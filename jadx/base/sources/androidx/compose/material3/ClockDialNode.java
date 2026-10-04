package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerEventPass;
import androidx.compose.p004ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p004ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.p004ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.DelegatingNode;
import androidx.compose.p004ui.node.LayoutAwareModifierNode;
import androidx.compose.p004ui.node.PointerInputModifierNode;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010\u0019J'\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020%H\u0016¢\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020#H\u0016J3\u00100\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b1\u00102R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, m1599d2 = {"Landroidx/compose/material3/ClockDialNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "state", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material3/AnalogTimePickerState;ZILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "offsetX", "offsetY", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", TtmlNode.CENTER, "getCenter-nOcc-ac", "()J", "setCenter--gyyYBs", "(J)V", "center$delegate", "Landroidx/compose/runtime/MutableState;", "maxDist", "getMaxDist", "()F", "pointerInputTapNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputDragNode", "onRemeasured", "", "size", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "updateNode", "updateNode-JwYzU44", "(Landroidx/compose/material3/AnalogTimePickerState;ZILandroidx/compose/animation/core/AnimationSpec;)V", "material3"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ClockDialNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode, LayoutAwareModifierNode {
    public static final int $stable = 8;
    private AnimationSpec<Float> animationSpec;
    private boolean autoSwitchToMinute;

    /* JADX INFO: renamed from: center$delegate, reason: from kotlin metadata */
    private final MutableState center;
    private float offsetX;
    private float offsetY;
    private final SuspendingPointerInputModifierNode pointerInputDragNode;
    private final SuspendingPointerInputModifierNode pointerInputTapNode;
    private int selection;
    private AnalogTimePickerState state;

    public /* synthetic */ ClockDialNode(AnalogTimePickerState analogTimePickerState, boolean z, int i, AnimationSpec animationSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(analogTimePickerState, z, i, animationSpec);
    }

    private ClockDialNode(AnalogTimePickerState analogTimePickerState, boolean z, int i, AnimationSpec<Float> animationSpec) {
        this.state = analogTimePickerState;
        this.autoSwitchToMinute = z;
        this.selection = i;
        this.animationSpec = animationSpec;
        this.center = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m11136boximpl(IntOffset.INSTANCE.m11156getZeronOccac()), null, 2, null);
        this.pointerInputTapNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ClockDialNode$pointerInputTapNode$1(this)));
        this.pointerInputDragNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ClockDialNode$pointerInputDragNode$1(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getCenter-nOcc-ac, reason: not valid java name */
    public final long m4768getCenternOccac() {
        return ((IntOffset) this.center.getValue()).m11154unboximpl();
    }

    /* JADX INFO: renamed from: setCenter--gyyYBs, reason: not valid java name */
    private final void m4769setCentergyyYBs(long j) {
        this.center.setValue(IntOffset.m11136boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getMaxDist() {
        return (DelegatableNodeKt.requireDensity(this).mo2191toPx0680j_4(TimePickerKt.MaxDistance) * r0.mo2185roundToPx0680j_4(this.state.m4584getCurrentDiameterD9Ej5fM())) / r0.mo2185roundToPx0680j_4(TimePickerTokens.INSTANCE.m7055getClockDialContainerSizeD9Ej5fM());
    }

    @Override // androidx.compose.p004ui.node.LayoutAwareModifierNode, androidx.compose.p004ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public void mo2180onRemeasuredozmzZPI(long size) {
        m4769setCentergyyYBs(IntSizeKt.m11194getCenterozmzZPI(size));
        this.state.m4586setCurrentDiameter0680j_4(DelegatableNodeKt.requireDensity(this).mo2188toDpu2uoSUM((int) (size >> 32)));
    }

    @Override // androidx.compose.p004ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo1983onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.pointerInputTapNode.mo1983onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        this.pointerInputDragNode.mo1983onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    @Override // androidx.compose.p004ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        this.pointerInputTapNode.onCancelPointerInput();
        this.pointerInputDragNode.onCancelPointerInput();
    }

    /* JADX INFO: renamed from: updateNode-JwYzU44, reason: not valid java name */
    public final void m4770updateNodeJwYzU44(AnalogTimePickerState state, boolean autoSwitchToMinute, int selection, AnimationSpec<Float> animationSpec) {
        this.state = state;
        this.autoSwitchToMinute = autoSwitchToMinute;
        this.animationSpec = animationSpec;
        if (TimePickerSelectionMode.m5953equalsimpl0(this.selection, selection)) {
            return;
        }
        this.selection = selection;
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ClockDialNode$updateNode$1(state, animationSpec, null), 3, null);
    }
}
