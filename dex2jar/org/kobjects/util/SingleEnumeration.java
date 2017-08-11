package org.kobjects.util;

import java.util.Enumeration;

public class SingleEnumeration
  implements Enumeration
{
  Object object;
  
  public SingleEnumeration(Object paramObject)
  {
    object = paramObject;
  }
  
  public boolean hasMoreElements()
  {
    return object != null;
  }
  
  public Object nextElement()
  {
    Object localObject = object;
    object = null;
    return localObject;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kobjects/util/SingleEnumeration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */