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
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
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

public class BookAppointmentWithout
  extends Activity
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  String DepartmentnameString;
  private String METHOD = "";
  String aadhaarno;
  String appdate;
  ImageView button_home;
  Button cancel;
  TextView chk;
  String[] date = { "-Select Date-", "24-june-2015", "25-june-2015", "25-june-2015", "26-june-2015" };
  String dateString;
  List<String> datelist = new ArrayList();
  String[] department = { "-Select Department-", "Cardiology", "C.T.V.S", "Endrocrionology", "ENT", "Pedriatric" };
  int departmentcode;
  String[] departmentid;
  SharedPreferences.Editor editor;
  String finalresp = "";
  String[] hospital = { "-Select Hospital-", "AIIMS", "Dr.Ram Manohar Lohia Hospital", "Sports Injury Center (Safdarjung Hospital)" };
  int hospitalcode;
  String[] hospitalid;
  TextView hospitalname;
  String hospitalnameString;
  List<String> id = new ArrayList();
  int limit = 5;
  List<String> list = new ArrayList();
  Spinner mdate;
  Spinner mdepartment;
  Spinner mhospital;
  Spinner mstate;
  Button next;
  SharedPreferences pref;
  Button proceed;
  String spacialitymessage = "";
  String[] state = { "-Select State-", "ASSAM", "BIHAR", "DELHI", "GOA", "GUJRAT", "HARYANA" };
  int statecode = 7;
  String[] stateid;
  String[] uidData;
  int x = 0;
  Button yes;
  
  private void intitializeViews()
  {
    button_home = ((ImageView)findViewById(2131296259));
    mstate = ((Spinner)findViewById(2131296334));
    mhospital = ((Spinner)findViewById(2131296335));
    mdepartment = ((Spinner)findViewById(2131296337));
    mdate = ((Spinner)findViewById(2131296338));
    hospitalname = ((TextView)findViewById(2131296332));
    chk = ((TextView)findViewById(2131296342));
    next = ((Button)findViewById(2131296339));
    yes = ((Button)findViewById(2131296341));
    proceed = ((Button)findViewById(2131296273));
    cancel = ((Button)findViewById(2131296340));
  }
  
  private void showDialogonclick(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getResources().getString(2131034183));
    localBuilder.setMessage(paramString).setCancelable(false).setPositiveButton(getResources().getString(2131034259), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    localBuilder.create().show();
  }
  
  private void showDialogonclickExtra(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getResources().getString(2131034183));
    localBuilder.setMessage(paramString).setCancelable(false).setPositiveButton(getResources().getString(2131034259), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Intent localIntent = new Intent(getApplicationContext(), AuthenticateNonAadhaar.class);
        localIntent.putExtra("appointment_info", "<" + hospitalnameString + ">" + "<" + DepartmentnameString + ">" + "<" + dateString + ">");
        editor.putString("appointment_detail", spacialitymessage).commit();
        localIntent.putExtra("from", "noaadhaar");
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
    yes.setVisibility(8);
    next.setVisibility(8);
    ArrayAdapter localArrayAdapter = new ArrayAdapter(getApplicationContext(), 2130903050, state);
    mstate.setAdapter(localArrayAdapter);
    if (isConnected()) {
      new CallList(null).execute(new String[] { "getHospitallist", "0" });
    }
    mstate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (!state[paramAnonymousInt].contains("Select"))
        {
          if (isConnected()) {
            new BookAppointmentWithout.CallList(BookAppointmentWithout.this, null).execute(new String[] { "getHospitallist", Integer.toString(paramAnonymousInt) });
          }
          return;
        }
        hospitalname.setText("");
        cancel.setVisibility(8);
        proceed.setVisibility(8);
        yes.setVisibility(8);
        next.setVisibility(8);
        mhospital.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, new String[] { getResources().getString(2131034307) }));
        mdepartment.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, new String[] { getResources().getString(2131034303) }));
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    mhospital.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (!hospital[paramAnonymousInt].contains("Select"))
        {
          hospitalname.setText(hospital[paramAnonymousInt]);
          hospitalnameString = hospital[paramAnonymousInt];
          datelist.clear();
          if (isConnected()) {
            new BookAppointmentWithout.CallList(BookAppointmentWithout.this, null).execute(new String[] { "getDepartmentlist", Integer.toString(paramAnonymousInt) });
          }
          return;
        }
        cancel.setVisibility(8);
        proceed.setVisibility(8);
        yes.setVisibility(8);
        next.setVisibility(8);
        hospitalname.setText("");
        datelist.clear();
        mdepartment.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, new String[] { getResources().getString(2131034303) }));
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    mdepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (!department[paramAnonymousInt].contains("Select"))
        {
          DepartmentnameString = department[paramAnonymousInt];
          datelist.clear();
          mdate.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, new String[] { getResources().getString(2131034139) }));
          departmentcode = Integer.parseInt(departmentid[paramAnonymousInt]);
          x = 0;
          if (isConnected()) {
            new BookAppointmentWithout.CallList(BookAppointmentWithout.this, null).execute(new String[] { "getAvailabledatelist", Integer.toString(paramAnonymousInt) });
          }
          return;
        }
        proceed.setVisibility(8);
        cancel.setVisibility(8);
        yes.setVisibility(8);
        datelist.clear();
        next.setVisibility(8);
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    mdate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (paramAnonymousInt != 0)
        {
          dateString = date[paramAnonymousInt];
          yes.setVisibility(0);
          appdate = date[paramAnonymousInt];
          return;
        }
        proceed.setVisibility(8);
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    proceed.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        editor.putString("state_name", "");
        editor.putString("dept_name", DepartmentnameString);
        editor.putString("hospital_name", hospitalnameString);
        editor.putString("date_name", dateString);
        editor.putString("dept_code", Integer.toString(departmentcode));
        editor.putString("hospital_code", Integer.toString(hospitalcode));
        editor.putString("state_code", Integer.toString(statecode));
        editor.commit();
        new BookAppointmentWithout.CallList(BookAppointmentWithout.this, null).execute(new String[] { "getSuperSpacialityMsg", Integer.toString(departmentcode) });
      }
    });
    yes.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!mdate.getSelectedItem().toString().contains("Available"))
        {
          editor.putString("state_name", "");
          editor.putString("dept_name", DepartmentnameString);
          editor.putString("hospital_name", hospitalnameString);
          editor.putString("date_name", dateString);
          editor.putString("dept_code", Integer.toString(departmentcode));
          editor.putString("hospital_code", Integer.toString(hospitalcode));
          editor.putString("state_code", Integer.toString(statecode));
          editor.commit();
          spacialitymessage = "";
          new BookAppointmentWithout.CallList(BookAppointmentWithout.this, null).execute(new String[] { "getSuperSpacialityMsg", Integer.toString(departmentcode) });
          return;
        }
        BookAppointmentWithout.this.showMessage(getResources().getString(2131034178));
      }
    });
    cancel.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Toast.makeText(getApplicationContext(), getResources().getString(2131034325), 1).show();
      }
    });
    next.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        BookAppointmentWithout.this.showMessage(getResources().getString(2131034141));
        paramAnonymousView = BookAppointmentWithout.this;
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
    setContentView(2130903045);
    pref = getSharedPreferences("ors", 0);
    editor = pref.edit();
    intitializeViews();
    try
    {
      updateView();
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  private class CallList
    extends AsyncTask<String, String, String>
  {
    private ProgressDialog dlog;
    
    private CallList() {}
    
    protected String doInBackground(String... paramVarArgs)
    {
      BookAppointmentWithout.access$202(BookAppointmentWithout.this, paramVarArgs[0]);
      Object localObject = new SoapObject("http://orsws/", METHOD);
      PropertyInfo localPropertyInfo;
      if (METHOD.equals("getHospitallist"))
      {
        localPropertyInfo = new PropertyInfo();
        localPropertyInfo.setName("stateid");
        localPropertyInfo.setValue(Integer.valueOf(7));
        localPropertyInfo.setType(Integer.class);
        ((SoapObject)localObject).addProperty(localPropertyInfo);
      }
      if (METHOD.equals("getDepartmentlist"))
      {
        hospitalcode = Integer.parseInt(hospitalid[Integer.parseInt(paramVarArgs[1])]);
        localPropertyInfo = new PropertyInfo();
        localPropertyInfo.setName("hospitalid");
        localPropertyInfo.setValue(hospitalid[Integer.parseInt(paramVarArgs[1])]);
        localPropertyInfo.setType(Integer.class);
        ((SoapObject)localObject).addProperty(localPropertyInfo);
      }
      if (METHOD.equals("getSuperSpacialityMsg"))
      {
        localPropertyInfo = new PropertyInfo();
        localPropertyInfo.setName("intoken");
        localPropertyInfo.setValue("dG9rZW5Ad2ViQGFwcG9pbnQjbmlj");
        localPropertyInfo.setType(String.class);
        ((SoapObject)localObject).addProperty(localPropertyInfo);
        localPropertyInfo = new PropertyInfo();
        localPropertyInfo.setName("dept_id");
        localPropertyInfo.setValue(Integer.valueOf(departmentcode));
        localPropertyInfo.setType(Integer.class);
        ((SoapObject)localObject).addProperty(localPropertyInfo);
        localPropertyInfo = new PropertyInfo();
        localPropertyInfo.setName("hos_id");
        localPropertyInfo.setValue(Integer.valueOf(hospitalcode));
        localPropertyInfo.setType(Integer.class);
        ((SoapObject)localObject).addProperty(localPropertyInfo);
      }
      if (METHOD.equals("getAvailabledatelist"))
      {
        departmentcode = Integer.parseInt(departmentid[Integer.parseInt(paramVarArgs[1])]);
        localPropertyInfo = new PropertyInfo();
        localPropertyInfo.setName("hospitalid");
        localPropertyInfo.setValue(Integer.valueOf(hospitalcode));
        localPropertyInfo.setType(Integer.class);
        ((SoapObject)localObject).addProperty(localPropertyInfo);
        localPropertyInfo = new PropertyInfo();
        localPropertyInfo.setName("departmentid");
        localPropertyInfo.setValue(departmentid[Integer.parseInt(paramVarArgs[1])]);
        localPropertyInfo.setType(Integer.class);
        ((SoapObject)localObject).addProperty(localPropertyInfo);
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("appointmentcat");
        paramVarArgs.setValue(Integer.valueOf(1));
        paramVarArgs.setType(Integer.class);
        ((SoapObject)localObject).addProperty(paramVarArgs);
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("calmonth");
        paramVarArgs.setValue(Integer.valueOf(0));
        paramVarArgs.setType(Integer.class);
        ((SoapObject)localObject).addProperty(paramVarArgs);
        paramVarArgs = new PropertyInfo();
        paramVarArgs.setName("inToken");
        paramVarArgs.setValue("dG9rZW5Ad2ViQGFwcG9pbnQjbmlj");
        paramVarArgs.setType(String.class);
        ((SoapObject)localObject).addProperty(paramVarArgs);
      }
      paramVarArgs = new SoapSerializationEnvelope(110);
      paramVarArgs.setOutputSoapObject(localObject);
      localObject = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/services?wsdl", 60000);
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
          runOnUiThread(new Runnable()
          {
            public void run() {}
          });
        }
      }
    }
    
    protected void onPostExecute(String paramString)
    {
      super.onPostExecute(paramString);
      if (dlog.isShowing()) {
        dlog.dismiss();
      }
      for (;;)
      {
        Object localObject1;
        int i;
        Object localObject2;
        int j;
        int k;
        try
        {
          paramString = new JSONObject(paramString);
          if (METHOD.equals("getStatelist"))
          {
            list.clear();
            id.clear();
            localObject1 = paramString.optJSONArray("statelist");
            list.add(getResources().getString(2131034309));
            id.add("0");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localObject2 = ((JSONArray)localObject1).getJSONObject(i);
              list.add(((JSONObject)localObject2).getString("statename"));
              id.add(((JSONObject)localObject2).getString("stateid"));
              i += 1;
              continue;
            }
            state = ((String[])list.toArray(new String[list.size()]));
            stateid = ((String[])id.toArray(new String[id.size()]));
            localObject1 = state;
            j = localObject1.length;
            i = 0;
            break label1755;
            localObject1 = stateid;
            j = localObject1.length;
            i = 0;
            break label1773;
            mstate.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, state));
          }
          else
          {
            if (METHOD.equals("getHospitallist"))
            {
              list.clear();
              id.clear();
              localObject1 = paramString.optJSONArray("hospitallist");
              list.add(getResources().getString(2131034307));
              id.add("0");
              i = 0;
              if (i < ((JSONArray)localObject1).length())
              {
                localObject2 = ((JSONArray)localObject1).getJSONObject(i);
                list.add(((JSONObject)localObject2).getString("hospitalname"));
                id.add(((JSONObject)localObject2).getString("hospitalid"));
                i += 1;
                continue;
              }
              hospital = ((String[])list.toArray(new String[list.size()]));
              hospitalid = ((String[])id.toArray(new String[id.size()]));
              localObject1 = hospital;
              j = localObject1.length;
              i = 0;
              break label1791;
              localObject1 = hospitalid;
              j = localObject1.length;
              i = 0;
              break label1809;
              if (list.size() == 1) {
                runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    BookAppointmentWithout.this.showDialogonclick(getResources().getString(2131034253));
                  }
                });
              }
              mhospital.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, hospital));
            }
            if (METHOD.equals("getDepartmentlist"))
            {
              list.clear();
              id.clear();
              localObject1 = paramString.optJSONArray("departmentlist");
              list.add(getResources().getString(2131034303));
              id.add("0");
              i = 0;
              if (i < ((JSONArray)localObject1).length())
              {
                localObject2 = ((JSONArray)localObject1).getJSONObject(i);
                list.add(((JSONObject)localObject2).getString("departmentname"));
                id.add(((JSONObject)localObject2).getString("departmentid"));
                i += 1;
                continue;
              }
              department = ((String[])list.toArray(new String[list.size()]));
              departmentid = ((String[])id.toArray(new String[id.size()]));
              localObject1 = department;
              j = localObject1.length;
              i = 0;
              break label1827;
              localObject1 = departmentid;
              j = localObject1.length;
              i = 0;
              break label1845;
              if (list.size() == 1) {
                runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    BookAppointmentWithout.this.showDialogonclick(getResources().getString(2131034253));
                  }
                });
              }
              mdepartment.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, department));
            }
            if (METHOD.equals("getAvailabledatelist"))
            {
              list.clear();
              id.clear();
              localObject2 = new JSONObject(paramString.get("data").toString());
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
                      break label1863;
                    }
                    i = 1;
                    break label1863;
                  }
                  j = i;
                  if (i == 0)
                  {
                    list.add(localJSONObject.getString("app_date_"));
                    j = i;
                  }
                }
                if (!localJSONObject.getString("flag").equals("3")) {
                  break label1877;
                }
                i = 0;
                if (i < ((JSONArray)localObject2).length())
                {
                  str = localJSONObject.getString("day_");
                  if (!((JSONArray)localObject2).getJSONObject(i).getString("calender_day").equals(str)) {
                    break label1870;
                  }
                  j = 1;
                  break label1870;
                }
                if (j != 0) {
                  break label1877;
                }
                list.add(localJSONObject.getString("app_date_"));
                break label1877;
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
              if (isConnected()) {
                new BookAppointmentWithout.CallListagain(BookAppointmentWithout.this, null).execute(new String[] { "getAvailabledatelist" });
              }
            }
            if (!METHOD.equals("getSuperSpacialityMsg")) {
              break;
            }
            spacialitymessage = paramString.getString("msg");
            if (spacialitymessage.equalsIgnoreCase("NA"))
            {
              spacialitymessage = "";
              paramString = new Intent(getApplicationContext(), AuthenticateNonAadhaar.class);
              editor.putString("appointment_detail", spacialitymessage).commit();
              paramString.putExtra("from", "noaadhaar");
              paramString.putExtra("appointment_info", "<" + hospitalnameString + ">" + "<" + DepartmentnameString + ">" + "<" + dateString + ">");
              startActivity(paramString);
              return;
            }
            BookAppointmentWithout.this.showDialogonclickExtra(spacialitymessage);
            return;
          }
        }
        catch (JSONException paramString)
        {
          runOnUiThread(new Runnable()
          {
            public void run() {}
          });
          return;
        }
        label1755:
        while (i < j)
        {
          localObject2 = localObject1[i];
          i += 1;
        }
        continue;
        label1773:
        while (i < j)
        {
          localObject2 = localObject1[i];
          i += 1;
        }
        continue;
        label1791:
        while (i < j)
        {
          localObject2 = localObject1[i];
          i += 1;
        }
        continue;
        label1809:
        while (i < j)
        {
          localObject2 = localObject1[i];
          i += 1;
        }
        continue;
        label1827:
        while (i < j)
        {
          localObject2 = localObject1[i];
          i += 1;
        }
        continue;
        label1845:
        while (i < j)
        {
          localObject2 = localObject1[i];
          i += 1;
        }
        continue;
        label1863:
        j += 1;
        continue;
        label1870:
        i += 1;
        continue;
        label1877:
        k += 1;
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(BookAppointmentWithout.this);
      dlog.setTitle(getResources().getString(2131034289));
      dlog.setMessage(getResources().getString(2131034207));
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
      BookAppointmentWithout.access$202(BookAppointmentWithout.this, paramVarArgs[0]);
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
        ((PropertyInfo)localObject).setValue(Integer.valueOf(1));
        ((PropertyInfo)localObject).setType(Integer.class);
        paramVarArgs.addProperty((PropertyInfo)localObject);
        localObject = new PropertyInfo();
        ((PropertyInfo)localObject).setName("calmonth");
        ((PropertyInfo)localObject).setValue(Integer.valueOf(1));
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
          runOnUiThread(new Runnable()
          {
            public void run() {}
          });
        }
      }
    }
    
    protected void onPostExecute(String paramString)
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
                    break label951;
                  }
                  i = 1;
                  break label951;
                }
                j = i;
                if (i == 0)
                {
                  list.add(localJSONObject.getString("app_date_"));
                  j = i;
                }
              }
              if (!localJSONObject.getString("flag").equals("3")) {
                break label965;
              }
              i = 0;
              if (i < ((JSONArray)localObject).length())
              {
                str = localJSONObject.getString("day_");
                if (!((JSONArray)localObject).getJSONObject(i).getString("calender_day").equals(str)) {
                  break label958;
                }
                j = 1;
                break label958;
              }
              if (j != 0) {
                break label965;
              }
              list.add(localJSONObject.getString("app_date_"));
              break label965;
            }
            i = 0;
            paramString = list.iterator();
            if (paramString.hasNext())
            {
              localObject = (String)paramString.next();
              datelist.add(localObject);
              i += 1;
              continue;
            }
            if ((datelist.size() == 0) || (datelist.size() <= limit + 1)) {
              break label680;
            }
            date = new String[limit + 1];
            date[0] = getResources().getString(2131034139);
            i = 1;
            j = limit;
            if (i < j) {
              try
              {
                date[i] = ((String)datelist.get(i - 1));
                i += 1;
              }
              catch (Exception paramString)
              {
                runOnUiThread(new Runnable()
                {
                  public void run() {}
                });
                continue;
              }
            }
          }
          else
          {
            return;
          }
        }
        catch (JSONException paramString)
        {
          runOnUiThread(new Runnable()
          {
            public void run() {}
          });
        }
        date[limit] = ((String)datelist.get(limit - 1));
        if (date.length > limit) {
          runOnUiThread(new Runnable()
          {
            public void run()
            {
              yes.setVisibility(0);
              next.setVisibility(0);
            }
          });
        }
        mdate.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, date));
        return;
        label680:
        if ((datelist.size() != 0) && (datelist.size() <= limit))
        {
          date = new String[datelist.size() + 1];
          date[0] = getResources().getString(2131034139);
          i = 1;
          for (;;)
          {
            j = datelist.size();
            if (i < j) {
              try
              {
                date[i] = ((String)datelist.get(i - 1));
                i += 1;
              }
              catch (Exception paramString)
              {
                for (;;)
                {
                  runOnUiThread(new Runnable()
                  {
                    public void run() {}
                  });
                }
              }
            }
          }
          date[datelist.size()] = ((String)datelist.get(datelist.size() - 1));
          runOnUiThread(new Runnable()
          {
            public void run()
            {
              yes.setVisibility(0);
            }
          });
          mdate.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, date));
          return;
        }
        runOnUiThread(new Runnable()
        {
          public void run()
          {
            BookAppointmentWithout.this.showDialogonclick(getResources().getString(2131034248));
          }
        });
        return;
        label951:
        j += 1;
        continue;
        label958:
        i += 1;
        continue;
        label965:
        k += 1;
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(BookAppointmentWithout.this);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/BookAppointmentWithout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */