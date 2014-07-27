/**
*@author Georgi Tsatsev 
*Matriculation Number:1045049.
*/
import java.io.*;
import java.net.*;

class Sender1 {
	

	
	public static void main(String args[]) throws Exception {
		
		// Check for incorrect input from the command line.
		if(args.length != 3) {
			System.out.println("The arguments provided did not meet the expected input.");
			System.out.println("Please retry with the following options:");
			System.out.println("java Sender1 localhost <Port> <Filename>");
			System.exit(0);
		}else {
			DatagramSocket socket = new DatagramSocket();
			byte[] packet = new byte[1024];
	 		byte[] packet_header = new byte[3];
	 		byte[] final_packet = new byte[1027];
	 		int port;
	 		int file_size;
		    int packets_to_send;
		    boolean eof=false;
			
			InetAddress address = InetAddress.getByName(args[0]);
			port = Integer.parseInt(args[1]);
			@SuppressWarnings("resource")
			FileInputStream file_to_send = new FileInputStream(args[2]); 
		    
			file_size=file_to_send.available();
	 		packets_to_send =(int) Math.ceil(file_size / (double) packet.length);
			
	 		System.out.println("Sending " + args[2] + ".");
	 		
	 		for (int packet_number=0; packet_number<=packets_to_send&&!eof;packet_number++ ){
	 			
	 			// 20ms delay
	 			Thread.sleep(20);
	 			
	 			// 	If we have reached the end of file packet set the "eof" variable to true
	 			// and recalculate the sizes of the packet to send.
	 			if (packet_number==packets_to_send-1){
	 				eof=true;
	 				
	 				// Take out the bytes that are extra from the last package to send.
	 				packet= new byte [1024-(packets_to_send*1024-file_size)];
	 				final_packet= new byte[packet.length+packet_header.length];
	 			}
	 			
	 			// Read the specified bytes into the packet array.
	 			file_to_send.read(packet);
	 			
	 			packet_header=HelperFunctions.getHeader(packet_number,eof);
	 			System.arraycopy(packet_header, 0, final_packet, 0, packet_header.length);
	 	 		System.arraycopy(packet, 0, final_packet, packet_header.length, packet.length);
	
	 	 		
	 			DatagramPacket packet_to_send = new DatagramPacket(final_packet, final_packet.length,address,port);
	 			socket.send(packet_to_send); 
	 			 			 			
			}	
			
			System.out.println("File "+ args[2] + " has been sent!");
			socket.close();
		}
	}
}
	
