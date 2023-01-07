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

public class AsnExpr_Impl extends ASTWrapperPsiElement implements AsnExpr_ {

  public AsnExpr_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitExpr_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsnBodyChoiceExpr getBodyChoiceExpr() {
    return findChildByClass(AsnBodyChoiceExpr.class);
  }

  @Override
  @Nullable
  public AsnBodyEnumExpr getBodyEnumExpr() {
    return findChildByClass(AsnBodyEnumExpr.class);
  }

  @Override
  @Nullable
  public AsnBodySequenceExpr getBodySequenceExpr() {
    return findChildByClass(AsnBodySequenceExpr.class);
  }

  @Override
  @Nullable
  public AsnBodyTaggedExpr getBodyTaggedExpr() {
    return findChildByClass(AsnBodyTaggedExpr.class);
  }

  @Override
  @Nullable
  public AsnPrimitiveExpr getPrimitiveExpr() {
    return findChildByClass(AsnPrimitiveExpr.class);
  }

  @Override
  @Nullable
  public AsnWithoutBodyExpr getWithoutBodyExpr() {
    return findChildByClass(AsnWithoutBodyExpr.class);
  }

}
