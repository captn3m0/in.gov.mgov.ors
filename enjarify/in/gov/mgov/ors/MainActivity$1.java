package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;

class MainActivity$1
  implements View.OnClickListener
{
  MainActivity$1(MainActivity paramMainActivity) {}
  
  public void onClick(View paramView)
  {
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
        i = 0;
        localAsyncTaskRunner.<init>((MainActivity)localObject, null);
        bool = true;
        localObject = new String[bool];
        String str = "aadhaar";
        localObject[0] = str;
        localAsyncTaskRunner.execute((Object[])localObject);
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */