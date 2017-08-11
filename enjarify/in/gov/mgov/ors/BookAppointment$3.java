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

class BookAppointment$3
  implements AdapterView.OnItemSelectedListener
{
  BookAppointment$3(BookAppointment paramBookAppointment) {}
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    int j = 8;
    Object localObject1;
    if (paramInt != 0)
    {
      localObject1 = this$0;
      Object localObject2 = this$0.department[paramInt];
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
      j = Integer.parseInt((String)localObject2);
      departmentcode = j;
      this$0.x = 0;
      localObject1 = this$0;
      boolean bool = ((BookAppointment)localObject1).isConnected();
      if (bool)
      {
        localObject1 = new in/gov/mgov/ors/BookAppointment$CallList;
        localObject2 = this$0;
        ((BookAppointment.CallList)localObject1).<init>((BookAppointment)localObject2, null);
        j = 2;
        localObject2 = new String[j];
        localObject2[0] = "getAvailabledatelist";
        localObject3 = Integer.toString(paramInt);
        localObject2[i] = localObject3;
        ((BookAppointment.CallList)localObject1).execute((Object[])localObject2);
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointment$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */