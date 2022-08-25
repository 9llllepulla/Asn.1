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

    public static final Map<TokenGroup, TextAttributesKey> OVERRIDDEN_HIGHLIGHTERS = Map.of(
            TokenGroup.KEYWORDS, DefaultLanguageHighlighterColors.STATIC_METHOD,
            TokenGroup.NUMBERS, DefaultLanguageHighlighterColors.CLASS_REFERENCE,
            TokenGroup.BRACKETS, DefaultLanguageHighlighterColors.KEYWORD,
            TokenGroup.TYPE_KEYWORDS, DefaultLanguageHighlighterColors.STATIC_FIELD,
            TokenGroup.OPERATORS, DefaultLanguageHighlighterColors.KEYWORD,
            TokenGroup.COMMENTS, DefaultLanguageHighlighterColors.BLOCK_COMMENT,
            TokenGroup.VAR, DefaultLanguageHighlighterColors.STRING,
            TokenGroup.REF, DefaultLanguageHighlighterColors.CLASS_REFERENCE,
            TokenGroup.ASN_BAD_CHARACTER, HighlighterColors.BAD_CHARACTER
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
                .parallelStream()
                .filter(tokenSet -> tokenSet.contains(tokenType))
                .findAny()
                .map(asnDefinitions::get)
                .orElse(new TextAttributesKey[0]);
    }

    private Map<TokenSet, TextAttributesKey[]> createAsnDefinitions() {
        return OVERRIDDEN_HIGHLIGHTERS.entrySet()
                .stream()
                .collect(toMap(
                        entry -> AsnParserDefinition.TOKEN_GROUPS.get(entry.getKey()),
                        entry -> {
                            var textAttributesKey = createTextAttributesKey(entry.getKey().name(), entry.getValue());
                            return new TextAttributesKey[]{textAttributesKey};
                        }));
    }

}
