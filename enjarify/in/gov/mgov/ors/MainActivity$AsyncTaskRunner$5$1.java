package in.gov.mgov.ors;

import android.content.res.Resources;
import android.widget.EditText;

class MainActivity$AsyncTaskRunner$5$1
  implements Runnable
{
  MainActivity$AsyncTaskRunner$5$1(MainActivity.AsyncTaskRunner.5 param5) {}
  
  public void run()
  {
    MainActivity localMainActivity = this$2.this$1.this$0;
    Object localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    Object localObject2 = this$2.this$1.this$0.getResources().getString(2131034263);
    localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(" ");
    localObject2 = this$2.this$1.this$0.aadhaar_name_number.getText();
    localObject1 = localObject2;
    MainActivity.access$200(localMainActivity, (String)localObject1);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$AsyncTaskRunner$5$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */