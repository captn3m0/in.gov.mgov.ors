package org.ksoap2.transport;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import org.ksoap2.SoapEnvelope;
import org.kxml2.io.KXmlParser;
import org.kxml2.io.KXmlSerializer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public abstract class Transport
{
  protected static final String CONTENT_TYPE_SOAP_XML_CHARSET_UTF_8 = "application/soap+xml;charset=utf-8";
  protected static final String CONTENT_TYPE_XML_CHARSET_UTF_8 = "text/xml;charset=utf-8";
  protected static final String USER_AGENT = "ksoap2-android/2.6.0+";
  private int bufferLength = 262144;
  public boolean debug;
  protected Proxy proxy;
  public String requestDump;
  public String responseDump;
  protected int timeout = 20000;
  protected String url;
  private String xmlVersionTag = "";
  
  public Transport() {}
  
  public Transport(String paramString)
  {
    this(null, paramString);
  }
  
  public Transport(String paramString, int paramInt)
  {
    url = paramString;
    timeout = paramInt;
  }
  
  public Transport(String paramString, int paramInt1, int paramInt2)
  {
    url = paramString;
    timeout = paramInt1;
    bufferLength = paramInt2;
  }
  
  public Transport(Proxy paramProxy, String paramString)
  {
    proxy = paramProxy;
    url = paramString;
  }
  
  public Transport(Proxy paramProxy, String paramString, int paramInt)
  {
    proxy = paramProxy;
    url = paramString;
    timeout = paramInt;
  }
  
  public Transport(Proxy paramProxy, String paramString, int paramInt1, int paramInt2)
  {
    proxy = paramProxy;
    url = paramString;
    timeout = paramInt1;
    bufferLength = paramInt2;
  }
  
  public abstract List call(String paramString, SoapEnvelope paramSoapEnvelope, List paramList);
  
  public abstract List call(String paramString, SoapEnvelope paramSoapEnvelope, List paramList, File paramFile);
  
  public void call(String paramString, SoapEnvelope paramSoapEnvelope)
  {
    call(paramString, paramSoapEnvelope, null);
  }
  
  protected byte[] createRequestData(SoapEnvelope paramSoapEnvelope)
  {
    return createRequestData(paramSoapEnvelope, null);
  }
  
  protected byte[] createRequestData(SoapEnvelope paramSoapEnvelope, String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
    int i = bufferLength;
    localByteArrayOutputStream.<init>(i);
    byte[] arrayOfByte = xmlVersionTag.getBytes();
    localByteArrayOutputStream.write(arrayOfByte);
    KXmlSerializer localKXmlSerializer = new org/kxml2/io/KXmlSerializer;
    localKXmlSerializer.<init>();
    localKXmlSerializer.setOutput(localByteArrayOutputStream, paramString);
    paramSoapEnvelope.write(localKXmlSerializer);
    localKXmlSerializer.flush();
    localByteArrayOutputStream.write(13);
    localByteArrayOutputStream.write(10);
    localByteArrayOutputStream.flush();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public String getHost()
  {
    URL localURL = new java/net/URL;
    String str = url;
    localURL.<init>(str);
    return localURL.getHost();
  }
  
  public String getPath()
  {
    URL localURL = new java/net/URL;
    String str = url;
    localURL.<init>(str);
    return localURL.getPath();
  }
  
  public int getPort()
  {
    URL localURL = new java/net/URL;
    String str = url;
    localURL.<init>(str);
    return localURL.getPort();
  }
  
  public abstract ServiceConnection getServiceConnection();
  
  protected void parseResponse(SoapEnvelope paramSoapEnvelope, InputStream paramInputStream)
  {
    KXmlParser localKXmlParser = new org/kxml2/io/KXmlParser;
    localKXmlParser.<init>();
    localKXmlParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
    localKXmlParser.setInput(paramInputStream, null);
    paramSoapEnvelope.parse(localKXmlParser);
    paramInputStream.close();
  }
  
  public void reset() {}
  
  public void setUrl(String paramString)
  {
    url = paramString;
  }
  
  public void setXmlVersionTag(String paramString)
  {
    xmlVersionTag = paramString;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/transport/Transport.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */