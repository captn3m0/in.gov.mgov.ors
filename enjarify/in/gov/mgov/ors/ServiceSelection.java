package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

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
    Object localObject = (Button)findViewById(2131296437);
    appointment = ((Button)localObject);
    localObject = (Button)findViewById(2131296442);
    lab = ((Button)localObject);
    localObject = (Button)findViewById(2131296443);
    blood = ((Button)localObject);
    localObject = (ImageView)findViewById(2131296446);
    i = ((ImageView)localObject);
    localObject = (LinearLayout)findViewById(2131296440);
    checkAppointment = ((LinearLayout)localObject);
    localObject = (Button)findViewById(2131296438);
    appointment_without = ((Button)localObject);
    localObject = (LinearLayout)findViewById(2131296439);
    bloodrep = ((LinearLayout)localObject);
    localObject = (LinearLayout)findViewById(2131296441);
    labrep = ((LinearLayout)localObject);
  }
  
  private void restartActivity()
  {
    Intent localIntent = getIntent();
    finish();
    startActivity(localIntent);
  }
  
  private void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    localBuilder.<init>(this);
    Object localObject = getResources().getString(2131034183);
    localBuilder.setTitle((CharSequence)localObject);
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    String str = getResources().getString(2131034259);
    ServiceSelection.10 local10 = new in/gov/mgov/ors/ServiceSelection$10;
    local10.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local10);
    localBuilder.create().show();
  }
  
  private void showMessage(String paramString)
  {
    Toast localToast = Toast.makeText(getApplicationContext(), paramString, 1);
    localToast.setGravity(17, 0, 0);
    localToast.show();
  }
  
  private void updateView()
  {
    Object localObject1 = (Button)findViewById(2131296445);
    language = ((Button)localObject1);
    localObject1 = language;
    Object localObject2 = new in/gov/mgov/ors/ServiceSelection$1;
    ((ServiceSelection.1)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = appointment;
    localObject2 = new in/gov/mgov/ors/ServiceSelection$2;
    ((ServiceSelection.2)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = lab;
    localObject2 = new in/gov/mgov/ors/ServiceSelection$3;
    ((ServiceSelection.3)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = blood;
    localObject2 = new in/gov/mgov/ors/ServiceSelection$4;
    ((ServiceSelection.4)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = i;
    localObject2 = new in/gov/mgov/ors/ServiceSelection$5;
    ((ServiceSelection.5)localObject2).<init>(this);
    ((ImageView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = checkAppointment;
    localObject2 = new in/gov/mgov/ors/ServiceSelection$6;
    ((ServiceSelection.6)localObject2).<init>(this);
    ((LinearLayout)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = appointment_without;
    localObject2 = new in/gov/mgov/ors/ServiceSelection$7;
    ((ServiceSelection.7)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = bloodrep;
    localObject2 = new in/gov/mgov/ors/ServiceSelection$8;
    ((ServiceSelection.8)localObject2).<init>(this);
    ((LinearLayout)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = labrep;
    localObject2 = new in/gov/mgov/ors/ServiceSelection$9;
    ((ServiceSelection.9)localObject2).<init>(this);
    ((LinearLayout)localObject1).setOnClickListener((View.OnClickListener)localObject2);
  }
  
  public boolean isConnected()
  {
    Context localContext = getApplicationContext();
    String str = "connectivity";
    ConnectivityManager localConnectivityManager = (ConnectivityManager)localContext.getSystemService(str);
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    boolean bool;
    if (localNetworkInfo != null)
    {
      bool = localNetworkInfo.isConnected();
      if (bool) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      localContext = null;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getWindow();
    int j = 8;
    ((Window)localObject).requestFeature(j);
    getActionBar().hide();
    int k = 2130903063;
    setContentView(k);
    Context localContext = getApplicationContext();
    PackageManager localPackageManager = localContext.getPackageManager();
    localObject = getSharedPreferences("ors", 0);
    pref = ((SharedPreferences)localObject);
    localObject = pref.edit();
    editor = ((SharedPreferences.Editor)localObject);
    localObject = editor;
    String str1 = "aadhaar_no";
    String str2 = "";
    localObject = ((SharedPreferences.Editor)localObject).putString(str1, str2);
    ((SharedPreferences.Editor)localObject).commit();
    try
    {
      localObject = localContext.getPackageName();
      j = 0;
      str1 = null;
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo((String)localObject, 0);
      localObject = versionName;
      appversion = ((String)localObject);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    intializeViews();
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ServiceSelection.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */