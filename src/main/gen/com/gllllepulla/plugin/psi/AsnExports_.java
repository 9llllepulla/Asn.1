// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnExports_ extends PsiElement {

  @Nullable
  AsnTypes_ getTypes_();

  @NotNull
  List<AsnValues_> getValues_List();

  @NotNull
  PsiElement getExports();

  @Nullable
  PsiElement getSemicolon();

}
