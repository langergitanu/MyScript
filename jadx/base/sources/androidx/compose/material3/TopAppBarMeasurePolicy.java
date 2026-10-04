package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.layout.AlignmentLineKt;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutIdKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.p004ui.util.ListUtilsKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\"\u0010#\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010&\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010'\u001a\u00020\tH\u0016J\"\u0010(\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010)\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010'\u001a\u00020\tH\u0016JK\u0010*\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\tH\u0002¢\u0006\u0004\b2\u00103R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u00064"}, m1599d2 = {"Landroidx/compose/material3/TopAppBarMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scrolledOffset", "Landroidx/compose/material3/internal/FloatProducer;", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "titleBottomPadding", "", "height", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Landroidx/compose/material3/internal/FloatProducer;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;IFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getScrolledOffset", "()Landroidx/compose/material3/internal/FloatProducer;", "getTitleVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTitleHorizontalAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "getTitleBottomPadding", "()I", "getHeight-D9Ej5fM", "()F", "F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "placeTopAppBar", "layoutHeight", "maxLayoutHeight", "navigationIconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "titlePlaceable", "actionIconsPlaceable", "titleBaseline", "placeTopAppBar-mpW86Vk", "(Landroidx/compose/ui/layout/MeasureScope;JIILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;I)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
final class TopAppBarMeasurePolicy implements MeasurePolicy {
    private final float height;
    private final FloatProducer scrolledOffset;
    private final int titleBottomPadding;
    private final Alignment.Horizontal titleHorizontalAlignment;
    private final Arrangement.Vertical titleVerticalArrangement;

    public /* synthetic */ TopAppBarMeasurePolicy(FloatProducer floatProducer, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(floatProducer, vertical, horizontal, i, f);
    }

    private TopAppBarMeasurePolicy(FloatProducer floatProducer, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, float f) {
        this.scrolledOffset = floatProducer;
        this.titleVerticalArrangement = vertical;
        this.titleHorizontalAlignment = horizontal;
        this.titleBottomPadding = i;
        this.height = f;
    }

    public final FloatProducer getScrolledOffset() {
        return this.scrolledOffset;
    }

    public final Arrangement.Vertical getTitleVerticalArrangement() {
        return this.titleVerticalArrangement;
    }

    public final Alignment.Horizontal getTitleHorizontalAlignment() {
        return this.titleHorizontalAlignment;
    }

    public final int getTitleBottomPadding() {
        return this.titleBottomPadding;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getHeight() {
        return this.height;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Integer num;
        int i2 = intrinsicMeasureScope.mo2185roundToPx0680j_4(this.height);
        if (list.isEmpty()) {
            num = null;
        } else {
            Integer numValueOf = Integer.valueOf(list.get(0).minIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(list.get(i3).minIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            num = numValueOf;
        }
        Integer num2 = num;
        return Math.max(i2, num2 != null ? num2.intValue() : 0);
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Integer num;
        int i2 = intrinsicMeasureScope.mo2185roundToPx0680j_4(this.height);
        if (list.isEmpty()) {
            num = null;
        } else {
            Integer numValueOf = Integer.valueOf(list.get(0).maxIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(list.get(i3).maxIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            num = numValueOf;
        }
        Integer num2 = num;
        return Math.max(i2, num2 != null ? num2.intValue() : 0);
    }

    /* JADX INFO: renamed from: placeTopAppBar-mpW86Vk, reason: not valid java name */
    private final MeasureResult m6112placeTopAppBarmpW86Vk(final MeasureScope measureScope, final long j, final int i, final int i2, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final int i3) {
        return MeasureScope.layout$default(measureScope, Constraints.m10970getMaxWidthimpl(j), i, null, new Function1() { // from class: androidx.compose.material3.TopAppBarMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TopAppBarMeasurePolicy.placeTopAppBar_mpW86Vk$lambda$8(placeable, i, placeable2, placeable3, j, measureScope, this, i3, i2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit placeTopAppBar_mpW86Vk$lambda$8(Placeable placeable, int i, Placeable placeable2, Placeable placeable3, long j, MeasureScope measureScope, TopAppBarMeasurePolicy topAppBarMeasurePolicy, int i2, int i3, Placeable.PlacementScope placementScope) {
        int iM10970getMaxWidthimpl;
        Arrangement.Vertical vertical;
        int i4;
        int height;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, null);
        int iMax = Math.max(measureScope.mo2185roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), placeable.getWidth());
        int width = placeable3.getWidth();
        int iAlign = topAppBarMeasurePolicy.titleHorizontalAlignment.align(placeable2.getWidth(), Constraints.m10970getMaxWidthimpl(j), LayoutDirection.Ltr);
        if (iAlign >= iMax) {
            if (placeable2.getWidth() + iAlign > Constraints.m10970getMaxWidthimpl(j) - width) {
                iM10970getMaxWidthimpl = (Constraints.m10970getMaxWidthimpl(j) - width) - (placeable2.getWidth() + iAlign);
            }
            int i5 = iAlign;
            vertical = topAppBarMeasurePolicy.titleVerticalArrangement;
            if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
                i4 = 0;
                if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getBottom())) {
                    int i6 = topAppBarMeasurePolicy.titleBottomPadding;
                    if (i6 == 0) {
                        height = i - placeable2.getHeight();
                    } else {
                        int height2 = i6 - (placeable2.getHeight() - i2);
                        int height3 = placeable2.getHeight() + height2;
                        if (height3 > i3) {
                            height2 -= height3 - i3;
                        }
                        height = (i - placeable2.getHeight()) - Math.max(0, height2);
                    }
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i5, i4, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, Constraints.m10970getMaxWidthimpl(j) - placeable3.getWidth(), (i - placeable3.getHeight()) / 2, 0.0f, 4, null);
                return Unit.INSTANCE;
            }
            height = (i - placeable2.getHeight()) / 2;
            i4 = height;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i5, i4, 0.0f, 4, null);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, Constraints.m10970getMaxWidthimpl(j) - placeable3.getWidth(), (i - placeable3.getHeight()) / 2, 0.0f, 4, null);
            return Unit.INSTANCE;
        }
        iM10970getMaxWidthimpl = iMax - iAlign;
        iAlign += iM10970getMaxWidthimpl;
        int i52 = iAlign;
        vertical = topAppBarMeasurePolicy.titleVerticalArrangement;
        if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getCenter())) {
        }
        i4 = height;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i52, i4, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, Constraints.m10970getMaxWidthimpl(j) - placeable3.getWidth(), (i - placeable3.getHeight()) / 2, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1747measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int iCoerceAtLeast;
        TopAppBarMeasurePolicy topAppBarMeasurePolicy = this;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i = 0;
        while (i < size) {
            Measurable measurable = list.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "navigationIcon")) {
                Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "actionIcons")) {
                        Placeable placeableMo9625measureBRTryo02 = measurable2.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
                        if (Constraints.m10970getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                            iCoerceAtLeast = Constraints.m10970getMaxWidthimpl(j);
                        } else {
                            iCoerceAtLeast = RangesKt.coerceAtLeast((Constraints.m10970getMaxWidthimpl(j) - placeableMo9625measureBRTryo0.getWidth()) - placeableMo9625measureBRTryo02.getWidth(), 0);
                        }
                        int i3 = iCoerceAtLeast;
                        int size3 = list2.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            Measurable measurable3 = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "title")) {
                                Placeable placeableMo9625measureBRTryo03 = measurable3.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, i3, 0, 0, 12, null));
                                int i5 = placeableMo9625measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE ? placeableMo9625measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) : 0;
                                float fInvoke = topAppBarMeasurePolicy.scrolledOffset.invoke();
                                int iRoundToInt = Float.isNaN(fInvoke) ? 0 : MathKt.roundToInt(fInvoke);
                                int iMax = Math.max(measureScope.mo2185roundToPx0680j_4(topAppBarMeasurePolicy.height), placeableMo9625measureBRTryo03.getHeight());
                                return topAppBarMeasurePolicy.m6112placeTopAppBarmpW86Vk(measureScope, j, Constraints.m10969getMaxHeightimpl(j) == Integer.MAX_VALUE ? iMax : RangesKt.coerceAtLeast(iRoundToInt + iMax, 0), iMax, placeableMo9625measureBRTryo0, placeableMo9625measureBRTryo03, placeableMo9625measureBRTryo02, i5);
                            }
                            i4++;
                            topAppBarMeasurePolicy = this;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i2++;
                    topAppBarMeasurePolicy = this;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i++;
            topAppBarMeasurePolicy = this;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        int size = list.size();
        int iMinIntrinsicWidth = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iMinIntrinsicWidth += list.get(i2).minIntrinsicWidth(i);
        }
        return iMinIntrinsicWidth;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        int size = list.size();
        int iMaxIntrinsicWidth = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iMaxIntrinsicWidth += list.get(i2).maxIntrinsicWidth(i);
        }
        return iMaxIntrinsicWidth;
    }
}
