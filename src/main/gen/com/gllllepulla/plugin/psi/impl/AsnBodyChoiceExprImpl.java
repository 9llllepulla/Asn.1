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

public class AsnBodyChoiceExprImpl extends ASTWrapperPsiElement implements AsnBodyChoiceExpr {

  public AsnBodyChoiceExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitBodyChoiceExpr(this);
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
  public List<AsnChoiceConstruct> getChoiceConstructList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnChoiceConstruct.class);
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
  public PsiElement getAssigment() {
    return findNotNullChildByType(ASSIGMENT);
  }

  @Override
  @NotNull
  public PsiElement getChoice() {
    return findNotNullChildByType(CHOICE);
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
