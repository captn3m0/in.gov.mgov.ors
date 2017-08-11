package org.kobjects.util;

import java.io.InputStream;
import java.io.OutputStream;

public final class Util
{
  public static String buildUrl(String paramString1, String paramString2)
  {
    int i = 58;
    int j = paramString2.indexOf(i);
    Object localObject = "/";
    int k = paramString2.startsWith((String)localObject);
    String str;
    if (k == 0)
    {
      k = 1;
      if (j != k) {}
    }
    else
    {
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      str = "file:///";
      localObject = ((StringBuilder)localObject).append(str).append(paramString2);
      paramString2 = ((StringBuilder)localObject).toString();
    }
    int n;
    do
    {
      return paramString2;
      int m = 2;
      if (j <= m) {
        break;
      }
      n = 6;
    } while (j < n);
    if (paramString1 == null) {
      paramString1 = "file:///";
    }
    for (;;)
    {
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = ((StringBuilder)localObject).append(paramString1).append(paramString2);
      paramString2 = ((StringBuilder)localObject).toString();
      break;
      int i1 = paramString1.indexOf(i);
      i = -1;
      if (i1 == i)
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        str = "file:///";
        localObject = ((StringBuilder)localObject).append(str).append(paramString1);
        paramString1 = ((StringBuilder)localObject).toString();
      }
      localObject = "/";
      boolean bool = paramString1.endsWith((String)localObject);
      if (!bool)
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        localObject = ((StringBuilder)localObject).append(paramString1);
        str = "/";
        localObject = ((StringBuilder)localObject).append(str);
        paramString1 = ((StringBuilder)localObject).toString();
      }
    }
  }
  
  public static int indexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    int i = 0;
    int j = paramArrayOfObject.length;
    if (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      boolean bool = localObject.equals(paramObject);
      if (!bool) {}
    }
    for (;;)
    {
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static void sort(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    int i = 2;
    int j = paramInt2 - paramInt1;
    Object localObject1;
    String str;
    Object localObject2;
    if (j <= i)
    {
      j = paramInt2 - paramInt1;
      if (j == i)
      {
        localObject1 = paramArrayOfObject[paramInt1].toString();
        i = paramInt1 + 1;
        str = paramArrayOfObject[i].toString();
        j = ((String)localObject1).compareTo(str);
        if (j > 0)
        {
          localObject2 = paramArrayOfObject[paramInt1];
          j = paramInt1 + 1;
          localObject1 = paramArrayOfObject[j];
          paramArrayOfObject[paramInt1] = localObject1;
          j = paramInt1 + 1;
          paramArrayOfObject[j] = localObject2;
        }
      }
    }
    for (;;)
    {
      return;
      j = paramInt2 - paramInt1;
      i = 3;
      if (j == i)
      {
        j = paramInt1 + 2;
        sort(paramArrayOfObject, paramInt1, j);
        j = paramInt1 + 1;
        i = paramInt1 + 3;
        sort(paramArrayOfObject, j, i);
        j = paramInt1 + 2;
        sort(paramArrayOfObject, paramInt1, j);
      }
      else
      {
        int k = (paramInt1 + paramInt2) / 2;
        sort(paramArrayOfObject, paramInt1, k);
        sort(paramArrayOfObject, k, paramInt2);
        j = paramInt2 - paramInt1;
        localObject2 = new Object[j];
        int m = paramInt1;
        int n = k;
        int i1 = 0;
        j = localObject2.length;
        if (i1 < j)
        {
          int i2;
          if (m == k)
          {
            i2 = n + 1;
            localObject1 = paramArrayOfObject[n];
            localObject2[i1] = localObject1;
            n = i2;
          }
          for (;;)
          {
            i1 += 1;
            break;
            if (n != paramInt2)
            {
              localObject1 = paramArrayOfObject[m].toString();
              str = paramArrayOfObject[n].toString();
              j = ((String)localObject1).compareTo(str);
              if (j >= 0) {}
            }
            else
            {
              int i3 = m + 1;
              localObject1 = paramArrayOfObject[m];
              localObject2[i1] = localObject1;
              m = i3;
              continue;
            }
            i2 = n + 1;
            localObject1 = paramArrayOfObject[n];
            localObject2[i1] = localObject1;
            n = i2;
          }
        }
        j = 0;
        localObject1 = null;
        i = localObject2.length;
        System.arraycopy(localObject2, 0, paramArrayOfObject, paramInt1, i);
      }
    }
  }
  
  public static OutputStream streamcopy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    Runtime localRuntime = Runtime.getRuntime();
    long l1 = localRuntime.freeMemory();
    long l2 = 1048576L;
    boolean bool = l1 < l2;
    int i;
    byte[] arrayOfByte;
    if (!bool)
    {
      i = 16384;
      arrayOfByte = new byte[i];
    }
    for (;;)
    {
      i = arrayOfByte.length;
      int j = paramInputStream.read(arrayOfByte, 0, i);
      i = -1;
      if (j == i)
      {
        paramInputStream.close();
        return paramOutputStream;
        i = 128;
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/util/Util.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */