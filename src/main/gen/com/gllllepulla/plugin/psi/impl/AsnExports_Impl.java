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

public class AsnExports_Impl extends ASTWrapperPsiElement implements AsnExports_ {

  public AsnExports_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitExports_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsnAllValues_ getAllValues_() {
    return findChildByClass(AsnAllValues_.class);
  }

  @Override
  @NotNull
  public List<AsnValues_> getValues_List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnValues_.class);
  }

  @Override
  @NotNull
  public PsiElement getExports() {
    return findNotNullChildByType(EXPORTS);
  }

  @Override
  @Nullable
  public PsiElement getOid() {
    return findChildByType(OID);
  }

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(SEMICOLON);
  }

}
