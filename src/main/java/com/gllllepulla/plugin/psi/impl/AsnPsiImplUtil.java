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

package com.gllllepulla.plugin.psi.impl;

import com.gllllepulla.plugin.psi.AsnProperty;
import com.gllllepulla.plugin.psi.AsnTypes;
import com.intellij.lang.ASTNode;

import javax.annotation.Nullable;
import java.util.Optional;

public class AsnPsiImplUtil {

    @Nullable
    public static String getKey(AsnProperty element) {
        return Optional.ofNullable(element.getNode().findChildByType(AsnTypes.KEY))
                // IMPORTANT: Convert embedded escaped spaces to simple spaces
                .map(astNode -> astNode.getText().replaceAll("\\\\ ", " "))
                .orElse(null);
    }

    @Nullable
    public static String getValue(AsnProperty element) {
        return Optional.ofNullable(element.getNode().findChildByType(AsnTypes.VALUE))
                .map(ASTNode::getText)
                .orElse(null);
    }
}
