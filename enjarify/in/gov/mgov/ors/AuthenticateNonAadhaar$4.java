package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

class AuthenticateNonAadhaar$4
  implements View.OnClickListener
{
  AuthenticateNonAadhaar$4(AuthenticateNonAadhaar paramAuthenticateNonAadhaar) {}
  
  public void onClick(View paramView)
  {
    int i = 8;
    this$0.getotp.setVisibility(0);
    this$0.number.setEnabled(true);
    this$0.ll_otp.setVisibility(i);
    this$0.showNumber.setVisibility(i);
    this$0.resetnumber.setVisibility(i);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/AuthenticateNonAadhaar$4.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */