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

public class AsnConstruct_Impl extends ASTWrapperPsiElement implements AsnConstruct_ {

  public AsnConstruct_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitConstruct_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsnElementsConst getElementsConst() {
    return findChildByClass(AsnElementsConst.class);
  }

  @Override
  @Nullable
  public AsnIdTaggedConst getIdTaggedConst() {
    return findChildByClass(AsnIdTaggedConst.class);
  }

  @Override
  @Nullable
  public AsnInnerExpr getInnerExpr() {
    return findChildByClass(AsnInnerExpr.class);
  }

  @Override
  @Nullable
  public AsnSeqOfValue getSeqOfValue() {
    return findChildByClass(AsnSeqOfValue.class);
  }

}
