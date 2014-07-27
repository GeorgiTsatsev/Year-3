parser grammar SmallCParser;

options {
  language = Java;
  tokenVocab = SmallCLexer;
  output = AST;
}

@header {
  package FrontEnd;
}

program : includes decls procedure* main EOF ;

includes : ( INCLUDE STRING )* ;

decls : ( typedident SEMIC )* ; 

procedure : (TINT | TCHAR)? IDENT LPAREN args RPAREN body ;

main : MAIN LPAREN RPAREN body ;

typedident : ( TINT | TCHAR ) IDENT ;

args : ( typedident ( COMM typedident )* )? ;

body : LBRACE decls stmtlist RBRACE ;

stmtlist : stmt* ;

exp : lexp ( ( GT | LT | GTE | LTE | EQ ) lexp )? ;

stmt : 
	LBRACE stmtlist RBRACE | 
	WHILE LPAREN exp RPAREN stmt |
	IF LPAREN exp RPAREN stmt ( ( ELSE )=> ELSE stmt )? |   
	IDENT ASSIGN lexp SEMIC | 
	READ LPAREN IDENT RPAREN SEMIC | 
	OUTPUT LPAREN IDENT RPAREN SEMIC | 
	PRINT LPAREN STRING RPAREN SEMIC | 
	RETURN lexp? SEMIC | 
	READC LPAREN IDENT RPAREN SEMIC | 
	OUTPUTC LPAREN IDENT RPAREN SEMIC | 
	IDENT LPAREN ( IDENT ( COMM IDENT )* )? RPAREN SEMIC ;

lexp : term ( ( PLUS | MINUS ) term )* ;

factor : 
	LPAREN lexp RPAREN | 
	MINUS? ( IDENT | NUMBER ) | 
	CHARACTER | 
	IDENT LPAREN ( IDENT ( COMM IDENT )* )? RPAREN ;

term : factor ( ( DIV | MULT | MOD ) factor )* ;


