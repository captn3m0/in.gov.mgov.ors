package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;

class MainActivity$5
  implements View.OnClickListener
{
  MainActivity$5(MainActivity paramMainActivity) {}
  
  public void onClick(View paramView)
  {
    String str1 = null;
    Object localObject = this$0.showmobilenumber;
    int i = 8;
    ((TextView)localObject).setVisibility(i);
    this$0.no_aadhhar.setVisibility(0);
    localObject = this$0.consent;
    boolean bool = ((CheckBox)localObject).isChecked();
    if (bool)
    {
      localObject = this$0;
      bool = ((MainActivity)localObject).isConnected();
      if (bool)
      {
        MainActivity.access$102(this$0, "createOtpDetails");
        MainActivity.AsyncTaskRunner localAsyncTaskRunner = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner;
        localObject = this$0;
        localAsyncTaskRunner.<init>((MainActivity)localObject, null);
        int j = 2;
        localObject = new String[j];
        String str2 = "aadhaar";
        localObject[0] = str2;
        i = 1;
        str1 = "1212";
        localObject[i] = str1;
        localAsyncTaskRunner.execute((Object[])localObject);
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$5.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */