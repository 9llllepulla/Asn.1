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

public class AsnIdTaggedConstImpl extends ASTWrapperPsiElement implements AsnIdTaggedConst {

  public AsnIdTaggedConstImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitIdTaggedConst(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AsnBodySingleton> getBodySingletonList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnBodySingleton.class);
  }

  @Override
  @NotNull
  public AsnValues_ getValues_() {
    return findNotNullChildByClass(AsnValues_.class);
  }

  @Override
  @NotNull
  public PsiElement getDot() {
    return findNotNullChildByType(DOT);
  }

  @Override
  @NotNull
  public PsiElement getLparen() {
    return findNotNullChildByType(LPAREN);
  }

  @Override
  @Nullable
  public PsiElement getRparen() {
    return findChildByType(RPAREN);
  }

  @Override
  @NotNull
  public PsiElement getTypeClass() {
    return findNotNullChildByType(TYPE_CLASS);
  }

  @Override
  @NotNull
  public PsiElement getValueName() {
    return findNotNullChildByType(VALUE_NAME);
  }

  @Override
  @NotNull
  public PsiElement getVar() {
    return findNotNullChildByType(VAR);
  }

}
