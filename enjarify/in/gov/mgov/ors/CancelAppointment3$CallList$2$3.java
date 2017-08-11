package in.gov.mgov.ors;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

class CancelAppointment3$CallList$2$3
  implements View.OnClickListener
{
  CancelAppointment3$CallList$2$3(CancelAppointment3.CallList.2 param2) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$2.this$1.this$0;
    int i = maxTriesforOTP;
    int j = 3;
    Object localObject2;
    int k;
    if (i < j)
    {
      localObject1 = this$2.this$1.this$0;
      boolean bool = ((CancelAppointment3)localObject1).isConnected();
      if (bool)
      {
        localObject1 = new in/gov/mgov/ors/CancelAppointment3$CallListSecond;
        localObject2 = this$2.this$1.this$0;
        ((CancelAppointment3.CallListSecond)localObject1).<init>((CancelAppointment3)localObject2, null);
        j = 2;
        localObject2 = new String[j];
        localObject2[0] = "getRawOTP";
        k = 1;
        String str = "resend";
        localObject2[k] = str;
        ((CancelAppointment3.CallListSecond)localObject1).execute((Object[])localObject2);
      }
    }
    for (;;)
    {
      return;
      localObject1 = this$2.this$1.this$0;
      localObject2 = this$2.this$1.this$0.getResources();
      k = 2131034204;
      localObject2 = ((Resources)localObject2).getString(k);
      CancelAppointment3.access$400((CancelAppointment3)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment3$CallList$2$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */