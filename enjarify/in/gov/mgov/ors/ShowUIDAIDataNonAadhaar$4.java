package in.gov.mgov.ors;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ShowUIDAIDataNonAadhaar$4
  implements DialogInterface.OnClickListener
{
  ShowUIDAIDataNonAadhaar$4(ShowUIDAIDataNonAadhaar paramShowUIDAIDataNonAadhaar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new android/content/Intent;
    Context localContext = this$0.getApplicationContext();
    localIntent.<init>(localContext, ServiceSelection.class);
    localIntent.addFlags(268468224);
    this$0.startActivity(localIntent);
    paramDialogInterface.cancel();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowUIDAIDataNonAadhaar$4.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */