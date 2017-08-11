package in.gov.mgov.ors;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import nitesh.floatinghint.FloatingHintEditText;

class CancelAppointment3$CallList$2$1
  implements View.OnClickListener
{
  CancelAppointment3$CallList$2$1(CancelAppointment3.CallList.2 param2) {}
  
  public void onClick(View paramView)
  {
    String str1 = this$2.val$input.getText().toString();
    Object localObject1 = this$2.this$1.this$0.OTP;
    boolean bool = str1.equals(localObject1);
    Object localObject2;
    int j;
    if (bool)
    {
      localObject1 = this$2.this$1.this$0;
      bool = ((CancelAppointment3)localObject1).isConnected();
      if (bool)
      {
        localObject1 = this$2.this$1.this$0;
        localObject2 = "cancelAppointment";
        CancelAppointment3.access$102((CancelAppointment3)localObject1, (String)localObject2);
      }
      localObject1 = new in/gov/mgov/ors/CancelAppointment3$CallListSecond;
      localObject2 = this$2.this$1.this$0;
      ((CancelAppointment3.CallListSecond)localObject1).<init>((CancelAppointment3)localObject2, null);
      int i = 1;
      localObject2 = new String[i];
      j = 0;
      String str2 = "cancelAppointment";
      localObject2[0] = str2;
      ((CancelAppointment3.CallListSecond)localObject1).execute((Object[])localObject2);
    }
    for (;;)
    {
      return;
      localObject1 = this$2.this$1.this$0;
      localObject2 = this$2.this$1.this$0.getResources();
      j = 2131034339;
      localObject2 = ((Resources)localObject2).getString(j);
      CancelAppointment3.access$200((CancelAppointment3)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment3$CallList$2$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */