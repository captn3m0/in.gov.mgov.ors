package in.gov.mgov.ors;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import java.util.ArrayList;
import java.util.List;
import nitesh.floatinghint.FloatingHintEditText;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

class LabReport_2$CallList
  extends AsyncTask
{
  List Collecteddate;
  List daily_sampleno_str;
  private ProgressDialog dlog;
  String finalresp;
  List id;
  List list;
  List report_id;
  List report_year;
  List sample_no;
  List sample_type_desc;
  List sample_year;
  List test_name;
  
  private LabReport_2$CallList(LabReport_2 paramLabReport_2)
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    id = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    sample_type_desc = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    sample_year = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    report_year = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    daily_sampleno_str = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    test_name = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    sample_no = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    report_id = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    Collecteddate = localArrayList;
  }
  
  protected String doInBackground(String... paramVarArgs)
  {
    int i = 60000;
    localObject1 = this$0;
    localObject2 = paramVarArgs[0];
    LabReport_2.access$102((LabReport_2)localObject1, (String)localObject2);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localObject2 = LabReport_2.access$100(this$0);
    localSoapObject.<init>("http://orsws/", (String)localObject2);
    localObject1 = paramVarArgs[0];
    localObject2 = "getRawOTP";
    boolean bool = ((String)localObject1).equals(localObject2);
    if (bool)
    {
      localObject1 = this$0;
      String str = this$0.p_mobile_no;
      localObject1 = LabReport_2.access$200((LabReport_2)localObject1, "mobileno", str, String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject1 = LabReport_2.access$200(this$0, "userid", "mobileappors", String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject1 = this$0;
      localObject2 = "intoken";
      str = "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj";
      Class localClass = String.class;
      localObject1 = LabReport_2.access$200((LabReport_2)localObject1, (String)localObject2, str, localClass);
      localSoapObject.addProperty((PropertyInfo)localObject1);
    }
    SoapSerializationEnvelope localSoapSerializationEnvelope = new org/ksoap2/serialization/SoapSerializationEnvelope;
    localSoapSerializationEnvelope.<init>(110);
    localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
    localObject1 = paramVarArgs[0];
    localObject2 = "getRawOTP";
    bool = ((String)localObject1).equals(localObject2);
    HttpTransportSE localHttpTransportSE;
    if (bool)
    {
      localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
      localObject1 = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
      localHttpTransportSE.<init>((String)localObject1, i);
    }
    for (;;)
    {
      localObject1 = "http://orsws/";
      try
      {
        localHttpTransportSE.call((String)localObject1, localSoapSerializationEnvelope);
        Object localObject3 = localSoapSerializationEnvelope.getResponse();
        localObject3 = (SoapPrimitive)localObject3;
        localObject1 = ((SoapPrimitive)localObject3).toString();
        finalresp = ((String)localObject1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = this$0;
          localObject2 = new in/gov/mgov/ors/LabReport_2$CallList$1;
          ((LabReport_2.CallList.1)localObject2).<init>(this);
          ((LabReport_2)localObject1).runOnUiThread((Runnable)localObject2);
          localException.printStackTrace();
        }
      }
      return finalresp;
      localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
      localObject1 = "http://ors.gov.in/ORSServicecontainer/labservices?wsdl";
      localHttpTransportSE.<init>((String)localObject1, i);
    }
  }
  
  protected void onPostExecute(String paramString)
  {
    super.onPostExecute(paramString);
    Object localObject1 = dlog;
    boolean bool = ((ProgressDialog)localObject1).isShowing();
    if (bool)
    {
      localObject1 = dlog;
      ((ProgressDialog)localObject1).dismiss();
    }
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      localObject1 = this$0;
      localObject1 = LabReport_2.access$100((LabReport_2)localObject1);
      localObject2 = "getRawOTP";
      bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
      if (bool)
      {
        localObject1 = "status";
        localObject1 = localJSONObject.getString((String)localObject1);
        localObject2 = "Y";
        bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
        if (bool)
        {
          localObject1 = this$0;
          localObject2 = "data";
          localObject2 = localJSONObject.getString((String)localObject2);
          OTP = ((String)localObject2);
          AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
          localObject1 = this$0;
          localBuilder.<init>((Context)localObject1);
          localObject1 = this$0;
          localObject1 = ((LabReport_2)localObject1).getResources();
          int j = 2131034183;
          localObject1 = ((Resources)localObject1).getString(j);
          localBuilder.setTitle((CharSequence)localObject1);
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          localObject2 = this$0;
          localObject2 = ((LabReport_2)localObject2).getResources();
          k = 2131034264;
          localObject2 = ((Resources)localObject2).getString(k);
          localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
          localObject2 = ": XXXXXX";
          localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
          localObject2 = this$0;
          localObject2 = p_mobile_no;
          Object localObject3 = this$0;
          localObject3 = p_mobile_no;
          k = ((String)localObject3).length() + -4;
          Object localObject4 = this$0;
          localObject4 = p_mobile_no;
          int m = ((String)localObject4).length();
          localObject2 = ((String)localObject2).substring(k, m);
          localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
          localBuilder.setMessage((CharSequence)localObject1);
          FloatingHintEditText localFloatingHintEditText = new nitesh/floatinghint/FloatingHintEditText;
          localObject1 = this$0;
          localFloatingHintEditText.<init>((Context)localObject1);
          bool = true;
          localObject1 = new InputFilter[bool];
          j = 0;
          localObject2 = null;
          localObject3 = new android/text/InputFilter$LengthFilter;
          m = 5;
          ((InputFilter.LengthFilter)localObject3).<init>(m);
          localObject1[0] = localObject3;
          localFloatingHintEditText.setFilters((InputFilter[])localObject1);
          localObject1 = this$0;
          localObject1 = ((LabReport_2)localObject1).getResources();
          j = 2131034190;
          localObject1 = ((Resources)localObject1).getString(j);
          localFloatingHintEditText.setHint((CharSequence)localObject1);
          int i = 2;
          localFloatingHintEditText.setInputType(i);
          localBuilder.setView(localFloatingHintEditText);
          localObject1 = this$0;
          localObject1 = ((LabReport_2)localObject1).getResources();
          j = 2131034259;
          localObject1 = ((Resources)localObject1).getString(j);
          j = 0;
          localObject2 = null;
          localBuilder.setPositiveButton((CharSequence)localObject1, null);
          localObject1 = this$0;
          localObject1 = ((LabReport_2)localObject1).getResources();
          j = 2131034156;
          localObject1 = ((Resources)localObject1).getString(j);
          j = 0;
          localObject2 = null;
          localBuilder.setNegativeButton((CharSequence)localObject1, null);
          localObject1 = this$0;
          localObject1 = ((LabReport_2)localObject1).getResources();
          j = 2131034293;
          localObject1 = ((Resources)localObject1).getString(j);
          j = 0;
          localObject2 = null;
          localBuilder.setNeutralButton((CharSequence)localObject1, null);
          AlertDialog localAlertDialog = localBuilder.create();
          localObject1 = new in/gov/mgov/ors/LabReport_2$CallList$2;
          ((LabReport_2.CallList.2)localObject1).<init>(this, localAlertDialog, localFloatingHintEditText);
          localAlertDialog.setOnShowListener((DialogInterface.OnShowListener)localObject1);
          localAlertDialog.show();
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localObject1 = this$0;
        Object localObject2 = this$0.getResources();
        int k = 2131034288;
        localObject2 = ((Resources)localObject2).getString(k);
        LabReport_2.access$300((LabReport_2)localObject1, (String)localObject2);
      }
    }
  }
  
  protected void onPreExecute()
  {
    int i = 1;
    super.onPreExecute();
    ProgressDialog localProgressDialog = new android/app/ProgressDialog;
    Object localObject = this$0;
    localProgressDialog.<init>((Context)localObject);
    dlog = localProgressDialog;
    localProgressDialog = dlog;
    localObject = this$0.getResources().getString(2131034289);
    localProgressDialog.setTitle((CharSequence)localObject);
    localProgressDialog = dlog;
    localObject = this$0.getResources();
    int j = 2131034206;
    localObject = ((Resources)localObject).getString(j);
    localProgressDialog.setMessage((CharSequence)localObject);
    int k = Build.VERSION.SDK_INT;
    int m = 11;
    if (k >= m)
    {
      dlog.setProgressStyle(i);
      dlog.setIndeterminate(i);
      dlog.setProgressNumberFormat(null);
      localProgressDialog = dlog;
      localProgressDialog.setProgressPercentFormat(null);
    }
    dlog.setCancelable(false);
    dlog.show();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_2$CallList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */