package in.gov.mgov.ors;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

class ServiceSelection$5
  implements View.OnClickListener
{
  ServiceSelection$5(ServiceSelection paramServiceSelection) {}
  
  public void onClick(View paramView)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    Object localObject = this$0;
    localBuilder.<init>((Context)localObject);
    localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    String str = this$0.getResources().getString(2131034120);
    localObject = ((StringBuilder)localObject).append(str).append(": ");
    str = this$0.appversion;
    localObject = str;
    localBuilder.setTitle((CharSequence)localObject);
    localObject = this$0.getResources().getString(2131034121);
    localObject = localBuilder.setMessage((CharSequence)localObject).setCancelable(false);
    str = this$0.getResources().getString(2131034259);
    ServiceSelection.5.1 local1 = new in/gov/mgov/ors/ServiceSelection$5$1;
    local1.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local1);
    localBuilder.create().show();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ServiceSelection$5.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */