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

import com.gllllepulla.plugin.AsnFileType;
import com.gllllepulla.plugin.parser.TokenGroup;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

import static com.gllllepulla.plugin.highlighter.AsnSyntaxHighlighter.OVERRIDDEN_HIGHLIGHTERS;

public class AsnColorSettingsPage implements ColorSettingsPage {

    private final AttributesDescriptor[] descriptors;

    public AsnColorSettingsPage() {
        descriptors = createAttributesDescriptors();
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return AsnFileType.ICON_FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new AsnSyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return "TelcosRecord ::= SEQUENCE {\n" +
                "  telco-id\t\tTelcoID,\t\t\t\t\t--- номер\n" +
                "  begin-time\tDateAndTime,\t\t\t\t--- время начала\n" +
                "  end-time\tDateAndTime OPTIONAL,\t\t\t--- время конца\n" +
                "  description\tUTF8String (SIZE (1 .. 256)),\t\t--- описание\n" +
                "  mcc [0]\t\tNumericString (SIZE(3)) OPTIONAL,\t--- код\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return descriptors;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull @NlsContexts.ConfigurableName String getDisplayName() {
        return "Asn.1";
    }

    private AttributesDescriptor[] createAttributesDescriptors() {
        return OVERRIDDEN_HIGHLIGHTERS.entrySet()
                .parallelStream()
                .filter(entry -> !entry.getKey().equals(TokenGroup.ASN_BAD_CHARACTER))
                .map(entry -> new AttributesDescriptor(entry.getKey().getDescription(), entry.getValue()))
                .toArray(AttributesDescriptor[]::new);
    }
}
