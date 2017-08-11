package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;

class ShowUIDAIDataNonAadhaar$2
  implements View.OnClickListener
{
  ShowUIDAIDataNonAadhaar$2(ShowUIDAIDataNonAadhaar paramShowUIDAIDataNonAadhaar) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0;
    boolean bool = ((ShowUIDAIDataNonAadhaar)localObject1).isConnected();
    if (bool)
    {
      localObject1 = new in/gov/mgov/ors/ShowUIDAIDataNonAadhaar$CallList;
      Object localObject2 = this$0;
      ((ShowUIDAIDataNonAadhaar.CallList)localObject1).<init>((ShowUIDAIDataNonAadhaar)localObject2, null);
      int i = 1;
      localObject2 = new String[i];
      String str = "fixAppointment";
      localObject2[0] = str;
      ((ShowUIDAIDataNonAadhaar.CallList)localObject1).execute((Object[])localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowUIDAIDataNonAadhaar$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */