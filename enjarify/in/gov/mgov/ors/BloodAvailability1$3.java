package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class BloodAvailability1$3
  implements AdapterView.OnItemClickListener
{
  BloodAvailability1$3(BloodAvailability1 paramBloodAvailability1) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new android/content/Intent;
    Context localContext = this$0.getBaseContext();
    localIntent.<init>(localContext, BloodAvailability2.class);
    String str = this$0.stringarray_bbaddress[paramInt];
    localIntent.putExtra("bbaddress", str);
    str = this$0.stringarray_bbname[paramInt];
    localIntent.putExtra("bbname", str);
    str = this$0.stringarray_bbemail[paramInt];
    localIntent.putExtra("bbemail", str);
    str = this$0.stringarray_bbstateid[paramInt];
    localIntent.putExtra("bbstateid", str);
    str = this$0.stringarray_bbstatename[paramInt];
    localIntent.putExtra("bbstatename", str);
    str = this$0.stringarray_bbid[paramInt];
    localIntent.putExtra("bbid", str);
    str = this$0.stringarray_bbdistname[paramInt];
    localIntent.putExtra("bbdistname", str);
    str = this$0.stringarray_bblandno[paramInt];
    localIntent.putExtra("bblandno", str);
    str = this$0.stringarray_bbdistid[paramInt];
    localIntent.putExtra("bbdistid", str);
    str = this$0.stringarray_bbmoicname[paramInt];
    localIntent.putExtra("bbmoicname", str);
    this$0.startActivity(localIntent);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/BloodAvailability1$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */