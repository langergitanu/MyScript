package com.revenuecat.purchases.common.workflows;

import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WorkflowManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowManager$onPaywallConfigReady$readiness$1$1", m1609f = "WorkflowManager.kt", m1610i = {}, m1611l = {172, PDFACompliance.e_PDFA1_7_3}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class WorkflowManager$onPaywallConfigReady$readiness$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WorkflowManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WorkflowManager$onPaywallConfigReady$readiness$1$1(WorkflowManager workflowManager, Continuation<? super WorkflowManager$onPaywallConfigReady$readiness$1$1> continuation) {
        super(2, continuation);
        this.this$0 = workflowManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkflowManager$onPaywallConfigReady$readiness$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkflowManager$onPaywallConfigReady$readiness$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowManager$onPaywallConfigReady$readiness$1$1$1 */
    /* JADX INFO: compiled from: WorkflowManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowManager$onPaywallConfigReady$readiness$1$1$1", m1609f = "WorkflowManager.kt", m1610i = {}, m1611l = {172}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72591 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WorkflowManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72591(WorkflowManager workflowManager, Continuation<? super C72591> continuation) {
            super(1, continuation);
            this.this$0 = workflowManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C72591(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C72591) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.readyUiConfig(this) == coroutine_suspended) {
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

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        if (r6.this$0.awaitBestEffort(com.revenuecat.purchases.common.events.BackendEvent.WORKFLOW_EVENT_TYPE, new com.revenuecat.purchases.common.workflows.WorkflowManager$onPaywallConfigReady$readiness$1$1.C72602(r6.this$0, null), r6) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.awaitBestEffort("ui_config", new C72591(this.this$0, null), this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 2;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowManager$onPaywallConfigReady$readiness$1$1$2 */
    /* JADX INFO: compiled from: WorkflowManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowManager$onPaywallConfigReady$readiness$1$1$2", m1609f = "WorkflowManager.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_7_3}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72602 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WorkflowManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72602(WorkflowManager workflowManager, Continuation<? super C72602> continuation) {
            super(1, continuation);
            this.this$0 = workflowManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C72602(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C72602) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.workflowsConfigProvider.warm(this) == coroutine_suspended) {
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
}
