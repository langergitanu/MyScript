package com.myscript.nebo.penpanel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes7.dex */
public class ColorSeekBar extends AppCompatSeekBar {
    private static final int ANGLE_360 = 360;
    private static final int ANGLE_90 = 90;
    private static final int RIPPLE_DURATION = 150;
    private static final int THUMB_ANIM_DURATION = 100;
    private ValueAnimator mAnimator;
    private Paint mClearPaint;
    private int mEndColor;
    private int mFontSize;
    private LinearGradient mProgressGradient;
    private Paint mProgressPaint;
    private RectF mProgressRect;
    private float mProgressThickness;
    private boolean mShowText;
    private int mStartColor;
    private TextPaint mTextPaint;
    private Paint mThumbPaint;
    private float mThumbRadius;
    private int mThumbRadiusMax;
    private RectF mThumbRect;
    private Handler mTimerHandler;
    private Runnable mTimerRunnable;
    private int mToolTipHeight;
    private int mToolTipMaxHeight;
    private int mToolTipMaxWidth;
    private Rect mToolTipRect;
    private int mToolTipWidth;

    public ColorSeekBar(Context context, int i, int i2, boolean z) {
        super(context);
        this.mToolTipHeight = 0;
        this.mToolTipWidth = 0;
        this.mStartColor = i;
        this.mEndColor = i2;
        init();
    }

    public ColorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mToolTipHeight = 0;
        this.mToolTipWidth = 0;
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6693R.styleable.ColorSeekBar, 0, 0);
        try {
            this.mStartColor = typedArrayObtainStyledAttributes.getColor(C6693R.styleable.ColorSeekBar_gradient_color_left, -16777216);
            this.mProgressThickness = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6693R.styleable.ColorSeekBar_progress_thickness, 5);
            this.mThumbRadiusMax = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6693R.styleable.ColorSeekBar_seekbar_thumb_radius, 7);
            this.mFontSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6693R.styleable.ColorSeekBar_sb_font_size, 20);
            boolean z = typedArrayObtainStyledAttributes.getBoolean(C6693R.styleable.ColorSeekBar_sb_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
            this.mThumbRadius = this.mThumbRadiusMax;
            this.mToolTipMaxWidth = resources.getDimensionPixelSize(C6693R.dimen.cp_tooltip_width);
            this.mToolTipMaxHeight = resources.getDimensionPixelSize(C6693R.dimen.cp_tooltip_height);
            init();
            setEnabled(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void init() {
        Paint paint = new Paint();
        this.mProgressPaint = paint;
        paint.setAntiAlias(true);
        this.mProgressPaint.setStyle(Paint.Style.FILL);
        this.mProgressPaint.setStrokeWidth(this.mProgressThickness);
        Paint paint2 = new Paint();
        this.mThumbPaint = paint2;
        paint2.setAntiAlias(true);
        this.mThumbPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(this.mFontSize);
        Paint paint3 = new Paint();
        this.mClearPaint = paint3;
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mClearPaint.setColor(-1);
        this.mClearPaint.setAntiAlias(true);
        this.mProgressRect = new RectF();
        this.mThumbRect = new RectF();
        this.mToolTipRect = new Rect();
        setBackground(null);
        this.mAnimator = new ValueAnimator();
        this.mTimerHandler = new Handler();
        this.mTimerRunnable = new Runnable() { // from class: com.myscript.nebo.penpanel.ColorSeekBar$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$init$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0() {
        this.mShowText = false;
        animateToolTip(false);
        this.mTimerHandler.removeCallbacks(this.mTimerRunnable);
    }

    private void initGradient() {
        this.mProgressGradient = new LinearGradient(this.mProgressRect.left, this.mProgressRect.top, this.mProgressRect.right, this.mProgressRect.bottom, new int[]{this.mStartColor, this.mEndColor}, (float[]) null, Shader.TileMode.CLAMP);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) (getPaddingTop() + this.mProgressThickness + getPaddingBottom()));
        float paddingLeft = getPaddingLeft();
        this.mProgressRect.set(paddingLeft, getPaddingTop() - (this.mProgressThickness / 2.0f), ((getMeasuredWidth() - getPaddingLeft()) + paddingLeft) - getPaddingRight(), getPaddingTop() + (this.mProgressThickness / 2.0f));
        initGradient();
        updateThumbPosition();
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas canvas2;
        this.mProgressPaint.setShader(this.mProgressGradient);
        canvas.drawRect(this.mProgressRect, this.mProgressPaint);
        if (isEnabled()) {
            canvas2 = canvas;
        } else {
            canvas2 = canvas;
            canvas2.drawArc(this.mThumbRect, -90.0f, 360.0f, true, this.mClearPaint);
        }
        if (this.mThumbRect.width() > 0.0f) {
            canvas2.drawArc(this.mThumbRect, -90.0f, 360.0f, true, this.mThumbPaint);
        }
        if (this.mToolTipWidth == 0 || this.mToolTipHeight == 0) {
            return;
        }
        Rect clipBounds = canvas2.getClipBounds();
        clipBounds.inset(0, -clipBounds.height());
        clipBounds.union(this.mToolTipRect);
        canvas2.save();
        canvas2.clipRect(clipBounds);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), C6693R.drawable.ic_color_tooltip, getContext().getTheme());
        drawable.setColorFilter(this.mThumbPaint.getColor(), PorterDuff.Mode.SRC_ATOP);
        drawable.setBounds((int) (this.mThumbRect.centerX() - (this.mToolTipWidth / 2.0f)), (int) (this.mThumbRect.centerY() - this.mToolTipHeight), (int) (this.mThumbRect.centerX() + (this.mToolTipWidth / 2.0f)), (int) this.mThumbRect.centerY());
        drawable.draw(canvas2);
        if (this.mShowText) {
            canvas2.drawText(Integer.toString((int) ((getProgress() / 255.0f) * 100.0f)), this.mToolTipRect.centerX(), (int) (this.mToolTipRect.centerY() - (this.mTextPaint.descent() / 2.0f)), this.mTextPaint);
        }
        canvas2.restore();
    }

    private void updateThumbPosition() {
        updateThumbPosition(getProgress());
    }

    private void updateThumbPosition(int i) {
        if (this.mProgressRect == null) {
            return;
        }
        float paddingLeft = getPaddingLeft() + (((this.mProgressRect.width() - (this.mThumbRadius * 2.0f)) * i) / getMax());
        float fCenterY = this.mProgressRect.centerY();
        RectF rectF = this.mThumbRect;
        float f = this.mThumbRadius;
        rectF.set(paddingLeft, fCenterY - f, (2.0f * f) + paddingLeft, fCenterY + f);
        float fCenterX = this.mThumbRect.centerX();
        float fCenterY2 = this.mThumbRect.centerY();
        Rect rect = this.mToolTipRect;
        int i2 = this.mToolTipWidth;
        rect.set((int) (fCenterX - (i2 / 2)), (int) (fCenterY2 - this.mToolTipHeight), (int) (fCenterX + (i2 / 2)), (int) fCenterY2);
        invalidate(this.mToolTipRect);
    }

    public void setThumbColor(int i) {
        this.mThumbPaint.setColor(i);
        this.mTextPaint.setColor(ColorCircle.getForegroundColorForPill(getContext(), this.mThumbPaint.getColor()));
        invalidate();
    }

    public void setStartColor(int i) {
        this.mStartColor = i;
        initGradient();
        invalidate();
    }

    public void setEndColor(int i) {
        this.mEndColor = i;
        initGradient();
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int i = z ? 255 : 128;
        this.mThumbPaint.setAlpha(i);
        this.mProgressPaint.setAlpha(i);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        if (isEnabled()) {
            super.setProgress(i);
            updateThumbPosition(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // android.widget.AbsSeekBar, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            animateToolTip(true);
            this.mTimerHandler.removeCallbacks(this.mTimerRunnable);
            this.mShowText = true;
            updateThumbPosition();
        } else if (action == 1) {
            this.mTimerHandler.postDelayed(this.mTimerRunnable, 750L);
        } else if (action == 2) {
            updateThumbPosition();
        } else if (action == 6) {
        }
        return true;
    }

    private void expandThumb(float f, float f2) {
        this.mAnimator.cancel();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.mAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(100L);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.myscript.nebo.penpanel.ColorSeekBar$$ExternalSyntheticLambda0
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
        int i = z ? 0 : this.mToolTipMaxHeight;
        int i2 = z ? this.mToolTipMaxHeight : 0;
        if (this.mToolTipHeight == i2) {
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.setDuration(150L);
        valueAnimatorOfInt.removeAllUpdateListeners();
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.myscript.nebo.penpanel.ColorSeekBar$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$animateToolTip$2(valueAnimator);
            }
        });
        valueAnimatorOfInt.start();
        expandThumb(z ? this.mThumbRadiusMax : 0, z ? 0 : this.mThumbRadiusMax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateToolTip$2(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.mToolTipHeight = iIntValue;
        this.mToolTipWidth = (iIntValue * this.mToolTipMaxWidth) / this.mToolTipMaxHeight;
        updateThumbPosition();
    }
}
