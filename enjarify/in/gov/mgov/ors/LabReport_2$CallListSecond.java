package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

class LabReport_2$CallListSecond
  extends AsyncTask
{
  private ProgressDialog dlog;
  String finalresp;
  
  private LabReport_2$CallListSecond(LabReport_2 paramLabReport_2) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    String str = null;
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
      str = this$0.p_mobile_no;
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
    int i = 110;
    localSoapSerializationEnvelope.<init>(i);
    localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
    HttpTransportSE localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
    int j = 60000;
    localHttpTransportSE.<init>("http://ors.gov.in/ORSServicecontainer/services?wsdl", j);
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
        localObject2 = new in/gov/mgov/ors/LabReport_2$CallListSecond$1;
        ((LabReport_2.CallListSecond.1)localObject2).<init>(this);
        ((LabReport_2)localObject1).runOnUiThread((Runnable)localObject2);
      }
    }
    return finalresp;
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
      Object localObject2 = "getRawOTP";
      bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
      if (bool)
      {
        localObject1 = this$0;
        localObject2 = "data";
        localObject2 = localJSONObject.getString((String)localObject2);
        OTP = ((String)localObject2);
        localObject1 = this$0;
        localObject2 = this$0;
        localObject2 = ((LabReport_2)localObject2).getResources();
        int i = 2131034262;
        localObject2 = ((Resources)localObject2).getString(i);
        LabReport_2.access$300((LabReport_2)localObject1, (String)localObject2);
        localObject1 = this$0;
        int j = maxTriesforOTP + 1;
        maxTriesforOTP = j;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
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
    int j = 2131034164;
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_2$CallListSecond.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */