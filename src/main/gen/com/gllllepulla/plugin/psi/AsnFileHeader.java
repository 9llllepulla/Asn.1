// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnFileHeader extends PsiElement {

  @Nullable
  AsnExports_ getExports_();

  @NotNull
  List<AsnExpr_> getExpr_List();

  @Nullable
  AsnImports_ getImports_();

  @NotNull
  PsiElement getAssigment();

  @Nullable
  PsiElement getBegin();

  @NotNull
  PsiElement getDefinitions();

  @Nullable
  PsiElement getEnd();

  @Nullable
  PsiElement getImplicit();

  @Nullable
  PsiElement getTags();

  @Nullable
  PsiElement getTypeClass();

  @Nullable
  PsiElement getUserType();

}
