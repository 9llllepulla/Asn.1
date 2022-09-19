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
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;

public class AsnFormattingModelBuilder implements FormattingModelBuilder {

    private CodeStyleSettings codeStyleSettings;
    private final Language asnInstance = AsnLanguage.INSTANCE;

    @NotNull
    @Override
    public FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        this.codeStyleSettings = formattingContext.getCodeStyleSettings();
        var asnBlock = new AsnBlock(formattingContext.getNode(), Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(), createSpaceBuilder());
        return FormattingModelProvider.createFormattingModelForPsiFile(formattingContext.getContainingFile(), asnBlock, codeStyleSettings);
    }

    private SpacingBuilder createSpaceBuilder() {
        return new SpacingBuilder(codeStyleSettings, asnInstance)
                .append(comment())
                .append(numberingRule())
                .append(valuesRule())
                .append(typeStringRule());
    }

    private SpacingBuilder valuesRule() {
        return new SpacingBuilder(codeStyleSettings, asnInstance)
                .before(AsnTypes.VALUE_NAME).spaces(1)
                .after(AsnTypes.VALUE_NAME).spaces(1)
                .before(AsnTypes.USER_TYPE).spaces(1)
                .after(AsnTypes.USER_TYPE).spaces(1);
    }

    private SpacingBuilder typeStringRule() {
        return new SpacingBuilder(codeStyleSettings, AsnLanguage.INSTANCE)
                .around(AsnTypes.TYPE_STRING).spaces(1);
    }

    private SpacingBuilder numberingRule() {
        return new SpacingBuilder(codeStyleSettings, asnInstance)
                .around(AsnTypes.INT_ROUND).spaces(1)
                .around(AsnTypes.INT_SQUARE).spaces(1)
                .around(AsnTypes.SIZE_RANGE).spaces(1);
    }

    private SpacingBuilder comment() {
        return new SpacingBuilder(codeStyleSettings, asnInstance)
                .before(AsnTypes.COMMENT_LINE).spaces(5);
    }
}
