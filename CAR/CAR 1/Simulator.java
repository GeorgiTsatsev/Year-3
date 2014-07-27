import java.io.*;
import java.util.*;






public class Simulator {
	
	
	/* The FromHexToBinary is a helper function created to 
	convert an input hexadecimal string to a binary string.
	*/
	public static String FromHexToBinary(String Hex){
	    
		int n = Integer.parseInt(Hex,16);
	    String binary = Integer.toBinaryString(n);
	    
	    return binary;
	}
	
	
	/* The fillBinary function is a helper function that given an
	arrayList of strings and a given size fills it with all the possible
	binary number combinations of that size. This is used to create the
	buffer for the predictor.	 
	 */
	public static List<String> fillBinary (List<String> x, int size){
		
		int binary=0;
		String temp="";
		
		/* The variable n represents the bits that are looked at for 
		buffers of different sizes. For 512 bit buffer 2^9=512 so n is 9.
		*/
		int n = (int)(Math.log(size)/Math.log(2));
		
		// The first entry in the buffer table is zeroes only.
		for (int i=0; i<n;i++){
		temp=temp+"0";
		}
		
		/* Iterates the loop so that it would fill the buffer table
		with every combination of binary numbers for the size given.
		*/
		while (x.size()<size){
			
			x.add(temp);
			binary=Integer.parseInt(temp, 2);
			binary++;
			temp=Integer.toBinaryString(binary);
			
			// Fills the remaining left bits to be '0'
			while (temp.length()<n){
			
				temp="0"+temp;
				
			}

		}

	return x;
	}
	
	/* This is the function that calculates the 2-bit predictor's failure. 
	It takes as input a BufferedReader (throws an exception if an empty one is given as input)
	and the size of the buffer table and simulates a four state FSM for each 
	possible values of the 2-bit predictor in the table.	 
	 */
	public static double TwoBitPrediction (BufferedReader br, int size) throws IOException{
		
		// addess and prediction are the arraylist variables used for the prediction table.
		List<String> address = new ArrayList<String>();
		List<Integer> prediction = new ArrayList<Integer>();
		
		int hit = 0, miss = 0, action=0, temp=0;
		String line;		
		String[] tokens;		
		
		address=fillBinary(address, size);
		
		// Adds the initial prediction values to be zeroes in the predictor table.
		for (int i=0;i<address.size();i++){
		prediction.add(0);
		}
		
		/* A while loop that iterates every line of branch instructions
		and simulates the 2-bit prediction algorithm.		
		 */
		while ((line = br.readLine())!= null){
			
			temp=0;
			tokens = line.split(" ");
			tokens[1]=FromHexToBinary(tokens[1]);
			
			
			/* Gets the substring of the instruction's address that represents
			the LSB that are the same length as the prediction table's entries.
			*/
			tokens[1]=tokens[1].substring((int)(tokens[1].length()-(Math.log(size))/Math.log(2)),tokens[1].length() );
			
			/* temp is the index of the prediction table's entry that has the
			same instruction address as the current branch instruction.
			*/
			temp = address.indexOf(tokens[1]);
			// action takes whether the current branch is taken or not.
			action = Integer.parseInt(tokens[2]);
				
			// This switch is for the FSM states.
			switch (prediction.get(temp)){
				case 0:
					if (action == 0){
						hit++;
					}else{
						prediction.set(temp, (prediction.get(temp))+1);
						miss++;
					}
                    break;
				case 1: 
					if (action == 0){
						prediction.set(temp, (prediction.get(temp)-1));
						hit++;
					} else {
						prediction.set(temp, (prediction.get(temp)+1));
						miss++;
					}
					break;
				case 2: 
					if (action == 0){
						prediction.set(temp, (prediction.get(temp)-1));
						miss++;
					} else {
						prediction.set(temp, (prediction.get(temp)+1));
						hit++;
					}
					break;
				case 3: 
					if (action == 0){
						prediction.set(temp, (prediction.get(temp)-1));
						miss++;
					} else hit++;
					break;
			}
					
		}
				
	return 100*(double)miss/(miss+hit);	
	}

	/* The Function for the AlwaysTaken predictor. Takes as input a BufferedReader
	And returns a double value for the miss rate of the prediction.
	 */
	public static double AlwaysTaken (BufferedReader br) throws IOException{
		
		int hit=0, miss=0;
		String line;
		String[] tokens;
		
		while ((line = br.readLine())!= null){
			
			tokens = line.split(" ");			
			if (Integer.parseInt(tokens[2])==1){
				hit++;
			} else miss++;
		}
		return 100*(double)miss/(hit+miss);
	}
	
	/* The Function for the AlwaysNotTaken predictor. Takes as input a BufferedReader
	And returns a double value for the miss rate of the prediction.
	 */
	public static double AlwaysNotTaken (BufferedReader br) throws IOException{
		
		int hit=0, miss=0;
		String line;
		String[] tokens;
		
		while ((line = br.readLine())!= null){
			
			tokens = line.split(" ");			
			if (Integer.parseInt(tokens[2])==1){
				miss++;
			} else hit++;
		}
		return 100*(double)miss/(hit+miss);
	}
	
	
	/* A helper function that makes the profile for the profile guided prediction.
	Takes as input a Bufferedreader and returns a Hashmap with the profile.
	 */
	public static HashMap<String, Integer> Profiler(BufferedReader br) throws IOException{
		HashMap<String, Integer> profile = new HashMap();

		
		int temp=0;
		String line;		
		String[] tokens;
		
		while ((line = br.readLine())!= null){
			
			tokens = line.split(" ");
			if (profile.containsKey(tokens[1])){
				temp=profile.get(tokens[1]);
				if (Integer.parseInt(tokens[2])==0){
					temp=profile.get(tokens[1])-1;
					
				}else{
					temp=profile.get(tokens[1])+1;
				}
				profile.put(tokens[1],temp);
			}else{
				if (Integer.parseInt(tokens[2])==0){
					profile.put(tokens[1],-1);
					
				}else{
					profile.put(tokens[1],1);
				}
			}
						
		}
		
		
		
		return profile;
	}
	
	/* The function that simulates the profile guided predictor according to
	a previous set profile.
	 */
	public static double ProfileGuided(HashMap<String, Integer> profile, BufferedReader br) throws IOException{
		int temp=0,hit=0,miss=0;
		String line;		
		String[] tokens;
		
		while ((line = br.readLine())!= null){
			
			tokens = line.split(" ");
			if (profile.containsKey(tokens[1])){
				temp=profile.get(tokens[1]);
				if (Integer.parseInt(tokens[2])==0){
					if (temp>0){
						miss++;
					}else{
						hit++;
					}
					
				}else{
					if (temp>0){
						hit++;
					}else{
						miss++;
					}
				}
				
			}
						
		}
		
		return 100*(double)miss/(hit+miss);
	}
	
	public static void main(String[] args) throws Exception {
		
		HashMap<String, Integer> profile = new HashMap();
		double result=0;
		int size=512;
		String input=null;
        String filename;
        String[] tokens;
		int decision=0;

	
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Please enter the filename you wish to simulate and the predictor you wish to simulate");
            System.out.println("Separated by a single empty space. Choose from One to seven for each predictor.");
            System.out.println("1 - AlwaysTaken");
            System.out.println("2 - AlwaysNotTaken");
            System.out.println("3 - ProfileGuided");
            System.out.println("4 - TwoBitPrediction with 512 entries table");
            System.out.println("5 - TwoBitPrediction with 1024 entries table");
            System.out.println("6 - TwoBitPrediction with 2048 entries table");
            System.out.println("7 - TwoBitPrediction with 4096 entries table");
            
            input = br.readLine();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		tokens=input.split(" ");
		filename=tokens[0];
		decision=Integer.parseInt(tokens[1]);

		
        FileInputStream file = new FileInputStream (filename);
        FileInputStream file2 = new FileInputStream (filename);
		BufferedReader br = new BufferedReader (new InputStreamReader(file));
		BufferedReader br2 = new BufferedReader (new InputStreamReader(file2));
	
		
		switch (decision-1){
		case 0:
			result=AlwaysTaken(br);
            break; 
		case 1:
			result=AlwaysNotTaken(br);
            break;
		case 2:
			profile=Profiler(br);
			result=ProfileGuided(profile,br2);
			
            break;
		case 3:
			result=TwoBitPrediction(br, size);
		   break;
		case 4:
			result=TwoBitPrediction(br, size*2);
		   break;
		case 5:
			result=TwoBitPrediction(br, size*4);
		   break;
		case 6:
			result=TwoBitPrediction(br, size*8);
		   break;
		}
		
		System.out.println("The misprediction rate is: "+result+"%");
		br.close();
		br2.close();

		
	}

}
