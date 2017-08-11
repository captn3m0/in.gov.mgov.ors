package org.ksoap2;

import java.io.IOException;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class SoapFault
  extends IOException
{
  private static final long serialVersionUID = 1011001L;
  public Node detail;
  public String faultactor;
  public String faultcode;
  public String faultstring;
  public int version;
  
  public SoapFault()
  {
    version = 110;
  }
  
  public SoapFault(int paramInt)
  {
    version = paramInt;
  }
  
  public String getMessage()
  {
    return faultstring;
  }
  
  public void parse(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    paramXmlPullParser.require(2, "http://schemas.xmlsoap.org/soap/envelope/", "Fault");
    String str;
    do
    {
      if (paramXmlPullParser.nextTag() != 2) {
        break;
      }
      str = paramXmlPullParser.getName();
      if (!str.equals("detail")) {
        break label103;
      }
      detail = new Node();
      detail.parse(paramXmlPullParser);
    } while ((!paramXmlPullParser.getNamespace().equals("http://schemas.xmlsoap.org/soap/envelope/")) || (!paramXmlPullParser.getName().equals("Fault")));
    paramXmlPullParser.require(3, "http://schemas.xmlsoap.org/soap/envelope/", "Fault");
    paramXmlPullParser.nextTag();
    return;
    label103:
    if (str.equals("faultcode")) {
      faultcode = paramXmlPullParser.nextText();
    }
    for (;;)
    {
      paramXmlPullParser.require(3, null, str);
      break;
      if (str.equals("faultstring"))
      {
        faultstring = paramXmlPullParser.nextText();
      }
      else
      {
        if (!str.equals("faultactor")) {
          break label178;
        }
        faultactor = paramXmlPullParser.nextText();
      }
    }
    label178:
    throw new RuntimeException("unexpected tag:" + str);
  }
  
  public String toString()
  {
    return "SoapFault - faultcode: '" + faultcode + "' faultstring: '" + faultstring + "' faultactor: '" + faultactor + "' detail: " + detail;
  }
  
  public void write(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Fault");
    paramXmlSerializer.startTag(null, "faultcode");
    paramXmlSerializer.text("" + faultcode);
    paramXmlSerializer.endTag(null, "faultcode");
    paramXmlSerializer.startTag(null, "faultstring");
    paramXmlSerializer.text("" + faultstring);
    paramXmlSerializer.endTag(null, "faultstring");
    paramXmlSerializer.startTag(null, "detail");
    if (detail != null) {
      detail.write(paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, "detail");
    paramXmlSerializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Fault");
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/ksoap2/SoapFault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */