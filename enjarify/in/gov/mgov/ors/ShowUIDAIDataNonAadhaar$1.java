package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ShowUIDAIDataNonAadhaar$1
  implements View.OnClickListener
{
  ShowUIDAIDataNonAadhaar$1(ShowUIDAIDataNonAadhaar paramShowUIDAIDataNonAadhaar) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new android/content/Intent;
    Context localContext = this$0.getApplicationContext();
    localIntent.<init>(localContext, ServiceSelection.class);
    localIntent.addFlags(268468224);
    this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowUIDAIDataNonAadhaar$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */