package org.ksoap2.transport;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;

public class HttpTransportSE
  extends Transport
{
  public HttpTransportSE(String paramString)
  {
    super(null, paramString);
  }
  
  public HttpTransportSE(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public HttpTransportSE(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1);
  }
  
  public HttpTransportSE(Proxy paramProxy, String paramString)
  {
    super(paramProxy, paramString);
  }
  
  public HttpTransportSE(Proxy paramProxy, String paramString, int paramInt)
  {
    super(paramProxy, paramString, paramInt);
  }
  
  public HttpTransportSE(Proxy paramProxy, String paramString, int paramInt1, int paramInt2)
  {
    super(paramProxy, paramString, paramInt1);
  }
  
  private InputStream getUnZippedInputStream(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = (GZIPInputStream)paramInputStream;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        GZIPInputStream localGZIPInputStream = new java/util/zip/GZIPInputStream;
        localGZIPInputStream.<init>(paramInputStream);
        paramInputStream = localGZIPInputStream;
      }
    }
    return paramInputStream;
  }
  
  private InputStream readDebug(InputStream paramInputStream, int paramInt, File paramFile)
  {
    int i = 256;
    Object localObject1;
    byte[] arrayOfByte;
    if (paramFile != null)
    {
      localObject1 = new java/io/FileOutputStream;
      ((FileOutputStream)localObject1).<init>(paramFile);
      arrayOfByte = new byte[i];
    }
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte, 0, i);
      int k = -1;
      if (j == k)
      {
        ((OutputStream)localObject1).flush();
        boolean bool = localObject1 instanceof ByteArrayOutputStream;
        if (bool)
        {
          localObject1 = (ByteArrayOutputStream)localObject1;
          arrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
        }
        Object localObject2 = new java/lang/String;
        ((String)localObject2).<init>(arrayOfByte);
        responseDump = ((String)localObject2);
        paramInputStream.close();
        localObject2 = new java/io/ByteArrayInputStream;
        ((ByteArrayInputStream)localObject2).<init>(arrayOfByte);
        return (InputStream)localObject2;
        localObject1 = new java/io/ByteArrayOutputStream;
        if (paramInt > 0) {}
        for (;;)
        {
          ((ByteArrayOutputStream)localObject1).<init>(paramInt);
          break;
          paramInt = 262144;
        }
      }
      ((OutputStream)localObject1).write(arrayOfByte, 0, j);
    }
  }
  
  public List call(String paramString, SoapEnvelope paramSoapEnvelope, List paramList)
  {
    return call(paramString, paramSoapEnvelope, paramList, null);
  }
  
  public List call(String paramString, SoapEnvelope paramSoapEnvelope, List paramList, File paramFile)
  {
    if (paramString == null) {
      paramString = "\"\"";
    }
    Object localObject1 = "UTF-8";
    Object localObject2 = this;
    byte[] arrayOfByte = createRequestData(paramSoapEnvelope, (String)localObject1);
    boolean bool1 = debug;
    ServiceConnection localServiceConnection;
    if (bool1)
    {
      localObject1 = new java/lang/String;
      ((String)localObject1).<init>(arrayOfByte);
      localObject2 = this;
      requestDump = ((String)localObject1);
      responseDump = null;
      localServiceConnection = getServiceConnection();
      localObject1 = "User-Agent";
      localObject3 = "ksoap2-android/2.6.0+";
      localObject2 = localObject3;
      localServiceConnection.setRequestProperty((String)localObject1, (String)localObject3);
      localObject2 = paramSoapEnvelope;
      i = version;
      k = 120;
      m = k;
      if (i != k)
      {
        localObject1 = "SOAPAction";
        localObject2 = paramString;
        localServiceConnection.setRequestProperty((String)localObject1, paramString);
      }
      localObject2 = paramSoapEnvelope;
      i = version;
      k = 120;
      m = k;
      if (i != k) {
        break label365;
      }
      localObject1 = "Content-Type";
      localObject3 = "application/soap+xml;charset=utf-8";
      localObject2 = localObject3;
      localServiceConnection.setRequestProperty((String)localObject1, (String)localObject3);
    }
    String str;
    int n;
    Object localObject4;
    for (;;)
    {
      localObject2 = "close";
      localServiceConnection.setRequestProperty("Connection", (String)localObject2);
      localObject2 = "gzip";
      localServiceConnection.setRequestProperty("Accept-Encoding", (String)localObject2);
      localObject1 = "Content-Length";
      localObject3 = new java/lang/StringBuffer;
      ((StringBuffer)localObject3).<init>();
      str = "";
      localObject3 = ((StringBuffer)localObject3).append(str);
      m = arrayOfByte.length;
      localObject3 = m;
      localObject2 = localObject3;
      localServiceConnection.setRequestProperty((String)localObject1, (String)localObject3);
      i = arrayOfByte.length;
      localServiceConnection.setFixedLengthStreamingMode(i);
      if (paramList == null) {
        break label391;
      }
      n = 0;
      for (;;)
      {
        i = paramList.size();
        if (n >= i) {
          break;
        }
        localObject2 = paramList;
        localObject4 = (HeaderProperty)paramList.get(n);
        localObject1 = ((HeaderProperty)localObject4).getKey();
        localObject3 = ((HeaderProperty)localObject4).getValue();
        localObject2 = localObject3;
        localServiceConnection.setRequestProperty((String)localObject1, (String)localObject3);
        n += 1;
      }
      i = 0;
      localObject1 = null;
      break;
      label365:
      localObject1 = "Content-Type";
      localObject3 = "text/xml;charset=utf-8";
      localObject2 = localObject3;
      localServiceConnection.setRequestProperty((String)localObject1, (String)localObject3);
    }
    label391:
    localServiceConnection.setRequestMethod("POST");
    OutputStream localOutputStream = localServiceConnection.openOutputStream();
    int i = 0;
    localObject1 = null;
    int m = arrayOfByte.length;
    int k = m;
    localOutputStream.write(arrayOfByte, 0, m);
    localOutputStream.flush();
    localOutputStream.close();
    arrayOfByte = null;
    List localList = null;
    int i1 = 8192;
    int i2 = 0;
    try
    {
      int i3 = localServiceConnection.getResponseCode();
      i = 200;
      if (i3 == i) {
        break label622;
      }
      localObject1 = new java/io/IOException;
      localObject3 = new java/lang/StringBuffer;
      ((StringBuffer)localObject3).<init>();
      str = "HTTP request failed, HTTP status: ";
      localObject3 = ((StringBuffer)localObject3).append(str);
      localObject2 = localObject3;
      localObject3 = ((StringBuffer)localObject3).append(i3);
      localObject3 = ((StringBuffer)localObject3).toString();
      ((IOException)localObject1).<init>((String)localObject3);
      throw ((Throwable)localObject1);
    }
    catch (IOException localIOException)
    {
      if (i2 == 0) {
        break label910;
      }
    }
    localObject1 = new java/io/BufferedInputStream;
    Object localObject3 = localServiceConnection.getErrorStream();
    localObject2 = localObject3;
    ((BufferedInputStream)localObject1).<init>((InputStream)localObject3, i1);
    localObject2 = this;
    Object localObject5 = getUnZippedInputStream((InputStream)localObject1);
    for (;;)
    {
      localObject2 = this;
      boolean bool2 = debug;
      if ((bool2) && (localObject5 != null)) {
        readDebug((InputStream)localObject5, i1, paramFile);
      }
      localServiceConnection.disconnect();
      throw localIOException;
      label622:
      localList = localServiceConnection.getResponseProperties();
      n = 0;
      int j = localList.size();
      boolean bool3;
      if (n < j)
      {
        localObject4 = localList.get(n);
        localObject4 = (HeaderProperty)localObject4;
        localObject1 = ((HeaderProperty)localObject4).getKey();
        if (localObject1 == null) {}
        do
        {
          do
          {
            n += 1;
            break;
            localObject1 = ((HeaderProperty)localObject4).getKey();
            localObject3 = "content-length";
            bool3 = ((String)localObject1).equalsIgnoreCase((String)localObject3);
            if (bool3)
            {
              localObject1 = ((HeaderProperty)localObject4).getValue();
              if (localObject1 == null) {}
            }
            try
            {
              localObject1 = ((HeaderProperty)localObject4).getValue();
              i1 = Integer.parseInt((String)localObject1);
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                i1 = 8192;
                continue;
                localObject5 = new java/io/BufferedInputStream;
                localObject1 = localServiceConnection.openInputStream();
                ((BufferedInputStream)localObject5).<init>((InputStream)localObject1, i1);
              }
            }
            localObject1 = ((HeaderProperty)localObject4).getKey();
            localObject3 = "Content-Encoding";
            bool3 = ((String)localObject1).equalsIgnoreCase((String)localObject3);
          } while (!bool3);
          localObject1 = ((HeaderProperty)localObject4).getValue();
          localObject3 = "gzip";
          bool3 = ((String)localObject1).equalsIgnoreCase((String)localObject3);
        } while (!bool3);
        i2 = 1;
      }
      else if (i2 != 0)
      {
        localObject1 = new java/io/BufferedInputStream;
        localObject3 = localServiceConnection.openInputStream();
        localObject2 = localObject3;
        ((BufferedInputStream)localObject1).<init>((InputStream)localObject3, i1);
        localObject2 = this;
        localObject5 = getUnZippedInputStream((InputStream)localObject1);
        localObject2 = this;
        bool3 = debug;
        if (bool3) {
          localObject5 = readDebug((InputStream)localObject5, i1, paramFile);
        }
        localObject2 = this;
        parseResponse(paramSoapEnvelope, (InputStream)localObject5);
        return localList;
      }
      label910:
      localObject5 = new java/io/BufferedInputStream;
      localObject1 = localServiceConnection.getErrorStream();
      ((BufferedInputStream)localObject5).<init>((InputStream)localObject1, i1);
    }
  }
  
  public void call(String paramString, SoapEnvelope paramSoapEnvelope)
  {
    call(paramString, paramSoapEnvelope, null);
  }
  
  public ServiceConnection getServiceConnection()
  {
    ServiceConnectionSE localServiceConnectionSE = new org/ksoap2/transport/ServiceConnectionSE;
    Proxy localProxy = proxy;
    String str = url;
    int i = timeout;
    localServiceConnectionSE.<init>(localProxy, str, i);
    return localServiceConnectionSE;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/transport/HttpTransportSE.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */