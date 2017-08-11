package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
    Button localButton = btn_back;
    if (paramView == localButton) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903044);
    Object localObject1 = (TextView)findViewById(2131296301);
    textview_address = ((TextView)localObject1);
    localObject1 = (TextView)findViewById(2131296303);
    textview_doctorname = ((TextView)localObject1);
    localObject1 = (TextView)findViewById(2131296305);
    textview_phonenumber = ((TextView)localObject1);
    localObject1 = (TextView)findViewById(2131296300);
    textview_bloodbank_name = ((TextView)localObject1);
    localObject1 = (TextView)findViewById(2131296299);
    textView_title_header = ((TextView)localObject1);
    Intent localIntent = getIntent();
    String str1 = localIntent.getStringExtra("bbaddress");
    String str2 = localIntent.getStringExtra("bbmoicname");
    String str3 = localIntent.getStringExtra("bblandno");
    intent_bbid = localIntent.getStringExtra("bbid");
    intent_stateid = localIntent.getStringExtra("bbstateid");
    textview_address.setText(str1);
    textview_doctorname.setText(str2);
    textview_phonenumber.setText(str3);
    localObject1 = textview_bloodbank_name;
    Object localObject2 = localIntent.getStringExtra("bbname");
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textView_title_header;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    String str4 = getResources().getString(2131034146);
    localObject2 = ((StringBuilder)localObject2).append(str4).append(" - ");
    str4 = localIntent.getStringExtra("bbstatename");
    localObject2 = str4;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = (Button)findViewById(2131296298);
    btn_back = ((Button)localObject1);
    btn_back.setOnClickListener(this);
    localObject1 = (ImageView)findViewById(2131296259);
    button_home = ((ImageView)localObject1);
    localObject1 = button_home;
    localObject2 = new in/gov/mgov/ors/BloodAvailability2$1;
    ((BloodAvailability2.1)localObject2).<init>(this);
    ((ImageView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = new in/gov/mgov/ors/BloodAvailability2$CallList;
    ((BloodAvailability2.CallList)localObject1).<init>(this, null);
    localObject2 = new String[1];
    localObject2[0] = "getBloodstatus";
    ((BloodAvailability2.CallList)localObject1).execute((Object[])localObject2);
  }
  
  public void setListData()
  {
    int i = 4;
    int j = 3;
    int k = 2;
    int m = 1;
    TextView localTextView = (TextView)findViewById(2131296309);
    blood_item_txtview = localTextView;
    localTextView = (TextView)findViewById(2131296312);
    blood_item_txtview1 = localTextView;
    localTextView = (TextView)findViewById(2131296315);
    blood_item_txtview2 = localTextView;
    localTextView = (TextView)findViewById(2131296318);
    blood_item_txtview3 = localTextView;
    localTextView = (TextView)findViewById(2131296321);
    blood_item_txtview4 = localTextView;
    localTextView = (TextView)findViewById(2131296324);
    blood_item_txtview5 = localTextView;
    localTextView = (TextView)findViewById(2131296327);
    blood_item_txtview6 = localTextView;
    localTextView = (TextView)findViewById(2131296330);
    blood_item_txtview7 = localTextView;
    localTextView = (TextView)findViewById(2131296310);
    quantity_txtview = localTextView;
    localTextView = (TextView)findViewById(2131296313);
    quantity_txtview1 = localTextView;
    localTextView = (TextView)findViewById(2131296316);
    quantity_txtview2 = localTextView;
    localTextView = (TextView)findViewById(2131296319);
    quantity_txtview3 = localTextView;
    localTextView = (TextView)findViewById(2131296322);
    quantity_txtview4 = localTextView;
    localTextView = (TextView)findViewById(2131296325);
    quantity_txtview5 = localTextView;
    localTextView = (TextView)findViewById(2131296328);
    quantity_txtview6 = localTextView;
    localTextView = (TextView)findViewById(2131296331);
    quantity_txtview7 = localTextView;
    localTextView = blood_item_txtview;
    String str = stringarr_item_name[0];
    localTextView.setText(str);
    localTextView = blood_item_txtview1;
    str = stringarr_item_name[m];
    localTextView.setText(str);
    localTextView = blood_item_txtview2;
    str = stringarr_item_name[k];
    localTextView.setText(str);
    localTextView = blood_item_txtview3;
    str = stringarr_item_name[j];
    localTextView.setText(str);
    localTextView = blood_item_txtview4;
    str = stringarr_item_name[i];
    localTextView.setText(str);
    localTextView = blood_item_txtview5;
    str = stringarr_item_name[5];
    localTextView.setText(str);
    localTextView = blood_item_txtview6;
    str = stringarr_item_name[6];
    localTextView.setText(str);
    localTextView = blood_item_txtview7;
    str = stringarr_item_name[7];
    localTextView.setText(str);
    localTextView = quantity_txtview;
    str = stringarr_quantity[0];
    localTextView.setText(str);
    localTextView = quantity_txtview1;
    str = stringarr_quantity[m];
    localTextView.setText(str);
    localTextView = quantity_txtview2;
    str = stringarr_quantity[k];
    localTextView.setText(str);
    localTextView = quantity_txtview3;
    str = stringarr_quantity[j];
    localTextView.setText(str);
    localTextView = quantity_txtview4;
    str = stringarr_quantity[i];
    localTextView.setText(str);
    localTextView = quantity_txtview5;
    str = stringarr_quantity[5];
    localTextView.setText(str);
    localTextView = quantity_txtview6;
    str = stringarr_quantity[6];
    localTextView.setText(str);
    localTextView = quantity_txtview7;
    str = stringarr_quantity[7];
    localTextView.setText(str);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BloodAvailability2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */