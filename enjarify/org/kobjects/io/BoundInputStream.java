package org.kobjects.io;

import java.io.IOException;
import java.io.InputStream;

public class BoundInputStream
  extends InputStream
{
  InputStream is;
  int remaining;
  
  public BoundInputStream(InputStream paramInputStream, int paramInt)
  {
    is = paramInputStream;
    remaining = paramInt;
  }
  
  public int available()
  {
    InputStream localInputStream = is;
    int i = localInputStream.available();
    int j = remaining;
    if (i < j) {}
    for (;;)
    {
      return i;
      i = remaining;
    }
  }
  
  public void close()
  {
    try
    {
      InputStream localInputStream = is;
      localInputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public int read()
  {
    int i = remaining;
    if (i <= 0) {}
    InputStream localInputStream;
    for (i = -1;; i = localInputStream.read())
    {
      return i;
      i = remaining + -1;
      remaining = i;
      localInputStream = is;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = remaining;
    if (paramInt2 > i) {
      paramInt2 = remaining;
    }
    InputStream localInputStream = is;
    int j = localInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (j > 0)
    {
      i = remaining - j;
      remaining = i;
    }
    return j;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/io/BoundInputStream.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */