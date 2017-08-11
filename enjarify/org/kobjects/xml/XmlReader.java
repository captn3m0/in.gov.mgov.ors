package org.kobjects.xml;

import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;

public class XmlReader
{
  static final int CDSECT = 5;
  public static final int END_DOCUMENT = 1;
  public static final int END_TAG = 3;
  static final int ENTITY_REF = 6;
  private static final int LEGACY = 999;
  public static final int START_DOCUMENT = 0;
  public static final int START_TAG = 2;
  public static final int TEXT = 4;
  private static final String UNEXPECTED_EOF = "Unexpected EOF";
  private String[] TYPES;
  private int attributeCount;
  private String[] attributes;
  private int column;
  private boolean degenerated;
  private int depth;
  private String[] elementStack;
  private Hashtable entityMap;
  private boolean eof;
  private boolean isWhitespace;
  private int line;
  private String name;
  private int peek0;
  private int peek1;
  private Reader reader;
  public boolean relaxed;
  private char[] srcBuf;
  private int srcCount;
  private int srcPos;
  private String text;
  private char[] txtBuf;
  private int txtPos;
  private int type;
  
  public XmlReader(Reader paramReader)
  {
    Object localObject = new String[j];
    elementStack = ((String[])localObject);
    localObject = Runtime.getRuntime();
    long l1 = ((Runtime)localObject).freeMemory();
    long l2 = 1048576L;
    boolean bool = l1 < l2;
    int m;
    if (!bool)
    {
      m = 8192;
      localObject = new char[m];
      srcBuf = ((char[])localObject);
      localObject = new char[i];
      txtBuf = ((char[])localObject);
      localObject = new String[16];
      attributes = ((String[])localObject);
      localObject = new String[5];
      localObject[0] = "Start Document";
      localObject[k] = "End Document";
      localObject[2] = "Start Tag";
      String str1 = "End Tag";
      localObject[3] = str1;
      String str2 = "Text";
      localObject[j] = str2;
      TYPES = ((String[])localObject);
      reader = paramReader;
      m = paramReader.read();
      peek0 = m;
      m = paramReader.read();
      peek1 = m;
      m = peek0;
      i = -1;
      if (m != i) {
        break label294;
      }
      m = k;
    }
    for (;;)
    {
      eof = m;
      localObject = new java/util/Hashtable;
      ((Hashtable)localObject).<init>();
      entityMap = ((Hashtable)localObject);
      entityMap.put("amp", "&");
      entityMap.put("apos", "'");
      entityMap.put("gt", ">");
      entityMap.put("lt", "<");
      entityMap.put("quot", "\"");
      line = k;
      column = k;
      return;
      m = i;
      break;
      label294:
      m = 0;
      localObject = null;
    }
  }
  
  private static final String[] ensureCapacity(String[] paramArrayOfString, int paramInt)
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
    IOException localIOException = new java/io/IOException;
    Object localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    localObject = ((StringBuilder)localObject).append(paramString).append(" pos: ");
    String str = getPositionDescription();
    localObject = str;
    localIOException.<init>((String)localObject);
    throw localIOException;
  }
  
  private final void parseDoctype()
  {
    int i = 1;
    do
    {
      for (;;)
      {
        int j = read();
        switch (j)
        {
        default: 
          break;
        case -1: 
          String str = "Unexpected EOF";
          exception(str);
        case 60: 
          i += 1;
        }
      }
      i += -1;
    } while (i != 0);
  }
  
  private final void parseEndTag()
  {
    read();
    read();
    Object localObject1 = readName();
    name = ((String)localObject1);
    int i = depth;
    if (i == 0)
    {
      bool1 = relaxed;
      if (!bool1)
      {
        localObject1 = "element stack empty";
        exception((String)localObject1);
      }
    }
    localObject1 = name;
    Object localObject2 = elementStack;
    int k = depth + -1;
    localObject2 = localObject2[k];
    boolean bool1 = ((String)localObject1).equals(localObject2);
    if (bool1)
    {
      int j = depth + -1;
      depth = j;
    }
    for (;;)
    {
      skip();
      read('>');
      return;
      boolean bool2 = relaxed;
      if (!bool2)
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localObject1 = ((StringBuilder)localObject1).append("expected: ");
        localObject2 = elementStack;
        k = depth;
        localObject2 = localObject2[k];
        localObject1 = (String)localObject2;
        exception((String)localObject1);
      }
    }
  }
  
  private final void parseLegacy(boolean paramBoolean)
  {
    int i = 63;
    String str1 = "";
    read();
    int j = read();
    int k;
    if (j == i) {
      k = 63;
    }
    int i3;
    Object localObject;
    for (;;)
    {
      int m = 0;
      for (;;)
      {
        int n = str1.length();
        if (m >= n) {
          break;
        }
        n = str1.charAt(m);
        read(n);
        m += 1;
      }
      i1 = 33;
      if (j == i1)
      {
        i1 = peek0;
        i3 = 45;
        if (i1 == i3)
        {
          str1 = "--";
          k = 45;
        }
        else
        {
          str1 = "DOCTYPE";
          k = -1;
        }
      }
      else
      {
        i1 = 91;
        if (j != i1)
        {
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          String str2 = "cantreachme: ";
          localObject = str2 + j;
          exception((String)localObject);
        }
        str1 = "CDATA[";
        k = 93;
      }
    }
    int i1 = -1;
    if (k == i1) {
      parseDoctype();
    }
    for (;;)
    {
      return;
      int i2;
      do
      {
        do
        {
          do
          {
            boolean bool = eof;
            if (bool)
            {
              localObject = "Unexpected EOF";
              exception((String)localObject);
            }
            j = read();
            if (paramBoolean) {
              push(j);
            }
          } while ((k != i) && (j != k));
          i2 = peek0;
        } while (i2 != k);
        i2 = peek1;
        i3 = 62;
      } while (i2 != i3);
      read();
      read();
      if ((paramBoolean) && (k != i))
      {
        i2 = txtPos + -1;
        pop(i2);
      }
    }
  }
  
  private final void parseStartTag()
  {
    int i = 62;
    read();
    Object localObject = readName();
    name = ((String)localObject);
    localObject = elementStack;
    int j = depth + 1;
    localObject = ensureCapacity((String[])localObject, j);
    elementStack = ((String[])localObject);
    localObject = elementStack;
    j = depth;
    int m = j + 1;
    depth = m;
    String str1 = name;
    localObject[j] = str1;
    for (;;)
    {
      skip();
      int n = peek0;
      int i1 = 47;
      if (n == i1)
      {
        i2 = 1;
        degenerated = i2;
        read();
        skip();
        read(i);
      }
      for (;;)
      {
        return;
        if (n != i) {
          break;
        }
        read();
      }
      int i2 = -1;
      if (n == i2)
      {
        localObject = "Unexpected EOF";
        exception((String)localObject);
      }
      String str2 = readName();
      int i3 = str2.length();
      if (i3 == 0)
      {
        localObject = "attr name expected";
        exception((String)localObject);
      }
      skip();
      read('=');
      skip();
      int i5 = read();
      i3 = 39;
      if (i5 != i3)
      {
        i3 = 34;
        if (i5 != i3)
        {
          boolean bool = relaxed;
          if (!bool)
          {
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            localObject = ((StringBuilder)localObject).append("<");
            str3 = name;
            localObject = ((StringBuilder)localObject).append(str3);
            str3 = ">: invalid delimiter: ";
            localObject = ((StringBuilder)localObject).append(str3);
            j = (char)i5;
            localObject = j;
            exception((String)localObject);
          }
          i5 = 32;
        }
      }
      int i4 = attributeCount;
      int k = i4 + 1;
      attributeCount = k;
      int i6 = i4 << 1;
      localObject = attributes;
      k = i6 + 4;
      localObject = ensureCapacity((String[])localObject, k);
      attributes = ((String[])localObject);
      localObject = attributes;
      int i7 = i6 + 1;
      localObject[i6] = str2;
      int i8 = txtPos;
      pushText(i5);
      localObject = attributes;
      String str3 = pop(i8);
      localObject[i7] = str3;
      i4 = 32;
      if (i5 != i4) {
        read();
      }
    }
  }
  
  private final int peekType()
  {
    int i = peek0;
    switch (i)
    {
    default: 
      i = 4;
    }
    for (;;)
    {
      return i;
      i = 1;
      continue;
      i = 6;
      continue;
      i = peek1;
      switch (i)
      {
      default: 
        i = 2;
        break;
      case 47: 
        i = 3;
        break;
      case 91: 
        i = 5;
        break;
      case 33: 
      case 63: 
        i = 999;
      }
    }
  }
  
  private final String pop(int paramInt)
  {
    String str = new java/lang/String;
    char[] arrayOfChar = txtBuf;
    int i = txtPos - paramInt;
    str.<init>(arrayOfChar, paramInt, i);
    txtPos = paramInt;
    return str;
  }
  
  private final void push(int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      int j = txtPos;
      char[] arrayOfChar1 = txtBuf;
      int k = arrayOfChar1.length;
      if (j == k)
      {
        j = txtPos * 4 / 3 + 4;
        char[] arrayOfChar2 = new char[j];
        arrayOfChar3 = txtBuf;
        k = txtPos;
        System.arraycopy(arrayOfChar3, 0, arrayOfChar2, 0, k);
        txtBuf = arrayOfChar2;
      }
      char[] arrayOfChar3 = txtBuf;
      k = txtPos;
      i = k + 1;
      txtPos = i;
      i = (char)paramInt;
      arrayOfChar3[k] = i;
    }
  }
  
  private final boolean pushText(int paramInt)
  {
    int i = 32;
    boolean bool1 = true;
    int j = peek0;
    boolean bool2 = eof;
    if ((!bool2) && (j != paramInt))
    {
      if (paramInt != i) {
        break label52;
      }
      if (j > i)
      {
        k = 62;
        if (j != k) {
          break label52;
        }
      }
    }
    return bool1;
    label52:
    int k = 38;
    if (j == k)
    {
      boolean bool3 = pushEntity();
      if (!bool3) {
        bool1 = false;
      }
    }
    for (;;)
    {
      j = peek0;
      break;
      if (j > i) {
        bool1 = false;
      }
      int m = read();
      push(m);
    }
  }
  
  private final int read()
  {
    int i = 13;
    int j = 10;
    int k = -1;
    int m = peek0;
    int n = peek1;
    peek0 = n;
    n = peek0;
    if (n == k)
    {
      n = 1;
      eof = n;
    }
    for (;;)
    {
      return m;
      if ((m == j) || (m == i))
      {
        n = line + 1;
        line = n;
        column = 0;
        if (m == i)
        {
          n = peek0;
          if (n == j) {
            peek0 = 0;
          }
        }
      }
      n = column + 1;
      column = n;
      n = srcPos;
      j = srcCount;
      Object localObject;
      if (n >= j)
      {
        localObject = reader;
        char[] arrayOfChar1 = srcBuf;
        char[] arrayOfChar2 = srcBuf;
        i = arrayOfChar2.length;
        n = ((Reader)localObject).read(arrayOfChar1, 0, i);
        srcCount = n;
        n = srcCount;
        if (n <= 0) {
          peek1 = k;
        } else {
          srcPos = 0;
        }
      }
      else
      {
        localObject = srcBuf;
        j = srcPos;
        i = j + 1;
        srcPos = i;
        n = localObject[j];
        peek1 = n;
      }
    }
  }
  
  private final void read(char paramChar)
  {
    char c1 = read();
    if (c1 != paramChar)
    {
      boolean bool = relaxed;
      if (!bool) {
        break label37;
      }
      char c2 = ' ';
      if (paramChar <= c2)
      {
        skip();
        read();
      }
    }
    for (;;)
    {
      return;
      label37:
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = ((StringBuilder)localObject).append("expected: '").append(paramChar);
      String str = "'";
      localObject = str;
      exception((String)localObject);
    }
  }
  
  private final String readName()
  {
    int i = 97;
    int j = 95;
    int k = 90;
    int m = 65;
    int n = 58;
    int i1 = txtPos;
    int i2 = peek0;
    if (i2 >= i)
    {
      int i3 = 122;
      if (i2 <= i3) {}
    }
    else if (((i2 < m) || (i2 > k)) && (i2 != j) && (i2 != n))
    {
      boolean bool = relaxed;
      if (!bool)
      {
        String str = "name expected";
        exception(str);
      }
    }
    int i4;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                i4 = read();
                push(i4);
                i2 = peek0;
                if (i2 < i) {
                  break;
                }
                i4 = 122;
              } while (i2 <= i4);
            } while ((i2 >= m) && (i2 <= k));
            i4 = 48;
            if (i2 < i4) {
              break;
            }
            i4 = 57;
          } while (i2 <= i4);
        } while (i2 == j);
        i4 = 45;
      } while ((i2 == i4) || (i2 == n));
      i4 = 46;
    } while (i2 == i4);
    return pop(i1);
  }
  
  private final void skip()
  {
    for (;;)
    {
      boolean bool = eof;
      if (bool) {
        break;
      }
      int i = peek0;
      int j = 32;
      if (i > j) {
        break;
      }
      read();
    }
  }
  
  public void defineCharacterEntity(String paramString1, String paramString2)
  {
    entityMap.put(paramString1, paramString2);
  }
  
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
    int j = paramInt << 1;
    return localObject[j];
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
    int j = (paramInt << 1) + 1;
    return localObject[j];
  }
  
  public String getAttributeValue(String paramString)
  {
    int i = attributeCount << 1;
    int j = i + -2;
    boolean bool;
    int k;
    if (j >= 0)
    {
      localObject = attributes[j];
      bool = ((String)localObject).equals(paramString);
      if (bool)
      {
        localObject = attributes;
        k = j + 1;
      }
    }
    for (Object localObject = localObject[k];; localObject = null)
    {
      return (String)localObject;
      j += -2;
      break;
      bool = false;
    }
  }
  
  public int getColumnNumber()
  {
    return column;
  }
  
  public int getDepth()
  {
    return depth;
  }
  
  public int getLineNumber()
  {
    return line;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getPositionDescription()
  {
    int i = 3;
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    int j = type;
    Object localObject1 = TYPES;
    int k = localObject1.length;
    Object localObject2;
    if (j < k)
    {
      localObject2 = TYPES;
      int m = type;
      localObject2 = localObject2[m];
      localStringBuffer.<init>((String)localObject2);
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = ((StringBuilder)localObject2).append(" @");
      m = line;
      localObject2 = ((StringBuilder)localObject2).append(m).append(":");
      m = column;
      localObject2 = ((StringBuilder)localObject2).append(m);
      localObject1 = ": ";
      localObject2 = (String)localObject1;
      localStringBuffer.append((String)localObject2);
      j = type;
      m = 2;
      if (j != m)
      {
        j = type;
        if (j != i) {
          break label218;
        }
      }
      localStringBuffer.append('<');
      j = type;
      if (j == i)
      {
        j = 47;
        localStringBuffer.append(j);
      }
      localObject2 = name;
      localStringBuffer.append((String)localObject2);
      char c = '>';
      localStringBuffer.append(c);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localObject2 = "Other";
      break;
      label218:
      boolean bool = isWhitespace;
      if (bool)
      {
        localObject2 = "[whitespace]";
        localStringBuffer.append((String)localObject2);
      }
      else
      {
        localObject2 = getText();
        localStringBuffer.append((String)localObject2);
      }
    }
  }
  
  public String getText()
  {
    String str = text;
    if (str == null)
    {
      str = pop(0);
      text = str;
    }
    return text;
  }
  
  public int getType()
  {
    return type;
  }
  
  public boolean isEmptyElementTag()
  {
    return degenerated;
  }
  
  public boolean isWhitespace()
  {
    return isWhitespace;
  }
  
  public int next()
  {
    int i = 1;
    int k = 4;
    boolean bool1 = degenerated;
    if (bool1)
    {
      type = 3;
      degenerated = false;
      i = depth + -1;
      depth = i;
      i = type;
      return i;
    }
    txtPos = 0;
    isWhitespace = i;
    int m;
    label125:
    do
    {
      do
      {
        attributeCount = 0;
        name = null;
        text = null;
        m = peekType();
        type = m;
        m = type;
        switch (m)
        {
        default: 
          parseLegacy(false);
        case 1: 
          m = type;
        }
      } while (m > k);
      m = type;
      if (m != k) {
        break;
      }
      m = peekType();
    } while (m >= k);
    int n = isWhitespace;
    int i1 = type;
    if (i1 == k) {}
    for (;;)
    {
      i &= n;
      isWhitespace = i;
      i = type;
      break;
      boolean bool2 = isWhitespace;
      boolean bool3 = pushEntity();
      bool2 &= bool3;
      isWhitespace = bool2;
      type = k;
      break label125;
      parseStartTag();
      break label125;
      parseEndTag();
      break label125;
      bool2 = isWhitespace;
      bool3 = pushText(60);
      bool2 &= bool3;
      isWhitespace = bool2;
      break label125;
      parseLegacy(i);
      isWhitespace = false;
      type = k;
      break label125;
      int j = 0;
    }
  }
  
  public final boolean pushEntity()
  {
    int i = 32;
    String str1 = null;
    int j = 1;
    read();
    int m = txtPos;
    int i1;
    for (;;)
    {
      boolean bool = eof;
      if (bool) {
        break;
      }
      n = peek0;
      i1 = 59;
      if (n == i1) {
        break;
      }
      n = read();
      push(n);
    }
    String str2 = pop(m);
    read();
    int n = str2.length();
    String str3;
    int i2;
    if (n > 0)
    {
      n = str2.charAt(0);
      i1 = 35;
      if (n == i1)
      {
        n = str2.charAt(j);
        i1 = 120;
        if (n == i1)
        {
          n = 2;
          str3 = str2.substring(n);
          i1 = 16;
          i2 = Integer.parseInt(str3, i1);
          push(i2);
          if (i2 > i) {
            break label181;
          }
        }
      }
    }
    for (;;)
    {
      return j;
      str3 = str2.substring(j);
      i2 = Integer.parseInt(str3);
      break;
      label181:
      int k = 0;
      Object localObject = null;
      continue;
      localObject = entityMap;
      String str4 = (String)((Hashtable)localObject).get(str2);
      int i3 = 1;
      if (str4 == null)
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        localObject = ((StringBuilder)localObject).append("&").append(str2);
        str1 = ";";
        localObject = ((StringBuilder)localObject).append(str1);
        str4 = ((StringBuilder)localObject).toString();
      }
      int i4 = 0;
      for (;;)
      {
        k = str4.length();
        if (i4 >= k) {
          break;
        }
        i2 = str4.charAt(i4);
        if (i2 > i) {
          i3 = 0;
        }
        push(i2);
        i4 += 1;
      }
      k = i3;
    }
  }
  
  public String readText()
  {
    int i = type;
    int j = 4;
    String str;
    if (i != j) {
      str = "";
    }
    for (;;)
    {
      return str;
      str = getText();
      next();
    }
  }
  
  public void require(int paramInt, String paramString)
  {
    int i = 4;
    int j = type;
    if ((j == i) && (paramInt != i))
    {
      boolean bool1 = isWhitespace();
      if (bool1) {
        next();
      }
    }
    int k = type;
    Object localObject;
    if (paramInt == k)
    {
      if (paramString != null)
      {
        localObject = getName();
        boolean bool2 = paramString.equals(localObject);
        if (bool2) {}
      }
    }
    else
    {
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = ((StringBuilder)localObject).append("expected: ");
      String str = TYPES[paramInt];
      localObject = ((StringBuilder)localObject).append(str);
      str = "/";
      localObject = str + paramString;
      exception((String)localObject);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/xml/XmlReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */