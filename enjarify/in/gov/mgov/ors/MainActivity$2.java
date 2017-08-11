package in.gov.mgov.ors;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;

class MainActivity$2
  implements View.OnClickListener
{
  MainActivity$2(MainActivity paramMainActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0.otp.getText().toString();
    int i = ((String)localObject1).length();
    int j = 6;
    Object localObject2;
    if (i == j)
    {
      localObject1 = this$0.consent;
      boolean bool = ((CheckBox)localObject1).isChecked();
      if (bool)
      {
        localObject1 = this$0;
        localObject2 = "AuthenticateKYCUsingOTP";
        MainActivity.access$102((MainActivity)localObject1, (String)localObject2);
        localObject1 = this$0;
        bool = ((MainActivity)localObject1).isConnected();
        if (bool)
        {
          MainActivity.AsyncTaskRunner localAsyncTaskRunner = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner;
          localObject1 = this$0;
          localAsyncTaskRunner.<init>((MainActivity)localObject1, null);
          bool = true;
          localObject1 = new String[bool];
          j = 0;
          localObject2 = null;
          String str = "otp";
          localObject1[0] = str;
          localAsyncTaskRunner.execute((Object[])localObject1);
        }
      }
    }
    for (;;)
    {
      return;
      localObject1 = this$0;
      localObject2 = this$0.getResources();
      int k = 2131034287;
      localObject2 = ((Resources)localObject2).getString(k);
      MainActivity.access$200((MainActivity)localObject1, (String)localObject2);
      continue;
      localObject1 = this$0;
      localObject2 = this$0.getResources();
      k = 2131034284;
      localObject2 = ((Resources)localObject2).getString(k);
      MainActivity.access$200((MainActivity)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */