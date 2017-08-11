package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import com.aadhaar.auth.Verhoeff;
import in.gov.mgov.helper.Helper;

class CancelAppointment_1$3
  implements View.OnClickListener
{
  CancelAppointment_1$3(CancelAppointment_1 paramCancelAppointment_1) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = this$0.search_criteria.getSelectedItemPosition();
    Object localObject1 = this$0.mhospital;
    int i2 = ((Spinner)localObject1).getSelectedItemPosition();
    int i5;
    label92:
    label171:
    label251:
    int i3;
    if (i2 != 0)
    {
      i = 0 + 1;
      if (i1 != 0) {
        break label550;
      }
      localObject1 = this$0.enteredValue.getText().toString();
      i2 = ((String)localObject1).length();
      i5 = 13;
      if (i2 != i5) {
        break label544;
      }
      i += 1;
      i2 = 1;
      if (i1 != i2) {
        break label562;
      }
      localObject1 = this$0.enteredValue.getText().toString();
      i2 = ((String)localObject1).length();
      i5 = 13;
      if (i2 > i5) {
        break label556;
      }
      localObject1 = this$0.enteredValue.getText().toString();
      i2 = ((String)localObject1).length();
      i5 = 5;
      if (i2 < i5) {
        break label556;
      }
      i += 1;
      i2 = 2;
      if (i1 != i2) {
        break label580;
      }
      localObject1 = this$0.enteredValue.getText().toString();
      i2 = ((String)localObject1).length();
      i5 = 12;
      if (i2 != i5) {
        break label574;
      }
      new Verhoeff();
      localObject1 = this$0.enteredValue.getText().toString();
      boolean bool1 = Verhoeff.validateVerhoeff((String)localObject1);
      if (!bool1) {
        break label568;
      }
      i += 1;
      i3 = 3;
      if (i1 == i3)
      {
        localObject1 = this$0.enteredValue.getText().toString();
        i3 = ((String)localObject1).length();
        i5 = 10;
        if (i3 != i5) {
          break label586;
        }
        i += 1;
      }
    }
    Object localObject2;
    int i6;
    label544:
    label550:
    label556:
    label562:
    label568:
    label574:
    label580:
    label586:
    for (;;)
    {
      i3 = 2;
      if (i != i3) {
        break label589;
      }
      Intent localIntent = new android/content/Intent;
      localObject1 = this$0.getApplicationContext();
      localObject2 = CancelAppointment2.class;
      localIntent.<init>((Context)localObject1, (Class)localObject2);
      localObject1 = this$0;
      boolean bool2 = ((CancelAppointment_1)localObject1).isConnected();
      if (bool2)
      {
        String str1;
        if (k == 0)
        {
          localObject1 = new in/gov/mgov/ors/CancelAppointment_1$CallList;
          localObject2 = this$0;
          ((CancelAppointment_1.CallList)localObject1).<init>((CancelAppointment_1)localObject2, null);
          i5 = 2;
          localObject2 = new String[i5];
          localObject2[0] = "getAppointmentList";
          i6 = 1;
          str1 = "byid";
          localObject2[i6] = str1;
          ((CancelAppointment_1.CallList)localObject1).execute((Object[])localObject2);
        }
        if (m == 0)
        {
          localObject1 = new in/gov/mgov/ors/CancelAppointment_1$CallList;
          localObject2 = this$0;
          ((CancelAppointment_1.CallList)localObject1).<init>((CancelAppointment_1)localObject2, null);
          i5 = 2;
          localObject2 = new String[i5];
          localObject2[0] = "getAppointmentList";
          i6 = 1;
          str1 = "byuhid";
          localObject2[i6] = str1;
          ((CancelAppointment_1.CallList)localObject1).execute((Object[])localObject2);
        }
        if (n == 0)
        {
          localObject1 = new in/gov/mgov/ors/CancelAppointment_1$CallList;
          localObject2 = this$0;
          ((CancelAppointment_1.CallList)localObject1).<init>((CancelAppointment_1)localObject2, null);
          i5 = 2;
          localObject2 = new String[i5];
          localObject2[0] = "getAppointmentList";
          i6 = 1;
          str1 = "byaadhaar";
          localObject2[i6] = str1;
          ((CancelAppointment_1.CallList)localObject1).execute((Object[])localObject2);
        }
      }
      return;
      j = 1;
      break;
      k = 1;
      break label92;
      k = 1;
      break label92;
      m = 1;
      break label171;
      m = 1;
      break label171;
      n = 1;
      break label251;
      n = 1;
      break label251;
      n = 1;
      break label251;
    }
    label589:
    String str2 = "";
    if (j != 0)
    {
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject1 = ((StringBuilder)localObject1).append(str2);
      localObject2 = this$0.getResources();
      i6 = 2131034285;
      localObject2 = ((Resources)localObject2).getString(i6);
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
      localObject2 = "\n";
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
      str2 = ((StringBuilder)localObject1).toString();
    }
    if (i1 == 0)
    {
      localObject1 = this$0.enteredValue.getText().toString();
      i4 = ((String)localObject1).length();
      i5 = 13;
      if (i4 != i5)
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localObject1 = ((StringBuilder)localObject1).append(str2);
        localObject2 = this$0.getResources();
        i6 = 2131034275;
        localObject2 = ((Resources)localObject2).getString(i6);
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(" ");
        localObject2 = this$0.enteredValue.getHint();
        localObject1 = ((StringBuilder)localObject1).append(localObject2);
        localObject2 = "\n";
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
        str2 = ((StringBuilder)localObject1).toString();
      }
    }
    int i4 = 1;
    if (i1 == i4)
    {
      localObject1 = this$0.enteredValue.getText().toString();
      i4 = ((String)localObject1).length();
      i5 = 13;
      if (i4 <= i5)
      {
        localObject1 = this$0.enteredValue.getText().toString();
        i4 = ((String)localObject1).length();
        i5 = 5;
        if (i4 < i5) {}
      }
    }
    else
    {
      label876:
      i4 = 2;
      if (i1 == i4)
      {
        localObject1 = this$0.enteredValue.getText().toString();
        i4 = ((String)localObject1).length();
        i5 = 12;
        if (i4 == i5) {
          break label1142;
        }
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localObject1 = ((StringBuilder)localObject1).append(str2);
        localObject2 = this$0.getResources();
        i6 = 2131034275;
        localObject2 = ((Resources)localObject2).getString(i6);
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(" ");
        localObject2 = this$0.enteredValue.getHint();
        localObject1 = ((StringBuilder)localObject1).append(localObject2);
        localObject2 = "\n";
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
        str2 = ((StringBuilder)localObject1).toString();
      }
    }
    for (;;)
    {
      localObject1 = new in/gov/mgov/helper/Helper;
      localObject2 = this$0;
      ((Helper)localObject1).<init>((Context)localObject2);
      ((Helper)localObject1).showDialogonclick(str2);
      break;
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject1 = ((StringBuilder)localObject1).append(str2);
      localObject2 = this$0.getResources();
      i6 = 2131034275;
      localObject2 = ((Resources)localObject2).getString(i6);
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(" ");
      localObject2 = this$0.enteredValue.getHint();
      localObject1 = ((StringBuilder)localObject1).append(localObject2);
      localObject2 = "\n";
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
      str2 = ((StringBuilder)localObject1).toString();
      break label876;
      label1142:
      localObject1 = this$0.enteredValue.getText().toString();
      i4 = ((String)localObject1).length();
      i5 = 12;
      if (i4 == i5)
      {
        new Verhoeff();
        localObject1 = this$0.enteredValue.getText().toString();
        boolean bool3 = Verhoeff.validateVerhoeff((String)localObject1);
        if (!bool3)
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          localObject1 = ((StringBuilder)localObject1).append(str2);
          localObject2 = this$0.getResources();
          i6 = 2131034277;
          localObject2 = ((Resources)localObject2).getString(i6);
          localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append(" ");
          localObject2 = this$0.enteredValue.getHint();
          localObject1 = ((StringBuilder)localObject1).append(localObject2);
          localObject2 = "\n";
          localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
          str2 = ((StringBuilder)localObject1).toString();
        }
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment_1$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */