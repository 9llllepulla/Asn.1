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

public class AsnBodyWithSyntaxExprImpl extends ASTWrapperPsiElement implements AsnBodyWithSyntaxExpr {

  public AsnBodyWithSyntaxExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitBodyWithSyntaxExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AsnTypes_> getTypes_List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnTypes_.class);
  }

  @Override
  @NotNull
  public List<AsnValues_> getValues_List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AsnValues_.class);
  }

  @Override
  @NotNull
  public PsiElement getLbrace() {
    return findNotNullChildByType(LBRACE);
  }

  @Override
  @Nullable
  public PsiElement getRbrace() {
    return findChildByType(RBRACE);
  }

  @Override
  @NotNull
  public PsiElement getSyntax() {
    return findNotNullChildByType(SYNTAX);
  }

  @Override
  @NotNull
  public PsiElement getWith() {
    return findNotNullChildByType(WITH);
  }

}
