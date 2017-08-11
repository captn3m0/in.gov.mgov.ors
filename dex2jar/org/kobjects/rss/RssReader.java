package org.kobjects.rss;

import java.io.IOException;
import java.io.Reader;
import org.kobjects.xml.XmlReader;

public class RssReader
{
  public static final int AUTHOR = 4;
  public static final int DATE = 3;
  public static final int DESCRIPTION = 2;
  public static final int LINK = 1;
  public static final int TITLE = 0;
  XmlReader xr;
  
  public RssReader(Reader paramReader)
    throws IOException
  {
    xr = new XmlReader(paramReader);
  }
  
  public String[] next()
    throws IOException
  {
    String[] arrayOfString = new String[5];
    while (xr.next() != 1) {
      if (xr.getType() == 2)
      {
        localObject1 = xr.getName().toLowerCase();
        if ((((String)localObject1).equals("item")) || (((String)localObject1).endsWith(":item"))) {
          for (;;)
          {
            localObject1 = arrayOfString;
            if (xr.next() == 3) {
              break;
            }
            if (xr.getType() == 2)
            {
              Object localObject2 = xr.getName().toLowerCase();
              int i = ((String)localObject2).indexOf(":");
              localObject1 = localObject2;
              if (i != -1) {
                localObject1 = ((String)localObject2).substring(i + 1);
              }
              localObject2 = new StringBuffer();
              readText((StringBuffer)localObject2);
              localObject2 = ((StringBuffer)localObject2).toString();
              if (((String)localObject1).equals("title")) {
                arrayOfString[0] = localObject2;
              } else if (((String)localObject1).equals("link")) {
                arrayOfString[1] = localObject2;
              } else if (((String)localObject1).equals("description")) {
                arrayOfString[2] = localObject2;
              } else if (((String)localObject1).equals("date")) {
                arrayOfString[3] = localObject2;
              } else if (((String)localObject1).equals("author")) {
                arrayOfString[4] = localObject2;
              }
            }
          }
        }
      }
    }
    Object localObject1 = null;
    return (String[])localObject1;
  }
  
  void readText(StringBuffer paramStringBuffer)
    throws IOException
  {
    while (xr.next() != 3) {
      switch (xr.getType())
      {
      case 3: 
      default: 
        break;
      case 2: 
        readText(paramStringBuffer);
        break;
      case 4: 
        paramStringBuffer.append(xr.getText());
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kobjects/rss/RssReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */