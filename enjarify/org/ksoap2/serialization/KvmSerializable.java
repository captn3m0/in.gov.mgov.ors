package org.ksoap2.serialization;

import java.util.Hashtable;

public abstract interface KvmSerializable
{
  public abstract Object getProperty(int paramInt);
  
  public abstract int getPropertyCount();
  
  public abstract void getPropertyInfo(int paramInt, Hashtable paramHashtable, PropertyInfo paramPropertyInfo);
  
  public abstract void setProperty(int paramInt, Object paramObject);
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/KvmSerializable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */