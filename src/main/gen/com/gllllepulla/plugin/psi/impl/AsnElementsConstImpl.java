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

public class AsnElementsConstImpl extends ASTWrapperPsiElement implements AsnElementsConst {

  public AsnElementsConstImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitElementsConst(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsnElement_ getElement_() {
    return findChildByClass(AsnElement_.class);
  }

  @Override
  @NotNull
  public List<AsnEnumElement> getEnumElementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnEnumElement.class);
  }

  @Override
  @Nullable
  public AsnIntSquare getIntSquare() {
    return findChildByClass(AsnIntSquare.class);
  }

  @Override
  @Nullable
  public AsnSeqOf getSeqOf() {
    return findChildByClass(AsnSeqOf.class);
  }

  @Override
  @Nullable
  public PsiElement getEnumerated() {
    return findChildByType(ENUMERATED);
  }

  @Override
  @Nullable
  public PsiElement getExplicit() {
    return findChildByType(EXPLICIT);
  }

  @Override
  @Nullable
  public PsiElement getImplicit() {
    return findChildByType(IMPLICIT);
  }

  @Override
  @Nullable
  public PsiElement getLbrace() {
    return findChildByType(LBRACE);
  }

  @Override
  @Nullable
  public PsiElement getOptional() {
    return findChildByType(OPTIONAL);
  }

  @Override
  @Nullable
  public PsiElement getRbrace() {
    return findChildByType(RBRACE);
  }

  @Override
  @NotNull
  public PsiElement getValueName() {
    return findNotNullChildByType(VALUE_NAME);
  }

}
