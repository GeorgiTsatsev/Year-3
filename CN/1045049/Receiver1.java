/**
*@author Georgi Tsatsev 
*Matriculation Number:1045049.
*/

import java.io.*;
import java.net.*;

class Receiver1 {


	public static void main(String args[]) throws Exception  {
		
		// Check for incorrect input from the command line.
		if(args.length != 2) {
			System.out.println("The arguments provided did not meet the expected input.");
			System.out.println("Please retry with the following options:");
			System.out.println("java Receiver1 <Port> <Filename>");
			System.exit(0);
		}else {
			
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			DatagramPacket receivePacket;
			byte[] receiveData = new byte[1027];
		    byte[] true_data = new byte[1024];
		    byte[] header_data = new byte[3];
			boolean eof=false;
			int port;
			
			// Getting the file and the port number from the input arguments.	
			port = Integer.parseInt(args[0]);
			FileOutputStream new_file = new FileOutputStream(args[1]);
		 	
			DatagramSocket socket = new DatagramSocket(port);
		 	System.out.println("Waiting for data...");
		    
		 	// We receive packages until we get one containing eof byte set to 1.
		    while(!eof){
		    	
		      	receivePacket = new DatagramPacket(receiveData, receiveData.length);
		        socket.receive(receivePacket);
				
		        System.arraycopy(receiveData, 0, header_data, 0, header_data.length);
				
				// If we have received the eof package set to 1 we change the size 
		        //of the true_data byte array respective to the bytes that complete the file.
				if (header_data[2]==1){
		 			eof=true;
		 			true_data= new byte[receivePacket.getLength()-header_data.length];
		 		}
				
				System.arraycopy(receiveData,  header_data.length, true_data, 0, true_data.length);
		 	 	output.write(true_data);
		
		    }
		    
		    	new_file.write(output.toByteArray());
		    	new_file.close();
		    	socket.close();
		    	System.out.println("File received and saved to " + args[1] + ".");
		}
	}
}
