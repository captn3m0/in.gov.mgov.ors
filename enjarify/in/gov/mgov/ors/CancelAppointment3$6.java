package in.gov.mgov.ors;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class CancelAppointment3$6
  implements DialogInterface.OnClickListener
{
  CancelAppointment3$6(CancelAppointment3 paramCancelAppointment3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new android/content/Intent;
    Context localContext = this$0.getApplicationContext();
    localIntent.<init>(localContext, ServiceSelection.class);
    localIntent.addFlags(268468224);
    this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment3$6.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */