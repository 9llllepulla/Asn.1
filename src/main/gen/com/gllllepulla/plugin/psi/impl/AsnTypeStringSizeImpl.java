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

public class AsnTypeStringSizeImpl extends ASTWrapperPsiElement implements AsnTypeStringSize {

  public AsnTypeStringSizeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitTypeStringSize(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsnSizeRange getSizeRange() {
    return findChildByClass(AsnSizeRange.class);
  }

  @Override
  @Nullable
  public PsiElement getStringBmp() {
    return findChildByType(STRING_BMP);
  }

  @Override
  @Nullable
  public PsiElement getStringChar() {
    return findChildByType(STRING_CHAR);
  }

  @Override
  @Nullable
  public PsiElement getStringGen() {
    return findChildByType(STRING_GEN);
  }

  @Override
  @Nullable
  public PsiElement getStringGraph() {
    return findChildByType(STRING_GRAPH);
  }

  @Override
  @Nullable
  public PsiElement getStringIa5() {
    return findChildByType(STRING_IA5);
  }

  @Override
  @Nullable
  public PsiElement getStringNum() {
    return findChildByType(STRING_NUM);
  }

  @Override
  @Nullable
  public PsiElement getStringPr() {
    return findChildByType(STRING_PR);
  }

  @Override
  @Nullable
  public PsiElement getStringTele() {
    return findChildByType(STRING_TELE);
  }

  @Override
  @Nullable
  public PsiElement getStringUni() {
    return findChildByType(STRING_UNI);
  }

  @Override
  @Nullable
  public PsiElement getStringUtf8() {
    return findChildByType(STRING_UTF8);
  }

  @Override
  @Nullable
  public PsiElement getStringVis() {
    return findChildByType(STRING_VIS);
  }

  @Override
  @Nullable
  public PsiElement getStringVtext() {
    return findChildByType(STRING_VTEXT);
  }

}
