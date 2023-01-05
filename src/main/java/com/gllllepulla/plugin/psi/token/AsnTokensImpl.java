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

    private TextAttributesKey getTokenGroupHighlighter(TokenGroup tokenGroup) {
        switch (tokenGroup) {
            case EXPRESSIONS:
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
            case COMMENTS:
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
                return TokenSet.create(INTEGER, NULL, BOOLEAN, OID, REAL, OPTIONAL, DEFAULT, UNIQUE);
            case BIT_STRINGS:
                return TokenSet.create(BIT, OCTET);
            case TYPE_STRINGS:
                return TokenSet.create(STRING_BMP, STRING_CHAR, STRING_PR, STRING_GEN, STRING_GRAPH, STRING_IA5,
                        STRING_NUM, STRING_UTF8, STRING_UNI, STRING_VIS, STRING_TELE, STRING_VTEXT);
            case BRACKETS:
                return TokenSet.create(LPAREN, RPAREN, LBRACKET, RBRACKET);
            case OPERATORS:
                return TokenSet.create(VAR, ASSIGMENT);
            case SYMBOLS:
                return TokenSet.create(COMMA, SEMICOLON, DOUBLE_DOT, DOT, OR, MINUS, AT, COLON, DOUBLE_QUOTE);
            case COMMENTS:
                return TokenSet.create(COMMENT_LINE, COMMENT_HEADER, COMMENT_MULTILINE);
            case DATE_TIME:
                return TokenSet.create(DURATION, DATE, DATE_TIME, TIME, TIME_GEN, TIME_OF_DAY, TIME_UTC);
            case IDENTIFIERS:
                return TokenSet.create(USER_TYPE, TYPE_CLASS, VALUE_NAME);
            case PRIMITIVES:
                return TokenSet.create(STR_LITERALS, NUMBER_FLOAT, NUMBER_INT);
            case GLOBAL_TYPES:
                return TokenSet.create(UNIVERSAL, APPLICATION, CONTENT_SPECIFIC, PRIVATE);
            case EXPRESSIONS:
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
        return getTokenSetByGroup(TokenGroup.COMMENTS);
    }

    @Override
    public TokenSet getWhiteSpaceTokens() {
        return getTokenSetByGroup(TokenGroup.WHITE_SPACE_TYPES);
    }

}
