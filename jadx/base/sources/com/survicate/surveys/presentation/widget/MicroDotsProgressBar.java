package com.survicate.surveys.presentation.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.utils.AccessibilityUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroDotsProgressBar.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0006\u0010\u0017\u001a\u00020\u0012J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\b\u0010\u0019\u001a\u00020\u0012H\u0014R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroDotsProgressBar;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dots", "", "Landroid/widget/ImageView;", "animators", "Landroid/animation/ValueAnimator;", "shouldAnimate", "", "inject", "", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "setupForAccessibility", "setupAnimations", "startAnimation", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroDotsProgressBar extends FrameLayout {
    private static final Companion Companion = new Companion(null);
    private static final long DOT_ANIMATION_DURATION = 500;
    private static final float FINAL_SCALE_FACTOR = 1.0f;
    private static final float INIT_SCALE_FACTOR = 0.3f;
    private static final long WHOLE_ANIM_DURATION = 1500;
    private final List<ValueAnimator> animators;
    private final List<ImageView> dots;
    private boolean shouldAnimate;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroDotsProgressBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroDotsProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroDotsProgressBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroDotsProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<ImageView> arrayList = new ArrayList();
        this.dots = arrayList;
        this.animators = new ArrayList();
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_dots_progress_bar, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_dots_progress_bar_dot_left);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        arrayList.add(viewFindViewById);
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_dots_progress_bar_dot_center);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        arrayList.add(viewFindViewById2);
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_dots_progress_bar_dot_right);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        arrayList.add(viewFindViewById3);
        for (ImageView imageView : arrayList) {
            imageView.setScaleX(0.3f);
            imageView.setScaleY(0.3f);
        }
        setupForAccessibility();
        setupAnimations();
    }

    public final void inject(ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Iterator<T> it = this.dots.iterator();
        while (it.hasNext()) {
            ((ImageView) it.next()).setColorFilter(colorScheme.getProgressBar(), PorterDuff.Mode.SRC_IN);
        }
    }

    private final void setupForAccessibility() {
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityUtils.ProgressBarRoleAccessibilityDelegate());
        setContentDescription(getContext().getString(C8369R.string.survicate_micro_dots_progress_bar_content_description));
    }

    private final void setupAnimations() {
        int i = 0;
        for (Object obj : this.dots) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final ImageView imageView = (ImageView) obj;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.3f, 1.0f, 0.3f, 0.3f);
            valueAnimatorOfFloat.setDuration(1500L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setRepeatMode(1);
            valueAnimatorOfFloat.setStartDelay(((long) i) * 500);
            valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.survicate.surveys.presentation.widget.MicroDotsProgressBar$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MicroDotsProgressBar.setupAnimations$lambda$4$lambda$3$lambda$2(imageView, valueAnimator);
                }
            });
            List<ValueAnimator> list = this.animators;
            Intrinsics.checkNotNull(valueAnimatorOfFloat);
            list.add(valueAnimatorOfFloat);
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAnimations$lambda$4$lambda$3$lambda$2(ImageView imageView, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        imageView.setScaleX(fFloatValue);
        imageView.setScaleY(fFloatValue);
    }

    public final void startAnimation() {
        this.shouldAnimate = true;
        if (isAttachedToWindow()) {
            Iterator<T> it = this.animators.iterator();
            while (it.hasNext()) {
                ((ValueAnimator) it.next()).start();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        List<ValueAnimator> list = this.animators;
        if (!this.shouldAnimate) {
            list = null;
        }
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((ValueAnimator) it.next()).start();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<T> it = this.animators.iterator();
        while (it.hasNext()) {
            ((ValueAnimator) it.next()).cancel();
        }
    }

    /* JADX INFO: compiled from: MicroDotsProgressBar.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroDotsProgressBar$Companion;", "", "<init>", "()V", "WHOLE_ANIM_DURATION", "", "DOT_ANIMATION_DURATION", "INIT_SCALE_FACTOR", "", "FINAL_SCALE_FACTOR", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
