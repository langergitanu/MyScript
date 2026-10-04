package kotlinx.coroutines.channels;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: BufferedChannel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "kotlinx.coroutines.channels.BufferedChannel", m1609f = "BufferedChannel.kt", m1610i = {0, 0, 0, 0}, m1611l = {3117}, m1612m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", m1613n = {"this", "segment", FirebaseAnalytics.Param.INDEX, "r"}, m1615s = {"L$0", "L$1", "I$0", "J$0"})
final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM16027receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m16027receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return objM16027receiveCatchingOnNoWaiterSuspendGKJJFZk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM16027receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m16036boximpl(objM16027receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
