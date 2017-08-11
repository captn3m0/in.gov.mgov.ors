package in.gov.mgov.ors;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

class EnterAadhaar$1
  implements TextWatcher
{
  EnterAadhaar$1(EnterAadhaar paramEnterAadhaar) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = 2130837541;
    int j = 2130837536;
    int k = 16;
    int m = paramEditable.length();
    int i1 = 12;
    Object localObject1;
    Object localObject2;
    int n;
    if (m == i1)
    {
      localObject1 = this$0;
      localObject2 = paramEditable.toString();
      boolean bool = EnterAadhaar.access$000((EnterAadhaar)localObject1, (String)localObject2);
      if (bool)
      {
        localObject1 = this$0.submit;
        i1 = 1;
        ((Button)localObject1).setEnabled(i1);
        localObject1 = this$0;
        n = sdk;
        if (n > k)
        {
          localObject1 = this$0.submit;
          localObject2 = this$0.getResources().getDrawable(j);
          ((Button)localObject1).setBackground((Drawable)localObject2);
        }
      }
    }
    for (;;)
    {
      return;
      localObject1 = this$0.submit;
      localObject2 = this$0.getResources().getDrawable(j);
      ((Button)localObject1).setBackgroundDrawable((Drawable)localObject2);
      continue;
      localObject1 = this$0;
      localObject2 = this$0.getResources();
      k = 2131034338;
      localObject2 = ((Resources)localObject2).getString(k);
      EnterAadhaar.access$100((EnterAadhaar)localObject1, (String)localObject2);
      continue;
      localObject1 = this$0.submit;
      int i2 = 0;
      localObject2 = null;
      ((Button)localObject1).setEnabled(false);
      localObject1 = this$0;
      n = sdk;
      if (n > k)
      {
        localObject1 = this$0.submit;
        localObject2 = this$0.getResources().getDrawable(i);
        ((Button)localObject1).setBackground((Drawable)localObject2);
      }
      else
      {
        localObject1 = this$0.submit;
        localObject2 = this$0.getResources().getDrawable(i);
        ((Button)localObject1).setBackgroundDrawable((Drawable)localObject2);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/EnterAadhaar$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */