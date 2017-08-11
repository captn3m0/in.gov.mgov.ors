package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import in.gov.mgov.helper.GetStateData;
import in.gov.mgov.helper.Helper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

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
  List<String> id = new ArrayList();
  ImageView image;
  List<String> list = new ArrayList();
  Spinner mdate;
  TextView mno;
  TextView mobilenumbertext;
  TextView name;
  TextView no;
  SharedPreferences pref;
  int statecode;
  String[] uidData;
  Button yes;
  
  private void intitalizeViews()
  {
    name = ((TextView)findViewById(2131296449));
    dob = ((TextView)findViewById(2131296450));
    gender = ((TextView)findViewById(2131296451));
    mno = ((TextView)findViewById(2131296452));
    address = ((TextView)findViewById(2131296455));
    datepref = ((TextView)findViewById(2131296262));
    mdate = ((Spinner)findViewById(2131296338));
    hostpital_state = ((TextView)findViewById(2131296260));
    department = ((TextView)findViewById(2131296261));
    aadhaar = ((TextView)findViewById(2131296448));
    image = ((ImageView)findViewById(2131296447));
    yes = ((Button)findViewById(2131296341));
    no = ((TextView)findViewById(2131296456));
    button_home = ((ImageView)findViewById(2131296259));
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
  
  private void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getResources().getString(2131034183));
    localBuilder.setMessage(paramString).setCancelable(false).setPositiveButton(getResources().getString(2131034259), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Intent localIntent = new Intent(getApplicationContext(), ServiceSelection.class);
        localIntent.addFlags(268468224);
        startActivity(localIntent);
        paramAnonymousDialogInterface.cancel();
      }
    });
    localBuilder.create().show();
  }
  
  private void showMessage(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 0);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  private void updateView()
  {
    ((TextView)findViewById(2131296258)).setText(pref.getString("source", ""));
    statecode = Integer.parseInt(pref.getString("state_code", "0"));
    departmentcode = Integer.parseInt(pref.getString("dept_code", "0"));
    hospitalcode = Integer.parseInt(pref.getString("hospital_code", "0"));
    appdate = pref.getString("date_name", "0");
    hostpital_state.setText(hostpital_state.getText() + pref.getString("hospital_name", "") + ", " + pref.getString("state_name", ""));
    department.setText(department.getText() + pref.getString("dept_name", ""));
    aadhaar.setText(getResources().getString(2131034114) + ": " + pref.getString("aadhaar_no", ""));
    datepref.setText(getResources().getString(2131034133) + ": " + pref.getString("date_name", ""));
    if (pref.getString("aadhaar_no", "").equals("")) {
      aadhaar.setVisibility(8);
    }
    Intent localIntent = getIntent();
    uidData = localIntent.getStringArrayExtra("uid_data");
    aadhaarno = localIntent.getStringExtra("aaddhaarid");
    name.setText(getResources().getString(2131034243) + " " + uidData[0]);
    dob.setText(getResources().getString(2131034180) + ": " + uidData[1]);
    gender.setText(getResources().getString(2131034211) + ": " + uidData[2]);
    mno.setText(getResources().getString(2131034230) + ": " + uidData[3]);
    aadhaar.setText(getResources().getString(2131034114) + ": " + aadhaarno);
    image.setVisibility(8);
    address.setText(getResources().getString(2131034122) + ": " + uidData[5] + ", " + uidData[6]);
    yes.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (isConnected()) {
          new ShowUIDAIDataNonAadhaar.CallList(ShowUIDAIDataNonAadhaar.this, null).execute(new String[] { "fixAppointment" });
        }
      }
    });
    no.setOnClickListener(new View.OnClickListener()
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
    setContentView(2130903067);
    pref = getSharedPreferences("ors", 0);
    editor = pref.edit();
    intitalizeViews();
    updateView();
  }
  
  private class CallList
    extends AsyncTask<String, String, String>
  {
    private ProgressDialog dlog;
    
    private CallList() {}
    
    private PropertyInfo addProperties(String paramString, int paramInt, Object paramObject)
    {
      PropertyInfo localPropertyInfo = new PropertyInfo();
      localPropertyInfo.setName(paramString);
      localPropertyInfo.setValue(Integer.valueOf(paramInt));
      localPropertyInfo.setType(paramObject);
      return localPropertyInfo;
    }
    
    private PropertyInfo addProperties(String paramString, Boolean paramBoolean, Object paramObject)
    {
      PropertyInfo localPropertyInfo = new PropertyInfo();
      localPropertyInfo.setName(paramString);
      localPropertyInfo.setValue(paramBoolean);
      localPropertyInfo.setType(paramObject);
      return localPropertyInfo;
    }
    
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
      ShowUIDAIDataNonAadhaar.access$102(ShowUIDAIDataNonAadhaar.this, paramVarArgs[0]);
      Object localObject = new SoapObject("http://orsws/", METHOD);
      if (METHOD.equals("getAvailabledatelist"))
      {
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("hospitalid");
        paramVarArgs.setValue(Integer.valueOf(hospitalcode));
        paramVarArgs.setType(Integer.class);
        ((SoapObject)localObject).addProperty(paramVarArgs);
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("departmentid");
        paramVarArgs.setValue(Integer.valueOf(departmentcode));
        paramVarArgs.setType(Integer.class);
        ((SoapObject)localObject).addProperty(paramVarArgs);
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("appointmentcat");
        paramVarArgs.setValue(Integer.valueOf(0));
        paramVarArgs.setType(Integer.class);
        ((SoapObject)localObject).addProperty(paramVarArgs);
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("calmonth");
        paramVarArgs.setValue(Integer.valueOf(0));
        paramVarArgs.setType(Integer.class);
        ((SoapObject)localObject).addProperty(paramVarArgs);
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("inToken");
        paramVarArgs.setValue("dG9rZW5Ad2ViQGFwcG9pbnQjbmlj");
        paramVarArgs.setType(String.class);
        ((SoapObject)localObject).addProperty(paramVarArgs);
      }
      if (METHOD.equals("fixAppointment"))
      {
        paramVarArgs = "0";
        if (uidData[2].equals("Male")) {
          paramVarArgs = "1";
        }
        if (uidData[2].equals("Female")) {
          paramVarArgs = "2";
        }
        String str1 = uidData[5];
        String str2 = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String str4 = uidData[1];
        int i = Integer.parseInt(str4.substring(str4.length() - 4, str4.length()));
        int j = Integer.parseInt(str2.substring(str2.length() - 4, str2.length()));
        str2 = str4.substring(str4.length() - 4, str4.length());
        String str3 = str4.substring(str4.length() - 7, str4.length() - 5);
        str4 = str4.substring(0, 2);
        String str5 = j - i + "";
        ((SoapObject)localObject).addProperty(addProperties("flagtp", 1, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
        ((SoapObject)localObject).addProperty(addProperties("inpatientname", uidData[0].replaceAll(" ", "^"), String.class));
        ((SoapObject)localObject).addProperty(addProperties("ingender", paramVarArgs, String.class));
        ((SoapObject)localObject).addProperty(addProperties("inpaddress", str1, String.class));
        ((SoapObject)localObject).addProperty(addProperties("indob", str2 + "-" + str3 + "-" + str4, String.class));
        ((SoapObject)localObject).addProperty(addProperties("instatecode", new GetStateData().getStateCode(uidData[(uidData.length - 1)]), Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("incountrycode", 91, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("inmobileno", uidData[3], String.class));
        ((SoapObject)localObject).addProperty(addProperties("inemail", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("inbillingtype", 1, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("inreligion", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("inhospitalid", hospitalcode, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("inentfrom", "0.0.0.0", String.class));
        ((SoapObject)localObject).addProperty(addProperties("infathername", uidData[4], String.class));
        ((SoapObject)localObject).addProperty(addProperties("inmothername", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("inpatrelstr", "c/o", String.class));
        ((SoapObject)localObject).addProperty(addProperties("inbplverifiedby", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("inothersdetails", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("injaildetails", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("incghscardno", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("inage", str5 + " years", String.class));
        ((SoapObject)localObject).addProperty(addProperties("newfollowup", "0", String.class));
        ((SoapObject)localObject).addProperty(addProperties("birthorder", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("parity", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("gravida", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("pragnancyindicator", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("durationofpragnancy", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("prvregno", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("inaadhaarId", aadhaarno, String.class));
        ((SoapObject)localObject).addProperty(addProperties("inaadhaarImg", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("hosid", hospitalcode, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("deptid", departmentcode, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("unitid", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("clinicid", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("roomid", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("docid", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("appdate", appdate, String.class));
        ((SoapObject)localObject).addProperty(addProperties("regno", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("tmpappid", "0", String.class));
        ((SoapObject)localObject).addProperty(addProperties("uid", 99999, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("entsystem", "0.0.0.0", String.class));
        ((SoapObject)localObject).addProperty(addProperties("apptype", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("appcat", 0, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("apptimestr", "8 AM", String.class));
        ((SoapObject)localObject).addProperty(addProperties("isautodoc", "Y", String.class));
        ((SoapObject)localObject).addProperty(addProperties("iswithuhid", "N", String.class));
        ((SoapObject)localObject).addProperty(addProperties("contextPath", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("mblno", uidData[3], String.class));
        ((SoapObject)localObject).addProperty(addProperties("email", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("ispayonline", Boolean.valueOf(false), Boolean.class));
        ((SoapObject)localObject).addProperty(addProperties("hid", "", String.class));
        ((SoapObject)localObject).addProperty(addProperties("hidavailable", "", String.class));
      }
      paramVarArgs = new SoapSerializationEnvelope(110);
      paramVarArgs.setOutputSoapObject(localObject);
      localObject = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/services?wsdl", 60000);
      try
      {
        ((HttpTransportSE)localObject).call("http://orsws/", paramVarArgs);
        paramVarArgs = (SoapPrimitive)paramVarArgs.getResponse();
        finalresp = paramVarArgs.toString();
        return finalresp;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          new Helper(ShowUIDAIDataNonAadhaar.this).showDialogonclick(getResources().getString(2131034252));
        }
      }
    }
    
    protected void onPostExecute(final String paramString)
    {
      super.onPostExecute(paramString);
      if (dlog.isShowing()) {
        dlog.dismiss();
      }
      for (;;)
      {
        int j;
        try
        {
          paramString = new JSONObject(paramString);
          Object localObject;
          if (METHOD.equals("getAvailabledatelist"))
          {
            list.clear();
            id.clear();
            localObject = new JSONObject(paramString.get("data").toString()).optJSONArray("calenderData");
            list.add(getResources().getString(2131034302));
            id.add("0");
            j = 0;
            if (j < ((JSONArray)localObject).length())
            {
              int i = 0;
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
              if (localJSONObject.getString("flag").equals("4")) {
                i = 1;
              }
              if (localJSONObject.getString("flag").equals("2")) {
                i = 1;
              }
              if (i == 0) {
                list.add(localJSONObject.getString("app_date_"));
              }
            }
            else
            {
              date = ((String[])list.toArray(new String[list.size()]));
            }
          }
          else
          {
            if (!METHOD.equals("fixAppointment")) {
              break;
            }
            if (finalresp.equals("{}")) {
              ShowUIDAIDataNonAadhaar.this.showDialogonclick(getResources().getString(2131034334));
            }
            if (paramString.getString("error_code").equals("0"))
            {
              localObject = new Intent(getApplicationContext(), ShowAppointmentNoNumber.class);
              ((Intent)localObject).putExtra("uid_data", uidData);
              editor.putString("appointment_id", paramString.getString("appointment_id")).commit();
              editor.putString("hid_data", paramString.getString("hid")).commit();
              startActivity((Intent)localObject);
              return;
            }
            runOnUiThread(new Runnable()
            {
              public void run()
              {
                try
                {
                  ShowUIDAIDataNonAadhaar.this.showDialogonclick(paramString.getString("error_string"));
                  return;
                }
                catch (JSONException localJSONException)
                {
                  localJSONException.printStackTrace();
                }
              }
            });
            return;
          }
        }
        catch (JSONException paramString)
        {
          new Helper(ShowUIDAIDataNonAadhaar.this).showDialogonclick(getResources().getString(2131034158));
          return;
        }
        j += 1;
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(ShowUIDAIDataNonAadhaar.this);
      dlog.setTitle(getResources().getString(2131034289));
      dlog.setMessage(getResources().getString(2131034207));
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


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/ShowUIDAIDataNonAadhaar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */