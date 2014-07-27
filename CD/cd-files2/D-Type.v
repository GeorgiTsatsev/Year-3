`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    16:03:01 10/16/2012 
// Design Name: 
// Module Name:    D-Type 
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
module DtypeS1(
input clock,
input reset,
output reg Q
);
reg [23:0] count;



always @(posedge clock or posedge reset)
begin
	if (reset) 
	begin
		count <= 'd0;
		Q = 1'b0;
	end
	else 
	begin
    if (count == 12499999)
	 begin
		Q = 1'b1;
      count <= 'd0;	 
		end 
	 else 
	 begin
      Q = 1'b0;
      count <= count + 1;
    end
	end
end
endmodule