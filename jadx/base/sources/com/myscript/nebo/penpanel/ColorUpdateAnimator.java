package com.myscript.nebo.penpanel;

import android.animation.ValueAnimator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorUpdateAnimator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0013\u001a\u00020\t2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\u0015\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ColorUpdateAnimator;", "", "fromColor", "", "toColor", TypedValues.TransitionType.S_DURATION, "", "onUpdate", "Lkotlin/Function0;", "", "<init>", "(IIJLkotlin/jvm/functions/Function0;)V", "onEndDelegate", "impl", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animatedValue", "getAnimatedValue", "()I", TtmlNode.START, "onEnd", "cancel", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ColorUpdateAnimator {
    private final long duration;
    private final int fromColor;
    private final ValueAnimator impl;
    private Function0<Unit> onEndDelegate;
    private final int toColor;

    public ColorUpdateAnimator(int i, int i2, long j, final Function0<Unit> onUpdate) {
        Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
        this.fromColor = i;
        this.toColor = i2;
        this.duration = j;
        this.onEndDelegate = new Function0() { // from class: com.myscript.nebo.penpanel.ColorUpdateAnimator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
        ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(i, i2);
        valueAnimatorOfArgb.setDuration(j);
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.myscript.nebo.penpanel.ColorUpdateAnimator$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ColorUpdateAnimator.impl$lambda$0$0(onUpdate, valueAnimator);
            }
        });
        valueAnimatorOfArgb.addListener(new ColorUpdateAnimator$impl$1$2(valueAnimatorOfArgb, this));
        this.impl = valueAnimatorOfArgb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void impl$lambda$0$0(Function0 function0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
    }

    public final int getAnimatedValue() {
        Object animatedValue = this.impl.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) animatedValue).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void start$default(ColorUpdateAnimator colorUpdateAnimator, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0() { // from class: com.myscript.nebo.penpanel.ColorUpdateAnimator$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        colorUpdateAnimator.start(function0);
    }

    public final void start(Function0<Unit> onEnd) {
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        this.onEndDelegate = onEnd;
        this.impl.start();
    }

    public final void cancel() {
        this.impl.cancel();
    }
}
