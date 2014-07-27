/**
*@author Georgi Tsatsev 
*Matriculation Number:1045049.
*/
public class HelperFunctions {

	
    public static byte[] integerToBytes(int n) {
        byte[] byteStream = new byte[2];

        byteStream[1] = (byte) (n);
        n >>>= 8;
        byteStream[0] = (byte) (n);

        return byteStream;
    }
	
	public static byte[] getHeader(int packet_num,boolean eof){
		byte[] header= new byte[3];
		
		header [0] = integerToBytes(packet_num)[0];
		header [1] = integerToBytes(packet_num)[1];
		if (eof){
			header[2]=1;
		}else {
			header[2]=0;
		}
		
		return header;
	}
	
	public static int fromByteToInt(byte b1, byte b2){
		int num;
		num=(b1<< 8) + (b2 & 0xFF);
		return num;
	}
	
}
