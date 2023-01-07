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

public class AsnFrom_Impl extends ASTWrapperPsiElement implements AsnFrom_ {

  public AsnFrom_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitFrom_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AsnValues_> getValues_List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnValues_.class);
  }

  @Override
  @NotNull
  public PsiElement getFrom() {
    return findNotNullChildByType(FROM);
  }

  @Override
  @NotNull
  public PsiElement getUserType() {
    return findNotNullChildByType(USER_TYPE);
  }

}
