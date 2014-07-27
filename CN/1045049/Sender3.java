/**
*@author Georgi Tsatsev 
*Matriculation Number:1045049.
*/
import java.io.*;
import java.net.*;
import java.util.HashMap;

class Sender3 {
	
	public static void main(String args[]) throws Exception {
		if(args.length != 5) {
			System.out.println("The arguments provided did not meet the expected input.");
			System.out.println("Please retry with the following options:");
			System.out.println("java Sender3 localhost <Port> <Filename> [RetryTimeout] [WindowSize]");
			System.exit(0);
		}else {
			
			HashMap<Integer, byte[]> sendBuffer = new HashMap<Integer,byte[]>();
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket receiveAcknowledgement;
			byte[] packet = new byte[1024];
			byte[] packet_header = new byte[3];
			byte[] acknowledged = new byte[2];
			long start_time=0;
			long end_time=0;
			short window_size;
			int packet_acknowledged = -1;
			int port;
			int file_size;
			int packets_to_send;
			int timeout;
			boolean eof = false;
					
			InetAddress address = InetAddress.getByName(args[0]);
			port = Integer.parseInt(args[1]);
			// Suppress the warning for the input stream.
			@SuppressWarnings("resource")
			FileInputStream file_to_send = new FileInputStream(args[2]);
			timeout=Integer.parseInt(args[3]);
			window_size=Short.parseShort(args[4]);
			
			file_size = file_to_send.available();
			packets_to_send = (int) Math.ceil(file_size / (double) packet.length);
				
			// For loop to fill out the send buffer with the file bytes.
			for (int packet_number = 0; packet_number < packets_to_send ; packet_number++) {
				
				byte[] final_packet = new byte[1027];
				
				// If we have reached the end of file packet set the "eof" variable
				// to true and recalculate the sizes of the packet to send.
				if (packet_number == packets_to_send - 1) {
					eof = true;
	
					// Take out the extra bytes from the last package
					packet = new byte[1024 - (packets_to_send * 1024 - file_size)];
					final_packet = new byte[packet.length + packet_header.length];
				}
	
				// Read the specified bytes into the packet array.
				file_to_send.read(packet);
	
				packet_header = HelperFunctions.getHeader(packet_number, eof);
				
				// Populating the final_packet with the header and true packet.
				System.arraycopy(packet_header, 0, final_packet, 0,	packet_header.length);
				System.arraycopy(packet, 0, final_packet, packet_header.length,	packet.length);
				
				// Populating the sendBuffer HashMap.
				sendBuffer.put(packet_number,final_packet);
			}
			long start_receive_time=0;
			long end_receive_time=0;
			Integer from=0;
			int n = 0;
			receiveAcknowledgement = new DatagramPacket(acknowledged,acknowledged.length);
			System.out.println("Sending "+ args[2] +".");
			while (packet_acknowledged<(packets_to_send-1)){
				try {
								
					for (n=from;n<=(from+window_size)&&n<packets_to_send;n++){
						DatagramPacket packet_to_send = new DatagramPacket(
						sendBuffer.get(n), sendBuffer.get(n).length, address, port);
							
						socket.send(packet_to_send);
					}	
					
					socket.setSoTimeout(timeout);

					start_receive_time=System.currentTimeMillis();
					
					while ((end_receive_time-start_receive_time)<timeout&&packet_acknowledged<=(packets_to_send-1)){						
						// Checks for throughput start and end time.
						if (packet_acknowledged==0)
						start_time=System.currentTimeMillis();
						if (packet_acknowledged==(packets_to_send-1))
						end_time=System.currentTimeMillis();
						
						// Receiving packets until the timeout runs out.
						socket.receive(receiveAcknowledgement);
						end_receive_time=System.currentTimeMillis();
						packet_acknowledged = (acknowledged[0]<<8) + (acknowledged[1]&0xFF);
						from = packet_acknowledged+1;
					}
					
						
					}catch (SocketTimeoutException e) {}
					
			}
						
			System.out.println("File sent!");
			System.out.println("Throughput: "+(float)( (file_size/1024.0)/((end_time-start_time)/1000.0) )); 
			
			socket.close();
		}
	}
}
