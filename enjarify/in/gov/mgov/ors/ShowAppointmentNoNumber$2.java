package in.gov.mgov.ors;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ShowAppointmentNoNumber$2
  implements View.OnClickListener
{
  ShowAppointmentNoNumber$2(ShowAppointmentNoNumber paramShowAppointmentNoNumber) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new android/content/Intent;
    ShowAppointmentNoNumber localShowAppointmentNoNumber = this$0;
    localIntent.<init>(localShowAppointmentNoNumber, payment.class);
    this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowAppointmentNoNumber$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */