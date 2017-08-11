package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.ksoap2.serialization.PropertyInfo;

public class LabReport_2
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
  Button button_view_lab_reports;
  String dob;
  String fathers_name;
  String guardian_rel;
  String hospital;
  String hospitalcode;
  ImageView imageview_photo_id;
  int maxTriesforOTP = 0;
  String p_address;
  String p_fname;
  String p_initial;
  String p_lname;
  String p_mname;
  String p_mobile_no;
  String p_sex;
  TextView textview__age_data;
  TextView textview_address_data;
  TextView textview_gender_data;
  TextView textview_mobile_data;
  TextView textview_name_data;
  TextView textview_tital_info;
  TextView textview_uhid_data;
  String uhid;
  
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
    Object localObject = (ImageView)findViewById(2131296413);
    imageview_photo_id = ((ImageView)localObject);
    localObject = (TextView)findViewById(2131296414);
    textview_uhid_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296362);
    textview_name_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296363);
    textview__age_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296364);
    textview_gender_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296365);
    textview_mobile_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296415);
    textview_address_data = ((TextView)localObject);
    localObject = (Button)findViewById(2131296416);
    button_view_lab_reports = ((Button)localObject);
    localObject = (TextView)findViewById(2131296412);
    textview_tital_info = ((TextView)localObject);
  }
  
  private void showDialogonclickExtra(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    localBuilder.<init>(this);
    Object localObject = getResources().getString(2131034183);
    localBuilder.setTitle((CharSequence)localObject);
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    String str = getResources().getString(2131034259);
    LabReport_2.4 local4 = new in/gov/mgov/ors/LabReport_2$4;
    local4.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local4);
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
    Button localButton = (Button)findViewById(2131296410);
    Object localObject1 = new in/gov/mgov/ors/LabReport_2$1;
    ((LabReport_2.1)localObject1).<init>(this);
    localButton.setOnClickListener((View.OnClickListener)localObject1);
    ImageView localImageView = (ImageView)findViewById(2131296259);
    localObject1 = new in/gov/mgov/ors/LabReport_2$2;
    ((LabReport_2.2)localObject1).<init>(this);
    localImageView.setOnClickListener((View.OnClickListener)localObject1);
    localObject1 = textview_tital_info;
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    String str1 = getResources().getString(2131034268);
    localObject2 = ((StringBuilder)localObject2).append(str1).append(" ");
    str1 = hospital;
    localObject2 = str1;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    imageview_photo_id.setVisibility(8);
    localObject1 = textview_uhid_data;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    str1 = getResources().getString(2131034329);
    localObject2 = ((StringBuilder)localObject2).append(str1).append(" ");
    str1 = uhid;
    localObject2 = str1;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_name_data;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    str1 = getResources().getString(2131034243);
    localObject2 = ((StringBuilder)localObject2).append(str1).append(" ");
    str1 = p_initial;
    localObject2 = ((StringBuilder)localObject2).append(str1).append(" ");
    str1 = p_fname;
    localObject2 = ((StringBuilder)localObject2).append(str1).append(" ");
    str1 = p_lname;
    localObject2 = str1;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = new java/text/SimpleDateFormat;
    ((SimpleDateFormat)localObject1).<init>("yyyy");
    localObject2 = new java/util/Date;
    ((Date)localObject2).<init>();
    String str2 = ((SimpleDateFormat)localObject1).format((Date)localObject2);
    localObject1 = dob;
    int i = dob.length() + -4;
    int j = dob.length();
    int k = Integer.valueOf(((String)localObject1).substring(i, j)).intValue();
    int m = Integer.valueOf(str2).intValue() - k;
    localObject1 = textview__age_data;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    str1 = getResources().getString(2131034127);
    localObject2 = ((StringBuilder)localObject2).append(str1).append(" ").append(m).append(" ");
    str1 = getResources().getString(2131034340);
    localObject2 = ((StringBuilder)localObject2).append(str1).append("  ");
    str1 = p_sex;
    localObject2 = str1;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_gender_data;
    localObject2 = p_sex;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_address_data;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    str1 = getResources().getString(2131034122);
    localObject2 = ((StringBuilder)localObject2).append(str1).append(": ");
    str1 = p_address;
    localObject2 = str1;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_mobile_data;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    str1 = getResources().getString(2131034230);
    localObject2 = ((StringBuilder)localObject2).append(str1).append(": XXXXXX");
    str1 = p_mobile_no;
    int n = p_mobile_no.length() + -4;
    int i1 = p_mobile_no.length();
    str1 = str1.substring(n, i1);
    localObject2 = str1;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = button_view_lab_reports;
    localObject2 = new in/gov/mgov/ors/LabReport_2$3;
    ((LabReport_2.3)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
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
    setContentView(2130903054);
    Intent localIntent = getIntent();
    Object localObject = localIntent.getStringExtra("p_mname");
    p_mname = ((String)localObject);
    localObject = localIntent.getStringExtra("fathers_name");
    fathers_name = ((String)localObject);
    localObject = localIntent.getStringExtra("guardian_rel");
    guardian_rel = ((String)localObject);
    localObject = localIntent.getStringExtra("p_sex");
    p_sex = ((String)localObject);
    localObject = localIntent.getStringExtra("p_lname");
    p_lname = ((String)localObject);
    localObject = localIntent.getStringExtra("p_fname");
    p_fname = ((String)localObject);
    localObject = localIntent.getStringExtra("p_address");
    p_address = ((String)localObject);
    localObject = localIntent.getStringExtra("p_mobile_no");
    p_mobile_no = ((String)localObject);
    localObject = localIntent.getStringExtra("p_initial");
    p_initial = ((String)localObject);
    localObject = localIntent.getStringExtra("dob");
    dob = ((String)localObject);
    localObject = localIntent.getStringExtra("uhid");
    uhid = ((String)localObject);
    localObject = localIntent.getStringExtra("hospital");
    hospital = ((String)localObject);
    localObject = localIntent.getStringExtra("hosid");
    hospitalcode = ((String)localObject);
    localObject = localIntent.getStringExtra("OTP");
    OTP = ((String)localObject);
    localObject = localIntent.getStringArrayExtra("Res_sample_type_desc");
    Res_sample_type_desc = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_sample_year");
    Res_sample_year = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_report_year");
    Res_report_year = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_sample_no");
    Res_sample_no = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_daily_sampleno_str");
    Res_daily_sampleno_str = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_test_name");
    Res_test_name = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_report_id");
    Res_report_id = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_Collecteddate");
    Res_Collecteddate = ((String[])localObject);
    intializeViews();
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */