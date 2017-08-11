package org.xmlpull.v1;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class XmlPullParserFactory
{
  public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
  private static final String RESOURCE_NAME = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
  static final Class referenceContextClass = new XmlPullParserFactory().getClass();
  protected String classNamesLocation;
  protected Hashtable features = new Hashtable();
  protected Vector parserClasses;
  protected Vector serializerClasses;
  
  public static XmlPullParserFactory newInstance()
    throws XmlPullParserException
  {
    return newInstance(null, null);
  }
  
  public static XmlPullParserFactory newInstance(String paramString, Class paramClass)
    throws XmlPullParserException
  {
    Object localObject1 = paramClass;
    if (paramClass == null) {
      localObject1 = referenceContextClass;
    }
    int i;
    String str1;
    label120:
    Vector localVector1;
    Vector localVector2;
    if ((paramString == null) || (paramString.length() == 0) || ("DEFAULT".equals(paramString)))
    {
      try
      {
        paramString = ((Class)localObject1).getResourceAsStream("/META-INF/services/org.xmlpull.v1.XmlPullParserFactory");
        if (paramString == null) {
          throw new XmlPullParserException("resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available");
        }
      }
      catch (Exception paramString)
      {
        throw new XmlPullParserException(null, null, paramString);
      }
      paramClass = new StringBuffer();
      i = paramString.read();
      if (i < 0)
      {
        paramString.close();
        str1 = paramClass.toString();
        localObject1 = "resource /META-INF/services/org.xmlpull.v1.XmlPullParserFactory that contained '" + str1 + "'";
        paramString = null;
        localVector1 = new Vector();
        localVector2 = new Vector();
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= str1.length()) {
        break label378;
      }
      int k = str1.indexOf(',', i);
      int j = k;
      if (k == -1) {
        j = str1.length();
      }
      String str2 = str1.substring(i, j);
      paramClass = null;
      Object localObject3 = null;
      try
      {
        localObject2 = Class.forName(str2);
        paramClass = (Class)localObject2;
        Object localObject4 = ((Class)localObject2).newInstance();
        localObject3 = localObject4;
        paramClass = (Class)localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        char c;
        for (;;) {}
      }
      localObject2 = paramString;
      if (paramClass != null)
      {
        i = 0;
        if ((localObject3 instanceof XmlPullParser))
        {
          localVector1.addElement(paramClass);
          i = 1;
        }
        if ((localObject3 instanceof XmlSerializer))
        {
          localVector2.addElement(paramClass);
          i = 1;
        }
        paramClass = paramString;
        if ((localObject3 instanceof XmlPullParserFactory))
        {
          paramClass = paramString;
          if (paramString == null) {
            paramClass = (XmlPullParserFactory)localObject3;
          }
          i = 1;
        }
        localObject2 = paramClass;
        if (i == 0)
        {
          throw new XmlPullParserException("incompatible class: " + str2);
          if (i <= 32) {
            break;
          }
          c = (char)i;
          paramClass.append(c);
          break;
          localObject1 = "parameter classNames to newInstance() that contained '" + paramString + "'";
          str1 = paramString;
          break label120;
        }
      }
      i = j + 1;
      paramString = (String)localObject2;
    }
    label378:
    paramClass = paramString;
    if (paramString == null) {
      paramClass = new XmlPullParserFactory();
    }
    parserClasses = localVector1;
    serializerClasses = localVector2;
    classNamesLocation = ((String)localObject1);
    return paramClass;
  }
  
  public boolean getFeature(String paramString)
  {
    paramString = (Boolean)features.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  public boolean isNamespaceAware()
  {
    return getFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces");
  }
  
  public boolean isValidating()
  {
    return getFeature("http://xmlpull.org/v1/doc/features.html#validation");
  }
  
  public XmlPullParser newPullParser()
    throws XmlPullParserException
  {
    if (parserClasses == null) {
      throw new XmlPullParserException("Factory initialization was incomplete - has not tried " + classNamesLocation);
    }
    if (parserClasses.size() == 0) {
      throw new XmlPullParserException("No valid parser classes found in " + classNamesLocation);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i < parserClasses.size())
      {
        Class localClass = (Class)parserClasses.elementAt(i);
        try
        {
          XmlPullParser localXmlPullParser = (XmlPullParser)localClass.newInstance();
          Enumeration localEnumeration = features.keys();
          while (localEnumeration.hasMoreElements())
          {
            String str = (String)localEnumeration.nextElement();
            Boolean localBoolean = (Boolean)features.get(str);
            if ((localBoolean != null) && (localBoolean.booleanValue())) {
              localXmlPullParser.setFeature(str, true);
            }
          }
        }
        catch (Exception localException)
        {
          localStringBuffer.append(localClass.getName() + ": " + localException.toString() + "; ");
          i += 1;
        }
      }
    }
    throw new XmlPullParserException("could not create parser: " + localStringBuffer);
    return localException;
  }
  
  public XmlSerializer newSerializer()
    throws XmlPullParserException
  {
    if (serializerClasses == null) {
      throw new XmlPullParserException("Factory initialization incomplete - has not tried " + classNamesLocation);
    }
    if (serializerClasses.size() == 0) {
      throw new XmlPullParserException("No valid serializer classes found in " + classNamesLocation);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < serializerClasses.size())
    {
      Class localClass = (Class)serializerClasses.elementAt(i);
      try
      {
        XmlSerializer localXmlSerializer = (XmlSerializer)localClass.newInstance();
        return localXmlSerializer;
      }
      catch (Exception localException)
      {
        localStringBuffer.append(localClass.getName() + ": " + localException.toString() + "; ");
        i += 1;
      }
    }
    throw new XmlPullParserException("could not create serializer: " + localStringBuffer);
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
    throws XmlPullParserException
  {
    features.put(paramString, new Boolean(paramBoolean));
  }
  
  public void setNamespaceAware(boolean paramBoolean)
  {
    features.put("http://xmlpull.org/v1/doc/features.html#process-namespaces", new Boolean(paramBoolean));
  }
  
  public void setValidating(boolean paramBoolean)
  {
    features.put("http://xmlpull.org/v1/doc/features.html#validation", new Boolean(paramBoolean));
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/xmlpull/v1/XmlPullParserFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */