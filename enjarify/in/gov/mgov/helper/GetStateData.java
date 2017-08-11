package in.gov.mgov.helper;

import java.util.Arrays;
import java.util.List;

public class GetStateData
{
  int[] stateCode;
  String[] statedata;
  
  public GetStateData()
  {
    Object localObject = new String[i];
    localObject[0] = "-Select State-";
    localObject[1] = "Andman & Nicobar Islands";
    localObject[2] = "Andhra Pradesh";
    localObject[3] = "Arunachal Pradesh";
    localObject[4] = "Assam";
    localObject[5] = "Bihar";
    localObject[6] = "Chhattisgarh";
    localObject[7] = "Chandigarh";
    localObject[8] = "Daman & Diu";
    localObject[9] = "Delhi";
    localObject[10] = "Dadra & Nagar Haveli";
    localObject[11] = "Goa";
    localObject[12] = "Gujarat";
    localObject[13] = "Himachal Pradesh";
    localObject[14] = "Haryana";
    localObject[15] = "Jharkhand";
    localObject[16] = "Jammu & Kashmir";
    localObject[17] = "Karnataka";
    localObject[18] = "Kerala";
    localObject[19] = "Lakshadweep";
    localObject[20] = "Meghalaya";
    localObject[21] = "Maharashtra";
    localObject[22] = "Manipur";
    localObject[23] = "Madhya Pradesh";
    localObject[24] = "Mizoram";
    localObject[25] = "Nagaland";
    localObject[26] = "Odisha";
    localObject[27] = "Puducherry";
    localObject[28] = "Punjab";
    localObject[29] = "Rajasthan";
    localObject[30] = "Sikkim";
    localObject[31] = "Tamil Nadu";
    localObject[32] = "Tripura";
    localObject[33] = "Uttar Pradesh";
    localObject[34] = "Uttarakhand";
    localObject[35] = "West bengal";
    localObject[36] = "Telangana";
    statedata = ((String[])localObject);
    localObject = new int[i];
    Object tmp238_237 = localObject;
    Object tmp239_238 = tmp238_237;
    Object tmp239_238 = tmp238_237;
    tmp239_238[0] = 0;
    tmp239_238[1] = 35;
    Object tmp247_239 = tmp239_238;
    Object tmp247_239 = tmp239_238;
    tmp247_239[2] = 28;
    tmp247_239[3] = 12;
    Object tmp256_247 = tmp247_239;
    Object tmp256_247 = tmp247_239;
    tmp256_247[4] = 18;
    tmp256_247[5] = 10;
    Object tmp265_256 = tmp256_247;
    Object tmp265_256 = tmp256_247;
    tmp265_256[6] = 22;
    tmp265_256[7] = 4;
    Object tmp275_265 = tmp265_256;
    Object tmp275_265 = tmp265_256;
    tmp275_265[8] = 25;
    tmp275_265[9] = 7;
    Object tmp286_275 = tmp275_265;
    Object tmp286_275 = tmp275_265;
    tmp286_275[10] = 26;
    tmp286_275[11] = 30;
    Object tmp297_286 = tmp286_275;
    Object tmp297_286 = tmp286_275;
    tmp297_286[12] = 24;
    tmp297_286[13] = 2;
    Object tmp307_297 = tmp297_286;
    Object tmp307_297 = tmp297_286;
    tmp307_297[14] = 6;
    tmp307_297[15] = 20;
    Object tmp318_307 = tmp307_297;
    Object tmp318_307 = tmp307_297;
    tmp318_307[16] = 1;
    tmp318_307[17] = 29;
    Object tmp328_318 = tmp318_307;
    Object tmp328_318 = tmp318_307;
    tmp328_318[18] = 32;
    tmp328_318[19] = 31;
    Object tmp339_328 = tmp328_318;
    Object tmp339_328 = tmp328_318;
    tmp339_328[20] = 17;
    tmp339_328[21] = 27;
    Object tmp350_339 = tmp339_328;
    Object tmp350_339 = tmp339_328;
    tmp350_339[22] = 14;
    tmp350_339[23] = 23;
    Object tmp361_350 = tmp350_339;
    Object tmp361_350 = tmp350_339;
    tmp361_350[24] = 15;
    tmp361_350[25] = 13;
    Object tmp372_361 = tmp361_350;
    Object tmp372_361 = tmp361_350;
    tmp372_361[26] = 21;
    tmp372_361[27] = 34;
    Object tmp383_372 = tmp372_361;
    Object tmp383_372 = tmp372_361;
    tmp383_372[28] = 3;
    tmp383_372[29] = 8;
    Object tmp393_383 = tmp383_372;
    Object tmp393_383 = tmp383_372;
    tmp393_383[30] = 11;
    tmp393_383[31] = 33;
    Object tmp404_393 = tmp393_383;
    Object tmp404_393 = tmp393_383;
    tmp404_393[32] = 16;
    tmp404_393[33] = 9;
    tmp404_393[34] = 5;
    Object tmp419_404 = tmp404_393;
    tmp419_404[35] = 19;
    tmp419_404[36] = 36;
    stateCode = ((int[])localObject);
  }
  
  public int getStateCode(String paramString)
  {
    List localList = Arrays.asList(statedata);
    int[] arrayOfInt = stateCode;
    int i = localList.indexOf(paramString);
    return arrayOfInt[i];
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/helper/GetStateData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */