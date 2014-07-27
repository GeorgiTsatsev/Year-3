`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    14:30:14 07/29/2010 
// Design Name: 
// Module Name:    clockgen 
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
module clockgen(
    input CLK_50MHz,
    input reset,
    output CLK_108MHz
    );

	wire CLKFB0;
	wire CLKFB1;
	wire CLK_180MHz;

   // DCM_SP: Digital Clock Manager Circuit
   //         Spartan-3E/3A
   // Xilinx HDL Language Template, version 10.1

   DCM_SP #(
      .CLKDV_DIVIDE(2.0), // Divide by: 1.5,2.0,2.5,3.0,3.5,4.0,4.5,5.0,5.5,6.0,6.5
                          //   7.0,7.5,8.0,9.0,10.0,11.0,12.0,13.0,14.0,15.0 or 16.0
      .CLKFX_DIVIDE(5),   // Can be any integer from 1 to 32
      .CLKFX_MULTIPLY(18), // Can be any integer from 2 to 32
      .CLKIN_DIVIDE_BY_2("FALSE"), // TRUE/FALSE to enable CLKIN divide by two feature
      .CLKIN_PERIOD(20.0),  // Specify period of input clock
      .CLKOUT_PHASE_SHIFT("NONE"), // Specify phase shift of NONE, FIXED or VARIABLE
      .CLK_FEEDBACK("1X"),  // Specify clock feedback of NONE, 1X or 2X
      .DESKEW_ADJUST("SYSTEM_SYNCHRONOUS"), // SOURCE_SYNCHRONOUS, SYSTEM_SYNCHRONOUS or
                                            //   an integer from 0 to 15
      .DFS_FREQUENCY_MODE("LOW"),  // HIGH or LOW frequency mode for frequency synthesis
      .DLL_FREQUENCY_MODE("LOW"),  // HIGH or LOW frequency mode for DLL
      .DUTY_CYCLE_CORRECTION("TRUE"), // Duty cycle correction, TRUE or FALSE
      .FACTORY_JF(16'hC080),   // FACTORY JF values
      .PHASE_SHIFT(0),     // Amount of fixed phase shift from -255 to 255
      .STARTUP_WAIT("FALSE")   // Delay configuration DONE until DCM LOCK, TRUE/FALSE
   ) DCM_SP_inst_0 (
      .CLK0(CLKFB0),     // 0 degree DCM CLK output
      .CLK180(), // 180 degree DCM CLK output
      .CLK270(), // 270 degree DCM CLK output
      .CLK2X(),   // 2X DCM CLK output
      .CLK2X180(), // 2X, 180 degree DCM CLK out
      .CLK90(),   // 90 degree DCM CLK output
      .CLKDV(),   // Divided DCM CLK out (CLKDV_DIVIDE)
      .CLKFX(CLK_180MHz),   // DCM CLK synthesis out (M/D)
      .CLKFX180(), // 180 degree CLK synthesis out
      .LOCKED(), // DCM LOCK status output
      .PSDONE(), // Dynamic phase adjust done output
      .STATUS(), // 8-bit DCM status bits output
      .CLKFB(CLKFB0),   // DCM clock feedback
      .CLKIN(CLK_50MHz),   // Clock input (from IBUFG, BUFG or DCM)
      .PSCLK(),   // Dynamic phase adjust clock input
      .PSEN(),     // Dynamic phase adjust enable input
      .PSINCDEC(), // Dynamic phase adjust increment/decrement
      .RST(reset)        // DCM asynchronous reset input
   );

   // End of DCM_SP_inst instantiation
   // DCM_SP: Digital Clock Manager Circuit
   //         Spartan-3E/3A
   // Xilinx HDL Language Template, version 10.1

   DCM_SP #(
      .CLKDV_DIVIDE(2.0), // Divide by: 1.5,2.0,2.5,3.0,3.5,4.0,4.5,5.0,5.5,6.0,6.5
                          //   7.0,7.5,8.0,9.0,10.0,11.0,12.0,13.0,14.0,15.0 or 16.0
      .CLKFX_DIVIDE(25),   // Can be any integer from 1 to 32
      .CLKFX_MULTIPLY(15), // Can be any integer from 2 to 32
      .CLKIN_DIVIDE_BY_2("FALSE"), // TRUE/FALSE to enable CLKIN divide by two feature
      .CLKIN_PERIOD(5.555),  // Specify period of input clock
      .CLKOUT_PHASE_SHIFT("NONE"), // Specify phase shift of NONE, FIXED or VARIABLE
      .CLK_FEEDBACK("1X"),  // Specify clock feedback of NONE, 1X or 2X
      .DESKEW_ADJUST("SYSTEM_SYNCHRONOUS"), // SOURCE_SYNCHRONOUS, SYSTEM_SYNCHRONOUS or
                                            //   an integer from 0 to 15
      .DFS_FREQUENCY_MODE("LOW"),  // HIGH or LOW frequency mode for frequency synthesis
      .DLL_FREQUENCY_MODE("LOW"),  // HIGH or LOW frequency mode for DLL
      .DUTY_CYCLE_CORRECTION("TRUE"), // Duty cycle correction, TRUE or FALSE
      .FACTORY_JF(16'hC080),   // FACTORY JF values
      .PHASE_SHIFT(0),     // Amount of fixed phase shift from -255 to 255
      .STARTUP_WAIT("FALSE")   // Delay configuration DONE until DCM LOCK, TRUE/FALSE
   ) DCM_SP_inst_1 (
      .CLK0(CLKFB1),     // 0 degree DCM CLK output
      .CLK180(), // 180 degree DCM CLK output
      .CLK270(), // 270 degree DCM CLK output
      .CLK2X(),   // 2X DCM CLK output
      .CLK2X180(), // 2X, 180 degree DCM CLK out
      .CLK90(),   // 90 degree DCM CLK output
      .CLKDV(),   // Divided DCM CLK out (CLKDV_DIVIDE)
      .CLKFX(CLK_108MHz),   // DCM CLK synthesis out (M/D)
      .CLKFX180(), // 180 degree CLK synthesis out
      .LOCKED(), // DCM LOCK status output
      .PSDONE(), // Dynamic phase adjust done output
      .STATUS(), // 8-bit DCM status bits output
      .CLKFB(CLKFB1),   // DCM clock feedback
      .CLKIN(CLK_180MHz),   // Clock input (from IBUFG, BUFG or DCM)
      .PSCLK(),   // Dynamic phase adjust clock input
      .PSEN(),     // Dynamic phase adjust enable input
      .PSINCDEC(), // Dynamic phase adjust increment/decrement
      .RST(reset)        // DCM asynchronous reset input
   );

   // End of DCM_SP_inst instantiation
endmodule
