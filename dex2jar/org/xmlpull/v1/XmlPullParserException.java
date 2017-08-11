package org.xmlpull.v1;

import java.io.PrintStream;

public class XmlPullParserException
  extends Exception
{
  protected int column = -1;
  protected Throwable detail;
  protected int row = -1;
  
  public XmlPullParserException(String paramString)
  {
    super(paramString);
  }
  
  public XmlPullParserException(String paramString, XmlPullParser paramXmlPullParser, Throwable paramThrowable) {}
  
  public int getColumnNumber()
  {
    return column;
  }
  
  public Throwable getDetail()
  {
    return detail;
  }
  
  public int getLineNumber()
  {
    return row;
  }
  
  public void printStackTrace()
  {
    if (detail == null)
    {
      super.printStackTrace();
      return;
    }
    synchronized (System.err)
    {
      System.err.println(super.getMessage() + "; nested exception is:");
      detail.printStackTrace();
      return;
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/xmlpull/v1/XmlPullParserException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */