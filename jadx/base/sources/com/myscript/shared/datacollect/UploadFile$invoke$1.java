package com.myscript.shared.datacollect;

import com.revenuecat.purchases.common.verification.SigningManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: UploadFile.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.shared.datacollect.UploadFile", m1609f = "UploadFile.kt", m1610i = {0, 0, 0, 0, 0, 0, 0}, m1611l = {15}, m1612m = "invoke-hUnOzRk", m1613n = {"file", SigningManager.POST_PARAMS_ALGORITHM, "ssoId", "userStatus", "uuid", "$this$invoke_hUnOzRk_u24lambda_u241", "$i$a$-run-UploadFile$invoke$3"}, m1614nl = {15}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, m1616v = 2)
final class UploadFile$invoke$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadFile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UploadFile$invoke$1(UploadFile uploadFile, Continuation<? super UploadFile$invoke$1> continuation) {
        super(continuation);
        this.this$0 = uploadFile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13534invokehUnOzRk = this.this$0.m13534invokehUnOzRk(null, null, null, null, null, this);
        return objM13534invokehUnOzRk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM13534invokehUnOzRk : Result.m14498boximpl(objM13534invokehUnOzRk);
    }
}
