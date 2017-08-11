package in.gov.mgov.ors;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

class MainActivity$AsyncTaskRunner$2
  implements Runnable
{
  MainActivity$AsyncTaskRunner$2(MainActivity.AsyncTaskRunner paramAsyncTaskRunner, String[] paramArrayOfString) {}
  
  public void run()
  {
    int i = 2131034202;
    int j = 8;
    Object localObject1 = val$params[0];
    Object localObject2 = "aadhaar";
    boolean bool = ((String)localObject1).equals(localObject2);
    if (bool)
    {
      localObject1 = this$1.this$0.finalresp;
      localObject2 = "\"err\":\"111\"";
      bool = ((String)localObject1).contains((CharSequence)localObject2);
      if (bool)
      {
        this$1.this$0.aadhaar.setEnabled(false);
        this$1.this$0.showmobilenumber.setVisibility(0);
        localObject1 = this$1.this$0.showmobilenumber;
        localObject2 = this$1.this$0.getResources();
        i = 2131034232;
        localObject2 = ((Resources)localObject2).getString(i);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        this$1.this$0.submit.setVisibility(j);
        this$1.this$0.no_aadhhar.setVisibility(j);
        this$1.this$0.ll_name.setVisibility(0);
        localObject1 = this$1.this$0.consent;
        ((CheckBox)localObject1).setVisibility(j);
      }
    }
    for (;;)
    {
      return;
      localObject1 = val$params[0];
      localObject2 = "aadhaar";
      bool = ((String)localObject1).equals(localObject2);
      if (bool)
      {
        localObject1 = this$1.this$0.finalresp;
        localObject2 = "\"err\":\"540\"";
        bool = ((String)localObject1).contains((CharSequence)localObject2);
        if (bool)
        {
          this$1.this$0.aadhaar.setEnabled(false);
          this$1.this$0.showmobilenumber.setVisibility(0);
          localObject1 = this$1.this$0.showmobilenumber;
          localObject2 = this$1.this$0.getResources().getString(i);
          ((TextView)localObject1).setText((CharSequence)localObject2);
          this$1.this$0.submit.setVisibility(j);
          this$1.this$0.no_aadhhar.setVisibility(j);
          localObject1 = this$1.this$0.consent;
          ((CheckBox)localObject1).setVisibility(j);
          continue;
        }
      }
      this$1.this$0.aadhaar.setEnabled(false);
      this$1.this$0.showmobilenumber.setVisibility(0);
      localObject1 = this$1.this$0.showmobilenumber;
      localObject2 = this$1.this$0.getResources().getString(i);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      this$1.this$0.submit.setVisibility(j);
      this$1.this$0.no_aadhhar.setVisibility(j);
      localObject1 = this$1.this$0.consent;
      ((CheckBox)localObject1).setVisibility(j);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$AsyncTaskRunner$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */