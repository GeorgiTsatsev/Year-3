`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    14:00:20 07/28/2010 
// Design Name: 
// Module Name:    LCD_driver 
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
module BTN_memory(
    input [3:0] buttons,
    input clk,
		input reset,
		output reg [2:0] in1,
		output reg [2:0] in2
    );

// Module to convert 4 binary switches to three 3-digit numbers by using switch[3] as a selector. 

always @(posedge clk or posedge reset)
begin
	if(reset)
	begin
		in1 <= 3'b000;
	end
	else
	begin
		if(buttons[3] == 1'b0)
		begin
			in1 <= buttons[2:0];
		end
		else
		begin
			in1 <= in1;
		end
	end		
end

always @(posedge clk or posedge reset)
begin
	if(reset)
	begin
		in2 <= 3'b000;
	end
	else
	begin
		if(buttons[3] == 1'b1)
		begin
			in2 <= buttons[2:0];
		end
		else
		begin
			in2 <= in2;
		end
	end		
end

endmodule

