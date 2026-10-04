package androidx.compose.material3;

import androidx.collection.MutableIntList;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.MultiContentMeasurePolicy;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
final class TabRowKt$ScrollableTabRowImpl$1$1$2$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ float $minTabWidth;
    final /* synthetic */ TabRowKt$ScrollableTabRowImpl$1$scope$1$1 $scope;
    final /* synthetic */ ScrollableTabData $scrollableTabData;
    final /* synthetic */ int $selectedTabIndex;

    TabRowKt$ScrollableTabRowImpl$1$1$2$1(float f, float f2, TabRowKt$ScrollableTabRowImpl$1$scope$1$1 tabRowKt$ScrollableTabRowImpl$1$scope$1$1, int i, ScrollableTabData scrollableTabData) {
        this.$edgePadding = f;
        this.$minTabWidth = f2;
        this.$scope = tabRowKt$ScrollableTabRowImpl$1$scope$1$1;
        this.$selectedTabIndex = i;
        this.$scrollableTabData = scrollableTabData;
    }

    @Override // androidx.compose.p004ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo2719measure3p2s80s(final MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list.get(0);
        List<? extends Measurable> list3 = list.get(1);
        final int i = measureScope2.mo2185roundToPx0680j_4(this.$edgePadding);
        int size = list2.size();
        int iValueOf = 0;
        List<? extends Measurable> list4 = list2;
        int size2 = list4.size();
        for (int i2 = 0; i2 < size2; i2++) {
            iValueOf = Integer.valueOf(Math.max(iValueOf.intValue(), list2.get(i2).maxIntrinsicHeight(Integer.MAX_VALUE)));
        }
        int iIntValue = iValueOf.intValue();
        int i3 = i * 2;
        int i4 = iIntValue;
        long jM10960copyZbe2FdA$default = Constraints.m10960copyZbe2FdA$default(j, measureScope2.mo2185roundToPx0680j_4(this.$minTabWidth), 0, i4, iIntValue, 2, null);
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = this.$edgePadding;
        ArrayList arrayList = new ArrayList(list2.size());
        int size3 = list4.size();
        for (int i5 = 0; i5 < size3; i5++) {
            arrayList.add(list2.get(i5).mo9625measureBRTryo0(jM10960copyZbe2FdA$default));
        }
        ArrayList arrayList2 = arrayList;
        MutableIntList mutableIntList = new MutableIntList(0, 1, null);
        int size4 = list4.size();
        for (int i6 = 0; i6 < size4; i6++) {
            mutableIntList.add(list2.get(i6).maxIntrinsicWidth(Integer.MAX_VALUE));
        }
        float f = this.$minTabWidth;
        ArrayList arrayList3 = new ArrayList(size);
        int i7 = i3;
        int i8 = 0;
        while (i8 < size) {
            float fM11031unboximpl = ((C1486Dp) ComparisonsKt.maxOf(C1486Dp.m11015boximpl(f), C1486Dp.m11015boximpl(measureScope2.mo2188toDpu2uoSUM(((Placeable) arrayList2.get(i8)).getWidth())))).m11031unboximpl();
            i7 += measureScope2.mo2185roundToPx0680j_4(fM11031unboximpl);
            TabPosition tabPosition = new TabPosition(floatRef.element, fM11031unboximpl, ((C1486Dp) ComparisonsKt.maxOf(C1486Dp.m11015boximpl(C1486Dp.m11017constructorimpl(measureScope2.mo2188toDpu2uoSUM(mutableIntList.get(i8)) - C1486Dp.m11017constructorimpl(TabKt.getHorizontalTextPadding() * 2))), C1486Dp.m11015boximpl(C1486Dp.m11017constructorimpl(24)))).m11031unboximpl(), null);
            floatRef.element = C1486Dp.m11017constructorimpl(floatRef.element + fM11031unboximpl);
            arrayList3.add(tabPosition);
            i8++;
            arrayList2 = arrayList2;
        }
        final ArrayList arrayList4 = arrayList2;
        final ArrayList arrayList5 = arrayList3;
        this.$scope.setTabPositions(arrayList5);
        int i9 = this.$selectedTabIndex;
        ArrayList arrayList6 = new ArrayList(list3.size());
        int size5 = list3.size();
        int i10 = 0;
        while (i10 < size5) {
            int i11 = i4;
            i4 = i11;
            arrayList6.add(list3.get(i10).mo9625measureBRTryo0(Constraints.m10959copyZbe2FdA(j, 0, measureScope2.mo2185roundToPx0680j_4(((TabPosition) arrayList5.get(i9)).getContentWidth()), 0, i11)));
            i10++;
            measureScope2 = measureScope;
            floatRef = floatRef;
            list3 = list3;
        }
        final Ref.FloatRef floatRef2 = floatRef;
        final ArrayList arrayList7 = arrayList6;
        final float f2 = this.$edgePadding;
        final ScrollableTabData scrollableTabData = this.$scrollableTabData;
        final int i12 = this.$selectedTabIndex;
        final int i13 = i4;
        return MeasureScope.layout$default(measureScope, i7, i4, null, new Function1() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$1$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabRowKt$ScrollableTabRowImpl$1$1$2$1.measure_3p2s80s$lambda$7(floatRef2, f2, arrayList4, arrayList7, scrollableTabData, measureScope, i, arrayList5, i12, i13, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$7(Ref.FloatRef floatRef, float f, List list, List list2, ScrollableTabData scrollableTabData, MeasureScope measureScope, int i, List list3, int i2, int i3, Placeable.PlacementScope placementScope) {
        floatRef.element = f;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i4), measureScope.mo2185roundToPx0680j_4(floatRef.element), 0, 0.0f, 4, null);
            floatRef.element = C1486Dp.m11017constructorimpl(floatRef.element + ((TabPosition) list3.get(i4)).getWidth());
        }
        int size2 = list2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Placeable placeable = (Placeable) list2.get(i5);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, Math.max(0, (measureScope.mo2185roundToPx0680j_4(((TabPosition) list3.get(i2)).getWidth()) - placeable.getWidth()) / 2), i3 - placeable.getHeight(), 0.0f, 4, null);
        }
        scrollableTabData.onLaidOut(measureScope, i, list3, i2);
        return Unit.INSTANCE;
    }
}
