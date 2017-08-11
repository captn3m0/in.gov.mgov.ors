package in.gov.mgov.helper;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;

public class Helper
{
  private Context context;
  
  public Helper(Context paramContext)
  {
    context = paramContext;
  }
  
  public void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    Object localObject = context;
    localBuilder.<init>((Context)localObject);
    localBuilder.setTitle("e-Hospital");
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    Helper.1 local1 = new in/gov/mgov/helper/Helper$1;
    local1.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton("OK", local1);
    localBuilder.create().show();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/helper/Helper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */