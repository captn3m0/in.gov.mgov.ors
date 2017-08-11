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
    throws IOException
  {
    parser.getType();
    int j = parser.next();
    int i = j;
    if (j == 4)
    {
      i = j;
      if (parser.isWhitespace()) {
        i = parser.next();
      }
    }
    if ((i != 3) && (i != 2)) {
      throw new IOException("unexpected type: " + i);
    }
    return i;
  }
  
  private final String nextText()
    throws IOException
  {
    if (parser.getType() != 2) {
      throw new IOException("precondition: START_TAG");
    }
    int i = parser.next();
    String str;
    if (i == 4)
    {
      str = parser.getText();
      i = parser.next();
    }
    while (i != 3)
    {
      throw new IOException("END_TAG expected");
      str = "";
    }
    return str;
  }
  
  private final Vector parseArray()
    throws IOException
  {
    nextTag();
    int i = nextTag();
    Vector localVector = new Vector();
    while (i != 3)
    {
      localVector.addElement(parseValue());
      i = parser.getType();
    }
    nextTag();
    nextTag();
    return localVector;
  }
  
  private final Object parseFault()
    throws IOException
  {
    nextTag();
    Object localObject = parseValue();
    nextTag();
    return localObject;
  }
  
  private final Object parseParams()
    throws IOException
  {
    Vector localVector = new Vector();
    for (int i = nextTag(); i != 3; i = nextTag())
    {
      nextTag();
      localVector.addElement(parseValue());
    }
    nextTag();
    return localVector;
  }
  
  private final Hashtable parseStruct()
    throws IOException
  {
    Hashtable localHashtable = new Hashtable();
    for (int i = nextTag(); i != 3; i = nextTag())
    {
      nextTag();
      String str = nextText();
      nextTag();
      localHashtable.put(str, parseValue());
    }
    nextTag();
    return localHashtable;
  }
  
  private final Object parseValue()
    throws IOException
  {
    Object localObject1 = null;
    int j = parser.next();
    int i = j;
    if (j == 4)
    {
      localObject1 = parser.getText();
      i = parser.next();
    }
    Object localObject2 = localObject1;
    if (i == 2)
    {
      localObject2 = parser.getName();
      if (!((String)localObject2).equals("array")) {
        break label74;
      }
    }
    for (localObject2 = parseArray();; localObject2 = parseStruct())
    {
      nextTag();
      return localObject2;
      label74:
      if (!((String)localObject2).equals("struct")) {
        break;
      }
    }
    if (((String)localObject2).equals("string")) {
      localObject1 = nextText();
    }
    for (;;)
    {
      nextTag();
      localObject2 = localObject1;
      break;
      if ((((String)localObject2).equals("i4")) || (((String)localObject2).equals("int"))) {
        localObject1 = new Integer(Integer.parseInt(nextText().trim()));
      } else if (((String)localObject2).equals("boolean")) {
        localObject1 = new Boolean(nextText().trim().equals("1"));
      } else if (((String)localObject2).equals("dateTime.iso8601")) {
        localObject1 = IsoDate.stringToDate(nextText(), 3);
      } else if (((String)localObject2).equals("base64")) {
        localObject1 = Base64.decode(nextText());
      } else if (((String)localObject2).equals("double")) {
        localObject1 = nextText();
      }
    }
  }
  
  public final Object parseResponse()
    throws IOException
  {
    Object localObject2 = null;
    nextTag();
    Object localObject1 = localObject2;
    if (nextTag() == 2)
    {
      if (!"fault".equals(parser.getName())) {
        break label39;
      }
      localObject1 = parseFault();
    }
    label39:
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (!"params".equals(parser.getName()));
    return parseParams();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kobjects/xmlrpc/XmlRpcParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */