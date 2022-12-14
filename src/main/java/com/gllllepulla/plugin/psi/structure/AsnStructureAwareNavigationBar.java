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

import com.gllllepulla.plugin.AsnLanguage;
import com.gllllepulla.plugin.psi.AsnFile;
import com.gllllepulla.plugin.psi.AsnProperty;
import com.intellij.icons.AllIcons;
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension;
import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AsnStructureAwareNavigationBar extends StructureAwareNavBarModelExtension {

    @Nullable
    @Override
    public Icon getIcon(Object object) {
        if (object instanceof AsnProperty) {
            return AllIcons.Nodes.Property;
        }
        return null;
    }

    @Nullable
    @Override
    public String getPresentableText(Object object) {
        if (object instanceof AsnFile) {
            return ((AsnFile)object).getName();
        }
        if (object instanceof AsnProperty) {
            return ((AsnProperty)object).getText();
        }
        return null;
    }

    @NotNull
    @Override
    protected Language getLanguage() {
        return AsnLanguage.INSTANCE;
    }
}
