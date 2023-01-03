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

package com.gllllepulla.plugin.parser;

public enum TokenGroup {
    UNI_TYPES("Universal type"),
    BIT_STRINGS("Bit string"),
    TYPE_STRINGS("Type string"),
    BRACKETS("Brackets"),
    OPERATORS("Operator"),
    SYMBOLS("Symbol"),
    COMMENTS("Comment"),
    DATE_TIME("Date and Time"),
    IDENTIFIERS("Identifier"),
    PRIMITIVES("Primitive"),
    GLOBAL_TYPES("Global type"),
    CONSTRUCTS("Construct definition"),
    ASN_BAD_CHARACTER("ASN_BAD_CHARACTER");

    private final String description;

    TokenGroup(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
