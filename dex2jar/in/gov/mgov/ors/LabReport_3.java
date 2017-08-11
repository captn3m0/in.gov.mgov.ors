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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class LabReport_3
  extends Activity
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/labservices?wsdl";
  public ArrayList<LabReportRowModel> CustomListViewValuesArr = new ArrayList();
  public LabReport_3 LabReportListView = null;
  private String METHOD = "";
  String[] Res_Collecteddate;
  String[] Res_daily_sampleno_str;
  String[] Res_report_id;
  String[] Res_report_year;
  String[] Res_sample_no;
  String[] Res_sample_type_desc;
  String[] Res_sample_year;
  String[] Res_test_name;
  LabreportAdapter adapter;
  String dob;
  String fathers_name;
  String guardian_rel;
  String hospital;
  String hospitalcode;
  ListView listview_report;
  String p_address;
  String p_fname;
  String p_initial;
  String p_lname;
  String p_mname;
  String p_mobile_no;
  String p_sex;
  int pos = 0;
  TextView textview__age_data;
  TextView textview_gender_data;
  TextView textview_name_data;
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
    textview_uhid_data = ((TextView)findViewById(2131296414));
    textview_name_data = ((TextView)findViewById(2131296418));
    textview__age_data = ((TextView)findViewById(2131296419));
    textview_gender_data = ((TextView)findViewById(2131296420));
    listview_report = ((ListView)findViewById(2131296421));
  }
  
  private void setListData()
  {
    int i = 0;
    while (i < Res_sample_type_desc.length)
    {
      LabReportRowModel localLabReportRowModel = new LabReportRowModel();
      localLabReportRowModel.setdate(Res_Collecteddate[i]);
      localLabReportRowModel.setsample_no(Res_daily_sampleno_str[i].substring(0, 4) + "...." + Res_daily_sampleno_str[i].substring(Res_daily_sampleno_str[i].length() - 3, Res_daily_sampleno_str[i].length()));
      localLabReportRowModel.settest(Res_test_name[i]);
      localLabReportRowModel.settype(Res_sample_type_desc[i]);
      CustomListViewValuesArr.add(localLabReportRowModel);
      i += 1;
    }
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
    textview_gender_data.setText(p_sex);
    textview_gender_data.setVisibility(8);
    textview__age_data.setText(dob);
    textview_name_data.setText(p_mname);
    textview_uhid_data.setText(uhid + "  " + getResources().getString(2131034215) + ": " + hospital);
    LabReportListView = this;
    setListData();
    Resources localResources = getResources();
    adapter = new LabreportAdapter(LabReportListView, CustomListViewValuesArr, localResources);
    listview_report.setAdapter(adapter);
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
    setContentView(2130903055);
    paramBundle = getIntent();
    Res_sample_type_desc = paramBundle.getStringArrayExtra("Res_sample_type_desc");
    Res_sample_year = paramBundle.getStringArrayExtra("Res_sample_year");
    Res_report_year = paramBundle.getStringArrayExtra("Res_report_year");
    Res_daily_sampleno_str = paramBundle.getStringArrayExtra("Res_daily_sampleno_str");
    Res_test_name = paramBundle.getStringArrayExtra("Res_test_name");
    Res_report_id = paramBundle.getStringArrayExtra("Res_report_id");
    Res_sample_no = paramBundle.getStringArrayExtra("Res_sample_no");
    Res_Collecteddate = paramBundle.getStringArrayExtra("Res_Collecteddate");
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
    intializeViews();
    updateView();
  }
  
  public void onItemClick(int paramInt)
  {
    LabReportRowModel localLabReportRowModel = (LabReportRowModel)CustomListViewValuesArr.get(paramInt);
    if (isConnected())
    {
      pos = paramInt;
      new CallList(null).execute(new String[] { "getLabReportDetails", paramInt + "" });
    }
  }
  
  private class CallList
    extends AsyncTask<String, String, String>
  {
    private ProgressDialog dlog;
    String finalresp;
    List<String> normal_range_lower = new ArrayList();
    List<String> normal_range_upper = new ArrayList();
    List<String> reamrks = new ArrayList();
    List<String> report_verified_by = new ArrayList();
    List<String> resultl = new ArrayList();
    List<String> sample_receive_date = new ArrayList();
    List<String> testName = new ArrayList();
    List<String> uhidl = new ArrayList();
    List<String> unit = new ArrayList();
    
    private CallList() {}
    
    protected String doInBackground(String... paramVarArgs)
    {
      LabReport_3.access$102(LabReport_3.this, paramVarArgs[0]);
      Object localObject = new SoapObject("http://orsws/", METHOD);
      if (paramVarArgs[0].equals("getLabReportDetails"))
      {
        ((SoapObject)localObject).addProperty(LabReport_3.this.addProperties("in_token", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
        ((SoapObject)localObject).addProperty(LabReport_3.this.addProperties("hos_id", Integer.valueOf(hospitalcode).intValue(), Integer.class));
        ((SoapObject)localObject).addProperty(LabReport_3.this.addProperties("reportID", Res_report_id[Integer.valueOf(paramVarArgs[1]).intValue()], String.class));
        ((SoapObject)localObject).addProperty(LabReport_3.this.addProperties("reportYR", Res_report_year[Integer.valueOf(paramVarArgs[1]).intValue()], String.class));
      }
      paramVarArgs = new SoapSerializationEnvelope(110);
      paramVarArgs.setOutputSoapObject(localObject);
      localObject = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/labservices?wsdl", 60000);
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
              LabReport_3.this.showMessage(getResources().getString(2131034292));
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
        if (METHOD.equalsIgnoreCase("getLabReportDetails"))
        {
          if (paramString.getString("status").equalsIgnoreCase("1"))
          {
            paramString = paramString.getString("detailedData");
            Intent localIntent = new Intent(getApplicationContext(), LabReprt_4_webview.class);
            localIntent.putExtra("unit", (String[])unit.toArray(new String[unit.size()]));
            localIntent.putExtra("resultl", (String[])resultl.toArray(new String[unit.size()]));
            localIntent.putExtra("testName", (String[])testName.toArray(new String[unit.size()]));
            localIntent.putExtra("normal_range_lower", (String[])normal_range_lower.toArray(new String[unit.size()]));
            localIntent.putExtra("reamrks", (String[])reamrks.toArray(new String[unit.size()]));
            localIntent.putExtra("sample_receive_date", (String[])sample_receive_date.toArray(new String[unit.size()]));
            localIntent.putExtra("uhid", uhid);
            localIntent.putExtra("normal_range_upper", (String[])normal_range_upper.toArray(new String[unit.size()]));
            localIntent.putExtra("report_verified_by", (String[])report_verified_by.toArray(new String[unit.size()]));
            localIntent.putExtra("name", textview_name_data.getText().toString());
            localIntent.putExtra("age", textview__age_data.getText().toString());
            localIntent.putExtra("sex", textview_gender_data.getText().toString());
            localIntent.putExtra("Res_sample_type_desc", Res_sample_type_desc[pos]);
            localIntent.putExtra("Res_sample_year", Res_sample_year[pos]);
            localIntent.putExtra("Res_report_year", Res_report_year[pos]);
            localIntent.putExtra("Res_daily_sampleno_str", Res_daily_sampleno_str[pos]);
            localIntent.putExtra("Res_test_name", Res_test_name[pos]);
            localIntent.putExtra("Res_sample_no", Res_sample_no[pos]);
            localIntent.putExtra("Res_report_id", Res_report_id[pos]);
            localIntent.putExtra("Res_Collecteddate", Res_Collecteddate[pos]);
            localIntent.putExtra("webdata", paramString);
            startActivity(localIntent);
            return;
          }
          LabReport_3.this.showMessage(getResources().getString(2131034250));
          return;
        }
      }
      catch (JSONException paramString)
      {
        LabReport_3.this.showMessage(getResources().getString(2131034288));
        return;
      }
      catch (Exception paramString)
      {
        LabReport_3.this.showMessage(getResources().getString(2131034288));
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(LabReport_3.this);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/LabReport_3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */