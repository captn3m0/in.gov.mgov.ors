package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;

public class ShowAppointmentNoNumber
  extends Activity
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  private String METHOD = "";
  TextView UHID;
  TextView aadhaar;
  String aadhaarno;
  TextView address;
  String appdate;
  TextView appointment_detail;
  TextView appointmentid;
  ImageView button_home;
  TextView date;
  TextView department;
  int departmentcode;
  TextView dob;
  SharedPreferences.Editor editor;
  String finalresp;
  TextView gender;
  int hospitalcode;
  TextView hostpital_state;
  ImageView image;
  TextView mno;
  TextView name;
  TextView no;
  Button payment;
  SharedPreferences pref;
  int statecode;
  String[] uidData;
  Button yes;
  
  private boolean PayNow(String paramString)
  {
    String str1 = "\\|";
    String[] arrayOfString1 = paramString.split(str1);
    int i = 0;
    int j = arrayOfString1.length;
    int k;
    label43:
    boolean bool;
    if (i < j)
    {
      str1 = arrayOfString1[i];
      Object localObject = "\\^";
      String[] arrayOfString2 = str1.split((String)localObject);
      k = 0;
      j = arrayOfString2.length;
      if (k < j)
      {
        str1 = arrayOfString2[k];
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        int m = hospitalcode;
        localObject = ((StringBuilder)localObject).append(m);
        String str2 = "";
        localObject = str2;
        bool = str1.equals(localObject);
        if (bool) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      return bool;
      k += 1;
      break label43;
      i += 1;
      break;
      bool = false;
      str1 = null;
    }
  }
  
  private void intitalizeViews()
  {
    Object localObject = (TextView)findViewById(2131296449);
    name = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296450);
    dob = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296451);
    gender = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296452);
    mno = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296455);
    address = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296260);
    hostpital_state = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296261);
    department = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296448);
    aadhaar = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296262);
    date = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296453);
    appointmentid = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296457);
    appointment_detail = ((TextView)localObject);
    localObject = (ImageView)findViewById(2131296447);
    image = ((ImageView)localObject);
    localObject = (Button)findViewById(2131296341);
    yes = ((Button)localObject);
    localObject = (TextView)findViewById(2131296456);
    no = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296454);
    UHID = ((TextView)localObject);
    localObject = (ImageView)findViewById(2131296259);
    button_home = ((ImageView)localObject);
    localObject = button_home;
    ShowAppointmentNoNumber.1 local1 = new in/gov/mgov/ors/ShowAppointmentNoNumber$1;
    local1.<init>(this);
    ((ImageView)localObject).setOnClickListener(local1);
  }
  
  private void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    localBuilder.<init>(this);
    Object localObject = getResources().getString(2131034183);
    localBuilder.setTitle((CharSequence)localObject);
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    String str = getResources().getString(2131034259);
    ShowAppointmentNoNumber.5 local5 = new in/gov/mgov/ors/ShowAppointmentNoNumber$5;
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
  
  private void updateView()
  {
    int i = 1;
    int j = 8;
    Object localObject1 = (Button)findViewById(2131296458);
    payment = ((Button)localObject1);
    payment.setVisibility(j);
    localObject1 = payment;
    Object localObject2 = new in/gov/mgov/ors/ShowAppointmentNoNumber$2;
    ((ShowAppointmentNoNumber.2)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = getResources();
    int k = 2131034150;
    localObject1 = ((Resources)localObject1).getString(k);
    localObject2 = pref;
    Object localObject3 = "source";
    String str1 = "";
    localObject2 = ((SharedPreferences)localObject2).getString((String)localObject3, str1);
    boolean bool1 = ((String)localObject1).equals(localObject2);
    if (!bool1)
    {
      localObject1 = new in/gov/mgov/ors/ShowAppointmentNoNumber$CallListagain;
      k = 0;
      ((ShowAppointmentNoNumber.CallListagain)localObject1).<init>(this, null);
      localObject2 = new String[i];
      localObject3 = "getHospitalListForPayment";
      localObject2[0] = localObject3;
      ((ShowAppointmentNoNumber.CallListagain)localObject1).execute((Object[])localObject2);
    }
    TextView localTextView = (TextView)findViewById(2131296258);
    localObject1 = pref.getString("source", "");
    localTextView.setText((CharSequence)localObject1);
    localObject1 = localTextView.getText().toString().replace("Book", "Booked");
    localTextView.setText((CharSequence)localObject1);
    int m = Integer.parseInt(pref.getString("state_code", "0"));
    statecode = m;
    m = Integer.parseInt(pref.getString("dept_code", "0"));
    departmentcode = m;
    m = Integer.parseInt(pref.getString("hospital_code", "0"));
    hospitalcode = m;
    localObject1 = pref.getString("date_name", "0");
    appdate = ((String)localObject1);
    localObject1 = appointment_detail;
    localObject2 = pref.getString("appointment_detail", "");
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = hostpital_state;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = hostpital_state.getText();
    localObject2 = ((StringBuilder)localObject2).append(localObject3);
    localObject3 = pref.getString("hospital_name", "");
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = department;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = department.getText();
    localObject2 = ((StringBuilder)localObject2).append(localObject3);
    localObject3 = pref;
    str1 = "dept_name";
    Object localObject4 = "";
    localObject3 = ((SharedPreferences)localObject3).getString(str1, (String)localObject4);
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = pref;
    localObject3 = "";
    localObject1 = ((SharedPreferences)localObject1).getString("aadhaar_no", (String)localObject3);
    localObject2 = "";
    boolean bool2 = ((String)localObject1).equals(localObject2);
    if (!bool2)
    {
      localObject1 = aadhaar;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = getResources().getString(2131034114);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ").append("XXXXXXXX");
      localObject3 = pref.getString("aadhaar_no", "");
      str1 = pref.getString("aadhaar_no", "");
      int n = str1.length() + -4;
      localObject4 = pref;
      String str2 = "aadhaar_no";
      String str3 = "";
      localObject4 = ((SharedPreferences)localObject4).getString(str2, str3);
      int i1 = ((String)localObject4).length();
      localObject3 = ((String)localObject3).substring(n, i1);
      localObject2 = (String)localObject3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
    }
    for (;;)
    {
      localObject1 = date;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = date.getText();
      localObject2 = ((StringBuilder)localObject2).append(localObject3);
      localObject3 = pref.getString("date_name", "");
      localObject2 = (String)localObject3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = appointmentid;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = appointmentid.getText();
      localObject2 = ((StringBuilder)localObject2).append(localObject3);
      localObject3 = pref;
      str1 = "appointment_id";
      localObject4 = "";
      localObject3 = ((SharedPreferences)localObject3).getString(str1, (String)localObject4);
      localObject2 = (String)localObject3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = pref;
      localObject3 = "";
      localObject1 = ((SharedPreferences)localObject1).getString("hid_data", (String)localObject3);
      localObject2 = "";
      bool2 = ((String)localObject1).equals(localObject2);
      if (bool2)
      {
        localObject1 = UHID;
        ((TextView)localObject1).setVisibility(j);
      }
      localObject1 = UHID;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = UHID.getText();
      localObject2 = ((StringBuilder)localObject2).append(localObject3).append(" ");
      localObject3 = pref.getString("hid_data", "");
      localObject2 = (String)localObject3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = getResources().getString(2131034313);
      showDialogonclick((String)localObject1);
      Intent localIntent = getIntent();
      localObject1 = localIntent.getStringArrayExtra("uid_data");
      uidData = ((String[])localObject1);
      localObject1 = localIntent.getStringExtra("aaddhaarid");
      aadhaarno = ((String)localObject1);
      localObject1 = name;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = getResources().getString(2131034243);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(" ");
      localObject3 = uidData[0];
      localObject2 = (String)localObject3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = dob;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = getResources().getString(2131034180);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
      localObject3 = uidData[i];
      localObject2 = (String)localObject3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = gender;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = getResources().getString(2131034211);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
      localObject3 = uidData[2];
      localObject2 = (String)localObject3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = mno;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = getResources().getString(2131034230);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
      localObject3 = uidData[3];
      localObject2 = (String)localObject3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      String str4 = uidData[5];
      address.setText(str4);
      image.setVisibility(j);
      localObject1 = yes;
      localObject2 = new in/gov/mgov/ors/ShowAppointmentNoNumber$3;
      ((ShowAppointmentNoNumber.3)localObject2).<init>(this);
      ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
      localObject1 = no;
      localObject2 = new in/gov/mgov/ors/ShowAppointmentNoNumber$4;
      ((ShowAppointmentNoNumber.4)localObject2).<init>(this);
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
      return;
      localObject1 = aadhaar;
      ((TextView)localObject1).setVisibility(j);
    }
  }
  
  public void onBackPressed()
  {
    Intent localIntent = new android/content/Intent;
    Context localContext = getApplicationContext();
    localIntent.<init>(localContext, ServiceSelection.class);
    localIntent.addFlags(268468224);
    startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903064);
    Object localObject = getSharedPreferences("ors", 0);
    pref = ((SharedPreferences)localObject);
    localObject = pref.edit();
    editor = ((SharedPreferences.Editor)localObject);
    editor.putString("paymentstatus", "").commit();
    intitalizeViews();
    updateView();
  }
  
  public String screenShot(View paramView)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
    Canvas localCanvas = new android/graphics/Canvas;
    localCanvas.<init>(localBitmap);
    paramView.draw(localCanvas);
    ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
    localByteArrayOutputStream.<init>();
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
    localBitmap.compress(localCompressFormat, 100, localByteArrayOutputStream);
    return Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowAppointmentNoNumber.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */