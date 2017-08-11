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
    this((String)localObject1);
    localObject1 = value;
    boolean bool1 = localObject1 instanceof String[];
    String[] arrayOfString;
    if (bool1)
    {
      int i = ((String[])value).length;
      arrayOfString = new String[i];
      localObject1 = (String[])value;
      int j = arrayOfString.length;
      System.arraycopy(localObject1, 0, arrayOfString, 0, j);
    }
    for (value = arrayOfString;; value = localObject1)
    {
      localObject1 = properties;
      if (localObject1 == null) {
        break;
      }
      localObject1 = new java/util/Hashtable;
      ((Hashtable)localObject1).<init>();
      properties = ((Hashtable)localObject1);
      localObject1 = properties;
      Enumeration localEnumeration = ((Hashtable)localObject1).keys();
      for (;;)
      {
        boolean bool2 = localEnumeration.hasMoreElements();
        if (!bool2) {
          break;
        }
        String str = (String)localEnumeration.nextElement();
        localObject1 = properties;
        Object localObject2 = properties.get(str);
        ((Hashtable)localObject1).put(str, localObject2);
      }
      localObject1 = value;
    }
  }
  
  public boolean getAttribute(String paramString)
  {
    boolean bool = false;
    String str1 = "type";
    String str2 = getProperty(str1);
    if (str2 == null) {}
    for (;;)
    {
      return bool;
      int i = str2.indexOf(paramString);
      int j = -1;
      if (i != j) {
        bool = true;
      }
    }
  }
  
  public String getProperty(String paramString)
  {
    Object localObject = properties;
    if (localObject == null) {}
    for (localObject = null;; localObject = (String)properties.get(paramString)) {
      return (String)localObject;
    }
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
    boolean bool = getAttribute(paramString);
    if (bool == paramBoolean) {
      return;
    }
    Object localObject = "type";
    String str1 = getProperty((String)localObject);
    int i;
    if (paramBoolean) {
      if (str1 != null)
      {
        i = str1.length();
        if (i != 0) {}
      }
      else
      {
        str1 = paramString;
      }
    }
    for (;;)
    {
      localObject = "type";
      setProperty((String)localObject, str1);
      break;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = ((StringBuilder)localObject).append(str1).append(paramString);
      str1 = ((StringBuilder)localObject).toString();
      continue;
      int j = str1.indexOf(paramString);
      if (j > 0) {
        j += -1;
      }
      i = -1;
      if (j != i)
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        String str2 = str1.substring(0, j);
        localObject = ((StringBuilder)localObject).append(str2);
        int k = paramString.length() + j + 1;
        str2 = str1.substring(k);
        localObject = ((StringBuilder)localObject).append(str2);
        str1 = ((StringBuilder)localObject).toString();
      }
    }
  }
  
  public void setProperty(String paramString1, String paramString2)
  {
    Hashtable localHashtable = properties;
    if (localHashtable == null) {
      if (paramString2 != null) {}
    }
    for (;;)
    {
      return;
      localHashtable = new java/util/Hashtable;
      localHashtable.<init>();
      properties = localHashtable;
      if (paramString2 == null)
      {
        localHashtable = properties;
        localHashtable.remove(paramString1);
      }
      else
      {
        localHashtable = properties;
        localHashtable.put(paramString1, paramString2);
      }
    }
  }
  
  public void setValue(Object paramObject)
  {
    value = paramObject;
  }
  
  public String toString()
  {
    Object localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    Object localObject2 = name;
    localObject2 = ((StringBuilder)localObject1).append((String)localObject2);
    localObject1 = properties;
    Hashtable localHashtable;
    if (localObject1 != null)
    {
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject1 = ((StringBuilder)localObject1).append(";");
      localHashtable = properties;
    }
    for (localObject1 = localHashtable;; localObject1 = "")
    {
      localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append(":");
      localObject2 = value;
      return (String)localObject2;
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/pim/PimField.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */