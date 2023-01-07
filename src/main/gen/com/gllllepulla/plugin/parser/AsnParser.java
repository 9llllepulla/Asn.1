// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.gllllepulla.plugin.psi.AsnTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class AsnParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return program(b, l + 1);
  }

  /* ********************************************************** */
  // CHOICE LBRACE choice_construct? {COMMA choice_construct}* RBRACE
  public static boolean body_choice(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice")) return false;
    if (!nextTokenIs(b, CHOICE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BODY_CHOICE, null);
    r = consumeTokens(b, 2, CHOICE, LBRACE);
    p = r; // pin = 2
    r = r && report_error_(b, body_choice_2(b, l + 1));
    r = p && report_error_(b, body_choice_3(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // choice_construct?
  private static boolean body_choice_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_2")) return false;
    choice_construct(b, l + 1);
    return true;
  }

  // {COMMA choice_construct}*
  private static boolean body_choice_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!body_choice_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_choice_3", c)) break;
    }
    return true;
  }

  // COMMA choice_construct
  private static boolean body_choice_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && choice_construct(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // values_? (types_)? ASSIGMENT CLASS_DEF? CHOICE LBRACE choice_construct? {COMMA choice_construct}* RBRACE body_with_syntax_expr?
  public static boolean body_choice_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_expr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BODY_CHOICE_EXPR, "<body choice expr>");
    r = body_choice_expr_0(b, l + 1);
    r = r && body_choice_expr_1(b, l + 1);
    r = r && consumeToken(b, ASSIGMENT);
    r = r && body_choice_expr_3(b, l + 1);
    r = r && consumeTokens(b, 2, CHOICE, LBRACE);
    p = r; // pin = 6
    r = r && report_error_(b, body_choice_expr_6(b, l + 1));
    r = p && report_error_(b, body_choice_expr_7(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RBRACE)) && r;
    r = p && body_choice_expr_9(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // values_?
  private static boolean body_choice_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_expr_0")) return false;
    values_(b, l + 1);
    return true;
  }

  // (types_)?
  private static boolean body_choice_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_expr_1")) return false;
    body_choice_expr_1_0(b, l + 1);
    return true;
  }

  // (types_)
  private static boolean body_choice_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = types_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CLASS_DEF?
  private static boolean body_choice_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_expr_3")) return false;
    consumeToken(b, CLASS_DEF);
    return true;
  }

  // choice_construct?
  private static boolean body_choice_expr_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_expr_6")) return false;
    choice_construct(b, l + 1);
    return true;
  }

  // {COMMA choice_construct}*
  private static boolean body_choice_expr_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_expr_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!body_choice_expr_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_choice_expr_7", c)) break;
    }
    return true;
  }

  // COMMA choice_construct
  private static boolean body_choice_expr_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_expr_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && choice_construct(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // body_with_syntax_expr?
  private static boolean body_choice_expr_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_choice_expr_9")) return false;
    body_with_syntax_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ENUMERATED LBRACE enum_element? {COMMA enum_element}* RBRACE OPTIONAL?
  public static boolean body_enum(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum")) return false;
    if (!nextTokenIs(b, ENUMERATED)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BODY_ENUM, null);
    r = consumeTokens(b, 2, ENUMERATED, LBRACE);
    p = r; // pin = 2
    r = r && report_error_(b, body_enum_2(b, l + 1));
    r = p && report_error_(b, body_enum_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RBRACE)) && r;
    r = p && body_enum_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // enum_element?
  private static boolean body_enum_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_2")) return false;
    enum_element(b, l + 1);
    return true;
  }

  // {COMMA enum_element}*
  private static boolean body_enum_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!body_enum_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_enum_3", c)) break;
    }
    return true;
  }

  // COMMA enum_element
  private static boolean body_enum_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enum_element(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPTIONAL?
  private static boolean body_enum_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_5")) return false;
    consumeToken(b, OPTIONAL);
    return true;
  }

  /* ********************************************************** */
  // values_? (types_)? ASSIGMENT CLASS_DEF? ENUMERATED LBRACE enum_element? {COMMA enum_element}* RBRACE OPTIONAL? body_with_syntax_expr?
  public static boolean body_enum_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_expr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BODY_ENUM_EXPR, "<body enum expr>");
    r = body_enum_expr_0(b, l + 1);
    r = r && body_enum_expr_1(b, l + 1);
    r = r && consumeToken(b, ASSIGMENT);
    r = r && body_enum_expr_3(b, l + 1);
    r = r && consumeTokens(b, 2, ENUMERATED, LBRACE);
    p = r; // pin = 6
    r = r && report_error_(b, body_enum_expr_6(b, l + 1));
    r = p && report_error_(b, body_enum_expr_7(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RBRACE)) && r;
    r = p && report_error_(b, body_enum_expr_9(b, l + 1)) && r;
    r = p && body_enum_expr_10(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // values_?
  private static boolean body_enum_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_expr_0")) return false;
    values_(b, l + 1);
    return true;
  }

  // (types_)?
  private static boolean body_enum_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_expr_1")) return false;
    body_enum_expr_1_0(b, l + 1);
    return true;
  }

  // (types_)
  private static boolean body_enum_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = types_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CLASS_DEF?
  private static boolean body_enum_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_expr_3")) return false;
    consumeToken(b, CLASS_DEF);
    return true;
  }

  // enum_element?
  private static boolean body_enum_expr_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_expr_6")) return false;
    enum_element(b, l + 1);
    return true;
  }

  // {COMMA enum_element}*
  private static boolean body_enum_expr_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_expr_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!body_enum_expr_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_enum_expr_7", c)) break;
    }
    return true;
  }

  // COMMA enum_element
  private static boolean body_enum_expr_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_expr_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enum_element(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPTIONAL?
  private static boolean body_enum_expr_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_expr_9")) return false;
    consumeToken(b, OPTIONAL);
    return true;
  }

  // body_with_syntax_expr?
  private static boolean body_enum_expr_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_enum_expr_10")) return false;
    body_with_syntax_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // values_? (types_)? ASSIGMENT CLASS_DEF? SEQUENCE LBRACE sequence_construct? {COMMA sequence_construct}* RBRACE body_with_syntax_expr?
  public static boolean body_sequence_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_sequence_expr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BODY_SEQUENCE_EXPR, "<body sequence expr>");
    r = body_sequence_expr_0(b, l + 1);
    r = r && body_sequence_expr_1(b, l + 1);
    r = r && consumeToken(b, ASSIGMENT);
    r = r && body_sequence_expr_3(b, l + 1);
    r = r && consumeTokens(b, 2, SEQUENCE, LBRACE);
    p = r; // pin = 6
    r = r && report_error_(b, body_sequence_expr_6(b, l + 1));
    r = p && report_error_(b, body_sequence_expr_7(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RBRACE)) && r;
    r = p && body_sequence_expr_9(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // values_?
  private static boolean body_sequence_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_sequence_expr_0")) return false;
    values_(b, l + 1);
    return true;
  }

  // (types_)?
  private static boolean body_sequence_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_sequence_expr_1")) return false;
    body_sequence_expr_1_0(b, l + 1);
    return true;
  }

  // (types_)
  private static boolean body_sequence_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_sequence_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = types_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CLASS_DEF?
  private static boolean body_sequence_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_sequence_expr_3")) return false;
    consumeToken(b, CLASS_DEF);
    return true;
  }

  // sequence_construct?
  private static boolean body_sequence_expr_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_sequence_expr_6")) return false;
    sequence_construct(b, l + 1);
    return true;
  }

  // {COMMA sequence_construct}*
  private static boolean body_sequence_expr_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_sequence_expr_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!body_sequence_expr_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_sequence_expr_7", c)) break;
    }
    return true;
  }

  // COMMA sequence_construct
  private static boolean body_sequence_expr_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_sequence_expr_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && sequence_construct(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // body_with_syntax_expr?
  private static boolean body_sequence_expr_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_sequence_expr_9")) return false;
    body_with_syntax_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LBRACE AT? (types_|VALUE_NAME) RBRACE
  public static boolean body_singleton(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_singleton")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BODY_SINGLETON, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, body_singleton_1(b, l + 1));
    r = p && report_error_(b, body_singleton_2(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // AT?
  private static boolean body_singleton_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_singleton_1")) return false;
    consumeToken(b, AT);
    return true;
  }

  // types_|VALUE_NAME
  private static boolean body_singleton_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_singleton_2")) return false;
    boolean r;
    r = types_(b, l + 1);
    if (!r) r = consumeToken(b, VALUE_NAME);
    return r;
  }

  /* ********************************************************** */
  // values_? (types_)? ASSIGMENT CLASS_DEF? LBRACE (values_or|variables_|oid_|data_|seq_of_value|inner_expr)* RBRACE body_with_syntax_expr?
  public static boolean body_tagged_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_tagged_expr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BODY_TAGGED_EXPR, "<body tagged expr>");
    r = body_tagged_expr_0(b, l + 1);
    r = r && body_tagged_expr_1(b, l + 1);
    r = r && consumeToken(b, ASSIGMENT);
    r = r && body_tagged_expr_3(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    p = r; // pin = 5
    r = r && report_error_(b, body_tagged_expr_5(b, l + 1));
    r = p && report_error_(b, consumeToken(b, RBRACE)) && r;
    r = p && body_tagged_expr_7(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // values_?
  private static boolean body_tagged_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_tagged_expr_0")) return false;
    values_(b, l + 1);
    return true;
  }

  // (types_)?
  private static boolean body_tagged_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_tagged_expr_1")) return false;
    body_tagged_expr_1_0(b, l + 1);
    return true;
  }

  // (types_)
  private static boolean body_tagged_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_tagged_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = types_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CLASS_DEF?
  private static boolean body_tagged_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_tagged_expr_3")) return false;
    consumeToken(b, CLASS_DEF);
    return true;
  }

  // (values_or|variables_|oid_|data_|seq_of_value|inner_expr)*
  private static boolean body_tagged_expr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_tagged_expr_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!body_tagged_expr_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_tagged_expr_5", c)) break;
    }
    return true;
  }

  // values_or|variables_|oid_|data_|seq_of_value|inner_expr
  private static boolean body_tagged_expr_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_tagged_expr_5_0")) return false;
    boolean r;
    r = values_or(b, l + 1);
    if (!r) r = variables_(b, l + 1);
    if (!r) r = oid_(b, l + 1);
    if (!r) r = data_(b, l + 1);
    if (!r) r = seq_of_value(b, l + 1);
    if (!r) r = inner_expr(b, l + 1);
    return r;
  }

  // body_with_syntax_expr?
  private static boolean body_tagged_expr_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_tagged_expr_7")) return false;
    body_with_syntax_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WITH SYNTAX LBRACE {types_ VAR (VALUE_NAME|USER_TYPE)}* RBRACE
  public static boolean body_with_syntax_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_with_syntax_expr")) return false;
    if (!nextTokenIs(b, WITH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BODY_WITH_SYNTAX_EXPR, null);
    r = consumeTokens(b, 3, WITH, SYNTAX, LBRACE);
    p = r; // pin = 3
    r = r && report_error_(b, body_with_syntax_expr_3(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // {types_ VAR (VALUE_NAME|USER_TYPE)}*
  private static boolean body_with_syntax_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_with_syntax_expr_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!body_with_syntax_expr_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_with_syntax_expr_3", c)) break;
    }
    return true;
  }

  // types_ VAR (VALUE_NAME|USER_TYPE)
  private static boolean body_with_syntax_expr_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_with_syntax_expr_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = types_(b, l + 1);
    r = r && consumeToken(b, VAR);
    r = r && body_with_syntax_expr_3_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VALUE_NAME|USER_TYPE
  private static boolean body_with_syntax_expr_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_with_syntax_expr_3_0_2")) return false;
    boolean r;
    r = consumeToken(b, VALUE_NAME);
    if (!r) r = consumeToken(b, USER_TYPE);
    return r;
  }

  /* ********************************************************** */
  // BOOLEAN DEFAULT? (TRUE|FALSE)?
  public static boolean bool_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_")) return false;
    if (!nextTokenIs(b, BOOLEAN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOOLEAN);
    r = r && bool__1(b, l + 1);
    r = r && bool__2(b, l + 1);
    exit_section_(b, m, BOOL_, r);
    return r;
  }

  // DEFAULT?
  private static boolean bool__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool__1")) return false;
    consumeToken(b, DEFAULT);
    return true;
  }

  // (TRUE|FALSE)?
  private static boolean bool__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool__2")) return false;
    bool__2_0(b, l + 1);
    return true;
  }

  // TRUE|FALSE
  private static boolean bool__2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool__2_0")) return false;
    boolean r;
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    return r;
  }

  /* ********************************************************** */
  // VALUE_NAME int_square? (seq_of|IMPLICIT|EXPLICIT)? (element_|body_enum)
  public static boolean choice_construct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_construct")) return false;
    if (!nextTokenIs(b, VALUE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VALUE_NAME);
    r = r && choice_construct_1(b, l + 1);
    r = r && choice_construct_2(b, l + 1);
    r = r && choice_construct_3(b, l + 1);
    exit_section_(b, m, CHOICE_CONSTRUCT, r);
    return r;
  }

  // int_square?
  private static boolean choice_construct_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_construct_1")) return false;
    int_square(b, l + 1);
    return true;
  }

  // (seq_of|IMPLICIT|EXPLICIT)?
  private static boolean choice_construct_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_construct_2")) return false;
    choice_construct_2_0(b, l + 1);
    return true;
  }

  // seq_of|IMPLICIT|EXPLICIT
  private static boolean choice_construct_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_construct_2_0")) return false;
    boolean r;
    r = seq_of(b, l + 1);
    if (!r) r = consumeToken(b, IMPLICIT);
    if (!r) r = consumeToken(b, EXPLICIT);
    return r;
  }

  // element_|body_enum
  private static boolean choice_construct_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_construct_3")) return false;
    boolean r;
    r = element_(b, l + 1);
    if (!r) r = body_enum(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // TYPE_CLASS seq_of? (USER_TYPE|body_choice)
  public static boolean data_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_")) return false;
    if (!nextTokenIs(b, TYPE_CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_CLASS);
    r = r && data__1(b, l + 1);
    r = r && data__2(b, l + 1);
    exit_section_(b, m, DATA_, r);
    return r;
  }

  // seq_of?
  private static boolean data__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data__1")) return false;
    seq_of(b, l + 1);
    return true;
  }

  // USER_TYPE|body_choice
  private static boolean data__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data__2")) return false;
    boolean r;
    r = consumeToken(b, USER_TYPE);
    if (!r) r = body_choice(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (USER_TYPE|type_string_size|time_|range_|primitive_def|octet_string|bool_) OPTIONAL?
  public static boolean element_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_, "<element>");
    r = element__0(b, l + 1);
    r = r && element__1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // USER_TYPE|type_string_size|time_|range_|primitive_def|octet_string|bool_
  private static boolean element__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element__0")) return false;
    boolean r;
    r = consumeToken(b, USER_TYPE);
    if (!r) r = type_string_size(b, l + 1);
    if (!r) r = time_(b, l + 1);
    if (!r) r = range_(b, l + 1);
    if (!r) r = primitive_def(b, l + 1);
    if (!r) r = octet_string(b, l + 1);
    if (!r) r = bool_(b, l + 1);
    return r;
  }

  // OPTIONAL?
  private static boolean element__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element__1")) return false;
    consumeToken(b, OPTIONAL);
    return true;
  }

  /* ********************************************************** */
  // VALUE_NAME LPAREN NUMBER_INT RPAREN
  public static boolean enum_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_element")) return false;
    if (!nextTokenIs(b, VALUE_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_ELEMENT, null);
    r = consumeTokens(b, 2, VALUE_NAME, LPAREN, NUMBER_INT, RPAREN);
    p = r; // pin = 2
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // EXPORTS (types_|values_) {COMMA values_}* SEMICOLON
  public static boolean exports_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exports_")) return false;
    if (!nextTokenIs(b, EXPORTS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXPORTS_, null);
    r = consumeToken(b, EXPORTS);
    p = r; // pin = 1
    r = r && report_error_(b, exports__1(b, l + 1));
    r = p && report_error_(b, exports__2(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // types_|values_
  private static boolean exports__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exports__1")) return false;
    boolean r;
    r = types_(b, l + 1);
    if (!r) r = values_(b, l + 1);
    return r;
  }

  // {COMMA values_}*
  private static boolean exports__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exports__2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!exports__2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "exports__2", c)) break;
    }
    return true;
  }

  // COMMA values_
  private static boolean exports__2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exports__2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && values_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primitive_expr|without_body_expr|body_choice_expr|body_enum_expr|body_sequence_expr|body_tagged_expr
  public static boolean expr_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR_, "<expr>");
    r = primitive_expr(b, l + 1);
    if (!r) r = without_body_expr(b, l + 1);
    if (!r) r = body_choice_expr(b, l + 1);
    if (!r) r = body_enum_expr(b, l + 1);
    if (!r) r = body_sequence_expr(b, l + 1);
    if (!r) r = body_tagged_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (USER_TYPE|TYPE_CLASS) DEFINITIONS (IMPLICIT TAGS)? ASSIGMENT BEGIN exports_ imports_? expr_* END
  public static boolean file_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_header")) return false;
    if (!nextTokenIs(b, "<file header>", TYPE_CLASS, USER_TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FILE_HEADER, "<file header>");
    r = file_header_0(b, l + 1);
    r = r && consumeToken(b, DEFINITIONS);
    r = r && file_header_2(b, l + 1);
    r = r && consumeTokens(b, 1, ASSIGMENT, BEGIN);
    p = r; // pin = 4
    r = r && report_error_(b, exports_(b, l + 1));
    r = p && report_error_(b, file_header_6(b, l + 1)) && r;
    r = p && report_error_(b, file_header_7(b, l + 1)) && r;
    r = p && consumeToken(b, END) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // USER_TYPE|TYPE_CLASS
  private static boolean file_header_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_header_0")) return false;
    boolean r;
    r = consumeToken(b, USER_TYPE);
    if (!r) r = consumeToken(b, TYPE_CLASS);
    return r;
  }

  // (IMPLICIT TAGS)?
  private static boolean file_header_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_header_2")) return false;
    file_header_2_0(b, l + 1);
    return true;
  }

  // IMPLICIT TAGS
  private static boolean file_header_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_header_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPLICIT, TAGS);
    exit_section_(b, m, null, r);
    return r;
  }

  // imports_?
  private static boolean file_header_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_header_6")) return false;
    imports_(b, l + 1);
    return true;
  }

  // expr_*
  private static boolean file_header_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_header_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_header_7", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (TYPE_CLASS|values_) {COMMA (TYPE_CLASS|values_)}* FROM USER_TYPE
  public static boolean from_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "from_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FROM_, "<from>");
    r = from__0(b, l + 1);
    r = r && from__1(b, l + 1);
    r = r && consumeTokens(b, 0, FROM, USER_TYPE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TYPE_CLASS|values_
  private static boolean from__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "from__0")) return false;
    boolean r;
    r = consumeToken(b, TYPE_CLASS);
    if (!r) r = values_(b, l + 1);
    return r;
  }

  // {COMMA (TYPE_CLASS|values_)}*
  private static boolean from__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "from__1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!from__1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "from__1", c)) break;
    }
    return true;
  }

  // COMMA (TYPE_CLASS|values_)
  private static boolean from__1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "from__1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && from__1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TYPE_CLASS|values_
  private static boolean from__1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "from__1_0_1")) return false;
    boolean r;
    r = consumeToken(b, TYPE_CLASS);
    if (!r) r = values_(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // VALUE_NAME TYPE_CLASS DOT VAR values_ LPAREN body_singleton* RPAREN
  public static boolean id_tagged_construct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_tagged_construct")) return false;
    if (!nextTokenIs(b, VALUE_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ID_TAGGED_CONSTRUCT, null);
    r = consumeTokens(b, 0, VALUE_NAME, TYPE_CLASS, DOT, VAR);
    r = r && values_(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    p = r; // pin = 6
    r = r && report_error_(b, id_tagged_construct_6(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // body_singleton*
  private static boolean id_tagged_construct_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_tagged_construct_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!body_singleton(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "id_tagged_construct_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IMPORTS from_* SEMICOLON
  public static boolean imports_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports_")) return false;
    if (!nextTokenIs(b, IMPORTS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORTS_, null);
    r = consumeToken(b, IMPORTS);
    p = r; // pin = 1
    r = r && report_error_(b, imports__1(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // from_*
  private static boolean imports__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports__1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!from_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "imports__1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (VALUE_NAME int_square?|USER_TYPE|TYPE_CLASS) CHOICE LBRACE choice_construct? {COMMA choice_construct}* RBRACE
  public static boolean inner_choice_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_choice_expr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INNER_CHOICE_EXPR, "<inner choice expr>");
    r = inner_choice_expr_0(b, l + 1);
    r = r && consumeTokens(b, 2, CHOICE, LBRACE);
    p = r; // pin = 3
    r = r && report_error_(b, inner_choice_expr_3(b, l + 1));
    r = p && report_error_(b, inner_choice_expr_4(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // VALUE_NAME int_square?|USER_TYPE|TYPE_CLASS
  private static boolean inner_choice_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_choice_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inner_choice_expr_0_0(b, l + 1);
    if (!r) r = consumeToken(b, USER_TYPE);
    if (!r) r = consumeToken(b, TYPE_CLASS);
    exit_section_(b, m, null, r);
    return r;
  }

  // VALUE_NAME int_square?
  private static boolean inner_choice_expr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_choice_expr_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VALUE_NAME);
    r = r && inner_choice_expr_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // int_square?
  private static boolean inner_choice_expr_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_choice_expr_0_0_1")) return false;
    int_square(b, l + 1);
    return true;
  }

  // choice_construct?
  private static boolean inner_choice_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_choice_expr_3")) return false;
    choice_construct(b, l + 1);
    return true;
  }

  // {COMMA choice_construct}*
  private static boolean inner_choice_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_choice_expr_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inner_choice_expr_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inner_choice_expr_4", c)) break;
    }
    return true;
  }

  // COMMA choice_construct
  private static boolean inner_choice_expr_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_choice_expr_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && choice_construct(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (VALUE_NAME int_square?|USER_TYPE|TYPE_CLASS) ENUMERATED LBRACE enum_element? {COMMA enum_element}* RBRACE OPTIONAL?
  public static boolean inner_enum_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_enum_expr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INNER_ENUM_EXPR, "<inner enum expr>");
    r = inner_enum_expr_0(b, l + 1);
    r = r && consumeTokens(b, 2, ENUMERATED, LBRACE);
    p = r; // pin = 3
    r = r && report_error_(b, inner_enum_expr_3(b, l + 1));
    r = p && report_error_(b, inner_enum_expr_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RBRACE)) && r;
    r = p && inner_enum_expr_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // VALUE_NAME int_square?|USER_TYPE|TYPE_CLASS
  private static boolean inner_enum_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_enum_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inner_enum_expr_0_0(b, l + 1);
    if (!r) r = consumeToken(b, USER_TYPE);
    if (!r) r = consumeToken(b, TYPE_CLASS);
    exit_section_(b, m, null, r);
    return r;
  }

  // VALUE_NAME int_square?
  private static boolean inner_enum_expr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_enum_expr_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VALUE_NAME);
    r = r && inner_enum_expr_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // int_square?
  private static boolean inner_enum_expr_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_enum_expr_0_0_1")) return false;
    int_square(b, l + 1);
    return true;
  }

  // enum_element?
  private static boolean inner_enum_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_enum_expr_3")) return false;
    enum_element(b, l + 1);
    return true;
  }

  // {COMMA enum_element}*
  private static boolean inner_enum_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_enum_expr_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inner_enum_expr_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inner_enum_expr_4", c)) break;
    }
    return true;
  }

  // COMMA enum_element
  private static boolean inner_enum_expr_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_enum_expr_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enum_element(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPTIONAL?
  private static boolean inner_enum_expr_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_enum_expr_6")) return false;
    consumeToken(b, OPTIONAL);
    return true;
  }

  /* ********************************************************** */
  // inner_choice_expr|inner_enum_expr
  public static boolean inner_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INNER_EXPR, "<inner expr>");
    r = inner_choice_expr(b, l + 1);
    if (!r) r = inner_enum_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_DOT NUMBER_INT
  public static boolean int_range_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_range_expr")) return false;
    if (!nextTokenIs(b, DOUBLE_DOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INT_RANGE_EXPR, null);
    r = consumeTokens(b, 1, DOUBLE_DOT, NUMBER_INT);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LBRACKET NUMBER_INT RBRACKET
  public static boolean int_square(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_square")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INT_SQUARE, null);
    r = consumeTokens(b, 1, LBRACKET, NUMBER_INT, RBRACKET);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (OCTET|BIT) size_range
  public static boolean octet_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "octet_string")) return false;
    if (!nextTokenIs(b, "<octet string>", BIT, OCTET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OCTET_STRING, "<octet string>");
    r = octet_string_0(b, l + 1);
    r = r && size_range(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OCTET|BIT
  private static boolean octet_string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "octet_string_0")) return false;
    boolean r;
    r = consumeToken(b, OCTET);
    if (!r) r = consumeToken(b, BIT);
    return r;
  }

  /* ********************************************************** */
  // OID (body_singleton|VALUE_NAME)
  public static boolean oid_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oid_")) return false;
    if (!nextTokenIs(b, OID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OID);
    r = r && oid__1(b, l + 1);
    exit_section_(b, m, OID_, r);
    return r;
  }

  // body_singleton|VALUE_NAME
  private static boolean oid__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oid__1")) return false;
    boolean r;
    r = body_singleton(b, l + 1);
    if (!r) r = consumeToken(b, VALUE_NAME);
    return r;
  }

  /* ********************************************************** */
  // INTEGER|REAL|NULL
  public static boolean primitive_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_def")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMITIVE_DEF, "<primitive def>");
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, REAL);
    if (!r) r = consumeToken(b, NULL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // values_? (types_)? ASSIGMENT (STR_LITERALS|NUMBER_INT|NUMBER_FLOAT) body_with_syntax_expr?
  public static boolean primitive_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMITIVE_EXPR, "<primitive expr>");
    r = primitive_expr_0(b, l + 1);
    r = r && primitive_expr_1(b, l + 1);
    r = r && consumeToken(b, ASSIGMENT);
    r = r && primitive_expr_3(b, l + 1);
    r = r && primitive_expr_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // values_?
  private static boolean primitive_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_expr_0")) return false;
    values_(b, l + 1);
    return true;
  }

  // (types_)?
  private static boolean primitive_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_expr_1")) return false;
    primitive_expr_1_0(b, l + 1);
    return true;
  }

  // (types_)
  private static boolean primitive_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = types_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STR_LITERALS|NUMBER_INT|NUMBER_FLOAT
  private static boolean primitive_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_expr_3")) return false;
    boolean r;
    r = consumeToken(b, STR_LITERALS);
    if (!r) r = consumeToken(b, NUMBER_INT);
    if (!r) r = consumeToken(b, NUMBER_FLOAT);
    return r;
  }

  // body_with_syntax_expr?
  private static boolean primitive_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_expr_4")) return false;
    body_with_syntax_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // property
  static boolean program(PsiBuilder b, int l) {
    return property(b, l + 1);
  }

  /* ********************************************************** */
  // NEW_LINE* file_header
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_0(b, l + 1);
    r = r && file_header(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "property_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // INTEGER? LPAREN NUMBER_INT int_range_expr? RPAREN
  public static boolean range_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_")) return false;
    if (!nextTokenIs(b, "<range>", INTEGER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RANGE_, "<range>");
    r = range__0(b, l + 1);
    r = r && consumeTokens(b, 0, LPAREN, NUMBER_INT);
    r = r && range__3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INTEGER?
  private static boolean range__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range__0")) return false;
    consumeToken(b, INTEGER);
    return true;
  }

  // int_range_expr?
  private static boolean range__3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range__3")) return false;
    int_range_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SEQUENCE OF
  public static boolean seq_of(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "seq_of")) return false;
    if (!nextTokenIs(b, SEQUENCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SEQUENCE, OF);
    exit_section_(b, m, SEQ_OF, r);
    return r;
  }

  /* ********************************************************** */
  // values_ seq_of USER_TYPE OPTIONAL?
  public static boolean seq_of_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "seq_of_value")) return false;
    if (!nextTokenIs(b, "<seq of value>", USER_TYPE, VALUE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SEQ_OF_VALUE, "<seq of value>");
    r = values_(b, l + 1);
    r = r && seq_of(b, l + 1);
    r = r && consumeToken(b, USER_TYPE);
    r = r && seq_of_value_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OPTIONAL?
  private static boolean seq_of_value_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "seq_of_value_3")) return false;
    consumeToken(b, OPTIONAL);
    return true;
  }

  /* ********************************************************** */
  // seq_of_value|choice_construct|inner_expr|id_tagged_construct
  public static boolean sequence_construct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequence_construct")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SEQUENCE_CONSTRUCT, "<sequence construct>");
    r = seq_of_value(b, l + 1);
    if (!r) r = choice_construct(b, l + 1);
    if (!r) r = inner_expr(b, l + 1);
    if (!r) r = id_tagged_construct(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN SIZE range_ RPAREN
  public static boolean size_range(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "size_range")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SIZE_RANGE, null);
    r = consumeTokens(b, 1, LPAREN, SIZE);
    p = r; // pin = 1
    r = r && report_error_(b, range_(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TIME_UTC|TIME_GEN|TIME|TIME_OF_DAY|DATE|DATE_TIME|DURATION
  public static boolean time_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "time_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TIME_, "<time>");
    r = consumeToken(b, TIME_UTC);
    if (!r) r = consumeToken(b, TIME_GEN);
    if (!r) r = consumeToken(b, TIME);
    if (!r) r = consumeToken(b, TIME_OF_DAY);
    if (!r) r = consumeToken(b, DATE);
    if (!r) r = consumeToken(b, DATE_TIME);
    if (!r) r = consumeToken(b, DURATION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (STRING_NUM|STRING_PR|STRING_TELE|STRING_VTEXT|STRING_VIS|STRING_IA5|STRING_GRAPH|STRING_BMP|STRING_GEN|STRING_UNI|STRING_UTF8|STRING_CHAR) size_range?
  public static boolean type_string_size(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_string_size")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_STRING_SIZE, "<type string size>");
    r = type_string_size_0(b, l + 1);
    r = r && type_string_size_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING_NUM|STRING_PR|STRING_TELE|STRING_VTEXT|STRING_VIS|STRING_IA5|STRING_GRAPH|STRING_BMP|STRING_GEN|STRING_UNI|STRING_UTF8|STRING_CHAR
  private static boolean type_string_size_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_string_size_0")) return false;
    boolean r;
    r = consumeToken(b, STRING_NUM);
    if (!r) r = consumeToken(b, STRING_PR);
    if (!r) r = consumeToken(b, STRING_TELE);
    if (!r) r = consumeToken(b, STRING_VTEXT);
    if (!r) r = consumeToken(b, STRING_VIS);
    if (!r) r = consumeToken(b, STRING_IA5);
    if (!r) r = consumeToken(b, STRING_GRAPH);
    if (!r) r = consumeToken(b, STRING_BMP);
    if (!r) r = consumeToken(b, STRING_GEN);
    if (!r) r = consumeToken(b, STRING_UNI);
    if (!r) r = consumeToken(b, STRING_UTF8);
    if (!r) r = consumeToken(b, STRING_CHAR);
    return r;
  }

  // size_range?
  private static boolean type_string_size_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_string_size_1")) return false;
    size_range(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TYPE_CLASS|USER_TYPE|OID
  public static boolean types_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "types_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPES_, "<types>");
    r = consumeToken(b, TYPE_CLASS);
    if (!r) r = consumeToken(b, USER_TYPE);
    if (!r) r = consumeToken(b, OID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // USER_TYPE|VALUE_NAME
  public static boolean values_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_")) return false;
    if (!nextTokenIs(b, "<values>", USER_TYPE, VALUE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUES_, "<values>");
    r = consumeToken(b, USER_TYPE);
    if (!r) r = consumeToken(b, VALUE_NAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VALUE_NAME {OR VALUE_NAME}*
  public static boolean values_or(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_or")) return false;
    if (!nextTokenIs(b, VALUE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VALUE_NAME);
    r = r && values_or_1(b, l + 1);
    exit_section_(b, m, VALUES_OR, r);
    return r;
  }

  // {OR VALUE_NAME}*
  private static boolean values_or_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_or_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!values_or_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "values_or_1", c)) break;
    }
    return true;
  }

  // OR VALUE_NAME
  private static boolean values_or_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_or_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OR, VALUE_NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VAR values_ USER_TYPE? UNIQUE?
  public static boolean var_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR);
    r = r && values_(b, l + 1);
    r = r && var__2(b, l + 1);
    r = r && var__3(b, l + 1);
    exit_section_(b, m, VAR_, r);
    return r;
  }

  // USER_TYPE?
  private static boolean var__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var__2")) return false;
    consumeToken(b, USER_TYPE);
    return true;
  }

  // UNIQUE?
  private static boolean var__3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var__3")) return false;
    consumeToken(b, UNIQUE);
    return true;
  }

  /* ********************************************************** */
  // var_ {COMMA var_}*
  public static boolean variables_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variables_")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_(b, l + 1);
    r = r && variables__1(b, l + 1);
    exit_section_(b, m, VARIABLES_, r);
    return r;
  }

  // {COMMA var_}*
  private static boolean variables__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variables__1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variables__1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variables__1", c)) break;
    }
    return true;
  }

  // COMMA var_
  private static boolean variables__1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variables__1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && var_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // values_? (types_)? ASSIGMENT CLASS_DEF? seq_of? element_
  public static boolean without_body_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "without_body_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WITHOUT_BODY_EXPR, "<without body expr>");
    r = without_body_expr_0(b, l + 1);
    r = r && without_body_expr_1(b, l + 1);
    r = r && consumeToken(b, ASSIGMENT);
    r = r && without_body_expr_3(b, l + 1);
    r = r && without_body_expr_4(b, l + 1);
    r = r && element_(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // values_?
  private static boolean without_body_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "without_body_expr_0")) return false;
    values_(b, l + 1);
    return true;
  }

  // (types_)?
  private static boolean without_body_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "without_body_expr_1")) return false;
    without_body_expr_1_0(b, l + 1);
    return true;
  }

  // (types_)
  private static boolean without_body_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "without_body_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = types_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CLASS_DEF?
  private static boolean without_body_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "without_body_expr_3")) return false;
    consumeToken(b, CLASS_DEF);
    return true;
  }

  // seq_of?
  private static boolean without_body_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "without_body_expr_4")) return false;
    seq_of(b, l + 1);
    return true;
  }

}
