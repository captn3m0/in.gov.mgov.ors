package org.ksoap2.transport;

public class HttpsServiceConnectionSEIgnoringConnectionClose
  extends HttpsServiceConnectionSE
{
  public HttpsServiceConnectionSEIgnoringConnectionClose(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    String str = "Connection";
    boolean bool = str.equalsIgnoreCase(paramString1);
    if (!bool)
    {
      str = "close";
      bool = str.equalsIgnoreCase(paramString2);
      if (!bool) {
        super.setRequestProperty(paramString1, paramString2);
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/transport/HttpsServiceConnectionSEIgnoringConnectionClose.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */