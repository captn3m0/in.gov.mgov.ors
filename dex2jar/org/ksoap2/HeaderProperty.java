package org.ksoap2;

public class HeaderProperty
{
  private String key;
  private String value;
  
  public HeaderProperty(String paramString1, String paramString2)
  {
    key = paramString1;
    value = paramString2;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public String getValue()
  {
    return value;
  }
  
  public void setKey(String paramString)
  {
    key = paramString;
  }
  
  public void setValue(String paramString)
  {
    value = paramString;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/ksoap2/HeaderProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */