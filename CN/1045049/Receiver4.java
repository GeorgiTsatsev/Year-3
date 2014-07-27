/**
*@author Georgi Tsatsev 
*Matriculation Number:1045049.
*/

import java.io.*;
import java.net.*;
import java.util.HashMap;

class Receiver4 {


	public static void main(String args[]) throws Exception  {
		
		if(args.length != 3) {
			System.out.println("The arguments provided did not meet the expected input.");
			System.out.println("Please retry with the following options:");
			System.out.println("java Receiver4 <Port> <Filename> [WindowSize]");
			System.exit(0);
		}else {
			HashMap<Integer, byte[]> receiveBuffer = new HashMap<Integer,byte[]>();
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			DatagramPacket receivePacket;
		 	DatagramPacket acknowledgment = null;
			byte[] receiveData = new byte[1027];
		    int endnum=0;
		    byte[] header_data = new byte[3];
		    byte[] acknowledged_packet_number = new byte[2];
			boolean eof=false;
			int port;
			short window_size;
			int expected_packet_number=0;
			int received_packet_number=0;
			
			port = Integer.parseInt(args[0]);
			FileOutputStream new_file = new FileOutputStream(args[1]);
			window_size=Short.parseShort(args[2]);
			DatagramSocket socket = new DatagramSocket(port);

		 	System.out.println("Receiving data...");
		 	// receive packages until you get one containing eof byte set to 1.
		    while(!eof&&(endnum<=receiveBuffer.size())){
		    	
		    	// Receive the packet from the server.
		    	receivePacket = new DatagramPacket(receiveData, receiveData.length);
		    	socket.receive(receivePacket);
		    	
		    	
		    	// We populate the header_data array with its three bytes from the received data.
		    	System.arraycopy(receiveData, 0, header_data, 0, header_data.length);
		    	
		    	// We get the received packet number into integer format.
		    	received_packet_number=HelperFunctions.fromByteToInt(header_data[0],header_data[1]);
		    	
		    	// Loop through the packet window to populate the received buffer and send 
		    	//the appropriate acknowledgments.
		    	for (int i=expected_packet_number;i<(expected_packet_number+window_size);i++){
		    		acknowledged_packet_number[0] = HelperFunctions.integerToBytes(received_packet_number)[0];
			    	acknowledged_packet_number[1] = HelperFunctions.integerToBytes(received_packet_number)[1];
			    	acknowledgment = new DatagramPacket(acknowledged_packet_number, acknowledged_packet_number.length,receivePacket.getAddress(),receivePacket.getPort());
			    	byte[] true_data = new byte[1024];
		    		// We get the true data from the received data of size 1027. Then we write it to the output.
		    		System.arraycopy(receiveData,  header_data.length, true_data, 0, true_data.length);
		    		
		    		// Itterate the expected packet if we already have it.
		    		while (receiveBuffer.containsKey(expected_packet_number)&header_data[2]!=1){
		    			expected_packet_number++;				
		    		}
			
		    		if (received_packet_number==expected_packet_number){
		    			
			    		if (header_data[2]==1){
			    			endnum=received_packet_number;    			
			    			eof=true;
			    			true_data= new byte[receivePacket.getLength()-header_data.length];
			    		}
			    			    		
			    		// We get the true data from the received data of size 1027. Then we write it to the output.
			    		System.arraycopy(receiveData,  header_data.length, true_data, 0, true_data.length);
			    		receiveBuffer.put(received_packet_number,true_data);
			    		socket.send(acknowledgment);		    		
		    		} else if (received_packet_number==(i+1)){
		    			
		    			receiveBuffer.put(received_packet_number,true_data);		    		
			    		socket.send(acknowledgment);
				 
			    	} else if  (received_packet_number<expected_packet_number){
			    		socket.send(acknowledgment);			
			    	}
			    
		    	
		    	}
		    		 
		    	// Making sure that the last acknowledgment is being resent several times
		    	//so that the sending party gets if the packet gets lost the first time.
		    	if (eof||endnum>=receiveBuffer.size()){
		    		acknowledged_packet_number[0] = HelperFunctions.integerToBytes(endnum)[0];
			    	acknowledged_packet_number[1] = HelperFunctions.integerToBytes(endnum)[1];
			    	acknowledgment = new DatagramPacket(acknowledged_packet_number, acknowledged_packet_number.length,receivePacket.getAddress(),receivePacket.getPort());
			    
		    		for (int k=0;k<30;k++){
		    			socket.send(acknowledgment);
		    		}
		    	}
		    	
		
		    }
		   
		    for (int i=0;i<receiveBuffer.size();i++){
		    	output.write(receiveBuffer.get(i));
		    }
		    new_file.write(output.toByteArray());
		    new_file.close();
		    socket.close();
		    System.out.println("File received and saved to " + args[1]+ ".");
		}
	}
}
