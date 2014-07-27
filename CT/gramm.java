import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.TokenRewriteStream;

ANTLRFileStream fs = new ANTLRFileStream("test.html");
HtmlDocLexer lex = new HtmlDocLexer(fs);
TokenRewriteStream tokens = new TokenRewriteStream(lex);
HtmlDoc grammar = new HtmlDoc(tokens);
static final TreeAdaptor adaptor = new CommonTreeAdaptor() {
	public Object create(Token payload) {
		return new CommonTree(payload);
	}
};
grammar.setTreeAdaptor(adaptor);
HtmlDoc.html_doc_return ret = grammar.html_doc();
CommonTree tree = (CommonTree)ret.getTree();
public void gramm(CommonTree t, int indent) {
	if ( t != null ) {
		StringBuffer sb = new StringBuffer(indent);
		
		if (t.getParent() == null){
			System.out.println(sb.toString() + t.getText().toString());	
		}
		for ( int i = 0; i < indent; i++ )
			sb = sb.append("   ");
		for ( int i = 0; i < t.getChildCount(); i++ ) {
			System.out.println(sb.toString() + t.getChild(i).toString());
			printTree((CommonTree)t.getChild(i), indent+1);
		}
	}
}
