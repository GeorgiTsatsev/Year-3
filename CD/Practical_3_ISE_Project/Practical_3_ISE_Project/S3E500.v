`timescale 1ns / 1ps

// module to drive a monitor from a 8-bit character(byte)-only interface. 

// uses submodules from bridge. 

// ports: 

// CLK_108MHz 
// CLK_DATA

// 8 it input data
// input data enable

// VGA outputs 


module VGA_S3E500(
input CLK_108MHz,
input CLK_DATA,

input reset,

input [7:0] max_rows,
input [7:0] max_columns,
input       row_column_update,

input [7:0] data,
input data_en,

output reg VGA_HSYNC,
output reg VGA_VSYNC,
output reg VGA_RED,
output reg VGA_GREEN,
output reg VGA_BLUE
);

///////////////////////////////////////////////////////////////////
// Declarations for the row, column asunc bridging. 
///////////////////////////////////////////////////////////////////

wire [15:0] async_data;
wire        async_tx;
wire        async_rx;

wire [15:0] combined_pxclk;
wire        combined_valid;

reg  [7:0]  rows_pxclk;
reg  [7:0]  columns_pxclk;

///////////////////////////////////////////////////////////////////////////////
// Declarations for the character buffer RAM 
////////////////////////////////////////////////////////////////////////////////

wire [7:0]      rama_data_in;
wire [7:0]      rama_data_out;
wire [31:0]     rama_addr;
wire            rama_ena; 
wire            rama_wena;  

reg  [7:0]      ramb_data_in;
wire [7:0]      ramb_data_out;
reg             ramb_ena;
reg             ramb_wena;
wire [31:0]     ramb_addr;

reg  [7:0]      ramb_data_in_dly;
reg             ramb_ena_dly;
reg             ramb_wena_dly;


wire [15:0]     fetch_addr;
wire [15:0]     fetch_rdata;
wire [15:0]     fetch_wdata;
wire            fetch_ena;
wire            fetch_wena;


///////////////////////////////////////////////////////////////////////////////
// instantiating the graphics pipeline. 
//////////////////////////////////////////////////////////////////////////////

wire [3:0] hsync;
wire [3:0] vsync;
wire [3:0] de;

wire [10:0] hctr0;
wire [10:0] vctr0;

wire [2:0] hctr1;
wire [2:0] vctr1;

wire [2:0] hctr2;
wire [2:0] vctr2;

wire [15:0] address1;

wire [7:0] character2;
wire [7:0] color2;

wire [7:0] color3;
wire 			pixel3;


// dotclock stage
dotclock u_dotclock(
.reset(reset),
.CLK_108MHz(CLK_108MHz),
.hsync(hsync[0]),
.vsync(vsync[0]),
.hctr(hctr0),
.vctr(vctr0),
.de(de[0])
);

// multiplier stage
dotaddr u_dotaddr(
.CLK_108MHz(CLK_108MHz),
.reset(reset),
.hctr_in(hctr0),
.vctr_in(vctr0),
.hsync_in(hsync[0]),
.vsync_in(vsync[0]),
.de_in(de[0]),
.hctr_out(hctr1),
.vctr_out(vctr1),
.hsync_out(hsync[1]),
.vsync_out(vsync[1]),
.de_out(de[1]),
.address_out(address1),
.max_rows(rows_pxclk),
.max_columns(columns_pxclk)
);

// fetch stage
dotfetch u_fetch(
.CLK_108MHz(CLK_108MHz),
.reset(reset),
.hsync_in(hsync[1]),
.vsync_in(vsync[1]),
.de_in(de[1]),
.hctr_in(hctr1),
.vctr_in(vctr1),
.address_in(address1),
.hsync_out(hsync[2]),
.vsync_out(vsync[2]),
.de_out(de[2]),
.hctr_out(hctr2),
.vctr_out(vctr2),
.character_out(character2),
.color_out(color2),
.addr(fetch_addr),
.ena(fetch_ena),
.wena(fetch_wena),
.wdata(fetch_wdata),
.rdata(fetch_rdata)
);

assign	rama_addr = fetch_addr;
assign  rama_ena = fetch_ena;
assign 	rama_wena = fetch_wena;
assign  rama_data_in = fetch_wdata[7:0];
assign  fetch_rdata = {8'h0F, rama_data_out};  // 8 bit wide implies no color, or rather, white on black. 

charmap u_charmap(
.CLK_108MHz(CLK_108MHz),
.reset(reset),
.hctr_in(hctr2),
.vctr_in(vctr2),
.character_in(character2),
.color_in(color2),
.hsync_in(hsync[2]),
.vsync_in(vsync[2]),
.de_in(de[2]),
.pixel_out(pixel3),
.color_out(color3),
.hsync_out(hsync[3]),
.vsync_out(vsync[3]),
.de_out(de[3])
);

// last stage - mapping color and pixel to the R, G and B outputs

always @(posedge CLK_108MHz)
begin
	if(reset)
	begin
		VGA_HSYNC <= 0;
		VGA_VSYNC <= 0;
		VGA_RED <= 0;
		VGA_GREEN <= 0;
		VGA_BLUE <= 0;
	end
	else
	begin
		VGA_HSYNC <= hsync[3];
		VGA_VSYNC <= vsync[3];
		VGA_RED <= pixel3;
		VGA_BLUE <= pixel3;
		VGA_GREEN <= pixel3;
	end	
end

/////////////////////////////////////////////////////////////////////////
// The RAM we are keeping the data in
////////////////////////////////////////////////////////////////////////

prom_ram_empty ram0 (
.clka(CLK_108MHz),
.clkb(CLK_DATA),
// read port. 
.ena(rama_ena), 
.wea(rama_wen), 
.addra(rama_addr), // muliplexing read and writes to the same port, valid is the read valid 
.ina(rama_data_in), 
.outa(rama_data_out), 

// read & write port. 
.enb(ramb_ena_dly),
.web(ramb_wena_dly), 
.addrb(ramb_addr),
.inb(ramb_data_in_dly), 
.outb(ramb_data_out)

);

///////////////////////////////////////////////////////////////////////
// logic to transfer data from the data in to the RAM. 
// Keeps the current line / row in registers, which are manipulated by some character, notable CR and BS
///////////////////////////////////////////////////////////////////////

reg [7:0] row;
reg [7:0] column;


always @(posedge CLK_DATA or posedge reset)
begin
	if(reset)
	begin
		row <= 0;
		column <= 0;
	end
	else
	begin
		
		if(data_en)
		begin
			case(data)
			8'h0D: // carriage return
			begin
				row <= row >  (max_rows -1) ? 0 : row + 1;
				column <= 8'h00;
			end
			8'h0A: // line feed
			begin
				row <= row >  (max_rows -1) ? 0 : row + 1;
				column <= 8'h00;
			end
			8'h08: // backspace
			begin
				row <= row;
				column <= (column == 8'h00) ? 8'h00 : column - 1;
			end
			default: // anything else
			begin
				row <= (column > (max_columns -1) ) ? (row > (max_rows -1) ? 0 : row + 1) : row;
				column <= (column > (max_columns-1) ) ? 8'h00 : column + 1;
			end
			endcase
		end
		else
		begin
			row <= row;
			column <= column;
		end

	end		
end

// register the data one more time - needed because of the single-cycle delay in simplemult
// note that if more pipeline stages are intoduced in simplemult, this will need to have more stages as well. 

always @ (posedge CLK_DATA or posedge reset)
#108
begin
	if(reset)
	begin
		ramb_ena <= 1'b0;
		ramb_wena <= 1'b0;
		ramb_data_in <= 8'h00;

		ramb_ena_dly <= 0;
		ramb_wena_dly <= 0;
		ramb_data_in_dly <= 0;

	end
	else
	begin
		case(data)
		8'h0D:
		begin
			ramb_ena <= 1'b0;
			ramb_wena <= 1'b0;
		end
		8'h0A:
		begin
			ramb_ena <= 1'b0;
			ramb_wena <= 1'b0;
		end
		8'h08:
		begin
			ramb_ena <= 1'b0;
			ramb_wena <= 1'b0;	
		end
		default:
		begin
			ramb_ena <= data_en;
			ramb_wena <= data_en;
		end
		endcase
		ramb_data_in <= data;


		ramb_ena_dly <= ramb_ena;
		ramb_wena_dly <= ramb_wena;
		ramb_data_in_dly <= ramb_data_in;

	end

end


//////////////////////////////////////////////////////////////////////////////////////////
// Second instance of the multiplier. 
//////////////////////////////////////////////////////////////////////////////////////////

simplemult u_daddr(
.clock(CLK_DATA),
.reset(reset),
.opa({1'b0, row}),
.opb(max_columns),
.opc(column),
.result(ramb_addr)
);

////////////////////////////////////////////////////////////////////////////////
// clock transfer of row and columns. 
// needed because dotaddr assume those signals are synched to the dot clock, but they are generated in the data clock domain
////////////////////////////////////////////////////////////////////////////////
 

tx #( .WIDTH(16) ) u_tx (
    .clk(CLK_DATA),    // domain clock

    .rx_a(async_rx),   // toggling handshake acknowledgement
    .data(async_data),   // data to be synchronised by the RX-half
    .tx(async_tx),     // toggling handshake request

    .in({max_rows, max_columns}),     // synchroniser input, registered locally
    .valid(row_column_update),  // input is valid
    .send()    // is ready to send data - consider renaming it
);

rx #(.WIDTH(16)) u_rx (
    .clk(CLK_108MHz),    // domain clock

    .data_a(async_data), // asynchronous data from the TX-half
    .tx_a(async_tx),   // toggling handshake request
    .rx(async_rx),     // toggling handshake acknowledgement

    .out(combined_pxclk),    // synchroniser's data output
    .valid(combined_valid)   // synchroniser has valid output
);


always @(posedge CLK_108MHz or posedge reset)
begin
	if(reset)
	begin
		rows_pxclk <= 8'h80;
		columns_pxclk <= 8'hA0; 
	end
	else
	begin
		if(combined_valid)
		begin
			rows_pxclk <= combined_pxclk[15:8];
			columns_pxclk <= combined_pxclk[7:0];
		end
		else
		begin
			rows_pxclk <= rows_pxclk;
			columns_pxclk <= columns_pxclk;
		end
	end		
end

endmodule

