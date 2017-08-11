package org.ksoap2.serialization;

import java.util.Vector;

public class AttributeContainer
{
  private Vector attributes = new Vector();
  
  private Integer attributeIndex(String paramString)
  {
    int i = 0;
    while (i < attributes.size())
    {
      if (paramString.equals(((AttributeInfo)attributes.elementAt(i)).getName())) {
        return new Integer(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void addAttribute(String paramString, Object paramObject)
  {
    AttributeInfo localAttributeInfo = new AttributeInfo();
    name = paramString;
    if (paramObject == null) {}
    for (paramString = PropertyInfo.OBJECT_CLASS;; paramString = paramObject.getClass())
    {
      type = paramString;
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
    if (value != null) {
      attributes.addElement(paramAttributeInfo);
    }
  }
  
  protected boolean attributesAreEqual(AttributeContainer paramAttributeContainer)
  {
    int j = getAttributeCount();
    if (j != paramAttributeContainer.getAttributeCount()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label78;
      }
      AttributeInfo localAttributeInfo = (AttributeInfo)attributes.elementAt(i);
      Object localObject = localAttributeInfo.getValue();
      if ((!paramAttributeContainer.hasAttribute(localAttributeInfo.getName())) || (!localObject.equals(paramAttributeContainer.getAttributeSafely(localAttributeInfo.getName())))) {
        break;
      }
      i += 1;
    }
    label78:
    return true;
  }
  
  public Object getAttribute(int paramInt)
  {
    return ((AttributeInfo)attributes.elementAt(paramInt)).getValue();
  }
  
  public Object getAttribute(String paramString)
  {
    Integer localInteger = attributeIndex(paramString);
    if (localInteger != null) {
      return getAttribute(localInteger.intValue());
    }
    throw new RuntimeException("illegal property: " + paramString);
  }
  
  public String getAttributeAsString(int paramInt)
  {
    return ((AttributeInfo)attributes.elementAt(paramInt)).getValue().toString();
  }
  
  public String getAttributeAsString(String paramString)
  {
    Integer localInteger = attributeIndex(paramString);
    if (localInteger != null) {
      return getAttribute(localInteger.intValue()).toString();
    }
    throw new RuntimeException("illegal property: " + paramString);
  }
  
  public int getAttributeCount()
  {
    return attributes.size();
  }
  
  public void getAttributeInfo(int paramInt, AttributeInfo paramAttributeInfo)
  {
    AttributeInfo localAttributeInfo = (AttributeInfo)attributes.elementAt(paramInt);
    name = name;
    namespace = namespace;
    flags = flags;
    type = type;
    elementType = elementType;
    value = localAttributeInfo.getValue();
  }
  
  public Object getAttributeSafely(String paramString)
  {
    paramString = attributeIndex(paramString);
    if (paramString != null) {
      return getAttribute(paramString.intValue());
    }
    return null;
  }
  
  public Object getAttributeSafelyAsString(String paramString)
  {
    paramString = attributeIndex(paramString);
    if (paramString != null) {
      return getAttribute(paramString.intValue()).toString();
    }
    return "";
  }
  
  public boolean hasAttribute(String paramString)
  {
    return attributeIndex(paramString) != null;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/ksoap2/serialization/AttributeContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */