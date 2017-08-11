package org.ksoap2.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class PropertyInfo
  implements Serializable
{
  public static final Class BOOLEAN_CLASS;
  public static final Class INTEGER_CLASS;
  public static final Class LONG_CLASS;
  public static final int MULTI_REF = 2;
  public static final Class OBJECT_CLASS;
  public static final PropertyInfo OBJECT_TYPE;
  public static final int REF_ONLY = 4;
  public static final Class STRING_CLASS;
  public static final int TRANSIENT = 1;
  public static final Class VECTOR_CLASS;
  public PropertyInfo elementType;
  public int flags;
  public boolean multiRef;
  public String name;
  public String namespace;
  public Object type;
  protected Object value;
  
  static
  {
    Object localObject = new java/lang/Object;
    localObject.<init>();
    OBJECT_CLASS = localObject.getClass();
    STRING_CLASS = "".getClass();
    localObject = new java/lang/Integer;
    ((Integer)localObject).<init>(0);
    INTEGER_CLASS = localObject.getClass();
    localObject = new java/lang/Long;
    ((Long)localObject).<init>(0L);
    LONG_CLASS = localObject.getClass();
    localObject = new java/lang/Boolean;
    ((Boolean)localObject).<init>(true);
    BOOLEAN_CLASS = localObject.getClass();
    localObject = new java/util/Vector;
    ((Vector)localObject).<init>();
    VECTOR_CLASS = localObject.getClass();
    localObject = new org/ksoap2/serialization/PropertyInfo;
    ((PropertyInfo)localObject).<init>();
    OBJECT_TYPE = (PropertyInfo)localObject;
  }
  
  public PropertyInfo()
  {
    Class localClass = OBJECT_CLASS;
    type = localClass;
  }
  
  public void clear()
  {
    Class localClass = OBJECT_CLASS;
    type = localClass;
    flags = 0;
    name = null;
    namespace = null;
  }
  
  public Object clone()
  {
    Object localObject = null;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      ObjectOutputStream localObjectOutputStream = new java/io/ObjectOutputStream;
      localObjectOutputStream.<init>(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(this);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      ObjectInputStream localObjectInputStream = new java/io/ObjectInputStream;
      ByteArrayInputStream localByteArrayInputStream = new java/io/ByteArrayInputStream;
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayInputStream.<init>(arrayOfByte);
      localObjectInputStream.<init>(localByteArrayInputStream);
      localObject = localObjectInputStream.readObject();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
    catch (NotSerializableException localNotSerializableException)
    {
      for (;;)
      {
        localNotSerializableException.printStackTrace();
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    return localObject;
  }
  
  public PropertyInfo getElementType()
  {
    return elementType;
  }
  
  public int getFlags()
  {
    return flags;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public Object getType()
  {
    return type;
  }
  
  public Object getValue()
  {
    return value;
  }
  
  public boolean isMultiRef()
  {
    return multiRef;
  }
  
  public void setElementType(PropertyInfo paramPropertyInfo)
  {
    elementType = paramPropertyInfo;
  }
  
  public void setFlags(int paramInt)
  {
    flags = paramInt;
  }
  
  public void setMultiRef(boolean paramBoolean)
  {
    multiRef = paramBoolean;
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void setNamespace(String paramString)
  {
    namespace = paramString;
  }
  
  public void setType(Object paramObject)
  {
    type = paramObject;
  }
  
  public void setValue(Object paramObject)
  {
    value = paramObject;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    Object localObject = name;
    localStringBuffer.append((String)localObject);
    localStringBuffer.append(" : ");
    localObject = value;
    if (localObject != null)
    {
      localObject = value;
      localStringBuffer.append(localObject);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localObject = "(not set)";
      localStringBuffer.append((String)localObject);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/PropertyInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */