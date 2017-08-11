package org.kobjects.pim;

import java.io.Writer;
import java.util.Enumeration;

public class PimWriter
{
  Writer writer;
  
  public PimWriter(Writer paramWriter)
  {
    writer = paramWriter;
  }
  
  public void writeEntry(PimItem paramPimItem)
  {
    writer.write("begin:");
    Writer localWriter = writer;
    String str1 = paramPimItem.getType();
    localWriter.write(str1);
    localWriter = writer;
    str1 = "\r\n";
    localWriter.write(str1);
    Enumeration localEnumeration = paramPimItem.fieldNames();
    boolean bool = localEnumeration.hasMoreElements();
    if (bool)
    {
      String str2 = (String)localEnumeration.nextElement();
      int j = 0;
      for (;;)
      {
        int i = paramPimItem.getFieldCount(str2);
        if (j >= i) {
          break;
        }
        PimField localPimField = paramPimItem.getField(str2, j);
        writer.write(str2);
        localWriter = writer;
        int k = 58;
        localWriter.write(k);
        localWriter = writer;
        str1 = localPimField.getValue().toString();
        localWriter.write(str1);
        localWriter = writer;
        str1 = "\r\n";
        localWriter.write(str1);
        j += 1;
      }
    }
    writer.write("end:");
    localWriter = writer;
    str1 = paramPimItem.getType();
    localWriter.write(str1);
    writer.write("\r\n\r\n");
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/pim/PimWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */