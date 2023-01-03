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

package com.gllllepulla.plugin.psi;

import com.gllllepulla.plugin.AsnFileType;
import com.gllllepulla.plugin.AsnLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

/**
 * Базовый класс для реализации PSI.
 * <p>
 * PSI, или Program Structure Interface, дерево строится поверх AST,
 * добавляя семантику и методы для управления конкретными языковыми конструкциями.
 * Узлы дерева PSI представлены классами, реализующими интерфейс PsiElement,
 * и создаются плагином языка в методе ParserDefinition.createElement().
 * Узел верхнего уровня дерева PSI для файла должен реализовывать интерфейс PsiFile
 * и создается в методе ParserDefinition.createFile().
 */
public class AsnFile extends PsiFileBase {

    public AsnFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, AsnLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return AsnFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Asn.1 File";
    }
}
