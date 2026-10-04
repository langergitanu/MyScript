package com.survicate.surveys.presentation.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.survicate.surveys.presentation.widget.MicroSurveyPointImage$animateHeightToMatchView$1$valueAnimator$1$1 */
/* JADX INFO: compiled from: MicroSurveyPointImage.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
final class C8473x8478861d implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ View $this_animateHeightToMatchView;

    C8473x8478861d(View view) {
        this.$this_animateHeightToMatchView = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        View view = this.$this_animateHeightToMatchView;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        view.setLayoutParams(layoutParams);
        this.$this_animateHeightToMatchView.requestLayout();
    }
}
