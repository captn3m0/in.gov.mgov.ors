package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;

class LabReport_2$3
  implements View.OnClickListener
{
  LabReport_2$3(LabReport_2 paramLabReport_2) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0;
    boolean bool = ((LabReport_2)localObject1).isConnected();
    if (bool)
    {
      localObject1 = new in/gov/mgov/ors/LabReport_2$CallList;
      Object localObject2 = this$0;
      ((LabReport_2.CallList)localObject1).<init>((LabReport_2)localObject2, null);
      int i = 1;
      localObject2 = new String[i];
      String str = "getRawOTP";
      localObject2[0] = str;
      ((LabReport_2.CallList)localObject1).execute((Object[])localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_2$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */