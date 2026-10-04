package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\bH¤@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\nJ\u000e\u0010\f\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Landroidx/datastore/core/RunOnce;", "", "<init>", "()V", "runMutex", "Lkotlinx/coroutines/sync/Mutex;", "didRun", "Lkotlinx/coroutines/CompletableDeferred;", "", "doRun", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitComplete", "runIfNeeded", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public abstract class RunOnce {
    private final Mutex runMutex = MutexKt.Mutex$default(false, 1, null);
    private final CompletableDeferred<Unit> didRun = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);

    /* JADX INFO: renamed from: androidx.datastore.core.RunOnce$runIfNeeded$1 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.RunOnce", m1609f = "DataStoreImpl.kt", m1610i = {0, 1}, m1611l = {566, 517}, m1612m = "runIfNeeded", m1613n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, m1615s = {"L$0", "L$0"}, m1616v = 1)
    static final class C18851 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C18851(Continuation<? super C18851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RunOnce.this.runIfNeeded(this);
        }
    }

    protected abstract Object doRun(Continuation<? super Unit> continuation);

    public final Object awaitComplete(Continuation<? super Unit> continuation) {
        Object objAwait = this.didRun.await(continuation);
        return objAwait == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwait : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runIfNeeded(Continuation<? super Unit> continuation) throws Throwable {
        C18851 c18851;
        Mutex mutex;
        Mutex mutex2;
        Throwable th;
        if (continuation instanceof C18851) {
            c18851 = (C18851) continuation;
            if ((c18851.label & Integer.MIN_VALUE) != 0) {
                c18851.label -= Integer.MIN_VALUE;
            } else {
                c18851 = new C18851(continuation);
            }
        }
        Object obj = c18851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18851.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.didRun.isCompleted()) {
                    return Unit.INSTANCE;
                }
                mutex = this.runMutex;
                c18851.L$0 = mutex;
                c18851.label = 1;
                if (mutex.lock(null, c18851) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) c18851.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    this.didRun.complete(Unit.INSTANCE);
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c18851.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            if (!this.didRun.isCompleted()) {
                c18851.L$0 = mutex;
                c18851.label = 2;
                if (doRun(c18851) != coroutine_suspended) {
                    mutex2 = mutex;
                    this.didRun.complete(Unit.INSTANCE);
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return unit;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }
}
