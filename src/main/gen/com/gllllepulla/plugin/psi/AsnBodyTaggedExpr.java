// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnBodyTaggedExpr extends PsiElement {

  @Nullable
  AsnBodyWithSyntaxExpr getBodyWithSyntaxExpr();

  @NotNull
  List<AsnData_> getData_List();

  @NotNull
  List<AsnInnerExpr> getInnerExprList();

  @NotNull
  List<AsnOid_> getOid_List();

  @NotNull
  List<AsnSeqOfValue> getSeqOfValueList();

  @Nullable
  AsnTypes_ getTypes_();

  @Nullable
  AsnValues_ getValues_();

  @NotNull
  List<AsnValuesOr> getValuesOrList();

  @NotNull
  List<AsnVariables_> getVariables_List();

  @NotNull
  PsiElement getAssigment();

  @Nullable
  PsiElement getClassDef();

  @NotNull
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

}
