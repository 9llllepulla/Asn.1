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

import com.gllllepulla.plugin.psi.token.groups.GroupableToken;
import com.gllllepulla.plugin.psi.token.groups.GroupingType;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static com.gllllepulla.plugin.psi.token.groups.GroupingType.*;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static java.util.stream.Collectors.toMap;

final class AsnTokensImpl implements AsnToken {

    private static final Set<GroupableToken> TOKEN_GROUPS = GroupableToken.createTokenGroups();

    @Override
    public Map<TokenSet, TextAttributesKey[]> createTokensHighlighters() {
        return TOKEN_GROUPS.parallelStream()
                .collect(toMap(
                        token -> TokenSet.create(token.getGroupElements().toArray(IElementType[]::new)),
                        token -> {
                            var tokenGroupHighlighter = token.getGroupHighlighter();
                            var textAttributesKey = createTextAttributesKey(token.getGroupName(), tokenGroupHighlighter);
                            return new TextAttributesKey[]{textAttributesKey};
                        }));
    }

    @Override
    public AttributesDescriptor[] createTokensHighlighterDescriptors() {
        Predicate<GroupableToken> isNotBadCharacterToken = token -> token.groupingTypes()
                .parallelStream()
                .noneMatch(groupingType -> groupingType == BAD_CHARACTER);
        return TOKEN_GROUPS.parallelStream()
                .filter(isNotBadCharacterToken)
                .map(token -> {
                    var groupHighlighter = token.getGroupHighlighter();
                    return new AttributesDescriptor(token.getDescription(), groupHighlighter);
                }).toArray(AttributesDescriptor[]::new);
    }

    @Override
    public TokenSet getCommentTokens() {
        return createTokenSet(COMMENT);
    }

    @Override
    public TokenSet getWhiteSpaceTokens() {
        return createTokenSet(WHITESPACE);
    }

    @NotNull
    private TokenSet createTokenSet(GroupingType... groupingTypes) {
        Set<GroupingType> types = Set.of(groupingTypes);
        Predicate<GroupableToken> tokenPredicate = token -> token.groupingTypes()
                .parallelStream()
                .anyMatch(types::contains);
        IElementType[] commentsTypes = TOKEN_GROUPS.parallelStream()
                .filter(tokenPredicate)
                .flatMap(token -> token.getGroupElements().stream())
                .toArray(IElementType[]::new);
        return TokenSet.create(commentsTypes);
    }

}
