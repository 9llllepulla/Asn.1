// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.gllllepulla.plugin.psi.AsnTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.gllllepulla.plugin.psi.*;

public class AsnBodyTaggedExprImpl extends ASTWrapperPsiElement implements AsnBodyTaggedExpr {

  public AsnBodyTaggedExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitBodyTaggedExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsnBodyWithSyntaxExpr getBodyWithSyntaxExpr() {
    return findChildByClass(AsnBodyWithSyntaxExpr.class);
  }

  @Override
  @NotNull
  public List<AsnData_> getData_List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnData_.class);
  }

  @Override
  @NotNull
  public List<AsnInnerExpr> getInnerExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnInnerExpr.class);
  }

  @Override
  @NotNull
  public List<AsnOid_> getOid_List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnOid_.class);
  }

  @Override
  @NotNull
  public List<AsnSeqOfValue> getSeqOfValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnSeqOfValue.class);
  }

  @Override
  @Nullable
  public AsnTypes_ getTypes_() {
    return findChildByClass(AsnTypes_.class);
  }

  @Override
  @Nullable
  public AsnValues_ getValues_() {
    return findChildByClass(AsnValues_.class);
  }

  @Override
  @NotNull
  public List<AsnValuesOr> getValuesOrList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnValuesOr.class);
  }

  @Override
  @NotNull
  public List<AsnVariables_> getVariables_List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnVariables_.class);
  }

  @Override
  @NotNull
  public PsiElement getAssigment() {
    return findNotNullChildByType(ASSIGMENT);
  }

  @Override
  @Nullable
  public PsiElement getClassDef() {
    return findChildByType(CLASS_DEF);
  }

  @Override
  @NotNull
  public PsiElement getLbrace() {
    return findNotNullChildByType(LBRACE);
  }

  @Override
  @Nullable
  public PsiElement getRbrace() {
    return findChildByType(RBRACE);
  }

}
