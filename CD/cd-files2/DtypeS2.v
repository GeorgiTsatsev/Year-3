`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    14:42:12 10/23/2012 
// Design Name: 
// Module Name:    DtypeS2 
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
module DtypeS2(
input clock,
input reset,
input D,
output reg [3:0] Q
);


reg [1:0] state;

parameter zero=0, one=1, two=2, three=3;

always @(state) 
     begin
          case (state)
               zero:
                    Q = 4'b0001;
               one:
                    Q = 4'b0010;
               two:
                    Q = 4'b0100;
               three:
                    Q = 4'b1000;
               default:
                    Q = 4'b0001;
          endcase
     end

always @(posedge clock or posedge reset)
     begin
          if (reset)
               state = zero;
          else
               case (state)
                    zero:
                         if (D)
                              state = one;
                         else
                              state = zero;
                    one:
                         if (D)
                              state = two;
                         else
                              state = one;
                    two:                 
								 if (D)
                              state = three;
                         else
                              state = two;
                    three:
                         if (D)
                              state = zero;
                         else
                              state = three;
               endcase
     end

endmodule
