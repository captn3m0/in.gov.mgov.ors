package in.gov.mgov.ors;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import java.util.List;

class BookAppointmentWithout$3
  implements AdapterView.OnItemSelectedListener
{
  BookAppointmentWithout$3(BookAppointmentWithout paramBookAppointmentWithout) {}
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    int j = 8;
    Object localObject1 = this$0.department[paramInt];
    Object localObject2 = "Select";
    boolean bool = ((String)localObject1).contains((CharSequence)localObject2);
    if (!bool)
    {
      localObject1 = this$0;
      localObject2 = this$0.department[paramInt];
      DepartmentnameString = ((String)localObject2);
      this$0.datelist.clear();
      localObject1 = this$0.mdate;
      localObject2 = new android/widget/ArrayAdapter;
      Object localObject3 = this$0.getApplicationContext();
      int k = 2130903050;
      String[] arrayOfString = new String[i];
      Object localObject4 = this$0.getResources();
      int m = 2131034139;
      localObject4 = ((Resources)localObject4).getString(m);
      arrayOfString[0] = localObject4;
      ((ArrayAdapter)localObject2).<init>((Context)localObject3, k, arrayOfString);
      ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
      localObject1 = this$0;
      localObject2 = this$0.departmentid[paramInt];
      int n = Integer.parseInt((String)localObject2);
      departmentcode = n;
      this$0.x = 0;
      localObject1 = this$0;
      bool = ((BookAppointmentWithout)localObject1).isConnected();
      if (bool)
      {
        localObject1 = new in/gov/mgov/ors/BookAppointmentWithout$CallList;
        localObject2 = this$0;
        j = 0;
        ((BookAppointmentWithout.CallList)localObject1).<init>((BookAppointmentWithout)localObject2, null);
        n = 2;
        localObject2 = new String[n];
        localObject2[0] = "getAvailabledatelist";
        localObject3 = Integer.toString(paramInt);
        localObject2[i] = localObject3;
        ((BookAppointmentWithout.CallList)localObject1).execute((Object[])localObject2);
      }
    }
    for (;;)
    {
      return;
      this$0.proceed.setVisibility(j);
      this$0.cancel.setVisibility(j);
      this$0.yes.setVisibility(j);
      this$0.datelist.clear();
      localObject1 = this$0.next;
      ((Button)localObject1).setVisibility(j);
    }
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointmentWithout$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */