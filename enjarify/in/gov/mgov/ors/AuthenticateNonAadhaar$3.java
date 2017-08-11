package in.gov.mgov.ors;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

class AuthenticateNonAadhaar$3
  implements View.OnClickListener
{
  AuthenticateNonAadhaar$3(AuthenticateNonAadhaar paramAuthenticateNonAadhaar) {}
  
  public void onClick(View paramView)
  {
    String str1 = null;
    Object localObject1 = this$0;
    boolean bool = ((AuthenticateNonAadhaar)localObject1).isConnected();
    Object localObject2;
    int k;
    if (bool)
    {
      localObject1 = this$0;
      int i = maxtriesforresendotp;
      int j = 3;
      if (i == j) {
        break label106;
      }
      AuthenticateNonAadhaar.access$002(this$0, "getRawOTP");
      localObject1 = new in/gov/mgov/ors/AuthenticateNonAadhaar$AsyncTaskRunner;
      localObject2 = this$0;
      ((AuthenticateNonAadhaar.AsyncTaskRunner)localObject1).<init>((AuthenticateNonAadhaar)localObject2, null);
      j = 2;
      localObject2 = new String[j];
      String str2 = "getRawOTP";
      localObject2[0] = str2;
      k = 1;
      str1 = "resendOTP";
      localObject2[k] = str1;
      ((AuthenticateNonAadhaar.AsyncTaskRunner)localObject1).execute((Object[])localObject2);
    }
    for (;;)
    {
      return;
      label106:
      this$0.maxtriesforresendotp = 0;
      localObject1 = this$0;
      localObject2 = this$0.getResources();
      k = 2131034204;
      localObject2 = ((Resources)localObject2).getString(k);
      AuthenticateNonAadhaar.access$400((AuthenticateNonAadhaar)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/AuthenticateNonAadhaar$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */