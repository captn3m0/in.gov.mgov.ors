package org.kobjects.pim;

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
    LookAheadReader localLookAheadReader = new org/kobjects/io/LookAheadReader;
    localLookAheadReader.<init>(paramReader);
    reader = localLookAheadReader;
    type = paramClass;
  }
  
  String[] readArrayValue(int paramInt)
  {
    Vector localVector = new java/util/Vector;
    localVector.<init>();
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    int i = 1;
    String[] arrayOfString;
    for (;;)
    {
      Object localObject = reader;
      String str = ";\n\r";
      localObject = ((LookAheadReader)localObject).readTo(str);
      localStringBuffer.append((String)localObject);
      localObject = reader;
      int j = ((LookAheadReader)localObject).read();
      switch (j)
      {
      }
      while (i == 0)
      {
        j = localStringBuffer.length();
        if (j != 0)
        {
          localObject = localStringBuffer.toString();
          localVector.addElement(localObject);
        }
        arrayOfString = new String[paramInt];
        int k = 0;
        for (;;)
        {
          j = arrayOfString.length;
          m = localVector.size();
          j = Math.min(j, m);
          if (k >= j) {
            break;
          }
          localObject = (String)localVector.elementAt(k);
          arrayOfString[k] = localObject;
          k += 1;
        }
        localObject = localStringBuffer.toString();
        localVector.addElement(localObject);
        localStringBuffer.setLength(0);
        continue;
        localObject = reader;
        j = ((LookAheadReader)localObject).peek(0);
        int m = 10;
        if (j == m)
        {
          localObject = reader;
          ((LookAheadReader)localObject).read();
        }
        localObject = reader;
        j = ((LookAheadReader)localObject).peek(0);
        m = 32;
        if (j != m)
        {
          i = 0;
        }
        else
        {
          localObject = reader;
          ((LookAheadReader)localObject).read();
        }
      }
    }
    return arrayOfString;
  }
  
  public PimItem readItem()
  {
    String str1 = readName();
    Object localObject1;
    if (str1 == null)
    {
      localObject1 = null;
      return (PimItem)localObject1;
    }
    Object localObject2 = "begin";
    boolean bool1 = str1.equals(localObject2);
    if (!bool1)
    {
      localObject2 = new java/lang/RuntimeException;
      ((RuntimeException)localObject2).<init>("'begin:' expected");
      throw ((Throwable)localObject2);
    }
    Object localObject3;
    try
    {
      localObject2 = type;
      localObject1 = ((Class)localObject2).newInstance();
      localObject1 = (PimItem)localObject1;
      reader.read();
      localObject2 = ((PimItem)localObject1).getType();
      localObject3 = readStringValue().toLowerCase();
      bool1 = ((String)localObject2).equals(localObject3);
      if (bool1) {
        break label193;
      }
      localObject2 = new java/lang/RuntimeException;
      ((RuntimeException)localObject2).<init>("item types do not match!");
      throw ((Throwable)localObject2);
    }
    catch (Exception localException)
    {
      localObject2 = new java/lang/RuntimeException;
      localObject3 = localException.toString();
      ((RuntimeException)localObject2).<init>((String)localObject3);
      throw ((Throwable)localObject2);
    }
    String str2;
    int i = ((PimItem)localObject1).getArraySize(str2);
    for (Object localObject4 = readArrayValue(i);; localObject4 = readStringValue())
    {
      localPimField.setValue(localObject4);
      localObject2 = System.out;
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      String str3 = "value:";
      localObject3 = str3 + localObject4;
      ((PrintStream)localObject2).println((String)localObject3);
      ((PimItem)localObject1).addField(localPimField);
      label193:
      str2 = readName();
      localObject2 = "end";
      boolean bool2 = str2.equals(localObject2);
      if (bool2)
      {
        reader.read();
        localObject2 = System.out;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        localObject3 = ((StringBuilder)localObject3).append("end:");
        str3 = readStringValue();
        localObject3 = str3;
        ((PrintStream)localObject2).println((String)localObject3);
        break;
      }
      PimField localPimField = new org/kobjects/pim/PimField;
      localPimField.<init>(str2);
      readProperties(localPimField);
      int j = ((PimItem)localObject1).getType(str2);
      switch (j)
      {
      }
    }
  }
  
  String readName()
  {
    String str1 = reader.readTo(":;").trim().toLowerCase();
    Object localObject1 = System.out;
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    String str2 = "name:";
    localObject2 = str2 + str1;
    ((PrintStream)localObject1).println((String)localObject2);
    localObject1 = reader;
    localObject2 = null;
    int i = ((LookAheadReader)localObject1).peek(0);
    int j = -1;
    if (i == j) {
      str1 = null;
    }
    return str1;
  }
  
  void readProperties(PimField paramPimField)
  {
    Object localObject = reader;
    int j;
    for (int i = ((LookAheadReader)localObject).read();; i = ((LookAheadReader)localObject).read())
    {
      j = 32;
      if (i != j) {
        break;
      }
      localObject = reader;
    }
    for (;;)
    {
      j = 58;
      if (i == j) {
        break;
      }
      localObject = reader;
      String str1 = ":;=";
      String str2 = ((LookAheadReader)localObject).readTo(str1).trim().toLowerCase();
      localObject = reader;
      i = ((LookAheadReader)localObject).read();
      j = 61;
      if (i == j)
      {
        localObject = reader;
        str1 = ":;";
        localObject = ((LookAheadReader)localObject).readTo(str1).trim().toLowerCase();
        paramPimField.setProperty(str2, (String)localObject);
        localObject = reader;
        i = ((LookAheadReader)localObject).read();
      }
      else
      {
        j = 1;
        paramPimField.setAttribute(str2, j);
      }
    }
  }
  
  String readStringValue()
  {
    Object localObject = reader;
    for (String str1 = ((LookAheadReader)localObject).readLine();; str1 = ((StringBuilder)localObject).toString())
    {
      localObject = reader;
      String str2 = null;
      int i = ((LookAheadReader)localObject).peek(0);
      int j = 32;
      if (i != j) {
        break;
      }
      reader.read();
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = ((StringBuilder)localObject).append(str1);
      str2 = reader.readLine();
      localObject = ((StringBuilder)localObject).append(str2);
    }
    return str1;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/pim/PimParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */