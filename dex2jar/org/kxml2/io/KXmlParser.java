package org.kxml2.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Hashtable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KXmlParser
  implements XmlPullParser
{
  private static final String ILLEGAL_TYPE = "Wrong event type";
  private static final int LEGACY = 999;
  private static final String UNEXPECTED_EOF = "Unexpected EOF";
  private static final int XML_DECL = 998;
  private int attributeCount;
  private String[] attributes = new String[16];
  private int column;
  private boolean degenerated;
  private int depth;
  private String[] elementStack = new String[16];
  private String encoding;
  private Hashtable entityMap;
  private String error;
  private boolean isWhitespace;
  private int line;
  private Object location;
  private String name;
  private String namespace;
  private int[] nspCounts = new int[4];
  private String[] nspStack = new String[8];
  private int[] peek = new int[2];
  private int peekCount;
  private String prefix;
  private boolean processNsp;
  private Reader reader;
  private boolean relaxed;
  private char[] srcBuf;
  private int srcCount;
  private int srcPos;
  private Boolean standalone;
  private boolean token;
  private char[] txtBuf = new char[''];
  private int txtPos;
  private int type;
  private boolean unresolved;
  private String version;
  private boolean wasCR;
  
  public KXmlParser()
  {
    if (Runtime.getRuntime().freeMemory() >= 1048576L) {
      i = 8192;
    }
    srcBuf = new char[i];
  }
  
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
            error("illegal empty namespace");
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
        if ((j == 0) && (!relaxed)) {
          throw new RuntimeException("illegal attribute name: " + (String)localObject2 + " at " + this);
        }
        if (j != -1)
        {
          localObject1 = ((String)localObject2).substring(0, j);
          localObject2 = ((String)localObject2).substring(j + 1);
          String str = getNamespace((String)localObject1);
          if ((str == null) && (!relaxed)) {
            throw new RuntimeException("Undefined Prefix: " + (String)localObject1 + " in " + this);
          }
          attributes[i] = str;
          attributes[(i + 1)] = localObject1;
          attributes[(i + 2)] = localObject2;
        }
        i -= 4;
      }
    }
    i = name.indexOf(':');
    if (i == 0) {
      error("illegal tag name: " + name);
    }
    if (i != -1)
    {
      prefix = name.substring(0, i);
      name = name.substring(i + 1);
    }
    namespace = getNamespace(prefix);
    if (namespace == null)
    {
      if (prefix != null) {
        error("undefined prefix: " + prefix);
      }
      namespace = "";
    }
    return bool1;
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
  
  private final void error(String paramString)
    throws XmlPullParserException
  {
    if (relaxed)
    {
      if (error == null) {
        error = ("ERR: " + paramString);
      }
      return;
    }
    exception(paramString);
  }
  
  private final void exception(String paramString)
    throws XmlPullParserException
  {
    if (paramString.length() < 100) {}
    for (;;)
    {
      throw new XmlPullParserException(paramString, this, null);
      paramString = paramString.substring(0, 100) + "\n";
    }
  }
  
  private final String get(int paramInt)
  {
    return new String(txtBuf, paramInt, txtPos - paramInt);
  }
  
  private final boolean isProp(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (!paramString1.startsWith("http://xmlpull.org/v1/doc/")) {
      return false;
    }
    if (paramBoolean) {
      return paramString1.substring(42).equals(paramString2);
    }
    return paramString1.substring(40).equals(paramString2);
  }
  
  private final void nextImpl()
    throws IOException, XmlPullParserException
  {
    boolean bool = false;
    if (reader == null) {
      exception("No Input specified");
    }
    if (type == 3) {
      depth -= 1;
    }
    attributeCount = -1;
    if (degenerated)
    {
      degenerated = false;
      type = 3;
    }
    do
    {
      return;
      if (error != null)
      {
        int i = 0;
        while (i < error.length())
        {
          push(error.charAt(i));
          i += 1;
        }
        error = null;
        type = 9;
        return;
      }
      prefix = null;
      name = null;
      namespace = null;
      type = peekType();
      switch (type)
      {
      case 1: 
      case 5: 
      default: 
        type = parseLegacy(token);
        if (type == 998) {
          break;
        }
        return;
      case 6: 
        pushEntity();
        return;
      case 2: 
        parseStartTag(false);
        return;
      case 3: 
        parseEndTag();
        return;
      case 4: 
        if (!token) {
          bool = true;
        }
        pushText(60, bool);
      }
    } while ((depth != 0) || (!isWhitespace));
    type = 7;
  }
  
  private final void parseDoctype(boolean paramBoolean)
    throws IOException, XmlPullParserException
  {
    int k = 1;
    int j = 0;
    int n = read();
    int m;
    int i;
    switch (n)
    {
    default: 
      m = j;
      i = k;
    }
    do
    {
      do
      {
        for (;;)
        {
          k = i;
          j = m;
          if (!paramBoolean) {
            break;
          }
          push(n);
          k = i;
          j = m;
          break;
          error("Unexpected EOF");
          return;
          if (j == 0) {}
          for (j = 1;; j = 0)
          {
            i = k;
            m = j;
            break;
          }
          i = k;
          m = j;
          if (j == 0)
          {
            i = k + 1;
            m = j;
          }
        }
        i = k;
        m = j;
      } while (j != 0);
      k -= 1;
      i = k;
      m = j;
    } while (k != 0);
  }
  
  private final void parseEndTag()
    throws IOException, XmlPullParserException
  {
    read();
    read();
    name = readName();
    skip();
    read('>');
    int i = depth - 1 << 2;
    if (depth == 0)
    {
      error("element stack empty");
      type = 9;
    }
    while (relaxed) {
      return;
    }
    if (!name.equals(elementStack[(i + 3)])) {
      error("expected: /" + elementStack[(i + 3)] + " read: " + name);
    }
    namespace = elementStack[i];
    prefix = elementStack[(i + 1)];
    name = elementStack[(i + 2)];
  }
  
  private final int parseLegacy(boolean paramBoolean)
    throws IOException, XmlPullParserException
  {
    String str = "";
    int m = 0;
    read();
    int i = read();
    int j;
    int k;
    if (i == 63) {
      if (((peek(0) == 120) || (peek(0) == 88)) && ((peek(1) == 109) || (peek(1) == 77)))
      {
        if (paramBoolean)
        {
          push(peek(0));
          push(peek(1));
        }
        read();
        read();
        if (((peek(0) == 108) || (peek(0) == 76)) && (peek(1) <= 32))
        {
          if ((line != 1) || (column > 4)) {
            error("PI must not start with xml");
          }
          parseStartTag(true);
          if ((attributeCount < 1) || (!"version".equals(attributes[2]))) {
            error("version expected");
          }
          version = attributes[3];
          j = 1;
          i = j;
          if (1 < attributeCount)
          {
            i = j;
            if ("encoding".equals(attributes[6]))
            {
              encoding = attributes[7];
              i = 1 + 1;
            }
          }
          j = i;
          if (i < attributeCount)
          {
            j = i;
            if ("standalone".equals(attributes[(i * 4 + 2)]))
            {
              str = attributes[(i * 4 + 3)];
              if (!"yes".equals(str)) {
                break label341;
              }
              standalone = new Boolean(true);
              j = i + 1;
            }
          }
          if (j != attributeCount) {
            error("illegal xmldecl");
          }
          isWhitespace = true;
          txtPos = 0;
          k = 998;
        }
      }
    }
    label341:
    do
    {
      do
      {
        return k;
        if ("no".equals(str))
        {
          standalone = new Boolean(false);
          break;
        }
        error("illegal standalone value: " + str);
        break;
        j = 63;
        i = 8;
        for (;;)
        {
          k = 0;
          while (k < str.length())
          {
            read(str.charAt(k));
            k += 1;
          }
          if (i != 33) {
            break;
          }
          if (peek(0) == 45)
          {
            i = 9;
            str = "--";
            j = 45;
          }
          else if (peek(0) == 91)
          {
            i = 5;
            str = "[CDATA[";
            j = 93;
            paramBoolean = true;
          }
          else
          {
            i = 10;
            str = "DOCTYPE";
            j = -1;
          }
        }
        error("illegal: <" + i);
        return 9;
        k = m;
        if (i == 10)
        {
          parseDoctype(paramBoolean);
          return i;
        }
        do
        {
          k = m;
          m = read();
          if (m == -1)
          {
            error("Unexpected EOF");
            return 9;
          }
          if (paramBoolean) {
            push(m);
          }
        } while (((j != 63) && (m != j)) || (peek(0) != j) || (peek(1) != 62));
        if ((j == 45) && (k == 45) && (!relaxed)) {
          error("illegal comment delimiter: --->");
        }
        read();
        read();
        k = i;
      } while (!paramBoolean);
      k = i;
    } while (j == 63);
    txtPos -= 1;
    return i;
  }
  
  private final void parseStartTag(boolean paramBoolean)
    throws IOException, XmlPullParserException
  {
    if (!paramBoolean) {
      read();
    }
    name = readName();
    attributeCount = 0;
    skip();
    int i = peek(0);
    label80:
    Object localObject;
    if (paramBoolean)
    {
      if (i == 63)
      {
        read();
        read('>');
      }
    }
    else if (i == 47)
    {
      degenerated = true;
      read();
      skip();
      read('>');
      i = depth;
      depth = (i + 1);
      i <<= 2;
      elementStack = ensureCapacity(elementStack, i + 4);
      elementStack[(i + 3)] = name;
      if (depth >= nspCounts.length)
      {
        localObject = new int[depth + 4];
        System.arraycopy(nspCounts, 0, localObject, 0, nspCounts.length);
        nspCounts = ((int[])localObject);
      }
      nspCounts[depth] = nspCounts[(depth - 1)];
      if (!processNsp) {
        break label523;
      }
      adjustNsp();
    }
    for (;;)
    {
      elementStack[i] = namespace;
      elementStack[(i + 1)] = prefix;
      elementStack[(i + 2)] = name;
      return;
      if ((i == 62) && (!paramBoolean))
      {
        read();
        break label80;
      }
      if (i == -1)
      {
        error("Unexpected EOF");
        return;
      }
      localObject = readName();
      if (((String)localObject).length() == 0)
      {
        error("attr name expected");
        break label80;
      }
      i = attributeCount;
      attributeCount = (i + 1);
      int j = i << 2;
      attributes = ensureCapacity(attributes, j + 4);
      String[] arrayOfString = attributes;
      i = j + 1;
      arrayOfString[j] = "";
      arrayOfString = attributes;
      int k = i + 1;
      arrayOfString[i] = null;
      arrayOfString = attributes;
      j = k + 1;
      arrayOfString[k] = localObject;
      skip();
      if (peek(0) != 61)
      {
        if (!relaxed) {
          error("Attr.value missing f. " + (String)localObject);
        }
        attributes[j] = localObject;
        break;
      }
      read('=');
      skip();
      i = peek(0);
      if ((i != 39) && (i != 34))
      {
        if (!relaxed) {
          error("attr value delimiter missing!");
        }
        i = 32;
      }
      for (;;)
      {
        k = txtPos;
        pushText(i, true);
        attributes[j] = get(k);
        txtPos = k;
        if (i == 32) {
          break;
        }
        read();
        break;
        read();
      }
      label523:
      namespace = "";
    }
  }
  
  private final int peek(int paramInt)
    throws IOException
  {
    if (paramInt >= peekCount)
    {
      int i;
      if (srcBuf.length <= 1) {
        i = reader.read();
      }
      Object localObject;
      for (;;)
      {
        if (i == 13)
        {
          wasCR = true;
          localObject = peek;
          i = peekCount;
          peekCount = (i + 1);
          localObject[i] = 10;
          break;
          if (srcPos < srcCount)
          {
            localObject = srcBuf;
            i = srcPos;
            srcPos = (i + 1);
            i = localObject[i];
          }
          else
          {
            srcCount = reader.read(srcBuf, 0, srcBuf.length);
            if (srcCount <= 0) {}
            for (i = -1;; i = srcBuf[0])
            {
              srcPos = 1;
              break;
            }
          }
        }
      }
      if (i == 10) {
        if (!wasCR)
        {
          localObject = peek;
          i = peekCount;
          peekCount = (i + 1);
          localObject[i] = 10;
        }
      }
      for (;;)
      {
        wasCR = false;
        break;
        localObject = peek;
        int j = peekCount;
        peekCount = (j + 1);
        localObject[j] = i;
      }
    }
    return peek[paramInt];
  }
  
  private final int peekType()
    throws IOException
  {
    int i = 1;
    switch (peek(0))
    {
    default: 
      i = 4;
    case -1: 
      return i;
    case 38: 
      return 6;
    }
    switch (peek(1))
    {
    default: 
      return 2;
    case 47: 
      return 3;
    }
    return 999;
  }
  
  private final void push(int paramInt)
  {
    boolean bool2 = isWhitespace;
    if (paramInt <= 32) {}
    int i;
    for (boolean bool1 = true;; i = 0)
    {
      isWhitespace = (bool1 & bool2);
      if (txtPos == txtBuf.length)
      {
        arrayOfChar = new char[txtPos * 4 / 3 + 4];
        System.arraycopy(txtBuf, 0, arrayOfChar, 0, txtPos);
        txtBuf = arrayOfChar;
      }
      char[] arrayOfChar = txtBuf;
      i = txtPos;
      txtPos = (i + 1);
      arrayOfChar[i] = ((char)paramInt);
      return;
    }
  }
  
  private final void pushEntity()
    throws IOException, XmlPullParserException
  {
    boolean bool = true;
    push(read());
    int i = txtPos;
    int j = peek(0);
    String str1;
    if (j == 59)
    {
      read();
      str1 = get(i);
      txtPos = (i - 1);
      if ((token) && (type == 6)) {
        name = str1;
      }
      if (str1.charAt(0) != '#') {
        break label240;
      }
      if (str1.charAt(1) != 'x') {
        break label227;
      }
      i = Integer.parseInt(str1.substring(2), 16);
      label102:
      push(i);
    }
    for (;;)
    {
      return;
      if ((j < 128) && ((j < 48) || (j > 57)) && ((j < 97) || (j > 122)) && ((j < 65) || (j > 90)) && (j != 95) && (j != 45) && (j != 35))
      {
        if (!relaxed) {
          error("unterminated entity ref");
        }
        System.out.println("broken entitiy: " + get(i - 1));
        return;
      }
      push(read());
      break;
      label227:
      i = Integer.parseInt(str1.substring(1));
      break label102;
      label240:
      String str2 = (String)entityMap.get(str1);
      if (str2 == null) {}
      for (;;)
      {
        unresolved = bool;
        if (!unresolved) {
          break label315;
        }
        if (token) {
          break;
        }
        error("unresolved: &" + str1 + ";");
        return;
        bool = false;
      }
      label315:
      i = 0;
      while (i < str2.length())
      {
        push(str2.charAt(i));
        i += 1;
      }
    }
  }
  
  private final void pushText(int paramInt, boolean paramBoolean)
    throws IOException, XmlPullParserException
  {
    int j = peek(0);
    int i = 0;
    if ((j == -1) || (j == paramInt) || ((paramInt == 32) && ((j <= 32) || (j == 62)))) {}
    do
    {
      return;
      if (j != 38) {
        break;
      }
    } while (!paramBoolean);
    pushEntity();
    label57:
    if ((j == 62) && (i >= 2) && (paramInt != 93)) {
      error("Illegal: ]]>");
    }
    if (j == 93) {
      i += 1;
    }
    for (;;)
    {
      j = peek(0);
      break;
      if ((j == 10) && (type == 2))
      {
        read();
        push(32);
        break label57;
      }
      push(read());
      break label57;
      i = 0;
    }
  }
  
  private final int read()
    throws IOException
  {
    int i;
    if (peekCount == 0) {
      i = peek(0);
    }
    for (;;)
    {
      peekCount -= 1;
      column += 1;
      if (i == 10)
      {
        line += 1;
        column = 1;
      }
      return i;
      i = peek[0];
      peek[0] = peek[1];
    }
  }
  
  private final void read(char paramChar)
    throws IOException, XmlPullParserException
  {
    char c = read();
    if (c != paramChar) {
      error("expected: '" + paramChar + "' actual: '" + (char)c + "'");
    }
  }
  
  private final String readName()
    throws IOException, XmlPullParserException
  {
    int i = txtPos;
    int j = peek(0);
    if (((j < 97) || (j > 122)) && ((j < 65) || (j > 90)) && (j != 95) && (j != 58) && (j < 192) && (!relaxed)) {
      error("name expected");
    }
    do
    {
      push(read());
      j = peek(0);
    } while (((j >= 97) && (j <= 122)) || ((j >= 65) && (j <= 90)) || ((j >= 48) && (j <= 57)) || (j == 95) || (j == 45) || (j == 58) || (j == 46) || (j >= 183));
    String str = get(i);
    txtPos = i;
    return str;
  }
  
  private final void skip()
    throws IOException
  {
    for (;;)
    {
      int i = peek(0);
      if ((i > 32) || (i == -1)) {
        return;
      }
      read();
    }
  }
  
  public void defineEntityReplacementText(String paramString1, String paramString2)
    throws XmlPullParserException
  {
    if (entityMap == null) {
      throw new RuntimeException("entity replacement text must be defined after setInput!");
    }
    entityMap.put(paramString1, paramString2);
  }
  
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
    return column;
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
    boolean bool = false;
    if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(paramString)) {
      bool = processNsp;
    }
    while (!isProp(paramString, false, "relaxed")) {
      return bool;
    }
    return relaxed;
  }
  
  public String getInputEncoding()
  {
    return encoding;
  }
  
  public int getLineNumber()
  {
    return line;
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
        break label391;
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
    localStringBuffer.append("@" + line + ":" + column);
    if (location != null)
    {
      localStringBuffer.append(" in ");
      localStringBuffer.append(location);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      label391:
      if (type == 7) {
        break;
      }
      if (type != 4)
      {
        localStringBuffer.append(getText());
        break;
      }
      if (isWhitespace)
      {
        localStringBuffer.append("(whitespace)");
        break;
      }
      String str = getText();
      localObject = str;
      if (str.length() > 16) {
        localObject = str.substring(0, 16) + "...";
      }
      localStringBuffer.append((String)localObject);
      break;
      if (reader != null)
      {
        localStringBuffer.append(" in ");
        localStringBuffer.append(reader.toString());
      }
    }
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public Object getProperty(String paramString)
  {
    if (isProp(paramString, true, "xmldecl-version")) {
      return version;
    }
    if (isProp(paramString, true, "xmldecl-standalone")) {
      return standalone;
    }
    if (isProp(paramString, true, "location"))
    {
      if (location != null) {
        return location;
      }
      return reader.toString();
    }
    return null;
  }
  
  public String getText()
  {
    if ((type < 4) || ((type == 6) && (unresolved))) {
      return null;
    }
    return get(0);
  }
  
  public char[] getTextCharacters(int[] paramArrayOfInt)
  {
    if (type >= 4)
    {
      if (type == 6)
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = name.length();
        return name.toCharArray();
      }
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = txtPos;
      return txtBuf;
    }
    paramArrayOfInt[0] = -1;
    paramArrayOfInt[1] = -1;
    return null;
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
    txtPos = 0;
    isWhitespace = true;
    int i = 9999;
    token = false;
    int j;
    do
    {
      do
      {
        nextImpl();
        j = i;
        if (type < i) {
          j = type;
        }
        i = j;
      } while (j > 6);
      if (j < 4) {
        break;
      }
      i = j;
    } while (peekType() >= 4);
    type = j;
    if (type > 4) {
      type = 4;
    }
    return type;
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
    txtPos = 0;
    token = true;
    nextImpl();
    return type;
  }
  
  public void require(int paramInt, String paramString1, String paramString2)
    throws XmlPullParserException, IOException
  {
    if ((paramInt != type) || ((paramString1 != null) && (!paramString1.equals(getNamespace()))) || ((paramString2 != null) && (!paramString2.equals(getName())))) {
      exception("expected: " + TYPES[paramInt] + " {" + paramString1 + "}" + paramString2);
    }
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
    throws XmlPullParserException
  {
    if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(paramString))
    {
      processNsp = paramBoolean;
      return;
    }
    if (isProp(paramString, false, "relaxed"))
    {
      relaxed = paramBoolean;
      return;
    }
    exception("unsupported feature: " + paramString);
  }
  
  public void setInput(InputStream paramInputStream, String paramString)
    throws XmlPullParserException
  {
    srcPos = 0;
    srcCount = 0;
    Object localObject2 = paramString;
    if (paramInputStream == null) {
      throw new IllegalArgumentException();
    }
    Object localObject1 = localObject2;
    int i;
    if (localObject2 == null) {
      i = 0;
    }
    for (;;)
    {
      int k;
      try
      {
        if (srcCount < 4)
        {
          j = paramInputStream.read();
          if (j != -1) {}
        }
        else
        {
          localObject1 = localObject2;
          if (srcCount != 4) {
            break label656;
          }
        }
        switch (i)
        {
        case 65279: 
          if ((0xFFFF0000 & i) != -16842752) {
            break label566;
          }
          localObject1 = "UTF-16BE";
          srcBuf[0] = ((char)(srcBuf[2] << '\b' | srcBuf[3]));
          srcCount = 1;
          break label656;
          i = srcCount;
          setInput(new InputStreamReader(paramInputStream, (String)localObject2));
          encoding = paramString;
          srcCount = i;
          return;
          i = i << 8 | j;
          localObject1 = srcBuf;
          k = srcCount;
          srcCount = (k + 1);
          localObject1[k] = ((char)j);
          continue;
          localObject1 = "UTF-32BE";
        }
      }
      catch (Exception paramInputStream)
      {
        throw new XmlPullParserException("Invalid stream or encoding: " + paramInputStream.toString(), this, paramInputStream);
      }
      srcCount = 0;
      break label656;
      localObject1 = "UTF-32LE";
      srcCount = 0;
      break label656;
      localObject1 = "UTF-32BE";
      srcBuf[0] = '<';
      srcCount = 1;
      break label656;
      localObject1 = "UTF-32LE";
      srcBuf[0] = '<';
      srcCount = 1;
      break label656;
      localObject1 = "UTF-16BE";
      srcBuf[0] = '<';
      srcBuf[1] = '?';
      srcCount = 2;
      break label656;
      localObject1 = "UTF-16LE";
      srcBuf[0] = '<';
      srcBuf[1] = '?';
      srcCount = 2;
      break label656;
      do
      {
        j = paramInputStream.read();
        localObject1 = localObject2;
        if (j == -1) {
          break;
        }
        localObject1 = srcBuf;
        k = srcCount;
        srcCount = (k + 1);
        localObject1[k] = ((char)j);
      } while (j != 62);
      String str = new String(srcBuf, 0, srcCount);
      int j = str.indexOf("encoding");
      localObject1 = localObject2;
      if (j != -1)
      {
        while ((str.charAt(j) != '"') && (str.charAt(j) != '\'')) {
          j += 1;
        }
        k = j + 1;
        localObject1 = str.substring(k, str.indexOf(str.charAt(j), k));
        continue;
        label566:
        if ((0xFFFF0000 & i) == -131072)
        {
          localObject1 = "UTF-16LE";
          srcBuf[0] = ((char)(srcBuf[3] << '\b' | srcBuf[2]));
          srcCount = 1;
        }
        else if ((i & 0xFF00) == -272908544)
        {
          localObject1 = "UTF-8";
          srcBuf[0] = srcBuf[3];
          srcCount = 1;
          break label656;
          localObject1 = localObject2;
          continue;
        }
        label656:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "UTF-8";
        }
      }
    }
  }
  
  public void setInput(Reader paramReader)
    throws XmlPullParserException
  {
    reader = paramReader;
    line = 1;
    column = 0;
    type = 0;
    name = null;
    namespace = null;
    degenerated = false;
    attributeCount = -1;
    encoding = null;
    version = null;
    standalone = null;
    if (paramReader == null) {
      return;
    }
    srcPos = 0;
    srcCount = 0;
    peekCount = 0;
    depth = 0;
    entityMap = new Hashtable();
    entityMap.put("amp", "&");
    entityMap.put("apos", "'");
    entityMap.put("gt", ">");
    entityMap.put("lt", "<");
    entityMap.put("quot", "\"");
  }
  
  public void setProperty(String paramString, Object paramObject)
    throws XmlPullParserException
  {
    if (isProp(paramString, true, "location"))
    {
      location = paramObject;
      return;
    }
    throw new XmlPullParserException("unsupported property: " + paramString);
  }
  
  public void skipSubTree()
    throws XmlPullParserException, IOException
  {
    require(2, null, null);
    int i = 1;
    while (i > 0)
    {
      int j = next();
      if (j == 3) {
        i -= 1;
      } else if (j == 2) {
        i += 1;
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kxml2/io/KXmlParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */