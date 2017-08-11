package in.gov.mgov.ors;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

class MainActivity$AsyncTaskRunner$1
  implements Runnable
{
  MainActivity$AsyncTaskRunner$1(MainActivity.AsyncTaskRunner paramAsyncTaskRunner, String[] paramArrayOfString) {}
  
  public void run()
  {
    Object localObject1 = null;
    Object localObject2 = val$params[0];
    Object localObject3 = "aadhaar";
    boolean bool = ((String)localObject2).equals(localObject3);
    int j;
    if (bool)
    {
      this$1.this$0.aadhaar.setEnabled(false);
      localObject2 = this$1.this$0.submit;
      j = 8;
      ((Button)localObject2).setVisibility(j);
      localObject2 = this$1.this$0.ll_otp;
      ((LinearLayout)localObject2).setVisibility(0);
    }
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localObject2 = this$1;
      localObject2 = this$0;
      localObject2 = finalresp;
      localJSONObject.<init>((String)localObject2);
      localObject2 = this$1;
      localObject2 = this$0;
      localObject2 = showmobilenumber;
      j = 0;
      localObject3 = null;
      ((TextView)localObject2).setVisibility(0);
      localObject2 = this$1;
      localObject2 = this$0;
      localObject2 = showmobilenumber;
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      localObject1 = this$1;
      localObject1 = this$0;
      localObject1 = shownumber;
      localObject3 = ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = "mbl";
      localObject1 = localJSONObject.getString((String)localObject1);
      localObject3 = ((StringBuilder)localObject3).append((String)localObject1);
      localObject3 = ((StringBuilder)localObject3).toString();
      ((TextView)localObject2).setText((CharSequence)localObject3);
      localObject2 = val$params;
      int i = localObject2.length;
      j = 1;
      if (i > j)
      {
        localObject2 = this$1;
        localObject2 = this$0;
        localObject3 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner$1$1;
        ((MainActivity.AsyncTaskRunner.1.1)localObject3).<init>(this, localJSONObject);
        ((MainActivity)localObject2).runOnUiThread((Runnable)localObject3);
      }
      localObject2 = this$1;
      localObject2 = this$0;
      localObject2 = no_aadhhar;
      j = 0;
      localObject3 = null;
      ((TextView)localObject2).setVisibility(0);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$AsyncTaskRunner$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */