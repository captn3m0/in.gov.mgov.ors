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
    boolean bool1 = true;
    boolean bool2 = false;
    boolean bool3 = paramObject instanceof SoapPrimitive;
    if (!bool3) {
      return bool2;
    }
    Object localObject = paramObject;
    localObject = (SoapPrimitive)paramObject;
    String str1 = name;
    String str2 = name;
    bool3 = str1.equals(str2);
    label76:
    label99:
    int i;
    if (bool3)
    {
      str1 = namespace;
      if (str1 == null)
      {
        str1 = namespace;
        if (str1 != null) {
          break label152;
        }
        str1 = value;
        if (str1 != null) {
          break label158;
        }
        str1 = value;
        if (str1 != null) {
          break label152;
        }
        i = bool1;
        if (i == 0) {
          break label188;
        }
        bool3 = attributesAreEqual((AttributeContainer)localObject);
        if (!bool3) {
          break label188;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      break;
      str1 = namespace;
      str2 = namespace;
      bool3 = str1.equals(str2);
      if (bool3) {
        break label76;
      }
      label152:
      label158:
      do
      {
        i = 0;
        break;
        str1 = value;
        str2 = value;
        bool3 = str1.equals(str2);
      } while (!bool3);
      break label99;
      label188:
      bool1 = false;
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
    int i = name.hashCode();
    String str = namespace;
    int j;
    if (str == null)
    {
      j = 0;
      str = null;
    }
    for (;;)
    {
      return j ^ i;
      str = namespace;
      j = str.hashCode();
    }
  }
  
  public String toString()
  {
    return value;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/SoapPrimitive.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */