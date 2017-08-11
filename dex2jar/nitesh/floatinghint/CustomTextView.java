package nitesh.floatinghint;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class CustomTextView
  extends TextView
{
  public CustomTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(Html.fromHtml((String)paramCharSequence), paramBufferType);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/nitesh/floatinghint/CustomTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */