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
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CancelAppointment2
  extends Activity
  implements View.OnClickListener
{
  public CancelAppointment2 CancelListView = null;
  public ArrayList<CancelRowModel> CustomListViewValuesArr = new ArrayList();
  CancelAdapter adapter;
  ListView appointmnet_list;
  Button btn_home;
  ImageView button_home;
  String hospitalcode;
  String[] resAadhaar;
  String[] resAppdates;
  String[] resAppointment_id;
  String[] resApptime;
  String[] resDOB;
  String[] resDept;
  String[] resDoctor;
  String[] resEmail;
  String[] resGender;
  String[] resHospitals;
  String[] resMobileNo;
  String[] resP_address;
  String[] resPatientname;
  String[] resRequestDate;
  String[] resRoom_name;
  String[] resStatus;
  String[] resfathers_name;
  String[] reshid;
  TextView textview_aadhaar;
  TextView textview_address;
  TextView textview_age;
  TextView textview_appid;
  TextView textview_gender;
  TextView textview_hospital;
  TextView textview_name;
  TextView textview_uhid;
  String type;
  String value;
  
  private void intializeViews()
  {
    button_home = ((ImageView)findViewById(2131296259));
    textview_name = ((TextView)findViewById(2131296345));
    textview_age = ((TextView)findViewById(2131296346));
    textview_gender = ((TextView)findViewById(2131296347));
    textview_address = ((TextView)findViewById(2131296348));
    textview_hospital = ((TextView)findViewById(2131296353));
    textview_uhid = ((TextView)findViewById(2131296352));
    textview_aadhaar = ((TextView)findViewById(2131296349));
    appointmnet_list = ((ListView)findViewById(2131296358));
    btn_home = ((Button)findViewById(2131296359));
    textview_appid = ((TextView)findViewById(2131296351));
  }
  
  private void showMessage(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 1);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  private void updateView()
  {
    button_home.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), ServiceSelection.class);
        paramAnonymousView.addFlags(268468224);
        startActivity(paramAnonymousView);
      }
    });
    btn_home.setOnClickListener(this);
    CancelListView = this;
    setListData();
    Object localObject = getResources();
    adapter = new CancelAdapter(CancelListView, CustomListViewValuesArr, (Resources)localObject);
    appointmnet_list.setAdapter(adapter);
    textview_aadhaar.setText(getResources().getString(2131034114) + ": " + resAadhaar[0]);
    textview_uhid.setText(getResources().getString(2131034329) + " " + reshid[0]);
    if (type.equalsIgnoreCase("byuhid"))
    {
      textview_uhid.setText(getResources().getString(2131034329) + " " + value);
      textview_uhid.setVisibility(0);
      textview_aadhaar.setVisibility(8);
      textview_appid.setVisibility(8);
    }
    if (type.equalsIgnoreCase("byid"))
    {
      textview_aadhaar.setVisibility(8);
      textview_uhid.setVisibility(8);
      textview_appid.setVisibility(0);
      textview_appid.setText(getResources().getString(2131034136) + ": " + value);
    }
    if (type.equalsIgnoreCase("byaadhaar"))
    {
      textview_uhid.setVisibility(8);
      textview_appid.setVisibility(8);
      textview_aadhaar.setText(getResources().getString(2131034114) + ": " + value);
      textview_aadhaar.setVisibility(0);
    }
    textview_name.setText(getResources().getString(2131034242) + ": " + resPatientname[0]);
    textview_gender.setText(getResources().getString(2131034211) + ": " + resGender[0]);
    textview_address.setText(getResources().getString(2131034122) + ": " + resP_address[0]);
    textview_hospital.setText(getResources().getString(2131034215) + ": " + resHospitals[0]);
    localObject = new SimpleDateFormat("yyyy").format(new Date());
    int i = Integer.valueOf(resDOB[0].substring(0, 4)).intValue();
    int j = Integer.valueOf((String)localObject).intValue();
    textview_age.setText(j - i + "");
    textview_address.setVisibility(8);
    textview_gender.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == btn_home)
    {
      startActivity(new Intent(getApplicationContext(), ServiceSelection.class));
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903047);
    paramBundle = getIntent();
    resHospitals = paramBundle.getStringArrayExtra("hospitals");
    resDept = paramBundle.getStringArrayExtra("depts");
    resAppdates = paramBundle.getStringArrayExtra("appdates");
    resStatus = paramBundle.getStringArrayExtra("status");
    resPatientname = paramBundle.getStringArrayExtra("patient_name");
    resfathers_name = paramBundle.getStringArrayExtra("fathers_name");
    resEmail = paramBundle.getStringArrayExtra("email");
    resRoom_name = paramBundle.getStringArrayExtra("room_name");
    resDOB = paramBundle.getStringArrayExtra("dob");
    resGender = paramBundle.getStringArrayExtra("gender");
    resP_address = paramBundle.getStringArrayExtra("p_address");
    resAppointment_id = paramBundle.getStringArrayExtra("appointment_id");
    resMobileNo = paramBundle.getStringArrayExtra("mobile_no");
    resDoctor = paramBundle.getStringArrayExtra("doctor");
    resAadhaar = paramBundle.getStringArrayExtra("aadhaar");
    reshid = paramBundle.getStringArrayExtra("hid");
    resRequestDate = paramBundle.getStringArrayExtra("requestdate");
    resApptime = paramBundle.getStringArrayExtra("apptime");
    hospitalcode = paramBundle.getStringExtra("hosid");
    type = paramBundle.getStringExtra("type");
    value = paramBundle.getStringExtra("value");
    intializeViews();
    updateView();
  }
  
  public void onItemClick(int paramInt)
  {
    Object localObject = (CancelRowModel)CustomListViewValuesArr.get(paramInt);
    if (resStatus[paramInt].equalsIgnoreCase("Cancelled"))
    {
      showMessage(getResources().getString(2131034131));
      return;
    }
    if (resStatus[paramInt].equalsIgnoreCase("Expired"))
    {
      showMessage(getResources().getString(2131034132));
      return;
    }
    localObject = new Intent(getApplicationContext(), CancelAppointment3.class);
    ((Intent)localObject).putExtra("appdates", resAppdates[paramInt]);
    ((Intent)localObject).putExtra("hospitals", resHospitals[paramInt]);
    ((Intent)localObject).putExtra("depts", resDept[paramInt]);
    ((Intent)localObject).putExtra("status", resStatus[paramInt]);
    ((Intent)localObject).putExtra("patient_name", resPatientname[paramInt]);
    ((Intent)localObject).putExtra("fathers_name", resfathers_name[paramInt]);
    ((Intent)localObject).putExtra("email", resEmail[paramInt]);
    ((Intent)localObject).putExtra("room_name", resRoom_name[paramInt]);
    ((Intent)localObject).putExtra("dob", textview_age.getText().toString());
    ((Intent)localObject).putExtra("gender", resGender[paramInt]);
    ((Intent)localObject).putExtra("p_address", resP_address[paramInt]);
    ((Intent)localObject).putExtra("appointment_id", resAppointment_id[paramInt]);
    ((Intent)localObject).putExtra("mobile_no", resMobileNo[paramInt]);
    ((Intent)localObject).putExtra("doctor", resDoctor[paramInt]);
    ((Intent)localObject).putExtra("hosid", hospitalcode);
    ((Intent)localObject).putExtra("aadhaar", resAadhaar[paramInt]);
    ((Intent)localObject).putExtra("hid", reshid[paramInt]);
    ((Intent)localObject).putExtra("requestdate", resRequestDate[paramInt]);
    ((Intent)localObject).putExtra("apptime", resApptime[paramInt]);
    startActivity((Intent)localObject);
  }
  
  public void setListData()
  {
    int i = 0;
    while (i < resAppdates.length)
    {
      CancelRowModel localCancelRowModel = new CancelRowModel();
      localCancelRowModel.setAppt_date(resAppdates[i]);
      localCancelRowModel.setdepartment(resDept[i]);
      localCancelRowModel.sethospital(resHospitals[i]);
      localCancelRowModel.setStatus(resStatus[i]);
      CustomListViewValuesArr.add(localCancelRowModel);
      i += 1;
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/CancelAppointment2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */