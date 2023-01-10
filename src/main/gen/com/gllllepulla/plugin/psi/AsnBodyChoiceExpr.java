// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnBodyChoiceExpr extends PsiElement {

  @Nullable
  AsnBodyWithSyntaxExpr getBodyWithSyntaxExpr();

  @NotNull
  List<AsnElementsConst> getElementsConstList();

  @Nullable
  AsnTypes_ getTypes_();

  @Nullable
  AsnValues_ getValues_();

  @NotNull
  PsiElement getAssigment();

  @NotNull
  PsiElement getChoice();

  @Nullable
  PsiElement getClassDef();

  @NotNull
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

}
