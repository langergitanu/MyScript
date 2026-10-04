package androidx.compose.material3;

import androidx.compose.p004ui.layout.AlignmentLineKt;
import androidx.compose.p004ui.layout.LayoutIdKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.util.ListUtilsKt;
import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Tab.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
final class TabKt$TabBaselineLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX WARN: Multi-variable type inference failed */
    TabKt$TabBaselineLayout$2$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        this.$text = function2;
        this.$icon = function22;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1747measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Placeable placeableMo9625measureBRTryo0;
        Placeable placeableMo9625measureBRTryo02;
        if (this.$text != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Measurable measurable = list.get(i);
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "text")) {
                    placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                }
            }
            ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
            throw new KotlinNothingValueException();
        }
        placeableMo9625measureBRTryo0 = null;
        if (this.$icon != null) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Measurable measurable2 = list.get(i2);
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                    placeableMo9625measureBRTryo02 = measurable2.mo9625measureBRTryo0(j);
                }
            }
            ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
            throw new KotlinNothingValueException();
        }
        placeableMo9625measureBRTryo02 = null;
        final int iMax = Math.max(placeableMo9625measureBRTryo0 != null ? placeableMo9625measureBRTryo0.getWidth() : 0, placeableMo9625measureBRTryo02 != null ? placeableMo9625measureBRTryo02.getWidth() : 0);
        final int iMax2 = Math.max(measureScope.mo2185roundToPx0680j_4((placeableMo9625measureBRTryo0 == null || placeableMo9625measureBRTryo02 == null) ? TabKt.SmallTabHeight : TabKt.LargeTabHeight), (placeableMo9625measureBRTryo02 != null ? placeableMo9625measureBRTryo02.getHeight() : 0) + (placeableMo9625measureBRTryo0 != null ? placeableMo9625measureBRTryo0.getHeight() : 0) + measureScope.mo2184roundToPxR2X_6o(TabKt.IconDistanceFromBaseline));
        final Integer numValueOf = placeableMo9625measureBRTryo0 != null ? Integer.valueOf(placeableMo9625measureBRTryo0.get(AlignmentLineKt.getFirstBaseline())) : null;
        final Integer numValueOf2 = placeableMo9625measureBRTryo0 != null ? Integer.valueOf(placeableMo9625measureBRTryo0.get(AlignmentLineKt.getLastBaseline())) : null;
        final Placeable placeable = placeableMo9625measureBRTryo0;
        final Placeable placeable2 = placeableMo9625measureBRTryo02;
        return MeasureScope.layout$default(measureScope, iMax, iMax2, null, new Function1() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabKt$TabBaselineLayout$2$1.measure_3p2s80s$lambda$4(placeable, placeable2, measureScope, iMax, iMax2, numValueOf, numValueOf2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$4(Placeable placeable, Placeable placeable2, MeasureScope measureScope, int i, int i2, Integer num, Integer num2, Placeable.PlacementScope placementScope) {
        if (placeable != null && placeable2 != null) {
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Intrinsics.checkNotNull(num2);
            TabKt.placeTextAndIcon(placementScope, measureScope, placeable, placeable2, i, i2, iIntValue, num2.intValue());
        } else if (placeable != null) {
            TabKt.placeTextOrIcon(placementScope, placeable, i2);
        } else if (placeable2 != null) {
            TabKt.placeTextOrIcon(placementScope, placeable2, i2);
        }
        return Unit.INSTANCE;
    }
}
