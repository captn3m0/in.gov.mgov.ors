package in.gov.mgov.ors;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

class LabReport_2$CallList$2$3
  implements View.OnClickListener
{
  LabReport_2$CallList$2$3(LabReport_2.CallList.2 param2) {}
  
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
      boolean bool = ((LabReport_2)localObject1).isConnected();
      if (bool)
      {
        localObject1 = new in/gov/mgov/ors/LabReport_2$CallListSecond;
        localObject2 = this$2.this$1.this$0;
        ((LabReport_2.CallListSecond)localObject1).<init>((LabReport_2)localObject2, null);
        j = 2;
        localObject2 = new String[j];
        localObject2[0] = "getRawOTP";
        k = 1;
        String str = "resend";
        localObject2[k] = str;
        ((LabReport_2.CallListSecond)localObject1).execute((Object[])localObject2);
      }
    }
    for (;;)
    {
      return;
      localObject1 = this$2.this$1.this$0;
      localObject2 = this$2.this$1.this$0.getResources();
      k = 2131034204;
      localObject2 = ((Resources)localObject2).getString(k);
      LabReport_2.access$500((LabReport_2)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_2$CallList$2$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */