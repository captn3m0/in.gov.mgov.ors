package org.kxml2.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlSerializer;

public class KXmlSerializer
  implements XmlSerializer
{
  private int auto;
  private int depth;
  private String[] elementStack;
  private String encoding;
  private boolean[] indent;
  private int[] nspCounts;
  private String[] nspStack;
  private boolean pending;
  private boolean unicode;
  private Writer writer;
  
  public KXmlSerializer()
  {
    Object localObject = new String[12];
    elementStack = ((String[])localObject);
    localObject = new int[i];
    nspCounts = ((int[])localObject);
    localObject = new String[8];
    nspStack = ((String[])localObject);
    localObject = new boolean[i];
    indent = ((boolean[])localObject);
  }
  
  private final void check(boolean paramBoolean)
  {
    int i = 34;
    boolean bool1 = pending;
    if (!bool1) {
      return;
    }
    int j = depth + 1;
    depth = j;
    pending = false;
    Object localObject1 = indent;
    j = localObject1.length;
    int m = depth;
    Object localObject2;
    if (j <= m)
    {
      j = depth + 4;
      localObject2 = new boolean[j];
      localObject1 = indent;
      m = depth;
      System.arraycopy(localObject1, 0, localObject2, 0, m);
      indent = ((boolean[])localObject2);
    }
    localObject1 = indent;
    m = depth;
    Object localObject3 = indent;
    int n = depth + -1;
    int i1 = localObject3[n];
    localObject1[m] = i1;
    localObject1 = nspCounts;
    m = depth + -1;
    int i2 = localObject1[m];
    localObject1 = nspCounts;
    m = depth;
    j = localObject1[m];
    if (i2 < j)
    {
      localObject1 = writer;
      m = 32;
      ((Writer)localObject1).write(m);
      writer.write("xmlns");
      localObject1 = "";
      localObject4 = nspStack;
      i1 = i2 * 2;
      localObject4 = localObject4[i1];
      boolean bool2 = ((String)localObject1).equals(localObject4);
      if (!bool2)
      {
        localObject1 = writer;
        m = 58;
        ((Writer)localObject1).write(m);
        localObject1 = writer;
        localObject4 = nspStack;
        i1 = i2 * 2;
        localObject4 = localObject4[i1];
        ((Writer)localObject1).write((String)localObject4);
      }
      do
      {
        do
        {
          localObject1 = writer;
          localObject4 = "=\"";
          ((Writer)localObject1).write((String)localObject4);
          localObject1 = nspStack;
          m = i2 * 2 + 1;
          localObject1 = localObject1[m];
          writeEscaped((String)localObject1, i);
          localObject1 = writer;
          ((Writer)localObject1).write(i);
          i2 += 1;
          break;
          localObject1 = "";
          localObject4 = getNamespace();
          bool2 = ((String)localObject1).equals(localObject4);
        } while (!bool2);
        localObject1 = "";
        localObject4 = nspStack;
        i1 = i2 * 2 + 1;
        localObject4 = localObject4[i1];
        bool2 = ((String)localObject1).equals(localObject4);
      } while (bool2);
      localObject1 = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject1).<init>("Cannot set default namespace for elements in no namespace");
      throw ((Throwable)localObject1);
    }
    localObject1 = nspCounts;
    int k = localObject1.length;
    m = depth + 1;
    if (k <= m)
    {
      k = depth + 8;
      localObject2 = new int[k];
      localObject1 = nspCounts;
      m = depth + 1;
      System.arraycopy(localObject1, 0, localObject2, 0, m);
      nspCounts = ((int[])localObject2);
    }
    localObject1 = nspCounts;
    m = depth + 1;
    localObject3 = nspCounts;
    n = depth;
    i1 = localObject3[n];
    localObject1[m] = i1;
    Object localObject4 = writer;
    if (paramBoolean) {}
    for (localObject1 = " />";; localObject1 = ">")
    {
      ((Writer)localObject4).write((String)localObject1);
      break;
    }
  }
  
  private final String getPrefix(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = nspCounts;
    int i = depth + 1;
    int j = localObject1[i] * 2;
    int n = j + -2;
    Object localObject2;
    int i1;
    label117:
    boolean bool2;
    if (n >= 0)
    {
      localObject1 = nspStack;
      i = n + 1;
      localObject1 = localObject1[i];
      boolean bool1 = ((String)localObject1).equals(paramString);
      if (bool1) {
        if (!paramBoolean1)
        {
          localObject1 = nspStack[n];
          str1 = "";
          bool1 = ((String)localObject1).equals(str1);
          if (bool1) {}
        }
        else
        {
          localObject1 = nspStack;
          localObject2 = localObject1[n];
          i1 = n + 2;
          localObject1 = nspCounts;
          i = depth + 1;
          int k = localObject1[i] * 2;
          if (i1 < k)
          {
            localObject1 = nspStack[i1];
            bool2 = ((String)localObject1).equals(localObject2);
            if (bool2) {
              localObject2 = null;
            }
          }
          else
          {
            if (localObject2 == null) {
              break label190;
            }
          }
        }
      }
    }
    for (;;)
    {
      return (String)localObject2;
      i1 += 1;
      break label117;
      label190:
      n += -2;
      break;
      if (!paramBoolean2)
      {
        localObject2 = null;
      }
      else
      {
        localObject1 = "";
        bool2 = ((String)localObject1).equals(paramString);
        if (!bool2) {
          break label268;
        }
        str2 = "";
        boolean bool4 = pending;
        bool2 = false;
        localObject1 = null;
        pending = false;
        setPrefix(str2, paramString);
        pending = bool4;
        localObject2 = str2;
      }
    }
    label268:
    localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    String str1 = "n";
    localObject1 = ((StringBuilder)localObject1).append(str1);
    i = auto;
    int i2 = i + 1;
    auto = i2;
    String str2 = i;
    localObject1 = nspCounts;
    i = depth + 1;
    int m = localObject1[i] * 2;
    n = m + -2;
    for (;;)
    {
      if (n >= 0)
      {
        localObject1 = nspStack[n];
        boolean bool3 = str2.equals(localObject1);
        if (bool3) {
          str2 = null;
        }
      }
      else
      {
        if (str2 == null) {
          break label268;
        }
        break;
      }
      n += -2;
    }
  }
  
  private final void writeEscaped(String paramString, int paramInt)
  {
    int i = 0;
    int j = paramString.length();
    if (i < j)
    {
      int m = paramString.charAt(i);
      label96:
      Object localObject1;
      switch (m)
      {
      default: 
        j = 32;
        if (m >= j)
        {
          j = 64;
          if (m != j)
          {
            j = 127;
            if (m >= j)
            {
              boolean bool = unicode;
              if (!bool) {
                break;
              }
            }
            else
            {
              localObject1 = writer;
              ((Writer)localObject1).write(m);
            }
          }
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        int k = -1;
        if (paramInt == k)
        {
          localObject1 = writer;
          ((Writer)localObject1).write(m);
        }
        else
        {
          localObject1 = writer;
          Object localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          String str = "&#";
          localObject2 = ((StringBuilder)localObject2).append(str).append(m);
          char c = ';';
          localObject2 = c;
          ((Writer)localObject1).write((String)localObject2);
          continue;
          localObject1 = writer;
          localObject2 = "&amp;";
          ((Writer)localObject1).write((String)localObject2);
          continue;
          localObject1 = writer;
          localObject2 = "&gt;";
          ((Writer)localObject1).write((String)localObject2);
          continue;
          localObject1 = writer;
          localObject2 = "&lt;";
          ((Writer)localObject1).write((String)localObject2);
          continue;
          if (m != paramInt) {
            break label96;
          }
          localObject2 = writer;
          k = 34;
          if (m == k) {}
          for (localObject1 = "&quot;";; localObject1 = "&apos;")
          {
            ((Writer)localObject2).write((String)localObject1);
            break;
          }
          localObject1 = writer;
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          localObject2 = ((StringBuilder)localObject2).append("&#").append(m);
          str = ";";
          localObject2 = str;
          ((Writer)localObject1).write((String)localObject2);
        }
      }
    }
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
  {
    int i = 34;
    boolean bool = pending;
    if (!bool)
    {
      localObject = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject).<init>("illegal position for attribute");
      throw ((Throwable)localObject);
    }
    if (paramString1 == null) {
      paramString1 = "";
    }
    Object localObject = "";
    bool = ((String)localObject).equals(paramString1);
    String str;
    int k;
    int j;
    if (bool)
    {
      str = "";
      localObject = writer;
      k = 32;
      ((Writer)localObject).write(k);
      localObject = "";
      bool = ((String)localObject).equals(str);
      if (!bool)
      {
        writer.write(str);
        localObject = writer;
        k = 58;
        ((Writer)localObject).write(k);
      }
      writer.write(paramString2);
      localObject = writer;
      ((Writer)localObject).write(61);
      j = paramString3.indexOf(i);
      k = -1;
      if (j != k) {
        break label207;
      }
    }
    for (;;)
    {
      writer.write(i);
      writeEscaped(paramString3, i);
      writer.write(i);
      return this;
      j = 0;
      localObject = null;
      k = 1;
      str = getPrefix(paramString1, false, k);
      break;
      label207:
      i = 39;
    }
  }
  
  public void cdsect(String paramString)
  {
    check(false);
    writer.write("<![CDATA[");
    writer.write(paramString);
    writer.write("]]>");
  }
  
  public void comment(String paramString)
  {
    check(false);
    writer.write("<!--");
    writer.write(paramString);
    writer.write("-->");
  }
  
  public void docdecl(String paramString)
  {
    writer.write("<!DOCTYPE");
    writer.write(paramString);
    writer.write(">");
  }
  
  public void endDocument()
  {
    for (;;)
    {
      int i = depth;
      if (i <= 0) {
        break;
      }
      Object localObject1 = elementStack;
      int j = depth * 3 + -3;
      localObject1 = localObject1[j];
      Object localObject2 = elementStack;
      int k = depth * 3 + -1;
      localObject2 = localObject2[k];
      endTag((String)localObject1, (String)localObject2);
    }
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
  {
    boolean bool1 = pending;
    if (!bool1)
    {
      int i = depth + -1;
      depth = i;
    }
    int k;
    if (paramString1 == null)
    {
      localObject1 = elementStack;
      k = depth * 3;
      localObject1 = localObject1[k];
      if (localObject1 != null) {}
    }
    else if (paramString1 != null)
    {
      localObject1 = elementStack;
      k = depth * 3;
      localObject1 = localObject1[k];
      bool2 = paramString1.equals(localObject1);
      if (!bool2) {}
    }
    else
    {
      localObject1 = elementStack;
      k = depth * 3 + 2;
      localObject1 = localObject1[k];
      bool2 = ((String)localObject1).equals(paramString2);
      if (bool2) {
        break label176;
      }
    }
    Object localObject1 = new java/lang/IllegalArgumentException;
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject2 = "</{" + paramString1 + "}" + paramString2 + "> does not match start";
    ((IllegalArgumentException)localObject1).<init>((String)localObject2);
    throw ((Throwable)localObject1);
    label176:
    boolean bool2 = pending;
    int j;
    if (bool2)
    {
      check(true);
      j = depth + -1;
      depth = j;
    }
    for (;;)
    {
      localObject1 = nspCounts;
      k = depth + 1;
      int[] arrayOfInt = nspCounts;
      int m = depth;
      int n = arrayOfInt[m];
      localObject1[k] = n;
      return this;
      localObject1 = indent;
      k = depth + 1;
      j = localObject1[k];
      if (j != 0)
      {
        localObject1 = writer;
        localObject2 = "\r\n";
        ((Writer)localObject1).write((String)localObject2);
        int i1 = 0;
        for (;;)
        {
          j = depth;
          if (i1 >= j) {
            break;
          }
          localObject1 = writer;
          localObject2 = "  ";
          ((Writer)localObject1).write((String)localObject2);
          i1 += 1;
        }
      }
      localObject1 = writer;
      localObject2 = "</";
      ((Writer)localObject1).write((String)localObject2);
      localObject1 = elementStack;
      k = depth * 3 + 1;
      Object localObject3 = localObject1[k];
      localObject1 = "";
      boolean bool3 = ((String)localObject1).equals(localObject3);
      if (!bool3)
      {
        writer.write((String)localObject3);
        localObject1 = writer;
        k = 58;
        ((Writer)localObject1).write(k);
      }
      writer.write(paramString2);
      localObject1 = writer;
      k = 62;
      ((Writer)localObject1).write(k);
    }
  }
  
  public void entityRef(String paramString)
  {
    check(false);
    writer.write(38);
    writer.write(paramString);
    writer.write(59);
  }
  
  public void flush()
  {
    check(false);
    writer.flush();
  }
  
  public int getDepth()
  {
    boolean bool = pending;
    if (bool) {}
    for (int i = depth + 1;; i = depth) {
      return i;
    }
  }
  
  public boolean getFeature(String paramString)
  {
    Object localObject = "http://xmlpull.org/v1/doc/features.html#indent-output";
    boolean bool = ((String)localObject).equals(paramString);
    int i;
    if (bool)
    {
      localObject = indent;
      int k = depth;
      i = localObject[k];
    }
    for (;;)
    {
      return i;
      int j = 0;
      localObject = null;
    }
  }
  
  public String getName()
  {
    int i = getDepth();
    if (i == 0) {
      i = 0;
    }
    int j;
    for (Object localObject = null;; localObject = localObject[j])
    {
      return (String)localObject;
      localObject = elementStack;
      j = getDepth() * 3 + -1;
    }
  }
  
  public String getNamespace()
  {
    int i = getDepth();
    if (i == 0) {
      i = 0;
    }
    int j;
    for (Object localObject = null;; localObject = localObject[j])
    {
      return (String)localObject;
      localObject = elementStack;
      j = getDepth() * 3 + -3;
    }
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    RuntimeException localRuntimeException = null;
    try
    {
      return getPrefix(paramString, false, paramBoolean);
    }
    catch (IOException localIOException)
    {
      localRuntimeException = new java/lang/RuntimeException;
      String str = localIOException.toString();
      localRuntimeException.<init>(str);
      throw localRuntimeException;
    }
  }
  
  public Object getProperty(String paramString)
  {
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    localRuntimeException.<init>("Unsupported property");
    throw localRuntimeException;
  }
  
  public void ignorableWhitespace(String paramString)
  {
    text(paramString);
  }
  
  public void processingInstruction(String paramString)
  {
    check(false);
    writer.write("<?");
    writer.write(paramString);
    writer.write("?>");
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    Object localObject = "http://xmlpull.org/v1/doc/features.html#indent-output";
    boolean bool = ((String)localObject).equals(paramString);
    if (bool)
    {
      localObject = indent;
      int i = depth;
      localObject[i] = paramBoolean;
      return;
    }
    localObject = new java/lang/RuntimeException;
    ((RuntimeException)localObject).<init>("Unsupported Feature");
    throw ((Throwable)localObject);
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
  {
    Object localObject;
    if (paramOutputStream == null)
    {
      localObject = new java/lang/IllegalArgumentException;
      ((IllegalArgumentException)localObject).<init>();
      throw ((Throwable)localObject);
    }
    if (paramString == null)
    {
      localObject = new java/io/OutputStreamWriter;
      ((OutputStreamWriter)localObject).<init>(paramOutputStream);
    }
    for (;;)
    {
      setOutput((Writer)localObject);
      encoding = paramString;
      if (paramString != null)
      {
        localObject = paramString.toLowerCase();
        String str = "utf";
        boolean bool = ((String)localObject).startsWith(str);
        if (bool)
        {
          bool = true;
          unicode = bool;
        }
      }
      return;
      localObject = new java/io/OutputStreamWriter;
      ((OutputStreamWriter)localObject).<init>(paramOutputStream, paramString);
    }
  }
  
  public void setOutput(Writer paramWriter)
  {
    int i = 1;
    int j = 2;
    writer = paramWriter;
    nspCounts[0] = j;
    nspCounts[i] = j;
    nspStack[0] = "";
    nspStack[i] = "";
    nspStack[j] = "xml";
    nspStack[3] = "http://www.w3.org/XML/1998/namespace";
    pending = false;
    auto = 0;
    depth = 0;
    unicode = false;
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    check(false);
    if (paramString1 == null) {
      paramString1 = "";
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    String str = getPrefix(paramString2, true, false);
    boolean bool = paramString1.equals(str);
    if (bool) {}
    for (;;)
    {
      return;
      Object localObject = nspCounts;
      int j = depth + 1;
      int k = localObject[j];
      int m = k + 1;
      localObject[j] = m;
      int n = k << 1;
      localObject = nspStack;
      int i = localObject.length;
      j = n + 1;
      if (i < j)
      {
        i = nspStack.length + 16;
        String[] arrayOfString = new String[i];
        localObject = nspStack;
        System.arraycopy(localObject, 0, arrayOfString, 0, n);
        nspStack = arrayOfString;
      }
      localObject = nspStack;
      int i1 = n + 1;
      localObject[n] = paramString1;
      localObject = nspStack;
      localObject[i1] = paramString2;
    }
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    Object localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    localObject = "Unsupported Property:" + paramObject;
    localRuntimeException.<init>((String)localObject);
    throw localRuntimeException;
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
  {
    Object localObject1 = writer;
    Object localObject2 = "<?xml version='1.0' ";
    ((Writer)localObject1).write((String)localObject2);
    boolean bool;
    if (paramString != null)
    {
      encoding = paramString;
      localObject1 = paramString.toLowerCase();
      localObject2 = "utf";
      bool = ((String)localObject1).startsWith((String)localObject2);
      if (bool)
      {
        bool = true;
        unicode = bool;
      }
    }
    localObject1 = encoding;
    if (localObject1 != null)
    {
      writer.write("encoding='");
      localObject1 = writer;
      localObject2 = encoding;
      ((Writer)localObject1).write((String)localObject2);
      localObject1 = writer;
      localObject2 = "' ";
      ((Writer)localObject1).write((String)localObject2);
    }
    if (paramBoolean != null)
    {
      localObject1 = writer;
      ((Writer)localObject1).write("standalone='");
      localObject2 = writer;
      bool = paramBoolean.booleanValue();
      if (!bool) {
        break label176;
      }
    }
    label176:
    for (localObject1 = "yes";; localObject1 = "no")
    {
      ((Writer)localObject2).write((String)localObject1);
      localObject1 = writer;
      localObject2 = "' ";
      ((Writer)localObject1).write((String)localObject2);
      writer.write("?>");
      return;
    }
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
  {
    boolean bool1 = true;
    int i = 0;
    check(false);
    Object localObject1 = indent;
    int j = depth;
    int k = localObject1[j];
    Object localObject2;
    int n;
    if (k != 0)
    {
      localObject1 = writer;
      localObject2 = "\r\n";
      ((Writer)localObject1).write((String)localObject2);
      n = 0;
      for (;;)
      {
        k = depth;
        if (n >= k) {
          break;
        }
        localObject1 = writer;
        localObject2 = "  ";
        ((Writer)localObject1).write((String)localObject2);
        n += 1;
      }
    }
    int i1 = depth * 3;
    localObject1 = elementStack;
    k = localObject1.length;
    j = i1 + 3;
    if (k < j)
    {
      k = elementStack.length + 12;
      String[] arrayOfString = new String[k];
      localObject1 = elementStack;
      System.arraycopy(localObject1, 0, arrayOfString, 0, i1);
      elementStack = arrayOfString;
    }
    String str;
    if (paramString1 == null)
    {
      str = "";
      localObject1 = "";
      boolean bool2 = ((String)localObject1).equals(paramString1);
      if (bool2)
      {
        localObject1 = nspCounts;
        j = depth;
        n = localObject1[j];
      }
    }
    else
    {
      for (;;)
      {
        localObject1 = nspCounts;
        j = depth + 1;
        int m = localObject1[j];
        if (n >= m) {
          break label349;
        }
        localObject1 = "";
        localObject2 = nspStack;
        i = n * 2;
        localObject2 = localObject2[i];
        bool3 = ((String)localObject1).equals(localObject2);
        if (bool3)
        {
          localObject1 = "";
          localObject2 = nspStack;
          i = n * 2 + 1;
          localObject2 = localObject2[i];
          bool3 = ((String)localObject1).equals(localObject2);
          if (!bool3)
          {
            localObject1 = new java/lang/IllegalStateException;
            ((IllegalStateException)localObject1).<init>("Cannot set default namespace for elements in no namespace");
            throw ((Throwable)localObject1);
            str = getPrefix(paramString1, bool1, bool1);
            break;
          }
        }
        n += 1;
      }
    }
    label349:
    localObject1 = elementStack;
    int i2 = i1 + 1;
    localObject1[i1] = paramString1;
    localObject1 = elementStack;
    i1 = i2 + 1;
    localObject1[i2] = str;
    elementStack[i1] = paramString2;
    localObject1 = writer;
    j = 60;
    ((Writer)localObject1).write(j);
    localObject1 = "";
    boolean bool3 = ((String)localObject1).equals(str);
    if (!bool3)
    {
      writer.write(str);
      localObject1 = writer;
      j = 58;
      ((Writer)localObject1).write(j);
    }
    writer.write(paramString2);
    pending = bool1;
    return this;
  }
  
  public XmlSerializer text(String paramString)
  {
    check(false);
    boolean[] arrayOfBoolean = indent;
    int i = depth;
    arrayOfBoolean[i] = false;
    writeEscaped(paramString, -1);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    String str = new java/lang/String;
    str.<init>(paramArrayOfChar, paramInt1, paramInt2);
    text(str);
    return this;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kxml2/io/KXmlSerializer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */