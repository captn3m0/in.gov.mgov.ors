package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

class ShowUIDAIData$CallListagain
  extends AsyncTask
{
  private ProgressDialog dlog;
  
  private ShowUIDAIData$CallListagain(ShowUIDAIData paramShowUIDAIData) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    Object localObject1 = this$0;
    String str = paramVarArgs[0];
    ShowUIDAIData.access$202((ShowUIDAIData)localObject1, str);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    str = ShowUIDAIData.access$200(this$0);
    localSoapObject.<init>("http://orsws/", str);
    localObject1 = ShowUIDAIData.access$200(this$0);
    str = "getAvailabledatelist";
    boolean bool = ((String)localObject1).equals(str);
    if (bool)
    {
      PropertyInfo localPropertyInfo1 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo1.<init>();
      localPropertyInfo1.setName("hospitalid");
      localObject1 = Integer.valueOf(this$0.hospitalcode);
      localPropertyInfo1.setValue(localObject1);
      localPropertyInfo1.setType(Integer.class);
      localSoapObject.addProperty(localPropertyInfo1);
      PropertyInfo localPropertyInfo2 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo2.<init>();
      localPropertyInfo2.setName("departmentid");
      localObject1 = Integer.valueOf(this$0.departmentcode);
      localPropertyInfo2.setValue(localObject1);
      localPropertyInfo2.setType(Integer.class);
      localSoapObject.addProperty(localPropertyInfo2);
      PropertyInfo localPropertyInfo3 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo3.<init>();
      localPropertyInfo3.setName("appointmentcat");
      localObject1 = Integer.valueOf(0);
      localPropertyInfo3.setValue(localObject1);
      localPropertyInfo3.setType(Integer.class);
      localSoapObject.addProperty(localPropertyInfo3);
      PropertyInfo localPropertyInfo4 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo4.<init>();
      localPropertyInfo4.setName("calmonth");
      i = this$0.monthx;
      localObject1 = Integer.valueOf(i);
      localPropertyInfo4.setValue(localObject1);
      localPropertyInfo4.setType(Integer.class);
      localSoapObject.addProperty(localPropertyInfo4);
      PropertyInfo localPropertyInfo5 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo5.<init>();
      localPropertyInfo5.setName("inToken");
      localPropertyInfo5.setValue("dG9rZW5Ad2ViQGFwcG9pbnQjbmlj");
      localObject1 = String.class;
      localPropertyInfo5.setType(localObject1);
      localSoapObject.addProperty(localPropertyInfo5);
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
    Object localObject1 = this;
    Object localObject2 = dlog;
    boolean bool1 = ((ProgressDialog)localObject2).isShowing();
    if (bool1)
    {
      localObject2 = dlog;
      ((ProgressDialog)localObject2).dismiss();
    }
    localObject1 = this;
    localObject2 = ShowUIDAIData.access$200(this$0);
    Object localObject3 = "fixAppointment";
    bool1 = ((String)localObject2).equals(localObject3);
    if (bool1)
    {
      localObject2 = this$0.finalresp;
      localObject3 = "{}";
      bool1 = ((String)localObject2).equals(localObject3);
      if (bool1)
      {
        localObject2 = this$0;
        localObject3 = "ERROR";
        ShowUIDAIData.access$100((ShowUIDAIData)localObject2, (String)localObject3);
      }
    }
    try
    {
      JSONObject localJSONObject1 = new org/json/JSONObject;
      localObject1 = paramString;
      localJSONObject1.<init>(paramString);
      localObject1 = this;
      localObject2 = this$0;
      localObject2 = ShowUIDAIData.access$200((ShowUIDAIData)localObject2);
      localObject3 = "getAvailabledatelist";
      bool1 = ((String)localObject2).equals(localObject3);
      if (bool1)
      {
        localObject2 = this$0;
        localObject2 = list;
        ((List)localObject2).clear();
        localObject2 = this$0;
        localObject2 = id;
        ((List)localObject2).clear();
        localObject2 = "data";
        localObject2 = localJSONObject1.get((String)localObject2);
        String str1 = localObject2.toString();
        JSONObject localJSONObject2 = new org/json/JSONObject;
        localJSONObject2.<init>(str1);
        localObject2 = "calenderData";
        JSONArray localJSONArray1 = localJSONObject2.optJSONArray((String)localObject2);
        localObject2 = "eventCalender";
        JSONArray localJSONArray2 = localJSONObject2.optJSONArray((String)localObject2);
        localObject2 = this$0;
        localObject2 = id;
        localObject3 = "0";
        ((List)localObject2).add(localObject3);
        int n = 0;
        boolean bool4;
        for (;;)
        {
          int i = localJSONArray1.length();
          if (n >= i) {
            break;
          }
          int i1 = 0;
          JSONObject localJSONObject3 = localJSONArray1.getJSONObject(n);
          localObject2 = "flag";
          localObject2 = localJSONObject3.getString((String)localObject2);
          localObject3 = "4";
          boolean bool2 = ((String)localObject2).equals(localObject3);
          if (bool2) {
            i1 = 1;
          }
          localObject2 = "flag";
          localObject2 = localJSONObject3.getString((String)localObject2);
          localObject3 = "2";
          bool2 = ((String)localObject2).equals(localObject3);
          if (bool2) {
            i1 = 1;
          }
          localObject2 = "flag";
          localObject2 = localJSONObject3.getString((String)localObject2);
          localObject3 = "1";
          bool2 = ((String)localObject2).equals(localObject3);
          String str2;
          JSONObject localJSONObject4;
          if (bool2)
          {
            i2 = 0;
            for (;;)
            {
              int j = localJSONArray2.length();
              if (i2 >= j) {
                break;
              }
              localObject2 = "day_";
              str2 = localJSONObject3.getString((String)localObject2);
              localJSONObject4 = localJSONArray2.getJSONObject(i2);
              localObject2 = "calender_day";
              localObject2 = localJSONObject4.getString((String)localObject2);
              bool3 = ((String)localObject2).equals(str2);
              if (bool3) {
                i1 = 1;
              }
              i2 += 1;
            }
            if (i1 == 0)
            {
              localObject1 = this;
              localObject2 = this$0;
              localObject2 = list;
              localObject3 = "app_date_";
              localObject1 = localObject3;
              localObject3 = localJSONObject3.getString((String)localObject3);
              ((List)localObject2).add(localObject3);
            }
          }
          localObject2 = "flag";
          localObject2 = localJSONObject3.getString((String)localObject2);
          localObject3 = "3";
          boolean bool3 = ((String)localObject2).equals(localObject3);
          if (bool3)
          {
            i2 = 0;
            for (;;)
            {
              int k = localJSONArray2.length();
              if (i2 >= k) {
                break;
              }
              localObject2 = "day_";
              str2 = localJSONObject3.getString((String)localObject2);
              localJSONObject4 = localJSONArray2.getJSONObject(i2);
              localObject2 = "calender_day";
              localObject2 = localJSONObject4.getString((String)localObject2);
              bool4 = ((String)localObject2).equals(str2);
              if (bool4) {
                i1 = 1;
              }
              i2 += 1;
            }
            if (i1 == 0)
            {
              localObject1 = this;
              localObject2 = this$0;
              localObject2 = list;
              localObject3 = "app_date_";
              localObject1 = localObject3;
              localObject3 = localJSONObject3.getString((String)localObject3);
              ((List)localObject2).add(localObject3);
            }
          }
          n += 1;
        }
        localObject1 = this;
        localObject3 = this$0;
        localObject1 = this;
        localObject2 = this$0;
        localObject2 = list;
        localObject1 = this$0;
        Object localObject4 = localObject1;
        localObject1 = list;
        localObject4 = localObject1;
        int i3 = ((List)localObject1).size();
        int i4 = i3;
        localObject1 = new String[i3];
        localObject4 = localObject1;
        localObject2 = ((List)localObject2).toArray((Object[])localObject1);
        localObject2 = (String[])localObject2;
        localObject1 = localObject3;
        date = ((String[])localObject2);
        n = 0;
        localObject1 = this;
        localObject2 = this$0;
        localObject2 = list;
        Iterator localIterator = ((List)localObject2).iterator();
        for (;;)
        {
          bool4 = localIterator.hasNext();
          if (!bool4) {
            break;
          }
          Object localObject5 = localIterator.next();
          localObject5 = (String)localObject5;
          localObject1 = this;
          localObject2 = this$0;
          localObject2 = datelist;
          ((List)localObject2).add(localObject5);
          n += 1;
        }
        localObject1 = this;
        localObject2 = this$0;
        localObject1 = this$0;
        localObject3 = localObject1;
        i4 = limit;
        localObject1 = new String[i4];
        localObject3 = localObject1;
        date = ((String[])localObject1);
        localObject1 = this;
        localObject2 = this$0;
        localObject2 = date;
        localObject3 = null;
        localObject1 = this$0;
        localObject4 = localObject1;
        localObject4 = ((ShowUIDAIData)localObject1).getResources();
        int i5 = 2131034139;
        localObject4 = ((Resources)localObject4).getString(i5);
        localObject2[0] = localObject4;
        int i2 = 1;
        for (;;)
        {
          int m = 10;
          if (i2 >= m) {
            break;
          }
          localObject1 = this;
          localObject2 = this$0;
          localObject3 = date;
          localObject1 = this;
          localObject2 = this$0;
          localObject2 = datelist;
          localObject2 = ((List)localObject2).get(i2);
          localObject2 = (String)localObject2;
          localObject3[i2] = localObject2;
          i2 += 1;
        }
        localObject1 = this;
        localObject2 = this$0;
        localObject2 = mdate;
        localObject3 = new android/widget/ArrayAdapter;
        localObject1 = this$0;
        localObject4 = localObject1;
        localObject4 = ((ShowUIDAIData)localObject1).getApplicationContext();
        i5 = 2130903050;
        localObject1 = this;
        localObject1 = this$0;
        localObject1 = date;
        ((ArrayAdapter)localObject3).<init>((Context)localObject4, i5, (Object[])localObject1);
        ((Spinner)localObject2).setAdapter((SpinnerAdapter)localObject3);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowUIDAIData$CallListagain.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */