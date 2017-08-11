package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

class MainActivity$8
  implements View.OnClickListener
{
  MainActivity$8(MainActivity paramMainActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 8;
    this$0.resetmobilenumber.setVisibility(i);
    this$0.ll_name_otp.setVisibility(i);
    this$0.proceed_name_number.setVisibility(0);
    this$0.aadhaar_name_number.setText("");
    this$0.aadhaar_name_number.setEnabled(true);
    this$0.text31a.setVisibility(0);
    this$0.showmobilenumber_demo.setVisibility(i);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$8.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */