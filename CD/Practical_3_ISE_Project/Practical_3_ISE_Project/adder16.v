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
    input [15:0] in1,
    input [7:0] in2,
    output reg [16:0] result
	 );
wire cr;
reg [7:0] in1_reg;
reg [7:0] in2_reg;
wire [7:0] result_reg;
parameter zero=0, one=1,two=2, three=3;
reg [1:0] state=zero;
reg dummie =1'b0;

 ripple asd(
 .Sum(result_reg),
 .Cout(cr),
 .A(in1_reg),
 .B(in2_reg),
 .Cin(1'b0)
 );

always @(posedge clock)
begin
case (state)
  zero:
  begin :kafal
		 in1_reg <=  in1 [7:0];
		 in2_reg <=  in2[7:0];
		 result [7:0] <= result_reg;
		 dummie <= cr;
		 state <= one;
		 disable kafal;
  end
  one:
	begin :kerim
		  in1_reg <=  in1 [15:8];
		  in2_reg [0] <=  dummie;
		  in2_reg [7:1] <= 7'b0000000;
		  dummie <= cr;
		  result [15:8] <= result_reg;
		  state <= three;
		  disable kerim;
	end
	three:
		begin :kazak
			result [16] <= dummie;
			state <= zero;
			//disable kazak;
		end

endcase
end 
endmodule