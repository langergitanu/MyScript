package com.myscript.nebo;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: NeboBaseActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity", m1609f = "NeboBaseActivity.kt", m1610i = {0, 0}, m1611l = {1009}, m1612m = "driveSilentSignIn-IoAF18A", m1613n = {"authorizationRequest", "$i$f$suspendCancellableCoroutine"}, m1614nl = {1019}, m1615s = {"L$0", "I$0"}, m1616v = 2)
final class NeboBaseActivity$driveSilentSignIn$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NeboBaseActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboBaseActivity$driveSilentSignIn$1(NeboBaseActivity neboBaseActivity, Continuation<? super NeboBaseActivity$driveSilentSignIn$1> continuation) {
        super(continuation);
        this.this$0 = neboBaseActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM12799driveSilentSignInIoAF18A = this.this$0.m12799driveSilentSignInIoAF18A(this);
        return objM12799driveSilentSignInIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12799driveSilentSignInIoAF18A : Result.m14498boximpl(objM12799driveSilentSignInIoAF18A);
    }
}
