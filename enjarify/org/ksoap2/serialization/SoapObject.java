package org.ksoap2.serialization;

import java.util.Hashtable;
import java.util.Vector;

public class SoapObject
  extends AttributeContainer
  implements KvmSerializable
{
  private static final String EMPTY_STRING = "";
  static Class class$java$lang$String;
  static Class class$org$ksoap2$serialization$SoapObject;
  protected String name;
  protected String namespace;
  protected Vector properties;
  
  public SoapObject()
  {
    this("", "");
  }
  
  public SoapObject(String paramString1, String paramString2)
  {
    Vector localVector = new java/util/Vector;
    localVector.<init>();
    properties = localVector;
    namespace = paramString1;
    name = paramString2;
  }
  
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
  
  private Integer propertyIndex(String paramString)
  {
    int i;
    Object localObject;
    boolean bool;
    if (paramString != null)
    {
      i = 0;
      localObject = properties;
      int j = ((Vector)localObject).size();
      if (i < j)
      {
        localObject = ((PropertyInfo)properties.elementAt(i)).getName();
        bool = paramString.equals(localObject);
        if (bool)
        {
          localObject = new java/lang/Integer;
          ((Integer)localObject).<init>(i);
        }
      }
    }
    for (;;)
    {
      return (Integer)localObject;
      i += 1;
      break;
      bool = false;
      localObject = null;
    }
  }
  
  public SoapObject addProperty(String paramString, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    name = paramString;
    if (paramObject == null) {}
    for (Class localClass = PropertyInfo.OBJECT_CLASS;; localClass = paramObject.getClass())
    {
      type = localClass;
      value = paramObject;
      return addProperty(localPropertyInfo);
    }
  }
  
  public SoapObject addProperty(PropertyInfo paramPropertyInfo)
  {
    properties.addElement(paramPropertyInfo);
    return this;
  }
  
  public SoapObject addPropertyIfValue(String paramString, Object paramObject)
  {
    if (paramObject != null) {
      this = addProperty(paramString, paramObject);
    }
    return this;
  }
  
  public SoapObject addPropertyIfValue(PropertyInfo paramPropertyInfo)
  {
    Object localObject = value;
    if (localObject != null)
    {
      localObject = properties;
      ((Vector)localObject).addElement(paramPropertyInfo);
    }
    return this;
  }
  
  public SoapObject addPropertyIfValue(PropertyInfo paramPropertyInfo, Object paramObject)
  {
    if (paramObject != null)
    {
      paramPropertyInfo.setValue(paramObject);
      this = addProperty(paramPropertyInfo);
    }
    return this;
  }
  
  public SoapObject addSoapObject(SoapObject paramSoapObject)
  {
    properties.addElement(paramSoapObject);
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2 = paramObject instanceof SoapObject;
    if (!bool2) {}
    for (;;)
    {
      return bool1;
      Object localObject1 = paramObject;
      localObject1 = (SoapObject)paramObject;
      Object localObject2 = name;
      String str = name;
      bool2 = ((String)localObject2).equals(str);
      if (bool2)
      {
        localObject2 = namespace;
        str = namespace;
        bool2 = ((String)localObject2).equals(str);
        if (bool2)
        {
          int j = properties.size();
          localObject2 = properties;
          int i = ((Vector)localObject2).size();
          if (j == i)
          {
            int k = 0;
            for (;;)
            {
              if (k >= j) {
                break label148;
              }
              localObject2 = properties;
              Object localObject3 = ((Vector)localObject2).elementAt(k);
              boolean bool3 = ((SoapObject)localObject1).isPropertyEqual(localObject3, k);
              if (!bool3) {
                break;
              }
              k += 1;
            }
            label148:
            bool1 = attributesAreEqual((AttributeContainer)localObject1);
          }
        }
      }
    }
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public Object getPrimitiveProperty(String paramString)
  {
    Integer localInteger = propertyIndex(paramString);
    if (localInteger != null)
    {
      localObject1 = properties;
      int i = localInteger.intValue();
      PropertyInfo localPropertyInfo = (PropertyInfo)((Vector)localObject1).elementAt(i);
      localObject2 = localPropertyInfo.getType();
      localObject1 = class$org$ksoap2$serialization$SoapObject;
      if (localObject1 == null)
      {
        localObject1 = class$("org.ksoap2.serialization.SoapObject");
        class$org$ksoap2$serialization$SoapObject = (Class)localObject1;
      }
      while (localObject2 != localObject1)
      {
        localObject1 = localPropertyInfo.getValue();
        return localObject1;
        localObject1 = class$org$ksoap2$serialization$SoapObject;
      }
      localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo.<init>();
      localObject1 = class$java$lang$String;
      if (localObject1 == null)
      {
        localObject1 = class$("java.lang.String");
        class$java$lang$String = (Class)localObject1;
      }
      for (;;)
      {
        localPropertyInfo.setType(localObject1);
        localPropertyInfo.setValue("");
        localPropertyInfo.setName(paramString);
        localObject1 = localPropertyInfo.getValue();
        break;
        localObject1 = class$java$lang$String;
      }
    }
    Object localObject1 = new java/lang/RuntimeException;
    Object localObject2 = new java/lang/StringBuffer;
    ((StringBuffer)localObject2).<init>();
    localObject2 = "illegal property: " + paramString;
    ((RuntimeException)localObject1).<init>((String)localObject2);
    throw ((Throwable)localObject1);
  }
  
  public String getPrimitivePropertyAsString(String paramString)
  {
    Integer localInteger = propertyIndex(paramString);
    if (localInteger != null)
    {
      localObject1 = properties;
      int i = localInteger.intValue();
      PropertyInfo localPropertyInfo = (PropertyInfo)((Vector)localObject1).elementAt(i);
      localObject2 = localPropertyInfo.getType();
      localObject1 = class$org$ksoap2$serialization$SoapObject;
      if (localObject1 == null)
      {
        localObject1 = class$("org.ksoap2.serialization.SoapObject");
        class$org$ksoap2$serialization$SoapObject = (Class)localObject1;
        if (localObject2 == localObject1) {
          break label81;
        }
      }
      label81:
      for (localObject1 = localPropertyInfo.getValue().toString();; localObject1 = "")
      {
        return (String)localObject1;
        localObject1 = class$org$ksoap2$serialization$SoapObject;
        break;
      }
    }
    Object localObject1 = new java/lang/RuntimeException;
    Object localObject2 = new java/lang/StringBuffer;
    ((StringBuffer)localObject2).<init>();
    localObject2 = "illegal property: " + paramString;
    ((RuntimeException)localObject1).<init>((String)localObject2);
    throw ((Throwable)localObject1);
  }
  
  public Object getPrimitivePropertySafely(String paramString)
  {
    Integer localInteger = propertyIndex(paramString);
    Object localObject1;
    PropertyInfo localPropertyInfo;
    if (localInteger != null)
    {
      localObject1 = properties;
      int i = localInteger.intValue();
      localPropertyInfo = (PropertyInfo)((Vector)localObject1).elementAt(i);
      Object localObject2 = localPropertyInfo.getType();
      localObject1 = class$org$ksoap2$serialization$SoapObject;
      if (localObject1 == null)
      {
        localObject1 = class$("org.ksoap2.serialization.SoapObject");
        class$org$ksoap2$serialization$SoapObject = (Class)localObject1;
        if (localObject2 == localObject1) {
          break label81;
        }
        localObject1 = localPropertyInfo.getValue().toString();
      }
    }
    for (;;)
    {
      return localObject1;
      localObject1 = class$org$ksoap2$serialization$SoapObject;
      break;
      label81:
      localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo.<init>();
      localObject1 = class$java$lang$String;
      if (localObject1 == null)
      {
        localObject1 = class$("java.lang.String");
        class$java$lang$String = (Class)localObject1;
      }
      for (;;)
      {
        localPropertyInfo.setType(localObject1);
        localPropertyInfo.setValue("");
        localPropertyInfo.setName(paramString);
        localObject1 = localPropertyInfo.getValue();
        break;
        localObject1 = class$java$lang$String;
      }
      localObject1 = new org/ksoap2/serialization/NullSoapObject;
      ((NullSoapObject)localObject1).<init>();
    }
  }
  
  public String getPrimitivePropertySafelyAsString(String paramString)
  {
    Integer localInteger = propertyIndex(paramString);
    Object localObject1;
    if (localInteger != null)
    {
      localObject1 = properties;
      int i = localInteger.intValue();
      PropertyInfo localPropertyInfo = (PropertyInfo)((Vector)localObject1).elementAt(i);
      Object localObject2 = localPropertyInfo.getType();
      localObject1 = class$org$ksoap2$serialization$SoapObject;
      if (localObject1 == null)
      {
        localObject1 = class$("org.ksoap2.serialization.SoapObject");
        class$org$ksoap2$serialization$SoapObject = (Class)localObject1;
        if (localObject2 == localObject1) {
          break label81;
        }
        localObject1 = localPropertyInfo.getValue().toString();
      }
    }
    for (;;)
    {
      return (String)localObject1;
      localObject1 = class$org$ksoap2$serialization$SoapObject;
      break;
      label81:
      localObject1 = "";
      continue;
      localObject1 = "";
    }
  }
  
  public Object getProperty(int paramInt)
  {
    Vector localVector = properties;
    Object localObject = localVector.elementAt(paramInt);
    boolean bool = localObject instanceof PropertyInfo;
    if (bool) {}
    for (localObject = ((PropertyInfo)localObject).getValue();; localObject = (SoapObject)localObject) {
      return localObject;
    }
  }
  
  public Object getProperty(String paramString)
  {
    Integer localInteger = propertyIndex(paramString);
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      return getProperty(i);
    }
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    Object localObject = new java/lang/StringBuffer;
    ((StringBuffer)localObject).<init>();
    localObject = "illegal property: " + paramString;
    localRuntimeException.<init>((String)localObject);
    throw localRuntimeException;
  }
  
  public String getPropertyAsString(int paramInt)
  {
    return ((PropertyInfo)properties.elementAt(paramInt)).getValue().toString();
  }
  
  public String getPropertyAsString(String paramString)
  {
    Integer localInteger = propertyIndex(paramString);
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      return getProperty(i).toString();
    }
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    Object localObject = new java/lang/StringBuffer;
    ((StringBuffer)localObject).<init>();
    localObject = "illegal property: " + paramString;
    localRuntimeException.<init>((String)localObject);
    throw localRuntimeException;
  }
  
  public int getPropertyCount()
  {
    return properties.size();
  }
  
  public void getPropertyInfo(int paramInt, Hashtable paramHashtable, PropertyInfo paramPropertyInfo)
  {
    getPropertyInfo(paramInt, paramPropertyInfo);
  }
  
  public void getPropertyInfo(int paramInt, PropertyInfo paramPropertyInfo)
  {
    Object localObject1 = properties;
    Object localObject2 = ((Vector)localObject1).elementAt(paramInt);
    boolean bool1 = localObject2 instanceof PropertyInfo;
    boolean bool2;
    if (bool1)
    {
      Object localObject3 = localObject2;
      localObject3 = (PropertyInfo)localObject2;
      localObject1 = name;
      name = ((String)localObject1);
      localObject1 = namespace;
      namespace = ((String)localObject1);
      int i = flags;
      flags = i;
      localObject1 = type;
      type = localObject1;
      localObject1 = elementType;
      elementType = ((PropertyInfo)localObject1);
      localObject1 = value;
      value = localObject1;
      bool2 = multiRef;
    }
    for (multiRef = bool2;; multiRef = false)
    {
      return;
      name = null;
      namespace = null;
      flags = 0;
      type = null;
      elementType = null;
      value = localObject2;
    }
  }
  
  public Object getPropertySafely(String paramString)
  {
    Integer localInteger = propertyIndex(paramString);
    Object localObject;
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      localObject = getProperty(i);
    }
    for (;;)
    {
      return localObject;
      localObject = new org/ksoap2/serialization/NullSoapObject;
      ((NullSoapObject)localObject).<init>();
    }
  }
  
  public Object getPropertySafely(String paramString, Object paramObject)
  {
    Integer localInteger = propertyIndex(paramString);
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      paramObject = getProperty(i);
    }
    return paramObject;
  }
  
  public String getPropertySafelyAsString(String paramString)
  {
    Integer localInteger = propertyIndex(paramString);
    Object localObject;
    String str;
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      localObject = getProperty(i);
      if (localObject == null) {
        str = "";
      }
    }
    for (;;)
    {
      return str;
      str = localObject.toString();
      continue;
      str = "";
    }
  }
  
  public String getPropertySafelyAsString(String paramString, Object paramObject)
  {
    Integer localInteger = propertyIndex(paramString);
    String str;
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      Object localObject = getProperty(i);
      if (localObject != null) {
        str = localObject.toString();
      }
    }
    for (;;)
    {
      return str;
      str = "";
      continue;
      if (paramObject != null) {
        str = paramObject.toString();
      } else {
        str = "";
      }
    }
  }
  
  public boolean hasProperty(String paramString)
  {
    Integer localInteger = propertyIndex(paramString);
    boolean bool;
    if (localInteger != null) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      bool = false;
      localInteger = null;
    }
  }
  
  public boolean isPropertyEqual(Object paramObject, int paramInt)
  {
    boolean bool1 = false;
    int i = getPropertyCount();
    if (paramInt >= i) {}
    for (;;)
    {
      return bool1;
      Object localObject1 = properties;
      Object localObject2 = ((Vector)localObject1).elementAt(paramInt);
      boolean bool2 = paramObject instanceof PropertyInfo;
      if (bool2)
      {
        bool2 = localObject2 instanceof PropertyInfo;
        if (bool2)
        {
          Object localObject3 = paramObject;
          localObject3 = (PropertyInfo)paramObject;
          Object localObject4 = localObject2;
          localObject4 = (PropertyInfo)localObject2;
          localObject1 = ((PropertyInfo)localObject3).getName();
          Object localObject5 = ((PropertyInfo)localObject4).getName();
          bool2 = ((String)localObject1).equals(localObject5);
          if (!bool2) {
            continue;
          }
          localObject1 = ((PropertyInfo)localObject3).getValue();
          localObject5 = ((PropertyInfo)localObject4).getValue();
          bool2 = localObject1.equals(localObject5);
          if (!bool2) {
            continue;
          }
          bool1 = true;
          continue;
        }
      }
      bool2 = paramObject instanceof SoapObject;
      if (bool2)
      {
        bool2 = localObject2 instanceof SoapObject;
        if (bool2)
        {
          Object localObject6 = paramObject;
          localObject6 = (SoapObject)paramObject;
          Object localObject7 = localObject2;
          localObject7 = (SoapObject)localObject2;
          bool1 = ((SoapObject)localObject6).equals(localObject7);
        }
      }
    }
  }
  
  public SoapObject newInstance()
  {
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    Object localObject1 = namespace;
    String str = name;
    localSoapObject.<init>((String)localObject1, str);
    int i = 0;
    localObject1 = properties;
    int j = ((Vector)localObject1).size();
    if (i < j)
    {
      localObject1 = properties;
      Object localObject2 = ((Vector)localObject1).elementAt(i);
      boolean bool = localObject2 instanceof PropertyInfo;
      if (bool)
      {
        localObject1 = properties;
        PropertyInfo localPropertyInfo1 = (PropertyInfo)((Vector)localObject1).elementAt(i);
        PropertyInfo localPropertyInfo2 = (PropertyInfo)localPropertyInfo1.clone();
        localSoapObject.addProperty(localPropertyInfo2);
      }
      for (;;)
      {
        i += 1;
        break;
        bool = localObject2 instanceof SoapObject;
        if (bool)
        {
          localObject2 = (SoapObject)localObject2;
          localObject1 = ((SoapObject)localObject2).newInstance();
          localSoapObject.addSoapObject((SoapObject)localObject1);
        }
      }
    }
    int m = 0;
    for (;;)
    {
      int k = getAttributeCount();
      if (m >= k) {
        break;
      }
      AttributeInfo localAttributeInfo = new org/ksoap2/serialization/AttributeInfo;
      localAttributeInfo.<init>();
      getAttributeInfo(m, localAttributeInfo);
      localSoapObject.addAttribute(localAttributeInfo);
      m += 1;
    }
    return localSoapObject;
  }
  
  public void setProperty(int paramInt, Object paramObject)
  {
    Vector localVector = properties;
    Object localObject = localVector.elementAt(paramInt);
    boolean bool = localObject instanceof PropertyInfo;
    if (bool)
    {
      localObject = (PropertyInfo)localObject;
      ((PropertyInfo)localObject).setValue(paramObject);
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    Object localObject1 = new java/lang/StringBuffer;
    ((StringBuffer)localObject1).<init>();
    localObject1 = ((StringBuffer)localObject1).append("");
    Object localObject2 = name;
    localObject1 = ((StringBuffer)localObject1).append((String)localObject2);
    localObject2 = "{";
    localObject1 = (String)localObject2;
    localStringBuffer.<init>((String)localObject1);
    int i = 0;
    int j = getPropertyCount();
    if (i < j)
    {
      localObject1 = properties;
      Object localObject3 = ((Vector)localObject1).elementAt(i);
      boolean bool = localObject3 instanceof PropertyInfo;
      if (bool)
      {
        localObject1 = localStringBuffer.append("");
        localObject3 = (PropertyInfo)localObject3;
        localObject2 = ((PropertyInfo)localObject3).getName();
        localObject1 = ((StringBuffer)localObject1).append((String)localObject2).append("=");
        localObject2 = getProperty(i);
        localObject1 = ((StringBuffer)localObject1).append(localObject2);
        localObject2 = "; ";
        ((StringBuffer)localObject1).append((String)localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject3 = (SoapObject)localObject3;
        localObject1 = ((SoapObject)localObject3).toString();
        localStringBuffer.append((String)localObject1);
      }
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/SoapObject.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */