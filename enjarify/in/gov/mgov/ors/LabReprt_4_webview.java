package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
    WebView localWebView = (WebView)findViewById(2131296432);
    data = localWebView;
  }
  
  private void updateview()
  {
    Button localButton = (Button)findViewById(2131296410);
    Object localObject = new in/gov/mgov/ors/LabReprt_4_webview$1;
    ((LabReprt_4_webview.1)localObject).<init>(this);
    localButton.setOnClickListener((View.OnClickListener)localObject);
    localObject = data;
    String str = webdata;
    ((WebView)localObject).loadData(str, "text/html", "UTF-8");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903059);
    Object localObject = (TextView)findViewById(2131296414);
    textview_uhid_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296418);
    textview_name_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296419);
    textview__age_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296420);
    textview_gender_data = ((TextView)localObject);
    Intent localIntent = getIntent();
    localObject = localIntent.getStringExtra("webdata");
    webdata = ((String)localObject);
    localObject = localIntent.getStringExtra("uhid");
    uhidl = ((String)localObject);
    localObject = localIntent.getStringExtra("name");
    name = ((String)localObject);
    localObject = localIntent.getStringExtra("sex");
    gender = ((String)localObject);
    localObject = localIntent.getStringExtra("age");
    age = ((String)localObject);
    localObject = localIntent.getStringExtra("hospital");
    hospital = ((String)localObject);
    localObject = textview_uhid_data;
    String str = uhidl;
    ((TextView)localObject).setText(str);
    localObject = textview_name_data;
    str = name;
    ((TextView)localObject).setText(str);
    localObject = textview__age_data;
    str = age;
    ((TextView)localObject).setText(str);
    textview_gender_data.setText("");
    intializeView();
    updateview();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReprt_4_webview.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */