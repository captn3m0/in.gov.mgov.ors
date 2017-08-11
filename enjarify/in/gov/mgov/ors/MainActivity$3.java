package in.gov.mgov.ors;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

class MainActivity$3
  implements View.OnClickListener
{
  MainActivity$3(MainActivity paramMainActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 8;
    this$0.aadhaar.setEnabled(false);
    this$0.showmobilenumber.setVisibility(0);
    TextView localTextView = this$0.showmobilenumber;
    String str = this$0.getResources().getString(2131034282);
    localTextView.setText(str);
    this$0.submit.setVisibility(i);
    this$0.no_aadhhar.setVisibility(i);
    this$0.ll_otp.setVisibility(i);
    this$0.ll_name.setVisibility(0);
    this$0.consent.setVisibility(i);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */