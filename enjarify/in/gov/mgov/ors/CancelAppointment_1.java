package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class CancelAppointment_1
  extends Activity
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  private String METHOD = "";
  private String[] arraySpinner;
  Button btn_proceed;
  ImageView button_home;
  ImageView button_home_page;
  EditText enteredValue;
  String[] hospital;
  String hospitalcode;
  String[] hospitalid;
  String hospitalname;
  Spinner mhospital;
  String[] resAadhaar;
  String[] resAppdates;
  String[] resAppointment_id;
  String[] resApptime;
  String[] resDOB;
  String[] resDepts;
  String[] resDoctor;
  String[] resEmail;
  String[] resGender;
  String[] resMobileNo;
  String[] resP_address;
  String[] resPatientname;
  String[] resRequestDate;
  String[] resRoom_name;
  String[] resStatus;
  String[] resfathers_name;
  String[] reshid;
  String[] reshospitals;
  Spinner search_criteria;
  String type;
  
  private void intializeViews()
  {
    Object localObject = (ImageView)findViewById(2131296259);
    button_home_page = ((ImageView)localObject);
    localObject = (Spinner)findViewById(2131296335);
    mhospital = ((Spinner)localObject);
    localObject = (Spinner)findViewById(2131296343);
    search_criteria = ((Spinner)localObject);
    localObject = (EditText)findViewById(2131296344);
    enteredValue = ((EditText)localObject);
    localObject = (Button)findViewById(2131296273);
    btn_proceed = ((Button)localObject);
  }
  
  private void showMessage(String paramString)
  {
    Toast localToast = Toast.makeText(getApplicationContext(), paramString, 1);
    localToast.setGravity(17, 0, 0);
    localToast.show();
  }
  
  private void updateView()
  {
    boolean bool = isConnected();
    if (bool)
    {
      localObject1 = new in/gov/mgov/ors/CancelAppointment_1$CallList;
      ((CancelAppointment_1.CallList)localObject1).<init>(this, null);
      int i = 1;
      localObject2 = new String[i];
      String str = "getHospitallist";
      localObject2[0] = str;
      ((CancelAppointment_1.CallList)localObject1).execute((Object[])localObject2);
    }
    Object localObject1 = mhospital;
    Object localObject2 = new in/gov/mgov/ors/CancelAppointment_1$2;
    ((CancelAppointment_1.2)localObject2).<init>(this);
    ((Spinner)localObject1).setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject2);
    localObject1 = btn_proceed;
    localObject2 = new in/gov/mgov/ors/CancelAppointment_1$3;
    ((CancelAppointment_1.3)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = button_home_page;
    localObject2 = new in/gov/mgov/ors/CancelAppointment_1$4;
    ((CancelAppointment_1.4)localObject2).<init>(this);
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
    int i = 2;
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903046);
    intializeViews();
    updateView();
    Object localObject1 = new String[3];
    String str = getResources().getString(2131034153);
    localObject1[0] = str;
    str = getResources().getString(2131034155);
    localObject1[1] = str;
    Object localObject2 = getResources().getString(2131034152);
    localObject1[i] = localObject2;
    arraySpinner = ((String[])localObject1);
    ArrayAdapter localArrayAdapter = new android/widget/ArrayAdapter;
    localObject2 = arraySpinner;
    localArrayAdapter.<init>(this, 2130903050, (Object[])localObject2);
    search_criteria.setAdapter(localArrayAdapter);
    search_criteria.setSelection(i);
    localObject1 = search_criteria;
    localObject2 = new in/gov/mgov/ors/CancelAppointment_1$1;
    ((CancelAppointment_1.1)localObject2).<init>(this);
    ((Spinner)localObject1).setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject2);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment_1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */