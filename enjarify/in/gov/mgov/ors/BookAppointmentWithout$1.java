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
import android.widget.TextView;

class BookAppointmentWithout$1
  implements AdapterView.OnItemSelectedListener
{
  BookAppointmentWithout$1(BookAppointmentWithout paramBookAppointmentWithout) {}
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 2130903050;
    int j = 1;
    int k = 8;
    Object localObject1 = this$0.state[paramInt];
    Object localObject2 = "Select";
    boolean bool = ((String)localObject1).contains((CharSequence)localObject2);
    Object localObject3;
    if (!bool)
    {
      localObject1 = this$0;
      bool = ((BookAppointmentWithout)localObject1).isConnected();
      if (bool)
      {
        localObject1 = new in/gov/mgov/ors/BookAppointmentWithout$CallList;
        localObject2 = this$0;
        k = 0;
        ((BookAppointmentWithout.CallList)localObject1).<init>((BookAppointmentWithout)localObject2, null);
        int m = 2;
        localObject2 = new String[m];
        localObject2[0] = "getHospitallist";
        localObject3 = Integer.toString(paramInt);
        localObject2[j] = localObject3;
        ((BookAppointmentWithout.CallList)localObject1).execute((Object[])localObject2);
      }
    }
    for (;;)
    {
      return;
      this$0.hospitalname.setText("");
      this$0.cancel.setVisibility(k);
      this$0.proceed.setVisibility(k);
      this$0.yes.setVisibility(k);
      this$0.next.setVisibility(k);
      localObject1 = this$0.mhospital;
      localObject2 = new android/widget/ArrayAdapter;
      localObject3 = this$0.getApplicationContext();
      String[] arrayOfString = new String[j];
      Object localObject4 = this$0.getResources().getString(2131034307);
      arrayOfString[0] = localObject4;
      ((ArrayAdapter)localObject2).<init>((Context)localObject3, i, arrayOfString);
      ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
      localObject1 = this$0.mdepartment;
      localObject2 = new android/widget/ArrayAdapter;
      localObject3 = this$0.getApplicationContext();
      arrayOfString = new String[j];
      localObject4 = this$0.getResources();
      int n = 2131034303;
      localObject4 = ((Resources)localObject4).getString(n);
      arrayOfString[0] = localObject4;
      ((ArrayAdapter)localObject2).<init>((Context)localObject3, i, arrayOfString);
      ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
    }
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointmentWithout$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */