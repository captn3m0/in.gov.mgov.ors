package org.ksoap2.serialization;

public class SoapPrimitive
  extends AttributeContainer
{
  String name;
  String namespace;
  String value;
  
  public SoapPrimitive(String paramString1, String paramString2, String paramString3)
  {
    namespace = paramString1;
    name = paramString2;
    value = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof SoapPrimitive)) {
      return false;
    }
    paramObject = (SoapPrimitive)paramObject;
    label58:
    int i;
    if (name.equals(name)) {
      if (namespace == null)
      {
        if (namespace != null) {
          break label88;
        }
        if (value != null) {
          break label93;
        }
        if (value != null) {
          break label88;
        }
        i = 1;
        if ((i == 0) || (!attributesAreEqual((AttributeContainer)paramObject))) {
          break label110;
        }
      }
    }
    for (;;)
    {
      return bool;
      if (namespace.equals(namespace)) {
        break;
      }
      label88:
      label93:
      do
      {
        i = 0;
        break;
      } while (!value.equals(value));
      break label58;
      label110:
      bool = false;
    }
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public int hashCode()
  {
    int j = name.hashCode();
    if (namespace == null) {}
    for (int i = 0;; i = namespace.hashCode()) {
      return i ^ j;
    }
  }
  
  public String toString()
  {
    return value;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/ksoap2/serialization/SoapPrimitive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */