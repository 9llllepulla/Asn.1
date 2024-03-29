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

public class AsnData_Impl extends ASTWrapperPsiElement implements AsnData_ {

  public AsnData_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitData_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AsnElementsConst> getElementsConstList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnElementsConst.class);
  }

  @Override
  @Nullable
  public AsnSeqOf getSeqOf() {
    return findChildByClass(AsnSeqOf.class);
  }

  @Override
  @Nullable
  public PsiElement getChoice() {
    return findChildByType(CHOICE);
  }

  @Override
  @Nullable
  public PsiElement getLbrace() {
    return findChildByType(LBRACE);
  }

  @Override
  @Nullable
  public PsiElement getRbrace() {
    return findChildByType(RBRACE);
  }

  @Override
  @Nullable
  public PsiElement getTypeClass() {
    return findChildByType(TYPE_CLASS);
  }

  @Override
  @Nullable
  public PsiElement getUserType() {
    return findChildByType(USER_TYPE);
  }

}
