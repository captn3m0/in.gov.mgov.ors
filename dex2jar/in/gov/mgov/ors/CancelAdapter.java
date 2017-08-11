package in.gov.mgov.ors;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CancelAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static LayoutInflater inflater = null;
  private Activity activity;
  private ArrayList data;
  int i = 0;
  public Resources res;
  CancelRowModel tempValues = null;
  
  public CancelAdapter(Activity paramActivity, ArrayList paramArrayList, Resources paramResources)
  {
    activity = paramActivity;
    data = paramArrayList;
    res = paramResources;
    inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
  }
  
  public int getCount()
  {
    if (data.size() <= 0) {
      return 1;
    }
    return data.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = inflater.inflate(2130903049, null);
      paramView = new ViewHolder();
      apptdate = ((TextView)paramViewGroup.findViewById(2131296380));
      department = ((TextView)paramViewGroup.findViewById(2131296381));
      hospital = ((TextView)paramViewGroup.findViewById(2131296332));
      status = ((TextView)paramViewGroup.findViewById(2131296382));
      paramViewGroup.setTag(paramView);
    }
    while (data.size() <= 0)
    {
      apptdate.setText(2131034249);
      return paramViewGroup;
      paramView = (ViewHolder)paramViewGroup.getTag();
    }
    tempValues = null;
    tempValues = ((CancelRowModel)data.get(paramInt));
    apptdate.setText(tempValues.getAppt_date());
    department.setText(tempValues.getdepartment());
    hospital.setText(tempValues.gethospital());
    status.setText(tempValues.getStatus());
    paramViewGroup.setOnClickListener(new OnItemClickListener(paramInt));
    return paramViewGroup;
  }
  
  public void onClick(View paramView) {}
  
  private class OnItemClickListener
    implements View.OnClickListener
  {
    private int mPosition;
    
    OnItemClickListener(int paramInt)
    {
      mPosition = paramInt;
    }
    
    public void onClick(View paramView)
    {
      ((CancelAppointment2)activity).onItemClick(mPosition);
    }
  }
  
  public static class ViewHolder
  {
    public TextView apptdate;
    public TextView department;
    public TextView hospital;
    public TextView status;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/CancelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */