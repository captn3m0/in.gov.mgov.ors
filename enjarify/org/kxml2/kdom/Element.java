package org.kxml2.kdom;

import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class Element
  extends Node
{
  protected Vector attributes;
  protected String name;
  protected String namespace;
  protected Node parent;
  protected Vector prefixes;
  
  public void clear()
  {
    attributes = null;
    children = null;
  }
  
  public Element createElement(String paramString1, String paramString2)
  {
    Object localObject = parent;
    if (localObject == null) {}
    for (localObject = super.createElement(paramString1, paramString2);; localObject = parent.createElement(paramString1, paramString2)) {
      return (Element)localObject;
    }
  }
  
  public int getAttributeCount()
  {
    Vector localVector = attributes;
    int i;
    if (localVector == null)
    {
      i = 0;
      localVector = null;
    }
    for (;;)
    {
      return i;
      localVector = attributes;
      i = localVector.size();
    }
  }
  
  public String getAttributeName(int paramInt)
  {
    return ((String[])(String[])attributes.elementAt(paramInt))[1];
  }
  
  public String getAttributeNamespace(int paramInt)
  {
    return ((String[])(String[])attributes.elementAt(paramInt))[0];
  }
  
  public String getAttributeValue(int paramInt)
  {
    return ((String[])(String[])attributes.elementAt(paramInt))[2];
  }
  
  public String getAttributeValue(String paramString1, String paramString2)
  {
    int i = 0;
    int j = getAttributeCount();
    boolean bool;
    if (i < j)
    {
      str = getAttributeName(i);
      bool = paramString2.equals(str);
      if (bool) {
        if (paramString1 != null)
        {
          str = getAttributeNamespace(i);
          bool = paramString1.equals(str);
          if (!bool) {
            break label68;
          }
        }
      }
    }
    for (String str = getAttributeValue(i);; str = null)
    {
      return str;
      label68:
      i += 1;
      break;
      bool = false;
    }
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public int getNamespaceCount()
  {
    Vector localVector = prefixes;
    int i;
    if (localVector == null)
    {
      i = 0;
      localVector = null;
    }
    for (;;)
    {
      return i;
      localVector = prefixes;
      i = localVector.size();
    }
  }
  
  public String getNamespacePrefix(int paramInt)
  {
    return ((String[])(String[])prefixes.elementAt(paramInt))[0];
  }
  
  public String getNamespaceUri(int paramInt)
  {
    return ((String[])(String[])prefixes.elementAt(paramInt))[1];
  }
  
  public String getNamespaceUri(String paramString)
  {
    int i = getNamespaceCount();
    int j = 0;
    Object localObject;
    boolean bool;
    if (j < i)
    {
      localObject = getNamespacePrefix(j);
      if (paramString != localObject)
      {
        if (paramString != null)
        {
          localObject = getNamespacePrefix(j);
          bool = paramString.equals(localObject);
          if (!bool) {}
        }
      }
      else {
        localObject = getNamespaceUri(j);
      }
    }
    for (;;)
    {
      return (String)localObject;
      j += 1;
      break;
      localObject = parent;
      bool = localObject instanceof Element;
      if (bool)
      {
        localObject = ((Element)parent).getNamespaceUri(paramString);
      }
      else
      {
        bool = false;
        localObject = null;
      }
    }
  }
  
  public Node getParent()
  {
    return parent;
  }
  
  public Node getRoot()
  {
    for (Object localObject = this;; localObject = (Element)parent)
    {
      Node localNode = parent;
      if (localNode != null)
      {
        localNode = parent;
        boolean bool = localNode instanceof Element;
        if (!bool) {
          localObject = parent;
        }
      }
      else
      {
        return (Node)localObject;
      }
    }
  }
  
  public void init() {}
  
  public void parse(XmlPullParser paramXmlPullParser)
  {
    int i = paramXmlPullParser.getDepth() + -1;
    int k = paramXmlPullParser.getNamespaceCount(i);
    String str1;
    String str2;
    for (;;)
    {
      i = paramXmlPullParser.getDepth();
      i = paramXmlPullParser.getNamespaceCount(i);
      if (k >= i) {
        break;
      }
      str1 = paramXmlPullParser.getNamespacePrefix(k);
      str2 = paramXmlPullParser.getNamespaceUri(k);
      setPrefix(str1, str2);
      k += 1;
    }
    k = 0;
    String str3;
    for (;;)
    {
      i = paramXmlPullParser.getAttributeCount();
      if (k >= i) {
        break;
      }
      str1 = paramXmlPullParser.getAttributeNamespace(k);
      str2 = paramXmlPullParser.getAttributeName(k);
      str3 = paramXmlPullParser.getAttributeValue(k);
      setAttribute(str1, str2, str3);
      k += 1;
    }
    init();
    boolean bool = paramXmlPullParser.isEmptyElementTag();
    if (bool) {
      paramXmlPullParser.nextToken();
    }
    for (;;)
    {
      str2 = getNamespace();
      str3 = getName();
      paramXmlPullParser.require(3, str2, str3);
      paramXmlPullParser.nextToken();
      return;
      paramXmlPullParser.nextToken();
      super.parse(paramXmlPullParser);
      int j = getChildCount();
      if (j == 0)
      {
        j = 7;
        str2 = "";
        addChild(j, str2);
      }
    }
  }
  
  public void setAttribute(String paramString1, String paramString2, String paramString3)
  {
    int i = 2;
    int j = 1;
    Object localObject1 = attributes;
    if (localObject1 == null)
    {
      localObject1 = new java/util/Vector;
      ((Vector)localObject1).<init>();
      attributes = ((Vector)localObject1);
    }
    if (paramString1 == null) {
      paramString1 = "";
    }
    localObject1 = attributes;
    int k = ((Vector)localObject1).size();
    int m = k + -1;
    Object localObject2;
    if (m >= 0)
    {
      localObject1 = (String[])attributes.elementAt(m);
      localObject2 = localObject1;
      localObject2 = (String[])localObject1;
      localObject1 = localObject2[0];
      boolean bool = ((String)localObject1).equals(paramString1);
      if (bool)
      {
        localObject1 = localObject2[j];
        bool = ((String)localObject1).equals(paramString2);
        if (bool) {
          if (paramString3 == null)
          {
            localObject1 = attributes;
            ((Vector)localObject1).removeElementAt(m);
          }
        }
      }
    }
    for (;;)
    {
      return;
      localObject2[i] = paramString3;
      continue;
      m += -1;
      break;
      localObject1 = attributes;
      int n = 3;
      String[] arrayOfString = new String[n];
      arrayOfString[0] = paramString1;
      arrayOfString[j] = paramString2;
      arrayOfString[i] = paramString3;
      ((Vector)localObject1).addElement(arrayOfString);
    }
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void setNamespace(String paramString)
  {
    if (paramString == null)
    {
      NullPointerException localNullPointerException = new java/lang/NullPointerException;
      localNullPointerException.<init>("Use \"\" for empty namespace");
      throw localNullPointerException;
    }
    namespace = paramString;
  }
  
  protected void setParent(Node paramNode)
  {
    parent = paramNode;
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    Vector localVector = prefixes;
    if (localVector == null)
    {
      localVector = new java/util/Vector;
      localVector.<init>();
      prefixes = localVector;
    }
    localVector = prefixes;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString1;
    arrayOfString[1] = paramString2;
    localVector.addElement(arrayOfString);
  }
  
  public void write(XmlSerializer paramXmlSerializer)
  {
    Object localObject = prefixes;
    if (localObject != null)
    {
      i = 0;
      for (;;)
      {
        localObject = prefixes;
        int j = ((Vector)localObject).size();
        if (i >= j) {
          break;
        }
        localObject = getNamespacePrefix(i);
        str1 = getNamespaceUri(i);
        paramXmlSerializer.setPrefix((String)localObject, str1);
        i += 1;
      }
    }
    localObject = getNamespace();
    String str1 = getName();
    paramXmlSerializer.startTag((String)localObject, str1);
    int k = getAttributeCount();
    int i = 0;
    while (i < k)
    {
      localObject = getAttributeNamespace(i);
      str1 = getAttributeName(i);
      String str2 = getAttributeValue(i);
      paramXmlSerializer.attribute((String)localObject, str1, str2);
      i += 1;
    }
    writeChildren(paramXmlSerializer);
    localObject = getNamespace();
    str1 = getName();
    paramXmlSerializer.endTag((String)localObject, str1);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kxml2/kdom/Element.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */