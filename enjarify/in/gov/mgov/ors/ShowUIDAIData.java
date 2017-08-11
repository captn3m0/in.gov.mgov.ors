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
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Base64;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;

public class ShowUIDAIData
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
  String appointmentidforcheck = "";
  ImageView button_home;
  String[] date;
  List datelist;
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
  int limit = 10;
  List list;
  Spinner mdate;
  TextView mno;
  int monthx;
  TextView name;
  Button next;
  TextView no;
  SharedPreferences pref;
  int statecode;
  String[] uidData;
  int x = 0;
  Button yes;
  
  public ShowUIDAIData()
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    datelist = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    id = localArrayList;
    monthx = 0;
  }
  
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
  
  private PropertyInfo addProperties(String paramString, Boolean paramBoolean, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    localPropertyInfo.setName(paramString);
    localPropertyInfo.setValue(paramBoolean);
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
    localObject = (Button)findViewById(2131296339);
    next = ((Button)localObject);
    localObject = (ImageView)findViewById(2131296259);
    button_home = ((ImageView)localObject);
    localObject = button_home;
    ShowUIDAIData.1 local1 = new in/gov/mgov/ors/ShowUIDAIData$1;
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
    ShowUIDAIData.5 local5 = new in/gov/mgov/ors/ShowUIDAIData$5;
    local5.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local5);
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
    Object localObject1 = pref;
    Object localObject2 = "source";
    Object localObject3 = "";
    localObject1 = ((SharedPreferences)localObject1).getString((String)localObject2, (String)localObject3);
    localTextView.setText((CharSequence)localObject1);
    ShowUIDAIData.CallList localCallList = new in/gov/mgov/ors/ShowUIDAIData$CallList;
    localObject1 = null;
    localCallList.<init>(this, null);
    boolean bool = isConnected();
    if (bool)
    {
      localObject1 = pref;
      localObject2 = "state_code";
      localObject3 = "0";
      localObject1 = ((SharedPreferences)localObject1).getString((String)localObject2, (String)localObject3);
      i = Integer.parseInt((String)localObject1);
      statecode = i;
    }
    int i = Integer.parseInt(pref.getString("dept_code", "0"));
    departmentcode = i;
    i = Integer.parseInt(pref.getString("hospital_code", "0"));
    hospitalcode = i;
    localObject1 = pref.getString("date_name", "0");
    appdate = ((String)localObject1);
    localObject1 = datepref;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources().getString(2131034133);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
    localObject3 = pref.getString("date_name", "");
    localObject2 = (String)localObject3;
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
    localObject3 = pref.getString("dept_name", "");
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = aadhaar;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources().getString(2131034133);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ").append("XXXXXXXX");
    localObject3 = pref.getString("aadhaar_no", "");
    String str1 = pref.getString("aadhaar_no", "");
    int j = str1.length() + -4;
    Object localObject4 = pref;
    String str2 = "aadhaar_no";
    String str3 = "";
    localObject4 = ((SharedPreferences)localObject4).getString(str2, str3);
    int k = ((String)localObject4).length();
    localObject3 = ((String)localObject3).substring(j, k);
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    Intent localIntent = getIntent();
    localObject1 = localIntent.getStringArrayExtra("uid_data");
    uidData = ((String[])localObject1);
    localObject1 = localIntent.getStringExtra("aaddhaarid");
    aadhaarno = ((String)localObject1);
    localObject1 = name;
    localObject2 = uidData;
    localObject3 = null;
    localObject2 = localObject2[0];
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = dob;
    localObject2 = uidData[1];
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = gender;
    localObject2 = uidData[2];
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = mno;
    localObject2 = uidData;
    int m = 3;
    localObject2 = localObject2[m];
    ((TextView)localObject1).setText((CharSequence)localObject2);
    String str4 = "";
    int n = 5;
    for (;;)
    {
      i = 15;
      if (n >= i) {
        break;
      }
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject1 = ((StringBuilder)localObject1).append(str4);
      localObject2 = uidData[n];
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
      localObject2 = " ";
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
      str4 = ((StringBuilder)localObject1).toString();
      n += 1;
    }
    address.setText(str4);
    byte[] arrayOfByte = Base64.decode(uidData[15], 0);
    int i1 = arrayOfByte.length;
    Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, i1);
    image.setImageBitmap(localBitmap);
    localObject1 = yes;
    localObject2 = new in/gov/mgov/ors/ShowUIDAIData$2;
    ((ShowUIDAIData.2)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = no;
    localObject2 = new in/gov/mgov/ors/ShowUIDAIData$3;
    ((ShowUIDAIData.3)localObject2).<init>(this);
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = next;
    localObject2 = new in/gov/mgov/ors/ShowUIDAIData$4;
    ((ShowUIDAIData.4)localObject2).<init>(this);
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
    setContentView(2130903066);
    Object localObject = getSharedPreferences("ors", 0);
    pref = ((SharedPreferences)localObject);
    localObject = pref.edit();
    editor = ((SharedPreferences.Editor)localObject);
    intitalizeViews();
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowUIDAIData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */