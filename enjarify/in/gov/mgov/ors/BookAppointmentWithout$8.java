package in.gov.mgov.ors;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import java.util.ArrayList;
import java.util.List;

class BookAppointmentWithout$8
  implements View.OnClickListener
{
  BookAppointmentWithout$8(BookAppointmentWithout paramBookAppointmentWithout) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0;
    Object localObject2 = this$0.getResources();
    int i = 2131034141;
    localObject2 = ((Resources)localObject2).getString(i);
    BookAppointmentWithout.access$100((BookAppointmentWithout)localObject1, (String)localObject2);
    localObject1 = this$0;
    int j = x + 1;
    x = j;
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    localObject1 = this$0.getResources().getString(2131034139);
    localArrayList.add(localObject1);
    localObject1 = this$0;
    int k = x;
    localObject2 = this$0;
    j = limit;
    int m = k * j;
    localObject1 = this$0;
    k = x + 1;
    localObject2 = this$0;
    j = limit;
    k *= j;
    if (m < k)
    {
      localObject1 = this$0.datelist;
      k = ((List)localObject1).size();
      if (k > m)
      {
        localObject1 = this$0.datelist.get(m);
        localArrayList.add(localObject1);
      }
      for (;;)
      {
        m += 1;
        break;
        localObject1 = this$0;
        j = -1;
        x = j;
      }
    }
    localObject2 = this$0;
    localObject1 = new String[localArrayList.size()];
    localObject1 = (String[])localArrayList.toArray((Object[])localObject1);
    date = ((String[])localObject1);
    localObject1 = this$0.mdate;
    localObject2 = new android/widget/ArrayAdapter;
    Context localContext = this$0.getApplicationContext();
    String[] arrayOfString = this$0.date;
    ((ArrayAdapter)localObject2).<init>(localContext, 2130903050, arrayOfString);
    ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BookAppointmentWithout$8.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */