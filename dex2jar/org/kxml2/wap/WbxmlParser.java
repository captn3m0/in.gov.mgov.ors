package org.kxml2.wap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class WbxmlParser
  implements XmlPullParser
{
  static final String HEX_DIGITS = "0123456789abcdef";
  private static final String ILLEGAL_TYPE = "Wrong event type";
  private static final String UNEXPECTED_EOF = "Unexpected EOF";
  public static final int WAP_EXTENSION = 64;
  private int ATTR_START_TABLE = 1;
  private int ATTR_VALUE_TABLE = 2;
  private int TAG_TABLE = 0;
  private String[] attrStartTable;
  private String[] attrValueTable;
  private int attributeCount;
  private String[] attributes = new String[16];
  private Hashtable cacheStringTable = null;
  private boolean degenerated;
  private int depth;
  private String[] elementStack = new String[16];
  private String encoding;
  private InputStream in;
  private boolean isWhitespace;
  private String name;
  private String namespace;
  private int nextId = -2;
  private int[] nspCounts = new int[4];
  private String[] nspStack = new String[8];
  private String prefix;
  private boolean processNsp;
  private int publicIdentifierId;
  private byte[] stringTable;
  private Vector tables = new Vector();
  private String[] tagTable;
  private String text;
  private int type;
  private int version;
  private int wapCode;
  private Object wapExtensionData;
  
  private final boolean adjustNsp()
    throws XmlPullParserException
  {
    boolean bool1 = false;
    int i = 0;
    Object localObject1;
    int j;
    Object localObject2;
    if (i < attributeCount << 2)
    {
      localObject1 = attributes[(i + 2)];
      j = ((String)localObject1).indexOf(':');
      label57:
      boolean bool2;
      if (j != -1)
      {
        localObject2 = ((String)localObject1).substring(0, j);
        localObject1 = ((String)localObject1).substring(j + 1);
        if (((String)localObject2).equals("xmlns")) {
          break label109;
        }
        bool2 = true;
        j = i;
      }
      for (;;)
      {
        i = j + 4;
        bool1 = bool2;
        break;
        bool2 = bool1;
        j = i;
        if (((String)localObject1).equals("xmlns"))
        {
          localObject2 = localObject1;
          localObject1 = null;
          break label57;
          label109:
          localObject2 = nspCounts;
          j = depth;
          int k = localObject2[j];
          localObject2[j] = (k + 1);
          j = k << 1;
          nspStack = ensureCapacity(nspStack, j + 2);
          nspStack[j] = localObject1;
          nspStack[(j + 1)] = attributes[(i + 3)];
          if ((localObject1 != null) && (attributes[(i + 3)].equals(""))) {
            exception("illegal empty namespace");
          }
          localObject1 = attributes;
          localObject2 = attributes;
          j = attributeCount - 1;
          attributeCount = j;
          System.arraycopy(localObject1, i + 4, localObject2, i, (j << 2) - i);
          j = i - 4;
          bool2 = bool1;
        }
      }
    }
    if (bool1)
    {
      i = (attributeCount << 2) - 4;
      while (i >= 0)
      {
        localObject2 = attributes[(i + 2)];
        j = ((String)localObject2).indexOf(':');
        if (j == 0) {
          throw new RuntimeException("illegal attribute name: " + (String)localObject2 + " at " + this);
        }
        if (j != -1)
        {
          localObject1 = ((String)localObject2).substring(0, j);
          localObject2 = ((String)localObject2).substring(j + 1);
          String str = getNamespace((String)localObject1);
          if (str == null) {
            throw new RuntimeException("Undefined Prefix: " + (String)localObject1 + " in " + this);
          }
          attributes[i] = str;
          attributes[(i + 1)] = localObject1;
          attributes[(i + 2)] = localObject2;
          j = (attributeCount << 2) - 4;
          while (j > i)
          {
            if ((((String)localObject2).equals(attributes[(j + 2)])) && (str.equals(attributes[j]))) {
              exception("Duplicate Attribute: {" + str + "}" + (String)localObject2);
            }
            j -= 4;
          }
        }
        i -= 4;
      }
    }
    i = name.indexOf(':');
    if (i == 0) {
      exception("illegal tag name: " + name);
    }
    for (;;)
    {
      namespace = getNamespace(prefix);
      if (namespace == null)
      {
        if (prefix != null) {
          exception("undefined prefix: " + prefix);
        }
        namespace = "";
      }
      return bool1;
      if (i != -1)
      {
        prefix = name.substring(0, i);
        name = name.substring(i + 1);
      }
    }
  }
  
  private final String[] ensureCapacity(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString.length >= paramInt) {
      return paramArrayOfString;
    }
    String[] arrayOfString = new String[paramInt + 16];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    return arrayOfString;
  }
  
  private final void exception(String paramString)
    throws XmlPullParserException
  {
    throw new XmlPullParserException(paramString, this, null);
  }
  
  private final void nextImpl()
    throws IOException, XmlPullParserException
  {
    if (type == 3) {
      depth -= 1;
    }
    if (degenerated)
    {
      type = 3;
      degenerated = false;
      return;
    }
    text = null;
    prefix = null;
    name = null;
    for (int i = peekId(); i == 0; i = peekId())
    {
      nextId = -2;
      selectPage(readByte(), true);
    }
    nextId = -2;
    switch (i)
    {
    default: 
      parseElement(i);
      return;
    case -1: 
      type = 1;
      return;
    case 1: 
      i = depth - 1 << 2;
      type = 3;
      namespace = elementStack[i];
      prefix = elementStack[(i + 1)];
      name = elementStack[(i + 2)];
      return;
    case 2: 
      type = 6;
      char c = (char)readInt();
      text = ("" + c);
      name = ("#" + c);
      return;
    case 3: 
      type = 4;
      text = readStrI();
      return;
    case 64: 
    case 65: 
    case 66: 
    case 128: 
    case 129: 
    case 130: 
    case 192: 
    case 193: 
    case 194: 
    case 195: 
      type = 64;
      wapCode = i;
      wapExtensionData = parseWapExtension(i);
      return;
    case 67: 
      throw new RuntimeException("PI curr. not supp.");
    }
    type = 4;
    text = readStrT();
  }
  
  private int peekId()
    throws IOException
  {
    if (nextId == -2) {
      nextId = in.read();
    }
    return nextId;
  }
  
  private void selectPage(int paramInt, boolean paramBoolean)
    throws XmlPullParserException
  {
    if ((tables.size() == 0) && (paramInt == 0)) {
      return;
    }
    if (paramInt * 3 > tables.size()) {
      exception("Code Page " + paramInt + " undefined!");
    }
    if (paramBoolean)
    {
      tagTable = ((String[])tables.elementAt(paramInt * 3 + TAG_TABLE));
      return;
    }
    attrStartTable = ((String[])tables.elementAt(paramInt * 3 + ATTR_START_TABLE));
    attrValueTable = ((String[])tables.elementAt(paramInt * 3 + ATTR_VALUE_TABLE));
  }
  
  private final void setTable(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if (stringTable != null) {
      throw new RuntimeException("setXxxTable must be called before setInput!");
    }
    while (tables.size() < paramInt1 * 3 + 3) {
      tables.addElement(null);
    }
    tables.setElementAt(paramArrayOfString, paramInt1 * 3 + paramInt2);
  }
  
  public void defineEntityReplacementText(String paramString1, String paramString2)
    throws XmlPullParserException
  {}
  
  public int getAttributeCount()
  {
    return attributeCount;
  }
  
  public String getAttributeName(int paramInt)
  {
    if (paramInt >= attributeCount) {
      throw new IndexOutOfBoundsException();
    }
    return attributes[((paramInt << 2) + 2)];
  }
  
  public String getAttributeNamespace(int paramInt)
  {
    if (paramInt >= attributeCount) {
      throw new IndexOutOfBoundsException();
    }
    return attributes[(paramInt << 2)];
  }
  
  public String getAttributePrefix(int paramInt)
  {
    if (paramInt >= attributeCount) {
      throw new IndexOutOfBoundsException();
    }
    return attributes[((paramInt << 2) + 1)];
  }
  
  public String getAttributeType(int paramInt)
  {
    return "CDATA";
  }
  
  public String getAttributeValue(int paramInt)
  {
    if (paramInt >= attributeCount) {
      throw new IndexOutOfBoundsException();
    }
    return attributes[((paramInt << 2) + 3)];
  }
  
  public String getAttributeValue(String paramString1, String paramString2)
  {
    int i = (attributeCount << 2) - 4;
    while (i >= 0)
    {
      if ((attributes[(i + 2)].equals(paramString2)) && ((paramString1 == null) || (attributes[i].equals(paramString1)))) {
        return attributes[(i + 3)];
      }
      i -= 4;
    }
    return null;
  }
  
  public int getColumnNumber()
  {
    return -1;
  }
  
  public int getDepth()
  {
    return depth;
  }
  
  public int getEventType()
    throws XmlPullParserException
  {
    return type;
  }
  
  public boolean getFeature(String paramString)
  {
    if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(paramString)) {
      return processNsp;
    }
    return false;
  }
  
  public String getInputEncoding()
  {
    return encoding;
  }
  
  public int getLineNumber()
  {
    return -1;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public String getNamespace(String paramString)
  {
    if ("xml".equals(paramString)) {
      return "http://www.w3.org/XML/1998/namespace";
    }
    if ("xmlns".equals(paramString)) {
      return "http://www.w3.org/2000/xmlns/";
    }
    int i = (getNamespaceCount(depth) << 1) - 2;
    while (i >= 0)
    {
      if (paramString == null)
      {
        if (nspStack[i] == null) {
          return nspStack[(i + 1)];
        }
      }
      else if (paramString.equals(nspStack[i])) {
        return nspStack[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public int getNamespaceCount(int paramInt)
  {
    if (paramInt > depth) {
      throw new IndexOutOfBoundsException();
    }
    return nspCounts[paramInt];
  }
  
  public String getNamespacePrefix(int paramInt)
  {
    return nspStack[(paramInt << 1)];
  }
  
  public String getNamespaceUri(int paramInt)
  {
    return nspStack[((paramInt << 1) + 1)];
  }
  
  public String getPositionDescription()
  {
    if (type < TYPES.length) {}
    StringBuffer localStringBuffer;
    for (Object localObject = TYPES[type];; localObject = "unknown")
    {
      localStringBuffer = new StringBuffer((String)localObject);
      localStringBuffer.append(' ');
      if ((type != 2) && (type != 3)) {
        break label322;
      }
      if (degenerated) {
        localStringBuffer.append("(empty) ");
      }
      localStringBuffer.append('<');
      if (type == 3) {
        localStringBuffer.append('/');
      }
      if (prefix != null) {
        localStringBuffer.append("{" + namespace + "}" + prefix + ":");
      }
      localStringBuffer.append(name);
      int j = attributeCount;
      int i = 0;
      while (i < j << 2)
      {
        localStringBuffer.append(' ');
        if (attributes[(i + 1)] != null) {
          localStringBuffer.append("{" + attributes[i] + "}" + attributes[(i + 1)] + ":");
        }
        localStringBuffer.append(attributes[(i + 2)] + "='" + attributes[(i + 3)] + "'");
        i += 4;
      }
    }
    localStringBuffer.append('>');
    for (;;)
    {
      return localStringBuffer.toString();
      label322:
      if (type != 7) {
        if (type != 4)
        {
          localStringBuffer.append(getText());
        }
        else if (isWhitespace)
        {
          localStringBuffer.append("(whitespace)");
        }
        else
        {
          String str = getText();
          localObject = str;
          if (str.length() > 16) {
            localObject = str.substring(0, 16) + "...";
          }
          localStringBuffer.append((String)localObject);
        }
      }
    }
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public Object getProperty(String paramString)
  {
    return null;
  }
  
  public String getText()
  {
    return text;
  }
  
  public char[] getTextCharacters(int[] paramArrayOfInt)
  {
    if (type >= 4)
    {
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = text.length();
      paramArrayOfInt = new char[text.length()];
      text.getChars(0, text.length(), paramArrayOfInt, 0);
      return paramArrayOfInt;
    }
    paramArrayOfInt[0] = -1;
    paramArrayOfInt[1] = -1;
    return null;
  }
  
  public int getWapCode()
  {
    return wapCode;
  }
  
  public Object getWapExtensionData()
  {
    return wapExtensionData;
  }
  
  public boolean isAttributeDefault(int paramInt)
  {
    return false;
  }
  
  public boolean isEmptyElementTag()
    throws XmlPullParserException
  {
    if (type != 2) {
      exception("Wrong event type");
    }
    return degenerated;
  }
  
  public boolean isWhitespace()
    throws XmlPullParserException
  {
    if ((type != 4) && (type != 7) && (type != 5)) {
      exception("Wrong event type");
    }
    return isWhitespace;
  }
  
  public int next()
    throws XmlPullParserException, IOException
  {
    isWhitespace = true;
    int i = 9999;
    String str;
    int j;
    do
    {
      str = text;
      nextImpl();
      j = i;
      if (type < i) {
        j = type;
      }
      i = j;
    } while (j > 5);
    if (j >= 4) {
      if (str != null) {
        if (text != null) {
          break label155;
        }
      }
    }
    for (;;)
    {
      text = str;
      i = j;
      switch (peekId())
      {
      }
      type = j;
      if (type > 4) {
        type = 4;
      }
      return type;
      label155:
      str = str + text;
    }
  }
  
  public int nextTag()
    throws XmlPullParserException, IOException
  {
    next();
    if ((type == 4) && (isWhitespace)) {
      next();
    }
    if ((type != 3) && (type != 2)) {
      exception("unexpected type");
    }
    return type;
  }
  
  public String nextText()
    throws XmlPullParserException, IOException
  {
    if (type != 2) {
      exception("precondition: START_TAG");
    }
    next();
    String str;
    if (type == 4)
    {
      str = getText();
      next();
    }
    for (;;)
    {
      if (type != 3) {
        exception("END_TAG expected");
      }
      return str;
      str = "";
    }
  }
  
  public int nextToken()
    throws XmlPullParserException, IOException
  {
    isWhitespace = true;
    nextImpl();
    return type;
  }
  
  void parseElement(int paramInt)
    throws IOException, XmlPullParserException
  {
    type = 2;
    name = resolveId(tagTable, paramInt & 0x3F);
    attributeCount = 0;
    if ((paramInt & 0x80) != 0) {
      readAttr();
    }
    boolean bool;
    int j;
    if ((paramInt & 0x40) == 0)
    {
      bool = true;
      degenerated = bool;
      paramInt = depth;
      depth = (paramInt + 1);
      j = paramInt << 2;
      elementStack = ensureCapacity(elementStack, j + 4);
      elementStack[(j + 3)] = name;
      if (depth >= nspCounts.length)
      {
        int[] arrayOfInt = new int[depth + 4];
        System.arraycopy(nspCounts, 0, arrayOfInt, 0, nspCounts.length);
        nspCounts = arrayOfInt;
      }
      nspCounts[depth] = nspCounts[(depth - 1)];
      paramInt = attributeCount - 1;
    }
    for (;;)
    {
      if (paramInt <= 0) {
        break label243;
      }
      int i = 0;
      for (;;)
      {
        if (i < paramInt)
        {
          if (getAttributeName(paramInt).equals(getAttributeName(i))) {
            exception("Duplicate Attribute: " + getAttributeName(paramInt));
          }
          i += 1;
          continue;
          bool = false;
          break;
        }
      }
      paramInt -= 1;
    }
    label243:
    if (processNsp) {
      adjustNsp();
    }
    for (;;)
    {
      elementStack[j] = namespace;
      elementStack[(j + 1)] = prefix;
      elementStack[(j + 2)] = name;
      return;
      namespace = "";
    }
  }
  
  public Object parseWapExtension(int paramInt)
    throws IOException, XmlPullParserException
  {
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = arrayOfByte2;
    switch (paramInt)
    {
    default: 
      exception("illegal id: " + paramInt);
      arrayOfByte1 = arrayOfByte2;
    case 192: 
    case 193: 
    case 194: 
      return arrayOfByte1;
    case 64: 
    case 65: 
    case 66: 
      return readStrI();
    case 128: 
    case 129: 
    case 130: 
      return new Integer(readInt());
    }
    paramInt = readInt();
    arrayOfByte2 = new byte[paramInt];
    for (;;)
    {
      arrayOfByte1 = arrayOfByte2;
      if (paramInt <= 0) {
        break;
      }
      paramInt -= in.read(arrayOfByte2, arrayOfByte2.length - paramInt, paramInt);
    }
  }
  
  public void readAttr()
    throws IOException, XmlPullParserException
  {
    int i = readByte();
    int j = 0;
    while (i != 1)
    {
      while (i == 0)
      {
        selectPage(readByte(), false);
        i = readByte();
      }
      Object localObject = resolveId(attrStartTable, i);
      i = ((String)localObject).indexOf('=');
      StringBuffer localStringBuffer;
      if (i == -1)
      {
        localStringBuffer = new StringBuffer();
        i = readByte();
        label71:
        if ((i <= 128) && (i != 0) && (i != 2) && (i != 3) && (i != 131) && ((i < 64) || (i > 66)) && ((i < 128) || (i > 130))) {
          break label371;
        }
        switch (i)
        {
        default: 
          localStringBuffer.append(resolveId(attrValueTable, i));
        }
      }
      for (;;)
      {
        i = readByte();
        break label71;
        localStringBuffer = new StringBuffer(((String)localObject).substring(i + 1));
        localObject = ((String)localObject).substring(0, i);
        break;
        selectPage(readByte(), false);
        continue;
        localStringBuffer.append((char)readInt());
        continue;
        localStringBuffer.append(readStrI());
        continue;
        localStringBuffer.append(resolveWapExtension(i, parseWapExtension(i)));
        continue;
        localStringBuffer.append(readStrT());
      }
      label371:
      attributes = ensureCapacity(attributes, j + 4);
      String[] arrayOfString = attributes;
      int k = j + 1;
      arrayOfString[j] = "";
      arrayOfString = attributes;
      j = k + 1;
      arrayOfString[k] = null;
      arrayOfString = attributes;
      k = j + 1;
      arrayOfString[j] = localObject;
      localObject = attributes;
      j = k + 1;
      localObject[k] = localStringBuffer.toString();
      attributeCount += 1;
    }
  }
  
  int readByte()
    throws IOException
  {
    int i = in.read();
    if (i == -1) {
      throw new IOException("Unexpected EOF");
    }
    return i;
  }
  
  int readInt()
    throws IOException
  {
    int i = 0;
    int k;
    int j;
    do
    {
      k = readByte();
      j = i << 7 | k & 0x7F;
      i = j;
    } while ((k & 0x80) != 0);
    return j;
  }
  
  String readStrI()
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = true;
    for (;;)
    {
      int i = in.read();
      if (i == 0)
      {
        isWhitespace = bool;
        String str = new String(localByteArrayOutputStream.toByteArray(), encoding);
        localByteArrayOutputStream.close();
        return str;
      }
      if (i == -1) {
        throw new IOException("Unexpected EOF");
      }
      if (i > 32) {
        bool = false;
      }
      localByteArrayOutputStream.write(i);
    }
  }
  
  String readStrT()
    throws IOException
  {
    int j = readInt();
    if (cacheStringTable == null) {
      cacheStringTable = new Hashtable();
    }
    String str2 = (String)cacheStringTable.get(new Integer(j));
    String str1 = str2;
    if (str2 == null)
    {
      int i = j;
      while ((i < stringTable.length) && (stringTable[i] != 0)) {
        i += 1;
      }
      str1 = new String(stringTable, j, i - j, encoding);
      cacheStringTable.put(new Integer(j), str1);
    }
    return str1;
  }
  
  public void require(int paramInt, String paramString1, String paramString2)
    throws XmlPullParserException, IOException
  {
    StringBuilder localStringBuilder;
    if ((paramInt != type) || ((paramString1 != null) && (!paramString1.equals(getNamespace()))) || ((paramString2 != null) && (!paramString2.equals(getName()))))
    {
      localStringBuilder = new StringBuilder().append("expected: ");
      if (paramInt != 64) {
        break label77;
      }
    }
    label77:
    for (paramString1 = "WAP Ext.";; paramString1 = TYPES[paramInt] + " {" + paramString1 + "}" + paramString2)
    {
      exception(paramString1);
      return;
    }
  }
  
  String resolveId(String[] paramArrayOfString, int paramInt)
    throws IOException
  {
    int i = (paramInt & 0x7F) - 5;
    if (i == -1)
    {
      wapCode = -1;
      return readStrT();
    }
    if ((i < 0) || (paramArrayOfString == null) || (i >= paramArrayOfString.length) || (paramArrayOfString[i] == null)) {
      throw new IOException("id " + paramInt + " undef.");
    }
    wapCode = (i + 5);
    return paramArrayOfString[i];
  }
  
  protected String resolveWapExtension(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof byte[]))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      paramObject = (byte[])paramObject;
      paramInt = 0;
      while (paramInt < paramObject.length)
      {
        localStringBuffer.append("0123456789abcdef".charAt(paramObject[paramInt] >> 4 & 0xF));
        localStringBuffer.append("0123456789abcdef".charAt(paramObject[paramInt] & 0xF));
        paramInt += 1;
      }
      return localStringBuffer.toString();
    }
    return "$(" + paramObject + ")";
  }
  
  public void setAttrStartTable(int paramInt, String[] paramArrayOfString)
  {
    setTable(paramInt, ATTR_START_TABLE, paramArrayOfString);
  }
  
  public void setAttrValueTable(int paramInt, String[] paramArrayOfString)
  {
    setTable(paramInt, ATTR_VALUE_TABLE, paramArrayOfString);
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
    throws XmlPullParserException
  {
    if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(paramString))
    {
      processNsp = paramBoolean;
      return;
    }
    exception("unsupported feature: " + paramString);
  }
  
  public void setInput(InputStream paramInputStream, String paramString)
    throws XmlPullParserException
  {
    in = paramInputStream;
    for (;;)
    {
      try
      {
        version = readByte();
        publicIdentifierId = readInt();
        if (publicIdentifierId == 0) {
          readInt();
        }
        i = readInt();
        if (paramString != null) {
          break label176;
        }
        switch (i)
        {
        case 4: 
          throw new UnsupportedEncodingException("" + i);
        }
      }
      catch (IOException paramInputStream)
      {
        exception("Illegal input format");
        return;
      }
      encoding = "ISO-8859-1";
      int j = readInt();
      stringTable = new byte[j];
      int i = 0;
      for (;;)
      {
        int k;
        if (i < j)
        {
          k = paramInputStream.read(stringTable, i, j - i);
          if (k > 0) {}
        }
        else
        {
          selectPage(0, true);
          selectPage(0, false);
          return;
          encoding = "UTF-8";
          break;
          label176:
          encoding = paramString;
          break;
        }
        i += k;
      }
    }
  }
  
  public void setInput(Reader paramReader)
    throws XmlPullParserException
  {
    exception("InputStream required");
  }
  
  public void setProperty(String paramString, Object paramObject)
    throws XmlPullParserException
  {
    throw new XmlPullParserException("unsupported property: " + paramString);
  }
  
  public void setTagTable(int paramInt, String[] paramArrayOfString)
  {
    setTable(paramInt, TAG_TABLE, paramArrayOfString);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kxml2/wap/WbxmlParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */