package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ServiceSelection$8
  implements View.OnClickListener
{
  ServiceSelection$8(ServiceSelection paramServiceSelection) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new android/content/Intent;
    Context localContext = this$0.getApplicationContext();
    localIntent.<init>(localContext, BloodAvailability1.class);
    this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ServiceSelection$8.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */