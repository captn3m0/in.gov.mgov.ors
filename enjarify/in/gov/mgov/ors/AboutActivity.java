package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.view.Window;
import android.widget.RelativeLayout;

public class AboutActivity
  extends Activity
{
  private static final long SPLASHTIME = 4000L;
  private static final int STOPSPLASH;
  RelativeLayout Al;
  protected int _splashTime = 4000;
  
  public void finish()
  {
    System.exit(0);
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903040);
    AboutActivity.SplashHandler localSplashHandler = new in/gov/mgov/ors/AboutActivity$SplashHandler;
    localSplashHandler.<init>(this, null);
    Message localMessage = new android/os/Message;
    localMessage.<init>();
    what = 0;
    localSplashHandler.sendMessageDelayed(localMessage, 4000L);
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131296256);
    Al = localRelativeLayout;
    localRelativeLayout = Al;
    AboutActivity.1 local1 = new in/gov/mgov/ors/AboutActivity$1;
    local1.<init>(this);
    localRelativeLayout.setOnClickListener(local1);
  }
  
  protected void onPause()
  {
    super.onPause();
    super.finish();
    Process.killProcess(Process.myPid());
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/AboutActivity.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */