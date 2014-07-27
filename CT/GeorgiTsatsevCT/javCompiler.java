/***
 * The class that creates a .class file from a small-C program by converting the code
 * into java bytecode.
 */



import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;
import org.objectweb.asm.*;
	
/**
 * @author Georgi Tsatsev
 */
public class javCompiler extends ClassLoader implements Opcodes  {

	private static ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
	private static FieldVisitor fv;
	private static MethodVisitor mv;
	private static HashMap<String,String> global_var_reg = new HashMap<String,String>();
	private static String class_name;
	private static HashMap<String,String> procedures =new HashMap<String,String>();
	
	/**
	 * A function pushing the value of the variable that is contained in a
	 * tree.
	 *  
	 * @param  variable  The abstract syntax tree of a variable.
	 * @param var_reg The variables and their register values in the procedure.
	 * 
	 * @return	void and it pushes the result to the stack.
	 */	
	public static void getVal(Tree variable,HashMap<String,Integer> var_reg){
		String var_string=variable.toString();
		
		if (procedures.containsKey(var_string)){
			
			mv.visitMethodInsn(INVOKESTATIC,class_name,var_string,"("+ procedures.get(var_string)+")I");
		}		
		if (global_var_reg.containsKey(var_string)){
			mv.visitFieldInsn(GETSTATIC, class_name, var_string, global_var_reg.get(var_string));
		}else if (var_reg.containsKey(var_string)){
			mv.visitVarInsn(ILOAD, var_reg.get(var_string));
		}else if (var_string.charAt(0)=='\''&&var_string.charAt(2)=='\''){
			mv.visitIntInsn(BIPUSH, variable.toString().charAt(1));
		}else {
			mv.visitIntInsn(SIPUSH, Integer.parseInt(variable.toString()));
		}
		
	}
	
	/**
	 * The localDeclaration function handles the declarations of variables
	 * within the different procedures.
	 *  
	 * @param  proc_tree  The abstract syntax tree of the procedure.
	 * 
	 * @return	a hashmap of strings and integers containing the variable name
	 * and its respective register address.
	 */	
	public static HashMap<String,Integer> localDeclarations (Tree proc_tree){
		HashMap<String,Integer> var_reg = new HashMap<String,Integer>();
		Tree proc_root;
		String proc_root_name=null;
		String var_name = null;
		int reg=0;
		for (int j=0; j<proc_tree.getChildCount();j++){
			
			proc_root = proc_tree.getChild(j);
        	proc_root_name = proc_root.toString(); 
        	
        	if (proc_root_name.equals("VAR_DEF")||proc_root_name.equals("ARG_DEF")){
        				
        		proc_root_name = proc_root.getChild(0).toString();
        		var_name=proc_root.getChild(1).toString();
            	if (proc_root_name.equals("int")){
            		
            		mv.visitIntInsn(SIPUSH, 0);
            		mv.visitVarInsn(ISTORE, reg);  
            		
            	} else{
            		mv.visitIntInsn(BIPUSH, '\000');
            		mv.visitVarInsn(ISTORE, reg);  
            	}
            	
            	
            	var_reg.put(var_name, reg);
            	reg++;
        	} 
		}
		return var_reg;
	}

	
	/**
	 * This is a helper function that given an expression tree and a hashmap with 
	 * the variables and their respective register index returns its calculated result.
	 *
	 *<p> It loops recursivelly during its execution.
	 *  
	 * @param  expression  The abstract syntax tree a procedure's expression.
	 * @param var_reg The variables and their register values in the procedure.
	 * @return	void and it pushes the result to the stack.
	 */	
	public static void recExp(Tree expression, HashMap<String,Integer> var_reg ){
		
		if (expression.getChildCount()==0){
			getVal(expression,var_reg);
		}else if(expression.getChildCount()==2){
			
			if (expression.getChild(0).getChildCount()==0&&expression.getChild(1).getChildCount()==0){
				
				getVal(expression.getChild(0),var_reg);
				getVal(expression.getChild(1),var_reg);
					
			}else{
				recExp(expression.getChild(0),var_reg);
				recExp(expression.getChild(1),var_reg);
			}
		} else if(expression.getChildCount()==3) {
			if (expression.getChild(0).toString().equals("-")){
				mv.visitIntInsn(SIPUSH, Integer.parseInt("-"+expression.getChild(1).toString()));
				recExp(expression.getChild(2),var_reg);
			}else{
				recExp(expression.getChild(0),var_reg);
				mv.visitIntInsn(SIPUSH, Integer.parseInt("-"+expression.getChild(2).toString()));
				
			}
		} else{
			
			mv.visitIntInsn(SIPUSH, Integer.parseInt("-"+expression.getChild(1).toString()));
			mv.visitIntInsn(SIPUSH, Integer.parseInt("-"+expression.getChild(3).toString()));
			

		}
		if (expression.toString().equals("+")){
			mv.visitInsn(IADD);
		}
		if (expression.toString().equals("-")){
			mv.visitInsn(ISUB);
		}
		if (expression.toString().equals("*")){
			mv.visitInsn(IMUL);
		}
		if (expression.toString().equals("/")){
			mv.visitInsn(IDIV);
		}


		
	}

	
	/**
	 * This function determines whether or not an if statement would be taken 
	 * and sets the Method visotors labels appropriatelly. 
	 *  
	 * @param  condit  The AST of a condition check of an if.
	 * @param var_reg The variables and their register values in the procedure.
	 * @return	void and it pushes the result to the stack.
	 */	
	public static void if_Jumper(Tree condit,HashMap<String,Integer> var_reg)throws Exception{
		
		String root = condit.toString();
		Tree var_assignments;
		String condition = null;
		
		Label jump_target = new Label();
		Label jump_skipp = new Label();
		

		var_assignments=condit.getChild(1);
		root = var_assignments.toString();
		if(condit.getChildCount()==3){
			root = condit.getChild(0).toString();
			condition = root;				
				
		    if (condit.getChild(0).getChild(0).toString().charAt(0)==('\'')){
				mv.visitIntInsn(BIPUSH,condit.getChild(0).getChild(0).toString().charAt(1));
			}else{        					
				recExp(condit.getChild(0).getChild(0),var_reg);
			}	
		    if (condit.getChild(0).getChild(1).toString().charAt(0)==('\'')){
		    	mv.visitIntInsn(BIPUSH,condit.getChild(0).getChild(1).toString().charAt(1));
			}else{        					
				recExp(condit.getChild(0).getChild(1),var_reg);
			}
		        	        
		    if (condition.equals(">")){
		      	mv.visitJumpInsn(IF_ICMPLE, jump_target);
		    }else if (condition.equals(">=")){
		      	mv.visitJumpInsn(IF_ICMPLT, jump_target);
		    }else if (condition.equals("<")){
		       	mv.visitJumpInsn(IF_ICMPGE, jump_target);
			}else if (condition.equals("<=")){
		       	mv.visitJumpInsn(IF_ICMPGT, jump_target);
			}else if (condition.equals("==")){
		       	mv.visitJumpInsn(IF_ICMPNE, jump_target);
			}else if (condition.equals("!=")){
		       	mv.visitJumpInsn(IF_ICMPEQ, jump_target);
					
		    }
		    	procedureVisitor(condit.getChild(1),var_reg);
		        mv.visitJumpInsn(GOTO, jump_skipp);
		                
		        mv.visitLabel(jump_target);
		        procedureVisitor(condit.getChild(2),var_reg);
		        mv.visitLabel(jump_skipp);
		}
		//	}else {
				//mv.visitLabel(jump_skipp);
				//procedureVisitor(condit.getChild(1),var_reg);
	//		}
			
	//	}
	}
	
	/**
	 * This function determines whether or not while statement would be taken 
	 * and sets the Method visotors labels appropriatelly. Loops back to its label
	 * until the condition is met.
	 *  
	 * @param  condit  The AST of a condition check of an if.
	 * @param var_reg The variables and their register values in the procedure.
	 * @return	void and it pushes the result to the stack.
	 */	
	public static void while_Jumper(Tree condit,HashMap<String,Integer> var_reg)throws Exception{
		
		String root = condit.toString();
		Tree var_assignments;
		String condition = null;
		
		Label jump_target = new Label();
		Label loop = new Label();
		// Loop through each node of the while or if.
		for (int n=0;n<condit.getChildCount();n++){
			
			var_assignments=condit.getChild(n);
			root = var_assignments.toString();
			
			// If there are any nested while's or if's call itself.
			if (root.equals("while")){
				while_Jumper(var_assignments,var_reg);
			} else {
				
				
				mv.visitLabel(loop);	
				
				root = condit.getChild(0).toString();
				condition = root;				
				
		        if (condit.getChild(0).getChild(0).toString().charAt(0)==('\'')){
					mv.visitIntInsn(BIPUSH,condit.getChild(0).getChild(0).toString().charAt(1));
				}else{        					
					recExp(condit.getChild(0).getChild(0),var_reg);
				}	
		        if (condit.getChild(0).getChild(1).toString().charAt(0)==('\'')){
					mv.visitIntInsn(BIPUSH,condit.getChild(0).getChild(1).toString().charAt(1));
				}else{        					
					recExp(condit.getChild(0).getChild(1),var_reg);
				}
		        	        
		        if (condition.equals(">")){
		        	mv.visitJumpInsn(IF_ICMPLE, jump_target);
		        }else if (condition.equals(">=")){
		        	mv.visitJumpInsn(IF_ICMPLT, jump_target);
				}else if (condition.equals("<")){
		        	mv.visitJumpInsn(IF_ICMPGE, jump_target);
				}else if (condition.equals("<=")){
		        	mv.visitJumpInsn(IF_ICMPGT, jump_target);
				}else if (condition.equals("==")){
		        	mv.visitJumpInsn(IF_ICMPNE, jump_target);
				}else if (condition.equals("!=")){
		        	mv.visitJumpInsn(IF_ICMPEQ, jump_target);
					
		        }
		        
		        procedureVisitor(condit,var_reg);
		        mv.visitJumpInsn(GOTO, loop);
		        mv.visitLabel(jump_target);
			}
			
		}
		
		
		
	}
	
	/**
	 * This function transforms the current's procedure's code into java bytecode
	 * with the help of the above functions.
	 * 
	 * @param  proc  The AST of the current proceduree.
	 * @param var_reg The variables and their register values in the procedure.
	 * @return	void and it pushes and loads everything to the stack.
	 */	
	public static void procedureVisitor(Tree proc,HashMap<String, Integer> var_reg ) throws Exception{
			
			Tree child;
			String child_root;
			String variable;
			for (int i=0; i<proc.getChildCount();i++){
				child = proc.getChild(i);
				child_root = child.toString(); 
	    	
				// Argument assignments.
				if (child_root.equals("=")){
        			variable = child.getChild(0).toString();
        			        			
        			if (child.getChild(1).toString().charAt(0)==('\'')){
        				mv.visitIntInsn(BIPUSH,child.getChild(1).toString().charAt(1));
        				mv.visitVarInsn(ISTORE, var_reg.get(variable));
        			}else if (procedures.containsKey(child.getChild(1).toString())) {
        				
        			} else{
						recExp(child.getChild(1),var_reg);
	            		if (global_var_reg.containsKey(variable)){
	            			mv.visitFieldInsn(PUTSTATIC, class_name,variable, global_var_reg.get(variable));
	            		} else if (var_reg.containsKey(variable)) {
	    					mv.visitVarInsn(ISTORE, var_reg.get(variable));
	    				} 
        			}
        			
				}
				if (child_root.equals("IF")){
	        	   	if_Jumper(child,var_reg);
				}
				if (child_root.equals("while")){
	        	   	while_Jumper(child,var_reg);
				}

				if (child_root.toString().equals("output")){
					mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
					getVal(child.getChild(0),var_reg);
			        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(I)V");
   	
				}
				if (child_root.toString().equals("outputc")){
					mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
					getVal(child.getChild(0),var_reg);
			        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(C)V");
   	
				}
				if (child_root.toString().equals("read")){
					variable = child.getChild(0).toString();
					mv.visitFieldInsn(INVOKESTATIC, "java/lang/System", "console", "()Ljava/io/Console;");
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/Console", "readLine", "()Ljava/lang/String;");
			        mv.visitFieldInsn(INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I");
			        
			        getVal(child.getChild(0),var_reg);
			       
				}
				if (child_root.toString().equals("readc")){
					variable = child.getChild(0).toString();
					mv.visitFieldInsn(INVOKESTATIC, "java/lang/System", "console", "()Ljava/io/Console;");
					mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/Console", "reader", "()Ljava/lang/Reader;");
			        mv.visitFieldInsn(INVOKESTATIC, "java/io/Reader", "reader", "()I");
			        mv.visitInsn(I2C);
			        
			        getVal(child.getChild(0),var_reg);
			   	}
				if (child_root.toString().equals("print")){
					mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
					mv.visitLdcInsn(child.getChild(0).toString());
			        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V");
   	
				}
				if (child_root.toString().equals("return")){
					
					getVal(child.getChild(0),var_reg);
					mv.visitInsn(IRETURN);
			        mv.visitMaxs(256,256);
   	
				}
	
			
			}
	}

	
	public static void fun_Compile(Tree tree,String name) throws Exception {
		
		//////////////////////////// DEFAULT CLASS DECL ////////////////////////////////////
		
		// Get the name of the file .
		name = name.split("[.]")[0];	
		cw.visit(V1_1, ACC_PUBLIC, name, null, "java/lang/Object", null);
        //////////////////////// DEFAULT CLASS DECL END////////////////////////
       
        
        ///////////////////////// GLOBAL VARIABLES DECL//////////////////////////////////
        String root_name = null;
        Tree root;
        class_name=name;
  
        for (int i=0; i<tree.getChildCount();i++){
        	root = tree.getChild(i);
        	root_name = root.toString(); 
        	if (root_name.equals("VAR_DEF")){
        		root_name=root.getChild(0).toString();
        		
        		if (root_name.equals("int")){
        			root_name=root.getChild(1).toString();
            		fv = cw.visitField(ACC_STATIC,root_name, "I", null , 0);
            		fv.visitEnd();
            		global_var_reg.put(root.getChild(1).toString(),"I");
        		} else{
        			root_name=root.getChild(1).toString();
            		fv = cw.visitField(ACC_STATIC, root_name, "C", null , '\000');
            		global_var_reg.put(root.getChild(1).toString(),"C");
            		fv.visitEnd();
        		}
        		
        	}

        }
              
        
        ///////////////////////////DEFAULTS METHOD ////////////////////////////////
        // creates a MethodWriter for the (implicit) constructor
        mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        // invokes the super class constructor
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        mv.visitInsn(RETURN);
        // this code uses a maximum of one stack element and one local variable
        mv.visitMaxs(1, 1);
        mv.visitEnd();
        ///////////////////////// DEFAULTS METHOD END ///////////////////////////////
               
        //////////////////////// PROCEDURE CREATION LOOP //////////////////////////
       
   
        Tree node = null;
        String node_name=null;
        String procedure_args="";
        String procedure_name=null;
        String procedure_return=null;
        HashMap<String, Integer> var_reg = new HashMap<String, Integer>();


        for (int i=0; i<tree.getChildCount();i++){
        	root = tree.getChild(i);
        	root_name = root.toString(); 
        	if (root_name.equals("PROC_DEF")){
        		
        		procedure_name=root.getChild(0).toString();
        		
        		for (int j=1; j<root.getChildCount();j++){
        			
        			node =root.getChild(j);
        			node_name=node.toString();
        			if (procedure_name.equals("main")){
    					procedure_args = "[Ljava/lang/String;";
    				} 
        			if (node_name.equals("RET_TYPE")){
        				procedure_return = node.getChild(0).toString();
        				if (procedure_return.equals("VOID")){
        					procedure_return = "V";
        				}else if(procedure_return.equals("INT")){
        					procedure_return = "I";
        				} else{
        					procedure_return = "C";
        				}
        			}
        			if (node_name.equals("ARG_DEF")){
        				
        				if (node.getChild(0).toString().equals("int"))
        					procedure_args=procedure_args+"I";
        				else 
        					procedure_args=procedure_args+"C";
           			}
        		        		
        		}
        		
        		procedures.put(procedure_name, procedure_args);
        		mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, procedure_name, "("+procedure_args+")"+procedure_return, null, null);
        		mv.visitCode();
                var_reg = localDeclarations(root);
                procedureVisitor(root,var_reg);
                mv.visitEnd();
        	}
        }
        	
     

        
        
        mv.visitInsn(RETURN);
        mv.visitMaxs(100, 100);
        mv.visitEnd();
        ////////////////////////// MAIN METHOD CREATION END //////////////////////
   
       
        /////////////////////////// FILE CREATION //////////////////////////
        byte[] code = cw.toByteArray();
        FileOutputStream fos = new FileOutputStream(name + ".class");
        fos.write(code);
        fos.close();
        //////////////////////// FILE CREATION END /////////////////////////////////////
        
     
        
    }



	public static void main(String[] args) throws Exception {

		CharStream input = new ANTLRFileStream(args[0]);
		SmallCLexer lex = new SmallCLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		SmallCParser parser = new SmallCParser(tokens);
		SmallCParser.program_return r = parser.program();
		String tree = ((Tree) r.tree).toStringTree();		
		
		//calling the semantic check and compilator.
		SemanticCheck.populateSymbolTable((Tree)r.tree);
		fun_Compile((Tree)r.tree,args[0]);
	   
		
		
		System.out.println(tree);
		
		if (args.length > 1) {
			PrintWriter out = new PrintWriter(new FileWriter(args[1]));
			out.println(tree);
			out.close();
		}
	}
}