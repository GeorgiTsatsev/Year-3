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
module top(
    input clk,
    input reset,
    input [3:0] switches,
    output [7:0] LED,
    output [7:0] LCD
    );

// use these wires as your inputs
wire [3:0] result;
wire [2:0] in1;
wire [2:0] in2;
wire dump;

// button memory module, driving the inputs from dtypes.

BTN_memory u_BTN_memory(
.clk(clk),
.reset(reset),
.buttons(switches),
.in1(in1),
.in2(in2)
);

// add your own code here
DtypeS1 fsm1 (
.clock(clk),
.reset(reset),
.Q(dump)
);
DtypeS2 fsm2 (
.clock(clk),
.D(dump),
.reset(reset),
.Q(result)
);

// debug logic: drives the input values to the on-board LEDs. 
// you can replace this if you need to. 
assign LED = { result [0],result [1],result [2],result [3]};



// LCD driver instantiation. 
// not currently used; use this only if you attach the LCD board. 

LCD_driver u_LCD(
.value(result),
.LCD(LCD)
);


endmodule
