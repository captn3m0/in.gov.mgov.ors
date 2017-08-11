package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CancelAppointment3
  extends Activity
  implements View.OnClickListener
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  private String METHOD = "";
  String OTP = "";
  Button btn_backtoappointmnet;
  Button btn_cancel;
  ImageView button_home;
  TextView dr;
  String hospitalcode;
  ImageView img_id;
  int maxTriesforOTP = 0;
  String resAadhaar;
  String resAppdates;
  String resAppointment_id;
  String resApptime;
  String resDOB;
  String resDept;
  String resDoctor;
  String resEmail;
  String resGender;
  String resHospitals;
  String resMobileNo;
  String resP_address;
  String resPatientname;
  String resRequestDate;
  String resRoom_name;
  String resStatus;
  String resfathers_name;
  String reshid;
  TextView txt_aadhaar;
  TextView txt_age;
  TextView txt_appdate;
  TextView txt_appid;
  TextView txt_dept;
  TextView txt_grnder;
  TextView txt_hospital;
  TextView txt_mobileno;
  TextView txt_name;
  TextView txt_room_no;
  TextView txt_uhid;
  
  private void intializeView()
  {
    Object localObject = (ImageView)findViewById(2131296259);
    button_home = ((ImageView)localObject);
    localObject = (TextView)findViewById(2131296361);
    txt_aadhaar = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296362);
    txt_name = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296363);
    txt_age = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296364);
    txt_grnder = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296365);
    txt_mobileno = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296366);
    txt_hospital = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296368);
    txt_dept = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296370);
    txt_appid = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296372);
    txt_appdate = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296374);
    txt_uhid = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296378);
    dr = ((TextView)localObject);
    localObject = (Button)findViewById(2131296340);
    btn_cancel = ((Button)localObject);
    localObject = (TextView)findViewById(2131296376);
    txt_room_no = ((TextView)localObject);
    localObject = (Button)findViewById(2131296379);
    btn_backtoappointmnet = ((Button)localObject);
    localObject = (ImageView)findViewById(2131296302);
    img_id = ((ImageView)localObject);
  }
  
  private void showDialogonclickExtra(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    localBuilder.<init>(this);
    Object localObject = getResources().getString(2131034183);
    localBuilder.setTitle((CharSequence)localObject);
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    String str = getResources().getString(2131034259);
    CancelAppointment3.6 local6 = new in/gov/mgov/ors/CancelAppointment3$6;
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
    int i = 8;
    boolean bool = isConnected();
    if (bool)
    {
      localObject1 = new in/gov/mgov/ors/CancelAppointment3$CallList;
      ((CancelAppointment3.CallList)localObject1).<init>(this, null);
      int j = 1;
      localObject2 = new String[j];
      str1 = null;
      String str2 = "getAadhaarIamge";
      localObject2[0] = str2;
      ((CancelAppointment3.CallList)localObject1).execute((Object[])localObject2);
    }
    img_id.setVisibility(i);
    Object localObject1 = txt_name;
    Object localObject2 = resPatientname;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = txt_age;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    String str1 = resDOB;
    localObject2 = str1 + " years";
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = txt_grnder;
    localObject2 = resGender;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = txt_mobileno;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    str1 = getResources().getString(2131034234);
    localObject2 = ((StringBuilder)localObject2).append(str1).append(": XXXXXX");
    str1 = resMobileNo;
    int k = resMobileNo.length() + -4;
    int m = resMobileNo.length();
    str1 = str1.substring(k, m);
    localObject2 = str1;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = txt_hospital;
    localObject2 = resHospitals;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = txt_dept;
    localObject2 = resDept;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = txt_appdate;
    localObject2 = resAppdates;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = txt_appid;
    localObject2 = resAppointment_id;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = txt_aadhaar;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    str1 = getResources().getString(2131034114);
    localObject2 = ((StringBuilder)localObject2).append(str1).append(": ");
    str1 = resAadhaar;
    localObject2 = str1;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = txt_uhid;
    localObject2 = reshid;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = dr;
    localObject2 = resDoctor;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    dr.setVisibility(i);
    localObject1 = txt_room_no;
    localObject2 = resRoom_name;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    txt_room_no.setVisibility(i);
    localObject1 = btn_cancel;
    localObject2 = new in/gov/mgov/ors/CancelAppointment3$1;
    ((CancelAppointment3.1)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = btn_backtoappointmnet;
    localObject2 = new in/gov/mgov/ors/CancelAppointment3$2;
    ((CancelAppointment3.2)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = button_home;
    localObject2 = new in/gov/mgov/ors/CancelAppointment3$3;
    ((CancelAppointment3.3)localObject2).<init>(this);
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
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = btn_cancel;
    Object localObject2;
    if (paramView == localObject1)
    {
      localObject1 = new android/app/AlertDialog$Builder;
      ((AlertDialog.Builder)localObject1).<init>(this);
      localObject2 = getResources().getString(2131034157);
      localObject1 = ((AlertDialog.Builder)localObject1).setTitle((CharSequence)localObject2);
      localObject2 = getResources().getString(2131034138);
      localObject1 = ((AlertDialog.Builder)localObject1).setMessage((CharSequence)localObject2);
      localObject2 = getResources().getString(2131034259);
      Object localObject3 = new in/gov/mgov/ors/CancelAppointment3$5;
      ((CancelAppointment3.5)localObject3).<init>(this);
      localObject1 = ((AlertDialog.Builder)localObject1).setPositiveButton((CharSequence)localObject2, (DialogInterface.OnClickListener)localObject3);
      localObject2 = getResources();
      int i = 2131034156;
      localObject2 = ((Resources)localObject2).getString(i);
      localObject3 = new in/gov/mgov/ors/CancelAppointment3$4;
      ((CancelAppointment3.4)localObject3).<init>(this);
      localObject1 = ((AlertDialog.Builder)localObject1).setNegativeButton((CharSequence)localObject2, (DialogInterface.OnClickListener)localObject3);
      int j = 17301543;
      localObject1 = ((AlertDialog.Builder)localObject1).setIcon(j);
      ((AlertDialog.Builder)localObject1).show();
    }
    localObject1 = btn_backtoappointmnet;
    if (paramView == localObject1)
    {
      Intent localIntent = new android/content/Intent;
      localObject1 = getApplicationContext();
      localObject2 = CancelAppointment2.class;
      localIntent.<init>((Context)localObject1, (Class)localObject2);
      startActivity(localIntent);
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903048);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("hospitals");
    resHospitals = str;
    str = localIntent.getStringExtra("depts");
    resDept = str;
    str = localIntent.getStringExtra("appdates");
    resAppdates = str;
    str = localIntent.getStringExtra("status");
    resStatus = str;
    str = localIntent.getStringExtra("patient_name");
    resPatientname = str;
    str = localIntent.getStringExtra("fathers_name");
    resfathers_name = str;
    str = localIntent.getStringExtra("email");
    resEmail = str;
    str = localIntent.getStringExtra("room_name");
    resRoom_name = str;
    str = localIntent.getStringExtra("dob");
    resDOB = str;
    str = localIntent.getStringExtra("gender");
    resGender = str;
    str = localIntent.getStringExtra("p_address");
    resP_address = str;
    str = localIntent.getStringExtra("appointment_id");
    resAppointment_id = str;
    str = localIntent.getStringExtra("mobile_no");
    resMobileNo = str;
    str = localIntent.getStringExtra("hosid");
    hospitalcode = str;
    str = localIntent.getStringExtra("doctor");
    resDoctor = str;
    str = localIntent.getStringExtra("aadhaar");
    resAadhaar = str;
    str = localIntent.getStringExtra("hid");
    reshid = str;
    str = localIntent.getStringExtra("requestdate");
    resRequestDate = str;
    str = localIntent.getStringExtra("apptime");
    resApptime = str;
    str = localIntent.getStringExtra("hosid");
    hospitalcode = str;
    intializeView();
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */