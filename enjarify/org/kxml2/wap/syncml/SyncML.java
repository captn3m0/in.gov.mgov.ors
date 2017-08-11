package org.kxml2.wap.syncml;

import org.kxml2.wap.WbxmlParser;
import org.kxml2.wap.WbxmlSerializer;

public abstract class SyncML
{
  public static final String[] TAG_TABLE_0;
  public static final String[] TAG_TABLE_1;
  public static final String[] TAG_TABLE_2_DM;
  
  static
  {
    int i = 4;
    int j = 3;
    int k = 2;
    int m = 1;
    String[] arrayOfString = new String[56];
    arrayOfString[0] = "Add";
    arrayOfString[m] = "Alert";
    arrayOfString[k] = "Archive";
    arrayOfString[j] = "Atomic";
    arrayOfString[i] = "Chal";
    arrayOfString[5] = "Cmd";
    arrayOfString[6] = "CmdID";
    arrayOfString[7] = "CmdRef";
    arrayOfString[8] = "Copy";
    arrayOfString[9] = "Cred";
    arrayOfString[10] = "Data";
    arrayOfString[11] = "Delete";
    arrayOfString[12] = "Exec";
    arrayOfString[13] = "Final";
    arrayOfString[14] = "Get";
    arrayOfString[15] = "Item";
    arrayOfString[16] = "Lang";
    arrayOfString[17] = "LocName";
    arrayOfString[18] = "LocURI";
    arrayOfString[19] = "Map";
    arrayOfString[20] = "MapItem";
    arrayOfString[21] = "Meta";
    arrayOfString[22] = "MsgID";
    arrayOfString[23] = "MsgRef";
    arrayOfString[24] = "NoResp";
    arrayOfString[25] = "NoResults";
    arrayOfString[26] = "Put";
    arrayOfString[27] = "Replace";
    arrayOfString[28] = "RespURI";
    arrayOfString[29] = "Results";
    arrayOfString[30] = "Search";
    arrayOfString[31] = "Sequence";
    arrayOfString[32] = "SessionID";
    arrayOfString[33] = "SftDel";
    arrayOfString[34] = "Source";
    arrayOfString[35] = "SourceRef";
    arrayOfString[36] = "Status";
    arrayOfString[37] = "Sync";
    arrayOfString[38] = "SyncBody";
    arrayOfString[39] = "SyncHdr";
    arrayOfString[40] = "SyncML";
    arrayOfString[41] = "Target";
    arrayOfString[42] = "TargetRef";
    arrayOfString[43] = "Reserved for future use";
    arrayOfString[44] = "VerDTD";
    arrayOfString[45] = "VerProto";
    arrayOfString[46] = "NumberOfChanged";
    arrayOfString[47] = "MoreData";
    arrayOfString[48] = "Field";
    arrayOfString[49] = "Filter";
    arrayOfString[50] = "Record";
    arrayOfString[51] = "FilterType";
    arrayOfString[52] = "SourceParent";
    arrayOfString[53] = "TargetParent";
    arrayOfString[54] = "Move";
    arrayOfString[55] = "Correlator";
    TAG_TABLE_0 = arrayOfString;
    arrayOfString = new String[18];
    arrayOfString[0] = "Anchor";
    arrayOfString[m] = "EMI";
    arrayOfString[k] = "Format";
    arrayOfString[j] = "FreeID";
    arrayOfString[i] = "FreeMem";
    arrayOfString[5] = "Last";
    arrayOfString[6] = "Mark";
    arrayOfString[7] = "MaxMsgSize";
    arrayOfString[8] = "Mem";
    arrayOfString[9] = "MetInf";
    arrayOfString[10] = "Next";
    arrayOfString[11] = "NextNonce";
    arrayOfString[12] = "SharedMem";
    arrayOfString[13] = "Size";
    arrayOfString[14] = "Type";
    arrayOfString[15] = "Version";
    arrayOfString[16] = "MaxObjSize";
    arrayOfString[17] = "FieldLevel";
    TAG_TABLE_1 = arrayOfString;
    arrayOfString = new String[56];
    arrayOfString[0] = "AccessType";
    arrayOfString[m] = "ACL";
    arrayOfString[k] = "Add";
    arrayOfString[j] = "b64";
    arrayOfString[i] = "bin";
    arrayOfString[5] = "bool";
    arrayOfString[6] = "chr";
    arrayOfString[7] = "CaseSense";
    arrayOfString[8] = "CIS";
    arrayOfString[9] = "Copy";
    arrayOfString[10] = "CS";
    arrayOfString[11] = "date";
    arrayOfString[12] = "DDFName";
    arrayOfString[13] = "DefaultValue";
    arrayOfString[14] = "Delete";
    arrayOfString[15] = "Description";
    arrayOfString[16] = "DDFFormat";
    arrayOfString[17] = "DFProperties";
    arrayOfString[18] = "DFTitle";
    arrayOfString[19] = "DFType";
    arrayOfString[20] = "Dynamic";
    arrayOfString[21] = "Exec";
    arrayOfString[22] = "float";
    arrayOfString[23] = "Format";
    arrayOfString[24] = "Get";
    arrayOfString[25] = "int";
    arrayOfString[26] = "Man";
    arrayOfString[27] = "MgmtTree";
    arrayOfString[28] = "MIME";
    arrayOfString[29] = "Mod";
    arrayOfString[30] = "Name";
    arrayOfString[31] = "Node";
    arrayOfString[32] = "node";
    arrayOfString[33] = "NodeName";
    arrayOfString[34] = "null";
    arrayOfString[35] = "Occurence";
    arrayOfString[36] = "One";
    arrayOfString[37] = "OneOrMore";
    arrayOfString[38] = "OneOrN";
    arrayOfString[39] = "Path";
    arrayOfString[40] = "Permanent";
    arrayOfString[41] = "Replace";
    arrayOfString[42] = "RTProperties";
    arrayOfString[43] = "Scope";
    arrayOfString[44] = "Size";
    arrayOfString[45] = "time";
    arrayOfString[46] = "Title";
    arrayOfString[47] = "TStamp";
    arrayOfString[48] = "Type";
    arrayOfString[49] = "Value";
    arrayOfString[50] = "VerDTD";
    arrayOfString[51] = "VerNo";
    arrayOfString[52] = "xml";
    arrayOfString[53] = "ZeroOrMore";
    arrayOfString[54] = "ZeroOrN";
    arrayOfString[55] = "ZeroOrOne";
    TAG_TABLE_2_DM = arrayOfString;
  }
  
