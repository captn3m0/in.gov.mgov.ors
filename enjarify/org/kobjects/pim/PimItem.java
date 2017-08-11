package org.kobjects.pim;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public abstract class PimItem
{
  public static final int TYPE_STRING = 0;
  public static final int TYPE_STRING_ARRAY = 1;
  Hashtable fields;
  
  public PimItem()
  {
    Hashtable localHashtable = new java/util/Hashtable;
    localHashtable.<init>();
    fields = localHashtable;
  }
  
  public PimItem(PimItem paramPimItem)
  {
    Object localObject = new java/util/Hashtable;
    ((Hashtable)localObject).<init>();
    fields = ((Hashtable)localObject);
    Enumeration localEnumeration = paramPimItem.fields();
    for (;;)
    {
      boolean bool = localEnumeration.hasMoreElements();
      if (!bool) {
        break;
      }
      PimField localPimField = new org/kobjects/pim/PimField;
      localObject = (PimField)localEnumeration.nextElement();
      localPimField.<init>((PimField)localObject);
      addField(localPimField);
    }
  }
  
  public void addField(PimField paramPimField)
  {
    Hashtable localHashtable = fields;
    String str = name;
    Vector localVector = (Vector)localHashtable.get(str);
    if (localVector == null)
    {
      localVector = new java/util/Vector;
      localVector.<init>();
      localHashtable = fields;
      str = name;
      localHashtable.put(str, localVector);
    }
    localVector.addElement(paramPimField);
  }
  
  public Enumeration fieldNames()
  {
    return fields.keys();
  }
  
  public Enumeration fields()
  {
    Vector localVector = new java/util/Vector;
    localVector.<init>();
    Enumeration localEnumeration1 = fieldNames();
    boolean bool = localEnumeration1.hasMoreElements();
    if (bool)
    {
      String str = (String)localEnumeration1.nextElement();
      Enumeration localEnumeration2 = fields(str);
      for (;;)
      {
        bool = localEnumeration2.hasMoreElements();
        if (!bool) {
          break;
        }
        Object localObject = localEnumeration2.nextElement();
        localVector.addElement(localObject);
      }
    }
    return localVector.elements();
  }
  
  public Enumeration fields(String paramString)
  {
    Hashtable localHashtable = fields;
    Vector localVector = (Vector)localHashtable.get(paramString);
    if (localVector == null)
    {
      localVector = new java/util/Vector;
      localVector.<init>();
    }
    return localVector.elements();
  }
  
  public abstract int getArraySize(String paramString);
  
  public PimField getField(String paramString, int paramInt)
  {
    return (PimField)((Vector)fields.get(paramString)).elementAt(paramInt);
  }
  
  public int getFieldCount(String paramString)
  {
    Hashtable localHashtable = fields;
    Vector localVector = (Vector)localHashtable.get(paramString);
    int i;
    if (localVector == null)
    {
      i = 0;
      localHashtable = null;
    }
    for (;;)
    {
      return i;
      i = localVector.size();
    }
  }
  
  public int getType(String paramString)
  {
    int i = getArraySize(paramString);
    int j = -1;
    if (i == j) {}
    for (i = 0;; i = 1) {
      return i;
    }
  }
  
  public abstract String getType();
  
  public void removeField(String paramString, int paramInt)
  {
    ((Vector)fields.get(paramString)).removeElementAt(paramInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new java/lang/StringBuilder;
    localStringBuilder.<init>();
    String str = getType();
    localStringBuilder = localStringBuilder.append(str).append(":");
    str = fields.toString();
    return str;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/pim/PimItem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */