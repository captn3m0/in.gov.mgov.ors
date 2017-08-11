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
  private WeakHashMap mHelpers;
  private float mMinTextSize;
  private float mPrecision;
  
  public AutofitLayout(Context paramContext)
  {
    super(paramContext);
    WeakHashMap localWeakHashMap = new java/util/WeakHashMap;
    localWeakHashMap.<init>();
    mHelpers = localWeakHashMap;
    init(paramContext, null, 0);
  }
  
  public AutofitLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    WeakHashMap localWeakHashMap = new java/util/WeakHashMap;
    localWeakHashMap.<init>();
    mHelpers = localWeakHashMap;
    init(paramContext, paramAttributeSet, 0);
  }
  
  public AutofitLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    WeakHashMap localWeakHashMap = new java/util/WeakHashMap;
    localWeakHashMap.<init>();
    mHelpers = localWeakHashMap;
    init(paramContext, paramAttributeSet, paramInt);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    boolean bool = true;
    int i = -1;
    float f1 = -1.0F;
    if (paramAttributeSet != null)
    {
      int[] arrayOfInt = R.styleable.AutofitTextView;
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, paramInt, 0);
      bool = localTypedArray.getBoolean(2, bool);
      i = localTypedArray.getDimensionPixelSize(0, i);
      int j = 1;
      f2 = Float.MIN_VALUE;
      f1 = localTypedArray.getFloat(j, f1);
      localTypedArray.recycle();
    }
    mEnabled = bool;
    float f2 = i;
    mMinTextSize = f2;
    mPrecision = f1;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    Object localObject = paramView;
    localObject = (TextView)paramView;
    AutofitHelper localAutofitHelper1 = AutofitHelper.create((TextView)localObject);
    boolean bool1 = mEnabled;
    AutofitHelper localAutofitHelper2 = localAutofitHelper1.setEnabled(bool1);
    float f1 = mPrecision;
    boolean bool2 = f1 < 0.0F;
    if (bool2)
    {
      f1 = mPrecision;
      localAutofitHelper2.setPrecision(f1);
    }
    f1 = mMinTextSize;
    bool2 = f1 < 0.0F;
    if (bool2)
    {
      bool2 = false;
      f1 = 0.0F;
      localAutofitHelper1 = null;
      float f2 = mMinTextSize;
      localAutofitHelper2.setMinTextSize(0, f2);
    }
    mHelpers.put(localObject, localAutofitHelper2);
  }
  
  public AutofitHelper getAutofitHelper(int paramInt)
  {
    WeakHashMap localWeakHashMap = mHelpers;
    View localView = getChildAt(paramInt);
    return (AutofitHelper)localWeakHashMap.get(localView);
  }
  
  public AutofitHelper getAutofitHelper(TextView paramTextView)
  {
    return (AutofitHelper)mHelpers.get(paramTextView);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/me/grantland/widget/AutofitLayout.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */