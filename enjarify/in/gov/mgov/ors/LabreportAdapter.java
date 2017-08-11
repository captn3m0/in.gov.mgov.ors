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
    LabreportAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localObject = inflater;
      int j = 2130903057;
      localView = ((LayoutInflater)localObject).inflate(j, null);
      localViewHolder = new in/gov/mgov/ors/LabreportAdapter$ViewHolder;
      localViewHolder.<init>();
      localObject = (TextView)localView.findViewById(2131296262);
      date = ((TextView)localObject);
      localObject = (TextView)localView.findViewById(2131296428);
      sample_no = ((TextView)localObject);
      localObject = (TextView)localView.findViewById(2131296426);
      test = ((TextView)localObject);
      int k = 2131296427;
      localObject = (TextView)localView.findViewById(k);
      type = ((TextView)localObject);
      localView.setTag(localViewHolder);
      localObject = data;
      k = ((ArrayList)localObject).size();
      if (k > 0) {
        break label174;
      }
      localObject = date;
      j = 2131034249;
      ((TextView)localObject).setText(j);
    }
    for (;;)
    {
      return localView;
      localViewHolder = (LabreportAdapter.ViewHolder)paramView.getTag();
      break;
      label174:
      tempValues = null;
      localObject = (LabReportRowModel)data.get(paramInt);
      tempValues = ((LabReportRowModel)localObject);
      localObject = date;
      String str = tempValues.getdate();
      ((TextView)localObject).setText(str);
      localObject = sample_no;
      str = tempValues.getsample_no();
      ((TextView)localObject).setText(str);
      localObject = test;
      str = tempValues.gettest();
      ((TextView)localObject).setText(str);
      localObject = type;
      str = tempValues.gettype();
      ((TextView)localObject).setText(str);
      localObject = new in/gov/mgov/ors/LabreportAdapter$OnItemClickListener;
      ((LabreportAdapter.OnItemClickListener)localObject).<init>(this, paramInt);
      localView.setOnClickListener((View.OnClickListener)localObject);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabreportAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */