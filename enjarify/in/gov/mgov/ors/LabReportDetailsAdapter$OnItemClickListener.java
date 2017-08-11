package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;

class LabReportDetailsAdapter$OnItemClickListener
  implements View.OnClickListener
{
  private int mPosition;
  
  LabReportDetailsAdapter$OnItemClickListener(LabReportDetailsAdapter paramLabReportDetailsAdapter, int paramInt)
  {
    mPosition = paramInt;
  }
  
  public void onClick(View paramView)
  {
    LabReport_4 localLabReport_4 = (LabReport_4)LabReportDetailsAdapter.access$000(this$0);
    int i = mPosition;
    localLabReport_4.onItemClick(i);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReportDetailsAdapter$OnItemClickListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */