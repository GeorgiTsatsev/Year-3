`timescale 1ns / 1ps

//////////////////////////////////////////////////////////////////////////////
//  Synchroniser circuit - RX half                                          //
//    This module implements the RX half of a data synchroniser.            //
//    It works by accepting data from the TX half in a double handshake     //
//    manner, using a pair of toggling state on each side.                  //
//////////////////////////////////////////////////////////////////////////////

module rx(
    clk,    // domain clock

    data_a, // asynchronous data from the TX-half
    tx_a,   // toggling handshake request
    rx,     // toggling handshake acknowledgement

    out,    // synchroniser's data output
    valid   // synchroniser has valid output
  );

  parameter WIDTH = 8;

  input                 clk;

  // Interface between the synchroniser's TX and RX halves
  //
  input   [WIDTH-1:0]   data_a;
  input                 tx_a;
  output                reg rx;

  // Interface to the data destination
  //
  output  reg [WIDTH-1:0]   out;
  output  reg              valid;


	wire tx1; // wires to resynch the tx vbalid signal to local clock
	wire tx2; 

	// resynch flipflops. 

	FD u_tx1 (.D(tx_a), .Q(tx1), .C(clk));
	FD u_tx2 (.D(tx1), .Q(tx2), .C(clk));

	initial begin
	out <= 0;
	valid <= 0;
	rx <= 0;
	end

	always @(posedge clk)
	begin
		if(rx != tx2) // tx have sent data and changed the tx line, so sample it and ack to sender. 
		begin
			out <= data_a; // now safe. 
			rx <= tx2;
			valid <= 1'b1; // assert valid for 1 cycle. 
		end 
		else
		begin
			out <= out;
			rx <= rx;
			valid <= 1'b0;
		end
	end	
	
endmodule
