package in.gov.mgov.ors;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

class BloodAvailability1$2
  implements AdapterView.OnItemSelectedListener
{
  BloodAvailability1$2(BloodAvailability1 paramBloodAvailability1) {}
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 2131034146;
    int j = 8;
    Object localObject1 = this$0;
    Object localObject2 = paramAdapterView.getItemAtPosition(paramInt).toString();
    selectedstate = ((String)localObject2);
    int k;
    if (paramInt != 0)
    {
      localObject1 = this$0.title;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      String str = this$0.getResources().getString(i);
      localObject2 = ((StringBuilder)localObject2).append(str).append("- ");
      str = this$0.selectedstate;
      localObject2 = str;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = this$0.selectstate_linearlayout;
      localObject2 = "#eeeeee";
      k = Color.parseColor((String)localObject2);
      ((LinearLayout)localObject1).setBackgroundColor(k);
      this$0.listview_hospital.setVisibility(0);
      this$0.textview_bloodbanktitle.setVisibility(0);
      BloodAvailability1.selected_state_id_from_spinner = this$0.stateid[paramInt];
      localObject1 = this$0;
      BloodAvailability1.access$100((BloodAvailability1)localObject1);
    }
    for (;;)
    {
      return;
      if (paramInt == 0)
      {
        localObject1 = this$0.title;
        localObject2 = this$0.getResources().getString(i);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        localObject1 = this$0.selectstate_linearlayout;
        localObject2 = "#ffffff";
        k = Color.parseColor((String)localObject2);
        ((LinearLayout)localObject1).setBackgroundColor(k);
        this$0.listview_hospital.setVisibility(j);
        localObject1 = this$0.textview_bloodbanktitle;
        ((TextView)localObject1).setVisibility(j);
      }
    }
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BloodAvailability1$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */