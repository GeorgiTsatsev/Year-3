/**
*@author Georgi Tsatsev 
*Matriculation Number:1045049.
*/
import java.io.*;
import java.net.*;

class Sender2 {

	public static void main(String args[]) throws Exception {

		
		if(args.length != 4) {
			System.out.println("The arguments provided did not meet the expected input.");
			System.out.println("Please retry with the following options:");
			System.out.println("java Sender2 localhost <Port> <Filename> [RetryTimeout]");
			System.exit(0);
		}else {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket receiveAcknowledgement;
			byte[] packet = new byte[1024];
			byte[] packet_header = new byte[3];
			byte[] final_packet = new byte[1027];
			byte[] acknowledged = new byte[3];
			long start_time=0;
			long end_time=0;
			int port;
			int file_size;
			int packets_to_send;
			int timeout;
			int number_of_sends = 0;
			boolean eof = false;
					
			InetAddress address = InetAddress.getByName(args[0]);
			port = Integer.parseInt(args[1]);
			// Suppress the warning for the input stream.
			@SuppressWarnings("resource")
			FileInputStream file_to_send = new FileInputStream(args[2]);
			timeout=Integer.parseInt(args[3]);
			
			file_size = file_to_send.available();
			packets_to_send = (int) Math.ceil(file_size / (double) packet.length);
	
			System.out.println("Sending " + args[2] + ".");
			
			// Sending every packet to the receiving party.
			for (int packet_number = 0; packet_number <= packets_to_send && !eof; packet_number++) {
	
				// If we have reached the end of file packet set the "eof" variable
				// to true and recalculate the sizes of the packet to send.
				if (packet_number == packets_to_send - 1) {
					eof = true;
	
					// Take out the bytes that are extra from the last package to
					// send.
					packet = new byte[1024 - (packets_to_send * 1024 - file_size)];
					final_packet = new byte[packet.length + packet_header.length];
				}
	
				// Read the specified bytes into the packet array.
				file_to_send.read(packet);
	
				packet_header = HelperFunctions.getHeader(packet_number, eof);
				
				// Populating the final_packet with the header and true packet.
				System.arraycopy(packet_header, 0, final_packet, 0,	packet_header.length);
				System.arraycopy(packet, 0, final_packet, packet_header.length,	packet.length);
				
				// This loop simulates the send-and-wait algorithm. The sender
				//keeps sending a packet until he receives a positive acknowledgment
				//message for that packet from the Receiver end.
				do {
					
					try {
						DatagramPacket packet_to_send = new DatagramPacket(
								final_packet, final_packet.length, address, port);
						receiveAcknowledgement = new DatagramPacket(acknowledged,
								acknowledged.length);
						
						socket.send(packet_to_send);
						
						// Iterate the number_of_sends variable when we send packages.
						number_of_sends++;
						
						// Timeout the socket with the desired time and receive 
						//the acknowledgment packet afterwards. 
						socket.setSoTimeout(timeout);
						socket.receive(receiveAcknowledgement);
					} catch (SocketTimeoutException e) {
						
					}
	
				} while ((acknowledged[1] != final_packet[0]) || (acknowledged[2] != final_packet[1])||acknowledged[0]!=1);
				if (packet_number==0){
					start_time=System.currentTimeMillis();
				}else if(packet_number==packets_to_send-1){
					end_time=System.currentTimeMillis();
				}
			}
			
			
			System.out.println("File"+ args[2] +" has been sent!");
			
			// We get the number of retransmissions by subtracting the packets
			//to send from the number_of_sends. 
			System.out.println("Number of retransmissions: " + (number_of_sends-packets_to_send));
			System.out.println(  "Throughput: "+(float)( (file_size/1024.0)/((end_time-start_time)/1000.0) )  ); 
				
			socket.close();

		}
	}
}
