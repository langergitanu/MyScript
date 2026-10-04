package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C8357R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenQTLayoutAnimation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n*\u0004=@CF\b\u0000\u0018\u0000 R2\u00020\u0001:\u0004RSTUB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0007J\u0006\u0010!\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007J\u001e\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007J\u0016\u0010(\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010)\u001a\u00020\rJ\u0006\u0010*\u001a\u00020\u001fJ\u0006\u0010+\u001a\u00020\u001bJ\b\u0010,\u001a\u00020\u001fH\u0002J\u0006\u0010-\u001a\u00020\u001fJ\u0006\u0010.\u001a\u00020\u001fJ \u0010/\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020%H\u0002J\u0018\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u0018\u00105\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u000e\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\rJ\u0018\u00108\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u0018\u00109\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010:\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010;\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\b\u0010H\u001a\u00020\u001fH\u0002J\b\u0010I\u001a\u00020\u001fH\u0002JJ\u0010J\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00072\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070L2\u0006\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020%2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u000fH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>R\u0010\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0004\n\u0002\u0010AR\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010DR\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010G¨\u0006V"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mTargetView", "Landroid/view/View;", "mAniItems", "Ljava/util/HashMap;", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$AnimationInfo;", "Lkotlin/collections/HashMap;", "mContainerLastOrder", "", "mShowAnimationEndLister", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationEndListener;", "mHideAnimationEndLister", "mToggleToOpenAnimationListener", "mToggleToCloseAnimationListener", "mEnterDockingZoneAnimationListener", "mExitDockingZoneAnimationListener", "mShowSpringX", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mShowSpringY", "mHideSpringX", "mHideSpringY", "mIsAnimationInitialized", "", "mAnglePosition", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTAnglePosition;", "setTargetView", "", "view", "getAnimationViewCount", "registerScaleView", "registerRotateView", "rotateValue", "", "angle", "registerAlphaView", "registerContainerAnimationView", "order", "clearAllAnimationView", "hasContainerAnimationView", "clearAnimationItem", "close", "cancelAnimation", "rotateAnimation", "startPosition", "endPosition", "openAnimation", "skipAniItem", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "closeAnimation", "setViewVisibility", "viewVisibility", "toggleToOpenAnimation", "toggleToCloseAnimation", "enterDockingZoneAnimation", "exitDockingZoneAnimation", "mToggleToOpenAnimatorListenerAdapter", "com/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mToggleToOpenAnimatorListenerAdapter$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mToggleToOpenAnimatorListenerAdapter$1;", "mToggleToCloseAnimatorListenerAdapter", "com/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mToggleToCloseAnimatorListenerAdapter$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mToggleToCloseAnimatorListenerAdapter$1;", "mEnterDockingZoneAnimatorListenerAdapter", "com/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mEnterDockingZoneAnimatorListenerAdapter$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mEnterDockingZoneAnimatorListenerAdapter$1;", "mExitDockingZoneAnimatorListenerAdapter", "com/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mExitDockingZoneAnimatorListenerAdapter$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mExitDockingZoneAnimatorListenerAdapter$1;", "initAnimation", "clearAnimation", "createSpringAnimation", "property", "Landroidx/dynamicanimation/animation/FloatPropertyCompat;", "startValue", "dampingRatio", "stiffness", "finalPosition", "endListener", "Companion", "OpenCloseInfo", "ContainerAnimationInfo", "AnimationInfo", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenQTLayoutAnimation {
    private static final float HIDE_BASE_ALPHA = 0.0f;
    private static final float HIDE_BASE_SCALE = 0.0f;
    private static final float SHOW_BASE_ALPHA = 1.0f;
    private static final float SHOW_BASE_SCALE = 1.0f;
    private static final String TAG = "SpenQTLayoutAnimation";
    private static final int VI_ALPHA = 4;
    private static final long VI_ALPHA_HIDE_DURATION = 100;
    private static final long VI_ALPHA_SHOW_DURATION = 200;
    private static final long VI_DOCKING_SCALE_HIDE_DURATION = 300;
    private static final long VI_DOCKING_SCALE_SHOW_DURATION = 400;
    private static final int VI_ROTATION = 2;
    private static final float VI_ROTATION_BASE_POSITION = 270.0f;
    private static final float VI_ROTATION_DAMPING_RATIO = 0.6f;
    private static final float VI_ROTATION_STIFFNESS = 200.0f;
    private static final int VI_SCALE = 1;
    private static final long VI_SCALE_HIDE_DURATION = 350;
    private static final long VI_SCALE_SHOW_DURATION = 400;
    private static final long VI_TARGET_ALPHA_HIDE_DURATION = 100;
    private static final float VI_TARGET_DAMPING_RATIO = 0.55f;
    private static final float VI_TARGET_STIFFNESS = 200.0f;
    private static final long VI_TOGGLE_SCALE_HIDE_DURATION = 350;
    private static final int VI_TOGGLE_SCALE_INTER_ORDER_DELAY = 50;
    private static final long VI_TOGGLE_SCALE_SHOW_DURATION = 400;
    private final SpenQTAnglePosition mAnglePosition;
    private final HashMap<View, AnimationInfo> mAniItems;
    private int mContainerLastOrder;
    private DynamicAnimation.OnAnimationEndListener mEnterDockingZoneAnimationListener;
    private final SpenQTLayoutAnimation$mEnterDockingZoneAnimatorListenerAdapter$1 mEnterDockingZoneAnimatorListenerAdapter;
    private DynamicAnimation.OnAnimationEndListener mExitDockingZoneAnimationListener;
    private final SpenQTLayoutAnimation$mExitDockingZoneAnimatorListenerAdapter$1 mExitDockingZoneAnimatorListenerAdapter;
    private DynamicAnimation.OnAnimationEndListener mHideAnimationEndLister;
    private SpringAnimation mHideSpringX;
    private SpringAnimation mHideSpringY;
    private boolean mIsAnimationInitialized;
    private DynamicAnimation.OnAnimationEndListener mShowAnimationEndLister;
    private SpringAnimation mShowSpringX;
    private SpringAnimation mShowSpringY;
    private View mTargetView;
    private DynamicAnimation.OnAnimationEndListener mToggleToCloseAnimationListener;
    private final SpenQTLayoutAnimation$mToggleToCloseAnimatorListenerAdapter$1 mToggleToCloseAnimatorListenerAdapter;
    private DynamicAnimation.OnAnimationEndListener mToggleToOpenAnimationListener;
    private final SpenQTLayoutAnimation$mToggleToOpenAnimatorListenerAdapter$1 mToggleToOpenAnimatorListenerAdapter;

    /* JADX WARN: Type inference failed for: r4v3, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mToggleToOpenAnimatorListenerAdapter$1] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mToggleToCloseAnimatorListenerAdapter$1] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mEnterDockingZoneAnimatorListenerAdapter$1] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mExitDockingZoneAnimatorListenerAdapter$1] */
    public SpenQTLayoutAnimation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAniItems = new HashMap<>();
        this.mContainerLastOrder = -1;
        SpenQTAnglePosition spenQTAnglePosition = new SpenQTAnglePosition();
        this.mAnglePosition = spenQTAnglePosition;
        spenQTAnglePosition.setRadius(context.getResources().getDimensionPixelSize(C8357R.dimen.qt_circle_radius));
        spenQTAnglePosition.setCenterPosition(context.getResources().getDimensionPixelSize(C8357R.dimen.qt_circle_center_x), context.getResources().getDimensionPixelSize(C8357R.dimen.qt_circle_center_y));
        this.mToggleToOpenAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mToggleToOpenAnimatorListenerAdapter$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mToggleToOpenAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, true, 0.0f, 0.0f);
                }
                this.this$0.mToggleToOpenAnimationListener = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mToggleToOpenAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, false, 1.0f, 1.0f);
                }
                this.this$0.mToggleToOpenAnimationListener = null;
            }
        };
        this.mToggleToCloseAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mToggleToCloseAnimatorListenerAdapter$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mToggleToCloseAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, true, 1.0f, 1.0f);
                }
                this.this$0.mToggleToCloseAnimationListener = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mToggleToCloseAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, false, 0.0f, 0.0f);
                }
                this.this$0.mToggleToCloseAnimationListener = null;
            }
        };
        this.mEnterDockingZoneAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mEnterDockingZoneAnimatorListenerAdapter$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mEnterDockingZoneAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, true, 1.0f, 1.0f);
                }
                this.this$0.mEnterDockingZoneAnimationListener = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mEnterDockingZoneAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, false, 0.0f, 0.0f);
                }
                this.this$0.mEnterDockingZoneAnimationListener = null;
            }
        };
        this.mExitDockingZoneAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mExitDockingZoneAnimatorListenerAdapter$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mExitDockingZoneAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, true, 0.0f, 0.0f);
                }
                this.this$0.mExitDockingZoneAnimationListener = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mExitDockingZoneAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, false, 1.0f, 1.0f);
                }
                this.this$0.mExitDockingZoneAnimationListener = null;
            }
        };
    }

    /* JADX INFO: compiled from: SpenQTLayoutAnimation.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001d"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$OpenCloseInfo;", "", "type", "", "rotateValue", "", "angle", "<init>", "(IFI)V", "getType", "()I", "setType", "(I)V", "getRotateValue", "()F", "setRotateValue", "(F)V", "getAngle", "setAngle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final /* data */ class OpenCloseInfo {
        private int angle;
        private float rotateValue;
        private int type;

        public static /* synthetic */ OpenCloseInfo copy$default(OpenCloseInfo openCloseInfo, int i, float f, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = openCloseInfo.type;
            }
            if ((i3 & 2) != 0) {
                f = openCloseInfo.rotateValue;
            }
            if ((i3 & 4) != 0) {
                i2 = openCloseInfo.angle;
            }
            return openCloseInfo.copy(i, f, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getRotateValue() {
            return this.rotateValue;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getAngle() {
            return this.angle;
        }

        public final OpenCloseInfo copy(int type, float rotateValue, int angle) {
            return new OpenCloseInfo(type, rotateValue, angle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenCloseInfo)) {
                return false;
            }
            OpenCloseInfo openCloseInfo = (OpenCloseInfo) other;
            return this.type == openCloseInfo.type && Float.compare(this.rotateValue, openCloseInfo.rotateValue) == 0 && this.angle == openCloseInfo.angle;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.type) * 31) + Float.hashCode(this.rotateValue)) * 31) + Integer.hashCode(this.angle);
        }

        public String toString() {
            return "OpenCloseInfo(type=" + this.type + ", rotateValue=" + this.rotateValue + ", angle=" + this.angle + ")";
        }

        public OpenCloseInfo(int i, float f, int i2) {
            this.type = i;
            this.rotateValue = f;
            this.angle = i2;
        }

        public /* synthetic */ OpenCloseInfo(int i, float f, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? 0.0f : f, (i3 & 4) != 0 ? 0 : i2);
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i) {
            this.type = i;
        }

        public final float getRotateValue() {
            return this.rotateValue;
        }

        public final void setRotateValue(float f) {
            this.rotateValue = f;
        }

        public final int getAngle() {
            return this.angle;
        }

        public final void setAngle(int i) {
            this.angle = i;
        }
    }

    /* JADX INFO: compiled from: SpenQTLayoutAnimation.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$ContainerAnimationInfo;", "", "order", "", "startDelay", "", "<init>", "(IJ)V", "getOrder", "()I", "setOrder", "(I)V", "getStartDelay", "()J", "setStartDelay", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final /* data */ class ContainerAnimationInfo {
        private int order;
        private long startDelay;

        public ContainerAnimationInfo() {
            this(0, 0L, 3, null);
        }

        public static /* synthetic */ ContainerAnimationInfo copy$default(ContainerAnimationInfo containerAnimationInfo, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = containerAnimationInfo.order;
            }
            if ((i2 & 2) != 0) {
                j = containerAnimationInfo.startDelay;
            }
            return containerAnimationInfo.copy(i, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getOrder() {
            return this.order;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getStartDelay() {
            return this.startDelay;
        }

        public final ContainerAnimationInfo copy(int order, long startDelay) {
            return new ContainerAnimationInfo(order, startDelay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContainerAnimationInfo)) {
                return false;
            }
            ContainerAnimationInfo containerAnimationInfo = (ContainerAnimationInfo) other;
            return this.order == containerAnimationInfo.order && this.startDelay == containerAnimationInfo.startDelay;
        }

        public int hashCode() {
            return (Integer.hashCode(this.order) * 31) + Long.hashCode(this.startDelay);
        }

        public String toString() {
            return "ContainerAnimationInfo(order=" + this.order + ", startDelay=" + this.startDelay + ")";
        }

        public ContainerAnimationInfo(int i, long j) {
            this.order = i;
            this.startDelay = j;
        }

        public /* synthetic */ ContainerAnimationInfo(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j);
        }

        public final int getOrder() {
            return this.order;
        }

        public final void setOrder(int i) {
            this.order = i;
        }

        public final long getStartDelay() {
            return this.startDelay;
        }

        public final void setStartDelay(long j) {
            this.startDelay = j;
        }
    }

    /* JADX INFO: compiled from: SpenQTLayoutAnimation.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$AnimationInfo;", "", "openCloseAnimation", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$OpenCloseInfo;", "containerAnimation", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$ContainerAnimationInfo;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$OpenCloseInfo;Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$ContainerAnimationInfo;)V", "getOpenCloseAnimation", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$OpenCloseInfo;", "getContainerAnimation", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$ContainerAnimationInfo;", "setContainerAnimation", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$ContainerAnimationInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final /* data */ class AnimationInfo {
        private ContainerAnimationInfo containerAnimation;
        private final OpenCloseInfo openCloseAnimation;

        public static /* synthetic */ AnimationInfo copy$default(AnimationInfo animationInfo, OpenCloseInfo openCloseInfo, ContainerAnimationInfo containerAnimationInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                openCloseInfo = animationInfo.openCloseAnimation;
            }
            if ((i & 2) != 0) {
                containerAnimationInfo = animationInfo.containerAnimation;
            }
            return animationInfo.copy(openCloseInfo, containerAnimationInfo);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final OpenCloseInfo getOpenCloseAnimation() {
            return this.openCloseAnimation;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ContainerAnimationInfo getContainerAnimation() {
            return this.containerAnimation;
        }

        public final AnimationInfo copy(OpenCloseInfo openCloseAnimation, ContainerAnimationInfo containerAnimation) {
            Intrinsics.checkNotNullParameter(openCloseAnimation, "openCloseAnimation");
            return new AnimationInfo(openCloseAnimation, containerAnimation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimationInfo)) {
                return false;
            }
            AnimationInfo animationInfo = (AnimationInfo) other;
            return Intrinsics.areEqual(this.openCloseAnimation, animationInfo.openCloseAnimation) && Intrinsics.areEqual(this.containerAnimation, animationInfo.containerAnimation);
        }

        public int hashCode() {
            int iHashCode = this.openCloseAnimation.hashCode() * 31;
            ContainerAnimationInfo containerAnimationInfo = this.containerAnimation;
            return iHashCode + (containerAnimationInfo == null ? 0 : containerAnimationInfo.hashCode());
        }

        public String toString() {
            return "AnimationInfo(openCloseAnimation=" + this.openCloseAnimation + ", containerAnimation=" + this.containerAnimation + ")";
        }

        public AnimationInfo(OpenCloseInfo openCloseAnimation, ContainerAnimationInfo containerAnimationInfo) {
            Intrinsics.checkNotNullParameter(openCloseAnimation, "openCloseAnimation");
            this.openCloseAnimation = openCloseAnimation;
            this.containerAnimation = containerAnimationInfo;
        }

        public /* synthetic */ AnimationInfo(OpenCloseInfo openCloseInfo, ContainerAnimationInfo containerAnimationInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(openCloseInfo, (i & 2) != 0 ? null : containerAnimationInfo);
        }

        public final OpenCloseInfo getOpenCloseAnimation() {
            return this.openCloseAnimation;
        }

        public final ContainerAnimationInfo getContainerAnimation() {
            return this.containerAnimation;
        }

        public final void setContainerAnimation(ContainerAnimationInfo containerAnimationInfo) {
            this.containerAnimation = containerAnimationInfo;
        }
    }

    public final void setTargetView(View view) {
        if (this.mTargetView != null) {
            clearAnimation();
        }
        this.mTargetView = view;
    }

    public final int getAnimationViewCount() {
        return this.mAniItems.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void registerScaleView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Log.i(TAG, "registerScaleView() view=" + view);
        AnimationInfo animationInfo = this.mAniItems.get(view);
        if (animationInfo == null) {
            this.mAniItems.put(view, new AnimationInfo(new OpenCloseInfo(1, 0.0f, 0, 6, null), null, 2, 0 == true ? 1 : 0));
            return;
        }
        animationInfo.getOpenCloseAnimation().setType(animationInfo.getOpenCloseAnimation().getType() | 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void registerRotateView(View view, float rotateValue, int angle) {
        Intrinsics.checkNotNullParameter(view, "view");
        Log.i(TAG, "registerRotateView() view=" + view + " angle=" + angle + ", rotateValue=" + rotateValue);
        AnimationInfo animationInfo = this.mAniItems.get(view);
        int i = 2;
        if (animationInfo == null) {
            this.mAniItems.put(view, new AnimationInfo(new OpenCloseInfo(2, rotateValue, angle), null, i, 0 == true ? 1 : 0));
            return;
        }
        animationInfo.getOpenCloseAnimation().setType(2 | animationInfo.getOpenCloseAnimation().getType());
        animationInfo.getOpenCloseAnimation().setRotateValue(rotateValue);
        animationInfo.getOpenCloseAnimation().setAngle(angle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void registerAlphaView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Log.i(TAG, "registerAlphaView() view=" + view);
        AnimationInfo animationInfo = this.mAniItems.get(view);
        if (animationInfo == null) {
            this.mAniItems.put(view, new AnimationInfo(new OpenCloseInfo(4, 0.0f, 0, 6, null), null, 2, 0 == true ? 1 : 0));
            return;
        }
        animationInfo.getOpenCloseAnimation().setType(animationInfo.getOpenCloseAnimation().getType() | 4);
    }

    public final boolean registerContainerAnimationView(View view, int order) {
        Intrinsics.checkNotNullParameter(view, "view");
        Log.i(TAG, "registerContainerAnimationView() view=" + view);
        AnimationInfo animationInfo = this.mAniItems.get(view);
        if (animationInfo == null) {
            Log.i(TAG, "not exist registered animationInfo");
            return false;
        }
        long j = order * 50;
        if (animationInfo.getContainerAnimation() == null) {
            animationInfo.setContainerAnimation(new ContainerAnimationInfo(order, j));
        } else {
            ContainerAnimationInfo containerAnimation = animationInfo.getContainerAnimation();
            Intrinsics.checkNotNull(containerAnimation);
            Log.i(TAG, "change order " + containerAnimation.getOrder() + " -> order");
            ContainerAnimationInfo containerAnimation2 = animationInfo.getContainerAnimation();
            if (containerAnimation2 != null) {
                containerAnimation2.setOrder(order);
            }
            ContainerAnimationInfo containerAnimation3 = animationInfo.getContainerAnimation();
            if (containerAnimation3 != null) {
                containerAnimation3.setStartDelay(j);
            }
        }
        if (this.mContainerLastOrder >= order) {
            return true;
        }
        this.mContainerLastOrder = order;
        return true;
    }

    public final void clearAllAnimationView() {
        Log.i(TAG, "clearAll() mAniItems.size=" + this.mAniItems.size());
        cancelAnimation();
        clearAnimationItem();
    }

    public final boolean hasContainerAnimationView() {
        return this.mContainerLastOrder > 0;
    }

    private final void clearAnimationItem() {
        this.mAniItems.clear();
        this.mContainerLastOrder = -1;
    }

    public final void close() {
        cancelAnimation();
        clearAnimationItem();
        this.mTargetView = null;
        this.mShowAnimationEndLister = null;
        this.mHideAnimationEndLister = null;
    }

    public final void cancelAnimation() {
        Log.i(TAG, " cancelAnimation()");
        for (View view : this.mAniItems.keySet()) {
            Intrinsics.checkNotNullExpressionValue(view, "next(...)");
            view.animate().cancel();
        }
        View view2 = this.mTargetView;
        if (view2 != null) {
            if (this.mIsAnimationInitialized) {
                SpringAnimation springAnimation = this.mShowSpringX;
                if (springAnimation != null) {
                    springAnimation.cancel();
                }
                SpringAnimation springAnimation2 = this.mShowSpringY;
                if (springAnimation2 != null) {
                    springAnimation2.cancel();
                }
                SpringAnimation springAnimation3 = this.mHideSpringX;
                if (springAnimation3 != null) {
                    springAnimation3.cancel();
                }
                SpringAnimation springAnimation4 = this.mHideSpringY;
                if (springAnimation4 != null) {
                    springAnimation4.cancel();
                }
            }
            view2.clearAnimation();
            view2.setAlpha(1.0f);
            view2.setEnabled(true);
        }
        this.mShowAnimationEndLister = null;
        this.mHideAnimationEndLister = null;
    }

    private final void rotateAnimation(final View view, float startPosition, float endPosition) {
        Log.i(TAG, "rotateAnimation() [" + startPosition + " -> " + endPosition + "]");
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(startPosition), endPosition);
        SpringForce spring = springAnimation.getSpring();
        spring.setDampingRatio(0.6f);
        spring.setStiffness(200.0f);
        springAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$$ExternalSyntheticLambda0
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                SpenQTLayoutAnimation.rotateAnimation$lambda$4(this.f$0, view, dynamicAnimation, f, f2);
            }
        });
        springAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rotateAnimation$lambda$4(SpenQTLayoutAnimation spenQTLayoutAnimation, View view, DynamicAnimation dynamicAnimation, float f, float f2) {
        PointF viewPosition = spenQTLayoutAnimation.mAnglePosition.getViewPosition(view.getWidth(), view.getHeight(), (int) f);
        view.setX(viewPosition.x);
        view.setY(viewPosition.y);
    }

    public final boolean openAnimation(boolean skipAniItem, DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "showAnimation()");
        if (!skipAniItem) {
            for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
                View key = entry.getKey();
                AnimationInfo value = entry.getValue();
                if (key.getVisibility() == 0) {
                    OpenCloseInfo openCloseAnimation = value.getOpenCloseAnimation();
                    if ((openCloseAnimation.getType() & 2) == 2) {
                        Log.i(TAG, "openAnimation() rotateAngle[ " + openCloseAnimation.getRotateValue() + " -> " + openCloseAnimation.getAngle() + "]");
                        rotateAnimation(key, openCloseAnimation.getRotateValue(), openCloseAnimation.getAngle());
                    }
                    if ((openCloseAnimation.getType() & 4) == 4) {
                        Log.i(TAG, "start alpha animation() view=" + key);
                        key.setAlpha(0.0f);
                        key.setEnabled(true);
                        key.animate().alpha(1.0f).setDuration(200L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).start();
                    }
                    if ((openCloseAnimation.getType() & 1) == 1) {
                        Log.i(TAG, "start scale animation() view=" + key);
                        key.setScaleX(0.0f);
                        key.setScaleY(0.0f);
                        key.setEnabled(true);
                        key.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).start();
                    }
                }
            }
        }
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        if (!this.mIsAnimationInitialized) {
            initAnimation();
        }
        this.mShowAnimationEndLister = listener;
        view.setAlpha(1.0f);
        view.setEnabled(true);
        SpringAnimation springAnimation = this.mShowSpringX;
        if (springAnimation != null) {
            springAnimation.start();
        }
        SpringAnimation springAnimation2 = this.mShowSpringY;
        if (springAnimation2 != null) {
            springAnimation2.start();
        }
        return true;
    }

    public final boolean closeAnimation(boolean skipAniItem, DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "hideAnimation()");
        if (!skipAniItem) {
            for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
                View key = entry.getKey();
                AnimationInfo value = entry.getValue();
                if (key.getVisibility() != 0) {
                    Log.i(TAG, "hideAnimation() skip invisible view=" + key);
                } else {
                    OpenCloseInfo openCloseAnimation = value.getOpenCloseAnimation();
                    if ((openCloseAnimation.getType() & 2) == 2) {
                        Log.i(TAG, "closeAnimation() rotateAngle[" + openCloseAnimation.getAngle() + " -> " + openCloseAnimation.getRotateValue() + " ]");
                        rotateAnimation(key, openCloseAnimation.getAngle(), openCloseAnimation.getRotateValue());
                    }
                    if ((openCloseAnimation.getType() & 1) == 1) {
                        key.setScaleX(1.0f);
                        key.setScaleY(1.0f);
                        key.setEnabled(false);
                        key.animate().scaleX(0.0f).scaleY(0.0f).setDuration(350L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).start();
                    }
                    if ((openCloseAnimation.getType() & 4) == 4) {
                        key.setAlpha(1.0f);
                        key.setEnabled(false);
                        key.animate().alpha(0.0f).setDuration(100L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).start();
                    }
                }
            }
        }
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        if (!this.mIsAnimationInitialized) {
            initAnimation();
        }
        this.mHideAnimationEndLister = listener;
        view.setEnabled(false);
        View view2 = this.mTargetView;
        Intrinsics.checkNotNull(view2);
        view2.animate().alpha(0.0f).setDuration(100L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).start();
        SpringAnimation springAnimation = this.mHideSpringX;
        if (springAnimation != null) {
            springAnimation.start();
        }
        SpringAnimation springAnimation2 = this.mHideSpringY;
        if (springAnimation2 != null) {
            springAnimation2.start();
        }
        return true;
    }

    public final void setViewVisibility(int viewVisibility) {
        Log.i(TAG, "setViewVisibility() visibility=" + viewVisibility);
        boolean z = viewVisibility == 0;
        float f = z ? 1.0f : 0.0f;
        float f2 = z ? 1.0f : 0.0f;
        Iterator<Map.Entry<View, AnimationInfo>> it = this.mAniItems.entrySet().iterator();
        while (it.hasNext()) {
            View key = it.next().getKey();
            if (key.getVisibility() == 0) {
                key.setScaleX(f);
                key.setScaleY(f);
                key.setAlpha(f2);
                key.setEnabled(z);
            }
        }
    }

    public final void toggleToOpenAnimation(boolean skipAniItem, DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "toggleToOpenAnimation()");
        this.mToggleToOpenAnimationListener = listener;
        int i = 0;
        if (!skipAniItem) {
            for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
                View key = entry.getKey();
                AnimationInfo value = entry.getValue();
                if (key.getVisibility() == 0 && value.getContainerAnimation() != null) {
                    ContainerAnimationInfo containerAnimation = value.getContainerAnimation();
                    Intrinsics.checkNotNull(containerAnimation);
                    key.setScaleX(0.0f);
                    key.setScaleY(0.0f);
                    key.setEnabled(true);
                    key.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setStartDelay(containerAnimation.getStartDelay()).setListener(this.mContainerLastOrder == containerAnimation.getOrder() ? this.mToggleToOpenAnimatorListenerAdapter : null).start();
                    i++;
                }
            }
        }
        if (i == 0) {
            Log.i(TAG, "animationCount() = 0");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    SpenQTLayoutAnimation.toggleToOpenAnimation$lambda$11(this.f$0);
                }
            });
        } else {
            Log.i(TAG, "toggleToOpenAnimation() end. animationCount=" + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleToOpenAnimation$lambda$11(SpenQTLayoutAnimation spenQTLayoutAnimation) {
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mToggleToOpenAnimationListener;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(null, false, 1.0f, 1.0f);
        }
        spenQTLayoutAnimation.mToggleToOpenAnimationListener = null;
    }

    public final void toggleToCloseAnimation(boolean skipAniItem, DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "toggleToCloseAnimation()");
        this.mToggleToCloseAnimationListener = listener;
        boolean z = false;
        if (!skipAniItem) {
            boolean z2 = false;
            for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
                View key = entry.getKey();
                AnimationInfo value = entry.getValue();
                if (key.getVisibility() == 0 && value.getContainerAnimation() != null) {
                    key.setScaleX(1.0f);
                    key.setScaleY(1.0f);
                    key.setEnabled(false);
                    key.setPivotX(key.getWidth() / 2.0f);
                    key.setPivotY(key.getHeight() / 2.0f);
                    key.animate().scaleX(0.0f).scaleY(0.0f).setDuration(350L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setListener(!z2 ? this.mToggleToCloseAnimatorListenerAdapter : null).setStartDelay(0L).start();
                    z2 = true;
                }
            }
            z = z2;
        }
        if (!z) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    SpenQTLayoutAnimation.toggleToCloseAnimation$lambda$13(this.f$0);
                }
            });
        } else {
            Log.i(TAG, "toggleToCloseAnimation() end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleToCloseAnimation$lambda$13(SpenQTLayoutAnimation spenQTLayoutAnimation) {
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mToggleToCloseAnimationListener;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(null, false, 0.0f, 0.0f);
        }
        spenQTLayoutAnimation.mToggleToCloseAnimationListener = null;
    }

    public final void enterDockingZoneAnimation(DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "enterDockingZoneAnimation()");
        this.mEnterDockingZoneAnimationListener = listener;
        boolean z = false;
        for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
            View key = entry.getKey();
            AnimationInfo value = entry.getValue();
            if (key.getVisibility() == 0 && value.getContainerAnimation() != null) {
                key.setScaleX(1.0f);
                key.setScaleY(1.0f);
                key.setEnabled(false);
                key.setPivotX(key.getWidth() / 2.0f);
                key.setPivotY(key.getHeight() / 2.0f);
                key.animate().scaleX(0.0f).scaleY(0.0f).setDuration(300L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setListener(!z ? this.mEnterDockingZoneAnimatorListenerAdapter : null).setStartDelay(0L).start();
                z = true;
            }
        }
        if (!z) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    SpenQTLayoutAnimation.enterDockingZoneAnimation$lambda$15(this.f$0);
                }
            });
        } else {
            Log.i(TAG, "enterDockingZoneAnimation() end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterDockingZoneAnimation$lambda$15(SpenQTLayoutAnimation spenQTLayoutAnimation) {
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mEnterDockingZoneAnimationListener;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(null, false, 0.0f, 0.0f);
        }
        spenQTLayoutAnimation.mEnterDockingZoneAnimationListener = null;
    }

    public final void exitDockingZoneAnimation(DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "exitDockingZoneAnimation()");
        this.mExitDockingZoneAnimationListener = listener;
        boolean z = false;
        for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
            View key = entry.getKey();
            AnimationInfo value = entry.getValue();
            if (key.getVisibility() == 0 && value.getContainerAnimation() != null) {
                key.setScaleX(0.0f);
                key.setScaleY(0.0f);
                key.setEnabled(true);
                key.setPivotX(key.getWidth() / 2.0f);
                key.setPivotY(key.getHeight() / 2.0f);
                key.setAlpha(1.0f);
                key.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setListener(!z ? this.mExitDockingZoneAnimatorListenerAdapter : null).setStartDelay(0L).start();
                z = true;
            }
        }
        if (!z) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    SpenQTLayoutAnimation.exitDockingZoneAnimation$lambda$17(this.f$0);
                }
            });
        } else {
            Log.i(TAG, "exitDockingZoneAnimation() end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitDockingZoneAnimation$lambda$17(SpenQTLayoutAnimation spenQTLayoutAnimation) {
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mExitDockingZoneAnimationListener;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(null, false, 1.0f, 1.0f);
        }
        spenQTLayoutAnimation.mExitDockingZoneAnimationListener = null;
    }

    private final void initAnimation() {
        View view = this.mTargetView;
        if (view == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        DynamicAnimation.ViewProperty SCALE_Y = DynamicAnimation.SCALE_Y;
        Intrinsics.checkNotNullExpressionValue(SCALE_Y, "SCALE_Y");
        this.mShowSpringY = createSpringAnimation$default(this, view, SCALE_Y, 0.0f, VI_TARGET_DAMPING_RATIO, 200.0f, 1.0f, null, 64, null);
        View view2 = this.mTargetView;
        Intrinsics.checkNotNull(view2);
        DynamicAnimation.ViewProperty SCALE_X = DynamicAnimation.SCALE_X;
        Intrinsics.checkNotNullExpressionValue(SCALE_X, "SCALE_X");
        this.mShowSpringX = createSpringAnimation(view2, SCALE_X, 0.0f, VI_TARGET_DAMPING_RATIO, 200.0f, 1.0f, new DynamicAnimation.OnAnimationEndListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$$ExternalSyntheticLambda5
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                SpenQTLayoutAnimation.initAnimation$lambda$18(this.f$0, dynamicAnimation, z, f, f2);
            }
        });
        View view3 = this.mTargetView;
        Intrinsics.checkNotNull(view3);
        DynamicAnimation.ViewProperty SCALE_Y2 = DynamicAnimation.SCALE_Y;
        Intrinsics.checkNotNullExpressionValue(SCALE_Y2, "SCALE_Y");
        this.mHideSpringY = createSpringAnimation$default(this, view3, SCALE_Y2, 1.0f, VI_TARGET_DAMPING_RATIO, 200.0f, 0.0f, null, 64, null);
        View view4 = this.mTargetView;
        Intrinsics.checkNotNull(view4);
        DynamicAnimation.ViewProperty SCALE_X2 = DynamicAnimation.SCALE_X;
        Intrinsics.checkNotNullExpressionValue(SCALE_X2, "SCALE_X");
        this.mHideSpringX = createSpringAnimation(view4, SCALE_X2, 1.0f, VI_TARGET_DAMPING_RATIO, 200.0f, 0.0f, new DynamicAnimation.OnAnimationEndListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$$ExternalSyntheticLambda6
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                SpenQTLayoutAnimation.initAnimation$lambda$19(this.f$0, dynamicAnimation, z, f, f2);
            }
        });
        this.mIsAnimationInitialized = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimation$lambda$18(SpenQTLayoutAnimation spenQTLayoutAnimation, DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        Log.i(TAG, "ShowSpringAnimation - onAnimationEnd()");
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mShowAnimationEndLister;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(dynamicAnimation, z, f, f2);
        }
        spenQTLayoutAnimation.mShowAnimationEndLister = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimation$lambda$19(SpenQTLayoutAnimation spenQTLayoutAnimation, DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        Log.i(TAG, "HideSpringAnimation - onAnimationEnd()");
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mHideAnimationEndLister;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(dynamicAnimation, z, f, f2);
        }
        spenQTLayoutAnimation.mHideAnimationEndLister = null;
    }

    private final void clearAnimation() {
        cancelAnimation();
        this.mShowSpringX = null;
        this.mShowSpringY = null;
        this.mHideSpringX = null;
        this.mHideSpringY = null;
        this.mIsAnimationInitialized = false;
    }

    static /* synthetic */ SpringAnimation createSpringAnimation$default(SpenQTLayoutAnimation spenQTLayoutAnimation, View view, FloatPropertyCompat floatPropertyCompat, float f, float f2, float f3, float f4, DynamicAnimation.OnAnimationEndListener onAnimationEndListener, int i, Object obj) {
        return spenQTLayoutAnimation.createSpringAnimation(view, floatPropertyCompat, f, f2, f3, f4, (i & 64) != 0 ? null : onAnimationEndListener);
    }

    private final SpringAnimation createSpringAnimation(View view, FloatPropertyCompat<View> property, float startValue, float dampingRatio, float stiffness, float finalPosition, DynamicAnimation.OnAnimationEndListener endListener) {
        SpringAnimation springAnimation = new SpringAnimation(view, property);
        SpringForce springForce = new SpringForce();
        springAnimation.setStartValue(startValue);
        springForce.setDampingRatio(dampingRatio);
        springForce.setStiffness(stiffness);
        springForce.setFinalPosition(finalPosition);
        springAnimation.setSpring(springForce);
        springAnimation.addEndListener(endListener);
        return springAnimation;
    }
}
