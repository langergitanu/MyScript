package com.revenuecat.purchases.common.workflows;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$announceWorkflowsToPrewarm$1$1", m1609f = "WorkflowsConfigProvider.kt", m1610i = {}, m1611l = {259}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class WorkflowsConfigProvider$announceWorkflowsToPrewarm$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<String, Function2<? super String, ? super Continuation<? super PublishedWorkflow>, ? extends Object>, Continuation<? super Unit>, Object> $notify;
    final /* synthetic */ String $workflowId;
    int label;
    final /* synthetic */ WorkflowsConfigProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    WorkflowsConfigProvider$announceWorkflowsToPrewarm$1$1(Function3<? super String, ? super Function2<? super String, ? super Continuation<? super PublishedWorkflow>, ? extends Object>, ? super Continuation<? super Unit>, ? extends Object> function3, String str, WorkflowsConfigProvider workflowsConfigProvider, Continuation<? super WorkflowsConfigProvider$announceWorkflowsToPrewarm$1$1> continuation) {
        super(2, continuation);
        this.$notify = function3;
        this.$workflowId = str;
        this.this$0 = workflowsConfigProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkflowsConfigProvider$announceWorkflowsToPrewarm$1$1(this.$notify, this.$workflowId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkflowsConfigProvider$announceWorkflowsToPrewarm$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$announceWorkflowsToPrewarm$1$1$1 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    /* synthetic */ class C72681 extends FunctionReferenceImpl implements Function2<String, Continuation<? super PublishedWorkflow>, Object>, SuspendFunction {
        C72681(Object obj) {
            super(2, obj, WorkflowsConfigProvider.class, "resolveWorkflowBody", "resolveWorkflowBody(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super PublishedWorkflow> continuation) {
            return ((WorkflowsConfigProvider) this.receiver).resolveWorkflowBody(str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function3<String, Function2<? super String, ? super Continuation<? super PublishedWorkflow>, ? extends Object>, Continuation<? super Unit>, Object> function3 = this.$notify;
            String str = this.$workflowId;
            C72681 c72681 = new C72681(this.this$0);
            this.label = 1;
            if (function3.invoke(str, c72681, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
