package in.gov.mgov.ors;

import android.content.res.Resources;
import android.widget.EditText;

class AuthenticateNonAadhaar$AsyncTaskRunner$1$1
  implements Runnable
{
  AuthenticateNonAadhaar$AsyncTaskRunner$1$1(AuthenticateNonAadhaar.AsyncTaskRunner.1 param1) {}
  
  public void run()
  {
    AuthenticateNonAadhaar localAuthenticateNonAadhaar = this$2.this$1.this$0;
    Object localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    Object localObject2 = this$2.this$1.this$0.getResources().getString(2131034263);
    localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(" ");
    localObject2 = this$2.this$1.this$0.number.getText();
    localObject1 = localObject2;
    AuthenticateNonAadhaar.access$200(localAuthenticateNonAadhaar, (String)localObject1);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/AuthenticateNonAadhaar$AsyncTaskRunner$1$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */