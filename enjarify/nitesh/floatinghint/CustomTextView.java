package nitesh.floatinghint;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
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
    Spanned localSpanned = Html.fromHtml((String)paramCharSequence);
    super.setText(localSpanned, paramBufferType);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/nitesh/floatinghint/CustomTextView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */