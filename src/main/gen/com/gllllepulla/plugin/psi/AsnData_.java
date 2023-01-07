// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnData_ extends PsiElement {

  @Nullable
  AsnBodyChoice getBodyChoice();

  @Nullable
  AsnSeqOf getSeqOf();

  @NotNull
  PsiElement getTypeClass();

  @Nullable
  PsiElement getUserType();

}
