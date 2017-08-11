package org.kxml2.kdom;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class Document
  extends Node
{
  String encoding;
  protected int rootIndex = -1;
  Boolean standalone;
  
  public void addChild(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = 2;
    if (paramInt2 == i) {
      rootIndex = paramInt1;
    }
    for (;;)
    {
      super.addChild(paramInt1, paramInt2, paramObject);
      return;
      i = rootIndex;
      if (i >= paramInt1)
      {
        i = rootIndex + 1;
        rootIndex = i;
      }
    }
  }
  
  public String getEncoding()
  {
    return encoding;
  }
  
  public String getName()
  {
    return "#document";
  }
  
  public Element getRootElement()
  {
    int i = rootIndex;
    int j = -1;
    if (i == j)
    {
      RuntimeException localRuntimeException = new java/lang/RuntimeException;
      localRuntimeException.<init>("Document has no root element!");
      throw localRuntimeException;
    }
    i = rootIndex;
    return (Element)getChild(i);
  }
  
  public Boolean getStandalone()
  {
    return standalone;
  }
  
  public void parse(XmlPullParser paramXmlPullParser)
  {
    paramXmlPullParser.require(0, null, null);
    paramXmlPullParser.nextToken();
    Object localObject = paramXmlPullParser.getInputEncoding();
    encoding = ((String)localObject);
    localObject = (Boolean)paramXmlPullParser.getProperty("http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone");
    standalone = ((Boolean)localObject);
    super.parse(paramXmlPullParser);
    int i = paramXmlPullParser.getEventType();
    int j = 1;
    if (i != j)
    {
      localObject = new java/lang/RuntimeException;
      ((RuntimeException)localObject).<init>("Document end expected!");
      throw ((Throwable)localObject);
    }
  }
  
  public void removeChild(int paramInt)
  {
    int i = rootIndex;
    if (paramInt == i)
    {
      i = -1;
      rootIndex = i;
    }
    for (;;)
    {
      super.removeChild(paramInt);
      return;
      i = rootIndex;
      if (paramInt < i)
      {
        i = rootIndex + -1;
        rootIndex = i;
      }
    }
  }
  
  public void setEncoding(String paramString)
  {
    encoding = paramString;
  }
  
  public void setStandalone(Boolean paramBoolean)
  {
    standalone = paramBoolean;
  }
  
  public void write(XmlSerializer paramXmlSerializer)
  {
    String str = encoding;
    Boolean localBoolean = standalone;
    paramXmlSerializer.startDocument(str, localBoolean);
    writeChildren(paramXmlSerializer);
    paramXmlSerializer.endDocument();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kxml2/kdom/Document.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */