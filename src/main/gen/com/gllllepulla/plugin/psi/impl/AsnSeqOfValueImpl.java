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

public class AsnSeqOfValueImpl extends ASTWrapperPsiElement implements AsnSeqOfValue {

  public AsnSeqOfValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitSeqOfValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AsnSeqOf getSeqOf() {
    return findNotNullChildByClass(AsnSeqOf.class);
  }

  @Override
  @NotNull
  public AsnValues_ getValues_() {
    return findNotNullChildByClass(AsnValues_.class);
  }

  @Override
  @Nullable
  public PsiElement getOptional() {
    return findChildByType(OPTIONAL);
  }

  @Override
  @NotNull
  public PsiElement getUserType() {
    return findNotNullChildByType(USER_TYPE);
  }

}
