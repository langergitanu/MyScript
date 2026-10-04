package androidx.compose.material;

import androidx.compose.p004ui.layout.AlignmentLineKt;
import androidx.compose.p004ui.layout.LayoutIdKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
final class AlertDialogKt$AlertDialogBaselineLayout$2$1 implements MeasurePolicy {
    public static final AlertDialogKt$AlertDialogBaselineLayout$2$1 INSTANCE = new AlertDialogKt$AlertDialogBaselineLayout$2$1();

    AlertDialogKt$AlertDialogBaselineLayout$2$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$7(Placeable placeable, int i, Placeable placeable2, int i2, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, i, 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable2, 0, i2, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5  */
    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MeasureResult mo1747measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Measurable measurable;
        Measurable measurable2;
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        final int i;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                measurable = null;
                break;
            }
            measurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "title")) {
                break;
            }
            i2++;
        }
        Measurable measurable3 = measurable;
        final Placeable placeableMo9625measureBRTryo0 = measurable3 != null ? measurable3.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
        int size2 = list2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "text")) {
                break;
            }
            i3++;
        }
        Measurable measurable4 = measurable2;
        final Placeable placeableMo9625measureBRTryo02 = measurable4 != null ? measurable4.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
        int iMax = Math.max(placeableMo9625measureBRTryo0 != null ? placeableMo9625measureBRTryo0.getWidth() : 0, placeableMo9625measureBRTryo02 != null ? placeableMo9625measureBRTryo02.getWidth() : 0);
        if (placeableMo9625measureBRTryo0 == null) {
            iIntValue = 0;
        } else {
            int iIntValue4 = Integer.valueOf(placeableMo9625measureBRTryo0.get(AlignmentLineKt.getFirstBaseline())).intValue();
            Integer numValueOf = iIntValue4 == Integer.MIN_VALUE ? null : Integer.valueOf(iIntValue4);
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            }
        }
        if (placeableMo9625measureBRTryo0 == null) {
            iIntValue2 = 0;
        } else {
            int i4 = placeableMo9625measureBRTryo0.get(AlignmentLineKt.getLastBaseline());
            Integer numValueOf2 = i4 == Integer.MIN_VALUE ? null : Integer.valueOf(i4);
            if (numValueOf2 != null) {
                iIntValue2 = numValueOf2.intValue();
            }
        }
        final int i5 = measureScope.mo2184roundToPxR2X_6o(AlertDialogKt.TitleBaselineDistanceFromTop) - iIntValue;
        if (placeableMo9625measureBRTryo02 == null) {
            iIntValue3 = 0;
        } else {
            int i6 = placeableMo9625measureBRTryo02.get(AlignmentLineKt.getFirstBaseline());
            Integer numValueOf3 = i6 != Integer.MIN_VALUE ? Integer.valueOf(i6) : null;
            if (numValueOf3 != null) {
                iIntValue3 = numValueOf3.intValue();
            }
        }
        int i7 = placeableMo9625measureBRTryo0 == null ? measureScope.mo2184roundToPxR2X_6o(AlertDialogKt.TextBaselineDistanceFromTop) : measureScope.mo2184roundToPxR2X_6o(AlertDialogKt.TextBaselineDistanceFromTitle);
        int height = placeableMo9625measureBRTryo0 != null ? placeableMo9625measureBRTryo0.getHeight() + i5 : 0;
        if (placeableMo9625measureBRTryo0 == null) {
            i = i7 - iIntValue3;
        } else {
            i = (iIntValue2 == 0 ? height - iIntValue3 : (i5 + iIntValue2) - iIntValue3) + i7;
        }
        if (placeableMo9625measureBRTryo02 != null) {
            if (iIntValue2 == 0) {
                height = (placeableMo9625measureBRTryo02.getHeight() + i7) - iIntValue3;
            } else {
                height = ((placeableMo9625measureBRTryo02.getHeight() + i7) - iIntValue3) - ((placeableMo9625measureBRTryo0 != null ? placeableMo9625measureBRTryo0.getHeight() : 0) - iIntValue2);
            }
        }
        return MeasureScope.layout$default(measureScope, iMax, height + height, null, new Function1() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AlertDialogKt$AlertDialogBaselineLayout$2$1.measure_3p2s80s$lambda$7(placeableMo9625measureBRTryo0, i5, placeableMo9625measureBRTryo02, i, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }
}
