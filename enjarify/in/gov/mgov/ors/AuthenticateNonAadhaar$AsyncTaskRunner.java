package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.EditText;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

class AuthenticateNonAadhaar$AsyncTaskRunner
  extends AsyncTask
{
  private ProgressDialog dlog;
  private String resp;
  
  private AuthenticateNonAadhaar$AsyncTaskRunner(AuthenticateNonAadhaar paramAuthenticateNonAadhaar) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    int i = 1;
    localObject1 = new String[i];
    int j = 0;
    localObject1[0] = "Loading contents...";
    publishProgress((Object[])localObject1);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localObject2 = AuthenticateNonAadhaar.access$000(this$0);
    localSoapObject.<init>("http://orsws/", (String)localObject2);
    localObject1 = this$0;
    String str = this$0.number.getText().toString();
    localObject1 = AuthenticateNonAadhaar.access$500((AuthenticateNonAadhaar)localObject1, "mobileno", str, String.class);
    localSoapObject.addProperty((PropertyInfo)localObject1);
    localObject1 = AuthenticateNonAadhaar.access$500(this$0, "userid", "mobileappors", String.class);
    localSoapObject.addProperty((PropertyInfo)localObject1);
    localObject1 = this$0;
    localObject2 = "intoken";
    str = "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj";
    Class localClass = String.class;
    localObject1 = AuthenticateNonAadhaar.access$500((AuthenticateNonAadhaar)localObject1, (String)localObject2, str, localClass);
    localSoapObject.addProperty((PropertyInfo)localObject1);
    for (;;)
    {
      try
      {
        SoapSerializationEnvelope localSoapSerializationEnvelope = new org/ksoap2/serialization/SoapSerializationEnvelope;
        i = 110;
        localSoapSerializationEnvelope.<init>(i);
        localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
        HttpTransportSE localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
        localObject1 = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
        j = 60000;
        localHttpTransportSE.<init>((String)localObject1, j);
        localObject1 = "http://orsws/";
        localHttpTransportSE.call((String)localObject1, localSoapSerializationEnvelope);
        Object localObject3 = localSoapSerializationEnvelope.getResponse();
        localObject3 = (SoapPrimitive)localObject3;
        localObject1 = this$0;
        localObject2 = ((SoapPrimitive)localObject3).toString();
        finalresp = ((String)localObject2);
        localObject1 = this$0;
        localObject1 = AuthenticateNonAadhaar.access$000((AuthenticateNonAadhaar)localObject1);
        localObject2 = "getRawOTP";
        boolean bool = ((String)localObject1).equals(localObject2);
        if (bool)
        {
          localJSONObject = new org/json/JSONObject;
          localObject1 = this$0;
          localObject1 = finalresp;
          localJSONObject.<init>((String)localObject1);
          localObject1 = "status";
          localObject1 = localJSONObject.getString((String)localObject1);
          localObject2 = "Y";
          bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
          if (!bool) {
            continue;
          }
          localObject1 = this$0;
          localObject2 = new in/gov/mgov/ors/AuthenticateNonAadhaar$AsyncTaskRunner$1;
          ((AuthenticateNonAadhaar.AsyncTaskRunner.1)localObject2).<init>(this, localJSONObject, paramVarArgs);
          ((AuthenticateNonAadhaar)localObject1).runOnUiThread((Runnable)localObject2);
        }
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        localObject1 = this$0;
        localObject2 = new in/gov/mgov/ors/AuthenticateNonAadhaar$AsyncTaskRunner$3;
        ((AuthenticateNonAadhaar.AsyncTaskRunner.3)localObject2).<init>(this);
        ((AuthenticateNonAadhaar)localObject1).runOnUiThread((Runnable)localObject2);
        continue;
      }
      return resp;
      localObject1 = this$0;
      localObject2 = new in/gov/mgov/ors/AuthenticateNonAadhaar$AsyncTaskRunner$2;
      ((AuthenticateNonAadhaar.AsyncTaskRunner.2)localObject2).<init>(this, localJSONObject);
      ((AuthenticateNonAadhaar)localObject1).runOnUiThread((Runnable)localObject2);
    }
  }
  
  protected void onPostExecute(String paramString)
  {
    ProgressDialog localProgressDialog = dlog;
    boolean bool = localProgressDialog.isShowing();
    if (bool)
    {
      localProgressDialog = dlog;
      localProgressDialog.dismiss();
    }
  }
  
  protected void onPreExecute()
  {
    int i = 1;
    ProgressDialog localProgressDialog = new android/app/ProgressDialog;
    Object localObject = this$0;
    localProgressDialog.<init>((Context)localObject);
    dlog = localProgressDialog;
    localProgressDialog = dlog;
    localObject = this$0.getResources().getString(2131034289);
    localProgressDialog.setTitle((CharSequence)localObject);
    localProgressDialog = dlog;
    localObject = this$0.getResources();
    int j = 2131034163;
    localObject = ((Resources)localObject).getString(j);
    localProgressDialog.setMessage((CharSequence)localObject);
    int k = Build.VERSION.SDK_INT;
    int m = 11;
    if (k >= m)
    {
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      j = Build.VERSION.SDK_INT;
      localObject = ((StringBuilder)localObject).append(j);
      String str = "";
      localObject = str;
      Log.d("Ver", (String)localObject);
      dlog.setProgressStyle(i);
      dlog.setIndeterminate(i);
      dlog.setProgressNumberFormat(null);
      localProgressDialog = dlog;
      localProgressDialog.setProgressPercentFormat(null);
    }
    dlog.setCancelable(false);
    dlog.show();
  }
  
  protected void onProgressUpdate(String... paramVarArgs) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/AuthenticateNonAadhaar$AsyncTaskRunner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */