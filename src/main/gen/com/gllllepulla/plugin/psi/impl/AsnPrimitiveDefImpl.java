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

public class AsnPrimitiveDefImpl extends ASTWrapperPsiElement implements AsnPrimitiveDef {

  public AsnPrimitiveDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitPrimitiveDef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getInteger() {
    return findChildByType(INTEGER);
  }

  @Override
  @Nullable
  public PsiElement getNull() {
    return findChildByType(NULL);
  }

  @Override
  @Nullable
  public PsiElement getReal() {
    return findChildByType(REAL);
  }

}
