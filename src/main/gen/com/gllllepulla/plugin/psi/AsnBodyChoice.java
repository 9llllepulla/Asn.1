// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnBodyChoice extends PsiElement {

  @NotNull
  List<AsnChoiceConstruct> getChoiceConstructList();

  @NotNull
  PsiElement getChoice();

  @NotNull
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

}
