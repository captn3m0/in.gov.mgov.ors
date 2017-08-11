package org.ksoap2.serialization;

import org.ksoap2.SoapEnvelope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

class DM
  implements Marshal
{
  public Object readInstance(XmlPullParser paramXmlPullParser, String paramString1, String paramString2, PropertyInfo paramPropertyInfo)
  {
    Object localObject1 = paramXmlPullParser.nextText();
    Object localObject2 = null;
    int i = paramString2.charAt(0);
    switch (i)
    {
    default: 
      localObject2 = new java/lang/RuntimeException;
      ((RuntimeException)localObject2).<init>();
      throw ((Throwable)localObject2);
    case 105: 
      localObject2 = new java/lang/Integer;
      int j = Integer.parseInt((String)localObject1);
      ((Integer)localObject2).<init>(j);
      localObject1 = localObject2;
    }
    for (;;)
    {
      return localObject1;
      localObject2 = new java/lang/Long;
      long l = Long.parseLong((String)localObject1);
      ((Long)localObject2).<init>(l);
      localObject1 = localObject2;
      continue;
      localObject2 = new java/lang/Boolean;
      boolean bool = SoapEnvelope.stringToBoolean((String)localObject1);
      ((Boolean)localObject2).<init>(bool);
      localObject1 = localObject2;
    }
  }
  
  public void register(SoapSerializationEnvelope paramSoapSerializationEnvelope)
  {
    String str = xsd;
    Class localClass = PropertyInfo.INTEGER_CLASS;
    paramSoapSerializationEnvelope.addMapping(str, "int", localClass, this);
    str = xsd;
    localClass = PropertyInfo.LONG_CLASS;
    paramSoapSerializationEnvelope.addMapping(str, "long", localClass, this);
    str = xsd;
    localClass = PropertyInfo.STRING_CLASS;
    paramSoapSerializationEnvelope.addMapping(str, "string", localClass, this);
    str = xsd;
    localClass = PropertyInfo.BOOLEAN_CLASS;
    paramSoapSerializationEnvelope.addMapping(str, "boolean", localClass, this);
  }
  
  public void writeInstance(XmlSerializer paramXmlSerializer, Object paramObject)
  {
    boolean bool = paramObject instanceof AttributeContainer;
    if (bool)
    {
      Object localObject = paramObject;
      localObject = (AttributeContainer)paramObject;
      int i = ((AttributeContainer)localObject).getAttributeCount();
      int j = 0;
      while (j < i)
      {
        AttributeInfo localAttributeInfo = new org/ksoap2/serialization/AttributeInfo;
        localAttributeInfo.<init>();
        ((AttributeContainer)localObject).getAttributeInfo(j, localAttributeInfo);
        str1 = localAttributeInfo.getNamespace();
        String str2 = localAttributeInfo.getName();
        String str3 = localAttributeInfo.getValue().toString();
        paramXmlSerializer.attribute(str1, str2, str3);
        j += 1;
      }
    }
    String str1 = paramObject.toString();
    paramXmlSerializer.text(str1);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/DM.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */