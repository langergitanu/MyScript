package com.myscript.shared.datacollect;

import com.revenuecat.purchases.common.verification.SigningManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: S3FileUploader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.shared.datacollect.S3FileUploader", m1609f = "S3FileUploader.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {30}, m1612m = "invoke-hUnOzRk", m1613n = {"file", SigningManager.POST_PARAMS_ALGORITHM, "ssoId", "userStatus", "uuid", "$this$invoke_hUnOzRk_u24lambda_u240", "it", "$i$a$-runCatching-S3FileUploader$invoke$2", "$i$a$-use-S3FileUploader$invoke$2$1"}, m1614nl = {47}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "I$0", "I$1"}, m1616v = 2)
final class S3FileUploader$invoke$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ S3FileUploader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    S3FileUploader$invoke$1(S3FileUploader s3FileUploader, Continuation<? super S3FileUploader$invoke$1> continuation) {
        super(continuation);
        this.this$0 = s3FileUploader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo13527invokehUnOzRk = this.this$0.mo13527invokehUnOzRk(null, null, null, null, null, this);
        return objMo13527invokehUnOzRk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo13527invokehUnOzRk : Result.m14498boximpl(objMo13527invokehUnOzRk);
    }
}
