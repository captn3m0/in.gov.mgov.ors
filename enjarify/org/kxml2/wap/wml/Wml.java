package org.kxml2.wap.wml;

import org.kxml2.wap.WbxmlParser;
import org.kxml2.wap.WbxmlSerializer;

public abstract class Wml
{
  public static final String[] ATTR_START_TABLE;
  public static final String[] ATTR_VALUE_TABLE;
  public static final String[] TAG_TABLE;
  
  static
  {
    int i = 3;
    int j = 2;
    int k = 1;
    String[] arrayOfString = new String[59];
    arrayOfString[0] = null;
    arrayOfString[k] = null;
    arrayOfString[j] = null;
    arrayOfString[i] = null;
    arrayOfString[4] = null;
    arrayOfString[5] = null;
    arrayOfString[6] = null;
    arrayOfString[7] = null;
    arrayOfString[8] = null;
    arrayOfString[9] = null;
    arrayOfString[10] = null;
    arrayOfString[11] = null;
    arrayOfString[12] = null;
    arrayOfString[13] = null;
    arrayOfString[14] = null;
    arrayOfString[15] = null;
    arrayOfString[16] = null;
    arrayOfString[17] = null;
    arrayOfString[18] = null;
    arrayOfString[19] = null;
    arrayOfString[20] = null;
    arrayOfString[21] = null;
    arrayOfString[22] = null;
    arrayOfString[23] = "a";
    arrayOfString[24] = "td";
    arrayOfString[25] = "tr";
    arrayOfString[26] = "table";
    arrayOfString[27] = "p";
    arrayOfString[28] = "postfield";
    arrayOfString[29] = "anchor";
    arrayOfString[30] = "access";
    arrayOfString[31] = "b";
    arrayOfString[32] = "big";
    arrayOfString[33] = "br";
    arrayOfString[34] = "card";
    arrayOfString[35] = "do";
    arrayOfString[36] = "em";
    arrayOfString[37] = "fieldset";
    arrayOfString[38] = "go";
    arrayOfString[39] = "head";
    arrayOfString[40] = "i";
    arrayOfString[41] = "img";
    arrayOfString[42] = "input";
    arrayOfString[43] = "meta";
    arrayOfString[44] = "noop";
    arrayOfString[45] = "prev";
    arrayOfString[46] = "onevent";
    arrayOfString[47] = "optgroup";
    arrayOfString[48] = "option";
    arrayOfString[49] = "refresh";
    arrayOfString[50] = "select";
    arrayOfString[51] = "small";
    arrayOfString[52] = "strong";
    arrayOfString[53] = null;
    arrayOfString[54] = "template";
    arrayOfString[55] = "timer";
    arrayOfString[56] = "u";
    arrayOfString[57] = "setvar";
    arrayOfString[58] = "wml";
    TAG_TABLE = arrayOfString;
    arrayOfString = new String[91];
    arrayOfString[0] = "accept-charset";
    arrayOfString[k] = "align=bottom";
    arrayOfString[j] = "align=center";
    arrayOfString[i] = "align=left";
    arrayOfString[4] = "align=middle";
    arrayOfString[5] = "align=right";
    arrayOfString[6] = "align=top";
    arrayOfString[7] = "alt";
    arrayOfString[8] = "content";
    arrayOfString[9] = null;
    arrayOfString[10] = "domain";
    arrayOfString[11] = "emptyok=false";
    arrayOfString[12] = "emptyok=true";
    arrayOfString[13] = "format";
    arrayOfString[14] = "height";
    arrayOfString[15] = "hspace";
    arrayOfString[16] = "ivalue";
    arrayOfString[17] = "iname";
    arrayOfString[18] = null;
    arrayOfString[19] = "label";
    arrayOfString[20] = "localsrc";
    arrayOfString[21] = "maxlength";
    arrayOfString[22] = "method=get";
    arrayOfString[23] = "method=post";
    arrayOfString[24] = "mode=nowrap";
    arrayOfString[25] = "mode=wrap";
    arrayOfString[26] = "multiple=false";
    arrayOfString[27] = "multiple=true";
    arrayOfString[28] = "name";
    arrayOfString[29] = "newcontext=false";
    arrayOfString[30] = "newcontext=true";
    arrayOfString[31] = "onpick";
    arrayOfString[32] = "onenterbackward";
    arrayOfString[33] = "onenterforward";
    arrayOfString[34] = "ontimer";
    arrayOfString[35] = "optimal=false";
    arrayOfString[36] = "optimal=true";
    arrayOfString[37] = "path";
    arrayOfString[38] = null;
    arrayOfString[39] = null;
    arrayOfString[40] = null;
    arrayOfString[41] = "scheme";
    arrayOfString[42] = "sendreferer=false";
    arrayOfString[43] = "sendreferer=true";
    arrayOfString[44] = "size";
    arrayOfString[45] = "src";
    arrayOfString[46] = "ordered=true";
    arrayOfString[47] = "ordered=false";
    arrayOfString[48] = "tabindex";
    arrayOfString[49] = "title";
    arrayOfString[50] = "type";
    arrayOfString[51] = "type=accept";
    arrayOfString[52] = "type=delete";
    arrayOfString[53] = "type=help";
    arrayOfString[54] = "type=password";
    arrayOfString[55] = "type=onpick";
    arrayOfString[56] = "type=onenterbackward";
    arrayOfString[57] = "type=onenterforward";
    arrayOfString[58] = "type=ontimer";
    arrayOfString[59] = null;
    arrayOfString[60] = null;
    arrayOfString[61] = null;
    arrayOfString[62] = null;
    arrayOfString[63] = null;
    arrayOfString[64] = "type=options";
    arrayOfString[65] = "type=prev";
    arrayOfString[66] = "type=reset";
    arrayOfString[67] = "type=text";
    arrayOfString[68] = "type=vnd.";
    arrayOfString[69] = "href";
    arrayOfString[70] = "href=http://";
    arrayOfString[71] = "href=https://";
    arrayOfString[72] = "value";
    arrayOfString[73] = "vspace";
    arrayOfString[74] = "width";
    arrayOfString[75] = "xml:lang";
    arrayOfString[76] = null;
    arrayOfString[77] = "align";
    arrayOfString[78] = "columns";
    arrayOfString[79] = "class";
    arrayOfString[80] = "id";
    arrayOfString[81] = "forua=false";
    arrayOfString[82] = "forua=true";
    arrayOfString[83] = "src=http://";
    arrayOfString[84] = "src=https://";
    arrayOfString[85] = "http-equiv";
    arrayOfString[86] = "http-equiv=Content-Type";
    arrayOfString[87] = "content=application/vnd.wap.wmlc;charset=";
    arrayOfString[88] = "http-equiv=Expires";
    arrayOfString[89] = null;
    arrayOfString[90] = null;
    ATTR_START_TABLE = arrayOfString;
    arrayOfString = new String[29];
    arrayOfString[0] = ".com/";
    arrayOfString[k] = ".edu/";
    arrayOfString[j] = ".net/";
    arrayOfString[i] = ".org/";
    arrayOfString[4] = "accept";
    arrayOfString[5] = "bottom";
    arrayOfString[6] = "clear";
    arrayOfString[7] = "delete";
    arrayOfString[8] = "help";
    arrayOfString[9] = "http://";
    arrayOfString[10] = "http://www.";
    arrayOfString[11] = "https://";
    arrayOfString[12] = "https://www.";
    arrayOfString[13] = null;
    arrayOfString[14] = "middle";
    arrayOfString[15] = "nowrap";
    arrayOfString[16] = "onpick";
    arrayOfString[17] = "onenterbackward";
    arrayOfString[18] = "onenterforward";
    arrayOfString[19] = "ontimer";
    arrayOfString[20] = "options";
    arrayOfString[21] = "password";
    arrayOfString[22] = "reset";
    arrayOfString[23] = null;
    arrayOfString[24] = "text";
    arrayOfString[25] = "top";
    arrayOfString[26] = "unknown";
    arrayOfString[27] = "wrap";
    arrayOfString[28] = "www.";
    ATTR_VALUE_TABLE = arrayOfString;
  }
  
  public static WbxmlParser createParser()
  {
    WbxmlParser localWbxmlParser = new org/kxml2/wap/WbxmlParser;
    localWbxmlParser.<init>();
    String[] arrayOfString = TAG_TABLE;
    localWbxmlParser.setTagTable(0, arrayOfString);
    arrayOfString = ATTR_START_TABLE;
    localWbxmlParser.setAttrStartTable(0, arrayOfString);
    arrayOfString = ATTR_VALUE_TABLE;
    localWbxmlParser.setAttrValueTable(0, arrayOfString);
    return localWbxmlParser;
  }
  
  public static WbxmlSerializer createSerializer()
  {
    WbxmlSerializer localWbxmlSerializer = new org/kxml2/wap/WbxmlSerializer;
    localWbxmlSerializer.<init>();
    String[] arrayOfString = TAG_TABLE;
    localWbxmlSerializer.setTagTable(0, arrayOfString);
    arrayOfString = ATTR_START_TABLE;
    localWbxmlSerializer.setAttrStartTable(0, arrayOfString);
    arrayOfString = ATTR_VALUE_TABLE;
    localWbxmlSerializer.setAttrValueTable(0, arrayOfString);
    return localWbxmlSerializer;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kxml2/wap/wml/Wml.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */