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

package com.gllllepulla.plugin.psi.token.groups;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.tree.IElementType;

import java.util.List;

import static com.gllllepulla.plugin.psi.AsnTypes.*;
import static com.gllllepulla.plugin.psi.AsnTypes.SEMICOLON;

/**
 * Types of symbols of ASN lang: COLON, COMMA, DOT, DOUBLE_DOT, DOUBLE_QUOTE, MINUS, OR, SEMICOLON
 */
class Symbol implements GroupableToken {

    @Override
    public List<String> groupingTypes() {
        return List.of("symbol");
    }

    @Override
    public String getDescription() {
        return "Symbols types";
    }

    @Override
    public TextAttributesKey getGroupHighlighter() {
        return DefaultLanguageHighlighterColors.COMMA;
    }

    @Override
    public List<IElementType> getGroupElements() {
        return List.of(COLON, COMMA, DOT, DOUBLE_DOT, DOUBLE_QUOTE, MINUS, OR, SEMICOLON);
    }

}