  public static WbxmlParser createDMParser()
  {
    WbxmlParser localWbxmlParser = createParser();
    String[] arrayOfString = TAG_TABLE_2_DM;
    localWbxmlParser.setTagTable(2, arrayOfString);
    return localWbxmlParser;
  }
  
  public static WbxmlSerializer createDMSerializer()
  {
    WbxmlSerializer localWbxmlSerializer = createSerializer();
    String[] arrayOfString = TAG_TABLE_2_DM;
    localWbxmlSerializer.setTagTable(2, arrayOfString);
    return localWbxmlSerializer;
  }
  
  public static WbxmlParser createParser()
  {
    WbxmlParser localWbxmlParser = new org/kxml2/wap/WbxmlParser;
    localWbxmlParser.<init>();
    String[] arrayOfString = TAG_TABLE_0;
    localWbxmlParser.setTagTable(0, arrayOfString);
    arrayOfString = TAG_TABLE_1;
    localWbxmlParser.setTagTable(1, arrayOfString);
    return localWbxmlParser;
  }
  
  public static WbxmlSerializer createSerializer()
  {
    WbxmlSerializer localWbxmlSerializer = new org/kxml2/wap/WbxmlSerializer;
    localWbxmlSerializer.<init>();
    String[] arrayOfString = TAG_TABLE_0;
    localWbxmlSerializer.setTagTable(0, arrayOfString);
    arrayOfString = TAG_TABLE_1;
    localWbxmlSerializer.setTagTable(1, arrayOfString);
    return localWbxmlSerializer;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kxml2/wap/syncml/SyncML.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */