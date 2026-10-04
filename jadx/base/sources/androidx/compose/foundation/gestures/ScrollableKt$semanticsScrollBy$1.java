package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.gestures.ScrollableKt", m1609f = "Scrollable.kt", m1610i = {0, 0}, m1611l = {1149}, m1612m = "semanticsScrollBy-d-4ec7I", m1613n = {"$this$semanticsScrollBy_u2dd_u2d4ec7I", "previousValue"}, m1615s = {"L$0", "L$1"}, m1616v = 1)
final class ScrollableKt$semanticsScrollBy$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    ScrollableKt$semanticsScrollBy$1(Continuation<? super ScrollableKt$semanticsScrollBy$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ScrollableKt.m2378semanticsScrollByd4ec7I(null, 0L, this);
    }
}
