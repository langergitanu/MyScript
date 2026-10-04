package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.p004ui.layout.LayoutIdKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.util.ListUtilsKt;
import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
final class SearchBarKt$SearchBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    SearchBarKt$SearchBarLayout$2$1(Animatable<Float, AnimationVector1D> animatable, MutableWindowInsets mutableWindowInsets, MutableState<BackEventCompat> mutableState, MutableFloatState mutableFloatState, MutableState<BackEventCompat> mutableState2) {
        this.$animationProgress = animatable;
        this.$unconsumedInsets = mutableWindowInsets;
        this.$currentBackEvent = mutableState;
        this.$finalBackProgress = mutableFloatState;
        this.$firstBackEvent = mutableState2;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1747measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, final long j) {
        Measurable measurable;
        final Placeable placeableMo9625measureBRTryo0;
        int i;
        int iM10969getMaxHeightimpl;
        MeasureScope measureScope2 = measureScope;
        long j2 = j;
        final float fFloatValue = this.$animationProgress.getValue().floatValue();
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (i2 < size) {
            Measurable measurable2 = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "InputField")) {
                int size2 = list2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Measurable measurable3 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Surface")) {
                        int size3 = list2.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size3) {
                                measurable = null;
                                break;
                            }
                            measurable = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Content")) {
                                break;
                            }
                            i4++;
                        }
                        Measurable measurable4 = measurable;
                        final int top = this.$unconsumedInsets.getTop(measureScope2) + measureScope2.mo2185roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int i5 = measureScope2.mo2185roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int iM10987constrainWidthK40F9xA = ConstraintsKt.m10987constrainWidthK40F9xA(j2, measurable2.maxIntrinsicWidth(Constraints.m10969getMaxHeightimpl(j2)));
                        int iM10986constrainHeightK40F9xA = ConstraintsKt.m10986constrainHeightK40F9xA(j2, measurable2.minIntrinsicHeight(Constraints.m10970getMaxWidthimpl(j2)));
                        int iRoundToInt = MathKt.roundToInt(Constraints.m10970getMaxWidthimpl(j2) * 0.9f);
                        int iRoundToInt2 = MathKt.roundToInt(Constraints.m10969getMaxHeightimpl(j2) * 0.9f);
                        final float fCalculatePredictiveBackMultiplier = SearchBarKt.calculatePredictiveBackMultiplier(this.$currentBackEvent.getValue(), fFloatValue, this.$finalBackProgress.getFloatValue());
                        int iLerp = MathHelpersKt.lerp(iM10987constrainWidthK40F9xA, iRoundToInt, fCalculatePredictiveBackMultiplier);
                        int i6 = top + iM10986constrainHeightK40F9xA;
                        int iLerp2 = MathHelpersKt.lerp(i6, iRoundToInt2, fCalculatePredictiveBackMultiplier);
                        int iM10970getMaxWidthimpl = Constraints.m10970getMaxWidthimpl(j2);
                        int iM10969getMaxHeightimpl2 = Constraints.m10969getMaxHeightimpl(j2);
                        int iLerp3 = MathHelpersKt.lerp(iLerp, iM10970getMaxWidthimpl, fFloatValue);
                        final int iLerp4 = MathHelpersKt.lerp(iLerp2, iM10969getMaxHeightimpl2, fFloatValue);
                        final int iLerp5 = MathHelpersKt.lerp(top, 0, fFloatValue);
                        final int iLerp6 = MathHelpersKt.lerp(0, i5, fFloatValue);
                        final Placeable placeableMo9625measureBRTryo02 = measurable2.mo9625measureBRTryo0(ConstraintsKt.Constraints(iLerp3, iM10970getMaxWidthimpl, iM10986constrainHeightK40F9xA, iM10986constrainHeightK40F9xA));
                        int width = placeableMo9625measureBRTryo02.getWidth();
                        final Placeable placeableMo9625measureBRTryo03 = measurable3.mo9625measureBRTryo0(Constraints.INSTANCE.m10980fixedJhjzzOo(width, iLerp4 - iLerp5));
                        if (measurable4 != null) {
                            if (Constraints.m10965getHasBoundedHeightimpl(j)) {
                                i = 0;
                                iM10969getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m10969getMaxHeightimpl(j) - (i6 + i5), 0);
                            } else {
                                i = 0;
                                iM10969getMaxHeightimpl = Constraints.m10969getMaxHeightimpl(j);
                            }
                            placeableMo9625measureBRTryo0 = measurable4.mo9625measureBRTryo0(ConstraintsKt.Constraints(width, width, i, iM10969getMaxHeightimpl));
                        } else {
                            placeableMo9625measureBRTryo0 = null;
                        }
                        final MutableState<BackEventCompat> mutableState = this.$currentBackEvent;
                        final MutableState<BackEventCompat> mutableState2 = this.$firstBackEvent;
                        return MeasureScope.layout$default(measureScope, width, iLerp4, null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$SearchBarLayout$2$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchBarKt$SearchBarLayout$2$1.measure_3p2s80s$lambda$3(measureScope, j, mutableState, fFloatValue, fCalculatePredictiveBackMultiplier, mutableState2, iLerp4, placeableMo9625measureBRTryo03, iLerp5, placeableMo9625measureBRTryo02, top, placeableMo9625measureBRTryo0, iLerp6, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i3++;
                    measureScope2 = measureScope;
                    j2 = j;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i2++;
            measureScope2 = measureScope;
            j2 = j;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$3(MeasureScope measureScope, long j, MutableState mutableState, float f, float f2, MutableState mutableState2, int i, Placeable placeable, int i2, Placeable placeable2, int i3, Placeable placeable3, int i4, Placeable.PlacementScope placementScope) {
        int i5 = measureScope.mo2185roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMinMargin);
        int iM5532calculatePredictiveBackOffsetXrOvwMX4 = SearchBarKt.m5532calculatePredictiveBackOffsetXrOvwMX4(j, i5, (BackEventCompat) mutableState.getValue(), measureScope.getLayoutDirection(), f, f2);
        int iM5533calculatePredictiveBackOffsetYdzo92Q0 = SearchBarKt.m5533calculatePredictiveBackOffsetYdzo92Q0(j, i5, (BackEventCompat) mutableState.getValue(), (BackEventCompat) mutableState2.getValue(), i, measureScope.mo2185roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMaxOffsetY), f2);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iM5532calculatePredictiveBackOffsetXrOvwMX4, iM5533calculatePredictiveBackOffsetYdzo92Q0 + i2, 0.0f, 4, null);
        int i6 = iM5533calculatePredictiveBackOffsetYdzo92Q0 + i3;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, iM5532calculatePredictiveBackOffsetXrOvwMX4, i6, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iM5532calculatePredictiveBackOffsetXrOvwMX4, i6 + placeable2.getHeight() + i4, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
