package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.ksoap2.serialization.PropertyInfo;

public class AuthenticateNonAadhaar
  extends Activity
{
  private static final String NAMESPACE_NIC = "http://orsws/";
  private static final String URLNIC = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  private String METHOD = "";
  String OTP_RES;
  SharedPreferences.Editor editor;
  String finalresp;
  Button getotp;
  LinearLayout ll_otp;
  int maxtriesforresendotp = 0;
  EditText number;
  EditText otp;
  SharedPreferences pref;
  Button resendotp;
  TextView resetnumber;
  TextView showNumber;
  Button submit;
  
  private PropertyInfo addProperties(String paramString1, String paramString2, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    localPropertyInfo.setName(paramString1);
    localPropertyInfo.setValue(paramString2);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  private void intializeViews()
  {
    Object localObject = (EditText)findViewById(2131296281);
    number = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296286);
    otp = ((EditText)localObject);
    localObject = (Button)findViewById(2131296283);
    getotp = ((Button)localObject);
    localObject = (Button)findViewById(2131296287);
    submit = ((Button)localObject);
    localObject = (Button)findViewById(2131296288);
    resendotp = ((Button)localObject);
    localObject = (LinearLayout)findViewById(2131296284);
    ll_otp = ((LinearLayout)localObject);
    localObject = (TextView)findViewById(2131296289);
    resetnumber = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296268);
    showNumber = ((TextView)localObject);
  }
  
  private void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    localBuilder.<init>(this);
    Object localObject = getResources().getString(2131034183);
    localBuilder.setTitle((CharSequence)localObject);
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    String str = getResources().getString(2131034259);
    AuthenticateNonAadhaar.5 local5 = new in/gov/mgov/ors/AuthenticateNonAadhaar$5;
    local5.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local5);
    localBuilder.create().show();
  }
  
  private void showDialogonclickExtra(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    localBuilder.<init>(this);
    Object localObject = getResources().getString(2131034183);
    localBuilder.setTitle((CharSequence)localObject);
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    String str = getResources().getString(2131034259);
    AuthenticateNonAadhaar.6 local6 = new in/gov/mgov/ors/AuthenticateNonAadhaar$6;
    local6.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local6);
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
    TextView localTextView = (TextView)findViewById(2131296258);
    Object localObject1 = pref.getString("source", "");
    localTextView.setText((CharSequence)localObject1);
    localObject1 = getotp;
    Object localObject2 = new in/gov/mgov/ors/AuthenticateNonAadhaar$1;
    ((AuthenticateNonAadhaar.1)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = submit;
    localObject2 = new in/gov/mgov/ors/AuthenticateNonAadhaar$2;
    ((AuthenticateNonAadhaar.2)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = resendotp;
    localObject2 = new in/gov/mgov/ors/AuthenticateNonAadhaar$3;
    ((AuthenticateNonAadhaar.3)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = resetnumber;
    localObject2 = new in/gov/mgov/ors/AuthenticateNonAadhaar$4;
    ((AuthenticateNonAadhaar.4)localObject2).<init>(this);
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
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
    setContentView(2130903042);
    Object localObject = getSharedPreferences("ors", 0);
    pref = ((SharedPreferences)localObject);
    localObject = pref.edit();
    editor = ((SharedPreferences.Editor)localObject);
    intializeViews();
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/AuthenticateNonAadhaar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */