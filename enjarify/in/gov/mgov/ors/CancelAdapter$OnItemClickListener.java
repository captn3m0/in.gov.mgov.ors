package in.gov.mgov.ors;

import android.view.View;
import android.view.View.OnClickListener;

class CancelAdapter$OnItemClickListener
  implements View.OnClickListener
{
  private int mPosition;
  
  CancelAdapter$OnItemClickListener(CancelAdapter paramCancelAdapter, int paramInt)
  {
    mPosition = paramInt;
  }
  
  public void onClick(View paramView)
  {
    CancelAppointment2 localCancelAppointment2 = (CancelAppointment2)CancelAdapter.access$000(this$0);
    int i = mPosition;
    localCancelAppointment2.onItemClick(i);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAdapter$OnItemClickListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */