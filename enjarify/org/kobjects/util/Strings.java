package org.kobjects.util;

public class Strings
{
  public static String beautify(String paramString)
  {
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    int i = paramString.length();
    if (i > 0)
    {
      String str = null;
      i = Character.toUpperCase(paramString.charAt(0));
      localStringBuffer.append(i);
      int i1 = 1;
      for (;;)
      {
        int j = paramString.length() + -1;
        if (i1 >= j) {
          break;
        }
        char c = paramString.charAt(i1);
        boolean bool1 = Character.isUpperCase(c);
        if (bool1)
        {
          int k = i1 + -1;
          boolean bool2 = Character.isLowerCase(paramString.charAt(k));
          if (bool2)
          {
            int m = i1 + 1;
            boolean bool3 = Character.isLowerCase(paramString.charAt(m));
            if (bool3)
            {
              str = " ";
              localStringBuffer.append(str);
            }
          }
        }
        localStringBuffer.append(c);
        i1 += 1;
      }
      int n = paramString.length();
      int i2 = 1;
      if (n > i2)
      {
        n = paramString.length() + -1;
        n = paramString.charAt(n);
        localStringBuffer.append(n);
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String fill(String paramString, int paramInt, char paramChar)
  {
    int i;
    int j;
    if (paramInt < 0)
    {
      i = 1;
      paramInt = Math.abs(paramInt);
      j = paramString.length();
      if (j < paramInt) {
        break label30;
      }
    }
    for (;;)
    {
      return paramString;
      i = 0;
      break;
      label30:
      StringBuffer localStringBuffer = new java/lang/StringBuffer;
      localStringBuffer.<init>();
      j = paramString.length();
      paramInt -= j;
      while (paramInt > 0)
      {
        localStringBuffer.append(paramChar);
        paramInt += -1;
      }
      if (i != 0)
      {
        localStringBuffer.append(paramString);
        paramString = localStringBuffer.toString();
      }
      else
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder = localStringBuilder.append(paramString);
        String str = localStringBuffer.toString();
        localStringBuilder = localStringBuilder.append(str);
        paramString = localStringBuilder.toString();
      }
    }
  }
  
  public static String lTrim(String paramString1, String paramString2)
  {
    int i = 0;
    int j = paramString1.length();
    if (i < j)
    {
      int k;
      int m;
      if (paramString2 == null)
      {
        k = paramString1.charAt(i);
        m = 32;
        if (k > m) {}
      }
      else
      {
        do
        {
          i += 1;
          break;
          k = paramString1.charAt(i);
          k = paramString2.indexOf(k);
          m = -1;
        } while (k != m);
      }
    }
    if (i == 0) {}
    for (;;)
    {
      return paramString1;
      paramString1 = paramString1.substring(i);
    }
  }
  
  public static String rTrim(String paramString1, String paramString2)
  {
    int i = paramString1.length();
    int j = i + -1;
    int k;
    if (j >= 0) {
      if (paramString2 == null)
      {
        i = paramString1.charAt(j);
        k = 32;
        if (i > k) {}
      }
      else
      {
        do
        {
          j += -1;
          break;
          i = paramString1.charAt(j);
          i = paramString2.indexOf(i);
          k = -1;
        } while (i != k);
      }
    }
    i = paramString1.length() + -1;
    if (j == i) {}
    for (;;)
    {
      return paramString1;
      i = 0;
      k = j + 1;
      paramString1 = paramString1.substring(0, k);
    }
  }
  
  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    int i = -1;
    int j = paramString1.indexOf(paramString2);
    if (j == i) {
      return paramString1;
    }
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    int k = 0;
    String str = paramString1.substring(0, j);
    localStringBuffer.<init>(str);
    for (;;)
    {
      localStringBuffer.append(paramString3);
      k = paramString2.length();
      j += k;
      int m = paramString1.indexOf(paramString2, j);
      if (m == i)
      {
        str = paramString1.substring(j);
        localStringBuffer.append(str);
        paramString1 = localStringBuffer.toString();
        break;
      }
      str = paramString1.substring(j, m);
      localStringBuffer.append(str);
      j = m;
    }
  }
  
  public static String toAscii(String paramString)
  {
    char c = ' ';
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    int i = 0;
    int j = paramString.length();
    if (i < j)
    {
      int k = paramString.charAt(i);
      if (k <= c) {
        localStringBuffer.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        j = 127;
        if (k < j)
        {
          localStringBuffer.append(k);
        }
        else
        {
          String str;
          switch (k)
          {
          default: 
            j = 63;
            localStringBuffer.append(j);
            break;
          case 196: 
            str = "Ae";
            localStringBuffer.append(str);
            break;
          case 228: 
            str = "ae";
            localStringBuffer.append(str);
            break;
          case 214: 
            str = "Oe";
            localStringBuffer.append(str);
            break;
          case 246: 
            str = "oe";
            localStringBuffer.append(str);
            break;
          case 220: 
            str = "Ue";
            localStringBuffer.append(str);
            break;
          case 252: 
            str = "ue";
            localStringBuffer.append(str);
            break;
          case 223: 
            str = "ss";
            localStringBuffer.append(str);
          }
        }
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/util/Strings.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */