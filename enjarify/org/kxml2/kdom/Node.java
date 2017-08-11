package org.kxml2.kdom;

import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class Node
{
  public static final int CDSECT = 5;
  public static final int COMMENT = 9;
  public static final int DOCDECL = 10;
  public static final int DOCUMENT = 0;
  public static final int ELEMENT = 2;
  public static final int ENTITY_REF = 6;
  public static final int IGNORABLE_WHITESPACE = 7;
  public static final int PROCESSING_INSTRUCTION = 8;
  public static final int TEXT = 4;
  protected Vector children;
  protected StringBuffer types;
  
  public void addChild(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramObject == null)
    {
      localObject = new java/lang/NullPointerException;
      ((NullPointerException)localObject).<init>();
      throw ((Throwable)localObject);
    }
    Object localObject = children;
    if (localObject == null)
    {
      localObject = new java/util/Vector;
      ((Vector)localObject).<init>();
      children = ((Vector)localObject);
      localObject = new java/lang/StringBuffer;
      ((StringBuffer)localObject).<init>();
      types = ((StringBuffer)localObject);
    }
    int i = 2;
    boolean bool;
    if (paramInt2 == i)
    {
      bool = paramObject instanceof Element;
      if (!bool)
      {
        localObject = new java/lang/RuntimeException;
        ((RuntimeException)localObject).<init>("Element obj expected)");
        throw ((Throwable)localObject);
      }
      localObject = paramObject;
      localObject = (Element)paramObject;
      ((Element)localObject).setParent(this);
    }
    do
    {
      children.insertElementAt(paramObject, paramInt1);
      localObject = types;
      char c = (char)paramInt2;
      ((StringBuffer)localObject).insert(paramInt1, c);
      return;
      bool = paramObject instanceof String;
    } while (bool);
    localObject = new java/lang/RuntimeException;
    ((RuntimeException)localObject).<init>("String expected");
    throw ((Throwable)localObject);
  }
  
  public void addChild(int paramInt, Object paramObject)
  {
    int i = getChildCount();
    addChild(i, paramInt, paramObject);
  }
  
  public Element createElement(String paramString1, String paramString2)
  {
    Element localElement = new org/kxml2/kdom/Element;
    localElement.<init>();
    if (paramString1 == null) {
      paramString1 = "";
    }
    namespace = paramString1;
    name = paramString2;
    return localElement;
  }
  
  public Object getChild(int paramInt)
  {
    return children.elementAt(paramInt);
  }
  
  public int getChildCount()
  {
    Vector localVector = children;
    int i;
    if (localVector == null)
    {
      i = 0;
      localVector = null;
    }
    for (;;)
    {
      return i;
      localVector = children;
      i = localVector.size();
    }
  }
  
  public Element getElement(int paramInt)
  {
    Object localObject = getChild(paramInt);
    boolean bool = localObject instanceof Element;
    if (bool) {}
    for (localObject = (Element)localObject;; localObject = null) {
      return (Element)localObject;
    }
  }
  
  public Element getElement(String paramString1, String paramString2)
  {
    int i = -1;
    Object localObject = null;
    int j = indexOf(paramString1, paramString2, 0);
    int k = j + 1;
    int m = indexOf(paramString1, paramString2, k);
    if ((j == i) || (m != i))
    {
      RuntimeException localRuntimeException = new java/lang/RuntimeException;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = ((StringBuilder)localObject).append("Element {").append(paramString1).append("}");
      StringBuilder localStringBuilder = ((StringBuilder)localObject).append(paramString2);
      if (j == i) {}
      for (localObject = " not found in ";; localObject = " more than once in ")
      {
        localObject = (String)localObject + this;
        localRuntimeException.<init>((String)localObject);
        throw localRuntimeException;
      }
    }
    return getElement(j);
  }
  
  public String getText(int paramInt)
  {
    boolean bool = isText(paramInt);
    if (bool) {}
    for (String str = (String)getChild(paramInt);; str = null)
    {
      return str;
      bool = false;
    }
  }
  
  public int getType(int paramInt)
  {
    return types.charAt(paramInt);
  }
  
  public int indexOf(String paramString1, String paramString2, int paramInt)
  {
    int i = getChildCount();
    int j = paramInt;
    if (j < i)
    {
      Element localElement = getElement(j);
      if (localElement != null)
      {
        String str = localElement.getName();
        boolean bool = paramString2.equals(str);
        if (bool) {
          if (paramString1 != null)
          {
            str = localElement.getNamespace();
            bool = paramString1.equals(str);
            if (!bool) {
              break label76;
            }
          }
        }
      }
    }
    for (;;)
    {
      return j;
      label76:
      j += 1;
      break;
      j = -1;
    }
  }
  
  public boolean isText(int paramInt)
  {
    int i = getType(paramInt);
    int j = 4;
    if (i != j)
    {
      j = 7;
      if (i != j)
      {
        j = 5;
        if (i != j) {
          break label32;
        }
      }
    }
    label32:
    int k;
    for (j = 1;; k = 0) {
      return j;
    }
  }
  
  public void parse(XmlPullParser paramXmlPullParser)
  {
    int i = 6;
    int j = 0;
    int k = paramXmlPullParser.getEventType();
    String str1;
    switch (k)
    {
    default: 
      str1 = paramXmlPullParser.getText();
      if (str1 != null)
      {
        if (k == i) {
          k = 4;
        }
        str1 = paramXmlPullParser.getText();
        addChild(k, str1);
      }
      break;
    }
    for (;;)
    {
      paramXmlPullParser.nextToken();
      while (j != 0)
      {
        return;
        str1 = paramXmlPullParser.getNamespace();
        String str2 = paramXmlPullParser.getName();
        Element localElement = createElement(str1, str2);
        int m = 2;
        addChild(m, localElement);
        localElement.parse(paramXmlPullParser);
        continue;
        j = 1;
      }
      if (k == i)
      {
        str1 = paramXmlPullParser.getName();
        if (str1 != null)
        {
          str1 = paramXmlPullParser.getName();
          addChild(i, str1);
        }
      }
    }
  }
  
  public void removeChild(int paramInt)
  {
    children.removeElementAt(paramInt);
    StringBuffer localStringBuffer1 = types;
    int i = localStringBuffer1.length();
    int j = i + -1;
    int k = paramInt;
    while (k < j)
    {
      localStringBuffer1 = types;
      StringBuffer localStringBuffer2 = types;
      int m = k + 1;
      char c = localStringBuffer2.charAt(m);
      localStringBuffer1.setCharAt(k, c);
      k += 1;
    }
    types.setLength(j);
  }
  
  public void write(XmlSerializer paramXmlSerializer)
  {
    writeChildren(paramXmlSerializer);
    paramXmlSerializer.flush();
  }
  
  public void writeChildren(XmlSerializer paramXmlSerializer)
  {
    Object localObject1 = children;
    if (localObject1 == null) {}
    int i;
    int j;
    do
    {
      return;
      localObject1 = children;
      i = ((Vector)localObject1).size();
      j = 0;
    } while (j >= i);
    int k = getType(j);
    localObject1 = children;
    Object localObject2 = ((Vector)localObject1).elementAt(j);
    switch (k)
    {
    case 3: 
    default: 
      localObject1 = new java/lang/RuntimeException;
      Object localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      localObject3 = "Illegal type: " + k;
      ((RuntimeException)localObject1).<init>((String)localObject3);
      throw ((Throwable)localObject1);
    case 2: 
      localObject2 = (Element)localObject2;
      ((Element)localObject2).write(paramXmlSerializer);
    }
    for (;;)
    {
      j += 1;
      break;
      localObject2 = (String)localObject2;
      paramXmlSerializer.text((String)localObject2);
      continue;
      localObject2 = (String)localObject2;
      paramXmlSerializer.ignorableWhitespace((String)localObject2);
      continue;
      localObject2 = (String)localObject2;
      paramXmlSerializer.cdsect((String)localObject2);
      continue;
      localObject2 = (String)localObject2;
      paramXmlSerializer.comment((String)localObject2);
      continue;
      localObject2 = (String)localObject2;
      paramXmlSerializer.entityRef((String)localObject2);
      continue;
      localObject2 = (String)localObject2;
      paramXmlSerializer.processingInstruction((String)localObject2);
      continue;
      localObject2 = (String)localObject2;
      paramXmlSerializer.docdecl((String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kxml2/kdom/Node.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */