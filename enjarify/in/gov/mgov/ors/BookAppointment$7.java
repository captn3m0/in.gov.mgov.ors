package in.gov.mgov.ors;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

class BookAppointment$7
  implements View.OnClickListener
{
  BookAppointment$7(BookAppointment paramBookAppointment) {}
  
  public void onClick(View paramView)
  {
    Context localContext = this$0.getApplicationContext();
    String str = this$0.getResources().getString(2131034325);
    Toast.makeText(localContext, str, 1).show();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointment$7.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */