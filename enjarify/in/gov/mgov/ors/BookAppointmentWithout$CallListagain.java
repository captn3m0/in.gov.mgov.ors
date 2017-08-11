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

class BookAppointmentWithout$CallListagain
  extends AsyncTask
{
  private ProgressDialog dlog;
  
  private BookAppointmentWithout$CallListagain(BookAppointmentWithout paramBookAppointmentWithout) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    int i = 1;
    localObject1 = this$0;
    int j = 0;
    localObject2 = paramVarArgs[0];
    BookAppointmentWithout.access$202((BookAppointmentWithout)localObject1, (String)localObject2);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localObject2 = BookAppointmentWithout.access$200(this$0);
    localSoapObject.<init>("http://orsws/", (String)localObject2);
    localObject1 = BookAppointmentWithout.access$200(this$0);
    localObject2 = "getAvailabledatelist";
    boolean bool = ((String)localObject1).equals(localObject2);
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
      k = this$0.departmentcode;
      localObject1 = Integer.valueOf(k);
      localPropertyInfo2.setValue(localObject1);
      localPropertyInfo2.setType(Integer.class);
      localSoapObject.addProperty(localPropertyInfo2);
      PropertyInfo localPropertyInfo3 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo3.<init>();
      localPropertyInfo3.setName("appointmentcat");
      localObject1 = Integer.valueOf(i);
      localPropertyInfo3.setValue(localObject1);
      localPropertyInfo3.setType(Integer.class);
      localSoapObject.addProperty(localPropertyInfo3);
      PropertyInfo localPropertyInfo4 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo4.<init>();
      localPropertyInfo4.setName("calmonth");
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
    int k = 110;
    localSoapSerializationEnvelope.<init>(k);
    localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
    HttpTransportSE localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
    j = 60000;
    localHttpTransportSE.<init>("http://ors.gov.in/ORSServicecontainer/services?wsdl", j);
    localObject1 = "http://orsws/";
    try
    {
      localHttpTransportSE.call((String)localObject1, localSoapSerializationEnvelope);
      Object localObject3 = localSoapSerializationEnvelope.getResponse();
      localObject3 = (SoapPrimitive)localObject3;
      localObject1 = this$0;
      localObject2 = ((SoapPrimitive)localObject3).toString();
      finalresp = ((String)localObject2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = this$0;
        localObject2 = new in/gov/mgov/ors/BookAppointmentWithout$CallListagain$1;
        ((BookAppointmentWithout.CallListagain.1)localObject2).<init>(this);
        ((BookAppointmentWithout)localObject1).runOnUiThread((Runnable)localObject2);
      }
    }
    return this$0.finalresp;
  }
  
  protected void onPostExecute(String paramString)
  {
    super.onPostExecute(paramString);
    Object localObject1 = this;
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
    Object localObject3;
    int i1;
    int i3;
    int m;
    int i4;
    Object localObject5;
    int i5;
    int i6;
    try
    {
      JSONObject localJSONObject1 = new org/json/JSONObject;
      localObject1 = paramString;
      localJSONObject1.<init>(paramString);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = BookAppointmentWithout.access$200((BookAppointmentWithout)localObject1);
      localObject3 = "getAvailabledatelist";
      bool1 = ((String)localObject2).equals(localObject3);
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
        localObject3 = "0";
        ((List)localObject1).add(localObject3);
        int n = 0;
        boolean bool4;
        for (;;)
        {
          int i = localJSONArray1.length();
          i1 = i;
          if (n >= i) {
            break;
          }
          int i2 = 0;
          JSONObject localJSONObject3 = localJSONArray1.getJSONObject(n);
          localObject2 = "flag";
          localObject1 = localObject2;
          localObject2 = localJSONObject3.getString((String)localObject2);
          localObject3 = "4";
          boolean bool2 = ((String)localObject2).equals(localObject3);
          if (bool2) {
            i2 = 1;
          }
          localObject2 = "flag";
          localObject1 = localObject2;
          localObject2 = localJSONObject3.getString((String)localObject2);
          localObject3 = "2";
          bool2 = ((String)localObject2).equals(localObject3);
          if (bool2) {
            i2 = 1;
          }
          localObject2 = "flag";
          localObject1 = localObject2;
          localObject2 = localJSONObject3.getString((String)localObject2);
          localObject3 = "1";
          bool2 = ((String)localObject2).equals(localObject3);
          String str2;
          JSONObject localJSONObject4;
          if (bool2)
          {
            i3 = 0;
            for (;;)
            {
              int j = localJSONArray2.length();
              i1 = j;
              if (i3 >= j) {
                break;
              }
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
            }
            if (i2 == 0)
            {
              localObject1 = this;
              localObject1 = this$0;
              localObject2 = localObject1;
              localObject2 = list;
              localObject3 = "app_date_";
              localObject1 = localObject3;
              localObject3 = localJSONObject3.getString((String)localObject3);
              ((List)localObject2).add(localObject3);
            }
          }
          localObject2 = "flag";
          localObject1 = localObject2;
          localObject2 = localJSONObject3.getString((String)localObject2);
          localObject3 = "3";
          boolean bool3 = ((String)localObject2).equals(localObject3);
          if (bool3)
          {
            i3 = 0;
            for (;;)
            {
              int k = localJSONArray2.length();
              i1 = k;
              if (i3 >= k) {
                break;
              }
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
            }
            if (i2 == 0)
            {
              localObject1 = this;
              localObject1 = this$0;
              localObject2 = localObject1;
              localObject2 = list;
              localObject3 = "app_date_";
              localObject1 = localObject3;
              localObject3 = localJSONObject3.getString((String)localObject3);
              ((List)localObject2).add(localObject3);
            }
          }
          n += 1;
        }
        n = 0;
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject1 = list;
        localObject2 = localObject1;
        Iterator localIterator = ((List)localObject1).iterator();
        for (;;)
        {
          bool4 = localIterator.hasNext();
          if (!bool4) {
            break;
          }
          Object localObject4 = localIterator.next();
          localObject4 = (String)localObject4;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = datelist;
          localObject2 = localObject1;
          ((List)localObject1).add(localObject4);
          n += 1;
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject1 = datelist;
        localObject2 = localObject1;
        m = ((List)localObject1).size();
        if (m != 0)
        {
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = datelist;
          localObject2 = localObject1;
          m = ((List)localObject1).size();
          localObject1 = this;
          localObject1 = this$0;
          localObject3 = localObject1;
          i1 = limit;
          i4 = i1;
          i4 = i1 + 1;
          i1 = m;
          if (m > i4)
          {
            localObject1 = this;
            localObject2 = this$0;
            localObject1 = this;
            localObject1 = this$0;
            localObject3 = localObject1;
            i1 = limit;
            i4 = i1;
            i4 = i1 + 1;
            i1 = i4;
            localObject1 = new String[i4];
            localObject3 = localObject1;
            date = ((String[])localObject1);
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = date;
            i4 = 0;
            localObject3 = null;
            localObject1 = this;
            localObject1 = this$0;
            localObject5 = localObject1;
            localObject5 = ((BookAppointmentWithout)localObject1).getResources();
            i5 = 2131034139;
            localObject5 = ((Resources)localObject5).getString(i5);
            localObject2[0] = localObject5;
            i3 = 1;
            for (;;)
            {
              localObject1 = this;
              localObject1 = this$0;
              localObject2 = localObject1;
              i1 = limit;
              m = i1;
              if (i3 >= i1) {
                break label1070;
              }
              localObject1 = this;
              try
              {
                localObject1 = this$0;
                localObject2 = localObject1;
                localObject3 = date;
                localObject1 = this;
                localObject1 = this$0;
                localObject2 = localObject1;
                localObject1 = datelist;
                localObject2 = localObject1;
                i6 = i3 + -1;
                localObject2 = ((List)localObject1).get(i6);
                localObject2 = (String)localObject2;
                localObject3[i3] = localObject2;
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  localObject1 = this;
                  localObject1 = this$0;
                  localObject2 = localObject1;
                  localObject3 = new in/gov/mgov/ors/BookAppointmentWithout$CallListagain$2;
                  localObject1 = localObject3;
                  ((BookAppointmentWithout.CallListagain.2)localObject3).<init>(this);
                  ((BookAppointmentWithout)localObject2).runOnUiThread((Runnable)localObject3);
                }
              }
              i3 += 1;
            }
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localObject1 = this;
      localObject2 = this$0;
      localObject3 = new in/gov/mgov/ors/BookAppointmentWithout$CallListagain$7;
      localObject1 = localObject3;
      ((BookAppointmentWithout.CallListagain.7)localObject3).<init>(this);
      ((BookAppointmentWithout)localObject2).runOnUiThread((Runnable)localObject3);
    }
    for (;;)
    {
      label1070:
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject3 = date;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      i1 = limit;
      i6 = i1;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = datelist;
      localObject1 = this;
      localObject1 = this$0;
      i1 = limit;
      i5 = i1;
      i5 = i1 + -1;
      localObject1 = localObject2;
      localObject2 = ((List)localObject2).get(i5);
      localObject2 = (String)localObject2;
      localObject3[i6] = localObject2;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = date;
      localObject2 = localObject1;
      i1 = localObject1.length;
      m = i1;
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      i4 = limit;
      i1 = m;
      if (m > i4)
      {
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject3 = new in/gov/mgov/ors/BookAppointmentWithout$CallListagain$3;
        localObject1 = localObject3;
        ((BookAppointmentWithout.CallListagain.3)localObject3).<init>(this);
        ((BookAppointmentWithout)localObject2).runOnUiThread((Runnable)localObject3);
      }
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = mdate;
      localObject2 = localObject1;
      localObject3 = new android/widget/ArrayAdapter;
      localObject1 = this;
      localObject1 = this$0;
      localObject5 = localObject1;
      localObject5 = ((BookAppointmentWithout)localObject1).getApplicationContext();
      i5 = 2130903050;
      localObject1 = this;
      localObject1 = this$0;
      localObject1 = date;
      ((ArrayAdapter)localObject3).<init>((Context)localObject5, i5, (Object[])localObject1);
      ((Spinner)localObject2).setAdapter((SpinnerAdapter)localObject3);
      continue;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = datelist;
      localObject2 = localObject1;
      m = ((List)localObject1).size();
      if (m != 0)
      {
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject1 = datelist;
        localObject2 = localObject1;
        m = ((List)localObject1).size();
        localObject1 = this;
        localObject1 = this$0;
        localObject3 = localObject1;
        i4 = limit;
        i1 = m;
        if (m <= i4)
        {
          localObject1 = this;
          localObject2 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject3 = localObject1;
          localObject1 = datelist;
          localObject3 = localObject1;
          i4 = ((List)localObject1).size() + 1;
          i1 = i4;
          localObject1 = new String[i4];
          localObject3 = localObject1;
          date = ((String[])localObject1);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = date;
          i4 = 0;
          localObject3 = null;
          localObject1 = this;
          localObject1 = this$0;
          localObject5 = localObject1;
          localObject5 = ((BookAppointmentWithout)localObject1).getResources();
          i5 = 2131034139;
          localObject5 = ((Resources)localObject5).getString(i5);
          localObject2[0] = localObject5;
          i3 = 1;
          for (;;)
          {
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject1 = datelist;
            localObject2 = localObject1;
            m = ((List)localObject1).size();
            i1 = m;
            if (i3 >= m) {
              break label1640;
            }
            localObject1 = this;
            try
            {
              localObject1 = this$0;
              localObject2 = localObject1;
              localObject3 = date;
              localObject1 = this;
              localObject1 = this$0;
              localObject2 = localObject1;
              localObject1 = datelist;
              localObject2 = localObject1;
              i6 = i3 + -1;
              localObject2 = ((List)localObject1).get(i6);
              localObject2 = (String)localObject2;
              localObject3[i3] = localObject2;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                localObject1 = this;
                localObject1 = this$0;
                localObject2 = localObject1;
                localObject3 = new in/gov/mgov/ors/BookAppointmentWithout$CallListagain$4;
                localObject1 = localObject3;
                ((BookAppointmentWithout.CallListagain.4)localObject3).<init>(this);
                ((BookAppointmentWithout)localObject2).runOnUiThread((Runnable)localObject3);
              }
            }
            i3 += 1;
          }
          label1640:
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject3 = date;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = datelist;
          localObject2 = localObject1;
          i6 = ((List)localObject1).size();
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = datelist;
          localObject1 = this;
          localObject1 = this$0;
          localObject1 = datelist;
          i5 = ((List)localObject1).size() + -1;
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).get(i5);
          localObject2 = (String)localObject2;
          localObject3[i6] = localObject2;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject3 = new in/gov/mgov/ors/BookAppointmentWithout$CallListagain$5;
          localObject1 = localObject3;
          ((BookAppointmentWithout.CallListagain.5)localObject3).<init>(this);
          ((BookAppointmentWithout)localObject2).runOnUiThread((Runnable)localObject3);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = mdate;
          localObject2 = localObject1;
          localObject3 = new android/widget/ArrayAdapter;
          localObject1 = this;
          localObject1 = this$0;
          localObject5 = localObject1;
          localObject5 = ((BookAppointmentWithout)localObject1).getApplicationContext();
          i5 = 2130903050;
          localObject1 = this;
          localObject1 = this$0;
          localObject1 = date;
          ((ArrayAdapter)localObject3).<init>((Context)localObject5, i5, (Object[])localObject1);
          ((Spinner)localObject2).setAdapter((SpinnerAdapter)localObject3);
          continue;
        }
      }
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject3 = new in/gov/mgov/ors/BookAppointmentWithout$CallListagain$6;
      localObject1 = localObject3;
      ((BookAppointmentWithout.CallListagain.6)localObject3).<init>(this);
      ((BookAppointmentWithout)localObject2).runOnUiThread((Runnable)localObject3);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointmentWithout$CallListagain.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */