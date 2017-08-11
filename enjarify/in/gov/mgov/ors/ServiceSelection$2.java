package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

class ServiceSelection$2
  implements View.OnClickListener
{
  ServiceSelection$2(ServiceSelection paramServiceSelection) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this$0.editor;
    String str = this$0.getResources().getString(2131034149);
    ((SharedPreferences.Editor)localObject).putString("source", str).commit();
    Intent localIntent = new android/content/Intent;
    localObject = this$0.getApplicationContext();
    localIntent.<init>((Context)localObject, BookAppointment.class);
    this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ServiceSelection$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */