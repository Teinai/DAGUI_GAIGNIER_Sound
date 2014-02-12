
%%
   
%package calculator
%class Lexer
%line
%column
%cup

%%

[ \t\f]					{ }
[ \r\n|\r|\n]			{ }
   
[0-9]+					{ System.out.println(yytext()); 
						return getSymbolFactory().newSymbol ("INTEGER", Sym.INTEGER, new Integer(yytext())); }
[0-9]+\.[0-9]*			{ System.out.println(yytext());
return getSymbolFactory().newSymbol ("FLOAT", Sym.FLOAT, new Float(yytext())); }
DO						{ System.out.println(yytext());
						return getSymbolFactory().newSymbol ("DO", Sym.DO); }

DOD						{ System.out.println(yytext());
return getSymbolFactory().newSymbol ("DOD", Sym.DOD); }
REB						{ System.out.println(yytext());
return getSymbolFactory().newSymbol ("REB", Sym.REB); }
RE						{ System.out.println(yytext());
return getSymbolFactory().newSymbol ("RE", Sym.RE); }
RED						{ return getSymbolFactory().newSymbol ("RED", Sym.RED); }
MIB						{ return getSymbolFactory().newSymbol ("MIB", Sym.MIB); }
MI						{ System.out.println(yytext());
return getSymbolFactory().newSymbol ("MI", Sym.MI); }
FA						{ return getSymbolFactory().newSymbol ("FA", Sym.FA); }
FAD						{ return getSymbolFactory().newSymbol ("FAD", Sym.FAD); }
SOLB					{ return getSymbolFactory().newSymbol ("SOLB", Sym.SOLB); }
SOL						{ return getSymbolFactory().newSymbol ("SOL", Sym.SOL); }
SOLD					{ return getSymbolFactory().newSymbol ("SOLD", Sym.SOLD); }
LAB						{ return getSymbolFactory().newSymbol ("LAB", Sym.LAB); }
LA						{ return getSymbolFactory().newSymbol ("LA", Sym.LA); }
LAD						{ return getSymbolFactory().newSymbol ("LAD", Sym.LAD); }
SIB						{ return getSymbolFactory().newSymbol ("SIB", Sym.SIB); }
SI						{ return getSymbolFactory().newSymbol ("SI", Sym.SI); }
SILENCE					{ return getSymbolFactory().newSymbol ("SILENCE", Sym.SILENCE); }

PLAY|Play|play					{ System.out.println(yytext());
return getSymbolFactory().newSymbol ("PLAY", Sym.PLAY); }
BEGIN					{ System.out.println(yytext());
return getSymbolFactory().newSymbol ("BEGIN", Sym.BEGIN); }
END						{ System.out.println(yytext());
return getSymbolFactory().newSymbol ("END", Sym.END); }
","					{ return getSymbolFactory().newSymbol ("COMMA", Sym.COMMA); }

[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
