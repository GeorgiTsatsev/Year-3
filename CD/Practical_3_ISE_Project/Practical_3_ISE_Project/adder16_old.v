`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    15:42:44 10/23/2012 
// Design Name: 
// Module Name:    adder16 
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
module adder16(
    input clock,
    input [15:0] in12,
    input [7:0] in22,
    output reg [16:0] result22  
    );
//reg state=1'b0;
wire [7:0] cr;
reg  crr=0;
wire [7:0] in1 = [7:0] in12;
wire [7:0] in2= [7:0] in22;
reg [8:0] result;

adder add1 (
		.a( in1 [0]), 
		.b( in2 [0]), 
		.c_in(crr), 
		.o( result [0]), 
		.c_out( cr [1])
	);
adder add2 (
		.a( in1 [1]), 
		.b( in2 [1]), 
		.c_in(cr [1]), 
		.o( result [1]), 
		.c_out( cr [2])
	);
adder add3 (
		.a( in1 [2]), 
		.b( in2 [2]), 
		.c_in(cr [2]), 
		.o( result [2]), 
		.c_out( cr[3])
	);
adder add4 (
		.a( in1 [3]), 
		.b( in2 [3]), 
		.c_in(cr [3]), 
		.o( result [3]), 
		.c_out( cr [4])
	);
adder add5 (
		.a( in1 [4]), 
		.b( in2 [4]), 
		.c_in(cr [4]), 
		.o( result [4]), 
		.c_out( cr [5])
	);
adder add6 (
		.a( in1 [5]), 
		.b( in2 [5]), 
		.c_in(cr [5]), 
		.o( result [5]), 
		.c_out( cr [6])
	);
adder add7 (
		.a( in1 [6]), 
		.b( in2 [6]), 
		.c_in(cr [6]), 
		.o( result [6]), 
		.c_out( cr [7])
	);
adder add8 (
		.a( in1 [7]), 
		.b( in2 [7]), 
		.c_in(cr [7]), 
		.o( result [7]), 
		.c_out( crr)
	);
always @(posedge clock)
begin
	
		assign  result22 [7:0] = result;
			
		assign  in1 =  in12 [15:8];
		assign [0] in2 =  crr;
		
		assign [7:1] in2 = 7'b0000000;
		//assign  cr[7:0] = 8'b00000000;
		assign  result22[16] = crr;
		assign  result22[15:8] = result;
		
	
end

endmodule