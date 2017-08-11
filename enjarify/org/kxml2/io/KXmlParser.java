package org.kxml2.io;

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
  private String[] attributes;
  private int column;
  private boolean degenerated;
  private int depth;
  private String[] elementStack;
  private String encoding;
  private Hashtable entityMap;
  private String error;
  private boolean isWhitespace;
  private int line;
  private Object location;
  private String name;
  private String namespace;
  private int[] nspCounts;
  private String[] nspStack;
  private int[] peek;
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
  private char[] txtBuf;
  private int txtPos;
  private int type;
  private boolean unresolved;
  private String version;
  private boolean wasCR;
  
  public KXmlParser()
  {
    Object localObject = new String[j];
    elementStack = ((String[])localObject);
    localObject = new String[8];
    nspStack = ((String[])localObject);
    localObject = new int[4];
    nspCounts = ((int[])localObject);
    localObject = new char[i];
    txtBuf = ((char[])localObject);
    localObject = new String[j];
    attributes = ((String[])localObject);
    localObject = new int[2];
    peek = ((int[])localObject);
    localObject = Runtime.getRuntime();
    long l1 = ((Runtime)localObject).freeMemory();
    long l2 = 1048576L;
    boolean bool = l1 < l2;
    if (!bool) {
      i = 8192;
    }
    char[] arrayOfChar = new char[i];
    srcBuf = arrayOfChar;
  }
  
  private final boolean adjustNsp()
  {
    int i = 58;
    int j = -1;
    boolean bool1 = false;
    int k = 0;
    int m = attributeCount << 2;
    int i2;
    String str1;
    label83:
    label140:
    Object localObject3;
    if (k < m)
    {
      localObject1 = attributes;
      i2 = k + 2;
      str1 = localObject1[i2];
      i3 = str1.indexOf(i);
      String str2;
      boolean bool2;
      if (i3 != j)
      {
        str2 = str1.substring(0, i3);
        m = i3 + 1;
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
          i2 = depth;
          int i4 = localObject1[i2];
          int i5 = i4 + 1;
          localObject1[i2] = i5;
          int i6 = i4 << 1;
          localObject1 = nspStack;
          i2 = i6 + 2;
          localObject1 = ensureCapacity((String[])localObject1, i2);
          nspStack = ((String[])localObject1);
          nspStack[i6] = str1;
          localObject1 = nspStack;
          i2 = i6 + 1;
          Object localObject2 = attributes;
          i5 = k + 3;
          localObject2 = localObject2[i5];
          localObject1[i2] = localObject2;
          if (str1 != null)
          {
            localObject1 = attributes;
            i2 = k + 3;
            localObject1 = localObject1[i2];
            localObject3 = "";
            bool2 = ((String)localObject1).equals(localObject3);
            if (bool2)
            {
              localObject1 = "illegal empty namespace";
              error((String)localObject1);
            }
          }
          localObject1 = attributes;
          i2 = k + 4;
          localObject2 = attributes;
          i5 = attributeCount + -1;
          attributeCount = i5;
          i5 = (i5 << 2) - k;
          System.arraycopy(localObject1, i2, localObject2, k, i5);
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
        i2 = k + 2;
        str1 = localObject1[i2];
        i3 = str1.indexOf(i);
        if (i3 == 0)
        {
          boolean bool3 = relaxed;
          if (!bool3)
          {
            localObject1 = new java/lang/RuntimeException;
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            localObject3 = "illegal attribute name: " + str1 + " at " + this;
            ((RuntimeException)localObject1).<init>((String)localObject3);
            throw ((Throwable)localObject1);
          }
        }
        if (i3 != j)
        {
          String str3 = str1.substring(0, i3);
          int i1 = i3 + 1;
          str1 = str1.substring(i1);
          String str4 = getNamespace(str3);
          if (str4 == null)
          {
            boolean bool4 = relaxed;
            if (!bool4)
            {
              localObject1 = new java/lang/RuntimeException;
              localObject3 = new java/lang/StringBuilder;
              ((StringBuilder)localObject3).<init>();
              localObject3 = "Undefined Prefix: " + str3 + " in " + this;
              ((RuntimeException)localObject1).<init>((String)localObject3);
              throw ((Throwable)localObject1);
            }
          }
          attributes[k] = str4;
          localObject1 = attributes;
          i2 = k + 1;
          localObject1[i2] = str3;
          localObject1 = attributes;
          i2 = k + 2;
          localObject1[i2] = str1;
        }
        k += -4;
      }
    }
    Object localObject1 = name;
    int i3 = ((String)localObject1).indexOf(i);
    if (i3 == 0)
    {
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject1 = ((StringBuilder)localObject1).append("illegal tag name: ");
      localObject3 = name;
      localObject1 = (String)localObject3;
      error((String)localObject1);
    }
    if (i3 != j)
    {
      localObject1 = name.substring(0, i3);
      prefix = ((String)localObject1);
      localObject1 = name;
      i2 = i3 + 1;
      localObject1 = ((String)localObject1).substring(i2);
      name = ((String)localObject1);
    }
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
        error((String)localObject1);
      }
      localObject1 = "";
      namespace = ((String)localObject1);
    }
    return bool1;
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
  
  private final void error(String paramString)
  {
    boolean bool = relaxed;
    if (bool)
    {
      Object localObject = error;
      if (localObject == null)
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        String str = "ERR: ";
        localObject = str + paramString;
        error = ((String)localObject);
      }
    }
    for (;;)
    {
      return;
      exception(paramString);
    }
  }
  
  private final void exception(String paramString)
  {
    int i = 100;
    XmlPullParserException localXmlPullParserException = new org/xmlpull/v1/XmlPullParserException;
    int j = paramString.length();
    if (j < i) {}
    for (;;)
    {
      localXmlPullParserException.<init>(paramString, this, null);
      throw localXmlPullParserException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      String str = paramString.substring(0, i);
      localStringBuilder = localStringBuilder.append(str);
      str = "\n";
      localStringBuilder = localStringBuilder.append(str);
      paramString = localStringBuilder.toString();
    }
  }
  
  private final String get(int paramInt)
  {
    String str = new java/lang/String;
    char[] arrayOfChar = txtBuf;
    int i = txtPos - paramInt;
    str.<init>(arrayOfChar, paramInt, i);
    return str;
  }
  
  private final boolean isProp(String paramString1, boolean paramBoolean, String paramString2)
  {
    String str = "http://xmlpull.org/v1/doc/";
    boolean bool = paramString1.startsWith(str);
    if (!bool)
    {
      bool = false;
      str = null;
    }
    for (;;)
    {
      return bool;
      if (paramBoolean)
      {
        str = paramString1.substring(42);
        bool = str.equals(paramString2);
      }
      else
      {
        str = paramString1.substring(40);
        bool = str.equals(paramString2);
      }
    }
  }
  
  private final void nextImpl()
  {
    int i = 3;
    int j = 0;
    String str = null;
    Object localObject = reader;
    if (localObject == null)
    {
      localObject = "No Input specified";
      exception((String)localObject);
    }
    int n = type;
    if (n == i)
    {
      n = depth + -1;
      depth = n;
    }
    attributeCount = -1;
    boolean bool2 = degenerated;
    if (bool2)
    {
      degenerated = false;
      type = i;
    }
    for (;;)
    {
      return;
      localObject = error;
      if (localObject != null)
      {
        int i3 = 0;
        for (;;)
        {
          str = error;
          j = str.length();
          if (i3 >= j) {
            break;
          }
          str = error;
          j = str.charAt(i3);
          push(j);
          int i4;
          i3 += 1;
        }
        error = null;
        j = 9;
        type = j;
      }
      else
      {
        prefix = null;
        name = null;
        namespace = null;
        int i1 = peekType();
        type = i1;
        i1 = type;
        int i2;
        switch (i1)
        {
        case 1: 
        case 5: 
        default: 
          boolean bool3 = token;
          i2 = parseLegacy(bool3);
          type = i2;
          i2 = type;
          int i5 = 998;
          if (i2 == i5) {
            break;
          }
          break;
        case 6: 
          pushEntity();
          break;
        case 2: 
          parseStartTag(false);
          break;
        case 3: 
          parseEndTag();
          break;
        case 4: 
          i2 = 60;
          boolean bool4 = token;
          if (!bool4) {
            j = 1;
          }
          pushText(i2, j);
          int k = depth;
          if (k == 0)
          {
            boolean bool1 = isWhitespace;
            if (bool1)
            {
              int m = 7;
              type = m;
            }
          }
          break;
        }
      }
    }
  }
  
  private final void parseDoctype(boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    for (;;)
    {
      label4:
      int k = read();
      switch (k)
      {
      default: 
        label56:
        if (!paramBoolean) {
          break label103;
        }
        push(k);
      }
    }
    String str = "Unexpected EOF";
    error(str);
    for (;;)
    {
      return;
      if (j == 0) {}
      for (j = 1;; j = 0) {
        break;
      }
      if (j != 0) {
        break label56;
      }
      i += 1;
      break label56;
      label103:
      break label4;
      if (j != 0) {
        break;
      }
      i += -1;
      if (i != 0) {
        break;
      }
    }
  }
  
  private final void parseEndTag()
  {
    read();
    read();
    Object localObject1 = readName();
    name = ((String)localObject1);
    skip();
    read('>');
    int i = depth + -1 << 2;
    int j = depth;
    if (j == 0)
    {
      localObject1 = "element stack empty";
      error((String)localObject1);
      j = 9;
      type = j;
    }
    for (;;)
    {
      return;
      boolean bool = relaxed;
      if (!bool)
      {
        localObject1 = name;
        Object localObject2 = elementStack;
        int k = i + 3;
        localObject2 = localObject2[k];
        bool = ((String)localObject1).equals(localObject2);
        if (!bool)
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          localObject1 = ((StringBuilder)localObject1).append("expected: /");
          localObject2 = elementStack;
          k = i + 3;
          localObject2 = localObject2[k];
          localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(" read: ");
          localObject2 = name;
          localObject1 = (String)localObject2;
          error((String)localObject1);
        }
        localObject1 = elementStack[i];
        namespace = ((String)localObject1);
        localObject1 = elementStack;
        int m = i + 1;
        localObject1 = localObject1[m];
        prefix = ((String)localObject1);
        localObject1 = elementStack;
        m = i + 2;
        localObject1 = localObject1[m];
        name = ((String)localObject1);
      }
    }
  }
  
  private final int parseLegacy(boolean paramBoolean)
  {
    String str = "";
    int i = 0;
    read();
    int j = read();
    int k = 63;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i9;
    if (j == k)
    {
      localObject1 = null;
      k = peek(0);
      int i5 = 120;
      if (k != i5)
      {
        localObject1 = null;
        k = peek(0);
        i5 = 88;
        if (k != i5) {}
      }
      else
      {
        k = peek(1);
        i5 = 109;
        if (k != i5)
        {
          k = peek(1);
          i5 = 77;
          if (k != i5) {}
        }
        else
        {
          if (paramBoolean)
          {
            localObject1 = null;
            k = peek(0);
            push(k);
            k = peek(1);
            push(k);
          }
          read();
          read();
          localObject1 = null;
          k = peek(0);
          i5 = 108;
          if (k != i5)
          {
            localObject1 = null;
            k = peek(0);
            i5 = 76;
            if (k != i5) {}
          }
          else
          {
            k = peek(1);
            i5 = 32;
            if (k <= i5)
            {
              k = line;
              i5 = 1;
              if (k == i5)
              {
                k = column;
                i5 = 4;
                if (k <= i5) {}
              }
              else
              {
                localObject1 = "PI must not start with xml";
                error((String)localObject1);
              }
              parseStartTag(true);
              k = attributeCount;
              i5 = 1;
              int i7;
              if (k >= i5)
              {
                localObject1 = "version";
                localObject2 = attributes;
                i7 = 2;
                localObject2 = localObject2[i7];
                boolean bool1 = ((String)localObject1).equals(localObject2);
                if (bool1) {}
              }
              else
              {
                localObject1 = "version expected";
                error((String)localObject1);
              }
              localObject1 = attributes;
              i5 = 3;
              localObject1 = localObject1[i5];
              version = ((String)localObject1);
              int i8 = 1;
              int m = attributeCount;
              if (i8 < m)
              {
                localObject1 = "encoding";
                localObject2 = attributes;
                i7 = 6;
                localObject2 = localObject2[i7];
                boolean bool2 = ((String)localObject1).equals(localObject2);
                if (bool2)
                {
                  localObject1 = attributes;
                  i5 = 7;
                  localObject1 = localObject1[i5];
                  encoding = ((String)localObject1);
                  i8 += 1;
                }
              }
              int n = attributeCount;
              if (i8 < n)
              {
                localObject1 = "standalone";
                localObject2 = attributes;
                i7 = i8 * 4 + 2;
                localObject2 = localObject2[i7];
                boolean bool3 = ((String)localObject1).equals(localObject2);
                if (bool3)
                {
                  localObject1 = attributes;
                  i5 = i8 * 4 + 3;
                  localObject3 = localObject1[i5];
                  localObject1 = "yes";
                  bool3 = ((String)localObject1).equals(localObject3);
                  if (!bool3) {
                    break label589;
                  }
                  localObject1 = new java/lang/Boolean;
                  i5 = 1;
                  ((Boolean)localObject1).<init>(i5);
                  standalone = ((Boolean)localObject1);
                  i8 += 1;
                }
              }
              int i1 = attributeCount;
              if (i8 != i1)
              {
                localObject1 = "illegal xmldecl";
                error((String)localObject1);
              }
              isWhitespace = true;
              i1 = 0;
              localObject1 = null;
              txtPos = 0;
              i9 = 998;
            }
          }
        }
      }
    }
    for (;;)
    {
      return i9;
      label589:
      localObject1 = "no";
      boolean bool4 = ((String)localObject1).equals(localObject3);
      int i6;
      if (bool4)
      {
        localObject1 = new java/lang/Boolean;
        i6 = 0;
        localObject2 = null;
        ((Boolean)localObject1).<init>(false);
        standalone = ((Boolean)localObject1);
        break;
      }
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject2 = "illegal standalone value: ";
      localObject1 = (String)localObject2 + (String)localObject3;
      error((String)localObject1);
      break;
      int i10 = 63;
      i9 = 8;
      for (;;)
      {
        int i11 = 0;
        for (;;)
        {
          int i2 = str.length();
          if (i11 >= i2) {
            break;
          }
          i2 = str.charAt(i11);
          read(i2);
          int i12;
          i11 += 1;
        }
        i3 = 33;
        if (j != i3) {
          break;
        }
        localObject1 = null;
        i3 = peek(0);
        i6 = 45;
        if (i3 == i6)
        {
          i9 = 9;
          str = "--";
          i10 = 45;
        }
        else
        {
          localObject1 = null;
          i3 = peek(0);
          i6 = 91;
          if (i3 == i6)
          {
            i9 = 5;
            str = "[CDATA[";
            i10 = 93;
            paramBoolean = true;
          }
          else
          {
            i9 = 10;
            str = "DOCTYPE";
            i10 = -1;
          }
        }
      }
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject2 = "illegal: <";
      localObject1 = (String)localObject2 + j;
      error((String)localObject1);
      i9 = 9;
      continue;
      int i3 = 10;
      if (i9 == i3)
      {
        parseDoctype(paramBoolean);
      }
      else
      {
        do
        {
          do
          {
            do
            {
              i = j;
              j = read();
              i3 = -1;
              if (j == i3)
              {
                localObject1 = "Unexpected EOF";
                error((String)localObject1);
                i9 = 9;
                break;
              }
              if (paramBoolean) {
                push(j);
              }
              i3 = 63;
            } while ((i10 != i3) && (j != i10));
            localObject1 = null;
            i3 = peek(0);
          } while (i3 != i10);
          i3 = peek(1);
          i6 = 62;
        } while (i3 != i6);
        i3 = 45;
        if (i10 == i3)
        {
          i3 = 45;
          if (i == i3)
          {
            boolean bool5 = relaxed;
            if (!bool5)
            {
              localObject1 = "illegal comment delimiter: --->";
              error((String)localObject1);
            }
          }
        }
        read();
        read();
        if (paramBoolean)
        {
          int i4 = 63;
          if (i10 != i4)
          {
            i4 = txtPos + -1;
            txtPos = i4;
          }
        }
      }
    }
  }
  
  private final void parseStartTag(boolean paramBoolean)
  {
    int i = 61;
    boolean bool1 = true;
    char c = '>';
    int k = 0;
    if (!paramBoolean) {
      read();
    }
    Object localObject1 = readName();
    name = ((String)localObject1);
    attributeCount = 0;
    skip();
    int m = peek(0);
    int n;
    label75:
    label107:
    int i4;
    int i5;
    Object localObject2;
    Object localObject3;
    int j;
    if (paramBoolean)
    {
      n = 63;
      if (m == n)
      {
        read();
        read(c);
      }
    }
    else
    {
      n = 47;
      if (m == n)
      {
        degenerated = bool1;
        read();
        skip();
        read(c);
        n = depth;
        i4 = n + 1;
        depth = i4;
        i5 = n << 2;
        localObject1 = elementStack;
        i4 = i5 + 4;
        localObject1 = ensureCapacity((String[])localObject1, i4);
        elementStack = ((String[])localObject1);
        localObject1 = elementStack;
        i4 = i5 + 3;
        localObject2 = name;
        localObject1[i4] = localObject2;
        n = depth;
        localObject3 = nspCounts;
        i4 = localObject3.length;
        if (n >= i4)
        {
          n = depth + 4;
          int[] arrayOfInt = new int[n];
          localObject1 = nspCounts;
          localObject3 = nspCounts;
          i4 = localObject3.length;
          System.arraycopy(localObject1, 0, arrayOfInt, 0, i4);
          nspCounts = arrayOfInt;
        }
        localObject1 = nspCounts;
        i4 = depth;
        localObject2 = nspCounts;
        k = depth + -1;
        j = localObject2[k];
        localObject1[i4] = j;
        boolean bool2 = processNsp;
        if (!bool2) {
          break label785;
        }
        adjustNsp();
      }
    }
    for (;;)
    {
      localObject1 = elementStack;
      localObject3 = namespace;
      localObject1[i5] = localObject3;
      localObject1 = elementStack;
      i4 = i5 + 1;
      localObject2 = prefix;
      localObject1[i4] = localObject2;
      localObject1 = elementStack;
      i4 = i5 + 2;
      localObject2 = name;
      localObject1[i4] = localObject2;
      break label75;
      if ((m == j) && (!paramBoolean))
      {
        read();
        break label107;
      }
      int i1 = -1;
      if (m == i1)
      {
        localObject1 = "Unexpected EOF";
        error((String)localObject1);
        break label75;
      }
      String str = readName();
      i1 = str.length();
      if (i1 == 0)
      {
        localObject1 = "attr name expected";
        error((String)localObject1);
        break label107;
      }
      i1 = attributeCount;
      i4 = i1 + 1;
      attributeCount = i4;
      int i6 = i1 << 2;
      localObject1 = attributes;
      i4 = i6 + 4;
      localObject1 = ensureCapacity((String[])localObject1, i4);
      attributes = ((String[])localObject1);
      localObject1 = attributes;
      int i7 = i6 + 1;
      localObject1[i6] = "";
      localObject1 = attributes;
      i6 = i7 + 1;
      i4 = 0;
      localObject3 = null;
      localObject1[i7] = null;
      localObject1 = attributes;
      i7 = i6 + 1;
      localObject1[i6] = str;
      skip();
      i1 = peek(0);
      if (i1 != i)
      {
        boolean bool3 = relaxed;
        if (!bool3)
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          localObject3 = "Attr.value missing f. ";
          localObject1 = (String)localObject3 + str;
          error((String)localObject1);
        }
        localObject1 = attributes;
        localObject1[i7] = str;
        break;
      }
      read(i);
      skip();
      int i8 = peek(0);
      int i2 = 39;
      if (i8 != i2)
      {
        i2 = 34;
        if (i8 != i2)
        {
          boolean bool4 = relaxed;
          if (!bool4)
          {
            localObject1 = "attr value delimiter missing!";
            error((String)localObject1);
          }
          i8 = 32;
        }
      }
      for (;;)
      {
        int i9 = txtPos;
        pushText(i8, bool1);
        localObject1 = attributes;
        localObject3 = get(i9);
        localObject1[i7] = localObject3;
        txtPos = i9;
        int i3 = 32;
        if (i8 == i3) {
          break;
        }
        read();
        break;
        read();
      }
      label785:
      localObject1 = "";
      namespace = ((String)localObject1);
    }
  }
  
  private final int peek(int paramInt)
  {
    int i = 10;
    int j = 1;
    int k = peekCount;
    if (paramInt >= k)
    {
      Object localObject = srcBuf;
      k = localObject.length;
      if (k <= j) {
        localObject = reader;
      }
      int n;
      for (int m = ((Reader)localObject).read();; m = localObject[n])
      {
        k = 13;
        if (m != k) {
          break label227;
        }
        wasCR = j;
        localObject = peek;
        n = peekCount;
        i1 = n + 1;
        peekCount = i1;
        localObject[n] = i;
        break;
        k = srcPos;
        n = srcCount;
        if (k >= n) {
          break label149;
        }
        localObject = srcBuf;
        n = srcPos;
        i1 = n + 1;
        srcPos = i1;
      }
      label149:
      localObject = reader;
      char[] arrayOfChar1 = srcBuf;
      char[] arrayOfChar2 = srcBuf;
      int i1 = arrayOfChar2.length;
      k = ((Reader)localObject).read(arrayOfChar1, 0, i1);
      srcCount = k;
      k = srcCount;
      if (k <= 0) {}
      for (m = -1;; m = localObject[0])
      {
        srcPos = j;
        break;
        localObject = srcBuf;
      }
      label227:
      if (m == i)
      {
        boolean bool = wasCR;
        if (!bool)
        {
          localObject = peek;
          n = peekCount;
          i1 = n + 1;
          peekCount = i1;
          localObject[n] = i;
        }
      }
      for (;;)
      {
        wasCR = false;
        break;
        localObject = peek;
        n = peekCount;
        i1 = n + 1;
        peekCount = i1;
        localObject[n] = m;
      }
    }
    return peek[paramInt];
  }
  
  private final int peekType()
  {
    int i = 1;
    int j = peek(0);
    switch (j)
    {
    default: 
      i = 4;
    }
    for (;;)
    {
      return i;
      i = 6;
      continue;
      i = peek(i);
      switch (i)
      {
      default: 
        i = 2;
        break;
      case 47: 
        i = 3;
        break;
      case 33: 
      case 63: 
        i = 999;
      }
    }
  }
  
  private final void push(int paramInt)
  {
    int i = 0;
    int j = isWhitespace;
    int m = 32;
    if (paramInt <= m) {
      m = 1;
    }
    for (;;)
    {
      m &= j;
      isWhitespace = m;
      m = txtPos;
      char[] arrayOfChar1 = txtBuf;
      int k = arrayOfChar1.length;
      if (m == k)
      {
        m = txtPos * 4 / 3 + 4;
        char[] arrayOfChar2 = new char[m];
        arrayOfChar3 = txtBuf;
        k = txtPos;
        System.arraycopy(arrayOfChar3, 0, arrayOfChar2, 0, k);
        txtBuf = arrayOfChar2;
      }
      char[] arrayOfChar3 = txtBuf;
      i = txtPos;
      k = i + 1;
      txtPos = k;
      k = (char)paramInt;
      arrayOfChar3[i] = k;
      return;
      m = 0;
      arrayOfChar3 = null;
    }
  }
  
  private final void pushEntity()
  {
    int i = 35;
    int j = 1;
    int n = 0;
    Object localObject1 = null;
    int i1 = read();
    push(i1);
    int i3 = txtPos;
    int i4 = peek(0);
    i1 = 59;
    String str1;
    int i2;
    Object localObject2;
    if (i4 == i1)
    {
      read();
      str1 = get(i3);
      i1 = i3 + -1;
      txtPos = i1;
      boolean bool2 = token;
      if (bool2)
      {
        i2 = type;
        int i5 = 6;
        if (i2 == i5) {
          name = str1;
        }
      }
      i2 = str1.charAt(0);
      if (i2 != i) {
        break label384;
      }
      n = str1.charAt(j);
      i2 = 120;
      if (n != i2) {
        break label366;
      }
      j = 2;
      localObject2 = str1.substring(j);
      n = 16;
    }
    int k;
    for (i4 = Integer.parseInt((String)localObject2, n);; i4 = Integer.parseInt((String)localObject2))
    {
      push(i4);
      for (;;)
      {
        return;
        i2 = 128;
        if (i4 >= i2) {
          break;
        }
        i2 = 48;
        if (i4 >= i2)
        {
          i2 = 57;
          if (i4 <= i2) {
            break;
          }
        }
        i2 = 97;
        if (i4 >= i2)
        {
          i2 = 122;
          if (i4 <= i2) {
            break;
          }
        }
        i2 = 65;
        if (i4 >= i2)
        {
          i2 = 90;
          if (i4 <= i2) {
            break;
          }
        }
        i2 = 95;
        if (i4 == i2) {
          break;
        }
        i2 = 45;
        if ((i4 == i2) || (i4 == i)) {
          break;
        }
        k = relaxed;
        if (k == 0)
        {
          localObject2 = "unterminated entity ref";
          error((String)localObject2);
        }
        localObject2 = System.out;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localObject1 = ((StringBuilder)localObject1).append("broken entitiy: ");
        i2 = i3 + -1;
        localObject3 = get(i2);
        localObject1 = (String)localObject3;
        ((PrintStream)localObject2).println((String)localObject1);
      }
      i2 = read();
      push(i2);
      break;
      label366:
      localObject2 = str1.substring(k);
    }
    label384:
    Object localObject3 = entityMap;
    String str2 = (String)((Hashtable)localObject3).get(str1);
    if (str2 == null) {}
    for (;;)
    {
      unresolved = k;
      boolean bool1 = unresolved;
      if (!bool1) {
        break label489;
      }
      bool1 = token;
      if (bool1) {
        break;
      }
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = ((StringBuilder)localObject2).append("unresolved: &").append(str1);
      localObject1 = ";";
      localObject2 = (String)localObject1;
      error((String)localObject2);
      break;
      bool1 = false;
      localObject2 = null;
    }
    label489:
    int i6 = 0;
    for (;;)
    {
      int m = str2.length();
      if (i6 >= m) {
        break;
      }
      m = str2.charAt(i6);
      push(m);
      i6 += 1;
    }
  }
  
  private final void pushText(int paramInt, boolean paramBoolean)
  {
    int i = 93;
    int j = 62;
    int k = 2;
    int m = 32;
    int n = peek(0);
    int i1 = 0;
    int i2 = -1;
    if ((n == i2) || (n == paramInt) || ((paramInt == m) && ((n <= m) || (n == j)))) {}
    do
    {
      return;
      i2 = 38;
      if (n != i2) {
        break;
      }
    } while (!paramBoolean);
    pushEntity();
    label80:
    if ((n == j) && (i1 >= k) && (paramInt != i))
    {
      String str = "Illegal: ]]>";
      error(str);
    }
    if (n == i) {
      i1 += 1;
    }
    for (;;)
    {
      n = peek(0);
      break;
      i2 = 10;
      if (n == i2)
      {
        i2 = type;
        if (i2 == k)
        {
          read();
          push(m);
          break label80;
        }
      }
      i2 = read();
      push(i2);
      break label80;
      i1 = 0;
    }
  }
  
  private final int read()
  {
    int i = 1;
    int j = peekCount;
    int k;
    if (j == 0) {
      k = peek(0);
    }
    for (;;)
    {
      j = peekCount + -1;
      peekCount = j;
      j = column + 1;
      column = j;
      j = 10;
      if (k == j)
      {
        j = line + 1;
        line = j;
        column = i;
      }
      return k;
      k = peek[0];
      int[] arrayOfInt1 = peek;
      int[] arrayOfInt2 = peek;
      int m = arrayOfInt2[i];
      arrayOfInt1[0] = m;
    }
  }
  
  private final void read(char paramChar)
  {
    char c1 = read();
    if (c1 != paramChar)
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = ((StringBuilder)localObject).append("expected: '").append(paramChar).append("' actual: '");
      char c2 = (char)c1;
      localObject = ((StringBuilder)localObject).append(c2);
      String str = "'";
      localObject = str;
      error((String)localObject);
    }
  }
  
  private final String readName()
  {
    int i = 95;
    int j = 90;
    int k = 65;
    int m = 58;
    int n = txtPos;
    int i1 = peek(0);
    int i2 = 97;
    if (i1 >= i2)
    {
      i2 = 122;
      if (i1 <= i2) {}
    }
    else if (((i1 < k) || (i1 > j)) && (i1 != i) && (i1 != m))
    {
      i2 = 192;
      if (i1 < i2)
      {
        boolean bool = relaxed;
        if (!bool)
        {
          String str1 = "name expected";
          error(str1);
        }
      }
    }
    int i3;
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
                do
                {
                  i3 = read();
                  push(i3);
                  i1 = peek(0);
                  i3 = 97;
                  if (i1 < i3) {
                    break;
                  }
                  i3 = 122;
                } while (i1 <= i3);
              } while ((i1 >= k) && (i1 <= j));
              i3 = 48;
              if (i1 < i3) {
                break;
              }
              i3 = 57;
            } while (i1 <= i3);
          } while (i1 == i);
          i3 = 45;
        } while ((i1 == i3) || (i1 == m));
        i3 = 46;
      } while (i1 == i3);
      i3 = 183;
    } while (i1 >= i3);
    String str2 = get(n);
    txtPos = n;
    return str2;
  }
  
  private final void skip()
  {
    for (;;)
    {
      int i = peek(0);
      int j = 32;
      if (i <= j)
      {
        j = -1;
        if (i != j) {}
      }
      else
      {
        return;
      }
      read();
    }
  }
  
  public void defineEntityReplacementText(String paramString1, String paramString2)
  {
    Object localObject = entityMap;
    if (localObject == null)
    {
      localObject = new java/lang/RuntimeException;
      ((RuntimeException)localObject).<init>("entity replacement text must be defined after setInput!");
      throw ((Throwable)localObject);
    }
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
    return column;
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
    boolean bool1 = false;
    String str = "http://xmlpull.org/v1/doc/features.html#process-namespaces";
    boolean bool2 = str.equals(paramString);
    if (bool2) {
      bool1 = processNsp;
    }
    for (;;)
    {
      return bool1;
      str = "relaxed";
      bool2 = isProp(paramString, false, str);
      if (bool2) {
        bool1 = relaxed;
      }
    }
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
          break label642;
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
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject2 = ((StringBuilder)localObject2).append("@");
    i3 = line;
    localObject2 = ((StringBuilder)localObject2).append(i3);
    localObject1 = ":";
    localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
    i3 = column;
    localObject2 = i3;
    localStringBuffer.append((String)localObject2);
    localObject2 = location;
    if (localObject2 != null)
    {
      localStringBuffer.append(" in ");
      localObject2 = location;
      localStringBuffer.append(localObject2);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      label642:
      int i1 = type;
      i3 = 7;
      if (i1 == i3) {
        break;
      }
      i1 = type;
      i3 = 4;
      if (i1 != i3)
      {
        localObject2 = getText();
        localStringBuffer.append((String)localObject2);
        break;
      }
      boolean bool2 = isWhitespace;
      if (bool2)
      {
        localObject2 = "(whitespace)";
        localStringBuffer.append((String)localObject2);
        break;
      }
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
      break;
      localObject2 = reader;
      if (localObject2 != null)
      {
        localStringBuffer.append(" in ");
        localObject2 = reader.toString();
        localStringBuffer.append((String)localObject2);
      }
    }
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public Object getProperty(String paramString)
  {
    boolean bool1 = true;
    Object localObject = "xmldecl-version";
    boolean bool2 = isProp(paramString, bool1, (String)localObject);
    if (bool2) {
      localObject = version;
    }
    for (;;)
    {
      return localObject;
      localObject = "xmldecl-standalone";
      bool2 = isProp(paramString, bool1, (String)localObject);
      if (bool2)
      {
        localObject = standalone;
      }
      else
      {
        localObject = "location";
        bool2 = isProp(paramString, bool1, (String)localObject);
        if (bool2)
        {
          localObject = location;
          if (localObject != null) {
            localObject = location;
          } else {
            localObject = reader.toString();
          }
        }
        else
        {
          bool2 = false;
          localObject = null;
        }
      }
    }
  }
  
  public String getText()
  {
    int i = type;
    int j = 4;
    boolean bool;
    if (i >= j)
    {
      i = type;
      j = 6;
      if (i == j)
      {
        bool = unresolved;
        if (!bool) {}
      }
    }
    else
    {
      bool = false;
    }
    for (String str = null;; str = get(0))
    {
      return str;
      bool = false;
    }
  }
  
  public char[] getTextCharacters(int[] paramArrayOfInt)
  {
    int i = -1;
    int j = 1;
    int k = type;
    int m = 4;
    char[] arrayOfChar;
    if (k >= m)
    {
      k = type;
      m = 6;
      if (k == m)
      {
        paramArrayOfInt[0] = 0;
        k = name.length();
        paramArrayOfInt[j] = k;
        arrayOfChar = name.toCharArray();
      }
    }
    for (;;)
    {
      return arrayOfChar;
      paramArrayOfInt[0] = 0;
      k = txtPos;
      paramArrayOfInt[j] = k;
      arrayOfChar = txtBuf;
      continue;
      paramArrayOfInt[0] = i;
      paramArrayOfInt[j] = i;
      k = 0;
      arrayOfChar = null;
    }
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
    txtPos = 0;
    int j = 1;
    isWhitespace = j;
    int k = 9999;
    token = false;
    do
    {
      do
      {
        nextImpl();
        j = type;
        if (j < k) {
          k = type;
        }
        j = 6;
      } while (k > j);
      if (k < i) {
        break;
      }
      j = peekType();
    } while (j >= i);
    type = k;
    j = type;
    if (j > i) {
      type = i;
    }
    return type;
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
    boolean bool = true;
    isWhitespace = bool;
    txtPos = 0;
    token = bool;
    nextImpl();
    return type;
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
          return;
        }
        localObject = getName();
        bool = paramString2.equals(localObject);
        if (bool) {
          return;
        }
      }
    }
    Object localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    localObject = ((StringBuilder)localObject).append("expected: ");
    String str = TYPES[paramInt];
    localObject = ((StringBuilder)localObject).append(str).append(" {").append(paramString1);
    str = "}";
    localObject = str + paramString2;
    exception((String)localObject);
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
      localObject = null;
      String str = "relaxed";
      bool = isProp(paramString, false, str);
      if (bool)
      {
        relaxed = paramBoolean;
      }
      else
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        str = "unsupported feature: ";
        localObject = str + paramString;
        exception((String)localObject);
      }
    }
  }
  
  public void setInput(InputStream paramInputStream, String paramString)
  {
    srcPos = 0;
    int i = 0;
    Object localObject1 = null;
    srcCount = 0;
    String str1 = paramString;
    if (paramInputStream == null)
    {
      localObject1 = new java/lang/IllegalArgumentException;
      ((IllegalArgumentException)localObject1).<init>();
      throw ((Throwable)localObject1);
    }
    int j;
    if (paramString == null) {
      j = 0;
    }
    for (;;)
    {
      int m;
      Object localObject3;
      int n;
      char[] arrayOfChar;
      int i2;
      try
      {
        i = srcCount;
        k = 4;
        if (i < k)
        {
          m = paramInputStream.read();
          i = -1;
          if (m != i) {}
        }
        else
        {
          i = srcCount;
          k = 4;
          if (i != k) {}
        }
        switch (j)
        {
        default: 
          i = 0xFFFF0000 & j;
          k = -16842752;
          if (i != k) {
            break label831;
          }
          str1 = "UTF-16BE";
          localObject1 = srcBuf;
          k = 0;
          localObject2 = null;
          localObject3 = srcBuf;
          n = 2;
          i1 = localObject3[n] << '\b';
          arrayOfChar = srcBuf;
          i2 = 3;
          n = arrayOfChar[i2];
          i1 = (char)(i1 | n);
          localObject1[0] = i1;
          i = 1;
          srcCount = i;
          if (str1 == null) {
            str1 = "UTF-8";
          }
          int i3 = srcCount;
          localObject1 = new java/io/InputStreamReader;
          ((InputStreamReader)localObject1).<init>(paramInputStream, str1);
          setInput((Reader)localObject1);
          encoding = paramString;
          srcCount = i3;
          return;
          i = j << 8;
          j = i | m;
          localObject1 = srcBuf;
          k = srcCount;
          i1 = k + 1;
          srcCount = i1;
          i1 = (char)m;
          localObject1[k] = i1;
          break;
        case 65279: 
          str1 = "UTF-32BE";
        }
      }
      catch (Exception localException)
      {
        localObject1 = new org/xmlpull/v1/XmlPullParserException;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject2 = ((StringBuilder)localObject2).append("Invalid stream or encoding: ");
        localObject3 = localException.toString();
        localObject2 = (String)localObject3;
        ((XmlPullParserException)localObject1).<init>((String)localObject2, this, localException);
        throw ((Throwable)localObject1);
      }
      i = 0;
      localObject1 = null;
      srcCount = 0;
      continue;
      str1 = "UTF-32LE";
      i = 0;
      localObject1 = null;
      srcCount = 0;
      continue;
      str1 = "UTF-32BE";
      localObject1 = srcBuf;
      int k = 0;
      Object localObject2 = null;
      int i1 = 60;
      localObject1[0] = i1;
      i = 1;
      srcCount = i;
      continue;
      str1 = "UTF-32LE";
      localObject1 = srcBuf;
      k = 0;
      localObject2 = null;
      i1 = 60;
      localObject1[0] = i1;
      i = 1;
      srcCount = i;
      continue;
      str1 = "UTF-16BE";
      localObject1 = srcBuf;
      k = 0;
      localObject2 = null;
      i1 = 60;
      localObject1[0] = i1;
      localObject1 = srcBuf;
      k = 1;
      i1 = 63;
      localObject1[k] = i1;
      i = 2;
      srcCount = i;
      continue;
      str1 = "UTF-16LE";
      localObject1 = srcBuf;
      k = 0;
      localObject2 = null;
      i1 = 60;
      localObject1[0] = i1;
      localObject1 = srcBuf;
      k = 1;
      i1 = 63;
      localObject1[k] = i1;
      i = 2;
      srcCount = i;
      continue;
      do
      {
        m = paramInputStream.read();
        i = -1;
        if (m == i) {
          break;
        }
        localObject1 = srcBuf;
        k = srcCount;
        i1 = k + 1;
        srcCount = i1;
        i1 = (char)m;
        localObject1[k] = i1;
        i = 62;
      } while (m != i);
      String str2 = new java/lang/String;
      localObject1 = srcBuf;
      k = 0;
      localObject2 = null;
      i1 = srcCount;
      str2.<init>((char[])localObject1, 0, i1);
      localObject1 = "encoding";
      int i4 = str2.indexOf((String)localObject1);
      i = -1;
      if (i4 != i)
      {
        for (int i5 = i4;; i5 = i4)
        {
          i = str2.charAt(i5);
          k = 34;
          if (i == k) {
            break;
          }
          i = str2.charAt(i5);
          k = 39;
          if (i == k) {
            break;
          }
          i4 = i5 + 1;
        }
        i4 = i5 + 1;
        int i6 = str2.charAt(i5);
        int i7 = str2.indexOf(i6, i4);
        str1 = str2.substring(i4, i7);
        continue;
        label831:
        i = 0xFFFF0000 & j;
        k = -131072;
        if (i == k)
        {
          str1 = "UTF-16LE";
          localObject1 = srcBuf;
          k = 0;
          localObject2 = null;
          localObject3 = srcBuf;
          n = 3;
          i1 = localObject3[n] << '\b';
          arrayOfChar = srcBuf;
          i2 = 2;
          n = arrayOfChar[i2];
          i1 = (char)(i1 | n);
          localObject1[0] = i1;
          i = 1;
          srcCount = i;
        }
        else
        {
          i = j & 0xFF00;
          k = -272908544;
          if (i == k)
          {
            str1 = "UTF-8";
            localObject1 = srcBuf;
            k = 0;
            localObject2 = null;
            localObject3 = srcBuf;
            n = 3;
            i1 = localObject3[n];
            localObject1[0] = i1;
            i = 1;
            srcCount = i;
          }
        }
      }
    }
  }
  
  public void setInput(Reader paramReader)
  {
    String str1 = null;
    String str2 = null;
    reader = paramReader;
    line = 1;
    column = 0;
    type = 0;
    name = null;
    namespace = null;
    degenerated = false;
    int i = -1;
    attributeCount = i;
    encoding = null;
    version = null;
    standalone = null;
    if (paramReader == null) {}
    for (;;)
    {
      return;
      srcPos = 0;
      srcCount = 0;
      peekCount = 0;
      depth = 0;
      Hashtable localHashtable = new java/util/Hashtable;
      localHashtable.<init>();
      entityMap = localHashtable;
      entityMap.put("amp", "&");
      entityMap.put("apos", "'");
      entityMap.put("gt", ">");
      entityMap.put("lt", "<");
      localHashtable = entityMap;
      str2 = "quot";
      str1 = "\"";
      localHashtable.put(str2, str1);
    }
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    Object localObject = "location";
    boolean bool = isProp(paramString, true, (String)localObject);
    if (bool)
    {
      location = paramObject;
      return;
    }
    XmlPullParserException localXmlPullParserException = new org/xmlpull/v1/XmlPullParserException;
    localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    localObject = "unsupported property: " + paramString;
    localXmlPullParserException.<init>((String)localObject);
    throw localXmlPullParserException;
  }
  
  public void skipSubTree()
  {
    int i = 0;
    int j = 2;
    require(j, null, null);
    int k = 1;
    while (k > 0)
    {
      int m = next();
      i = 3;
      if (m == i) {
        k += -1;
      } else if (m == j) {
        k += 1;
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kxml2/io/KXmlParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */