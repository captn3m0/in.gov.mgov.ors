package me.grantland.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class AutofitTextView
  extends TextView
  implements AutofitHelper.OnTextSizeChangeListener
{
  private AutofitHelper mHelper;
  
  public AutofitTextView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null, 0);
  }
  
  public AutofitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet, 0);
  }
  
  public AutofitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AutofitHelper localAutofitHelper = AutofitHelper.create(this, paramAttributeSet, paramInt).addOnTextSizeChangeListener(this);
    mHelper = localAutofitHelper;
  }
  
  public AutofitHelper getAutofitHelper()
  {
    return mHelper;
  }
  
  public float getMaxTextSize()
  {
    return mHelper.getMaxTextSize();
  }
  
  public float getMinTextSize()
  {
    return mHelper.getMinTextSize();
  }
  
  public float getPrecision()
  {
    return mHelper.getPrecision();
  }
  
  public boolean isSizeToFit()
  {
    return mHelper.isEnabled();
  }
  
  public void onTextSizeChange(float paramFloat1, float paramFloat2) {}
  
  public void setLines(int paramInt)
  {
    super.setLines(paramInt);
    AutofitHelper localAutofitHelper = mHelper;
    if (localAutofitHelper != null)
    {
      localAutofitHelper = mHelper;
      localAutofitHelper.setMaxLines(paramInt);
    }
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    AutofitHelper localAutofitHelper = mHelper;
    if (localAutofitHelper != null)
    {
      localAutofitHelper = mHelper;
      localAutofitHelper.setMaxLines(paramInt);
    }
  }
  
  public void setMaxTextSize(float paramFloat)
  {
    mHelper.setMaxTextSize(paramFloat);
  }
  
  public void setMaxTextSize(int paramInt, float paramFloat)
  {
    mHelper.setMaxTextSize(paramInt, paramFloat);
  }
  
  public void setMinTextSize(int paramInt)
  {
    AutofitHelper localAutofitHelper = mHelper;
    float f = paramInt;
    localAutofitHelper.setMinTextSize(2, f);
  }
  
  public void setMinTextSize(int paramInt, float paramFloat)
  {
    mHelper.setMinTextSize(paramInt, paramFloat);
  }
  
  public void setPrecision(float paramFloat)
  {
    mHelper.setPrecision(paramFloat);
  }
  
  public void setSizeToFit()
  {
    setSizeToFit(true);
  }
  
  public void setSizeToFit(boolean paramBoolean)
  {
    mHelper.setEnabled(paramBoolean);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    AutofitHelper localAutofitHelper = mHelper;
    if (localAutofitHelper != null)
    {
      localAutofitHelper = mHelper;
      localAutofitHelper.setTextSize(paramInt, paramFloat);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/me/grantland/widget/AutofitTextView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */