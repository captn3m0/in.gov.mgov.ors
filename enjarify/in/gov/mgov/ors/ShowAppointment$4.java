package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ShowAppointment$4
  implements View.OnClickListener
{
  ShowAppointment$4(ShowAppointment paramShowAppointment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new android/content/Intent;
    Context localContext = this$0.getApplicationContext();
    localIntent.<init>(localContext, MainActivity.class);
    this$0.finish();
    this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowAppointment$4.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */