package in.gov.mgov.ors;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

class AuthenticateNonAadhaar$AsyncTaskRunner$1
  implements Runnable
{
  AuthenticateNonAadhaar$AsyncTaskRunner$1(AuthenticateNonAadhaar.AsyncTaskRunner paramAsyncTaskRunner, JSONObject paramJSONObject, String[] paramArrayOfString) {}
  
  public void run()
  {
    try
    {
      localObject1 = this$1;
      localObject1 = this$0;
      localObject2 = val$obj;
      Object localObject3 = "data";
      localObject2 = ((JSONObject)localObject2).getString((String)localObject3);
      OTP_RES = ((String)localObject2);
      localObject1 = this$1;
      localObject1 = this$0;
      localObject1 = getotp;
      int i = 8;
      ((Button)localObject1).setVisibility(i);
      localObject1 = this$1;
      localObject1 = this$0;
      localObject1 = number;
      i = 0;
      localObject2 = null;
      ((EditText)localObject1).setEnabled(false);
      localObject1 = this$1;
      localObject1 = this$0;
      localObject1 = showNumber;
      i = 0;
      localObject2 = null;
      ((TextView)localObject1).setVisibility(0);
      localObject1 = this$1;
      localObject1 = this$0;
      localObject1 = showNumber;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = this$1;
      localObject3 = this$0;
      localObject3 = ((AuthenticateNonAadhaar)localObject3).getResources();
      int j = 2131034264;
      localObject3 = ((Resources)localObject3).getString(j);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
      localObject3 = " \n";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
      localObject3 = this$1;
      localObject3 = this$0;
      localObject3 = number;
      localObject3 = ((EditText)localObject3).getText();
      localObject2 = ((StringBuilder)localObject2).append(localObject3);
      localObject2 = ((StringBuilder)localObject2).toString();
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = this$1;
      localObject1 = this$0;
      localObject1 = resetnumber;
      i = 0;
      localObject2 = null;
      ((TextView)localObject1).setVisibility(0);
      localObject1 = this$1;
      localObject1 = this$0;
      localObject1 = ll_otp;
      i = 0;
      localObject2 = null;
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = val$params;
      int k = localObject1.length;
      i = 1;
      if (k > i)
      {
        localObject1 = this$1;
        localObject1 = this$0;
        i = maxtriesforresendotp + 1;
        maxtriesforresendotp = i;
        localObject1 = this$1;
        localObject1 = this$0;
        localObject2 = new in/gov/mgov/ors/AuthenticateNonAadhaar$AsyncTaskRunner$1$1;
        ((AuthenticateNonAadhaar.AsyncTaskRunner.1.1)localObject2).<init>(this);
        ((AuthenticateNonAadhaar)localObject1).runOnUiThread((Runnable)localObject2);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1 = this$1.this$0;
        Object localObject2 = new in/gov/mgov/ors/AuthenticateNonAadhaar$AsyncTaskRunner$1$2;
        ((AuthenticateNonAadhaar.AsyncTaskRunner.1.2)localObject2).<init>(this);
        ((AuthenticateNonAadhaar)localObject1).runOnUiThread((Runnable)localObject2);
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/AuthenticateNonAadhaar$AsyncTaskRunner$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */