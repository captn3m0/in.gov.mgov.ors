package org.ksoap2.serialization;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public abstract interface Marshal
{
  public abstract Object readInstance(XmlPullParser paramXmlPullParser, String paramString1, String paramString2, PropertyInfo paramPropertyInfo);
  
  public abstract void register(SoapSerializationEnvelope paramSoapSerializationEnvelope);
  
  public abstract void writeInstance(XmlSerializer paramXmlSerializer, Object paramObject);
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/Marshal.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */