// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnData_ extends PsiElement {

  @NotNull
  List<AsnElementsConst> getElementsConstList();

  @Nullable
  AsnSeqOf getSeqOf();

  @Nullable
  PsiElement getChoice();

  @Nullable
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

  @Nullable
  PsiElement getTypeClass();

  @Nullable
  PsiElement getUserType();

}
