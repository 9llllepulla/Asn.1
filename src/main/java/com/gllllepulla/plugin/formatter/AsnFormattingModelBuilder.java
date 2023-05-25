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

import com.gllllepulla.plugin.AsnLanguage;
import com.gllllepulla.plugin.psi.AsnTypes;
import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;

import static com.gllllepulla.plugin.AsnFileType.ASN_TOKEN_INSTANCE;

public class AsnFormattingModelBuilder implements FormattingModelBuilder {

    private CodeStyleSettings codeStyleSettings;

    @NotNull
    @Override
    public FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        this.codeStyleSettings = formattingContext.getCodeStyleSettings();
        var asnBlock = new AsnBlock(formattingContext.getNode(), Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(), createSpaceBuilder());
        return FormattingModelProvider.createFormattingModelForPsiFile(formattingContext.getContainingFile(), asnBlock, codeStyleSettings);
    }

    private SpacingBuilder createSpaceBuilder() {
        return new SpacingBuilder(codeStyleSettings, AsnLanguage.INSTANCE)
                .append(comment())
                .append(atRule())
                .append(numberingRule())
                .append(valuesRule())
                .append(headerRule())
                .append(typeStringRule());
    }

    private SpacingBuilder valuesRule() {
        return new SpacingBuilder(codeStyleSettings, AsnLanguage.INSTANCE)
                .before(AsnTypes.TYPES_).spaces(1)
                .after(AsnTypes.TYPES_).spaceIf(false);
    }

    private SpacingBuilder typeStringRule() {
        return new SpacingBuilder(codeStyleSettings, AsnLanguage.INSTANCE)
                .around(AsnTypes.TYPE_STRING_SIZE).spaces(1);
    }

    private SpacingBuilder numberingRule() {
        return new SpacingBuilder(codeStyleSettings, AsnLanguage.INSTANCE)
                .before(AsnTypes.RANGE_).spaces(1)
                .around(AsnTypes.INT_SQUARE).spaces(1)
                .around(AsnTypes.SIZE_RANGE).spaces(1);
    }

    private SpacingBuilder atRule() {
        return new SpacingBuilder(codeStyleSettings, AsnLanguage.INSTANCE)
                .before(AsnTypes.AT).spaces(1)
                .after(AsnTypes.AT).none();
    }

    private SpacingBuilder headerRule() {
        return new SpacingBuilder(codeStyleSettings, AsnLanguage.INSTANCE)
                .around(AsnTypes.FILE_HEADER).spaceIf(false);
    }

    private SpacingBuilder comment() {
        return new SpacingBuilder(codeStyleSettings, AsnLanguage.INSTANCE)
                .before(ASN_TOKEN_INSTANCE.getCommentTokens()).spaces(3);
    }
}
