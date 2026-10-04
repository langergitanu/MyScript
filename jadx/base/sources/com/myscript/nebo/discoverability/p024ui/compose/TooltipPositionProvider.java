package com.myscript.nebo.discoverability.p024ui.compose;

import android.graphics.Rect;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntRect;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.p004ui.window.PopupPositionProvider;
import com.myscript.nebo.discoverability.p024ui.TooltipPosition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TooltipPositionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/compose/TooltipPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltipPosition", "Lcom/myscript/nebo/discoverability/ui/TooltipPosition;", "density", "Landroidx/compose/ui/unit/Density;", "provideTargetRect", "Lkotlin/Function0;", "Landroid/graphics/Rect;", "statusBarHeightPx", "", "<init>", "(Lcom/myscript/nebo/discoverability/ui/TooltipPosition;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;I)V", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TooltipPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final Density density;
    private final Function0<Rect> provideTargetRect;
    private final int statusBarHeightPx;
    private final TooltipPosition tooltipPosition;

    public TooltipPositionProvider(TooltipPosition tooltipPosition, Density density, Function0<Rect> provideTargetRect, int i) {
        Intrinsics.checkNotNullParameter(tooltipPosition, "tooltipPosition");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(provideTargetRect, "provideTargetRect");
        this.tooltipPosition = tooltipPosition;
        this.density = density;
        this.provideTargetRect = provideTargetRect;
        this.statusBarHeightPx = i;
    }

    @Override // androidx.compose.p004ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo2153calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        long jM11139constructorimpl;
        Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int iRoundToInt = MathKt.roundToInt(this.density.mo2191toPx0680j_4(C1486Dp.m11017constructorimpl(16)));
        int i = (int) (popupContentSize >> 32);
        int i2 = (int) (popupContentSize & 4294967295L);
        Rect rect = new Rect(0, 0, (int) (windowSize >> 32), (int) (windowSize & 4294967295L));
        rect.offset(0, this.statusBarHeightPx);
        Rect rectInvoke = this.provideTargetRect.invoke();
        if (rectInvoke != null) {
            boolean z = (rectInvoke.right + iRoundToInt) + i < rect.right - iRoundToInt;
            boolean z2 = (rectInvoke.left - i) - iRoundToInt > rect.left + iRoundToInt;
            boolean z3 = (rectInvoke.bottom + i2) + iRoundToInt < rect.bottom - iRoundToInt;
            boolean z4 = (rectInvoke.top - i2) - iRoundToInt > rect.top + iRoundToInt;
            int i3 = rectInvoke.left;
            int i4 = rectInvoke.top;
            if (this.tooltipPosition != TooltipPosition.Right || !z) {
                if (this.tooltipPosition != TooltipPosition.Left || !z2) {
                    if (this.tooltipPosition != TooltipPosition.Bottom || !z3) {
                        if (this.tooltipPosition == TooltipPosition.Top && z4) {
                            jM11139constructorimpl = IntOffset.m11139constructorimpl((((long) i3) << 32) | (((long) ((rectInvoke.top - i2) - iRoundToInt)) & 4294967295L));
                        } else if (z) {
                            jM11139constructorimpl = IntOffset.m11139constructorimpl((((long) (rectInvoke.right + iRoundToInt)) << 32) | (((long) i4) & 4294967295L));
                        } else if (z2) {
                            jM11139constructorimpl = IntOffset.m11139constructorimpl((((long) ((rectInvoke.left - iRoundToInt) - i)) << 32) | (((long) i4) & 4294967295L));
                        } else if (z3) {
                            jM11139constructorimpl = IntOffset.m11139constructorimpl((((long) i3) << 32) | (((long) (rectInvoke.bottom + iRoundToInt)) & 4294967295L));
                        } else {
                            jM11139constructorimpl = IntOffset.m11139constructorimpl((((long) i3) << 32) | (((long) ((rectInvoke.top - i2) - iRoundToInt)) & 4294967295L));
                        }
                    } else {
                        jM11139constructorimpl = IntOffset.m11139constructorimpl((((long) i3) << 32) | (((long) (rectInvoke.bottom + iRoundToInt)) & 4294967295L));
                    }
                } else {
                    jM11139constructorimpl = IntOffset.m11139constructorimpl((((long) ((rectInvoke.left - iRoundToInt) - i)) << 32) | (((long) i4) & 4294967295L));
                }
            } else {
                jM11139constructorimpl = IntOffset.m11139constructorimpl((((long) (rectInvoke.right + iRoundToInt)) << 32) | (((long) i4) & 4294967295L));
            }
            int i5 = rect.top + iRoundToInt;
            int iMax = Math.max(i5, (rect.bottom - i2) - iRoundToInt);
            int i6 = rect.left + iRoundToInt;
            return IntOffset.m11139constructorimpl((((long) RangesKt.coerceIn(IntOffset.m11146getYimpl(jM11139constructorimpl), i5, iMax)) & 4294967295L) | (((long) RangesKt.coerceIn(IntOffset.m11145getXimpl(jM11139constructorimpl), i6, Math.max(i6, (rect.right - i) - iRoundToInt))) << 32));
        }
        return IntOffset.m11139constructorimpl((((long) (rect.left + iRoundToInt)) << 32) | (((long) (rect.top + iRoundToInt)) & 4294967295L));
    }
}
