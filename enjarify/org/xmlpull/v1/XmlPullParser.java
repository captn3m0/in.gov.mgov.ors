package org.xmlpull.v1;

import java.io.InputStream;
import java.io.Reader;

public abstract interface XmlPullParser
{
  public static final int CDSECT = 5;
  public static final int COMMENT = 9;
  public static final int DOCDECL = 10;
  public static final int END_DOCUMENT = 1;
  public static final int END_TAG = 3;
  public static final int ENTITY_REF = 6;
  public static final String FEATURE_PROCESS_DOCDECL = "http://xmlpull.org/v1/doc/features.html#process-docdecl";
  public static final String FEATURE_PROCESS_NAMESPACES = "http://xmlpull.org/v1/doc/features.html#process-namespaces";
  public static final String FEATURE_REPORT_NAMESPACE_ATTRIBUTES = "http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes";
  public static final String FEATURE_VALIDATION = "http://xmlpull.org/v1/doc/features.html#validation";
  public static final int IGNORABLE_WHITESPACE = 7;
  public static final String NO_NAMESPACE = "";
  public static final int PROCESSING_INSTRUCTION = 8;
  public static final int START_DOCUMENT = 0;
  public static final int START_TAG = 2;
  public static final int TEXT = 4;
  public static final String[] TYPES;
  
  static
  {
    String[] arrayOfString = new String[11];
    arrayOfString[0] = "START_DOCUMENT";
    arrayOfString[1] = "END_DOCUMENT";
    arrayOfString[2] = "START_TAG";
    arrayOfString[3] = "END_TAG";
    arrayOfString[4] = "TEXT";
    arrayOfString[5] = "CDSECT";
    arrayOfString[6] = "ENTITY_REF";
    arrayOfString[7] = "IGNORABLE_WHITESPACE";
    arrayOfString[8] = "PROCESSING_INSTRUCTION";
    arrayOfString[9] = "COMMENT";
    arrayOfString[10] = "DOCDECL";
    TYPES = arrayOfString;
  }
  
  public abstract void defineEntityReplacementText(String paramString1, String paramString2);
  
  public abstract int getAttributeCount();
  
  public abstract String getAttributeName(int paramInt);
  
  public abstract String getAttributeNamespace(int paramInt);
  
  public abstract String getAttributePrefix(int paramInt);
  
  public abstract String getAttributeType(int paramInt);
  
  public abstract String getAttributeValue(int paramInt);
  
  public abstract String getAttributeValue(String paramString1, String paramString2);
  
  public abstract int getColumnNumber();
  
  public abstract int getDepth();
  
  public abstract int getEventType();
  
  public abstract boolean getFeature(String paramString);
  
  public abstract String getInputEncoding();
  
  public abstract int getLineNumber();
  
  public abstract String getName();
  
  public abstract String getNamespace();
  
  public abstract String getNamespace(String paramString);
  
  public abstract int getNamespaceCount(int paramInt);
  
  public abstract String getNamespacePrefix(int paramInt);
  
  public abstract String getNamespaceUri(int paramInt);
  
  public abstract String getPositionDescription();
  
  public abstract String getPrefix();
  
  public abstract Object getProperty(String paramString);
  
  public abstract String getText();
  
  public abstract char[] getTextCharacters(int[] paramArrayOfInt);
  
  public abstract boolean isAttributeDefault(int paramInt);
  
  public abstract boolean isEmptyElementTag();
  
  public abstract boolean isWhitespace();
  
  public abstract int next();
  
  public abstract int nextTag();
  
  public abstract String nextText();
  
  public abstract int nextToken();
  
  public abstract void require(int paramInt, String paramString1, String paramString2);
  
  public abstract void setFeature(String paramString, boolean paramBoolean);
  
  public abstract void setInput(InputStream paramInputStream, String paramString);
  
  public abstract void setInput(Reader paramReader);
  
  public abstract void setProperty(String paramString, Object paramObject);
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/xmlpull/v1/XmlPullParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */