package in.gov.mgov.ors;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

class CancelAppointment_1$2
  implements AdapterView.OnItemSelectedListener
{
  CancelAppointment_1$2(CancelAppointment_1 paramCancelAppointment_1) {}
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt != 0)
    {
      CancelAppointment_1 localCancelAppointment_1 = this$0;
      String str = this$0.mhospital.getSelectedItem().toString();
      hospitalname = str;
      localCancelAppointment_1 = this$0;
      str = this$0.hospitalid[paramInt];
      hospitalcode = str;
    }
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment_1$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */