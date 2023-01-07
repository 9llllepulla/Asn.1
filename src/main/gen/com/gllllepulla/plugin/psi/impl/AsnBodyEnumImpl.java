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

public class AsnBodyEnumImpl extends ASTWrapperPsiElement implements AsnBodyEnum {

  public AsnBodyEnumImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitBodyEnum(this);
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

}
