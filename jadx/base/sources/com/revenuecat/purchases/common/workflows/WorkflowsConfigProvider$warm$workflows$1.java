package com.revenuecat.purchases.common.workflows;

import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001*\u00020\u0005H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$warm$workflows$1", m1609f = "WorkflowsConfigProvider.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_3_3}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class WorkflowsConfigProvider$warm$workflows$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Pair<? extends String, ? extends byte[]>>>, Object> {
    final /* synthetic */ List<String> $eligibleIds;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WorkflowsConfigProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WorkflowsConfigProvider$warm$workflows$1(List<String> list, WorkflowsConfigProvider workflowsConfigProvider, Continuation<? super WorkflowsConfigProvider$warm$workflows$1> continuation) {
        super(2, continuation);
        this.$eligibleIds = list;
        this.this$0 = workflowsConfigProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WorkflowsConfigProvider$warm$workflows$1 workflowsConfigProvider$warm$workflows$1 = new WorkflowsConfigProvider$warm$workflows$1(this.$eligibleIds, this.this$0, continuation);
        workflowsConfigProvider$warm$workflows$1.L$0 = obj;
        return workflowsConfigProvider$warm$workflows$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Pair<? extends String, ? extends byte[]>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<Pair<String, byte[]>>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Pair<String, byte[]>>> continuation) {
        return ((WorkflowsConfigProvider$warm$workflows$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        List listDistinct = CollectionsKt.distinct(this.$eligibleIds);
        WorkflowsConfigProvider workflowsConfigProvider = this.this$0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listDistinct, 10));
        Iterator it = listDistinct.iterator();
        while (it.hasNext()) {
            arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new WorkflowsConfigProvider$warm$workflows$1$1$1((String) it.next(), workflowsConfigProvider, null), 3, null));
        }
        this.label = 1;
        Object objAwaitAll = AwaitKt.awaitAll(arrayList, this);
        return objAwaitAll == coroutine_suspended ? coroutine_suspended : objAwaitAll;
    }
}
