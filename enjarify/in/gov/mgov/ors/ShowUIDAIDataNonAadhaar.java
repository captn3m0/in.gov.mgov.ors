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
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class ShowUIDAIDataNonAadhaar
  extends Activity
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  private String METHOD = "";
  TextView aadhaar;
  String aadhaarno;
  TextView address;
  String appdate;
  TextView appointmenntdate;
  ImageView button_home;
  String[] date;
  TextView datepref;
  TextView department;
  int departmentcode;
  TextView dob;
  SharedPreferences.Editor editor;
  String finalresp;
  TextView gender;
  int hospitalcode;
  TextView hostpital_state;
  List id;
  ImageView image;
  List list;
  Spinner mdate;
  TextView mno;
  TextView mobilenumbertext;
  TextView name;
  TextView no;
  SharedPreferences pref;
  int statecode;
  String[] uidData;
  Button yes;
  
  public ShowUIDAIDataNonAadhaar()
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    id = localArrayList;
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
    localObject = (TextView)findViewById(2131296262);
    datepref = ((TextView)localObject);
    localObject = (Spinner)findViewById(2131296338);
    mdate = ((Spinner)localObject);
    localObject = (TextView)findViewById(2131296260);
    hostpital_state = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296261);
    department = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296448);
    aadhaar = ((TextView)localObject);
    localObject = (ImageView)findViewById(2131296447);
    image = ((ImageView)localObject);
    localObject = (Button)findViewById(2131296341);
    yes = ((Button)localObject);
    localObject = (TextView)findViewById(2131296456);
    no = ((TextView)localObject);
    localObject = (ImageView)findViewById(2131296259);
    button_home = ((ImageView)localObject);
    localObject = button_home;
    ShowUIDAIDataNonAadhaar.1 local1 = new in/gov/mgov/ors/ShowUIDAIDataNonAadhaar$1;
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
    ShowUIDAIDataNonAadhaar.4 local4 = new in/gov/mgov/ors/ShowUIDAIDataNonAadhaar$4;
    local4.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local4);
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
    int i = 2131034114;
    int j = 8;
    TextView localTextView = (TextView)findViewById(2131296258);
    Object localObject1 = pref.getString("source", "");
    localTextView.setText((CharSequence)localObject1);
    int k = Integer.parseInt(pref.getString("state_code", "0"));
    statecode = k;
    k = Integer.parseInt(pref.getString("dept_code", "0"));
    departmentcode = k;
    k = Integer.parseInt(pref.getString("hospital_code", "0"));
    hospitalcode = k;
    localObject1 = pref.getString("date_name", "0");
    appdate = ((String)localObject1);
    localObject1 = hostpital_state;
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    Object localObject3 = hostpital_state.getText();
    localObject2 = ((StringBuilder)localObject2).append(localObject3);
    localObject3 = pref.getString("hospital_name", "");
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(", ");
    localObject3 = pref.getString("state_name", "");
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
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources().getString(i);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
    localObject3 = pref.getString("aadhaar_no", "");
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = datepref;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources();
    int m = 2131034133;
    localObject3 = ((Resources)localObject3).getString(m);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
    localObject3 = pref;
    String str1 = "date_name";
    String str2 = "";
    localObject3 = ((SharedPreferences)localObject3).getString(str1, str2);
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = pref;
    localObject3 = "";
    localObject1 = ((SharedPreferences)localObject1).getString("aadhaar_no", (String)localObject3);
    localObject2 = "";
    boolean bool = ((String)localObject1).equals(localObject2);
    if (bool)
    {
      localObject1 = aadhaar;
      ((TextView)localObject1).setVisibility(j);
    }
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
    localObject3 = uidData[1];
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
    localObject1 = aadhaar;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources().getString(i);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
    localObject3 = aadhaarno;
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    image.setVisibility(j);
    localObject1 = address;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources().getString(2131034122);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
    localObject3 = uidData[5];
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(", ");
    localObject3 = uidData[6];
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = yes;
    localObject2 = new in/gov/mgov/ors/ShowUIDAIDataNonAadhaar$2;
    ((ShowUIDAIDataNonAadhaar.2)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = no;
    localObject2 = new in/gov/mgov/ors/ShowUIDAIDataNonAadhaar$3;
    ((ShowUIDAIDataNonAadhaar.3)localObject2).<init>(this);
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
    setContentView(2130903067);
    Object localObject = getSharedPreferences("ors", 0);
    pref = ((SharedPreferences)localObject);
    localObject = pref.edit();
    editor = ((SharedPreferences.Editor)localObject);
    intitalizeViews();
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowUIDAIDataNonAadhaar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */