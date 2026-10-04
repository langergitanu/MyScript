package com.myscript.nebo.purchase;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: RevenueCatPurchaseProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.purchase.RevenueCatPurchaseProvider", m1609f = "RevenueCatPurchaseProvider.kt", m1610i = {0}, m1611l = {143}, m1612m = "syncPurchases-IoAF18A", m1613n = {"$i$f$suspendCancellableCoroutine"}, m1614nl = {153}, m1615s = {"I$0"}, m1616v = 2)
final class RevenueCatPurchaseProvider$syncPurchases$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RevenueCatPurchaseProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RevenueCatPurchaseProvider$syncPurchases$1(RevenueCatPurchaseProvider revenueCatPurchaseProvider, Continuation<? super RevenueCatPurchaseProvider$syncPurchases$1> continuation) {
        super(continuation);
        this.this$0 = revenueCatPurchaseProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo13349syncPurchasesIoAF18A = this.this$0.mo13349syncPurchasesIoAF18A(this);
        return objMo13349syncPurchasesIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo13349syncPurchasesIoAF18A : Result.m14498boximpl(objMo13349syncPurchasesIoAF18A);
    }
}
