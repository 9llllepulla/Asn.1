/*
 * Copyright 2022 Sergey Lyashko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gllllepulla.plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Register type of file
 */
public class AsnFileType extends LanguageFileType {

    public static final LanguageFileType INSTANCE = new AsnFileType();
    public static final Icon ICON_FILE = IconLoader.getIcon("META-INF/pluginIcon.svg", AsnFileType.class);

    private AsnFileType() {
        super(AsnLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Asn.1 File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "ASN.1 - Abstract Syntax Notation One, a language for describing structured information";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "asn";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ICON_FILE;
    }
}
