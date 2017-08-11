package org.xmlpull.v1;

import java.io.OutputStream;
import java.io.Writer;

public abstract interface XmlSerializer
{
  public abstract XmlSerializer attribute(String paramString1, String paramString2, String paramString3);
  
  public abstract void cdsect(String paramString);
  
  public abstract void comment(String paramString);
  
  public abstract void docdecl(String paramString);
  
  public abstract void endDocument();
  
  public abstract XmlSerializer endTag(String paramString1, String paramString2);
  
  public abstract void entityRef(String paramString);
  
  public abstract void flush();
  
  public abstract int getDepth();
  
  public abstract boolean getFeature(String paramString);
  
  public abstract String getName();
  
  public abstract String getNamespace();
  
  public abstract String getPrefix(String paramString, boolean paramBoolean);
  
  public abstract Object getProperty(String paramString);
  
  public abstract void ignorableWhitespace(String paramString);
  
  public abstract void processingInstruction(String paramString);
  
  public abstract void setFeature(String paramString, boolean paramBoolean);
  
  public abstract void setOutput(OutputStream paramOutputStream, String paramString);
  
  public abstract void setOutput(Writer paramWriter);
  
  public abstract void setPrefix(String paramString1, String paramString2);
  
  public abstract void setProperty(String paramString, Object paramObject);
  
  public abstract void startDocument(String paramString, Boolean paramBoolean);
  
  public abstract XmlSerializer startTag(String paramString1, String paramString2);
  
  public abstract XmlSerializer text(String paramString);
  
  public abstract XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2);
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/xmlpull/v1/XmlSerializer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */