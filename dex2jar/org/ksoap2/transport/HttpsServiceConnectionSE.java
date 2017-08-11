package org.ksoap2.transport;

import java.io.IOException;
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
    throws IOException
  {
    this(null, paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public HttpsServiceConnectionSE(Proxy paramProxy, String paramString1, int paramInt1, String paramString2, int paramInt2)
    throws IOException
  {
    if (paramProxy == null) {}
    for (connection = ((HttpsURLConnection)new URL("https", paramString1, paramInt1, paramString2).openConnection());; connection = ((HttpsURLConnection)new URL("https", paramString1, paramInt1, paramString2).openConnection(paramProxy)))
    {
      connection = ((HttpsURLConnection)new URL("https", paramString1, paramInt1, paramString2).openConnection());
      updateConnectionParameters(paramInt2);
      return;
    }
  }
  
  private void updateConnectionParameters(int paramInt)
  {
    connection.setConnectTimeout(paramInt);
    connection.setReadTimeout(paramInt);
    connection.setUseCaches(false);
    connection.setDoOutput(true);
    connection.setDoInput(true);
  }
  
  public void connect()
    throws IOException
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
    throws IOException
  {
    return connection.getResponseCode();
  }
  
  public List getResponseProperties()
  {
    Map localMap = connection.getHeaderFields();
    Object localObject = localMap.keySet();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      List localList = (List)localMap.get(str);
      int i = 0;
      while (i < localList.size())
      {
        localLinkedList.add(new HeaderProperty(str, (String)localList.get(i)));
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public InputStream openInputStream()
    throws IOException
  {
    return connection.getInputStream();
  }
  
  public OutputStream openOutputStream()
    throws IOException
  {
    return connection.getOutputStream();
  }
  
  public void setFixedLengthStreamingMode(int paramInt)
  {
    connection.setFixedLengthStreamingMode(paramInt);
  }
  
  public void setRequestMethod(String paramString)
    throws IOException
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


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/ksoap2/transport/HttpsServiceConnectionSE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */