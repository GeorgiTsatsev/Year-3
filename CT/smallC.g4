grammar smallC;

options{
    language=java;
}
@members {
    public static void main(String[] args) throws Exception {
        smallCLexer lex = new smallCLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
         smallCParser parser = new smallParser(lex);
        try {
           parser.get();
        } catch (RecognitionException e)  {
          
              throw new IllegalStateException("Recognition exception is never thrown, only declared.");
   
        }
    }
}

/*------------------------------------------------------------------
 *	 LEXER RULES
 *------------------------------------------------------------------*/

WHILE       : 'while'           ;
INCLUDE     : '#include'	;
MAIN        : 'main'		;
LBRACKET    : '('               ;
RBRACKET    : ')'               ;
LCBRACKET   : '{'               ;
RCBRACKET   : '}'               ;
INT         : 'int'		;
CHAR        : 'char'		;
SEMICOLON   : ';'               ;
COMMA       : ','		;
COMPLEFT    : '<'               ;
COMPRIGHT   : '>'               ;
COMPLEFTEQ  : '<='              ;
COMPRIGHTEQ : '>='              ;
ISNOTEQ     : '!='              ;
ISEQ        : '=='		;
EQ          : '='		;
PLUS        : '+'		;
MINUS       : '-'		;
DIVIDE      : '/'		;
MULTIPLY    : '*'               ;
MOD         : '%'		;
ELSE        : 'else'		;
IF          : 'if'		;
READ        : 'read'		;
OUTPUT      : 'output'          ;
PRINT       : 'print'           ;
RETURN      : 'return'          ;
READC       : 'readc'           ;
OUTPUTC     : 'outputc'         ;
SQUOTE      : '\''		;
LQUOTE      : '\"'		;


fragment LLETTER : 'a'..'z' ;

fragment ULETTER : 'A'..'Z' ;

fragment ALPHA : ( LLETTER | ULETTER ) ;

fragment DIGIT : '0'..'9' ;

fragment USCORE : '_' ;

fragment NACHAR : ( '`' | '~' | '!' | '@' | '#' | '$' | ' ' | '^' | '&' | '|' | '\\'  | ':'  | '.' | '?'  ) ;

fragment CHARR : ( ALPHA | DIGIT | NACHAR | '\n' | '\t' | EOF ) ;

IDENT : ( ALPHA ( ALPHA | DIGIT | USCORE )* ) ;

CHARACTER : SQUOTE CHARR SQUOTE ;

STRING : LQUOTE ( ALPHA | DIGIT | NACHAR | COMPLEFT | COMPRIGHT )* LQUOTE ;


NUMBER : DIGIT+ ;

COMMENT
    :   ( '//' ~[\r\n]* '\r'? '\n'
        | '/*' .*? '*/'
        ) -> channel(HIDDEN)
    ;
WS
    :   [\r\t\n]+
        -> skip
    ;
 
/*------------------------------------------------------------------
 *	 PARSER RULES
 *------------------------------------------------------------------*/


program	
	:	( includes decls procedure* main );
	
includes	
	: 	( INCLUDE string )*;
	
decls	
	:	( typedident SEMICOLON )*;
	
procedure	
	:	( ( INT | CHAR )? ident LBRACKET args RBRACKET body );
	
main	
	:	MAIN LBRACKET RBRACKET body;
		
string	
	:	STRING  ;
	
body	
	:	LCBRACKET decls stmtlist RCBRACKET;
		
ident	
	:	IDENT;
	
args	
	:	( typedident ( COMMA typedident )* )?;
	
lexp	
	:	term ( ( PLUS | MINUS ) term )*;
	
typedident	
	:	( INT | CHAR ) ident;
	
exp	
	:	
		
		( lexp ( ( COMPLEFT|COMPRIGHT | COMPLEFTEQ | COMPRIGHTEQ |ISNOTEQ |ISEQ) lexp ) ? );
		
term	
	
	:	factor ( ( DIVIDE | MULTIPLY | MOD ) factor )*;
	
factor	

	:	( LBRACKET lexp RBRACKET ) |
		( MINUS? ( number | ident )) |
		( character ) |
		( ident LBRACKET ( ident ( COMMA ident )*)?  RBRACKET);
		
character	
	:	CHARACTER;
	
number	
	:	NUMBER;
	
stmtlist	
	:	stmt*;
	
stmt	
	:	
		( LCBRACKET stmtlist RCBRACKET ) |
		( WHILE LBRACKET exp RBRACKET stmt ) |
		( IF LBRACKET exp RBRACKET stmt ( ELSE stmt )? ) |
		( ident EQ lexp SEMICOLON ) |
		( READ LBRACKET ident RBRACKET SEMICOLON ) |
		( OUTPUT LBRACKET ident RBRACKET SEMICOLON ) |
		( PRINT LBRACKET string RBRACKET SEMICOLON ) |
		( RETURN lexp? SEMICOLON ) |
		( READC LBRACKET ident RBRACKET SEMICOLON ) | 
		( OUTPUTC LBRACKET ident RBRACKET SEMICOLON ) |
		( ident LBRACKET ( ident ( COMMA ident )* )? RBRACKET SEMICOLON ) ;	

