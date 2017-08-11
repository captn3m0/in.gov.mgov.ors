package in.gov.mgov.ors;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;

class BookAppointment$5
  implements View.OnClickListener
{
  BookAppointment$5(BookAppointment paramBookAppointment) {}
  
  public void onClick(View paramView)
  {
    this$0.editor.putString("state_name", "");
    Object localObject1 = this$0.editor;
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
    localObject1 = new in/gov/mgov/ors/BookAppointment$CallList;
    Object localObject2 = this$0;
    ((BookAppointment.CallList)localObject1).<init>((BookAppointment)localObject2, null);
    localObject2 = new String[2];
    localObject2[0] = "getSuperSpacialityMsg";
    String str2 = Integer.toString(this$0.departmentcode);
    localObject2[1] = str2;
    ((BookAppointment.CallList)localObject1).execute((Object[])localObject2);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointment$5.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */