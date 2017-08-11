package org.kxml2.kdom;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class Document
  extends Node
{
  String encoding;
  protected int rootIndex = -1;
  Boolean standalone;
  
  public void addChild(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt2 == 2) {
      rootIndex = paramInt1;
    }
    for (;;)
    {
      super.addChild(paramInt1, paramInt2, paramObject);
      return;
      if (rootIndex >= paramInt1) {
        rootIndex += 1;
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
    if (rootIndex == -1) {
      throw new RuntimeException("Document has no root element!");
    }
    return (Element)getChild(rootIndex);
  }
  
  public Boolean getStandalone()
  {
    return standalone;
  }
  
  public void parse(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    paramXmlPullParser.require(0, null, null);
    paramXmlPullParser.nextToken();
    encoding = paramXmlPullParser.getInputEncoding();
    standalone = ((Boolean)paramXmlPullParser.getProperty("http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone"));
    super.parse(paramXmlPullParser);
    if (paramXmlPullParser.getEventType() != 1) {
      throw new RuntimeException("Document end expected!");
    }
  }
  
  public void removeChild(int paramInt)
  {
    if (paramInt == rootIndex) {
      rootIndex = -1;
    }
    for (;;)
    {
      super.removeChild(paramInt);
      return;
      if (paramInt < rootIndex) {
        rootIndex -= 1;
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
    throws IOException
  {
    paramXmlSerializer.startDocument(encoding, standalone);
    writeChildren(paramXmlSerializer);
    paramXmlSerializer.endDocument();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kxml2/kdom/Document.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */