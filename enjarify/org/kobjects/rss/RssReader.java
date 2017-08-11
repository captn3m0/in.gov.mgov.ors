package org.kobjects.rss;

import java.io.Reader;
import org.kobjects.xml.XmlReader;

public class RssReader
{
  public static final int AUTHOR = 4;
  public static final int DATE = 3;
  public static final int DESCRIPTION = 2;
  public static final int LINK = 1;
  public static final int TITLE;
  XmlReader xr;
  
  public RssReader(Reader paramReader)
  {
    XmlReader localXmlReader = new org/kobjects/xml/XmlReader;
    localXmlReader.<init>(paramReader);
    xr = localXmlReader;
  }
  
  public String[] next()
  {
    int i = 3;
    int j = 1;
    int k = 2;
    int m = 5;
    String[] arrayOfString = new String[m];
    Object localObject;
    boolean bool1;
    do
    {
      do
      {
        localObject = xr;
        m = ((XmlReader)localObject).next();
        if (m == j) {
          break;
        }
        localObject = xr;
        m = ((XmlReader)localObject).getType();
      } while (m != k);
      String str1 = xr.getName().toLowerCase();
      localObject = "item";
      bool1 = str1.equals(localObject);
      if (bool1) {
        break;
      }
      localObject = ":item";
      bool1 = str1.endsWith((String)localObject);
    } while (!bool1);
    for (;;)
    {
      localObject = xr;
      int n = ((XmlReader)localObject).next();
      if (n == i) {
        break;
      }
      localObject = xr;
      n = ((XmlReader)localObject).getType();
      if (n == k)
      {
        String str2 = xr.getName().toLowerCase();
        localObject = ":";
        int i2 = str2.indexOf((String)localObject);
        n = -1;
        if (i2 != n)
        {
          n = i2 + 1;
          str2 = str2.substring(n);
        }
        StringBuffer localStringBuffer = new java/lang/StringBuffer;
        localStringBuffer.<init>();
        readText(localStringBuffer);
        String str3 = localStringBuffer.toString();
        localObject = "title";
        boolean bool2 = str2.equals(localObject);
        if (bool2)
        {
          bool2 = false;
          localObject = null;
          arrayOfString[0] = str3;
        }
        else
        {
          localObject = "link";
          bool2 = str2.equals(localObject);
          if (bool2)
          {
            arrayOfString[j] = str3;
          }
          else
          {
            localObject = "description";
            bool2 = str2.equals(localObject);
            if (bool2)
            {
              arrayOfString[k] = str3;
            }
            else
            {
              localObject = "date";
              bool2 = str2.equals(localObject);
              if (bool2)
              {
                arrayOfString[i] = str3;
              }
              else
              {
                localObject = "author";
                bool2 = str2.equals(localObject);
                if (bool2)
                {
                  int i1 = 4;
                  arrayOfString[i1] = str3;
                }
              }
            }
          }
        }
      }
    }
    arrayOfString = null;
    return arrayOfString;
  }
  
  void readText(StringBuffer paramStringBuffer)
  {
    for (;;)
    {
      Object localObject = xr;
      int i = ((XmlReader)localObject).next();
      int j = 3;
      if (i == j) {
        break;
      }
      localObject = xr;
      i = ((XmlReader)localObject).getType();
      switch (i)
      {
      default: 
        break;
      case 2: 
        readText(paramStringBuffer);
        break;
      case 4: 
        localObject = xr.getText();
        paramStringBuffer.append((String)localObject);
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/rss/RssReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */