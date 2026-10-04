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
@DebugMetadata(m1608c = "com.myscript.nebo.purchase.RevenueCatPurchaseProvider", m1609f = "RevenueCatPurchaseProvider.kt", m1610i = {0, 0}, m1611l = {143}, m1612m = "login-gIAlu-s", m1613n = {"appUserId", "$i$f$suspendCancellableCoroutine"}, m1614nl = {153}, m1615s = {"L$0", "I$0"}, m1616v = 2)
final class RevenueCatPurchaseProvider$login$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RevenueCatPurchaseProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RevenueCatPurchaseProvider$login$1(RevenueCatPurchaseProvider revenueCatPurchaseProvider, Continuation<? super RevenueCatPurchaseProvider$login$1> continuation) {
        super(continuation);
        this.this$0 = revenueCatPurchaseProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo13347logingIAlus = this.this$0.mo13347logingIAlus(null, this);
        return objMo13347logingIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo13347logingIAlus : Result.m14498boximpl(objMo13347logingIAlus);
    }
}
