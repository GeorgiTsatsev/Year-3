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

wire [2:0] in1;
reg [2:0] r;
reg [2:0] s;
reg [2:0] t;
wire [2:0] in2;
wire [2:0] cr;
wire [5:0] result;
wire x;
// button memory module, driving the inputs from dtypes.

BTN_memory u_BTN_memory(
.clk(clk),
.reset(reset),
.buttons(switches),
.in1(in1),
.in2(in2)
);

// add your own code here

assign x = 1'b0;
always @*
if (in1 [0] == 1'b0) 
	begin 
     	r [0] = 1'b0;
		r [1] = 1'b0;
		r [2] = 1'b0;
   end
else 
	begin 
      r [0] = in2 [0];
		r [1] = in2 [1];
		r [2] = in2 [2];
   end
always @*
if (in1 [1] == 1'b0) 
	begin 
      s [0] = 1'b0;
		s [1] = 1'b0;
		s [2] = 1'b0;
   end
else 
	begin 
      s [0] = in2 [0];
		s [1] = in2 [1];
		s [2] = in2 [2];
   end
always @*
if (in1 [2] == 1'b0) 
	begin 
		t [0] = 1'b0;
		t [1] = 1'b0;
		t [2] = 1'b0;
   end
else 
	begin 
      t [0] = in2 [0];
		t [1] = in2 [1];
		t [2] = in2 [2];
   end

assign result[0] = r[0];

adder add1 (
		.a(r [1]), 
		.b(s [0]), 
		.c_in(x), 
		.o( result [1]), 
		.c_out( cr [0])
	);
wire y,u,z,p;
adder add_mid1 (
		.a(r [2]), 
		.b(s [1]), 
		.c_in(t[0]), 
		.o( y ), 
		.c_out( u )
	);
adder add_midcr (
		.a(cr [0]), 
		.b(y), 
		.c_in(x), 
		.o(  result [2] ), 
		.c_out( p )
	);	
adder add_mid2 (
		.a(u), 
		.b(p), 
		.c_in(x), 
		.o(  cr [1] ), 
		.c_out( z )
	);		
		
adder add3 (
		.a(s [2]), 
		.b(t [1]), 
		.c_in(cr[1]), 
		.o( result [3]), 
		.c_out( cr [2])
	);
		

adder add4 (
		.a(t [2]), 
		.b(cr [2]), 
		.c_in(z), 
		.o( result [4]), 
		.c_out( result [5])
	);
// debug logic: drives the input values to the on-board LEDs. 
// you can replace this if you need to. 
//assign LED = { 1'b0, in1, 1'b0, in2};
assign  LED =   {result [5], result [4], result [3], result [2], result [1], result [0]};

// LCD driver instantiation. 
// not currently used; use this only if you attach the LCD board. 

LCD_driver u_LCD(
.value(result),
.LCD(LCD)
);


endmodule
