package org.kobjects.util;

import java.util.Vector;

public class Csv
{
  public static String[] decode(String paramString)
  {
    int i = 94;
    int j = 44;
    int k = 32;
    int m = 34;
    Vector localVector = new java/util/Vector;
    localVector.<init>();
    int n = 0;
    int i1 = paramString.length();
    while (n < i1)
    {
      i2 = paramString.charAt(n);
      if (i2 > k) {
        break;
      }
      n += 1;
    }
    label69:
    String[] arrayOfString;
    Object localObject1;
    if (n >= i1)
    {
      i2 = localVector.size();
      arrayOfString = new String[i2];
      int i3 = 0;
      for (;;)
      {
        i2 = arrayOfString.length;
        if (i3 >= i2) {
          break;
        }
        localObject1 = (String)localVector.elementAt(i3);
        arrayOfString[i3] = localObject1;
        i3 += 1;
      }
    }
    int i2 = paramString.charAt(n);
    StringBuffer localStringBuffer;
    label157:
    int i4;
    int i5;
    if (i2 == m)
    {
      n += 1;
      localStringBuffer = new java/lang/StringBuffer;
      localStringBuffer.<init>();
      i4 = n + 1;
      i5 = paramString.charAt(n);
      if ((i5 == i) && (i4 < i1))
      {
        n = i4 + 1;
        int i6 = paramString.charAt(i4);
        if (i6 == i) {}
        for (;;)
        {
          localStringBuffer.append(i6);
          break;
          i2 = i6 + -64;
          int i7 = (char)i2;
        }
      }
      if (i5 != m) {
        break label477;
      }
      if (i4 != i1)
      {
        i2 = paramString.charAt(i4);
        if (i2 == m) {}
      }
      else
      {
        localObject1 = localStringBuffer.toString();
        localVector.addElement(localObject1);
        n = i4;
        while (n < i1)
        {
          i2 = paramString.charAt(n);
          if (i2 > k) {
            break;
          }
          n += 1;
        }
      }
    }
    label477:
    for (n = i4 + 1;; n = i4)
    {
      localStringBuffer.append(i5);
      break label157;
      if (n >= i1) {
        break label69;
      }
      i2 = paramString.charAt(n);
      if (i2 != j)
      {
        localObject1 = new java/lang/RuntimeException;
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject2 = "Comma expected at " + n + " line: " + paramString;
        ((RuntimeException)localObject1).<init>((String)localObject2);
        throw ((Throwable)localObject1);
      }
      n += 1;
      break;
      int i8 = paramString.indexOf(j, n);
      i2 = -1;
      if (i8 == i2)
      {
        localObject1 = paramString.substring(n).trim();
        localVector.addElement(localObject1);
        break label69;
      }
      localObject1 = paramString.substring(n, i8).trim();
      localVector.addElement(localObject1);
      n = i8 + 1;
      break;
      return arrayOfString;
    }
  }
  
  public static String encode(String paramString, char paramChar)
  {
    char c1 = '^';
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    int i = 0;
    char c2 = paramString.length();
    if (i < c2)
    {
      char c3 = paramString.charAt(i);
      if ((c3 == paramChar) || (c3 == c1))
      {
        localStringBuffer.append(c3);
        localStringBuffer.append(c3);
      }
      for (;;)
      {
        i += 1;
        break;
        c2 = ' ';
        if (c3 < c2)
        {
          localStringBuffer.append(c1);
          c2 = (char)(c3 + '@');
          localStringBuffer.append(c2);
        }
        else
        {
          localStringBuffer.append(c3);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String encode(Object[] paramArrayOfObject)
  {
    char c = '"';
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    int i = 0;
    int j = paramArrayOfObject.length;
    if (i < j)
    {
      if (i != 0)
      {
        j = 44;
        localStringBuffer.append(j);
      }
      Object localObject = paramArrayOfObject[i];
      boolean bool = localObject instanceof Number;
      String str;
      if (!bool)
      {
        bool = localObject instanceof Boolean;
        if (!bool) {}
      }
      else
      {
        str = localObject.toString();
        localStringBuffer.append(str);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(c);
        str = encode(localObject.toString(), c);
        localStringBuffer.append(str);
        localStringBuffer.append(c);
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/util/Csv.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */