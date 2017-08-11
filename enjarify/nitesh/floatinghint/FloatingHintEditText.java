package nitesh.floatinghint;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.EditText;

public class FloatingHintEditText
  extends EditText
{
  private FloatingHintEditText.Animation mAnimation;
  private int mAnimationFrame;
  private final int mAnimationSteps;
  private final Paint mFloatingHintPaint;
  private final ColorStateList mHintColors;
  private final float mHintScale;
  private boolean mWasEmpty;
  
  public FloatingHintEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatingHintEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130771968);
  }
  
  public FloatingHintEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = new android/graphics/Paint;
    ((Paint)localObject).<init>();
    mFloatingHintPaint = ((Paint)localObject);
    localObject = FloatingHintEditText.Animation.NONE;
    mAnimation = ((FloatingHintEditText.Animation)localObject);
    TypedValue localTypedValue = new android/util/TypedValue;
    localTypedValue.<init>();
    getResources().getValue(2131230721, localTypedValue, true);
    float f = localTypedValue.getFloat();
    mHintScale = f;
    int i = getResources().getInteger(2131230720);
    mAnimationSteps = i;
    localObject = getHintTextColors();
    mHintColors = ((ColorStateList)localObject);
    boolean bool = TextUtils.isEmpty(getText());
    mWasEmpty = bool;
  }
  
  private void drawAnimationFrame(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    float f1 = lerp(paramFloat1, paramFloat2);
    float f2 = lerp(paramFloat4, paramFloat5);
    mFloatingHintPaint.setTextSize(f1);
    String str = getHint().toString();
    Paint localPaint = mFloatingHintPaint;
    paramCanvas.drawText(str, paramFloat3, f2, localPaint);
  }
  
  private float lerp(float paramFloat1, float paramFloat2)
  {
    float f1 = mAnimationFrame;
    float f2 = mAnimationSteps + -1;
    float f3 = f1 / f2;
    f1 = (1.0F - f3) * paramFloat1;
    f2 = paramFloat2 * f3;
    return f1 + f2;
  }
  
  public int getCompoundPaddingTop()
  {
    Paint.FontMetricsInt localFontMetricsInt = getPaint().getFontMetricsInt();
    int i = bottom;
    int j = top;
    float f1 = i - j;
    float f2 = mHintScale;
    int k = (int)(f1 * f2);
    return super.getCompoundPaddingTop() + k;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = getHint();
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    if (bool) {
      return;
    }
    localObject1 = mAnimation;
    Object localObject2 = FloatingHintEditText.Animation.NONE;
    if (localObject1 != localObject2) {}
    Object localObject3;
    Object localObject4;
    int m;
    int i;
    float f1;
    float f2;
    float f3;
    float f5;
    float f6;
    float f7;
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        localObject1 = getText();
        bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (bool) {
          break;
        }
      }
      localObject1 = mFloatingHintPaint;
      localObject2 = getPaint();
      ((Paint)localObject1).set((Paint)localObject2);
      localObject1 = mFloatingHintPaint;
      localObject2 = mHintColors;
      localObject3 = getDrawableState();
      localObject4 = mHintColors;
      int k = ((ColorStateList)localObject4).getDefaultColor();
      m = ((ColorStateList)localObject2).getColorForState((int[])localObject3, k);
      ((Paint)localObject1).setColor(m);
      i = getCompoundPaddingLeft();
      m = getScrollX();
      f1 = i + m;
      f2 = getBaseline();
      localObject1 = getPaint().getFontMetricsInt();
      i = top;
      f3 = i + f2;
      m = getScrollY();
      float f4 = m;
      f5 = f3 + f4;
      f6 = getTextSize();
      f3 = mHintScale;
      f7 = f6 * f3;
      if (j != 0) {
        break label254;
      }
      mFloatingHintPaint.setTextSize(f7);
      localObject1 = getHint().toString();
      localObject2 = mFloatingHintPaint;
      paramCanvas.drawText((String)localObject1, f1, f5, (Paint)localObject2);
      break;
    }
    label254:
    localObject1 = mAnimation;
    localObject2 = FloatingHintEditText.Animation.SHRINK;
    if (localObject1 == localObject2)
    {
      localObject1 = this;
      localObject2 = paramCanvas;
      drawAnimationFrame(paramCanvas, f6, f7, f1, f2, f5);
    }
    for (;;)
    {
      i = mAnimationFrame + 1;
      mAnimationFrame = i;
      i = mAnimationFrame;
      m = mAnimationSteps;
      if (i == m)
      {
        localObject1 = mAnimation;
        localObject2 = FloatingHintEditText.Animation.GROW;
        if (localObject1 == localObject2)
        {
          localObject1 = mHintColors;
          setHintTextColor((ColorStateList)localObject1);
        }
        localObject1 = FloatingHintEditText.Animation.NONE;
        mAnimation = ((FloatingHintEditText.Animation)localObject1);
        i = 0;
        f3 = 0.0F;
        localObject1 = null;
        mAnimationFrame = 0;
      }
      invalidate();
      break;
      localObject3 = this;
      localObject4 = paramCanvas;
      drawAnimationFrame(paramCanvas, f7, f6, f1, f5, f2);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    Object localObject = getText();
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject);
    boolean bool2 = mWasEmpty;
    if (bool2 == bool1) {}
    for (;;)
    {
      return;
      mWasEmpty = bool1;
      bool2 = isShown();
      if (bool2) {
        if (bool1)
        {
          localObject = FloatingHintEditText.Animation.GROW;
          mAnimation = ((FloatingHintEditText.Animation)localObject);
          bool2 = false;
          localObject = null;
          setHintTextColor(0);
        }
        else
        {
          localObject = FloatingHintEditText.Animation.SHRINK;
          mAnimation = ((FloatingHintEditText.Animation)localObject);
        }
      }
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/nitesh/floatinghint/FloatingHintEditText.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */