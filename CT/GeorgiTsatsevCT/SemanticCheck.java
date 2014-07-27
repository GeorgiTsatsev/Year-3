import java.util.ArrayList;

import org.antlr.runtime.tree.Tree;


public class SemanticCheck {


	// Global variables the values of the symbol table.
	private static Variables global_vars = new Variables();
	private static ArrayList<Procedure> procedures = new ArrayList<Procedure>();	
	
	/**
	 * Checks if the procedure that is being called has been declared. 
	 * Throws an exception if it has not been stating that you cannot call 
	 * an undeclared procedure.
	 *
	 * @param  proc_name  The name of the procedure that is being called.
	 * @return      It is set to void since it only checks for previous declaration of the procedure.
	 */
	public static void isProcedureDeclared(String proc_name) throws Exception{
		boolean isDeclared=false;
		if (!proc_name.equals("IF")&&!proc_name.equals("while")){
			for (int k=0; k<procedures.size();k++){
				isDeclared=isDeclared||(procedures.get(k).getName().equals(proc_name));
				
			}		
			if (!isDeclared){
				throw new Exception("Cannot call an undeclared procedure : " + proc_name);
			}
		}
	}

	/**
	 * Checks if the variable has previously been declared. Throws an 
	 * exception if it has not been stating that it has not been declared.
	 *
	 * @param  proc_index  The index of the procedure we are checking for.
	 * @param  var_name  The name of the variable we come across.
	 * @return      It is set to void since it only checks for previous declaration of the variable.
	 */
	public static void isVariableDeclared(int proc_index,String var_name) throws Exception{
			
		if ((var_name.charAt(0)<57&&var_name.charAt(0)>47)||var_name.charAt(0)=='\''||var_name.charAt(0)=='\"'||var_name.charAt(0)=='-'){
	
		}else if (!(procedures.get(proc_index).getVariables().containsKey(var_name))){
			throw new Exception("Variable " + var_name + " has not been declared. Within " + procedures.get(proc_index).getName());
		}
		
	}

	/**
	 * A helper function that during its execution does Semantic analysis for
	 * the input procedure tree. Throws an Exception if there is a type mismatch
	 * for the procedure arguments, if the arguments are not the same number as
	 * required and if the arguments provided when calling the functions have not
	 * been declared previously.
	 * 
	 * @param  proc_num		The number of procedure we are currently in.
	 * @param  procedure	The procedure we are currently in.
	 *
	 * @return Returns the type of the procedure that is being called
	 *  within the procedure we are currently in.
	 */
	public static String getProcedureType(int proc_num, Tree procedure) throws Exception {
		
		// Variables used inside the loops.
		ArrayList<String> arguments = new  ArrayList<String>();
		Procedure proc = new Procedure();
		String type=null;
		String required=null;
		String argument=null;
		String procedure_name = procedure.toString();
		
		// Loop through the procedures arrayList to see which procedure is being called.
		for (int k=0; k<procedures.size();k++){
			
			// If we have reached the procedure that is being called do the semantic checks.
			if (procedures.get(k).getName().equals(procedure_name)){
				
				// We get the procedure, its type and its arguments.
				proc = procedures.get(k);
				type=proc.getType();
				arguments=proc.getArguments();
				
				// If the argument number provided for the procedure call are not 
				//the same number as the required throw an Exception.
				if (arguments.size()!=procedure.getChildCount())
					throw new Exception ("The procedure requires " + arguments.size() + " arguments. " + "Got " + procedure.getChildCount() + " instead");
				
				// Loop through each argument and compare its type to the required one.
				for (int i=0;i<arguments.size();i++){
					required = arguments.get(i);
					argument =procedure.getChild(i).toString();
							
					if (procedures.get(proc_num).isChar(argument)&&required.equals("int"))
						throw new Exception ("Type mismatch for procedure " + proc.getName() + ". Argument " + (i+1) + " requires integer got character instead.");
					if (procedures.get(proc_num).isInt(argument)&&required.equals("char"))
						throw new Exception ("Type mismatch for procedure " + proc.getName() + ". Argument " + (i+1) + " requires character got integer instead.");
					if (!procedures.get(proc_num).getVariables().containsKey(argument))
						throw new Exception ("Variable " + argument + " has not been declared." );
					}
					
			}
		}		
		
		return type;
	}
	
	/**
	 * When given an expression tree this function checks if all of the variables
	 * within this expression are integers.
	 * 
	 * <p> Within this function semantic checks for the validity of the procedures and variables
	 * that are inside are done with the help of the isProcedureDeclared, isVariableDeclared,
	 * and getProcedureType.
	 *
	 * @param  proc_num  The index of the procedure we are currently in.
	 * @param  expression_tree  The expression tree we are evaluating
	 * @return		A boolean result false if they are not all integers and true otherwise.
	 */
	public static boolean areInts(int proc_num,Tree expression_tree)throws Exception{
		
		boolean allInts=true;
		Tree child;
		String root = expression_tree.toString();
		String proc_type=null;
		
		// Validate simple operations.
		simpleEval(proc_num,expression_tree);	
		
		// Loop through each child of the expression tree to evaluate it on its own.
		for (int i=0;i<expression_tree.getChildCount();i++){
			
			child = expression_tree.getChild(i);
			root = child.toString();
			
			// If there are no subexpressions do the checking.
			// Else call the function recursively on the subexpression.
			if (expression_tree.getChild(i).getChildCount()==0){			
				
				// If the variable is in the current procedure symbol table and is set as 
				// integer or it is a number then the function would return true. if in 
				// one of the iterations of the above loop it is not the it would return false.
				if (procedures.get(proc_num).getVariables().getInteger().containsKey(root)||(root.matches("[0-9]*"))||(root.matches("-"))){
					allInts=allInts&&true;
				} else{
					
					allInts=false;
					
					// Check if the variable within the expression has previously been declared.
					isVariableDeclared(proc_num,root);
				}
				
			}else{
				
				// If the subexpression is a function do function checks and get its return type.
				if ((child.getChildCount()>0)&&(child.toString().matches("[a-zA-Z0-9_]+"))&&(!child.toString().equals("while"))&& 
					(!child.toString().equals("IF"))&& (!child.toString().equals("BLOCK"))&&(!child.toString().equals("else")) ){
					
					isProcedureDeclared(child.toString());
						
					// Checks if the procedure called is the same as the procedure we are currently in
					// If it is then throw an Exception. Not handling recursion.
					if (procedures.get(proc_num).getName().equals(root)){
						throw new Exception ("The compiler only handles non-recursive procedures.");
					}
						
					proc_type=getProcedureType(proc_num,expression_tree.getChild(i));
					
					// If the return type of the function is not int then allInts is false.
					if (!proc_type.equals("int"))
						allInts=false;
					
				} else{
					
					// Recursive call of the areInts function.
					allInts=areInts(proc_num,child);
				}
			}
		}
		return allInts;
	}
	
	/**
	 * When given an expression tree to evaluate this function checks if all of the variables
	 * within this expression tree are characters.
	 * 
	 * <p> Within this function semantic checks for the validity of the procedures and variables
	 * that are inside are done with the help of the isProcedureDeclared, isVariableDeclared,
	 * and getProcedureType.
	 *
	 * @param  proc_num  The index of the procedure we are currently in.
	 * @param  expression_tree  The expression tree we are evaluating
	 * @return		A boolean result false if they are not all characters and true otherwise.
	 */
	public static boolean areChars(int proc_num,Tree expression_tree)throws Exception{
		
		boolean allChars=true;
		Tree child;
		String root = expression_tree.toString();
		String proc_type=null;
		
		// Validate simple operations.
		simpleEval(proc_num,expression_tree);
		
		// Loop through each child of the expression tree to evaluate it on its own.
		for (int i=0;i<expression_tree.getChildCount();i++){
			
			child = expression_tree.getChild(i);
			root = child.toString();
			
			// If there are no subexpressions do the checking.
			// Else call the function recursively on the subexpression.
			if (expression_tree.getChild(i).getChildCount()==0){
				
				// If the variable is in the current procedure symbol table and is set as 
				// character or it is a character surrounded by '' then the function would 
				//return true. if in one of the iterations of the above loop it is not 
				//the it would return false.
				if (procedures.get(proc_num).getVariables().getCharacter().containsKey(root)||
						(root.charAt(0)=='\''&&root.charAt(2)=='\''&&root.length()==3)){
						allChars=allChars&&true;
				} else{
					allChars=false;
					// Check if the variable within the expression has previously been declared.
					isVariableDeclared(proc_num,root);
				}
				
			} else{
				
				// If the subexpression is a function do function checks and get its return type.
				if ((child.getChildCount()>0)&&(child.toString().matches("[a-zA-Z0-9_]+"))&&(!child.toString().equals("while"))&&
					(!child.toString().equals("IF"))&&(!child.toString().equals("BLOCK"))&&(!child.toString().equals("else")) ){
						
					isProcedureDeclared(child.toString());
					
					// Checks if the procedure called is the same as the procedure we are currently in
					// If it is then throw an Exception. Not handling recursion.
					if (procedures.get(proc_num).getName().equals(root)){
						throw new Exception ("The compiler only handles non-recursive procedures.");
					}
										
					proc_type=getProcedureType(proc_num,expression_tree.getChild(i));
					
					// If the return type of the function is not char then allChars is false.
					if (!proc_type.equals("char"))
						allChars=false;
				} else{
				
					// Recursive call of the areChars function.
					allChars=areChars(proc_num,child);
				}
			}
		}
		return allChars;
	}
	
	/**
	 * Evaluates the procedure tree for semantic errors with the help of other functions.
	 *
	 * @param  proc_num  The index of the procedure we are evaluating.
	 * @param  proc_tree  The procedure tree we are currently evaluating.
	 * @return	The return type is void and throws an Exception if the Evaluation fails
	 */
	public static void procedureEval(int proc_num, Tree proc_tree)throws Exception{

		String variable;
		Tree child;
		String root;
		
		// The current procedure's type and name.
		String proc_type = procedures.get(proc_num).getType();
		String proc_name = procedures.get(proc_num).getName();
		
		// Loop through the children of the procedure tree to check each
		// declaration and assignment separately.
		for (int i=0;i<proc_tree.getChildCount();i++){
			
			child = proc_tree.getChild(i);
			root = child.toString();
			
			// Validate the assignments of the variables.
			if (root.equals("=")){
				
				variable=child.getChild(0).toString();
								
				// Type mismatch checks.
				if (procedures.get(proc_num).getCharacters().containsKey(variable)&&!areChars(proc_num,child)){	
					throw new Exception("Type mismatch for the variable " + variable + ". Expected type: character" );
				}
				if (procedures.get(proc_num).getIntegers().containsKey(variable)&&!areInts(proc_num,child)){
						throw new Exception("Type mismatch for the variable " + variable + ". Expected type: integer" );
				}
		
			}
			
			// Validate procedure's return :
			if (root.equals("return")){
				variable=child.getChild(0).toString();
				if (proc_type.equals("int")){
					if(!areInts(proc_num, child))
						throw new Exception ("Type mismatch for the return of function " + proc_name + ". Expected return type: int");
				} else if (proc_type.equals("char")){
					if(!areChars(proc_num, child))
						throw new Exception ("Type mismatch for the return of function " + proc_name + ". Expected return type: char");
				} else{
					throw new Exception ("The function " + proc_name + " is of type void.");
				}
				
			}
			
			// Validate procedure's if and while 's:
			if (root.equals("while")||root.equals("IF")){
				conditionCheck(proc_num,child);
			}
			
			// Validate simple operators:
			if (root.equals("print")||root.equals("outputc")||root.equals("output")||root.equals("readc")||root.equals("read")){
				simpleEval(proc_num,child);
			}
			
		}	
	}
	
	/**
	 * Function that evaluates the print, output, outputc, read and readc operators.
	 * 
	 * @param  proc_num  The index of the procedure we are in.
	 * @param  expression_tree  The expression tree we are currently evaluating.
	 * @return	The return type is void and throws an Exception if the Evaluation fails
	 */
	public static void simpleEval (int proc_num,Tree expression_tree) throws Exception{
		
		String root = expression_tree.toString();
		String variable=expression_tree.getChild(0).toString();
		
		// Validate simple operations.
		if (root.equals("readc")){
			if (!procedures.get(proc_num).getCharacters().containsKey(variable)){	
				throw new Exception("The readc operator requires a character." );
			}
		}
		if (root.equals("outputc")){
			if (!procedures.get(proc_num).getCharacters().containsKey(variable)){	
				throw new Exception("The outputc operator requires a character." );
			}
		}		
		
		if (root.equals("read")){
			if (!procedures.get(proc_num).getIntegers().containsKey(variable)){	
				throw new Exception("The read operator requires an integer." );
			}
		}

		if (root.equals("output")){
			if (!procedures.get(proc_num).getIntegers().containsKey(variable)){	
				throw new Exception("The output operator requires an integer." );
			}
		}
		if (root.equals("print")){
			if (!variable.startsWith("\"")&&!variable.endsWith("\"")){	
				throw new Exception("The print operation requires a String." );
			}
		}
	}
	
	/**
	 * This function checks if the values within if's and whiles are assigned properly.
	 * It also loops recursively if there are any nested while or if 's. 
	 *
	 * @param  proc_num  The index of the procedure we are evaluating.
	 * @param  condit  The while or if subtree we are currently evaluating.
	 * @return	The return type is void and throws an Exception if the Evaluation fails
	 */
	public static void conditionCheck(int proc_num,Tree condit)throws Exception{
		
		String root = condit.toString();
		Tree var_assignments;
		
		// Loop through each node of the while or if.
		for (int n=0;n<condit.getChildCount();n++){
			
			var_assignments=condit.getChild(n);
			root = var_assignments.toString();
			
			// If there are any nested while's or if's call itself.
			if (root.equals("while")||root.equals("IF")||root.equals("BLOCK")||root.equals("else")){
				conditionCheck(proc_num,var_assignments);
			} else{
				
				if(!root.equals("print")){
					if ((!areChars(proc_num,var_assignments))&&(!areInts(proc_num,var_assignments))){
						throw new Exception("Type mismatch within a While or an If.");
					}
				}
			}
		}
		
	

	}
	
	/**
	 * Populates the symbol table arrayList with procedure objects for each 
	 * procedure there is within the small-C program. It populates it with the declared
	 * variables as well with 0 for integers and '\000' for characters.
	 *
	 *<p> While populating a semantic check is performed for each procedure encountered
	 * with the help of procedureEval function.
	 *  
	 * @param  tree  The abstract syntax tree of the small-C program.
	 * 
	 * @return	The return type is void since within its execution 
	 * it populates the global arrayList variable "procedures", which serves
	 * as a symbol table.
	 */							
	public static void populateSymbolTable(Tree tree) throws Exception{
		
		int proc_index=0;
		int i = 0;
		Tree child;
		Tree children;
		String root;
		String proc_root;
		String var;
		String type;
		String proc_name;
		
		// Loop through each of the upper nodes of the AST tree.
		while (tree.getChild(i)!=null){
			
			child = tree.getChild(i);
			root = child.toString();
			
			// Populate the the Variable object with the global variables of the program.
			if (root == "VAR_DEF"){
				
				var=child.getChild(1).toString();
				type =child.getChild(0).toString();

				if (global_vars.containsKey(var))
					throw new Exception("Invalid Redeclaration of the global variable " + var + "." );
				
				if (type.equals("int")){
					global_vars.setInteger(var,0);
					
				}
				if (type.equals("char")){
					global_vars.setCharacter(var,'\000');
				}
			}
			
			// Operations on the different procedures are done here.
			if (root.equals("PROC_DEF")){
				
				// Temporary Procedure variable used to populate the 
				// Procedures arrayList in the end of the if. 
				Procedure procedure = new Procedure();
				
				// Inserting the global variables in the procedures own 
				// variable definition.
				procedure.getVariables().insertVariables(global_vars);
				int j = 1;
				
				proc_name = child.getChild(0).toString();
				
				// Check for procedure redeclarations.
				for (int k=0;k<procedures.size();k++){
					if (procedures.get(k).getName().equals(proc_name))
						throw new Exception ("Invalid redeclaration of procedure " + proc_name + ".");
				}
				
				procedure.setName(proc_name);
				
				// Loop through the rest of the procedure children.
				while ((child.getChild(j)!=null)){
					
					children = child.getChild(j);
					proc_root= children.toString();
					
					if (proc_root.equals("RET_TYPE"))
						procedure.setType(children.getChild(0).toString());
					
					if ((proc_root.equals("ARG_DEF"))||proc_root.equals("VAR_DEF")){
						type = children.getChild(0).toString();
						var = children.getChild(1).toString();
						
						if (proc_root.equals("ARG_DEF")){
							procedure.setArguments(var, type);
						}
						if (procedure.getVariables().containsKey(var))
							throw new Exception("Invalid Redeclaration of variable " + var + "." );
											
						if (type.equals("int")){
							
							procedure.setInteger(var, 0);
						}
						if (type.equals("char")){
							
							procedure.setCharacter(var, '\000');
							
						}
						
					}
					
					j++;
					
				}	
			
			// Add the populated procedure to the Procedures arrayList and Evaluate it afterwards.
			procedures.add(procedure);
			procedureEval(proc_index,child);
			proc_index++;
			}
			i++;
			
		}
		
	}
	



}
