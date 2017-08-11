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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class MainActivity
  extends Activity
{
  public static final String NAMESPACE = "http://kycWS/";
  public static final String SOAP_ACTION_PREFIX = "http://kycWS/";
  public static final String URL = "http://orf.gov.in/aadhaarekyc/validateKYC?wsdl";
  public static final String URLNIC = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  private String METHOD = "";
  private String NAMESPACE_NIC = "http://orsws/";
  String OTP_RES = "";
  EditText aadhaar;
  EditText aadhaar_name;
  EditText aadhaar_name_number;
  EditText aadhaar_name_otp;
  String appointment_info;
  ImageView button_home;
  String check = "";
  CheckBox consent;
  String date;
  TextView datepref;
  TextView department;
  String departmentcode;
  SharedPreferences.Editor editor;
  String errCode = "";
  String[] finalArray;
  String finalresp = "";
  String hospitalcode;
  TextView hostpital_state;
  LinearLayout ll_name;
  LinearLayout ll_name_number;
  LinearLayout ll_name_otp;
  LinearLayout ll_otp;
  int maxTriesforName = 0;
  int maxTriesforOTP = 0;
  int maxTriesforresendOTP = 0;
  TextView no_aadhhar;
  EditText otp;
  SharedPreferences pref;
  Button proceed;
  Button proceed_name;
  Button proceed_name_number;
  Button proceed_name_otp;
  Button proceed_name_otp_resend;
  Button resend;
  TextView resetmobilenumber;
  TextView showmobilenumber;
  TextView showmobilenumber_demo;
  String shownumber;
  String statecode;
  Button submit;
  TextView text31a;
  boolean vaild = false;
  
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
    hostpital_state = ((TextView)findViewById(2131296260));
    department = ((TextView)findViewById(2131296261));
    showmobilenumber = ((TextView)findViewById(2131296268));
    datepref = ((TextView)findViewById(2131296262));
    showmobilenumber_demo = ((TextView)findViewById(2131296282));
    resetmobilenumber = ((TextView)findViewById(2131296289));
    text31a = ((TextView)findViewById(2131296280));
    aadhaar_name = ((EditText)findViewById(2131296277));
    aadhaar = ((EditText)findViewById(2131296266));
    otp = ((EditText)findViewById(2131296272));
    aadhaar_name_number = ((EditText)findViewById(2131296281));
    aadhaar_name_otp = ((EditText)findViewById(2131296286));
    submit = ((Button)findViewById(2131296269));
    proceed = ((Button)findViewById(2131296273));
    no_aadhhar = ((TextView)findViewById(2131296290));
    proceed_name = ((Button)findViewById(2131296278));
    resend = ((Button)findViewById(2131296274));
    proceed_name_number = ((Button)findViewById(2131296283));
    proceed_name_otp = ((Button)findViewById(2131296287));
    proceed_name_otp_resend = ((Button)findViewById(2131296288));
    consent = ((CheckBox)findViewById(2131296267));
    ll_otp = ((LinearLayout)findViewById(2131296270));
    ll_name = ((LinearLayout)findViewById(2131296275));
    ll_name_number = ((LinearLayout)findViewById(2131296279));
    ll_name_otp = ((LinearLayout)findViewById(2131296284));
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
    ((TextView)findViewById(2131296258)).setText(pref.getString("source", ""));
    shownumber = showmobilenumber.getText().toString();
    hostpital_state.setText(hostpital_state.getText() + pref.getString("hospital_name", ""));
    department.setText(department.getText() + pref.getString("dept_name", ""));
    aadhaar.setText(pref.getString("aadhaar_no", ""));
    datepref.setText("Appointment Date: " + pref.getString("date_name", ""));
    no_aadhhar.setVisibility(8);
    if (isConnected())
    {
      METHOD = "createOtpDetails";
      new AsyncTaskRunner(null).execute(new String[] { "aadhaar" });
    }
    submit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        showmobilenumber.setVisibility(8);
        no_aadhhar.setVisibility(0);
        if ((consent.isChecked()) && (isConnected()))
        {
          MainActivity.access$102(MainActivity.this, "createOtpDetails");
          new MainActivity.AsyncTaskRunner(MainActivity.this, null).execute(new String[] { "aadhaar" });
        }
      }
    });
    proceed.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (otp.getText().toString().length() == 6)
        {
          if (consent.isChecked())
          {
            MainActivity.access$102(MainActivity.this, "AuthenticateKYCUsingOTP");
            if (isConnected()) {
              new MainActivity.AsyncTaskRunner(MainActivity.this, null).execute(new String[] { "otp" });
            }
            return;
          }
          MainActivity.this.showMessage(getResources().getString(2131034287));
          return;
        }
        MainActivity.this.showMessage(getResources().getString(2131034284));
      }
    });
    no_aadhhar.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        aadhaar.setEnabled(false);
        showmobilenumber.setVisibility(0);
        showmobilenumber.setText(getResources().getString(2131034282));
        submit.setVisibility(8);
        no_aadhhar.setVisibility(8);
        ll_otp.setVisibility(8);
        ll_name.setVisibility(0);
        consent.setVisibility(8);
      }
    });
    proceed_name.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (aadhaar_name.getText().toString().length() != 0)
        {
          MainActivity.access$102(MainActivity.this, "AuthUsingName");
          if (isConnected()) {
            new MainActivity.AsyncTaskRunner(MainActivity.this, null).execute(new String[] { "AuthUsingName" });
          }
        }
      }
    });
    resend.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        showmobilenumber.setVisibility(8);
        no_aadhhar.setVisibility(0);
        if ((consent.isChecked()) && (isConnected()))
        {
          MainActivity.access$102(MainActivity.this, "createOtpDetails");
          new MainActivity.AsyncTaskRunner(MainActivity.this, null).execute(new String[] { "aadhaar", "1212" });
        }
      }
    });
    proceed_name_number.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (aadhaar_name_number.length() == 10)
        {
          MainActivity.access$102(MainActivity.this, "getRawOTP");
          if (isConnected()) {
            new MainActivity.AsyncTaskRunner(MainActivity.this, null).execute(new String[] { "getRawOTP" });
          }
          return;
        }
        MainActivity.this.showMessage(getResources().getString(2131034194));
      }
    });
    proceed_name_otp.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (aadhaar_name_otp.getText().toString().length() == 5)
        {
          if (OTP_RES.equals(aadhaar_name_otp.getText().toString()))
          {
            paramAnonymousView = new Intent(getApplicationContext(), GetUserInformation.class);
            paramAnonymousView.putExtra("from", "fromaadhaar");
            paramAnonymousView.putExtra("name", aadhaar_name.getText().toString());
            paramAnonymousView.putExtra("mono", aadhaar_name_number.getText().toString());
            startActivity(paramAnonymousView);
          }
          do
          {
            return;
            MainActivity.this.showMessage(getResources().getString(2131034339));
            paramAnonymousView = MainActivity.this;
            maxTriesforOTP += 1;
          } while (maxTriesforOTP != 2);
          maxTriesforOTP = 0;
          MainActivity.this.showMessage(getResources().getString(2131034188));
          showmobilenumber_demo.setVisibility(8);
          resetmobilenumber.setVisibility(8);
          ll_name_otp.setVisibility(8);
          aadhaar_name_number.setText("");
          aadhaar_name_number.setEnabled(true);
          proceed_name_number.setVisibility(0);
          return;
        }
        MainActivity.this.showMessage(getResources().getString(2131034195));
      }
    });
    resetmobilenumber.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        resetmobilenumber.setVisibility(8);
        ll_name_otp.setVisibility(8);
        proceed_name_number.setVisibility(0);
        aadhaar_name_number.setText("");
        aadhaar_name_number.setEnabled(true);
        text31a.setVisibility(0);
        showmobilenumber_demo.setVisibility(8);
      }
    });
    proceed_name_otp_resend.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (maxTriesforresendOTP < 4)
        {
          if (isConnected())
          {
            MainActivity.access$102(MainActivity.this, "getRawOTP");
            new MainActivity.AsyncTaskRunner(MainActivity.this, null).execute(new String[] { "getRawOTP", "resendotp" });
          }
          return;
        }
        maxTriesforresendOTP = 0;
        MainActivity.this.showDialogonclickExtra(getResources().getString(2131034204));
      }
    });
    TextWatcher local10 = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() == 5)
        {
          proceed_name_otp.setEnabled(true);
          return;
        }
        proceed_name_otp.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    aadhaar_name_otp.addTextChangedListener(local10);
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
    setContentView(2130903041);
    pref = getSharedPreferences("ors", 0);
    editor = pref.edit();
    intitalizeViews();
    updateView();
  }
  
  private class AsyncTaskRunner
    extends AsyncTask<String, String, String>
  {
    private ProgressDialog dlog;
    private String resp;
    
    private AsyncTaskRunner() {}
    
    protected String doInBackground(final String... paramVarArgs)
    {
      publishProgress(new String[] { getResources().getString(2131034226) });
      vaild = false;
      final Object localObject1;
      if (paramVarArgs[0].equals("getRawOTP")) {
        localObject1 = new SoapObject(NAMESPACE_NIC, METHOD);
      }
      for (;;)
      {
        check = paramVarArgs[0];
        if (paramVarArgs[0].equals("aadhaar"))
        {
          localObject2 = new PropertyInfo();
          ((PropertyInfo)localObject2).setName("aadhaar");
          ((PropertyInfo)localObject2).setValue(aadhaar.getText().toString());
          ((PropertyInfo)localObject2).setType(String.class);
          ((SoapObject)localObject1).addProperty((PropertyInfo)localObject2);
        }
        if (paramVarArgs[0].equals("otp"))
        {
          localObject2 = new PropertyInfo();
          ((PropertyInfo)localObject2).setName("otp");
          ((PropertyInfo)localObject2).setValue(otp.getText().toString());
          ((PropertyInfo)localObject2).setType(String.class);
          ((SoapObject)localObject1).addProperty((PropertyInfo)localObject2);
          localObject2 = new PropertyInfo();
          ((PropertyInfo)localObject2).setName("aadhaar");
          ((PropertyInfo)localObject2).setValue(aadhaar.getText().toString());
          ((PropertyInfo)localObject2).setType(String.class);
          ((SoapObject)localObject1).addProperty((PropertyInfo)localObject2);
        }
        if (paramVarArgs[0].equals("AuthUsingName"))
        {
          ((SoapObject)localObject1).addProperty(MainActivity.this.addProperties("name", aadhaar_name.getText().toString(), String.class));
          ((SoapObject)localObject1).addProperty(MainActivity.this.addProperties("aadhaar", aadhaar.getText().toString(), String.class));
        }
        if (paramVarArgs[0].equals("getRawOTP"))
        {
          ((SoapObject)localObject1).addProperty(MainActivity.this.addProperties("mobileno", aadhaar_name_number.getText().toString(), String.class));
          ((SoapObject)localObject1).addProperty(MainActivity.this.addProperties("userid", "mobileappors", String.class));
          ((SoapObject)localObject1).addProperty(MainActivity.this.addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
        }
        if (!paramVarArgs[0].equals("getRawOTP"))
        {
          localObject2 = new PropertyInfo();
          ((PropertyInfo)localObject2).setName("tokenType");
          ((PropertyInfo)localObject2).setValue("TP");
          ((PropertyInfo)localObject2).setType(String.class);
          ((SoapObject)localObject1).addProperty((PropertyInfo)localObject2);
          localObject2 = new PropertyInfo();
          ((PropertyInfo)localObject2).setName("token");
          ((PropertyInfo)localObject2).setValue("dd951891b72c317e8b94a7a6d54b57b0");
          ((PropertyInfo)localObject2).setType(String.class);
          ((SoapObject)localObject1).addProperty((PropertyInfo)localObject2);
        }
        Object localObject2 = new SoapSerializationEnvelope(110);
        ((SoapSerializationEnvelope)localObject2).setOutputSoapObject(localObject1);
        if (METHOD.equals("getRawOTP")) {
          localObject1 = new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/services?wsdl", 60000);
        }
        try
        {
          label487:
          if (paramVarArgs[0].equals("getRawOTP"))
          {
            ((HttpTransportSE)localObject1).call(NAMESPACE_NIC, (SoapEnvelope)localObject2);
            label510:
            localObject1 = (SoapPrimitive)((SoapSerializationEnvelope)localObject2).getResponse();
            finalresp = ((SoapPrimitive)localObject1).toString();
            if (((SoapPrimitive)localObject1).toString().contains("\"y\"")) {
              runOnUiThread(new Runnable()
              {
                public void run()
                {
                  if (paramVarArgs[0].equals("aadhaar"))
                  {
                    aadhaar.setEnabled(false);
                    submit.setVisibility(8);
                    ll_otp.setVisibility(0);
                  }
                  try
                  {
                    final JSONObject localJSONObject = new JSONObject(finalresp);
                    showmobilenumber.setVisibility(0);
                    showmobilenumber.setText(shownumber + localJSONObject.getString("mbl"));
                    if (paramVarArgs.length > 1) {
                      runOnUiThread(new Runnable()
                      {
                        public void run()
                        {
                          try
                          {
                            MainActivity.this.showMessage(getResources().getString(2131034263) + " " + localJSONObject.getString("mbl"));
                            return;
                          }
                          catch (JSONException localJSONException)
                          {
                            localJSONException.printStackTrace();
                          }
                        }
                      });
                    }
                    no_aadhhar.setVisibility(0);
                    return;
                  }
                  catch (JSONException localJSONException)
                  {
                    localJSONException.printStackTrace();
                  }
                }
              });
            }
            if ((paramVarArgs[0].equals("aadhaar")) && (finalresp.contains("\"ret\":\"n\""))) {
              runOnUiThread(new Runnable()
              {
                public void run()
                {
                  if ((paramVarArgs[0].equals("aadhaar")) && (finalresp.contains("\"err\":\"111\"")))
                  {
                    aadhaar.setEnabled(false);
                    showmobilenumber.setVisibility(0);
                    showmobilenumber.setText(getResources().getString(2131034232));
                    submit.setVisibility(8);
                    no_aadhhar.setVisibility(8);
                    ll_name.setVisibility(0);
                    consent.setVisibility(8);
                    return;
                  }
                  if ((paramVarArgs[0].equals("aadhaar")) && (finalresp.contains("\"err\":\"540\"")))
                  {
                    aadhaar.setEnabled(false);
                    showmobilenumber.setVisibility(0);
                    showmobilenumber.setText(getResources().getString(2131034202));
                    submit.setVisibility(8);
                    no_aadhhar.setVisibility(8);
                    consent.setVisibility(8);
                    return;
                  }
                  aadhaar.setEnabled(false);
                  showmobilenumber.setVisibility(0);
                  showmobilenumber.setText(getResources().getString(2131034202));
                  submit.setVisibility(8);
                  no_aadhhar.setVisibility(8);
                  consent.setVisibility(8);
                }
              });
            }
            if ((paramVarArgs[0].equals("AuthUsingName")) && (finalresp.contains("\"ret\":\"n\""))) {
              runOnUiThread(new Runnable()
              {
                public void run()
                {
                  MainActivity.this.showMessage(getResources().getString(2131034245));
                  aadhaar_name.setText("");
                  MainActivity localMainActivity = MainActivity.this;
                  maxTriesforName += 1;
                  if (maxTriesforName == 3)
                  {
                    maxTriesforName = 0;
                    MainActivity.this.showDialogonclickExtra(getResources().getString(2131034341));
                  }
                }
              });
            }
            if ((paramVarArgs[0].equals("AuthUsingName")) && (finalresp.contains("\"ret\":\"y\""))) {
              runOnUiThread(new Runnable()
              {
                public void run()
                {
                  aadhaar_name.setEnabled(false);
                  aadhaar_name.setHint(getResources().getString(2131034344));
                  showmobilenumber.setVisibility(8);
                  proceed_name.setVisibility(8);
                  ll_name_number.setVisibility(0);
                }
              });
            }
            if (METHOD.equals("getRawOTP"))
            {
              localObject1 = new JSONObject(finalresp);
              if (((JSONObject)localObject1).getString("status").equalsIgnoreCase("Y")) {
                runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    try
                    {
                      OTP_RES = localObject1.getString("data");
                      ll_name_otp.setVisibility(0);
                      showmobilenumber_demo.setText(getResources().getString(2131034267) + aadhaar_name_number.getText());
                      showmobilenumber_demo.setVisibility(0);
                      aadhaar_name_number.setEnabled(false);
                      text31a.setVisibility(8);
                      proceed_name_number.setVisibility(8);
                      resetmobilenumber.setVisibility(0);
                      aadhaar_name_otp.requestFocus();
                      if (paramVarArgs.length > 1)
                      {
                        if (paramVarArgs[1].equalsIgnoreCase("resendotp"))
                        {
                          MainActivity localMainActivity = MainActivity.this;
                          maxTriesforresendOTP += 1;
                          runOnUiThread(new Runnable()
                          {
                            public void run()
                            {
                              MainActivity.this.showMessage(getResources().getString(2131034263) + " " + aadhaar_name_number.getText());
                            }
                          });
                          if (maxTriesforresendOTP != 3) {
                            return;
                          }
                          return;
                        }
                        maxTriesforresendOTP = 0;
                        return;
                      }
                    }
                    catch (JSONException localJSONException)
                    {
                      localJSONException.printStackTrace();
                      return;
                    }
                    MainActivity.this.showMessage(getResources().getString(2131034266) + " " + aadhaar_name_number.getText());
                  }
                });
              }
            }
            if ((paramVarArgs[0].equals("otp")) && (finalresp.contains("ret=\"N\"")))
            {
              if (!finalresp.contains("err=\"K-100\"")) {
                break label1306;
              }
              runOnUiThread(new Runnable()
              {
                public void run()
                {
                  if (paramVarArgs[0].equals("otp")) {
                    MainActivity.this.showMessage(getResources().getString(2131034339));
                  }
                }
              });
            }
            if ((paramVarArgs[0].equals("otp")) && (finalresp.contains("ret=\"Y\"")))
            {
              vaild = true;
              paramVarArgs = new String[27];
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          try
          {
            localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            localObject2 = new InputSource();
            ((InputSource)localObject2).setCharacterStream(new StringReader(finalresp));
            localObject3 = ((DocumentBuilder)localObject1).parse((InputSource)localObject2).getDocumentElement();
            ((Element)localObject3).getAttribute(finalresp);
            localObject1 = (Element)((Element)localObject3).getElementsByTagName("Poi").item(0);
            localObject2 = (Element)((Element)localObject3).getElementsByTagName("Poa").item(0);
            localObject3 = ((Element)((Element)localObject3).getElementsByTagName("Pht").item(0)).getTextContent();
            paramVarArgs[0] = ((Element)localObject1).getAttribute("name");
            str = ((Element)localObject1).getAttribute("dob");
          }
          catch (Exception paramVarArgs)
          {
            for (;;)
            {
              Object localObject3;
              String str;
              label1051:
              label1230:
              label1306:
              runOnUiThread(new Runnable()
              {
                public void run()
                {
                  MainActivity.this.showMessage("hi");
                }
              });
            }
          }
          try
          {
            paramVarArgs[1] = (str.split("\\-")[0] + "-" + str.split("\\-")[1] + "-" + str.split("\\-")[2]);
            paramVarArgs[2] = ((Element)localObject1).getAttribute("gender");
            paramVarArgs[3] = ((Element)localObject1).getAttribute("phone");
            paramVarArgs[4] = ((Element)localObject1).getAttribute("email");
            paramVarArgs[5] = ((Element)localObject2).getAttribute("co");
            paramVarArgs[6] = ((Element)localObject2).getAttribute("street");
            paramVarArgs[7] = ((Element)localObject2).getAttribute("house");
            paramVarArgs[8] = ((Element)localObject2).getAttribute("lm");
            paramVarArgs[9] = ((Element)localObject2).getAttribute("loc");
            paramVarArgs[10] = ((Element)localObject2).getAttribute("vtc");
            paramVarArgs[11] = ((Element)localObject2).getAttribute("dist");
            paramVarArgs[12] = ((Element)localObject2).getAttribute("state");
            paramVarArgs[13] = ((Element)localObject2).getAttribute("pc");
            paramVarArgs[14] = ((Element)localObject2).getAttribute("po");
            paramVarArgs[15] = localObject3;
            finalArray = paramVarArgs;
            return resp;
            localObject1 = new SoapObject("http://kycWS/", METHOD);
            continue;
            localObject1 = new HttpTransportSE("http://orf.gov.in/aadhaarekyc/validateKYC?wsdl", 60000);
            break label487;
            ((HttpTransportSE)localObject1).call("http://kycWS/", (SoapEnvelope)localObject2);
            break label510;
            paramVarArgs = paramVarArgs;
            runOnUiThread(new Runnable()
            {
              public void run()
              {
                MainActivity.this.showMessage(getResources().getString(2131034166));
              }
            });
            paramVarArgs.printStackTrace();
            break label1230;
            runOnUiThread(new Runnable()
            {
              public void run()
              {
                if (paramVarArgs[0].equals("otp")) {
                  MainActivity.this.showMessage(getResources().getString(2131034201));
                }
              }
            });
          }
          catch (Exception localException)
          {
            paramVarArgs[1] = "10-10-2010";
            break label1051;
          }
        }
      }
    }
    
    protected void onPostExecute(String paramString)
    {
      if (dlog.isShowing()) {
        dlog.dismiss();
      }
      if ((check.equals("otp")) && (vaild))
      {
        paramString = new Intent(getApplicationContext(), ShowUIDAIData.class);
        paramString.putExtra("uid_data", finalArray);
        paramString.putExtra("aaddhaarid", aadhaar.getText().toString());
        finish();
        startActivity(paramString);
      }
    }
    
    protected void onPreExecute()
    {
      dlog = new ProgressDialog(MainActivity.this);
      dlog.setTitle(getResources().getString(2131034289));
      if (METHOD.equals("getRawOTP")) {
        dlog.setMessage(getResources().getString(2131034163));
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
        dlog.setMessage(getResources().getString(2131034165));
      }
    }
    
    protected void onProgressUpdate(String... paramVarArgs) {}
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */