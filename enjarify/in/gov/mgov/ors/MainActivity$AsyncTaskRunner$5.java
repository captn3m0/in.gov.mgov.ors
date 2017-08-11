package in.gov.mgov.ors;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

class MainActivity$AsyncTaskRunner$5
  implements Runnable
{
  MainActivity$AsyncTaskRunner$5(MainActivity.AsyncTaskRunner paramAsyncTaskRunner, JSONObject paramJSONObject, String[] paramArrayOfString) {}
  
  public void run()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        localObject1 = this$1;
        localObject1 = this$0;
        localObject2 = val$obj;
        localObject3 = "data";
        localObject2 = ((JSONObject)localObject2).getString((String)localObject3);
        OTP_RES = ((String)localObject2);
        localObject1 = this$1;
        localObject1 = this$0;
        localObject1 = ll_name_otp;
        j = 0;
        localObject2 = null;
        ((LinearLayout)localObject1).setVisibility(0);
        localObject1 = this$1;
        localObject1 = this$0;
        localObject1 = showmobilenumber_demo;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject3 = this$1;
        localObject3 = this$0;
        localObject3 = ((MainActivity)localObject3).getResources();
        k = 2131034267;
        localObject3 = ((Resources)localObject3).getString(k);
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        localObject3 = this$1;
        localObject3 = this$0;
        localObject3 = aadhaar_name_number;
        localObject3 = ((EditText)localObject3).getText();
        localObject2 = ((StringBuilder)localObject2).append(localObject3);
        localObject2 = ((StringBuilder)localObject2).toString();
        ((TextView)localObject1).setText((CharSequence)localObject2);
        localObject1 = this$1;
        localObject1 = this$0;
        localObject1 = showmobilenumber_demo;
        j = 0;
        localObject2 = null;
        ((TextView)localObject1).setVisibility(0);
        localObject1 = this$1;
        localObject1 = this$0;
        localObject1 = aadhaar_name_number;
        j = 0;
        localObject2 = null;
        ((EditText)localObject1).setEnabled(false);
        localObject1 = this$1;
        localObject1 = this$0;
        localObject1 = text31a;
        j = 8;
        ((TextView)localObject1).setVisibility(j);
        localObject1 = this$1;
        localObject1 = this$0;
        localObject1 = proceed_name_number;
        j = 8;
        ((Button)localObject1).setVisibility(j);
        localObject1 = this$1;
        localObject1 = this$0;
        localObject1 = resetmobilenumber;
        j = 0;
        localObject2 = null;
        ((TextView)localObject1).setVisibility(0);
        localObject1 = this$1;
        localObject1 = this$0;
        localObject1 = aadhaar_name_otp;
        ((EditText)localObject1).requestFocus();
        localObject1 = val$params;
        int m = localObject1.length;
        if (m <= i) {
          continue;
        }
        localObject1 = val$params;
        j = 1;
        localObject1 = localObject1[j];
        localObject2 = "resendotp";
        boolean bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
        if (bool)
        {
          localObject1 = this$1;
          localObject1 = this$0;
          j = maxTriesforresendOTP + 1;
          maxTriesforresendOTP = j;
          localObject1 = this$1;
          localObject1 = this$0;
          localObject2 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner$5$1;
          ((MainActivity.AsyncTaskRunner.5.1)localObject2).<init>(this);
          ((MainActivity)localObject1).runOnUiThread((Runnable)localObject2);
          localObject1 = this$1;
          localObject1 = this$0;
          int n = maxTriesforresendOTP;
          j = 3;
          if (n == j) {}
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        int j;
        localJSONException.printStackTrace();
        continue;
        Object localObject1 = this$1;
        localObject1 = this$0;
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        Object localObject3 = this$1;
        localObject3 = this$0;
        localObject3 = ((MainActivity)localObject3).getResources();
        int k = 2131034266;
        localObject3 = ((Resources)localObject3).getString(k);
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        localObject3 = " ";
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        localObject3 = this$1;
        localObject3 = this$0;
        localObject3 = aadhaar_name_number;
        localObject3 = ((EditText)localObject3).getText();
        localObject2 = ((StringBuilder)localObject2).append(localObject3);
        localObject2 = ((StringBuilder)localObject2).toString();
        MainActivity.access$200((MainActivity)localObject1, (String)localObject2);
        continue;
      }
      localObject1 = this$1;
      localObject1 = this$0;
      j = 0;
      localObject2 = null;
      maxTriesforresendOTP = 0;
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$AsyncTaskRunner$5.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */