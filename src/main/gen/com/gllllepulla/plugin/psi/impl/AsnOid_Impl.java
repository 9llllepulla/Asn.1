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

public class AsnOid_Impl extends ASTWrapperPsiElement implements AsnOid_ {

  public AsnOid_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitOid_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsnBodySingleton getBodySingleton() {
    return findChildByClass(AsnBodySingleton.class);
  }

  @Override
  @NotNull
  public PsiElement getOid() {
    return findNotNullChildByType(OID);
  }

  @Override
  @Nullable
  public PsiElement getValueName() {
    return findChildByType(VALUE_NAME);
  }

}
