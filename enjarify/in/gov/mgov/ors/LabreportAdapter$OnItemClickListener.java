package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;

class LabreportAdapter$OnItemClickListener
  implements View.OnClickListener
{
  private int mPosition;
  
  LabreportAdapter$OnItemClickListener(LabreportAdapter paramLabreportAdapter, int paramInt)
  {
    mPosition = paramInt;
  }
  
  public void onClick(View paramView)
  {
    LabReport_3 localLabReport_3 = (LabReport_3)LabreportAdapter.access$000(this$0);
    int i = mPosition;
    localLabReport_3.onItemClick(i);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabreportAdapter$OnItemClickListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */