package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C8357R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenQTColorPickerView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c*\u0001<\b\u0000\u0018\u0000 v2\u00020\u0001:\u0005vwxyzB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0014J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0016J\u0006\u0010F\u001a\u00020?J\u000e\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020CJ\u000e\u0010I\u001a\u00020?2\u0006\u0010J\u001a\u000206J\u0010\u0010K\u001a\u00020?2\b\u0010J\u001a\u0004\u0018\u000108J\u0010\u0010L\u001a\u00020?2\b\u0010J\u001a\u0004\u0018\u00010:J\u000e\u0010M\u001a\u00020?2\u0006\u0010N\u001a\u00020$J\b\u0010O\u001a\u00020?H\u0002J\u0018\u0010P\u001a\u00020C2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020\rH\u0002J\u0010\u0010S\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J \u0010T\u001a\u00020?2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020\r2\u0006\u0010U\u001a\u00020\u0013H\u0002J\u0010\u0010V\u001a\u00020?2\u0006\u0010W\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u00020?2\u0006\u0010W\u001a\u00020XH\u0002J\u0010\u0010Z\u001a\u00020?2\u0006\u0010W\u001a\u00020XH\u0002J\u0010\u0010[\u001a\u00020?2\u0006\u0010W\u001a\u00020XH\u0002J \u0010\\\u001a\u00020C2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020\r2\u0006\u0010U\u001a\u00020\u0013H\u0002J\u0010\u0010]\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J \u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\r2\u0006\u0010a\u001a\u00020\u00132\u0006\u0010b\u001a\u00020\u0013H\u0002J\u0010\u0010c\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J8\u0010d\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010e\u001a\u00020\u00132\u0006\u0010f\u001a\u00020\r2\u0006\u0010g\u001a\u00020\r2\u0006\u0010h\u001a\u00020\r2\u0006\u0010i\u001a\u00020CH\u0002J\u0010\u0010j\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010k\u001a\u00020\u00132\u0006\u0010l\u001a\u00020\rH\u0002J\b\u0010m\u001a\u00020?H\u0002J\b\u0010n\u001a\u00020?H\u0002J\b\u0010o\u001a\u00020?H\u0002J\b\u0010p\u001a\u00020?H\u0002J\u0010\u0010q\u001a\u00020?2\u0006\u0010H\u001a\u00020CH\u0002J\u0010\u0010r\u001a\u00020?2\u0006\u0010U\u001a\u00020\u0013H\u0002J\u0010\u0010s\u001a\u00020?2\u0006\u0010U\u001a\u00020\u0013H\u0002J\u0010\u0010t\u001a\u00020\r2\u0006\u0010u\u001a\u00020\rH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=¨\u0006{"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerView;", "Landroid/view/View;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mHsvPaint", "Landroid/graphics/Paint;", "mHandlerPaint", "mHueWheelStartAngle", "", "mHueWheelRadius", "mHueWheelStrokeWidth", "mHueWheelHandlerRadius", "mHueWheelHandlerAngle", "mHueWheelAlpha", "", "mColorToneSeekBarRadius", "mColorToneSeekBarStrokeWidth", "mColorToneSeekBarBorderWidth", "mColorToneSeekBarHandlerRadius", "mColorToneSeekBarAlpha", "mBrightnessHandlerAngle", "mBrightnessHandlerPos", "Landroid/graphics/PointF;", "mSaturationHandlerAngle", "mSaturationHandlerPos", "mBorderStrokeWidth", "mBorderColor", "mHandlerColor", "mBorderStrokeWidthColor", "mHueColor", "mHsv", "", "mCenter", "mIsAttributeTouched", "mSweepAngle", "mExtendedAngle", "mHueWheelTrimAnimator", "Landroid/animation/ValueAnimator;", "mHueWheelOpacityAnimator", "mHueHandlerScaleAnimator", "mHueHandlerBorderScaleAnimator", "mSeekbarOpacityAnimator", "mColorToneSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mSpringForce", "Landroidx/dynamicanimation/animation/SpringForce;", "mAnimationSet", "Landroid/animation/AnimatorSet;", "mOnColorChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerView$OnColorChangedListener;", "mAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerView$AnimationListener;", "mPickerActionListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerView$OnActionListener;", "mSeekbarFloatProperty", "com/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerView$mSeekbarFloatProperty$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerView$mSeekbarFloatProperty$1;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "close", "startAnimation", "isShow", "setOnColorChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAnimationListener", "setOnPickerActionListener", "setPositionByColor", "hsvColor", "init", "isColorWheelTouch", "x", "y", "drawHueWheel", "adjustHandlerPosition", "attribute", "updateBrightnessView", "angleDegree", "", "updateBrightnessValue", "updateSaturationView", "updateSaturationValue", "isSeekBarTouch", "drawColorToneSeekBar", "makeShader", "Landroid/graphics/Shader;", "rotationDegree", "startColor", "endColor", "drawHueHandler", "drawHandler", "color", "cx", "cy", "radius", "hasBorder", "drawColorToneSeekBarHandler", "getHueColorAtAngle", "angel", "initHandlerPaint", "initHsvPaint", "updateSelectedColor", "initAnimator", "startAnimationShow", "notifyPickerPressed", "notifyPickerReleased", "getHandlerAngleDegree", "angle", "Companion", "OnColorChangedListener", "AnimationListener", "OnActionListener", "FloatValueHolder", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenQTColorPickerView extends View {
    private static final float ANGLE_SUM = 120.0f;
    private static final int ATTRIBUTE_BRIGHTNESS = 2;
    private static final int ATTRIBUTE_HUE = 1;
    private static final int ATTRIBUTE_SATURATION = 3;
    private static final float BRIGHTNESS_ANGLE_END = 240.0f;
    private static final float BRIGHTNESS_ANGLE_START = 120.0f;
    private static final long HIDE_HUE_HANDLER_ANIMATION_DURATION = 350;
    private static final long HIDE_HUE_TRIM_ANIMATION_DURATION = 350;
    private static final long HIDE_SEEKBAR_OPACITY_ANIMATION_DURATION = 100;
    private static final float HUE_ANGLE_END = 240.0f;
    private static final float HUE_ANGLE_START = 60.0f;
    private static final long HUE_OPACITY_ANIMATION_DURATION = 350;
    private static final int MAX_ALPHA = 255;
    private static final float SATURATION_ANGLE_END = 60.0f;
    private static final float SATURATION_ANGLE_START = 300.0f;
    private static final float SEEKBAR_SPRING_OVER_OFFSET = 1.0f;
    private static final float SEEK_BAR_SPRING_DAMPING_RATIO = 0.63f;
    private static final float SEEK_BAR_SPRING_STIFFNESS = 200.0f;
    private static final long SHOW_HUE_HANDLER_ANIMATION_DURATION = 400;
    private static final long SHOW_HUE_TRIM_ANIMATION_DURATION = 400;
    private static final long SHOW_SEEKBAR_OPACITY_ANIMATION_DURATION = 200;
    private static final String TAG = "SpenQTColorPickerView";
    private AnimationListener mAnimationListener;
    private final AnimatorSet mAnimationSet;
    private int mBorderColor;
    private float mBorderStrokeWidth;
    private int mBorderStrokeWidthColor;
    private float mBrightnessHandlerAngle;
    private PointF mBrightnessHandlerPos;
    private PointF mCenter;
    private int mColorToneSeekBarAlpha;
    private float mColorToneSeekBarBorderWidth;
    private float mColorToneSeekBarHandlerRadius;
    private float mColorToneSeekBarRadius;
    private float mColorToneSeekBarStrokeWidth;
    private SpringAnimation mColorToneSpringAnimation;
    private float mExtendedAngle;
    private int mHandlerColor;
    private Paint mHandlerPaint;
    private float[] mHsv;
    private Paint mHsvPaint;
    private int mHueColor;
    private final ValueAnimator mHueHandlerBorderScaleAnimator;
    private final ValueAnimator mHueHandlerScaleAnimator;
    private int mHueWheelAlpha;
    private float mHueWheelHandlerAngle;
    private float mHueWheelHandlerRadius;
    private final ValueAnimator mHueWheelOpacityAnimator;
    private float mHueWheelRadius;
    private float mHueWheelStartAngle;
    private float mHueWheelStrokeWidth;
    private final ValueAnimator mHueWheelTrimAnimator;
    private int mIsAttributeTouched;
    private OnColorChangedListener mOnColorChangedListener;
    private OnActionListener mPickerActionListener;
    private float mSaturationHandlerAngle;
    private PointF mSaturationHandlerPos;
    private final SpenQTColorPickerView$mSeekbarFloatProperty$1 mSeekbarFloatProperty;
    private final ValueAnimator mSeekbarOpacityAnimator;
    private final SpringForce mSpringForce;
    private float mSweepAngle;

    /* JADX INFO: compiled from: SpenQTColorPickerView.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerView$AnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public interface AnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX INFO: compiled from: SpenQTColorPickerView.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerView$OnActionListener;", "", "onHuePressed", "", "onHueReleased", "onSaturationPressed", "onSaturationReleased", "onBrightnessPressed", "onBrightnessReleased", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public interface OnActionListener {
        void onBrightnessPressed();

        void onBrightnessReleased();

        void onHuePressed();

        void onHueReleased();

        void onSaturationPressed();

        void onSaturationReleased();
    }

    /* JADX INFO: compiled from: SpenQTColorPickerView.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerView$OnColorChangedListener;", "", "onColorChanged", "", "hsvColor", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public interface OnColorChangedListener {
        void onColorChanged(float[] hsvColor);
    }

    private final float getHandlerAngleDegree(float angle) {
        float f = 360;
        float f2 = angle % f;
        return f2 > 180.0f ? f2 - f : f2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v12, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView$mSeekbarFloatProperty$1] */
    public SpenQTColorPickerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBrightnessHandlerPos = new PointF();
        this.mSaturationHandlerPos = new PointF();
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = 0.0f;
        }
        this.mHsv = fArr;
        this.mCenter = new PointF();
        this.mHueWheelTrimAnimator = new ValueAnimator();
        this.mHueWheelOpacityAnimator = new ValueAnimator();
        this.mHueHandlerScaleAnimator = new ValueAnimator();
        this.mHueHandlerBorderScaleAnimator = new ValueAnimator();
        this.mSeekbarOpacityAnimator = new ValueAnimator();
        this.mSpringForce = new SpringForce();
        this.mAnimationSet = new AnimatorSet();
        this.mSeekbarFloatProperty = new FloatPropertyCompat<FloatValueHolder>() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView$mSeekbarFloatProperty$1
            {
                super("Seekbar Radius");
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(SpenQTColorPickerView.FloatValueHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                return holder.getValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(SpenQTColorPickerView.FloatValueHolder holder, float value) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                holder.setValue(value);
                this.this$0.mColorToneSeekBarRadius = value;
                this.this$0.updateSaturationView(r3.mSaturationHandlerAngle);
                this.this$0.updateBrightnessView(r3.mBrightnessHandlerAngle);
                this.this$0.invalidate();
            }
        };
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v12, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView$mSeekbarFloatProperty$1] */
    public SpenQTColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBrightnessHandlerPos = new PointF();
        this.mSaturationHandlerPos = new PointF();
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = 0.0f;
        }
        this.mHsv = fArr;
        this.mCenter = new PointF();
        this.mHueWheelTrimAnimator = new ValueAnimator();
        this.mHueWheelOpacityAnimator = new ValueAnimator();
        this.mHueHandlerScaleAnimator = new ValueAnimator();
        this.mHueHandlerBorderScaleAnimator = new ValueAnimator();
        this.mSeekbarOpacityAnimator = new ValueAnimator();
        this.mSpringForce = new SpringForce();
        this.mAnimationSet = new AnimatorSet();
        this.mSeekbarFloatProperty = new FloatPropertyCompat<FloatValueHolder>() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView$mSeekbarFloatProperty$1
            {
                super("Seekbar Radius");
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(SpenQTColorPickerView.FloatValueHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                return holder.getValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(SpenQTColorPickerView.FloatValueHolder holder, float value) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                holder.setValue(value);
                this.this$0.mColorToneSeekBarRadius = value;
                this.this$0.updateSaturationView(r3.mSaturationHandlerAngle);
                this.this$0.updateBrightnessView(r3.mBrightnessHandlerAngle);
                this.this$0.invalidate();
            }
        };
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawHueWheel(canvas);
        drawHueHandler(canvas);
        drawColorToneSeekBar(canvas);
        drawColorToneSeekBarHandler(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        int i = 3;
        if (action == 0) {
            if (isColorWheelTouch(event.getX(), event.getY())) {
                i = 1;
            } else if (isSeekBarTouch(event.getX(), event.getY(), 2)) {
                i = 2;
            } else if (!isSeekBarTouch(event.getX(), event.getY(), 3)) {
                i = 0;
            }
            this.mIsAttributeTouched = i;
            if (i == 0) {
                return false;
            }
            notifyPickerPressed(i);
        } else if (action == 1) {
            notifyPickerReleased(this.mIsAttributeTouched);
            this.mIsAttributeTouched = 0;
        } else if (action == 2) {
            int i2 = this.mIsAttributeTouched;
            if (i2 == 1) {
                adjustHandlerPosition(event.getX(), event.getY(), 1);
            } else if (i2 == 2) {
                adjustHandlerPosition(event.getX(), event.getY(), 2);
            } else if (i2 == 3) {
                adjustHandlerPosition(event.getX(), event.getY(), 3);
            }
            invalidate();
        }
        return true;
    }

    public final void close() {
        this.mOnColorChangedListener = null;
        this.mAnimationListener = null;
    }

    public final void startAnimation(boolean isShow) {
        startAnimationShow(isShow);
    }

    public final void setOnColorChangedListener(OnColorChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnColorChangedListener = listener;
    }

    public final void setAnimationListener(AnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final void setOnPickerActionListener(OnActionListener listener) {
        this.mPickerActionListener = listener;
    }

    public final void setPositionByColor(float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        this.mHsv = hsvColor;
        float f = hsvColor[0] % 360;
        this.mHueWheelHandlerAngle = f;
        this.mHueColor = getHueColorAtAngle(f);
        float handlerAngleDegree = getHandlerAngleDegree((this.mHsv[1] * 120.0f) + SATURATION_ANGLE_START);
        this.mSaturationHandlerAngle = handlerAngleDegree;
        updateSaturationView(handlerAngleDegree);
        float handlerAngleDegree2 = getHandlerAngleDegree((this.mHsv[2] * 120.0f) + 120.0f);
        this.mBrightnessHandlerAngle = handlerAngleDegree2;
        updateBrightnessView(handlerAngleDegree2);
    }

    private final void init() {
        this.mHueWheelRadius = getResources().getDimensionPixelSize(C8357R.dimen.qt_color_picker_hue_wheel_radius);
        this.mHueWheelStrokeWidth = getResources().getDimensionPixelSize(C8357R.dimen.qt_color_picker_hue_wheel_stroke_width);
        this.mColorToneSeekBarRadius = getResources().getDimensionPixelSize(C8357R.dimen.qt_color_picker_color_tone_seekbar_max_radius);
        this.mColorToneSeekBarStrokeWidth = getResources().getDimensionPixelSize(C8357R.dimen.qt_color_picker_color_tone_seekbar_stroke_width);
        this.mColorToneSeekBarBorderWidth = getResources().getDimensionPixelSize(C8357R.dimen.qt_color_picker_color_tone_seekbar_stroke_width_border);
        this.mColorToneSeekBarHandlerRadius = getResources().getDimensionPixelSize(C8357R.dimen.qt_color_picker_color_tone_seekbar_handler_radius);
        this.mExtendedAngle = (float) Math.ceil((float) Math.toDegrees((this.mColorToneSeekBarStrokeWidth / 2.0f) / this.mColorToneSeekBarRadius));
        this.mBorderColor = getResources().getColor(C8357R.color.setting_qt_circle_bg_color, null);
        this.mHandlerColor = getResources().getColor(C8357R.color.setting_qt_color_picker_handler_color, null);
        this.mBorderStrokeWidthColor = getResources().getColor(C8357R.color.setting_qt_color_picker_stroke_width_border_color, null);
        float dimensionPixelSize = getResources().getDimensionPixelSize(C8357R.dimen.qt_color_picker_layout_width);
        float dimensionPixelSize2 = getResources().getDimensionPixelSize(C8357R.dimen.qt_color_picker_layout_height);
        float f = 2;
        this.mCenter.x = dimensionPixelSize / f;
        this.mCenter.y = dimensionPixelSize2 / f;
        initHsvPaint();
        initHandlerPaint();
        initAnimator();
    }

    private final boolean isColorWheelTouch(float x, float y) {
        double dSqrt = Math.sqrt(Math.pow(x - this.mCenter.x, 2.0d) + Math.pow(y - this.mCenter.y, 2.0d));
        float f = this.mHueWheelRadius;
        float f2 = this.mHueWheelStrokeWidth;
        float f3 = 2;
        return ((double) (f - (f2 / f3))) <= dSqrt && dSqrt <= ((double) ((f2 / f3) + f));
    }

    private final void drawHueWheel(Canvas canvas) {
        Paint paint;
        int[] iArr = {SupportMenu.CATEGORY_MASK, -256, -16711936, -16711681, -16776961, -65281, SupportMenu.CATEGORY_MASK};
        Paint paint2 = this.mHsvPaint;
        Paint paint3 = null;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint2 = null;
        }
        paint2.setStrokeWidth(this.mHueWheelStrokeWidth);
        SweepGradient sweepGradient = new SweepGradient(this.mCenter.x, this.mCenter.y, iArr, (float[]) null);
        Paint paint4 = this.mHsvPaint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint4 = null;
        }
        paint4.setShader(sweepGradient);
        Paint paint5 = this.mHsvPaint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint5 = null;
        }
        paint5.setAlpha(this.mHueWheelAlpha);
        RectF rectF = new RectF(this.mCenter.x - this.mHueWheelRadius, this.mCenter.y - this.mHueWheelRadius, this.mCenter.x + this.mHueWheelRadius, this.mCenter.y + this.mHueWheelRadius);
        float f = this.mHueWheelStartAngle;
        float f2 = this.mSweepAngle;
        Paint paint6 = this.mHsvPaint;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint = null;
        } else {
            paint = paint6;
        }
        canvas.drawArc(rectF, f, f2, false, paint);
        Paint paint7 = this.mHsvPaint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint7 = null;
        }
        paint7.setShader(null);
        Paint paint8 = this.mHsvPaint;
        if (paint8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint8 = null;
        }
        paint8.setColor(this.mBorderColor);
        Paint paint9 = this.mHsvPaint;
        if (paint9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint9 = null;
        }
        paint9.setStrokeWidth(this.mBorderStrokeWidth);
        float f3 = this.mCenter.x;
        float f4 = this.mCenter.y;
        float f5 = 2;
        float f6 = this.mHueWheelRadius + (this.mHueWheelStrokeWidth / f5) + (this.mBorderStrokeWidth / f5);
        Paint paint10 = this.mHsvPaint;
        if (paint10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint10 = null;
        }
        canvas.drawCircle(f3, f4, f6, paint10);
        float f7 = this.mCenter.x;
        float f8 = this.mCenter.y;
        float f9 = (this.mHueWheelRadius - (this.mHueWheelStrokeWidth / f5)) - (this.mBorderStrokeWidth / f5);
        Paint paint11 = this.mHsvPaint;
        if (paint11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
        } else {
            paint3 = paint11;
        }
        canvas.drawCircle(f7, f8, f9, paint3);
    }

    private final void adjustHandlerPosition(float x, float y, int attribute) {
        float f = x - this.mCenter.x;
        float f2 = y - this.mCenter.y;
        if (attribute == 1) {
            float degrees = (float) Math.toDegrees(Math.atan2(f2, f));
            this.mHueWheelHandlerAngle = degrees;
            this.mHueColor = getHueColorAtAngle(degrees);
        } else if (attribute == 2) {
            float degrees2 = (float) Math.toDegrees(Math.atan2(f2, f));
            this.mBrightnessHandlerAngle = degrees2;
            updateBrightnessView(degrees2);
        } else if (attribute == 3) {
            float degrees3 = (float) Math.toDegrees(Math.atan2(f2, f));
            this.mSaturationHandlerAngle = degrees3;
            updateSaturationView(degrees3);
        }
        updateSelectedColor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBrightnessView(double angleDegree) {
        double d = angleDegree < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 360.0d + angleDegree : angleDegree;
        if (angleDegree >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d <= this.mExtendedAngle + 240.0f) {
            if (angleDegree < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d >= 120.0f - this.mExtendedAngle) {
                if (angleDegree < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d > 240.0d) {
                    d = 240.0d;
                } else if (angleDegree >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d < 120.0d) {
                    d = 120.0d;
                }
                updateBrightnessValue(d);
                this.mBrightnessHandlerPos.x = (float) (((double) this.mCenter.x) + (Math.cos(Math.toRadians(d)) * ((double) this.mColorToneSeekBarRadius)));
                this.mBrightnessHandlerPos.y = (float) (((double) this.mCenter.y) + (Math.sin(Math.toRadians(d)) * ((double) this.mColorToneSeekBarRadius)));
            }
        }
    }

    private final void updateBrightnessValue(double angleDegree) {
        if (angleDegree > 240.0d) {
            angleDegree += (double) 360;
        }
        int iAbs = (int) Math.abs(((angleDegree - ((double) 240.0f)) * ((double) 100)) / ((double) 120.0f));
        if (iAbs > 100) {
            iAbs = 100;
        }
        this.mHsv[2] = (100 - iAbs) / 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSaturationView(double angleDegree) {
        double d = angleDegree < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 360.0d + angleDegree : angleDegree;
        if (angleDegree >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d >= SATURATION_ANGLE_START - this.mExtendedAngle) {
            if (angleDegree < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d <= this.mExtendedAngle + 60.0f) {
                if (angleDegree < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d < 300.0d) {
                    d = 300.0d;
                } else if (angleDegree >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d > 60.0d) {
                    d = 60.0d;
                }
                updateSaturationValue(d);
                this.mSaturationHandlerPos.x = (float) (((double) this.mCenter.x) + (Math.cos(Math.toRadians(d)) * ((double) this.mColorToneSeekBarRadius)));
                this.mSaturationHandlerPos.y = (float) (((double) this.mCenter.y) + (Math.sin(Math.toRadians(d)) * ((double) this.mColorToneSeekBarRadius)));
            }
        }
    }

    private final void updateSaturationValue(double angleDegree) {
        if (angleDegree < 300.0d) {
            angleDegree += (double) 360;
        }
        this.mHsv[1] = (((int) Math.abs(((angleDegree - ((double) SATURATION_ANGLE_START)) * ((double) 100)) / ((double) 120.0f))) <= 100 ? r4 : 100) / 100.0f;
    }

    private final boolean isSeekBarTouch(float x, float y, int attribute) {
        double dSqrt = Math.sqrt(Math.pow(x - this.mCenter.x, 2.0d) + Math.pow(y - this.mCenter.y, 2.0d));
        float f = (this.mColorToneSeekBarStrokeWidth / 2) + this.mColorToneSeekBarRadius;
        if (dSqrt >= r2 - (r3 / r5) && dSqrt <= f) {
            float degrees = (float) Math.toDegrees(Math.atan2(y - this.mCenter.y, x - this.mCenter.x));
            if (degrees < 0.0f) {
                degrees += 360.0f;
            }
            float f2 = attribute == 2 ? 120.0f : SATURATION_ANGLE_START;
            float f3 = attribute == 2 ? 240.0f : 60.0f;
            float f4 = this.mExtendedAngle;
            float f5 = f2 - f4;
            float f6 = f3 + f4;
            if (f5 > f6) {
                return (degrees >= f5 && degrees <= f5 + f6) || degrees <= f6;
            }
            if (f5 <= degrees && degrees <= f6) {
                return true;
            }
        }
        return false;
    }

    private final void drawColorToneSeekBar(Canvas canvas) {
        Paint paint;
        Paint paint2;
        Paint paint3;
        Paint paint4;
        Color.colorToHSV(this.mHueColor, new float[3]);
        RectF rectF = new RectF(this.mCenter.x - this.mColorToneSeekBarRadius, this.mCenter.y - this.mColorToneSeekBarRadius, this.mCenter.x + this.mColorToneSeekBarRadius, this.mCenter.y + this.mColorToneSeekBarRadius);
        Paint paint5 = this.mHsvPaint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint5 = null;
        }
        paint5.setStrokeWidth(this.mColorToneSeekBarBorderWidth);
        Paint paint6 = this.mHsvPaint;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint6 = null;
        }
        paint6.setColor(this.mBorderStrokeWidthColor);
        Paint paint7 = this.mHsvPaint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint7 = null;
        }
        paint7.setAlpha(this.mColorToneSeekBarAlpha);
        Paint paint8 = this.mHsvPaint;
        if (paint8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint = null;
        } else {
            paint = paint8;
        }
        canvas.drawArc(rectF, 120.0f, 120.0f, false, paint);
        Paint paint9 = this.mHsvPaint;
        if (paint9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint2 = null;
        } else {
            paint2 = paint9;
        }
        canvas.drawArc(rectF, SATURATION_ANGLE_START, 120.0f, false, paint2);
        Paint paint10 = this.mHsvPaint;
        if (paint10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint10 = null;
        }
        paint10.setStrokeWidth(this.mColorToneSeekBarStrokeWidth);
        Paint paint11 = this.mHsvPaint;
        if (paint11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint11 = null;
        }
        paint11.setShader(makeShader(119.0f, -16777216, -1));
        Paint paint12 = this.mHsvPaint;
        if (paint12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint3 = null;
        } else {
            paint3 = paint12;
        }
        canvas.drawArc(rectF, 120.0f, 120.0f, false, paint3);
        Paint paint13 = this.mHsvPaint;
        if (paint13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint13 = null;
        }
        float[] fArr = this.mHsv;
        int iHSVToColor = SpenSettingUtil.HSVToColor(new float[]{fArr[0], 0.0f, fArr[2]});
        float[] fArr2 = this.mHsv;
        paint13.setShader(makeShader(-61.0f, iHSVToColor, SpenSettingUtil.HSVToColor(new float[]{fArr2[0], 1.0f, fArr2[2]})));
        Paint paint14 = this.mHsvPaint;
        if (paint14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint4 = null;
        } else {
            paint4 = paint14;
        }
        canvas.drawArc(rectF, SATURATION_ANGLE_START, 120.0f, false, paint4);
        Paint paint15 = this.mHsvPaint;
        if (paint15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint15 = null;
        }
        paint15.setShader(null);
    }

    private final Shader makeShader(float rotationDegree, int startColor, int endColor) {
        SweepGradient sweepGradient = new SweepGradient(this.mCenter.x, this.mCenter.y, new int[]{startColor, endColor}, new float[]{0.0f, ((2 * this.mExtendedAngle) + 120.0f) / 360.0f});
        Matrix matrix = new Matrix();
        matrix.setRotate(rotationDegree - this.mExtendedAngle, this.mCenter.x, this.mCenter.y);
        sweepGradient.setLocalMatrix(matrix);
        return sweepGradient;
    }

    private final void drawHueHandler(Canvas canvas) {
        drawHandler(canvas, this.mHueColor, (float) (((double) this.mCenter.x) + (Math.cos(Math.toRadians(this.mHueWheelHandlerAngle)) * ((double) this.mHueWheelRadius))), (float) (((double) this.mCenter.y) + (Math.sin(Math.toRadians(this.mHueWheelHandlerAngle)) * ((double) this.mHueWheelRadius))), this.mHueWheelHandlerRadius, true);
    }

    private final void drawHandler(Canvas canvas, int color, float cx, float cy, float radius, boolean hasBorder) {
        Paint paint = this.mHandlerPaint;
        Paint paint2 = null;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
            paint = null;
        }
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = this.mHandlerPaint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
            paint3 = null;
        }
        paint3.setColor(color);
        if (hasBorder) {
            Paint paint4 = this.mHandlerPaint;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
                paint4 = null;
            }
            paint4.setAlpha(255);
        } else {
            Paint paint5 = this.mHandlerPaint;
            if (paint5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
                paint5 = null;
            }
            paint5.setAlpha(this.mColorToneSeekBarAlpha);
        }
        int i = ((int) ((this.mColorToneSeekBarAlpha / 255.0f) * 51)) << 24;
        Paint paint6 = this.mHandlerPaint;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
            paint6 = null;
        }
        paint6.setShadowLayer(getResources().getDimensionPixelSize(C8357R.dimen.qt_color_picker_handler_elevation), 0.0f, 0.0f, i);
        Paint paint7 = this.mHandlerPaint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
            paint7 = null;
        }
        canvas.drawCircle(cx, cy, radius, paint7);
        if (hasBorder) {
            Paint paint8 = this.mHandlerPaint;
            if (paint8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
                paint8 = null;
            }
            paint8.setStyle(Paint.Style.STROKE);
            Paint paint9 = this.mHandlerPaint;
            if (paint9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
                paint9 = null;
            }
            paint9.setStrokeWidth(this.mBorderStrokeWidth);
            Paint paint10 = this.mHandlerPaint;
            if (paint10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
                paint10 = null;
            }
            paint10.setColor(this.mHandlerColor);
            float f = radius + (this.mBorderStrokeWidth / 2);
            Paint paint11 = this.mHandlerPaint;
            if (paint11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
            } else {
                paint2 = paint11;
            }
            canvas.drawCircle(cx, cy, f, paint2);
        }
    }

    private final void drawColorToneSeekBarHandler(Canvas canvas) {
        int iHSVToColor = Color.HSVToColor(new float[]{0.0f, 0.0f, 1.0f});
        drawHandler(canvas, iHSVToColor, this.mBrightnessHandlerPos.x, this.mBrightnessHandlerPos.y, this.mColorToneSeekBarHandlerRadius, false);
        drawHandler(canvas, iHSVToColor, this.mSaturationHandlerPos.x, this.mSaturationHandlerPos.y, this.mColorToneSeekBarHandlerRadius, false);
    }

    private final int getHueColorAtAngle(float angel) {
        float f = 360;
        float f2 = (angel + f) % f;
        this.mHsv[0] = f2;
        return Color.HSVToColor(new float[]{f2, 1.0f, 1.0f});
    }

    private final void initHandlerPaint() {
        Paint paint = new Paint();
        this.mHandlerPaint = paint;
        paint.setAntiAlias(true);
    }

    private final void initHsvPaint() {
        Paint paint = new Paint();
        this.mHsvPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = this.mHsvPaint;
        Paint paint3 = null;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint2 = null;
        }
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint4 = this.mHsvPaint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint4 = null;
        }
        paint4.setStrokeCap(Paint.Cap.ROUND);
        Paint paint5 = this.mHsvPaint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
        } else {
            paint3 = paint5;
        }
        paint3.setAlpha(0);
    }

    private final void updateSelectedColor() {
        float[] fArr = this.mHsv;
        float[] fArr2 = {fArr[0], fArr[1], fArr[2]};
        OnColorChangedListener onColorChangedListener = this.mOnColorChangedListener;
        if (onColorChangedListener != null) {
            onColorChangedListener.onColorChanged(fArr2);
        }
    }

    private final void initAnimator() {
        this.mHueWheelTrimAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        this.mHueWheelTrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SpenQTColorPickerView.initAnimator$lambda$0(this.f$0, valueAnimator);
            }
        });
        this.mHueWheelOpacityAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        this.mHueWheelOpacityAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SpenQTColorPickerView.initAnimator$lambda$1(this.f$0, valueAnimator);
            }
        });
        this.mHueHandlerScaleAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        this.mHueHandlerScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SpenQTColorPickerView.initAnimator$lambda$2(this.f$0, valueAnimator);
            }
        });
        this.mHueHandlerBorderScaleAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        this.mHueHandlerBorderScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SpenQTColorPickerView.initAnimator$lambda$3(this.f$0, valueAnimator);
            }
        });
        this.mSeekbarOpacityAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(15));
        this.mSeekbarOpacityAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SpenQTColorPickerView.initAnimator$lambda$4(this.f$0, valueAnimator);
            }
        });
        this.mSpringForce.setDampingRatio(SEEK_BAR_SPRING_DAMPING_RATIO);
        this.mSpringForce.setStiffness(200.0f);
        this.mAnimationSet.playTogether(this.mHueWheelTrimAnimator, this.mHueWheelOpacityAnimator, this.mHueHandlerScaleAnimator, this.mHueHandlerBorderScaleAnimator, this.mSeekbarOpacityAnimator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$0(SpenQTColorPickerView spenQTColorPickerView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        spenQTColorPickerView.mHueWheelStartAngle = (180.0f * fFloatValue) + 60.0f;
        spenQTColorPickerView.mSweepAngle = fFloatValue * (-360.0f);
        spenQTColorPickerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$1(SpenQTColorPickerView spenQTColorPickerView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        spenQTColorPickerView.mHueWheelAlpha = ((Integer) animatedValue).intValue();
        spenQTColorPickerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$2(SpenQTColorPickerView spenQTColorPickerView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        spenQTColorPickerView.mHueWheelHandlerRadius = ((Float) animatedValue).floatValue();
        spenQTColorPickerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$3(SpenQTColorPickerView spenQTColorPickerView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        spenQTColorPickerView.mBorderStrokeWidth = ((Float) animatedValue).floatValue();
        spenQTColorPickerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$4(SpenQTColorPickerView spenQTColorPickerView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        spenQTColorPickerView.mColorToneSeekBarAlpha = ((Integer) animatedValue).intValue();
        spenQTColorPickerView.invalidate();
    }

    private final void startAnimationShow(final boolean isShow) {
        Resources resources;
        int i;
        this.mAnimationSet.cancel();
        this.mHueWheelTrimAnimator.setFloatValues(isShow ? 0.0f : 1.0f, isShow ? 1.0f : 0.0f);
        this.mHueWheelTrimAnimator.setDuration(isShow ? 400L : 350L);
        this.mHueWheelTrimAnimator.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerView$startAnimationShow$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SpenQTColorPickerView.AnimationListener animationListener = this.this$0.mAnimationListener;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(isShow);
                }
            }
        });
        this.mHueWheelOpacityAnimator.setIntValues(isShow ? 0 : 255, isShow ? 255 : 0);
        this.mHueWheelOpacityAnimator.setDuration(350L);
        float dimensionPixelSize = getResources().getDimensionPixelSize(C8357R.dimen.qt_color_picker_hue_wheel_handler_radius);
        ValueAnimator valueAnimator = this.mHueHandlerScaleAnimator;
        float f = isShow ? 0.0f : dimensionPixelSize;
        if (!isShow) {
            dimensionPixelSize = 0.0f;
        }
        valueAnimator.setFloatValues(f, dimensionPixelSize);
        this.mHueHandlerScaleAnimator.setDuration(isShow ? 400L : 350L);
        float dimensionPixelSize2 = getResources().getDimensionPixelSize(C8357R.dimen.qt_color_picker_border_stroke_width);
        this.mHueHandlerBorderScaleAnimator.setFloatValues(isShow ? 0.0f : dimensionPixelSize2, isShow ? dimensionPixelSize2 : 0.0f);
        this.mHueHandlerBorderScaleAnimator.setDuration(isShow ? 400L : 350L);
        this.mSeekbarOpacityAnimator.setIntValues(isShow ? 0 : 255, isShow ? 255 : 0);
        this.mSeekbarOpacityAnimator.setDuration(isShow ? 200L : HIDE_SEEKBAR_OPACITY_ANIMATION_DURATION);
        Resources resources2 = getResources();
        this.mColorToneSpringAnimation = new SpringAnimation(isShow ? new FloatValueHolder(resources2.getDimensionPixelSize(C8357R.dimen.qt_color_picker_color_tone_seekbar_min_radius)) : new FloatValueHolder(resources2.getDimensionPixelSize(C8357R.dimen.qt_color_picker_color_tone_seekbar_max_radius)), this.mSeekbarFloatProperty);
        SpringForce springForce = this.mSpringForce;
        if (isShow) {
            resources = getResources();
            i = C8357R.dimen.qt_color_picker_color_tone_seekbar_max_radius;
        } else {
            resources = getResources();
            i = C8357R.dimen.qt_color_picker_color_tone_seekbar_min_radius;
        }
        springForce.setFinalPosition(resources.getDimensionPixelSize(i));
        SpringAnimation springAnimation = this.mColorToneSpringAnimation;
        SpringAnimation springAnimation2 = null;
        if (springAnimation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorToneSpringAnimation");
            springAnimation = null;
        }
        springAnimation.setSpring(this.mSpringForce);
        SpringAnimation springAnimation3 = this.mColorToneSpringAnimation;
        if (springAnimation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorToneSpringAnimation");
        } else {
            springAnimation2 = springAnimation3;
        }
        springAnimation2.start();
        this.mAnimationSet.start();
    }

    /* JADX INFO: compiled from: SpenQTColorPickerView.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorPickerView$FloatValueHolder;", "", "value", "", "<init>", "(F)V", "getValue", "()F", "setValue", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
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

    private final void notifyPickerPressed(int attribute) {
        OnActionListener onActionListener = this.mPickerActionListener;
        if (onActionListener != null) {
            if (attribute == 1) {
                onActionListener.onHuePressed();
            } else if (attribute == 2) {
                onActionListener.onBrightnessPressed();
            } else {
                if (attribute != 3) {
                    return;
                }
                onActionListener.onSaturationPressed();
            }
        }
    }

    private final void notifyPickerReleased(int attribute) {
        OnActionListener onActionListener = this.mPickerActionListener;
        if (onActionListener != null) {
            if (attribute == 1) {
                onActionListener.onHueReleased();
            } else if (attribute == 2) {
                onActionListener.onBrightnessReleased();
            } else {
                if (attribute != 3) {
                    return;
                }
                onActionListener.onSaturationReleased();
            }
        }
    }
}
