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

package com.gllllepulla.plugin.parser;

import com.gllllepulla.plugin.AsnLanguage;
import com.gllllepulla.plugin.lexer.AsnLexerAdapter;
import com.gllllepulla.plugin.psi.AsnFile;
import com.gllllepulla.plugin.psi.AsnTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static com.gllllepulla.plugin.psi.AsnTypes.*;

public class AsnParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(AsnLanguage.INSTANCE);

    private static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    private static final TokenSet COMMENTS_TOKEN = TokenSet.create(COMMENT_LINE, COMMENT_HEADER, COMMENT_MULTILINE);

    public static final Map<TokenGroup, TokenSet> TOKEN_GROUPS = Map.ofEntries(
            Map.entry(TokenGroup.UNI_TYPES, TokenSet.create(INTEGER, NULL, BOOLEAN, OID, /*OID_IRI, RELATIVE_OID, RELATIVE_OID_IRI,*/ REAL, OPTIONAL, DEFAULT, UNIQUE/*, EOC*/)),
            Map.entry(TokenGroup.BIT_STRINGS, TokenSet.create(BIT, OCTET)),
            Map.entry(TokenGroup.TYPE_STRINGS, TokenSet.create(STRING_BMP, STRING_CHAR, STRING_PR, STRING_GEN, STRING_GRAPH, STRING_IA5, STRING_NUM, STRING_UTF8,
                    STRING_UNI, STRING_VIS, STRING_TELE, STRING_VTEXT)),
            Map.entry(TokenGroup.BRACKETS, TokenSet.create(LPAREN, RPAREN, LBRACKET, RBRACKET)),
            Map.entry(TokenGroup.OPERATORS, TokenSet.create(VAR, ASSIGMENT)),
            Map.entry(TokenGroup.SYMBOLS, TokenSet.create(COMMA, SEMICOLON, DOUBLE_DOT, DOT, OR, MINUS, AT, COLON, DOUBLE_QUOTE)),
            Map.entry(TokenGroup.COMMENTS, COMMENTS_TOKEN),
            Map.entry(TokenGroup.DATE_TIME, TokenSet.create(DURATION, DATE, DATE_TIME, TIME, TIME_GEN, TIME_OF_DAY, TIME_UTC)),
            Map.entry(TokenGroup.IDENTIFIERS, TokenSet.create(USER_TYPE, TYPE_CLASS, VALUE_NAME)),
            Map.entry(TokenGroup.PRIMITIVES, TokenSet.create(STR_LITERALS, NUMBER_FLOAT, NUMBER_INT)),
            Map.entry(TokenGroup.GLOBAL_TYPES, TokenSet.create(UNIVERSAL, APPLICATION, CONTENT_SPECIFIC, PRIVATE)),
            Map.entry(TokenGroup.CONSTRUCTS, TokenSet.create(SET, EXTERNAL, INSTANCE, SEQUENCE, OF, BEGIN, END, DEFINITIONS, FROM, CLASS_DEF, /*TAGGED,*/ ANY,
                    CHOICE, IMPLICIT, EXPLICIT, SIZE, MAX, MIN, ENUMERATED, WITH, SYNTAX,
                    /* other */ TAGS, EXPORTS, IMPORTS, CONTAINING, TYPE_IDENTIFIER)),
            Map.entry(TokenGroup.ASN_BAD_CHARACTER, TokenSet.create(TokenType.BAD_CHARACTER)));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new AsnLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return COMMENTS_TOKEN;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiParser createParser(Project project) {
        return new AsnParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new AsnFile(viewProvider);
    }

    @NotNull
    @Override
    public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return AsnTypes.Factory.createElement(node);
    }

}
