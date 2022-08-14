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
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Register type of file
 */
public class AsnFileType extends LanguageFileType {

    public static final LanguageFileType INSTANCE = new AsnFileType();

    private AsnFileType() {
        super(AsnLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "ASN.1 File";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "ASN.1 - Abstract Syntax Notation One, a language for describing structured information";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "asn";
    }

    @Override
    public @Nullable Icon getIcon() {
        return null;
    }

    @Override
    public boolean isReadOnly() {
        return super.isReadOnly();
    }

    @Override
    public @NonNls @Nullable String getCharset(@NotNull VirtualFile file, byte @NotNull [] content) {
        return super.getCharset(file, content);
    }
}
