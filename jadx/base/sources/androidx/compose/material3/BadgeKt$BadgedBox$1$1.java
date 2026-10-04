package androidx.compose.material3;

import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.p004ui.layout.AlignmentLineKt;
import androidx.compose.p004ui.layout.LayoutIdKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.util.ListUtilsKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Badge.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
final class BadgeKt$BadgedBox$1$1 implements MeasurePolicy {
    public static final BadgeKt$BadgedBox$1$1 INSTANCE = new BadgeKt$BadgedBox$1$1();

    BadgeKt$BadgedBox$1$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$2(Placeable placeable, MeasureScope measureScope, Placeable placeable2, Placeable.PlacementScope placementScope) {
        boolean z = placeable.getWidth() > measureScope.mo2185roundToPx0680j_4(BadgeTokens.INSTANCE.m6380getSizeD9Ej5fM());
        float badgeWithContentHorizontalOffset = z ? BadgeKt.getBadgeWithContentHorizontalOffset() : BadgeKt.getBadgeOffset();
        float badgeWithContentVerticalOffset = z ? BadgeKt.getBadgeWithContentVerticalOffset() : BadgeKt.getBadgeOffset();
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, 0, 0, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, Math.min(placeable2.getWidth() - measureScope.mo2185roundToPx0680j_4(badgeWithContentHorizontalOffset), ((int) placementScope.current(BadgeKt.getBadgeEndRuler(), Float.POSITIVE_INFINITY)) - placeable.getWidth()), Math.max((-placeable.getHeight()) + measureScope.mo2185roundToPx0680j_4(badgeWithContentVerticalOffset), (int) placementScope.current(BadgeKt.getBadgeTopRuler(), Float.NEGATIVE_INFINITY)), 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1747measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "badge")) {
                final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Measurable measurable2 = list.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "anchor")) {
                        final Placeable placeableMo9625measureBRTryo02 = measurable2.mo9625measureBRTryo0(j);
                        return measureScope.layout(placeableMo9625measureBRTryo02.getWidth(), placeableMo9625measureBRTryo02.getHeight(), MapsKt.mapOf(TuplesKt.m1606to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(placeableMo9625measureBRTryo02.get(AlignmentLineKt.getFirstBaseline()))), TuplesKt.m1606to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(placeableMo9625measureBRTryo02.get(AlignmentLineKt.getLastBaseline())))), new Function1() { // from class: androidx.compose.material3.BadgeKt$BadgedBox$1$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BadgeKt$BadgedBox$1$1.measure_3p2s80s$lambda$2(placeableMo9625measureBRTryo0, measureScope, placeableMo9625measureBRTryo02, (Placeable.PlacementScope) obj);
                            }
                        });
                    }
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
