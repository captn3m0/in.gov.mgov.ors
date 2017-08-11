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
  private String[] elementStack = new String[12];
  private String encoding;
  private boolean[] indent = new boolean[4];
  private int[] nspCounts = new int[4];
  private String[] nspStack = new String[8];
  private boolean pending;
  private boolean unicode;
  private Writer writer;
  
  private final void check(boolean paramBoolean)
    throws IOException
  {
    if (!pending) {
      return;
    }
    depth += 1;
    pending = false;
    if (indent.length <= depth)
    {
      localObject = new boolean[depth + 4];
      System.arraycopy(indent, 0, localObject, 0, depth);
      indent = ((boolean[])localObject);
    }
    indent[depth] = indent[(depth - 1)];
    int i = nspCounts[(depth - 1)];
    if (i < nspCounts[depth])
    {
      writer.write(32);
      writer.write("xmlns");
      if (!"".equals(nspStack[(i * 2)]))
      {
        writer.write(58);
        writer.write(nspStack[(i * 2)]);
      }
      while ((!"".equals(getNamespace())) || ("".equals(nspStack[(i * 2 + 1)])))
      {
        writer.write("=\"");
        writeEscaped(nspStack[(i * 2 + 1)], 34);
        writer.write(34);
        i += 1;
        break;
      }
      throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
    }
    if (nspCounts.length <= depth + 1)
    {
      localObject = new int[depth + 8];
      System.arraycopy(nspCounts, 0, localObject, 0, depth + 1);
      nspCounts = ((int[])localObject);
    }
    nspCounts[(depth + 1)] = nspCounts[depth];
    Writer localWriter = writer;
    if (paramBoolean) {}
    for (Object localObject = " />";; localObject = ">")
    {
      localWriter.write((String)localObject);
      return;
    }
  }
  
  private final String getPrefix(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    int i = nspCounts[(depth + 1)] * 2 - 2;
    while (i >= 0)
    {
      if ((nspStack[(i + 1)].equals(paramString)) && ((paramBoolean1) || (!nspStack[i].equals(""))))
      {
        str = nspStack[i];
        int j = i + 2;
        for (;;)
        {
          localObject = str;
          if (j < nspCounts[(depth + 1)] * 2)
          {
            if (nspStack[j].equals(str)) {
              localObject = null;
            }
          }
          else
          {
            if (localObject == null) {
              break;
            }
            return (String)localObject;
          }
          j += 1;
        }
      }
      i -= 2;
    }
    if (!paramBoolean2) {
      return null;
    }
    if ("".equals(paramString))
    {
      localObject = "";
      paramBoolean1 = pending;
      pending = false;
      setPrefix((String)localObject, paramString);
      pending = paramBoolean1;
      return (String)localObject;
    }
    label182:
    Object localObject = new StringBuilder().append("n");
    i = auto;
    auto = (i + 1);
    String str = i;
    i = nspCounts[(depth + 1)] * 2 - 2;
    for (;;)
    {
      localObject = str;
      if (i >= 0)
      {
        if (str.equals(nspStack[i])) {
          localObject = null;
        }
      }
      else
      {
        if (localObject == null) {
          break label182;
        }
        break;
      }
      i -= 2;
    }
  }
  
  private final void writeEscaped(String paramString, int paramInt)
    throws IOException
  {
    int i = 0;
    if (i < paramString.length())
    {
      int j = paramString.charAt(i);
      switch (j)
      {
      default: 
        label92:
        if ((j >= 32) && (j != 64) && ((j < 127) || (unicode))) {
          writer.write(j);
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt == -1)
        {
          writer.write(j);
        }
        else
        {
          writer.write("&#" + j + ';');
          continue;
          writer.write("&amp;");
          continue;
          writer.write("&gt;");
          continue;
          writer.write("&lt;");
          continue;
          if (j != paramInt) {
            break label92;
          }
          Writer localWriter = writer;
          if (j == 34) {}
          for (String str = "&quot;";; str = "&apos;")
          {
            localWriter.write(str);
            break;
          }
          writer.write("&#" + j + ";");
        }
      }
    }
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    int i = 34;
    if (!pending) {
      throw new IllegalStateException("illegal position for attribute");
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    if ("".equals(str))
    {
      paramString1 = "";
      writer.write(32);
      if (!"".equals(paramString1))
      {
        writer.write(paramString1);
        writer.write(58);
      }
      writer.write(paramString2);
      writer.write(61);
      if (paramString3.indexOf('"') != -1) {
        break label146;
      }
    }
    for (;;)
    {
      writer.write(i);
      writeEscaped(paramString3, i);
      writer.write(i);
      return this;
      paramString1 = getPrefix(str, false, true);
      break;
      label146:
      i = 39;
    }
  }
  
  public void cdsect(String paramString)
    throws IOException
  {
    check(false);
    writer.write("<![CDATA[");
    writer.write(paramString);
    writer.write("]]>");
  }
  
  public void comment(String paramString)
    throws IOException
  {
    check(false);
    writer.write("<!--");
    writer.write(paramString);
    writer.write("-->");
  }
  
  public void docdecl(String paramString)
    throws IOException
  {
    writer.write("<!DOCTYPE");
    writer.write(paramString);
    writer.write(">");
  }
  
  public void endDocument()
    throws IOException
  {
    while (depth > 0) {
      endTag(elementStack[(depth * 3 - 3)], elementStack[(depth * 3 - 1)]);
    }
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
    throws IOException
  {
    if (!pending) {
      depth -= 1;
    }
    if (((paramString1 == null) && (elementStack[(depth * 3)] != null)) || ((paramString1 != null) && (!paramString1.equals(elementStack[(depth * 3)]))) || (!elementStack[(depth * 3 + 2)].equals(paramString2))) {
      throw new IllegalArgumentException("</{" + paramString1 + "}" + paramString2 + "> does not match start");
    }
    if (pending)
    {
      check(true);
      depth -= 1;
    }
    for (;;)
    {
      nspCounts[(depth + 1)] = nspCounts[depth];
      return this;
      if (indent[(depth + 1)] != 0)
      {
        writer.write("\r\n");
        int i = 0;
        while (i < depth)
        {
          writer.write("  ");
          i += 1;
        }
      }
      writer.write("</");
      paramString1 = elementStack[(depth * 3 + 1)];
      if (!"".equals(paramString1))
      {
        writer.write(paramString1);
        writer.write(58);
      }
      writer.write(paramString2);
      writer.write(62);
    }
  }
  
  public void entityRef(String paramString)
    throws IOException
  {
    check(false);
    writer.write(38);
    writer.write(paramString);
    writer.write(59);
  }
  
  public void flush()
    throws IOException
  {
    check(false);
    writer.flush();
  }
  
  public int getDepth()
  {
    if (pending) {
      return depth + 1;
    }
    return depth;
  }
  
  public boolean getFeature(String paramString)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString)) {
      return indent[depth];
    }
    return false;
  }
  
  public String getName()
  {
    if (getDepth() == 0) {
      return null;
    }
    return elementStack[(getDepth() * 3 - 1)];
  }
  
  public String getNamespace()
  {
    if (getDepth() == 0) {
      return null;
    }
    return elementStack[(getDepth() * 3 - 3)];
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = getPrefix(paramString, false, paramBoolean);
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString.toString());
    }
  }
  
  public Object getProperty(String paramString)
  {
    throw new RuntimeException("Unsupported property");
  }
  
  public void ignorableWhitespace(String paramString)
    throws IOException
  {
    text(paramString);
  }
  
  public void processingInstruction(String paramString)
    throws IOException
  {
    check(false);
    writer.write("<?");
    writer.write(paramString);
    writer.write("?>");
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString))
    {
      indent[depth] = paramBoolean;
      return;
    }
    throw new RuntimeException("Unsupported Feature");
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException();
    }
    if (paramString == null) {}
    for (paramOutputStream = new OutputStreamWriter(paramOutputStream);; paramOutputStream = new OutputStreamWriter(paramOutputStream, paramString))
    {
      setOutput(paramOutputStream);
      encoding = paramString;
      if ((paramString != null) && (paramString.toLowerCase().startsWith("utf"))) {
        unicode = true;
      }
      return;
    }
  }
  
  public void setOutput(Writer paramWriter)
  {
    writer = paramWriter;
    nspCounts[0] = 2;
    nspCounts[1] = 2;
    nspStack[0] = "";
    nspStack[1] = "";
    nspStack[2] = "xml";
    nspStack[3] = "http://www.w3.org/XML/1998/namespace";
    pending = false;
    auto = 0;
    depth = 0;
    unicode = false;
  }
  
  public void setPrefix(String paramString1, String paramString2)
    throws IOException
  {
    check(false);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (str.equals(getPrefix(paramString1, true, false))) {
      return;
    }
    paramString2 = nspCounts;
    int i = depth + 1;
    int j = paramString2[i];
    paramString2[i] = (j + 1);
    i = j << 1;
    if (nspStack.length < i + 1)
    {
      paramString2 = new String[nspStack.length + 16];
      System.arraycopy(nspStack, 0, paramString2, 0, i);
      nspStack = paramString2;
    }
    nspStack[i] = str;
    nspStack[(i + 1)] = paramString1;
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    throw new RuntimeException("Unsupported Property:" + paramObject);
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
    throws IOException
  {
    writer.write("<?xml version='1.0' ");
    if (paramString != null)
    {
      encoding = paramString;
      if (paramString.toLowerCase().startsWith("utf")) {
        unicode = true;
      }
    }
    if (encoding != null)
    {
      writer.write("encoding='");
      writer.write(encoding);
      writer.write("' ");
    }
    Writer localWriter;
    if (paramBoolean != null)
    {
      writer.write("standalone='");
      localWriter = writer;
      if (!paramBoolean.booleanValue()) {
        break label129;
      }
    }
    label129:
    for (paramString = "yes";; paramString = "no")
    {
      localWriter.write(paramString);
      writer.write("' ");
      writer.write("?>");
      return;
    }
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
    throws IOException
  {
    check(false);
    if (indent[depth] != 0)
    {
      writer.write("\r\n");
      i = 0;
      while (i < depth)
      {
        writer.write("  ");
        i += 1;
      }
    }
    int j = depth * 3;
    Object localObject;
    if (elementStack.length < j + 3)
    {
      localObject = new String[elementStack.length + 12];
      System.arraycopy(elementStack, 0, localObject, 0, j);
      elementStack = ((String[])localObject);
    }
    if (paramString1 == null)
    {
      localObject = "";
      if ("".equals(paramString1)) {
        i = nspCounts[depth];
      }
    }
    else
    {
      for (;;)
      {
        if (i >= nspCounts[(depth + 1)]) {
          break label209;
        }
        if (("".equals(nspStack[(i * 2)])) && (!"".equals(nspStack[(i * 2 + 1)])))
        {
          throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
          localObject = getPrefix(paramString1, true, true);
          break;
        }
        i += 1;
      }
    }
    label209:
    String[] arrayOfString = elementStack;
    int i = j + 1;
    arrayOfString[j] = paramString1;
    elementStack[i] = localObject;
    elementStack[(i + 1)] = paramString2;
    writer.write(60);
    if (!"".equals(localObject))
    {
      writer.write((String)localObject);
      writer.write(58);
    }
    writer.write(paramString2);
    pending = true;
    return this;
  }
  
  public XmlSerializer text(String paramString)
    throws IOException
  {
    check(false);
    indent[depth] = false;
    writeEscaped(paramString, -1);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    text(new String(paramArrayOfChar, paramInt1, paramInt2));
    return this;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kxml2/io/KXmlSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */