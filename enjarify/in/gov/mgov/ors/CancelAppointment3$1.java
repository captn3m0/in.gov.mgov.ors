package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;

class CancelAppointment3$1
  implements View.OnClickListener
{
  CancelAppointment3$1(CancelAppointment3 paramCancelAppointment3) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0;
    boolean bool = ((CancelAppointment3)localObject1).isConnected();
    if (bool)
    {
      localObject1 = new in/gov/mgov/ors/CancelAppointment3$CallList;
      Object localObject2 = this$0;
      ((CancelAppointment3.CallList)localObject1).<init>((CancelAppointment3)localObject2, null);
      int i = 1;
      localObject2 = new String[i];
      String str = "getRawOTP";
      localObject2[0] = str;
      ((CancelAppointment3.CallList)localObject1).execute((Object[])localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment3$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */