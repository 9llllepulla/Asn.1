// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnChoiceConstruct extends PsiElement {

  @Nullable
  AsnBodyEnum getBodyEnum();

  @Nullable
  AsnElement_ getElement_();

  @Nullable
  AsnIntSquare getIntSquare();

  @Nullable
  AsnSeqOf getSeqOf();

  @Nullable
  PsiElement getExplicit();

  @Nullable
  PsiElement getImplicit();

  @NotNull
  PsiElement getValueName();

}
