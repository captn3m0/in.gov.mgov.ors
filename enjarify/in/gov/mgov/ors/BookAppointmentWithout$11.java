package in.gov.mgov.ors;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;

class BookAppointmentWithout$11
  implements DialogInterface.OnClickListener
{
  BookAppointmentWithout$11(BookAppointmentWithout paramBookAppointmentWithout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new android/content/Intent;
    Object localObject1 = this$0.getApplicationContext();
    localIntent.<init>((Context)localObject1, AuthenticateNonAadhaar.class);
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject2 = ((StringBuilder)localObject2).append("<");
    String str = this$0.hospitalnameString;
    localObject2 = ((StringBuilder)localObject2).append(str).append(">").append("<");
    str = this$0.DepartmentnameString;
    localObject2 = ((StringBuilder)localObject2).append(str).append(">").append("<");
    str = this$0.dateString;
    localObject2 = str + ">";
    localIntent.putExtra("appointment_info", (String)localObject2);
    localObject1 = this$0.editor;
    str = this$0.spacialitymessage;
    ((SharedPreferences.Editor)localObject1).putString("appointment_detail", str).commit();
    localIntent.putExtra("from", "noaadhaar");
    this$0.startActivity(localIntent);
    paramDialogInterface.cancel();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointmentWithout$11.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */