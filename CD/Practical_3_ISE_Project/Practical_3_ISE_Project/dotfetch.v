`timescale 1ns / 1ps

// fetch unit; fetches the character to print from memory. 

// CLK_108MHz - main clock

// reset - asynchronous reset signal

// hsync_in - input sync signal, needs to bew rgistred

// vsync_in - input signal, needs to be registred

// de_in - input enable signal, do not need to look up data idf this is not high. 

// hctr_in - input counter, tells us where we are in the character. 3 bits.  

// vctr_in - input vcounter, also tells us where we are in the character. 3 bits. 

// address_in - input signal, gives the address of the character in the memory. 16 bits long. 

// hsync_out - hsync registred output.

// vsync_out - vsync registred output. 

// de_out - de registred output. 

// hctr_out - hctr registred output. 3 bits.

// vctr out vctr registred output. 3 bits. 

// character_out - the character that is at address, 8 bits. 

// color_out - the color that this character has. see CGA for details. 8 bits. 

/////////////////////
// ram interface

// addr - address, 15 bit byte address,  

// ena - enable

// wena - write enable - always 0

// wdata - write data - always 0

// rdata - read data, 16 bit double byte (character - color)


module dotfetch(
input CLK_108MHz,
input reset,
input hsync_in,
input vsync_in,
input de_in,
input [2:0] hctr_in,
input [2:0] vctr_in,
input [15:0] address_in,
output reg hsync_out,
output reg vsync_out,
output reg de_out,
output reg [2:0] hctr_out,
output reg [2:0] vctr_out,
output [7:0] character_out,
output [7:0] color_out,
output [15:0] addr,
output ena,
output reg wena,
output reg [15:0] wdata,
input [15:0] rdata

);

// register the signals that needs registred for this stage in the pipeline. 

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


always @(posedge CLK_108MHz or posedge reset)
begin
	if(reset)
	begin
		hctr_out 	<= 3'b000;
		vctr_out 	<= 3'b000;
		wena 			<= 1'b0;
		wdata 		<= 16'h0000;
	end
	else
	begin
		hctr_out 	<= hctr_in;
		vctr_out 	<= vctr_in;
		wena 			<= 1'b0;
		wdata			<= 16'h0000;
	end
end

// and connect the rest of the ports

assign addr = address_in;
assign ena = de_in;
assign character_out = rdata[7:0];
assign color_out = rdata[15:8];


endmodule
