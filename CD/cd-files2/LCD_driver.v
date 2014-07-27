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
module LCD_driver(
    input [3:0] value,
    output reg [7:0] LCD
    );

// module to convert a 4-bit value to an 8-bit LCD output vector. 
// implemented as a single combinatorial process. Note that this is not clocked. 

always @(value)
begin

	LCD = 8'b00000000;

	case(value)  
	4'b0000: LCD = 8'b00111111;
	4'b0001: LCD = 8'b00000110;
	4'b0010: LCD = 8'b01011011; 
	4'b0011: LCD = 8'b01001111;
	4'b0100: LCD = 8'b01100110;
	4'b0101: LCD = 8'b01101101;
	4'b0110: LCD = 8'b01111101;
	4'b0111: LCD = 8'b00100111;
	4'b1000: LCD = 8'b01111111;
	4'b1001: LCD = 8'b01101111;
	4'b1010: LCD = 8'b10111111;
	4'b1011: LCD = 8'b10000110;
	4'b1100: LCD = 8'b11011011;
	4'b1101: LCD = 8'b11001111;
	4'b1110: LCD = 8'b11100110;
	4'b1111: LCD = 8'b11101101;	
	default: LCD = 8'b00000000;
	endcase

end

endmodule
