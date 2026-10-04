package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", m1609f = "DragGestureDetector.kt", m1610i = {0, 0}, m1611l = {1159}, m1612m = "awaitDragOrCancellation-rnUCldI", m1613n = {"$this$awaitDragOrUp_u2djO51t88$iv", "pointer$iv"}, m1615s = {"L$0", "L$1"}, m1616v = 1)
final class DragGestureDetectorKt$awaitDragOrCancellation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$awaitDragOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitDragOrCancellation$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m2263awaitDragOrCancellationrnUCldI(null, 0L, this);
    }
}
