`timescale 1ns / 1ps

// dotclock - takes a 27 MHz input clock an generates the followinf signals, all intended for use with a 1280x1024@60Hz monitor:

// reset - resets all counters to 0 if high, asynchronous to all clocks. 

// CLK_108MHz - actual pizel clock, and the clock that all other output signals are synchronous to. 

// hsync - horizontal sync signal

// vsync - vertical sync signal

// hctr - position in the current line, 11 bits long

// vctr - number of the current line, 11 bits long

// de - data enable; high if this clock is on the screen (not on a porch or during a sync). 

module dotclock(

input reset,
input CLK_108MHz,
output reg hsync,
output reg vsync,
output reg [10:0] hctr,
output reg [10:0] vctr,
output de
);

reg [10:0] hctr_int;
reg [10:0] vctr_int;

// helpers for de

reg de_h; // de-horizontal
reg de_v; // de - vertical. 
reg vcounter_tick; 

// vctr - simple count-to-1688 circuit 

always @(posedge CLK_108MHz or posedge reset)
begin
	if(reset)
	begin
		hctr_int <= 0;
	end
	else
	begin
		
		case(hctr_int)
		1687: hctr_int <= 0;
		default: hctr_int <= hctr_int + 1;
		endcase

		

	end
end

always @(hctr)
begin
	vcounter_tick = 0;
	case(hctr)
		1686: vcounter_tick = 1;
		default: vcounter_tick = 0;
	endcase
end
// hctr - simple count-to-1066 circuit with enable. 

always @(posedge CLK_108MHz or posedge reset)
begin
	if(reset)
	begin
		vctr_int <= 0;
	end
	else
	begin

		if(vcounter_tick)
		begin
			case(vctr_int)
			1065: vctr_int <= 0;
			default: vctr_int <= vctr + 1;
			endcase
		end		
		else
		begin
			vctr_int <= vctr_int;
		end

	end
end

// generate the sync and data enable signals. 

always @(posedge CLK_108MHz or posedge reset)
begin
	if(reset)
	begin
		hsync <= 1'b0;
		vsync <= 1'b0;
		de_h <= 1'b0;
		de_v <= 1'b0;
	end
	else
	begin

		case(hctr_int)
		1328: hsync <= 1'b1;
		1440: hsync <= 1'b0;
		default: hsync <= hsync;
		endcase

		case(vctr_int)
		1025: vsync <= 1'b1;
		1028: vsync <= 1'b0;
		default: vsync <= vsync;
		endcase

// data enables. 
 
		case(hctr_int)
		0: de_h <= 1'b1;
		1280: de_h <= 1'b0;
		default: de_h <= de_h;
		endcase

		case(vctr_int)
		0:    de_v <= 1'b1;
		1024: de_v <= 1'b0;
		default: de_v <= de_v;
		endcase

	end
end

// make DE with an and gate. 

assign de = de_v & de_h;

always@(posedge CLK_108MHz or posedge reset)
begin
	if(reset)
	begin
		hctr <= 0;
		vctr <= 0;
	end
	else
	begin
		hctr <= hctr_int;
		vctr <= vctr_int;
	end
end

endmodule
