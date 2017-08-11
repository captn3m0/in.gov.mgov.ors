package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import in.gov.mgov.helper.GetStateData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class ShowUIDAIData
  extends Activity
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  private String METHOD = "";
  TextView aadhaar;
  String aadhaarno;
  TextView address;
  String appdate;
  String appointmentidforcheck = "";
  ImageView button_home;
  String[] date;
  List<String> datelist = new ArrayList();
  TextView datepref;
  TextView department;
  int departmentcode;
  TextView dob;
  SharedPreferences.Editor editor;
  String finalresp;
  TextView gender;
  int hospitalcode;
  TextView hostpital_state;
  List<String> id = new ArrayList();
  ImageView image;
  int limit = 10;
  List<String> list = new ArrayList();
  Spinner mdate;
  TextView mno;
  int monthx = 0;
  TextView name;
  Button next;
  TextView no;
  SharedPreferences pref;
  int statecode;
  String[] uidData;
  int x = 0;
  Button yes;
  
  private PropertyInfo addProperties(String paramString, int paramInt, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new PropertyInfo();
    localPropertyInfo.setName(paramString);
    localPropertyInfo.setValue(Integer.valueOf(paramInt));
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  private PropertyInfo addProperties(String paramString, Boolean paramBoolean, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new PropertyInfo();
    localPropertyInfo.setName(paramString);
    localPropertyInfo.setValue(paramBoolean);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  private PropertyInfo addProperties(String paramString1, String paramString2, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new PropertyInfo();
    localPropertyInfo.setName(paramString1);
    localPropertyInfo.setValue(paramString2);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  private void intitalizeViews()
  {
    name = ((TextView)findViewById(2131296449));
    dob = ((TextView)findViewById(2131296450));
    gender = ((TextView)findViewById(2131296451));
    mno = ((TextView)findViewById(2131296452));
    address = ((TextView)findViewById(2131296455));
    datepref = ((TextView)findViewById(2131296262));
    mdate = ((Spinner)findViewById(2131296338));
    hostpital_state = ((TextView)findViewById(2131296260));
    department = ((TextView)findViewById(2131296261));
    aadhaar = ((TextView)findViewById(2131296448));
    image = ((ImageView)findViewById(2131296447));
    yes = ((Button)findViewById(2131296341));
    no = ((TextView)findViewById(2131296456));
    next = ((Button)findViewById(2131296339));
    button_home = ((ImageView)findViewById(2131296259));
    button_home.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), ServiceSelection.class);
        paramAnonymousView.addFlags(268468224);
        startActivity(paramAnonymousView);
      }
    });
  }
  
  private void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getResources().getString(2131034183));
    localBuilder.setMessage(paramString).setCancelable(false).setPositiveButton(getResources().getString(2131034259), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Intent localIntent = new Intent(getApplicationContext(), ServiceSelection.class);
        localIntent.addFlags(268468224);
        startActivity(localIntent);
        paramAnonymousDialogInterface.cancel();
      }
    });
    localBuilder.create().show();
  }
  
  private void showMessage(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 1);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  private void updateView()
  {
    ((TextView)findViewById(2131296258)).setText(pref.getString("source", ""));
    new CallList(null);
    if (isConnected()) {
      statecode = Integer.parseInt(pref.getString("state_code", "0"));
    }
    departmentcode = Integer.parseInt(pref.getString("dept_code", "0"));
    hospitalcode = Integer.parseInt(pref.getString("hospital_code", "0"));
    appdate = pref.getString("date_name", "0");
    datepref.setText(getResources().getString(2131034133) + ": " + pref.getString("date_name", ""));
    hostpital_state.setText(hostpital_state.getText() + pref.getString("hospital_name", ""));
    department.setText(department.getText() + pref.getString("dept_name", ""));
    aadhaar.setText(getResources().getString(2131034133) + ": " + "XXXXXXXX" + pref.getString("aadhaar_no", "").substring(pref.getString("aadhaar_no", "").length() - 4, pref.getString("aadhaar_no", "").length()));
    Object localObject = getIntent();
    uidData = ((Intent)localObject).getStringArrayExtra("uid_data");
    aadhaarno = ((Intent)localObject).getStringExtra("aaddhaarid");
    name.setText(uidData[0]);
    dob.setText(uidData[1]);
    gender.setText(uidData[2]);
    mno.setText(uidData[3]);
    localObject = "";
    int i = 5;
    while (i < 15)
    {
      localObject = (String)localObject + uidData[i] + " ";
      i += 1;
    }
    address.setText((CharSequence)localObject);
    localObject = Base64.decode(uidData[15], 0);
    localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
    image.setImageBitmap((Bitmap)localObject);
    yes.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (isConnected()) {
          new ShowUIDAIData.CallList(ShowUIDAIData.this, null).execute(new String[] { "fixAppointment" });
        }
      }
    });
    no.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), ServiceSelection.class);
        paramAnonymousView.addFlags(268468224);
        startActivity(paramAnonymousView);
      }
    });
    next.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ShowUIDAIData.this.showMessage(getResources().getString(2131034141));
        paramAnonymousView = ShowUIDAIData.this;
        x += 1;
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(getResources().getString(2131034139));
        int i = x * limit;
        if (i < (x + 1) * limit)
        {
          if (datelist.size() > i) {
            paramAnonymousView.add(datelist.get(i));
          }
          for (;;)
          {
            i += 1;
            break;
            x = -1;
          }
        }
        date = ((String[])paramAnonymousView.toArray(new String[paramAnonymousView.size()]));
        mdate.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, date));
      }
    });
  }
  
  public boolean isConnected()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
      return true;
    }
    showMessage(getResources().getString(2131034274));
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903066);
    pref = getSharedPreferences("ors", 0);
    editor = pref.edit();
    intitalizeViews();
    updateView();
  }
  
  private class CallList
    extends AsyncTask<String, String, String>
  {
    private ProgressDialog dlog;
    
    private CallList() {}
    
    protected String doInBackground(String... paramVarArgs)
    {
      ShowUIDAIData.access$202(ShowUIDAIData.this, paramVarArgs[0]);
      SoapObject localSoapObject = new SoapObject("http://orsws/", METHOD);
      if (METHOD.equals("getAvailabledatelist"))
      {
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("hospitalid");
        paramVarArgs.setValue(Integer.valueOf(hospitalcode));
        paramVarArgs.setType(Integer.class);
        localSoapObject.addProperty(paramVarArgs);
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("departmentid");
        paramVarArgs.setValue(Integer.valueOf(departmentcode));
        paramVarArgs.setType(Integer.class);
        localSoapObject.addProperty(paramVarArgs);
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("appointmentcat");
        paramVarArgs.setValue(Integer.valueOf(0));
        paramVarArgs.setType(Integer.class);
        localSoapObject.addProperty(paramVarArgs);
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("calmonth");
        paramVarArgs.setValue(Integer.valueOf(monthx));
        paramVarArgs.setType(Integer.class);
        localSoapObject.addProperty(paramVarArgs);
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("inToken");
        paramVarArgs.setValue("dG9rZW5Ad2ViQGFwcG9pbnQjbmlj");
        paramVarArgs.setType(String.class);
        localSoapObject.addProperty(paramVarArgs);
      }
      if (METHOD.equals("fixAppointment"))
      {
        paramVarArgs = "0";
        if (uidData[2].equalsIgnoreCase("M")) {
          paramVarArgs = "1";
        }
        if (uidData[2].equalsIgnoreCase("F")) {
          paramVarArgs = "2";
        }
        localObject = "";
        int i = 5;
        while (i < 15)
        {
          localObject = (String)localObject + uidData[i] + " ";
          i += 1;
        }
        String str1 = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String str3 = uidData[1];
        i = Integer.parseInt(str3.substring(str3.length() - 4, str3.length()));
        int j = Integer.parseInt(str1.substring(str1.length() - 4, str1.length()));
        str1 = str3.substring(str3.length() - 4, str3.length());
        String str2 = str3.substring(str3.length() - 7, str3.length() - 5);
        str3 = str3.substring(0, 2);
        String str4 = j - i + "";
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("flagtp", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inpatientname", uidData[0].replaceAll(" ", "^"), String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("ingender", paramVarArgs, String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inpaddress", (String)localObject, String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("indob", str1 + "-" + str2 + "-" + str3, String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("instatecode", new GetStateData().getStateCode(uidData[12]), Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("incountrycode", 91, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inmobileno", uidData[3], String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inemail", "", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inbillingtype", 1, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inreligion", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inhospitalid", hospitalcode, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inentfrom", "0.0.0.0", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("infathername", uidData[5], String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inmothername", "", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inpatrelstr", "c/o", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inbplverifiedby", "", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inothersdetails", "", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("injaildetails", "", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("incghscardno", "", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inage", str4 + " years", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("newfollowup", "0", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("birthorder", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("parity", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("gravida", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("pragnancyindicator", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("durationofpragnancy", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("prvregno", "", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inaadhaarId", aadhaarno, String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("inaadhaarImg", uidData[15], String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("hosid", hospitalcode, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("deptid", departmentcode, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("unitid", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("clinicid", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("roomid", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("docid", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("appdate", appdate, String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("regno", "", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("tmpappid", "0", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("uid", 99999, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("entsystem", "0.0.0.0", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("apptype", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("appcat", 0, Integer.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("apptimestr", "8 AM", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("isautodoc", "Y", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("iswithuhid", "N", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("contextPath", "", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("mblno", uidData[3], String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("email", uidData[4], String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("ispayonline", Boolean.valueOf(false), Boolean.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("hid", "", String.class));
        localSoapObject.addProperty(ShowUIDAIData.this.addProperties("hidavailable", "", String.class));
      }
      paramVarArgs = new SoapSerializationEnvelope(110);
      paramVarArgs.setOutputSoapObject(localSoapObject);
      Object localObject = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/services?wsdl", 60000);
      try
      {
        ((HttpTransportSE)localObject).call("http://orsws/", paramVarArgs);
        paramVarArgs = (SoapPrimitive)paramVarArgs.getResponse();
        finalresp = paramVarArgs.toString();
        return finalresp;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
        }
      }
    }
    
    protected void onPostExecute(final String paramString)
    {
      super.onPostExecute(paramString);
      if (dlog.isShowing()) {
        dlog.dismiss();
      }
      for (;;)
      {
        int k;
        int i;
        int j;
        try
        {
          paramString = new JSONObject(paramString);
          Object localObject1;
          if (METHOD.equals("getAvailabledatelist"))
          {
            list.clear();
            id.clear();
            Object localObject2 = new JSONObject(paramString.get("data").toString());
            localObject1 = ((JSONObject)localObject2).optJSONArray("calenderData");
            localObject2 = ((JSONObject)localObject2).optJSONArray("eventCalender");
            k = 0;
            if (k < ((JSONArray)localObject1).length())
            {
              i = 0;
              JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(k);
              if (localJSONObject.getString("flag").equals("4")) {
                i = 1;
              }
              if (localJSONObject.getString("flag").equals("2")) {
                i = 1;
              }
              j = i;
              String str;
              if (localJSONObject.getString("flag").equals("1"))
              {
                j = 0;
                if (j < ((JSONArray)localObject2).length())
                {
                  str = localJSONObject.getString("day_");
                  if (!((JSONArray)localObject2).getJSONObject(j).getString("calender_day").equals(str)) {
                    break label773;
                  }
                  i = 1;
                  break label773;
                }
                j = i;
                if (i == 0)
                {
                  list.add(localJSONObject.getString("app_date_"));
                  j = i;
                }
              }
              if (!localJSONObject.getString("flag").equals("3")) {
                break label787;
              }
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                str = localJSONObject.getString("day_");
                if (!((JSONArray)localObject2).getJSONObject(i).getString("calender_day").equals(str)) {
                  break label780;
                }
                j = 1;
                break label780;
              }
              if (j != 0) {
                break label787;
              }
              list.add(localJSONObject.getString("app_date_"));
              break label787;
            }
            date = ((String[])list.toArray(new String[list.size()]));
            i = 0;
            localObject1 = list.iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              datelist.add(localObject2);
              i += 1;
              continue;
            }
            date = ((String[])datelist.toArray(new String[datelist.size()]));
            mdate.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, date));
            localObject1 = ShowUIDAIData.this;
            monthx += 1;
            if (isConnected()) {
              new ShowUIDAIData.CallListagain(ShowUIDAIData.this, null).execute(new String[] { "getAvailabledatelist" });
            }
          }
          if (!METHOD.equals("fixAppointment")) {
            break;
          }
          if (finalresp.equals("{}")) {
            ShowUIDAIData.this.showDialogonclick(getResources().getString(2131034334));
          }
          if (paramString.getString("error_code").equals("0"))
          {
            localObject1 = new Intent(getApplicationContext(), ShowAppointment.class);
            ((Intent)localObject1).putExtra("uid_data", uidData);
            editor.putString("appointment_id", paramString.getString("appointment_id")).commit();
            editor.putString("hid_data", paramString.getString("hid")).commit();
            ((Intent)localObject1).putExtra("from", "fromaadhaar");
            startActivity((Intent)localObject1);
            return;
          }
          runOnUiThread(new Runnable()
          {
            public void run()
            {
              try
              {
                ShowUIDAIData.this.showDialogonclick(paramString.getString("error_string"));
                return;
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
              }
            }
          });
          return;
        }
        catch (JSONException paramString)
        {
          return;
        }
        label773:
        j += 1;
        continue;
        label780:
        i += 1;
        continue;
        label787:
        k += 1;
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(ShowUIDAIData.this);
      dlog.setTitle(getResources().getString(2131034289));
      dlog.setMessage(getResources().getString(2131034151));
      if (Build.VERSION.SDK_INT >= 11)
      {
        dlog.setProgressStyle(1);
        dlog.setIndeterminate(true);
        dlog.setProgressNumberFormat(null);
        dlog.setProgressPercentFormat(null);
      }
      dlog.setCancelable(false);
      dlog.show();
    }
  }
  
  private class CallListagain
    extends AsyncTask<String, String, String>
  {
    private ProgressDialog dlog;
    
    private CallListagain() {}
    
    protected String doInBackground(String... paramVarArgs)
    {
      ShowUIDAIData.access$202(ShowUIDAIData.this, paramVarArgs[0]);
      paramVarArgs = new SoapObject("http://orsws/", METHOD);
      if (METHOD.equals("getAvailabledatelist"))
      {
        localObject = new PropertyInfo();
        ((PropertyInfo)localObject).setName("hospitalid");
        ((PropertyInfo)localObject).setValue(Integer.valueOf(hospitalcode));
        ((PropertyInfo)localObject).setType(Integer.class);
        paramVarArgs.addProperty((PropertyInfo)localObject);
        localObject = new PropertyInfo();
        ((PropertyInfo)localObject).setName("departmentid");
        ((PropertyInfo)localObject).setValue(Integer.valueOf(departmentcode));
        ((PropertyInfo)localObject).setType(Integer.class);
        paramVarArgs.addProperty((PropertyInfo)localObject);
        localObject = new PropertyInfo();
        ((PropertyInfo)localObject).setName("appointmentcat");
        ((PropertyInfo)localObject).setValue(Integer.valueOf(0));
        ((PropertyInfo)localObject).setType(Integer.class);
        paramVarArgs.addProperty((PropertyInfo)localObject);
        localObject = new PropertyInfo();
        ((PropertyInfo)localObject).setName("calmonth");
        ((PropertyInfo)localObject).setValue(Integer.valueOf(monthx));
        ((PropertyInfo)localObject).setType(Integer.class);
        paramVarArgs.addProperty((PropertyInfo)localObject);
        localObject = new PropertyInfo();
        ((PropertyInfo)localObject).setName("inToken");
        ((PropertyInfo)localObject).setValue("dG9rZW5Ad2ViQGFwcG9pbnQjbmlj");
        ((PropertyInfo)localObject).setType(String.class);
        paramVarArgs.addProperty((PropertyInfo)localObject);
      }
      Object localObject = new SoapSerializationEnvelope(110);
      ((SoapSerializationEnvelope)localObject).setOutputSoapObject(paramVarArgs);
      paramVarArgs = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/services?wsdl", 60000);
      try
      {
        paramVarArgs.call("http://orsws/", (SoapEnvelope)localObject);
        paramVarArgs = (SoapPrimitive)((SoapSerializationEnvelope)localObject).getResponse();
        finalresp = paramVarArgs.toString();
        return finalresp;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
        }
      }
    }
    
    protected void onPostExecute(String paramString)
    {
      super.onPostExecute(paramString);
      if (dlog.isShowing()) {
        dlog.dismiss();
      }
      if ((METHOD.equals("fixAppointment")) && (finalresp.equals("{}"))) {
        ShowUIDAIData.this.showMessage("ERROR");
      }
      for (;;)
      {
        int k;
        int i;
        int j;
        try
        {
          paramString = new JSONObject(paramString);
          if (METHOD.equals("getAvailabledatelist"))
          {
            list.clear();
            id.clear();
            Object localObject = new JSONObject(paramString.get("data").toString());
            paramString = ((JSONObject)localObject).optJSONArray("calenderData");
            localObject = ((JSONObject)localObject).optJSONArray("eventCalender");
            id.add("0");
            k = 0;
            if (k < paramString.length())
            {
              i = 0;
              JSONObject localJSONObject = paramString.getJSONObject(k);
              if (localJSONObject.getString("flag").equals("4")) {
                i = 1;
              }
              if (localJSONObject.getString("flag").equals("2")) {
                i = 1;
              }
              j = i;
              String str;
              if (localJSONObject.getString("flag").equals("1"))
              {
                j = 0;
                if (j < ((JSONArray)localObject).length())
                {
                  str = localJSONObject.getString("day_");
                  if (!((JSONArray)localObject).getJSONObject(j).getString("calender_day").equals(str)) {
                    break label604;
                  }
                  i = 1;
                  break label604;
                }
                j = i;
                if (i == 0)
                {
                  list.add(localJSONObject.getString("app_date_"));
                  j = i;
                }
              }
              if (!localJSONObject.getString("flag").equals("3")) {
                break label618;
              }
              i = 0;
              if (i < ((JSONArray)localObject).length())
              {
                str = localJSONObject.getString("day_");
                if (!((JSONArray)localObject).getJSONObject(i).getString("calender_day").equals(str)) {
                  break label611;
                }
                j = 1;
                break label611;
              }
              if (j != 0) {
                break label618;
              }
              list.add(localJSONObject.getString("app_date_"));
              break label618;
            }
            else
            {
              date = ((String[])list.toArray(new String[list.size()]));
              i = 0;
              paramString = list.iterator();
              if (paramString.hasNext())
              {
                localObject = (String)paramString.next();
                datelist.add(localObject);
                i += 1;
                continue;
              }
              date = new String[limit];
              date[0] = getResources().getString(2131034139);
              i = 1;
              if (i < 10)
              {
                date[i] = ((String)datelist.get(i));
                i += 1;
                continue;
              }
              mdate.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, date));
            }
          }
          else
          {
            return;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return;
        }
        label604:
        j += 1;
        continue;
        label611:
        i += 1;
        continue;
        label618:
        k += 1;
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(ShowUIDAIData.this);
      dlog.setTitle(getResources().getString(2131034289));
      dlog.setMessage(getResources().getString(2131034162));
      if (Build.VERSION.SDK_INT >= 11)
      {
        dlog.setProgressStyle(1);
        dlog.setIndeterminate(true);
        dlog.setProgressNumberFormat(null);
        dlog.setProgressPercentFormat(null);
      }
      dlog.setCancelable(false);
      dlog.show();
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/ShowUIDAIData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */