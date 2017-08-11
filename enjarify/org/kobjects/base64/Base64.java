package org.kobjects.base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64
{
  static final char[] charTab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  
  static int decode(char paramChar)
  {
    char c = 'A';
    if (paramChar >= c)
    {
      c = 'Z';
      if (paramChar <= c) {
        c = paramChar + '﾿';
      }
    }
    for (;;)
    {
      return c;
      c = 'a';
      if (paramChar >= c)
      {
        c = 'z';
        if (paramChar <= c)
        {
          c = paramChar + 'ﾟ' + 26;
          continue;
        }
      }
      c = '0';
      if (paramChar >= c)
      {
        c = '9';
        if (paramChar <= c)
        {
          c = paramChar + '￐' + 26 + 26;
          continue;
        }
      }
      RuntimeException localRuntimeException;
      switch (paramChar)
      {
      default: 
        localRuntimeException = new java/lang/RuntimeException;
        Object localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        localObject = "unexpected code: " + paramChar;
        localRuntimeException.<init>((String)localObject);
        throw localRuntimeException;
      case '+': 
        c = '>';
        break;
      case '/': 
        c = '?';
        break;
      case '=': 
        c = '\000';
        localRuntimeException = null;
      }
    }
  }
  
  public static void decode(String paramString, OutputStream paramOutputStream)
  {
    int i = 61;
    int j = 0;
    int k = paramString.length();
    for (;;)
    {
      int n;
      if (j < k)
      {
        m = paramString.charAt(j);
        n = 32;
        if (m <= n)
        {
          j += 1;
          continue;
        }
      }
      if (j == k) {}
      int i1;
      do
      {
        do
        {
          return;
          m = decode(paramString.charAt(j)) << 18;
          n = j + 1;
          n = decode(paramString.charAt(n)) << 12;
          m += n;
          n = j + 2;
          n = decode(paramString.charAt(n)) << 6;
          m += n;
          n = j + 3;
          n = decode(paramString.charAt(n));
          i1 = m + n;
          m = i1 >> 16 & 0xFF;
          paramOutputStream.write(m);
          m = j + 2;
          m = paramString.charAt(m);
        } while (m == i);
        m = i1 >> 8 & 0xFF;
        paramOutputStream.write(m);
        m = j + 3;
        m = paramString.charAt(m);
      } while (m == i);
      int m = i1 & 0xFF;
      paramOutputStream.write(m);
      j += 4;
    }
  }
  
  public static byte[] decode(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
    localByteArrayOutputStream.<init>();
    try
    {
      decode(paramString, localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      RuntimeException localRuntimeException = new java/lang/RuntimeException;
      localRuntimeException.<init>();
      throw localRuntimeException;
    }
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return encode(paramArrayOfByte, 0, i, null).toString();
  }
  
  public static StringBuffer encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, StringBuffer paramStringBuffer)
  {
    int i;
    if (paramStringBuffer == null)
    {
      paramStringBuffer = new java/lang/StringBuffer;
      i = paramArrayOfByte.length * 3 / 2;
      paramStringBuffer.<init>(i);
    }
    int m = paramInt2 + -3;
    int n = paramInt1;
    int i1 = 0;
    int i6;
    Object localObject;
    int i4;
    for (char c4 = '\000'; n <= m; c4 = i1)
    {
      i = (paramArrayOfByte[n] & 0xFF) << 16;
      int i2 = n + 1;
      i2 = (paramArrayOfByte[i2] & 0xFF) << 8;
      i |= i2;
      int i3 = n + 2;
      i3 = paramArrayOfByte[i3] & 0xFF;
      i6 = i | i3;
      localObject = charTab;
      i4 = i6 >> 18 & 0x3F;
      i = localObject[i4];
      paramStringBuffer.append(i);
      localObject = charTab;
      i4 = i6 >> 12 & 0x3F;
      char c1 = localObject[i4];
      paramStringBuffer.append(c1);
      localObject = charTab;
      i4 = i6 >> 6 & 0x3F;
      c1 = localObject[i4];
      paramStringBuffer.append(c1);
      localObject = charTab;
      i4 = i6 & 0x3F;
      c1 = localObject[i4];
      paramStringBuffer.append(c1);
      n += 3;
      i1 = c4 + '\001';
      c1 = '\016';
      if (c4 >= c1)
      {
        i1 = 0;
        localObject = "\r\n";
        paramStringBuffer.append((String)localObject);
      }
    }
    int j = paramInt1 + paramInt2 + -2;
    int i5;
    if (n == j)
    {
      j = (paramArrayOfByte[n] & 0xFF) << 16;
      i4 = n + 1;
      i4 = (paramArrayOfByte[i4] & 0xFF) << 8;
      i6 = j | i4;
      localObject = charTab;
      i5 = i6 >> 18 & 0x3F;
      j = localObject[i5];
      paramStringBuffer.append(j);
      localObject = charTab;
      i5 = i6 >> 12 & 0x3F;
      char c2 = localObject[i5];
      paramStringBuffer.append(c2);
      localObject = charTab;
      i5 = i6 >> 6 & 0x3F;
      c2 = localObject[i5];
      paramStringBuffer.append(c2);
      localObject = "=";
      paramStringBuffer.append((String)localObject);
    }
    for (;;)
    {
      return paramStringBuffer;
      int k = paramInt1 + paramInt2 + -1;
      if (n == k)
      {
        i6 = (paramArrayOfByte[n] & 0xFF) << 16;
        localObject = charTab;
        i5 = i6 >> 18 & 0x3F;
        k = localObject[i5];
        paramStringBuffer.append(k);
        localObject = charTab;
        i5 = i6 >> 12 & 0x3F;
        char c3 = localObject[i5];
        paramStringBuffer.append(c3);
        localObject = "==";
        paramStringBuffer.append((String)localObject);
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/base64/Base64.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */