// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnWithoutBodyExpr extends PsiElement {

  @NotNull
  AsnElement_ getElement_();

  @Nullable
  AsnSeqOf getSeqOf();

  @Nullable
  AsnTypes_ getTypes_();

  @Nullable
  AsnValues_ getValues_();

  @NotNull
  PsiElement getAssigment();

  @Nullable
  PsiElement getClassDef();

}
