package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 176)
@DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", m1609f = "DragGestureDetector.kt", m1610i = {0, 0, 0, 0, 0, 0}, m1611l = {1159}, m1612m = "drag-VnAYq1g", m1613n = {"$this$drag_u2dVnAYq1g", "onDrag", "orientation", "motionConsumed", "$this$awaitDragOrUp_u2djO51t88$iv", "pointer$iv"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, m1616v = 1)
final class DragGestureDetectorKt$drag$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$drag$2(Continuation<? super DragGestureDetectorKt$drag$2> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m2276dragVnAYq1g(null, 0L, null, null, null, this);
    }
}
