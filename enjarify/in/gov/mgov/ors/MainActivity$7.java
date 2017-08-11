package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

class MainActivity$7
  implements View.OnClickListener
{
  MainActivity$7(MainActivity paramMainActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 8;
    Object localObject1 = this$0.aadhaar_name_otp.getText().toString();
    int j = ((String)localObject1).length();
    int m = 5;
    Object localObject2;
    if (j == m)
    {
      localObject1 = this$0.OTP_RES;
      localObject2 = this$0.aadhaar_name_otp.getText().toString();
      boolean bool = ((String)localObject1).equals(localObject2);
      if (bool)
      {
        Intent localIntent = new android/content/Intent;
        localObject1 = this$0.getApplicationContext();
        localIntent.<init>((Context)localObject1, GetUserInformation.class);
        localIntent.putExtra("from", "fromaadhaar");
        localObject2 = this$0.aadhaar_name.getText().toString();
        localIntent.putExtra("name", (String)localObject2);
        localObject2 = this$0.aadhaar_name_number.getText().toString();
        localIntent.putExtra("mono", (String)localObject2);
        localObject1 = this$0;
        ((MainActivity)localObject1).startActivity(localIntent);
      }
    }
    for (;;)
    {
      return;
      localObject1 = this$0;
      localObject2 = this$0.getResources();
      int n = 2131034339;
      localObject2 = ((Resources)localObject2).getString(n);
      MainActivity.access$200((MainActivity)localObject1, (String)localObject2);
      localObject1 = this$0;
      m = maxTriesforOTP + 1;
      maxTriesforOTP = m;
      localObject1 = this$0;
      int k = maxTriesforOTP;
      m = 2;
      if (k == m)
      {
        this$0.maxTriesforOTP = 0;
        localObject1 = this$0;
        localObject2 = this$0.getResources();
        n = 2131034188;
        localObject2 = ((Resources)localObject2).getString(n);
        MainActivity.access$200((MainActivity)localObject1, (String)localObject2);
        this$0.showmobilenumber_demo.setVisibility(i);
        this$0.resetmobilenumber.setVisibility(i);
        this$0.ll_name_otp.setVisibility(i);
        localObject1 = this$0.aadhaar_name_number;
        localObject2 = "";
        ((EditText)localObject1).setText((CharSequence)localObject2);
        localObject1 = this$0.aadhaar_name_number;
        m = 1;
        ((EditText)localObject1).setEnabled(m);
        localObject1 = this$0.proceed_name_number;
        ((Button)localObject1).setVisibility(0);
        continue;
        localObject1 = this$0;
        localObject2 = this$0.getResources();
        n = 2131034195;
        localObject2 = ((Resources)localObject2).getString(n);
        MainActivity.access$200((MainActivity)localObject1, (String)localObject2);
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$7.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */