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
    CancelAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localObject = inflater;
      int j = 2130903049;
      localView = ((LayoutInflater)localObject).inflate(j, null);
      localViewHolder = new in/gov/mgov/ors/CancelAdapter$ViewHolder;
      localViewHolder.<init>();
      localObject = (TextView)localView.findViewById(2131296380);
      apptdate = ((TextView)localObject);
      localObject = (TextView)localView.findViewById(2131296381);
      department = ((TextView)localObject);
      localObject = (TextView)localView.findViewById(2131296332);
      hospital = ((TextView)localObject);
      int k = 2131296382;
      localObject = (TextView)localView.findViewById(k);
      status = ((TextView)localObject);
      localView.setTag(localViewHolder);
      localObject = data;
      k = ((ArrayList)localObject).size();
      if (k > 0) {
        break label174;
      }
      localObject = apptdate;
      j = 2131034249;
      ((TextView)localObject).setText(j);
    }
    for (;;)
    {
      return localView;
      localViewHolder = (CancelAdapter.ViewHolder)paramView.getTag();
      break;
      label174:
      tempValues = null;
      localObject = (CancelRowModel)data.get(paramInt);
      tempValues = ((CancelRowModel)localObject);
      localObject = apptdate;
      String str = tempValues.getAppt_date();
      ((TextView)localObject).setText(str);
      localObject = department;
      str = tempValues.getdepartment();
      ((TextView)localObject).setText(str);
      localObject = hospital;
      str = tempValues.gethospital();
      ((TextView)localObject).setText(str);
      localObject = status;
      str = tempValues.getStatus();
      ((TextView)localObject).setText(str);
      localObject = new in/gov/mgov/ors/CancelAdapter$OnItemClickListener;
      ((CancelAdapter.OnItemClickListener)localObject).<init>(this, paramInt);
      localView.setOnClickListener((View.OnClickListener)localObject);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */