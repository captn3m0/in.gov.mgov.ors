package org.ksoap2;

import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class SoapEnvelope
{
  public static final String ENC = "http://schemas.xmlsoap.org/soap/encoding/";
  public static final String ENC2003 = "http://www.w3.org/2003/05/soap-encoding";
  public static final String ENV = "http://schemas.xmlsoap.org/soap/envelope/";
  public static final String ENV2003 = "http://www.w3.org/2003/05/soap-envelope";
  public static final int VER10 = 100;
  public static final int VER11 = 110;
  public static final int VER12 = 120;
  public static final String XSD = "http://www.w3.org/2001/XMLSchema";
  public static final String XSD1999 = "http://www.w3.org/1999/XMLSchema";
  public static final String XSI = "http://www.w3.org/2001/XMLSchema-instance";
  public static final String XSI1999 = "http://www.w3.org/1999/XMLSchema-instance";
  public Object bodyIn;
  public Object bodyOut;
  public String enc;
  public String encodingStyle;
  public String env;
  public Element[] headerIn;
  public Element[] headerOut;
  public int version;
  public String xsd;
  public String xsi;
  
  public SoapEnvelope(int paramInt)
  {
    version = paramInt;
    int i = 100;
    String str;
    if (paramInt == i)
    {
      xsi = "http://www.w3.org/1999/XMLSchema-instance";
      str = "http://www.w3.org/1999/XMLSchema";
      xsd = str;
      i = 120;
      if (paramInt >= i) {
        break label71;
      }
      enc = "http://schemas.xmlsoap.org/soap/encoding/";
      str = "http://schemas.xmlsoap.org/soap/envelope/";
    }
    for (env = str;; env = str)
    {
      return;
      xsi = "http://www.w3.org/2001/XMLSchema-instance";
      str = "http://www.w3.org/2001/XMLSchema";
      xsd = str;
      break;
      label71:
      enc = "http://www.w3.org/2003/05/soap-encoding";
      str = "http://www.w3.org/2003/05/soap-envelope";
    }
  }
  
  public static boolean stringToBoolean(String paramString)
  {
    boolean bool1 = false;
    if (paramString == null) {}
    for (;;)
    {
      return bool1;
      paramString = paramString.trim().toLowerCase();
      String str = "1";
      boolean bool2 = paramString.equals(str);
      if (!bool2)
      {
        str = "true";
        bool2 = paramString.equals(str);
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public void parse(XmlPullParser paramXmlPullParser)
  {
    int i = 3;
    int j = 2;
    paramXmlPullParser.nextTag();
    String str1 = env;
    paramXmlPullParser.require(j, str1, "Envelope");
    str1 = env;
    String str2 = "encodingStyle";
    str1 = paramXmlPullParser.getAttributeValue(str1, str2);
    encodingStyle = str1;
    paramXmlPullParser.nextTag();
    int k = paramXmlPullParser.getEventType();
    if (k == j)
    {
      str1 = paramXmlPullParser.getNamespace();
      str2 = env;
      boolean bool = str1.equals(str2);
      if (bool)
      {
        str1 = paramXmlPullParser.getName();
        str2 = "Header";
        bool = str1.equals(str2);
        if (bool)
        {
          parseHeader(paramXmlPullParser);
          str1 = env;
          str2 = "Header";
          paramXmlPullParser.require(i, str1, str2);
          paramXmlPullParser.nextTag();
        }
      }
    }
    str1 = env;
    paramXmlPullParser.require(j, str1, "Body");
    str1 = env;
    str1 = paramXmlPullParser.getAttributeValue(str1, "encodingStyle");
    encodingStyle = str1;
    parseBody(paramXmlPullParser);
    str1 = env;
    paramXmlPullParser.require(i, str1, "Body");
    paramXmlPullParser.nextTag();
    str1 = env;
    paramXmlPullParser.require(i, str1, "Envelope");
  }
  
  public void parseBody(XmlPullParser paramXmlPullParser)
  {
    paramXmlPullParser.nextTag();
    int i = paramXmlPullParser.getEventType();
    int k = 2;
    if (i == k)
    {
      localObject1 = paramXmlPullParser.getNamespace();
      String str = env;
      boolean bool1 = ((String)localObject1).equals(str);
      if (bool1)
      {
        localObject1 = paramXmlPullParser.getName();
        str = "Fault";
        bool1 = ((String)localObject1).equals(str);
        if (bool1)
        {
          int j = version;
          k = 120;
          Object localObject2;
          if (j < k)
          {
            localObject2 = new org/ksoap2/SoapFault;
            j = version;
            ((SoapFault)localObject2).<init>(j);
          }
          for (;;)
          {
            ((SoapFault)localObject2).parse(paramXmlPullParser);
            bodyIn = localObject2;
            return;
            localObject2 = new org/ksoap2/SoapFault12;
            j = version;
            ((SoapFault12)localObject2).<init>(j);
          }
        }
      }
    }
    Object localObject1 = bodyIn;
    boolean bool2 = localObject1 instanceof Node;
    Object localObject3;
    if (bool2)
    {
      localObject1 = (Node)bodyIn;
      localObject3 = localObject1;
    }
    for (;;)
    {
      ((Node)localObject3).parse(paramXmlPullParser);
      bodyIn = localObject3;
      break;
      localObject3 = new org/kxml2/kdom/Node;
      ((Node)localObject3).<init>();
    }
  }
  
  public void parseHeader(XmlPullParser paramXmlPullParser)
  {
    paramXmlPullParser.nextTag();
    Node localNode = new org/kxml2/kdom/Node;
    localNode.<init>();
    localNode.parse(paramXmlPullParser);
    int i = 0;
    int j = 0;
    int k;
    Element localElement;
    for (;;)
    {
      k = localNode.getChildCount();
      if (j >= k) {
        break;
      }
      localElement = localNode.getElement(j);
      if (localElement != null) {
        i += 1;
      }
      j += 1;
    }
    Element[] arrayOfElement = new Element[i];
    headerIn = arrayOfElement;
    i = 0;
    j = 0;
    for (;;)
    {
      k = localNode.getChildCount();
      if (j >= k) {
        break;
      }
      localElement = localNode.getElement(j);
      if (localElement != null)
      {
        arrayOfElement = headerIn;
        int m = i + 1;
        arrayOfElement[i] = localElement;
        i = m;
      }
      j += 1;
    }
  }
  
  public void setOutputSoapObject(Object paramObject)
  {
    bodyOut = paramObject;
  }
  
  public void write(XmlSerializer paramXmlSerializer)
  {
    String str1 = xsi;
    paramXmlSerializer.setPrefix("i", str1);
    str1 = xsd;
    paramXmlSerializer.setPrefix("d", str1);
    str1 = enc;
    paramXmlSerializer.setPrefix("c", str1);
    str1 = env;
    paramXmlSerializer.setPrefix("v", str1);
    String str2 = env;
    paramXmlSerializer.startTag(str2, "Envelope");
    str2 = env;
    paramXmlSerializer.startTag(str2, "Header");
    writeHeader(paramXmlSerializer);
    str2 = env;
    paramXmlSerializer.endTag(str2, "Header");
    str2 = env;
    paramXmlSerializer.startTag(str2, "Body");
    writeBody(paramXmlSerializer);
    str2 = env;
    paramXmlSerializer.endTag(str2, "Body");
    str2 = env;
    paramXmlSerializer.endTag(str2, "Envelope");
  }
  
  public void writeBody(XmlSerializer paramXmlSerializer)
  {
    String str1 = encodingStyle;
    if (str1 != null)
    {
      str1 = env;
      String str2 = "encodingStyle";
      String str3 = encodingStyle;
      paramXmlSerializer.attribute(str1, str2, str3);
    }
    ((Node)bodyOut).write(paramXmlSerializer);
  }
  
  public void writeHeader(XmlSerializer paramXmlSerializer)
  {
    Object localObject = headerOut;
    if (localObject != null)
    {
      int i = 0;
      for (;;)
      {
        localObject = headerOut;
        int j = localObject.length;
        if (i >= j) {
          break;
        }
        localObject = headerOut[i];
        ((Element)localObject).write(paramXmlSerializer);
        i += 1;
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/SoapEnvelope.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */