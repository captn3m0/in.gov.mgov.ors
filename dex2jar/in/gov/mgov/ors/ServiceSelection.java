package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.Locale;

public class ServiceSelection
  extends Activity
{
  Button appointment;
  Button appointment_without;
  String appversion;
  Button blood;
  LinearLayout bloodrep;
  LinearLayout checkAppointment;
  SharedPreferences.Editor editor;
  ImageView i;
  Button lab;
  LinearLayout labrep;
  Button language;
  SharedPreferences pref;
  
  private void intializeViews()
  {
    appointment = ((Button)findViewById(2131296437));
    lab = ((Button)findViewById(2131296442));
    blood = ((Button)findViewById(2131296443));
    i = ((ImageView)findViewById(2131296446));
    checkAppointment = ((LinearLayout)findViewById(2131296440));
    appointment_without = ((Button)findViewById(2131296438));
    bloodrep = ((LinearLayout)findViewById(2131296439));
    labrep = ((LinearLayout)findViewById(2131296441));
  }
  
  private void restartActivity()
  {
    Intent localIntent = getIntent();
    finish();
    startActivity(localIntent);
  }
  
  private void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getResources().getString(2131034183));
    localBuilder.setMessage(paramString).setCancelable(false).setPositiveButton(getResources().getString(2131034259), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    localBuilder.create().show();
  }
  
  private void showMessage(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 1);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  private void updateView()
  {
    language = ((Button)findViewById(2131296445));
    language.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!language.getText().toString().equalsIgnoreCase("english"))
        {
          paramAnonymousView = new Locale("hi");
          Locale.setDefault(paramAnonymousView);
          localConfiguration = new Configuration();
          locale = paramAnonymousView;
          getBaseContext().getResources().updateConfiguration(localConfiguration, getBaseContext().getResources().getDisplayMetrics());
          editor.putString("lang", "HI").commit();
          ServiceSelection.this.restartActivity();
          return;
        }
        paramAnonymousView = new Locale("en");
        Locale.setDefault(paramAnonymousView);
        Configuration localConfiguration = new Configuration();
        locale = paramAnonymousView;
        getBaseContext().getResources().updateConfiguration(localConfiguration, getBaseContext().getResources().getDisplayMetrics());
        editor.putString("lang", "EN").commit();
        ServiceSelection.this.restartActivity();
      }
    });
    appointment.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        editor.putString("source", getResources().getString(2131034149)).commit();
        paramAnonymousView = new Intent(getApplicationContext(), BookAppointment.class);
        startActivity(paramAnonymousView);
      }
    });
    lab.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ServiceSelection.this.showMessage(getResources().getString(2131034310));
      }
    });
    blood.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ServiceSelection.this.showMessage(getResources().getString(2131034310));
      }
    });
    i.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new AlertDialog.Builder(ServiceSelection.this);
        paramAnonymousView.setTitle(getResources().getString(2131034120) + ": " + appversion);
        paramAnonymousView.setMessage(getResources().getString(2131034121)).setCancelable(false).setPositiveButton(getResources().getString(2131034259), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.cancel();
          }
        });
        paramAnonymousView.create().show();
      }
    });
    checkAppointment.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), CancelAppointment_1.class);
        startActivity(paramAnonymousView);
      }
    });
    appointment_without.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        editor.putString("source", getResources().getString(2131034150)).commit();
        paramAnonymousView = new Intent(getApplicationContext(), BookAppointmentWithout.class);
        startActivity(paramAnonymousView);
      }
    });
    bloodrep.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), BloodAvailability1.class);
        startActivity(paramAnonymousView);
      }
    });
    labrep.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), LabReport_1.class);
        startActivity(paramAnonymousView);
      }
    });
  }
  
  public boolean isConnected()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903063);
    paramBundle = getApplicationContext();
    PackageManager localPackageManager = paramBundle.getPackageManager();
    pref = getSharedPreferences("ors", 0);
    editor = pref.edit();
    editor.putString("aadhaar_no", "").commit();
    try
    {
      appversion = getPackageInfogetPackageName0versionName;
      intializeViews();
      updateView();
      return;
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/ServiceSelection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */