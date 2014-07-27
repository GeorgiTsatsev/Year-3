import java.util.ArrayList;
import java.util.HashMap;

//import org.antlr.runtime.tree.Tree;


public class Procedure {
	
	
	private Variables vars = new Variables();
	private ArrayList<String> arguments = new ArrayList<String>();
	private String type;
	private String name; 
	
	// Constructor
	public Procedure (){
	
	}
	
	// Method for the Procedure object.
	public void setArguments (String arg_name,String arg_type){
		arguments.add(arg_type);
	}
	public void setInteger(String a,int b){
		vars.setInteger(a, b);
	}
	public void setCharacter(String a,char b){
		vars.setCharacter(a, b);
	}
	public void setType(String a){
		type=a;
	}
	public void setName (String a){
		name = a;
	}
	public ArrayList<String> getArguments(){
		return arguments;
	}
	public String getName(){
		return name;
	}
	public Variables getVariables(){
		return vars;
	}
	public HashMap <String,Character> getCharacters(){
		return vars.getCharacter();
	}
	public HashMap <String,Integer> getIntegers(){
		return vars.getInteger();
	}
	public String getType(){
		return type;
	}
	
	public boolean isChar(String var_type){
		return vars.getCharacter().containsKey(var_type);
	}
	public boolean isInt(String var_type){
		return vars.getInteger().containsKey(var_type);
	}
}
