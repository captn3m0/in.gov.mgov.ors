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
  private String[] attributes;
  private Hashtable cacheStringTable = null;
  private boolean degenerated;
  private int depth;
  private String[] elementStack;
  private String encoding;
  private InputStream in;
  private boolean isWhitespace;
  private String name;
  private String namespace;
  private int nextId;
  private int[] nspCounts;
  private String[] nspStack;
  private String prefix;
  private boolean processNsp;
  private int publicIdentifierId;
  private byte[] stringTable;
  private Vector tables;
  private String[] tagTable;
  private String text;
  private int type;
  private int version;
  private int wapCode;
  private Object wapExtensionData;
  
  public WbxmlParser()
  {
    Object localObject = new String[i];
    elementStack = ((String[])localObject);
    localObject = new String[8];
    nspStack = ((String[])localObject);
    localObject = new int[4];
    nspCounts = ((int[])localObject);
    localObject = new String[i];
    attributes = ((String[])localObject);
    nextId = -2;
    localObject = new java/util/Vector;
    ((Vector)localObject).<init>();
    tables = ((Vector)localObject);
  }
  
  private final boolean adjustNsp()
  {
    int i = 58;
    int j = -1;
    boolean bool1 = false;
    int k = 0;
    int m = attributeCount << 2;
    int i1;
    String str1;
    label83:
    label140:
    int i5;
    Object localObject3;
    if (k < m)
    {
      localObject1 = attributes;
      i1 = k + 2;
      str1 = localObject1[i1];
      i2 = str1.indexOf(i);
      String str2;
      boolean bool2;
      if (i2 != j)
      {
        str2 = str1.substring(0, i2);
        m = i2 + 1;
        str1 = str1.substring(m);
        localObject1 = "xmlns";
        bool2 = str2.equals(localObject1);
        if (bool2) {
          break label140;
        }
        bool1 = true;
      }
      for (;;)
      {
        k += 4;
        break;
        localObject1 = "xmlns";
        bool2 = str1.equals(localObject1);
        if (bool2)
        {
          str2 = str1;
          str1 = null;
          break label83;
          localObject1 = nspCounts;
          i1 = depth;
          int i3 = localObject1[i1];
          int i4 = i3 + 1;
          localObject1[i1] = i4;
          i5 = i3 << 1;
          localObject1 = nspStack;
          i1 = i5 + 2;
          localObject1 = ensureCapacity((String[])localObject1, i1);
          nspStack = ((String[])localObject1);
          nspStack[i5] = str1;
          localObject1 = nspStack;
          i1 = i5 + 1;
          Object localObject2 = attributes;
          i4 = k + 3;
          localObject2 = localObject2[i4];
          localObject1[i1] = localObject2;
          if (str1 != null)
          {
            localObject1 = attributes;
            i1 = k + 3;
            localObject1 = localObject1[i1];
            localObject3 = "";
            bool2 = ((String)localObject1).equals(localObject3);
            if (bool2)
            {
              localObject1 = "illegal empty namespace";
              exception((String)localObject1);
            }
          }
          localObject1 = attributes;
          i1 = k + 4;
          localObject2 = attributes;
          i4 = attributeCount + -1;
          attributeCount = i4;
          i4 = (i4 << 2) - k;
          System.arraycopy(localObject1, i1, localObject2, k, i4);
          k += -4;
        }
      }
    }
    if (bool1)
    {
      int n = attributeCount << 2;
      k = n + -4;
      while (k >= 0)
      {
        localObject1 = attributes;
        i1 = k + 2;
        str1 = localObject1[i1];
        i2 = str1.indexOf(i);
        if (i2 == 0)
        {
          localObject1 = new java/lang/RuntimeException;
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          localObject3 = "illegal attribute name: " + str1 + " at " + this;
          ((RuntimeException)localObject1).<init>((String)localObject3);
          throw ((Throwable)localObject1);
        }
        if (i2 != j)
        {
          String str3 = str1.substring(0, i2);
          n = i2 + 1;
          str1 = str1.substring(n);
          String str4 = getNamespace(str3);
          if (str4 == null)
          {
            localObject1 = new java/lang/RuntimeException;
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            localObject3 = "Undefined Prefix: " + str3 + " in " + this;
            ((RuntimeException)localObject1).<init>((String)localObject3);
            throw ((Throwable)localObject1);
          }
          attributes[k] = str4;
          localObject1 = attributes;
          i1 = k + 1;
          localObject1[i1] = str3;
          localObject1 = attributes;
          i1 = k + 2;
          localObject1[i1] = str1;
          n = attributeCount << 2;
          i5 = n + -4;
          while (i5 > k)
          {
            localObject1 = attributes;
            i1 = i5 + 2;
            localObject1 = localObject1[i1];
            boolean bool3 = str1.equals(localObject1);
            if (bool3)
            {
              localObject1 = attributes[i5];
              bool3 = str4.equals(localObject1);
              if (bool3)
              {
                localObject1 = new java/lang/StringBuilder;
                ((StringBuilder)localObject1).<init>();
                localObject1 = ((StringBuilder)localObject1).append("Duplicate Attribute: {").append(str4);
                localObject3 = "}";
                localObject1 = (String)localObject3 + str1;
                exception((String)localObject1);
              }
            }
            i5 += -4;
          }
        }
        k += -4;
      }
    }
    Object localObject1 = name;
    int i2 = ((String)localObject1).indexOf(i);
    if (i2 == 0)
    {
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject1 = ((StringBuilder)localObject1).append("illegal tag name: ");
      localObject3 = name;
      localObject1 = (String)localObject3;
      exception((String)localObject1);
    }
    for (;;)
    {
      localObject1 = prefix;
      localObject1 = getNamespace((String)localObject1);
      namespace = ((String)localObject1);
      localObject1 = namespace;
      if (localObject1 == null)
      {
        localObject1 = prefix;
        if (localObject1 != null)
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          localObject1 = ((StringBuilder)localObject1).append("undefined prefix: ");
          localObject3 = prefix;
          localObject1 = (String)localObject3;
          exception((String)localObject1);
        }
        localObject1 = "";
        namespace = ((String)localObject1);
      }
      return bool1;
      if (i2 != j)
      {
        localObject1 = name.substring(0, i2);
        prefix = ((String)localObject1);
        localObject1 = name;
        i1 = i2 + 1;
        localObject1 = ((String)localObject1).substring(i1);
        name = ((String)localObject1);
      }
    }
  }
  
  private final String[] ensureCapacity(String[] paramArrayOfString, int paramInt)
  {
    int i = paramArrayOfString.length;
    if (i >= paramInt) {}
    for (;;)
    {
      return paramArrayOfString;
      String[] arrayOfString = new String[paramInt + 16];
      i = paramArrayOfString.length;
      System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, i);
      paramArrayOfString = arrayOfString;
    }
  }
  
  private final void exception(String paramString)
  {
    XmlPullParserException localXmlPullParserException = new org/xmlpull/v1/XmlPullParserException;
    localXmlPullParserException.<init>(paramString, this, null);
    throw localXmlPullParserException;
  }
  
  private final void nextImpl()
  {
    int i = 4;
    int j = 1;
    int k = -2;
    int m = 3;
    int n = type;
    if (n == m)
    {
      n = depth + -1;
      depth = n;
    }
    boolean bool = degenerated;
    Object localObject;
    if (bool)
    {
      type = m;
      bool = false;
      localObject = null;
      degenerated = false;
    }
    for (;;)
    {
      return;
      text = null;
      prefix = null;
      name = null;
      int i1;
      for (int i2 = peekId(); i2 == 0; i2 = peekId())
      {
        nextId = k;
        i1 = readByte();
        selectPage(i1, j);
      }
      nextId = k;
      switch (i2)
      {
      default: 
        parseElement(i2);
        break;
      case -1: 
        type = j;
        break;
      case 1: 
        i1 = depth + -1;
        int i3 = i1 << 2;
        type = m;
        localObject = elementStack[i3];
        namespace = ((String)localObject);
        localObject = elementStack;
        m = i3 + 1;
        localObject = localObject[m];
        prefix = ((String)localObject);
        localObject = elementStack;
        m = i3 + 2;
        localObject = localObject[m];
        name = ((String)localObject);
        break;
      case 2: 
        type = 6;
        i1 = readInt();
        char c = (char)i1;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        localObject = "" + c;
        text = ((String)localObject);
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        String str = "#";
        localObject = str + c;
        name = ((String)localObject);
        break;
      case 3: 
        type = i;
        localObject = readStrI();
        text = ((String)localObject);
        break;
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
        i1 = 64;
        type = i1;
        wapCode = i2;
        localObject = parseWapExtension(i2);
        wapExtensionData = localObject;
        break;
      case 67: 
        localObject = new java/lang/RuntimeException;
        ((RuntimeException)localObject).<init>("PI curr. not supp.");
        throw ((Throwable)localObject);
      case 131: 
        type = i;
        localObject = readStrT();
        text = ((String)localObject);
      }
    }
  }
  
  private int peekId()
  {
    int i = nextId;
    int j = -2;
    if (i == j)
    {
      InputStream localInputStream = in;
      i = localInputStream.read();
      nextId = i;
    }
    return nextId;
  }
  
  private void selectPage(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = tables;
    int i = ((Vector)localObject1).size();
    if ((i == 0) && (paramInt == 0)) {}
    for (;;)
    {
      return;
      i = paramInt * 3;
      Object localObject2 = tables;
      int j = ((Vector)localObject2).size();
      if (i > j)
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localObject1 = ((StringBuilder)localObject1).append("Code Page ").append(paramInt);
        localObject2 = " undefined!";
        localObject1 = (String)localObject2;
        exception((String)localObject1);
      }
      int k;
      if (paramBoolean)
      {
        localObject1 = tables;
        j = paramInt * 3;
        k = TAG_TABLE;
        j += k;
        localObject1 = (String[])((Vector)localObject1).elementAt(j);
        tagTable = ((String[])localObject1);
      }
      else
      {
        localObject1 = tables;
        j = paramInt * 3;
        k = ATTR_START_TABLE;
        j += k;
        localObject1 = (String[])((Vector)localObject1).elementAt(j);
        attrStartTable = ((String[])localObject1);
        localObject1 = tables;
        j = paramInt * 3;
        k = ATTR_VALUE_TABLE;
        j += k;
        localObject1 = (String[])((Vector)localObject1).elementAt(j);
        attrValueTable = ((String[])localObject1);
      }
    }
  }
  
  private final void setTable(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    Object localObject = stringTable;
    if (localObject != null)
    {
      localObject = new java/lang/RuntimeException;
      ((RuntimeException)localObject).<init>("setXxxTable must be called before setInput!");
      throw ((Throwable)localObject);
    }
    for (;;)
    {
      localObject = tables;
      int i = ((Vector)localObject).size();
      j = paramInt1 * 3 + 3;
      if (i >= j) {
        break;
      }
      localObject = tables;
      j = 0;
      ((Vector)localObject).addElement(null);
    }
    localObject = tables;
    int j = paramInt1 * 3 + paramInt2;
    ((Vector)localObject).setElementAt(paramArrayOfString, j);
  }
  
  public void defineEntityReplacementText(String paramString1, String paramString2) {}
  
  public int getAttributeCount()
  {
    return attributeCount;
  }
  
  public String getAttributeName(int paramInt)
  {
    int i = attributeCount;
    if (paramInt >= i)
    {
      localObject = new java/lang/IndexOutOfBoundsException;
      ((IndexOutOfBoundsException)localObject).<init>();
      throw ((Throwable)localObject);
    }
    Object localObject = attributes;
    int j = (paramInt << 2) + 2;
    return localObject[j];
  }
  
  public String getAttributeNamespace(int paramInt)
  {
    int i = attributeCount;
    if (paramInt >= i)
    {
      localObject = new java/lang/IndexOutOfBoundsException;
      ((IndexOutOfBoundsException)localObject).<init>();
      throw ((Throwable)localObject);
    }
    Object localObject = attributes;
    int j = paramInt << 2;
    return localObject[j];
  }
  
  public String getAttributePrefix(int paramInt)
  {
    int i = attributeCount;
    if (paramInt >= i)
    {
      localObject = new java/lang/IndexOutOfBoundsException;
      ((IndexOutOfBoundsException)localObject).<init>();
      throw ((Throwable)localObject);
    }
    Object localObject = attributes;
    int j = (paramInt << 2) + 1;
    return localObject[j];
  }
  
  public String getAttributeType(int paramInt)
  {
    return "CDATA";
  }
  
  public String getAttributeValue(int paramInt)
  {
    int i = attributeCount;
    if (paramInt >= i)
    {
      localObject = new java/lang/IndexOutOfBoundsException;
      ((IndexOutOfBoundsException)localObject).<init>();
      throw ((Throwable)localObject);
    }
    Object localObject = attributes;
    int j = (paramInt << 2) + 3;
    return localObject[j];
  }
  
  public String getAttributeValue(String paramString1, String paramString2)
  {
    int i = attributeCount << 2;
    int j = i + -4;
    int k;
    boolean bool;
    if (j >= 0)
    {
      localObject = attributes;
      k = j + 2;
      localObject = localObject[k];
      bool = ((String)localObject).equals(paramString2);
      if (bool) {
        if (paramString1 != null)
        {
          localObject = attributes[j];
          bool = ((String)localObject).equals(paramString1);
          if (!bool) {}
        }
        else
        {
          localObject = attributes;
          k = j + 3;
        }
      }
    }
    for (Object localObject = localObject[k];; localObject = null)
    {
      return (String)localObject;
      j += -4;
      break;
      bool = false;
    }
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
  {
    return type;
  }
  
  public boolean getFeature(String paramString)
  {
    String str = "http://xmlpull.org/v1/doc/features.html#process-namespaces";
    boolean bool = str.equals(paramString);
    if (bool) {
      bool = processNsp;
    }
    for (;;)
    {
      return bool;
      bool = false;
      str = null;
    }
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
    Object localObject = "xml";
    boolean bool1 = ((String)localObject).equals(paramString);
    if (bool1) {
      localObject = "http://www.w3.org/XML/1998/namespace";
    }
    for (;;)
    {
      return (String)localObject;
      localObject = "xmlns";
      bool1 = ((String)localObject).equals(paramString);
      if (bool1)
      {
        localObject = "http://www.w3.org/2000/xmlns/";
      }
      else
      {
        int i = depth;
        i = getNamespaceCount(i) << 1;
        int j = i + -2;
        for (;;)
        {
          if (j < 0) {
            break label146;
          }
          int k;
          if (paramString == null)
          {
            localObject = nspStack[j];
            if (localObject != null) {
              break label136;
            }
            localObject = nspStack;
            k = j + 1;
            localObject = localObject[k];
            break;
          }
          localObject = nspStack[j];
          bool2 = paramString.equals(localObject);
          if (bool2)
          {
            localObject = nspStack;
            k = j + 1;
            localObject = localObject[k];
            break;
          }
          label136:
          j += -2;
        }
        label146:
        boolean bool2 = false;
        localObject = null;
      }
    }
  }
  
  public int getNamespaceCount(int paramInt)
  {
    int i = depth;
    if (paramInt > i)
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new java/lang/IndexOutOfBoundsException;
      localIndexOutOfBoundsException.<init>();
      throw localIndexOutOfBoundsException;
    }
    return nspCounts[paramInt];
  }
  
  public String getNamespacePrefix(int paramInt)
  {
    String[] arrayOfString = nspStack;
    int i = paramInt << 1;
    return arrayOfString[i];
  }
  
  public String getNamespaceUri(int paramInt)
  {
    String[] arrayOfString = nspStack;
    int i = (paramInt << 1) + 1;
    return arrayOfString[i];
  }
  
  public String getPositionDescription()
  {
    char c = ' ';
    int i = 16;
    int j = 3;
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    int k = type;
    Object localObject1 = TYPES;
    int i3 = localObject1.length;
    if (k < i3)
    {
      localObject2 = TYPES;
      i3 = type;
    }
    for (Object localObject2 = localObject2[i3];; localObject2 = "unknown")
    {
      localStringBuffer.<init>((String)localObject2);
      localStringBuffer.append(c);
      k = type;
      i3 = 2;
      if (k != i3)
      {
        k = type;
        if (k != j) {
          break label532;
        }
      }
      boolean bool1 = degenerated;
      if (bool1)
      {
        localObject2 = "(empty) ";
        localStringBuffer.append((String)localObject2);
      }
      localStringBuffer.append('<');
      int m = type;
      if (m == j)
      {
        m = 47;
        localStringBuffer.append(m);
      }
      localObject2 = prefix;
      if (localObject2 != null)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject2 = ((StringBuilder)localObject2).append("{");
        localObject1 = namespace;
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("}");
        localObject1 = prefix;
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ":";
        localObject2 = (String)localObject1;
        localStringBuffer.append((String)localObject2);
      }
      localObject2 = name;
      localStringBuffer.append((String)localObject2);
      n = attributeCount;
      int i4 = n << 2;
      int i5 = 0;
      while (i5 < i4)
      {
        localStringBuffer.append(c);
        localObject2 = attributes;
        i3 = i5 + 1;
        localObject2 = localObject2[i3];
        if (localObject2 != null)
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          localObject2 = ((StringBuilder)localObject2).append("{");
          localObject1 = attributes[i5];
          localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("}");
          localObject1 = attributes;
          j = i5 + 1;
          localObject1 = localObject1[j];
          localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ":";
          localObject2 = (String)localObject1;
          localStringBuffer.append((String)localObject2);
        }
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = attributes;
        j = i5 + 2;
        localObject1 = localObject1[j];
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("='");
        localObject1 = attributes;
        j = i5 + 3;
        localObject1 = localObject1[j];
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = "'";
        localObject2 = (String)localObject1;
        localStringBuffer.append((String)localObject2);
        i5 += 4;
      }
    }
    int n = 62;
    localStringBuffer.append(n);
    for (;;)
    {
      return localStringBuffer.toString();
      label532:
      int i1 = type;
      i3 = 7;
      if (i1 != i3)
      {
        i1 = type;
        i3 = 4;
        if (i1 != i3)
        {
          localObject2 = getText();
          localStringBuffer.append((String)localObject2);
        }
        else
        {
          boolean bool2 = isWhitespace;
          if (bool2)
          {
            localObject2 = "(whitespace)";
            localStringBuffer.append((String)localObject2);
          }
          else
          {
            String str = getText();
            int i2 = str.length();
            if (i2 > i)
            {
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>();
              i3 = 0;
              localObject1 = str.substring(0, i);
              localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
              localObject1 = "...";
              localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
              str = ((StringBuilder)localObject2).toString();
            }
            localStringBuffer.append(str);
          }
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
    int i = 1;
    int j = -1;
    int k = type;
    int m = 4;
    char[] arrayOfChar;
    if (k >= m)
    {
      paramArrayOfInt[0] = 0;
      k = text.length();
      paramArrayOfInt[i] = k;
      k = text.length();
      arrayOfChar = new char[k];
      String str1 = text;
      String str2 = text;
      m = str2.length();
      str1.getChars(0, m, arrayOfChar, 0);
    }
    for (;;)
    {
      return arrayOfChar;
      paramArrayOfInt[0] = j;
      paramArrayOfInt[i] = j;
      arrayOfChar = null;
    }
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
  {
    int i = type;
    int j = 2;
    if (i != j)
    {
      String str = "Wrong event type";
      exception(str);
    }
    return degenerated;
  }
  
  public boolean isWhitespace()
  {
    int i = type;
    int j = 4;
    if (i != j)
    {
      i = type;
      j = 7;
      if (i != j)
      {
        i = type;
        j = 5;
        if (i != j)
        {
          String str = "Wrong event type";
          exception(str);
        }
      }
    }
    return isWhitespace;
  }
  
  public int next()
  {
    int i = 4;
    int j = 1;
    isWhitespace = j;
    int k = 9999;
    String str1;
    do
    {
      str1 = text;
      nextImpl();
      j = type;
      if (j < k) {
        k = type;
      }
      j = 5;
    } while (k > j);
    Object localObject;
    if (k >= i) {
      if (str1 != null)
      {
        localObject = text;
        if (localObject != null) {
          break label169;
        }
      }
    }
    for (;;)
    {
      text = str1;
      j = peekId();
      switch (j)
      {
      }
      type = k;
      j = type;
      if (j > i) {
        type = i;
      }
      return type;
      label169:
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = ((StringBuilder)localObject).append(str1);
      String str2 = text;
      localObject = ((StringBuilder)localObject).append(str2);
      str1 = ((StringBuilder)localObject).toString();
    }
  }
  
  public int nextTag()
  {
    next();
    int i = type;
    int k = 4;
    if (i == k)
    {
      boolean bool = isWhitespace;
      if (bool) {
        next();
      }
    }
    int j = type;
    k = 3;
    if (j != k)
    {
      j = type;
      k = 2;
      if (j != k)
      {
        String str = "unexpected type";
        exception(str);
      }
    }
    return type;
  }
  
  public String nextText()
  {
    int i = type;
    int j = 2;
    String str1;
    if (i != j)
    {
      str1 = "precondition: START_TAG";
      exception(str1);
    }
    next();
    i = type;
    j = 4;
    String str2;
    if (i == j)
    {
      str2 = getText();
      next();
    }
    for (;;)
    {
      i = type;
      j = 3;
      if (i != j)
      {
        str1 = "END_TAG expected";
        exception(str1);
      }
      return str2;
      str2 = "";
    }
  }
  
  public int nextToken()
  {
    isWhitespace = true;
    nextImpl();
    return type;
  }
  
  void parseElement(int paramInt)
  {
    int i = 0;
    String str1 = null;
    type = 2;
    Object localObject1 = tagTable;
    int j = paramInt & 0x3F;
    localObject1 = resolveId((String[])localObject1, j);
    name = ((String)localObject1);
    attributeCount = 0;
    int k = paramInt & 0x80;
    if (k != 0) {
      readAttr();
    }
    k = paramInt & 0x40;
    int m;
    Object localObject2;
    int i1;
    if (k == 0)
    {
      k = 1;
      degenerated = k;
      k = depth;
      j = k + 1;
      depth = j;
      m = k << 2;
      localObject1 = elementStack;
      j = m + 4;
      localObject1 = ensureCapacity((String[])localObject1, j);
      elementStack = ((String[])localObject1);
      localObject1 = elementStack;
      j = m + 3;
      String str2 = name;
      localObject1[j] = str2;
      k = depth;
      localObject2 = nspCounts;
      j = localObject2.length;
      if (k >= j)
      {
        k = depth + 4;
        int[] arrayOfInt = new int[k];
        localObject1 = nspCounts;
        localObject2 = nspCounts;
        j = localObject2.length;
        System.arraycopy(localObject1, 0, arrayOfInt, 0, j);
        nspCounts = arrayOfInt;
      }
      localObject1 = nspCounts;
      i = depth;
      localObject2 = nspCounts;
      int n = depth + -1;
      j = localObject2[n];
      localObject1[i] = j;
      k = attributeCount;
      i1 = k + -1;
    }
    for (;;)
    {
      if (i1 <= 0) {
        break label391;
      }
      int i2 = 0;
      for (;;)
      {
        if (i2 < i1)
        {
          localObject1 = getAttributeName(i1);
          str1 = getAttributeName(i2);
          bool = ((String)localObject1).equals(str1);
          if (bool)
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            localObject1 = ((StringBuilder)localObject1).append("Duplicate Attribute: ");
            str1 = getAttributeName(i1);
            localObject1 = str1;
            exception((String)localObject1);
          }
          i2 += 1;
          continue;
          bool = false;
          localObject1 = null;
          break;
        }
      }
      i1 += -1;
    }
    label391:
    boolean bool = processNsp;
    if (bool) {
      adjustNsp();
    }
    for (;;)
    {
      localObject1 = elementStack;
      str1 = namespace;
      localObject1[m] = str1;
      localObject1 = elementStack;
      i = m + 1;
      localObject2 = prefix;
      localObject1[i] = localObject2;
      localObject1 = elementStack;
      i = m + 2;
      localObject2 = name;
      localObject1[i] = localObject2;
      return;
      localObject1 = "";
      namespace = ((String)localObject1);
    }
  }
  
  public Object parseWapExtension(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      String str = "illegal id: ";
      localObject2 = str + paramInt;
      exception((String)localObject2);
    }
    for (;;)
    {
      return localObject1;
      localObject1 = readStrI();
      continue;
      localObject1 = new java/lang/Integer;
      int i = readInt();
      ((Integer)localObject1).<init>(i);
      continue;
      int j = readInt();
      localObject1 = new byte[j];
      while (j > 0)
      {
        localObject2 = in;
        int k = localObject1.length - j;
        i = ((InputStream)localObject2).read((byte[])localObject1, k, j);
        j -= i;
      }
    }
  }
  
  public void readAttr()
  {
    int i = 128;
    int j = readByte();
    int k = 0;
    int m = 0;
    for (;;)
    {
      int n = 1;
      if (j == n) {
        break;
      }
      while (j == 0)
      {
        n = readByte();
        selectPage(n, false);
        j = readByte();
      }
      Object localObject = attrStartTable;
      String str1 = resolveId((String[])localObject, j);
      int i2 = str1.indexOf('=');
      n = -1;
      StringBuffer localStringBuffer;
      if (i2 == n)
      {
        localStringBuffer = new java/lang/StringBuffer;
        localStringBuffer.<init>();
        j = readByte();
        label97:
        if ((j <= i) && (j != 0))
        {
          n = 2;
          if (j != n)
          {
            n = 3;
            if (j != n)
            {
              n = 131;
              if (j != n)
              {
                n = 64;
                if (j >= n)
                {
                  n = 66;
                  if (j <= n) {}
                }
                else
                {
                  if (j < i) {
                    break label462;
                  }
                  n = 130;
                  if (j > n) {
                    break label462;
                  }
                }
              }
            }
          }
        }
        switch (j)
        {
        default: 
          localObject = attrValueTable;
          localObject = resolveId((String[])localObject, j);
          localStringBuffer.append((String)localObject);
        }
      }
      for (;;)
      {
        j = readByte();
        break label97;
        localStringBuffer = new java/lang/StringBuffer;
        n = i2 + 1;
        localObject = str1.substring(n);
        localStringBuffer.<init>((String)localObject);
        str1 = str1.substring(0, i2);
        break;
        n = readByte();
        selectPage(n, false);
        continue;
        n = (char)readInt();
        localStringBuffer.append(n);
        continue;
        localObject = readStrI();
        localStringBuffer.append((String)localObject);
        continue;
        localObject = parseWapExtension(j);
        localObject = resolveWapExtension(j, localObject);
        localStringBuffer.append((String)localObject);
        continue;
        localObject = readStrT();
        localStringBuffer.append((String)localObject);
      }
      label462:
      localObject = attributes;
      int i3 = m + 4;
      localObject = ensureCapacity((String[])localObject, i3);
      attributes = ((String[])localObject);
      localObject = attributes;
      k = m + 1;
      localObject[m] = "";
      localObject = attributes;
      m = k + 1;
      i3 = 0;
      localObject[k] = null;
      localObject = attributes;
      k = m + 1;
      localObject[m] = str1;
      localObject = attributes;
      m = k + 1;
      String str2 = localStringBuffer.toString();
      localObject[k] = str2;
      int i1 = attributeCount + 1;
      attributeCount = i1;
    }
  }
  
  int readByte()
  {
    Object localObject = in;
    int i = ((InputStream)localObject).read();
    int j = -1;
    if (i == j)
    {
      localObject = new java/io/IOException;
      ((IOException)localObject).<init>("Unexpected EOF");
      throw ((Throwable)localObject);
    }
    return i;
  }
  
  int readInt()
  {
    int i = 0;
    int k;
    do
    {
      int j = readByte();
      k = i << 7;
      int m = j & 0x7F;
      i = k | m;
      k = j & 0x80;
    } while (k != 0);
    return i;
  }
  
  String readStrI()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
    localByteArrayOutputStream.<init>();
    boolean bool = true;
    for (;;)
    {
      Object localObject = in;
      int i = ((InputStream)localObject).read();
      if (i == 0)
      {
        isWhitespace = bool;
        String str1 = new java/lang/String;
        localObject = localByteArrayOutputStream.toByteArray();
        String str2 = encoding;
        str1.<init>((byte[])localObject, str2);
        localByteArrayOutputStream.close();
        return str1;
      }
      int j = -1;
      if (i == j)
      {
        localObject = new java/io/IOException;
        ((IOException)localObject).<init>("Unexpected EOF");
        throw ((Throwable)localObject);
      }
      j = 32;
      if (i > j) {
        bool = false;
      }
      localByteArrayOutputStream.write(i);
    }
  }
  
  String readStrT()
  {
    int i = readInt();
    Object localObject = cacheStringTable;
    if (localObject == null)
    {
      localObject = new java/util/Hashtable;
      ((Hashtable)localObject).<init>();
      cacheStringTable = ((Hashtable)localObject);
    }
    localObject = cacheStringTable;
    Integer localInteger = new java/lang/Integer;
    localInteger.<init>(i);
    String str1 = (String)((Hashtable)localObject).get(localInteger);
    if (str1 == null)
    {
      int j = i;
      for (;;)
      {
        localObject = stringTable;
        int k = localObject.length;
        if (j >= k) {
          break;
        }
        localObject = stringTable;
        k = localObject[j];
        if (k == 0) {
          break;
        }
        j += 1;
      }
      str1 = new java/lang/String;
      localObject = stringTable;
      int m = j - i;
      String str2 = encoding;
      str1.<init>((byte[])localObject, i, m, str2);
      localObject = cacheStringTable;
      localInteger = new java/lang/Integer;
      localInteger.<init>(i);
      ((Hashtable)localObject).put(localInteger, str1);
    }
    return str1;
  }
  
  public void require(int paramInt, String paramString1, String paramString2)
  {
    int i = type;
    if (paramInt == i)
    {
      boolean bool;
      if (paramString1 != null)
      {
        localObject = getNamespace();
        bool = paramString1.equals(localObject);
        if (!bool) {}
      }
      else
      {
        if (paramString2 == null) {
          break label111;
        }
        localObject = getName();
        bool = paramString2.equals(localObject);
        if (bool) {
          break label111;
        }
      }
    }
    Object localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    StringBuilder localStringBuilder = ((StringBuilder)localObject).append("expected: ");
    int j = 64;
    if (paramInt == j) {}
    label111:
    String str;
    for (localObject = "WAP Ext.";; localObject = str + paramString2)
    {
      localObject = (String)localObject;
      exception((String)localObject);
      return;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      str = TYPES[paramInt];
      localObject = ((StringBuilder)localObject).append(str).append(" {").append(paramString1);
      str = "}";
    }
  }
  
  String resolveId(String[] paramArrayOfString, int paramInt)
  {
    int i = -1;
    int j = paramInt & 0x7F;
    int k = j + -5;
    if (k == i) {
      wapCode = i;
    }
    for (Object localObject1 = readStrT();; localObject1 = paramArrayOfString[k])
    {
      return (String)localObject1;
      if ((k >= 0) && (paramArrayOfString != null))
      {
        j = paramArrayOfString.length;
        if (k < j)
        {
          localObject1 = paramArrayOfString[k];
          if (localObject1 != null) {
            break label114;
          }
        }
      }
      localObject1 = new java/io/IOException;
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = "id " + paramInt + " undef.";
      ((IOException)localObject1).<init>((String)localObject2);
      throw ((Throwable)localObject1);
      label114:
      j = k + 5;
      wapCode = j;
    }
  }
  
  protected String resolveWapExtension(int paramInt, Object paramObject)
  {
    boolean bool = paramObject instanceof byte[];
    StringBuffer localStringBuffer;
    if (bool)
    {
      localStringBuffer = new java/lang/StringBuffer;
      localStringBuffer.<init>();
      paramObject = (byte[])paramObject;
      Object localObject1 = paramObject;
      localObject1 = (byte[])paramObject;
      int j = 0;
      for (;;)
      {
        int i = localObject1.length;
        if (j >= i) {
          break;
        }
        int m = localObject1[j] >> 4 & 0xF;
        i = "0123456789abcdef".charAt(m);
        localStringBuffer.append(i);
        localObject2 = "0123456789abcdef";
        m = localObject1[j] & 0xF;
        char c = ((String)localObject2).charAt(m);
        localStringBuffer.append(c);
        int k;
        j += 1;
      }
    }
    String str;
    for (Object localObject2 = localStringBuffer.toString();; localObject2 = str)
    {
      return (String)localObject2;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = ((StringBuilder)localObject2).append("$(").append(paramObject);
      str = ")";
    }
  }
  
  public void setAttrStartTable(int paramInt, String[] paramArrayOfString)
  {
    int i = ATTR_START_TABLE;
    setTable(paramInt, i, paramArrayOfString);
  }
  
  public void setAttrValueTable(int paramInt, String[] paramArrayOfString)
  {
    int i = ATTR_VALUE_TABLE;
    setTable(paramInt, i, paramArrayOfString);
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    Object localObject = "http://xmlpull.org/v1/doc/features.html#process-namespaces";
    boolean bool = ((String)localObject).equals(paramString);
    if (bool) {
      processNsp = paramBoolean;
    }
    for (;;)
    {
      return;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      String str = "unsupported feature: ";
      localObject = str + paramString;
      exception((String)localObject);
    }
  }
  
  public void setInput(InputStream paramInputStream, String paramString)
  {
    in = paramInputStream;
    int i;
    Object localObject2;
    try
    {
      i = readByte();
      version = i;
      i = readInt();
      publicIdentifierId = i;
      i = publicIdentifierId;
      if (i == 0) {
        readInt();
      }
      int j = readInt();
      if (paramString != null) {
        break label261;
      }
      switch (j)
      {
      default: 
        localObject1 = new java/io/UnsupportedEncodingException;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        String str = "";
        localObject2 = ((StringBuilder)localObject2).append(str);
        localObject2 = ((StringBuilder)localObject2).append(j);
        localObject2 = ((StringBuilder)localObject2).toString();
        ((UnsupportedEncodingException)localObject1).<init>((String)localObject2);
        throw ((Throwable)localObject1);
      }
    }
    catch (IOException localIOException)
    {
      localObject1 = "Illegal input format";
      exception((String)localObject1);
    }
    return;
    Object localObject1 = "ISO-8859-1";
    encoding = ((String)localObject1);
    label154:
    int k = readInt();
    localObject1 = new byte[k];
    stringTable = ((byte[])localObject1);
    int m = 0;
    for (;;)
    {
      int n;
      int i2;
      if (m < k)
      {
        localObject1 = stringTable;
        n = k - m;
        i2 = paramInputStream.read((byte[])localObject1, m, n);
        if (i2 > 0) {}
      }
      else
      {
        i = 0;
        localObject1 = null;
        n = 1;
        selectPage(0, n);
        i = 0;
        localObject1 = null;
        int i1 = 0;
        localObject2 = null;
        selectPage(0, false);
        break;
        localObject1 = "UTF-8";
        encoding = ((String)localObject1);
        break label154;
        label261:
        encoding = paramString;
        break label154;
      }
      m += i2;
    }
  }
  
  public void setInput(Reader paramReader)
  {
    exception("InputStream required");
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    XmlPullParserException localXmlPullParserException = new org/xmlpull/v1/XmlPullParserException;
    Object localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    localObject = "unsupported property: " + paramString;
    localXmlPullParserException.<init>((String)localObject);
    throw localXmlPullParserException;
  }
  
  public void setTagTable(int paramInt, String[] paramArrayOfString)
  {
    int i = TAG_TABLE;
    setTable(paramInt, i, paramArrayOfString);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kxml2/wap/WbxmlParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */