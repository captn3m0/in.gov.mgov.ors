package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import nitesh.floatinghint.FloatingHintEditText;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class LabReport_2
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
  Button button_view_lab_reports;
  String dob;
  String fathers_name;
  String guardian_rel;
  String hospital;
  String hospitalcode;
  ImageView imageview_photo_id;
  int maxTriesforOTP = 0;
  String p_address;
  String p_fname;
  String p_initial;
  String p_lname;
  String p_mname;
  String p_mobile_no;
  String p_sex;
  TextView textview__age_data;
  TextView textview_address_data;
  TextView textview_gender_data;
  TextView textview_mobile_data;
  TextView textview_name_data;
  TextView textview_tital_info;
  TextView textview_uhid_data;
  String uhid;
  
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
    imageview_photo_id = ((ImageView)findViewById(2131296413));
    textview_uhid_data = ((TextView)findViewById(2131296414));
    textview_name_data = ((TextView)findViewById(2131296362));
    textview__age_data = ((TextView)findViewById(2131296363));
    textview_gender_data = ((TextView)findViewById(2131296364));
    textview_mobile_data = ((TextView)findViewById(2131296365));
    textview_address_data = ((TextView)findViewById(2131296415));
    button_view_lab_reports = ((Button)findViewById(2131296416));
    textview_tital_info = ((TextView)findViewById(2131296412));
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
    ((ImageView)findViewById(2131296259)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), ServiceSelection.class);
        paramAnonymousView.addFlags(268468224);
        startActivity(paramAnonymousView);
      }
    });
    textview_tital_info.setText(getResources().getString(2131034268) + " " + hospital);
    imageview_photo_id.setVisibility(8);
    textview_uhid_data.setText(getResources().getString(2131034329) + " " + uhid);
    textview_name_data.setText(getResources().getString(2131034243) + " " + p_initial + " " + p_fname + " " + p_lname);
    String str = new SimpleDateFormat("yyyy").format(new Date());
    int i = Integer.valueOf(dob.substring(dob.length() - 4, dob.length())).intValue();
    int j = Integer.valueOf(str).intValue();
    textview__age_data.setText(getResources().getString(2131034127) + " " + (j - i) + " " + getResources().getString(2131034340) + "  " + p_sex);
    textview_gender_data.setText(p_sex);
    textview_address_data.setText(getResources().getString(2131034122) + ": " + p_address);
    textview_mobile_data.setText(getResources().getString(2131034230) + ": XXXXXX" + p_mobile_no.substring(p_mobile_no.length() - 4, p_mobile_no.length()));
    button_view_lab_reports.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (isConnected()) {
          new LabReport_2.CallList(LabReport_2.this, null).execute(new String[] { "getRawOTP" });
        }
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
    setContentView(2130903054);
    paramBundle = getIntent();
    p_mname = paramBundle.getStringExtra("p_mname");
    fathers_name = paramBundle.getStringExtra("fathers_name");
    guardian_rel = paramBundle.getStringExtra("guardian_rel");
    p_sex = paramBundle.getStringExtra("p_sex");
    p_lname = paramBundle.getStringExtra("p_lname");
    p_fname = paramBundle.getStringExtra("p_fname");
    p_address = paramBundle.getStringExtra("p_address");
    p_mobile_no = paramBundle.getStringExtra("p_mobile_no");
    p_initial = paramBundle.getStringExtra("p_initial");
    dob = paramBundle.getStringExtra("dob");
    uhid = paramBundle.getStringExtra("uhid");
    hospital = paramBundle.getStringExtra("hospital");
    hospitalcode = paramBundle.getStringExtra("hosid");
    OTP = paramBundle.getStringExtra("OTP");
    Res_sample_type_desc = paramBundle.getStringArrayExtra("Res_sample_type_desc");
    Res_sample_year = paramBundle.getStringArrayExtra("Res_sample_year");
    Res_report_year = paramBundle.getStringArrayExtra("Res_report_year");
    Res_sample_no = paramBundle.getStringArrayExtra("Res_sample_no");
    Res_daily_sampleno_str = paramBundle.getStringArrayExtra("Res_daily_sampleno_str");
    Res_test_name = paramBundle.getStringArrayExtra("Res_test_name");
    Res_report_id = paramBundle.getStringArrayExtra("Res_report_id");
    Res_Collecteddate = paramBundle.getStringArrayExtra("Res_Collecteddate");
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
      LabReport_2.access$102(LabReport_2.this, paramVarArgs[0]);
      SoapObject localSoapObject = new SoapObject("http://orsws/", METHOD);
      if (paramVarArgs[0].equals("getRawOTP"))
      {
        localSoapObject.addProperty(LabReport_2.this.addProperties("mobileno", p_mobile_no, String.class));
        localSoapObject.addProperty(LabReport_2.this.addProperties("userid", "mobileappors", String.class));
        localSoapObject.addProperty(LabReport_2.this.addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
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
              LabReport_2.this.showMessage(getResources().getString(2131034292));
            }
          });
          paramVarArgs.printStackTrace();
        }
      }
    }
    
    protected void onPostExecute(final String paramString)
    {
      super.onPostExecute(paramString);
      if (dlog.isShowing()) {
        dlog.dismiss();
      }
      try
      {
        paramString = new JSONObject(paramString);
        if ((METHOD.equalsIgnoreCase("getRawOTP")) && (paramString.getString("status").equalsIgnoreCase("Y")))
        {
          OTP = paramString.getString("data");
          final Object localObject = new AlertDialog.Builder(LabReport_2.this);
          ((AlertDialog.Builder)localObject).setTitle(getResources().getString(2131034183));
          ((AlertDialog.Builder)localObject).setMessage(getResources().getString(2131034264) + ": XXXXXX" + p_mobile_no.substring(p_mobile_no.length() - 4, p_mobile_no.length()));
          paramString = new FloatingHintEditText(LabReport_2.this);
          paramString.setFilters(new InputFilter[] { new InputFilter.LengthFilter(5) });
          paramString.setHint(getResources().getString(2131034190));
          paramString.setInputType(2);
          ((AlertDialog.Builder)localObject).setView(paramString);
          ((AlertDialog.Builder)localObject).setPositiveButton(getResources().getString(2131034259), null);
          ((AlertDialog.Builder)localObject).setNegativeButton(getResources().getString(2131034156), null);
          ((AlertDialog.Builder)localObject).setNeutralButton(getResources().getString(2131034293), null);
          localObject = ((AlertDialog.Builder)localObject).create();
          ((AlertDialog)localObject).setOnShowListener(new DialogInterface.OnShowListener()
          {
            public void onShow(DialogInterface paramAnonymousDialogInterface)
            {
              paramAnonymousDialogInterface = localObject.getButton(-1);
              Button localButton1 = localObject.getButton(-2);
              Button localButton2 = localObject.getButton(-3);
              paramAnonymousDialogInterface.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymous2View)
                {
                  if (val$input.getText().toString().equals(OTP))
                  {
                    paramAnonymous2View = new Intent(LabReport_2.this, LabReport_3.class);
                    paramAnonymous2View.putExtra("p_mname", textview_name_data.getText().toString());
                    paramAnonymous2View.putExtra("fathers_name", fathers_name);
                    paramAnonymous2View.putExtra("guardian_rel", guardian_rel);
                    paramAnonymous2View.putExtra("p_sex", p_sex);
                    paramAnonymous2View.putExtra("p_lname", p_lname);
                    paramAnonymous2View.putExtra("p_fname", p_fname);
                    paramAnonymous2View.putExtra("dob", textview__age_data.getText().toString());
                    paramAnonymous2View.putExtra("p_address", p_address);
                    paramAnonymous2View.putExtra("p_mobile_no", p_mobile_no);
                    paramAnonymous2View.putExtra("p_initial", p_initial);
                    paramAnonymous2View.putExtra("Res_sample_type_desc", Res_sample_type_desc);
                    paramAnonymous2View.putExtra("Res_sample_year", Res_sample_year);
                    paramAnonymous2View.putExtra("Res_report_year", Res_report_year);
                    paramAnonymous2View.putExtra("Res_daily_sampleno_str", Res_daily_sampleno_str);
                    paramAnonymous2View.putExtra("Res_test_name", Res_test_name);
                    paramAnonymous2View.putExtra("Res_sample_no", Res_sample_no);
                    paramAnonymous2View.putExtra("Res_report_id", Res_report_id);
                    paramAnonymous2View.putExtra("Res_Collecteddate", Res_Collecteddate);
                    paramAnonymous2View.putExtra("hospital", hospital);
                    paramAnonymous2View.putExtra("hosid", hospitalcode);
                    paramAnonymous2View.putExtra("uhid", textview_uhid_data.getText().toString());
                    startActivity(paramAnonymous2View);
                    val$d.cancel();
                    return;
                  }
                  LabReport_2.this.showMessage(getResources().getString(2131034339));
                }
              });
              localButton1.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymous2View)
                {
                  val$d.cancel();
                }
              });
              localButton2.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymous2View)
                {
                  if (maxTriesforOTP < 3)
                  {
                    if (isConnected()) {
                      new LabReport_2.CallListSecond(LabReport_2.this, null).execute(new String[] { "getRawOTP", "resend" });
                    }
                    return;
                  }
                  LabReport_2.this.showDialogonclickExtra(getResources().getString(2131034204));
                }
              });
            }
          });
          ((AlertDialog)localObject).show();
        }
        return;
      }
      catch (JSONException paramString)
      {
        LabReport_2.this.showMessage(getResources().getString(2131034288));
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(LabReport_2.this);
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
      LabReport_2.access$102(LabReport_2.this, paramVarArgs[0]);
      Object localObject = new SoapObject("http://orsws/", METHOD);
      if (paramVarArgs[0].equals("getRawOTP"))
      {
        ((SoapObject)localObject).addProperty(LabReport_2.this.addProperties("mobileno", p_mobile_no, String.class));
        ((SoapObject)localObject).addProperty(LabReport_2.this.addProperties("userid", "mobileappors", String.class));
        ((SoapObject)localObject).addProperty(LabReport_2.this.addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
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
              LabReport_2.this.showMessage(getResources().getString(2131034292));
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
          LabReport_2.this.showMessage(getResources().getString(2131034262));
          paramString = LabReport_2.this;
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
      dlog = new ProgressDialog(LabReport_2.this);
      dlog.setTitle(getResources().getString(2131034289));
      dlog.setMessage(getResources().getString(2131034164));
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


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/LabReport_2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */