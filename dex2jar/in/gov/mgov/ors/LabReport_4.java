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
import java.util.ArrayList;

public class LabReport_4
  extends Activity
{
  public ArrayList<LabReportDetailsRowModel> CustomListViewValuesArr = new ArrayList();
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
  
  private void intializeViews()
  {
    textview_uhid_data = ((TextView)findViewById(2131296414));
    textview_name_data = ((TextView)findViewById(2131296418));
    textview__age_data = ((TextView)findViewById(2131296419));
    textview_gender_data = ((TextView)findViewById(2131296420));
    textview_test_name_data = ((TextView)findViewById(2131296422));
    textview_type_data = ((TextView)findViewById(2131296423));
    textview_date_data = ((TextView)findViewById(2131296424));
    listview_report_details = ((ListView)findViewById(2131296425));
  }
  
  private void setListData()
  {
    int i = 0;
    while (i < unit.length)
    {
      LabReportDetailsRowModel localLabReportDetailsRowModel = new LabReportDetailsRowModel();
      localLabReportDetailsRowModel.settest_name(testName[i]);
      localLabReportDetailsRowModel.setobservation_result(resultl[i]);
      localLabReportDetailsRowModel.setnormal_range(normal_range_lower[i] + "-" + normal_range_upper[i]);
      CustomListViewValuesArr.add(localLabReportDetailsRowModel);
      i += 1;
    }
  }
  
  private void updateView()
  {
    ((Button)findViewById(2131296410)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        onBackPressed();
      }
    });
    ((ImageView)findViewById(2131296259)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), ServiceSelection.class);
        paramAnonymousView.addFlags(268468224);
        startActivity(paramAnonymousView);
      }
    });
    textview_uhid_data.setText(getResources().getString(2131034328) + ": " + uhidl[0] + "    " + getResources().getString(2131034215) + ": " + hospital);
    textview_name_data.setText(name);
    textview__age_data.setText(age);
    textview_gender_data.setText(gender);
    textview_type_data.setText(Res_daily_sampleno_str);
    textview_test_name_data.setText(Res_test_name);
    textview_date_data.setText(Res_Collecteddate);
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
    paramBundle = getIntent();
    unit = paramBundle.getStringArrayExtra("unit");
    resultl = paramBundle.getStringArrayExtra("resultl");
    testName = paramBundle.getStringArrayExtra("testName");
    normal_range_lower = paramBundle.getStringArrayExtra("normal_range_lower");
    sample_receive_date = paramBundle.getStringArrayExtra("sample_receive_date");
    normal_range_upper = paramBundle.getStringArrayExtra("normal_range_upper");
    report_verified_by = paramBundle.getStringArrayExtra("report_verified_by");
    uhidl = paramBundle.getStringArrayExtra("uhidl");
    name = paramBundle.getStringExtra("name");
    gender = paramBundle.getStringExtra("sex");
    age = paramBundle.getStringExtra("age");
    hospital = paramBundle.getStringExtra("hospital");
    Res_sample_type_desc = paramBundle.getStringExtra("Res_sample_type_desc");
    Res_sample_year = paramBundle.getStringExtra("Res_sample_year");
    Res_report_year = paramBundle.getStringExtra("Res_report_year");
    Res_daily_sampleno_str = paramBundle.getStringExtra("Res_daily_sampleno_str");
    Res_test_name = paramBundle.getStringExtra("Res_test_name");
    Res_report_id = paramBundle.getStringExtra("Res_report_id");
    Res_sample_no = paramBundle.getStringExtra("Res_sample_no");
    Res_Collecteddate = paramBundle.getStringExtra("Res_Collecteddate");
    intializeViews();
    updateView();
  }
  
  public void onItemClick(int paramInt)
  {
    LabReportDetailsRowModel localLabReportDetailsRowModel = (LabReportDetailsRowModel)CustomListViewValuesArr.get(paramInt);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/LabReport_4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */