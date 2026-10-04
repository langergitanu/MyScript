package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOpacity;
import com.samsung.android.spen.C8357R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SPenQTCircleBackgroundView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001'\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\n \u001a*\u0004\u0018\u00010\u00160\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(¨\u0006-"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SPenQTCircleBackgroundView;", "Landroid/view/View;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPaint", "Landroid/graphics/Paint;", "mLeftFadePaint", "mRightFadePaint", "mCenterBgPaint", "mStrokeWidth", "", "mElevationValue", "mShadowColor", "", "mCircleBackgroundColor", "mCircleBgRadius", "mCurrentBgRadius", "mBgRadiusAnimator", "Landroid/animation/ValueAnimator;", "mArchBgRadius", "mCenterRadius", "mInnerBgAnimator", "kotlin.jvm.PlatformType", "Landroid/animation/ValueAnimator;", "mCurrentInnerBgColor", "mDefaultInnerBgColor", "close", "", "initFadePaint", "initBgAnimator", "setOpenModeLayout", "animation", "", "setCloseModeLayout", "mCloseModeLayoutAnimatorListener", "com/samsung/android/sdk/pen/setting/quicktool/SPenQTCircleBackgroundView$mCloseModeLayoutAnimatorListener$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SPenQTCircleBackgroundView$mCloseModeLayoutAnimatorListener$1;", "draw", "canvas", "Landroid/graphics/Canvas;", "Companion", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SPenQTCircleBackgroundView extends View {
    public static final long BG_ALPHA_ANIMATOR_DURATION = 200;
    public static final long BG_CLOSE_ANIMATOR_DURATION = 350;
    public static final long BG_OPEN_ANIMATOR_DURATION = 400;
    private static final String TAG = "SPenQTCircleBackgroundView";
    private float mArchBgRadius;
    private ValueAnimator mBgRadiusAnimator;
    private Paint mCenterBgPaint;
    private final float mCenterRadius;
    private int mCircleBackgroundColor;
    private float mCircleBgRadius;
    private final SPenQTCircleBackgroundView$mCloseModeLayoutAnimatorListener$1 mCloseModeLayoutAnimatorListener;
    private float mCurrentBgRadius;
    private int mCurrentInnerBgColor;
    private int mDefaultInnerBgColor;
    private float mElevationValue;
    private ValueAnimator mInnerBgAnimator;
    private Paint mLeftFadePaint;
    private Paint mPaint;
    private Paint mRightFadePaint;
    private int mShadowColor;
    private float mStrokeWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.samsung.android.sdk.pen.setting.quicktool.SPenQTCircleBackgroundView$mCloseModeLayoutAnimatorListener$1] */
    public SPenQTCircleBackgroundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = new Paint();
        this.mLeftFadePaint = new Paint();
        this.mRightFadePaint = new Paint();
        this.mCenterBgPaint = new Paint();
        this.mBgRadiusAnimator = new ValueAnimator();
        this.mCenterRadius = context.getResources().getDimensionPixelSize(C8357R.dimen.qt_circle_center_radius);
        this.mInnerBgAnimator = ValueAnimator.ofInt(0, 255);
        this.mStrokeWidth = context.getResources().getDimensionPixelSize(C8357R.dimen.qt_circle_stroke_size);
        this.mElevationValue = getResources().getDimensionPixelSize(C8357R.dimen.qt_circle_layout_elevation);
        this.mShadowColor = getResources().getColor(C8357R.color.setting_qt_bg_shadow_color);
        this.mCircleBackgroundColor = getResources().getColor(C8357R.color.setting_qt_circle_bg_color);
        float dimensionPixelSize = (getResources().getDimensionPixelSize(C8357R.dimen.qt_circle_layout_height) - this.mStrokeWidth) / 2.0f;
        this.mCircleBgRadius = dimensionPixelSize;
        this.mCurrentBgRadius = dimensionPixelSize;
        this.mArchBgRadius = context.getResources().getDimensionPixelSize(C8357R.dimen.qt_circle_arch_background_radius);
        int color = SpenSettingUtil.getColor(context, C8357R.color.setting_qt_center_bg_color);
        this.mDefaultInnerBgColor = color;
        this.mCurrentInnerBgColor = color;
        Paint paint = this.mCenterBgPaint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.mDefaultInnerBgColor);
        initFadePaint();
        initBgAnimator();
        setLayerType(2, null);
        this.mCloseModeLayoutAnimatorListener = new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SPenQTCircleBackgroundView$mCloseModeLayoutAnimatorListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                int iAlpha;
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (this.this$0.mInnerBgAnimator.isRunning()) {
                    this.this$0.mInnerBgAnimator.cancel();
                    iAlpha = Color.alpha(this.this$0.mCurrentInnerBgColor);
                } else {
                    iAlpha = 0;
                }
                this.this$0.mInnerBgAnimator.setIntValues(iAlpha, Color.alpha(this.this$0.mDefaultInnerBgColor));
                this.this$0.mInnerBgAnimator.start();
            }
        };
    }

    public final void close() {
        this.mBgRadiusAnimator.cancel();
    }

    private final void initFadePaint() {
        float f = this.mElevationValue * 2;
        this.mLeftFadePaint.setShader(new LinearGradient(0.0f, 0.0f, f, 0.0f, new int[]{0, this.mPaint.getColor()}, (float[]) null, Shader.TileMode.CLAMP));
        this.mLeftFadePaint.setStyle(Paint.Style.FILL);
        this.mLeftFadePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C8357R.dimen.qt_pen_list_width);
        this.mRightFadePaint.setShader(new LinearGradient(dimensionPixelSize - f, 0.0f, dimensionPixelSize, 0.0f, new int[]{this.mPaint.getColor(), 0}, (float[]) null, Shader.TileMode.CLAMP));
        this.mRightFadePaint.setStyle(Paint.Style.FILL);
        this.mRightFadePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    private final void initBgAnimator() {
        this.mBgRadiusAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
        this.mBgRadiusAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SPenQTCircleBackgroundView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SPenQTCircleBackgroundView.initBgAnimator$lambda$1(this.f$0, valueAnimator);
            }
        });
        this.mInnerBgAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(15));
        this.mInnerBgAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SPenQTCircleBackgroundView$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SPenQTCircleBackgroundView.initBgAnimator$lambda$2(this.f$0, valueAnimator);
            }
        });
        this.mInnerBgAnimator.setDuration(200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBgAnimator$lambda$1(SPenQTCircleBackgroundView sPenQTCircleBackgroundView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        sPenQTCircleBackgroundView.mCurrentBgRadius = ((Float) animatedValue).floatValue();
        sPenQTCircleBackgroundView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBgAnimator$lambda$2(SPenQTCircleBackgroundView sPenQTCircleBackgroundView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        sPenQTCircleBackgroundView.mCurrentInnerBgColor = SpenSettingUtilOpacity.setCurrentAlpha(sPenQTCircleBackgroundView.mDefaultInnerBgColor, ((Integer) animatedValue).intValue());
        sPenQTCircleBackgroundView.invalidate();
    }

    private final void setOpenModeLayout(boolean animation) {
        float f = this.mCircleBgRadius;
        if (this.mBgRadiusAnimator.isRunning()) {
            this.mBgRadiusAnimator.cancel();
            f = this.mCurrentBgRadius;
        }
        if (this.mInnerBgAnimator.isRunning()) {
            this.mInnerBgAnimator.cancel();
        }
        if (!animation) {
            this.mCurrentBgRadius = this.mArchBgRadius;
            invalidate();
        } else {
            this.mBgRadiusAnimator.setFloatValues(f, this.mArchBgRadius);
            this.mBgRadiusAnimator.setDuration(400L);
            this.mBgRadiusAnimator.removeListener(this.mCloseModeLayoutAnimatorListener);
            this.mBgRadiusAnimator.start();
        }
    }

    private final void setCloseModeLayout(boolean animation) {
        float f = this.mArchBgRadius;
        if (this.mBgRadiusAnimator.isRunning()) {
            this.mBgRadiusAnimator.cancel();
            f = this.mCurrentBgRadius;
        }
        if (this.mInnerBgAnimator.isRunning()) {
            this.mInnerBgAnimator.cancel();
        }
        if (!animation) {
            this.mCurrentBgRadius = this.mCircleBgRadius;
            this.mCenterBgPaint.setColor(this.mDefaultInnerBgColor);
            invalidate();
        } else {
            this.mBgRadiusAnimator.setFloatValues(f, this.mCircleBgRadius);
            this.mBgRadiusAnimator.setDuration(350L);
            this.mBgRadiusAnimator.addListener(this.mCloseModeLayoutAnimatorListener);
            this.mBgRadiusAnimator.start();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        PointF pointF = new PointF(getWidth() / 2.0f, ((getHeight() / 2.0f) + this.mCurrentBgRadius) - this.mCircleBgRadius);
        if (!this.mBgRadiusAnimator.isRunning() && this.mCurrentBgRadius == this.mCircleBgRadius) {
            this.mCenterBgPaint.setColor(this.mCurrentInnerBgColor);
            canvas.drawCircle(pointF.x, pointF.y, this.mCenterRadius, this.mCenterBgPaint);
        }
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setColor(this.mShadowColor);
        this.mPaint.setMaskFilter(new BlurMaskFilter(this.mElevationValue, BlurMaskFilter.Blur.NORMAL));
        canvas.drawCircle(pointF.x, pointF.y, this.mCurrentBgRadius, this.mPaint);
        this.mPaint.setMaskFilter(null);
        this.mPaint.setColor(this.mCircleBackgroundColor);
        canvas.drawCircle(pointF.x, pointF.y, this.mCurrentBgRadius, this.mPaint);
        super.draw(canvas);
        if (this.mCurrentBgRadius > getHeight()) {
            float f = 2;
            canvas.drawRect(0.0f, 0.0f, this.mElevationValue * f, getHeight(), this.mLeftFadePaint);
            canvas.drawRect(getWidth() - (this.mElevationValue * f), 0.0f, getWidth(), getHeight(), this.mRightFadePaint);
        }
    }
}
