package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
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

class BloodAvailability2$CallList
  extends AsyncTask
{
  List blood_name_list;
  private ProgressDialog dlog;
  String finalresp;
  List item_name_list;
  List quantity_list;
  
  private BloodAvailability2$CallList(BloodAvailability2 paramBloodAvailability2)
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    item_name_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    blood_name_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    quantity_list = localArrayList;
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
    Object localObject1 = this$0;
    String str = paramVarArgs[0];
    BloodAvailability2.access$102((BloodAvailability2)localObject1, str);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    str = BloodAvailability2.access$100(this$0);
    localSoapObject.<init>("http://orsws/", str);
    localObject1 = addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class);
    localSoapObject.addProperty((PropertyInfo)localObject1);
    str = BloodAvailability2.intent_bbid;
    localObject1 = addProperties("bloodbankid", str, String.class);
    localSoapObject.addProperty((PropertyInfo)localObject1);
    str = BloodAvailability2.intent_stateid;
    Class localClass = String.class;
    localObject1 = addProperties("stateid", str, localClass);
    localSoapObject.addProperty((PropertyInfo)localObject1);
    SoapSerializationEnvelope localSoapSerializationEnvelope = new org/ksoap2/serialization/SoapSerializationEnvelope;
    int i = 110;
    localSoapSerializationEnvelope.<init>(i);
    localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
    HttpTransportSE localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
    int j = 60000;
    localHttpTransportSE.<init>("http://ors.gov.in/ORSServicecontainer/bbservices?wsdl", j);
    localObject1 = "http://orsws/";
    try
    {
      localHttpTransportSE.call((String)localObject1, localSoapSerializationEnvelope);
      Object localObject2 = localSoapSerializationEnvelope.getResponse();
      localObject2 = (SoapPrimitive)localObject2;
      localObject1 = ((SoapPrimitive)localObject2).toString();
      finalresp = ((String)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
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
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new org/json/JSONObject;
        localObject1 = finalresp;
        localJSONObject1.<init>((String)localObject1);
        localObject1 = this$0;
        localObject1 = BloodAvailability2.access$100((BloodAvailability2)localObject1);
        localObject2 = "getBloodstatus";
        bool = ((String)localObject1).equals(localObject2);
        if (bool)
        {
          localObject1 = item_name_list;
          ((List)localObject1).clear();
          localObject1 = blood_name_list;
          ((List)localObject1).clear();
          localObject1 = quantity_list;
          ((List)localObject1).clear();
          localObject1 = finalresp;
          localObject2 = "error";
          bool = ((String)localObject1).contains((CharSequence)localObject2);
          if (bool) {
            continue;
          }
          localObject1 = "bloodData";
          JSONArray localJSONArray = localJSONObject1.optJSONArray((String)localObject1);
          int j = 0;
          int i = localJSONArray.length();
          if (j < i)
          {
            JSONObject localJSONObject2 = localJSONArray.getJSONObject(j);
            localObject1 = item_name_list;
            localObject2 = "item_name";
            localObject2 = localJSONObject2.getString((String)localObject2);
            ((List)localObject1).add(localObject2);
            localObject1 = blood_name_list;
            localObject2 = "blood_name";
            localObject2 = localJSONObject2.getString((String)localObject2);
            ((List)localObject1).add(localObject2);
            localObject1 = quantity_list;
            localObject2 = "quantity";
            localObject2 = localJSONObject2.getString((String)localObject2);
            ((List)localObject1).add(localObject2);
            j += 1;
            continue;
          }
          localObject2 = this$0;
          localObject1 = item_name_list;
          Object localObject3 = item_name_list;
          int k = ((List)localObject3).size();
          localObject3 = new String[k];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          stringarr_item_name = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = blood_name_list;
          localObject3 = blood_name_list;
          k = ((List)localObject3).size();
          localObject3 = new String[k];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          stringarr_blodd_name = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = quantity_list;
          localObject3 = quantity_list;
          k = ((List)localObject3).size();
          localObject3 = new String[k];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          stringarr_quantity = ((String[])localObject1);
          localObject1 = this$0;
          ((BloodAvailability2)localObject1).setListData();
          localObject1 = item_name_list;
          i = ((List)localObject1).size();
          if (i == 0)
          {
            localObject1 = this$0;
            localObject2 = new in/gov/mgov/ors/BloodAvailability2$CallList$1;
            ((BloodAvailability2.CallList.1)localObject2).<init>(this);
            ((BloodAvailability2)localObject1).runOnUiThread((Runnable)localObject2);
          }
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        localJSONException.printStackTrace();
        continue;
      }
      localObject1 = this$0;
      localObject2 = new in/gov/mgov/ors/BloodAvailability2$CallList$2;
      ((BloodAvailability2.CallList.2)localObject2).<init>(this);
      ((BloodAvailability2)localObject1).runOnUiThread((Runnable)localObject2);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BloodAvailability2$CallList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */