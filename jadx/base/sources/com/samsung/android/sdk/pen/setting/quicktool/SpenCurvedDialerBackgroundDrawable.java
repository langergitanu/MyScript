package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C8357R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenCurvedDialerBackgroundDrawable.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\fJ\u001a\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u000fH\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\b\u0010.\u001a\u00020\u001aH\u0002R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialerBackgroundDrawable;", "Landroid/graphics/drawable/Drawable;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", TtmlNode.CENTER, "Landroid/graphics/PointF;", "<init>", "(Landroid/content/Context;Landroid/graphics/PointF;)V", "mContext", "mPaint", "Landroid/graphics/Paint;", "mRadius", "", "mCenter", "mStartIndex", "", "mEndIndex", "mOffsetAngle", "mMaxDot", "mItemSizes", "", "mItemAngles", "mValueAnimator", "Landroid/animation/ValueAnimator;", "mItemSizeScale", "close", "", "updatePosition", "value", "angle", "setMaxDotsVisible", "setItemSizeScale", "scale", "startAnimation", "targetAngle", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialerBackgroundDrawable$AnimationListener;", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "generateCircleDotInfo", "Companion", "AnimationListener", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenCurvedDialerBackgroundDrawable extends Drawable {
    private static final float END_ANGLE = 45.0f;
    private static final int END_INDEX = 10;
    private static final int MAX_POINT = 11;
    private static final long ROTATE_ANIMATION_DURATION = 450;
    private static final float START_ANGLE = 315.0f;
    private static final int START_INDEX = 0;
    private static final String TAG = "SpenCurvedDialerBackgroundDrawable";
    private final PointF mCenter;
    private final Context mContext;
    private int mEndIndex;
    private float[] mItemAngles;
    private float mItemSizeScale;
    private float[] mItemSizes;
    private int mMaxDot;
    private float mOffsetAngle;
    private final Paint mPaint;
    private final float mRadius;
    private int mStartIndex;
    private ValueAnimator mValueAnimator;

    /* JADX INFO: compiled from: SpenCurvedDialerBackgroundDrawable.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialerBackgroundDrawable$AnimationListener;", "", "onAnimationStart", "", "onAnimationUpdate", "value", "", "onAnimationEnd", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public interface AnimationListener {
        void onAnimationEnd();

        void onAnimationStart();

        void onAnimationUpdate(float value);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public SpenCurvedDialerBackgroundDrawable(Context context, PointF center) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(center, "center");
        this.mContext = context;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        this.mItemSizeScale = 1.0f;
        paint.setColor(context.getResources().getColor(C8357R.color.setting_qt_dialer_dot_color, null));
        this.mRadius = (context.getResources().getDimensionPixelSize(C8357R.dimen.qt_dial_width) - context.getResources().getDimensionPixelSize(C8357R.dimen.qt_dial_stroke_size)) / 2.0f;
        this.mCenter = center;
        this.mStartIndex = 0;
        this.mEndIndex = 10;
        this.mOffsetAngle = 0.0f;
        this.mMaxDot = 11;
        generateCircleDotInfo();
    }

    public final void close() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mValueAnimator = null;
    }

    public final void updatePosition(int value, float angle) {
        if (angle == this.mOffsetAngle) {
            return;
        }
        this.mOffsetAngle = angle;
        int i = value / 10;
        this.mStartIndex = Math.max(i - 6, 0);
        this.mEndIndex = Math.min(i + 6, 10);
        invalidateSelf();
    }

    public final void setMaxDotsVisible(int value) {
        this.mMaxDot = value;
        generateCircleDotInfo();
        invalidateSelf();
    }

    public final void setItemSizeScale(float scale) {
        this.mItemSizeScale = scale;
    }

    public static /* synthetic */ void startAnimation$default(SpenCurvedDialerBackgroundDrawable spenCurvedDialerBackgroundDrawable, float f, AnimationListener animationListener, int i, Object obj) {
        if ((i & 2) != 0) {
            animationListener = null;
        }
        spenCurvedDialerBackgroundDrawable.startAnimation(f, animationListener);
    }

    public final void startAnimation(float targetAngle, final AnimationListener listener) {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        final ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mOffsetAngle, targetAngle);
        valueAnimatorOfFloat.setDuration(ROTATE_ANIMATION_DURATION);
        valueAnimatorOfFloat.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable$startAnimation$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SpenCurvedDialerBackgroundDrawable.AnimationListener animationListener = listener;
                if (animationListener != null) {
                    animationListener.onAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SpenCurvedDialerBackgroundDrawable.AnimationListener animationListener = listener;
                if (animationListener != null) {
                    animationListener.onAnimationStart();
                }
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SpenCurvedDialerBackgroundDrawable.startAnimation$lambda$1$lambda$0(listener, valueAnimatorOfFloat, valueAnimator2);
            }
        });
        valueAnimatorOfFloat.start();
        this.mValueAnimator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$1$lambda$0(AnimationListener animationListener, ValueAnimator valueAnimator, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (animationListener != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            animationListener.onAnimationUpdate(((Float) animatedValue).floatValue());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float radians = (float) Math.toRadians(this.mOffsetAngle);
        int i = this.mStartIndex;
        int i2 = this.mEndIndex;
        if (i > i2) {
            return;
        }
        while (true) {
            double d = this.mCenter.x;
            double d2 = this.mRadius;
            float[] fArr = this.mItemAngles;
            float[] fArr2 = null;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemAngles");
                fArr = null;
            }
            float fCos = (float) (d + (d2 * Math.cos(fArr[i] + radians)));
            double d3 = this.mCenter.y;
            double d4 = this.mRadius;
            float[] fArr3 = this.mItemAngles;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemAngles");
                fArr3 = null;
            }
            float fSin = (float) (d3 + (d4 * Math.sin(fArr3[i] + radians)));
            float[] fArr4 = this.mItemSizes;
            if (fArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemSizes");
            } else {
                fArr2 = fArr4;
            }
            canvas.drawCircle(fCos, fSin, fArr2[i] * this.mItemSizeScale, this.mPaint);
            if (i == i2) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void generateCircleDotInfo() {
        float radians = (float) Math.toRadians(315.0d);
        float radians2 = (float) Math.toRadians(45.0d);
        float dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C8357R.dimen.qt_dial_item_min_size) / 2.0f;
        float dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(C8357R.dimen.qt_dial_item_max_size) / 2.0f;
        float[] fArr = new float[11];
        this.mItemSizes = fArr;
        int length = fArr.length;
        int i = 0;
        while (true) {
            float[] fArr2 = null;
            if (i >= length) {
                break;
            }
            float[] fArr3 = this.mItemSizes;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemSizes");
            } else {
                fArr2 = fArr3;
            }
            fArr2[i] = (((dimensionPixelSize2 - dimensionPixelSize) * i) / 10) + dimensionPixelSize;
            i++;
        }
        float[] fArr4 = new float[11];
        this.mItemAngles = fArr4;
        int length2 = fArr4.length;
        for (int i2 = 0; i2 < length2; i2++) {
            float[] fArr5 = this.mItemAngles;
            if (fArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemAngles");
                fArr5 = null;
            }
            fArr5[i2] = (((radians2 - radians) * i2) / 10) + radians;
        }
    }
}
