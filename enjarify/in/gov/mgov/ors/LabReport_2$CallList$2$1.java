package in.gov.mgov.ors;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import nitesh.floatinghint.FloatingHintEditText;

class LabReport_2$CallList$2$1
  implements View.OnClickListener
{
  LabReport_2$CallList$2$1(LabReport_2.CallList.2 param2) {}
  
  public void onClick(View paramView)
  {
    String str = this$2.val$input.getText().toString();
    Object localObject1 = this$2.this$1.this$0.OTP;
    boolean bool = str.equals(localObject1);
    Object localObject2;
    if (bool)
    {
      Intent localIntent = new android/content/Intent;
      localObject1 = this$2.this$1.this$0;
      localIntent.<init>((Context)localObject1, LabReport_3.class);
      localObject2 = this$2.this$1.this$0.textview_name_data.getText().toString();
      localIntent.putExtra("p_mname", (String)localObject2);
      localObject2 = this$2.this$1.this$0.fathers_name;
      localIntent.putExtra("fathers_name", (String)localObject2);
      localObject2 = this$2.this$1.this$0.guardian_rel;
      localIntent.putExtra("guardian_rel", (String)localObject2);
      localObject2 = this$2.this$1.this$0.p_sex;
      localIntent.putExtra("p_sex", (String)localObject2);
      localObject2 = this$2.this$1.this$0.p_lname;
      localIntent.putExtra("p_lname", (String)localObject2);
      localObject2 = this$2.this$1.this$0.p_fname;
      localIntent.putExtra("p_fname", (String)localObject2);
      localObject2 = this$2.this$1.this$0.textview__age_data.getText().toString();
      localIntent.putExtra("dob", (String)localObject2);
      localObject2 = this$2.this$1.this$0.p_address;
      localIntent.putExtra("p_address", (String)localObject2);
      localObject2 = this$2.this$1.this$0.p_mobile_no;
      localIntent.putExtra("p_mobile_no", (String)localObject2);
      localObject2 = this$2.this$1.this$0.p_initial;
      localIntent.putExtra("p_initial", (String)localObject2);
      localObject2 = this$2.this$1.this$0.Res_sample_type_desc;
      localIntent.putExtra("Res_sample_type_desc", (String[])localObject2);
      localObject2 = this$2.this$1.this$0.Res_sample_year;
      localIntent.putExtra("Res_sample_year", (String[])localObject2);
      localObject2 = this$2.this$1.this$0.Res_report_year;
      localIntent.putExtra("Res_report_year", (String[])localObject2);
      localObject2 = this$2.this$1.this$0.Res_daily_sampleno_str;
      localIntent.putExtra("Res_daily_sampleno_str", (String[])localObject2);
      localObject2 = this$2.this$1.this$0.Res_test_name;
      localIntent.putExtra("Res_test_name", (String[])localObject2);
      localObject2 = this$2.this$1.this$0.Res_sample_no;
      localIntent.putExtra("Res_sample_no", (String[])localObject2);
      localObject2 = this$2.this$1.this$0.Res_report_id;
      localIntent.putExtra("Res_report_id", (String[])localObject2);
      localObject2 = this$2.this$1.this$0.Res_Collecteddate;
      localIntent.putExtra("Res_Collecteddate", (String[])localObject2);
      localObject2 = this$2.this$1.this$0.hospital;
      localIntent.putExtra("hospital", (String)localObject2);
      localObject2 = this$2.this$1.this$0.hospitalcode;
      localIntent.putExtra("hosid", (String)localObject2);
      localObject2 = this$2.this$1.this$0.textview_uhid_data.getText().toString();
      localIntent.putExtra("uhid", (String)localObject2);
      this$2.this$1.this$0.startActivity(localIntent);
      localObject1 = this$2.val$d;
      ((AlertDialog)localObject1).cancel();
    }
    for (;;)
    {
      return;
      localObject1 = this$2.this$1.this$0;
      localObject2 = this$2.this$1.this$0.getResources();
      int i = 2131034339;
      localObject2 = ((Resources)localObject2).getString(i);
      LabReport_2.access$300((LabReport_2)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_2$CallList$2$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */