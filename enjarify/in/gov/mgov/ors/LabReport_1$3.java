package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;

class LabReport_1$3
  implements View.OnClickListener
{
  LabReport_1$3(LabReport_1 paramLabReport_1) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new android/content/Intent;
    Object localObject1 = this$0;
    Object localObject2 = LabReport_2.class;
    localIntent.<init>((Context)localObject1, (Class)localObject2);
    localObject1 = this$0.spinner_select_hospital;
    int i = ((Spinner)localObject1).getSelectedItemPosition();
    int m;
    if (i != 0)
    {
      localObject1 = this$0.edittext_uhid.getText();
      i = ((Editable)localObject1).length();
      int k = 5;
      if (i >= k)
      {
        localObject1 = this$0.edittext_uhid.getText();
        i = ((Editable)localObject1).length();
        k = 13;
        if (i <= k)
        {
          localObject1 = this$0;
          boolean bool = ((LabReport_1)localObject1).isConnected();
          if (bool)
          {
            localObject1 = this$0;
            localObject2 = this$0.hospitalid;
            m = this$0.spinner_select_hospital.getSelectedItemPosition();
            localObject2 = localObject2[m];
            hospitalcode = ((String)localObject2);
            localObject1 = new in/gov/mgov/ors/LabReport_1$CallList;
            localObject2 = this$0;
            ((LabReport_1.CallList)localObject1).<init>((LabReport_1)localObject2, null);
            k = 1;
            localObject2 = new String[k];
            m = 0;
            String str = "getLabbasicreportlist";
            localObject2[0] = str;
            ((LabReport_1.CallList)localObject1).execute((Object[])localObject2);
          }
        }
      }
    }
    for (;;)
    {
      return;
      localObject1 = this$0.edittext_uhid.getText();
      int j = ((Editable)localObject1).length();
      if (j == 0)
      {
        localObject1 = this$0;
        localObject2 = this$0.getResources();
        m = 2131034192;
        localObject2 = ((Resources)localObject2).getString(m);
        LabReport_1.access$100((LabReport_1)localObject1, (String)localObject2);
      }
      else
      {
        localObject1 = this$0;
        localObject2 = this$0.getResources();
        m = 2131034187;
        localObject2 = ((Resources)localObject2).getString(m);
        LabReport_1.access$100((LabReport_1)localObject1, (String)localObject2);
        continue;
        localObject1 = this$0;
        localObject2 = this$0.getResources();
        m = 2131034299;
        localObject2 = ((Resources)localObject2).getString(m);
        LabReport_1.access$100((LabReport_1)localObject1, (String)localObject2);
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReport_1$3.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */