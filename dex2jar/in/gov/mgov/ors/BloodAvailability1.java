package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import in.gov.mgov.helper.Helper;
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

public class BloodAvailability1
  extends Activity
  implements View.OnClickListener
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/bbservices?wsdl";
  static String selected_state_id_from_spinner = "0";
  private String METHOD = "";
  private String[] arraySpinnerState;
  Button btn_back;
  ImageView button_home;
  ListView listview_hospital;
  String selectedstate = "";
  LinearLayout selectstate_linearlayout;
  Spinner spinner_selectState;
  String[] state;
  String[] stateid;
  String[] stringarray_bbaddress;
  String[] stringarray_bbdistid;
  String[] stringarray_bbdistname;
  String[] stringarray_bbemail;
  String[] stringarray_bbid;
  String[] stringarray_bblandno;
  String[] stringarray_bbmoicname;
  String[] stringarray_bbname = new String[0];
  String[] stringarray_bbstateid;
  String[] stringarray_bbstatename;
  TextView textview_bloodbanktitle;
  TextView title;
  
  private void popultelist()
  {
    new CallList(null).execute(new String[] { "getBloodBanklistforastate" });
    listview_hospital.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = new Intent(getBaseContext(), BloodAvailability2.class);
        paramAnonymousAdapterView.putExtra("bbaddress", stringarray_bbaddress[paramAnonymousInt]);
        paramAnonymousAdapterView.putExtra("bbname", stringarray_bbname[paramAnonymousInt]);
        paramAnonymousAdapterView.putExtra("bbemail", stringarray_bbemail[paramAnonymousInt]);
        paramAnonymousAdapterView.putExtra("bbstateid", stringarray_bbstateid[paramAnonymousInt]);
        paramAnonymousAdapterView.putExtra("bbstatename", stringarray_bbstatename[paramAnonymousInt]);
        paramAnonymousAdapterView.putExtra("bbid", stringarray_bbid[paramAnonymousInt]);
        paramAnonymousAdapterView.putExtra("bbdistname", stringarray_bbdistname[paramAnonymousInt]);
        paramAnonymousAdapterView.putExtra("bblandno", stringarray_bblandno[paramAnonymousInt]);
        paramAnonymousAdapterView.putExtra("bbdistid", stringarray_bbdistid[paramAnonymousInt]);
        paramAnonymousAdapterView.putExtra("bbmoicname", stringarray_bbmoicname[paramAnonymousInt]);
        startActivity(paramAnonymousAdapterView);
      }
    });
  }
  
  private void showMessage(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 1);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == btn_back) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903043);
    spinner_selectState = ((Spinner)findViewById(2131296295));
    listview_hospital = ((ListView)findViewById(2131296297));
    title = ((TextView)findViewById(2131296293));
    btn_back = ((Button)findViewById(2131296298));
    btn_back.setOnClickListener(this);
    textview_bloodbanktitle = ((TextView)findViewById(2131296296));
    selectstate_linearlayout = ((LinearLayout)findViewById(2131296294));
    button_home = ((ImageView)findViewById(2131296259));
    new CallList(null).execute(new String[] { "getBBStatelist" });
    button_home.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), ServiceSelection.class);
        paramAnonymousView.addFlags(268468224);
        startActivity(paramAnonymousView);
      }
    });
    spinner_selectState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        selectedstate = paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt).toString();
        if (paramAnonymousInt != 0)
        {
          title.setText(getResources().getString(2131034146) + "- " + selectedstate);
          selectstate_linearlayout.setBackgroundColor(Color.parseColor("#eeeeee"));
          listview_hospital.setVisibility(0);
          textview_bloodbanktitle.setVisibility(0);
          BloodAvailability1.selected_state_id_from_spinner = stateid[paramAnonymousInt];
          BloodAvailability1.this.popultelist();
        }
        while (paramAnonymousInt != 0) {
          return;
        }
        title.setText(getResources().getString(2131034146));
        selectstate_linearlayout.setBackgroundColor(Color.parseColor("#ffffff"));
        listview_hospital.setVisibility(8);
        textview_bloodbanktitle.setVisibility(8);
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
  }
  
  private class CallList
    extends AsyncTask<String, String, String>
  {
    List<String> bbaddress_list = new ArrayList();
    List<String> bbdistid_list = new ArrayList();
    List<String> bbdistname_list = new ArrayList();
    List<String> bbemail_list = new ArrayList();
    List<String> bbid_list = new ArrayList();
    List<String> bblandno_list = new ArrayList();
    List<String> bbmoicname_list = new ArrayList();
    List<String> bbname_list = new ArrayList();
    List<String> bbstateid_list = new ArrayList();
    List<String> bbstatename_list = new ArrayList();
    private ProgressDialog dlog;
    String finalresp;
    List<String> state_id = new ArrayList();
    List<String> state_list = new ArrayList();
    
    private CallList() {}
    
    private PropertyInfo addProperties(String paramString1, String paramString2, Object paramObject)
    {
      PropertyInfo localPropertyInfo = new PropertyInfo();
      localPropertyInfo.setName(paramString1);
      localPropertyInfo.setValue(paramString2);
      localPropertyInfo.setType(paramObject);
      return localPropertyInfo;
    }
    
    protected String doInBackground(String... paramVarArgs)
    {
      BloodAvailability1.access$202(BloodAvailability1.this, paramVarArgs[0]);
      Object localObject = new SoapObject("http://orsws/", METHOD);
      if (METHOD.equals("getBBStatelist")) {
        ((SoapObject)localObject).addProperty(addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
      }
      if (METHOD.equals("getBloodBanklistforastate"))
      {
        ((SoapObject)localObject).addProperty(addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
        ((SoapObject)localObject).addProperty(addProperties("stateid", BloodAvailability1.selected_state_id_from_spinner, String.class));
      }
      paramVarArgs = new SoapSerializationEnvelope(110);
      paramVarArgs.setOutputSoapObject(localObject);
      localObject = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/bbservices?wsdl", 60000);
      try
      {
        ((HttpTransportSE)localObject).call("http://orsws/", paramVarArgs);
        finalresp = ((SoapPrimitive)paramVarArgs.getResponse()).toString();
        return finalresp;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          runOnUiThread(new Runnable()
          {
            public void run()
            {
              BloodAvailability1.this.showMessage(getResources().getString(2131034292));
            }
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
        Object localObject;
        int i;
        JSONObject localJSONObject;
        int j;
        try
        {
          paramString = new JSONObject(paramString);
          if (METHOD.equals("getBBStatelist"))
          {
            state_list.clear();
            state_id.clear();
            localObject = paramString.optJSONArray("statelist");
            state_list.add(getResources().getString(2131034300));
            state_id.add("0");
            i = 0;
            if (i < ((JSONArray)localObject).length())
            {
              localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              state_list.add(localJSONObject.getString("statename"));
              state_id.add(localJSONObject.getString("stateid"));
              i += 1;
              continue;
            }
            state = ((String[])state_list.toArray(new String[state_list.size()]));
            stateid = ((String[])state_id.toArray(new String[state_id.size()]));
            localObject = state;
            j = localObject.length;
            i = 0;
            break label1032;
            localObject = stateid;
            j = localObject.length;
            i = 0;
            break label1050;
            if (state_list.size() == 1) {
              runOnUiThread(new Runnable()
              {
                public void run()
                {
                  new Helper(getApplicationContext()).showDialogonclick(getResources().getString(2131034253));
                }
              });
            }
            spinner_selectState.setAdapter(new ArrayAdapter(getApplicationContext(), 2130903050, state));
          }
          else
          {
            if (METHOD.equals("getBloodBanklistforastate"))
            {
              bbaddress_list.clear();
              bbname_list.clear();
              bbemail_list.clear();
              bbstateid_list.clear();
              bbstatename_list.clear();
              bbid_list.clear();
              bbdistname_list.clear();
              bblandno_list.clear();
              bbdistid_list.clear();
              bbmoicname_list.clear();
              paramString = paramString.optJSONArray("bblistforastate");
              i = 0;
              if (i < paramString.length())
              {
                localObject = paramString.getJSONObject(i);
                bbaddress_list.add(((JSONObject)localObject).getString("bbaddress"));
                bbname_list.add(((JSONObject)localObject).getString("bbname"));
                bbemail_list.add(((JSONObject)localObject).getString("bbemail"));
                bbstateid_list.add(((JSONObject)localObject).getString("bbstateid"));
                bbstatename_list.add(((JSONObject)localObject).getString("bbstatename"));
                bbid_list.add(((JSONObject)localObject).getString("bbid"));
                bbdistname_list.add(((JSONObject)localObject).getString("bbdistname"));
                bblandno_list.add(((JSONObject)localObject).getString("bblandno"));
                bbdistid_list.add(((JSONObject)localObject).getString("bbdistid"));
                bbmoicname_list.add(((JSONObject)localObject).getString("bbmoicname"));
                i += 1;
                continue;
              }
              stringarray_bbaddress = ((String[])bbaddress_list.toArray(new String[bbaddress_list.size()]));
              stringarray_bbname = ((String[])bbname_list.toArray(new String[bbname_list.size()]));
              stringarray_bbemail = ((String[])bbemail_list.toArray(new String[bbemail_list.size()]));
              stringarray_bbstateid = ((String[])bbstateid_list.toArray(new String[bbstateid_list.size()]));
              stringarray_bbstatename = ((String[])bbstatename_list.toArray(new String[bbstatename_list.size()]));
              stringarray_bbid = ((String[])bbid_list.toArray(new String[bbid_list.size()]));
              stringarray_bbdistname = ((String[])bbdistname_list.toArray(new String[bbdistname_list.size()]));
              stringarray_bblandno = ((String[])bblandno_list.toArray(new String[bblandno_list.size()]));
              stringarray_bbdistid = ((String[])bbdistid_list.toArray(new String[bbdistid_list.size()]));
              stringarray_bbmoicname = ((String[])bbmoicname_list.toArray(new String[bbmoicname_list.size()]));
              if (state_list.size() == 1) {
                runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    new Helper(getApplicationContext()).showDialogonclick(getResources().getString(2131034253));
                  }
                });
              }
              paramString = new ArrayAdapter(BloodAvailability1.this, 17367043, stringarray_bbname);
              listview_hospital.setAdapter(paramString);
            }
            return;
          }
        }
        catch (JSONException paramString)
        {
          runOnUiThread(new Runnable()
          {
            public void run()
            {
              BloodAvailability1.this.showMessage(getResources().getString(2131034200));
            }
          });
          return;
        }
        label1032:
        while (i < j)
        {
          localJSONObject = localObject[i];
          i += 1;
        }
        continue;
        label1050:
        while (i < j)
        {
          localJSONObject = localObject[i];
          i += 1;
        }
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(BloodAvailability1.this);
      dlog.setTitle(getResources().getString(2131034289));
      dlog.setMessage(getResources().getString(2131034206));
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


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/BloodAvailability1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */