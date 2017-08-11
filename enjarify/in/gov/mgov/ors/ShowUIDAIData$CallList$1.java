package in.gov.mgov.ors;

import org.json.JSONException;
import org.json.JSONObject;

class ShowUIDAIData$CallList$1
  implements Runnable
{
  ShowUIDAIData$CallList$1(ShowUIDAIData.CallList paramCallList, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = this$1;
      localObject1 = this$0;
      Object localObject2 = val$jsonRootObject;
      String str = "error_string";
      localObject2 = ((JSONObject)localObject2).getString(str);
      ShowUIDAIData.access$700((ShowUIDAIData)localObject1, (String)localObject2);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowUIDAIData$CallList$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */