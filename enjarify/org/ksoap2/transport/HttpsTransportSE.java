package org.ksoap2.transport;

import java.net.Proxy;

public class HttpsTransportSE
  extends HttpTransportSE
{
  static final String PROTOCOL = "https";
  private static final String PROTOCOL_FULL = "https://";
  protected final String file;
  protected final String host;
  protected final int port;
  
  public HttpsTransportSE(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super((String)localObject, paramInt2);
    host = paramString1;
    port = paramInt1;
    file = paramString2;
  }
  
  public HttpsTransportSE(Proxy paramProxy, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(paramProxy, (String)localObject);
    host = paramString1;
    port = paramInt1;
    file = paramString2;
    timeout = paramInt2;
  }
  
  public ServiceConnection getServiceConnection()
  {
    HttpsServiceConnectionSE localHttpsServiceConnectionSE = new org/ksoap2/transport/HttpsServiceConnectionSE;
    Proxy localProxy = proxy;
    String str1 = host;
    int i = port;
    String str2 = file;
    int j = timeout;
    localHttpsServiceConnectionSE.<init>(localProxy, str1, i, str2, j);
    return localHttpsServiceConnectionSE;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/transport/HttpsTransportSE.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */