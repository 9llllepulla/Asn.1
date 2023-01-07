// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.gllllepulla.plugin.psi.token.AsnTokenType;
import com.gllllepulla.plugin.psi.impl.*;

public interface AsnTypes {

  IElementType BODY_CHOICE = new AsnElementType("BODY_CHOICE");
  IElementType BODY_CHOICE_EXPR = new AsnElementType("BODY_CHOICE_EXPR");
  IElementType BODY_ENUM = new AsnElementType("BODY_ENUM");
  IElementType BODY_ENUM_EXPR = new AsnElementType("BODY_ENUM_EXPR");
  IElementType BODY_SEQUENCE_EXPR = new AsnElementType("BODY_SEQUENCE_EXPR");
  IElementType BODY_SINGLETON = new AsnElementType("BODY_SINGLETON");
  IElementType BODY_TAGGED_EXPR = new AsnElementType("BODY_TAGGED_EXPR");
  IElementType BODY_WITH_SYNTAX_EXPR = new AsnElementType("BODY_WITH_SYNTAX_EXPR");
  IElementType BOOL_ = new AsnElementType("BOOL_");
  IElementType CHOICE_CONSTRUCT = new AsnElementType("CHOICE_CONSTRUCT");
  IElementType DATA_ = new AsnElementType("DATA_");
  IElementType ELEMENT_ = new AsnElementType("ELEMENT_");
  IElementType ENUM_ELEMENT = new AsnElementType("ENUM_ELEMENT");
  IElementType EXPORTS_ = new AsnElementType("EXPORTS_");
  IElementType EXPR_ = new AsnElementType("EXPR_");
  IElementType FILE_HEADER = new AsnElementType("FILE_HEADER");
  IElementType FROM_ = new AsnElementType("FROM_");
  IElementType ID_TAGGED_CONSTRUCT = new AsnElementType("ID_TAGGED_CONSTRUCT");
  IElementType IMPORTS_ = new AsnElementType("IMPORTS_");
  IElementType INNER_CHOICE_EXPR = new AsnElementType("INNER_CHOICE_EXPR");
  IElementType INNER_ENUM_EXPR = new AsnElementType("INNER_ENUM_EXPR");
  IElementType INNER_EXPR = new AsnElementType("INNER_EXPR");
  IElementType INT_RANGE_EXPR = new AsnElementType("INT_RANGE_EXPR");
  IElementType INT_SQUARE = new AsnElementType("INT_SQUARE");
  IElementType OCTET_STRING = new AsnElementType("OCTET_STRING");
  IElementType OID_ = new AsnElementType("OID_");
  IElementType PRIMITIVE_DEF = new AsnElementType("PRIMITIVE_DEF");
  IElementType PRIMITIVE_EXPR = new AsnElementType("PRIMITIVE_EXPR");
  IElementType PROPERTY = new AsnElementType("PROPERTY");
  IElementType RANGE_ = new AsnElementType("RANGE_");
  IElementType SEQUENCE_CONSTRUCT = new AsnElementType("SEQUENCE_CONSTRUCT");
  IElementType SEQ_OF = new AsnElementType("SEQ_OF");
  IElementType SEQ_OF_VALUE = new AsnElementType("SEQ_OF_VALUE");
  IElementType SIZE_RANGE = new AsnElementType("SIZE_RANGE");
  IElementType TIME_ = new AsnElementType("TIME_");
  IElementType TYPES_ = new AsnElementType("TYPES_");
  IElementType TYPE_STRING_SIZE = new AsnElementType("TYPE_STRING_SIZE");
  IElementType VALUES_ = new AsnElementType("VALUES_");
  IElementType VALUES_OR = new AsnElementType("VALUES_OR");
  IElementType VARIABLES_ = new AsnElementType("VARIABLES_");
  IElementType VAR_ = new AsnElementType("VAR_");
  IElementType WITHOUT_BODY_EXPR = new AsnElementType("WITHOUT_BODY_EXPR");

