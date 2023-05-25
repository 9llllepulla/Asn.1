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
import com.intellij.psi.tree.TokenSet;

import java.util.List;

import static com.gllllepulla.plugin.psi.AsnTypes.*;
import static com.gllllepulla.plugin.psi.token.groups.GroupingType.PRIMITIVE;

/**
 * Primitive types of ASN lang: NUMBER_FLOAT, NUMBER_INT, STR_LITERALS, FALSE, TRUE
 */
class Primitive implements GroupableToken {

    @Override
    public List<GroupingType> groupingTypes() {
        return List.of(PRIMITIVE);
    }

    @Override
    public String getDescription() {
        return "Primitive types";
    }

    @Override
    public TextAttributesKey getGroupHighlighter() {
        return DefaultLanguageHighlighterColors.CLASS_REFERENCE;
    }

    @Override
    public List<IElementType> getGroupElements() {
        return List.of(NUMBER_FLOAT, NUMBER_INT, STR_LITERALS, FALSE, TRUE);
    }

}
