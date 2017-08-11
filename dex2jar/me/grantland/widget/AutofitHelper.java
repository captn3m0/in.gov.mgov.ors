package me.grantland.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;
import in.gov.mgov.ors.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;

public class AutofitHelper
{
  private static final int DEFAULT_MIN_TEXT_SIZE = 8;
  private static final float DEFAULT_PRECISION = 0.5F;
  private static final boolean SPEW = false;
  private static final String TAG = "AutoFitTextHelper";
  private boolean mEnabled;
  private boolean mIsAutofitting;
  private ArrayList<OnTextSizeChangeListener> mListeners;
  private int mMaxLines;
  private float mMaxTextSize;
  private float mMinTextSize;
  private View.OnLayoutChangeListener mOnLayoutChangeListener = new AutofitOnLayoutChangeListener(null);
  private TextPaint mPaint;
  private float mPrecision;
  private float mTextSize;
  private TextView mTextView;
  private TextWatcher mTextWatcher = new AutofitTextWatcher(null);
  
  private AutofitHelper(TextView paramTextView)
  {
    float f = getContextgetResourcesgetDisplayMetricsscaledDensity;
    mTextView = paramTextView;
    mPaint = new TextPaint();
    setRawTextSize(paramTextView.getTextSize());
    mMaxLines = getMaxLines(paramTextView);
    mMinTextSize = (8.0F * f);
    mMaxTextSize = mTextSize;
    mPrecision = 0.5F;
  }
  
  private void autofit()
  {
    float f1 = mTextView.getTextSize();
    mIsAutofitting = true;
    autofit(mTextView, mPaint, mMinTextSize, mMaxTextSize, mMaxLines, mPrecision);
    mIsAutofitting = false;
    float f2 = mTextView.getTextSize();
    if (f2 != f1) {
      sendTextSizeChange(f2, f1);
    }
  }
  
  private static void autofit(TextView paramTextView, TextPaint paramTextPaint, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3)
  {
    if ((paramInt <= 0) || (paramInt == Integer.MAX_VALUE)) {}
    int i;
    do
    {
      return;
      i = paramTextView.getWidth() - paramTextView.getPaddingLeft() - paramTextView.getPaddingRight();
    } while (i <= 0);
    Object localObject2 = paramTextView.getText();
    Object localObject3 = paramTextView.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, paramTextView);
    }
    localObject3 = paramTextView.getContext();
    localObject2 = Resources.getSystem();
    float f = paramFloat2;
    if (localObject3 != null) {
      localObject2 = ((Context)localObject3).getResources();
    }
    localObject2 = ((Resources)localObject2).getDisplayMetrics();
    paramTextPaint.set(paramTextView.getPaint());
    paramTextPaint.setTextSize(f);
    if ((paramInt != 1) || (paramTextPaint.measureText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length()) <= i))
    {
      paramFloat2 = f;
      if (getLineCount((CharSequence)localObject1, paramTextPaint, f, i, (DisplayMetrics)localObject2) <= paramInt) {}
    }
    else
    {
      paramFloat2 = getAutofitTextSize((CharSequence)localObject1, paramTextPaint, i, paramInt, 0.0F, f, paramFloat3, (DisplayMetrics)localObject2);
    }
    paramFloat3 = paramFloat2;
    if (paramFloat2 < paramFloat1) {
      paramFloat3 = paramFloat1;
    }
    paramTextView.setTextSize(0, paramFloat3);
  }
  
  public static AutofitHelper create(TextView paramTextView)
  {
    return create(paramTextView, null, 0);
  }
  
  public static AutofitHelper create(TextView paramTextView, AttributeSet paramAttributeSet)
  {
    return create(paramTextView, paramAttributeSet, 0);
  }
  
  public static AutofitHelper create(TextView paramTextView, AttributeSet paramAttributeSet, int paramInt)
  {
    AutofitHelper localAutofitHelper = new AutofitHelper(paramTextView);
    boolean bool = true;
    if (paramAttributeSet != null)
    {
      paramTextView = paramTextView.getContext();
      int i = (int)localAutofitHelper.getMinTextSize();
      float f = localAutofitHelper.getPrecision();
      paramTextView = paramTextView.obtainStyledAttributes(paramAttributeSet, R.styleable.AutofitTextView, paramInt, 0);
      bool = paramTextView.getBoolean(2, true);
      paramInt = paramTextView.getDimensionPixelSize(0, i);
      f = paramTextView.getFloat(1, f);
      paramTextView.recycle();
      localAutofitHelper.setMinTextSize(0, paramInt).setPrecision(f);
    }
    localAutofitHelper.setEnabled(bool);
    return localAutofitHelper;
  }
  
  private static float getAutofitTextSize(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, DisplayMetrics paramDisplayMetrics)
  {
    float f3 = (paramFloat2 + paramFloat3) / 2.0F;
    int i = 1;
    StaticLayout localStaticLayout = null;
    paramTextPaint.setTextSize(TypedValue.applyDimension(0, f3, paramDisplayMetrics));
    if (paramInt != 1)
    {
      localStaticLayout = new StaticLayout(paramCharSequence, paramTextPaint, (int)paramFloat1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      i = localStaticLayout.getLineCount();
    }
    if (i > paramInt) {
      if (paramFloat3 - paramFloat2 >= paramFloat4) {}
    }
    float f1;
    float f2;
    while (paramFloat3 - paramFloat2 < paramFloat4)
    {
      return paramFloat2;
      return getAutofitTextSize(paramCharSequence, paramTextPaint, paramFloat1, paramInt, paramFloat2, f3, paramFloat4, paramDisplayMetrics);
      if (i < paramInt) {
        return getAutofitTextSize(paramCharSequence, paramTextPaint, paramFloat1, paramInt, f3, paramFloat3, paramFloat4, paramDisplayMetrics);
      }
      f1 = 0.0F;
      if (paramInt != 1) {
        break;
      }
      f2 = paramTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
    }
    if (f2 > paramFloat1)
    {
      return getAutofitTextSize(paramCharSequence, paramTextPaint, paramFloat1, paramInt, paramFloat2, f3, paramFloat4, paramDisplayMetrics);
      int j = 0;
      for (;;)
      {
        f2 = f1;
        if (j >= i) {
          break;
        }
        f2 = f1;
        if (localStaticLayout.getLineWidth(j) > f1) {
          f2 = localStaticLayout.getLineWidth(j);
        }
        j += 1;
        f1 = f2;
      }
    }
    if (f2 < paramFloat1) {
      return getAutofitTextSize(paramCharSequence, paramTextPaint, paramFloat1, paramInt, f3, paramFloat3, paramFloat4, paramDisplayMetrics);
    }
    return f3;
  }
  
  private static int getLineCount(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat1, float paramFloat2, DisplayMetrics paramDisplayMetrics)
  {
    paramTextPaint.setTextSize(TypedValue.applyDimension(0, paramFloat1, paramDisplayMetrics));
    return new StaticLayout(paramCharSequence, paramTextPaint, (int)paramFloat2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount();
  }
  
  private static int getMaxLines(TextView paramTextView)
  {
    int i = -1;
    TransformationMethod localTransformationMethod = paramTextView.getTransformationMethod();
    if ((localTransformationMethod != null) && ((localTransformationMethod instanceof SingleLineTransformationMethod))) {
      i = 1;
    }
    while (Build.VERSION.SDK_INT < 16) {
      return i;
    }
    return paramTextView.getMaxLines();
  }
  
  private void sendTextSizeChange(float paramFloat1, float paramFloat2)
  {
    if (mListeners == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = mListeners.iterator();
      while (localIterator.hasNext()) {
        ((OnTextSizeChangeListener)localIterator.next()).onTextSizeChange(paramFloat1, paramFloat2);
      }
    }
  }
  
  private void setRawMaxTextSize(float paramFloat)
  {
    if (paramFloat != mMaxTextSize)
    {
      mMaxTextSize = paramFloat;
      autofit();
    }
  }
  
  private void setRawMinTextSize(float paramFloat)
  {
    if (paramFloat != mMinTextSize)
    {
      mMinTextSize = paramFloat;
      autofit();
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (mTextSize != paramFloat) {
      mTextSize = paramFloat;
    }
  }
  
  public AutofitHelper addOnTextSizeChangeListener(OnTextSizeChangeListener paramOnTextSizeChangeListener)
  {
    if (mListeners == null) {
      mListeners = new ArrayList();
    }
    mListeners.add(paramOnTextSizeChangeListener);
    return this;
  }
  
  public int getMaxLines()
  {
    return mMaxLines;
  }
  
  public float getMaxTextSize()
  {
    return mMaxTextSize;
  }
  
  public float getMinTextSize()
  {
    return mMinTextSize;
  }
  
  public float getPrecision()
  {
    return mPrecision;
  }
  
  public float getTextSize()
  {
    return mTextSize;
  }
  
  public boolean isEnabled()
  {
    return mEnabled;
  }
  
  public AutofitHelper removeOnTextSizeChangeListener(OnTextSizeChangeListener paramOnTextSizeChangeListener)
  {
    if (mListeners != null) {
      mListeners.remove(paramOnTextSizeChangeListener);
    }
    return this;
  }
  
  public AutofitHelper setEnabled(boolean paramBoolean)
  {
    if (mEnabled != paramBoolean)
    {
      mEnabled = paramBoolean;
      if (paramBoolean)
      {
        mTextView.addTextChangedListener(mTextWatcher);
        mTextView.addOnLayoutChangeListener(mOnLayoutChangeListener);
        autofit();
      }
    }
    else
    {
      return this;
    }
    mTextView.removeTextChangedListener(mTextWatcher);
    mTextView.removeOnLayoutChangeListener(mOnLayoutChangeListener);
    mTextView.setTextSize(0, mTextSize);
    return this;
  }
  
  public AutofitHelper setMaxLines(int paramInt)
  {
    if (mMaxLines != paramInt)
    {
      mMaxLines = paramInt;
      autofit();
    }
    return this;
  }
  
  public AutofitHelper setMaxTextSize(float paramFloat)
  {
    return setMaxTextSize(2, paramFloat);
  }
  
  public AutofitHelper setMaxTextSize(int paramInt, float paramFloat)
  {
    Context localContext = mTextView.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    setRawMaxTextSize(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
    return this;
  }
  
  public AutofitHelper setMinTextSize(float paramFloat)
  {
    return setMinTextSize(2, paramFloat);
  }
  
  public AutofitHelper setMinTextSize(int paramInt, float paramFloat)
  {
    Context localContext = mTextView.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    setRawMinTextSize(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
    return this;
  }
  
  public AutofitHelper setPrecision(float paramFloat)
  {
    if (mPrecision != paramFloat)
    {
      mPrecision = paramFloat;
      autofit();
    }
    return this;
  }
  
  public void setTextSize(float paramFloat)
  {
    setTextSize(2, paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (mIsAutofitting) {
      return;
    }
    Context localContext = mTextView.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
  }
  
  private class AutofitOnLayoutChangeListener
    implements View.OnLayoutChangeListener
  {
    private AutofitOnLayoutChangeListener() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AutofitHelper.this.autofit();
    }
  }
  
  private class AutofitTextWatcher
    implements TextWatcher
  {
    private AutofitTextWatcher() {}
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AutofitHelper.this.autofit();
    }
  }
  
  public static abstract interface OnTextSizeChangeListener
  {
    public abstract void onTextSizeChange(float paramFloat1, float paramFloat2);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/me/grantland/widget/AutofitHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */