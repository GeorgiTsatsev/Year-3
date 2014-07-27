`timescale 1ns / 1ps

// dotaddr - generates the address that we need to look up the character at. 
// uses a multiply-add submodule to do the actual multiplication and addition neccesary. 
// note that the result is registred in this submodule. 

// parameters: 

// CHARSPERLINE - how many characters there is in a line. one of the inputs to the multiplier. 

// ports: 

// CLK_108MHz - global clock

// reset - asyncronous reset

// hctr_in - 11 bit hcounter from the dotclock

// vctr_in - 11 bit vcounter from teh dotclock

// hsync_in - hsync that needs to be registred

// vsync_in - vsync that needs to be registred

// de_in - data enable that neds to be registred

// hctr_out - the botton 3 bits of hctr_in, now registered

// vctr_out - the bottom 3 bits of vctr_in, registred

// hsync_out - registred hsync_in 

// vsync_out - registred vsync_in

// de_out - registred data enable signal

// address_out - the generated address, registred int he multiplier submodule. 

module dotaddr(
input CLK_108MHz,
input reset,
input [10:0] hctr_in,
input [10:0] vctr_in,
input hsync_in,
input vsync_in,
input de_in,
input [7:0] max_rows,
input [7:0] max_columns,
output reg [2:0] hctr_out,
output reg [2:0] vctr_out,
output reg hsync_out,
output reg vsync_out,
output reg de_out,
output [15:0] address_out

);

// register hsync, vsync, and de

always @( posedge CLK_108MHz or posedge reset)
begin
  if(reset)
  begin
    hsync_out <= 1'b0;
    vsync_out <= 1'b0;
    de_out    <= 1'b0;
  end
  else
  begin
    hsync_out <= hsync_in;
    vsync_out <= vsync_in;
    de_out    <= de_in;
  end
end

// register hctr and vctr

always @ (posedge CLK_108MHz or posedge reset)
begin
	if(reset)
	begin
		hctr_out <= 3'b000;
		vctr_out <= 3'b000;
	end
	else
	begin
		hctr_out <= hctr_in[2:0];
		vctr_out <= vctr_in[2:0];
	end
end

simplemult u_mult(
.clock(CLK_108MHz),
.reset(reset),
.opa( vctr_in[10:3]),
.opb( max_columns ),
.opc( hctr_in[10:3]),
.result(address_out)
);

endmodule


