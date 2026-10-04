package androidx.compose.material;

import androidx.compose.p004ui.layout.AlignmentLineKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
final class ListItemKt$BaselinesOffsetColumn$1$1 implements MeasurePolicy {
    final /* synthetic */ List<C1486Dp> $offsets;

    ListItemKt$BaselinesOffsetColumn$1$1(List<C1486Dp> list) {
        this.$offsets = list;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1747measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int height;
        long jM10960copyZbe2FdA$default = Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 3, null);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).mo9625measureBRTryo0(jM10960copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        int iValueOf = 0;
        ArrayList arrayList3 = arrayList2;
        int size2 = arrayList3.size();
        for (int i2 = 0; i2 < size2; i2++) {
            iValueOf = Integer.valueOf(Math.max(iValueOf.intValue(), ((Placeable) arrayList2.get(i2)).getWidth()));
        }
        int iIntValue = iValueOf.intValue();
        final int[] iArr = new int[arrayList2.size()];
        List<C1486Dp> list2 = this.$offsets;
        int size3 = arrayList3.size();
        int height2 = 0;
        for (int i3 = 0; i3 < size3; i3++) {
            Placeable placeable = (Placeable) arrayList2.get(i3);
            if (i3 > 0) {
                int i4 = i3 - 1;
                height = ((Placeable) arrayList2.get(i4)).getHeight() - ((Placeable) arrayList2.get(i4)).get(AlignmentLineKt.getLastBaseline());
            } else {
                height = 0;
            }
            int iMax = Math.max(0, (measureScope.mo2185roundToPx0680j_4(list2.get(i3).m11031unboximpl()) - placeable.get(AlignmentLineKt.getFirstBaseline())) - height);
            iArr[i3] = iMax + height2;
            height2 += iMax + placeable.getHeight();
        }
        return MeasureScope.layout$default(measureScope, iIntValue, height2, null, new Function1() { // from class: androidx.compose.material.ListItemKt$BaselinesOffsetColumn$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListItemKt$BaselinesOffsetColumn$1$1.measure_3p2s80s$lambda$3(arrayList2, iArr, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$3(List list, int[] iArr, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i), 0, iArr[i], 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
