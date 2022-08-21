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
import com.gllllepulla.plugin.parser.AsnParserDefinition;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static java.util.stream.Collectors.toMap;
import static com.gllllepulla.plugin.parser.AsnParserDefinition.*;

public class AsnSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final Map<TokenName, TextAttributesKey> OVERRIDDEN_HIGHLIGHTERS = Map.of(
            TokenName.KEYWORDS, DefaultLanguageHighlighterColors.STATIC_METHOD,
            TokenName.NUMBERS, DefaultLanguageHighlighterColors.CLASS_REFERENCE,
            TokenName.BRACKETS, DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE,
            TokenName.TYPE_KEYWORDS, DefaultLanguageHighlighterColors.STATIC_FIELD,
            TokenName.OPERATORS, DefaultLanguageHighlighterColors.KEYWORD,
            TokenName.COMMENTS, DefaultLanguageHighlighterColors.BLOCK_COMMENT,
            TokenName.BAD_CHARACTER, HighlighterColors.BAD_CHARACTER
    );

    private static Map<TokenSet, TextAttributesKey[]> asnDefinitions;

    public AsnSyntaxHighlighter() {
        if (asnDefinitions == null) {
            asnDefinitions = createAsnDefinitions();
        }
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new AsnLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return asnDefinitions.keySet()
                .stream()
                .filter(tokenSet -> tokenSet.contains(tokenType))
                .findFirst()
                .map(asnDefinitions::get)
                .orElse(new TextAttributesKey[0]);
    }

    private Map<TokenSet, TextAttributesKey[]> createAsnDefinitions() {
        return OVERRIDDEN_HIGHLIGHTERS.entrySet()
                .stream()
                .collect(toMap(
                        entry -> AsnParserDefinition.TOKEN_GROUPS.get(entry.getKey()),
                        entry -> {
                            var textAttributesKey = createTextAttributesKey(entry.getKey().getTokenName(), entry.getValue());
                            return new TextAttributesKey[]{textAttributesKey};
                        }));
    }

}
