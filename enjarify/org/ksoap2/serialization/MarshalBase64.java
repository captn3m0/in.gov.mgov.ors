package org.ksoap2.serialization;

import org.kobjects.base64.Base64;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class MarshalBase64
  implements Marshal
{
  public static Class BYTE_ARRAY_CLASS = new byte[0].getClass();
  
  public Object readInstance(XmlPullParser paramXmlPullParser, String paramString1, String paramString2, PropertyInfo paramPropertyInfo)
  {
    return Base64.decode(paramXmlPullParser.nextText());
  }
  
  public void register(SoapSerializationEnvelope paramSoapSerializationEnvelope)
  {
    String str = xsd;
    Class localClass = BYTE_ARRAY_CLASS;
    paramSoapSerializationEnvelope.addMapping(str, "base64Binary", localClass, this);
    localClass = BYTE_ARRAY_CLASS;
    paramSoapSerializationEnvelope.addMapping("http://schemas.xmlsoap.org/soap/encoding/", "base64", localClass, this);
  }
  
  public void writeInstance(XmlSerializer paramXmlSerializer, Object paramObject)
  {
    String str = Base64.encode((byte[])paramObject);
    paramXmlSerializer.text(str);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/MarshalBase64.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */