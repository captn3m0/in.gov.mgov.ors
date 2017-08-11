package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
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

class BookAppointment$CallListagain
  extends AsyncTask
{
  private ProgressDialog dlog;
  
  private BookAppointment$CallListagain(BookAppointment paramBookAppointment) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    Object localObject1 = this$0;
    String str = paramVarArgs[0];
    BookAppointment.access$202((BookAppointment)localObject1, str);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    str = BookAppointment.access$200(this$0);
    localSoapObject.<init>("http://orsws/", str);
    localObject1 = BookAppointment.access$200(this$0);
    str = "getAvailabledatelist";
    int i = ((String)localObject1).equals(str);
    if (i != 0)
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
      i = 1;
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
    int j = 110;
    localSoapSerializationEnvelope.<init>(j);
    localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
    HttpTransportSE localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
    int k = 60000;
    localHttpTransportSE.<init>("http://ors.gov.in/ORSServicecontainer/services?wsdl", k);
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
    localObject1 = this;
    localObject1 = dlog;
    Object localObject2 = localObject1;
    boolean bool1 = ((ProgressDialog)localObject1).isShowing();
    if (bool1)
    {
      localObject1 = this;
      localObject1 = dlog;
      localObject2 = localObject1;
      ((ProgressDialog)localObject1).dismiss();
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = new org/json/JSONObject;
        localObject1 = paramString;
        localJSONObject1.<init>(paramString);
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = BookAppointment.access$200((BookAppointment)localObject1);
        localObject4 = "getAvailabledatelist";
        bool1 = ((String)localObject2).equals(localObject4);
        if (bool1)
        {
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = list;
          localObject2 = localObject1;
          ((List)localObject1).clear();
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = id;
          localObject2 = localObject1;
          ((List)localObject1).clear();
          localObject2 = "data";
          localObject1 = localObject2;
          localObject2 = localJSONObject1.get((String)localObject2);
          String str1 = localObject2.toString();
          JSONObject localJSONObject2 = new org/json/JSONObject;
          localJSONObject2.<init>(str1);
          localObject2 = "calenderData";
          localObject1 = localObject2;
          JSONArray localJSONArray1 = localJSONObject2.optJSONArray((String)localObject2);
          localObject2 = "eventCalender";
          localObject1 = localObject2;
          JSONArray localJSONArray2 = localJSONObject2.optJSONArray((String)localObject2);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = id;
          localObject2 = localObject1;
          localObject4 = "0";
          ((List)localObject1).add(localObject4);
          int n = 0;
          int i = localJSONArray1.length();
          int i1 = i;
          if (n < i)
          {
            int i2 = 0;
            JSONObject localJSONObject3 = localJSONArray1.getJSONObject(n);
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject3.getString((String)localObject2);
            localObject4 = "4";
            boolean bool2 = ((String)localObject2).equals(localObject4);
            if (bool2) {
              i2 = 1;
            }
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject3.getString((String)localObject2);
            localObject4 = "2";
            bool2 = ((String)localObject2).equals(localObject4);
            if (bool2) {
              i2 = 1;
            }
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject3.getString((String)localObject2);
            localObject4 = "1";
            bool2 = ((String)localObject2).equals(localObject4);
            String str2;
            JSONObject localJSONObject4;
            if (bool2)
            {
              i3 = 0;
              int j = localJSONArray2.length();
              i1 = j;
              if (i3 < j)
              {
                localObject2 = "day_";
                localObject1 = localObject2;
                str2 = localJSONObject3.getString((String)localObject2);
                localJSONObject4 = localJSONArray2.getJSONObject(i3);
                localObject2 = "calender_day";
                localObject1 = localObject2;
                localObject2 = localJSONObject4.getString((String)localObject2);
                localObject1 = localObject2;
                bool3 = ((String)localObject2).equals(str2);
                if (bool3) {
                  i2 = 1;
                }
                i3 += 1;
                continue;
              }
              if (i2 == 0)
              {
                localObject1 = this;
                localObject1 = this$0;
                localObject2 = localObject1;
                localObject2 = list;
                localObject4 = "app_date_";
                localObject1 = localObject4;
                localObject4 = localJSONObject3.getString((String)localObject4);
                ((List)localObject2).add(localObject4);
              }
            }
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject3.getString((String)localObject2);
            localObject4 = "3";
            boolean bool3 = ((String)localObject2).equals(localObject4);
            if (bool3)
            {
              i3 = 0;
              int k = localJSONArray2.length();
              i1 = k;
              if (i3 < k)
              {
                localObject2 = "day_";
                localObject1 = localObject2;
                str2 = localJSONObject3.getString((String)localObject2);
                localJSONObject4 = localJSONArray2.getJSONObject(i3);
                localObject2 = "calender_day";
                localObject1 = localObject2;
                localObject2 = localJSONObject4.getString((String)localObject2);
                localObject1 = localObject2;
                bool4 = ((String)localObject2).equals(str2);
                if (bool4) {
                  i2 = 1;
                }
                i3 += 1;
                continue;
              }
              if (i2 == 0)
              {
                localObject1 = this;
                localObject1 = this$0;
                localObject2 = localObject1;
                localObject2 = list;
                localObject4 = "app_date_";
                localObject1 = localObject4;
                localObject4 = localJSONObject3.getString((String)localObject4);
                ((List)localObject2).add(localObject4);
              }
            }
            n += 1;
            continue;
          }
          localObject1 = this;
          localObject4 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = list;
          localObject1 = this;
          localObject1 = this$0;
          localObject5 = localObject1;
          localObject1 = list;
          localObject5 = localObject1;
          i4 = ((List)localObject1).size();
          i1 = i4;
          localObject5 = new String[i4];
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).toArray((Object[])localObject5);
          localObject2 = (String[])localObject2;
          localObject1 = localObject2;
          date = ((String[])localObject2);
          n = 0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = list;
          localObject2 = localObject1;
          Iterator localIterator = ((List)localObject1).iterator();
          boolean bool4 = localIterator.hasNext();
          if (bool4)
          {
            Object localObject6 = localIterator.next();
            localObject6 = (String)localObject6;
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject1 = datelist;
            localObject2 = localObject1;
            ((List)localObject1).add(localObject6);
            n += 1;
            continue;
          }
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = datelist;
          localObject2 = localObject1;
          int m = ((List)localObject1).size();
          if (m == 0) {
            continue;
          }
          localObject1 = this;
          localObject2 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          i1 = limit;
          int i5 = i1;
          i5 = i1 + 1;
          i1 = i5;
          localObject1 = new String[i5];
          localObject4 = localObject1;
          date = ((String[])localObject1);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = date;
          localObject2 = localObject1;
          i5 = 0;
          localObject4 = null;
          localObject5 = "-Available date-";
          localObject1[0] = localObject5;
          int i3 = 1;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          i1 = limit;
          m = i1;
          if (i3 < i1)
          {
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject4 = date;
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject1 = datelist;
            localObject2 = localObject1;
            i4 = i3 + -1;
            localObject2 = ((List)localObject1).get(i4);
            localObject2 = (String)localObject2;
            localObject4[i3] = localObject2;
            i3 += 1;
            continue;
          }
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject4 = date;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          i1 = limit;
          i4 = i1;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = datelist;
          localObject1 = this;
          localObject1 = this$0;
          i1 = limit;
          i6 = i1;
          i6 = i1 + -1;
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).get(i6);
          localObject2 = (String)localObject2;
          localObject4[i4] = localObject2;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = date;
          localObject2 = localObject1;
          i1 = localObject1.length;
          m = i1;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          i5 = limit;
          i1 = m;
          if (m > i5)
          {
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject4 = new in/gov/mgov/ors/BookAppointment$CallListagain$1;
            localObject1 = localObject4;
            ((BookAppointment.CallListagain.1)localObject4).<init>(this);
            ((BookAppointment)localObject2).runOnUiThread((Runnable)localObject4);
          }
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = mdate;
          localObject2 = localObject1;
          localObject4 = new android/widget/ArrayAdapter;
          localObject1 = this;
          localObject1 = this$0;
          localObject5 = localObject1;
          localObject5 = ((BookAppointment)localObject1).getApplicationContext();
          i6 = 2130903050;
          localObject1 = this;
          localObject1 = this$0;
          localObject1 = date;
          ((ArrayAdapter)localObject4).<init>((Context)localObject5, i6, (Object[])localObject1);
          ((Spinner)localObject2).setAdapter((SpinnerAdapter)localObject4);
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = BookAppointment.access$200((BookAppointment)localObject1);
        localObject4 = "fixAppointment";
        bool5 = ((String)localObject2).equals(localObject4);
        if (!bool5) {
          continue;
        }
        localObject2 = "error_code";
        localObject1 = localObject2;
        localObject2 = localJSONObject1.getString((String)localObject2);
        localObject4 = "0";
        bool5 = ((String)localObject2).equals(localObject4);
        if (!bool5) {
          continue;
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>();
        localObject1 = this;
        localObject1 = this$0;
        Object localObject5 = localObject1;
        localObject5 = ((BookAppointment)localObject1).getResources();
        int i6 = 2131034320;
        localObject5 = ((Resources)localObject5).getString(i6);
        localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
        localObject5 = " : ";
        localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
        localObject5 = "appointment_id";
        localObject1 = localObject5;
        localObject5 = localJSONObject1.getString((String)localObject5);
        localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
        localObject4 = ((StringBuilder)localObject4).toString();
        BookAppointment.access$100((BookAppointment)localObject2, (String)localObject4);
        Intent localIntent = new android/content/Intent;
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = ((BookAppointment)localObject1).getApplicationContext();
        localObject4 = ShowAppointment.class;
        localObject1 = localObject2;
        localIntent.<init>((Context)localObject2, (Class)localObject4);
        localObject2 = "uid_data";
        localObject1 = this;
        localObject1 = this$0;
        localObject4 = localObject1;
        localObject4 = uidData;
        localObject1 = localObject2;
        localIntent.putExtra((String)localObject2, (String[])localObject4);
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = editor;
        localObject4 = "appointment_id";
        localObject5 = "appointment_id";
        localObject1 = localObject5;
        localObject5 = localJSONObject1.getString((String)localObject5);
        localObject2 = ((SharedPreferences.Editor)localObject2).putString((String)localObject4, (String)localObject5);
        ((SharedPreferences.Editor)localObject2).commit();
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = editor;
        localObject4 = "UHID";
        localObject5 = "hid";
        localObject1 = localObject5;
        localObject5 = localJSONObject1.getString((String)localObject5);
        localObject2 = ((SharedPreferences.Editor)localObject2).putString((String)localObject4, (String)localObject5);
        ((SharedPreferences.Editor)localObject2).commit();
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        ((BookAppointment)localObject1).startActivity(localIntent);
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject1;
        int i4;
        continue;
        Object localObject3 = "error_code";
        localObject1 = localObject3;
        localObject3 = localJSONObject1.getString((String)localObject3);
        Object localObject4 = "0";
        boolean bool5 = ((String)localObject3).equals(localObject4);
        if (!bool5) {
          continue;
        }
        localObject1 = this;
        localObject3 = this$0;
        localObject4 = "error_string";
        localObject1 = localObject4;
        localObject4 = localJSONObject1.getString((String)localObject4);
        BookAppointment.access$100((BookAppointment)localObject3, (String)localObject4);
        continue;
        localObject1 = this;
        localObject3 = this$0;
        localObject4 = "error_string";
        localObject1 = localObject4;
        localObject4 = localJSONObject1.getString((String)localObject4);
        BookAppointment.access$100((BookAppointment)localObject3, (String)localObject4);
        continue;
      }
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = finalresp;
      localObject2 = localObject1;
      localObject4 = "{}";
      bool5 = ((String)localObject1).equals(localObject4);
      if (bool5)
      {
        localObject1 = this;
        localObject2 = this$0;
        localObject1 = this;
        localObject1 = this$0;
        localObject4 = localObject1;
        localObject4 = ((BookAppointment)localObject1).getResources();
        i4 = 2131034203;
        localObject4 = ((Resources)localObject4).getString(i4);
        BookAppointment.access$100((BookAppointment)localObject2, (String)localObject4);
      }
      return;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject4 = new in/gov/mgov/ors/BookAppointment$CallListagain$2;
      localObject1 = localObject4;
      ((BookAppointment.CallListagain.2)localObject4).<init>(this);
      ((BookAppointment)localObject2).runOnUiThread((Runnable)localObject4);
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
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointment$CallListagain.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */