package in.gov.mgov.ors;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class AuthenticateNonAadhaar$1
  implements View.OnClickListener
{
  AuthenticateNonAadhaar$1(AuthenticateNonAadhaar paramAuthenticateNonAadhaar) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0;
    boolean bool = ((AuthenticateNonAadhaar)localObject1).isConnected();
    Object localObject2;
    int k;
    if (bool)
    {
      localObject1 = this$0.number;
      int i = ((EditText)localObject1).length();
      int j = 10;
      if (i != j) {
        break label95;
      }
      AuthenticateNonAadhaar.access$002(this$0, "getRawOTP");
      localObject1 = new in/gov/mgov/ors/AuthenticateNonAadhaar$AsyncTaskRunner;
      localObject2 = this$0;
      ((AuthenticateNonAadhaar.AsyncTaskRunner)localObject1).<init>((AuthenticateNonAadhaar)localObject2, null);
      j = 1;
      localObject2 = new String[j];
      k = 0;
      String str = "getRawOTP";
      localObject2[0] = str;
      ((AuthenticateNonAadhaar.AsyncTaskRunner)localObject1).execute((Object[])localObject2);
    }
    for (;;)
    {
      return;
      label95:
      localObject1 = this$0;
      localObject2 = this$0.getResources();
      k = 2131034196;
      localObject2 = ((Resources)localObject2).getString(k);
      AuthenticateNonAadhaar.access$200((AuthenticateNonAadhaar)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/AuthenticateNonAadhaar$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */