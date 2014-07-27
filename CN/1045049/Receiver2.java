/**
*@author Georgi Tsatsev 
*Matriculation Number:1045049.
*/

import java.io.*;
import java.net.*;

class Receiver2 {


	public static void main(String args[]) throws Exception  {
		
		if(args.length != 2) {
			System.out.println("The arguments provided did not meet the expected input.");
			System.out.println("Please retry with the following options:");
			System.out.println("java Receiver2 <Port> <Filename>");
			System.exit(0);
		}else {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
		 	DatagramPacket receivePacket;
		 	DatagramPacket acknowledgment;
			byte[] receivedData = new byte[1027];
		    byte[] true_data = new byte[1024];
		    byte[] header_data = new byte[3];
		    byte[] acknowledgment_info = new byte[3];
			boolean eof=false;
			int expected_packet_number=0;
			int received_packet_number=0;
			int port;			
			
			port = Integer.parseInt(args[0]);			
		 	FileOutputStream new_file = new FileOutputStream(args[1]);
		 	DatagramSocket socket = new DatagramSocket(port);
		 	
		 	System.out.println("Waiting for data...");
		 	// receive packages until you get one containing eof byte set to 1.
		    while(!eof){
		    	
		    	// Set the acknowledgment to negative.
		    	acknowledgment_info[0]=0;
		    	// Receive the packet from the server.
		    	receivePacket = new DatagramPacket(receivedData, receivedData.length);
		    	socket.receive(receivePacket);
		    	
		    	
		    	// We populate the header_data array with its three bytes from the received data.
		    	System.arraycopy(receivedData, 0, header_data, 0, header_data.length);
		    
		    	received_packet_number=HelperFunctions.fromByteToInt(header_data[0],header_data[1]);
		    	acknowledgment_info[1] = header_data[0];
		    	acknowledgment_info[2] = header_data[1];
		    			    	    	
		    	if (received_packet_number==expected_packet_number){
		    		
		    		acknowledgment_info[0]=1;
		    		if (header_data[2]==1){
		    			eof=true;
		    			true_data= new byte[receivePacket.getLength()-header_data.length];
		    		}
		    		
		    		// We get the true data from the received data of size 1027. Then we write it to the output.
		    		System.arraycopy(receivedData,  header_data.length, true_data, 0, true_data.length);
		    		output.write(true_data);
		    		
		    		expected_packet_number++;
		    		// We send acknowledgment that the packet has been received.
		    		
		        
		    	// Taking into account that the packet we sent has been lost.
		    	}else if (expected_packet_number-received_packet_number==1){
		    		acknowledgment_info[0]=1;
		    	}
		    	acknowledgment = new DatagramPacket(acknowledgment_info, acknowledgment_info.length,receivePacket.getAddress(),receivePacket.getPort());
		    	socket.send(acknowledgment);
		    	// Making sure that the last acknowledgment is being resent several times
		    	//so that the sending party gets if the packet gets lost the first time.
		    	if (eof){
		    		for (int k=0;k<5;k++){
		        		socket.send(acknowledgment);
		    		}
		    	}
		    	
		
		    }
		    
		    // Writing the result to the file.
		    new_file.write(output.toByteArray());
		    new_file.close();
		    socket.close();
			System.out.println("File received and saved to " + args[1]+ ".");
		}
	}
}
