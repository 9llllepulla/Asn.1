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

package com.gllllepulla.plugin.highlighter;

import com.gllllepulla.plugin.lexer.AsnLexerAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static com.gllllepulla.plugin.AsnFileType.ASN_TOKEN_INSTANCE;

public class AsnSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final Map<TokenSet, TextAttributesKey[]> TOKENS_HIGHLIGHTERS = ASN_TOKEN_INSTANCE.createTokensHighlighters();

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new AsnLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return TOKENS_HIGHLIGHTERS.entrySet().stream()
                .filter(entry -> entry.getKey().contains(tokenType))
                .findAny()
                .map(Map.Entry::getValue)
                .orElse(new TextAttributesKey[0]);
    }

}
