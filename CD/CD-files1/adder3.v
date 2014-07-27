`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    12:35:02 07/28/2010 
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
module adder3(
   
	input [2:0] in1,
	input [2:0] in2,
	output [3:0] ok
   
    );

// use these wires as your inputs

//wire [2:0] in1;
//wire [2:0] in2;
wire [1:0] cr;
wire [3:0] result;
// button memory module, driving the inputs from dtypes.


// add your own code here

adder add1 (
		.a( in1 [0]), 
		.b( in2 [0]), 
		.c_in(0), 
		.o( result [0]), 
		.c_out( cr [0])
	);
adder add2 (
		.a( in1 [1]), 
		.b( in2 [1]), 
		.c_in(cr [0]), 
		.o( result [1]), 
		.c_out( cr [1])
	);
adder add3 (
		.a( in1 [2]), 
		.b( in2 [2]), 
		.c_in(cr [1]), 
		.o( result [2]), 
		.c_out( result [3])
	);


// debug logic: drives the input values to the on-board LEDs. 
// you can replace this if you need to. 
//assign LED = { 1'b0, in1, 1'b0, in2};
assign  ok =   {result [3], result [2], result [1], result [0] };

// LCD driver instantiation. 
// not currently used; use this only if you attach the LCD board. 



endmodule
