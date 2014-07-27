// $ANTLR 3.5 /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g 2013-02-15 04:46:28

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class antlrgrammaParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALPHA", "CHAR", "CHARACTER", 
		"CHARR", "COMMA", "COMMENT", "COMPLEFT", "COMPLEFTEQ", "COMPRIGHT", "COMPRIGHTEQ", 
		"DIGIT", "DIVIDE", "ELSE", "EQ", "IDENT", "IF", "INCLUDE", "INT", "ISEQ", 
		"ISNOTEQ", "LBRACKET", "LCBRACKET", "LLETTER", "LQUOTE", "MAIN", "MCOMMENT", 
		"MINUS", "MOD", "MULTIPLY", "NACHAR", "NUMBER", "OUTPUT", "OUTPUTC", "PLUS", 
		"PRINT", "RBRACKET", "RCBRACKET", "READ", "READC", "RETURN", "SEMICOLON", 
		"SQUOTE", "STRING", "ULETTER", "USCORE", "WHILE", "WS"
	};
	public static final int EOF=-1;
	public static final int ALPHA=4;
	public static final int CHAR=5;
	public static final int CHARACTER=6;
	public static final int CHARR=7;
	public static final int COMMA=8;
	public static final int COMMENT=9;
	public static final int COMPLEFT=10;
	public static final int COMPLEFTEQ=11;
	public static final int COMPRIGHT=12;
	public static final int COMPRIGHTEQ=13;
	public static final int DIGIT=14;
	public static final int DIVIDE=15;
	public static final int ELSE=16;
	public static final int EQ=17;
	public static final int IDENT=18;
	public static final int IF=19;
	public static final int INCLUDE=20;
	public static final int INT=21;
	public static final int ISEQ=22;
	public static final int ISNOTEQ=23;
	public static final int LBRACKET=24;
	public static final int LCBRACKET=25;
	public static final int LLETTER=26;
	public static final int LQUOTE=27;
	public static final int MAIN=28;
	public static final int MCOMMENT=29;
	public static final int MINUS=30;
	public static final int MOD=31;
	public static final int MULTIPLY=32;
	public static final int NACHAR=33;
	public static final int NUMBER=34;
	public static final int OUTPUT=35;
	public static final int OUTPUTC=36;
	public static final int PLUS=37;
	public static final int PRINT=38;
	public static final int RBRACKET=39;
	public static final int RCBRACKET=40;
	public static final int READ=41;
	public static final int READC=42;
	public static final int RETURN=43;
	public static final int SEMICOLON=44;
	public static final int SQUOTE=45;
	public static final int STRING=46;
	public static final int ULETTER=47;
	public static final int USCORE=48;
	public static final int WHILE=49;
	public static final int WS=50;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public antlrgrammaParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public antlrgrammaParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return antlrgrammaParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g"; }



	// $ANTLR start "program"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:79:1: program : ( includes decls ( procedure )* main ) ;
	public final void program() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:80:2: ( ( includes decls ( procedure )* main ) )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:80:4: ( includes decls ( procedure )* main )
			{
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:80:4: ( includes decls ( procedure )* main )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:80:6: includes decls ( procedure )* main
			{
			pushFollow(FOLLOW_includes_in_program661);
			includes();
			state._fsp--;

			pushFollow(FOLLOW_decls_in_program663);
			decls();
			state._fsp--;

			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:80:21: ( procedure )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==CHAR||LA1_0==IDENT||LA1_0==INT) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:80:21: procedure
					{
					pushFollow(FOLLOW_procedure_in_program665);
					procedure();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			pushFollow(FOLLOW_main_in_program668);
			main();
			state._fsp--;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "includes"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:82:1: includes : ( INCLUDE string )* ;
	public final void includes() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:83:2: ( ( INCLUDE string )* )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:83:5: ( INCLUDE string )*
			{
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:83:5: ( INCLUDE string )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==INCLUDE) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:83:7: INCLUDE string
					{
					match(input,INCLUDE,FOLLOW_INCLUDE_in_includes684); 
					pushFollow(FOLLOW_string_in_includes686);
					string();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "includes"



	// $ANTLR start "decls"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:85:1: decls : ( typedident SEMICOLON )* ;
	public final void decls() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:86:2: ( ( typedident SEMICOLON )* )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:86:4: ( typedident SEMICOLON )*
			{
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:86:4: ( typedident SEMICOLON )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==CHAR||LA3_0==INT) ) {
					int LA3_1 = input.LA(2);
					if ( (LA3_1==IDENT) ) {
						int LA3_3 = input.LA(3);
						if ( (LA3_3==SEMICOLON) ) {
							alt3=1;
						}

					}

				}

				switch (alt3) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:86:6: typedident SEMICOLON
					{
					pushFollow(FOLLOW_typedident_in_decls702);
					typedident();
					state._fsp--;

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_decls704); 
					}
					break;

				default :
					break loop3;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decls"



	// $ANTLR start "procedure"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:88:1: procedure : ( ( INT | CHAR )? ident LBRACKET args RBRACKET body ) ;
	public final void procedure() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:89:2: ( ( ( INT | CHAR )? ident LBRACKET args RBRACKET body ) )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:89:4: ( ( INT | CHAR )? ident LBRACKET args RBRACKET body )
			{
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:89:4: ( ( INT | CHAR )? ident LBRACKET args RBRACKET body )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:89:6: ( INT | CHAR )? ident LBRACKET args RBRACKET body
			{
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:89:6: ( INT | CHAR )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==CHAR||LA4_0==INT) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:
					{
					if ( input.LA(1)==CHAR||input.LA(1)==INT ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			pushFollow(FOLLOW_ident_in_procedure731);
			ident();
			state._fsp--;

			match(input,LBRACKET,FOLLOW_LBRACKET_in_procedure733); 
			pushFollow(FOLLOW_args_in_procedure735);
			args();
			state._fsp--;

			match(input,RBRACKET,FOLLOW_RBRACKET_in_procedure737); 
			pushFollow(FOLLOW_body_in_procedure739);
			body();
			state._fsp--;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "procedure"



	// $ANTLR start "main"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:91:1: main : MAIN LBRACKET RBRACKET body ;
	public final void main() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:92:2: ( MAIN LBRACKET RBRACKET body )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:92:4: MAIN LBRACKET RBRACKET body
			{
			match(input,MAIN,FOLLOW_MAIN_in_main752); 
			match(input,LBRACKET,FOLLOW_LBRACKET_in_main754); 
			match(input,RBRACKET,FOLLOW_RBRACKET_in_main756); 
			pushFollow(FOLLOW_body_in_main758);
			body();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "main"



	// $ANTLR start "string"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:94:1: string : STRING ;
	public final void string() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:95:2: ( STRING )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:95:4: STRING
			{
			match(input,STRING,FOLLOW_STRING_in_string770); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "string"



	// $ANTLR start "body"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:97:1: body : LCBRACKET decls stmtlist RCBRACKET ;
	public final void body() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:98:2: ( LCBRACKET decls stmtlist RCBRACKET )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:98:4: LCBRACKET decls stmtlist RCBRACKET
			{
			match(input,LCBRACKET,FOLLOW_LCBRACKET_in_body783); 
			pushFollow(FOLLOW_decls_in_body785);
			decls();
			state._fsp--;

			pushFollow(FOLLOW_stmtlist_in_body787);
			stmtlist();
			state._fsp--;

			match(input,RCBRACKET,FOLLOW_RCBRACKET_in_body789); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "body"



	// $ANTLR start "ident"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:100:1: ident : IDENT ;
	public final void ident() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:101:2: ( IDENT )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:101:4: IDENT
			{
			match(input,IDENT,FOLLOW_IDENT_in_ident801); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ident"



	// $ANTLR start "args"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:103:1: args : ( typedident ( COMMA typedident )* )? ;
	public final void args() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:104:2: ( ( typedident ( COMMA typedident )* )? )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:104:4: ( typedident ( COMMA typedident )* )?
			{
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:104:4: ( typedident ( COMMA typedident )* )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==CHAR||LA6_0==INT) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:104:6: typedident ( COMMA typedident )*
					{
					pushFollow(FOLLOW_typedident_in_args814);
					typedident();
					state._fsp--;

					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:104:17: ( COMMA typedident )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==COMMA) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:104:19: COMMA typedident
							{
							match(input,COMMA,FOLLOW_COMMA_in_args818); 
							pushFollow(FOLLOW_typedident_in_args820);
							typedident();
							state._fsp--;

							}
							break;

						default :
							break loop5;
						}
					}

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "args"



	// $ANTLR start "lexp"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:106:1: lexp : term ( ( PLUS | MINUS ) term )* ;
	public final void lexp() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:107:2: ( term ( ( PLUS | MINUS ) term )* )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:107:4: term ( ( PLUS | MINUS ) term )*
			{
			pushFollow(FOLLOW_term_in_lexp837);
			term();
			state._fsp--;

			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:107:9: ( ( PLUS | MINUS ) term )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==MINUS||LA7_0==PLUS) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:107:11: ( PLUS | MINUS ) term
					{
					if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_term_in_lexp851);
					term();
					state._fsp--;

					}
					break;

				default :
					break loop7;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lexp"



	// $ANTLR start "typedident"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:109:1: typedident : ( INT | CHAR ) ident ;
	public final void typedident() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:110:2: ( ( INT | CHAR ) ident )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:110:4: ( INT | CHAR ) ident
			{
			if ( input.LA(1)==CHAR||input.LA(1)==INT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_ident_in_typedident875);
			ident();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "typedident"



	// $ANTLR start "exp"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:112:1: exp : ( lexp ( ( COMPLEFT | COMPRIGHT | COMPLEFTEQ | COMPRIGHTEQ | ISNOTEQ | ISEQ ) lexp )? ) ;
	public final void exp() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:113:2: ( ( lexp ( ( COMPLEFT | COMPRIGHT | COMPLEFTEQ | COMPRIGHTEQ | ISNOTEQ | ISEQ ) lexp )? ) )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:115:3: ( lexp ( ( COMPLEFT | COMPRIGHT | COMPLEFTEQ | COMPRIGHTEQ | ISNOTEQ | ISEQ ) lexp )? )
			{
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:115:3: ( lexp ( ( COMPLEFT | COMPRIGHT | COMPLEFTEQ | COMPRIGHTEQ | ISNOTEQ | ISEQ ) lexp )? )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:115:5: lexp ( ( COMPLEFT | COMPRIGHT | COMPLEFTEQ | COMPRIGHTEQ | ISNOTEQ | ISEQ ) lexp )?
			{
			pushFollow(FOLLOW_lexp_in_exp894);
			lexp();
			state._fsp--;

			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:115:10: ( ( COMPLEFT | COMPRIGHT | COMPLEFTEQ | COMPRIGHTEQ | ISNOTEQ | ISEQ ) lexp )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( ((LA8_0 >= COMPLEFT && LA8_0 <= COMPRIGHTEQ)||(LA8_0 >= ISEQ && LA8_0 <= ISNOTEQ)) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:115:12: ( COMPLEFT | COMPRIGHT | COMPLEFTEQ | COMPRIGHTEQ | ISNOTEQ | ISEQ ) lexp
					{
					if ( (input.LA(1) >= COMPLEFT && input.LA(1) <= COMPRIGHTEQ)||(input.LA(1) >= ISEQ && input.LA(1) <= ISNOTEQ) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_lexp_in_exp919);
					lexp();
					state._fsp--;

					}
					break;

			}

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp"



	// $ANTLR start "term"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:117:1: term : factor ( ( DIVIDE | MULTIPLY | MOD ) factor )* ;
	public final void term() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:119:2: ( factor ( ( DIVIDE | MULTIPLY | MOD ) factor )* )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:119:4: factor ( ( DIVIDE | MULTIPLY | MOD ) factor )*
			{
			pushFollow(FOLLOW_factor_in_term939);
			factor();
			state._fsp--;

			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:119:11: ( ( DIVIDE | MULTIPLY | MOD ) factor )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==DIVIDE||(LA9_0 >= MOD && LA9_0 <= MULTIPLY)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:119:13: ( DIVIDE | MULTIPLY | MOD ) factor
					{
					if ( input.LA(1)==DIVIDE||(input.LA(1) >= MOD && input.LA(1) <= MULTIPLY) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_factor_in_term957);
					factor();
					state._fsp--;

					}
					break;

				default :
					break loop9;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "term"



	// $ANTLR start "factor"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:121:1: factor : ( ( LBRACKET lexp RBRACKET ) | ( ( MINUS )? ( number | ident ) ) | ( character ) | ( ident LBRACKET ( ident ( COMMA ident )* )? RBRACKET ) );
	public final void factor() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:123:2: ( ( LBRACKET lexp RBRACKET ) | ( ( MINUS )? ( number | ident ) ) | ( character ) | ( ident LBRACKET ( ident ( COMMA ident )* )? RBRACKET ) )
			int alt14=4;
			switch ( input.LA(1) ) {
			case LBRACKET:
				{
				alt14=1;
				}
				break;
			case MINUS:
			case NUMBER:
				{
				alt14=2;
				}
				break;
			case IDENT:
				{
				int LA14_3 = input.LA(2);
				if ( ((LA14_3 >= COMPLEFT && LA14_3 <= COMPRIGHTEQ)||LA14_3==DIVIDE||(LA14_3 >= ISEQ && LA14_3 <= ISNOTEQ)||(LA14_3 >= MINUS && LA14_3 <= MULTIPLY)||LA14_3==PLUS||LA14_3==RBRACKET||LA14_3==SEMICOLON) ) {
					alt14=2;
				}
				else if ( (LA14_3==LBRACKET) ) {
					alt14=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CHARACTER:
				{
				alt14=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:123:4: ( LBRACKET lexp RBRACKET )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:123:4: ( LBRACKET lexp RBRACKET )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:123:6: LBRACKET lexp RBRACKET
					{
					match(input,LBRACKET,FOLLOW_LBRACKET_in_factor974); 
					pushFollow(FOLLOW_lexp_in_factor976);
					lexp();
					state._fsp--;

					match(input,RBRACKET,FOLLOW_RBRACKET_in_factor978); 
					}

					}
					break;
				case 2 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:124:3: ( ( MINUS )? ( number | ident ) )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:124:3: ( ( MINUS )? ( number | ident ) )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:124:5: ( MINUS )? ( number | ident )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:124:5: ( MINUS )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==MINUS) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:124:5: MINUS
							{
							match(input,MINUS,FOLLOW_MINUS_in_factor988); 
							}
							break;

					}

					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:124:12: ( number | ident )
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==NUMBER) ) {
						alt11=1;
					}
					else if ( (LA11_0==IDENT) ) {
						alt11=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}

					switch (alt11) {
						case 1 :
							// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:124:14: number
							{
							pushFollow(FOLLOW_number_in_factor993);
							number();
							state._fsp--;

							}
							break;
						case 2 :
							// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:124:23: ident
							{
							pushFollow(FOLLOW_ident_in_factor997);
							ident();
							state._fsp--;

							}
							break;

					}

					}

					}
					break;
				case 3 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:125:3: ( character )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:125:3: ( character )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:125:5: character
					{
					pushFollow(FOLLOW_character_in_factor1008);
					character();
					state._fsp--;

					}

					}
					break;
				case 4 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:126:3: ( ident LBRACKET ( ident ( COMMA ident )* )? RBRACKET )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:126:3: ( ident LBRACKET ( ident ( COMMA ident )* )? RBRACKET )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:126:5: ident LBRACKET ( ident ( COMMA ident )* )? RBRACKET
					{
					pushFollow(FOLLOW_ident_in_factor1018);
					ident();
					state._fsp--;

					match(input,LBRACKET,FOLLOW_LBRACKET_in_factor1020); 
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:126:20: ( ident ( COMMA ident )* )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==IDENT) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:126:22: ident ( COMMA ident )*
							{
							pushFollow(FOLLOW_ident_in_factor1024);
							ident();
							state._fsp--;

							// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:126:28: ( COMMA ident )*
							loop12:
							while (true) {
								int alt12=2;
								int LA12_0 = input.LA(1);
								if ( (LA12_0==COMMA) ) {
									alt12=1;
								}

								switch (alt12) {
								case 1 :
									// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:126:30: COMMA ident
									{
									match(input,COMMA,FOLLOW_COMMA_in_factor1028); 
									pushFollow(FOLLOW_ident_in_factor1030);
									ident();
									state._fsp--;

									}
									break;

								default :
									break loop12;
								}
							}

							}
							break;

					}

					match(input,RBRACKET,FOLLOW_RBRACKET_in_factor1038); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "factor"



	// $ANTLR start "character"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:128:1: character : CHARACTER ;
	public final void character() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:129:2: ( CHARACTER )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:129:4: CHARACTER
			{
			match(input,CHARACTER,FOLLOW_CHARACTER_in_character1051); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "character"



	// $ANTLR start "number"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:131:1: number : NUMBER ;
	public final void number() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:132:2: ( NUMBER )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:132:4: NUMBER
			{
			match(input,NUMBER,FOLLOW_NUMBER_in_number1062); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "number"



	// $ANTLR start "stmtlist"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:134:1: stmtlist : ( stmt )* ;
	public final void stmtlist() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:135:2: ( ( stmt )* )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:135:4: ( stmt )*
			{
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:135:4: ( stmt )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= IDENT && LA15_0 <= IF)||LA15_0==LCBRACKET||(LA15_0 >= OUTPUT && LA15_0 <= OUTPUTC)||LA15_0==PRINT||(LA15_0 >= READ && LA15_0 <= RETURN)||LA15_0==WHILE) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:135:4: stmt
					{
					pushFollow(FOLLOW_stmt_in_stmtlist1073);
					stmt();
					state._fsp--;

					}
					break;

				default :
					break loop15;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stmtlist"



	// $ANTLR start "stmt"
	// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:137:1: stmt : ( ( LCBRACKET stmtlist RCBRACKET ) | ( WHILE LBRACKET exp RBRACKET stmt ) | ( IF LBRACKET exp RBRACKET stmt ELSE stmt ) | ( ident EQ lexp SEMICOLON ) | ( READ LBRACKET ident RBRACKET SEMICOLON ) | ( OUTPUT LBRACKET ident RBRACKET SEMICOLON ) | ( PRINT LBRACKET string RBRACKET SEMICOLON ) | ( RETURN ( lexp )? SEMICOLON ) | ( READC LBRACKET ident RBRACKET SEMICOLON ) | ( OUTPUTC LBRACKET ident RBRACKET SEMICOLON ) | ( ident LBRACKET ( ident ( COMMA ident )* )? RBRACKET SEMICOLON ) );
	public final void stmt() throws  {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:138:2: ( ( LCBRACKET stmtlist RCBRACKET ) | ( WHILE LBRACKET exp RBRACKET stmt ) | ( IF LBRACKET exp RBRACKET stmt ELSE stmt ) | ( ident EQ lexp SEMICOLON ) | ( READ LBRACKET ident RBRACKET SEMICOLON ) | ( OUTPUT LBRACKET ident RBRACKET SEMICOLON ) | ( PRINT LBRACKET string RBRACKET SEMICOLON ) | ( RETURN ( lexp )? SEMICOLON ) | ( READC LBRACKET ident RBRACKET SEMICOLON ) | ( OUTPUTC LBRACKET ident RBRACKET SEMICOLON ) | ( ident LBRACKET ( ident ( COMMA ident )* )? RBRACKET SEMICOLON ) )
			int alt19=11;
			switch ( input.LA(1) ) {
			case LCBRACKET:
				{
				alt19=1;
				}
				break;
			case WHILE:
				{
				alt19=2;
				}
				break;
			case IF:
				{
				alt19=3;
				}
				break;
			case IDENT:
				{
				int LA19_4 = input.LA(2);
				if ( (LA19_4==EQ) ) {
					alt19=4;
				}
				else if ( (LA19_4==LBRACKET) ) {
					alt19=11;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 19, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case READ:
				{
				alt19=5;
				}
				break;
			case OUTPUT:
				{
				alt19=6;
				}
				break;
			case PRINT:
				{
				alt19=7;
				}
				break;
			case RETURN:
				{
				alt19=8;
				}
				break;
			case READC:
				{
				alt19=9;
				}
				break;
			case OUTPUTC:
				{
				alt19=10;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:139:3: ( LCBRACKET stmtlist RCBRACKET )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:139:3: ( LCBRACKET stmtlist RCBRACKET )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:139:5: LCBRACKET stmtlist RCBRACKET
					{
					match(input,LCBRACKET,FOLLOW_LCBRACKET_in_stmt1090); 
					pushFollow(FOLLOW_stmtlist_in_stmt1092);
					stmtlist();
					state._fsp--;

					match(input,RCBRACKET,FOLLOW_RCBRACKET_in_stmt1094); 
					}

					}
					break;
				case 2 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:140:3: ( WHILE LBRACKET exp RBRACKET stmt )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:140:3: ( WHILE LBRACKET exp RBRACKET stmt )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:140:5: WHILE LBRACKET exp RBRACKET stmt
					{
					match(input,WHILE,FOLLOW_WHILE_in_stmt1104); 
					match(input,LBRACKET,FOLLOW_LBRACKET_in_stmt1106); 
					pushFollow(FOLLOW_exp_in_stmt1108);
					exp();
					state._fsp--;

					match(input,RBRACKET,FOLLOW_RBRACKET_in_stmt1110); 
					pushFollow(FOLLOW_stmt_in_stmt1112);
					stmt();
					state._fsp--;

					}

					}
					break;
				case 3 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:141:3: ( IF LBRACKET exp RBRACKET stmt ELSE stmt )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:141:3: ( IF LBRACKET exp RBRACKET stmt ELSE stmt )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:141:5: IF LBRACKET exp RBRACKET stmt ELSE stmt
					{
					match(input,IF,FOLLOW_IF_in_stmt1122); 
					match(input,LBRACKET,FOLLOW_LBRACKET_in_stmt1124); 
					pushFollow(FOLLOW_exp_in_stmt1126);
					exp();
					state._fsp--;

					match(input,RBRACKET,FOLLOW_RBRACKET_in_stmt1128); 
					pushFollow(FOLLOW_stmt_in_stmt1130);
					stmt();
					state._fsp--;

					match(input,ELSE,FOLLOW_ELSE_in_stmt1132); 
					pushFollow(FOLLOW_stmt_in_stmt1134);
					stmt();
					state._fsp--;

					}

					}
					break;
				case 4 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:142:3: ( ident EQ lexp SEMICOLON )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:142:3: ( ident EQ lexp SEMICOLON )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:142:5: ident EQ lexp SEMICOLON
					{
					pushFollow(FOLLOW_ident_in_stmt1143);
					ident();
					state._fsp--;

					match(input,EQ,FOLLOW_EQ_in_stmt1145); 
					pushFollow(FOLLOW_lexp_in_stmt1147);
					lexp();
					state._fsp--;

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_stmt1149); 
					}

					}
					break;
				case 5 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:143:3: ( READ LBRACKET ident RBRACKET SEMICOLON )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:143:3: ( READ LBRACKET ident RBRACKET SEMICOLON )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:143:5: READ LBRACKET ident RBRACKET SEMICOLON
					{
					match(input,READ,FOLLOW_READ_in_stmt1159); 
					match(input,LBRACKET,FOLLOW_LBRACKET_in_stmt1161); 
					pushFollow(FOLLOW_ident_in_stmt1163);
					ident();
					state._fsp--;

					match(input,RBRACKET,FOLLOW_RBRACKET_in_stmt1165); 
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_stmt1167); 
					}

					}
					break;
				case 6 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:144:3: ( OUTPUT LBRACKET ident RBRACKET SEMICOLON )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:144:3: ( OUTPUT LBRACKET ident RBRACKET SEMICOLON )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:144:5: OUTPUT LBRACKET ident RBRACKET SEMICOLON
					{
					match(input,OUTPUT,FOLLOW_OUTPUT_in_stmt1177); 
					match(input,LBRACKET,FOLLOW_LBRACKET_in_stmt1179); 
					pushFollow(FOLLOW_ident_in_stmt1181);
					ident();
					state._fsp--;

					match(input,RBRACKET,FOLLOW_RBRACKET_in_stmt1183); 
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_stmt1185); 
					}

					}
					break;
				case 7 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:145:3: ( PRINT LBRACKET string RBRACKET SEMICOLON )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:145:3: ( PRINT LBRACKET string RBRACKET SEMICOLON )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:145:5: PRINT LBRACKET string RBRACKET SEMICOLON
					{
					match(input,PRINT,FOLLOW_PRINT_in_stmt1195); 
					match(input,LBRACKET,FOLLOW_LBRACKET_in_stmt1197); 
					pushFollow(FOLLOW_string_in_stmt1199);
					string();
					state._fsp--;

					match(input,RBRACKET,FOLLOW_RBRACKET_in_stmt1201); 
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_stmt1203); 
					}

					}
					break;
				case 8 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:146:3: ( RETURN ( lexp )? SEMICOLON )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:146:3: ( RETURN ( lexp )? SEMICOLON )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:146:5: RETURN ( lexp )? SEMICOLON
					{
					match(input,RETURN,FOLLOW_RETURN_in_stmt1213); 
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:146:12: ( lexp )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==CHARACTER||LA16_0==IDENT||LA16_0==LBRACKET||LA16_0==MINUS||LA16_0==NUMBER) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:146:12: lexp
							{
							pushFollow(FOLLOW_lexp_in_stmt1215);
							lexp();
							state._fsp--;

							}
							break;

					}

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_stmt1218); 
					}

					}
					break;
				case 9 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:147:3: ( READC LBRACKET ident RBRACKET SEMICOLON )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:147:3: ( READC LBRACKET ident RBRACKET SEMICOLON )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:147:5: READC LBRACKET ident RBRACKET SEMICOLON
					{
					match(input,READC,FOLLOW_READC_in_stmt1228); 
					match(input,LBRACKET,FOLLOW_LBRACKET_in_stmt1230); 
					pushFollow(FOLLOW_ident_in_stmt1232);
					ident();
					state._fsp--;

					match(input,RBRACKET,FOLLOW_RBRACKET_in_stmt1234); 
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_stmt1236); 
					}

					}
					break;
				case 10 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:148:3: ( OUTPUTC LBRACKET ident RBRACKET SEMICOLON )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:148:3: ( OUTPUTC LBRACKET ident RBRACKET SEMICOLON )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:148:5: OUTPUTC LBRACKET ident RBRACKET SEMICOLON
					{
					match(input,OUTPUTC,FOLLOW_OUTPUTC_in_stmt1247); 
					match(input,LBRACKET,FOLLOW_LBRACKET_in_stmt1249); 
					pushFollow(FOLLOW_ident_in_stmt1251);
					ident();
					state._fsp--;

					match(input,RBRACKET,FOLLOW_RBRACKET_in_stmt1253); 
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_stmt1255); 
					}

					}
					break;
				case 11 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:149:3: ( ident LBRACKET ( ident ( COMMA ident )* )? RBRACKET SEMICOLON )
					{
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:149:3: ( ident LBRACKET ( ident ( COMMA ident )* )? RBRACKET SEMICOLON )
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:149:5: ident LBRACKET ( ident ( COMMA ident )* )? RBRACKET SEMICOLON
					{
					pushFollow(FOLLOW_ident_in_stmt1265);
					ident();
					state._fsp--;

					match(input,LBRACKET,FOLLOW_LBRACKET_in_stmt1267); 
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:149:20: ( ident ( COMMA ident )* )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==IDENT) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:149:22: ident ( COMMA ident )*
							{
							pushFollow(FOLLOW_ident_in_stmt1271);
							ident();
							state._fsp--;

							// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:149:28: ( COMMA ident )*
							loop17:
							while (true) {
								int alt17=2;
								int LA17_0 = input.LA(1);
								if ( (LA17_0==COMMA) ) {
									alt17=1;
								}

								switch (alt17) {
								case 1 :
									// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:149:30: COMMA ident
									{
									match(input,COMMA,FOLLOW_COMMA_in_stmt1275); 
									pushFollow(FOLLOW_ident_in_stmt1277);
									ident();
									state._fsp--;

									}
									break;

								default :
									break loop17;
								}
							}

							}
							break;

					}

					match(input,RBRACKET,FOLLOW_RBRACKET_in_stmt1285); 
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_stmt1287); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stmt"

	// Delegated rules



	public static final BitSet FOLLOW_includes_in_program661 = new BitSet(new long[]{0x0000000010240020L});
	public static final BitSet FOLLOW_decls_in_program663 = new BitSet(new long[]{0x0000000010240020L});
	public static final BitSet FOLLOW_procedure_in_program665 = new BitSet(new long[]{0x0000000010240020L});
	public static final BitSet FOLLOW_main_in_program668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INCLUDE_in_includes684 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_string_in_includes686 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_typedident_in_decls702 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_decls704 = new BitSet(new long[]{0x0000000000200022L});
	public static final BitSet FOLLOW_ident_in_procedure731 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACKET_in_procedure733 = new BitSet(new long[]{0x0000008000200020L});
	public static final BitSet FOLLOW_args_in_procedure735 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RBRACKET_in_procedure737 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_body_in_procedure739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_in_main752 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACKET_in_main754 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RBRACKET_in_main756 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_body_in_main758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_string770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LCBRACKET_in_body783 = new BitSet(new long[]{0x00020F58022C0020L});
	public static final BitSet FOLLOW_decls_in_body785 = new BitSet(new long[]{0x00020F58020C0000L});
	public static final BitSet FOLLOW_stmtlist_in_body787 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RCBRACKET_in_body789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_ident801 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_typedident_in_args814 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_COMMA_in_args818 = new BitSet(new long[]{0x0000000000200020L});
	public static final BitSet FOLLOW_typedident_in_args820 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_term_in_lexp837 = new BitSet(new long[]{0x0000002040000002L});
	public static final BitSet FOLLOW_set_in_lexp841 = new BitSet(new long[]{0x0000000441040040L});
	public static final BitSet FOLLOW_term_in_lexp851 = new BitSet(new long[]{0x0000002040000002L});
	public static final BitSet FOLLOW_set_in_typedident865 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ident_in_typedident875 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lexp_in_exp894 = new BitSet(new long[]{0x0000000000C03C02L});
	public static final BitSet FOLLOW_set_in_exp898 = new BitSet(new long[]{0x0000000441040040L});
	public static final BitSet FOLLOW_lexp_in_exp919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_factor_in_term939 = new BitSet(new long[]{0x0000000180008002L});
	public static final BitSet FOLLOW_set_in_term943 = new BitSet(new long[]{0x0000000441040040L});
	public static final BitSet FOLLOW_factor_in_term957 = new BitSet(new long[]{0x0000000180008002L});
	public static final BitSet FOLLOW_LBRACKET_in_factor974 = new BitSet(new long[]{0x0000000441040040L});
	public static final BitSet FOLLOW_lexp_in_factor976 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RBRACKET_in_factor978 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_factor988 = new BitSet(new long[]{0x0000000400040000L});
	public static final BitSet FOLLOW_number_in_factor993 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_factor997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_character_in_factor1008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_factor1018 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACKET_in_factor1020 = new BitSet(new long[]{0x0000008000040000L});
	public static final BitSet FOLLOW_ident_in_factor1024 = new BitSet(new long[]{0x0000008000000100L});
	public static final BitSet FOLLOW_COMMA_in_factor1028 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ident_in_factor1030 = new BitSet(new long[]{0x0000008000000100L});
	public static final BitSet FOLLOW_RBRACKET_in_factor1038 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_character1051 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_number1062 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stmt_in_stmtlist1073 = new BitSet(new long[]{0x00020E58020C0002L});
	public static final BitSet FOLLOW_LCBRACKET_in_stmt1090 = new BitSet(new long[]{0x00020F58020C0000L});
	public static final BitSet FOLLOW_stmtlist_in_stmt1092 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RCBRACKET_in_stmt1094 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_stmt1104 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACKET_in_stmt1106 = new BitSet(new long[]{0x0000000441040040L});
	public static final BitSet FOLLOW_exp_in_stmt1108 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RBRACKET_in_stmt1110 = new BitSet(new long[]{0x00020E58020C0000L});
	public static final BitSet FOLLOW_stmt_in_stmt1112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_stmt1122 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACKET_in_stmt1124 = new BitSet(new long[]{0x0000000441040040L});
	public static final BitSet FOLLOW_exp_in_stmt1126 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RBRACKET_in_stmt1128 = new BitSet(new long[]{0x00020E58020C0000L});
	public static final BitSet FOLLOW_stmt_in_stmt1130 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ELSE_in_stmt1132 = new BitSet(new long[]{0x00020E58020C0000L});
	public static final BitSet FOLLOW_stmt_in_stmt1134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_stmt1143 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_EQ_in_stmt1145 = new BitSet(new long[]{0x0000000441040040L});
	public static final BitSet FOLLOW_lexp_in_stmt1147 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_stmt1149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_READ_in_stmt1159 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACKET_in_stmt1161 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ident_in_stmt1163 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RBRACKET_in_stmt1165 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_stmt1167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OUTPUT_in_stmt1177 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACKET_in_stmt1179 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ident_in_stmt1181 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RBRACKET_in_stmt1183 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_stmt1185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_stmt1195 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACKET_in_stmt1197 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_string_in_stmt1199 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RBRACKET_in_stmt1201 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_stmt1203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_stmt1213 = new BitSet(new long[]{0x0000100441040040L});
	public static final BitSet FOLLOW_lexp_in_stmt1215 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_stmt1218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_READC_in_stmt1228 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACKET_in_stmt1230 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ident_in_stmt1232 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RBRACKET_in_stmt1234 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_stmt1236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OUTPUTC_in_stmt1247 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACKET_in_stmt1249 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ident_in_stmt1251 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RBRACKET_in_stmt1253 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_stmt1255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_stmt1265 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LBRACKET_in_stmt1267 = new BitSet(new long[]{0x0000008000040000L});
	public static final BitSet FOLLOW_ident_in_stmt1271 = new BitSet(new long[]{0x0000008000000100L});
	public static final BitSet FOLLOW_COMMA_in_stmt1275 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ident_in_stmt1277 = new BitSet(new long[]{0x0000008000000100L});
	public static final BitSet FOLLOW_RBRACKET_in_stmt1285 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_stmt1287 = new BitSet(new long[]{0x0000000000000002L});
}
