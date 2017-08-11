package in.gov.mgov.ors;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import nitesh.floatinghint.FloatingHintEditText;

class CancelAppointment3$CallList$2
  implements DialogInterface.OnShowListener
{
  CancelAppointment3$CallList$2(CancelAppointment3.CallList paramCallList, AlertDialog paramAlertDialog, FloatingHintEditText paramFloatingHintEditText) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    Button localButton1 = val$d.getButton(-1);
    Button localButton2 = val$d.getButton(-2);
    Button localButton3 = val$d.getButton(-3);
    Object localObject = new in/gov/mgov/ors/CancelAppointment3$CallList$2$1;
    ((CancelAppointment3.CallList.2.1)localObject).<init>(this);
    localButton1.setOnClickListener((View.OnClickListener)localObject);
    localObject = new in/gov/mgov/ors/CancelAppointment3$CallList$2$2;
    ((CancelAppointment3.CallList.2.2)localObject).<init>(this);
    localButton2.setOnClickListener((View.OnClickListener)localObject);
    localObject = new in/gov/mgov/ors/CancelAppointment3$CallList$2$3;
    ((CancelAppointment3.CallList.2.3)localObject).<init>(this);
    localButton3.setOnClickListener((View.OnClickListener)localObject);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment3$CallList$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */