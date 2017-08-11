package org.ksoap2.transport;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.ksoap2.HeaderProperty;

public class HttpsServiceConnectionSE
  implements ServiceConnection
{
  private HttpsURLConnection connection;
  
  public HttpsServiceConnectionSE(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this(null, paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public HttpsServiceConnectionSE(Proxy paramProxy, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    Object localObject;
    String str;
    if (paramProxy == null)
    {
      localObject = new java/net/URL;
      str = "https";
      ((URL)localObject).<init>(str, paramString1, paramInt1, paramString2);
      localObject = (HttpsURLConnection)((URL)localObject).openConnection();
    }
    for (connection = ((HttpsURLConnection)localObject);; connection = ((HttpsURLConnection)localObject))
    {
      localObject = new java/net/URL;
      ((URL)localObject).<init>("https", paramString1, paramInt1, paramString2);
      localObject = (HttpsURLConnection)((URL)localObject).openConnection();
      connection = ((HttpsURLConnection)localObject);
      updateConnectionParameters(paramInt2);
      return;
      localObject = new java/net/URL;
      str = "https";
      ((URL)localObject).<init>(str, paramString1, paramInt1, paramString2);
      localObject = (HttpsURLConnection)((URL)localObject).openConnection(paramProxy);
    }
  }
  
  private void updateConnectionParameters(int paramInt)
  {
    boolean bool = true;
    connection.setConnectTimeout(paramInt);
    connection.setReadTimeout(paramInt);
    connection.setUseCaches(false);
    connection.setDoOutput(bool);
    connection.setDoInput(bool);
  }
  
  public void connect()
  {
    connection.connect();
  }
  
  public void disconnect()
  {
    connection.disconnect();
  }
  
  public InputStream getErrorStream()
  {
    return connection.getErrorStream();
  }
  
  public String getHost()
  {
    return connection.getURL().getHost();
  }
  
  public String getPath()
  {
    return connection.getURL().getPath();
  }
  
  public int getPort()
  {
    return connection.getURL().getPort();
  }
  
  public int getResponseCode()
  {
    return connection.getResponseCode();
  }
  
  public List getResponseProperties()
  {
    Object localObject = connection;
    Map localMap = ((HttpsURLConnection)localObject).getHeaderFields();
    Set localSet = localMap.keySet();
    LinkedList localLinkedList = new java/util/LinkedList;
    localLinkedList.<init>();
    Iterator localIterator = localSet.iterator();
    boolean bool = localIterator.hasNext();
    if (bool)
    {
      String str = (String)localIterator.next();
      List localList = (List)localMap.get(str);
      int j = 0;
      for (;;)
      {
        int i = localList.size();
        if (j >= i) {
          break;
        }
        HeaderProperty localHeaderProperty = new org/ksoap2/HeaderProperty;
        localObject = (String)localList.get(j);
        localHeaderProperty.<init>(str, (String)localObject);
        localLinkedList.add(localHeaderProperty);
        j += 1;
      }
    }
    return localLinkedList;
  }
  
  public InputStream openInputStream()
  {
    return connection.getInputStream();
  }
  
  public OutputStream openOutputStream()
  {
    return connection.getOutputStream();
  }
  
  public void setFixedLengthStreamingMode(int paramInt)
  {
    connection.setFixedLengthStreamingMode(paramInt);
  }
  
  public void setRequestMethod(String paramString)
  {
    connection.setRequestMethod(paramString);
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    connection.setRequestProperty(paramString1, paramString2);
  }
  
  public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    connection.setSSLSocketFactory(paramSSLSocketFactory);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/transport/HttpsServiceConnectionSE.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */