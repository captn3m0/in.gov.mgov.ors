package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
  String[] stringarray_bbname;
  String[] stringarray_bbstateid;
  String[] stringarray_bbstatename;
  TextView textview_bloodbanktitle;
  TextView title;
  
  public BloodAvailability1()
  {
    String[] arrayOfString = new String[0];
    stringarray_bbname = arrayOfString;
  }
  
  private void popultelist()
  {
    Object localObject1 = new in/gov/mgov/ors/BloodAvailability1$CallList;
    ((BloodAvailability1.CallList)localObject1).<init>(this, null);
    Object localObject2 = new String[1];
    localObject2[0] = "getBloodBanklistforastate";
    ((BloodAvailability1.CallList)localObject1).execute((Object[])localObject2);
    localObject1 = listview_hospital;
    localObject2 = new in/gov/mgov/ors/BloodAvailability1$3;
    ((BloodAvailability1.3)localObject2).<init>(this);
    ((ListView)localObject1).setOnItemClickListener((AdapterView.OnItemClickListener)localObject2);
  }
  
  private void showMessage(String paramString)
  {
    Toast localToast = Toast.makeText(getApplicationContext(), paramString, 1);
    localToast.setGravity(17, 0, 0);
    localToast.show();
  }
  
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
    setContentView(2130903043);
    Object localObject1 = (Spinner)findViewById(2131296295);
    spinner_selectState = ((Spinner)localObject1);
    localObject1 = (ListView)findViewById(2131296297);
    listview_hospital = ((ListView)localObject1);
    localObject1 = (TextView)findViewById(2131296293);
    title = ((TextView)localObject1);
    localObject1 = (Button)findViewById(2131296298);
    btn_back = ((Button)localObject1);
    btn_back.setOnClickListener(this);
    localObject1 = (TextView)findViewById(2131296296);
    textview_bloodbanktitle = ((TextView)localObject1);
    localObject1 = (LinearLayout)findViewById(2131296294);
    selectstate_linearlayout = ((LinearLayout)localObject1);
    localObject1 = (ImageView)findViewById(2131296259);
    button_home = ((ImageView)localObject1);
    localObject1 = new in/gov/mgov/ors/BloodAvailability1$CallList;
    ((BloodAvailability1.CallList)localObject1).<init>(this, null);
    Object localObject2 = new String[1];
    localObject2[0] = "getBBStatelist";
    ((BloodAvailability1.CallList)localObject1).execute((Object[])localObject2);
    localObject1 = button_home;
    localObject2 = new in/gov/mgov/ors/BloodAvailability1$1;
    ((BloodAvailability1.1)localObject2).<init>(this);
    ((ImageView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    localObject1 = spinner_selectState;
    localObject2 = new in/gov/mgov/ors/BloodAvailability1$2;
    ((BloodAvailability1.2)localObject2).<init>(this);
    ((Spinner)localObject1).setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject2);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BloodAvailability1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */