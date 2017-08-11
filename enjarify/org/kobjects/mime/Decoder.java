package org.kobjects.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import org.kobjects.base64.Base64;

public class Decoder
{
  String boundary;
  char[] buf;
  String characterEncoding;
  boolean consumed;
  boolean eof;
  Hashtable header;
  InputStream is;
  
  public Decoder(InputStream paramInputStream, String paramString)
  {
    this(paramInputStream, paramString, null);
  }
  
  public Decoder(InputStream paramInputStream, String paramString1, String paramString2)
  {
    int i = 256;
    Object localObject = new char[i];
    buf = ((char[])localObject);
    characterEncoding = paramString2;
    is = paramInputStream;
    localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    String str1 = "--";
    localObject = str1 + paramString1;
    boundary = ((String)localObject);
    String str2 = null;
    do
    {
      str2 = readLine();
      if (str2 == null)
      {
        localObject = new java/io/IOException;
        ((IOException)localObject).<init>("Unexpected EOF");
        throw ((Throwable)localObject);
      }
      localObject = boundary;
      bool2 = str2.startsWith((String)localObject);
    } while (!bool2);
    localObject = "--";
    boolean bool2 = str2.endsWith((String)localObject);
    if (bool2)
    {
      eof = bool1;
      paramInputStream.close();
    }
    consumed = bool1;
  }
  
  public static Hashtable getHeaderElements(String paramString)
  {
    int i = 59;
    int j = 34;
    int k = -1;
    String str = "";
    int m = 0;
    Hashtable localHashtable = new java/util/Hashtable;
    localHashtable.<init>();
    int n = paramString.length();
    for (;;)
    {
      int i1;
      if (m < n)
      {
        i1 = paramString.charAt(m);
        int i2 = 32;
        if (i1 <= i2)
        {
          m += 1;
          continue;
        }
      }
      if (m >= n) {}
      int i3;
      label308:
      do
      {
        for (;;)
        {
          return localHashtable;
          i1 = paramString.charAt(m);
          if (i1 == j)
          {
            m += 1;
            i3 = paramString.indexOf(j, m);
            Object localObject2;
            if (i3 == k)
            {
              localObject1 = new java/lang/RuntimeException;
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>();
              localObject2 = "End quote expected in " + paramString;
              ((RuntimeException)localObject1).<init>((String)localObject2);
              throw ((Throwable)localObject1);
            }
            localObject1 = paramString.substring(m, i3);
            localHashtable.put(str, localObject1);
            m = i3 + 2;
            if (m < n)
            {
              i1 = m + -1;
              i1 = paramString.charAt(i1);
              if (i1 == i) {
                break label308;
              }
              localObject1 = new java/lang/RuntimeException;
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>();
              localObject2 = "; expected in " + paramString;
              ((RuntimeException)localObject1).<init>((String)localObject2);
              throw ((Throwable)localObject1);
            }
          }
          else
          {
            i3 = paramString.indexOf(i, m);
            if (i3 != k) {
              break;
            }
            localObject1 = paramString.substring(m);
            localHashtable.put(str, localObject1);
          }
        }
        localObject1 = paramString.substring(m, i3);
        localHashtable.put(str, localObject1);
        m = i3 + 1;
        i1 = 61;
        i3 = paramString.indexOf(i1, m);
      } while (i3 == k);
      Object localObject1 = paramString.substring(m, i3).toLowerCase();
      str = ((String)localObject1).trim();
      m = i3 + 1;
    }
  }
  
  private final String readLine()
  {
    int i = -1;
    int j = 0;
    for (;;)
    {
      Object localObject = is;
      int k = ((InputStream)localObject).read();
      if ((k == i) && (j == 0))
      {
        m = 0;
        localObject = null;
      }
      char[] arrayOfChar1;
      for (;;)
      {
        return (String)localObject;
        if (k != i)
        {
          m = 10;
          if (k != m) {
            break;
          }
        }
        localObject = new java/lang/String;
        arrayOfChar1 = buf;
        ((String)localObject).<init>(arrayOfChar1, 0, j);
      }
      int m = 13;
      if (k != m)
      {
        localObject = buf;
        m = localObject.length;
        if (j >= m)
        {
          m = buf.length * 3 / 2;
          char[] arrayOfChar2 = new char[m];
          localObject = buf;
          arrayOfChar1 = buf;
          n = arrayOfChar1.length;
          System.arraycopy(localObject, 0, arrayOfChar2, 0, n);
          buf = arrayOfChar2;
        }
        localObject = buf;
        int i1 = j + 1;
        int n = (char)k;
        localObject[j] = n;
        j = i1;
      }
    }
  }
  
  public String getHeader(String paramString)
  {
    Hashtable localHashtable = header;
    String str = paramString.toLowerCase();
    return (String)localHashtable.get(str);
  }
  
  public Enumeration getHeaderNames()
  {
    return header.keys();
  }
  
  public boolean next()
  {
    boolean bool1 = false;
    IOException localIOException = null;
    boolean bool2 = consumed;
    if (!bool2)
    {
      bool2 = false;
      localObject = null;
      readContent(null);
    }
    bool2 = eof;
    if (bool2) {
      return bool1;
    }
    Object localObject = new java/util/Hashtable;
    ((Hashtable)localObject).<init>();
    header = ((Hashtable)localObject);
    for (;;)
    {
      String str1 = readLine();
      if (str1 != null)
      {
        localObject = "";
        bool2 = str1.equals(localObject);
        if (!bool2) {}
      }
      else
      {
        consumed = false;
        bool1 = true;
        break;
      }
      int j = str1.indexOf(':');
      int i = -1;
      if (j == i)
      {
        localIOException = new java/io/IOException;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        localObject = "colon missing in multipart header line: " + str1;
        localIOException.<init>((String)localObject);
        throw localIOException;
      }
      localObject = header;
      String str2 = str1.substring(0, j).trim().toLowerCase();
      int k = j + 1;
      String str3 = str1.substring(k).trim();
      ((Hashtable)localObject).put(str2, str3);
    }
  }
  
  public String readContent()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
    localByteArrayOutputStream.<init>();
    readContent(localByteArrayOutputStream);
    Object localObject1 = characterEncoding;
    String str;
    if (localObject1 == null)
    {
      str = new java/lang/String;
      localObject1 = localByteArrayOutputStream.toByteArray();
      str.<init>((byte[])localObject1);
    }
    for (;;)
    {
      localObject1 = System.out;
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = "Field content: '" + str + "'";
      ((PrintStream)localObject1).println((String)localObject2);
      return str;
      str = new java/lang/String;
      localObject1 = localByteArrayOutputStream.toByteArray();
      localObject2 = characterEncoding;
      str.<init>((byte[])localObject1, (String)localObject2);
    }
  }
  
  public void readContent(OutputStream paramOutputStream)
  {
    boolean bool1 = false;
    String str1 = null;
    int i = 1;
    boolean bool2 = consumed;
    Object localObject1;
    if (bool2)
    {
      localObject1 = new java/lang/RuntimeException;
      ((RuntimeException)localObject1).<init>("Content already consumed!");
      throw ((Throwable)localObject1);
    }
    String str2 = "";
    getHeader("Content-Type");
    Object localObject2 = "base64";
    String str3 = getHeader("Content-Transfer-Encoding");
    bool2 = ((String)localObject2).equals(str3);
    if (bool2)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      for (;;)
      {
        str2 = readLine();
        if (str2 == null)
        {
          localObject1 = new java/io/IOException;
          ((IOException)localObject1).<init>("Unexpected EOF");
          throw ((Throwable)localObject1);
        }
        str1 = boundary;
        bool1 = str2.startsWith(str1);
        if (bool1)
        {
          str1 = "--";
          bool1 = str2.endsWith(str1);
          if (bool1) {
            eof = i;
          }
          consumed = i;
          return;
        }
        Base64.decode(str2, paramOutputStream);
      }
    }
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject2 = ((StringBuilder)localObject2).append("\r\n");
    str3 = boundary;
    localObject2 = ((StringBuilder)localObject2).append(str3);
    String str4 = ((StringBuilder)localObject2).toString();
    int k = 0;
    label373:
    label377:
    for (;;)
    {
      localObject2 = is;
      int m = ((InputStream)localObject2).read();
      int j = -1;
      if (m == j)
      {
        localObject1 = new java/lang/RuntimeException;
        ((RuntimeException)localObject1).<init>("Unexpected EOF");
        throw ((Throwable)localObject1);
      }
      j = (char)m;
      int n = str4.charAt(k);
      if (j == n)
      {
        k += 1;
        j = str4.length();
        if (k != j) {
          continue;
        }
        str2 = readLine();
        break;
      }
      if (k > 0)
      {
        int i1 = 0;
        while (i1 < k)
        {
          j = (byte)str4.charAt(i1);
          paramOutputStream.write(j);
          i1 += 1;
        }
        j = (char)m;
        n = str4.charAt(0);
        if (j != n) {
          break label373;
        }
      }
      for (k = i;; k = 0)
      {
        if (k != 0) {
          break label377;
        }
        j = (byte)m;
        paramOutputStream.write(j);
        break;
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/mime/Decoder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */