package org.ksoap2;

import java.io.IOException;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class SoapFault12
  extends SoapFault
{
  private static final long serialVersionUID = 1012001L;
  public Node Code;
  public Node Detail;
  public Node Node;
  public Node Reason;
  public Node Role;
  
  public SoapFault12()
  {
    version = 120;
  }
  
  public SoapFault12(int paramInt)
  {
    version = paramInt;
  }
  
  private void parseSelf(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    paramXmlPullParser.require(2, "http://www.w3.org/2003/05/soap-envelope", "Fault");
    if (paramXmlPullParser.nextTag() == 2)
    {
      String str = paramXmlPullParser.getName();
      paramXmlPullParser.nextTag();
      if (str.equals("Code"))
      {
        Code = new Node();
        Code.parse(paramXmlPullParser);
      }
      for (;;)
      {
        paramXmlPullParser.require(3, "http://www.w3.org/2003/05/soap-envelope", str);
        break;
        if (str.equals("Reason"))
        {
          Reason = new Node();
          Reason.parse(paramXmlPullParser);
        }
        else if (str.equals("Node"))
        {
          Node = new Node();
          Node.parse(paramXmlPullParser);
        }
        else if (str.equals("Role"))
        {
          Role = new Node();
          Role.parse(paramXmlPullParser);
        }
        else
        {
          if (!str.equals("Detail")) {
            break label200;
          }
          Detail = new Node();
          Detail.parse(paramXmlPullParser);
        }
      }
      label200:
      throw new RuntimeException("unexpected tag:" + str);
    }
    paramXmlPullParser.require(3, "http://www.w3.org/2003/05/soap-envelope", "Fault");
    paramXmlPullParser.nextTag();
  }
  
  public String getMessage()
  {
    return Reason.getElement("http://www.w3.org/2003/05/soap-envelope", "Text").getText(0);
  }
  
  public void parse(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    parseSelf(paramXmlPullParser);
    faultcode = Code.getElement("http://www.w3.org/2003/05/soap-envelope", "Value").getText(0);
    faultstring = Reason.getElement("http://www.w3.org/2003/05/soap-envelope", "Text").getText(0);
    detail = Detail;
    faultactor = null;
  }
  
  public String toString()
  {
    String str1 = Reason.getElement("http://www.w3.org/2003/05/soap-envelope", "Text").getText(0);
    String str2 = Code.getElement("http://www.w3.org/2003/05/soap-envelope", "Value").getText(0);
    return "Code: " + str2 + ", Reason: " + str1;
  }
  
  public void write(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Fault");
    paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Code");
    Code.write(paramXmlSerializer);
    paramXmlSerializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Code");
    paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Reason");
    Reason.write(paramXmlSerializer);
    paramXmlSerializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Reason");
    if (Node != null)
    {
      paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Node");
      Node.write(paramXmlSerializer);
      paramXmlSerializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Node");
    }
    if (Role != null)
    {
      paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Role");
      Role.write(paramXmlSerializer);
      paramXmlSerializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Role");
    }
    if (Detail != null)
    {
      paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Detail");
      Detail.write(paramXmlSerializer);
      paramXmlSerializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Detail");
    }
    paramXmlSerializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Fault");
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/ksoap2/SoapFault12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */