package org.kxml2.wap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.v1.XmlSerializer;

public class WbxmlSerializer
  implements XmlSerializer
{
  private int attrPage;
  Hashtable attrStartTable;
  Hashtable attrValueTable;
  Vector attributes;
  ByteArrayOutputStream buf;
  int depth;
  private String encoding;
  private boolean headerSent;
  String name;
  String namespace;
  OutputStream out;
  String pending;
  Hashtable stringTable;
  ByteArrayOutputStream stringTableBuf;
  private int tagPage;
  Hashtable tagTable;
  
  public WbxmlSerializer()
  {
    Object localObject = new java/util/Hashtable;
    ((Hashtable)localObject).<init>();
    stringTable = ((Hashtable)localObject);
    localObject = new java/io/ByteArrayOutputStream;
    ((ByteArrayOutputStream)localObject).<init>();
    buf = ((ByteArrayOutputStream)localObject);
    localObject = new java/io/ByteArrayOutputStream;
    ((ByteArrayOutputStream)localObject).<init>();
    stringTableBuf = ((ByteArrayOutputStream)localObject);
    localObject = new java/util/Vector;
    ((Vector)localObject).<init>();
    attributes = ((Vector)localObject);
    localObject = new java/util/Hashtable;
    ((Hashtable)localObject).<init>();
    attrStartTable = ((Hashtable)localObject);
    localObject = new java/util/Hashtable;
    ((Hashtable)localObject).<init>();
    attrValueTable = ((Hashtable)localObject);
    localObject = new java/util/Hashtable;
    ((Hashtable)localObject).<init>();
    tagTable = ((Hashtable)localObject);
    headerSent = false;
  }
  
  static void writeInt(OutputStream paramOutputStream, int paramInt)
  {
    int i = 5;
    byte[] arrayOfByte = new byte[i];
    int k;
    for (int j = 0;; j = k)
    {
      k = j + 1;
      i = (byte)(paramInt & 0x7F);
      arrayOfByte[j] = i;
      paramInt >>= 7;
      if (paramInt == 0)
      {
        j = k;
        for (;;)
        {
          i = 1;
          if (j <= i) {
            break;
          }
          j += -1;
          i = arrayOfByte[j] | 0x80;
          paramOutputStream.write(i);
        }
        i = arrayOfByte[0];
        paramOutputStream.write(i);
        return;
      }
    }
  }
  
  private void writeStr(String paramString)
  {
    int i = 65;
    int j = 32;
    int k = 131;
    int m = 0;
    int n = 0;
    int i1 = paramString.length();
    boolean bool = headerSent;
    Object localObject;
    if (bool)
    {
      localObject = buf;
      writeStrI((OutputStream)localObject, paramString);
    }
    for (;;)
    {
      return;
      int i3;
      int i2 = i3 - m;
      int i4 = 10;
      if (i2 > i4)
      {
        if (m <= n) {
          break label228;
        }
        i2 = m + -1;
        i2 = paramString.charAt(i2);
        if (i2 != j) {
          break label228;
        }
        localObject = stringTable;
        String str = paramString.substring(m, i3);
        localObject = ((Hashtable)localObject).get(str);
        if (localObject != null) {
          break label228;
        }
        buf.write(k);
        localObject = paramString.substring(n, i3);
        writeStrT((String)localObject, false);
      }
      for (;;)
      {
        n = i3;
        m = i3;
        if (m >= i1) {
          break label327;
        }
        while (m < i1)
        {
          i2 = paramString.charAt(m);
          if (i2 >= i) {
            break;
          }
          m += 1;
        }
        i3 = m;
        for (;;)
        {
          if (i3 >= i1) {
            break label226;
          }
          i2 = paramString.charAt(i3);
          if (i2 < i) {
            break;
          }
          i3 += 1;
        }
        label226:
        break;
        label228:
        if (m > n)
        {
          i2 = m + -1;
          i2 = paramString.charAt(i2);
          if (i2 == j) {
            m += -1;
          }
        }
        if (m > n)
        {
          buf.write(k);
          localObject = paramString.substring(n, m);
          writeStrT((String)localObject, false);
        }
        buf.write(k);
        localObject = paramString.substring(m, i3);
        i4 = 1;
        writeStrT((String)localObject, i4);
      }
      label327:
      if (n < i1)
      {
        buf.write(k);
        localObject = paramString.substring(n, i1);
        writeStrT((String)localObject, false);
      }
    }
  }
  
  private final void writeStrT(String paramString, boolean paramBoolean)
  {
    Hashtable localHashtable = stringTable;
    Integer localInteger = (Integer)localHashtable.get(paramString);
    ByteArrayOutputStream localByteArrayOutputStream = buf;
    if (localInteger == null) {}
    for (int i = addToStringTable(paramString, paramBoolean);; i = localInteger.intValue())
    {
      writeInt(localByteArrayOutputStream, i);
      return;
    }
  }
  
  public int addToStringTable(String paramString, boolean paramBoolean)
  {
    int i = 1;
    Integer localInteger = null;
    char c1 = ' ';
    boolean bool = headerSent;
    if (bool)
    {
      localObject1 = new java/io/IOException;
      ((IOException)localObject1).<init>("stringtable sent");
      throw ((Throwable)localObject1);
    }
    Object localObject1 = stringTableBuf;
    int j = ((ByteArrayOutputStream)localObject1).size();
    int k = j;
    char c2 = paramString.charAt(0);
    char c3 = '0';
    if ((c2 >= c3) && (paramBoolean))
    {
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject1 = ((StringBuilder)localObject1).append(c1).append(paramString);
      paramString = ((StringBuilder)localObject1).toString();
      k = j + 1;
    }
    localObject1 = stringTable;
    Object localObject2 = new java/lang/Integer;
    ((Integer)localObject2).<init>(j);
    ((Hashtable)localObject1).put(paramString, localObject2);
    c2 = paramString.charAt(0);
    int n;
    if (c2 == c1)
    {
      localObject1 = stringTable;
      localObject2 = paramString.substring(i);
      localInteger = new java/lang/Integer;
      n = j + 1;
      localInteger.<init>(n);
      ((Hashtable)localObject1).put(localObject2, localInteger);
    }
    int i1 = paramString.lastIndexOf(c1);
    if (i1 > i)
    {
      localObject1 = stringTable;
      localObject2 = paramString.substring(i1);
      localInteger = new java/lang/Integer;
      n = j + i1;
      localInteger.<init>(n);
      ((Hashtable)localObject1).put(localObject2, localInteger);
      localObject1 = stringTable;
      int m = i1 + 1;
      localObject2 = paramString.substring(m);
      localInteger = new java/lang/Integer;
      n = j + i1 + 1;
      localInteger.<init>(n);
      ((Hashtable)localObject1).put(localObject2, localInteger);
    }
    localObject1 = stringTableBuf;
    writeStrI((OutputStream)localObject1, paramString);
    stringTableBuf.flush();
    return k;
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
  {
    attributes.addElement(paramString2);
    attributes.addElement(paramString3);
    return this;
  }
  
  public void cdsect(String paramString)
  {
    text(paramString);
  }
  
  public void checkPending(boolean paramBoolean)
  {
    int i = 4;
    int j = 1;
    Object localObject1 = pending;
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      int k = attributes.size();
      localObject1 = tagTable;
      Object localObject2 = pending;
      localObject1 = (int[])((Hashtable)localObject1).get(localObject2);
      Object localObject3 = localObject1;
      localObject3 = (int[])localObject1;
      int n;
      if (localObject3 == null)
      {
        localObject2 = buf;
        if (k == 0) {
          if (paramBoolean)
          {
            m = i;
            ((ByteArrayOutputStream)localObject2).write(m);
            localObject1 = pending;
            writeStrT((String)localObject1, false);
            n = 0;
            label106:
            if (n >= k) {
              break label589;
            }
            localObject1 = attrStartTable;
            localObject2 = attributes.elementAt(n);
            localObject1 = (int[])((Hashtable)localObject1).get(localObject2);
            localObject3 = localObject1;
            localObject3 = (int[])localObject1;
            if (localObject3 != null) {
              break label429;
            }
            buf.write(i);
            localObject1 = (String)attributes.elementAt(n);
            writeStrT((String)localObject1, false);
            label187:
            localObject1 = attrValueTable;
            localObject2 = attributes;
            n += 1;
            localObject2 = ((Vector)localObject2).elementAt(n);
            localObject1 = (int[])((Hashtable)localObject1).get(localObject2);
            localObject3 = localObject1;
            localObject3 = (int[])localObject1;
            if (localObject3 != null) {
              break label509;
            }
            localObject1 = (String)attributes.elementAt(n);
            writeStr((String)localObject1);
          }
        }
      }
      for (;;)
      {
        n += 1;
        break label106;
        m = 68;
        break;
        if (paramBoolean)
        {
          m = 132;
          break;
        }
        m = 196;
        break;
        m = localObject3[0];
        int i1 = tagPage;
        if (m != i1)
        {
          m = localObject3[0];
          tagPage = m;
          buf.write(0);
          localObject1 = buf;
          i1 = tagPage;
          ((ByteArrayOutputStream)localObject1).write(i1);
        }
        localObject2 = buf;
        if (k == 0) {
          if (paramBoolean) {
            m = localObject3[j];
          }
        }
        for (;;)
        {
          ((ByteArrayOutputStream)localObject2).write(m);
          break;
          m = localObject3[j] | 0x40;
          continue;
          if (paramBoolean) {
            m = localObject3[j] | 0x80;
          } else {
            m = localObject3[j] | 0xC0;
          }
        }
        label429:
        m = localObject3[0];
        i1 = attrPage;
        if (m != i1)
        {
          m = localObject3[0];
          attrPage = m;
          buf.write(0);
          localObject1 = buf;
          i1 = attrPage;
          ((ByteArrayOutputStream)localObject1).write(i1);
        }
        localObject1 = buf;
        i1 = localObject3[j];
        ((ByteArrayOutputStream)localObject1).write(i1);
        break label187;
        label509:
        m = localObject3[0];
        i1 = attrPage;
        if (m != i1)
        {
          m = localObject3[0];
          attrPage = m;
          buf.write(0);
          localObject1 = buf;
          i1 = attrPage;
          ((ByteArrayOutputStream)localObject1).write(i1);
        }
        localObject1 = buf;
        i1 = localObject3[j];
        ((ByteArrayOutputStream)localObject1).write(i1);
      }
      label589:
      if (k > 0)
      {
        localObject1 = buf;
        ((ByteArrayOutputStream)localObject1).write(j);
      }
      int m = 0;
      pending = null;
      localObject1 = attributes;
      ((Vector)localObject1).removeAllElements();
    }
  }
  
  public void comment(String paramString) {}
  
  public void docdecl(String paramString)
  {
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    localRuntimeException.<init>("Cannot write docdecl for WBXML");
    throw localRuntimeException;
  }
  
  public void endDocument()
  {
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
  {
    int i = 1;
    Object localObject = pending;
    if (localObject != null) {
      checkPending(i);
    }
    for (;;)
    {
      int j = depth + -1;
      depth = j;
      return this;
      localObject = buf;
      ((ByteArrayOutputStream)localObject).write(i);
    }
  }
  
  public void entityRef(String paramString)
  {
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    localRuntimeException.<init>("EntityReference not supported for WBXML");
    throw localRuntimeException;
  }
  
  public void flush()
  {
    OutputStream localOutputStream = null;
    checkPending(false);
    boolean bool = headerSent;
    if (!bool)
    {
      localOutputStream = out;
      int i = stringTableBuf.size();
      writeInt(localOutputStream, i);
      localOutputStream = out;
      arrayOfByte = stringTableBuf.toByteArray();
      localOutputStream.write(arrayOfByte);
      bool = true;
      headerSent = bool;
    }
    localOutputStream = out;
    byte[] arrayOfByte = buf.toByteArray();
    localOutputStream.write(arrayOfByte);
    buf.reset();
  }
  
  public int getDepth()
  {
    return depth;
  }
  
  public boolean getFeature(String paramString)
  {
    return false;
  }
  
  public String getName()
  {
    return pending;
  }
  
  public String getNamespace()
  {
    return null;
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    localRuntimeException.<init>("NYI");
    throw localRuntimeException;
  }
  
  public Object getProperty(String paramString)
  {
    return null;
  }
  
  public void ignorableWhitespace(String paramString) {}
  
  public void processingInstruction(String paramString)
  {
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    localRuntimeException.<init>("PI NYI");
    throw localRuntimeException;
  }
  
  public void setAttrStartTable(int paramInt, String[] paramArrayOfString)
  {
    int i = 0;
    for (;;)
    {
      int j = paramArrayOfString.length;
      if (i >= j) {
        break;
      }
      Object localObject = paramArrayOfString[i];
      if (localObject != null)
      {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = paramInt;
        j = 1;
        int k = i + 5;
        arrayOfInt[j] = k;
        localObject = attrStartTable;
        String str = paramArrayOfString[i];
        ((Hashtable)localObject).put(str, arrayOfInt);
      }
      i += 1;
    }
  }
  
  public void setAttrValueTable(int paramInt, String[] paramArrayOfString)
  {
    int i = 0;
    for (;;)
    {
      int j = paramArrayOfString.length;
      if (i >= j) {
        break;
      }
      Object localObject = paramArrayOfString[i];
      if (localObject != null)
      {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = paramInt;
        j = 1;
        int k = i + 133;
        arrayOfInt[j] = k;
        localObject = attrValueTable;
        String str = paramArrayOfString[i];
        ((Hashtable)localObject).put(str, arrayOfInt);
      }
      i += 1;
    }
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    IllegalArgumentException localIllegalArgumentException = new java/lang/IllegalArgumentException;
    Object localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    localObject = "unknown feature " + paramString;
    localIllegalArgumentException.<init>((String)localObject);
    throw localIllegalArgumentException;
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
  {
    if (paramString == null) {
      paramString = "UTF-8";
    }
    encoding = paramString;
    out = paramOutputStream;
    ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
    localByteArrayOutputStream.<init>();
    buf = localByteArrayOutputStream;
    localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
    localByteArrayOutputStream.<init>();
    stringTableBuf = localByteArrayOutputStream;
    headerSent = false;
  }
  
  public void setOutput(Writer paramWriter)
  {
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    localRuntimeException.<init>("Wbxml requires an OutputStream!");
    throw localRuntimeException;
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    localRuntimeException.<init>("NYI");
    throw localRuntimeException;
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    IllegalArgumentException localIllegalArgumentException = new java/lang/IllegalArgumentException;
    Object localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    localObject = "unknown property " + paramString;
    localIllegalArgumentException.<init>((String)localObject);
    throw localIllegalArgumentException;
  }
  
  public void setTagTable(int paramInt, String[] paramArrayOfString)
  {
    int i = 0;
    for (;;)
    {
      int j = paramArrayOfString.length;
      if (i >= j) {
        break;
      }
      Object localObject = paramArrayOfString[i];
      if (localObject != null)
      {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = paramInt;
        j = 1;
        int k = i + 5;
        arrayOfInt[j] = k;
        localObject = tagTable;
        String str = paramArrayOfString[i];
        ((Hashtable)localObject).put(str, arrayOfInt);
      }
      i += 1;
    }
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
  {
    out.write(3);
    Object localObject = out;
    int i = 1;
    ((OutputStream)localObject).write(i);
    if (paramString != null) {
      encoding = paramString;
    }
    localObject = encoding.toUpperCase();
    String str = "UTF-8";
    boolean bool = ((String)localObject).equals(str);
    if (bool)
    {
      localObject = out;
      i = 106;
      ((OutputStream)localObject).write(i);
    }
    for (;;)
    {
      return;
      localObject = encoding.toUpperCase();
      str = "ISO-8859-1";
      bool = ((String)localObject).equals(str);
      if (!bool) {
        break;
      }
      localObject = out;
      i = 4;
      ((OutputStream)localObject).write(i);
    }
    localObject = new java/io/UnsupportedEncodingException;
    ((UnsupportedEncodingException)localObject).<init>(paramString);
    throw ((Throwable)localObject);
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Object localObject = "";
      boolean bool = ((String)localObject).equals(paramString1);
      if (!bool)
      {
        localObject = new java/lang/RuntimeException;
        ((RuntimeException)localObject).<init>("NSP NYI");
        throw ((Throwable)localObject);
      }
    }
    checkPending(false);
    pending = paramString2;
    int i = depth + 1;
    depth = i;
    return this;
  }
  
  public XmlSerializer text(String paramString)
  {
    checkPending(false);
    writeStr(paramString);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    checkPending(false);
    String str = new java/lang/String;
    str.<init>(paramArrayOfChar, paramInt1, paramInt2);
    writeStr(str);
    return this;
  }
  
  void writeStrI(OutputStream paramOutputStream, String paramString)
  {
    String str = encoding;
    byte[] arrayOfByte = paramString.getBytes(str);
    paramOutputStream.write(arrayOfByte);
    paramOutputStream.write(0);
  }
  
  public void writeWapExtension(int paramInt, Object paramObject)
  {
    int i = 0;
    checkPending(false);
    Object localObject1 = buf;
    ((ByteArrayOutputStream)localObject1).write(paramInt);
    switch (paramInt)
    {
    default: 
      localObject1 = new java/lang/IllegalArgumentException;
      ((IllegalArgumentException)localObject1).<init>();
      throw ((Throwable)localObject1);
    case 195: 
      paramObject = (byte[])paramObject;
      Object localObject2 = paramObject;
      localObject2 = (byte[])paramObject;
      localObject1 = buf;
      i = localObject2.length;
      writeInt((OutputStream)localObject1, i);
      localObject1 = buf;
      ((ByteArrayOutputStream)localObject1).write((byte[])localObject2);
    }
    for (;;)
    {
      return;
      localObject1 = buf;
      paramObject = (String)paramObject;
      writeStrI((OutputStream)localObject1, (String)paramObject);
      continue;
      paramObject = (String)paramObject;
      writeStrT((String)paramObject, false);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kxml2/wap/WbxmlSerializer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */