package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

public class payment$WebAppInterface
{
  Context mContext;
  
  payment$WebAppInterface(payment parampayment, Context paramContext)
  {
    mContext = paramContext;
  }
  
  public void performClick()
  {
    this$0.editor.putString("paymentstatus", "ok").commit();
    Intent localIntent = new android/content/Intent;
    Context localContext = this$0.getApplicationContext();
    localIntent.<init>(localContext, ServiceSelection.class);
    localIntent.addFlags(268468224);
    this$0.startActivity(localIntent);
  }
  
  public void showToast(String paramString)
  {
    Toast.makeText(mContext, paramString, 0).show();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/payment$WebAppInterface.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */