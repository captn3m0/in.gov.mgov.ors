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
    ArrayList localArrayList = data;
    int j = localArrayList.size();
    if (j <= 0) {}
    for (j = 1;; j = localArrayList.size())
    {
      return j;
      localArrayList = data;
    }
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
    View localView = paramView;
    Object localObject;
    LabReportDetailsAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localObject = inflater;
      int j = 2130903058;
      localView = ((LayoutInflater)localObject).inflate(j, null);
      localViewHolder = new in/gov/mgov/ors/LabReportDetailsAdapter$ViewHolder;
      localViewHolder.<init>();
      localObject = (TextView)localView.findViewById(2131296429);
      test_name = ((TextView)localObject);
      localObject = (TextView)localView.findViewById(2131296430);
      observation_result = ((TextView)localObject);
      int k = 2131296431;
      localObject = (TextView)localView.findViewById(k);
      normal_range = ((TextView)localObject);
      localView.setTag(localViewHolder);
      localObject = data;
      k = ((ArrayList)localObject).size();
      if (k > 0) {
        break label155;
      }
      localObject = test_name;
      j = 2131034249;
      ((TextView)localObject).setText(j);
    }
    for (;;)
    {
      return localView;
      localViewHolder = (LabReportDetailsAdapter.ViewHolder)paramView.getTag();
      break;
      label155:
      tempValues = null;
      localObject = (LabReportDetailsRowModel)data.get(paramInt);
      tempValues = ((LabReportDetailsRowModel)localObject);
      localObject = test_name;
      String str = tempValues.gettest_name();
      ((TextView)localObject).setText(str);
      localObject = observation_result;
      str = tempValues.getobservation_result();
      ((TextView)localObject).setText(str);
      localObject = normal_range;
      str = tempValues.getnormal_range();
      ((TextView)localObject).setText(str);
      localObject = new in/gov/mgov/ors/LabReportDetailsAdapter$OnItemClickListener;
      ((LabReportDetailsAdapter.OnItemClickListener)localObject).<init>(this, paramInt);
      localView.setOnClickListener((View.OnClickListener)localObject);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReportDetailsAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */