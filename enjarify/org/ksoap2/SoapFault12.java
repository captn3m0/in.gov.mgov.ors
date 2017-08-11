package org.ksoap2;

import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;
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
  {
    int i = 3;
    int j = 2;
    Object localObject1 = "http://www.w3.org/2003/05/soap-envelope";
    Object localObject2 = "Fault";
    paramXmlPullParser.require(j, (String)localObject1, (String)localObject2);
    int k = paramXmlPullParser.nextTag();
    if (k == j)
    {
      String str = paramXmlPullParser.getName();
      paramXmlPullParser.nextTag();
      localObject1 = "Code";
      boolean bool = str.equals(localObject1);
      if (bool)
      {
        localObject1 = new org/kxml2/kdom/Node;
        ((Node)localObject1).<init>();
        Code = ((Node)localObject1);
        localObject1 = Code;
        ((Node)localObject1).parse(paramXmlPullParser);
      }
      for (;;)
      {
        localObject1 = "http://www.w3.org/2003/05/soap-envelope";
        paramXmlPullParser.require(i, (String)localObject1, str);
        break;
        localObject1 = "Reason";
        bool = str.equals(localObject1);
        if (bool)
        {
          localObject1 = new org/kxml2/kdom/Node;
          ((Node)localObject1).<init>();
          Reason = ((Node)localObject1);
          localObject1 = Reason;
          ((Node)localObject1).parse(paramXmlPullParser);
        }
        else
        {
          localObject1 = "Node";
          bool = str.equals(localObject1);
          if (bool)
          {
            localObject1 = new org/kxml2/kdom/Node;
            ((Node)localObject1).<init>();
            Node = ((Node)localObject1);
            localObject1 = Node;
            ((Node)localObject1).parse(paramXmlPullParser);
          }
          else
          {
            localObject1 = "Role";
            bool = str.equals(localObject1);
            if (bool)
            {
              localObject1 = new org/kxml2/kdom/Node;
              ((Node)localObject1).<init>();
              Role = ((Node)localObject1);
              localObject1 = Role;
              ((Node)localObject1).parse(paramXmlPullParser);
            }
            else
            {
              localObject1 = "Detail";
              bool = str.equals(localObject1);
              if (!bool) {
                break label312;
              }
              localObject1 = new org/kxml2/kdom/Node;
              ((Node)localObject1).<init>();
              Detail = ((Node)localObject1);
              localObject1 = Detail;
              ((Node)localObject1).parse(paramXmlPullParser);
            }
          }
        }
      }
      label312:
      localObject1 = new java/lang/RuntimeException;
      localObject2 = new java/lang/StringBuffer;
      ((StringBuffer)localObject2).<init>();
      localObject2 = "unexpected tag:" + str;
      ((RuntimeException)localObject1).<init>((String)localObject2);
      throw ((Throwable)localObject1);
    }
    paramXmlPullParser.require(i, "http://www.w3.org/2003/05/soap-envelope", "Fault");
    paramXmlPullParser.nextTag();
  }
  
  public String getMessage()
  {
    return Reason.getElement("http://www.w3.org/2003/05/soap-envelope", "Text").getText(0);
  }
  
  public void parse(XmlPullParser paramXmlPullParser)
  {
    parseSelf(paramXmlPullParser);
    Object localObject = Code.getElement("http://www.w3.org/2003/05/soap-envelope", "Value").getText(0);
    faultcode = ((String)localObject);
    localObject = Reason.getElement("http://www.w3.org/2003/05/soap-envelope", "Text").getText(0);
    faultstring = ((String)localObject);
    localObject = Detail;
    detail = ((Node)localObject);
    faultactor = null;
  }
  
  public String toString()
  {
    String str1 = Reason.getElement("http://www.w3.org/2003/05/soap-envelope", "Text").getText(0);
    String str2 = Code.getElement("http://www.w3.org/2003/05/soap-envelope", "Value").getText(0);
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    return "Code: " + str2 + ", Reason: " + str1;
  }
  
  public void write(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Fault");
    paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Code");
    Code.write(paramXmlSerializer);
    paramXmlSerializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Code");
    paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Reason");
    Reason.write(paramXmlSerializer);
    String str = "Reason";
    paramXmlSerializer.endTag("http://www.w3.org/2003/05/soap-envelope", str);
    Object localObject = Node;
    if (localObject != null)
    {
      paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Node");
      Node.write(paramXmlSerializer);
      localObject = "http://www.w3.org/2003/05/soap-envelope";
      str = "Node";
      paramXmlSerializer.endTag((String)localObject, str);
    }
    localObject = Role;
    if (localObject != null)
    {
      paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Role");
      Role.write(paramXmlSerializer);
      localObject = "http://www.w3.org/2003/05/soap-envelope";
      str = "Role";
      paramXmlSerializer.endTag((String)localObject, str);
    }
    localObject = Detail;
    if (localObject != null)
    {
      paramXmlSerializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Detail");
      Detail.write(paramXmlSerializer);
      localObject = "http://www.w3.org/2003/05/soap-envelope";
      str = "Detail";
      paramXmlSerializer.endTag((String)localObject, str);
    }
    paramXmlSerializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Fault");
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/SoapFault12.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */