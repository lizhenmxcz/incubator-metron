// Generated from org/apache/metron/common/query/generated/Predicate.g4 by ANTLR 4.5
package org.apache.metron.common.query.generated;

//CHECKSTYLE:OFF
/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PredicateLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
<<<<<<< HEAD
		AND=1, OR=2, NOT=3, TRUE=4, FALSE=5, EQ=6, NEQ=7, COMMA=8, LBRACKET=9, 
		RBRACKET=10, LPAREN=11, RPAREN=12, IN=13, NIN=14, EXISTS=15, IDENTIFIER=16, 
		STRING_LITERAL=17, SEMI=18, COMMENT=19, WS=20;
=======
		AND=1, OR=2, NOT=3, TRUE=4, FALSE=5, EQ=6, NEQ=7, LT=8, LTE=9, GT=10, 
		GTE=11, COMMA=12, LBRACKET=13, RBRACKET=14, LPAREN=15, RPAREN=16, IN=17, 
		NIN=18, EXISTS=19, INT_LITERAL=20, DOUBLE_LITERAL=21, IDENTIFIER=22, STRING_LITERAL=23, 
		SEMI=24, COMMENT=25, WS=26;
>>>>>>> upstream/master
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
<<<<<<< HEAD
		"AND", "OR", "NOT", "TRUE", "FALSE", "EQ", "NEQ", "COMMA", "LBRACKET", 
		"RBRACKET", "LPAREN", "RPAREN", "IN", "NIN", "EXISTS", "IDENTIFIER", "SCHAR", 
		"STRING_LITERAL", "SEMI", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'=='", "'!='", "','", "'['", "']'", 
		"'('", "')'", "'in'", "'not in'", "'exists'", null, null, "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "OR", "NOT", "TRUE", "FALSE", "EQ", "NEQ", "COMMA", "LBRACKET", 
		"RBRACKET", "LPAREN", "RPAREN", "IN", "NIN", "EXISTS", "IDENTIFIER", "STRING_LITERAL", 
=======
		"AND", "OR", "NOT", "TRUE", "FALSE", "EQ", "NEQ", "LT", "LTE", "GT", "GTE", 
		"COMMA", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "IN", "NIN", "EXISTS", 
		"INT_LITERAL", "DOUBLE_LITERAL", "IDENTIFIER", "SCHAR", "STRING_LITERAL", 
		"SEMI", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'=='", "'!='", "'<'", "'<='", "'>'", 
		"'>='", "','", "'['", "']'", "'('", "')'", "'in'", "'not in'", "'exists'", 
		null, null, null, null, "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "OR", "NOT", "TRUE", "FALSE", "EQ", "NEQ", "LT", "LTE", "GT", 
		"GTE", "COMMA", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "IN", "NIN", 
		"EXISTS", "INT_LITERAL", "DOUBLE_LITERAL", "IDENTIFIER", "STRING_LITERAL", 
>>>>>>> upstream/master
		"SEMI", "COMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PredicateLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Predicate.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
<<<<<<< HEAD
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u00af\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\5\2\66\n\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4F\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5P\n\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\\\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21\u0081"+
		"\n\21\f\21\16\21\u0084\13\21\3\22\3\22\3\23\3\23\7\23\u008a\n\23\f\23"+
		"\16\23\u008d\13\23\3\23\3\23\3\23\7\23\u0092\n\23\f\23\16\23\u0095\13"+
		"\23\3\23\5\23\u0098\n\23\3\24\3\24\3\25\3\25\3\25\3\25\6\25\u00a0\n\25"+
		"\r\25\16\25\u00a1\3\25\5\25\u00a5\n\25\3\25\3\25\3\26\6\26\u00aa\n\26"+
		"\r\26\16\26\u00ab\3\26\3\26\3\u00a1\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\2%\23\'\24)\25+\26"+
		"\3\2\7\5\2C\\aac|\b\2\60\60\62;C\\^^aac|\7\2\f\f\17\17$$))^^\3\3\f\f\5"+
		"\2\13\f\16\17\"\"\u00ba\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3\65\3\2"+
		"\2\2\5=\3\2\2\2\7E\3\2\2\2\tO\3\2\2\2\13[\3\2\2\2\r]\3\2\2\2\17`\3\2\2"+
		"\2\21c\3\2\2\2\23e\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33m\3\2"+
		"\2\2\35p\3\2\2\2\37w\3\2\2\2!~\3\2\2\2#\u0085\3\2\2\2%\u0097\3\2\2\2\'"+
		"\u0099\3\2\2\2)\u009b\3\2\2\2+\u00a9\3\2\2\2-.\7c\2\2./\7p\2\2/\66\7f"+
		"\2\2\60\61\7(\2\2\61\66\7(\2\2\62\63\7C\2\2\63\64\7P\2\2\64\66\7F\2\2"+
		"\65-\3\2\2\2\65\60\3\2\2\2\65\62\3\2\2\2\66\4\3\2\2\2\678\7q\2\28>\7t"+
		"\2\29:\7~\2\2:>\7~\2\2;<\7Q\2\2<>\7T\2\2=\67\3\2\2\2=9\3\2\2\2=;\3\2\2"+
		"\2>\6\3\2\2\2?@\7p\2\2@A\7q\2\2AF\7v\2\2BC\7P\2\2CD\7Q\2\2DF\7V\2\2E?"+
		"\3\2\2\2EB\3\2\2\2F\b\3\2\2\2GH\7v\2\2HI\7t\2\2IJ\7w\2\2JP\7g\2\2KL\7"+
		"V\2\2LM\7T\2\2MN\7W\2\2NP\7G\2\2OG\3\2\2\2OK\3\2\2\2P\n\3\2\2\2QR\7h\2"+
		"\2RS\7c\2\2ST\7n\2\2TU\7u\2\2U\\\7g\2\2VW\7H\2\2WX\7C\2\2XY\7N\2\2YZ\7"+
		"U\2\2Z\\\7G\2\2[Q\3\2\2\2[V\3\2\2\2\\\f\3\2\2\2]^\7?\2\2^_\7?\2\2_\16"+
		"\3\2\2\2`a\7#\2\2ab\7?\2\2b\20\3\2\2\2cd\7.\2\2d\22\3\2\2\2ef\7]\2\2f"+
		"\24\3\2\2\2gh\7_\2\2h\26\3\2\2\2ij\7*\2\2j\30\3\2\2\2kl\7+\2\2l\32\3\2"+
		"\2\2mn\7k\2\2no\7p\2\2o\34\3\2\2\2pq\7p\2\2qr\7q\2\2rs\7v\2\2st\7\"\2"+
		"\2tu\7k\2\2uv\7p\2\2v\36\3\2\2\2wx\7g\2\2xy\7z\2\2yz\7k\2\2z{\7u\2\2{"+
		"|\7v\2\2|}\7u\2\2} \3\2\2\2~\u0082\t\2\2\2\177\u0081\t\3\2\2\u0080\177"+
		"\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\"\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\n\4\2\2\u0086$\3\2\2\2\u0087"+
		"\u008b\7$\2\2\u0088\u008a\5#\22\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2"+
		"\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\u0098\7$\2\2\u008f\u0093\7)\2\2\u0090\u0092\5#\22"+
		"\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094"+
		"\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0098\7)\2\2\u0097"+
		"\u0087\3\2\2\2\u0097\u008f\3\2\2\2\u0098&\3\2\2\2\u0099\u009a\7=\2\2\u009a"+
		"(\3\2\2\2\u009b\u009c\7\61\2\2\u009c\u009d\7\61\2\2\u009d\u009f\3\2\2"+
		"\2\u009e\u00a0\13\2\2\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a5\t\5"+
		"\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\b\25\2\2\u00a7"+
		"*\3\2\2\2\u00a8\u00aa\t\6\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2"+
		"\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae"+
		"\b\26\2\2\u00ae,\3\2\2\2\17\2\65=EO[\u0082\u008b\u0093\u0097\u00a1\u00a4"+
		"\u00ab\3\b\2\2";
=======
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u00d5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5"+
		"\2B\n\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3J\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4R"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\\\n\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6h\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\6\25\u0096\n\25\r\25\16\25\u0097\3\26\6\26\u009b"+
		"\n\26\r\26\16\26\u009c\3\26\3\26\6\26\u00a1\n\26\r\26\16\26\u00a2\3\27"+
		"\3\27\7\27\u00a7\n\27\f\27\16\27\u00aa\13\27\3\30\3\30\3\31\3\31\7\31"+
		"\u00b0\n\31\f\31\16\31\u00b3\13\31\3\31\3\31\3\31\7\31\u00b8\n\31\f\31"+
		"\16\31\u00bb\13\31\3\31\5\31\u00be\n\31\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\6\33\u00c6\n\33\r\33\16\33\u00c7\3\33\5\33\u00cb\n\33\3\33\3\33\3\34"+
		"\6\34\u00d0\n\34\r\34\16\34\u00d1\3\34\3\34\3\u00c7\2\35\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\2\61\31\63\32\65\33\67\34\3\2\7\5\2C\\aac|\b\2"+
		"\60\60\62;C\\^^aac|\7\2\f\f\17\17$$))^^\3\3\f\f\5\2\13\f\16\17\"\"\u00e3"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\3A\3\2\2\2\5I\3\2\2\2\7Q\3"+
		"\2\2\2\t[\3\2\2\2\13g\3\2\2\2\ri\3\2\2\2\17l\3\2\2\2\21o\3\2\2\2\23q\3"+
		"\2\2\2\25t\3\2\2\2\27v\3\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35}\3\2\2\2\37"+
		"\177\3\2\2\2!\u0081\3\2\2\2#\u0083\3\2\2\2%\u0086\3\2\2\2\'\u008d\3\2"+
		"\2\2)\u0095\3\2\2\2+\u009a\3\2\2\2-\u00a4\3\2\2\2/\u00ab\3\2\2\2\61\u00bd"+
		"\3\2\2\2\63\u00bf\3\2\2\2\65\u00c1\3\2\2\2\67\u00cf\3\2\2\29:\7c\2\2:"+
		";\7p\2\2;B\7f\2\2<=\7(\2\2=B\7(\2\2>?\7C\2\2?@\7P\2\2@B\7F\2\2A9\3\2\2"+
		"\2A<\3\2\2\2A>\3\2\2\2B\4\3\2\2\2CD\7q\2\2DJ\7t\2\2EF\7~\2\2FJ\7~\2\2"+
		"GH\7Q\2\2HJ\7T\2\2IC\3\2\2\2IE\3\2\2\2IG\3\2\2\2J\6\3\2\2\2KL\7p\2\2L"+
		"M\7q\2\2MR\7v\2\2NO\7P\2\2OP\7Q\2\2PR\7V\2\2QK\3\2\2\2QN\3\2\2\2R\b\3"+
		"\2\2\2ST\7v\2\2TU\7t\2\2UV\7w\2\2V\\\7g\2\2WX\7V\2\2XY\7T\2\2YZ\7W\2\2"+
		"Z\\\7G\2\2[S\3\2\2\2[W\3\2\2\2\\\n\3\2\2\2]^\7h\2\2^_\7c\2\2_`\7n\2\2"+
		"`a\7u\2\2ah\7g\2\2bc\7H\2\2cd\7C\2\2de\7N\2\2ef\7U\2\2fh\7G\2\2g]\3\2"+
		"\2\2gb\3\2\2\2h\f\3\2\2\2ij\7?\2\2jk\7?\2\2k\16\3\2\2\2lm\7#\2\2mn\7?"+
		"\2\2n\20\3\2\2\2op\7>\2\2p\22\3\2\2\2qr\7>\2\2rs\7?\2\2s\24\3\2\2\2tu"+
		"\7@\2\2u\26\3\2\2\2vw\7@\2\2wx\7?\2\2x\30\3\2\2\2yz\7.\2\2z\32\3\2\2\2"+
		"{|\7]\2\2|\34\3\2\2\2}~\7_\2\2~\36\3\2\2\2\177\u0080\7*\2\2\u0080 \3\2"+
		"\2\2\u0081\u0082\7+\2\2\u0082\"\3\2\2\2\u0083\u0084\7k\2\2\u0084\u0085"+
		"\7p\2\2\u0085$\3\2\2\2\u0086\u0087\7p\2\2\u0087\u0088\7q\2\2\u0088\u0089"+
		"\7v\2\2\u0089\u008a\7\"\2\2\u008a\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c"+
		"&\3\2\2\2\u008d\u008e\7g\2\2\u008e\u008f\7z\2\2\u008f\u0090\7k\2\2\u0090"+
		"\u0091\7u\2\2\u0091\u0092\7v\2\2\u0092\u0093\7u\2\2\u0093(\3\2\2\2\u0094"+
		"\u0096\4\62;\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0097\u0098\3\2\2\2\u0098*\3\2\2\2\u0099\u009b\4\62;\2\u009a\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u00a0\7\60\2\2\u009f\u00a1\4\62;\2\u00a0\u009f\3"+
		"\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		",\3\2\2\2\u00a4\u00a8\t\2\2\2\u00a5\u00a7\t\3\2\2\u00a6\u00a5\3\2\2\2"+
		"\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9.\3"+
		"\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\n\4\2\2\u00ac\60\3\2\2\2\u00ad"+
		"\u00b1\7$\2\2\u00ae\u00b0\5/\30\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2"+
		"\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00be\7$\2\2\u00b5\u00b9\7)\2\2\u00b6\u00b8\5/\30"+
		"\2\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be\7)\2\2\u00bd"+
		"\u00ad\3\2\2\2\u00bd\u00b5\3\2\2\2\u00be\62\3\2\2\2\u00bf\u00c0\7=\2\2"+
		"\u00c0\64\3\2\2\2\u00c1\u00c2\7\61\2\2\u00c2\u00c3\7\61\2\2\u00c3\u00c5"+
		"\3\2\2\2\u00c4\u00c6\13\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2"+
		"\u00c7\u00c8\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00cb"+
		"\t\5\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\b\33\2\2"+
		"\u00cd\66\3\2\2\2\u00ce\u00d0\t\6\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\b\34\2\2\u00d48\3\2\2\2\22\2AIQ[g\u0097\u009c\u00a2\u00a8\u00b1"+
		"\u00b9\u00bd\u00c7\u00ca\u00d1\3\b\2\2";
>>>>>>> upstream/master
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}