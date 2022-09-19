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

package com.gllllepulla.plugin.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  Блок форматирования - это некоторый диапазон текста (часто соответствующий какому-то PSI-элементу), к которому применяются правила форматирования.
 *  Блоки форматирования вкладываются друг в друга и образуют дерево.
 */
public class AsnBlock extends AbstractBlock {

    private final SpacingBuilder spacingBuilder;

    protected AsnBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment, SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
    }

    @Override
    protected List<Block> buildChildren() {
        return Stream.iterate(myNode.getFirstChildNode(), Objects::nonNull, ASTNode::getTreeNext)
                .filter(child -> child.getElementType() != TokenType.WHITE_SPACE)
                .map(child -> new AsnBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(), spacingBuilder))
                .collect(Collectors.toList());
    }

    // определяет количество пробелов или перенос строк между указанными дочерними элементами
    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public Indent getIndent() {
        return Indent.getNoneIndent();
    }

    @Override
    public boolean isLeaf() {
        return super.myNode.getFirstChildNode() == null;
    }
}
