package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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

public class BloodAvailability2
  extends Activity
  implements View.OnClickListener
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/bbservices?wsdl";
  static String intent_bbid;
  static String intent_stateid;
  static int unified_length = 0;
  private String METHOD = "";
  TextView blood_item_txtview;
  TextView blood_item_txtview1;
  TextView blood_item_txtview2;
  TextView blood_item_txtview3;
  TextView blood_item_txtview4;
  TextView blood_item_txtview5;
  TextView blood_item_txtview6;
  TextView blood_item_txtview7;
  Button btn_back;
  ImageView button_home;
  ListView list_blood_type;
  TextView quantity_txtview;
  TextView quantity_txtview1;
  TextView quantity_txtview2;
  TextView quantity_txtview3;
  TextView quantity_txtview4;
  TextView quantity_txtview5;
  TextView quantity_txtview6;
  TextView quantity_txtview7;
  String[] stringarr_blodd_name;
  String[] stringarr_item_name;
  String[] stringarr_quantity;
  TextView textView_title_header;
  TextView textview_address;
  TextView textview_bloodbank_name;
  TextView textview_doctorname;
  TextView textview_phonenumber;
  
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
    setContentView(2130903044);
    textview_address = ((TextView)findViewById(2131296301));
    textview_doctorname = ((TextView)findViewById(2131296303));
    textview_phonenumber = ((TextView)findViewById(2131296305));
    textview_bloodbank_name = ((TextView)findViewById(2131296300));
    textView_title_header = ((TextView)findViewById(2131296299));
    paramBundle = getIntent();
    String str1 = paramBundle.getStringExtra("bbaddress");
    String str2 = paramBundle.getStringExtra("bbmoicname");
    String str3 = paramBundle.getStringExtra("bblandno");
    intent_bbid = paramBundle.getStringExtra("bbid");
    intent_stateid = paramBundle.getStringExtra("bbstateid");
    textview_address.setText(str1);
    textview_doctorname.setText(str2);
    textview_phonenumber.setText(str3);
    textview_bloodbank_name.setText(paramBundle.getStringExtra("bbname"));
    textView_title_header.setText(getResources().getString(2131034146) + " - " + paramBundle.getStringExtra("bbstatename"));
    btn_back = ((Button)findViewById(2131296298));
    btn_back.setOnClickListener(this);
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
    new CallList(null).execute(new String[] { "getBloodstatus" });
  }
  
  public void setListData()
  {
    blood_item_txtview = ((TextView)findViewById(2131296309));
    blood_item_txtview1 = ((TextView)findViewById(2131296312));
    blood_item_txtview2 = ((TextView)findViewById(2131296315));
    blood_item_txtview3 = ((TextView)findViewById(2131296318));
    blood_item_txtview4 = ((TextView)findViewById(2131296321));
    blood_item_txtview5 = ((TextView)findViewById(2131296324));
    blood_item_txtview6 = ((TextView)findViewById(2131296327));
    blood_item_txtview7 = ((TextView)findViewById(2131296330));
    quantity_txtview = ((TextView)findViewById(2131296310));
    quantity_txtview1 = ((TextView)findViewById(2131296313));
    quantity_txtview2 = ((TextView)findViewById(2131296316));
    quantity_txtview3 = ((TextView)findViewById(2131296319));
    quantity_txtview4 = ((TextView)findViewById(2131296322));
    quantity_txtview5 = ((TextView)findViewById(2131296325));
    quantity_txtview6 = ((TextView)findViewById(2131296328));
    quantity_txtview7 = ((TextView)findViewById(2131296331));
    blood_item_txtview.setText(stringarr_item_name[0]);
    blood_item_txtview1.setText(stringarr_item_name[1]);
    blood_item_txtview2.setText(stringarr_item_name[2]);
    blood_item_txtview3.setText(stringarr_item_name[3]);
    blood_item_txtview4.setText(stringarr_item_name[4]);
    blood_item_txtview5.setText(stringarr_item_name[5]);
    blood_item_txtview6.setText(stringarr_item_name[6]);
    blood_item_txtview7.setText(stringarr_item_name[7]);
    quantity_txtview.setText(stringarr_quantity[0]);
    quantity_txtview1.setText(stringarr_quantity[1]);
    quantity_txtview2.setText(stringarr_quantity[2]);
    quantity_txtview3.setText(stringarr_quantity[3]);
    quantity_txtview4.setText(stringarr_quantity[4]);
    quantity_txtview5.setText(stringarr_quantity[5]);
    quantity_txtview6.setText(stringarr_quantity[6]);
    quantity_txtview7.setText(stringarr_quantity[7]);
  }
  
  private class CallList
    extends AsyncTask<String, String, String>
  {
    List<String> blood_name_list = new ArrayList();
    private ProgressDialog dlog;
    String finalresp;
    List<String> item_name_list = new ArrayList();
    List<String> quantity_list = new ArrayList();
    
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
      BloodAvailability2.access$102(BloodAvailability2.this, paramVarArgs[0]);
      Object localObject = new SoapObject("http://orsws/", METHOD);
      ((SoapObject)localObject).addProperty(addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
      ((SoapObject)localObject).addProperty(addProperties("bloodbankid", BloodAvailability2.intent_bbid, String.class));
      ((SoapObject)localObject).addProperty(addProperties("stateid", BloodAvailability2.intent_stateid, String.class));
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
      try
      {
        paramString = new JSONObject(finalresp);
        if (METHOD.equals("getBloodstatus"))
        {
          item_name_list.clear();
          blood_name_list.clear();
          quantity_list.clear();
          if (!finalresp.contains("error"))
          {
            paramString = paramString.optJSONArray("bloodData");
            int i = 0;
            while (i < paramString.length())
            {
              JSONObject localJSONObject = paramString.getJSONObject(i);
              item_name_list.add(localJSONObject.getString("item_name"));
              blood_name_list.add(localJSONObject.getString("blood_name"));
              quantity_list.add(localJSONObject.getString("quantity"));
              i += 1;
            }
            stringarr_item_name = ((String[])item_name_list.toArray(new String[item_name_list.size()]));
            stringarr_blodd_name = ((String[])blood_name_list.toArray(new String[blood_name_list.size()]));
            stringarr_quantity = ((String[])quantity_list.toArray(new String[quantity_list.size()]));
            setListData();
            if (item_name_list.size() == 0) {
              runOnUiThread(new Runnable()
              {
                public void run()
                {
                  new Helper(getApplicationContext()).showDialogonclick(getResources().getString(2131034253));
                }
              });
            }
          }
          else
          {
            runOnUiThread(new Runnable()
            {
              public void run()
              {
                new Helper(BloodAvailability2.this).showDialogonclick(getResources().getString(2131034253));
              }
            });
            return;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(BloodAvailability2.this);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/BloodAvailability2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */