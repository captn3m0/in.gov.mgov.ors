package in.gov.mgov.ors;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;

public class AboutActivity
  extends Activity
{
  private static final long SPLASHTIME = 4000L;
  private static final int STOPSPLASH = 0;
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
    paramBundle = new SplashHandler(null);
    Message localMessage = new Message();
    what = 0;
    paramBundle.sendMessageDelayed(localMessage, 4000L);
    Al = ((RelativeLayout)findViewById(2131296256));
    Al.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), ServiceSelection.class);
        startActivity(paramAnonymousView);
      }
    });
  }
  
  protected void onPause()
  {
    super.onPause();
    super.finish();
    Process.killProcess(Process.myPid());
  }
  
  @SuppressLint({"HandlerLeak"})
  private class SplashHandler
    extends Handler
  {
    private SplashHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (what)
      {
      default: 
        return;
      }
      paramMessage = new Intent(getApplicationContext(), ServiceSelection.class);
      startActivity(paramMessage);
      finish();
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/AboutActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */