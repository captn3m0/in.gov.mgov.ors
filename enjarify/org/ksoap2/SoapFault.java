package org.ksoap2;

import java.io.IOException;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;
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
  {
    int i = 3;
    int j = 2;
    Object localObject1 = "http://schemas.xmlsoap.org/soap/envelope/";
    Object localObject2 = "Fault";
    paramXmlPullParser.require(j, (String)localObject1, (String)localObject2);
    String str;
    do
    {
      do
      {
        int k = paramXmlPullParser.nextTag();
        if (k != j) {
          break;
        }
        str = paramXmlPullParser.getName();
        localObject1 = "detail";
        bool = str.equals(localObject1);
        if (!bool) {
          break label158;
        }
        localObject1 = new org/kxml2/kdom/Node;
        ((Node)localObject1).<init>();
        detail = ((Node)localObject1);
        detail.parse(paramXmlPullParser);
        localObject1 = paramXmlPullParser.getNamespace();
        localObject2 = "http://schemas.xmlsoap.org/soap/envelope/";
        bool = ((String)localObject1).equals(localObject2);
      } while (!bool);
      localObject1 = paramXmlPullParser.getName();
      localObject2 = "Fault";
      bool = ((String)localObject1).equals(localObject2);
    } while (!bool);
    paramXmlPullParser.require(i, "http://schemas.xmlsoap.org/soap/envelope/", "Fault");
    paramXmlPullParser.nextTag();
    return;
    label158:
    localObject1 = "faultcode";
    boolean bool = str.equals(localObject1);
    if (bool)
    {
      localObject1 = paramXmlPullParser.nextText();
      faultcode = ((String)localObject1);
    }
    for (;;)
    {
      bool = false;
      localObject1 = null;
      paramXmlPullParser.require(i, null, str);
      break;
      localObject1 = "faultstring";
      bool = str.equals(localObject1);
      if (bool)
      {
        localObject1 = paramXmlPullParser.nextText();
        faultstring = ((String)localObject1);
      }
      else
      {
        localObject1 = "faultactor";
        bool = str.equals(localObject1);
        if (!bool) {
          break label279;
        }
        localObject1 = paramXmlPullParser.nextText();
        faultactor = ((String)localObject1);
      }
    }
    label279:
    localObject1 = new java/lang/RuntimeException;
    localObject2 = new java/lang/StringBuffer;
    ((StringBuffer)localObject2).<init>();
    localObject2 = "unexpected tag:" + str;
    ((RuntimeException)localObject1).<init>((String)localObject2);
    throw ((Throwable)localObject1);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    localStringBuffer = localStringBuffer.append("SoapFault - faultcode: '");
    Object localObject = faultcode;
    localStringBuffer = localStringBuffer.append((String)localObject).append("' faultstring: '");
    localObject = faultstring;
    localStringBuffer = localStringBuffer.append((String)localObject).append("' faultactor: '");
    localObject = faultactor;
    localStringBuffer = localStringBuffer.append((String)localObject).append("' detail: ");
    localObject = detail;
    return (String)localObject;
  }
  
  public void write(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Fault");
    paramXmlSerializer.startTag(null, "faultcode");
    Object localObject = new java/lang/StringBuffer;
    ((StringBuffer)localObject).<init>();
    localObject = ((StringBuffer)localObject).append("");
    String str = faultcode;
    localObject = str;
    paramXmlSerializer.text((String)localObject);
    paramXmlSerializer.endTag(null, "faultcode");
    paramXmlSerializer.startTag(null, "faultstring");
    localObject = new java/lang/StringBuffer;
    ((StringBuffer)localObject).<init>();
    localObject = ((StringBuffer)localObject).append("");
    str = faultstring;
    localObject = str;
    paramXmlSerializer.text((String)localObject);
    paramXmlSerializer.endTag(null, "faultstring");
    paramXmlSerializer.startTag(null, "detail");
    localObject = detail;
    if (localObject != null)
    {
      localObject = detail;
      ((Node)localObject).write(paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, "detail");
    paramXmlSerializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Fault");
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/SoapFault.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */