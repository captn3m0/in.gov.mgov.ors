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
    throws IOException
  {
    int i = is.available();
    if (i < remaining) {
      return i;
    }
    return remaining;
  }
  
  public void close()
  {
    try
    {
      is.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public int read()
    throws IOException
  {
    if (remaining <= 0) {
      return -1;
    }
    remaining -= 1;
    return is.read();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = paramInt2;
    if (paramInt2 > remaining) {
      i = remaining;
    }
    paramInt1 = is.read(paramArrayOfByte, paramInt1, i);
    if (paramInt1 > 0) {
      remaining -= paramInt1;
    }
    return paramInt1;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kobjects/io/BoundInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */