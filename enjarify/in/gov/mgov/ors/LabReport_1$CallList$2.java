package in.gov.mgov.ors;

import android.content.Context;
import android.content.res.Resources;
import in.gov.mgov.helper.Helper;

class LabReport_1$CallList$2
  implements Runnable
{
  LabReport_1$CallList$2(LabReport_1.CallList paramCallList) {}
  
  public void run()
  {
    Helper localHelper = new in/gov/mgov/helper/Helper;
    Object localObject = this$1.this$0.getApplicationContext();
    localHelper.<init>((Context)localObject);
    localObject = this$1.this$0.getResources().getString(2131034253);
    localHelper.showDialogonclick((String)localObject);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_1$CallList$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */