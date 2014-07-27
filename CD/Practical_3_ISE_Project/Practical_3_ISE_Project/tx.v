`timescale 1ns / 1ps

//////////////////////////////////////////////////////////////////////////////
//  Synchroniser circuit - TX half                                          //
//    This module implements the TX half of a data synchroniser.            //
//    It works by putting input data through to the RX half in a double     //
//    handshake manner, using a pair of toggling state on each side.        //
//////////////////////////////////////////////////////////////////////////////

module tx(
    clk,    // domain clock

    rx_a,   // toggling handshake acknowledgement
    data,   // data to be synchronised by the RX-half
    tx,     // toggling handshake request

    in,     // synchroniser input, registered locally
    valid,  // input is valid
    send    // is ready to send data - consider renaming it
  );

  parameter WIDTH = 8;

	input clk;
	
	input rx_a;
	output reg  [WIDTH-1:0] data;
	output reg tx;
	
	input [WIDTH-1:0] in;
	input valid;
	output send;

	wire rx1; // resynchronizing wires
	wire rx2; // rx2 is in this clock domain. 

	initial begin
	data <= 0;
	tx <= 0;
	end

	// FF's for resynch of rx_a
	// replace this if we ever go off FPGA with this code. 

	FD u_rx1 (.D(rx_a), .Q(rx1), .C(clk));
	FD u_rx2 (.D(rx1), .Q(rx2), .C(clk));

	assign send = (rx2 == tx); // is true if we can send data in any clock cycle, false if we're waiting for the other side. 

	always @(posedge clk)
	begin
		if(valid && send) // we can send whenever we want, and we have valid data. 
		begin
			data <= in;
			tx <= ~tx;
		end
		else // either we dont have data, or we do have data but we're waiting on the other side to ack the last data. 
		begin
			data <= data;
			tx <= tx;	
		end
	end

endmodule
