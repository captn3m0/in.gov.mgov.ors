package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class LabReprt_4_webview
  extends Activity
{
  String age;
  Button button_view_lab_reports;
  WebView data;
  String dob;
  String fathers_name;
  String gender;
  String guardian_rel;
  String hospital;
  String hospitalcode;
  String name;
  String p_address;
  String p_fname;
  String p_initial;
  String p_lname;
  String p_mname;
  String p_mobile_no;
  String p_sex;
  TextView textview__age_data;
  TextView textview_address_data;
  TextView textview_date_data;
  TextView textview_gender_data;
  TextView textview_mobile_data;
  TextView textview_name_data;
  TextView textview_test_name_data;
  TextView textview_tital_info;
  TextView textview_type_data;
  TextView textview_uhid_data;
  String uhid;
  String uhidl;
  String webdata;
  
  private void intializeView()
  {
    data = ((WebView)findViewById(2131296432));
  }
  
  private void updateview()
  {
    ((Button)findViewById(2131296410)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        onBackPressed();
      }
    });
    data.loadData(webdata, "text/html", "UTF-8");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903059);
    textview_uhid_data = ((TextView)findViewById(2131296414));
    textview_name_data = ((TextView)findViewById(2131296418));
    textview__age_data = ((TextView)findViewById(2131296419));
    textview_gender_data = ((TextView)findViewById(2131296420));
    paramBundle = getIntent();
    webdata = paramBundle.getStringExtra("webdata");
    uhidl = paramBundle.getStringExtra("uhid");
    name = paramBundle.getStringExtra("name");
    gender = paramBundle.getStringExtra("sex");
    age = paramBundle.getStringExtra("age");
    hospital = paramBundle.getStringExtra("hospital");
    textview_uhid_data.setText(uhidl);
    textview_name_data.setText(name);
    textview__age_data.setText(age);
    textview_gender_data.setText("");
    intializeView();
    updateview();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/LabReprt_4_webview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */