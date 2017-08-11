package in.gov.mgov.ors;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

class MainActivity$9
  implements View.OnClickListener
{
  MainActivity$9(MainActivity paramMainActivity) {}
  
  public void onClick(View paramView)
  {
    String str1 = null;
    Object localObject1 = this$0;
    int i = maxTriesforresendOTP;
    int j = 4;
    Object localObject2;
    int k;
    if (i < j)
    {
      localObject1 = this$0;
      boolean bool = ((MainActivity)localObject1).isConnected();
      if (bool)
      {
        MainActivity.access$102(this$0, "getRawOTP");
        localObject1 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner;
        localObject2 = this$0;
        ((MainActivity.AsyncTaskRunner)localObject1).<init>((MainActivity)localObject2, null);
        j = 2;
        localObject2 = new String[j];
        String str2 = "getRawOTP";
        localObject2[0] = str2;
        k = 1;
        str1 = "resendotp";
        localObject2[k] = str1;
        ((MainActivity.AsyncTaskRunner)localObject1).execute((Object[])localObject2);
      }
    }
    for (;;)
    {
      return;
      this$0.maxTriesforresendOTP = 0;
      localObject1 = this$0;
      localObject2 = this$0.getResources();
      k = 2131034204;
      localObject2 = ((Resources)localObject2).getString(k);
      MainActivity.access$300((MainActivity)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$9.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */