package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import com.aadhaar.auth.Verhoeff;
import in.gov.mgov.helper.Helper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

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
    button_home_page = ((ImageView)findViewById(2131296259));
    mhospital = ((Spinner)findViewById(2131296335));
    search_criteria = ((Spinner)findViewById(2131296343));
    enteredValue = ((EditText)findViewById(2131296344));
    btn_proceed = ((Button)findViewById(2131296273));
  }
  
  private void showMessage(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 1);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  private void updateView()
  {
    if (isConnected()) {
      new CallList(null).execute(new String[] { "getHospitallist" });
    }
    mhospital.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (paramAnonymousInt != 0)
        {
          hospitalname = mhospital.getSelectedItem().toString();
          hospitalcode = hospitalid[paramAnonymousInt];
        }
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    btn_proceed.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = 0;
        int n = 0;
        int j = 0;
        int k = 0;
        int i1 = 0;
        int i2 = search_criteria.getSelectedItemPosition();
        label72:
        int m;
        if (mhospital.getSelectedItemPosition() != 0)
        {
          i = 0 + 1;
          if (i2 != 0) {
            break label372;
          }
          if (enteredValue.getText().toString().length() != 13) {
            break label367;
          }
          i += 1;
          if (i2 != 1) {
            break label386;
          }
          if ((enteredValue.getText().toString().length() > 13) || (enteredValue.getText().toString().length() < 5)) {
            break label377;
          }
          m = i + 1;
          label124:
          if (i2 != 2) {
            break label405;
          }
          if (enteredValue.getText().toString().length() != 12) {
            break label400;
          }
          new Verhoeff();
          if (!Verhoeff.validateVerhoeff(enteredValue.getText().toString())) {
            break label395;
          }
          m += 1;
          i = i1;
          label187:
          i1 = m;
          if (i2 == 3) {
            if (enteredValue.getText().toString().length() != 10) {
              break label410;
            }
          }
        }
        label367:
        label372:
        label377:
        label386:
        label395:
        label400:
        label405:
        label410:
        for (i1 = m + 1;; i1 = m)
        {
          if (i1 != 2) {
            break label417;
          }
          new Intent(getApplicationContext(), CancelAppointment2.class);
          if (isConnected())
          {
            if (j == 0) {
              new CancelAppointment_1.CallList(CancelAppointment_1.this, null).execute(new String[] { "getAppointmentList", "byid" });
            }
            if (k == 0) {
              new CancelAppointment_1.CallList(CancelAppointment_1.this, null).execute(new String[] { "getAppointmentList", "byuhid" });
            }
            if (i == 0) {
              new CancelAppointment_1.CallList(CancelAppointment_1.this, null).execute(new String[] { "getAppointmentList", "byaadhaar" });
            }
          }
          return;
          n = 1;
          break;
          j = 1;
          break label72;
          j = 1;
          break label72;
          k = 1;
          m = i;
          break label124;
          k = 1;
          m = i;
          break label124;
          i = 1;
          break label187;
          i = 1;
          break label187;
          i = 1;
          break label187;
        }
        label417:
        Object localObject = "";
        if (n != 0) {
          localObject = "" + getResources().getString(2131034285) + "\n";
        }
        paramAnonymousView = (View)localObject;
        if (i2 == 0)
        {
          paramAnonymousView = (View)localObject;
          if (enteredValue.getText().toString().length() != 13) {
            paramAnonymousView = (String)localObject + getResources().getString(2131034275) + " " + enteredValue.getHint() + "\n";
          }
        }
        localObject = paramAnonymousView;
        if (i2 == 1)
        {
          if ((enteredValue.getText().toString().length() <= 13) && (enteredValue.getText().toString().length() >= 5)) {
            localObject = paramAnonymousView;
          }
        }
        else
        {
          paramAnonymousView = (View)localObject;
          if (i2 == 2)
          {
            if (enteredValue.getText().toString().length() == 12) {
              break label759;
            }
            paramAnonymousView = (String)localObject + getResources().getString(2131034275) + " " + enteredValue.getHint() + "\n";
          }
        }
        for (;;)
        {
          new Helper(CancelAppointment_1.this).showDialogonclick(paramAnonymousView);
          return;
          localObject = paramAnonymousView + getResources().getString(2131034275) + " " + enteredValue.getHint() + "\n";
          break;
          label759:
          paramAnonymousView = (View)localObject;
          if (enteredValue.getText().toString().length() == 12)
          {
            new Verhoeff();
            paramAnonymousView = (View)localObject;
            if (!Verhoeff.validateVerhoeff(enteredValue.getText().toString())) {
              paramAnonymousView = (String)localObject + getResources().getString(2131034277) + " " + enteredValue.getHint() + "\n";
            }
          }
        }
      }
    });
    button_home_page.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), ServiceSelection.class);
        paramAnonymousView.addFlags(268468224);
        startActivity(paramAnonymousView);
      }
    });
  }
  
  public boolean isConnected()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
      return true;
    }
    showMessage(getResources().getString(2131034274));
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903046);
    intializeViews();
    updateView();
    arraySpinner = new String[] { getResources().getString(2131034153), getResources().getString(2131034155), getResources().getString(2131034152) };
    paramBundle = new ArrayAdapter(this, 2130903050, arraySpinner);
    search_criteria.setAdapter(paramBundle);
    search_criteria.setSelection(2);
    search_criteria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = search_criteria.getSelectedItem().toString();
        if (paramAnonymousAdapterView.equals(getResources().getString(2131034153)))
        {
          enteredValue.setText("");
          enteredValue.setHint(getResources().getString(2131034136));
          enteredValue.setFilters(new InputFilter[] { new InputFilter.LengthFilter(13) });
          return;
        }
        if (paramAnonymousAdapterView.equals(getResources().getString(2131034155)))
        {
          enteredValue.setText("");
          enteredValue.setHint(getResources().getString(2131034330));
          enteredValue.setFilters(new InputFilter[] { new InputFilter.LengthFilter(13) });
          return;
        }
        if (paramAnonymousAdapterView.equals(getResources().getString(2131034152)))
        {
          enteredValue.setText("");
          enteredValue.setHint(getResources().getString(2131034326));
          enteredValue.setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
          return;
        }
        if (paramAnonymousAdapterView.equals(getResources().getString(2131034154)))
        {
          enteredValue.setText("");
          enteredValue.setHint(getResources().getString(2131034321));
          enteredValue.setFilters(new InputFilter[] { new InputFilter.LengthFilter(10) });
          return;
        }
        enteredValue.setHint("");
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
  }
  
  private class CallList
    extends AsyncTask<String, String, String>
  {
    List<String> aadhaar = new ArrayList();
    List<String> appdate = new ArrayList();
    List<String> appointment_id = new ArrayList();
    List<String> apptime = new ArrayList();
    List<String> deptname = new ArrayList();
    private ProgressDialog dlog;
    List<String> dob = new ArrayList();
    List<String> doctor = new ArrayList();
    List<String> email = new ArrayList();
    List<String> fathers_name = new ArrayList();
    String finalresp;
    List<String> gender = new ArrayList();
    List<String> hid = new ArrayList();
    List<String> hospitalname = new ArrayList();
    List<String> id = new ArrayList();
    List<String> list = new ArrayList();
    List<String> mobile_no = new ArrayList();
    List<String> p_address = new ArrayList();
    List<String> patient_name = new ArrayList();
    List<String> requestdate = new ArrayList();
    List<String> room_name = new ArrayList();
    List<String> status = new ArrayList();
    
    private CallList() {}
    
    private PropertyInfo addProperties(String paramString1, String paramString2, Object paramObject)
    {
      PropertyInfo localPropertyInfo = new PropertyInfo();
      localPropertyInfo.setName(paramString1);
      localPropertyInfo.setValue(paramString2);
      localPropertyInfo.setType(paramObject);
      return localPropertyInfo;
    }
    
    protected String doInBackground(String... paramVarArgs)
    {
      CancelAppointment_1.access$102(CancelAppointment_1.this, paramVarArgs[0]);
      Object localObject = new SoapObject("http://orsws/", METHOD);
      if (paramVarArgs.length > 1)
      {
        type = paramVarArgs[1];
        ((SoapObject)localObject).addProperty(addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
        if (!paramVarArgs[1].equals("byid")) {
          break label199;
        }
        ((SoapObject)localObject).addProperty(addProperties("appointmentid", enteredValue.getText().toString(), String.class));
        ((SoapObject)localObject).addProperty(addProperties("aadhaar", "0", String.class));
        ((SoapObject)localObject).addProperty(addProperties("hid", "0", String.class));
      }
      for (;;)
      {
        ((SoapObject)localObject).addProperty(addProperties("in_hospital_id", hospitalcode, String.class));
        paramVarArgs = new SoapSerializationEnvelope(110);
        paramVarArgs.setOutputSoapObject(localObject);
        localObject = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/services?wsdl", 60000);
        try
        {
          ((HttpTransportSE)localObject).call("http://orsws/", paramVarArgs);
          finalresp = ((SoapPrimitive)paramVarArgs.getResponse()).toString();
          return finalresp;
          label199:
          if (paramVarArgs[1].equals("byuhid"))
          {
            ((SoapObject)localObject).addProperty(addProperties("appointmentid", "0", String.class));
            ((SoapObject)localObject).addProperty(addProperties("aadhaar", "0", String.class));
            ((SoapObject)localObject).addProperty(addProperties("hid", enteredValue.getText().toString(), String.class));
            continue;
          }
          if (!paramVarArgs[1].equals("byaadhaar")) {
            continue;
          }
          ((SoapObject)localObject).addProperty(addProperties("appointmentid", "0", String.class));
          ((SoapObject)localObject).addProperty(addProperties("aadhaar", enteredValue.getText().toString(), String.class));
          ((SoapObject)localObject).addProperty(addProperties("hid", "0", String.class));
        }
        catch (Exception paramVarArgs)
        {
          for (;;)
          {
            runOnUiThread(new Runnable()
            {
              public void run()
              {
                CancelAppointment_1.this.showMessage(getResources().getString(2131034292));
              }
            });
          }
        }
      }
    }
    
    protected void onPostExecute(String paramString)
    {
      super.onPostExecute(paramString);
      if (dlog.isShowing()) {
        dlog.dismiss();
      }
      for (;;)
      {
        Object localObject;
        JSONObject localJSONObject;
        int j;
        try
        {
          paramString = new JSONObject(paramString);
          if (METHOD.equals("getHospitallist"))
          {
            list.clear();
            id.clear();
            localObject = paramString.optJSONArray("hospitallist");
            list.add(getResources().getString(2131034307));
            id.add("0");
            i = 0;
            if (i < ((JSONArray)localObject).length())
            {
              localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              list.add(localJSONObject.getString("hospitalname"));
              id.add(localJSONObject.getString("hospitalid"));
              i += 1;
              continue;
            }
            hospital = ((String[])list.toArray(new String[list.size()]));
            hospitalid = ((String[])id.toArray(new String[id.size()]));
            localObject = hospital;
            j = localObject.length;
            i = 0;
            break label1515;
            localObject = hospitalid;
            j = localObject.length;
            i = 0;
            break label1533;
            if (list.size() == 1) {
              runOnUiThread(new Runnable()
              {
                public void run()
                {
                  new Helper(getApplicationContext()).showDialogonclick(getResources().getString(2131034253));
                }
              });
            }
            mhospital.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, hospital));
          }
          else
          {
            if (!METHOD.equals("getAppointmentList")) {
              break label1551;
            }
            if (finalresp.equals("{\"appointmentlist\":[]}"))
            {
              CancelAppointment_1.this.showMessage(getResources().getString(2131034250));
              return;
            }
            paramString = paramString.optJSONArray("appointmentlist");
            i = 0;
            if (i >= paramString.length()) {
              break label1552;
            }
            localObject = paramString.getJSONObject(i);
            appdate.add(((JSONObject)localObject).getString("appointment_date"));
            hospitalname.add(mhospital.getSelectedItem().toString());
            deptname.add(((JSONObject)localObject).getString("dept_name"));
            if (((JSONObject)localObject).getString("is_cancel").equals("0")) {
              status.add("<font color=\"#3F51B5\">View</font>");
            }
            if (((JSONObject)localObject).getString("is_cancel").equals("1")) {
              status.add("Cancelled");
            }
            if (((JSONObject)localObject).getString("is_cancel").equals("2")) {
              status.add("Expired");
            }
            patient_name.add(((JSONObject)localObject).getString("patient_name"));
            fathers_name.add(((JSONObject)localObject).getString("fathers_name"));
            email.add(((JSONObject)localObject).getString("email"));
            room_name.add(((JSONObject)localObject).getString("room_name"));
            dob.add(((JSONObject)localObject).getString("dob"));
            doctor.add(((JSONObject)localObject).getString("doctor_name"));
            aadhaar.add(((JSONObject)localObject).getString("aadhaar_id"));
            hid.add(((JSONObject)localObject).getString("hid"));
            requestdate.add(((JSONObject)localObject).getString("appointment_req_date"));
            apptime.add(((JSONObject)localObject).getString("app_time_str"));
            aadhaar.add(((JSONObject)localObject).getString("aadhaar_id"));
            if (((JSONObject)localObject).getString("gender").equals("0")) {
              gender.add("Other");
            }
            if (((JSONObject)localObject).getString("gender").equals("1")) {
              gender.add("Male");
            }
            if (((JSONObject)localObject).getString("gender").equals("2")) {
              gender.add("Female");
            }
            p_address.add(((JSONObject)localObject).getString("p_address"));
            appointment_id.add(((JSONObject)localObject).getString("appointment_id"));
            mobile_no.add(((JSONObject)localObject).getString("mobile_no"));
            i += 1;
            continue;
            if (i < appdate.size())
            {
              i += 1;
              continue;
            }
            resAppdates = ((String[])appdate.toArray(new String[appdate.size()]));
            reshospitals = ((String[])hospitalname.toArray(new String[appdate.size()]));
            resDepts = ((String[])deptname.toArray(new String[appdate.size()]));
            resStatus = ((String[])status.toArray(new String[appdate.size()]));
            resPatientname = ((String[])patient_name.toArray(new String[appdate.size()]));
            resfathers_name = ((String[])fathers_name.toArray(new String[appdate.size()]));
            resEmail = ((String[])email.toArray(new String[appdate.size()]));
            resRoom_name = ((String[])room_name.toArray(new String[appdate.size()]));
            resDOB = ((String[])dob.toArray(new String[appdate.size()]));
            resGender = ((String[])gender.toArray(new String[appdate.size()]));
            resP_address = ((String[])p_address.toArray(new String[appdate.size()]));
            resAppointment_id = ((String[])appointment_id.toArray(new String[appdate.size()]));
            resMobileNo = ((String[])mobile_no.toArray(new String[appdate.size()]));
            resDoctor = ((String[])doctor.toArray(new String[appdate.size()]));
            resAadhaar = ((String[])aadhaar.toArray(new String[appdate.size()]));
            reshid = ((String[])hid.toArray(new String[appdate.size()]));
            resRequestDate = ((String[])requestdate.toArray(new String[appdate.size()]));
            resApptime = ((String[])apptime.toArray(new String[appdate.size()]));
            runOnUiThread(new Runnable()
            {
              public void run()
              {
                Intent localIntent = new Intent(getApplicationContext(), CancelAppointment2.class);
                localIntent.putExtra("type", type);
                localIntent.putExtra("appdates", resAppdates);
                localIntent.putExtra("hospitals", reshospitals);
                localIntent.putExtra("depts", resDepts);
                localIntent.putExtra("status", resStatus);
                localIntent.putExtra("patient_name", resPatientname);
                localIntent.putExtra("fathers_name", resfathers_name);
                localIntent.putExtra("email", resEmail);
                localIntent.putExtra("room_name", resRoom_name);
                localIntent.putExtra("dob", resDOB);
                localIntent.putExtra("gender", resGender);
                localIntent.putExtra("p_address", resP_address);
                localIntent.putExtra("appointment_id", resAppointment_id);
                localIntent.putExtra("mobile_no", resMobileNo);
                localIntent.putExtra("doctor", resDoctor);
                localIntent.putExtra("hosid", hospitalcode);
                localIntent.putExtra("aadhaar", resAadhaar);
                localIntent.putExtra("hid", reshid);
                localIntent.putExtra("requestdate", resRequestDate);
                localIntent.putExtra("apptime", resApptime);
                localIntent.putExtra("value", enteredValue.getText().toString());
                startActivity(localIntent);
              }
            });
            return;
          }
        }
        catch (JSONException paramString)
        {
          CancelAppointment_1.this.showMessage(getResources().getString(2131034288));
          return;
        }
        label1515:
        while (i < j)
        {
          localJSONObject = localObject[i];
          i += 1;
        }
        continue;
        label1533:
        while (i < j)
        {
          localJSONObject = localObject[i];
          i += 1;
        }
        continue;
        label1551:
        return;
        label1552:
        int i = 0;
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(CancelAppointment_1.this);
      dlog.setTitle(getResources().getString(2131034289));
      dlog.setMessage(getResources().getString(2131034206));
      if (Build.VERSION.SDK_INT >= 11)
      {
        dlog.setProgressStyle(1);
        dlog.setIndeterminate(true);
        dlog.setProgressNumberFormat(null);
        dlog.setProgressPercentFormat(null);
      }
      dlog.setCancelable(false);
      dlog.show();
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/CancelAppointment_1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */