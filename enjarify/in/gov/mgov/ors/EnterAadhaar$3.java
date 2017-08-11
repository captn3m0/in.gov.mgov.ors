package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class EnterAadhaar$3
  implements View.OnClickListener
{
  EnterAadhaar$3(EnterAadhaar paramEnterAadhaar) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new android/content/Intent;
    Context localContext = this$0.getApplicationContext();
    localIntent.<init>(localContext, ServiceSelection.class);
    localIntent.addFlags(268468224);
    this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/EnterAadhaar$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */