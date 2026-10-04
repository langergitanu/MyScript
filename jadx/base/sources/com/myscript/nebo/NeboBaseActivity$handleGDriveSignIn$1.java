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
@DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity", m1609f = "NeboBaseActivity.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1}, m1611l = {969, 971}, m1612m = "handleGDriveSignIn-gIAlu-s", m1613n = {"result", "logger", "credential", "authorizationRequest", "result", "logger", "credential", "e"}, m1614nl = {970, 972}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, m1616v = 2)
final class NeboBaseActivity$handleGDriveSignIn$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NeboBaseActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboBaseActivity$handleGDriveSignIn$1(NeboBaseActivity neboBaseActivity, Continuation<? super NeboBaseActivity$handleGDriveSignIn$1> continuation) {
        super(continuation);
        this.this$0 = neboBaseActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM12801handleGDriveSignIngIAlus = this.this$0.m12801handleGDriveSignIngIAlus(null, this);
        return objM12801handleGDriveSignIngIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12801handleGDriveSignIngIAlus : Result.m14498boximpl(objM12801handleGDriveSignIngIAlus);
    }
}
