package org.ksoap2.transport;

public class KeepAliveHttpsTransportSE
  extends HttpsTransportSE
{
  public KeepAliveHttpsTransportSE(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public ServiceConnection getServiceConnection()
  {
    HttpsServiceConnectionSEIgnoringConnectionClose localHttpsServiceConnectionSEIgnoringConnectionClose = new org/ksoap2/transport/HttpsServiceConnectionSEIgnoringConnectionClose;
    String str1 = host;
    int i = port;
    String str2 = file;
    int j = timeout;
    localHttpsServiceConnectionSEIgnoringConnectionClose.<init>(str1, i, str2, j);
    localHttpsServiceConnectionSEIgnoringConnectionClose.setRequestProperty("Connection", "keep-alive");
    return localHttpsServiceConnectionSEIgnoringConnectionClose;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/transport/KeepAliveHttpsTransportSE.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */