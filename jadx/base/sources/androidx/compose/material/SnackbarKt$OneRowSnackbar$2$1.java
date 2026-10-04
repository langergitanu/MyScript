package androidx.compose.material;

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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
final class SnackbarKt$OneRowSnackbar$2$1 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $textTag;

    SnackbarKt$OneRowSnackbar$2$1(String str, String str2) {
        this.$actionTag = str;
        this.$textTag = str2;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1747measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int height;
        int iMax;
        MeasureScope measureScope2 = measureScope;
        String str = this.$actionTag;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int height2 = 0;
        int i = 0;
        while (i < size) {
            Measurable measurable = list.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str)) {
                long j2 = j;
                final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(j2);
                int iCoerceAtLeast = RangesKt.coerceAtLeast((Constraints.m10970getMaxWidthimpl(j2) - placeableMo9625measureBRTryo0.getWidth()) - measureScope2.mo2185roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing), Constraints.m10972getMinWidthimpl(j2));
                String str2 = this.$textTag;
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str2)) {
                        final Placeable placeableMo9625measureBRTryo02 = measurable2.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j2, 0, iCoerceAtLeast, 0, 0, 9, null));
                        int i3 = placeableMo9625measureBRTryo02.get(AlignmentLineKt.getFirstBaseline());
                        int i4 = placeableMo9625measureBRTryo02.get(AlignmentLineKt.getLastBaseline());
                        boolean z = true;
                        boolean z2 = (i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE) ? false : true;
                        if (i3 != i4 && z2) {
                            z = false;
                        }
                        final int iM10970getMaxWidthimpl = Constraints.m10970getMaxWidthimpl(j) - placeableMo9625measureBRTryo0.getWidth();
                        if (!z) {
                            height = measureScope2.mo2185roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i3;
                            iMax = Math.max(measureScope2.mo2185roundToPx0680j_4(SnackbarKt.SnackbarMinHeightTwoLines), placeableMo9625measureBRTryo02.getHeight() + height);
                            height2 = (iMax - placeableMo9625measureBRTryo0.getHeight()) / 2;
                        } else {
                            iMax = Math.max(measureScope2.mo2185roundToPx0680j_4(SnackbarKt.SnackbarMinHeightOneLine), placeableMo9625measureBRTryo0.getHeight());
                            height = (iMax - placeableMo9625measureBRTryo02.getHeight()) / 2;
                            int i5 = placeableMo9625measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                            if (i5 != Integer.MIN_VALUE) {
                                height2 = (i3 + height) - i5;
                            }
                        }
                        final int i6 = height2;
                        final int i7 = height;
                        return MeasureScope.layout$default(measureScope2, Constraints.m10970getMaxWidthimpl(j), iMax, null, new Function1() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$2$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SnackbarKt$OneRowSnackbar$2$1.measure_3p2s80s$lambda$3(placeableMo9625measureBRTryo02, i7, placeableMo9625measureBRTryo0, iM10970getMaxWidthimpl, i6, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i2++;
                    measureScope2 = measureScope;
                    j2 = j;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i++;
            measureScope2 = measureScope;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$3(Placeable placeable, int i, Placeable placeable2, int i2, int i3, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2, i3, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
