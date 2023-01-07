// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnInnerEnumExpr extends PsiElement {

  @NotNull
  List<AsnEnumElement> getEnumElementList();

  @Nullable
  AsnIntSquare getIntSquare();

  @NotNull
  PsiElement getEnumerated();

  @NotNull
  PsiElement getLbrace();

  @Nullable
  PsiElement getOptional();

  @Nullable
  PsiElement getRbrace();

  @Nullable
  PsiElement getTypeClass();

  @Nullable
  PsiElement getUserType();

  @Nullable
  PsiElement getValueName();

}
