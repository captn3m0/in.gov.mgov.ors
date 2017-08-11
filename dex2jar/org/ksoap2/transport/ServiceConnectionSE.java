package org.ksoap2.transport;

import java.io.IOException;
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
    throws IOException
  {
    this(null, paramString, 20000);
  }
  
  public ServiceConnectionSE(String paramString, int paramInt)
    throws IOException
  {
    this(null, paramString, paramInt);
  }
  
  public ServiceConnectionSE(Proxy paramProxy, String paramString)
    throws IOException
  {
    this(paramProxy, paramString, 20000);
  }
  
  public ServiceConnectionSE(Proxy paramProxy, String paramString, int paramInt)
    throws IOException
  {
    if (paramProxy == null) {}
    for (paramProxy = (HttpURLConnection)new URL(paramString).openConnection();; paramProxy = (HttpURLConnection)new URL(paramString).openConnection(paramProxy))
    {
      connection = paramProxy;
      connection.setUseCaches(false);
      connection.setDoOutput(true);
      connection.setDoInput(true);
      connection.setConnectTimeout(paramInt);
      connection.setReadTimeout(paramInt);
      return;
    }
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
    throws IOException
  {
    LinkedList localLinkedList = new LinkedList();
    Map localMap = connection.getHeaderFields();
    if (localMap != null)
    {
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        List localList = (List)localMap.get(str);
        int i = 0;
        while (i < localList.size())
        {
          localLinkedList.add(new HeaderProperty(str, (String)localList.get(i)));
          i += 1;
        }
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
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/ksoap2/transport/ServiceConnectionSE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */