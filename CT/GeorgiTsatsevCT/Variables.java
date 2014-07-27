import java.util.HashMap;


public class Variables {
	
	private HashMap <String,Integer> ints = new HashMap <String,Integer>();
	private HashMap <String,Character> chars = new HashMap <String,Character>();
	
	// Constructor
	public Variables (){
	
	}
	
	// Methods for variables object.
	public void setInteger(String a,int b){
		ints.put(a, b);
	}
	public void setCharacter(String a,char b){
		chars.put(a, b);
	}
	public HashMap <String,Integer> getInteger(){
		return ints;
	}
	public HashMap <String,Character> getCharacter(){
		return chars;
	}
	public boolean containsKey(String var){
		return ints.containsKey(var)||chars.containsKey(var);
	}	
	public void insertVariables(Variables variables){
		ints.putAll(variables.getInteger());
		chars.putAll(variables.getCharacter());
	}
	
}
