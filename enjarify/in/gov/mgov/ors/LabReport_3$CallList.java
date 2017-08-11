package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

class LabReport_3$CallList
  extends AsyncTask
{
  private ProgressDialog dlog;
  String finalresp;
  List normal_range_lower;
  List normal_range_upper;
  List reamrks;
  List report_verified_by;
  List resultl;
  List sample_receive_date;
  List testName;
  List uhidl;
  List unit;
  
  private LabReport_3$CallList(LabReport_3 paramLabReport_3)
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    unit = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    resultl = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    testName = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    normal_range_lower = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    reamrks = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    sample_receive_date = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    uhidl = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    normal_range_upper = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    report_verified_by = localArrayList;
  }
  
  protected String doInBackground(String... paramVarArgs)
  {
    int i = 1;
    int j = 0;
    Object localObject1 = null;
    localObject2 = this$0;
    localObject3 = paramVarArgs[0];
    LabReport_3.access$102((LabReport_3)localObject2, (String)localObject3);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localObject3 = LabReport_3.access$100(this$0);
    localSoapObject.<init>("http://orsws/", (String)localObject3);
    localObject2 = paramVarArgs[0];
    localObject3 = "getLabReportDetails";
    boolean bool = ((String)localObject2).equals(localObject3);
    if (bool)
    {
      localObject2 = LabReport_3.access$200(this$0, "in_token", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class);
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject2 = this$0;
      j = Integer.valueOf(this$0.hospitalcode).intValue();
      localObject2 = LabReport_3.access$300((LabReport_3)localObject2, "hos_id", j, Integer.class);
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject2 = this$0;
      localObject1 = this$0.Res_report_id;
      int m = Integer.valueOf(paramVarArgs[i]).intValue();
      localObject1 = localObject1[m];
      localObject2 = LabReport_3.access$200((LabReport_3)localObject2, "reportID", (String)localObject1, String.class);
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject2 = this$0;
      localObject3 = "reportYR";
      localObject1 = this$0.Res_report_year;
      m = Integer.valueOf(paramVarArgs[i]).intValue();
      localObject1 = localObject1[m];
      Class localClass = String.class;
      localObject2 = LabReport_3.access$200((LabReport_3)localObject2, (String)localObject3, (String)localObject1, localClass);
      localSoapObject.addProperty((PropertyInfo)localObject2);
    }
    SoapSerializationEnvelope localSoapSerializationEnvelope = new org/ksoap2/serialization/SoapSerializationEnvelope;
    int k = 110;
    localSoapSerializationEnvelope.<init>(k);
    localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
    HttpTransportSE localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
    int n = 60000;
    localHttpTransportSE.<init>("http://ors.gov.in/ORSServicecontainer/labservices?wsdl", n);
    localObject2 = "http://orsws/";
    try
    {
      localHttpTransportSE.call((String)localObject2, localSoapSerializationEnvelope);
      Object localObject4 = localSoapSerializationEnvelope.getResponse();
      localObject4 = (SoapPrimitive)localObject4;
      localObject2 = ((SoapPrimitive)localObject4).toString();
      finalresp = ((String)localObject2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = this$0;
        localObject3 = new in/gov/mgov/ors/LabReport_3$CallList$1;
        ((LabReport_3.CallList.1)localObject3).<init>(this);
        ((LabReport_3)localObject2).runOnUiThread((Runnable)localObject3);
      }
    }
    return finalresp;
  }
  
  protected void onPostExecute(String paramString)
  {
    i = 2131034288;
    super.onPostExecute(paramString);
    localObject1 = dlog;
    boolean bool = ((ProgressDialog)localObject1).isShowing();
    if (bool)
    {
      localObject1 = dlog;
      ((ProgressDialog)localObject1).dismiss();
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        localObject1 = this$0;
        localObject1 = LabReport_3.access$100((LabReport_3)localObject1);
        localObject2 = "getLabReportDetails";
        bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
        if (bool)
        {
          localObject1 = "status";
          localObject1 = localJSONObject.getString((String)localObject1);
          localObject2 = "1";
          bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
          if (bool)
          {
            localObject1 = "detailedData";
            String str = localJSONObject.getString((String)localObject1);
            Intent localIntent = new android/content/Intent;
            localObject1 = this$0;
            localObject1 = ((LabReport_3)localObject1).getApplicationContext();
            localObject2 = LabReprt_4_webview.class;
            localIntent.<init>((Context)localObject1, (Class)localObject2);
            localObject2 = "unit";
            localObject1 = unit;
            Object localObject3 = unit;
            j = ((List)localObject3).size();
            localObject3 = new String[j];
            localObject1 = ((List)localObject1).toArray((Object[])localObject3);
            localObject1 = (String[])localObject1;
            localIntent.putExtra((String)localObject2, (String[])localObject1);
            localObject2 = "resultl";
            localObject1 = resultl;
            localObject3 = unit;
            j = ((List)localObject3).size();
            localObject3 = new String[j];
            localObject1 = ((List)localObject1).toArray((Object[])localObject3);
            localObject1 = (String[])localObject1;
            localIntent.putExtra((String)localObject2, (String[])localObject1);
            localObject2 = "testName";
            localObject1 = testName;
            localObject3 = unit;
            j = ((List)localObject3).size();
            localObject3 = new String[j];
            localObject1 = ((List)localObject1).toArray((Object[])localObject3);
            localObject1 = (String[])localObject1;
            localIntent.putExtra((String)localObject2, (String[])localObject1);
            localObject2 = "normal_range_lower";
            localObject1 = normal_range_lower;
            localObject3 = unit;
            j = ((List)localObject3).size();
            localObject3 = new String[j];
            localObject1 = ((List)localObject1).toArray((Object[])localObject3);
            localObject1 = (String[])localObject1;
            localIntent.putExtra((String)localObject2, (String[])localObject1);
            localObject2 = "reamrks";
            localObject1 = reamrks;
            localObject3 = unit;
            j = ((List)localObject3).size();
            localObject3 = new String[j];
            localObject1 = ((List)localObject1).toArray((Object[])localObject3);
            localObject1 = (String[])localObject1;
            localIntent.putExtra((String)localObject2, (String[])localObject1);
            localObject2 = "sample_receive_date";
            localObject1 = sample_receive_date;
            localObject3 = unit;
            j = ((List)localObject3).size();
            localObject3 = new String[j];
            localObject1 = ((List)localObject1).toArray((Object[])localObject3);
            localObject1 = (String[])localObject1;
            localIntent.putExtra((String)localObject2, (String[])localObject1);
            localObject1 = "uhid";
            localObject2 = this$0;
            localObject2 = uhid;
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject2 = "normal_range_upper";
            localObject1 = normal_range_upper;
            localObject3 = unit;
            j = ((List)localObject3).size();
            localObject3 = new String[j];
            localObject1 = ((List)localObject1).toArray((Object[])localObject3);
            localObject1 = (String[])localObject1;
            localIntent.putExtra((String)localObject2, (String[])localObject1);
            localObject2 = "report_verified_by";
            localObject1 = report_verified_by;
            localObject3 = unit;
            j = ((List)localObject3).size();
            localObject3 = new String[j];
            localObject1 = ((List)localObject1).toArray((Object[])localObject3);
            localObject1 = (String[])localObject1;
            localIntent.putExtra((String)localObject2, (String[])localObject1);
            localObject1 = "name";
            localObject2 = this$0;
            localObject2 = textview_name_data;
            localObject2 = ((TextView)localObject2).getText();
            localObject2 = ((CharSequence)localObject2).toString();
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject1 = "age";
            localObject2 = this$0;
            localObject2 = textview__age_data;
            localObject2 = ((TextView)localObject2).getText();
            localObject2 = ((CharSequence)localObject2).toString();
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject1 = "sex";
            localObject2 = this$0;
            localObject2 = textview_gender_data;
            localObject2 = ((TextView)localObject2).getText();
            localObject2 = ((CharSequence)localObject2).toString();
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject1 = "Res_sample_type_desc";
            localObject2 = this$0;
            localObject2 = Res_sample_type_desc;
            localObject3 = this$0;
            j = pos;
            localObject2 = localObject2[j];
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject1 = "Res_sample_year";
            localObject2 = this$0;
            localObject2 = Res_sample_year;
            localObject3 = this$0;
            j = pos;
            localObject2 = localObject2[j];
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject1 = "Res_report_year";
            localObject2 = this$0;
            localObject2 = Res_report_year;
            localObject3 = this$0;
            j = pos;
            localObject2 = localObject2[j];
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject1 = "Res_daily_sampleno_str";
            localObject2 = this$0;
            localObject2 = Res_daily_sampleno_str;
            localObject3 = this$0;
            j = pos;
            localObject2 = localObject2[j];
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject1 = "Res_test_name";
            localObject2 = this$0;
            localObject2 = Res_test_name;
            localObject3 = this$0;
            j = pos;
            localObject2 = localObject2[j];
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject1 = "Res_sample_no";
            localObject2 = this$0;
            localObject2 = Res_sample_no;
            localObject3 = this$0;
            j = pos;
            localObject2 = localObject2[j];
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject1 = "Res_report_id";
            localObject2 = this$0;
            localObject2 = Res_report_id;
            localObject3 = this$0;
            j = pos;
            localObject2 = localObject2[j];
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject1 = "Res_Collecteddate";
            localObject2 = this$0;
            localObject2 = Res_Collecteddate;
            localObject3 = this$0;
            j = pos;
            localObject2 = localObject2[j];
            localIntent.putExtra((String)localObject1, (String)localObject2);
            localObject1 = "webdata";
            localIntent.putExtra((String)localObject1, str);
            localObject1 = this$0;
            ((LabReport_3)localObject1).startActivity(localIntent);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        int j;
        localObject1 = this$0;
        localObject2 = this$0.getResources().getString(i);
        LabReport_3.access$400((LabReport_3)localObject1, (String)localObject2);
        continue;
      }
      catch (Exception localException)
      {
        localObject1 = this$0;
        Object localObject2 = this$0.getResources().getString(i);
        LabReport_3.access$400((LabReport_3)localObject1, (String)localObject2);
        continue;
      }
      localObject1 = this$0;
      localObject2 = this$0;
      localObject2 = ((LabReport_3)localObject2).getResources();
      j = 2131034250;
      localObject2 = ((Resources)localObject2).getString(j);
      LabReport_3.access$400((LabReport_3)localObject1, (String)localObject2);
    }
  }
  
  protected void onPreExecute()
  {
    int i = 1;
    super.onPreExecute();
    Object localObject1 = new android/app/ProgressDialog;
    Object localObject2 = this$0;
    ((ProgressDialog)localObject1).<init>((Context)localObject2);
    dlog = ((ProgressDialog)localObject1);
    localObject1 = dlog;
    localObject2 = this$0.getResources();
    int j = 2131034289;
    localObject2 = ((Resources)localObject2).getString(j);
    ((ProgressDialog)localObject1).setTitle((CharSequence)localObject2);
    localObject1 = LabReport_3.access$100(this$0);
    localObject2 = "getRawOTP";
    boolean bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
    if (bool)
    {
      localObject1 = dlog;
      localObject2 = this$0.getResources();
      j = 2131034164;
      localObject2 = ((Resources)localObject2).getString(j);
      ((ProgressDialog)localObject1).setMessage((CharSequence)localObject2);
    }
    for (;;)
    {
      int k = Build.VERSION.SDK_INT;
      int m = 11;
      if (k >= m)
      {
        dlog.setProgressStyle(i);
        dlog.setIndeterminate(i);
        dlog.setProgressNumberFormat(null);
        localObject1 = dlog;
        ((ProgressDialog)localObject1).setProgressPercentFormat(null);
      }
      dlog.setCancelable(false);
      dlog.show();
      return;
      localObject1 = dlog;
      localObject2 = this$0.getResources();
      j = 2131034206;
      localObject2 = ((Resources)localObject2).getString(j);
      ((ProgressDialog)localObject1).setMessage((CharSequence)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_3$CallList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */