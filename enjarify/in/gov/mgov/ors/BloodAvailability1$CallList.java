package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

class BloodAvailability1$CallList
  extends AsyncTask
{
  List bbaddress_list;
  List bbdistid_list;
  List bbdistname_list;
  List bbemail_list;
  List bbid_list;
  List bblandno_list;
  List bbmoicname_list;
  List bbname_list;
  List bbstateid_list;
  List bbstatename_list;
  private ProgressDialog dlog;
  String finalresp;
  List state_id;
  List state_list;
  
  private BloodAvailability1$CallList(BloodAvailability1 paramBloodAvailability1)
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    state_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    state_id = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    bbaddress_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    bbname_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    bbemail_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    bbstateid_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    bbstatename_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    bbid_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    bbdistname_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    bblandno_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    bbdistid_list = localArrayList;
    localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    bbmoicname_list = localArrayList;
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
    int i = 0;
    localObject2 = paramVarArgs[0];
    BloodAvailability1.access$202((BloodAvailability1)localObject1, (String)localObject2);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localObject2 = BloodAvailability1.access$200(this$0);
    localSoapObject.<init>("http://orsws/", (String)localObject2);
    localObject1 = BloodAvailability1.access$200(this$0);
    localObject2 = "getBBStatelist";
    boolean bool = ((String)localObject1).equals(localObject2);
    Class localClass;
    if (bool)
    {
      localObject2 = "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj";
      localClass = String.class;
      localObject1 = addProperties("intoken", (String)localObject2, localClass);
      localSoapObject.addProperty((PropertyInfo)localObject1);
    }
    localObject1 = BloodAvailability1.access$200(this$0);
    localObject2 = "getBloodBanklistforastate";
    bool = ((String)localObject1).equals(localObject2);
    if (bool)
    {
      localObject1 = addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class);
      localSoapObject.addProperty((PropertyInfo)localObject1);
      localObject2 = BloodAvailability1.selected_state_id_from_spinner;
      localClass = String.class;
      localObject1 = addProperties("stateid", (String)localObject2, localClass);
      localSoapObject.addProperty((PropertyInfo)localObject1);
    }
    SoapSerializationEnvelope localSoapSerializationEnvelope = new org/ksoap2/serialization/SoapSerializationEnvelope;
    int j = 110;
    localSoapSerializationEnvelope.<init>(j);
    localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
    HttpTransportSE localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
    i = 60000;
    localHttpTransportSE.<init>("http://ors.gov.in/ORSServicecontainer/bbservices?wsdl", i);
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
        localObject2 = new in/gov/mgov/ors/BloodAvailability1$CallList$1;
        ((BloodAvailability1.CallList.1)localObject2).<init>(this);
        ((BloodAvailability1)localObject1).runOnUiThread((Runnable)localObject2);
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
      JSONObject localJSONObject1 = new org/json/JSONObject;
      localJSONObject1.<init>(paramString);
      localObject1 = this$0;
      localObject1 = BloodAvailability1.access$200((BloodAvailability1)localObject1);
      localObject2 = "getBBStatelist";
      bool1 = ((String)localObject1).equals(localObject2);
      JSONArray localJSONArray;
      int k;
      int m;
      JSONObject localJSONObject2;
      Object localObject3;
      int i2;
      if (bool1)
      {
        localObject1 = state_list;
        ((List)localObject1).clear();
        localObject1 = state_id;
        ((List)localObject1).clear();
        localObject1 = "statelist";
        localJSONArray = localJSONObject1.optJSONArray((String)localObject1);
        localObject1 = state_list;
        localObject2 = this$0;
        localObject2 = ((BloodAvailability1)localObject2).getResources();
        k = 2131034300;
        localObject2 = ((Resources)localObject2).getString(k);
        ((List)localObject1).add(localObject2);
        localObject1 = state_id;
        localObject2 = "0";
        ((List)localObject1).add(localObject2);
        m = 0;
        for (;;)
        {
          i = localJSONArray.length();
          if (m >= i) {
            break;
          }
          localJSONObject2 = localJSONArray.getJSONObject(m);
          localObject1 = state_list;
          localObject2 = "statename";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          localObject1 = state_id;
          localObject2 = "stateid";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          m += 1;
        }
        localObject2 = this$0;
        localObject1 = state_list;
        localObject3 = state_list;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        state = ((String[])localObject1);
        localObject2 = this$0;
        localObject1 = state_id;
        localObject3 = state_id;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        stateid = ((String[])localObject1);
        localObject1 = this$0;
        String[] arrayOfString = state;
        int n = arrayOfString.length;
        int i1 = 0;
        while (i1 < n)
        {
          localObject1 = arrayOfString[i1];
          i1 += 1;
        }
        localObject1 = this$0;
        arrayOfString = stateid;
        n = arrayOfString.length;
        i1 = 0;
        while (i1 < n)
        {
          localObject1 = arrayOfString[i1];
          i1 += 1;
        }
        localObject1 = state_list;
        int i = ((List)localObject1).size();
        i2 = 1;
        if (i == i2)
        {
          localObject1 = this$0;
          localObject2 = new in/gov/mgov/ors/BloodAvailability1$CallList$2;
          ((BloodAvailability1.CallList.2)localObject2).<init>(this);
          ((BloodAvailability1)localObject1).runOnUiThread((Runnable)localObject2);
        }
        localObject1 = this$0;
        localObject1 = spinner_selectState;
        localObject2 = new android/widget/ArrayAdapter;
        localObject3 = this$0;
        localObject3 = ((BloodAvailability1)localObject3).getApplicationContext();
        int i3 = 2130903050;
        Object localObject4 = this$0;
        localObject4 = state;
        ((ArrayAdapter)localObject2).<init>((Context)localObject3, i3, (Object[])localObject4);
        ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
      }
      localObject1 = this$0;
      localObject1 = BloodAvailability1.access$200((BloodAvailability1)localObject1);
      localObject2 = "getBloodBanklistforastate";
      boolean bool2 = ((String)localObject1).equals(localObject2);
      if (bool2)
      {
        localObject1 = bbaddress_list;
        ((List)localObject1).clear();
        localObject1 = bbname_list;
        ((List)localObject1).clear();
        localObject1 = bbemail_list;
        ((List)localObject1).clear();
        localObject1 = bbstateid_list;
        ((List)localObject1).clear();
        localObject1 = bbstatename_list;
        ((List)localObject1).clear();
        localObject1 = bbid_list;
        ((List)localObject1).clear();
        localObject1 = bbdistname_list;
        ((List)localObject1).clear();
        localObject1 = bblandno_list;
        ((List)localObject1).clear();
        localObject1 = bbdistid_list;
        ((List)localObject1).clear();
        localObject1 = bbmoicname_list;
        ((List)localObject1).clear();
        localObject1 = "bblistforastate";
        localJSONArray = localJSONObject1.optJSONArray((String)localObject1);
        m = 0;
        for (;;)
        {
          j = localJSONArray.length();
          if (m >= j) {
            break;
          }
          localJSONObject2 = localJSONArray.getJSONObject(m);
          localObject1 = bbaddress_list;
          localObject2 = "bbaddress";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          localObject1 = bbname_list;
          localObject2 = "bbname";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          localObject1 = bbemail_list;
          localObject2 = "bbemail";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          localObject1 = bbstateid_list;
          localObject2 = "bbstateid";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          localObject1 = bbstatename_list;
          localObject2 = "bbstatename";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          localObject1 = bbid_list;
          localObject2 = "bbid";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          localObject1 = bbdistname_list;
          localObject2 = "bbdistname";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          localObject1 = bblandno_list;
          localObject2 = "bblandno";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          localObject1 = bbdistid_list;
          localObject2 = "bbdistid";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          localObject1 = bbmoicname_list;
          localObject2 = "bbmoicname";
          localObject2 = localJSONObject2.getString((String)localObject2);
          ((List)localObject1).add(localObject2);
          m += 1;
        }
        localObject2 = this$0;
        localObject1 = bbaddress_list;
        localObject3 = bbaddress_list;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        stringarray_bbaddress = ((String[])localObject1);
        localObject2 = this$0;
        localObject1 = bbname_list;
        localObject3 = bbname_list;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        stringarray_bbname = ((String[])localObject1);
        localObject2 = this$0;
        localObject1 = bbemail_list;
        localObject3 = bbemail_list;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        stringarray_bbemail = ((String[])localObject1);
        localObject2 = this$0;
        localObject1 = bbstateid_list;
        localObject3 = bbstateid_list;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        stringarray_bbstateid = ((String[])localObject1);
        localObject2 = this$0;
        localObject1 = bbstatename_list;
        localObject3 = bbstatename_list;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        stringarray_bbstatename = ((String[])localObject1);
        localObject2 = this$0;
        localObject1 = bbid_list;
        localObject3 = bbid_list;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        stringarray_bbid = ((String[])localObject1);
        localObject2 = this$0;
        localObject1 = bbdistname_list;
        localObject3 = bbdistname_list;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        stringarray_bbdistname = ((String[])localObject1);
        localObject2 = this$0;
        localObject1 = bblandno_list;
        localObject3 = bblandno_list;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        stringarray_bblandno = ((String[])localObject1);
        localObject2 = this$0;
        localObject1 = bbdistid_list;
        localObject3 = bbdistid_list;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        stringarray_bbdistid = ((String[])localObject1);
        localObject2 = this$0;
        localObject1 = bbmoicname_list;
        localObject3 = bbmoicname_list;
        k = ((List)localObject3).size();
        localObject3 = new String[k];
        localObject1 = ((List)localObject1).toArray((Object[])localObject3);
        localObject1 = (String[])localObject1;
        stringarray_bbmoicname = ((String[])localObject1);
        localObject1 = state_list;
        int j = ((List)localObject1).size();
        i2 = 1;
        if (j == i2)
        {
          localObject1 = this$0;
          localObject2 = new in/gov/mgov/ors/BloodAvailability1$CallList$3;
          ((BloodAvailability1.CallList.3)localObject2).<init>(this);
          ((BloodAvailability1)localObject1).runOnUiThread((Runnable)localObject2);
        }
        ArrayAdapter localArrayAdapter = new android/widget/ArrayAdapter;
        localObject1 = this$0;
        i2 = 17367043;
        localObject3 = this$0;
        localObject3 = stringarray_bbname;
        localArrayAdapter.<init>((Context)localObject1, i2, (Object[])localObject3);
        localObject1 = this$0;
        localObject1 = listview_hospital;
        ((ListView)localObject1).setAdapter(localArrayAdapter);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localObject1 = this$0;
        Object localObject2 = new in/gov/mgov/ors/BloodAvailability1$CallList$4;
        ((BloodAvailability1.CallList.4)localObject2).<init>(this);
        ((BloodAvailability1)localObject1).runOnUiThread((Runnable)localObject2);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BloodAvailability1$CallList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */