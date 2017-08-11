package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
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
  public ArrayList CustomListViewValuesArr;
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
  
  public CancelAppointment2()
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    CustomListViewValuesArr = localArrayList;
  }
  
  private void intializeViews()
  {
    Object localObject = (ImageView)findViewById(2131296259);
    button_home = ((ImageView)localObject);
    localObject = (TextView)findViewById(2131296345);
    textview_name = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296346);
    textview_age = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296347);
    textview_gender = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296348);
    textview_address = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296353);
    textview_hospital = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296352);
    textview_uhid = ((TextView)localObject);
    localObject = (TextView)findViewById(2131296349);
    textview_aadhaar = ((TextView)localObject);
    localObject = (ListView)findViewById(2131296358);
    appointmnet_list = ((ListView)localObject);
    localObject = (Button)findViewById(2131296359);
    btn_home = ((Button)localObject);
    localObject = (TextView)findViewById(2131296351);
    textview_appid = ((TextView)localObject);
  }
  
  private void showMessage(String paramString)
  {
    Toast localToast = Toast.makeText(getApplicationContext(), paramString, 1);
    localToast.setGravity(17, 0, 0);
    localToast.show();
  }
  
  private void updateView()
  {
    int i = 2131034329;
    int j = 2131034114;
    int k = 8;
    Object localObject1 = button_home;
    Object localObject2 = new in/gov/mgov/ors/CancelAppointment2$1;
    ((CancelAppointment2.1)localObject2).<init>(this);
    ((ImageView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    btn_home.setOnClickListener(this);
    CancelListView = this;
    setListData();
    Resources localResources = getResources();
    localObject1 = new in/gov/mgov/ors/CancelAdapter;
    localObject2 = CancelListView;
    Object localObject3 = CustomListViewValuesArr;
    ((CancelAdapter)localObject1).<init>((Activity)localObject2, (ArrayList)localObject3, localResources);
    adapter = ((CancelAdapter)localObject1);
    localObject1 = appointmnet_list;
    localObject2 = adapter;
    ((ListView)localObject1).setAdapter((ListAdapter)localObject2);
    localObject1 = textview_aadhaar;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources().getString(j);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
    localObject3 = resAadhaar[0];
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_uhid;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources().getString(i);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(" ");
    localObject3 = reshid[0];
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = type;
    localObject2 = "byuhid";
    boolean bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
    if (bool)
    {
      localObject1 = textview_uhid;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = getResources().getString(i);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(" ");
      localObject3 = value;
      localObject2 = (String)localObject3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      textview_uhid.setVisibility(0);
      textview_aadhaar.setVisibility(k);
      localObject1 = textview_appid;
      ((TextView)localObject1).setVisibility(k);
    }
    localObject1 = type;
    localObject2 = "byid";
    bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
    if (bool)
    {
      textview_aadhaar.setVisibility(k);
      textview_uhid.setVisibility(k);
      textview_appid.setVisibility(0);
      localObject1 = textview_appid;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = getResources();
      i = 2131034136;
      localObject3 = ((Resources)localObject3).getString(i);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
      localObject3 = value;
      localObject2 = (String)localObject3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
    }
    localObject1 = type;
    localObject2 = "byaadhaar";
    bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
    if (bool)
    {
      textview_uhid.setVisibility(k);
      textview_appid.setVisibility(k);
      localObject1 = textview_aadhaar;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = getResources().getString(j);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
      localObject3 = value;
      localObject2 = (String)localObject3;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = textview_aadhaar;
      ((TextView)localObject1).setVisibility(0);
    }
    localObject1 = textview_name;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources().getString(2131034242);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
    localObject3 = resPatientname[0];
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_gender;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources().getString(2131034211);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
    localObject3 = resGender[0];
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_address;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources().getString(2131034122);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
    localObject3 = resP_address[0];
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = textview_hospital;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = getResources().getString(2131034215);
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(": ");
    localObject3 = resHospitals[0];
    localObject2 = (String)localObject3;
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localObject1 = new java/text/SimpleDateFormat;
    ((SimpleDateFormat)localObject1).<init>("yyyy");
    localObject2 = new java/util/Date;
    ((Date)localObject2).<init>();
    String str = ((SimpleDateFormat)localObject1).format((Date)localObject2);
    int m = Integer.valueOf(resDOB[0].substring(0, 4)).intValue();
    int n = Integer.valueOf(str).intValue() - m;
    localObject1 = textview_age;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject2 = n + "";
    ((TextView)localObject1).setText((CharSequence)localObject2);
    textview_address.setVisibility(k);
    textview_gender.setVisibility(k);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = btn_home;
    if (paramView == localObject)
    {
      Intent localIntent = new android/content/Intent;
      localObject = getApplicationContext();
      Class localClass = ServiceSelection.class;
      localIntent.<init>((Context)localObject, localClass);
      startActivity(localIntent);
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903047);
    Intent localIntent = getIntent();
    Object localObject = localIntent.getStringArrayExtra("hospitals");
    resHospitals = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("depts");
    resDept = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("appdates");
    resAppdates = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("status");
    resStatus = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("patient_name");
    resPatientname = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("fathers_name");
    resfathers_name = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("email");
    resEmail = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("room_name");
    resRoom_name = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("dob");
    resDOB = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("gender");
    resGender = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("p_address");
    resP_address = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("appointment_id");
    resAppointment_id = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("mobile_no");
    resMobileNo = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("doctor");
    resDoctor = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("aadhaar");
    resAadhaar = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("hid");
    reshid = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("requestdate");
    resRequestDate = ((String[])localObject);
    localObject = localIntent.getStringArrayExtra("apptime");
    resApptime = ((String[])localObject);
    localObject = localIntent.getStringExtra("hosid");
    hospitalcode = ((String)localObject);
    localObject = localIntent.getStringExtra("type");
    type = ((String)localObject);
    localObject = localIntent.getStringExtra("value");
    value = ((String)localObject);
    intializeViews();
    updateView();
  }
  
  public void onItemClick(int paramInt)
  {
    ((CancelRowModel)CustomListViewValuesArr.get(paramInt));
    Object localObject = resStatus[paramInt];
    String str = "Cancelled";
    boolean bool = ((String)localObject).equalsIgnoreCase(str);
    int i;
    if (bool)
    {
      localObject = getResources();
      i = 2131034131;
      localObject = ((Resources)localObject).getString(i);
      showMessage((String)localObject);
    }
    for (;;)
    {
      return;
      localObject = resStatus[paramInt];
      str = "Expired";
      bool = ((String)localObject).equalsIgnoreCase(str);
      if (bool)
      {
        localObject = getResources();
        i = 2131034132;
        localObject = ((Resources)localObject).getString(i);
        showMessage((String)localObject);
      }
      else
      {
        Intent localIntent = new android/content/Intent;
        localObject = getApplicationContext();
        localIntent.<init>((Context)localObject, CancelAppointment3.class);
        str = resAppdates[paramInt];
        localIntent.putExtra("appdates", str);
        str = resHospitals[paramInt];
        localIntent.putExtra("hospitals", str);
        str = resDept[paramInt];
        localIntent.putExtra("depts", str);
        str = resStatus[paramInt];
        localIntent.putExtra("status", str);
        str = resPatientname[paramInt];
        localIntent.putExtra("patient_name", str);
        str = resfathers_name[paramInt];
        localIntent.putExtra("fathers_name", str);
        str = resEmail[paramInt];
        localIntent.putExtra("email", str);
        str = resRoom_name[paramInt];
        localIntent.putExtra("room_name", str);
        str = textview_age.getText().toString();
        localIntent.putExtra("dob", str);
        str = resGender[paramInt];
        localIntent.putExtra("gender", str);
        str = resP_address[paramInt];
        localIntent.putExtra("p_address", str);
        str = resAppointment_id[paramInt];
        localIntent.putExtra("appointment_id", str);
        str = resMobileNo[paramInt];
        localIntent.putExtra("mobile_no", str);
        str = resDoctor[paramInt];
        localIntent.putExtra("doctor", str);
        str = hospitalcode;
        localIntent.putExtra("hosid", str);
        str = resAadhaar[paramInt];
        localIntent.putExtra("aadhaar", str);
        str = reshid[paramInt];
        localIntent.putExtra("hid", str);
        str = resRequestDate[paramInt];
        localIntent.putExtra("requestdate", str);
        localObject = "apptime";
        str = resApptime[paramInt];
        localIntent.putExtra((String)localObject, str);
        startActivity(localIntent);
      }
    }
  }
  
  public void setListData()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = resAppdates;
      int j = localObject.length;
      if (i >= j) {
        break;
      }
      CancelRowModel localCancelRowModel = new in/gov/mgov/ors/CancelRowModel;
      localCancelRowModel.<init>();
      localObject = resAppdates[i];
      localCancelRowModel.setAppt_date((String)localObject);
      localObject = resDept[i];
      localCancelRowModel.setdepartment((String)localObject);
      localObject = resHospitals[i];
      localCancelRowModel.sethospital((String)localObject);
      localObject = resStatus[i];
      localCancelRowModel.setStatus((String)localObject);
      localObject = CustomListViewValuesArr;
      ((ArrayList)localObject).add(localCancelRowModel);
      i += 1;
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */