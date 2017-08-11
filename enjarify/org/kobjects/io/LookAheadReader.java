package org.kobjects.io;

import java.io.Reader;

public class LookAheadReader
  extends Reader
{
  char[] buf;
  int bufPos;
  int bufValid;
  Reader reader;
  
  public LookAheadReader(Reader paramReader)
  {
    Object localObject = Runtime.getRuntime();
    long l1 = ((Runtime)localObject).freeMemory();
    long l2 = 1000000L;
    boolean bool = l1 < l2;
    if (bool) {}
    for (int i = 16384;; i = 128)
    {
      localObject = new char[i];
      buf = ((char[])localObject);
      bufPos = 0;
      bufValid = 0;
      reader = paramReader;
      return;
    }
  }
  
  public void close()
  {
    reader.close();
  }
  
  public int peek(int paramInt)
  {
    int i = -1;
    int j = 127;
    Object localObject;
    if (paramInt > j)
    {
      localObject = new java/lang/RuntimeException;
      ((RuntimeException)localObject).<init>("peek > 127 not supported!");
      throw ((Throwable)localObject);
    }
    int k;
    int m;
    char[] arrayOfChar;
    do
    {
      j = bufValid + k;
      bufValid = j;
      j = bufValid;
      if (paramInt < j) {
        break;
      }
      j = bufPos;
      m = bufValid;
      j += m;
      m = buf.length;
      int n = j % m;
      j = buf.length - n;
      m = buf.length;
      int i1 = bufValid;
      m -= i1;
      k = Math.min(j, m);
      Reader localReader = reader;
      arrayOfChar = buf;
      k = localReader.read(arrayOfChar, n, k);
    } while (k != i);
    for (;;)
    {
      return i;
      localObject = buf;
      j = bufPos;
      arrayOfChar = buf;
      m = arrayOfChar.length;
      m = paramInt % m;
      j += m;
      i = localObject[j];
    }
  }
  
  public int read()
  {
    int i = peek(0);
    int j = -1;
    if (i != j)
    {
      j = bufPos + 1;
      bufPos = j;
      char[] arrayOfChar = buf;
      int k = arrayOfChar.length;
      if (j == k) {
        bufPos = 0;
      }
      j = bufValid + -1;
      bufValid = j;
    }
    return i;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = -1;
    int j = bufValid;
    char[] arrayOfChar1;
    if (j == 0)
    {
      arrayOfChar1 = null;
      j = peek(0);
      if (j != i) {}
    }
    for (;;)
    {
      return i;
      i = bufValid;
      if (paramInt2 > i) {
        paramInt2 = bufValid;
      }
      char[] arrayOfChar2 = buf;
      i = arrayOfChar2.length;
      j = bufPos;
      i -= j;
      if (paramInt2 > i)
      {
        arrayOfChar2 = buf;
        i = arrayOfChar2.length;
        j = bufPos;
        paramInt2 = i - j;
      }
      arrayOfChar2 = buf;
      j = bufPos;
      System.arraycopy(arrayOfChar2, j, paramArrayOfChar, paramInt1, paramInt2);
      i = bufValid - paramInt2;
      bufValid = i;
      i = bufPos + paramInt2;
      bufPos = i;
      i = bufPos;
      arrayOfChar1 = buf;
      j = arrayOfChar1.length;
      if (i > j)
      {
        i = bufPos;
        arrayOfChar1 = buf;
        j = arrayOfChar1.length;
        i -= j;
        bufPos = i;
      }
      i = paramInt2;
    }
  }
  
  public String readLine()
  {
    int i = peek(0);
    int j = -1;
    String str1;
    if (i == j) {
      str1 = null;
    }
    for (;;)
    {
      return str1;
      String str2 = "\r\n";
      str1 = readTo(str2);
      i = read();
      j = 13;
      if (i == j)
      {
        i = peek(0);
        j = 10;
        if (i == j) {
          read();
        }
      }
    }
  }
  
  public String readTo(char paramChar)
  {
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    for (;;)
    {
      char c1 = peek(0);
      char c2 = '￿';
      if (c1 == c2) {
        break;
      }
      c1 = peek(0);
      if (c1 == paramChar) {
        break;
      }
      c1 = (char)read();
      localStringBuffer.append(c1);
    }
    return localStringBuffer.toString();
  }
  
  public String readTo(String paramString)
  {
    int i = -1;
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    for (;;)
    {
      int j = peek(0);
      if (j == i) {
        break;
      }
      j = (char)peek(0);
      j = paramString.indexOf(j);
      if (j != i) {
        break;
      }
      j = (char)read();
      localStringBuffer.append(j);
    }
    return localStringBuffer.toString();
  }
  
  public String readWhile(String paramString)
  {
    int i = -1;
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    for (;;)
    {
      int j = peek(0);
      if (j == i) {
        break;
      }
      j = (char)peek(0);
      j = paramString.indexOf(j);
      if (j == i) {
        break;
      }
      j = (char)read();
      localStringBuffer.append(j);
    }
    return localStringBuffer.toString();
  }
  
  public void skip(String paramString)
  {
    int i = -1;
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    for (;;)
    {
      int j = peek(0);
      if (j == i) {
        break;
      }
      j = (char)peek(0);
      j = paramString.indexOf(j);
      if (j == i) {
        break;
      }
      read();
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/io/LookAheadReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */