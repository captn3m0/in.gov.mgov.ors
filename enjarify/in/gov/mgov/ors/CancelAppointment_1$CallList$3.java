package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;

class CancelAppointment_1$CallList$3
  implements Runnable
{
  CancelAppointment_1$CallList$3(CancelAppointment_1.CallList paramCallList) {}
  
  public void run()
  {
    Intent localIntent = new android/content/Intent;
    Context localContext = this$1.this$0.getApplicationContext();
    localIntent.<init>(localContext, CancelAppointment2.class);
    Object localObject = this$1.this$0.type;
    localIntent.putExtra("type", (String)localObject);
    localObject = this$1.this$0.resAppdates;
    localIntent.putExtra("appdates", (String[])localObject);
    localObject = this$1.this$0.reshospitals;
    localIntent.putExtra("hospitals", (String[])localObject);
    localObject = this$1.this$0.resDepts;
    localIntent.putExtra("depts", (String[])localObject);
    localObject = this$1.this$0.resStatus;
    localIntent.putExtra("status", (String[])localObject);
    localObject = this$1.this$0.resPatientname;
    localIntent.putExtra("patient_name", (String[])localObject);
    localObject = this$1.this$0.resfathers_name;
    localIntent.putExtra("fathers_name", (String[])localObject);
    localObject = this$1.this$0.resEmail;
    localIntent.putExtra("email", (String[])localObject);
    localObject = this$1.this$0.resRoom_name;
    localIntent.putExtra("room_name", (String[])localObject);
    localObject = this$1.this$0.resDOB;
    localIntent.putExtra("dob", (String[])localObject);
    localObject = this$1.this$0.resGender;
    localIntent.putExtra("gender", (String[])localObject);
    localObject = this$1.this$0.resP_address;
    localIntent.putExtra("p_address", (String[])localObject);
    localObject = this$1.this$0.resAppointment_id;
    localIntent.putExtra("appointment_id", (String[])localObject);
    localObject = this$1.this$0.resMobileNo;
    localIntent.putExtra("mobile_no", (String[])localObject);
    localObject = this$1.this$0.resDoctor;
    localIntent.putExtra("doctor", (String[])localObject);
    localObject = this$1.this$0.hospitalcode;
    localIntent.putExtra("hosid", (String)localObject);
    localObject = this$1.this$0.resAadhaar;
    localIntent.putExtra("aadhaar", (String[])localObject);
    localObject = this$1.this$0.reshid;
    localIntent.putExtra("hid", (String[])localObject);
    localObject = this$1.this$0.resRequestDate;
    localIntent.putExtra("requestdate", (String[])localObject);
    localObject = this$1.this$0.resApptime;
    localIntent.putExtra("apptime", (String[])localObject);
    localObject = this$1.this$0.enteredValue.getText().toString();
    localIntent.putExtra("value", (String)localObject);
    this$1.this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment_1$CallList$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */