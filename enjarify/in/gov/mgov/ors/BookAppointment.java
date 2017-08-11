package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BookAppointment
  extends Activity
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  String DepartmentnameString;
  private String METHOD;
  String aadhaarno;
  String appdate;
  ImageView button_home;
  Button cancel;
  TextView chk;
  String[] date;
  String dateString;
  List datelist;
  String[] department;
  int departmentcode;
  String[] departmentid;
  SharedPreferences.Editor editor;
  String finalresp;
  String[] hospital;
  int hospitalcode;
  String[] hospitalid;
  TextView hospitalname;
  String hospitalnameString;
  List id;
  int limit;
  List list;
  Spinner mdate;
  Spinner mdepartment;
  Spinner mhospital;
  Spinner mstate;
  Button next;
  SharedPreferences pref;
  Button proceed;
  String spacialitymessage;
  String[] state;
  int statecode;
  String[] stateid;
  String[] uidData;
  int x;
  Button yes;
  
  public BookAppointment()
  {
    Object localObject = new String[7];
    localObject[0] = "-Select State-";
    localObject[m] = "ASSAM";
    localObject[k] = "BIHAR";
    localObject[j] = "DELHI";
    localObject[i] = "GOA";
    localObject[5] = "GUJRAT";
    localObject[6] = "HARYANA";
    state = ((String[])localObject);
    localObject = new String[i];
    localObject[0] = "-Select Hospital-";
    localObject[m] = "AIIMS";
    localObject[k] = "Dr.Ram Manohar Lohia Hospital";
    localObject[j] = "Sports Injury Center (Safdarjung Hospital)";
    hospital = ((String[])localObject);
    localObject = new String[6];
    localObject[0] = "-Select Department-";
    localObject[m] = "Cardiology";
    localObject[k] = "C.T.V.S";
    localObject[j] = "Endrocrionology";
    localObject[i] = "ENT";
    localObject[5] = "Pedriatric";
    department = ((String[])localObject);
    localObject = new String[5];
    localObject[0] = "-Select Date-";
    localObject[m] = "24-june-2015";
    localObject[k] = "25-june-2015";
    localObject[j] = "25-june-2015";
    localObject[i] = "26-june-2015";
    date = ((String[])localObject);
    spacialitymessage = "";
    statecode = 7;
    x = 0;
    limit = 5;
    localObject = new java/util/ArrayList;
    ((ArrayList)localObject).<init>();
    datelist = ((List)localObject);
    localObject = new java/util/ArrayList;
    ((ArrayList)localObject).<init>();
    list = ((List)localObject);
    localObject = new java/util/ArrayList;
    ((ArrayList)localObject).<init>();
    id = ((List)localObject);
    finalresp = "";
    METHOD = "";
  }
  
  private void intitializeViews()
  {
    Object localObject = (ImageView)findViewById(2131296259);
    button_home = ((ImageView)localObject);
    localObject = (Spinner)findViewById(2131296334);
    mstate = ((Spinner)localObject);
    localObject = (Spinner)findViewById(2131296335);
    mhospital = ((Spinner)localObject);
    localObject = (Spinner)findViewById(2131296337);
    mdepartment = ((Spinner)localObject);
    localObject = (Spinner)findViewById(2131296338);
    mdate = ((Spinner)localObject);
    localObject = (TextView)findViewById(2131296332);
    hospitalname = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296342);
    chk = ((TextView)localObject);
    localObject = (Button)findViewById(2131296339);
    next = ((Button)localObject);
    localObject = (Button)findViewById(2131296341);
    yes = ((Button)localObject);
    localObject = (Button)findViewById(2131296273);
    proceed = ((Button)localObject);
    localObject = (Button)findViewById(2131296340);
    cancel = ((Button)localObject);
  }
  
  private void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    localBuilder.<init>(this);
    Object localObject = getResources().getString(2131034183);
    localBuilder.setTitle((CharSequence)localObject);
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    String str = getResources().getString(2131034259);
    BookAppointment.10 local10 = new in/gov/mgov/ors/BookAppointment$10;
    local10.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local10);
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
    BookAppointment.11 local11 = new in/gov/mgov/ors/BookAppointment$11;
    local11.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local11);
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
    int i = 8;
    TextView localTextView = (TextView)findViewById(2131296258);
    Object localObject1 = pref;
    Object localObject2 = "source";
    localObject1 = ((SharedPreferences)localObject1).getString((String)localObject2, "");
    localTextView.setText((CharSequence)localObject1);
    yes.setVisibility(i);
    next.setVisibility(i);
    ArrayAdapter localArrayAdapter = new android/widget/ArrayAdapter;
    localObject1 = getApplicationContext();
    int j = 2130903050;
    String[] arrayOfString = state;
    localArrayAdapter.<init>((Context)localObject1, j, arrayOfString);
    localObject1 = mstate;
    ((Spinner)localObject1).setAdapter(localArrayAdapter);
    boolean bool = isConnected();
    if (bool)
    {
      localObject1 = new in/gov/mgov/ors/BookAppointment$CallList;
      ((BookAppointment.CallList)localObject1).<init>(this, null);
      j = 2;
      localObject2 = new String[j];
      arrayOfString = null;
      localObject2[0] = "getHospitallist";
      int k = 1;
      String str = "0";
      localObject2[k] = str;
      ((BookAppointment.CallList)localObject1).execute((Object[])localObject2);
    }
    localObject1 = mstate;
    localObject2 = new in/gov/mgov/ors/BookAppointment$1;
    ((BookAppointment.1)localObject2).<init>(this);
    ((Spinner)localObject1).setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject2);
    localObject1 = mhospital;
    localObject2 = new in/gov/mgov/ors/BookAppointment$2;
    ((BookAppointment.2)localObject2).<init>(this);
    ((Spinner)localObject1).setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject2);
    localObject1 = mdepartment;
    localObject2 = new in/gov/mgov/ors/BookAppointment$3;
    ((BookAppointment.3)localObject2).<init>(this);
    ((Spinner)localObject1).setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject2);
    localObject1 = mdate;
    localObject2 = new in/gov/mgov/ors/BookAppointment$4;
    ((BookAppointment.4)localObject2).<init>(this);
    ((Spinner)localObject1).setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject2);
    localObject1 = proceed;
    localObject2 = new in/gov/mgov/ors/BookAppointment$5;
    ((BookAppointment.5)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = yes;
    localObject2 = new in/gov/mgov/ors/BookAppointment$6;
    ((BookAppointment.6)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = cancel;
    localObject2 = new in/gov/mgov/ors/BookAppointment$7;
    ((BookAppointment.7)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = next;
    localObject2 = new in/gov/mgov/ors/BookAppointment$8;
    ((BookAppointment.8)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = button_home;
    localObject2 = new in/gov/mgov/ors/BookAppointment$9;
    ((BookAppointment.9)localObject2).<init>(this);
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
    Object localObject1 = getSharedPreferences("ors", 0);
    pref = ((SharedPreferences)localObject1);
    localObject1 = pref.edit();
    editor = ((SharedPreferences.Editor)localObject1);
    localObject1 = pref;
    String str1 = "EN";
    localObject1 = ((SharedPreferences)localObject1).getString("lang", str1);
    Object localObject2 = "HI";
    boolean bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
    if (bool)
    {
      String str2 = "hi";
      Locale localLocale = new java/util/Locale;
      localLocale.<init>(str2);
      Locale.setDefault(localLocale);
      Configuration localConfiguration = new android/content/res/Configuration;
      localConfiguration.<init>();
      locale = localLocale;
      localObject1 = getBaseContext().getResources();
      localObject2 = getBaseContext().getResources().getDisplayMetrics();
      ((Resources)localObject1).updateConfiguration(localConfiguration, (DisplayMetrics)localObject2);
    }
    setContentView(2130903045);
    intitializeViews();
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */