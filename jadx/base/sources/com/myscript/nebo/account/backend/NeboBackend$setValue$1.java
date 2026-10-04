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
@DebugMetadata(m1608c = "com.myscript.nebo.account.backend.NeboBackend", m1609f = "NeboBackend.kt", m1610i = {0, 0, 0, 0, 0, 0, 0}, m1611l = {114}, m1612m = "setValue-yxL6bBk", m1613n = {SubscriberAttributeKt.JSON_NAME_KEY, "value", "$this$setValue_yxL6bBk_u24lambda_u240", "writeOnce", "forceCacheFallback", "$i$a$-runCatching-NeboBackend$setValue$2", "hasInternetAccess"}, m1614nl = {115}, m1615s = {"L$0", "L$1", "L$2", "Z$0", "Z$1", "I$0", "I$1"}, m1616v = 2)
final class NeboBackend$setValue$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NeboBackend this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboBackend$setValue$1(NeboBackend neboBackend, Continuation<? super NeboBackend$setValue$1> continuation) {
        super(continuation);
        this.this$0 = neboBackend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo12809setValueyxL6bBk = this.this$0.mo12809setValueyxL6bBk(null, null, false, false, this);
        return objMo12809setValueyxL6bBk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo12809setValueyxL6bBk : Result.m14498boximpl(objMo12809setValueyxL6bBk);
    }
}
