// Copyright 2000-2017 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.java.decompiler.main.collectors;

import org.jetbrains.java.decompiler.struct.gen.VarType;
import org.jetbrains.java.decompiler.util.TypeNameConverter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class VarNamesCollector {

  private final Set<String> usedNames = new HashSet<>();

  public VarNamesCollector() {
  }

  public VarNamesCollector(Collection<String> setNames) {
    usedNames.addAll(setNames);
  }

  public void addName(String value) {
    usedNames.add(value);
  }

  public String getFreeName(int index) {
    return getFreeName("var" + index);
  }

  public String getFreeName(VarType type) {
    String prefix = TypeNameConverter.convert(type);
    int index = 1;
    while (usedNames.contains(prefix + index))
      index++;

    usedNames.add(prefix + index);
    return prefix + index;
  }

  public String getFreeName(String proposition) {
    while (usedNames.contains(proposition)) {
      proposition += "x";
    }
    usedNames.add(proposition);
    return proposition;
  }
}
