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

public class AsnInnerEnumExprImpl extends ASTWrapperPsiElement implements AsnInnerEnumExpr {

  public AsnInnerEnumExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitInnerEnumExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
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
  @NotNull
  public PsiElement getEnumerated() {
    return findNotNullChildByType(ENUMERATED);
  }

  @Override
  @NotNull
  public PsiElement getLbrace() {
    return findNotNullChildByType(LBRACE);
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
  @Nullable
  public PsiElement getTypeClass() {
    return findChildByType(TYPE_CLASS);
  }

  @Override
  @Nullable
  public PsiElement getUserType() {
    return findChildByType(USER_TYPE);
  }

  @Override
  @Nullable
  public PsiElement getValueName() {
    return findChildByType(VALUE_NAME);
  }

}
