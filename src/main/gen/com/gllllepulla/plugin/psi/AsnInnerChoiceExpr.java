// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnInnerChoiceExpr extends PsiElement {

  @NotNull
  List<AsnElementsConst> getElementsConstList();

  @Nullable
  AsnIntSquare getIntSquare();

  @NotNull
  PsiElement getChoice();

  @NotNull
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

  @Nullable
  PsiElement getTypeClass();

  @Nullable
  PsiElement getUserType();

  @Nullable
  PsiElement getValueName();

}
