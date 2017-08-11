package org.ksoap2.transport;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;

public class KeepAliveHttpTransportSE
  extends HttpTransportSE
{
  public KeepAliveHttpTransportSE(String paramString)
  {
    super(null, paramString);
  }
  
  public KeepAliveHttpTransportSE(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public KeepAliveHttpTransportSE(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1);
  }
  
  public KeepAliveHttpTransportSE(Proxy paramProxy, String paramString)
  {
    super(paramProxy, paramString);
  }
  
  public KeepAliveHttpTransportSE(Proxy paramProxy, String paramString, int paramInt)
  {
    super(paramProxy, paramString, paramInt);
  }
  
  public KeepAliveHttpTransportSE(Proxy paramProxy, String paramString, int paramInt1, int paramInt2)
  {
    super(paramProxy, paramString, paramInt1);
  }
  
  public List call(String paramString, SoapEnvelope paramSoapEnvelope, List paramList)
  {
    if (paramList == null)
    {
      paramList = new java/util/ArrayList;
      paramList.<init>();
    }
    String str1 = "Connection";
    HeaderProperty localHeaderProperty = getHeader(paramList, str1);
    if (localHeaderProperty == null)
    {
      localHeaderProperty = new org/ksoap2/HeaderProperty;
      str1 = "Connection";
      String str2 = "keep-alive";
      localHeaderProperty.<init>(str1, str2);
      paramList.add(localHeaderProperty);
    }
    for (;;)
    {
      return super.call(paramString, paramSoapEnvelope, paramList);
      str1 = "keep-alive";
      localHeaderProperty.setValue(str1);
    }
  }
  
  protected HeaderProperty getHeader(List paramList, String paramString)
  {
    Object localObject = null;
    int i;
    if (paramList != null) {
      i = 0;
    }
    for (;;)
    {
      int j = paramList.size();
      if (i < j)
      {
        HeaderProperty localHeaderProperty = (HeaderProperty)paramList.get(i);
        String str = localHeaderProperty.getKey();
        boolean bool = paramString.equals(str);
        if (bool) {
          localObject = localHeaderProperty;
        }
      }
      else
      {
        return (HeaderProperty)localObject;
      }
      i += 1;
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/transport/KeepAliveHttpTransportSE.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */