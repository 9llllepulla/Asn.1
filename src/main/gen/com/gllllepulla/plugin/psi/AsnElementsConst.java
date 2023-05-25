// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnElementsConst extends PsiElement {

  @Nullable
  AsnElement_ getElement_();

  @NotNull
  List<AsnEnumElement> getEnumElementList();

  @Nullable
  AsnIntSquare getIntSquare();

  @Nullable
  AsnSeqOf getSeqOf();

  @Nullable
  PsiElement getEnumerated();

  @Nullable
  PsiElement getExplicit();

  @Nullable
  PsiElement getImplicit();

  @Nullable
  PsiElement getLbrace();

  @Nullable
  PsiElement getOptional();

  @Nullable
  PsiElement getRbrace();

  @NotNull
  PsiElement getValueName();

}
