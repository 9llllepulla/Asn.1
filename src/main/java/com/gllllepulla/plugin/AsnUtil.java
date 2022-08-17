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

package com.gllllepulla.plugin;

import com.gllllepulla.plugin.psi.AsnProperty;
import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class AsnUtil {

    public static List<AsnProperty> findProperties(Project project, String key) {
        return FileTypeIndex.getFiles(AsnFileType.INSTANCE, GlobalSearchScope.allScope(project))
                .stream()
                .flatMap(virtualFile -> Optional.ofNullable(PsiManager.getInstance(project).findFile(virtualFile))
                        .map(asnFile -> PsiTreeUtil.getChildrenOfType(asnFile, AsnProperty.class)).stream()
                        .flatMap(Arrays::stream)
                        .filter(asnProperty -> asnProperty.getKey().equals(key))) // TODO string ??
                .collect(Collectors.toList());
    }

    public static List<AsnProperty> findProperties(Project project) {
        return FileTypeIndex.getFiles(AsnFileType.INSTANCE, GlobalSearchScope.allScope(project))
                .stream()
                .map(virtualFile -> PsiManager.getInstance(project).findFile(virtualFile))
                .filter(Objects::nonNull)
                .map(psiFile -> PsiTreeUtil.getChildrenOfType(psiFile, AsnProperty.class))
                .filter(Objects::nonNull)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    @NotNull
    public static String findDocumentationComment(AsnProperty property) {
        List<String> result = new LinkedList<>();
        PsiElement element = property.getPrevSibling();
        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
            if (element instanceof PsiComment) {
                String commentText = element.getText().replaceFirst("[!# ]+", "");
                result.add(commentText);
            }
            element = element.getPrevSibling();
        }
        return StringUtil.join(Lists.reverse(result), "\n ");
    }
}
