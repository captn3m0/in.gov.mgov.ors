package org.ksoap2.transport;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public abstract interface ServiceConnection
{
  public static final int DEFAULT_BUFFER_SIZE = 262144;
  public static final int DEFAULT_TIMEOUT = 20000;
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract InputStream getErrorStream();
  
  public abstract String getHost();
  
  public abstract String getPath();
  
  public abstract int getPort();
  
  public abstract int getResponseCode();
  
  public abstract List getResponseProperties();
  
  public abstract InputStream openInputStream();
  
  public abstract OutputStream openOutputStream();
  
  public abstract void setFixedLengthStreamingMode(int paramInt);
  
  public abstract void setRequestMethod(String paramString);
  
  public abstract void setRequestProperty(String paramString1, String paramString2);
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/transport/ServiceConnection.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */