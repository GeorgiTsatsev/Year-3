`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    14:17:06 11/13/2012 
// Design Name: 
// Module Name:    ripple 
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
module ripple(
    output [7:0] Sum,
    output Cout,
    input [7:0] A,
	 input [7:0] B,
    input Cin
    );
  wire c1,c2,c3,c4,c5,c6,c7;
 //reg carry;
    adder add1(Sum[0],c1,A[0],B[0],Cin),
			 add2(Sum[1],c2,A[1],B[1],c1),
			 add3(Sum[2],c3,A[2],B[2],c2),
			 add4(Sum[3],c4,A[3],B[3],c3),
			 add5(Sum[4],c5,A[4],B[4],c4),
			 add6(Sum[5],c6,A[5],B[5],c5),
			 add7(Sum[6],c7,A[6],B[6],c6),
			 add8(Sum[7],Cout,A[7],B[7],c7);

endmodule