package in.gov.mgov.ors;

import android.content.res.Resources;
import org.json.JSONException;
import org.json.JSONObject;

class AuthenticateNonAadhaar$AsyncTaskRunner$2
  implements Runnable
{
  AuthenticateNonAadhaar$AsyncTaskRunner$2(AuthenticateNonAadhaar.AsyncTaskRunner paramAsyncTaskRunner, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      localObject1 = this$1;
      localObject1 = this$0;
      localObject2 = val$obj;
      String str = "data";
      localObject2 = ((JSONObject)localObject2).getString(str);
      AuthenticateNonAadhaar.access$300((AuthenticateNonAadhaar)localObject1, (String)localObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1 = this$1.this$0;
        Object localObject2 = this$1.this$0.getResources();
        int i = 2131034167;
        localObject2 = ((Resources)localObject2).getString(i);
        AuthenticateNonAadhaar.access$300((AuthenticateNonAadhaar)localObject1, (String)localObject2);
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/AuthenticateNonAadhaar$AsyncTaskRunner$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */