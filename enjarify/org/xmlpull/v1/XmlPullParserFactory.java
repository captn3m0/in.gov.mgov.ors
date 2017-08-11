package org.xmlpull.v1;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class XmlPullParserFactory
{
  public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
  private static final String RESOURCE_NAME = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
  static final Class referenceContextClass;
  protected String classNamesLocation;
  protected Hashtable features;
  protected Vector parserClasses;
  protected Vector serializerClasses;
  
  static
  {
    XmlPullParserFactory localXmlPullParserFactory = new org/xmlpull/v1/XmlPullParserFactory;
    localXmlPullParserFactory.<init>();
    referenceContextClass = localXmlPullParserFactory.getClass();
  }
  
  protected XmlPullParserFactory()
  {
    Hashtable localHashtable = new java/util/Hashtable;
    localHashtable.<init>();
    features = localHashtable;
  }
  
  public static XmlPullParserFactory newInstance()
  {
    return newInstance(null, null);
  }
  
  public static XmlPullParserFactory newInstance(String paramString, Class paramClass)
  {
    if (paramClass == null) {
      paramClass = referenceContextClass;
    }
    String str1 = null;
    if (paramString != null)
    {
      int i = paramString.length();
      if (i != 0)
      {
        localObject1 = "DEFAULT";
        boolean bool = ((String)localObject1).equals(paramString);
        if (!bool) {
          break label439;
        }
      }
    }
    Object localObject1 = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
    InputStream localInputStream;
    Object localObject2;
    try
    {
      localInputStream = paramClass.getResourceAsStream((String)localObject1);
      if (localInputStream == null)
      {
        localObject1 = new org/xmlpull/v1/XmlPullParserException;
        localObject2 = "resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available";
        ((XmlPullParserException)localObject1).<init>((String)localObject2);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException2)
    {
      localObject1 = new org/xmlpull/v1/XmlPullParserException;
      ((XmlPullParserException)localObject1).<init>(null, null, localException2);
      throw ((Throwable)localObject1);
    }
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    int k = localInputStream.read();
    label168:
    Object localObject3;
    Vector localVector1;
    Vector localVector2;
    if (k < 0)
    {
      localInputStream.close();
      paramString = localStringBuffer.toString();
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject1 = ((StringBuilder)localObject1).append("resource /META-INF/services/org.xmlpull.v1.XmlPullParserFactory that contained '").append(paramString);
      localObject2 = "'";
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
      str1 = ((StringBuilder)localObject1).toString();
      localObject3 = null;
      localVector1 = new java/util/Vector;
      localVector1.<init>();
      localVector2 = new java/util/Vector;
      localVector2.<init>();
    }
    int i4;
    for (int m = 0;; m = i4 + 1)
    {
      int j = paramString.length();
      int n = j;
      if (m >= j) {
        break label493;
      }
      int i3 = 44;
      i4 = paramString.indexOf(i3, m);
      j = -1;
      n = j;
      if (i4 == j) {
        i4 = paramString.length();
      }
      String str2 = paramString.substring(m, i4);
      Class localClass = null;
      Object localObject4 = null;
      try
      {
        localClass = Class.forName(str2);
        localObject4 = localClass.newInstance();
      }
      catch (Exception localException1)
      {
        int i5;
        int i1;
        int i2;
        label439:
        for (;;) {}
      }
      if (localClass != null)
      {
        i5 = 0;
        i1 = localObject4 instanceof XmlPullParser;
        j = i1;
        if (i1 != 0)
        {
          localVector1.addElement(localClass);
          i5 = 1;
        }
        i1 = localObject4 instanceof XmlSerializer;
        j = i1;
        if (i1 != 0)
        {
          localVector2.addElement(localClass);
          i5 = 1;
        }
        i1 = localObject4 instanceof XmlPullParserFactory;
        j = i1;
        if (i1 != 0)
        {
          if (localObject3 == null)
          {
            localObject3 = localObject4;
            localObject3 = (XmlPullParserFactory)localObject4;
          }
          i5 = 1;
        }
        if (i5 == 0)
        {
          localObject1 = new org/xmlpull/v1/XmlPullParserException;
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          localObject2 = "incompatible class: " + str2;
          ((XmlPullParserException)localObject1).<init>((String)localObject2);
          throw ((Throwable)localObject1);
          j = 32;
          i1 = j;
          if (k <= j) {
            break;
          }
          i2 = (char)k;
          j = i2;
          localStringBuffer.append(i2);
          break;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          localObject1 = ((StringBuilder)localObject1).append("parameter classNames to newInstance() that contained '").append(paramString);
          localObject2 = "'";
          localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
          str1 = ((StringBuilder)localObject1).toString();
          break label168;
        }
      }
    }
    label493:
    if (localObject3 == null)
    {
      localObject3 = new org/xmlpull/v1/XmlPullParserFactory;
      ((XmlPullParserFactory)localObject3).<init>();
    }
    parserClasses = localVector1;
    serializerClasses = localVector2;
    classNamesLocation = str1;
    return (XmlPullParserFactory)localObject3;
  }
  
  public boolean getFeature(String paramString)
  {
    Hashtable localHashtable = features;
    Boolean localBoolean = (Boolean)localHashtable.get(paramString);
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    }
    for (;;)
    {
      return bool;
      bool = false;
      localHashtable = null;
    }
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
  {
    Object localObject1 = parserClasses;
    String str;
    if (localObject1 == null)
    {
      localObject1 = new org/xmlpull/v1/XmlPullParserException;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = ((StringBuilder)localObject2).append("Factory initialization was incomplete - has not tried ");
      str = classNamesLocation;
      localObject2 = str;
      ((XmlPullParserException)localObject1).<init>((String)localObject2);
      throw ((Throwable)localObject1);
    }
    localObject1 = parserClasses;
    int i = ((Vector)localObject1).size();
    if (i == 0)
    {
      localObject1 = new org/xmlpull/v1/XmlPullParserException;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = ((StringBuilder)localObject2).append("No valid parser classes found in ");
      str = classNamesLocation;
      localObject2 = str;
      ((XmlPullParserException)localObject1).<init>((String)localObject2);
      throw ((Throwable)localObject1);
    }
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    int j = 0;
    Object localObject3;
    for (;;)
    {
      localObject1 = parserClasses;
      i = ((Vector)localObject1).size();
      if (j < i)
      {
        localObject1 = parserClasses;
        Class localClass = (Class)((Vector)localObject1).elementAt(j);
        try
        {
          localObject3 = localClass.newInstance();
          localObject3 = (XmlPullParser)localObject3;
          localObject1 = features;
          Enumeration localEnumeration = ((Hashtable)localObject1).keys();
          for (;;)
          {
            boolean bool = localEnumeration.hasMoreElements();
            if (!bool) {
              break;
            }
            Object localObject4 = localEnumeration.nextElement();
            localObject4 = (String)localObject4;
            localObject1 = features;
            Object localObject5 = ((Hashtable)localObject1).get(localObject4);
            localObject5 = (Boolean)localObject5;
            if (localObject5 != null)
            {
              bool = ((Boolean)localObject5).booleanValue();
              if (bool)
              {
                bool = true;
                ((XmlPullParser)localObject3).setFeature((String)localObject4, bool);
              }
            }
          }
        }
        catch (Exception localException)
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          localObject2 = localClass.getName();
          localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(": ");
          localObject2 = localException.toString();
          localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
          localObject2 = "; ";
          localObject1 = (String)localObject2;
          localStringBuffer.append((String)localObject1);
          j += 1;
        }
      }
    }
    localObject1 = new org/xmlpull/v1/XmlPullParserException;
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject2 = "could not create parser: " + localStringBuffer;
    ((XmlPullParserException)localObject1).<init>((String)localObject2);
    throw ((Throwable)localObject1);
    return (XmlPullParser)localObject3;
  }
  
  public XmlSerializer newSerializer()
  {
    Object localObject1 = serializerClasses;
    String str;
    if (localObject1 == null)
    {
      localObject1 = new org/xmlpull/v1/XmlPullParserException;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = ((StringBuilder)localObject2).append("Factory initialization incomplete - has not tried ");
      str = classNamesLocation;
      localObject2 = str;
      ((XmlPullParserException)localObject1).<init>((String)localObject2);
      throw ((Throwable)localObject1);
    }
    localObject1 = serializerClasses;
    int i = ((Vector)localObject1).size();
    if (i == 0)
    {
      localObject1 = new org/xmlpull/v1/XmlPullParserException;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = ((StringBuilder)localObject2).append("No valid serializer classes found in ");
      str = classNamesLocation;
      localObject2 = str;
      ((XmlPullParserException)localObject1).<init>((String)localObject2);
      throw ((Throwable)localObject1);
    }
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    int j = 0;
    for (;;)
    {
      localObject1 = serializerClasses;
      i = ((Vector)localObject1).size();
      if (j >= i) {
        break;
      }
      localObject1 = serializerClasses;
      Class localClass = (Class)((Vector)localObject1).elementAt(j);
      try
      {
        Object localObject3 = localClass.newInstance();
        return (XmlSerializer)localObject3;
      }
      catch (Exception localException)
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localObject2 = localClass.getName();
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(": ");
        localObject2 = localException.toString();
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
        localObject2 = "; ";
        localObject1 = (String)localObject2;
        localStringBuffer.append((String)localObject1);
        j += 1;
      }
    }
    localObject1 = new org/xmlpull/v1/XmlPullParserException;
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject2 = "could not create serializer: " + localStringBuffer;
    ((XmlPullParserException)localObject1).<init>((String)localObject2);
    throw ((Throwable)localObject1);
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    Hashtable localHashtable = features;
    Boolean localBoolean = new java/lang/Boolean;
    localBoolean.<init>(paramBoolean);
    localHashtable.put(paramString, localBoolean);
  }
  
  public void setNamespaceAware(boolean paramBoolean)
  {
    Hashtable localHashtable = features;
    Boolean localBoolean = new java/lang/Boolean;
    localBoolean.<init>(paramBoolean);
    localHashtable.put("http://xmlpull.org/v1/doc/features.html#process-namespaces", localBoolean);
  }
  
  public void setValidating(boolean paramBoolean)
  {
    Hashtable localHashtable = features;
    Boolean localBoolean = new java/lang/Boolean;
    localBoolean.<init>(paramBoolean);
    localHashtable.put("http://xmlpull.org/v1/doc/features.html#validation", localBoolean);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/xmlpull/v1/XmlPullParserFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */