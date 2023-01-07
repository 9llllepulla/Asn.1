// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnPrimitiveExpr extends PsiElement {

  @Nullable
  AsnBodyWithSyntaxExpr getBodyWithSyntaxExpr();

  @Nullable
  AsnTypes_ getTypes_();

  @Nullable
  AsnValues_ getValues_();

  @NotNull
  PsiElement getAssigment();

  @Nullable
  PsiElement getNumberFloat();

  @Nullable
  PsiElement getNumberInt();

  @Nullable
  PsiElement getStrLiterals();

}
