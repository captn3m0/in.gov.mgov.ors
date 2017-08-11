package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import nitesh.floatinghint.FloatingHintEditText;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class CancelAppointment3
  extends Activity
  implements View.OnClickListener
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  private String METHOD = "";
  String OTP = "";
  Button btn_backtoappointmnet;
  Button btn_cancel;
  ImageView button_home;
  TextView dr;
  String hospitalcode;
  ImageView img_id;
  int maxTriesforOTP = 0;
  String resAadhaar;
  String resAppdates;
  String resAppointment_id;
  String resApptime;
  String resDOB;
  String resDept;
  String resDoctor;
  String resEmail;
  String resGender;
  String resHospitals;
  String resMobileNo;
  String resP_address;
  String resPatientname;
  String resRequestDate;
  String resRoom_name;
  String resStatus;
  String resfathers_name;
  String reshid;
  TextView txt_aadhaar;
  TextView txt_age;
  TextView txt_appdate;
  TextView txt_appid;
  TextView txt_dept;
  TextView txt_grnder;
  TextView txt_hospital;
  TextView txt_mobileno;
  TextView txt_name;
  TextView txt_room_no;
  TextView txt_uhid;
  
  private void intializeView()
  {
    button_home = ((ImageView)findViewById(2131296259));
    txt_aadhaar = ((TextView)findViewById(2131296361));
    txt_name = ((TextView)findViewById(2131296362));
    txt_age = ((TextView)findViewById(2131296363));
    txt_grnder = ((TextView)findViewById(2131296364));
    txt_mobileno = ((TextView)findViewById(2131296365));
    txt_hospital = ((TextView)findViewById(2131296366));
    txt_dept = ((TextView)findViewById(2131296368));
    txt_appid = ((TextView)findViewById(2131296370));
    txt_appdate = ((TextView)findViewById(2131296372));
    txt_uhid = ((TextView)findViewById(2131296374));
    dr = ((TextView)findViewById(2131296378));
    btn_cancel = ((Button)findViewById(2131296340));
    txt_room_no = ((TextView)findViewById(2131296376));
    btn_backtoappointmnet = ((Button)findViewById(2131296379));
    img_id = ((ImageView)findViewById(2131296302));
  }
  
  private void showDialogonclickExtra(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getResources().getString(2131034183));
    localBuilder.setMessage(paramString).setCancelable(false).setPositiveButton(getResources().getString(2131034259), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent(getApplicationContext(), ServiceSelection.class);
        paramAnonymousDialogInterface.addFlags(268468224);
        startActivity(paramAnonymousDialogInterface);
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
    if (isConnected()) {
      new CallList(null).execute(new String[] { "getAadhaarIamge" });
    }
    img_id.setVisibility(8);
    txt_name.setText(resPatientname);
    txt_age.setText(resDOB + " years");
    txt_grnder.setText(resGender);
    txt_mobileno.setText(getResources().getString(2131034234) + ": XXXXXX" + resMobileNo.substring(resMobileNo.length() - 4, resMobileNo.length()));
    txt_hospital.setText(resHospitals);
    txt_dept.setText(resDept);
    txt_appdate.setText(resAppdates);
    txt_appid.setText(resAppointment_id);
    txt_aadhaar.setText(getResources().getString(2131034114) + ": " + resAadhaar);
    txt_uhid.setText(reshid);
    dr.setText(resDoctor);
    dr.setVisibility(8);
    txt_room_no.setText(resRoom_name);
    txt_room_no.setVisibility(8);
    btn_cancel.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (isConnected()) {
          new CancelAppointment3.CallList(CancelAppointment3.this, null).execute(new String[] { "getRawOTP" });
        }
      }
    });
    btn_backtoappointmnet.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        finish();
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
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == btn_cancel) {
      new AlertDialog.Builder(this).setTitle(getResources().getString(2131034157)).setMessage(getResources().getString(2131034138)).setPositiveButton(getResources().getString(2131034259), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new Intent(getApplicationContext(), CancelAppointment2.class);
          startActivity(paramAnonymousDialogInterface);
          finish();
        }
      }).setNegativeButton(getResources().getString(2131034156), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }).setIcon(17301543).show();
    }
    if (paramView == btn_backtoappointmnet)
    {
      startActivity(new Intent(getApplicationContext(), CancelAppointment2.class));
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903048);
    paramBundle = getIntent();
    resHospitals = paramBundle.getStringExtra("hospitals");
    resDept = paramBundle.getStringExtra("depts");
    resAppdates = paramBundle.getStringExtra("appdates");
    resStatus = paramBundle.getStringExtra("status");
    resPatientname = paramBundle.getStringExtra("patient_name");
    resfathers_name = paramBundle.getStringExtra("fathers_name");
    resEmail = paramBundle.getStringExtra("email");
    resRoom_name = paramBundle.getStringExtra("room_name");
    resDOB = paramBundle.getStringExtra("dob");
    resGender = paramBundle.getStringExtra("gender");
    resP_address = paramBundle.getStringExtra("p_address");
    resAppointment_id = paramBundle.getStringExtra("appointment_id");
    resMobileNo = paramBundle.getStringExtra("mobile_no");
    hospitalcode = paramBundle.getStringExtra("hosid");
    resDoctor = paramBundle.getStringExtra("doctor");
    resAadhaar = paramBundle.getStringExtra("aadhaar");
    reshid = paramBundle.getStringExtra("hid");
    resRequestDate = paramBundle.getStringExtra("requestdate");
    resApptime = paramBundle.getStringExtra("apptime");
    hospitalcode = paramBundle.getStringExtra("hosid");
    intializeView();
    updateView();
  }
  
  private class CallList
    extends AsyncTask<String, String, String>
  {
    private ProgressDialog dlog;
    String finalresp;
    
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
      CancelAppointment3.access$102(CancelAppointment3.this, paramVarArgs[0]);
      Object localObject = new SoapObject("http://orsws/", METHOD);
      if (paramVarArgs[0].equals("getRawOTP"))
      {
        ((SoapObject)localObject).addProperty(addProperties("mobileno", resMobileNo, String.class));
        ((SoapObject)localObject).addProperty(addProperties("userid", "mobileappors", String.class));
        ((SoapObject)localObject).addProperty(addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
      }
      if (paramVarArgs[0].equals("getAadhaarIamge"))
      {
        ((SoapObject)localObject).addProperty(addProperties("in_token", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
        ((SoapObject)localObject).addProperty(addProperties("aadhaar", resAadhaar, String.class));
      }
      paramVarArgs = new SoapSerializationEnvelope(110);
      paramVarArgs.setOutputSoapObject(localObject);
      localObject = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/services?wsdl", 60000);
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
              CancelAppointment3.this.showMessage(getResources().getString(2131034251));
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
      try
      {
        paramString = new JSONObject(paramString);
        if (METHOD.equalsIgnoreCase("getRawOTP"))
        {
          OTP = paramString.getString("data");
          final Object localObject = new AlertDialog.Builder(CancelAppointment3.this);
          ((AlertDialog.Builder)localObject).setTitle(getResources().getString(2131034183));
          ((AlertDialog.Builder)localObject).setMessage(getResources().getString(2131034264) + ": XXXXXX" + resMobileNo.substring(resMobileNo.length() - 4, resMobileNo.length()));
          final FloatingHintEditText localFloatingHintEditText = new FloatingHintEditText(CancelAppointment3.this);
          localFloatingHintEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(5) });
          localFloatingHintEditText.setHint(getResources().getString(2131034190));
          localFloatingHintEditText.setInputType(2);
          ((AlertDialog.Builder)localObject).setView(localFloatingHintEditText);
          ((AlertDialog.Builder)localObject).setPositiveButton(getResources().getString(2131034259), null);
          ((AlertDialog.Builder)localObject).setNegativeButton(getResources().getString(2131034156), null);
          ((AlertDialog.Builder)localObject).setNeutralButton(getResources().getString(2131034293), null);
          localObject = ((AlertDialog.Builder)localObject).create();
          ((AlertDialog)localObject).setOnShowListener(new DialogInterface.OnShowListener()
          {
            public void onShow(DialogInterface paramAnonymousDialogInterface)
            {
              paramAnonymousDialogInterface = localObject.getButton(-1);
              Button localButton1 = localObject.getButton(-2);
              Button localButton2 = localObject.getButton(-3);
              paramAnonymousDialogInterface.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymous2View)
                {
                  if (val$input.getText().toString().equals(OTP))
                  {
                    if (isConnected()) {
                      CancelAppointment3.access$102(CancelAppointment3.this, "cancelAppointment");
                    }
                    new CancelAppointment3.CallListSecond(CancelAppointment3.this, null).execute(new String[] { "cancelAppointment" });
                    return;
                  }
                  CancelAppointment3.this.showMessage(getResources().getString(2131034339));
                }
              });
              localButton1.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymous2View)
                {
                  val$d.cancel();
                }
              });
              localButton2.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymous2View)
                {
                  if (maxTriesforOTP < 3)
                  {
                    if (isConnected()) {
                      new CancelAppointment3.CallListSecond(CancelAppointment3.this, null).execute(new String[] { "getRawOTP", "resend" });
                    }
                    return;
                  }
                  CancelAppointment3.this.showDialogonclickExtra(getResources().getString(2131034204));
                }
              });
            }
          });
          ((AlertDialog)localObject).show();
        }
        if ((METHOD.equals("getAadhaarIamge")) && (paramString.getString("imageFOUND").equalsIgnoreCase("y")))
        {
          paramString = Base64.decode(paramString.getString("image"), 0);
          paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
          img_id.setImageBitmap(paramString);
          img_id.setVisibility(0);
        }
        return;
      }
      catch (Exception paramString) {}
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(CancelAppointment3.this);
      dlog.setTitle(getResources().getString(2131034289));
      if (METHOD.equalsIgnoreCase("getRawOTP")) {
        dlog.setMessage(getResources().getString(2131034164));
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          dlog.setProgressStyle(1);
          dlog.setIndeterminate(true);
          dlog.setProgressNumberFormat(null);
          dlog.setProgressPercentFormat(null);
        }
        dlog.setCancelable(false);
        dlog.show();
        return;
        dlog.setMessage(getResources().getString(2131034206));
      }
    }
  }
  
  private class CallListSecond
    extends AsyncTask<String, String, String>
  {
    private ProgressDialog dlog;
    String finalresp;
    
    private CallListSecond() {}
    
    private PropertyInfo addProperties(String paramString, Integer paramInteger, Object paramObject)
    {
      PropertyInfo localPropertyInfo = new PropertyInfo();
      localPropertyInfo.setName(paramString);
      localPropertyInfo.setValue(paramInteger);
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
    
    protected String doInBackground(String... paramVarArgs)
    {
      CancelAppointment3.access$102(CancelAppointment3.this, paramVarArgs[0]);
      Object localObject = new SoapObject("http://orsws/", METHOD);
      if (paramVarArgs[0].equals("cancelAppointment"))
      {
        ((SoapObject)localObject).addProperty(addProperties("in_token", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
        ((SoapObject)localObject).addProperty(addProperties("uid", Integer.valueOf(99999), Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("app_no", resAppointment_id, String.class));
        ((SoapObject)localObject).addProperty(addProperties("hos_id", hospitalcode, Integer.class));
        ((SoapObject)localObject).addProperty(addProperties("entry_system", "0.0.0.0", String.class));
        ((SoapObject)localObject).addProperty(addProperties("app_date", resAppdates, String.class));
        ((SoapObject)localObject).addProperty(addProperties("isOnline", Integer.valueOf(0), Integer.class));
      }
      if (paramVarArgs[0].equals("getRawOTP"))
      {
        ((SoapObject)localObject).addProperty(addProperties("mobileno", resMobileNo, String.class));
        ((SoapObject)localObject).addProperty(addProperties("userid", "mobileappors", String.class));
        ((SoapObject)localObject).addProperty(addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
      }
      paramVarArgs = new SoapSerializationEnvelope(110);
      paramVarArgs.setOutputSoapObject(localObject);
      localObject = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/services?wsdl", 60000);
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
              CancelAppointment3.this.showMessage(getResources().getString(2131034292));
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
      try
      {
        paramString = new JSONObject(paramString);
        if (METHOD.equalsIgnoreCase("getRawOTP"))
        {
          OTP = paramString.getString("data");
          CancelAppointment3.this.showMessage(getResources().getString(2131034262));
          CancelAppointment3 localCancelAppointment3 = CancelAppointment3.this;
          maxTriesforOTP += 1;
        }
        if (METHOD.equals("cancelAppointment"))
        {
          paramString = paramString.getString("response");
          CancelAppointment3.this.showDialogonclickExtra(paramString);
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(CancelAppointment3.this);
      dlog.setTitle(getResources().getString(2131034289));
      if (METHOD.equalsIgnoreCase("getRawOTP")) {
        dlog.setMessage(getResources().getString(2131034164));
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          dlog.setProgressStyle(1);
          dlog.setIndeterminate(true);
          dlog.setProgressNumberFormat(null);
          dlog.setProgressPercentFormat(null);
        }
        dlog.setCancelable(false);
        dlog.show();
        return;
        dlog.setMessage(getResources().getString(2131034206));
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/CancelAppointment3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */