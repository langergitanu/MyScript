package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSliderBackgroundDrawable;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C8357R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenCurvedSlider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0016*\u0001.\b\u0010\u0018\u0000 ^2\u00020\u0001:\u0004^_`aB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020$H\u0004J\b\u00103\u001a\u000201H\u0016J\b\u00104\u001a\u000201H\u0014J(\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0014J\u0010\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<H\u0016J\u0016\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000fJ\u0018\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020$H\u0016J\u0018\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000fH\u0002J\b\u0010F\u001a\u000201H\u0002J\u000e\u0010G\u001a\u0002012\u0006\u0010H\u001a\u00020\tJ\u000e\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020\u000bJ\u0010\u0010K\u001a\u00020L2\u0006\u0010J\u001a\u00020\u000bH\u0002J\u0010\u0010M\u001a\u0002012\b\u0010N\u001a\u0004\u0018\u00010!J\u0010\u0010O\u001a\u0002012\b\u0010N\u001a\u0004\u0018\u00010&J\u0010\u0010P\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010Q\u001a\u000201H\u0002J\b\u0010R\u001a\u000201H\u0002J\b\u0010S\u001a\u000201H\u0002J\b\u0010T\u001a\u000201H\u0002J\u0010\u0010U\u001a\u0002012\u0006\u0010V\u001a\u00020$H\u0004J\b\u0010W\u001a\u00020$H\u0002J\u0010\u0010X\u001a\u0002012\u0006\u0010Y\u001a\u00020LH\u0002J\u0010\u0010Z\u001a\u0002012\u0006\u0010Y\u001a\u00020LH\u0002J\u0010\u0010[\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020LH\u0002J\u0010\u0010\\\u001a\u0002012\u0006\u0010Y\u001a\u00020LH\u0002J\u001a\u0010]\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006b"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider;", "Landroid/widget/RelativeLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mProgressBackgroundColor", "", "mCurrentValue", "", "mCenter", "Landroid/graphics/PointF;", "mRadius", "", "mAngleStart", "mAngleEnd", "mAngleSum", "mAngleDiff", "mThickness", "mExtendedAngle", "mArcDrawable", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSliderBackgroundDrawable;", "mThumbView", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSliderThumbView;", "getMThumbView", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSliderThumbView;", "setMThumbView", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSliderThumbView;)V", "mBackgroundView", "Landroid/view/View;", "mChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$OnChangedListener;", "mThumbSize", "mIsSupportCheckBg", "", "mAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$OnAnimationListener;", "mIsAnimationCancelled", "mRatioAnimator", "Landroid/animation/ValueAnimator;", "mCurrentBgAniRatio", "mCurrentBgStrokeWidthAniValue", "mIsAnimation", "mBgStrokeWidthFloatProperty", "com/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$mBgStrokeWidthFloatProperty$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$mBgStrokeWidthFloatProperty$1;", "setSupportCheckBg", "", "support", "close", "onFinishInflate", "onSizeChanged", "w", CmcdData.STREAMING_FORMAT_HLS, "oldw", "oldh", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "isRawPointInView", "absX", "absY", "setVisibility", "visibility", "animation", "isSliderTouched", "x", "y", "updateAngleSum", "setProgressColor", "colors", "setValue", "value", "calculateAngleDegree", "", "setOnChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnAnimationListener", "initView", "updateDrawCurvedInfo", "initAnimator", "startShowAnimation", "startHideAnimation", "startCurvedAnimation", "isShow", "isReversed", "updateThumbView", "angleDegree", "updateThumbPosition", "calculateValue", "updateSliderValue", "setAttributes", "Companion", "OnChangedListener", "OnAnimationListener", "FloatValueHolder", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public class SpenCurvedSlider extends RelativeLayout {
    public static final int DEFAULT_MAX_VALUE = 100;
    public static final int DEFAULT_MIN_VALUE = 1;
    public static final long HIDE_ANIMATION_DURATION = 350;
    private static final float HIDE_DAMPING_RATIO = 1.0f;
    private static final float HIDE_STIFFNESS = 400.0f;
    private static final float HIDE_TARGET_RATIO = 0.0f;
    public static final long SHOW_ANIMATION_DURATION = 400;
    private static final float SHOW_DAMPING_RATIO = 0.3f;
    private static final float SHOW_STIFFNESS = 200.0f;
    private static final float SHOW_TARGET_RATIO = 1.0f;
    private static final String TAG = "SpenCurvedSlider";
    private float mAngleDiff;
    private int mAngleEnd;
    private int mAngleStart;
    private int mAngleSum;
    private OnAnimationListener mAnimationListener;
    private SpenSliderBackgroundDrawable mArcDrawable;
    private View mBackgroundView;
    private final SpenCurvedSlider$mBgStrokeWidthFloatProperty$1 mBgStrokeWidthFloatProperty;
    private PointF mCenter;
    private OnChangedListener mChangedListener;
    private float mCurrentBgAniRatio;
    private float mCurrentBgStrokeWidthAniValue;
    private int mCurrentValue;
    private float mExtendedAngle;
    private boolean mIsAnimation;
    private boolean mIsAnimationCancelled;
    private boolean mIsSupportCheckBg;
    private int[] mProgressBackgroundColor;
    private float mRadius;
    private final ValueAnimator mRatioAnimator;
    private float mThickness;
    private int mThumbSize;
    private SpenCurvedSliderThumbView mThumbView;

    /* JADX INFO: compiled from: SpenCurvedSlider.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$OnAnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public interface OnAnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX INFO: compiled from: SpenCurvedSlider.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$OnChangedListener;", "", "onChanged", "", "value", "", "fromUser", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public interface OnChangedListener {
        void onChanged(int value, boolean fromUser);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider$mBgStrokeWidthFloatProperty$1] */
    public SpenCurvedSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mProgressBackgroundColor = new int[]{0, 0};
        this.mCurrentValue = 1;
        this.mCenter = new PointF();
        this.mRatioAnimator = new ValueAnimator();
        this.mBgStrokeWidthFloatProperty = new FloatPropertyCompat<FloatValueHolder>() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider$mBgStrokeWidthFloatProperty$1
            {
                super("customFloat");
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(SpenCurvedSlider.FloatValueHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                return holder.getValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(SpenCurvedSlider.FloatValueHolder holder, float value) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                holder.setValue(value);
                this.this$0.mCurrentBgStrokeWidthAniValue = value;
            }
        };
        setLayoutDirection(0);
        setAttributes(context, attributeSet);
    }

    protected final SpenCurvedSliderThumbView getMThumbView() {
        return this.mThumbView;
    }

    protected final void setMThumbView(SpenCurvedSliderThumbView spenCurvedSliderThumbView) {
        this.mThumbView = spenCurvedSliderThumbView;
    }

    protected final void setSupportCheckBg(boolean support) {
        this.mIsSupportCheckBg = support;
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = this.mArcDrawable;
        if (spenSliderBackgroundDrawable != null) {
            spenSliderBackgroundDrawable.setCheckerboardDrawableEnable(support);
        }
    }

    public void close() {
        this.mThumbView = null;
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = this.mArcDrawable;
        if (spenSliderBackgroundDrawable != null) {
            spenSliderBackgroundDrawable.close();
        }
        this.mArcDrawable = null;
        View view = this.mBackgroundView;
        if (view != null) {
            view.setBackground(null);
        }
        this.mBackgroundView = null;
        this.mAnimationListener = null;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w <= 0 || h <= 0) {
            return;
        }
        this.mCenter.x = w / 2.0f;
        this.mCenter.y = h / 2.0f;
        updateDrawCurvedInfo();
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = this.mArcDrawable;
        if (spenSliderBackgroundDrawable != null) {
            spenSliderBackgroundDrawable.setCheckerboardDrawableEnable(this.mIsSupportCheckBg);
        }
        updateThumbView(calculateAngleDegree(this.mCurrentValue));
        for (int i = 1; i < 101; i++) {
            Log.i(TAG, "value=" + i + ", angle=" + calculateAngleDegree(i));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action == 1) {
                OnChangedListener onChangedListener = this.mChangedListener;
                if (onChangedListener != null) {
                    onChangedListener.onChanged(this.mCurrentValue, true);
                }
            } else if (action == 2) {
                updateThumbView(Math.toDegrees(Math.atan2(event.getY() - this.mCenter.y, event.getX() - this.mCenter.x)));
            }
        } else if (!isSliderTouched(event.getX(), event.getY())) {
            return false;
        }
        return true;
    }

    public final boolean isRawPointInView(float absX, float absY) {
        getLocationOnScreen(new int[2]);
        return isSliderTouched(absX - r0[0], absY - r0[1]);
    }

    public void setVisibility(int visibility, boolean animation) {
        this.mIsAnimation = animation;
        if ((getVisibility() == 0 || visibility == 0) && animation) {
            setVisibility(0);
            startCurvedAnimation(visibility == 0);
        } else {
            setVisibility(visibility);
        }
    }

    private final boolean isSliderTouched(float x, float y) {
        double dSqrt = Math.sqrt(Math.pow(x - this.mCenter.x, 2.0d) + Math.pow(y - this.mCenter.y, 2.0d));
        float f = (this.mThickness / 2) + this.mRadius;
        if (dSqrt >= r2 - (r3 / r4) && dSqrt <= f) {
            float degrees = (float) Math.toDegrees(Math.atan2(y - this.mCenter.y, x - this.mCenter.x));
            if (degrees < 0.0f) {
                degrees += 360.0f;
            }
            float f2 = this.mAngleStart;
            float f3 = this.mExtendedAngle;
            float f4 = f2 - f3;
            float f5 = this.mAngleEnd + f3;
            if (isReversed()) {
                return (degrees >= f4 && degrees <= f4 + f5) || degrees <= f5;
            }
            if (f4 <= degrees && degrees <= f5) {
                return true;
            }
        }
        return false;
    }

    private final void updateAngleSum() {
        int i = this.mAngleStart;
        int i2 = this.mAngleEnd;
        if (i > i2) {
            this.mAngleSum = 360 - (i - i2);
        } else {
            this.mAngleSum = i2 - i;
        }
        int i3 = this.mAngleSum;
        float f = i3 / 99.0f;
        this.mAngleDiff = f;
        Log.i(TAG, "updateAngleSum() angleSum=" + i3 + " angleDiff=" + f);
    }

    public final void setProgressColor(int[] colors) {
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable;
        Intrinsics.checkNotNullParameter(colors, "colors");
        int[] iArrCopyOf = Arrays.copyOf(colors, colors.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, size)");
        this.mProgressBackgroundColor = iArrCopyOf;
        if (getWidth() == 0 || getHeight() == 0 || (spenSliderBackgroundDrawable = this.mArcDrawable) == null) {
            return;
        }
        spenSliderBackgroundDrawable.setGradientColor(this.mProgressBackgroundColor);
    }

    public final void setValue(int value) {
        Log.i(TAG, "setValue() value=" + value + " current=" + this.mCurrentValue);
        this.mCurrentValue = value;
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        updateThumbView(calculateAngleDegree(value));
    }

    private final double calculateAngleDegree(int value) {
        float f = (this.mAngleDiff * (value - 1)) + this.mAngleStart;
        if (isReversed()) {
            f -= 360;
        }
        return f;
    }

    public final void setOnChangedListener(OnChangedListener listener) {
        this.mChangedListener = listener;
    }

    public final void setOnAnimationListener(OnAnimationListener listener) {
        this.mAnimationListener = listener;
    }

    private final void initView(Context context) {
        this.mThumbView = (SpenCurvedSliderThumbView) findViewById(C8357R.id.curved_seekbar_thumb);
        this.mThumbSize = context.getResources().getDimensionPixelSize(C8357R.dimen.qt_curved_seekbar_thumb_size);
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = new SpenSliderBackgroundDrawable(context, getWidth(), getHeight(), this.mRadius, this.mThickness, this.mAngleStart, this.mAngleSum, this.mProgressBackgroundColor);
        this.mArcDrawable = spenSliderBackgroundDrawable;
        spenSliderBackgroundDrawable.setOutlineEnable(true);
        View viewFindViewById = findViewById(C8357R.id.curved_seekbar_background);
        this.mBackgroundView = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setBackground(this.mArcDrawable);
        }
        initAnimator();
    }

    private final void updateDrawCurvedInfo() {
        float f = this.mAngleSum * (this.mIsAnimation ? this.mCurrentBgAniRatio : 1.0f);
        SpenSliderBackgroundDrawable.DrawArcInfo drawArcInfo = new SpenSliderBackgroundDrawable.DrawArcInfo(getWidth(), getHeight(), this.mRadius, this.mIsAnimation ? this.mCurrentBgStrokeWidthAniValue : this.mThickness, this.mAngleStart + ((this.mAngleSum - f) / 2.0f), f, this.mExtendedAngle);
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = this.mArcDrawable;
        if (spenSliderBackgroundDrawable != null) {
            spenSliderBackgroundDrawable.setDrawInfo(drawArcInfo);
        }
    }

    private final void initAnimator() {
        this.mRatioAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        this.mRatioAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SpenCurvedSlider.initAnimator$lambda$0(this.f$0, valueAnimator);
            }
        });
        this.mRatioAnimator.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider.initAnimator.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SpenCurvedSlider.this.mIsAnimationCancelled = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                OnAnimationListener onAnimationListener;
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (SpenCurvedSlider.this.mIsAnimationCancelled || (onAnimationListener = SpenCurvedSlider.this.mAnimationListener) == null) {
                    return;
                }
                onAnimationListener.onAnimationEnd(SpenCurvedSlider.this.mCurrentBgAniRatio == 1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SpenCurvedSlider.this.mIsAnimationCancelled = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$0(SpenCurvedSlider spenCurvedSlider, ValueAnimator value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Object animatedValue = value.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        spenCurvedSlider.mCurrentBgAniRatio = ((Float) animatedValue).floatValue();
        spenCurvedSlider.updateDrawCurvedInfo();
    }

    private final void startShowAnimation() {
        this.mRatioAnimator.setDuration(400L);
        this.mRatioAnimator.setFloatValues(this.mCurrentBgAniRatio, 1.0f);
        this.mRatioAnimator.start();
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(getResources().getDimensionPixelSize(C8357R.dimen.qt_thickness_bg_min_stroke_width)), this.mBgStrokeWidthFloatProperty);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(0.3f);
        springForce.setStiffness(200.0f);
        springForce.setFinalPosition(getResources().getDimensionPixelSize(C8357R.dimen.qt_thickness_bg_max_stroke_width));
        springAnimation.setSpring(springForce);
        springAnimation.start();
    }

    private final void startHideAnimation() {
        this.mRatioAnimator.setDuration(350L);
        this.mRatioAnimator.setFloatValues(this.mCurrentBgAniRatio, 0.0f);
        this.mRatioAnimator.start();
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(getResources().getDimensionPixelSize(C8357R.dimen.qt_thickness_bg_max_stroke_width)), this.mBgStrokeWidthFloatProperty);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(400.0f);
        springForce.setFinalPosition(getResources().getDimensionPixelSize(C8357R.dimen.qt_thickness_bg_min_stroke_width));
        springAnimation.setSpring(springForce);
        springAnimation.start();
    }

    protected final void startCurvedAnimation(boolean isShow) {
        if (this.mRatioAnimator.isRunning()) {
            this.mRatioAnimator.cancel();
        }
        if (isShow) {
            startShowAnimation();
        } else {
            startHideAnimation();
        }
    }

    private final boolean isReversed() {
        return this.mAngleStart > this.mAngleEnd;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009f A[PHI: r1
      0x009f: PHI (r1v8 int) = (r1v2 int), (r1v11 int) binds: [B:39:0x009d, B:22:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00aa A[PHI: r0
      0x00aa: PHI (r0v4 int) = (r0v3 int), (r0v7 int) binds: [B:43:0x00a8, B:26:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateThumbView(double angleDegree) {
        int i;
        int i2;
        if (this.mThumbView == null) {
            return;
        }
        double d = angleDegree < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 360.0d + angleDegree : angleDegree;
        Log.i(TAG, "updateThumbView()-1 angleDegree=" + angleDegree + ", angle=" + d + ", isReversed()=" + isReversed());
        if (isReversed()) {
            if (angleDegree < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d < this.mAngleStart - this.mExtendedAngle) {
                return;
            }
            if (angleDegree >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d > this.mAngleEnd + this.mExtendedAngle) {
                return;
            }
            if (angleDegree < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                i2 = this.mAngleStart;
                if (d < i2) {
                    d = i2;
                }
            }
            if (angleDegree >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                i = this.mAngleEnd;
                if (d > i) {
                    d = i;
                }
            }
        } else {
            if (angleDegree < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d > this.mAngleEnd + this.mExtendedAngle) {
                return;
            }
            if (angleDegree >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d < this.mAngleStart - this.mExtendedAngle) {
                return;
            }
            if (angleDegree < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                i2 = this.mAngleEnd;
                if (d > i2) {
                }
            }
            if (angleDegree >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                i = this.mAngleStart;
                if (d < i) {
                }
            }
        }
        Log.i(TAG, "updateThumbView()-2 angleDegree= " + angleDegree + " angle= " + d);
        updateSliderValue(d);
        updateThumbPosition(d);
    }

    private final void updateThumbPosition(double angleDegree) {
        if (this.mThumbView == null) {
            return;
        }
        double d = (angleDegree * 3.141592653589793d) / ((double) SensibleDefaults.X_OFFSET);
        float fCos = (float) ((((double) this.mCenter.x) + (((double) this.mRadius) * Math.cos(d))) - ((double) (this.mThumbSize / 2)));
        float fSin = (float) ((((double) this.mCenter.y) + (((double) this.mRadius) * Math.sin(d))) - ((double) (this.mThumbSize / 2)));
        SpenCurvedSliderThumbView spenCurvedSliderThumbView = this.mThumbView;
        Intrinsics.checkNotNull(spenCurvedSliderThumbView);
        spenCurvedSliderThumbView.setX(fCos);
        SpenCurvedSliderThumbView spenCurvedSliderThumbView2 = this.mThumbView;
        Intrinsics.checkNotNull(spenCurvedSliderThumbView2);
        spenCurvedSliderThumbView2.setY(fSin);
    }

    private final int calculateValue(double angleDegree) {
        int i = this.mAngleStart;
        if (angleDegree < i) {
            angleDegree += (double) 360;
        }
        int i2 = ((int) (((angleDegree - ((double) i)) * ((double) 100)) / ((double) this.mAngleSum))) + 1;
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    private final void updateSliderValue(double angleDegree) {
        int iCalculateValue = calculateValue(angleDegree);
        this.mCurrentValue = iCalculateValue;
        Log.i(TAG, " updateSliderValue angleDegree=" + angleDegree + ", value=" + iCalculateValue);
        OnChangedListener onChangedListener = this.mChangedListener;
        if (onChangedListener != null) {
            onChangedListener.onChanged(iCalculateValue, false);
        }
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C8357R.styleable.SpenCurvedSlider, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.mAngleStart = typedArrayObtainStyledAttributes.getInteger(C8357R.styleable.SpenCurvedSlider_angleStart, 0);
            this.mAngleEnd = typedArrayObtainStyledAttributes.getInteger(C8357R.styleable.SpenCurvedSlider_angleEnd, 0);
            this.mRadius = typedArrayObtainStyledAttributes.getDimension(C8357R.styleable.SpenCurvedSlider_radius, 0.0f);
            this.mThickness = typedArrayObtainStyledAttributes.getDimension(C8357R.styleable.SpenCurvedSlider_thickness, 0.0f);
        }
        if (this.mThickness == 0.0f) {
            this.mThickness = getResources().getDimension(C8357R.dimen.qt_dial_bg_thickness);
        }
        if (this.mAngleStart == 0) {
            this.mAngleStart = getResources().getInteger(C8357R.integer.setting_qt_opacity_angle_start);
        }
        if (this.mAngleEnd == 0) {
            this.mAngleEnd = getResources().getInteger(C8357R.integer.setting_qt_opacity_angle_end);
        }
        if (this.mRadius == 0.0f) {
            this.mRadius = getResources().getDimension(C8357R.dimen.qt_circle_radius);
        }
        updateAngleSum();
        this.mExtendedAngle = (float) Math.toDegrees((this.mThickness / 2.0f) / this.mRadius);
    }

    /* JADX INFO: compiled from: SpenCurvedSlider.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$FloatValueHolder;", "", "value", "", "<init>", "(F)V", "getValue", "()F", "setValue", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class FloatValueHolder {
        private float value;

        public FloatValueHolder(float f) {
            this.value = f;
        }

        public final float getValue() {
            return this.value;
        }

        public final void setValue(float f) {
            this.value = f;
        }
    }
}
