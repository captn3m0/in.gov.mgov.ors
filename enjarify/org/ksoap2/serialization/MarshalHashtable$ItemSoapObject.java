package org.ksoap2.serialization;

import java.util.Hashtable;

class MarshalHashtable$ItemSoapObject
  extends SoapObject
{
  Hashtable h;
  int resolvedIndex;
  private final MarshalHashtable this$0;
  
  MarshalHashtable$ItemSoapObject(MarshalHashtable paramMarshalHashtable, Hashtable paramHashtable)
  {
    super(null, null);
    this$0 = paramMarshalHashtable;
    resolvedIndex = -1;
    h = paramHashtable;
    addProperty("key", null);
    addProperty("value", null);
  }
  
  public void setProperty(int paramInt, Object paramObject)
  {
    int i = resolvedIndex;
    int j = -1;
    if (i == j)
    {
      super.setProperty(paramInt, paramObject);
      resolvedIndex = paramInt;
    }
    for (;;)
    {
      return;
      i = resolvedIndex;
      if (i == 0)
      {
        i = 0;
        localHashtable = null;
      }
      for (Object localObject = getProperty(0);; localObject = getProperty(i))
      {
        if (paramInt != 0) {
          break label81;
        }
        localHashtable = h;
        localHashtable.put(paramObject, localObject);
        break;
        i = 1;
      }
      label81:
      Hashtable localHashtable = h;
      localHashtable.put(localObject, paramObject);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/MarshalHashtable$ItemSoapObject.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */