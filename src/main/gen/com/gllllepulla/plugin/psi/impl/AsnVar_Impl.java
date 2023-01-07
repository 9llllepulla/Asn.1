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

public class AsnVar_Impl extends ASTWrapperPsiElement implements AsnVar_ {

  public AsnVar_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitVar_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AsnValues_ getValues_() {
    return findNotNullChildByClass(AsnValues_.class);
  }

  @Override
  @Nullable
  public PsiElement getUnique() {
    return findChildByType(UNIQUE);
  }

  @Override
  @Nullable
  public PsiElement getUserType() {
    return findChildByType(USER_TYPE);
  }

  @Override
  @NotNull
  public PsiElement getVar() {
    return findNotNullChildByType(VAR);
  }

}
