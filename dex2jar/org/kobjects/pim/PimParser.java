package org.kobjects.pim;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Vector;
import org.kobjects.io.LookAheadReader;

public class PimParser
{
  LookAheadReader reader;
  Class type;
  
  public PimParser(Reader paramReader, Class paramClass)
  {
    reader = new LookAheadReader(paramReader);
    type = paramClass;
  }
  
  String[] readArrayValue(int paramInt)
    throws IOException
  {
    Vector localVector = new Vector();
    Object localObject = new StringBuffer();
    int i = 1;
    ((StringBuffer)localObject).append(reader.readTo(";\n\r"));
    int j;
    switch (reader.read())
    {
    default: 
      j = i;
    }
    for (;;)
    {
      i = j;
      if (j != 0) {
        break;
      }
      if (((StringBuffer)localObject).length() != 0) {
        localVector.addElement(((StringBuffer)localObject).toString());
      }
      localObject = new String[paramInt];
      paramInt = 0;
      while (paramInt < Math.min(localObject.length, localVector.size()))
      {
        localObject[paramInt] = ((String)localVector.elementAt(paramInt));
        paramInt += 1;
      }
      localVector.addElement(((StringBuffer)localObject).toString());
      ((StringBuffer)localObject).setLength(0);
      j = i;
      continue;
      if (reader.peek(0) == 10) {
        reader.read();
      }
      if (reader.peek(0) != 32)
      {
        j = 0;
      }
      else
      {
        reader.read();
        j = i;
      }
    }
    return (String[])localObject;
  }
  
  public PimItem readItem()
    throws IOException
  {
    String str = readName();
    if (str == null) {
      return null;
    }
    if (!str.equals("begin")) {
      throw new RuntimeException("'begin:' expected");
    }
    PimItem localPimItem;
    try
    {
      localPimItem = (PimItem)type.newInstance();
      reader.read();
      if (!localPimItem.getType().equals(readStringValue().toLowerCase())) {
        throw new RuntimeException("item types do not match!");
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException.toString());
    }
    for (Object localObject = readArrayValue(localPimItem.getArraySize(localException));; localObject = readStringValue())
    {
      localPimField.setValue(localObject);
      System.out.println("value:" + localObject);
      localPimItem.addField(localPimField);
      localObject = readName();
      if (((String)localObject).equals("end"))
      {
        reader.read();
        System.out.println("end:" + readStringValue());
        return localPimItem;
      }
      PimField localPimField = new PimField((String)localObject);
      readProperties(localPimField);
      switch (localPimItem.getType((String)localObject))
      {
      }
    }
  }
  
  String readName()
    throws IOException
  {
    String str = reader.readTo(":;").trim().toLowerCase();
    System.out.println("name:" + str);
    if (reader.peek(0) == -1) {
      str = null;
    }
    return str;
  }
  
  void readProperties(PimField paramPimField)
    throws IOException
  {
    int j;
    for (int i = reader.read();; i = reader.read())
    {
      j = i;
      if (i != 32) {
        break;
      }
    }
    while (j != 58)
    {
      String str = reader.readTo(":;=").trim().toLowerCase();
      j = reader.read();
      if (j == 61)
      {
        paramPimField.setProperty(str, reader.readTo(":;").trim().toLowerCase());
        j = reader.read();
      }
      else
      {
        paramPimField.setAttribute(str, true);
      }
    }
  }
  
  String readStringValue()
    throws IOException
  {
    for (String str = reader.readLine(); reader.peek(0) == 32; str = str + reader.readLine()) {
      reader.read();
    }
    return str;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kobjects/pim/PimParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */