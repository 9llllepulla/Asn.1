// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnIdTaggedConstruct extends PsiElement {

  @NotNull
  List<AsnBodySingleton> getBodySingletonList();

  @NotNull
  AsnValues_ getValues_();

  @NotNull
  PsiElement getDot();

  @NotNull
  PsiElement getLparen();

  @Nullable
  PsiElement getRparen();

  @NotNull
  PsiElement getTypeClass();

  @NotNull
  PsiElement getValueName();

  @NotNull
  PsiElement getVar();

}
