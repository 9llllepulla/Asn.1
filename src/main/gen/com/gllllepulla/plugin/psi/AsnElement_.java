// This is a generated file. Not intended for manual editing.
package com.gllllepulla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AsnElement_ extends PsiElement {

  @Nullable
  AsnBool_ getBool_();

  @Nullable
  AsnOctetString getOctetString();

  @Nullable
  AsnPrimitiveDef getPrimitiveDef();

  @Nullable
  AsnRange_ getRange_();

  @Nullable
  AsnTime_ getTime_();

  @Nullable
  AsnTypeStringSize getTypeStringSize();

  @Nullable
  PsiElement getOptional();

  @Nullable
  PsiElement getUserType();

}
