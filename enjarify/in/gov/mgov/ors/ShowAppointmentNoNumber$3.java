package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ShowAppointmentNoNumber$3
  implements View.OnClickListener
{
  ShowAppointmentNoNumber$3(ShowAppointmentNoNumber paramShowAppointmentNoNumber) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new android/content/Intent;
    Context localContext = this$0.getApplicationContext();
    localIntent.<init>(localContext, ServiceSelection.class);
    localIntent.addFlags(268468224);
    this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowAppointmentNoNumber$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */