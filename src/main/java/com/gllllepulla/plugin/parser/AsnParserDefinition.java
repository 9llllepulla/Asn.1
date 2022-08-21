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
    private static final TokenSet COMMENTS_TOKEN = TokenSet.create(COMMENT_LINE, COMMENT_HEADER);

    public static final Map<TokenGroup, TokenSet> TOKEN_GROUPS = Map.of(
            TokenGroup.NUMBERS, TokenSet.create(INT, DOUBLE_DOT, DOT),
            TokenGroup.BRACKETS, TokenSet.create(LPAREN, RPAREN, LBRACE, RBRACE, LBRACKET, RBRACKET),
            TokenGroup.KEYWORDS, TokenSet.create(BEGIN, IMPLICIT, TAGGED, TAGS, CLASS, EXPORTS, IMPORTS, ENUMERATED, SEQUENCE, CHOICE,
                    UNIQUE, OID, DATA, SIZE, FROM, END, DEFINITIONS, WITH_SYNTAX, SEQUENCE_OF),
            TokenGroup.TYPE_KEYWORDS, TokenSet.create(UTC_TIME, UTF8STRING, INTEGER, NULL, OPTIONAL, BOOLEAN, OCTET_STRING,
                    DATE_AND_TIME, IP_ADDRESS, NUMERIC_STRING),
            TokenGroup.OPERATORS, TokenSet.create(LET, COMMA, SEMICOLON, COLON),
            TokenGroup.COMMENTS, COMMENTS_TOKEN,
            TokenGroup.VAR, TokenSet.create(VAR_ID),
            TokenGroup.REF, TokenSet.create(REF_ID),
            TokenGroup.BAD_CHARACTER, TokenSet.create(TokenType.BAD_CHARACTER)
    );

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

    public enum TokenGroup {
        NUMBERS("NUMBERS"),
        COMMENTS("COMMENTS"),
        BRACKETS("BRACKETS"),
        KEYWORDS("KEYWORDS"),
        TYPE_KEYWORDS("TYPE_KEYWORDS"),
        OPERATORS("OPERATORS"),
        VAR("VAR"),
        REF("REF"),
        BAD_CHARACTER("ASN_BAD_CHARACTER");

        private final String groupName;

        TokenGroup(String groupName) {
            this.groupName = groupName;
        }

        public String getGroupName() {
            return groupName;
        }
    }
}
