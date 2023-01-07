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

public class AsnOctetStringImpl extends ASTWrapperPsiElement implements AsnOctetString {

  public AsnOctetStringImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitOctetString(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AsnSizeRange getSizeRange() {
    return findNotNullChildByClass(AsnSizeRange.class);
  }

  @Override
  @Nullable
  public PsiElement getBit() {
    return findChildByType(BIT);
  }

  @Override
  @Nullable
  public PsiElement getOctet() {
    return findChildByType(OCTET);
  }

}
