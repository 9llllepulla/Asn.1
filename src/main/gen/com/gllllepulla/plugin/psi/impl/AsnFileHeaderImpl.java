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

public class AsnFileHeaderImpl extends ASTWrapperPsiElement implements AsnFileHeader {

  public AsnFileHeaderImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitFileHeader(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsnExports_ getExports_() {
    return findChildByClass(AsnExports_.class);
  }

  @Override
  @NotNull
  public List<AsnExpr_> getExpr_List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnExpr_.class);
  }

  @Override
  @Nullable
  public AsnImports_ getImports_() {
    return findChildByClass(AsnImports_.class);
  }

  @Override
  @NotNull
  public PsiElement getAssigment() {
    return findNotNullChildByType(ASSIGMENT);
  }

  @Override
  @Nullable
  public PsiElement getBegin() {
    return findChildByType(BEGIN);
  }

  @Override
  @NotNull
  public PsiElement getDefinitions() {
    return findNotNullChildByType(DEFINITIONS);
  }

  @Override
  @Nullable
  public PsiElement getEnd() {
    return findChildByType(END);
  }

  @Override
  @Nullable
  public PsiElement getImplicit() {
    return findChildByType(IMPLICIT);
  }

  @Override
  @Nullable
  public PsiElement getTags() {
    return findChildByType(TAGS);
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
