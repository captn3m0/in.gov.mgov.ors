package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.AsyncTask;
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

class BookAppointmentWithout$CallList
  extends AsyncTask
{
  private ProgressDialog dlog;
  
  private BookAppointmentWithout$CallList(BookAppointmentWithout paramBookAppointmentWithout) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    localObject1 = this$0;
    int i = 0;
    localObject2 = paramVarArgs[0];
    BookAppointmentWithout.access$202((BookAppointmentWithout)localObject1, (String)localObject2);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localObject2 = BookAppointmentWithout.access$200(this$0);
    localSoapObject.<init>("http://orsws/", (String)localObject2);
    localObject1 = BookAppointmentWithout.access$200(this$0);
    localObject2 = "getHospitallist";
    boolean bool1 = ((String)localObject1).equals(localObject2);
    PropertyInfo localPropertyInfo1;
    if (bool1)
    {
      localPropertyInfo1 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo1.<init>();
      localPropertyInfo1.setName("stateid");
      int j = 7;
      localObject1 = Integer.valueOf(j);
      localPropertyInfo1.setValue(localObject1);
      localObject1 = Integer.class;
      localPropertyInfo1.setType(localObject1);
      localSoapObject.addProperty(localPropertyInfo1);
    }
    localObject1 = BookAppointmentWithout.access$200(this$0);
    localObject2 = "getDepartmentlist";
    boolean bool2 = ((String)localObject1).equals(localObject2);
    String str;
    int n;
    if (bool2)
    {
      localObject1 = this$0;
      localObject2 = this$0.hospitalid;
      str = paramVarArgs[1];
      n = Integer.parseInt(str);
      i = Integer.parseInt(localObject2[n]);
      hospitalcode = i;
      localPropertyInfo1 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo1.<init>();
      localPropertyInfo1.setName("hospitalid");
      localObject1 = this$0.hospitalid;
      localObject2 = paramVarArgs[1];
      i = Integer.parseInt((String)localObject2);
      localObject1 = localObject1[i];
      localPropertyInfo1.setValue(localObject1);
      localObject1 = Integer.class;
      localPropertyInfo1.setType(localObject1);
      localSoapObject.addProperty(localPropertyInfo1);
    }
    localObject1 = BookAppointmentWithout.access$200(this$0);
    localObject2 = "getSuperSpacialityMsg";
    bool2 = ((String)localObject1).equals(localObject2);
    PropertyInfo localPropertyInfo2;
    PropertyInfo localPropertyInfo3;
    if (bool2)
    {
      localPropertyInfo2 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo2.<init>();
      localPropertyInfo2.setName("intoken");
      localPropertyInfo2.setValue("dG9rZW5Ad2ViQGFwcG9pbnQjbmlj");
      localPropertyInfo2.setType(String.class);
      localSoapObject.addProperty(localPropertyInfo2);
      localPropertyInfo3 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo3.<init>();
      localPropertyInfo3.setName("dept_id");
      localObject1 = Integer.valueOf(this$0.departmentcode);
      localPropertyInfo3.setValue(localObject1);
      localPropertyInfo3.setType(Integer.class);
      localSoapObject.addProperty(localPropertyInfo3);
      localPropertyInfo1 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo1.<init>();
      localPropertyInfo1.setName("hos_id");
      int k = this$0.hospitalcode;
      localObject1 = Integer.valueOf(k);
      localPropertyInfo1.setValue(localObject1);
      localObject1 = Integer.class;
      localPropertyInfo1.setType(localObject1);
      localSoapObject.addProperty(localPropertyInfo1);
    }
    localObject1 = BookAppointmentWithout.access$200(this$0);
    localObject2 = "getAvailabledatelist";
    boolean bool3 = ((String)localObject1).equals(localObject2);
    if (bool3)
    {
      localObject1 = this$0;
      localObject2 = this$0.departmentid;
      str = paramVarArgs[1];
      n = Integer.parseInt(str);
      i = Integer.parseInt(localObject2[n]);
      departmentcode = i;
      localPropertyInfo1 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo1.<init>();
      localPropertyInfo1.setName("hospitalid");
      localObject1 = Integer.valueOf(this$0.hospitalcode);
      localPropertyInfo1.setValue(localObject1);
      localPropertyInfo1.setType(Integer.class);
      localSoapObject.addProperty(localPropertyInfo1);
      localPropertyInfo3 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo3.<init>();
      localPropertyInfo3.setName("departmentid");
      localObject1 = this$0.departmentid;
      localObject2 = paramVarArgs[1];
      i = Integer.parseInt((String)localObject2);
      localObject1 = localObject1[i];
      localPropertyInfo3.setValue(localObject1);
      localPropertyInfo3.setType(Integer.class);
      localSoapObject.addProperty(localPropertyInfo3);
      PropertyInfo localPropertyInfo4 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo4.<init>();
      localPropertyInfo4.setName("appointmentcat");
      localObject1 = Integer.valueOf(1);
      localPropertyInfo4.setValue(localObject1);
      localPropertyInfo4.setType(Integer.class);
      localSoapObject.addProperty(localPropertyInfo4);
      PropertyInfo localPropertyInfo5 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo5.<init>();
      localPropertyInfo5.setName("calmonth");
      bool3 = false;
      localObject1 = Integer.valueOf(0);
      localPropertyInfo5.setValue(localObject1);
      localPropertyInfo5.setType(Integer.class);
      localSoapObject.addProperty(localPropertyInfo5);
      localPropertyInfo2 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo2.<init>();
      localPropertyInfo2.setName("inToken");
      localPropertyInfo2.setValue("dG9rZW5Ad2ViQGFwcG9pbnQjbmlj");
      localObject1 = String.class;
      localPropertyInfo2.setType(localObject1);
      localSoapObject.addProperty(localPropertyInfo2);
    }
    SoapSerializationEnvelope localSoapSerializationEnvelope = new org/ksoap2/serialization/SoapSerializationEnvelope;
    int m = 110;
    localSoapSerializationEnvelope.<init>(m);
    localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
    HttpTransportSE localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
    i = 60000;
    localHttpTransportSE.<init>("http://ors.gov.in/ORSServicecontainer/services?wsdl", i);
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
        localObject2 = new in/gov/mgov/ors/BookAppointmentWithout$CallList$1;
        ((BookAppointmentWithout.CallList.1)localObject2).<init>(this);
        ((BookAppointmentWithout)localObject1).runOnUiThread((Runnable)localObject2);
      }
    }
    return this$0.finalresp;
  }
  
  protected void onPostExecute(String paramString)
  {
    super.onPostExecute(paramString);
    localObject1 = this;
    localObject1 = dlog;
    localObject2 = localObject1;
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
        JSONObject localJSONObject1 = new org/json/JSONObject;
        localObject1 = paramString;
        localJSONObject1.<init>(paramString);
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = BookAppointmentWithout.access$200((BookAppointmentWithout)localObject1);
        localObject3 = "getStatelist";
        bool1 = ((String)localObject2).equals(localObject3);
        JSONArray localJSONArray1;
        int i2;
        int i3;
        JSONObject localJSONObject2;
        Object localObject4;
        String[] arrayOfString;
        int i4;
        int i5;
        Iterator localIterator;
        int i6;
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
          localObject2 = "statelist";
          localObject1 = localObject2;
          localJSONArray1 = localJSONObject1.optJSONArray((String)localObject2);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = list;
          localObject1 = this;
          localObject1 = this$0;
          localObject3 = localObject1;
          localObject3 = ((BookAppointmentWithout)localObject1).getResources();
          i2 = 2131034309;
          localObject3 = ((Resources)localObject3).getString(i2);
          ((List)localObject2).add(localObject3);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = id;
          localObject2 = localObject1;
          localObject3 = "0";
          ((List)localObject1).add(localObject3);
          i3 = 0;
          int i = localJSONArray1.length();
          if (i3 < i)
          {
            localJSONObject2 = localJSONArray1.getJSONObject(i3);
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = list;
            localObject3 = "statename";
            localObject1 = localObject3;
            localObject3 = localJSONObject2.getString((String)localObject3);
            ((List)localObject2).add(localObject3);
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = id;
            localObject3 = "stateid";
            localObject1 = localObject3;
            localObject3 = localJSONObject2.getString((String)localObject3);
            ((List)localObject2).add(localObject3);
            i3 += 1;
            continue;
          }
          localObject1 = this;
          localObject3 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = list;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = list;
          localObject4 = localObject1;
          i2 = ((List)localObject1).size();
          localObject4 = new String[i2];
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).toArray((Object[])localObject4);
          localObject2 = (String[])localObject2;
          localObject1 = localObject2;
          state = ((String[])localObject2);
          localObject1 = this;
          localObject3 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = id;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = id;
          localObject4 = localObject1;
          i2 = ((List)localObject1).size();
          localObject4 = new String[i2];
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).toArray((Object[])localObject4);
          localObject2 = (String[])localObject2;
          localObject1 = localObject2;
          stateid = ((String[])localObject2);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          arrayOfString = state;
          i4 = arrayOfString.length;
          i5 = 0;
          localIterator = null;
          if (i5 < i4)
          {
            localObject2 = arrayOfString[i5];
            i5 += 1;
            continue;
          }
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          arrayOfString = stateid;
          i4 = arrayOfString.length;
          i5 = 0;
          localIterator = null;
          if (i5 < i4)
          {
            localObject2 = arrayOfString[i5];
            i5 += 1;
            continue;
          }
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = mstate;
          localObject2 = localObject1;
          localObject3 = new android/widget/ArrayAdapter;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject4 = ((BookAppointmentWithout)localObject1).getApplicationContext();
          i6 = 2130903050;
          localObject1 = this;
          localObject1 = this$0;
          localObject1 = state;
          ((ArrayAdapter)localObject3).<init>((Context)localObject4, i6, (Object[])localObject1);
          ((Spinner)localObject2).setAdapter((SpinnerAdapter)localObject3);
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = BookAppointmentWithout.access$200((BookAppointmentWithout)localObject1);
        localObject3 = "getHospitallist";
        boolean bool2 = ((String)localObject2).equals(localObject3);
        int i7;
        if (bool2)
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
          localObject2 = "hospitallist";
          localObject1 = localObject2;
          localJSONArray1 = localJSONObject1.optJSONArray((String)localObject2);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = list;
          localObject1 = this;
          localObject1 = this$0;
          localObject3 = localObject1;
          localObject3 = ((BookAppointmentWithout)localObject1).getResources();
          i2 = 2131034307;
          localObject3 = ((Resources)localObject3).getString(i2);
          ((List)localObject2).add(localObject3);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = id;
          localObject2 = localObject1;
          localObject3 = "0";
          ((List)localObject1).add(localObject3);
          i3 = 0;
          int j = localJSONArray1.length();
          if (i3 < j)
          {
            localJSONObject2 = localJSONArray1.getJSONObject(i3);
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = list;
            localObject3 = "hospitalname";
            localObject1 = localObject3;
            localObject3 = localJSONObject2.getString((String)localObject3);
            ((List)localObject2).add(localObject3);
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = id;
            localObject3 = "hospitalid";
            localObject1 = localObject3;
            localObject3 = localJSONObject2.getString((String)localObject3);
            ((List)localObject2).add(localObject3);
            i3 += 1;
            continue;
          }
          localObject1 = this;
          localObject3 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = list;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = list;
          localObject4 = localObject1;
          i2 = ((List)localObject1).size();
          localObject4 = new String[i2];
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).toArray((Object[])localObject4);
          localObject2 = (String[])localObject2;
          localObject1 = localObject2;
          hospital = ((String[])localObject2);
          localObject1 = this;
          localObject3 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = id;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = id;
          localObject4 = localObject1;
          i2 = ((List)localObject1).size();
          localObject4 = new String[i2];
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).toArray((Object[])localObject4);
          localObject2 = (String[])localObject2;
          localObject1 = localObject2;
          hospitalid = ((String[])localObject2);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          arrayOfString = hospital;
          i4 = arrayOfString.length;
          i5 = 0;
          localIterator = null;
          if (i5 < i4)
          {
            localObject2 = arrayOfString[i5];
            i5 += 1;
            continue;
          }
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          arrayOfString = hospitalid;
          i4 = arrayOfString.length;
          i5 = 0;
          localIterator = null;
          if (i5 < i4)
          {
            localObject2 = arrayOfString[i5];
            i5 += 1;
            continue;
          }
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = list;
          localObject2 = localObject1;
          j = ((List)localObject1).size();
          i7 = 1;
          if (j == i7)
          {
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject3 = new in/gov/mgov/ors/BookAppointmentWithout$CallList$2;
            localObject1 = localObject3;
            ((BookAppointmentWithout.CallList.2)localObject3).<init>(this);
            ((BookAppointmentWithout)localObject2).runOnUiThread((Runnable)localObject3);
          }
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = mhospital;
          localObject2 = localObject1;
          localObject3 = new android/widget/ArrayAdapter;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject4 = ((BookAppointmentWithout)localObject1).getApplicationContext();
          i6 = 2130903050;
          localObject1 = this;
          localObject1 = this$0;
          localObject1 = hospital;
          ((ArrayAdapter)localObject3).<init>((Context)localObject4, i6, (Object[])localObject1);
          ((Spinner)localObject2).setAdapter((SpinnerAdapter)localObject3);
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = BookAppointmentWithout.access$200((BookAppointmentWithout)localObject1);
        localObject3 = "getDepartmentlist";
        boolean bool3 = ((String)localObject2).equals(localObject3);
        if (bool3)
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
          localObject2 = "departmentlist";
          localObject1 = localObject2;
          localJSONArray1 = localJSONObject1.optJSONArray((String)localObject2);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = list;
          localObject1 = this;
          localObject1 = this$0;
          localObject3 = localObject1;
          localObject3 = ((BookAppointmentWithout)localObject1).getResources();
          i2 = 2131034303;
          localObject3 = ((Resources)localObject3).getString(i2);
          ((List)localObject2).add(localObject3);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = id;
          localObject2 = localObject1;
          localObject3 = "0";
          ((List)localObject1).add(localObject3);
          i3 = 0;
          int k = localJSONArray1.length();
          if (i3 < k)
          {
            localJSONObject2 = localJSONArray1.getJSONObject(i3);
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = list;
            localObject3 = "departmentname";
            localObject1 = localObject3;
            localObject3 = localJSONObject2.getString((String)localObject3);
            ((List)localObject2).add(localObject3);
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = id;
            localObject3 = "departmentid";
            localObject1 = localObject3;
            localObject3 = localJSONObject2.getString((String)localObject3);
            ((List)localObject2).add(localObject3);
            i3 += 1;
            continue;
          }
          localObject1 = this;
          localObject3 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = list;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = list;
          localObject4 = localObject1;
          i2 = ((List)localObject1).size();
          localObject4 = new String[i2];
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).toArray((Object[])localObject4);
          localObject2 = (String[])localObject2;
          localObject1 = localObject2;
          department = ((String[])localObject2);
          localObject1 = this;
          localObject3 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = id;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = id;
          localObject4 = localObject1;
          i2 = ((List)localObject1).size();
          localObject4 = new String[i2];
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).toArray((Object[])localObject4);
          localObject2 = (String[])localObject2;
          localObject1 = localObject2;
          departmentid = ((String[])localObject2);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          arrayOfString = department;
          i4 = arrayOfString.length;
          i5 = 0;
          localIterator = null;
          if (i5 < i4)
          {
            localObject2 = arrayOfString[i5];
            i5 += 1;
            continue;
          }
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          arrayOfString = departmentid;
          i4 = arrayOfString.length;
          i5 = 0;
          localIterator = null;
          if (i5 < i4)
          {
            localObject2 = arrayOfString[i5];
            i5 += 1;
            continue;
          }
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = list;
          localObject2 = localObject1;
          k = ((List)localObject1).size();
          i7 = 1;
          if (k == i7)
          {
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject3 = new in/gov/mgov/ors/BookAppointmentWithout$CallList$3;
            localObject1 = localObject3;
            ((BookAppointmentWithout.CallList.3)localObject3).<init>(this);
            ((BookAppointmentWithout)localObject2).runOnUiThread((Runnable)localObject3);
          }
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = mdepartment;
          localObject2 = localObject1;
          localObject3 = new android/widget/ArrayAdapter;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject4 = ((BookAppointmentWithout)localObject1).getApplicationContext();
          i6 = 2130903050;
          localObject1 = this;
          localObject1 = this$0;
          localObject1 = department;
          ((ArrayAdapter)localObject3).<init>((Context)localObject4, i6, (Object[])localObject1);
          ((Spinner)localObject2).setAdapter((SpinnerAdapter)localObject3);
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = BookAppointmentWithout.access$200((BookAppointmentWithout)localObject1);
        localObject3 = "getAvailabledatelist";
        boolean bool4 = ((String)localObject2).equals(localObject3);
        if (bool4)
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
          JSONObject localJSONObject3 = new org/json/JSONObject;
          localObject1 = localJSONObject3;
          localJSONObject3.<init>(str1);
          localObject2 = "calenderData";
          localJSONArray1 = localJSONObject3.optJSONArray((String)localObject2);
          localObject2 = "eventCalender";
          JSONArray localJSONArray2 = localJSONObject3.optJSONArray((String)localObject2);
          i3 = 0;
          int m = localJSONArray1.length();
          if (i3 < m)
          {
            int i8 = 0;
            localJSONObject2 = localJSONArray1.getJSONObject(i3);
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject2.getString((String)localObject2);
            localObject3 = "4";
            boolean bool5 = ((String)localObject2).equals(localObject3);
            if (bool5) {
              i8 = 1;
            }
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject2.getString((String)localObject2);
            localObject3 = "2";
            bool5 = ((String)localObject2).equals(localObject3);
            if (bool5) {
              i8 = 1;
            }
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject2.getString((String)localObject2);
            localObject3 = "1";
            bool5 = ((String)localObject2).equals(localObject3);
            int i9;
            String str2;
            JSONObject localJSONObject4;
            if (bool5)
            {
              i9 = 0;
              int n = localJSONArray2.length();
              if (i9 < n)
              {
                localObject2 = "day_";
                localObject1 = localObject2;
                str2 = localJSONObject2.getString((String)localObject2);
                localJSONObject4 = localJSONArray2.getJSONObject(i9);
                localObject2 = "calender_day";
                localObject1 = localJSONObject4;
                localObject2 = localJSONObject4.getString((String)localObject2);
                localObject1 = localObject2;
                bool6 = ((String)localObject2).equals(str2);
                if (bool6) {
                  i8 = 1;
                }
                i9 += 1;
                continue;
              }
              if (i8 == 0)
              {
                localObject1 = this;
                localObject1 = this$0;
                localObject2 = localObject1;
                localObject2 = list;
                localObject3 = "app_date_";
                localObject1 = localObject3;
                localObject3 = localJSONObject2.getString((String)localObject3);
                ((List)localObject2).add(localObject3);
              }
            }
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject2.getString((String)localObject2);
            localObject3 = "3";
            boolean bool6 = ((String)localObject2).equals(localObject3);
            if (bool6)
            {
              i9 = 0;
              int i1 = localJSONArray2.length();
              if (i9 < i1)
              {
                localObject2 = "day_";
                localObject1 = localObject2;
                str2 = localJSONObject2.getString((String)localObject2);
                localJSONObject4 = localJSONArray2.getJSONObject(i9);
                localObject2 = "calender_day";
                localObject1 = localJSONObject4;
                localObject2 = localJSONObject4.getString((String)localObject2);
                localObject1 = localObject2;
                bool7 = ((String)localObject2).equals(str2);
                if (bool7) {
                  i8 = 1;
                }
                i9 += 1;
                continue;
              }
              if (i8 == 0)
              {
                localObject1 = this;
                localObject1 = this$0;
                localObject2 = localObject1;
                localObject2 = list;
                localObject3 = "app_date_";
                localObject1 = localObject3;
                localObject3 = localJSONObject2.getString((String)localObject3);
                ((List)localObject2).add(localObject3);
              }
            }
            i3 += 1;
            continue;
          }
          localObject1 = this;
          localObject3 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = list;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = list;
          localObject4 = localObject1;
          i2 = ((List)localObject1).size();
          localObject4 = new String[i2];
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).toArray((Object[])localObject4);
          localObject2 = (String[])localObject2;
          localObject1 = localObject2;
          date = ((String[])localObject2);
          i3 = 0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = list;
          localObject2 = localObject1;
          localIterator = ((List)localObject1).iterator();
          bool7 = localIterator.hasNext();
          if (bool7)
          {
            Object localObject5 = localIterator.next();
            localObject5 = (String)localObject5;
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject1 = datelist;
            localObject2 = localObject1;
            ((List)localObject1).add(localObject5);
            i3 += 1;
            continue;
          }
          localObject1 = this;
          localObject3 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = datelist;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = datelist;
          localObject4 = localObject1;
          i2 = ((List)localObject1).size();
          localObject4 = new String[i2];
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).toArray((Object[])localObject4);
          localObject2 = (String[])localObject2;
          localObject1 = localObject2;
          date = ((String[])localObject2);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = mdate;
          localObject2 = localObject1;
          localObject3 = new android/widget/ArrayAdapter;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject4 = ((BookAppointmentWithout)localObject1).getApplicationContext();
          i6 = 2130903050;
          localObject1 = this;
          localObject1 = this$0;
          localObject1 = date;
          ((ArrayAdapter)localObject3).<init>((Context)localObject4, i6, (Object[])localObject1);
          ((Spinner)localObject2).setAdapter((SpinnerAdapter)localObject3);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          bool7 = ((BookAppointmentWithout)localObject1).isConnected();
          if (bool7)
          {
            localObject2 = new in/gov/mgov/ors/BookAppointmentWithout$CallListagain;
            localObject1 = this;
            localObject1 = this$0;
            localObject3 = localObject1;
            i2 = 0;
            localObject4 = null;
            ((BookAppointmentWithout.CallListagain)localObject2).<init>((BookAppointmentWithout)localObject1, null);
            i7 = 1;
            localObject1 = new String[i7];
            localObject3 = localObject1;
            i2 = 0;
            localObject4 = null;
            String str3 = "getAvailabledatelist";
            localObject1[0] = str3;
            ((BookAppointmentWithout.CallListagain)localObject2).execute((Object[])localObject1);
          }
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = BookAppointmentWithout.access$200((BookAppointmentWithout)localObject1);
        localObject3 = "getSuperSpacialityMsg";
        boolean bool7 = ((String)localObject2).equals(localObject3);
        if (bool7)
        {
          localObject1 = this;
          localObject2 = this$0;
          localObject3 = "msg";
          localObject1 = localObject3;
          localObject3 = localJSONObject1.getString((String)localObject3);
          localObject1 = localObject3;
          spacialitymessage = ((String)localObject3);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = spacialitymessage;
          localObject2 = localObject1;
          localObject3 = "NA";
          bool7 = ((String)localObject1).equalsIgnoreCase((String)localObject3);
          if (bool7)
          {
            localObject1 = this;
            localObject2 = this$0;
            localObject3 = "";
            localObject1 = localObject3;
            spacialitymessage = ((String)localObject3);
            Intent localIntent = new android/content/Intent;
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = ((BookAppointmentWithout)localObject1).getApplicationContext();
            localObject3 = AuthenticateNonAadhaar.class;
            localObject1 = localObject2;
            localIntent.<init>((Context)localObject2, (Class)localObject3);
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = editor;
            localObject3 = "appointment_detail";
            localObject1 = this;
            localObject1 = this$0;
            localObject4 = localObject1;
            localObject1 = spacialitymessage;
            localObject4 = localObject1;
            localObject2 = ((SharedPreferences.Editor)localObject2).putString((String)localObject3, (String)localObject1);
            ((SharedPreferences.Editor)localObject2).commit();
            localObject2 = "from";
            localObject3 = "noaadhaar";
            localObject1 = localObject2;
            localIntent.putExtra((String)localObject2, (String)localObject3);
            localObject2 = "appointment_info";
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            localObject4 = "<";
            localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
            localObject1 = this;
            localObject1 = this$0;
            localObject4 = localObject1;
            localObject1 = hospitalnameString;
            localObject4 = localObject1;
            localObject3 = ((StringBuilder)localObject3).append((String)localObject1);
            localObject4 = ">";
            localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
            localObject4 = "<";
            localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
            localObject1 = this;
            localObject1 = this$0;
            localObject4 = localObject1;
            localObject1 = DepartmentnameString;
            localObject4 = localObject1;
            localObject3 = ((StringBuilder)localObject3).append((String)localObject1);
            localObject4 = ">";
            localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
            localObject4 = "<";
            localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
            localObject1 = this;
            localObject1 = this$0;
            localObject4 = localObject1;
            localObject1 = dateString;
            localObject4 = localObject1;
            localObject3 = ((StringBuilder)localObject3).append((String)localObject1);
            localObject4 = ">";
            localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject1 = localObject2;
            localIntent.putExtra((String)localObject2, (String)localObject3);
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            ((BookAppointmentWithout)localObject1).startActivity(localIntent);
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
        Object localObject3 = new in/gov/mgov/ors/BookAppointmentWithout$CallList$4;
        localObject1 = localObject3;
        ((BookAppointmentWithout.CallList.4)localObject3).<init>(this);
        ((BookAppointmentWithout)localObject2).runOnUiThread((Runnable)localObject3);
        continue;
      }
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = spacialitymessage;
      localObject3 = localObject1;
      BookAppointmentWithout.access$500((BookAppointmentWithout)localObject2, (String)localObject1);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    ProgressDialog localProgressDialog = new android/app/ProgressDialog;
    Object localObject = this$0;
    localProgressDialog.<init>((Context)localObject);
    dlog = localProgressDialog;
    localProgressDialog = dlog;
    localObject = this$0.getResources().getString(2131034289);
    localProgressDialog.setTitle((CharSequence)localObject);
    localProgressDialog = dlog;
    localObject = this$0.getResources().getString(2131034207);
    localProgressDialog.setMessage((CharSequence)localObject);
    dlog.setCancelable(false);
    dlog.show();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointmentWithout$CallList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */