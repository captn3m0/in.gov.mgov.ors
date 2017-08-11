package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
  String[] countrydata = { "-Select Country-", "INDIA" };
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
  String[] intialsdata = { "-Select-", "Mr.", "Mrs.", "Miss", "Others" };
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
  int[] stateCode = { 0, 35, 28, 12, 18, 10, 22, 4, 25, 7, 26, 30, 24, 2, 6, 20, 1, 29, 32, 31, 17, 27, 14, 23, 15, 13, 21, 34, 3, 8, 11, 33, 16, 9, 5, 19, 36 };
  String[] statedata = { "-Select State-", "Andman & Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Chandigarh", "Daman & Diu", "Delhi", "Dadra & Nagar Haveli", "Goa", "Gujarat", "Himachal Pradesh", "Haryana", "Jharkhand", "Jammu & Kashmir", "Karnataka", "Kerala", "Lakshadweep", "Meghalaya", "Maharashtra", "Manipur", "Madhya Pradesh", "Mizoram", "Nagaland", "Odisha", "Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttar Pradesh", "Uttarakhand", "West bengal", "Telangana" };
  EditText yyyy;
  
  private void intitalizeViews()
  {
    button_home = ((ImageView)findViewById(2131296259));
    initials = ((Spinner)findViewById(2131296386));
    state = ((Spinner)findViewById(2131296334));
    country = ((Spinner)findViewById(2131296403));
    hostpital_state = ((TextView)findViewById(2131296260));
    department = ((TextView)findViewById(2131296261));
    name = ((TextView)findViewById(2131296385));
    aadhaar = ((TextView)findViewById(2131296383));
    mobilenumber = ((TextView)findViewById(2131296384));
    appointmentdate = ((TextView)findViewById(2131296262));
    fname = ((EditText)findViewById(2131296387));
    mname = ((EditText)findViewById(2131296388));
    lname = ((EditText)findViewById(2131296389));
    dd = ((EditText)findViewById(2131296395));
    mm = ((EditText)findViewById(2131296396));
    yyyy = ((EditText)findViewById(2131296397));
    cof = ((EditText)findViewById(2131296390));
    mothername = ((EditText)findViewById(2131296398));
    emailid = ((EditText)findViewById(2131296399));
    mobile = ((EditText)findViewById(2131296400));
    address = ((EditText)findViewById(2131296401));
    pin = ((EditText)findViewById(2131296405));
    gender = ((RadioGroup)findViewById(2131296391));
    Submit = ((Button)findViewById(2131296269));
  }
  
  private void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getResources().getString(2131034183));
    localBuilder.setMessage(paramString).setCancelable(false).setPositiveButton(getResources().getString(2131034259), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    localBuilder.create().show();
  }
  
  private void updateView()
  {
    ((TextView)findViewById(2131296258)).setText(pref.getString("source", ""));
    hostpital_state.setText(hostpital_state.getText() + pref.getString("hospital_name", "") + ", " + pref.getString("state_name", ""));
    department.setText(department.getText() + pref.getString("dept_name", ""));
    aadhaar.setText(aadhaar.getText() + pref.getString("aadhaar_no", ""));
    state.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, statedata));
    initials.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, intialsdata));
    country.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, countrydata));
    Submit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int k = 0;
        int n = 0;
        int i1 = 0;
        int i5 = 0;
        int i2 = 0;
        int i3 = 0;
        int i6 = 0;
        int i4 = 0;
        int m = 0;
        int i = gender.getCheckedRadioButtonId();
        gendervalue = ((RadioButton)findViewById(i));
        label103:
        int j;
        if (fname.getText().length() != 0)
        {
          k = 0 + 1;
          if (lname.getText().length() == 0) {
            break label985;
          }
          k += 1;
          i = m;
          j = k;
          if (dd.getText().length() != 0)
          {
            if ((Integer.parseInt(dd.getText().toString()) <= 0) || (Integer.parseInt(dd.getText().toString()) > 31)) {
              break label991;
            }
            if (dd.getText().length() == 1) {
              dd.setText("0" + dd.getText());
            }
            j = k + 1;
            i = m;
          }
          label232:
          k = i;
          m = j;
          if (mm.getText().length() != 0)
          {
            if ((Integer.parseInt(mm.getText().toString()) <= 0) || (Integer.parseInt(mm.getText().toString()) > 12)) {
              break label999;
            }
            if (mm.getText().length() == 1) {
              mm.setText("0" + mm.getText());
            }
            m = j + 1;
            k = i;
          }
          label361:
          j = k;
          i = m;
          if (yyyy.getText().length() != 0)
          {
            if ((Integer.parseInt(yyyy.getText().toString()) <= 1900) || (Integer.parseInt(yyyy.getText().toString()) > Calendar.getInstance().get(1))) {
              break label1008;
            }
            i = m + 1;
            j = k;
          }
          label441:
          if (!isThisDateValid(dd.getText() + "/" + mm.getText() + "/" + yyyy.getText(), "dd/MM/yyyy")) {
            break label1016;
          }
          i += 1;
          k = i6;
          label520:
          if (cof.getText().toString().trim().length() == 0) {
            break label1022;
          }
          i += 1;
          m = i5;
          label550:
          if (mobile.getText().length() == 0) {
            break label1028;
          }
          i += 1;
          label572:
          if (address.getText().toString().trim().length() == 0) {
            break label1034;
          }
          i += 1;
          label598:
          if (state.getSelectedItemPosition() == 0) {
            break label1040;
          }
          i += 1;
          label615:
          if (i != 10) {
            break label1066;
          }
          paramAnonymousView = new ArrayList();
          paramAnonymousView.add(fname.getText().toString().trim() + " " + lname.getText().toString().trim());
          paramAnonymousView.add(dd.getText().toString() + "-" + mm.getText().toString() + "-" + yyyy.getText().toString());
          paramAnonymousView.add(gendervalue.getText().toString());
          paramAnonymousView.add(mobile.getText().toString());
          paramAnonymousView.add(cof.getText().toString());
          paramAnonymousView.add(address.getText().toString() + " " + pin.getText().toString());
          paramAnonymousView.add(state.getSelectedItem().toString());
          localObject = (String[])paramAnonymousView.toArray(new String[paramAnonymousView.size()]);
          if (!location.equals("noaadhaar")) {
            break label1046;
          }
        }
        label985:
        label991:
        label999:
        label1008:
        label1016:
        label1022:
        label1028:
        label1034:
        label1040:
        label1046:
        for (paramAnonymousView = new Intent(getApplicationContext(), ShowUIDAIDataNonAadhaar.class);; paramAnonymousView = new Intent(getApplicationContext(), ShowUIDAIDataNonNumber.class))
        {
          paramAnonymousView.putExtra("uid_data", (String[])localObject);
          paramAnonymousView.putExtra("from", "fromaadhaarnonumber");
          startActivity(paramAnonymousView);
          return;
          n = 1;
          break;
          i1 = 1;
          break label103;
          i = 1;
          j = k;
          break label232;
          k = 1;
          m = j;
          break label361;
          j = 1;
          i = m;
          break label441;
          k = 1;
          break label520;
          m = 1;
          break label550;
          i2 = 1;
          break label572;
          i3 = 1;
          break label598;
          i4 = 1;
          break label615;
        }
        label1066:
        Object localObject = "";
        if (n != 0) {
          localObject = "" + getResources().getString(2131034279) + "\n";
        }
        paramAnonymousView = (View)localObject;
        if (i1 != 0) {
          paramAnonymousView = (String)localObject + getResources().getString(2131034280) + "\n";
        }
        if (k == 0)
        {
          localObject = paramAnonymousView;
          if (j == 0) {}
        }
        else
        {
          localObject = paramAnonymousView + getResources().getString(2131034278) + "\n";
        }
        paramAnonymousView = (View)localObject;
        if (m != 0) {
          paramAnonymousView = (String)localObject + getResources().getString(2131034283) + "\n";
        }
        localObject = paramAnonymousView;
        if (i2 != 0) {
          localObject = paramAnonymousView + getResources().getString(2131034281) + "\n";
        }
        paramAnonymousView = (View)localObject;
        if (i3 != 0) {
          paramAnonymousView = (String)localObject + getResources().getString(2131034276) + "\n";
        }
        localObject = paramAnonymousView;
        if (i4 != 0) {
          localObject = paramAnonymousView + getResources().getString(2131034286);
        }
        GetUserInformation.this.showDialogonclick((String)localObject);
      }
    });
    button_home.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), ServiceSelection.class);
        paramAnonymousView.addFlags(268468224);
        startActivity(paramAnonymousView);
      }
    });
  }
  
  public boolean isThisDateValid(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    paramString2 = new SimpleDateFormat(paramString2);
    paramString2.setLenient(false);
    try
    {
      paramString2.parse(paramString1);
      return true;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903051);
    intitalizeViews();
    pref = getSharedPreferences("ors", 0);
    editor = pref.edit();
    appointmentdate.setText(appointmentdate.getText() + pref.getString("date_name", ""));
    Object localObject = getIntent();
    location = ((Intent)localObject).getStringExtra("from");
    paramBundle = ((Intent)localObject).getStringExtra("name");
    localObject = ((Intent)localObject).getStringExtra("mono");
    if (location.equals("noaadhaar"))
    {
      fname.setEnabled(true);
      lname.setEnabled(true);
      mobile.setText((CharSequence)localObject);
      mobile.setEnabled(false);
    }
    if (location.equals("fromaadhaar"))
    {
      fname.setText(paramBundle.substring(0, paramBundle.indexOf(" ")));
      lname.setText(paramBundle.substring(paramBundle.indexOf(" "), paramBundle.length()));
      mobile.setText((CharSequence)localObject);
      name.setText(name.getText() + paramBundle);
      mobilenumber.setText(mobilenumber.getText() + (String)localObject);
      fname.setEnabled(false);
      lname.setEnabled(false);
      mobile.setEnabled(false);
    }
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/GetUserInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */