package org.jetbrains.java.decompiler.util;

import org.jetbrains.java.decompiler.code.CodeConstants;
import org.jetbrains.java.decompiler.struct.gen.VarType;

import java.util.HashMap;
import java.util.Map;

public class TypeNameConverter {
  private static final Map<Integer, String> primitiveToString;

  static {
    primitiveToString = new HashMap<Integer, String>();

    primitiveToString.put(CodeConstants.TYPE_INT, "int");
    primitiveToString.put(CodeConstants.TYPE_FLOAT, "float");
    primitiveToString.put(CodeConstants.TYPE_LONG, "long");
    primitiveToString.put(CodeConstants.TYPE_DOUBLE, "double");
    primitiveToString.put(CodeConstants.TYPE_BYTE, "byte");
    primitiveToString.put(CodeConstants.TYPE_CHAR, "char");
    primitiveToString.put(CodeConstants.TYPE_SHORT, "short");
    primitiveToString.put(CodeConstants.TYPE_BOOLEAN, "boolean");
    primitiveToString.put(CodeConstants.TYPE_BYTECHAR, "char");
    primitiveToString.put(CodeConstants.TYPE_SHORTCHAR, "char");
  }

  public static String convert(VarType type) {
    String original;

    if (primitiveToString.containsKey(type.type)) {
      original = primitiveToString.get(type.type);
    } else {
      original = type.value.substring(type.value.lastIndexOf("/") + 1);
    }

    return Character.toLowerCase(original.charAt(0)) + original.substring(1);
  }
}
