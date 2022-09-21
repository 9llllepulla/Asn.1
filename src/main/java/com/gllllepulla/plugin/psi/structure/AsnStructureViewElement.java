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

package com.gllllepulla.plugin.psi.structure;

import com.gllllepulla.plugin.psi.AsnFile;
import com.gllllepulla.plugin.psi.AsnProperty;
import com.gllllepulla.plugin.psi.impl.AsnPropertyImpl;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class AsnStructureViewElement implements StructureViewTreeElement, SortableTreeElement {

    private final NavigatablePsiElement psiElement;

    public AsnStructureViewElement(NavigatablePsiElement psiElement) {
        this.psiElement = psiElement;
    }

    @Override
    public Object getValue() {
        return psiElement;
    }

    @Override
    public @NotNull String getAlphaSortKey() {
        return Optional.ofNullable(psiElement.getName()).orElse("");
    }

    @Override
    public @NotNull ItemPresentation getPresentation() {
        return Optional.ofNullable(psiElement.getPresentation()).orElse(new PresentationData());
    }

    @Override
    public TreeElement @NotNull [] getChildren() {
        if (psiElement instanceof AsnFile) {
            return PsiTreeUtil.getChildrenOfTypeAsList(psiElement, AsnProperty.class).stream()
                    .map(asnProperty -> new AsnStructureViewElement((AsnPropertyImpl)asnProperty))
                    .toArray(TreeElement[]::new);
        }
        return EMPTY_ARRAY;
    }

    @Override
    public void navigate(boolean requestFocus) {
        psiElement.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return psiElement.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return psiElement.canNavigateToSource();
    }
}
