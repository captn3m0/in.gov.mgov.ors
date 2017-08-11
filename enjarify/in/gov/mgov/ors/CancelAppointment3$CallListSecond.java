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

class CancelAppointment3$CallListSecond
  extends AsyncTask
{
  private ProgressDialog dlog;
  String finalresp;
  
  private CancelAppointment3$CallListSecond(CancelAppointment3 paramCancelAppointment3) {}
  
  private PropertyInfo addProperties(String paramString, Integer paramInteger, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    localPropertyInfo.setName(paramString);
    localPropertyInfo.setValue(paramInteger);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  private PropertyInfo addProperties(String paramString1, String paramString2, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    localPropertyInfo.setName(paramString1);
    localPropertyInfo.setValue(paramString2);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  protected String doInBackground(String... paramVarArgs)
  {
    localObject1 = this$0;
    localObject2 = paramVarArgs[0];
    CancelAppointment3.access$102((CancelAppointment3)localObject1, (String)localObject2);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localObject2 = CancelAppointment3.access$100(this$0);
    localSoapObject.<init>("http://orsws/", (String)localObject2);
    localObject1 = paramVarArgs[0];
    localObject2 = "cancelAppointment";
    boolean bool = ((String)localObject1).equals(localObject2);
    Class localClass;
    if (bool)
    {
      localObject1 = addProperties("in_token", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      j = 99999;
      localObject2 = Integer.valueOf(j);
      localObject1 = addProperties("uid", (Integer)localObject2, Integer.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject2 = this$0.resAppointment_id;
      localObject1 = addProperties("app_no", (String)localObject2, String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject2 = this$0.hospitalcode;
      localObject1 = addProperties("hos_id", (String)localObject2, Integer.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject1 = addProperties("entry_system", "0.0.0.0", String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject2 = this$0.resAppdates;
      localObject1 = addProperties("app_date", (String)localObject2, String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject2 = Integer.valueOf(0);
      localClass = Integer.class;
      localObject1 = addProperties("isOnline", (Integer)localObject2, localClass);
      localSoapObject.addProperty((PropertyInfo)localObject1);
    }
    localObject1 = paramVarArgs[0];
    localObject2 = "getRawOTP";
    bool = ((String)localObject1).equals(localObject2);
    if (bool)
    {
      localObject2 = this$0.resMobileNo;
      localObject1 = addProperties("mobileno", (String)localObject2, String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject1 = addProperties("userid", "mobileappors", String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject2 = "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj";
      localClass = String.class;
      localObject1 = addProperties("intoken", (String)localObject2, localClass);
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
        localObject2 = new in/gov/mgov/ors/CancelAppointment3$CallListSecond$1;
        ((CancelAppointment3.CallListSecond.1)localObject2).<init>(this);
        ((CancelAppointment3)localObject1).runOnUiThread((Runnable)localObject2);
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
      localObject1 = CancelAppointment3.access$100((CancelAppointment3)localObject1);
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
        localObject2 = ((CancelAppointment3)localObject2).getResources();
        int i = 2131034262;
        localObject2 = ((Resources)localObject2).getString(i);
        CancelAppointment3.access$200((CancelAppointment3)localObject1, (String)localObject2);
        localObject1 = this$0;
        int j = maxTriesforOTP + 1;
        maxTriesforOTP = j;
      }
      localObject1 = this$0;
      localObject1 = CancelAppointment3.access$100((CancelAppointment3)localObject1);
      localObject2 = "cancelAppointment";
      bool = ((String)localObject1).equals(localObject2);
      if (bool)
      {
        localObject1 = "response";
        String str = localJSONObject.getString((String)localObject1);
        localObject1 = this$0;
        CancelAppointment3.access$400((CancelAppointment3)localObject1, str);
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
    Object localObject1 = new android/app/ProgressDialog;
    Object localObject2 = this$0;
    ((ProgressDialog)localObject1).<init>((Context)localObject2);
    dlog = ((ProgressDialog)localObject1);
    localObject1 = dlog;
    localObject2 = this$0.getResources();
    int j = 2131034289;
    localObject2 = ((Resources)localObject2).getString(j);
    ((ProgressDialog)localObject1).setTitle((CharSequence)localObject2);
    localObject1 = CancelAppointment3.access$100(this$0);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment3$CallListSecond.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */