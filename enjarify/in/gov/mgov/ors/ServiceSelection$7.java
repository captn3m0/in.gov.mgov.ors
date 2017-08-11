package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

class ServiceSelection$7
  implements View.OnClickListener
{
  ServiceSelection$7(ServiceSelection paramServiceSelection) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this$0.editor;
    String str = this$0.getResources().getString(2131034150);
    ((SharedPreferences.Editor)localObject).putString("source", str).commit();
    Intent localIntent = new android/content/Intent;
    localObject = this$0.getApplicationContext();
    localIntent.<init>((Context)localObject, BookAppointmentWithout.class);
    this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ServiceSelection$7.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */