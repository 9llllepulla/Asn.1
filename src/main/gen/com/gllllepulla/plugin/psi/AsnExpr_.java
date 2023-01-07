// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnExpr_ extends PsiElement {

  @Nullable
  AsnBodyChoiceExpr getBodyChoiceExpr();

  @Nullable
  AsnBodyEnumExpr getBodyEnumExpr();

  @Nullable
  AsnBodySequenceExpr getBodySequenceExpr();

  @Nullable
  AsnBodyTaggedExpr getBodyTaggedExpr();

  @Nullable
  AsnPrimitiveExpr getPrimitiveExpr();

  @Nullable
  AsnWithoutBodyExpr getWithoutBodyExpr();

}
