package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

class AboutActivity$SplashHandler
  extends Handler
{
  private AboutActivity$SplashHandler(AboutActivity paramAboutActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = what;
    switch (i)
    {
    }
    for (;;)
    {
      return;
      Intent localIntent = new android/content/Intent;
      Object localObject = this$0.getApplicationContext();
      Class localClass = ServiceSelection.class;
      localIntent.<init>((Context)localObject, localClass);
      this$0.startActivity(localIntent);
      localObject = this$0;
      ((AboutActivity)localObject).finish();
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/AboutActivity$SplashHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */