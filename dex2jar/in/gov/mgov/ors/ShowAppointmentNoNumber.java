package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class ShowAppointmentNoNumber
  extends Activity
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
  private String METHOD = "";
  TextView UHID;
  TextView aadhaar;
  String aadhaarno;
  TextView address;
  String appdate;
  TextView appointment_detail;
  TextView appointmentid;
  ImageView button_home;
  TextView date;
  TextView department;
  int departmentcode;
  TextView dob;
  SharedPreferences.Editor editor;
  String finalresp;
  TextView gender;
  int hospitalcode;
  TextView hostpital_state;
  ImageView image;
  TextView mno;
  TextView name;
  TextView no;
  Button payment;
  SharedPreferences pref;
  int statecode;
  String[] uidData;
  Button yes;
  
  private boolean PayNow(String paramString)
  {
    paramString = paramString.split("\\|");
    int i = 0;
    while (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split("\\^");
      int j = 0;
      while (j < arrayOfString.length)
      {
        if (arrayOfString[j].equals(hospitalcode + "")) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  private void intitalizeViews()
  {
    name = ((TextView)findViewById(2131296449));
    dob = ((TextView)findViewById(2131296450));
    gender = ((TextView)findViewById(2131296451));
    mno = ((TextView)findViewById(2131296452));
    address = ((TextView)findViewById(2131296455));
    hostpital_state = ((TextView)findViewById(2131296260));
    department = ((TextView)findViewById(2131296261));
    aadhaar = ((TextView)findViewById(2131296448));
    date = ((TextView)findViewById(2131296262));
    appointmentid = ((TextView)findViewById(2131296453));
    appointment_detail = ((TextView)findViewById(2131296457));
    image = ((ImageView)findViewById(2131296447));
    yes = ((Button)findViewById(2131296341));
    no = ((TextView)findViewById(2131296456));
    UHID = ((TextView)findViewById(2131296454));
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
        paramAnonymousDialogInterface.cancel();
      }
    });
    localBuilder.create().show();
  }
  
  private void showMessage(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 0);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  private void updateView()
  {
    payment = ((Button)findViewById(2131296458));
    payment.setVisibility(8);
    payment.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(ShowAppointmentNoNumber.this, payment.class);
        startActivity(paramAnonymousView);
      }
    });
    if (!getResources().getString(2131034150).equals(pref.getString("source", ""))) {
      new CallListagain(null).execute(new String[] { "getHospitalListForPayment" });
    }
    Object localObject = (TextView)findViewById(2131296258);
    ((TextView)localObject).setText(pref.getString("source", ""));
    ((TextView)localObject).setText(((TextView)localObject).getText().toString().replace("Book", "Booked"));
    statecode = Integer.parseInt(pref.getString("state_code", "0"));
    departmentcode = Integer.parseInt(pref.getString("dept_code", "0"));
    hospitalcode = Integer.parseInt(pref.getString("hospital_code", "0"));
    appdate = pref.getString("date_name", "0");
    appointment_detail.setText(pref.getString("appointment_detail", ""));
    hostpital_state.setText(hostpital_state.getText() + pref.getString("hospital_name", ""));
    department.setText(department.getText() + pref.getString("dept_name", ""));
    if (!pref.getString("aadhaar_no", "").equals("")) {
      aadhaar.setText(getResources().getString(2131034114) + ": " + "XXXXXXXX" + pref.getString("aadhaar_no", "").substring(pref.getString("aadhaar_no", "").length() - 4, pref.getString("aadhaar_no", "").length()));
    }
    for (;;)
    {
      date.setText(date.getText() + pref.getString("date_name", ""));
      appointmentid.setText(appointmentid.getText() + pref.getString("appointment_id", ""));
      if (pref.getString("hid_data", "").equals("")) {
        UHID.setVisibility(8);
      }
      UHID.setText(UHID.getText() + " " + pref.getString("hid_data", ""));
      showDialogonclick(getResources().getString(2131034313));
      localObject = getIntent();
      uidData = ((Intent)localObject).getStringArrayExtra("uid_data");
      aadhaarno = ((Intent)localObject).getStringExtra("aaddhaarid");
      name.setText(getResources().getString(2131034243) + " " + uidData[0]);
      dob.setText(getResources().getString(2131034180) + ": " + uidData[1]);
      gender.setText(getResources().getString(2131034211) + ": " + uidData[2]);
      mno.setText(getResources().getString(2131034230) + ": " + uidData[3]);
      localObject = uidData[5];
      address.setText((CharSequence)localObject);
      image.setVisibility(8);
      yes.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent(getApplicationContext(), ServiceSelection.class);
          paramAnonymousView.addFlags(268468224);
          startActivity(paramAnonymousView);
        }
      });
      no.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent(getApplicationContext(), MainActivity.class);
          finish();
          startActivity(paramAnonymousView);
        }
      });
      return;
      aadhaar.setVisibility(8);
    }
  }
  
  public void onBackPressed()
  {
    Intent localIntent = new Intent(getApplicationContext(), ServiceSelection.class);
    localIntent.addFlags(268468224);
    startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903064);
    pref = getSharedPreferences("ors", 0);
    editor = pref.edit();
    editor.putString("paymentstatus", "").commit();
    intitalizeViews();
    updateView();
  }
  
  public String screenShot(View paramView)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    paramView = new ByteArrayOutputStream();
    localBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramView);
    return Base64.encodeToString(paramView.toByteArray(), 0);
  }
  
  private class CallListagain
    extends AsyncTask<String, String, String>
  {
    private ProgressDialog dlog;
    
    private CallListagain() {}
    
    protected String doInBackground(String... paramVarArgs)
    {
      ShowAppointmentNoNumber.access$102(ShowAppointmentNoNumber.this, paramVarArgs[0]);
      paramVarArgs = new SoapObject("http://orsws/", METHOD);
      if (METHOD.equals("getHospitalListForPayment"))
      {
        localObject = new PropertyInfo();
        ((PropertyInfo)localObject).setName("intoken");
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
      if ((METHOD.equals("getHospitalListForPayment")) && (finalresp.equals("{}"))) {}
      try
      {
        if (ShowAppointmentNoNumber.this.PayNow(finalresp)) {
          payment.setVisibility(0);
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      dlog = new ProgressDialog(ShowAppointmentNoNumber.this);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/ShowAppointmentNoNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */