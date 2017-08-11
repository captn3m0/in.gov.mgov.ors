package org.kobjects.xmlrpc;

import java.io.FileReader;
import org.kobjects.xml.XmlReader;

public class Driver
{
  public static void main(String[] paramArrayOfString)
  {
    XmlReader localXmlReader = new org/kobjects/xml/XmlReader;
    FileReader localFileReader = new java/io/FileReader;
    String str = paramArrayOfString[0];
    localFileReader.<init>(str);
    localXmlReader.<init>(localFileReader);
    XmlRpcParser localXmlRpcParser = new org/kobjects/xmlrpc/XmlRpcParser;
    localXmlRpcParser.<init>(localXmlReader);
    localXmlRpcParser.parseResponse();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/xmlrpc/Driver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */