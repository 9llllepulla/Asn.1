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

public class AsnIntSquareImpl extends ASTWrapperPsiElement implements AsnIntSquare {

  public AsnIntSquareImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitIntSquare(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getLbracket() {
    return findNotNullChildByType(LBRACKET);
  }

  @Override
  @Nullable
  public PsiElement getNumberInt() {
    return findChildByType(NUMBER_INT);
  }

  @Override
  @Nullable
  public PsiElement getRbracket() {
    return findChildByType(RBRACKET);
  }

}
