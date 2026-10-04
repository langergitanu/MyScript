package com.myscript.nebo.account.backend;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: NeboBackend.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.account.backend.NeboBackend", m1609f = "NeboBackend.kt", m1610i = {0, 0, 0, 0, 0, 0}, m1611l = {149}, m1612m = "getValue-0E7RQCE", m1613n = {SubscriberAttributeKt.JSON_NAME_KEY, "cachePolicy", "$this$getValue_0E7RQCE_u24lambda_u240", "$i$a$-runCatching-NeboBackend$getValue$2", "hasInternetAccess", "tryFromCache"}, m1614nl = {151}, m1615s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2"}, m1616v = 2)
final class NeboBackend$getValue$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NeboBackend this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboBackend$getValue$1(NeboBackend neboBackend, Continuation<? super NeboBackend$getValue$1> continuation) {
        super(continuation);
        this.this$0 = neboBackend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo12808getValue0E7RQCE = this.this$0.mo12808getValue0E7RQCE(null, null, this);
        return objMo12808getValue0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo12808getValue0E7RQCE : Result.m14498boximpl(objMo12808getValue0E7RQCE);
    }
}
