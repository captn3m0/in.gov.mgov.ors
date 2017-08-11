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

public class LabReportDetailsAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static LayoutInflater inflater = null;
  private Activity activity;
  private ArrayList data;
  int i = 0;
  public Resources res;
  LabReportDetailsRowModel tempValues = null;
  
  public LabReportDetailsAdapter(Activity paramActivity, ArrayList paramArrayList, Resources paramResources)
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
      paramViewGroup = inflater.inflate(2130903058, null);
      paramView = new ViewHolder();
      test_name = ((TextView)paramViewGroup.findViewById(2131296429));
      observation_result = ((TextView)paramViewGroup.findViewById(2131296430));
      normal_range = ((TextView)paramViewGroup.findViewById(2131296431));
      paramViewGroup.setTag(paramView);
    }
    while (data.size() <= 0)
    {
      test_name.setText(2131034249);
      return paramViewGroup;
      paramView = (ViewHolder)paramViewGroup.getTag();
    }
    tempValues = null;
    tempValues = ((LabReportDetailsRowModel)data.get(paramInt));
    test_name.setText(tempValues.gettest_name());
    observation_result.setText(tempValues.getobservation_result());
    normal_range.setText(tempValues.getnormal_range());
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
      ((LabReport_4)activity).onItemClick(mPosition);
    }
  }
  
  public static class ViewHolder
  {
    public TextView normal_range;
    public TextView observation_result;
    public TextView test_name;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/LabReportDetailsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */