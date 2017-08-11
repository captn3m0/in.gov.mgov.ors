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
    Object localObject = object;
    boolean bool;
    if (localObject != null) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      bool = false;
      localObject = null;
    }
  }
  
  public Object nextElement()
  {
    Object localObject = object;
    object = null;
    return localObject;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/util/SingleEnumeration.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */