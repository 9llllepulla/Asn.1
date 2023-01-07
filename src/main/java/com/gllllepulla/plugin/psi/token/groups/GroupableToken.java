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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GroupableToken {

    List<String> groupingTypes();

    String getDescription();

    TextAttributesKey getGroupHighlighter();

    List<IElementType> getGroupElements();

    default String getGroupName() {
        return getDescription();
    }

    @NotNull
    static Map<String, GroupableToken> createTokenGroupStrategy() {
        Map<String, GroupableToken> strategy = new HashMap<>();

        var universalType = new UniversalType();
        strategy.put(universalType.getGroupName(), universalType);

        var bitString = new BitString();
        strategy.put(bitString.getGroupName(), bitString);

        var badCharacter = new BadCharacter();
        strategy.put(bitString.getGroupName(), badCharacter);

        var whiteSpace = new WhiteSpace();
        strategy.put(whiteSpace.getGroupName(), whiteSpace);

        var symbol = new Symbol();
        strategy.put(symbol.getGroupName(), symbol);

        var operator = new Operator();
        strategy.put(operator.getGroupName(), operator);

        var braces = new Braces();
        strategy.put(bitString.getGroupName(), braces);

        var brackets = new Brackets();
        strategy.put(brackets.getGroupName(), brackets);

        var lineComment = new LineComment();
        strategy.put(lineComment.getGroupName(), lineComment);

        var blockComment = new BlockComment();
        strategy.put(blockComment.getGroupName(),blockComment);

        var time = new Time();
        strategy.put(time.getGroupName(), time);

        var specialString = new SpecialString();
        strategy.put(specialString.getGroupName(), specialString);

        var primitive = new Primitive();
        strategy.put(primitive.getGroupName(), primitive);

        var generalKeyword = new GeneralKeyword();
        strategy.put(generalKeyword.getGroupName(), generalKeyword);

        var variable = new Variable();
        strategy.put(variable.getGroupName(), variable);

        var keyword = new Keyword();
        strategy.put(keyword.getGroupName(), keyword);

        return strategy;
    }

}
