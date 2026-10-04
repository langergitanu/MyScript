package com.myscript.nebo.dms.core;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: AutoSyncTimerManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager$networkStateObserver$1$1", m1609f = "AutoSyncTimerManager.kt", m1610i = {0, 0, 0}, m1611l = {645}, m1612m = "invokeSuspend", m1613n = {"$this$launch", "$this$withLock_u24default$iv", "$i$f$withLock"}, m1614nl = {646}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
final class AutoSyncTimerManager$networkStateObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AutoSyncTimerManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoSyncTimerManager$networkStateObserver$1$1(AutoSyncTimerManager autoSyncTimerManager, Continuation<? super AutoSyncTimerManager$networkStateObserver$1$1> continuation) {
        super(2, continuation);
        this.this$0 = autoSyncTimerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AutoSyncTimerManager$networkStateObserver$1$1 autoSyncTimerManager$networkStateObserver$1$1 = new AutoSyncTimerManager$networkStateObserver$1$1(this.this$0, continuation);
        autoSyncTimerManager$networkStateObserver$1$1.L$0 = obj;
        return autoSyncTimerManager$networkStateObserver$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AutoSyncTimerManager$networkStateObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        AutoSyncTimerManager autoSyncTimerManager;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.this$0.syncJobMutex;
            AutoSyncTimerManager autoSyncTimerManager2 = this.this$0;
            this.L$0 = coroutineScope;
            this.L$1 = mutex;
            this.L$2 = autoSyncTimerManager2;
            this.I$0 = 0;
            this.label = 1;
            if (mutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            autoSyncTimerManager = autoSyncTimerManager2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            autoSyncTimerManager = (AutoSyncTimerManager) this.L$2;
            mutex = (Mutex) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        Mutex mutex2 = mutex;
        try {
            Job job = autoSyncTimerManager.syncJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            autoSyncTimerManager.syncJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AutoSyncTimerManager$networkStateObserver$1$1$1$1(autoSyncTimerManager, null), 3, null);
            Unit unit = Unit.INSTANCE;
            mutex2.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex2.unlock(null);
            throw th;
        }
    }
}
