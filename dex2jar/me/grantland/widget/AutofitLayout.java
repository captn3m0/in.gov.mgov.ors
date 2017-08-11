package me.grantland.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import in.gov.mgov.ors.R.styleable;
import java.util.WeakHashMap;

public class AutofitLayout
  extends FrameLayout
{
  private boolean mEnabled;
  private WeakHashMap<View, AutofitHelper> mHelpers = new WeakHashMap();
  private float mMinTextSize;
  private float mPrecision;
  
  public AutofitLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null, 0);
  }
  
  public AutofitLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet, 0);
  }
  
  public AutofitLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    boolean bool = true;
    int i = -1;
    float f = -1.0F;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AutofitTextView, paramInt, 0);
      bool = paramContext.getBoolean(2, true);
      i = paramContext.getDimensionPixelSize(0, -1);
      f = paramContext.getFloat(1, -1.0F);
      paramContext.recycle();
    }
    mEnabled = bool;
    mMinTextSize = i;
    mPrecision = f;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    paramView = (TextView)paramView;
    paramLayoutParams = AutofitHelper.create(paramView).setEnabled(mEnabled);
    if (mPrecision > 0.0F) {
      paramLayoutParams.setPrecision(mPrecision);
    }
    if (mMinTextSize > 0.0F) {
      paramLayoutParams.setMinTextSize(0, mMinTextSize);
    }
    mHelpers.put(paramView, paramLayoutParams);
  }
  
  public AutofitHelper getAutofitHelper(int paramInt)
  {
    return (AutofitHelper)mHelpers.get(getChildAt(paramInt));
  }
  
  public AutofitHelper getAutofitHelper(TextView paramTextView)
  {
    return (AutofitHelper)mHelpers.get(paramTextView);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/me/grantland/widget/AutofitLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */