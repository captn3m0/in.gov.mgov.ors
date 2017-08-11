package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class MainActivity$4
  implements View.OnClickListener
{
  MainActivity$4(MainActivity paramMainActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0.aadhaar_name.getText().toString();
    int i = ((String)localObject1).length();
    if (i != 0)
    {
      localObject1 = this$0;
      Object localObject2 = "AuthUsingName";
      MainActivity.access$102((MainActivity)localObject1, (String)localObject2);
      localObject1 = this$0;
      boolean bool = ((MainActivity)localObject1).isConnected();
      if (bool)
      {
        localObject1 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner;
        localObject2 = this$0;
        ((MainActivity.AsyncTaskRunner)localObject1).<init>((MainActivity)localObject2, null);
        int j = 1;
        localObject2 = new String[j];
        String str = "AuthUsingName";
        localObject2[0] = str;
        ((MainActivity.AsyncTaskRunner)localObject1).execute((Object[])localObject2);
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$4.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */