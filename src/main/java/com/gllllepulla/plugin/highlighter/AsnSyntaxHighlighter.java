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

    public static final Map<TokenGroup, TextAttributesKey> OVERRIDDEN_HIGHLIGHTERS = Map.ofEntries(
            Map.entry(TokenGroup.CONSTRUCTS, DefaultLanguageHighlighterColors.STATIC_METHOD),
            Map.entry(TokenGroup.UNI_TYPES, DefaultLanguageHighlighterColors.CLASS_REFERENCE),
            Map.entry(TokenGroup.TYPE_STRINGS, DefaultLanguageHighlighterColors.STATIC_FIELD),
            Map.entry(TokenGroup.IDENTIFIERS, DefaultLanguageHighlighterColors.STRING),
            Map.entry(TokenGroup.PRIMITIVES, DefaultLanguageHighlighterColors.CLASS_REFERENCE),
            Map.entry(TokenGroup.BIT_STRINGS, DefaultLanguageHighlighterColors.LABEL),
            Map.entry(TokenGroup.BRACKETS, DefaultLanguageHighlighterColors.KEYWORD),
            Map.entry(TokenGroup.OPERATORS, DefaultLanguageHighlighterColors.KEYWORD),
            Map.entry(TokenGroup.COMMENTS, DefaultLanguageHighlighterColors.BLOCK_COMMENT),
            Map.entry(TokenGroup.SYMBOLS, DefaultLanguageHighlighterColors.COMMA),
            Map.entry(TokenGroup.DATE_TIME, DefaultLanguageHighlighterColors.CONSTANT),
            Map.entry(TokenGroup.GLOBAL_TYPES, DefaultLanguageHighlighterColors.GLOBAL_VARIABLE),
            Map.entry(TokenGroup.ASN_BAD_CHARACTER, HighlighterColors.BAD_CHARACTER)
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
