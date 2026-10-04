package com.myscript.android.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u001e\u0010\u0007\u001a\u00020\b*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n\u001a&\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n\u001a&\u0010\u000e\u001a\u00020\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n\u001a*\u0010\u000f\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015\u001a*\u0010\u0016\u001a\u00020\b*\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u0007\u001a(\u0010\u0018\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0012\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u001a\u001a\u00020\b*\u00020\u00012\b\b\u0001\u0010\u001b\u001a\u00020\u0004\u001a\u0014\u0010\u001c\u001a\u00020\b*\u00020\u001d2\b\b\u0001\u0010\u001b\u001a\u00020\u0004\u001a\n\u0010\"\u001a\u00020\b*\u00020\u0001\u001a\u0012\u0010#\u001a\u00020\b*\u00020$2\u0006\u0010%\u001a\u00020\u0004\"\u0015\u0010\u001e\u001a\u00020\u001f*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006&"}, m1599d2 = {"inflate", "Landroid/view/View;", "Landroid/view/ViewGroup;", "layoutRes", "", "attachToRoot", "", "fadeIn", "", "durationMs", "", "startDelayMs", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/animation/Animation$AnimationListener;", "fadeOut", "rotate", "rotationAngle", "", TypedValues.TransitionType.S_DURATION, "delay", "interpolator", "Landroid/view/animation/Interpolator;", "collapse", "hideViewWhenCollapsed", "expand", "targetHeight", "setTooltipText", "textRes", "setContentDescription", "Landroid/widget/ImageView;", "locationInWindow", "", "getLocationInWindow", "(Landroid/view/View;)[I", "configureForEdgeToEdge", "animateProgress", "Landroid/widget/ProgressBar;", "progress", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ViewExt {
    public static final void collapse(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        collapse$default(view, null, 0, false, 7, null);
    }

    public static final void collapse(View view, Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        collapse$default(view, interpolator, 0, false, 6, null);
    }

    public static final void collapse(View view, Interpolator interpolator, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        collapse$default(view, interpolator, i, false, 4, null);
    }

    public static final void expand(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        expand$default(view, i, null, 0, 6, null);
    }

    public static final void expand(View view, int i, Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        expand$default(view, i, interpolator, 0, 4, null);
    }

    public static /* synthetic */ View inflate$default(ViewGroup viewGroup, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return inflate(viewGroup, i, z);
    }

    public static final View inflate(ViewGroup viewGroup, int i, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return viewInflate;
    }

    public static /* synthetic */ void fadeIn$default(View view, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = view.getResources().getInteger(android.R.integer.config_mediumAnimTime);
        }
        if ((i & 2) != 0) {
            j2 = 0;
        }
        fadeIn(view, j, j2);
    }

    public static final void fadeIn(final View view, long j, long j2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        fadeIn(view, new Animation.AnimationListener() { // from class: com.myscript.android.utils.ViewExt.fadeIn.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                view.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                animation.setAnimationListener(null);
            }
        }, j, j2);
    }

    public static /* synthetic */ void fadeIn$default(View view, Animation.AnimationListener animationListener, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = view.getResources().getInteger(android.R.integer.config_mediumAnimTime);
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = 0;
        }
        fadeIn(view, animationListener, j3, j2);
    }

    public static final void fadeIn(View view, Animation.AnimationListener listener, long j, long j2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setAnimationListener(listener);
        alphaAnimation.setDuration(j);
        alphaAnimation.setStartTime(AnimationUtils.currentAnimationTimeMillis() + j2);
        view.startAnimation(alphaAnimation);
    }

    public static /* synthetic */ void fadeOut$default(View view, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = view.getResources().getInteger(android.R.integer.config_mediumAnimTime);
        }
        if ((i & 2) != 0) {
            j2 = 0;
        }
        fadeOut(view, j, j2);
    }

    public static final void fadeOut(final View view, long j, long j2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        fadeOut(view, new Animation.AnimationListener() { // from class: com.myscript.android.utils.ViewExt.fadeOut.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                animation.setAnimationListener(null);
                view.setVisibility(4);
            }
        }, j, j2);
    }

    public static /* synthetic */ void fadeOut$default(View view, Animation.AnimationListener animationListener, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = view.getResources().getInteger(android.R.integer.config_mediumAnimTime);
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = 0;
        }
        fadeOut(view, animationListener, j3, j2);
    }

    public static final void fadeOut(View view, Animation.AnimationListener listener, long j, long j2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setAnimationListener(listener);
        alphaAnimation.setDuration(j);
        alphaAnimation.setStartTime(AnimationUtils.currentAnimationTimeMillis() + j2);
        view.startAnimation(alphaAnimation);
    }

    public static final void rotate(View view, float f, long j, long j2, Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        ViewCompat.animate(view).rotation(f).withLayer().setDuration(j).setStartDelay(j2).setInterpolator(interpolator).start();
    }

    public static /* synthetic */ void collapse$default(View view, Interpolator interpolator, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interpolator = new FastOutSlowInInterpolator();
        }
        if ((i2 & 2) != 0) {
            i = android.R.integer.config_mediumAnimTime;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        collapse(view, interpolator, i, z);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.myscript.android.utils.ViewExt$collapse$animation$1] */
    public static final void collapse(final View view, Interpolator interpolator, int i, final boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        if (view.getVisibility() == 8) {
            return;
        }
        view.clearAnimation();
        final int measuredHeight = view.getMeasuredHeight();
        ?? r1 = new Animation() { // from class: com.myscript.android.utils.ViewExt$collapse$animation$1
            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }

            @Override // android.view.animation.Animation
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                Intrinsics.checkNotNullParameter(t, "t");
                if (interpolatedTime == 1.0f && z) {
                    view.setVisibility(8);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int i2 = measuredHeight;
                layoutParams.height = i2 - ((int) (i2 * interpolatedTime));
                view.requestLayout();
            }
        };
        r1.setDuration(view.getResources().getInteger(i));
        r1.setInterpolator(interpolator);
        view.startAnimation((Animation) r1);
    }

    public static /* synthetic */ void expand$default(View view, int i, Interpolator interpolator, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            interpolator = new FastOutSlowInInterpolator();
        }
        if ((i3 & 4) != 0) {
            i2 = android.R.integer.config_mediumAnimTime;
        }
        expand(view, i, interpolator, i2);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.myscript.android.utils.ViewExt$expand$animation$1] */
    public static final void expand(final View view, final int i, Interpolator interpolator, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        if (view.getVisibility() != 0 || view.getLayoutParams().height < i) {
            view.clearAnimation();
            final int height = view.getHeight();
            view.getLayoutParams().height = height;
            view.setVisibility(0);
            ?? r1 = new Animation() { // from class: com.myscript.android.utils.ViewExt$expand$animation$1
                @Override // android.view.animation.Animation
                public boolean willChangeBounds() {
                    return true;
                }

                @Override // android.view.animation.Animation
                protected void applyTransformation(float interpolatedTime, Transformation t) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    view.getLayoutParams().height = RangesKt.coerceAtLeast((int) (i * interpolatedTime), height);
                    view.requestLayout();
                }
            };
            r1.setDuration(view.getResources().getInteger(i2));
            r1.setInterpolator(interpolator);
            view.startAnimation((Animation) r1);
        }
    }

    public static final void setTooltipText(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        TooltipCompat.setTooltipText(view, view.getContext().getString(i));
    }

    public static final void setContentDescription(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        imageView.setContentDescription(imageView.getContext().getString(i));
    }

    public static final int[] getLocationInWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr;
    }

    public static final void configureForEdgeToEdge(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.myscript.android.utils.ViewExt$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return ViewExt.configureForEdgeToEdge$lambda$0(view2, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat configureForEdgeToEdge$lambda$0(View view, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        Insets insets2 = windowInsets.getInsets(WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        view.setPadding(0, Math.max(insets.top, insets2.top), 0, insets.bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    public static final void animateProgress(ProgressBar progressBar, int i) {
        Intrinsics.checkNotNullParameter(progressBar, "<this>");
        progressBar.setProgress(i, true);
    }
}
