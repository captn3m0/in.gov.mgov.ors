package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class AuthenticateNonAadhaar$2
  implements View.OnClickListener
{
  AuthenticateNonAadhaar$2(AuthenticateNonAadhaar paramAuthenticateNonAadhaar) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0.otp.getText().toString();
    Object localObject2 = this$0.OTP_RES;
    boolean bool = ((String)localObject1).equals(localObject2);
    if (bool)
    {
      Intent localIntent = new android/content/Intent;
      localObject1 = this$0.getApplicationContext();
      localIntent.<init>((Context)localObject1, GetUserInformationNonAadhaar.class);
      localIntent.putExtra("from", "noaadhaar");
      localObject2 = this$0.number.getText().toString();
      localIntent.putExtra("mono", (String)localObject2);
      localObject1 = this$0;
      ((AuthenticateNonAadhaar)localObject1).startActivity(localIntent);
    }
    for (;;)
    {
      return;
      localObject1 = this$0;
      localObject2 = this$0.getResources();
      int i = 2131034339;
      localObject2 = ((Resources)localObject2).getString(i);
      AuthenticateNonAadhaar.access$300((AuthenticateNonAadhaar)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/AuthenticateNonAadhaar$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */