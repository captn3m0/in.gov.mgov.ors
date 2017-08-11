package in.gov.mgov.ors;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class MainActivity$6
  implements View.OnClickListener
{
  MainActivity$6(MainActivity paramMainActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0.aadhaar_name_number;
    int i = ((EditText)localObject1).length();
    int j = 10;
    Object localObject2;
    int k;
    if (i == j)
    {
      localObject1 = this$0;
      localObject2 = "getRawOTP";
      MainActivity.access$102((MainActivity)localObject1, (String)localObject2);
      localObject1 = this$0;
      boolean bool = ((MainActivity)localObject1).isConnected();
      if (bool)
      {
        localObject1 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner;
        localObject2 = this$0;
        ((MainActivity.AsyncTaskRunner)localObject1).<init>((MainActivity)localObject2, null);
        j = 1;
        localObject2 = new String[j];
        k = 0;
        String str = "getRawOTP";
        localObject2[0] = str;
        ((MainActivity.AsyncTaskRunner)localObject1).execute((Object[])localObject2);
      }
    }
    for (;;)
    {
      return;
      localObject1 = this$0;
      localObject2 = this$0.getResources();
      k = 2131034194;
      localObject2 = ((Resources)localObject2).getString(k);
      MainActivity.access$200((MainActivity)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$6.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */