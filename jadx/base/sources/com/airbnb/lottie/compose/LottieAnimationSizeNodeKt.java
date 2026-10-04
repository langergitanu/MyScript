package com.airbnb.lottie.compose;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.layout.ScaleFactor;
import androidx.compose.p004ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LottieAnimationSizeNode.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0001\u001a\u001f\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m1599d2 = {"lottieSize", "Landroidx/compose/ui/Modifier;", "width", "", "height", "times", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/geometry/Size;", "scale", "Landroidx/compose/ui/layout/ScaleFactor;", "times-UQTWf7w", "(JJ)J", "lottie-compose_release"}, m1600k = 2, m1601mv = {1, 9, 0}, m1603xi = 48)
public final class LottieAnimationSizeNodeKt {
    public static final Modifier lottieSize(Modifier modifier, int i, int i2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then(new LottieAnimationSizeElement(i, i2));
    }

    /* JADX INFO: renamed from: times-UQTWf7w, reason: not valid java name */
    private static final long m12392timesUQTWf7w(long j, long j2) {
        return IntSizeKt.IntSize((int) (Size.m7972getWidthimpl(j) * ScaleFactor.m9741getScaleXimpl(j2)), (int) (Size.m7969getHeightimpl(j) * ScaleFactor.m9742getScaleYimpl(j2)));
    }
}
