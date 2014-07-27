/**
*@author Georgi Tsatsev 
*Matriculation Number:1045049.
*/

import java.io.*;
import java.net.*;

class Receiver3 {


	public static void main(String args[]) throws Exception  {
		
		if(args.length != 2) {
			System.out.println("The arguments provided did not meet the expected input.");
			System.out.println("Please retry with the following options:");
			System.out.println("java Receiver3 <Port> <Filename>");
			System.exit(0);
		}else {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			DatagramPacket receivePacket;
		 	DatagramPacket acknowledgment;
			byte[] receiveData = new byte[1027];
		    byte[] true_data = new byte[1024];
		    byte[] header_data = new byte[3];
		    byte[] acknowledged_packet_number = new byte[2];
			boolean eof=false;
			int port;
			int expected_packet_number=-1;
			int received_packet_number=0;
			
			port = Integer.parseInt(args[0]);
			FileOutputStream new_file = new FileOutputStream(args[1]);
		 	DatagramSocket socket = new DatagramSocket(port);

		 	System.out.println("Receiving data...");
		 	// receive packages until you get one containing eof byte set to 1.
		    while(!eof){
		    	
		    	// Receive the packet from the server.
		    	receivePacket = new DatagramPacket(receiveData, receiveData.length);
		    	socket.receive(receivePacket);
		    			    	
		    	// We populate the header_data array with its three bytes from the received data.
		    	System.arraycopy(receiveData, 0, header_data, 0, header_data.length);
		    	
		    	// We get the received packet number into integer format.
		    	received_packet_number=HelperFunctions.fromByteToInt(header_data[0],header_data[1]);
		    	
		    	// If we have received what we wanted then expect the next packet 
		    	//in the next loop iteration.
		    	if (received_packet_number==(expected_packet_number+1)){
		    		
		    		if (header_data[2]==1){
		    			eof=true;
		    			true_data= new byte[receivePacket.getLength()-header_data.length];
		    		}
		    			
		    		expected_packet_number++;
		        			    		
		    		// We get the true data from the received data of size 1027. Then we write it to the output.
		    		System.arraycopy(receiveData,  header_data.length, true_data, 0, true_data.length);
		    		output.write(true_data);
		    		 		
		    	}
		    	
		    	// We send acknowledgment for the last packet we received and that what we expected.
		    	acknowledged_packet_number[0] = HelperFunctions.integerToBytes(expected_packet_number)[0];
		    	acknowledged_packet_number[1] = HelperFunctions.integerToBytes(expected_packet_number)[1];
		    	acknowledgment = new DatagramPacket(acknowledged_packet_number, acknowledged_packet_number.length,receivePacket.getAddress(),receivePacket.getPort());
			//System.out.println(expected_packet_number);
		    	socket.send(acknowledgment);
		 
		    	// Making sure that the last acknowledgment is being resent several times
		    	//so that the sending party gets if the packet gets lost the first time.
		    	if (eof){
		    		for (int k=0;k<15;k++){
		        		socket.send(acknowledgment);
		    		}
		    	}
		    	
		
		    }
		  
		    new_file.write(output.toByteArray());
		    new_file.close();
		    socket.close();
		    System.out.println("File received and saved to " + args[1]+ ".");
		}
	}
}
