package in.gov.mgov.ors;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

class MainActivity$AsyncTaskRunner$4
  implements Runnable
{
  MainActivity$AsyncTaskRunner$4(MainActivity.AsyncTaskRunner paramAsyncTaskRunner) {}
  
  public void run()
  {
    int i = 8;
    this$1.this$0.aadhaar_name.setEnabled(false);
    EditText localEditText = this$1.this$0.aadhaar_name;
    String str = this$1.this$0.getResources().getString(2131034344);
    localEditText.setHint(str);
    this$1.this$0.showmobilenumber.setVisibility(i);
    this$1.this$0.proceed_name.setVisibility(i);
    this$1.this$0.ll_name_number.setVisibility(0);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$AsyncTaskRunner$4.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */