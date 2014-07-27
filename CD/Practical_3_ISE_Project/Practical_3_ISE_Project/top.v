`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    13:21:43 07/29/2010 
// Design Name: 
// Module Name:    top 
// Project Name: 
// Target Devices: 
// Tool versions: 
// Description: 
//
// Dependencies: 
//
// Revision: 
// Revision 0.01 - File Created
// Additional Comments: 
//
//////////////////////////////////////////////////////////////////////////////////
module top(
    input CLK_50MHz,
    input reset,
    
    input UART_RX,
	 
    output VGA_HSYNC,
    output VGA_VSYNC,
    output VGA_RED,
    output VGA_GREEN,
    output VGA_BLUE
    );

wire [7:0] uart_data;
wire       uart_data_en;

reg [7:0] rows;
reg [7:0] columns;
reg       row_column_update;

reg [7:0] fwd_uart_data;
reg       fwd_uart_ena; 

reg [1:0] escape;

// VGA pipeline

VGA_S3E500 u_vga(
.CLK_108MHz(CLK_108MHz),
.CLK_DATA(CLK_50MHz),

.reset(reset),

.max_rows(rows),
.max_columns(columns),
.row_column_update(row_column_update),

.data(fwd_uart_data),
.data_en(fwd_uart_ena),

.VGA_HSYNC(VGA_HSYNC),
.VGA_VSYNC(VGA_VSYNC),
.VGA_RED(VGA_RED),
.VGA_GREEN(VGA_GREEN),
.VGA_BLUE(VGA_BLUE)
);

// UART receiver

rx_line u_rx_line(

.CLK_50MHz(CLK_50MHz),
.ARESETn(~reset),

.UART_RX(UART_RX),

// fifo interface

.writeen(uart_data_en),
.data(uart_data)
);

clockgen u_clockgen (
.CLK_50MHz(CLK_50MHz),
.reset(reset),
.CLK_108MHz(CLK_108MHz)
);

////////////////////////////////////////////////////////////////
// escape interface - used to set number of rows and columns. may have hilarious consequences. 
////////////////////////////////////////////////////////////////

// row and column drivers. 

always @(posedge CLK_50MHz or posedge reset)
begin
	if(reset)
		rows <= 8'h80;
	else
		if(uart_data_en && (escape == 2'b01))
			rows <= uart_data;
		else
			rows <= rows;
end 

always @(posedge CLK_50MHz or posedge reset)
begin
	if(reset)
		columns <= 8'hA0;
	else
		if(uart_data_en && (escape == 2'b10))
			columns <= uart_data;
		else
			columns <= columns;
end

always @(posedge CLK_50MHz or posedge reset)
begin
	if(reset)
		row_column_update <= 1'b0;
	else
		if(uart_data_en &&  (escape == 2'b10))
			row_column_update <= 1'b1;
		else
			row_column_update <= 1'b0;
end

// escape state machine. steps on uart receive. 

always @(posedge CLK_50MHz or posedge reset)
begin
	if(reset)
	begin
		escape <= 2'b00; 
	end
	else
	begin
		if(uart_data_en)
		begin
			case(escape)
			2'b00: escape <= (uart_data == 8'h1B) ? 2'b01 : 2'b00; 
			2'b01: escape <= 2'b10;
			2'b10: escape <= 2'b00;
			default: escape <= 2'b00;
			endcase 
		end
		else
		begin
			escape <= escape;
		end
	end
end

// forward data registers. 

always @(posedge CLK_50MHz or posedge reset)
begin
	if(reset)
	begin
		fwd_uart_data <= 8'h00;
		fwd_uart_ena  <= 1'b0; 
	end
	else
	begin
		if( (uart_data_en) && (escape == 2'b00) && (uart_data != 8'h1B) )
		begin
				fwd_uart_data <= uart_data;
				fwd_uart_ena  <= 1'b1; 
		end
		else
		begin
				fwd_uart_data <= fwd_uart_data;
				fwd_uart_ena  <= 1'b0; 
		end
	end
end	

endmodule
