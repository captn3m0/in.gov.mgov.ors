package in.gov.mgov.ors;

import android.content.res.Resources;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;

class CancelAppointment_1$1
  implements AdapterView.OnItemSelectedListener
{
  CancelAppointment_1$1(CancelAppointment_1 paramCancelAppointment_1) {}
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 13;
    int j = 1;
    String str = this$0.search_criteria.getSelectedItem().toString();
    Object localObject1 = this$0.getResources();
    int k = 2131034153;
    localObject1 = ((Resources)localObject1).getString(k);
    boolean bool = str.equals(localObject1);
    Object localObject2;
    int m;
    InputFilter.LengthFilter localLengthFilter;
    if (bool)
    {
      this$0.enteredValue.setText("");
      localObject1 = this$0.enteredValue;
      localObject2 = this$0.getResources();
      m = 2131034136;
      localObject2 = ((Resources)localObject2).getString(m);
      ((EditText)localObject1).setHint((CharSequence)localObject2);
      localObject1 = this$0.enteredValue;
      localObject2 = new InputFilter[j];
      localLengthFilter = new android/text/InputFilter$LengthFilter;
      localLengthFilter.<init>(i);
      localObject2[0] = localLengthFilter;
      ((EditText)localObject1).setFilters((InputFilter[])localObject2);
    }
    for (;;)
    {
      return;
      localObject1 = this$0.getResources();
      k = 2131034155;
      localObject1 = ((Resources)localObject1).getString(k);
      bool = str.equals(localObject1);
      if (bool)
      {
        this$0.enteredValue.setText("");
        localObject1 = this$0.enteredValue;
        localObject2 = this$0.getResources();
        m = 2131034330;
        localObject2 = ((Resources)localObject2).getString(m);
        ((EditText)localObject1).setHint((CharSequence)localObject2);
        localObject1 = this$0.enteredValue;
        localObject2 = new InputFilter[j];
        localLengthFilter = new android/text/InputFilter$LengthFilter;
        localLengthFilter.<init>(i);
        localObject2[0] = localLengthFilter;
        ((EditText)localObject1).setFilters((InputFilter[])localObject2);
      }
      else
      {
        localObject1 = this$0.getResources();
        k = 2131034152;
        localObject1 = ((Resources)localObject1).getString(k);
        bool = str.equals(localObject1);
        if (bool)
        {
          this$0.enteredValue.setText("");
          localObject1 = this$0.enteredValue;
          localObject2 = this$0.getResources();
          m = 2131034326;
          localObject2 = ((Resources)localObject2).getString(m);
          ((EditText)localObject1).setHint((CharSequence)localObject2);
          localObject1 = this$0.enteredValue;
          localObject2 = new InputFilter[j];
          localLengthFilter = new android/text/InputFilter$LengthFilter;
          j = 12;
          localLengthFilter.<init>(j);
          localObject2[0] = localLengthFilter;
          ((EditText)localObject1).setFilters((InputFilter[])localObject2);
        }
        else
        {
          localObject1 = this$0.getResources();
          k = 2131034154;
          localObject1 = ((Resources)localObject1).getString(k);
          bool = str.equals(localObject1);
          if (bool)
          {
            this$0.enteredValue.setText("");
            localObject1 = this$0.enteredValue;
            localObject2 = this$0.getResources();
            m = 2131034321;
            localObject2 = ((Resources)localObject2).getString(m);
            ((EditText)localObject1).setHint((CharSequence)localObject2);
            localObject1 = this$0.enteredValue;
            localObject2 = new InputFilter[j];
            localLengthFilter = new android/text/InputFilter$LengthFilter;
            j = 10;
            localLengthFilter.<init>(j);
            localObject2[0] = localLengthFilter;
            ((EditText)localObject1).setFilters((InputFilter[])localObject2);
          }
          else
          {
            localObject1 = this$0.enteredValue;
            localObject2 = "";
            ((EditText)localObject1).setHint((CharSequence)localObject2);
          }
        }
      }
    }
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/CancelAppointment_1$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */