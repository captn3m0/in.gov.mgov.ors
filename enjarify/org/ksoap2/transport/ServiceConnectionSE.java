package org.ksoap2.transport;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.ksoap2.HeaderProperty;

public class ServiceConnectionSE
  implements ServiceConnection
{
  private HttpURLConnection connection;
  
  public ServiceConnectionSE(String paramString)
  {
    this(null, paramString, 20000);
  }
  
  public ServiceConnectionSE(String paramString, int paramInt)
  {
    this(null, paramString, paramInt);
  }
  
  public ServiceConnectionSE(Proxy paramProxy, String paramString)
  {
    this(paramProxy, paramString, 20000);
  }
  
  public ServiceConnectionSE(Proxy paramProxy, String paramString, int paramInt)
  {
    if (paramProxy == null)
    {
      localObject = new java/net/URL;
      ((URL)localObject).<init>(paramString);
    }
    for (Object localObject = (HttpURLConnection)((URL)localObject).openConnection();; localObject = (HttpURLConnection)((URL)localObject).openConnection(paramProxy))
    {
      connection = ((HttpURLConnection)localObject);
      connection.setUseCaches(false);
      connection.setDoOutput(bool);
      connection.setDoInput(bool);
      connection.setConnectTimeout(paramInt);
      connection.setReadTimeout(paramInt);
      return;
      localObject = new java/net/URL;
      ((URL)localObject).<init>(paramString);
    }
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
    LinkedList localLinkedList = new java/util/LinkedList;
    localLinkedList.<init>();
    Object localObject = connection;
    Map localMap = ((HttpURLConnection)localObject).getHeaderFields();
    if (localMap != null)
    {
      Set localSet = localMap.keySet();
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
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/transport/ServiceConnectionSE.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */