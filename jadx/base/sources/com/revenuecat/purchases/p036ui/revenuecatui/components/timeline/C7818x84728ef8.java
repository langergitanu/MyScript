package com.revenuecat.purchases.p036ui.revenuecatui.components.timeline;

import androidx.compose.p004ui.unit.C1486Dp;
import com.revenuecat.purchases.p036ui.revenuecatui.components.timeline.TimelineComponentState;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.SizeConstraintExtensionsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$2$biggestIconWidth$2$1 */
/* JADX INFO: compiled from: TimelineComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, m1599d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Dp;", "invoke-lTKBWiU"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
final class C7818x84728ef8 extends Lambda implements Function0<C1486Dp> {
    final /* synthetic */ TimelineComponentState $timelineState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C7818x84728ef8(TimelineComponentState timelineComponentState) {
        super(0);
        this.$timelineState = timelineComponentState;
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke-lTKBWiU, reason: not valid java name and merged with bridge method [inline-methods] */
    public final C1486Dp invoke() {
        C1486Dp c1486Dp;
        Iterator it = this.$timelineState.getItems().iterator();
        if (it.hasNext()) {
            C1486Dp c1486DpDpOrNull = SizeConstraintExtensionsKt.dpOrNull(((TimelineComponentState.ItemState) it.next()).getIcon().getSize().getWidth());
            C1486Dp c1486DpM11015boximpl = C1486Dp.m11015boximpl(c1486DpDpOrNull != null ? c1486DpDpOrNull.m11031unboximpl() : C1486Dp.m11017constructorimpl(0));
            while (it.hasNext()) {
                C1486Dp c1486DpDpOrNull2 = SizeConstraintExtensionsKt.dpOrNull(((TimelineComponentState.ItemState) it.next()).getIcon().getSize().getWidth());
                C1486Dp c1486DpM11015boximpl2 = C1486Dp.m11015boximpl(c1486DpDpOrNull2 != null ? c1486DpDpOrNull2.m11031unboximpl() : C1486Dp.m11017constructorimpl(0));
                if (c1486DpM11015boximpl.compareTo(c1486DpM11015boximpl2) < 0) {
                    c1486DpM11015boximpl = c1486DpM11015boximpl2;
                }
            }
            c1486Dp = c1486DpM11015boximpl;
        } else {
            c1486Dp = null;
        }
        return c1486Dp;
    }
}
