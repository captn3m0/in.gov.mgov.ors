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
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
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

public class LabReport_1
  extends Activity
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/labservices?wsdl";
  private String METHOD = "";
  String OTP = "";
  String[] Res_Collecteddate;
  String[] Res_daily_sampleno_str;
  String[] Res_report_id;
  String[] Res_report_year;
  String[] Res_sample_no;
  String[] Res_sample_type_desc;
  String[] Res_sample_year;
  String[] Res_test_name;
  TextView button_no_reg_mobileno;
  Button button_submit;
  String dob;
  EditText edittext_uhid;
  String fathers_name;
  String guardian_rel;
  String[] hospital;
  String hospitalcode;
  String[] hospitalid;
  String hospitalname;
  int maxTriesforOTP = 0;
  String p_address;
  String p_fname;
  String p_initial;
  String p_lname;
  String p_mname;
  String p_mobile_no;
  String p_sex;
  Spinner spinner_select_hospital;
  
  private PropertyInfo addProperties(String paramString, int paramInt, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new PropertyInfo();
    localPropertyInfo.setName(paramString);
    localPropertyInfo.setValue(Integer.valueOf(paramInt));
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
  
  private void intializeViews()
  {
    spinner_select_hospital = ((Spinner)findViewById(2131296406));
    edittext_uhid = ((EditText)findViewById(2131296407));
    button_submit = ((Button)findViewById(2131296269));
    button_no_reg_mobileno = ((TextView)findViewById(2131296411));
  }
  
  private void showDialogonclickExtra(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getResources().getString(2131034183));
    localBuilder.setMessage(paramString).setCancelable(false).setPositiveButton(getResources().getString(2131034259), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent(getApplicationContext(), ServiceSelection.class);
        paramAnonymousDialogInterface.addFlags(268468224);
        startActivity(paramAnonymousDialogInterface);
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
  
  private void showMessageLong(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 1);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  private void updateView()
  {
    ((Button)findViewById(2131296410)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        onBackPressed();
      }
    });
    if (isConnected()) {
      new CallList(null).execute(new String[] { "getHospitalList" });
    }
    ((ImageView)findViewById(2131296259)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), ServiceSelection.class);
        paramAnonymousView.addFlags(268468224);
        startActivity(paramAnonymousView);
      }
    });
    button_submit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new Intent(LabReport_1.this, LabReport_2.class);
        if (spinner_select_hospital.getSelectedItemPosition() != 0)
        {
          if ((edittext_uhid.getText().length() >= 5) && (edittext_uhid.getText().length() <= 13))
          {
            if (isConnected())
            {
              hospitalcode = hospitalid[spinner_select_hospital.getSelectedItemPosition()];
              new LabReport_1.CallList(LabReport_1.this, null).execute(new String[] { "getLabbasicreportlist" });
            }
            return;
          }
          if (edittext_uhid.getText().length() == 0)
          {
            LabReport_1.this.showMessage(getResources().getString(2131034192));
            return;
          }
          LabReport_1.this.showMessage(getResources().getString(2131034187));
          return;
        }
        LabReport_1.this.showMessage(getResources().getString(2131034299));
      }
    });
    button_no_reg_mobileno.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        finish();
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
    setContentView(2130903053);
    intializeViews();
    updateView();
  }
  
  private class CallList
    extends AsyncTask<String, String, String>
  {
    List<String> Collecteddate = new ArrayList();
    List<String> daily_sampleno_str = new ArrayList();
    private ProgressDialog dlog;
    String finalresp;
    List<String> id = new ArrayList();
    List<String> list = new ArrayList();
    List<String> report_id = new ArrayList();
    List<String> report_year = new ArrayList();
    List<String> sample_no = new ArrayList();
    List<String> sample_type_desc = new ArrayList();
    List<String> sample_year = new ArrayList();
    List<String> test_name = new ArrayList();
    
    private CallList() {}
    
    protected String doInBackground(String... paramVarArgs)
    {
      LabReport_1.access$202(LabReport_1.this, paramVarArgs[0]);
      SoapObject localSoapObject = new SoapObject("http://orsws/", METHOD);
      if (METHOD.equals("getHospitalList")) {
        localSoapObject.addProperty(LabReport_1.this.addProperties("in_token", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
      }
      if (METHOD.equals("getLabbasicreportlist"))
      {
        localSoapObject.addProperty(LabReport_1.this.addProperties("in_token", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
        localSoapObject.addProperty(LabReport_1.this.addProperties("hos_id", Integer.valueOf(hospitalcode).intValue(), Integer.class));
        localSoapObject.addProperty(LabReport_1.this.addProperties("uhid", edittext_uhid.getText().toString(), String.class));
      }
      if (paramVarArgs[0].equals("getRawOTP"))
      {
        localSoapObject.addProperty(LabReport_1.this.addProperties("mobileno", p_mobile_no, String.class));
        localSoapObject.addProperty(LabReport_1.this.addProperties("userid", "mobileappors", String.class));
        localSoapObject.addProperty(LabReport_1.this.addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
      }
      SoapSerializationEnvelope localSoapSerializationEnvelope = new SoapSerializationEnvelope(110);
      localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
      if (paramVarArgs[0].equals("getRawOTP")) {
        paramVarArgs = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/services?wsdl", 60000);
      }
      try
      {
        for (;;)
        {
          paramVarArgs.call("http://orsws/", localSoapSerializationEnvelope);
          finalresp = ((SoapPrimitive)localSoapSerializationEnvelope.getResponse()).toString();
          return finalresp;
          paramVarArgs = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/labservices?wsdl", 60000);
        }
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          runOnUiThread(new Runnable()
          {
            public void run()
            {
              LabReport_1.this.showMessage(getResources().getString(2131034292));
            }
          });
          paramVarArgs.printStackTrace();
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
        int i;
        JSONObject localJSONObject;
        int j;
        try
        {
          paramString = new JSONObject(paramString);
          if (METHOD.equals("getHospitalList"))
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
            break label1930;
            localObject = hospitalid;
            j = localObject.length;
            i = 0;
            break label1948;
            if (list.size() == 1) {
              runOnUiThread(new Runnable()
              {
                public void run()
                {
                  new Helper(getApplicationContext()).showDialogonclick(getResources().getString(2131034253));
                }
              });
            }
            spinner_select_hospital.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, hospital));
          }
          if (METHOD.equals("getLabbasicreportlist"))
          {
            localObject = new JSONObject(paramString.toString());
            if (!((JSONObject)localObject).getString("status").equals("1")) {
              continue;
            }
            localJSONObject = new JSONObject(paramString.get("demographicData").toString());
            p_mname = localJSONObject.getString("p_mname");
            fathers_name = localJSONObject.getString("fathers_name");
            guardian_rel = localJSONObject.getString("guardian_rel");
            p_sex = localJSONObject.getString("p_sex");
            p_lname = localJSONObject.getString("p_lname");
            p_fname = localJSONObject.getString("p_fname");
            dob = localJSONObject.getString("dob");
            p_address = localJSONObject.getString("p_address");
            p_mobile_no = localJSONObject.getString("p_mobile_no");
            p_initial = localJSONObject.getString("p_initial");
            localObject = new JSONObject(((JSONObject)localObject).get("labData").toString());
            if (!((JSONObject)localObject).getString("isReportFound").equals("Y")) {
              continue;
            }
            localObject = ((JSONObject)localObject).optJSONArray("ReportHeadList");
            i = 0;
            if (i < ((JSONArray)localObject).length())
            {
              localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              sample_type_desc.add(localJSONObject.getString("sample_type_desc"));
              sample_year.add(localJSONObject.getString("sample_year"));
              report_year.add(localJSONObject.getString("report_year"));
              daily_sampleno_str.add(localJSONObject.getString("daily_sampleno_str"));
              test_name.add(localJSONObject.getString("test_name"));
              sample_no.add(localJSONObject.getString("sample_no"));
              report_id.add(localJSONObject.getString("report_id"));
              Collecteddate.add(localJSONObject.getString("Collecteddate"));
              i += 1;
              continue;
            }
            Res_sample_type_desc = ((String[])sample_type_desc.toArray(new String[sample_type_desc.size()]));
            Res_sample_year = ((String[])sample_year.toArray(new String[sample_type_desc.size()]));
            Res_report_year = ((String[])report_year.toArray(new String[sample_type_desc.size()]));
            Res_daily_sampleno_str = ((String[])daily_sampleno_str.toArray(new String[sample_type_desc.size()]));
            Res_test_name = ((String[])test_name.toArray(new String[sample_type_desc.size()]));
            Res_sample_no = ((String[])sample_no.toArray(new String[sample_type_desc.size()]));
            Res_report_id = ((String[])report_id.toArray(new String[sample_type_desc.size()]));
            Res_Collecteddate = ((String[])Collecteddate.toArray(new String[sample_type_desc.size()]));
            localObject = new Intent(LabReport_1.this, LabReport_2.class);
            ((Intent)localObject).putExtra("p_mname", p_mname);
            ((Intent)localObject).putExtra("fathers_name", fathers_name);
            ((Intent)localObject).putExtra("guardian_rel", guardian_rel);
            ((Intent)localObject).putExtra("p_sex", p_sex);
            ((Intent)localObject).putExtra("p_lname", p_lname);
            ((Intent)localObject).putExtra("p_fname", p_fname);
            ((Intent)localObject).putExtra("dob", dob);
            ((Intent)localObject).putExtra("p_address", p_address);
            ((Intent)localObject).putExtra("p_mobile_no", p_mobile_no);
            ((Intent)localObject).putExtra("p_initial", p_initial);
            ((Intent)localObject).putExtra("Res_sample_type_desc", Res_sample_type_desc);
            ((Intent)localObject).putExtra("Res_sample_year", Res_sample_year);
            ((Intent)localObject).putExtra("Res_report_year", Res_report_year);
            ((Intent)localObject).putExtra("Res_daily_sampleno_str", Res_daily_sampleno_str);
            ((Intent)localObject).putExtra("Res_test_name", Res_test_name);
            ((Intent)localObject).putExtra("Res_sample_no", Res_sample_no);
            ((Intent)localObject).putExtra("Res_report_id", Res_report_id);
            ((Intent)localObject).putExtra("uhid", edittext_uhid.getText().toString());
            ((Intent)localObject).putExtra("Res_Collecteddate", Res_Collecteddate);
            ((Intent)localObject).putExtra("hospital", spinner_select_hospital.getSelectedItem().toString());
            ((Intent)localObject).putExtra("hosid", hospitalcode);
            ((Intent)localObject).putExtra("OTP", OTP);
            startActivity((Intent)localObject);
          }
        }
        catch (JSONException paramString)
        {
          LabReport_1.this.showMessage(getResources().getString(2131034288));
          return;
          LabReport_1.this.showMessageLong(getResources().getString(2131034197));
          continue;
        }
        catch (Exception paramString)
        {
          LabReport_1.this.showMessage(getResources().getString(2131034332));
          return;
        }
        if ((!METHOD.equalsIgnoreCase("getRawOTP")) || (!paramString.getString("status").equalsIgnoreCase("Y"))) {
          break;
        }
        OTP = paramString.getString("data");
        paramString = new Intent(LabReport_1.this, LabReport_2.class);
        paramString.putExtra("p_mname", p_mname);
        paramString.putExtra("fathers_name", fathers_name);
        paramString.putExtra("guardian_rel", guardian_rel);
        paramString.putExtra("p_sex", p_sex);
        paramString.putExtra("p_lname", p_lname);
        paramString.putExtra("p_fname", p_fname);
        paramString.putExtra("dob", dob);
        paramString.putExtra("p_address", p_address);
        paramString.putExtra("p_mobile_no", p_mobile_no);
        paramString.putExtra("p_initial", p_initial);
        paramString.putExtra("Res_sample_type_desc", Res_sample_type_desc);
        paramString.putExtra("Res_sample_year", Res_sample_year);
        paramString.putExtra("Res_report_year", Res_report_year);
        paramString.putExtra("Res_daily_sampleno_str", Res_daily_sampleno_str);
        paramString.putExtra("Res_test_name", Res_test_name);
        paramString.putExtra("Res_sample_no", Res_sample_no);
        paramString.putExtra("Res_report_id", Res_report_id);
        paramString.putExtra("uhid", edittext_uhid.getText().toString());
        paramString.putExtra("Res_Collecteddate", Res_Collecteddate);
        paramString.putExtra("hospital", spinner_select_hospital.getSelectedItem().toString());
        paramString.putExtra("hosid", hospitalcode);
        paramString.putExtra("OTP", OTP);
        startActivity(paramString);
        return;
        LabReport_1.this.showMessageLong(getResources().getString(2131034324) + ": " + edittext_uhid.getText().toString());
        continue;
        label1930:
        while (i < j)
        {
          localJSONObject = localObject[i];
          i += 1;
        }
        continue;
        label1948:
        while (i < j)
        {
          localJSONObject = localObject[i];
          i += 1;
        }
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(LabReport_1.this);
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
  
  private class CallListSecond
    extends AsyncTask<String, String, String>
  {
    private ProgressDialog dlog;
    String finalresp;
    
    private CallListSecond() {}
    
    protected String doInBackground(String... paramVarArgs)
    {
      LabReport_1.access$202(LabReport_1.this, paramVarArgs[0]);
      Object localObject = new SoapObject("http://orsws/", METHOD);
      if (paramVarArgs[0].equals("getRawOTP"))
      {
        ((SoapObject)localObject).addProperty(LabReport_1.this.addProperties("mobileno", p_mobile_no, String.class));
        ((SoapObject)localObject).addProperty(LabReport_1.this.addProperties("userid", "mobileappors", String.class));
        ((SoapObject)localObject).addProperty(LabReport_1.this.addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
      }
      paramVarArgs = new SoapSerializationEnvelope(110);
      paramVarArgs.setOutputSoapObject(localObject);
      localObject = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/services?wsdl", 60000);
      try
      {
        ((HttpTransportSE)localObject).call("http://orsws/", paramVarArgs);
        finalresp = ((SoapPrimitive)paramVarArgs.getResponse()).toString();
        return finalresp;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          runOnUiThread(new Runnable()
          {
            public void run()
            {
              LabReport_1.this.showMessage(getResources().getString(2131034332));
            }
          });
        }
      }
    }
    
    protected void onPostExecute(String paramString)
    {
      super.onPostExecute(paramString);
      if (dlog.isShowing()) {
        dlog.dismiss();
      }
      try
      {
        paramString = new JSONObject(paramString);
        if (METHOD.equalsIgnoreCase("getRawOTP"))
        {
          OTP = paramString.getString("data");
          LabReport_1.this.showMessage(getResources().getString(2131034262));
          paramString = LabReport_1.this;
          maxTriesforOTP += 1;
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(LabReport_1.this);
      dlog.setTitle(getResources().getString(2131034289));
      if (METHOD.equalsIgnoreCase("getRawOTP")) {
        dlog.setMessage(getResources().getString(2131034164));
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          dlog.setProgressStyle(1);
          dlog.setIndeterminate(true);
          dlog.setProgressNumberFormat(null);
          dlog.setProgressPercentFormat(null);
        }
        dlog.setCancelable(false);
        dlog.show();
        return;
        dlog.setMessage(getResources().getString(2131034206));
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/LabReport_1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */