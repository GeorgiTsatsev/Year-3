// $ANTLR 3.5 /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g 2013-02-15 04:46:28

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class antlrgrammaLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public antlrgrammaLexer() {} 
	public antlrgrammaLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public antlrgrammaLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g"; }

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:2:6: ( 'char' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:2:8: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:3:7: ( ',' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:3:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "COMPLEFT"
	public final void mCOMPLEFT() throws RecognitionException {
		try {
			int _type = COMPLEFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:4:10: ( '<' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:4:12: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMPLEFT"

	// $ANTLR start "COMPLEFTEQ"
	public final void mCOMPLEFTEQ() throws RecognitionException {
		try {
			int _type = COMPLEFTEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:5:12: ( '<=' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:5:14: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMPLEFTEQ"

	// $ANTLR start "COMPRIGHT"
	public final void mCOMPRIGHT() throws RecognitionException {
		try {
			int _type = COMPRIGHT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:6:11: ( '>' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:6:13: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMPRIGHT"

	// $ANTLR start "COMPRIGHTEQ"
	public final void mCOMPRIGHTEQ() throws RecognitionException {
		try {
			int _type = COMPRIGHTEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:7:13: ( '>=' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:7:15: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMPRIGHTEQ"

	// $ANTLR start "DIVIDE"
	public final void mDIVIDE() throws RecognitionException {
		try {
			int _type = DIVIDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:8:8: ( '/' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:8:10: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIVIDE"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:9:6: ( 'else' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:9:8: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:10:4: ( '=' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:10:6: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:11:4: ( 'if' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:11:6: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "INCLUDE"
	public final void mINCLUDE() throws RecognitionException {
		try {
			int _type = INCLUDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:12:9: ( '#include' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:12:11: '#include'
			{
			match("#include"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INCLUDE"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:13:5: ( 'int' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:13:7: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "ISEQ"
	public final void mISEQ() throws RecognitionException {
		try {
			int _type = ISEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:14:6: ( '==' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:14:8: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ISEQ"

	// $ANTLR start "ISNOTEQ"
	public final void mISNOTEQ() throws RecognitionException {
		try {
			int _type = ISNOTEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:15:9: ( '!=' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:15:11: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ISNOTEQ"

	// $ANTLR start "LBRACKET"
	public final void mLBRACKET() throws RecognitionException {
		try {
			int _type = LBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:16:10: ( '(' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:16:12: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LBRACKET"

	// $ANTLR start "LCBRACKET"
	public final void mLCBRACKET() throws RecognitionException {
		try {
			int _type = LCBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:17:11: ( '{' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:17:13: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LCBRACKET"

	// $ANTLR start "LQUOTE"
	public final void mLQUOTE() throws RecognitionException {
		try {
			int _type = LQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:18:8: ( '\\\"' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:18:10: '\\\"'
			{
			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LQUOTE"

	// $ANTLR start "MAIN"
	public final void mMAIN() throws RecognitionException {
		try {
			int _type = MAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:19:6: ( 'main' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:19:8: 'main'
			{
			match("main"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAIN"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:20:7: ( '-' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:20:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:21:5: ( '%' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:21:7: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOD"

	// $ANTLR start "MULTIPLY"
	public final void mMULTIPLY() throws RecognitionException {
		try {
			int _type = MULTIPLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:22:10: ( '*' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:22:12: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTIPLY"

	// $ANTLR start "OUTPUT"
	public final void mOUTPUT() throws RecognitionException {
		try {
			int _type = OUTPUT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:23:8: ( 'output' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:23:10: 'output'
			{
			match("output"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUTPUT"

	// $ANTLR start "OUTPUTC"
	public final void mOUTPUTC() throws RecognitionException {
		try {
			int _type = OUTPUTC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:24:9: ( 'outputc' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:24:11: 'outputc'
			{
			match("outputc"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUTPUTC"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:25:6: ( '+' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:25:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:26:7: ( 'print' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:26:9: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "RBRACKET"
	public final void mRBRACKET() throws RecognitionException {
		try {
			int _type = RBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:27:10: ( ')' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:27:12: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RBRACKET"

	// $ANTLR start "RCBRACKET"
	public final void mRCBRACKET() throws RecognitionException {
		try {
			int _type = RCBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:28:11: ( '}' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:28:13: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RCBRACKET"

	// $ANTLR start "READ"
	public final void mREAD() throws RecognitionException {
		try {
			int _type = READ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:29:6: ( 'read' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:29:8: 'read'
			{
			match("read"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "READ"

	// $ANTLR start "READC"
	public final void mREADC() throws RecognitionException {
		try {
			int _type = READC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:30:7: ( 'readc' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:30:9: 'readc'
			{
			match("readc"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "READC"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:31:8: ( 'return' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:31:10: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:32:11: ( ';' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:32:13: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "SQUOTE"
	public final void mSQUOTE() throws RecognitionException {
		try {
			int _type = SQUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:33:8: ( '\\'' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:33:10: '\\''
			{
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SQUOTE"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:34:7: ( 'while' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:34:9: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "LLETTER"
	public final void mLLETTER() throws RecognitionException {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:43:18: ( 'a' .. 'z' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:
			{
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LLETTER"

	// $ANTLR start "ULETTER"
	public final void mULETTER() throws RecognitionException {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:45:18: ( 'A' .. 'Z' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ULETTER"

	// $ANTLR start "ALPHA"
	public final void mALPHA() throws RecognitionException {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:47:16: ( ( LLETTER | ULETTER ) )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALPHA"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:49:16: ( '0' .. '9' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "USCORE"
	public final void mUSCORE() throws RecognitionException {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:51:17: ( '_' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:51:19: '_'
			{
			match('_'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "USCORE"

	// $ANTLR start "NACHAR"
	public final void mNACHAR() throws RecognitionException {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:53:17: ( ( '`' | '~' | '!' | '@' | '#' | '$' | '^' | '&' | '|' | '\\\\' | ':' | '.' | '?' ) )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:
			{
			if ( input.LA(1)=='!'||(input.LA(1) >= '#' && input.LA(1) <= '$')||input.LA(1)=='&'||input.LA(1)=='.'||input.LA(1)==':'||(input.LA(1) >= '?' && input.LA(1) <= '@')||input.LA(1)=='\\'||input.LA(1)=='^'||input.LA(1)=='`'||input.LA(1)=='|'||input.LA(1)=='~' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NACHAR"

	// $ANTLR start "CHARR"
	public final void mCHARR() throws RecognitionException {
		try {
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:54:16: ( ( ALPHA | DIGIT | NACHAR | ' ' | '\\n' | '\\t' | EOF ) )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:54:18: ( ALPHA | DIGIT | NACHAR | ' ' | '\\n' | '\\t' | EOF )
			{
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:54:18: ( ALPHA | DIGIT | NACHAR | ' ' | '\\n' | '\\t' | EOF )
			int alt1=7;
			switch ( input.LA(1) ) {
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case 'H':
			case 'I':
			case 'J':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z':
				{
				alt1=1;
				}
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				{
				alt1=2;
				}
				break;
			case '!':
			case '#':
			case '$':
			case '&':
			case '.':
			case ':':
			case '?':
			case '@':
			case '\\':
			case '^':
			case '`':
			case '|':
			case '~':
				{
				alt1=3;
				}
				break;
			case ' ':
				{
				alt1=4;
				}
				break;
			case '\n':
				{
				alt1=5;
				}
				break;
			case '\t':
				{
				alt1=6;
				}
				break;
			default:
				alt1=7;
			}
			switch (alt1) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:54:20: ALPHA
					{
					mALPHA(); 

					}
					break;
				case 2 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:54:28: DIGIT
					{
					mDIGIT(); 

					}
					break;
				case 3 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:54:36: NACHAR
					{
					mNACHAR(); 

					}
					break;
				case 4 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:54:45: ' '
					{
					match(' '); 
					}
					break;
				case 5 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:54:51: '\\n'
					{
					match('\n'); 
					}
					break;
				case 6 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:54:58: '\\t'
					{
					match('\t'); 
					}
					break;
				case 7 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:54:65: EOF
					{
					match(EOF); 

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHARR"

	// $ANTLR start "IDENT"
	public final void mIDENT() throws RecognitionException {
		try {
			int _type = IDENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:58:7: ( ( ALPHA ( ALPHA | DIGIT | USCORE )* ) )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:58:9: ( ALPHA ( ALPHA | DIGIT | USCORE )* )
			{
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:58:9: ( ALPHA ( ALPHA | DIGIT | USCORE )* )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:58:11: ALPHA ( ALPHA | DIGIT | USCORE )*
			{
			mALPHA(); 

			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:58:17: ( ALPHA | DIGIT | USCORE )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENT"

	// $ANTLR start "CHARACTER"
	public final void mCHARACTER() throws RecognitionException {
		try {
			int _type = CHARACTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:60:11: ( SQUOTE CHARR SQUOTE )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:60:13: SQUOTE CHARR SQUOTE
			{
			mSQUOTE(); 

			mCHARR(); 

			mSQUOTE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHARACTER"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:62:8: ( LQUOTE ( ALPHA | DIGIT | '.' )* LQUOTE )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:62:10: LQUOTE ( ALPHA | DIGIT | '.' )* LQUOTE
			{
			mLQUOTE(); 

			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:62:17: ( ALPHA | DIGIT | '.' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='.'||(LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:
					{
					if ( input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			mLQUOTE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:64:8: ( '1' .. '9' ( DIGIT )* )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:64:10: '1' .. '9' ( DIGIT )*
			{
			matchRange('1','9'); 
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:64:19: ( DIGIT )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:66:4: ( ( ' ' | '\\t' | '\\s' | '\\r' | '\\n' )+ )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:66:6: ( ' ' | '\\t' | '\\s' | '\\r' | '\\n' )+
			{
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:66:6: ( ' ' | '\\t' | '\\s' | '\\r' | '\\n' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' '||LA5_0=='s') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' '||input.LA(1)=='s' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:68:9: ( '//' ( . ~ '\\n' )* )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:68:11: '//' ( . ~ '\\n' )*
			{
			match("//"); 

			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:68:16: ( . ~ '\\n' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\uFFFF')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:68:18: . ~ '\\n'
					{
					matchAny(); 
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop6;
				}
			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "MCOMMENT"
	public final void mMCOMMENT() throws RecognitionException {
		try {
			int _type = MCOMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:70:10: ( '/*' ( . )* '*/' )
			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:70:12: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:70:17: ( . )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='*') ) {
					int LA7_1 = input.LA(2);
					if ( (LA7_1=='/') ) {
						alt7=2;
					}
					else if ( ((LA7_1 >= '\u0000' && LA7_1 <= '.')||(LA7_1 >= '0' && LA7_1 <= '\uFFFF')) ) {
						alt7=1;
					}

				}
				else if ( ((LA7_0 >= '\u0000' && LA7_0 <= ')')||(LA7_0 >= '+' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:70:17: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop7;
				}
			}

			match("*/"); 

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MCOMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:8: ( CHAR | COMMA | COMPLEFT | COMPLEFTEQ | COMPRIGHT | COMPRIGHTEQ | DIVIDE | ELSE | EQ | IF | INCLUDE | INT | ISEQ | ISNOTEQ | LBRACKET | LCBRACKET | LQUOTE | MAIN | MINUS | MOD | MULTIPLY | OUTPUT | OUTPUTC | PLUS | PRINT | RBRACKET | RCBRACKET | READ | READC | RETURN | SEMICOLON | SQUOTE | WHILE | IDENT | CHARACTER | STRING | NUMBER | WS | COMMENT | MCOMMENT )
		int alt8=40;
		alt8 = dfa8.predict(input);
		switch (alt8) {
			case 1 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:10: CHAR
				{
				mCHAR(); 

				}
				break;
			case 2 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:15: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 3 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:21: COMPLEFT
				{
				mCOMPLEFT(); 

				}
				break;
			case 4 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:30: COMPLEFTEQ
				{
				mCOMPLEFTEQ(); 

				}
				break;
			case 5 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:41: COMPRIGHT
				{
				mCOMPRIGHT(); 

				}
				break;
			case 6 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:51: COMPRIGHTEQ
				{
				mCOMPRIGHTEQ(); 

				}
				break;
			case 7 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:63: DIVIDE
				{
				mDIVIDE(); 

				}
				break;
			case 8 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:70: ELSE
				{
				mELSE(); 

				}
				break;
			case 9 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:75: EQ
				{
				mEQ(); 

				}
				break;
			case 10 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:78: IF
				{
				mIF(); 

				}
				break;
			case 11 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:81: INCLUDE
				{
				mINCLUDE(); 

				}
				break;
			case 12 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:89: INT
				{
				mINT(); 

				}
				break;
			case 13 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:93: ISEQ
				{
				mISEQ(); 

				}
				break;
			case 14 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:98: ISNOTEQ
				{
				mISNOTEQ(); 

				}
				break;
			case 15 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:106: LBRACKET
				{
				mLBRACKET(); 

				}
				break;
			case 16 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:115: LCBRACKET
				{
				mLCBRACKET(); 

				}
				break;
			case 17 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:125: LQUOTE
				{
				mLQUOTE(); 

				}
				break;
			case 18 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:132: MAIN
				{
				mMAIN(); 

				}
				break;
			case 19 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:137: MINUS
				{
				mMINUS(); 

				}
				break;
			case 20 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:143: MOD
				{
				mMOD(); 

				}
				break;
			case 21 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:147: MULTIPLY
				{
				mMULTIPLY(); 

				}
				break;
			case 22 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:156: OUTPUT
				{
				mOUTPUT(); 

				}
				break;
			case 23 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:163: OUTPUTC
				{
				mOUTPUTC(); 

				}
				break;
			case 24 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:171: PLUS
				{
				mPLUS(); 

				}
				break;
			case 25 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:176: PRINT
				{
				mPRINT(); 

				}
				break;
			case 26 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:182: RBRACKET
				{
				mRBRACKET(); 

				}
				break;
			case 27 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:191: RCBRACKET
				{
				mRCBRACKET(); 

				}
				break;
			case 28 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:201: READ
				{
				mREAD(); 

				}
				break;
			case 29 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:206: READC
				{
				mREADC(); 

				}
				break;
			case 30 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:212: RETURN
				{
				mRETURN(); 

				}
				break;
			case 31 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:219: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 32 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:229: SQUOTE
				{
				mSQUOTE(); 

				}
				break;
			case 33 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:236: WHILE
				{
				mWHILE(); 

				}
				break;
			case 34 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:242: IDENT
				{
				mIDENT(); 

				}
				break;
			case 35 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:248: CHARACTER
				{
				mCHARACTER(); 

				}
				break;
			case 36 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:258: STRING
				{
				mSTRING(); 

				}
				break;
			case 37 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:265: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 38 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:272: WS
				{
				mWS(); 

				}
				break;
			case 39 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:275: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 40 :
				// /afs/inf.ed.ac.uk/user/s10/s1045049/antlrgramma.g:1:283: MCOMMENT
				{
				mMCOMMENT(); 

				}
				break;

		}
	}


	protected DFA8 dfa8 = new DFA8(this);
	static final String DFA8_eotS =
		"\1\uffff\1\35\1\uffff\1\41\1\43\1\46\1\35\1\51\1\35\4\uffff\1\54\1\35"+
		"\3\uffff\1\35\1\uffff\1\35\2\uffff\1\35\1\uffff\1\62\2\35\3\uffff\1\35"+
		"\7\uffff\1\35\2\uffff\1\70\1\35\2\uffff\4\35\2\uffff\4\35\1\uffff\1\102"+
		"\6\35\1\111\1\112\1\uffff\1\113\2\35\1\117\2\35\3\uffff\1\35\1\123\1\124"+
		"\1\uffff\1\35\1\126\1\130\2\uffff\1\131\1\uffff\1\132\3\uffff";
	static final String DFA8_eofS =
		"\133\uffff";
	static final String DFA8_minS =
		"\1\11\1\150\1\uffff\2\75\1\52\1\154\1\75\1\146\4\uffff\1\42\1\141\3\uffff"+
		"\1\165\1\uffff\1\162\2\uffff\1\145\1\uffff\1\11\1\150\1\11\3\uffff\1\141"+
		"\7\uffff\1\163\2\uffff\1\60\1\164\2\uffff\1\151\1\164\1\151\1\141\2\uffff"+
		"\1\151\1\11\1\162\1\145\1\uffff\1\60\1\156\1\160\1\156\1\144\1\165\1\154"+
		"\2\60\1\uffff\1\60\1\165\1\164\1\60\1\162\1\145\3\uffff\1\164\2\60\1\uffff"+
		"\1\156\2\60\2\uffff\1\60\1\uffff\1\60\3\uffff";
	static final String DFA8_maxS =
		"\1\175\1\150\1\uffff\2\75\1\57\1\154\1\75\1\156\4\uffff\1\172\1\141\3"+
		"\uffff\1\165\1\uffff\1\162\2\uffff\1\145\1\uffff\1\176\1\150\1\163\3\uffff"+
		"\1\141\7\uffff\1\163\2\uffff\1\172\1\164\2\uffff\1\151\1\164\1\151\1\164"+
		"\2\uffff\1\151\1\163\1\162\1\145\1\uffff\1\172\1\156\1\160\1\156\1\144"+
		"\1\165\1\154\2\172\1\uffff\1\172\1\165\1\164\1\172\1\162\1\145\3\uffff"+
		"\1\164\2\172\1\uffff\1\156\2\172\2\uffff\1\172\1\uffff\1\172\3\uffff";
	static final String DFA8_acceptS =
		"\2\uffff\1\2\6\uffff\1\13\1\16\1\17\1\20\2\uffff\1\23\1\24\1\25\1\uffff"+
		"\1\30\1\uffff\1\32\1\33\1\uffff\1\37\3\uffff\1\45\1\42\1\46\1\uffff\1"+
		"\4\1\3\1\6\1\5\1\47\1\50\1\7\1\uffff\1\15\1\11\2\uffff\1\21\1\44\4\uffff"+
		"\1\40\1\43\4\uffff\1\12\11\uffff\1\14\6\uffff\1\1\1\10\1\22\3\uffff\1"+
		"\34\3\uffff\1\31\1\35\1\uffff\1\41\1\uffff\1\26\1\36\1\27";
	static final String DFA8_specialS =
		"\133\uffff}>";
	static final String[] DFA8_transitionS = {
			"\2\36\2\uffff\1\36\22\uffff\1\36\1\12\1\15\1\11\1\uffff\1\20\1\uffff"+
			"\1\31\1\13\1\25\1\21\1\23\1\2\1\17\1\uffff\1\5\1\uffff\11\34\1\uffff"+
			"\1\30\1\3\1\7\1\4\2\uffff\32\35\6\uffff\2\35\1\1\1\35\1\6\3\35\1\10\3"+
			"\35\1\16\1\35\1\22\1\24\1\35\1\27\1\33\3\35\1\32\3\35\1\14\1\uffff\1"+
			"\26",
			"\1\37",
			"",
			"\1\40",
			"\1\42",
			"\1\45\4\uffff\1\44",
			"\1\47",
			"\1\50",
			"\1\52\7\uffff\1\53",
			"",
			"",
			"",
			"",
			"\1\55\13\uffff\1\55\1\uffff\12\55\7\uffff\32\55\6\uffff\32\55",
			"\1\56",
			"",
			"",
			"",
			"\1\57",
			"",
			"\1\60",
			"",
			"",
			"\1\61",
			"",
			"\2\63\25\uffff\2\63\1\uffff\2\63\1\uffff\2\63\6\uffff\1\63\1\uffff\13"+
			"\63\4\uffff\34\63\1\uffff\1\63\1\uffff\1\63\1\uffff\33\63\1\uffff\1\63"+
			"\1\uffff\1\63",
			"\1\64",
			"\2\36\2\uffff\1\36\22\uffff\1\36\122\uffff\1\65",
			"",
			"",
			"",
			"\1\66",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\67",
			"",
			"",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\1\71",
			"",
			"",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75\22\uffff\1\76",
			"",
			"",
			"\1\77",
			"\2\36\2\uffff\1\36\22\uffff\1\36\122\uffff\1\65",
			"\1\100",
			"\1\101",
			"",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\1\114",
			"\1\115",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\2\35\1\116\27\35",
			"\1\120",
			"\1\121",
			"",
			"",
			"",
			"\1\122",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"",
			"\1\125",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\2\35\1\127\27\35",
			"",
			"",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"",
			"",
			""
	};

	static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
	static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
	static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
	static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
	static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
	static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
	static final short[][] DFA8_transition;

	static {
		int numStates = DFA8_transitionS.length;
		DFA8_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
		}
	}

	protected class DFA8 extends DFA {

		public DFA8(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 8;
			this.eot = DFA8_eot;
			this.eof = DFA8_eof;
			this.min = DFA8_min;
			this.max = DFA8_max;
			this.accept = DFA8_accept;
			this.special = DFA8_special;
			this.transition = DFA8_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( CHAR | COMMA | COMPLEFT | COMPLEFTEQ | COMPRIGHT | COMPRIGHTEQ | DIVIDE | ELSE | EQ | IF | INCLUDE | INT | ISEQ | ISNOTEQ | LBRACKET | LCBRACKET | LQUOTE | MAIN | MINUS | MOD | MULTIPLY | OUTPUT | OUTPUTC | PLUS | PRINT | RBRACKET | RCBRACKET | READ | READC | RETURN | SEMICOLON | SQUOTE | WHILE | IDENT | CHARACTER | STRING | NUMBER | WS | COMMENT | MCOMMENT );";
		}
	}

}
