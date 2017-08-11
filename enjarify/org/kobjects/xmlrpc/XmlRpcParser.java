package org.kobjects.xmlrpc;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.kobjects.base64.Base64;
import org.kobjects.isodate.IsoDate;
import org.kobjects.xml.XmlReader;

public class XmlRpcParser
{
  private XmlReader parser = null;
  
  public XmlRpcParser(XmlReader paramXmlReader)
  {
    parser = paramXmlReader;
  }
  
  private final int nextTag()
  {
    int i = parser.getType();
    Object localObject1 = parser;
    i = ((XmlReader)localObject1).next();
    int j = 4;
    if (i == j)
    {
      localObject1 = parser;
      boolean bool = ((XmlReader)localObject1).isWhitespace();
      if (bool)
      {
        localObject1 = parser;
        i = ((XmlReader)localObject1).next();
      }
    }
    int k = 3;
    if (i != k)
    {
      k = 2;
      if (i != k)
      {
        localObject1 = new java/io/IOException;
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject2 = "unexpected type: " + i;
        ((IOException)localObject1).<init>((String)localObject2);
        throw ((Throwable)localObject1);
      }
    }
    return i;
  }
  
  private final String nextText()
  {
    Object localObject = parser;
    int i = ((XmlReader)localObject).getType();
    int j = 2;
    if (i != j)
    {
      localObject = new java/io/IOException;
      ((IOException)localObject).<init>("precondition: START_TAG");
      throw ((Throwable)localObject);
    }
    localObject = parser;
    i = ((XmlReader)localObject).next();
    j = 4;
    String str;
    if (i == j)
    {
      str = parser.getText();
      localObject = parser;
      i = ((XmlReader)localObject).next();
    }
    for (;;)
    {
      j = 3;
      if (i == j) {
        break;
      }
      localObject = new java/io/IOException;
      ((IOException)localObject).<init>("END_TAG expected");
      throw ((Throwable)localObject);
      str = "";
    }
    return str;
  }
  
  private final Vector parseArray()
  {
    nextTag();
    int i = nextTag();
    Vector localVector = new java/util/Vector;
    localVector.<init>();
    for (;;)
    {
      int j = 3;
      if (i == j) {
        break;
      }
      Object localObject = parseValue();
      localVector.addElement(localObject);
      localObject = parser;
      i = ((XmlReader)localObject).getType();
    }
    nextTag();
    nextTag();
    return localVector;
  }
  
  private final Object parseFault()
  {
    nextTag();
    Object localObject = parseValue();
    nextTag();
    return localObject;
  }
  
  private final Object parseParams()
  {
    Vector localVector = new java/util/Vector;
    localVector.<init>();
    for (int i = nextTag();; i = nextTag())
    {
      int j = 3;
      if (i == j) {
        break;
      }
      nextTag();
      Object localObject = parseValue();
      localVector.addElement(localObject);
    }
    nextTag();
    return localVector;
  }
  
  private final Hashtable parseStruct()
  {
    Hashtable localHashtable = new java/util/Hashtable;
    localHashtable.<init>();
    for (int i = nextTag();; i = nextTag())
    {
      int j = 3;
      if (i == j) {
        break;
      }
      nextTag();
      String str = nextText();
      nextTag();
      Object localObject = parseValue();
      localHashtable.put(str, localObject);
    }
    nextTag();
    return localHashtable;
  }
  
  private final Object parseValue()
  {
    Object localObject1 = null;
    Object localObject2 = parser;
    int i = ((XmlReader)localObject2).next();
    int j = 4;
    if (i == j)
    {
      localObject1 = parser.getText();
      localObject2 = parser;
      i = ((XmlReader)localObject2).next();
    }
    j = 2;
    String str1;
    if (i == j)
    {
      str1 = parser.getName();
      localObject2 = "array";
      bool1 = str1.equals(localObject2);
      if (!bool1) {
        break label85;
      }
    }
    for (localObject1 = parseArray();; localObject1 = parseStruct())
    {
      nextTag();
      return localObject1;
      label85:
      localObject2 = "struct";
      bool1 = str1.equals(localObject2);
      if (!bool1) {
        break;
      }
    }
    localObject2 = "string";
    boolean bool1 = str1.equals(localObject2);
    if (bool1) {
      localObject1 = nextText();
    }
    for (;;)
    {
      nextTag();
      break;
      localObject2 = "i4";
      bool1 = str1.equals(localObject2);
      if (!bool1)
      {
        localObject2 = "int";
        bool1 = str1.equals(localObject2);
        if (!bool1) {}
      }
      else
      {
        localObject1 = new java/lang/Integer;
        localObject2 = nextText().trim();
        int k = Integer.parseInt((String)localObject2);
        ((Integer)localObject1).<init>(k);
        continue;
      }
      localObject2 = "boolean";
      boolean bool2 = str1.equals(localObject2);
      if (bool2)
      {
        localObject1 = new java/lang/Boolean;
        localObject2 = nextText().trim();
        String str2 = "1";
        bool2 = ((String)localObject2).equals(str2);
        ((Boolean)localObject1).<init>(bool2);
      }
      else
      {
        localObject2 = "dateTime.iso8601";
        bool2 = str1.equals(localObject2);
        if (bool2)
        {
          localObject2 = nextText();
          int m = 3;
          localObject1 = IsoDate.stringToDate((String)localObject2, m);
        }
        else
        {
          localObject2 = "base64";
          bool2 = str1.equals(localObject2);
          if (bool2)
          {
            localObject2 = nextText();
            localObject1 = Base64.decode((String)localObject2);
          }
          else
          {
            localObject2 = "double";
            bool2 = str1.equals(localObject2);
            if (bool2) {
              localObject1 = nextText();
            }
          }
        }
      }
    }
  }
  
  public final Object parseResponse()
  {
    Object localObject = null;
    nextTag();
    int i = nextTag();
    int j = 2;
    String str1;
    String str2;
    boolean bool;
    if (i == j)
    {
      str1 = "fault";
      str2 = parser.getName();
      bool = str1.equals(str2);
      if (!bool) {
        break label51;
      }
      localObject = parseFault();
    }
    for (;;)
    {
      return localObject;
      label51:
      str1 = "params";
      str2 = parser.getName();
      bool = str1.equals(str2);
      if (bool) {
        localObject = parseParams();
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/xmlrpc/XmlRpcParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */