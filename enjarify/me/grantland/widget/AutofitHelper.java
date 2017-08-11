package me.grantland.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
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
  private ArrayList mListeners;
  private int mMaxLines;
  private float mMaxTextSize;
  private float mMinTextSize;
  private View.OnLayoutChangeListener mOnLayoutChangeListener;
  private TextPaint mPaint;
  private float mPrecision;
  private float mTextSize;
  private TextView mTextView;
  private TextWatcher mTextWatcher;
  
  private AutofitHelper(TextView paramTextView)
  {
    Object localObject = new me/grantland/widget/AutofitHelper$AutofitTextWatcher;
    ((AutofitHelper.AutofitTextWatcher)localObject).<init>(this, null);
    mTextWatcher = ((TextWatcher)localObject);
    localObject = new me/grantland/widget/AutofitHelper$AutofitOnLayoutChangeListener;
    ((AutofitHelper.AutofitOnLayoutChangeListener)localObject).<init>(this, null);
    mOnLayoutChangeListener = ((View.OnLayoutChangeListener)localObject);
    float f1 = getContextgetResourcesgetDisplayMetricsscaledDensity;
    mTextView = paramTextView;
    localObject = new android/text/TextPaint;
    ((TextPaint)localObject).<init>();
    mPaint = ((TextPaint)localObject);
    float f2 = paramTextView.getTextSize();
    setRawTextSize(f2);
    int i = getMaxLines(paramTextView);
    mMaxLines = i;
    f2 = 8.0F * f1;
    mMinTextSize = f2;
    f2 = mTextSize;
    mMaxTextSize = f2;
    mPrecision = 0.5F;
  }
  
  private void autofit()
  {
    float f1 = mTextView.getTextSize();
    mIsAutofitting = true;
    TextView localTextView = mTextView;
    TextPaint localTextPaint = mPaint;
    float f2 = mMinTextSize;
    float f3 = mMaxTextSize;
    int i = mMaxLines;
    float f4 = mPrecision;
    autofit(localTextView, localTextPaint, f2, f3, i, f4);
    mIsAutofitting = false;
    localTextView = mTextView;
    float f5 = localTextView.getTextSize();
    boolean bool = f5 < f1;
    if (bool) {
      sendTextSizeChange(f5, f1);
    }
  }
  
  private static void autofit(TextView paramTextView, TextPaint paramTextPaint, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3)
  {
    int i;
    float f1;
    if (paramInt > 0)
    {
      i = -1 >>> 1;
      f1 = 0.0F / 0.0F;
      if (paramInt != i) {
        break label23;
      }
    }
    for (;;)
    {
      return;
      label23:
      i = paramTextView.getWidth();
      int k = paramTextView.getPaddingLeft();
      i -= k;
      k = paramTextView.getPaddingRight();
      int m = i - k;
      if (m > 0)
      {
        CharSequence localCharSequence = paramTextView.getText();
        TransformationMethod localTransformationMethod = paramTextView.getTransformationMethod();
        if (localTransformationMethod != null) {
          localCharSequence = localTransformationMethod.getTransformation(localCharSequence, paramTextView);
        }
        Context localContext = paramTextView.getContext();
        Resources localResources = Resources.getSystem();
        float f2 = paramFloat2;
        float f3 = paramFloat2;
        if (localContext != null) {
          localResources = localContext.getResources();
        }
        DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
        TextPaint localTextPaint = paramTextView.getPaint();
        paramTextPaint.set(localTextPaint);
        paramTextPaint.setTextSize(f2);
        i = 1;
        f1 = Float.MIN_VALUE;
        if (paramInt == i)
        {
          localTextPaint = null;
          k = localCharSequence.length();
          f1 = paramTextPaint.measureText(localCharSequence, 0, k);
          f4 = m;
          boolean bool1 = f1 < f4;
          if (bool1) {}
        }
        else
        {
          f1 = m;
          int j = getLineCount(localCharSequence, paramTextPaint, f2, f1, localDisplayMetrics);
          if (j <= paramInt) {
            break label250;
          }
        }
        float f4 = m;
        localTextPaint = paramTextPaint;
        f2 = getAutofitTextSize(localCharSequence, paramTextPaint, f4, paramInt, 0.0F, f3, paramFloat3, localDisplayMetrics);
        label250:
        boolean bool2 = f2 < paramFloat1;
        if (bool2) {
          f2 = paramFloat1;
        }
        bool2 = false;
        f1 = 0.0F;
        localTextPaint = null;
        paramTextView.setTextSize(0, f2);
      }
    }
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
    AutofitHelper localAutofitHelper = new me/grantland/widget/AutofitHelper;
    localAutofitHelper.<init>(paramTextView);
    boolean bool = true;
    if (paramAttributeSet != null)
    {
      Context localContext = paramTextView.getContext();
      int i = (int)localAutofitHelper.getMinTextSize();
      float f1 = localAutofitHelper.getPrecision();
      Object localObject = R.styleable.AutofitTextView;
      TypedArray localTypedArray = localContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
      bool = localTypedArray.getBoolean(2, bool);
      i = localTypedArray.getDimensionPixelSize(0, i);
      int j = 1;
      f1 = localTypedArray.getFloat(j, f1);
      localTypedArray.recycle();
      float f2 = i;
      localObject = localAutofitHelper.setMinTextSize(0, f2);
      ((AutofitHelper)localObject).setPrecision(f1);
    }
    localAutofitHelper.setEnabled(bool);
    return localAutofitHelper;
  }
  
  private static float getAutofitTextSize(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, DisplayMetrics paramDisplayMetrics)
  {
    float f1 = paramFloat2 + paramFloat3;
    int i = 1073741824;
    float f2 = 2.0F;
    float f3 = f1 / f2;
    int j = 1;
    StaticLayout localStaticLayout = null;
    f1 = TypedValue.applyDimension(0, f3, paramDisplayMetrics);
    paramTextPaint.setTextSize(f1);
    int k = 1;
    f1 = Float.MIN_VALUE;
    float f4;
    if (paramInt != k)
    {
      localStaticLayout = new android/text/StaticLayout;
      int n = (int)paramFloat1;
      Layout.Alignment localAlignment = Layout.Alignment.ALIGN_NORMAL;
      f4 = 1.0F;
      boolean bool2 = true;
      localStaticLayout.<init>(paramCharSequence, paramTextPaint, n, localAlignment, f4, 0.0F, bool2);
      j = localStaticLayout.getLineCount();
    }
    int m;
    if (j > paramInt)
    {
      f1 = paramFloat3 - paramFloat2;
      m = f1 < paramFloat4;
      if (m >= 0) {}
    }
    for (;;)
    {
      return paramFloat2;
      f4 = paramFloat2;
      paramFloat2 = getAutofitTextSize(paramCharSequence, paramTextPaint, paramFloat1, paramInt, paramFloat2, f3, paramFloat4, paramDisplayMetrics);
      continue;
      if (j < paramInt)
      {
        f4 = f3;
        paramFloat2 = getAutofitTextSize(paramCharSequence, paramTextPaint, paramFloat1, paramInt, f3, paramFloat3, paramFloat4, paramDisplayMetrics);
      }
      else
      {
        float f5 = 0.0F;
        m = 1;
        f1 = Float.MIN_VALUE;
        if (paramInt == m)
        {
          m = 0;
          f1 = 0.0F;
          i = paramCharSequence.length();
          f5 = paramTextPaint.measureText(paramCharSequence, 0, i);
        }
        for (;;)
        {
          f1 = paramFloat3 - paramFloat2;
          bool1 = f1 < paramFloat4;
          if (bool1) {
            break;
          }
          bool1 = f5 < paramFloat1;
          if (!bool1) {
            break label326;
          }
          f4 = paramFloat2;
          paramFloat2 = getAutofitTextSize(paramCharSequence, paramTextPaint, paramFloat1, paramInt, paramFloat2, f3, paramFloat4, paramDisplayMetrics);
          break;
          int i1 = 0;
          while (i1 < j)
          {
            f1 = localStaticLayout.getLineWidth(i1);
            bool1 = f1 < f5;
            if (bool1) {
              f5 = localStaticLayout.getLineWidth(i1);
            }
            i1 += 1;
          }
        }
        label326:
        boolean bool1 = f5 < paramFloat1;
        if (bool1)
        {
          f4 = f3;
          paramFloat2 = getAutofitTextSize(paramCharSequence, paramTextPaint, paramFloat1, paramInt, f3, paramFloat3, paramFloat4, paramDisplayMetrics);
        }
        else
        {
          paramFloat2 = f3;
        }
      }
    }
  }
  
  private static int getLineCount(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat1, float paramFloat2, DisplayMetrics paramDisplayMetrics)
  {
    float f = TypedValue.applyDimension(0, paramFloat1, paramDisplayMetrics);
    paramTextPaint.setTextSize(f);
    StaticLayout localStaticLayout = new android/text/StaticLayout;
    int i = (int)paramFloat2;
    Layout.Alignment localAlignment = Layout.Alignment.ALIGN_NORMAL;
    localStaticLayout.<init>(paramCharSequence, paramTextPaint, i, localAlignment, 1.0F, 0.0F, true);
    return localStaticLayout.getLineCount();
  }
  
  private static int getMaxLines(TextView paramTextView)
  {
    int i = -1;
    TransformationMethod localTransformationMethod = paramTextView.getTransformationMethod();
    if (localTransformationMethod != null)
    {
      boolean bool = localTransformationMethod instanceof SingleLineTransformationMethod;
      if (bool) {
        i = 1;
      }
    }
    for (;;)
    {
      return i;
      int j = Build.VERSION.SDK_INT;
      int k = 16;
      if (j >= k) {
        i = paramTextView.getMaxLines();
      }
    }
  }
  
  private void sendTextSizeChange(float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = mListeners;
    if (localArrayList == null) {
      return;
    }
    localArrayList = mListeners;
    Iterator localIterator = localArrayList.iterator();
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      if (!bool) {
        break;
      }
      AutofitHelper.OnTextSizeChangeListener localOnTextSizeChangeListener = (AutofitHelper.OnTextSizeChangeListener)localIterator.next();
      localOnTextSizeChangeListener.onTextSizeChange(paramFloat1, paramFloat2);
    }
  }
  
  private void setRawMaxTextSize(float paramFloat)
  {
    float f = mMaxTextSize;
    boolean bool = paramFloat < f;
    if (bool)
    {
      mMaxTextSize = paramFloat;
      autofit();
    }
  }
  
  private void setRawMinTextSize(float paramFloat)
  {
    float f = mMinTextSize;
    boolean bool = paramFloat < f;
    if (bool)
    {
      mMinTextSize = paramFloat;
      autofit();
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    float f = mTextSize;
    boolean bool = f < paramFloat;
    if (bool) {
      mTextSize = paramFloat;
    }
  }
  
  public AutofitHelper addOnTextSizeChangeListener(AutofitHelper.OnTextSizeChangeListener paramOnTextSizeChangeListener)
  {
    ArrayList localArrayList = mListeners;
    if (localArrayList == null)
    {
      localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      mListeners = localArrayList;
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
  
  public AutofitHelper removeOnTextSizeChangeListener(AutofitHelper.OnTextSizeChangeListener paramOnTextSizeChangeListener)
  {
    ArrayList localArrayList = mListeners;
    if (localArrayList != null)
    {
      localArrayList = mListeners;
      localArrayList.remove(paramOnTextSizeChangeListener);
    }
    return this;
  }
  
  public AutofitHelper setEnabled(boolean paramBoolean)
  {
    boolean bool = mEnabled;
    TextView localTextView;
    Object localObject;
    if (bool != paramBoolean)
    {
      mEnabled = paramBoolean;
      if (!paramBoolean) {
        break label59;
      }
      localTextView = mTextView;
      localObject = mTextWatcher;
      localTextView.addTextChangedListener((TextWatcher)localObject);
      localTextView = mTextView;
      localObject = mOnLayoutChangeListener;
      localTextView.addOnLayoutChangeListener((View.OnLayoutChangeListener)localObject);
      autofit();
    }
    for (;;)
    {
      return this;
      label59:
      localTextView = mTextView;
      localObject = mTextWatcher;
      localTextView.removeTextChangedListener((TextWatcher)localObject);
      localTextView = mTextView;
      localObject = mOnLayoutChangeListener;
      localTextView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)localObject);
      localTextView = mTextView;
      localObject = null;
      float f = mTextSize;
      localTextView.setTextSize(0, f);
    }
  }
  
  public AutofitHelper setMaxLines(int paramInt)
  {
    int i = mMaxLines;
    if (i != paramInt)
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
    Object localObject = mTextView;
    Context localContext = ((TextView)localObject).getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    localObject = localResources.getDisplayMetrics();
    float f = TypedValue.applyDimension(paramInt, paramFloat, (DisplayMetrics)localObject);
    setRawMaxTextSize(f);
    return this;
  }
  
  public AutofitHelper setMinTextSize(float paramFloat)
  {
    return setMinTextSize(2, paramFloat);
  }
  
  public AutofitHelper setMinTextSize(int paramInt, float paramFloat)
  {
    Object localObject = mTextView;
    Context localContext = ((TextView)localObject).getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    localObject = localResources.getDisplayMetrics();
    float f = TypedValue.applyDimension(paramInt, paramFloat, (DisplayMetrics)localObject);
    setRawMinTextSize(f);
    return this;
  }
  
  public AutofitHelper setPrecision(float paramFloat)
  {
    float f = mPrecision;
    boolean bool = f < paramFloat;
    if (bool)
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
    boolean bool = mIsAutofitting;
    if (bool) {}
    for (;;)
    {
      return;
      Object localObject = mTextView;
      Context localContext = ((TextView)localObject).getContext();
      Resources localResources = Resources.getSystem();
      if (localContext != null) {
        localResources = localContext.getResources();
      }
      localObject = localResources.getDisplayMetrics();
      float f = TypedValue.applyDimension(paramInt, paramFloat, (DisplayMetrics)localObject);
      setRawTextSize(f);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/me/grantland/widget/AutofitHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */