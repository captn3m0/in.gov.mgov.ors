package org.ksoap2;

import java.io.IOException;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
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
    if (paramInt == 100) {
      xsi = "http://www.w3.org/1999/XMLSchema-instance";
    }
    for (xsd = "http://www.w3.org/1999/XMLSchema"; paramInt < 120; xsd = "http://www.w3.org/2001/XMLSchema")
    {
      enc = "http://schemas.xmlsoap.org/soap/encoding/";
      env = "http://schemas.xmlsoap.org/soap/envelope/";
      return;
      xsi = "http://www.w3.org/2001/XMLSchema-instance";
    }
    enc = "http://www.w3.org/2003/05/soap-encoding";
    env = "http://www.w3.org/2003/05/soap-envelope";
  }
  
  public static boolean stringToBoolean(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.trim().toLowerCase();
    } while ((!paramString.equals("1")) && (!paramString.equals("true")));
    return true;
  }
  
  public void parse(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    paramXmlPullParser.nextTag();
    paramXmlPullParser.require(2, env, "Envelope");
    encodingStyle = paramXmlPullParser.getAttributeValue(env, "encodingStyle");
    paramXmlPullParser.nextTag();
    if ((paramXmlPullParser.getEventType() == 2) && (paramXmlPullParser.getNamespace().equals(env)) && (paramXmlPullParser.getName().equals("Header")))
    {
      parseHeader(paramXmlPullParser);
      paramXmlPullParser.require(3, env, "Header");
      paramXmlPullParser.nextTag();
    }
    paramXmlPullParser.require(2, env, "Body");
    encodingStyle = paramXmlPullParser.getAttributeValue(env, "encodingStyle");
    parseBody(paramXmlPullParser);
    paramXmlPullParser.require(3, env, "Body");
    paramXmlPullParser.nextTag();
    paramXmlPullParser.require(3, env, "Envelope");
  }
  
  public void parseBody(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    paramXmlPullParser.nextTag();
    if ((paramXmlPullParser.getEventType() == 2) && (paramXmlPullParser.getNamespace().equals(env)) && (paramXmlPullParser.getName().equals("Fault")))
    {
      if (version < 120) {}
      for (localObject = new SoapFault(version);; localObject = new SoapFault12(version))
      {
        ((SoapFault)localObject).parse(paramXmlPullParser);
        bodyIn = localObject;
        return;
      }
    }
    if ((bodyIn instanceof Node)) {}
    for (Object localObject = (Node)bodyIn;; localObject = new Node())
    {
      ((Node)localObject).parse(paramXmlPullParser);
      bodyIn = localObject;
      return;
    }
  }
  
  public void parseHeader(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    paramXmlPullParser.nextTag();
    Node localNode = new Node();
    localNode.parse(paramXmlPullParser);
    int j = 0;
    int i = 0;
    int k;
    while (i < localNode.getChildCount())
    {
      k = j;
      if (localNode.getElement(i) != null) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    headerIn = new Element[j];
    j = 0;
    i = 0;
    while (i < localNode.getChildCount())
    {
      paramXmlPullParser = localNode.getElement(i);
      k = j;
      if (paramXmlPullParser != null)
      {
        headerIn[j] = paramXmlPullParser;
        k = j + 1;
      }
      i += 1;
      j = k;
    }
  }
  
  public void setOutputSoapObject(Object paramObject)
  {
    bodyOut = paramObject;
  }
  
  public void write(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.setPrefix("i", xsi);
    paramXmlSerializer.setPrefix("d", xsd);
    paramXmlSerializer.setPrefix("c", enc);
    paramXmlSerializer.setPrefix("v", env);
    paramXmlSerializer.startTag(env, "Envelope");
    paramXmlSerializer.startTag(env, "Header");
    writeHeader(paramXmlSerializer);
    paramXmlSerializer.endTag(env, "Header");
    paramXmlSerializer.startTag(env, "Body");
    writeBody(paramXmlSerializer);
    paramXmlSerializer.endTag(env, "Body");
    paramXmlSerializer.endTag(env, "Envelope");
  }
  
  public void writeBody(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    if (encodingStyle != null) {
      paramXmlSerializer.attribute(env, "encodingStyle", encodingStyle);
    }
    ((Node)bodyOut).write(paramXmlSerializer);
  }
  
  public void writeHeader(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    if (headerOut != null)
    {
      int i = 0;
      while (i < headerOut.length)
      {
        headerOut[i].write(paramXmlSerializer);
        i += 1;
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/ksoap2/SoapEnvelope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */