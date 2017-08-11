package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class LabReport_4
  extends Activity
{
  public ArrayList CustomListViewValuesArr;
  public LabReport_4 LabReportDetailsListView = null;
  String Res_Collecteddate;
  String Res_daily_sampleno_str;
  String Res_report_id;
  String Res_report_year;
  String Res_sample_no;
  String Res_sample_type_desc;
  String Res_sample_year;
  String Res_test_name;
  LabReportDetailsAdapter adapter;
  String age;
  Button button_view_lab_reports;
  String gender;
  String hospital;
  ListView listview_report_details;
  String name;
  String[] normal_range_lower;
  String[] normal_range_upper;
  String[] report_verified_by;
  String[] resultl;
  String[] sample_receive_date;
  String[] testName;
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
  String[] uhidl;
  String[] unit;
  
  public LabReport_4()
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    CustomListViewValuesArr = localArrayList;
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
    localObject = (TextView)findViewById(2131296422);
    textview_test_name_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296423);
    textview_type_data = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296424);
    textview_date_data = ((TextView)localObject);
    localObject = (ListView)findViewById(2131296425);
    listview_report_details = ((ListView)localObject);
  }
  
  private void setListData()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = unit;
      int j = localObject.length;
      if (i >= j) {
        break;
      }
      LabReportDetailsRowModel localLabReportDetailsRowModel = new in/gov/mgov/ors/LabReportDetailsRowModel;
      localLabReportDetailsRowModel.<init>();
      localObject = testName[i];
      localLabReportDetailsRowModel.settest_name((String)localObject);
      localObject = resultl[i];
      localLabReportDetailsRowModel.setobservation_result((String)localObject);
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      String str = normal_range_lower[i];
      localObject = ((StringBuilder)localObject).append(str).append("-");
      str = normal_range_upper[i];
      localObject = str;
      localLabReportDetailsRowModel.setnormal_range((String)localObject);
      localObject = CustomListViewValuesArr;
      ((ArrayList)localObject).add(localLabReportDetailsRowModel);
      i += 1;
    }
  }
  
  private void updateView()
  {
    Button localButton = (Button)findViewById(2131296410);
    Object localObject1 = new in/gov/mgov/ors/LabReport_4$1;
    ((LabReport_4.1)localObject1).<init>(this);
    localButton.setOnClickListener((View.OnClickListener)localObject1);
    ImageView localImageView = (ImageView)findViewById(2131296259);
    localObject1 = new in/gov/mgov/ors/LabReport_4$2;
    ((LabReport_4.2)localObject1).<init>(this);
    localImageView.setOnClickListener((View.OnClickListener)localObject1);
    localObject1 = textview_uhid_data;
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    String str = getResources().getString(2131034328);
    localObject2 = ((StringBuilder)localObject2).append(str).append(": ");
    str = uhidl[0];
    localObject2 = ((StringBuilder)localObject2).append(str).append("    ");
    str = getResources().getString(2131034215);
    localObject2 = ((StringBuilder)localObject2).append(str).append(": ");
    str = hospital;
    localObject2 = str;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_name_data;
    localObject2 = name;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview__age_data;
    localObject2 = age;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_gender_data;
    localObject2 = gender;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_type_data;
    localObject2 = Res_daily_sampleno_str;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_test_name_data;
    localObject2 = Res_test_name;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_date_data;
    localObject2 = Res_Collecteddate;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    LabReportDetailsListView = this;
    setListData();
    getResources();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903056);
    Intent localIntent = getIntent();
    Object localObject = localIntent.getStringArrayExtra("unit");
    unit = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("resultl");
    resultl = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("testName");
    testName = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("normal_range_lower");
    normal_range_lower = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("sample_receive_date");
    sample_receive_date = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("normal_range_upper");
    normal_range_upper = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("report_verified_by");
    report_verified_by = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("uhidl");
    uhidl = ((String[])localObject);
    localObject = localIntent.getStringExtra("name");
    name = ((String)localObject);
    localObject = localIntent.getStringExtra("sex");
    gender = ((String)localObject);
    localObject = localIntent.getStringExtra("age");
    age = ((String)localObject);
    localObject = localIntent.getStringExtra("hospital");
    hospital = ((String)localObject);
    localObject = localIntent.getStringExtra("Res_sample_type_desc");
    Res_sample_type_desc = ((String)localObject);
    localObject = localIntent.getStringExtra("Res_sample_year");
    Res_sample_year = ((String)localObject);
    localObject = localIntent.getStringExtra("Res_report_year");
    Res_report_year = ((String)localObject);
    localObject = localIntent.getStringExtra("Res_daily_sampleno_str");
    Res_daily_sampleno_str = ((String)localObject);
    localObject = localIntent.getStringExtra("Res_test_name");
    Res_test_name = ((String)localObject);
    localObject = localIntent.getStringExtra("Res_report_id");
    Res_report_id = ((String)localObject);
    localObject = localIntent.getStringExtra("Res_sample_no");
    Res_sample_no = ((String)localObject);
    localObject = localIntent.getStringExtra("Res_Collecteddate");
    Res_Collecteddate = ((String)localObject);
    intializeViews();
    updateView();
  }
  
  public void onItemClick(int paramInt)
  {
    ((LabReportDetailsRowModel)CustomListViewValuesArr.get(paramInt));
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_4.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */