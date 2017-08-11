package in.gov.mgov.ors;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;

class BookAppointmentWithout$4
  implements AdapterView.OnItemSelectedListener
{
  BookAppointmentWithout$4(BookAppointmentWithout paramBookAppointmentWithout) {}
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    int i;
    if (paramInt != 0)
    {
      localObject = this$0;
      String str = this$0.date[paramInt];
      dateString = str;
      localObject = this$0.yes;
      i = 0;
      ((Button)localObject).setVisibility(0);
      localObject = this$0;
      str = this$0.date[paramInt];
      appdate = str;
    }
    for (;;)
    {
      return;
      localObject = this$0.proceed;
      i = 8;
      ((Button)localObject).setVisibility(i);
    }
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointmentWithout$4.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */