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

package com.gllllepulla.plugin.psi.token;

enum TokenGroup {
    UNI_TYPES("Universal types"),
    BIT_STRINGS("Bit strings"),
    TYPE_STRINGS("Type strings"),
    BRACES("Braces"),
    BRACKETS("Brackets"),
    OPERATORS("Operators"),
    SYMBOLS("Symbols"),
    BLOCK_COMMENT("Block comment"),
    LINE_COMMENT("Line comment"),
    DATE_TIME("Date and Time"),
    IDENTIFIERS("Identifiers"),
    PRIMITIVES("Primitives"),
    GLOBAL_TYPES("Global types"),
    KEYWORDS("Keywords"),
    ASN_BAD_CHARACTER("ASN_BAD_CHARACTER"),
    WHITE_SPACE_TYPES("Whitespaces");

    private final String description;

    TokenGroup(String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }
}
