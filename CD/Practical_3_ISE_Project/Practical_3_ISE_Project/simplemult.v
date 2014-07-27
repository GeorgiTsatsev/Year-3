`timescale 1ps / 1ps

// simple multiplication module, suitable for FPGA instantiation. 
// note that the size of the result is large enough to accomodate the largest possible result. 

// returns operand a (opa) multiplied with operand b (opb) with operand c (opc) added on. 
// The output is registred, i.e. a flipflop. The rest of the design assumes this module contain only a single flipflop stage.
// if you need more flipflop stages here, you need to also make modifications elsewhere.  

/// you should 
//  1) replace the adder in this module with equivalent logic without the + operator 
//  2) replace the multiplier with equivalent logic without the * operator

module simplemult (
input clock,
input reset,
input [7:0] opa,
input [7:0] opb,
input [7:0] opc,
output reg [16:0] result
);
wire [16:0] result1;
//wire [8:0] result2;
//assign result1 = opa*opb+opc;
adder16 blio (
	.clock(clock), 
	.in1(opa*opb), 
	.in2(opc), 
	.result(result1)
	);
//assign state=state1;
always @(posedge clock or posedge reset)
begin
	if(reset)
	begin
		result <= 0;
	end
	else
	begin
		//state1 <= 1'b1;
		result[16:1] <= result1[15:0];
		result[0] <= result1[16];
		// assign result = result1;
	end
end
//result  <= result1;
endmodule
