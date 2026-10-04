package androidx.compose.material;

import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.layout.AlignmentLineKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
final class ListItemKt$OffsetToBaselineOrCenter$1$1 implements MeasurePolicy {
    final /* synthetic */ float $offset;

    ListItemKt$OffsetToBaselineOrCenter$1$1(float f) {
        this.$offset = f;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1747measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int iMax;
        final int iM11146getYimpl;
        final Placeable placeableMo9625measureBRTryo0 = list.get(0).mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
        int i = placeableMo9625measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
        if (i != Integer.MIN_VALUE) {
            iM11146getYimpl = measureScope.mo2185roundToPx0680j_4(this.$offset) - i;
            iMax = Math.max(Constraints.m10971getMinHeightimpl(j), placeableMo9625measureBRTryo0.getHeight() + iM11146getYimpl);
        } else {
            iMax = Math.max(Constraints.m10971getMinHeightimpl(j), placeableMo9625measureBRTryo0.getHeight());
            iM11146getYimpl = IntOffset.m11146getYimpl(Alignment.INSTANCE.getCenter().mo7571alignKFBX0sM(IntSize.INSTANCE.m11193getZeroYbymL2g(), IntSize.m11183constructorimpl((((long) 0) << 32) | (((long) (iMax - placeableMo9625measureBRTryo0.getHeight())) & 4294967295L)), measureScope.getLayoutDirection()));
        }
        return MeasureScope.layout$default(measureScope, placeableMo9625measureBRTryo0.getWidth(), iMax, null, new Function1() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListItemKt$OffsetToBaselineOrCenter$1$1.measure_3p2s80s$lambda$0(placeableMo9625measureBRTryo0, iM11146getYimpl, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, int i, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
