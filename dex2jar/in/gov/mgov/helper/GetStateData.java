package in.gov.mgov.helper;

import java.util.Arrays;
import java.util.List;

public class GetStateData
{
  int[] stateCode = { 0, 35, 28, 12, 18, 10, 22, 4, 25, 7, 26, 30, 24, 2, 6, 20, 1, 29, 32, 31, 17, 27, 14, 23, 15, 13, 21, 34, 3, 8, 11, 33, 16, 9, 5, 19, 36 };
  String[] statedata = { "-Select State-", "Andman & Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Chandigarh", "Daman & Diu", "Delhi", "Dadra & Nagar Haveli", "Goa", "Gujarat", "Himachal Pradesh", "Haryana", "Jharkhand", "Jammu & Kashmir", "Karnataka", "Kerala", "Lakshadweep", "Meghalaya", "Maharashtra", "Manipur", "Madhya Pradesh", "Mizoram", "Nagaland", "Odisha", "Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttar Pradesh", "Uttarakhand", "West bengal", "Telangana" };
  
  public int getStateCode(String paramString)
  {
    List localList = Arrays.asList(statedata);
    return stateCode[localList.indexOf(paramString)];
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/helper/GetStateData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */