package com.airbnb.lottie.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;

/* JADX INFO: compiled from: LottieRetrySignal.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieRetrySignal;", "", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "<set-?>", "", "isAwaitingRetry", "()Z", "setAwaitingRetry", "(Z)V", "isAwaitingRetry$delegate", "Landroidx/compose/runtime/MutableState;", "awaitRetry", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retry", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
public final class LottieRetrySignal {
    public static final int $stable = 0;
    private final Channel<Unit> channel = ChannelKt.Channel$default(1, BufferOverflow.DROP_OLDEST, null, 4, null);

    /* JADX INFO: renamed from: isAwaitingRetry$delegate, reason: from kotlin metadata */
    private final MutableState isAwaitingRetry = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: com.airbnb.lottie.compose.LottieRetrySignal$awaitRetry$1 */
    /* JADX INFO: compiled from: LottieRetrySignal.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.airbnb.lottie.compose.LottieRetrySignal", m1609f = "LottieRetrySignal.kt", m1610i = {0}, m1611l = {45}, m1612m = "awaitRetry", m1613n = {"this"}, m1615s = {"L$0"})
    static final class C38791 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C38791(Continuation<? super C38791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LottieRetrySignal.this.awaitRetry(this);
        }
    }

    private final void setAwaitingRetry(boolean z) {
        this.isAwaitingRetry.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isAwaitingRetry() {
        return ((Boolean) this.isAwaitingRetry.getValue()).booleanValue();
    }

    public final void retry() {
        ChannelsKt.trySendBlocking(this.channel, Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitRetry(Continuation<? super Unit> continuation) throws Throwable {
        C38791 c38791;
        LottieRetrySignal lottieRetrySignal;
        if (continuation instanceof C38791) {
            c38791 = (C38791) continuation;
            if ((c38791.label & Integer.MIN_VALUE) != 0) {
                c38791.label -= Integer.MIN_VALUE;
            } else {
                c38791 = new C38791(continuation);
            }
        }
        Object obj = c38791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c38791.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lottieRetrySignal = (LottieRetrySignal) c38791.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                lottieRetrySignal.setAwaitingRetry(false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                lottieRetrySignal.setAwaitingRetry(false);
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        try {
            setAwaitingRetry(true);
            Channel<Unit> channel = this.channel;
            c38791.L$0 = this;
            c38791.label = 1;
            if (channel.receive(c38791) == coroutine_suspended) {
                return coroutine_suspended;
            }
            lottieRetrySignal = this;
            lottieRetrySignal.setAwaitingRetry(false);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            lottieRetrySignal = this;
            lottieRetrySignal.setAwaitingRetry(false);
            throw th;
        }
    }
}
