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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.ksoap2.serialization.PropertyInfo;

public class MainActivity
  extends Activity
{
  public static final String NAMESPACE = "http://kycWS/";
  public static final String SOAP_ACTION_PREFIX = "http://kycWS/";
  public static final String URL = "http://orf.gov.in/aadhaarekyc/validateKYC?wsdl";
  public static final String URLNIC = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  private String METHOD = "";
  private String NAMESPACE_NIC = "http://orsws/";
  String OTP_RES = "";
  EditText aadhaar;
  EditText aadhaar_name;
  EditText aadhaar_name_number;
  EditText aadhaar_name_otp;
  String appointment_info;
  ImageView button_home;
  String check = "";
  CheckBox consent;
  String date;
  TextView datepref;
  TextView department;
  String departmentcode;
  SharedPreferences.Editor editor;
  String errCode = "";
  String[] finalArray;
  String finalresp = "";
  String hospitalcode;
  TextView hostpital_state;
  LinearLayout ll_name;
  LinearLayout ll_name_number;
  LinearLayout ll_name_otp;
  LinearLayout ll_otp;
  int maxTriesforName = 0;
  int maxTriesforOTP = 0;
  int maxTriesforresendOTP = 0;
  TextView no_aadhhar;
  EditText otp;
  SharedPreferences pref;
  Button proceed;
  Button proceed_name;
  Button proceed_name_number;
  Button proceed_name_otp;
  Button proceed_name_otp_resend;
  Button resend;
  TextView resetmobilenumber;
  TextView showmobilenumber;
  TextView showmobilenumber_demo;
  String shownumber;
  String statecode;
  Button submit;
  TextView text31a;
  boolean vaild = false;
  
  private PropertyInfo addProperties(String paramString1, String paramString2, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    localPropertyInfo.setName(paramString1);
    localPropertyInfo.setValue(paramString2);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  private void intitalizeViews()
  {
    Object localObject = (TextView)findViewById(2131296260);
    hostpital_state = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296261);
    department = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296268);
    showmobilenumber = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296262);
    datepref = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296282);
    showmobilenumber_demo = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296289);
    resetmobilenumber = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296280);
    text31a = ((TextView)localObject);
    localObject = (EditText)findViewById(2131296277);
    aadhaar_name = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296266);
    aadhaar = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296272);
    otp = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296281);
    aadhaar_name_number = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296286);
    aadhaar_name_otp = ((EditText)localObject);
    localObject = (Button)findViewById(2131296269);
    submit = ((Button)localObject);
    localObject = (Button)findViewById(2131296273);
    proceed = ((Button)localObject);
    localObject = (TextView)findViewById(2131296290);
    no_aadhhar = ((TextView)localObject);
    localObject = (Button)findViewById(2131296278);
    proceed_name = ((Button)localObject);
    localObject = (Button)findViewById(2131296274);
    resend = ((Button)localObject);
    localObject = (Button)findViewById(2131296283);
    proceed_name_number = ((Button)localObject);
    localObject = (Button)findViewById(2131296287);
    proceed_name_otp = ((Button)localObject);
    localObject = (Button)findViewById(2131296288);
    proceed_name_otp_resend = ((Button)localObject);
    localObject = (CheckBox)findViewById(2131296267);
    consent = ((CheckBox)localObject);
    localObject = (LinearLayout)findViewById(2131296270);
    ll_otp = ((LinearLayout)localObject);
    localObject = (LinearLayout)findViewById(2131296275);
    ll_name = ((LinearLayout)localObject);
    localObject = (LinearLayout)findViewById(2131296279);
    ll_name_number = ((LinearLayout)localObject);
    localObject = (LinearLayout)findViewById(2131296284);
    ll_name_otp = ((LinearLayout)localObject);
    localObject = (ImageView)findViewById(2131296259);
    button_home = ((ImageView)localObject);
    localObject = button_home;
    MainActivity.11 local11 = new in/gov/mgov/ors/MainActivity$11;
    local11.<init>(this);
    ((ImageView)localObject).setOnClickListener(local11);
  }
  
  private void showDialogonclickExtra(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    localBuilder.<init>(this);
    Object localObject = getResources().getString(2131034183);
    localBuilder.setTitle((CharSequence)localObject);
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    String str = getResources().getString(2131034259);
    MainActivity.12 local12 = new in/gov/mgov/ors/MainActivity$12;
    local12.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local12);
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
    localObject1 = showmobilenumber.getText().toString();
    shownumber = ((String)localObject1);
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
    localObject1 = aadhaar;
    localObject2 = pref.getString("aadhaar_no", "");
    ((EditText)localObject1).setText((CharSequence)localObject2);
    localObject1 = datepref;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject2 = ((StringBuilder)localObject2).append("Appointment Date: ");
    localObject3 = pref;
    String str1 = "date_name";
    String str2 = "";
    localObject3 = ((SharedPreferences)localObject3).getString(str1, str2);
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = no_aadhhar;
    int i = 8;
    ((TextView)localObject1).setVisibility(i);
    boolean bool = isConnected();
    if (bool)
    {
      METHOD = "createOtpDetails";
      MainActivity.AsyncTaskRunner localAsyncTaskRunner = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner;
      localAsyncTaskRunner.<init>(this, null);
      bool = true;
      localObject1 = new String[bool];
      i = 0;
      localObject2 = null;
      localObject3 = "aadhaar";
      localObject1[0] = localObject3;
      localAsyncTaskRunner.execute((Object[])localObject1);
    }
    localObject1 = submit;
    localObject2 = new in/gov/mgov/ors/MainActivity$1;
    ((MainActivity.1)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = proceed;
    localObject2 = new in/gov/mgov/ors/MainActivity$2;
    ((MainActivity.2)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = no_aadhhar;
    localObject2 = new in/gov/mgov/ors/MainActivity$3;
    ((MainActivity.3)localObject2).<init>(this);
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = proceed_name;
    localObject2 = new in/gov/mgov/ors/MainActivity$4;
    ((MainActivity.4)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = resend;
    localObject2 = new in/gov/mgov/ors/MainActivity$5;
    ((MainActivity.5)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = proceed_name_number;
    localObject2 = new in/gov/mgov/ors/MainActivity$6;
    ((MainActivity.6)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = proceed_name_otp;
    localObject2 = new in/gov/mgov/ors/MainActivity$7;
    ((MainActivity.7)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = resetmobilenumber;
    localObject2 = new in/gov/mgov/ors/MainActivity$8;
    ((MainActivity.8)localObject2).<init>(this);
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = proceed_name_otp_resend;
    localObject2 = new in/gov/mgov/ors/MainActivity$9;
    ((MainActivity.9)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    MainActivity.10 local10 = new in/gov/mgov/ors/MainActivity$10;
    local10.<init>(this);
    aadhaar_name_otp.addTextChangedListener(local10);
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
    setContentView(2130903041);
    Object localObject = getSharedPreferences("ors", 0);
    pref = ((SharedPreferences)localObject);
    localObject = pref.edit();
    editor = ((SharedPreferences.Editor)localObject);
    intitalizeViews();
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */