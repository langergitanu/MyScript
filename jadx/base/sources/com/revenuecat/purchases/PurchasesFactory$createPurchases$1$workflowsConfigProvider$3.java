package com.revenuecat.purchases;

import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import com.revenuecat.purchases.common.workflows.WorkflowAssetPrewarmer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PurchasesFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
/* synthetic */ class PurchasesFactory$createPurchases$1$workflowsConfigProvider$3 extends FunctionReferenceImpl implements Function3<String, Function2<? super String, ? super Continuation<? super PublishedWorkflow>, ? extends Object>, Continuation<? super Unit>, Object>, SuspendFunction {
    PurchasesFactory$createPurchases$1$workflowsConfigProvider$3(Object obj) {
        super(3, obj, WorkflowAssetPrewarmer.class, "onWorkflowLoaded", "onWorkflowLoaded(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(String str, Function2<? super String, ? super Continuation<? super PublishedWorkflow>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return ((WorkflowAssetPrewarmer) this.receiver).onWorkflowLoaded(str, function2, continuation);
    }
}
