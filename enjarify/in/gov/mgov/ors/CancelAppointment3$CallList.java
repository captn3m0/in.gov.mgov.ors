package in.gov.mgov.ors;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.Base64;
import android.widget.ImageView;
import nitesh.floatinghint.FloatingHintEditText;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

class CancelAppointment3$CallList
  extends AsyncTask
{
  private ProgressDialog dlog;
  String finalresp;
  
  private CancelAppointment3$CallList(CancelAppointment3 paramCancelAppointment3) {}
  
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
    localObject2 = "getRawOTP";
    boolean bool = ((String)localObject1).equals(localObject2);
    Class localClass;
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
    localObject1 = paramVarArgs[0];
    localObject2 = "getAadhaarIamge";
    bool = ((String)localObject1).equals(localObject2);
    if (bool)
    {
      localObject1 = addProperties("in_token", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject2 = this$0.resAadhaar;
      localClass = String.class;
      localObject1 = addProperties("aadhaar", (String)localObject2, localClass);
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
        localObject2 = new in/gov/mgov/ors/CancelAppointment3$CallList$1;
        ((CancelAppointment3.CallList.1)localObject2).<init>(this);
        ((CancelAppointment3)localObject1).runOnUiThread((Runnable)localObject2);
      }
    }
    return finalresp;
  }
  
  protected void onPostExecute(String paramString)
  {
    super.onPostExecute(paramString);
    Object localObject1 = dlog;
    boolean bool1 = ((ProgressDialog)localObject1).isShowing();
    if (bool1)
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
      bool1 = ((String)localObject1).equalsIgnoreCase((String)localObject2);
      int j;
      if (bool1)
      {
        localObject1 = this$0;
        localObject2 = "data";
        localObject2 = localJSONObject.getString((String)localObject2);
        OTP = ((String)localObject2);
        AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
        localObject1 = this$0;
        localBuilder.<init>((Context)localObject1);
        localObject1 = this$0;
        localObject1 = ((CancelAppointment3)localObject1).getResources();
        j = 2131034183;
        localObject1 = ((Resources)localObject1).getString(j);
        localBuilder.setTitle((CharSequence)localObject1);
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localObject2 = this$0;
        localObject2 = ((CancelAppointment3)localObject2).getResources();
        int k = 2131034264;
        localObject2 = ((Resources)localObject2).getString(k);
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
        localObject2 = ": XXXXXX";
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
        localObject2 = this$0;
        localObject2 = resMobileNo;
        Object localObject3 = this$0;
        localObject3 = resMobileNo;
        k = ((String)localObject3).length() + -4;
        Object localObject4 = this$0;
        localObject4 = resMobileNo;
        int m = ((String)localObject4).length();
        localObject2 = ((String)localObject2).substring(k, m);
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
        localBuilder.setMessage((CharSequence)localObject1);
        FloatingHintEditText localFloatingHintEditText = new nitesh/floatinghint/FloatingHintEditText;
        localObject1 = this$0;
        localFloatingHintEditText.<init>((Context)localObject1);
        bool1 = true;
        localObject1 = new InputFilter[bool1];
        j = 0;
        localObject2 = null;
        localObject3 = new android/text/InputFilter$LengthFilter;
        m = 5;
        ((InputFilter.LengthFilter)localObject3).<init>(m);
        localObject1[0] = localObject3;
        localFloatingHintEditText.setFilters((InputFilter[])localObject1);
        localObject1 = this$0;
        localObject1 = ((CancelAppointment3)localObject1).getResources();
        j = 2131034190;
        localObject1 = ((Resources)localObject1).getString(j);
        localFloatingHintEditText.setHint((CharSequence)localObject1);
        int i = 2;
        localFloatingHintEditText.setInputType(i);
        localBuilder.setView(localFloatingHintEditText);
        localObject1 = this$0;
        localObject1 = ((CancelAppointment3)localObject1).getResources();
        j = 2131034259;
        localObject1 = ((Resources)localObject1).getString(j);
        j = 0;
        localObject2 = null;
        localBuilder.setPositiveButton((CharSequence)localObject1, null);
        localObject1 = this$0;
        localObject1 = ((CancelAppointment3)localObject1).getResources();
        j = 2131034156;
        localObject1 = ((Resources)localObject1).getString(j);
        j = 0;
        localObject2 = null;
        localBuilder.setNegativeButton((CharSequence)localObject1, null);
        localObject1 = this$0;
        localObject1 = ((CancelAppointment3)localObject1).getResources();
        j = 2131034293;
        localObject1 = ((Resources)localObject1).getString(j);
        j = 0;
        localObject2 = null;
        localBuilder.setNeutralButton((CharSequence)localObject1, null);
        AlertDialog localAlertDialog = localBuilder.create();
        localObject1 = new in/gov/mgov/ors/CancelAppointment3$CallList$2;
        ((CancelAppointment3.CallList.2)localObject1).<init>(this, localAlertDialog, localFloatingHintEditText);
        localAlertDialog.setOnShowListener((DialogInterface.OnShowListener)localObject1);
        localAlertDialog.show();
      }
      localObject1 = this$0;
      localObject1 = CancelAppointment3.access$100((CancelAppointment3)localObject1);
      localObject2 = "getAadhaarIamge";
      boolean bool2 = ((String)localObject1).equals(localObject2);
      if (bool2)
      {
        localObject1 = "imageFOUND";
        localObject1 = localJSONObject.getString((String)localObject1);
        localObject2 = "y";
        bool2 = ((String)localObject1).equalsIgnoreCase((String)localObject2);
        if (bool2)
        {
          localObject1 = "image";
          localObject1 = localJSONObject.getString((String)localObject1);
          j = 0;
          localObject2 = null;
          byte[] arrayOfByte = Base64.decode((String)localObject1, 0);
          bool2 = false;
          localObject1 = null;
          j = arrayOfByte.length;
          Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, j);
          localObject1 = this$0;
          localObject1 = img_id;
          ((ImageView)localObject1).setImageBitmap(localBitmap);
          localObject1 = this$0;
          localObject1 = img_id;
          j = 0;
          localObject2 = null;
          ((ImageView)localObject1).setVisibility(0);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment3$CallList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */