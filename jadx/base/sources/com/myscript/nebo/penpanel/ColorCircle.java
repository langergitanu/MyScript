package com.myscript.nebo.penpanel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.myscript.android.utils.ColorExt;
import com.myscript.nebo.common.C6183R;

/* JADX INFO: loaded from: classes7.dex */
public class ColorCircle extends View {
    private static final int ALPHA_MAX = 255;
    private static final int ANGLE_180 = 180;
    private static final int ANGLE_360 = 360;
    private static final int ANGLE_90 = 90;
    private static final float ANGLE_OFFSET = 0.0f;
    private static final int THUMB_ANIM_DURATION = 100;
    private static final int THUMB_COLLAPSE_DELAY = 750;
    private static final int TOOLTIP_ANIM_DURATION = 150;
    private int mAlpha;
    private ValueAnimator mAnimator;
    private Paint mArcPaint;
    private RectF mArcRect;
    private float mArcThickness;
    private Paint mClearPaint;
    private ColorCircleListener mColorListener;
    private int[] mColors;
    private int mDarkForegroundColor;
    private boolean mDownInside;
    private int mFontSize;
    private float mHue;
    private int mInitialColor;
    private int mInset;
    private Paint mInsidePaintLeft;
    private Paint mInsidePaintRight;
    private RectF mInsideRect;
    private int mLightForegroundColor;
    private float mRadius;
    private int mResetButtonSize;
    private float mRippleRadius;
    private RectF mRippleRect;
    private float mSaturation;
    private boolean mShowText;
    private SweepGradient mSweepGradient;
    private Rect mTempRect;
    private TextPaint mTextPaint;
    private Paint mThumbPaint;
    private float mThumbRadius;
    private float mThumbRadiusMax;
    private RectF mThumbRect;
    private float mThumbThickness;
    private float mThumbX;
    private float mThumbY;
    private Handler mTimerHandler;
    private Runnable mTimerRunnable;
    private int mToolTipHeight;
    private Rect mToolTipRect;
    private int mToolTipWidth;
    private int mTooltipMaxHeight;
    private int mTooltipMaxWidth;
    private float mValue;

    interface ColorCircleListener {
        void hueChanged(float f);

        void resetColor();
    }

    public ColorCircle(Context context) {
        super(context);
        this.mAlpha = 255;
        this.mRippleRadius = 0.0f;
        this.mThumbThickness = 3.0f;
        this.mToolTipWidth = 0;
        this.mToolTipHeight = 0;
        init();
    }

    public ColorCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAlpha = 255;
        this.mRippleRadius = 0.0f;
        this.mThumbThickness = 3.0f;
        this.mToolTipWidth = 0;
        this.mToolTipHeight = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6693R.styleable.ColorCircle, 0, 0);
        this.mRadius = typedArrayObtainStyledAttributes.getDimension(C6693R.styleable.ColorCircle_circle_radius, 0.0f);
        this.mArcThickness = typedArrayObtainStyledAttributes.getDimension(C6693R.styleable.ColorCircle_circle_thickness, 0.0f);
        this.mTooltipMaxWidth = context.getResources().getDimensionPixelSize(C6693R.dimen.cp_tooltip_width);
        this.mTooltipMaxHeight = context.getResources().getDimensionPixelSize(C6693R.dimen.cp_tooltip_height);
        this.mToolTipWidth = this.mTooltipMaxWidth;
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6693R.styleable.ColorCircle_thumb_radius, 0);
        this.mThumbRadiusMax = dimensionPixelSize;
        this.mThumbRadius = dimensionPixelSize;
        this.mFontSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6693R.styleable.ColorCircle_font_size, 20);
        this.mInset = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6693R.styleable.ColorCircle_inset, 36);
        this.mResetButtonSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6693R.styleable.ColorCircle_reset_button_width, 0);
        this.mLightForegroundColor = typedArrayObtainStyledAttributes.getColor(C6693R.styleable.ColorCircle_foreground_color_light, -1);
        this.mDarkForegroundColor = typedArrayObtainStyledAttributes.getColor(C6693R.styleable.ColorCircle_foreground_color_dark, -16777216);
        init();
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(C6693R.styleable.ColorCircle_circle_enabled, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void init() {
        this.mAnimator = new ValueAnimator();
        float f = this.mRadius;
        setLayoutParams(new ViewGroup.LayoutParams(((int) f) * 2, ((int) f) * 2));
        this.mSaturation = 1.0f;
        this.mValue = 1.0f;
        Paint paint = new Paint();
        this.mArcPaint = paint;
        paint.setAntiAlias(true);
        this.mArcPaint.setStyle(Paint.Style.STROKE);
        this.mArcPaint.setStrokeWidth(this.mArcThickness);
        Paint paint2 = new Paint();
        this.mThumbPaint = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mThumbPaint.setStrokeWidth(this.mThumbThickness);
        this.mThumbPaint.setAntiAlias(true);
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(this.mFontSize);
        Paint paint3 = new Paint();
        this.mInsidePaintRight = paint3;
        paint3.setAntiAlias(true);
        this.mInsidePaintRight.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mInsidePaintRight.setStrokeWidth(0.25f);
        Paint paint4 = new Paint();
        this.mInsidePaintLeft = paint4;
        paint4.setAntiAlias(true);
        this.mInsidePaintLeft.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mInsidePaintLeft.setStrokeWidth(0.25f);
        Paint paint5 = new Paint();
        this.mClearPaint = paint5;
        paint5.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mClearPaint.setStrokeWidth(this.mThumbThickness);
        this.mClearPaint.setColor(-1);
        this.mClearPaint.setAntiAlias(true);
        this.mThumbRect = new RectF();
        this.mArcRect = new RectF();
        this.mInsideRect = new RectF();
        this.mRippleRect = new RectF();
        this.mToolTipRect = new Rect();
        this.mTempRect = new Rect();
        initColorsForGradient();
        this.mTimerHandler = new Handler();
        this.mTimerRunnable = new Runnable() { // from class: com.myscript.nebo.penpanel.ColorCircle$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$init$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0() {
        animateToolTip(false);
        this.mShowText = false;
        this.mTimerHandler.removeCallbacks(this.mTimerRunnable);
    }

    private void initColorsForGradient() {
        this.mColors = new int[13];
        float[] fArr = new float[3];
        fArr[1] = 1.0f;
        fArr[2] = 1.0f;
        for (int i = 0; i < 12; i++) {
            fArr[0] = (i % 12) * 30.0f;
            this.mColors[12 - i] = Color.HSVToColor(this.mAlpha, fArr);
        }
        int[] iArr = this.mColors;
        iArr[0] = iArr[12];
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        this.mAlpha = (int) (f * 255.0f);
        invalidate();
    }

    public void setColorListener(ColorCircleListener colorCircleListener) {
        this.mColorListener = colorCircleListener;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int i = z ? 255 : 127;
        this.mAlpha = i;
        this.mThumbPaint.setAlpha(i);
        initColorsForGradient();
        invalidate();
    }

    private void thumbMoved(float f, float f2) {
        int iConvertPointToAngle = convertPointToAngle(f, f2);
        updateThumbPosition(f, f2);
        if (this.mColorListener != null) {
            float f3 = iConvertPointToAngle;
            this.mThumbPaint.setColor(Color.HSVToColor(this.mAlpha, new float[]{f3, 1.0f, 1.0f}));
            this.mInsidePaintRight.setColor(Color.HSVToColor(new float[]{f3, this.mSaturation, this.mValue}));
            this.mColorListener.hueChanged(f3);
        }
        invalidate(this.mToolTipRect);
    }

    private boolean isInInsideCircle(float f, float f2) {
        float fWidth = this.mInsideRect.width() / 2.0f;
        float fAbs = Math.abs(f - this.mInsideRect.centerX());
        float fAbs2 = Math.abs(f2 - this.mInsideRect.centerY());
        return fAbs <= fWidth && fAbs2 <= fWidth && (fAbs + fAbs2 <= fWidth || Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d) <= Math.pow((double) fWidth, 2.0d));
    }

    public void setColorLeft(int i) {
        updateCurrentHSV(i);
        this.mInsidePaintLeft.setAlpha(this.mAlpha);
        this.mInsidePaintLeft.setColor(i);
        this.mThumbPaint.setAlpha(this.mAlpha);
        invalidate();
    }

    public void setColorRight(int i) {
        updateCurrentHSV(i);
        this.mInsidePaintRight.setColor(i);
        invalidate();
    }

    public void setThumbColor(int i) {
        this.mThumbPaint.setColor(Color.HSVToColor(new float[]{i, 1.0f, 1.0f}));
        this.mThumbPaint.setAlpha(this.mAlpha);
        invalidate();
    }

    private int convertPointToAngle(float f, float f2) {
        return (int) convertPointToFloatAngle(f, f2);
    }

    private float convertPointToFloatAngle(float f, float f2) {
        double degrees = Math.toDegrees(Math.atan2(f2 - (getMeasuredHeight() / 2.0f), f - (getMeasuredWidth() / 2.0f)));
        double dCos = degrees + (Math.cos(Math.toRadians(degrees)) * 12.0d);
        return (float) (dCos < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? -dCos : 360.0d - dCos);
    }

    private void updateCurrentHSV(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        this.mHue = fArr[0];
        this.mSaturation = fArr[1];
        this.mValue = fArr[2];
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        float f = this.mRadius;
        int i3 = ((int) f) * 2;
        int i4 = ((int) f) * 2;
        float paddingTop = (((i3 / 2.0f) + getPaddingTop()) - this.mRadius) + (this.mArcThickness / 2.0f) + this.mThumbRadiusMax;
        float paddingLeft = (((i4 / 2.0f) + getPaddingLeft()) - this.mRadius) + (this.mArcThickness / 2.0f) + this.mThumbRadiusMax;
        int paddingBottom = i3 + getPaddingBottom() + getPaddingTop();
        int paddingRight = i4 + getPaddingRight() + getPaddingLeft();
        float f2 = this.mArcThickness;
        float f3 = this.mThumbRadiusMax;
        int i5 = (int) (paddingBottom + f2 + (f3 * 2.0f));
        int i6 = (int) (paddingRight + f2 + (f3 * 2.0f));
        RectF rectF = this.mArcRect;
        float f4 = this.mRadius;
        rectF.set(paddingLeft, paddingTop, (f4 * 2.0f) + paddingLeft, (f4 * 2.0f) + paddingTop);
        setMeasuredDimension(i6, i5 + getPaddingBottom());
        updateThumbPosition(this.mHue);
        this.mSweepGradient = new SweepGradient(getMeasuredWidth() / 2, getMeasuredHeight() / 2, this.mColors, (float[]) null);
    }

    private void updateThumbPosition(float f, float f2) {
        updateThumbPosition(convertPointToFloatAngle(f, f2));
    }

    private void updateThumbPosition() {
        RectF rectF = this.mThumbRect;
        float f = this.mThumbX;
        float f2 = this.mThumbRadius;
        float f3 = this.mThumbY;
        rectF.set(f - f2, f3 - f2, f + f2, f3 + f2);
        RectF rectF2 = this.mRippleRect;
        float f4 = this.mThumbX;
        float f5 = this.mRippleRadius;
        float f6 = this.mThumbY;
        rectF2.set(f4 - f5, f6 - f5, f4 + f5, f6 + f5);
        Rect rect = this.mToolTipRect;
        float f7 = this.mThumbX;
        int i = this.mToolTipWidth;
        float f8 = this.mThumbY;
        rect.set((int) (f7 - (i / 2.0f)), (int) (f8 - this.mToolTipHeight), (int) (f7 + (i / 2.0f)), (int) f8);
        invalidate();
    }

    private void updateThumbPosition(float f) {
        double d = 360.0f - f;
        this.mThumbX = (float) (((double) this.mArcRect.centerX()) + (((double) this.mRadius) * Math.cos(Math.toRadians(d))));
        float fCenterY = (float) (((double) this.mArcRect.centerY()) + (((double) this.mRadius) * Math.sin(Math.toRadians(d))));
        this.mThumbY = fCenterY;
        RectF rectF = this.mThumbRect;
        float f2 = this.mThumbX;
        float f3 = this.mThumbRadius;
        rectF.set(f2 - f3, fCenterY - f3, f2 + f3, fCenterY + f3);
        RectF rectF2 = this.mRippleRect;
        float f4 = this.mThumbX;
        float f5 = this.mRippleRadius;
        float f6 = this.mThumbY;
        rectF2.set(f4 - f5, f6 - f5, f4 + f5, f6 + f5);
        Rect rect = this.mToolTipRect;
        float f7 = this.mThumbX;
        int i = this.mToolTipWidth;
        float f8 = this.mThumbY;
        rect.set((int) (f7 - (i / 2.0f)), (int) (f8 - this.mToolTipHeight), (int) (f7 + (i / 2.0f)), (int) f8);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mArcPaint.setShader(this.mSweepGradient);
        canvas.drawArc(this.mArcRect, 0.0f, 360.0f, true, this.mArcPaint);
        this.mInsideRect.set(this.mArcRect);
        RectF rectF = this.mInsideRect;
        int i = this.mInset;
        rectF.inset(i, i);
        canvas.drawArc(this.mInsideRect, -90.0f, 360.0f, true, this.mInsidePaintRight);
        canvas.drawArc(this.mInsideRect, 90.0f, 180.0f, true, this.mInsidePaintLeft);
        if (this.mAlpha != 255) {
            canvas.drawArc(this.mThumbRect, 0.0f, 360.0f, true, this.mClearPaint);
        }
        if (this.mThumbRect.width() > 0.0f) {
            canvas.drawArc(this.mThumbRect, 0.0f, 360.0f, true, this.mThumbPaint);
        }
        Resources resources = getResources();
        Resources.Theme theme = getContext().getTheme();
        Drawable drawable = ResourcesCompat.getDrawable(resources, C6183R.drawable.ic_undo, theme);
        drawable.setTint(((Integer) ColorExt.getBrightnessAwareValue(this.mInsidePaintLeft.getColor(), Integer.valueOf(this.mLightForegroundColor), Integer.valueOf(this.mDarkForegroundColor))).intValue());
        drawable.setAlpha(this.mAlpha);
        int i2 = this.mResetButtonSize;
        int iWidth = (int) ((this.mInsideRect.left + (this.mInsideRect.width() / 4.0f)) - (i2 / 2));
        int iHeight = (int) (this.mInsideRect.top + ((this.mInsideRect.height() - i2) / 2.0f));
        drawable.setBounds(iWidth, iHeight, iWidth + i2, i2 + iHeight);
        drawable.draw(canvas);
        if (!isEnabled() || this.mToolTipWidth == 0 || this.mToolTipHeight == 0) {
            return;
        }
        canvas.getClipBounds(this.mTempRect);
        this.mTempRect.inset(-this.mToolTipWidth, -this.mToolTipHeight);
        canvas.save();
        canvas.clipRect(this.mTempRect, Region.Op.INTERSECT);
        Drawable drawable2 = ResourcesCompat.getDrawable(resources, C6693R.drawable.ic_color_tooltip, theme);
        drawable2.setColorFilter(this.mThumbPaint.getColor(), PorterDuff.Mode.SRC_ATOP);
        drawable2.setAlpha(this.mAlpha);
        drawable2.setBounds((int) (this.mThumbRect.centerX() - (this.mToolTipWidth / 2.0f)), (int) (this.mThumbRect.centerY() - this.mToolTipHeight), (int) (this.mThumbRect.centerX() + (this.mToolTipWidth / 2.0f)), (int) this.mThumbRect.centerY());
        drawable2.draw(canvas);
        if (this.mShowText) {
            int iCenterY = (int) (this.mToolTipRect.centerY() - (this.mTextPaint.descent() / 2.0f));
            this.mTextPaint.setColor(getForegroundColorForPill(getContext(), this.mThumbPaint.getColor()));
            canvas.drawText(Integer.toString(convertPointToAngle(this.mThumbX, this.mThumbY)), this.mToolTipRect.centerX(), iCenterY, this.mTextPaint);
        }
        canvas.restore();
    }

    @Deprecated
    static int getForegroundColorForPill(Context context, int i) {
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        return ((Integer) ColorExt.getBrightnessAwareValue(i, Integer.valueOf(ResourcesCompat.getColor(resources, C6693R.color.darkColorForeground, theme)), Integer.valueOf(ResourcesCompat.getColor(resources, C6693R.color.lightColorForeground, theme)))).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (!this.mDownInside) {
                    this.mTimerHandler.postDelayed(this.mTimerRunnable, 750L);
                    thumbMoved(x, y);
                }
                if (isInInsideCircle(x, y) && x <= this.mInsideRect.centerX() && this.mDownInside) {
                    this.mColorListener.resetColor();
                }
                this.mDownInside = false;
            } else if (action != 2) {
                if (action == 6) {
                }
            } else if (!this.mDownInside) {
                thumbMoved(x, y);
            }
        } else if (isInInsideCircle(x, y)) {
            this.mDownInside = true;
        } else {
            this.mShowText = true;
            animateToolTip(true);
            this.mTimerHandler.removeCallbacks(this.mTimerRunnable);
            thumbMoved(x, y);
        }
        return true;
    }

    private void expandThumb(float f, float f2) {
        this.mAnimator.cancel();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.mAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(100L);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.myscript.nebo.penpanel.ColorCircle$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$expandThumb$1(valueAnimator);
            }
        });
        this.mAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$expandThumb$1(ValueAnimator valueAnimator) {
        this.mThumbRadius = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
        updateThumbPosition();
    }

    private void animateToolTip(boolean z) {
        int i = z ? 0 : this.mTooltipMaxHeight;
        int i2 = z ? this.mTooltipMaxHeight : 0;
        if (this.mToolTipHeight == i2) {
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.setDuration(150L);
        valueAnimatorOfInt.removeAllUpdateListeners();
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.myscript.nebo.penpanel.ColorCircle$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$animateToolTip$2(valueAnimator);
            }
        });
        valueAnimatorOfInt.start();
        expandThumb(z ? (int) this.mThumbRadiusMax : 0, z ? 0 : (int) this.mThumbRadiusMax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateToolTip$2(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.mToolTipHeight = iIntValue;
        this.mToolTipWidth = (iIntValue * this.mTooltipMaxWidth) / this.mTooltipMaxHeight;
        updateThumbPosition();
    }

    public void setCurrentHue(int i) {
        updateThumbPosition(i);
    }
}
