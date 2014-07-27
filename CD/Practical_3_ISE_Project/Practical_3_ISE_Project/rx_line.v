`timescale 1ns / 1ps



module rx_line(

input CLK_50MHz,
input ARESETn,

input UART_RX,

// fifo interface

output reg writeen,
output reg [7:0] data


);

// line-speed logic, receiving

reg [3:0] bitcounter;
reg [9:0] cyclecounter;
reg resetcycles;
reg active;

// retime flopflops

wire uart_rx_retimed;
wire uart_rx_int;

FD U_retime0 (.D(UART_RX), .Q(uart_rx_int), .C(CLK_50MHz));
FD U_retime1 (.D(uart_rx_int), .Q(uart_rx_retimed), .C(CLK_50MHz));


always @(*)
begin

	resetcycles = 0;

	case(bitcounter)
	4'b0000: resetcycles = (cyclecounter == 217) ? 1 : 0;
//	4'b1001: resetcycles = (cyclecounter == ) ? 1 : 0;
	default: resetcycles = (cyclecounter == 434) ? 1 : 0;
	endcase

end

always @(posedge CLK_50MHz or negedge ARESETn)
begin
	if(!ARESETn)
	begin
		bitcounter <= 0;
		cyclecounter <= 0;
		active <= 0;
		data <= 0;
	end
	else
	begin

		casez({active, uart_rx_retimed})
		2'b01: active <= 0;
		2'b00: active <= 1;
		2'b11: active <= ((bitcounter == 4'b1001) & resetcycles ) ? 0 : 1;
		2'b10: active <= ((bitcounter == 4'b1001) & resetcycles ) ? 0 : 1;
		default: active <= 0;
		endcase

		if(active)
		begin
			if(resetcycles)
				cyclecounter <= 0;	
			else
				cyclecounter <= cyclecounter + 1;
		end
		else
		begin
			cyclecounter <= 0;
		end				

		if(active)
		begin
			if(resetcycles)
				bitcounter <= bitcounter + 1;
			else
				bitcounter <= bitcounter;
		end	
		else
		begin
			bitcounter <= 0;
		end

		if(active && resetcycles)
		begin
			case(bitcounter)
			4'b0001: data[0] <= uart_rx_retimed;
			4'b0010: data[1] <= uart_rx_retimed;
			4'b0011: data[2] <= uart_rx_retimed;
			4'b0100: data[3] <= uart_rx_retimed;
			4'b0101: data[4] <= uart_rx_retimed;
			4'b0110: data[5] <= uart_rx_retimed;
			4'b0111: data[6] <= uart_rx_retimed;
			4'b1000: data[7] <= uart_rx_retimed;
			default: data <= data;
			endcase
		end
		else
		begin
			data <= data;
		end

		if(active && resetcycles && (bitcounter == 4'b1001))
			writeen <= 1;
		else
			writeen <= 0;

	end
end

endmodule
