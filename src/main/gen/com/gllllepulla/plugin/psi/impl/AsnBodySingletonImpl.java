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

public class AsnBodySingletonImpl extends ASTWrapperPsiElement implements AsnBodySingleton {

  public AsnBodySingletonImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitBodySingleton(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsnTypes_ getTypes_() {
    return findChildByClass(AsnTypes_.class);
  }

  @Override
  @Nullable
  public PsiElement getAt() {
    return findChildByType(AT);
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

  @Override
  @Nullable
  public PsiElement getValueName() {
    return findChildByType(VALUE_NAME);
  }

}
