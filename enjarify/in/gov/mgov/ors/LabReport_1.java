package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import org.ksoap2.serialization.PropertyInfo;

public class LabReport_1
  extends Activity
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/labservices?wsdl";
  private String METHOD = "";
  String OTP = "";
  String[] Res_Collecteddate;
  String[] Res_daily_sampleno_str;
  String[] Res_report_id;
  String[] Res_report_year;
  String[] Res_sample_no;
  String[] Res_sample_type_desc;
  String[] Res_sample_year;
  String[] Res_test_name;
  TextView button_no_reg_mobileno;
  Button button_submit;
  String dob;
  EditText edittext_uhid;
  String fathers_name;
  String guardian_rel;
  String[] hospital;
  String hospitalcode;
  String[] hospitalid;
  String hospitalname;
  int maxTriesforOTP = 0;
  String p_address;
  String p_fname;
  String p_initial;
  String p_lname;
  String p_mname;
  String p_mobile_no;
  String p_sex;
  Spinner spinner_select_hospital;
  
  private PropertyInfo addProperties(String paramString, int paramInt, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    localPropertyInfo.setName(paramString);
    Integer localInteger = Integer.valueOf(paramInt);
    localPropertyInfo.setValue(localInteger);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
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
    Object localObject = (Spinner)findViewById(2131296406);
    spinner_select_hospital = ((Spinner)localObject);
    localObject = (EditText)findViewById(2131296407);
    edittext_uhid = ((EditText)localObject);
    localObject = (Button)findViewById(2131296269);
    button_submit = ((Button)localObject);
    localObject = (TextView)findViewById(2131296411);
    button_no_reg_mobileno = ((TextView)localObject);
  }
  
  private void showDialogonclickExtra(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    localBuilder.<init>(this);
    Object localObject = getResources().getString(2131034183);
    localBuilder.setTitle((CharSequence)localObject);
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    String str = getResources().getString(2131034259);
    LabReport_1.5 local5 = new in/gov/mgov/ors/LabReport_1$5;
    local5.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local5);
    localBuilder.create().show();
  }
  
  private void showMessage(String paramString)
  {
    Toast localToast = Toast.makeText(getApplicationContext(), paramString, 0);
    localToast.setGravity(17, 0, 0);
    localToast.show();
  }
  
  private void showMessageLong(String paramString)
  {
    Toast localToast = Toast.makeText(getApplicationContext(), paramString, 1);
    localToast.setGravity(17, 0, 0);
    localToast.show();
  }
  
  private void updateView()
  {
    Button localButton = (Button)findViewById(2131296410);
    Object localObject1 = new in/gov/mgov/ors/LabReport_1$1;
    ((LabReport_1.1)localObject1).<init>(this);
    localButton.setOnClickListener((View.OnClickListener)localObject1);
    boolean bool = isConnected();
    if (bool)
    {
      localObject1 = new in/gov/mgov/ors/LabReport_1$CallList;
      ((LabReport_1.CallList)localObject1).<init>(this, null);
      int i = 1;
      localObject2 = new String[i];
      String str = "getHospitalList";
      localObject2[0] = str;
      ((LabReport_1.CallList)localObject1).execute((Object[])localObject2);
    }
    ImageView localImageView = (ImageView)findViewById(2131296259);
    localObject1 = new in/gov/mgov/ors/LabReport_1$2;
    ((LabReport_1.2)localObject1).<init>(this);
    localImageView.setOnClickListener((View.OnClickListener)localObject1);
    localObject1 = button_submit;
    Object localObject2 = new in/gov/mgov/ors/LabReport_1$3;
    ((LabReport_1.3)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = button_no_reg_mobileno;
    localObject2 = new in/gov/mgov/ors/LabReport_1$4;
    ((LabReport_1.4)localObject2).<init>(this);
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
    setContentView(2130903053);
    intializeViews();
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */