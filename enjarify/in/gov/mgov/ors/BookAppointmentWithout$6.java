package in.gov.mgov.ors;

import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Spinner;

class BookAppointmentWithout$6
  implements View.OnClickListener
{
  BookAppointmentWithout$6(BookAppointmentWithout paramBookAppointmentWithout) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0.mdate.getSelectedItem().toString();
    Object localObject2 = "Available";
    boolean bool = ((String)localObject1).contains((CharSequence)localObject2);
    int j;
    if (!bool)
    {
      this$0.editor.putString("state_name", "");
      localObject1 = this$0.editor;
      String str1 = this$0.DepartmentnameString;
      ((SharedPreferences.Editor)localObject1).putString("dept_name", str1);
      localObject1 = this$0.editor;
      str1 = this$0.hospitalnameString;
      ((SharedPreferences.Editor)localObject1).putString("hospital_name", str1);
      localObject1 = this$0.editor;
      str1 = this$0.dateString;
      ((SharedPreferences.Editor)localObject1).putString("date_name", str1);
      localObject1 = this$0.editor;
      str1 = Integer.toString(this$0.departmentcode);
      ((SharedPreferences.Editor)localObject1).putString("dept_code", str1);
      localObject1 = this$0.editor;
      str1 = Integer.toString(this$0.hospitalcode);
      ((SharedPreferences.Editor)localObject1).putString("hospital_code", str1);
      localObject1 = this$0.editor;
      str1 = Integer.toString(this$0.statecode);
      ((SharedPreferences.Editor)localObject1).putString("state_code", str1);
      this$0.editor.commit();
      this$0.spacialitymessage = "";
      localObject1 = new in/gov/mgov/ors/BookAppointmentWithout$CallList;
      localObject2 = this$0;
      ((BookAppointmentWithout.CallList)localObject1).<init>((BookAppointmentWithout)localObject2, null);
      int i = 2;
      localObject2 = new String[i];
      str1 = null;
      localObject2[0] = "getSuperSpacialityMsg";
      j = 1;
      int k = this$0.departmentcode;
      String str2 = Integer.toString(k);
      localObject2[j] = str2;
      ((BookAppointmentWithout.CallList)localObject1).execute((Object[])localObject2);
    }
    for (;;)
    {
      return;
      localObject1 = this$0;
      localObject2 = this$0.getResources();
      j = 2131034178;
      localObject2 = ((Resources)localObject2).getString(j);
      BookAppointmentWithout.access$100((BookAppointmentWithout)localObject1, (String)localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointmentWithout$6.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */