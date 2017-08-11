package in.gov.mgov.ors;

import android.content.res.Resources;
import org.json.JSONException;
import org.json.JSONObject;

class MainActivity$AsyncTaskRunner$1$1
  implements Runnable
{
  MainActivity$AsyncTaskRunner$1$1(MainActivity.AsyncTaskRunner.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = this$2;
      localObject1 = this$1;
      localObject1 = this$0;
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      Object localObject3 = this$2;
      localObject3 = this$1;
      localObject3 = this$0;
      localObject3 = ((MainActivity)localObject3).getResources();
      int i = 2131034263;
      localObject3 = ((Resources)localObject3).getString(i);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
      localObject3 = " ";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
      localObject3 = val$jsonRootObject;
      String str = "mbl";
      localObject3 = ((JSONObject)localObject3).getString(str);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
      localObject2 = ((StringBuilder)localObject2).toString();
      MainActivity.access$200((MainActivity)localObject1, (String)localObject2);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$AsyncTaskRunner$1$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */