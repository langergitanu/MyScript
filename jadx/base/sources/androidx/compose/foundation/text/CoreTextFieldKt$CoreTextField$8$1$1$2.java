package androidx.compose.foundation.text;

import androidx.compose.p004ui.layout.AlignmentLineKt;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.input.OffsetMapping;
import androidx.compose.p004ui.text.input.TextFieldValue;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\f\u001a\u00020\r*\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0016¨\u0006\u0011"}, m1599d2 = {"androidx/compose/foundation/text/CoreTextFieldKt$CoreTextField$8$1$1$2", "Landroidx/compose/ui/layout/MeasurePolicy;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class CoreTextFieldKt$CoreTextField$8$1$1$2 implements MeasurePolicy {
    final /* synthetic */ Density $density;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ LegacyTextFieldState $state;
    final /* synthetic */ TextFieldValue $value;

    /* JADX WARN: Multi-variable type inference failed */
    CoreTextFieldKt$CoreTextField$8$1$1$2(LegacyTextFieldState legacyTextFieldState, Function1<? super TextLayoutResult, Unit> function1, TextFieldValue textFieldValue, OffsetMapping offsetMapping, Density density, int i) {
        this.$state = legacyTextFieldState;
        this.$onTextLayout = function1;
        this.$value = textFieldValue;
        this.$offsetMapping = offsetMapping;
        this.$density = density;
        this.$maxLines = i;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1747measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        LegacyTextFieldState legacyTextFieldState = this.$state;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
            Triple<Integer, Integer, TextLayoutResult> tripleM3531layout_EkL_Y$foundation = TextFieldDelegate.INSTANCE.m3531layout_EkL_Y$foundation(this.$state.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
            int iIntValue = tripleM3531layout_EkL_Y$foundation.component1().intValue();
            int iIntValue2 = tripleM3531layout_EkL_Y$foundation.component2().intValue();
            TextLayoutResult textLayoutResultComponent3 = tripleM3531layout_EkL_Y$foundation.component3();
            if (!Intrinsics.areEqual(value, textLayoutResultComponent3)) {
                this.$state.setLayoutResult(new TextLayoutResultProxy(textLayoutResultComponent3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                this.$onTextLayout.invoke(textLayoutResultComponent3);
                CoreTextFieldKt.notifyFocusedRect(this.$state, this.$value, this.$offsetMapping);
            }
            this.$state.m3490setMinHeightForSingleLineField0680j_4(this.$density.mo2188toDpu2uoSUM(this.$maxLines == 1 ? TextDelegateKt.ceilToIntPx(textLayoutResultComponent3.getLineBottom(0)) : 0));
            return measureScope.layout(iIntValue, iIntValue2, MapsKt.mapOf(TuplesKt.m1606to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(textLayoutResultComponent3.getFirstBaseline()))), TuplesKt.m1606to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(textLayoutResultComponent3.getLastBaseline())))), new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$8$1$1$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CoreTextFieldKt$CoreTextField$8$1$1$2.measure_3p2s80s$lambda$2((Placeable.PlacementScope) obj);
                }
            });
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$2(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        this.$state.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
        return this.$state.getTextDelegate().getMaxIntrinsicWidth();
    }
}
