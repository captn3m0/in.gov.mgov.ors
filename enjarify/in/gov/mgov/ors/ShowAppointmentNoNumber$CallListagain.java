package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.widget.Button;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

class ShowAppointmentNoNumber$CallListagain
  extends AsyncTask
{
  private ProgressDialog dlog;
  
  private ShowAppointmentNoNumber$CallListagain(ShowAppointmentNoNumber paramShowAppointmentNoNumber) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    Object localObject1 = this$0;
    int i = 0;
    String str = paramVarArgs[0];
    ShowAppointmentNoNumber.access$102((ShowAppointmentNoNumber)localObject1, str);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    str = ShowAppointmentNoNumber.access$100(this$0);
    localSoapObject.<init>("http://orsws/", str);
    localObject1 = ShowAppointmentNoNumber.access$100(this$0);
    str = "getHospitalListForPayment";
    boolean bool = ((String)localObject1).equals(str);
    if (bool)
    {
      PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo.<init>();
      localPropertyInfo.setName("intoken");
      localPropertyInfo.setValue("dG9rZW5Ad2ViQGFwcG9pbnQjbmlj");
      localObject1 = String.class;
      localPropertyInfo.setType(localObject1);
      localSoapObject.addProperty(localPropertyInfo);
    }
    SoapSerializationEnvelope localSoapSerializationEnvelope = new org/ksoap2/serialization/SoapSerializationEnvelope;
    int j = 110;
    localSoapSerializationEnvelope.<init>(j);
    localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
    HttpTransportSE localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
    i = 60000;
    localHttpTransportSE.<init>("http://ors.gov.in/ORSServicecontainer/services?wsdl", i);
    localObject1 = "http://orsws/";
    try
    {
      localHttpTransportSE.call((String)localObject1, localSoapSerializationEnvelope);
      Object localObject2 = localSoapSerializationEnvelope.getResponse();
      localObject2 = (SoapPrimitive)localObject2;
      localObject1 = this$0;
      str = ((SoapPrimitive)localObject2).toString();
      finalresp = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return this$0.finalresp;
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
    localObject1 = ShowAppointmentNoNumber.access$100(this$0);
    Object localObject2 = "getHospitalListForPayment";
    bool = ((String)localObject1).equals(localObject2);
    if (bool)
    {
      localObject1 = this$0.finalresp;
      localObject2 = "{}";
      bool = ((String)localObject1).equals(localObject2);
      if (!bool) {}
    }
    try
    {
      localObject1 = this$0;
      localObject2 = this$0;
      localObject2 = finalresp;
      bool = ShowAppointmentNoNumber.access$200((ShowAppointmentNoNumber)localObject1, (String)localObject2);
      if (bool)
      {
        localObject1 = this$0;
        localObject1 = payment;
        localObject2 = null;
        ((Button)localObject1).setVisibility(0);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
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
    int j = 2131034162;
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowAppointmentNoNumber$CallListagain.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */