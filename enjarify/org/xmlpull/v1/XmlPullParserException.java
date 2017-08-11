package org.xmlpull.v1;

import java.io.PrintStream;

public class XmlPullParserException
  extends Exception
{
  protected int column;
  protected Throwable detail;
  protected int row;
  
  public XmlPullParserException(String paramString)
  {
    super(paramString);
    row = i;
    column = i;
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
    Object localObject1 = detail;
    if (localObject1 == null) {
      super.printStackTrace();
    }
    for (;;)
    {
      return;
      synchronized (System.err)
      {
        localObject1 = System.err;
        Object localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        String str = super.getMessage();
        localObject3 = ((StringBuilder)localObject3).append(str);
        str = "; nested exception is:";
        localObject3 = ((StringBuilder)localObject3).append(str);
        localObject3 = ((StringBuilder)localObject3).toString();
        ((PrintStream)localObject1).println((String)localObject3);
        localObject1 = detail;
        ((Throwable)localObject1).printStackTrace();
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/xmlpull/v1/XmlPullParserException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */