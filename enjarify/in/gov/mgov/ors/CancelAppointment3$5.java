package in.gov.mgov.ors;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class CancelAppointment3$5
  implements DialogInterface.OnClickListener
{
  CancelAppointment3$5(CancelAppointment3 paramCancelAppointment3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new android/content/Intent;
    Context localContext = this$0.getApplicationContext();
    localIntent.<init>(localContext, CancelAppointment2.class);
    this$0.startActivity(localIntent);
    this$0.finish();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment3$5.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */