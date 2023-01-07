// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnSequenceConstruct extends PsiElement {

  @Nullable
  AsnChoiceConstruct getChoiceConstruct();

  @Nullable
  AsnIdTaggedConstruct getIdTaggedConstruct();

  @Nullable
  AsnInnerExpr getInnerExpr();

  @Nullable
  AsnSeqOfValue getSeqOfValue();

}
