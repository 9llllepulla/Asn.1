// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnBodyEnumExpr extends PsiElement {

  @Nullable
  AsnBodyWithSyntaxExpr getBodyWithSyntaxExpr();

  @NotNull
  List<AsnEnumElement> getEnumElementList();

  @Nullable
  AsnTypes_ getTypes_();

  @Nullable
  AsnValues_ getValues_();

  @NotNull
  PsiElement getAssigment();

  @Nullable
  PsiElement getClassDef();

  @NotNull
  PsiElement getEnumerated();

  @NotNull
  PsiElement getLbrace();

  @Nullable
  PsiElement getOptional();

  @Nullable
  PsiElement getRbrace();

}
