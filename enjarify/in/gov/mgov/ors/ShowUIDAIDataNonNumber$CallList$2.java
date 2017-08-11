package in.gov.mgov.ors;

import org.json.JSONException;
import org.json.JSONObject;

class ShowUIDAIDataNonNumber$CallList$2
  implements Runnable
{
  ShowUIDAIDataNonNumber$CallList$2(ShowUIDAIDataNonNumber.CallList paramCallList, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = this$1;
      localObject1 = this$0;
      Object localObject2 = val$jsonRootObject;
      String str = "error_string";
      localObject2 = ((JSONObject)localObject2).getString(str);
      ShowUIDAIDataNonNumber.access$200((ShowUIDAIDataNonNumber)localObject1, (String)localObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowUIDAIDataNonNumber$CallList$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */