`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    15:19:25 10/09/2012 
// Design Name: 
// Module Name:    adder 
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
module adder(
    input a,
    input b,
    input c_in,
    output o,
    output c_out
    );

	
	assign o = a ^ b ^ c_in;
	assign c_out = (a & b) | (a & c_in) | (b & c_in);
	
endmodule