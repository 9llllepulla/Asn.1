/*
 * Copyright 2022 Sergey Lyashko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gllllepulla.plugin.psi.token;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Map;

import static com.gllllepulla.plugin.psi.AsnTypes.*;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static java.util.stream.Collectors.toMap;

final class AsnTokensImpl implements AsnToken {

    @Override
    public Map<TokenSet, TextAttributesKey[]> createTokensHighlighters() {
        return Arrays.stream(TokenGroup.values())
                .collect(toMap(
                        this::getTokenSetByGroup,
                        tokenGroup -> {
                            var tokenGroupHighlighter = getTokenGroupHighlighter(tokenGroup);
                            var textAttributesKey = createTextAttributesKey(tokenGroup.name(), tokenGroupHighlighter);
                            return new TextAttributesKey[]{textAttributesKey};
                        }));
    }

    @NotNull
    @Override
    public AttributesDescriptor[] createTokensHighlighterDescriptors() {
        return Arrays.stream(TokenGroup.values())
                .filter(tokenGroup -> tokenGroup != TokenGroup.ASN_BAD_CHARACTER)
                .map(tokenGroup -> {
                    var highlighterColor = getTokenGroupHighlighter(tokenGroup);
                    return new AttributesDescriptor(tokenGroup.getDescription(), highlighterColor);
                }).toArray(AttributesDescriptor[]::new);
    }

    private TextAttributesKey getTokenGroupHighlighter(TokenGroup tokenGroup) { // todo решить проблему одинаковых switch
        switch (tokenGroup) {
            case KEYWORDS:
                return DefaultLanguageHighlighterColors.STATIC_METHOD;
            case UNI_TYPES:
                return DefaultLanguageHighlighterColors.CLASS_REFERENCE;
            case TYPE_STRINGS:
                return DefaultLanguageHighlighterColors.STATIC_FIELD;
            case IDENTIFIERS:
                return DefaultLanguageHighlighterColors.STRING;
            case PRIMITIVES:
                return DefaultLanguageHighlighterColors.CLASS_REFERENCE;
            case BIT_STRINGS:
                return DefaultLanguageHighlighterColors.LABEL;
            case BRACKETS:
                return DefaultLanguageHighlighterColors.KEYWORD;
            case OPERATORS:
                return DefaultLanguageHighlighterColors.KEYWORD;
            case LINE_COMMENT:
                return DefaultLanguageHighlighterColors.BLOCK_COMMENT;
            case SYMBOLS:
                return DefaultLanguageHighlighterColors.COMMA;
            case DATE_TIME:
                return DefaultLanguageHighlighterColors.CONSTANT;
            case GLOBAL_TYPES:
                return DefaultLanguageHighlighterColors.GLOBAL_VARIABLE;
            case ASN_BAD_CHARACTER:
                return HighlighterColors.BAD_CHARACTER;
            case WHITE_SPACE_TYPES:
                return HighlighterColors.NO_HIGHLIGHTING;
            default:
                throw new IllegalArgumentException("Highlighting for TokenGroup: " + tokenGroup + " not defined");
        }
    }

    @NotNull
    private TokenSet getTokenSetByGroup(TokenGroup tokenGroup) {
        switch (tokenGroup) {
            case UNI_TYPES:
                return TokenSet.create(BOOLEAN, DEFAULT, INTEGER, NULL, OID, OPTIONAL, REAL, UNIQUE);
            case BIT_STRINGS:
                return TokenSet.create(BIT, OCTET);
            case TYPE_STRINGS:
                return TokenSet.create(STRING_BMP, STRING_CHAR, STRING_GEN, STRING_GRAPH, STRING_IA5, STRING_NUM, STRING_PR, STRING_TELE, STRING_UNI,
                        STRING_UTF8, STRING_VIS, STRING_VTEXT);
            case BRACES:
                return TokenSet.create(LBRACE, RBRACE);
            case BRACKETS:
                return TokenSet.create(LPAREN, RPAREN, LBRACKET, RBRACKET);
            case OPERATORS:
                return TokenSet.create(AT, VAR, ASSIGMENT);
            case SYMBOLS:
                return TokenSet.create(COLON, COMMA, DOT, DOUBLE_DOT, DOUBLE_QUOTE, MINUS, OR, SEMICOLON);
            case BLOCK_COMMENT:
                return TokenSet.create(COMMENT_MULTILINE);
            case LINE_COMMENT:
                return TokenSet.create(COMMENT_LINE, COMMENT_HEADER);
            case DATE_TIME:
                return TokenSet.create(DATE, DATE_TIME, DURATION, TIME, TIME_GEN, TIME_OF_DAY, TIME_UTC);
            case IDENTIFIERS:
                return TokenSet.create(TYPE_CLASS, USER_TYPE, VALUE_NAME);
            case PRIMITIVES:
                return TokenSet.create(NUMBER_FLOAT, NUMBER_INT, STR_LITERALS, FALSE, TRUE);
            case GLOBAL_TYPES:
                return TokenSet.create(APPLICATION, CONTENT_SPECIFIC, PRIVATE, UNIVERSAL);
            case KEYWORDS:
                return TokenSet.create(SET, EXTERNAL, INSTANCE, SEQUENCE, OF, BEGIN, END, DEFINITIONS, FROM, CLASS_DEF, ANY, CHOICE, IMPLICIT, EXPLICIT, SIZE,
                        MAX, MIN, ENUMERATED, WITH, SYNTAX, TAGS, EXPORTS, IMPORTS, CONTAINING, TYPE_IDENTIFIER);
            case ASN_BAD_CHARACTER:
                return TokenSet.create(TokenType.BAD_CHARACTER);
            case WHITE_SPACE_TYPES:
                return TokenSet.create(TokenType.WHITE_SPACE);
            default:
                throw new IllegalArgumentException("TokenSet for TokenGroup: " + tokenGroup + " not defined");
        }
    }

    @Override
    public TokenSet getCommentTokens() {
        return getTokenSetByGroup(TokenGroup.LINE_COMMENT);
    }

    @Override
    public TokenSet getWhiteSpaceTokens() {
        return getTokenSetByGroup(TokenGroup.WHITE_SPACE_TYPES);
    }

}
    /*
  // выражения
  IElementType BODY_CHOICE_EXPR = new AsnElementType("BODY_CHOICE_EXPR");
        IElementType BODY_CHOICE = new AsnElementType("BODY_CHOICE");

  IElementType BODY_ENUM_EXPR = new AsnElementType("BODY_ENUM_EXPR");
        IElementType BODY_ENUM = new AsnElementType("BODY_ENUM");

  IElementType BODY_SEQUENCE_EXPR = new AsnElementType("BODY_SEQUENCE_EXPR");
  IElementType BODY_TAGGED_EXPR = new AsnElementType("BODY_TAGGED_EXPR");

  IElementType INNER_EXPR = new AsnElementType("INNER_CONSTRUCT");
        IElementType INNER_CHOICE_EXPR = new AsnElementType("INNER_CONSTRUCT_CHOICE_EXPR");
        IElementType INNER_ENUM_EXPR = new AsnElementType("INNER_CONSTRUCT_ENUM_EXPR");

  IElementType PRIMITIVE_EXPR = new AsnElementType("PRIMITIVE_EXPR");
  IElementType WITHOUT_BODY_EXPR = new AsnElementType("WITHOUT_BODY_EXPR");
  IElementType BODY_WITH_SYNTAX_EXPR = new AsnElementType("WITH_SYNTAX_EXPR");
  IElementType BODY_SINGLETON = new AsnElementType("SINGLETON_BODY");
  IElementType ID_TAGGED_CONSTRUCT = new AsnElementType("ID_TAGGED");
  IElementType ENUM_ELEMENT = new AsnElementType("ENUM_ELEMENT");

  IElementType IMPORTS_ = new AsnElementType("IMPORTS_");
  IElementType FROM_ = new AsnElementType("FROM_");
  IElementType FILE_HEADER = new AsnElementType("FILE_HEADER");
  IElementType EXPORTS_ = new AsnElementType("EXPORTS_");

  // значения в скобках
  IElementType INT_SQUARE = new AsnElementType("INT_SQUARE");
  IElementType RANGE_ = new AsnElementType("RANGE_");
  IElementType SIZE_RANGE = new AsnElementType("SIZE_RANGE");
  IElementType INT_RANGE_EXPR
  */
