package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;

class ShowUIDAIData$2
  implements View.OnClickListener
{
  ShowUIDAIData$2(ShowUIDAIData paramShowUIDAIData) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0;
    boolean bool = ((ShowUIDAIData)localObject1).isConnected();
    if (bool)
    {
      localObject1 = new in/gov/mgov/ors/ShowUIDAIData$CallList;
      Object localObject2 = this$0;
      ((ShowUIDAIData.CallList)localObject1).<init>((ShowUIDAIData)localObject2, null);
      int i = 1;
      localObject2 = new String[i];
      String str = "fixAppointment";
      localObject2[0] = str;
      ((ShowUIDAIData.CallList)localObject1).execute((Object[])localObject2);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowUIDAIData$2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */