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
import com.gllllepulla.plugin.psi.AsnTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class AsnSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR = createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY = createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey VALUE = createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STATIC_FIELD);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final Map<IElementType, TextAttributesKey[]> TYPES = new HashMap<>(){
        {
            put(AsnTypes.SEPARATOR, new TextAttributesKey[]{SEPARATOR});
            put(AsnTypes.KEY, new TextAttributesKey[]{KEY});
            put(AsnTypes.VALUE, new TextAttributesKey[]{VALUE});
            put(AsnTypes.COMMENT, new TextAttributesKey[]{COMMENT});
            put(TokenType.BAD_CHARACTER, new TextAttributesKey[]{BAD_CHARACTER});
        }
    };

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new AsnLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return Optional.ofNullable(TYPES.get(tokenType))
                .orElse(new TextAttributesKey[0]);
    }

}
