/**
*@author Georgi Tsatsev 
*Matriculation Number:1045049.
*/
import java.io.*;
import java.net.*;
import java.util.HashMap;

class Sender4 {
	
	public static void main(String args[]) throws Exception {
		if(args.length != 5) {
			System.out.println("The arguments provided did not meet the expected input.");
			System.out.println("Please retry with the following options:");
			System.out.println("java Sender4 localhost <Port> <Filename> [RetryTimeout] [WindowSize]");
			System.exit(0);
		}else {
			
			HashMap<Integer, Long > timeOutBuffer = new HashMap<Integer,Long>();
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
			long timeout;
			boolean eof = false;
					
			InetAddress address = InetAddress.getByName(args[0]);
			port = Integer.parseInt(args[1]);
			// Suppress the warning for the input stream.
			@SuppressWarnings("resource")
			FileInputStream file_to_send = new FileInputStream(args[2]);
			timeout=Long.parseLong(args[3]);
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
				timeOutBuffer.put(packet_number, (long) 0);
			}
			
			Integer from=0;
			int n=0;
			int empty=0;
			System.out.println("Sending "+ args[2] +".");
			while (sendBuffer.size()!=0){	
				receiveAcknowledgement = new DatagramPacket(acknowledged,acknowledged.length);
				
				try {
					while((sendBuffer.get(empty)==null)&&(empty<packets_to_send)){
						from++;
						empty++;
					}				
					for (n=from;n<=(from+window_size)&&n<=packets_to_send;n++){
						
						if (sendBuffer.containsKey(n)&&timeOutBuffer.get(n)==((long)0)){					
							
							DatagramPacket packet_to_send = new DatagramPacket(sendBuffer.get(n), sendBuffer.get(n).length, address, port);
							socket.send(packet_to_send);
							timeOutBuffer.put(n,System.currentTimeMillis());
						
						// If the packet has not been sent for longer that the provided timeout then we can resend it.
						} else if (sendBuffer.containsKey(n)&&(System.currentTimeMillis()-timeOutBuffer.get(n))>=timeout){
							DatagramPacket packet_to_send = new DatagramPacket(sendBuffer.get(n), sendBuffer.get(n).length, address, port);
							socket.send(packet_to_send);
							
							timeOutBuffer.put(n,System.currentTimeMillis());
						}	
										
					}
					
					for (n=from;n<=(from+window_size)&&n<=packets_to_send;n++){	
						socket.setSoTimeout(1);
						
						socket.receive(receiveAcknowledgement);
						packet_acknowledged=HelperFunctions.fromByteToInt(acknowledged[0],acknowledged[1]);
						
						
						if (sendBuffer.containsKey(packet_acknowledged)){
							if (packet_acknowledged==0)
								start_time=System.currentTimeMillis();
							if (packet_acknowledged==(packets_to_send-1))
								end_time=System.currentTimeMillis();				
						
							sendBuffer.remove(packet_acknowledged);
							
						}
					}
				}catch (SocketTimeoutException e) {
				
				}
			if (sendBuffer.size()==1 &&	packet_acknowledged==packets_to_send-1)
					break;
			}
						
			System.out.println("File sent!");
			System.out.println("Throughput: "+(float)( (file_size/1024.0)/((end_time-start_time)/1000.0) )); 
			
			socket.close();
		}
	}
}
