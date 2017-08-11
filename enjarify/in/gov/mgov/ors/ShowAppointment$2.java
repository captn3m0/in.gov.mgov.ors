package in.gov.mgov.ors;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ShowAppointment$2
  implements View.OnClickListener
{
  ShowAppointment$2(ShowAppointment paramShowAppointment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new android/content/Intent;
    ShowAppointment localShowAppointment = this$0;
    localIntent.<init>(localShowAppointment, payment.class);
    this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowAppointment$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */