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

public class LabreportAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static LayoutInflater inflater = null;
  private Activity activity;
  private ArrayList data;
  int i = 0;
  public Resources res;
  LabReportRowModel tempValues = null;
  
  public LabreportAdapter(Activity paramActivity, ArrayList paramArrayList, Resources paramResources)
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
      paramViewGroup = inflater.inflate(2130903057, null);
      paramView = new ViewHolder();
      date = ((TextView)paramViewGroup.findViewById(2131296262));
      sample_no = ((TextView)paramViewGroup.findViewById(2131296428));
      test = ((TextView)paramViewGroup.findViewById(2131296426));
      type = ((TextView)paramViewGroup.findViewById(2131296427));
      paramViewGroup.setTag(paramView);
    }
    while (data.size() <= 0)
    {
      date.setText(2131034249);
      return paramViewGroup;
      paramView = (ViewHolder)paramViewGroup.getTag();
    }
    tempValues = null;
    tempValues = ((LabReportRowModel)data.get(paramInt));
    date.setText(tempValues.getdate());
    sample_no.setText(tempValues.getsample_no());
    test.setText(tempValues.gettest());
    type.setText(tempValues.gettype());
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
      ((LabReport_3)activity).onItemClick(mPosition);
    }
  }
  
  public static class ViewHolder
  {
    public TextView date;
    public TextView sample_no;
    public TextView test;
    public TextView type;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/LabreportAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */