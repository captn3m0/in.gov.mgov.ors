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
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GetUserInformation
  extends Activity
{
  Button Submit;
  TextView aadhaar;
  EditText address;
  TextView appointmentdate;
  ImageView button_home;
  EditText cof;
  Spinner country;
  String[] countrydata;
  TextView date;
  EditText dd;
  TextView department;
  SharedPreferences.Editor editor;
  EditText emailid;
  EditText fname;
  RadioGroup gender;
  RadioButton gendervalue;
  TextView hostpital_state;
  Spinner initials;
  String[] intialsdata;
  EditText lname;
  String location;
  EditText mm;
  EditText mname;
  EditText mobile;
  TextView mobilenumber;
  EditText mothername;
  TextView name;
  EditText pin;
  SharedPreferences pref;
  Spinner state;
  int[] stateCode;
  String[] statedata;
  EditText yyyy;
  
  public GetUserInformation()
  {
    Object localObject = new String[5];
    localObject[0] = "-Select-";
    localObject[m] = "Mr.";
    localObject[k] = "Mrs.";
    localObject[j] = "Miss";
    localObject[i] = "Others";
    intialsdata = ((String[])localObject);
    localObject = new String[37];
    localObject[0] = "-Select State-";
    localObject[m] = "Andman & Nicobar Islands";
    localObject[k] = "Andhra Pradesh";
    localObject[j] = "Arunachal Pradesh";
    localObject[i] = "Assam";
    localObject[5] = "Bihar";
    localObject[6] = "Chhattisgarh";
    localObject[7] = "Chandigarh";
    localObject[8] = "Daman & Diu";
    localObject[9] = "Delhi";
    localObject[10] = "Dadra & Nagar Haveli";
    localObject[11] = "Goa";
    localObject[12] = "Gujarat";
    localObject[13] = "Himachal Pradesh";
    localObject[14] = "Haryana";
    localObject[15] = "Jharkhand";
    localObject[16] = "Jammu & Kashmir";
    localObject[17] = "Karnataka";
    localObject[18] = "Kerala";
    localObject[19] = "Lakshadweep";
    localObject[20] = "Meghalaya";
    localObject[21] = "Maharashtra";
    localObject[22] = "Manipur";
    localObject[23] = "Madhya Pradesh";
    localObject[24] = "Mizoram";
    localObject[25] = "Nagaland";
    localObject[26] = "Odisha";
    localObject[27] = "Puducherry";
    localObject[28] = "Punjab";
    localObject[29] = "Rajasthan";
    localObject[30] = "Sikkim";
    localObject[31] = "Tamil Nadu";
    localObject[32] = "Tripura";
    localObject[33] = "Uttar Pradesh";
    localObject[34] = "Uttarakhand";
    localObject[35] = "West bengal";
    localObject[36] = "Telangana";
    statedata = ((String[])localObject);
    localObject = new int[37];
    Object tmp331_329 = localObject;
    Object tmp332_331 = tmp331_329;
    Object tmp332_331 = tmp331_329;
    tmp332_331[0] = 0;
    tmp332_331[1] = 35;
    Object tmp340_332 = tmp332_331;
    Object tmp340_332 = tmp332_331;
    tmp340_332[2] = 28;
    tmp340_332[3] = 12;
    Object tmp349_340 = tmp340_332;
    Object tmp349_340 = tmp340_332;
    tmp349_340[4] = 18;
    tmp349_340[5] = 10;
    Object tmp358_349 = tmp349_340;
    Object tmp358_349 = tmp349_340;
    tmp358_349[6] = 22;
    tmp358_349[7] = 4;
    Object tmp368_358 = tmp358_349;
    Object tmp368_358 = tmp358_349;
    tmp368_358[8] = 25;
    tmp368_358[9] = 7;
    Object tmp379_368 = tmp368_358;
    Object tmp379_368 = tmp368_358;
    tmp379_368[10] = 26;
    tmp379_368[11] = 30;
    Object tmp390_379 = tmp379_368;
    Object tmp390_379 = tmp379_368;
    tmp390_379[12] = 24;
    tmp390_379[13] = 2;
    Object tmp400_390 = tmp390_379;
    Object tmp400_390 = tmp390_379;
    tmp400_390[14] = 6;
    tmp400_390[15] = 20;
    Object tmp411_400 = tmp400_390;
    Object tmp411_400 = tmp400_390;
    tmp411_400[16] = 1;
    tmp411_400[17] = 29;
    Object tmp421_411 = tmp411_400;
    Object tmp421_411 = tmp411_400;
    tmp421_411[18] = 32;
    tmp421_411[19] = 31;
    Object tmp432_421 = tmp421_411;
    Object tmp432_421 = tmp421_411;
    tmp432_421[20] = 17;
    tmp432_421[21] = 27;
    Object tmp443_432 = tmp432_421;
    Object tmp443_432 = tmp432_421;
    tmp443_432[22] = 14;
    tmp443_432[23] = 23;
    Object tmp454_443 = tmp443_432;
    Object tmp454_443 = tmp443_432;
    tmp454_443[24] = 15;
    tmp454_443[25] = 13;
    Object tmp465_454 = tmp454_443;
    Object tmp465_454 = tmp454_443;
    tmp465_454[26] = 21;
    tmp465_454[27] = 34;
    Object tmp476_465 = tmp465_454;
    Object tmp476_465 = tmp465_454;
    tmp476_465[28] = 3;
    tmp476_465[29] = 8;
    Object tmp486_476 = tmp476_465;
    Object tmp486_476 = tmp476_465;
    tmp486_476[30] = 11;
    tmp486_476[31] = 33;
    Object tmp497_486 = tmp486_476;
    Object tmp497_486 = tmp486_476;
    tmp497_486[32] = 16;
    tmp497_486[33] = 9;
    tmp497_486[34] = 5;
    Object tmp512_497 = tmp497_486;
    tmp512_497[35] = 19;
    tmp512_497[36] = 36;
    stateCode = ((int[])localObject);
    localObject = new String[k];
    localObject[0] = "-Select Country-";
    localObject[m] = "INDIA";
    countrydata = ((String[])localObject);
  }
  
  private void intitalizeViews()
  {
    Object localObject = (ImageView)findViewById(2131296259);
    button_home = ((ImageView)localObject);
    localObject = (Spinner)findViewById(2131296386);
    initials = ((Spinner)localObject);
    localObject = (Spinner)findViewById(2131296334);
    state = ((Spinner)localObject);
    localObject = (Spinner)findViewById(2131296403);
    country = ((Spinner)localObject);
    localObject = (TextView)findViewById(2131296260);
    hostpital_state = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296261);
    department = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296385);
    name = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296383);
    aadhaar = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296384);
    mobilenumber = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296262);
    appointmentdate = ((TextView)localObject);
    localObject = (EditText)findViewById(2131296387);
    fname = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296388);
    mname = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296389);
    lname = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296395);
    dd = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296396);
    mm = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296397);
    yyyy = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296390);
    cof = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296398);
    mothername = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296399);
    emailid = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296400);
    mobile = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296401);
    address = ((EditText)localObject);
    localObject = (EditText)findViewById(2131296405);
    pin = ((EditText)localObject);
    localObject = (RadioGroup)findViewById(2131296391);
    gender = ((RadioGroup)localObject);
    localObject = (Button)findViewById(2131296269);
    Submit = ((Button)localObject);
  }
  
  private void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    localBuilder.<init>(this);
    Object localObject = getResources().getString(2131034183);
    localBuilder.setTitle((CharSequence)localObject);
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    String str = getResources().getString(2131034259);
    GetUserInformation.3 local3 = new in/gov/mgov/ors/GetUserInformation$3;
    local3.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local3);
    localBuilder.create().show();
  }
  
  private void updateView()
  {
    int i = 2130903050;
    TextView localTextView = (TextView)findViewById(2131296258);
    Object localObject1 = pref.getString("source", "");
    localTextView.setText((CharSequence)localObject1);
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
    localObject3 = aadhaar.getText();
    localObject2 = ((StringBuilder)localObject2).append(localObject3);
    localObject3 = pref.getString("aadhaar_no", "");
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = state;
    localObject2 = new android/widget/ArrayAdapter;
    localObject3 = getApplicationContext();
    String[] arrayOfString = statedata;
    ((ArrayAdapter)localObject2).<init>((Context)localObject3, i, arrayOfString);
    ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
    localObject1 = initials;
    localObject2 = new android/widget/ArrayAdapter;
    localObject3 = getApplicationContext();
    arrayOfString = intialsdata;
    ((ArrayAdapter)localObject2).<init>((Context)localObject3, i, arrayOfString);
    ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
    localObject1 = country;
    localObject2 = new android/widget/ArrayAdapter;
    localObject3 = getApplicationContext();
    arrayOfString = countrydata;
    ((ArrayAdapter)localObject2).<init>((Context)localObject3, i, arrayOfString);
    ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
    localObject1 = Submit;
    localObject2 = new in/gov/mgov/ors/GetUserInformation$1;
    ((GetUserInformation.1)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = button_home;
    localObject2 = new in/gov/mgov/ors/GetUserInformation$2;
    ((GetUserInformation.2)localObject2).<init>(this);
    ((ImageView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
  }
  
  public boolean isThisDateValid(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (paramString1 == null) {}
    for (;;)
    {
      return bool;
      SimpleDateFormat localSimpleDateFormat = new java/text/SimpleDateFormat;
      localSimpleDateFormat.<init>(paramString2);
      localSimpleDateFormat.setLenient(false);
      try
      {
        localSimpleDateFormat.parse(paramString1);
        bool = true;
      }
      catch (ParseException localParseException)
      {
        localParseException.printStackTrace();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool1 = true;
    super.onCreate(paramBundle);
    Object localObject1 = getWindow();
    int i = 8;
    ((Window)localObject1).requestFeature(i);
    getActionBar().hide();
    setContentView(2130903051);
    intitalizeViews();
    localObject1 = getSharedPreferences("ors", 0);
    pref = ((SharedPreferences)localObject1);
    localObject1 = pref.edit();
    editor = ((SharedPreferences.Editor)localObject1);
    localObject1 = appointmentdate;
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    Object localObject3 = appointmentdate.getText();
    localObject2 = ((StringBuilder)localObject2).append(localObject3);
    localObject3 = pref;
    String str1 = "date_name";
    String str2 = "";
    localObject3 = ((SharedPreferences)localObject3).getString(str1, str2);
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    Intent localIntent = getIntent();
    localObject1 = localIntent.getStringExtra("from");
    location = ((String)localObject1);
    String str3 = localIntent.getStringExtra("name");
    String str4 = localIntent.getStringExtra("mono");
    localObject1 = location;
    localObject2 = "noaadhaar";
    boolean bool2 = ((String)localObject1).equals(localObject2);
    if (bool2)
    {
      fname.setEnabled(bool1);
      lname.setEnabled(bool1);
      mobile.setText(str4);
      localObject1 = mobile;
      ((EditText)localObject1).setEnabled(false);
    }
    localObject1 = location;
    localObject2 = "fromaadhaar";
    bool2 = ((String)localObject1).equals(localObject2);
    if (bool2)
    {
      localObject1 = fname;
      i = str3.indexOf(" ");
      localObject2 = str3.substring(0, i);
      ((EditText)localObject1).setText((CharSequence)localObject2);
      localObject1 = lname;
      i = str3.indexOf(" ");
      int j = str3.length();
      localObject2 = str3.substring(i, j);
      ((EditText)localObject1).setText((CharSequence)localObject2);
      mobile.setText(str4);
      localObject1 = name;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = name.getText();
      localObject2 = localObject3 + str3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = mobilenumber;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = mobilenumber.getText();
      localObject2 = localObject3 + str4;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      fname.setEnabled(false);
      lname.setEnabled(false);
      localObject1 = mobile;
      ((EditText)localObject1).setEnabled(false);
    }
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/GetUserInformation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */