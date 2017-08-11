package org.kobjects.pim;

import java.io.IOException;
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
    throws IOException
  {
    writer.write("begin:");
    writer.write(paramPimItem.getType());
    writer.write("\r\n");
    Enumeration localEnumeration = paramPimItem.fieldNames();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      int i = 0;
      while (i < paramPimItem.getFieldCount(str))
      {
        PimField localPimField = paramPimItem.getField(str, i);
        writer.write(str);
        writer.write(58);
        writer.write(localPimField.getValue().toString());
        writer.write("\r\n");
        i += 1;
      }
    }
    writer.write("end:");
    writer.write(paramPimItem.getType());
    writer.write("\r\n\r\n");
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kobjects/pim/PimWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */