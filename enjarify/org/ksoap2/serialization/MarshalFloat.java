package org.ksoap2.serialization;

import java.math.BigDecimal;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class MarshalFloat
  implements Marshal
{
  static Class class$java$lang$Double;
  static Class class$java$lang$Float;
  static Class class$java$math$BigDecimal;
  
  static Class class$(String paramString)
  {
    try
    {
      return Class.forName(paramString);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      NoClassDefFoundError localNoClassDefFoundError = new java/lang/NoClassDefFoundError;
      String str = localClassNotFoundException.getMessage();
      localNoClassDefFoundError.<init>(str);
      throw localNoClassDefFoundError;
    }
  }
  
  public Object readInstance(XmlPullParser paramXmlPullParser, String paramString1, String paramString2, PropertyInfo paramPropertyInfo)
  {
    String str = paramXmlPullParser.nextText();
    Object localObject1 = "float";
    boolean bool = paramString2.equals(localObject1);
    Object localObject2;
    if (bool)
    {
      localObject2 = new java/lang/Float;
      ((Float)localObject2).<init>(str);
    }
    for (;;)
    {
      return localObject2;
      localObject1 = "double";
      bool = paramString2.equals(localObject1);
      if (bool)
      {
        localObject2 = new java/lang/Double;
        ((Double)localObject2).<init>(str);
      }
      else
      {
        localObject1 = "decimal";
        bool = paramString2.equals(localObject1);
        if (!bool) {
          break;
        }
        localObject2 = new java/math/BigDecimal;
        ((BigDecimal)localObject2).<init>(str);
      }
    }
    localObject1 = new java/lang/RuntimeException;
    ((RuntimeException)localObject1).<init>("float, double, or decimal expected");
    throw ((Throwable)localObject1);
  }
  
  public void register(SoapSerializationEnvelope paramSoapSerializationEnvelope)
  {
    String str1 = xsd;
    String str2 = "float";
    Class localClass = class$java$lang$Float;
    if (localClass == null)
    {
      localClass = class$("java.lang.Float");
      class$java$lang$Float = localClass;
      paramSoapSerializationEnvelope.addMapping(str1, str2, localClass, this);
      str1 = xsd;
      str2 = "double";
      localClass = class$java$lang$Double;
      if (localClass != null) {
        break label126;
      }
      localClass = class$("java.lang.Double");
      class$java$lang$Double = localClass;
      label69:
      paramSoapSerializationEnvelope.addMapping(str1, str2, localClass, this);
      str1 = xsd;
      str2 = "decimal";
      localClass = class$java$math$BigDecimal;
      if (localClass != null) {
        break label134;
      }
      localClass = class$("java.math.BigDecimal");
      class$java$math$BigDecimal = localClass;
    }
    for (;;)
    {
      paramSoapSerializationEnvelope.addMapping(str1, str2, localClass, this);
      return;
      localClass = class$java$lang$Float;
      break;
      label126:
      localClass = class$java$lang$Double;
      break label69;
      label134:
      localClass = class$java$math$BigDecimal;
    }
  }
  
  public void writeInstance(XmlSerializer paramXmlSerializer, Object paramObject)
  {
    String str = paramObject.toString();
    paramXmlSerializer.text(str);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/MarshalFloat.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */