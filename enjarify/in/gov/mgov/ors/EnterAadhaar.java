package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.aadhaar.auth.Verhoeff;

public class EnterAadhaar
  extends Activity
{
  EditText aadhaar;
  ImageView button_home;
  CheckBox consent;
  TextView date;
  TextView department;
  SharedPreferences.Editor editor;
  TextView hostpital_state;
  SharedPreferences pref;
  int sdk;
  Button submit;
  
  private boolean checkaadahar(String paramString)
  {
    return Verhoeff.validateVerhoeff(paramString);
  }
  
  private void initializeViews()
  {
    Object localObject = (ImageView)findViewById(2131296259);
    button_home = ((ImageView)localObject);
    localObject = (TextView)findViewById(2131296260);
    hostpital_state = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296261);
    department = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296262);
    date = ((TextView)localObject);
    localObject = (Button)findViewById(2131296269);
    submit = ((Button)localObject);
    localObject = (CheckBox)findViewById(2131296267);
    consent = ((CheckBox)localObject);
    localObject = (EditText)findViewById(2131296266);
    aadhaar = ((EditText)localObject);
  }
  
  private void showMessage(String paramString)
  {
    Toast localToast = Toast.makeText(getApplicationContext(), paramString, 0);
    localToast.setGravity(17, 0, 0);
    localToast.show();
  }
  
  private void updateView()
  {
    int i = Build.VERSION.SDK_INT;
    sdk = i;
    TextView localTextView = (TextView)findViewById(2131296258);
    Object localObject1 = pref.getString("source", "");
    localTextView.setText((CharSequence)localObject1);
    localObject1 = hostpital_state;
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    Object localObject3 = hostpital_state.getText();
    localObject2 = ((StringBuilder)localObject2).append(localObject3);
    localObject3 = pref.getString("hospital_name", "");
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = department;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = department.getText();
    localObject2 = ((StringBuilder)localObject2).append(localObject3);
    localObject3 = pref.getString("dept_name", "");
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = date;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject2 = ((StringBuilder)localObject2).append("Appointment Date: ");
    localObject3 = pref.getString("date_name", "");
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    EnterAadhaar.1 local1 = new in/gov/mgov/ors/EnterAadhaar$1;
    local1.<init>(this);
    aadhaar.addTextChangedListener(local1);
    localObject1 = submit;
    localObject2 = new in/gov/mgov/ors/EnterAadhaar$2;
    ((EnterAadhaar.2)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = button_home;
    localObject2 = new in/gov/mgov/ors/EnterAadhaar$3;
    ((EnterAadhaar.3)localObject2).<init>(this);
    ((ImageView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
  }
  
  public boolean isConnected()
  {
    Object localObject = getApplicationContext();
    String str = "connectivity";
    ConnectivityManager localConnectivityManager = (ConnectivityManager)((Context)localObject).getSystemService(str);
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
      localObject = getResources();
      int i = 2131034274;
      localObject = ((Resources)localObject).getString(i);
      showMessage((String)localObject);
      bool = false;
      localObject = null;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903052);
    Object localObject = getSharedPreferences("ors", 0);
    pref = ((SharedPreferences)localObject);
    localObject = pref.edit();
    editor = ((SharedPreferences.Editor)localObject);
    initializeViews();
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/EnterAadhaar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */