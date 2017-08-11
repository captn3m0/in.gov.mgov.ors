package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import org.ksoap2.serialization.PropertyInfo;

public class LabReport_3
  extends Activity
{
  public static final String NAMESPACE = "http://orsws/";
  public static final String SOAP_ACTION_PREFIX = "http://orsws/";
  public static final String URL = "http://ors.gov.in/ORSServicecontainer/labservices?wsdl";
  public ArrayList CustomListViewValuesArr;
  public LabReport_3 LabReportListView = null;
  private String METHOD;
  String[] Res_Collecteddate;
  String[] Res_daily_sampleno_str;
  String[] Res_report_id;
  String[] Res_report_year;
  String[] Res_sample_no;
  String[] Res_sample_type_desc;
  String[] Res_sample_year;
  String[] Res_test_name;
  LabreportAdapter adapter;
  String dob;
  String fathers_name;
  String guardian_rel;
  String hospital;
  String hospitalcode;
  ListView listview_report;
  String p_address;
  String p_fname;
  String p_initial;
  String p_lname;
  String p_mname;
  String p_mobile_no;
  String p_sex;
  int pos;
  TextView textview__age_data;
  TextView textview_gender_data;
  TextView textview_name_data;
  TextView textview_uhid_data;
  String uhid;
  
  public LabReport_3()
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    CustomListViewValuesArr = localArrayList;
    pos = 0;
    METHOD = "";
  }
  
  private PropertyInfo addProperties(String paramString, int paramInt, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    localPropertyInfo.setName(paramString);
    Integer localInteger = Integer.valueOf(paramInt);
    localPropertyInfo.setValue(localInteger);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  private PropertyInfo addProperties(String paramString1, String paramString2, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    localPropertyInfo.setName(paramString1);
    localPropertyInfo.setValue(paramString2);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  private void intializeViews()
  {
    Object localObject = (TextView)findViewById(2131296414);
    textview_uhid_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296418);
    textview_name_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296419);
    textview__age_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296420);
    textview_gender_data = ((TextView)localObject);
    localObject = (ListView)findViewById(2131296421);
    listview_report = ((ListView)localObject);
  }
  
  private void setListData()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = Res_sample_type_desc;
      int j = localObject.length;
      if (i >= j) {
        break;
      }
      LabReportRowModel localLabReportRowModel = new in/gov/mgov/ors/LabReportRowModel;
      localLabReportRowModel.<init>();
      localObject = Res_Collecteddate[i];
      localLabReportRowModel.setdate((String)localObject);
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      String str1 = Res_daily_sampleno_str[i].substring(0, 4);
      localObject = ((StringBuilder)localObject).append(str1).append("....");
      str1 = Res_daily_sampleno_str[i];
      String str2 = Res_daily_sampleno_str[i];
      int k = str2.length() + -3;
      String str3 = Res_daily_sampleno_str[i];
      int m = str3.length();
      str1 = str1.substring(k, m);
      localObject = str1;
      localLabReportRowModel.setsample_no((String)localObject);
      localObject = Res_test_name[i];
      localLabReportRowModel.settest((String)localObject);
      localObject = Res_sample_type_desc[i];
      localLabReportRowModel.settype((String)localObject);
      localObject = CustomListViewValuesArr;
      ((ArrayList)localObject).add(localLabReportRowModel);
      i += 1;
    }
  }
  
  private void showDialogonclickExtra(String paramString)
  {
    AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
    localBuilder.<init>(this);
    Object localObject = getResources().getString(2131034183);
    localBuilder.setTitle((CharSequence)localObject);
    localObject = localBuilder.setMessage(paramString).setCancelable(false);
    String str = getResources().getString(2131034259);
    LabReport_3.3 local3 = new in/gov/mgov/ors/LabReport_3$3;
    local3.<init>(this);
    ((AlertDialog.Builder)localObject).setPositiveButton(str, local3);
    localBuilder.create().show();
  }
  
  private void showMessage(String paramString)
  {
    Toast localToast = Toast.makeText(getApplicationContext(), paramString, 1);
    localToast.setGravity(17, 0, 0);
    localToast.show();
  }
  
  private void updateView()
  {
    Button localButton = (Button)findViewById(2131296410);
    Object localObject1 = new in/gov/mgov/ors/LabReport_3$1;
    ((LabReport_3.1)localObject1).<init>(this);
    localButton.setOnClickListener((View.OnClickListener)localObject1);
    ImageView localImageView = (ImageView)findViewById(2131296259);
    localObject1 = new in/gov/mgov/ors/LabReport_3$2;
    ((LabReport_3.2)localObject1).<init>(this);
    localImageView.setOnClickListener((View.OnClickListener)localObject1);
    localObject1 = textview_gender_data;
    Object localObject2 = p_sex;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    textview_gender_data.setVisibility(8);
    localObject1 = textview__age_data;
    localObject2 = dob;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_name_data;
    localObject2 = p_mname;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_uhid_data;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    Object localObject3 = uhid;
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append("  ");
    localObject3 = getResources().getString(2131034215);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
    localObject3 = hospital;
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    LabReportListView = this;
    setListData();
    Resources localResources = getResources();
    localObject1 = new in/gov/mgov/ors/LabreportAdapter;
    localObject2 = LabReportListView;
    localObject3 = CustomListViewValuesArr;
    ((LabreportAdapter)localObject1).<init>((Activity)localObject2, (ArrayList)localObject3, localResources);
    adapter = ((LabreportAdapter)localObject1);
    localObject1 = listview_report;
    localObject2 = adapter;
    ((ListView)localObject1).setAdapter((ListAdapter)localObject2);
  }
  
  public boolean isConnected()
  {
    Object localObject = getApplicationContext();
    String str = "connectivity";
    ConnectivityManager localConnectivityManager = (ConnectivityManager)((Context)localObject).getSystemService(str);
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    boolean bool;
    if (localNetworkInfo != null)
    {
      bool = localNetworkInfo.isConnected();
      if (bool) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      localObject = getResources();
      int i = 2131034274;
      localObject = ((Resources)localObject).getString(i);
      showMessage((String)localObject);
      bool = false;
      localObject = null;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903055);
    Intent localIntent = getIntent();
    Object localObject = localIntent.getStringArrayExtra("Res_sample_type_desc");
    Res_sample_type_desc = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_sample_year");
    Res_sample_year = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_report_year");
    Res_report_year = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_daily_sampleno_str");
    Res_daily_sampleno_str = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_test_name");
    Res_test_name = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_report_id");
    Res_report_id = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_sample_no");
    Res_sample_no = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("Res_Collecteddate");
    Res_Collecteddate = ((String[])localObject);
    localObject = localIntent.getStringExtra("p_mname");
    p_mname = ((String)localObject);
    localObject = localIntent.getStringExtra("fathers_name");
    fathers_name = ((String)localObject);
    localObject = localIntent.getStringExtra("guardian_rel");
    guardian_rel = ((String)localObject);
    localObject = localIntent.getStringExtra("p_sex");
    p_sex = ((String)localObject);
    localObject = localIntent.getStringExtra("p_lname");
    p_lname = ((String)localObject);
    localObject = localIntent.getStringExtra("p_fname");
    p_fname = ((String)localObject);
    localObject = localIntent.getStringExtra("p_address");
    p_address = ((String)localObject);
    localObject = localIntent.getStringExtra("p_mobile_no");
    p_mobile_no = ((String)localObject);
    localObject = localIntent.getStringExtra("p_initial");
    p_initial = ((String)localObject);
    localObject = localIntent.getStringExtra("dob");
    dob = ((String)localObject);
    localObject = localIntent.getStringExtra("uhid");
    uhid = ((String)localObject);
    localObject = localIntent.getStringExtra("hospital");
    hospital = ((String)localObject);
    localObject = localIntent.getStringExtra("hosid");
    hospitalcode = ((String)localObject);
    intializeViews();
    updateView();
  }
  
  public void onItemClick(int paramInt)
  {
    Object localObject1 = CustomListViewValuesArr;
    ((LabReportRowModel)((ArrayList)localObject1).get(paramInt));
    boolean bool = isConnected();
    if (bool)
    {
      pos = paramInt;
      localObject1 = new in/gov/mgov/ors/LabReport_3$CallList;
      ((LabReport_3.CallList)localObject1).<init>(this, null);
      int i = 2;
      String[] arrayOfString = new String[i];
      arrayOfString[0] = "getLabReportDetails";
      int j = 1;
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = ((StringBuilder)localObject2).append(paramInt);
      String str = "";
      localObject2 = str;
      arrayOfString[j] = localObject2;
      ((LabReport_3.CallList)localObject1).execute(arrayOfString);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */