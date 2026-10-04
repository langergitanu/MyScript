package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PurchasesFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.PurchasesFactory$createPurchases$1$localRulesEvaluator$1", m1609f = "PurchasesFactory.kt", m1610i = {}, m1611l = {391}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class PurchasesFactory$createPurchases$1$localRulesEvaluator$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    int label;

    PurchasesFactory$createPurchases$1$localRulesEvaluator$1(Continuation<? super PurchasesFactory$createPurchases$1$localRulesEvaluator$1> continuation) {
        super(1, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PurchasesFactory$createPurchases$1$localRulesEvaluator$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super String> continuation) {
        return ((PurchasesFactory$createPurchases$1$localRulesEvaluator$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        this.label = 1;
        Object objAwaitStorefrontCountryCode = CoroutinesExtensionsCommonKt.awaitStorefrontCountryCode(Purchases.INSTANCE.getSharedInstance(), this);
        return objAwaitStorefrontCountryCode == coroutine_suspended ? coroutine_suspended : objAwaitStorefrontCountryCode;
    }
}
