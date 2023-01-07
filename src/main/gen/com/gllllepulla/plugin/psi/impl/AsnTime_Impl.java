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

public class AsnTime_Impl extends ASTWrapperPsiElement implements AsnTime_ {

  public AsnTime_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitTime_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getDate() {
    return findChildByType(DATE);
  }

  @Override
  @Nullable
  public PsiElement getDateTime() {
    return findChildByType(DATE_TIME);
  }

  @Override
  @Nullable
  public PsiElement getDuration() {
    return findChildByType(DURATION);
  }

  @Override
  @Nullable
  public PsiElement getTime() {
    return findChildByType(TIME);
  }

  @Override
  @Nullable
  public PsiElement getTimeGen() {
    return findChildByType(TIME_GEN);
  }

  @Override
  @Nullable
  public PsiElement getTimeOfDay() {
    return findChildByType(TIME_OF_DAY);
  }

  @Override
  @Nullable
  public PsiElement getTimeUtc() {
    return findChildByType(TIME_UTC);
  }

}
