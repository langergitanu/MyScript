package com.survicate.surveys;

import com.survicate.surveys.helpers.LogTags;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: WorkspaceLoader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.survicate.surveys.WorkspaceLoader$loadWorkspace$newLoadJob$1", m1609f = "WorkspaceLoader.kt", m1610i = {0}, m1611l = {45}, m1612m = "invokeSuspend", m1613n = {"$this$launch"}, m1615s = {"L$0"})
final class WorkspaceLoader$loadWorkspace$newLoadJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WorkspaceLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WorkspaceLoader$loadWorkspace$newLoadJob$1(WorkspaceLoader workspaceLoader, Continuation<? super WorkspaceLoader$loadWorkspace$newLoadJob$1> continuation) {
        super(2, continuation);
        this.this$0 = workspaceLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WorkspaceLoader$loadWorkspace$newLoadJob$1 workspaceLoader$loadWorkspace$newLoadJob$1 = new WorkspaceLoader$loadWorkspace$newLoadJob$1(this.this$0, continuation);
        workspaceLoader$loadWorkspace$newLoadJob$1.L$0 = obj;
        return workspaceLoader$loadWorkspace$newLoadJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkspaceLoader$loadWorkspace$newLoadJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        Exception e;
        WorkspaceLoader workspaceLoader;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    if (this.this$0.fetchWorkspace(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope2;
                    workspaceLoader = this.this$0;
                    synchronized (workspaceLoader) {
                    }
                } catch (Exception e2) {
                    coroutineScope = coroutineScope2;
                    e = e2;
                    CoroutineScopeKt.ensureActive(coroutineScope);
                    this.this$0.logger.error(LogTags.WORKSPACE, "Failed to fetch workspace", e);
                    workspaceLoader = this.this$0;
                    synchronized (workspaceLoader) {
                    }
                } catch (Throwable th) {
                    coroutine_suspended = coroutineScope2;
                    th = th;
                    WorkspaceLoader workspaceLoader2 = this.this$0;
                    synchronized (workspaceLoader2) {
                        if (Intrinsics.areEqual(coroutine_suspended.getCoroutineContext().get(Job.INSTANCE), workspaceLoader2.lastLoadJob)) {
                            workspaceLoader2.isLoading = false;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    workspaceLoader = this.this$0;
                    synchronized (workspaceLoader) {
                        if (Intrinsics.areEqual(coroutineScope.getCoroutineContext().get(Job.INSTANCE), workspaceLoader.lastLoadJob)) {
                            workspaceLoader.isLoading = false;
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                } catch (Exception e3) {
                    e = e3;
                    CoroutineScopeKt.ensureActive(coroutineScope);
                    this.this$0.logger.error(LogTags.WORKSPACE, "Failed to fetch workspace", e);
                    workspaceLoader = this.this$0;
                    synchronized (workspaceLoader) {
                        if (Intrinsics.areEqual(coroutineScope.getCoroutineContext().get(Job.INSTANCE), workspaceLoader.lastLoadJob)) {
                            workspaceLoader.isLoading = false;
                        }
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
