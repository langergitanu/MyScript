package androidx.compose.material3;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
final class ClockDialNode$pointerInputDragNode$1 implements PointerInputEventHandler {
    final /* synthetic */ ClockDialNode this$0;

    ClockDialNode$pointerInputDragNode$1(ClockDialNode clockDialNode) {
        this.this$0 = clockDialNode;
    }

    @Override // androidx.compose.p004ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final ClockDialNode clockDialNode = this.this$0;
        Function0 function0 = new Function0() { // from class: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ClockDialNode$pointerInputDragNode$1.invoke$lambda$0(clockDialNode);
            }
        };
        final ClockDialNode clockDialNode2 = this.this$0;
        Object objDetectDragGestures$default = DragGestureDetectorKt.detectDragGestures$default(pointerInputScope, null, function0, null, new Function2() { // from class: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ClockDialNode$pointerInputDragNode$1.invoke$lambda$1(clockDialNode2, (PointerInputChange) obj, (Offset) obj2);
            }
        }, continuation, 5, null);
        return objDetectDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(ClockDialNode clockDialNode) {
        BuildersKt__Builders_commonKt.launch$default(clockDialNode.getCoroutineScope(), null, null, new ClockDialNode$pointerInputDragNode$1$1$1(clockDialNode, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(ClockDialNode clockDialNode, PointerInputChange pointerInputChange, Offset offset) {
        BuildersKt__Builders_commonKt.launch$default(clockDialNode.getCoroutineScope(), null, null, new ClockDialNode$pointerInputDragNode$1$2$1(clockDialNode, offset, null), 3, null);
        return Unit.INSTANCE;
    }
}
