package org.kobjects.pim;

import java.util.Enumeration;
import java.util.Hashtable;

public class PimField
{
  String name;
  Hashtable properties;
  Object value;
  
  public PimField(String paramString)
  {
    name = paramString;
  }
  
  public PimField(PimField paramPimField)
  {
    this(name);
    Object localObject;
    if ((value instanceof String[]))
    {
      localObject = new String[((String[])value).length];
      System.arraycopy((String[])value, 0, localObject, 0, localObject.length);
    }
    for (value = localObject; properties != null; value = value)
    {
      properties = new Hashtable();
      localObject = properties.keys();
      while (((Enumeration)localObject).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject).nextElement();
        properties.put(str, properties.get(str));
      }
    }
  }
  
  public boolean getAttribute(String paramString)
  {
    String str = getProperty("type");
    if (str == null) {}
    while (str.indexOf(paramString) == -1) {
      return false;
    }
    return true;
  }
  
  public String getProperty(String paramString)
  {
    if (properties == null) {
      return null;
    }
    return (String)properties.get(paramString);
  }
  
  public Object getValue()
  {
    return value;
  }
  
  public Enumeration propertyNames()
  {
    return properties.keys();
  }
  
  public void setAttribute(String paramString, boolean paramBoolean)
  {
    if (getAttribute(paramString) == paramBoolean) {
      return;
    }
    String str2 = getProperty("type");
    String str1;
    if (paramBoolean) {
      if ((str2 == null) || (str2.length() == 0)) {
        str1 = paramString;
      }
    }
    for (;;)
    {
      setProperty("type", str1);
      return;
      str1 = str2 + paramString;
      continue;
      int j = str2.indexOf(paramString);
      int i = j;
      if (j > 0) {
        i = j - 1;
      }
      str1 = str2;
      if (i != -1) {
        str1 = str2.substring(0, i) + str2.substring(paramString.length() + i + 1);
      }
    }
  }
  
  public void setProperty(String paramString1, String paramString2)
  {
    if (properties == null)
    {
      if (paramString2 == null) {
        return;
      }
      properties = new Hashtable();
    }
    if (paramString2 == null)
    {
      properties.remove(paramString1);
      return;
    }
    properties.put(paramString1, paramString2);
  }
  
  public void setValue(Object paramObject)
  {
    value = paramObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(name);
    if (properties != null) {}
    for (String str = ";" + properties;; str = "") {
      return str + ":" + value;
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kobjects/pim/PimField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */