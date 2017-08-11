package in.gov.mgov.ors;

import android.content.res.Resources;
import android.widget.EditText;

class MainActivity$AsyncTaskRunner$3
  implements Runnable
{
  MainActivity$AsyncTaskRunner$3(MainActivity.AsyncTaskRunner paramAsyncTaskRunner) {}
  
  public void run()
  {
    Object localObject1 = this$1.this$0;
    Object localObject2 = this$1.this$0.getResources();
    int i = 2131034245;
    localObject2 = ((Resources)localObject2).getString(i);
    MainActivity.access$200((MainActivity)localObject1, (String)localObject2);
    localObject1 = this$1.this$0.aadhaar_name;
    localObject2 = "";
    ((EditText)localObject1).setText((CharSequence)localObject2);
    localObject1 = this$1.this$0;
    int j = maxTriesforName + 1;
    maxTriesforName = j;
    localObject1 = this$1.this$0;
    int k = maxTriesforName;
    j = 3;
    if (k == j)
    {
      localObject1 = this$1.this$0;
      j = 0;
      maxTriesforName = 0;
      localObject1 = this$1.this$0;
      localObject2 = this$1.this$0.getResources();
      i = 2131034341;
      localObject2 = ((Resources)localObject2).getString(i);
      MainActivity.access$300((MainActivity)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$AsyncTaskRunner$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */