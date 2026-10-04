package com.myscript.nebo.penpanel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorUpdateAnimator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, m1599d2 = {"com/myscript/nebo/penpanel/ColorUpdateAnimator$impl$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationRepeat", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ColorUpdateAnimator$impl$1$2 implements Animator.AnimatorListener {
    final /* synthetic */ ValueAnimator $this_apply;
    final /* synthetic */ ColorUpdateAnimator this$0;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    ColorUpdateAnimator$impl$1$2(ValueAnimator valueAnimator, ColorUpdateAnimator colorUpdateAnimator) {
        this.$this_apply = valueAnimator;
        this.this$0 = colorUpdateAnimator;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$this_apply.removeAllUpdateListeners();
        this.$this_apply.removeListener(this);
        this.this$0.onEndDelegate.invoke();
        this.this$0.onEndDelegate = new Function0() { // from class: com.myscript.nebo.penpanel.ColorUpdateAnimator$impl$1$2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$this_apply.removeAllUpdateListeners();
        this.$this_apply.removeListener(this);
    }
}