  IElementType ANY = new AsnTokenType("ANY");
  IElementType APPLICATION = new AsnTokenType("APPLICATION");
  IElementType ASSIGMENT = new AsnTokenType("::=");
  IElementType AT = new AsnTokenType("@");
  IElementType BEGIN = new AsnTokenType("BEGIN");
  IElementType BIT = new AsnTokenType("BIT STRING");
  IElementType BOOLEAN = new AsnTokenType("BOOLEAN");
  IElementType CHOICE = new AsnTokenType("CHOICE");
  IElementType CLASS_DEF = new AsnTokenType("CLASS");
  IElementType COLON = new AsnTokenType(":");
  IElementType COMMA = new AsnTokenType(",");
  IElementType COMMENT_HEADER = new AsnTokenType("COMMENT_HEADER");
  IElementType COMMENT_LINE = new AsnTokenType("COMMENT_LINE");
  IElementType COMMENT_MULTILINE = new AsnTokenType("COMMENT_MULTILINE");
  IElementType CONTAINING = new AsnTokenType("CONTAINING");
  IElementType CONTENT_SPECIFIC = new AsnTokenType("CONTENT-SPECIFIC");
  IElementType DATE = new AsnTokenType("DATE");
  IElementType DATE_TIME = new AsnTokenType("DATE-TIME");
  IElementType DEFAULT = new AsnTokenType("DEFAULT");
  IElementType DEFINITIONS = new AsnTokenType("DEFINITIONS");
  IElementType DOT = new AsnTokenType(".");
  IElementType DOUBLE_DOT = new AsnTokenType("..");
  IElementType DOUBLE_QUOTE = new AsnTokenType("\"");
  IElementType DURATION = new AsnTokenType("DURATION");
  IElementType END = new AsnTokenType("END");
  IElementType ENUMERATED = new AsnTokenType("ENUMERATED");
  IElementType EXPLICIT = new AsnTokenType("EXPLICIT");
  IElementType EXPORTS = new AsnTokenType("EXPORTS");
  IElementType EXTERNAL = new AsnTokenType("EXTERNAL");
  IElementType FALSE = new AsnTokenType("FALSE");
  IElementType FROM = new AsnTokenType("FROM");
  IElementType IMPLICIT = new AsnTokenType("IMPLICIT");
  IElementType IMPORTS = new AsnTokenType("IMPORTS");
  IElementType INSTANCE = new AsnTokenType("INSTANCE");
  IElementType INTEGER = new AsnTokenType("INTEGER");
  IElementType LBRACE = new AsnTokenType("{");
  IElementType LBRACKET = new AsnTokenType("[");
  IElementType LPAREN = new AsnTokenType("(");
  IElementType MAX = new AsnTokenType("MAX");
  IElementType MIN = new AsnTokenType("MIN");
  IElementType MINUS = new AsnTokenType("-");
  IElementType NEW_LINE = new AsnTokenType("NEW_LINE");
  IElementType NULL = new AsnTokenType("NULL");
  IElementType NUMBER_FLOAT = new AsnTokenType("NUMBER_FLOAT");
  IElementType NUMBER_INT = new AsnTokenType("NUMBER_INT");
  IElementType OCTET = new AsnTokenType("OCTET STRING");
  IElementType OF = new AsnTokenType("OF");
  IElementType OID = new AsnTokenType("OID");
  IElementType OPTIONAL = new AsnTokenType("OPTIONAL");
  IElementType OR = new AsnTokenType("|");
  IElementType PRIVATE = new AsnTokenType("PRIVATE");
  IElementType RBRACE = new AsnTokenType("}");
  IElementType RBRACKET = new AsnTokenType("]");
  IElementType REAL = new AsnTokenType("REAL");
  IElementType RPAREN = new AsnTokenType(")");
  IElementType SEMICOLON = new AsnTokenType(";");
  IElementType SEQUENCE = new AsnTokenType("SEQUENCE");
  IElementType SET = new AsnTokenType("SET");
  IElementType SIZE = new AsnTokenType("SIZE");
  IElementType STRING_BMP = new AsnTokenType("BMPString");
  IElementType STRING_CHAR = new AsnTokenType("CHARACTER STRING");
  IElementType STRING_GEN = new AsnTokenType("GeneralString");
  IElementType STRING_GRAPH = new AsnTokenType("GraphicString");
  IElementType STRING_IA5 = new AsnTokenType("IA5String");
  IElementType STRING_NUM = new AsnTokenType("NumericString");
  IElementType STRING_PR = new AsnTokenType("PrintableString");
  IElementType STRING_TELE = new AsnTokenType("TeletextString");
  IElementType STRING_UNI = new AsnTokenType("UniversalString");
  IElementType STRING_UTF8 = new AsnTokenType("UTF8String");
  IElementType STRING_VIS = new AsnTokenType("VisibleString");
  IElementType STRING_VTEXT = new AsnTokenType("VideotexString");
  IElementType STR_LITERALS = new AsnTokenType("STR_LITERALS");
  IElementType SYNTAX = new AsnTokenType("SYNTAX");
  IElementType TAGS = new AsnTokenType("TAGS");
  IElementType TIME = new AsnTokenType("TIME");
  IElementType TIME_GEN = new AsnTokenType("GeneralizedTime");
  IElementType TIME_OF_DAY = new AsnTokenType("TIME-OF-DAY");
  IElementType TIME_UTC = new AsnTokenType("UTCTime");
  IElementType TRUE = new AsnTokenType("TRUE");
  IElementType TYPE_CLASS = new AsnTokenType("TYPE_CLASS");
  IElementType TYPE_IDENTIFIER = new AsnTokenType("TYPE-IDENTIFIER");
  IElementType UNIQUE = new AsnTokenType("UNIQUE");
  IElementType UNIVERSAL = new AsnTokenType("UNIVERSAL");
  IElementType USER_TYPE = new AsnTokenType("USER_TYPE");
  IElementType VALUE_NAME = new AsnTokenType("VALUE_NAME");
  IElementType VAR = new AsnTokenType("&");
  IElementType WITH = new AsnTokenType("WITH");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BODY_CHOICE) {
        return new AsnBodyChoiceImpl(node);
      }
      else if (type == BODY_CHOICE_EXPR) {
        return new AsnBodyChoiceExprImpl(node);
      }
      else if (type == BODY_ENUM) {
        return new AsnBodyEnumImpl(node);
      }
      else if (type == BODY_ENUM_EXPR) {
        return new AsnBodyEnumExprImpl(node);
      }
      else if (type == BODY_SEQUENCE_EXPR) {
        return new AsnBodySequenceExprImpl(node);
      }
      else if (type == BODY_SINGLETON) {
        return new AsnBodySingletonImpl(node);
      }
      else if (type == BODY_TAGGED_EXPR) {
        return new AsnBodyTaggedExprImpl(node);
      }
      else if (type == BODY_WITH_SYNTAX_EXPR) {
        return new AsnBodyWithSyntaxExprImpl(node);
      }
      else if (type == BOOL_) {
        return new AsnBool_Impl(node);
      }
      else if (type == CHOICE_CONSTRUCT) {
        return new AsnChoiceConstructImpl(node);
      }
      else if (type == DATA_) {
        return new AsnData_Impl(node);
      }
      else if (type == ELEMENT_) {
        return new AsnElement_Impl(node);
      }
      else if (type == ENUM_ELEMENT) {
        return new AsnEnumElementImpl(node);
      }
      else if (type == EXPORTS_) {
        return new AsnExports_Impl(node);
      }
      else if (type == EXPR_) {
        return new AsnExpr_Impl(node);
      }
      else if (type == FILE_HEADER) {
        return new AsnFileHeaderImpl(node);
      }
      else if (type == FROM_) {
        return new AsnFrom_Impl(node);
      }
      else if (type == ID_TAGGED_CONSTRUCT) {
        return new AsnIdTaggedConstructImpl(node);
      }
      else if (type == IMPORTS_) {
        return new AsnImports_Impl(node);
      }
      else if (type == INNER_CHOICE_EXPR) {
        return new AsnInnerChoiceExprImpl(node);
      }
      else if (type == INNER_ENUM_EXPR) {
        return new AsnInnerEnumExprImpl(node);
      }
      else if (type == INNER_EXPR) {
        return new AsnInnerExprImpl(node);
      }
      else if (type == INT_RANGE_EXPR) {
        return new AsnIntRangeExprImpl(node);
      }
      else if (type == INT_SQUARE) {
        return new AsnIntSquareImpl(node);
      }
      else if (type == OCTET_STRING) {
        return new AsnOctetStringImpl(node);
      }
      else if (type == OID_) {
        return new AsnOid_Impl(node);
      }
      else if (type == PRIMITIVE_DEF) {
        return new AsnPrimitiveDefImpl(node);
      }
      else if (type == PRIMITIVE_EXPR) {
        return new AsnPrimitiveExprImpl(node);
      }
      else if (type == PROPERTY) {
        return new AsnPropertyImpl(node);
      }
      else if (type == RANGE_) {
        return new AsnRange_Impl(node);
      }
      else if (type == SEQUENCE_CONSTRUCT) {
        return new AsnSequenceConstructImpl(node);
      }
      else if (type == SEQ_OF) {
        return new AsnSeqOfImpl(node);
      }
      else if (type == SEQ_OF_VALUE) {
        return new AsnSeqOfValueImpl(node);
      }
      else if (type == SIZE_RANGE) {
        return new AsnSizeRangeImpl(node);
      }
      else if (type == TIME_) {
        return new AsnTime_Impl(node);
      }
      else if (type == TYPES_) {
        return new AsnTypes_Impl(node);
      }
      else if (type == TYPE_STRING_SIZE) {
        return new AsnTypeStringSizeImpl(node);
      }
      else if (type == VALUES_) {
        return new AsnValues_Impl(node);
      }
      else if (type == VALUES_OR) {
        return new AsnValuesOrImpl(node);
      }
      else if (type == VARIABLES_) {
        return new AsnVariables_Impl(node);
      }
      else if (type == VAR_) {
        return new AsnVar_Impl(node);
      }
      else if (type == WITHOUT_BODY_EXPR) {
        return new AsnWithoutBodyExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
