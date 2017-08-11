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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class AuthenticateNonAadhaar
  extends Activity
{
  private static final String NAMESPACE_NIC = "http://orsws/";
  private static final String URLNIC = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  private String METHOD = "";
  String OTP_RES;
  SharedPreferences.Editor editor;
  String finalresp;
  Button getotp;
  LinearLayout ll_otp;
  int maxtriesforresendotp = 0;
  EditText number;
  EditText otp;
  SharedPreferences pref;
  Button resendotp;
  TextView resetnumber;
  TextView showNumber;
  Button submit;
  
  private PropertyInfo addProperties(String paramString1, String paramString2, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new PropertyInfo();
    localPropertyInfo.setName(paramString1);
    localPropertyInfo.setValue(paramString2);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  private void intializeViews()
  {
    number = ((EditText)findViewById(2131296281));
    otp = ((EditText)findViewById(2131296286));
    getotp = ((Button)findViewById(2131296283));
    submit = ((Button)findViewById(2131296287));
    resendotp = ((Button)findViewById(2131296288));
    ll_otp = ((LinearLayout)findViewById(2131296284));
    resetnumber = ((TextView)findViewById(2131296289));
    showNumber = ((TextView)findViewById(2131296268));
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
    getotp.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (isConnected())
        {
          if (number.length() == 10)
          {
            AuthenticateNonAadhaar.access$002(AuthenticateNonAadhaar.this, "getRawOTP");
            new AuthenticateNonAadhaar.AsyncTaskRunner(AuthenticateNonAadhaar.this, null).execute(new String[] { "getRawOTP" });
          }
        }
        else {
          return;
        }
        AuthenticateNonAadhaar.this.showMessage(getResources().getString(2131034196));
      }
    });
    submit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (otp.getText().toString().equals(OTP_RES))
        {
          paramAnonymousView = new Intent(getApplicationContext(), GetUserInformationNonAadhaar.class);
          paramAnonymousView.putExtra("from", "noaadhaar");
          paramAnonymousView.putExtra("mono", number.getText().toString());
          startActivity(paramAnonymousView);
          return;
        }
        AuthenticateNonAadhaar.this.showDialogonclick(getResources().getString(2131034339));
      }
    });
    resendotp.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (isConnected())
        {
          if (maxtriesforresendotp != 3)
          {
            AuthenticateNonAadhaar.access$002(AuthenticateNonAadhaar.this, "getRawOTP");
            new AuthenticateNonAadhaar.AsyncTaskRunner(AuthenticateNonAadhaar.this, null).execute(new String[] { "getRawOTP", "resendOTP" });
          }
        }
        else {
          return;
        }
        maxtriesforresendotp = 0;
        AuthenticateNonAadhaar.this.showDialogonclickExtra(getResources().getString(2131034204));
      }
    });
    resetnumber.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        getotp.setVisibility(0);
        number.setEnabled(true);
        ll_otp.setVisibility(8);
        showNumber.setVisibility(8);
        resetnumber.setVisibility(8);
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
    setContentView(2130903042);
    pref = getSharedPreferences("ors", 0);
    editor = pref.edit();
    intializeViews();
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
      publishProgress(new String[] { "Loading contents..." });
      final Object localObject = new SoapObject("http://orsws/", METHOD);
      ((SoapObject)localObject).addProperty(AuthenticateNonAadhaar.this.addProperties("mobileno", number.getText().toString(), String.class));
      ((SoapObject)localObject).addProperty(AuthenticateNonAadhaar.this.addProperties("userid", "mobileappors", String.class));
      ((SoapObject)localObject).addProperty(AuthenticateNonAadhaar.this.addProperties("intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class));
      try
      {
        SoapSerializationEnvelope localSoapSerializationEnvelope = new SoapSerializationEnvelope(110);
        localSoapSerializationEnvelope.setOutputSoapObject(localObject);
        new HttpTransportSE("http://ors.gov.in/ORSServicecontainer/services?wsdl", 60000).call("http://orsws/", localSoapSerializationEnvelope);
        localObject = (SoapPrimitive)localSoapSerializationEnvelope.getResponse();
        finalresp = ((SoapPrimitive)localObject).toString();
        if (METHOD.equals("getRawOTP"))
        {
          localObject = new JSONObject(finalresp);
          if (!((JSONObject)localObject).getString("status").equalsIgnoreCase("Y")) {
            break label212;
          }
          runOnUiThread(new Runnable()
          {
            public void run()
            {
              try
              {
                OTP_RES = localObject.getString("data");
                getotp.setVisibility(8);
                number.setEnabled(false);
                showNumber.setVisibility(0);
                showNumber.setText(getResources().getString(2131034264) + " \n" + number.getText());
                resetnumber.setVisibility(0);
                ll_otp.setVisibility(0);
                if (paramVarArgs.length > 1)
                {
                  AuthenticateNonAadhaar localAuthenticateNonAadhaar = AuthenticateNonAadhaar.this;
                  maxtriesforresendotp += 1;
                  runOnUiThread(new Runnable()
                  {
                    public void run()
                    {
                      AuthenticateNonAadhaar.this.showMessage(getResources().getString(2131034263) + " " + number.getText());
                    }
                  });
                }
                return;
              }
              catch (JSONException localJSONException)
              {
                runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    AuthenticateNonAadhaar.this.showDialogonclick(getResources().getString(2131034159));
                  }
                });
              }
            }
          });
        }
        for (;;)
        {
          return resp;
          label212:
          runOnUiThread(new Runnable()
          {
            public void run()
            {
              try
              {
                AuthenticateNonAadhaar.this.showDialogonclick(localObject.getString("data"));
                return;
              }
              catch (JSONException localJSONException)
              {
                AuthenticateNonAadhaar.this.showDialogonclick(getResources().getString(2131034167));
              }
            }
          });
        }
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          runOnUiThread(new Runnable()
          {
            public void run()
            {
              AuthenticateNonAadhaar.this.showDialogonclick(getResources().getString(2131034166));
            }
          });
        }
      }
    }
    
    protected void onPostExecute(String paramString)
    {
      if (dlog.isShowing()) {
        dlog.dismiss();
      }
    }
    
    protected void onPreExecute()
    {
      dlog = new ProgressDialog(AuthenticateNonAadhaar.this);
      dlog.setTitle(getResources().getString(2131034289));
      dlog.setMessage(getResources().getString(2131034163));
      if (Build.VERSION.SDK_INT >= 11)
      {
        Log.d("Ver", Build.VERSION.SDK_INT + "");
        dlog.setProgressStyle(1);
        dlog.setIndeterminate(true);
        dlog.setProgressNumberFormat(null);
        dlog.setProgressPercentFormat(null);
      }
      dlog.setCancelable(false);
      dlog.show();
    }
    
    protected void onProgressUpdate(String... paramVarArgs) {}
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/AuthenticateNonAadhaar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */