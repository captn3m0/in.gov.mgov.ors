package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;

class EnterAadhaar$2
  implements View.OnClickListener
{
  EnterAadhaar$2(EnterAadhaar paramEnterAadhaar) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0;
    boolean bool = ((EnterAadhaar)localObject1).isConnected();
    Object localObject2;
    if (bool)
    {
      localObject1 = this$0.consent;
      bool = ((CheckBox)localObject1).isChecked();
      if (!bool) {
        break label107;
      }
      localObject1 = this$0.editor;
      String str = this$0.aadhaar.getText().toString();
      ((SharedPreferences.Editor)localObject1).putString("aadhaar_no", str).commit();
      Intent localIntent = new android/content/Intent;
      localObject1 = this$0.getApplicationContext();
      localObject2 = MainActivity.class;
      localIntent.<init>((Context)localObject1, (Class)localObject2);
      localObject1 = this$0;
      ((EnterAadhaar)localObject1).startActivity(localIntent);
    }
    for (;;)
    {
      return;
      label107:
      localObject1 = this$0;
      localObject2 = this$0.getResources();
      int i = 2131034287;
      localObject2 = ((Resources)localObject2).getString(i);
      EnterAadhaar.access$100((EnterAadhaar)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/EnterAadhaar$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */