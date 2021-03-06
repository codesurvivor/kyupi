/* Generated By:JavaCC: Do not edit this line. VerilogConstants.java */
package org.kyupi.graph.parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface VerilogConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int COMMENT = 5;
  /** RegularExpression Id. */
  int MODULE = 6;
  /** RegularExpression Id. */
  int INPUT = 7;
  /** RegularExpression Id. */
  int OUTPUT = 8;
  /** RegularExpression Id. */
  int TRISTATE = 9;
  /** RegularExpression Id. */
  int WIRE = 10;
  /** RegularExpression Id. */
  int ENDMODULE = 11;
  /** RegularExpression Id. */
  int ASSIGN = 12;
  /** RegularExpression Id. */
  int digit = 13;
  /** RegularExpression Id. */
  int id_head = 14;
  /** RegularExpression Id. */
  int id_tail = 15;
  /** RegularExpression Id. */
  int integer = 16;
  /** RegularExpression Id. */
  int basic_identifier = 17;
  /** RegularExpression Id. */
  int extended_identifier = 18;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\t\"",
    "<COMMENT>",
    "\"module\"",
    "\"input\"",
    "\"output\"",
    "\"tri\"",
    "\"wire\"",
    "\"endmodule\"",
    "\"assign\"",
    "<digit>",
    "<id_head>",
    "<id_tail>",
    "<integer>",
    "<basic_identifier>",
    "<extended_identifier>",
    "\"(\"",
    "\")\"",
    "\";\"",
    "\"=\"",
    "\",\"",
    "\".\"",
    "\"[\"",
    "\":\"",
    "\"]\"",
    "\"1\\\'b\"",
  };

}
