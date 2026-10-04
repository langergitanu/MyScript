package androidx.compose.foundation.lazy;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.LayoutModifierNode;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyItemScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u001e"}, m1599d2 = {"Landroidx/compose/foundation/lazy/ParentSizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "fraction", "", "widthState", "Landroidx/compose/runtime/State;", "", "heightState", "<init>", "(FLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getFraction", "()F", "setFraction", "(F)V", "getWidthState", "()Landroidx/compose/runtime/State;", "setWidthState", "(Landroidx/compose/runtime/State;)V", "getHeightState", "setHeightState", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class ParentSizeNode extends Modifier.Node implements LayoutModifierNode {
    private float fraction;
    private State<Integer> heightState;
    private State<Integer> widthState;

    public ParentSizeNode(float f, State<Integer> state, State<Integer> state2) {
        this.fraction = f;
        this.widthState = state;
        this.heightState = state2;
    }

    public /* synthetic */ ParentSizeNode(float f, State state, State state2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? null : state, (i & 4) != 0 ? null : state2);
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final void setFraction(float f) {
        this.fraction = f;
    }

    public final State<Integer> getWidthState() {
        return this.widthState;
    }

    public final void setWidthState(State<Integer> state) {
        this.widthState = state;
    }

    public final State<Integer> getHeightState() {
        return this.heightState;
    }

    public final void setHeightState(State<Integer> state) {
        this.heightState = state;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1775measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        State<Integer> state = this.widthState;
        int iRound = (state == null || state.getValue().intValue() == Integer.MAX_VALUE) ? Integer.MAX_VALUE : Math.round(state.getValue().floatValue() * this.fraction);
        State<Integer> state2 = this.heightState;
        int iRound2 = (state2 == null || state2.getValue().intValue() == Integer.MAX_VALUE) ? Integer.MAX_VALUE : Math.round(state2.getValue().floatValue() * this.fraction);
        int iM10972getMinWidthimpl = iRound != Integer.MAX_VALUE ? iRound : Constraints.m10972getMinWidthimpl(j);
        int iM10971getMinHeightimpl = iRound2 != Integer.MAX_VALUE ? iRound2 : Constraints.m10971getMinHeightimpl(j);
        if (iRound == Integer.MAX_VALUE) {
            iRound = Constraints.m10970getMaxWidthimpl(j);
        }
        if (iRound2 == Integer.MAX_VALUE) {
            iRound2 = Constraints.m10969getMaxHeightimpl(j);
        }
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(ConstraintsKt.Constraints(iM10972getMinWidthimpl, iRound, iM10971getMinHeightimpl, iRound2));
        return MeasureScope.layout$default(measureScope, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.lazy.ParentSizeNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ParentSizeNode.measure_3p2s80s$lambda$2(placeableMo9625measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$2(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
