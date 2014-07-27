lexer grammar SmallCLexer;

options {
  language = Java;
}

@header {
  package FrontEnd;
}

fragment LCALPHA : 'a'..'z' ;

fragment UCALPHA : 'A'..'Z' ;

fragment ALPHA : ( LCALPHA | UCALPHA ) ;

fragment DIGIT : '0'..'9' ;

fragment USCORE : '_' ;

fragment NACHAR : ( '`' | '~' | '!' | '@' | '#' | '$' | '%' | '^' | '&' | '*' | '(' | ')' | '-' | '_' | '+' | '=' | '{' | '[' | '}' | ']' | '|' | '\\' | ';' | ':' | '\'' | '\\"' | '<' | ',' | '>' | '.' | '?' | '/' ) ;

fragment CHAR : ( ALPHA | DIGIT | NACHAR | ' ' | '\n' | '\t' | EOF ) ;

fragment CQUOTE : '`' ;

fragment SQUOTE : '"' ;

INCLUDE : '#include' ; 

MAIN : 'main' ;

WHILE : 'while' ;

IF : 'if' ;

ELSE : 'else' ;

ASSIGN : '=' ;

READ : 'read' ;

OUTPUT : 'output' ;

PRINT : 'print' ;

RETURN : 'return' ;

READC : 'readc' ;

OUTPUTC : 'outputc' ;

TINT : 'int' ;

TCHAR : 'char' ;

fragment RESERVED : MAIN | WHILE | IF | ELSE | ASSIGN | OUTPUT | PRINT | RETURN | READC | OUTPUTC | INCLUDE | TINT | TCHAR ;

IDENT : ( ALPHA ( ALPHA | DIGIT | USCORE )* )~RESERVED ;

CHARACTER : CQUOTE CHAR CQUOTE ;

STRING : SQUOTE ( ALPHA | '.' )* SQUOTE ;

NUMBER : '1'..'9' DIGIT* ;

GT : '>' ;

LT : '<' ;

GTE : '>=' ;

LTE : '<=' ;

EQ : '==' ;

SEMIC : ';' ;

COMM : ',' ;

LPAREN : '(' ;

RPAREN : ')' ;

LBRACE : '{' ;

RBRACE : '}' ;

PLUS : '+' ;

MINUS : '-' ;

MULT : '*' ;

DIV : '/' ;

MOD : '%' ;

WS : ( ' ' | '\t' | '\s' | '\r' | '\n' )+ { $channel = HIDDEN; } ;

COMMENT : '//' ( .~'\n' )* { $channel = HIDDEN; } ;

MCOMMENT : '/*' .* '*/' { $channel = HIDDEN; } ;




