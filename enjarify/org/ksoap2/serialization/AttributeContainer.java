package org.ksoap2.serialization;

import java.util.Vector;

public class AttributeContainer
{
  private Vector attributes;
  
  public AttributeContainer()
  {
    Vector localVector = new java/util/Vector;
    localVector.<init>();
    attributes = localVector;
  }
  
  private Integer attributeIndex(String paramString)
  {
    int i = 0;
    Object localObject = attributes;
    int j = ((Vector)localObject).size();
    boolean bool;
    if (i < j)
    {
      localObject = ((AttributeInfo)attributes.elementAt(i)).getName();
      bool = paramString.equals(localObject);
      if (bool)
      {
        localObject = new java/lang/Integer;
        ((Integer)localObject).<init>(i);
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
  
  public void addAttribute(String paramString, Object paramObject)
  {
    AttributeInfo localAttributeInfo = new org/ksoap2/serialization/AttributeInfo;
    localAttributeInfo.<init>();
    name = paramString;
    if (paramObject == null) {}
    for (Class localClass = PropertyInfo.OBJECT_CLASS;; localClass = paramObject.getClass())
    {
      type = localClass;
      value = paramObject;
      addAttribute(localAttributeInfo);
      return;
    }
  }
  
  public void addAttribute(AttributeInfo paramAttributeInfo)
  {
    attributes.addElement(paramAttributeInfo);
  }
  
  public void addAttributeIfValue(String paramString, Object paramObject)
  {
    if (paramObject != null) {
      addAttribute(paramString, paramObject);
    }
  }
  
  public void addAttributeIfValue(AttributeInfo paramAttributeInfo)
  {
    Object localObject = value;
    if (localObject != null)
    {
      localObject = attributes;
      ((Vector)localObject).addElement(paramAttributeInfo);
    }
  }
  
  protected boolean attributesAreEqual(AttributeContainer paramAttributeContainer)
  {
    boolean bool1 = false;
    int i = getAttributeCount();
    int j = paramAttributeContainer.getAttributeCount();
    if (i != j) {}
    for (;;)
    {
      return bool1;
      int k = 0;
      for (;;)
      {
        if (k >= i) {
          break label109;
        }
        AttributeInfo localAttributeInfo = (AttributeInfo)attributes.elementAt(k);
        Object localObject1 = localAttributeInfo.getValue();
        String str = localAttributeInfo.getName();
        boolean bool2 = paramAttributeContainer.hasAttribute(str);
        if (!bool2) {
          break;
        }
        str = localAttributeInfo.getName();
        Object localObject2 = paramAttributeContainer.getAttributeSafely(str);
        bool2 = localObject1.equals(localObject2);
        if (!bool2) {
          break;
        }
        k += 1;
      }
      label109:
      bool1 = true;
    }
  }
  
  public Object getAttribute(int paramInt)
  {
    return ((AttributeInfo)attributes.elementAt(paramInt)).getValue();
  }
  
  public Object getAttribute(String paramString)
  {
    Integer localInteger = attributeIndex(paramString);
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      return getAttribute(i);
    }
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    Object localObject = new java/lang/StringBuffer;
    ((StringBuffer)localObject).<init>();
    localObject = "illegal property: " + paramString;
    localRuntimeException.<init>((String)localObject);
    throw localRuntimeException;
  }
  
  public String getAttributeAsString(int paramInt)
  {
    return ((AttributeInfo)attributes.elementAt(paramInt)).getValue().toString();
  }
  
  public String getAttributeAsString(String paramString)
  {
    Integer localInteger = attributeIndex(paramString);
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      return getAttribute(i).toString();
    }
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    Object localObject = new java/lang/StringBuffer;
    ((StringBuffer)localObject).<init>();
    localObject = "illegal property: " + paramString;
    localRuntimeException.<init>((String)localObject);
    throw localRuntimeException;
  }
  
  public int getAttributeCount()
  {
    return attributes.size();
  }
  
  public void getAttributeInfo(int paramInt, AttributeInfo paramAttributeInfo)
  {
    AttributeInfo localAttributeInfo = (AttributeInfo)attributes.elementAt(paramInt);
    Object localObject = name;
    name = ((String)localObject);
    localObject = namespace;
    namespace = ((String)localObject);
    int i = flags;
    flags = i;
    localObject = type;
    type = localObject;
    localObject = elementType;
    elementType = ((PropertyInfo)localObject);
    localObject = localAttributeInfo.getValue();
    value = localObject;
  }
  
  public Object getAttributeSafely(String paramString)
  {
    Integer localInteger = attributeIndex(paramString);
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    }
    for (Object localObject = getAttribute(i);; localObject = null)
    {
      return localObject;
      i = 0;
    }
  }
  
  public Object getAttributeSafelyAsString(String paramString)
  {
    Integer localInteger = attributeIndex(paramString);
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    }
    for (String str = getAttribute(i).toString();; str = "") {
      return str;
    }
  }
  
  public boolean hasAttribute(String paramString)
  {
    Integer localInteger = attributeIndex(paramString);
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
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/AttributeContainer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */