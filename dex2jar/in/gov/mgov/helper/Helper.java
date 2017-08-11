package in.gov.mgov.helper;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class Helper
{
  private Context context;
  
  public Helper(Context paramContext)
  {
    context = paramContext;
  }
  
  public void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(context);
    localBuilder.setTitle("e-Hospital");
    localBuilder.setMessage(paramString).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    localBuilder.create().show();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/helper/Helper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */