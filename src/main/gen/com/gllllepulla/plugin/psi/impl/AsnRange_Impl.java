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

public class AsnRange_Impl extends ASTWrapperPsiElement implements AsnRange_ {

  public AsnRange_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitRange_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsnIntRangeExpr getIntRangeExpr() {
    return findChildByClass(AsnIntRangeExpr.class);
  }

  @Override
  @Nullable
  public PsiElement getInteger() {
    return findChildByType(INTEGER);
  }

  @Override
  @NotNull
  public PsiElement getLparen() {
    return findNotNullChildByType(LPAREN);
  }

  @Override
  @NotNull
  public PsiElement getNumberInt() {
    return findNotNullChildByType(NUMBER_INT);
  }

  @Override
  @NotNull
  public PsiElement getRparen() {
    return findNotNullChildByType(RPAREN);
  }

}
