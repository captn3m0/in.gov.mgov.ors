package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
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

class CancelAppointment_1$CallList
  extends AsyncTask
{
  List aadhaar;
  List appdate;
  List appointment_id;
  List apptime;
  List deptname;
  private ProgressDialog dlog;
  List dob;
  List doctor;
  List email;
  List fathers_name;
  String finalresp;
  List gender;
  List hid;
  List hospitalname;
  List id;
  List list;
  List mobile_no;
  List p_address;
  List patient_name;
  List requestdate;
  List room_name;
  List status;
  
  private CancelAppointment_1$CallList(CancelAppointment_1 paramCancelAppointment_1)
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    id = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    appdate = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    deptname = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    hospitalname = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    status = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    patient_name = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    fathers_name = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    email = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    room_name = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    dob = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    gender = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    p_address = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    appointment_id = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    mobile_no = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    doctor = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    aadhaar = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    hid = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    requestdate = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    apptime = localArrayList;
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
    int i = 1;
    localObject1 = this$0;
    int j = 0;
    localObject2 = paramVarArgs[0];
    CancelAppointment_1.access$102((CancelAppointment_1)localObject1, (String)localObject2);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localObject1 = "http://orsws/";
    localObject2 = CancelAppointment_1.access$100(this$0);
    localSoapObject.<init>((String)localObject1, (String)localObject2);
    int k = paramVarArgs.length;
    Class localClass;
    if (k > i)
    {
      localObject1 = this$0;
      localObject2 = paramVarArgs[i];
      type = ((String)localObject2);
      localClass = String.class;
      localObject1 = addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", localClass);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject1 = paramVarArgs[i];
      localObject2 = "byid";
      boolean bool1 = ((String)localObject1).equals(localObject2);
      if (!bool1) {
        break label306;
      }
      localObject2 = this$0.enteredValue.getText().toString();
      localObject1 = addProperties("appointmentid", (String)localObject2, String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject1 = addProperties("aadhaar", "0", String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject2 = "0";
      localClass = String.class;
      localObject1 = addProperties("hid", (String)localObject2, localClass);
      localSoapObject.addProperty((PropertyInfo)localObject1);
    }
    for (;;)
    {
      localObject2 = this$0.hospitalcode;
      localClass = String.class;
      localObject1 = addProperties("in_hospital_id", (String)localObject2, localClass);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      SoapSerializationEnvelope localSoapSerializationEnvelope = new org/ksoap2/serialization/SoapSerializationEnvelope;
      int m = 110;
      localSoapSerializationEnvelope.<init>(m);
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
        localObject1 = ((SoapPrimitive)localObject3).toString();
        finalresp = ((String)localObject1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool2;
          localObject1 = this$0;
          localObject2 = new in/gov/mgov/ors/CancelAppointment_1$CallList$1;
          ((CancelAppointment_1.CallList.1)localObject2).<init>(this);
          ((CancelAppointment_1)localObject1).runOnUiThread((Runnable)localObject2);
        }
      }
      return finalresp;
      label306:
      localObject1 = paramVarArgs[i];
      localObject2 = "byuhid";
      bool2 = ((String)localObject1).equals(localObject2);
      if (bool2)
      {
        localObject1 = addProperties("appointmentid", "0", String.class);
        localSoapObject.addProperty((PropertyInfo)localObject1);
        localObject1 = addProperties("aadhaar", "0", String.class);
        localSoapObject.addProperty((PropertyInfo)localObject1);
        localObject2 = this$0.enteredValue.getText().toString();
        localClass = String.class;
        localObject1 = addProperties("hid", (String)localObject2, localClass);
        localSoapObject.addProperty((PropertyInfo)localObject1);
      }
      else
      {
        localObject1 = paramVarArgs[i];
        localObject2 = "byaadhaar";
        bool2 = ((String)localObject1).equals(localObject2);
        if (bool2)
        {
          localObject1 = addProperties("appointmentid", "0", String.class);
          localSoapObject.addProperty((PropertyInfo)localObject1);
          localObject2 = this$0.enteredValue.getText().toString();
          localObject1 = addProperties("aadhaar", (String)localObject2, String.class);
          localSoapObject.addProperty((PropertyInfo)localObject1);
          localObject2 = "0";
          localClass = String.class;
          localObject1 = addProperties("hid", (String)localObject2, localClass);
          localSoapObject.addProperty((PropertyInfo)localObject1);
        }
      }
    }
  }
  
  protected void onPostExecute(String paramString)
  {
    super.onPostExecute(paramString);
    localObject1 = dlog;
    boolean bool1 = ((ProgressDialog)localObject1).isShowing();
    if (bool1)
    {
      localObject1 = dlog;
      ((ProgressDialog)localObject1).dismiss();
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = new org/json/JSONObject;
        localJSONObject1.<init>(paramString);
        localObject1 = this$0;
        localObject1 = CancelAppointment_1.access$100((CancelAppointment_1)localObject1);
        localObject2 = "getHospitallist";
        bool1 = ((String)localObject1).equals(localObject2);
        if (bool1)
        {
          localObject1 = list;
          ((List)localObject1).clear();
          localObject1 = id;
          ((List)localObject1).clear();
          localObject1 = "hospitallist";
          localJSONArray = localJSONObject1.optJSONArray((String)localObject1);
          localObject1 = list;
          localObject2 = this$0;
          localObject2 = ((CancelAppointment_1)localObject2).getResources();
          m = 2131034307;
          localObject2 = ((Resources)localObject2).getString(m);
          ((List)localObject1).add(localObject2);
          localObject1 = id;
          localObject2 = "0";
          ((List)localObject1).add(localObject2);
          n = 0;
          int i = localJSONArray.length();
          if (n < i)
          {
            localJSONObject2 = localJSONArray.getJSONObject(n);
            localObject1 = list;
            localObject2 = "hospitalname";
            localObject2 = localJSONObject2.getString((String)localObject2);
            ((List)localObject1).add(localObject2);
            localObject1 = id;
            localObject2 = "hospitalid";
            localObject2 = localJSONObject2.getString((String)localObject2);
            ((List)localObject1).add(localObject2);
            n += 1;
            continue;
          }
          localObject2 = this$0;
          localObject1 = list;
          localObject3 = list;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          hospital = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = id;
          localObject3 = id;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          hospitalid = ((String[])localObject1);
          localObject1 = this$0;
          String[] arrayOfString = hospital;
          int i1 = arrayOfString.length;
          int i2 = 0;
          if (i2 < i1)
          {
            localObject1 = arrayOfString[i2];
            i2 += 1;
            continue;
          }
          localObject1 = this$0;
          arrayOfString = hospitalid;
          i1 = arrayOfString.length;
          i2 = 0;
          if (i2 < i1)
          {
            localObject1 = arrayOfString[i2];
            i2 += 1;
            continue;
          }
          localObject1 = list;
          i = ((List)localObject1).size();
          int i3 = 1;
          if (i == i3)
          {
            localObject1 = this$0;
            localObject2 = new in/gov/mgov/ors/CancelAppointment_1$CallList$2;
            ((CancelAppointment_1.CallList.2)localObject2).<init>(this);
            ((CancelAppointment_1)localObject1).runOnUiThread((Runnable)localObject2);
          }
          localObject1 = this$0;
          localObject1 = mhospital;
          localObject2 = new android/widget/ArrayAdapter;
          localObject3 = this$0;
          localObject3 = ((CancelAppointment_1)localObject3).getApplicationContext();
          int i4 = 2130903050;
          Object localObject4 = this$0;
          localObject4 = hospital;
          ((ArrayAdapter)localObject2).<init>((Context)localObject3, i4, (Object[])localObject4);
          ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
        }
        localObject1 = this$0;
        localObject1 = CancelAppointment_1.access$100((CancelAppointment_1)localObject1);
        localObject2 = "getAppointmentList";
        boolean bool2 = ((String)localObject1).equals(localObject2);
        if (bool2)
        {
          localObject1 = finalresp;
          localObject2 = "{\"appointmentlist\":[]}";
          bool2 = ((String)localObject1).equals(localObject2);
          if (bool2)
          {
            localObject1 = this$0;
            localObject2 = this$0;
            localObject2 = ((CancelAppointment_1)localObject2).getResources();
            m = 2131034250;
            localObject2 = ((Resources)localObject2).getString(m);
            CancelAppointment_1.access$200((CancelAppointment_1)localObject1, (String)localObject2);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject1;
        JSONArray localJSONArray;
        int n;
        JSONObject localJSONObject2;
        Object localObject3;
        int j;
        boolean bool3;
        int k;
        localObject1 = this$0;
        Object localObject2 = this$0.getResources();
        int m = 2131034288;
        localObject2 = ((Resources)localObject2).getString(m);
        CancelAppointment_1.access$200((CancelAppointment_1)localObject1, (String)localObject2);
        continue;
      }
      localObject1 = "appointmentlist";
      localJSONArray = localJSONObject1.optJSONArray((String)localObject1);
      n = 0;
      j = localJSONArray.length();
      if (n < j)
      {
        localJSONObject2 = localJSONArray.getJSONObject(n);
        localObject1 = appdate;
        localObject2 = "appointment_date";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = hospitalname;
        localObject2 = this$0;
        localObject2 = mhospital;
        localObject2 = ((Spinner)localObject2).getSelectedItem();
        localObject2 = localObject2.toString();
        ((List)localObject1).add(localObject2);
        localObject1 = deptname;
        localObject2 = "dept_name";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = "is_cancel";
        localObject1 = localJSONObject2.getString((String)localObject1);
        localObject2 = "0";
        bool3 = ((String)localObject1).equals(localObject2);
        if (bool3)
        {
          localObject1 = status;
          localObject2 = "<font color=\"#3F51B5\">View</font>";
          ((List)localObject1).add(localObject2);
        }
        localObject1 = "is_cancel";
        localObject1 = localJSONObject2.getString((String)localObject1);
        localObject2 = "1";
        bool3 = ((String)localObject1).equals(localObject2);
        if (bool3)
        {
          localObject1 = status;
          localObject2 = "Cancelled";
          ((List)localObject1).add(localObject2);
        }
        localObject1 = "is_cancel";
        localObject1 = localJSONObject2.getString((String)localObject1);
        localObject2 = "2";
        bool3 = ((String)localObject1).equals(localObject2);
        if (bool3)
        {
          localObject1 = status;
          localObject2 = "Expired";
          ((List)localObject1).add(localObject2);
        }
        localObject1 = patient_name;
        localObject2 = "patient_name";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = fathers_name;
        localObject2 = "fathers_name";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = email;
        localObject2 = "email";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = room_name;
        localObject2 = "room_name";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = dob;
        localObject2 = "dob";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = doctor;
        localObject2 = "doctor_name";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = aadhaar;
        localObject2 = "aadhaar_id";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = hid;
        localObject2 = "hid";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = requestdate;
        localObject2 = "appointment_req_date";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = apptime;
        localObject2 = "app_time_str";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = aadhaar;
        localObject2 = "aadhaar_id";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = "gender";
        localObject1 = localJSONObject2.getString((String)localObject1);
        localObject2 = "0";
        bool3 = ((String)localObject1).equals(localObject2);
        if (bool3)
        {
          localObject1 = gender;
          localObject2 = "Other";
          ((List)localObject1).add(localObject2);
        }
        localObject1 = "gender";
        localObject1 = localJSONObject2.getString((String)localObject1);
        localObject2 = "1";
        bool3 = ((String)localObject1).equals(localObject2);
        if (bool3)
        {
          localObject1 = gender;
          localObject2 = "Male";
          ((List)localObject1).add(localObject2);
        }
        localObject1 = "gender";
        localObject1 = localJSONObject2.getString((String)localObject1);
        localObject2 = "2";
        bool3 = ((String)localObject1).equals(localObject2);
        if (bool3)
        {
          localObject1 = gender;
          localObject2 = "Female";
          ((List)localObject1).add(localObject2);
        }
        localObject1 = p_address;
        localObject2 = "p_address";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = appointment_id;
        localObject2 = "appointment_id";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        localObject1 = mobile_no;
        localObject2 = "mobile_no";
        localObject2 = localJSONObject2.getString((String)localObject2);
        ((List)localObject1).add(localObject2);
        n += 1;
      }
      else
      {
        n = 0;
        localObject1 = appdate;
        k = ((List)localObject1).size();
        if (n < k)
        {
          n += 1;
        }
        else
        {
          localObject2 = this$0;
          localObject1 = appdate;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resAppdates = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = hospitalname;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          reshospitals = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = deptname;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resDepts = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = status;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resStatus = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = patient_name;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resPatientname = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = fathers_name;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resfathers_name = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = email;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resEmail = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = room_name;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resRoom_name = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = dob;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resDOB = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = gender;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resGender = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = p_address;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resP_address = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = appointment_id;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resAppointment_id = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = mobile_no;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resMobileNo = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = doctor;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resDoctor = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = aadhaar;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resAadhaar = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = hid;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          reshid = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = requestdate;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resRequestDate = ((String[])localObject1);
          localObject2 = this$0;
          localObject1 = apptime;
          localObject3 = appdate;
          m = ((List)localObject3).size();
          localObject3 = new String[m];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          resApptime = ((String[])localObject1);
          localObject1 = this$0;
          localObject2 = new in/gov/mgov/ors/CancelAppointment_1$CallList$3;
          ((CancelAppointment_1.CallList.3)localObject2).<init>(this);
          ((CancelAppointment_1)localObject1).runOnUiThread((Runnable)localObject2);
        }
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment_1$CallList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */