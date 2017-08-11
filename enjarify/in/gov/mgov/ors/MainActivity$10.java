package in.gov.mgov.ors;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

class MainActivity$10
  implements TextWatcher
{
  MainActivity$10(MainActivity paramMainActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = paramEditable.length();
    int j = 5;
    Button localButton;
    if (i == j)
    {
      localButton = this$0.proceed_name_otp;
      j = 1;
      localButton.setEnabled(j);
    }
    for (;;)
    {
      return;
      localButton = this$0.proceed_name_otp;
      int k = 0;
      localButton.setEnabled(false);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$10.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */