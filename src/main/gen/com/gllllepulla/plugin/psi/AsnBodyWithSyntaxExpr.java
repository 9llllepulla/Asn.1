// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnBodyWithSyntaxExpr extends PsiElement {

  @NotNull
  List<AsnTypes_> getTypes_List();

  @NotNull
  List<AsnValues_> getValues_List();

  @NotNull
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

  @NotNull
  PsiElement getSyntax();

  @NotNull
  PsiElement getWith();

}
