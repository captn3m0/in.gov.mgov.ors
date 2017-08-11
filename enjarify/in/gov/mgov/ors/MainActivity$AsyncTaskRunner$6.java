package in.gov.mgov.ors;

import android.content.res.Resources;

class MainActivity$AsyncTaskRunner$6
  implements Runnable
{
  MainActivity$AsyncTaskRunner$6(MainActivity.AsyncTaskRunner paramAsyncTaskRunner, String[] paramArrayOfString) {}
  
  public void run()
  {
    Object localObject1 = val$params[0];
    Object localObject2 = "otp";
    boolean bool = ((String)localObject1).equals(localObject2);
    if (bool)
    {
      localObject1 = this$1.this$0;
      localObject2 = this$1.this$0.getResources();
      int i = 2131034339;
      localObject2 = ((Resources)localObject2).getString(i);
      MainActivity.access$200((MainActivity)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$AsyncTaskRunner$6.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */