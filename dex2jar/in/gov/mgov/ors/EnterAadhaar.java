package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.TextView;
import android.widget.Toast;
import com.aadhaar.auth.Verhoeff;

public class EnterAadhaar
  extends Activity
{
  EditText aadhaar;
  ImageView button_home;
  CheckBox consent;
  TextView date;
  TextView department;
  SharedPreferences.Editor editor;
  TextView hostpital_state;
  SharedPreferences pref;
  int sdk;
  Button submit;
  
  private boolean checkaadahar(String paramString)
  {
    return Verhoeff.validateVerhoeff(paramString);
  }
  
  private void initializeViews()
  {
    button_home = ((ImageView)findViewById(2131296259));
    hostpital_state = ((TextView)findViewById(2131296260));
    department = ((TextView)findViewById(2131296261));
    date = ((TextView)findViewById(2131296262));
    submit = ((Button)findViewById(2131296269));
    consent = ((CheckBox)findViewById(2131296267));
    aadhaar = ((EditText)findViewById(2131296266));
  }
  
  private void showMessage(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 0);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  private void updateView()
  {
    sdk = Build.VERSION.SDK_INT;
    ((TextView)findViewById(2131296258)).setText(pref.getString("source", ""));
    hostpital_state.setText(hostpital_state.getText() + pref.getString("hospital_name", ""));
    department.setText(department.getText() + pref.getString("dept_name", ""));
    date.setText("Appointment Date: " + pref.getString("date_name", ""));
    TextWatcher local1 = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() == 12)
        {
          if (EnterAadhaar.this.checkaadahar(paramAnonymousEditable.toString()))
          {
            submit.setEnabled(true);
            if (sdk > 16)
            {
              submit.setBackground(getResources().getDrawable(2130837536));
              return;
            }
            submit.setBackgroundDrawable(getResources().getDrawable(2130837536));
            return;
          }
          EnterAadhaar.this.showMessage(getResources().getString(2131034338));
          return;
        }
        submit.setEnabled(false);
        if (sdk > 16)
        {
          submit.setBackground(getResources().getDrawable(2130837541));
          return;
        }
        submit.setBackgroundDrawable(getResources().getDrawable(2130837541));
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    aadhaar.addTextChangedListener(local1);
    submit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (isConnected())
        {
          if (consent.isChecked())
          {
            editor.putString("aadhaar_no", aadhaar.getText().toString()).commit();
            paramAnonymousView = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(paramAnonymousView);
          }
        }
        else {
          return;
        }
        EnterAadhaar.this.showMessage(getResources().getString(2131034287));
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
    setContentView(2130903052);
    pref = getSharedPreferences("ors", 0);
    editor = pref.edit();
    initializeViews();
    updateView();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/EnterAadhaar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */