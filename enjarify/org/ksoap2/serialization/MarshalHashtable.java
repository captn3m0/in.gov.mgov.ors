package org.ksoap2.serialization;

import java.util.Enumeration;
import java.util.Hashtable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class MarshalHashtable
  implements Marshal
{
  public static final Class HASHTABLE_CLASS;
  public static final String NAME = "Map";
  public static final String NAMESPACE = "http://xml.apache.org/xml-soap";
  SoapSerializationEnvelope envelope;
  
  static
  {
    Hashtable localHashtable = new java/util/Hashtable;
    localHashtable.<init>();
    HASHTABLE_CLASS = localHashtable.getClass();
  }
  
  public Object readInstance(XmlPullParser paramXmlPullParser, String paramString1, String paramString2, PropertyInfo paramPropertyInfo)
  {
    Hashtable localHashtable = new java/util/Hashtable;
    localHashtable.<init>();
    String str1 = paramXmlPullParser.getName();
    for (;;)
    {
      int i = paramXmlPullParser.nextTag();
      int j = 3;
      if (i == j) {
        break;
      }
      MarshalHashtable.ItemSoapObject localItemSoapObject = new org/ksoap2/serialization/MarshalHashtable$ItemSoapObject;
      localItemSoapObject.<init>(this, localHashtable);
      i = 2;
      j = 0;
      paramXmlPullParser.require(i, null, "item");
      paramXmlPullParser.nextTag();
      SoapSerializationEnvelope localSoapSerializationEnvelope = envelope;
      int k = 0;
      String str2 = null;
      PropertyInfo localPropertyInfo = PropertyInfo.OBJECT_TYPE;
      Object localObject1 = localSoapSerializationEnvelope.read(paramXmlPullParser, localItemSoapObject, 0, null, null, localPropertyInfo);
      paramXmlPullParser.nextTag();
      if (localObject1 != null)
      {
        i = 0;
        localSoapSerializationEnvelope = null;
        localItemSoapObject.setProperty(0, localObject1);
      }
      localSoapSerializationEnvelope = envelope;
      k = 1;
      localPropertyInfo = PropertyInfo.OBJECT_TYPE;
      Object localObject2 = localSoapSerializationEnvelope.read(paramXmlPullParser, localItemSoapObject, k, null, null, localPropertyInfo);
      paramXmlPullParser.nextTag();
      if (localObject2 != null)
      {
        i = 1;
        localItemSoapObject.setProperty(i, localObject2);
      }
      i = 3;
      j = 0;
      str2 = "item";
      paramXmlPullParser.require(i, null, str2);
    }
    paramXmlPullParser.require(3, null, str1);
    return localHashtable;
  }
  
  public void register(SoapSerializationEnvelope paramSoapSerializationEnvelope)
  {
    envelope = paramSoapSerializationEnvelope;
    Class localClass = HASHTABLE_CLASS;
    paramSoapSerializationEnvelope.addMapping("http://xml.apache.org/xml-soap", "Map", localClass, this);
  }
  
  public void writeInstance(XmlSerializer paramXmlSerializer, Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = paramObject;
    localObject2 = (Hashtable)paramObject;
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localSoapObject.<init>(null, null);
    localSoapObject.addProperty("key", null);
    String str = "value";
    localSoapObject.addProperty(str, null);
    Enumeration localEnumeration = ((Hashtable)localObject2).keys();
    for (;;)
    {
      int i = localEnumeration.hasMoreElements();
      if (i == 0) {
        break;
      }
      paramXmlSerializer.startTag("", "item");
      Object localObject3 = localEnumeration.nextElement();
      localSoapObject.setProperty(0, localObject3);
      i = 1;
      localObject1 = ((Hashtable)localObject2).get(localObject3);
      localSoapObject.setProperty(i, localObject1);
      envelope.writeObjectBody(paramXmlSerializer, localSoapObject);
      str = "";
      localObject1 = "item";
      paramXmlSerializer.endTag(str, (String)localObject1);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/MarshalHashtable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */