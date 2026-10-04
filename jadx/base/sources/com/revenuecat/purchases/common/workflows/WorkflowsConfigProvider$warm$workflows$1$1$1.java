package com.revenuecat.purchases.common.workflows;

import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\u008a@"}, m1599d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$warm$workflows$1$1$1", m1609f = "WorkflowsConfigProvider.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_3_2}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class WorkflowsConfigProvider$warm$workflows$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends byte[]>>, Object> {
    final /* synthetic */ String $id;
    Object L$0;
    int label;
    final /* synthetic */ WorkflowsConfigProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WorkflowsConfigProvider$warm$workflows$1$1$1(String str, WorkflowsConfigProvider workflowsConfigProvider, Continuation<? super WorkflowsConfigProvider$warm$workflows$1$1$1> continuation) {
        super(2, continuation);
        this.$id = str;
        this.this$0 = workflowsConfigProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkflowsConfigProvider$warm$workflows$1$1$1(this.$id, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends String, ? extends byte[]>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<String, byte[]>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<String, byte[]>> continuation) {
        return ((WorkflowsConfigProvider$warm$workflows$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = this.$id;
            this.L$0 = str2;
            this.label = 1;
            Object objResolveWorkflowBytes = this.this$0.resolveWorkflowBytes(str2, this);
            if (objResolveWorkflowBytes == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = str2;
            obj = objResolveWorkflowBytes;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return TuplesKt.m1606to(str, obj);
    }
}
