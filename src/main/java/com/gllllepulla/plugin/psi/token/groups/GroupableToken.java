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

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface GroupableToken {

    List<GroupingType> groupingTypes();

    String getDescription();

    TextAttributesKey getGroupHighlighter();

    List<IElementType> getGroupElements();

    default String getGroupName() {
        return getDescription();
    }

    @NotNull
    static Set<GroupableToken> createTokenGroups() {
        Set<GroupableToken> strategy = new HashSet<>();
        strategy.add(new UniversalType());
        strategy.add(new BitString());
        strategy.add(new BadCharacter());
        strategy.add(new WhiteSpace());
        strategy.add(new Symbol());
        strategy.add(new Operator());
        strategy.add(new Braces());
        strategy.add(new Brackets());
        strategy.add(new LineComment());
        strategy.add(new BlockComment());
        strategy.add(new Time());
        strategy.add(new SpecialString());
        strategy.add(new Primitive());
        strategy.add(new GeneralKeyword());
        strategy.add(new Variable());
        strategy.add(new Keyword());
        return strategy;
    }

}
