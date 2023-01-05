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
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import static com.gllllepulla.plugin.AsnFileType.ASN_TOKEN_INSTANCE;

/**
 * Плагин языка предоставляет реализацию синтаксического анализатора как реализацию интерфейса PsiParser,
 * возвращаемую функцией ParserDefinition.createParser().
 * Парсер получает экземпляр класса PsiBuilder, который используется для получения потока токенов
 * от лексера и хранения промежуточного состояния строящегося AST.
 * Синтаксический анализатор должен обрабатывать все токены, возвращенные лексером, до конца потока,
 * другими словами, пока PsiBuilder.getTokenType() не вернет значение null,
 * даже если токены недействительны в соответствии с синтаксисом языка.
 */
public class AsnParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(AsnLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new AsnLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return ASN_TOKEN_INSTANCE.getWhiteSpaceTokens();
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return ASN_TOKEN_INSTANCE.getCommentTokens();
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
