`timescale 1ps / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   14:50:06 07/29/2010
// Design Name:   top
// Module Name:   /afs/inf.ed.ac.uk/user/s02/s0232285/write/computerdesign/Practicals/Practical 3/Practical_3_completed/top_test.v
// Project Name:  Practical3
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: top
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module top_test;

	// Inputs
	reg CLK_50MHz;
	reg reset;
	reg UART_RX;

	// Outputs
	wire VGA_HSYNC;
	wire VGA_VSYNC;
	wire VGA_RED;
	wire VGA_GREEN;
	wire VGA_BLUE;

	// Instantiate the Unit Under Test (UUT)
	top uut (
		.CLK_50MHz(CLK_50MHz), 
		.reset(reset), 
		.UART_RX(UART_RX), 
		.VGA_HSYNC(VGA_HSYNC), 
		.VGA_VSYNC(VGA_VSYNC), 
		.VGA_RED(VGA_RED), 
		.VGA_GREEN(VGA_GREEN), 
		.VGA_BLUE(VGA_BLUE)
	);

	initial begin
		// Initialize Inputs
		CLK_50MHz = 0;
		reset = 0;
		UART_RX = 0;

		#50000;
			
		reset = 1;

		// Wait 100 ns for global reset to finish
		#50000;
        
		 reset = 0; 
		  
		// Add stimulus here

	end

	// 50MHz clock input. 
      
	always
	begin
	#10000 CLK_50MHz = ~CLK_50MHz;
	end
		
endmodule

