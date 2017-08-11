package org.ksoap2.serialization;

import java.util.Date;
import org.kobjects.isodate.IsoDate;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class MarshalDate
  implements Marshal
{
  public static Class DATE_CLASS;
  
  static
  {
    Date localDate = new java/util/Date;
    localDate.<init>();
    DATE_CLASS = localDate.getClass();
  }
  
  public Object readInstance(XmlPullParser paramXmlPullParser, String paramString1, String paramString2, PropertyInfo paramPropertyInfo)
  {
    return IsoDate.stringToDate(paramXmlPullParser.nextText(), 3);
  }
  
  public void register(SoapSerializationEnvelope paramSoapSerializationEnvelope)
  {
    String str = xsd;
    Class localClass = DATE_CLASS;
    paramSoapSerializationEnvelope.addMapping(str, "dateTime", localClass, this);
  }
  
  public void writeInstance(XmlSerializer paramXmlSerializer, Object paramObject)
  {
    String str = IsoDate.dateToString((Date)paramObject, 3);
    paramXmlSerializer.text(str);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/MarshalDate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */