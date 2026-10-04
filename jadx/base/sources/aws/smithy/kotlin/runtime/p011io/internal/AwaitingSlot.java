package aws.smithy.kotlin.runtime.p011io.internal;

import androidx.concurrent.futures.C1519xc40028dd;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: AwaitingSlot.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@¢\u0006\u0004\b\u000f\u0010\t¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/internal/AwaitingSlot;", "", "<init>", "()V", "Lkotlin/Function0;", "", "sleepCondition", "", "sleep", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resume", "", "cause", "cancel", "(Ljava/lang/Throwable;)V", "trySuspend", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwaitingSlot {
    private static final /* synthetic */ AtomicReferenceFieldUpdater suspension$FU = AtomicReferenceFieldUpdater.newUpdater(AwaitingSlot.class, Object.class, "suspension");
    private volatile /* synthetic */ Object suspension = null;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.internal.AwaitingSlot$sleep$1 */
    /* JADX INFO: compiled from: AwaitingSlot.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.internal.AwaitingSlot", m1609f = "AwaitingSlot.kt", m1610i = {0}, m1611l = {25}, m1612m = "sleep", m1613n = {"sleepCondition"}, m1614nl = {26}, m1615s = {"L$0"}, m1616v = 2)
    static final class C37611 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C37611(Continuation<? super C37611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwaitingSlot.this.sleep(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.internal.AwaitingSlot$trySuspend$1 */
    /* JADX INFO: compiled from: AwaitingSlot.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.internal.AwaitingSlot", m1609f = "AwaitingSlot.kt", m1610i = {0, 0, 0}, m1611l = {58}, m1612m = "trySuspend", m1613n = {"sleepCondition", "job", "suspended"}, m1614nl = {61}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C37621 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37621(Continuation<? super C37621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwaitingSlot.this.trySuspend(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sleep(Function0<Boolean> function0, Continuation<? super Unit> continuation) {
        C37611 c37611;
        if (continuation instanceof C37611) {
            c37611 = (C37611) continuation;
            if ((c37611.label & Integer.MIN_VALUE) != 0) {
                c37611.label -= Integer.MIN_VALUE;
            } else {
                c37611 = new C37611(continuation);
            }
        }
        Object objTrySuspend = c37611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37611.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objTrySuspend);
            c37611.L$0 = SpillingKt.nullOutSpilledVariable(function0);
            c37611.label = 1;
            objTrySuspend = trySuspend(function0, c37611);
            if (objTrySuspend == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objTrySuspend);
        }
        if (((Boolean) objTrySuspend).booleanValue()) {
            return Unit.INSTANCE;
        }
        resume();
        return Unit.INSTANCE;
    }

    public final void resume() {
        CompletableJob completableJob = (CompletableJob) suspension$FU.getAndSet(this, null);
        if (completableJob != null) {
            completableJob.complete();
        }
    }

    public final void cancel(Throwable cause) {
        CompletableJob completableJob = (CompletableJob) suspension$FU.getAndSet(this, null);
        if (completableJob == null) {
            return;
        }
        if (cause != null) {
            completableJob.completeExceptionally(cause);
        } else {
            completableJob.complete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object trySuspend(Function0<Boolean> function0, Continuation<? super Boolean> continuation) {
        C37621 c37621;
        int i;
        if (continuation instanceof C37621) {
            c37621 = (C37621) continuation;
            if ((c37621.label & Integer.MIN_VALUE) != 0) {
                c37621.label -= Integer.MIN_VALUE;
            } else {
                c37621 = new C37621(continuation);
            }
        }
        Object obj = c37621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c37621.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            if (C1519xc40028dd.m48m(suspension$FU, this, null, completableJobJob$default) && function0.invoke().booleanValue()) {
                c37621.L$0 = SpillingKt.nullOutSpilledVariable(function0);
                c37621.L$1 = SpillingKt.nullOutSpilledVariable(completableJobJob$default);
                c37621.I$0 = 1;
                c37621.label = 1;
                if (completableJobJob$default.join(c37621) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = 1;
            } else {
                i = 0;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c37621.I$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(i != 0);
    }
}
