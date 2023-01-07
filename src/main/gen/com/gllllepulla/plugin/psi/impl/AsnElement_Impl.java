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

public class AsnElement_Impl extends ASTWrapperPsiElement implements AsnElement_ {

  public AsnElement_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AsnVisitor visitor) {
    visitor.visitElement_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AsnVisitor) accept((AsnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AsnBool_ getBool_() {
    return findChildByClass(AsnBool_.class);
  }

  @Override
  @Nullable
  public AsnOctetString getOctetString() {
    return findChildByClass(AsnOctetString.class);
  }

  @Override
  @Nullable
  public AsnPrimitiveDef getPrimitiveDef() {
    return findChildByClass(AsnPrimitiveDef.class);
  }

  @Override
  @Nullable
  public AsnRange_ getRange_() {
    return findChildByClass(AsnRange_.class);
  }

  @Override
  @Nullable
  public AsnTime_ getTime_() {
    return findChildByClass(AsnTime_.class);
  }

  @Override
  @Nullable
  public AsnTypeStringSize getTypeStringSize() {
    return findChildByClass(AsnTypeStringSize.class);
  }

  @Override
  @Nullable
  public PsiElement getOptional() {
    return findChildByType(OPTIONAL);
  }

  @Override
  @Nullable
  public PsiElement getUserType() {
    return findChildByType(USER_TYPE);
  }

}
