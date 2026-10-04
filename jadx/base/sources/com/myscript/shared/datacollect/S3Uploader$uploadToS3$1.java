package com.myscript.shared.datacollect;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: S3Uploader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.shared.datacollect.S3Uploader", m1609f = "S3Uploader.kt", m1610i = {0, 0, 0, 0, 0, 0, 0}, m1611l = {80}, m1612m = "uploadToS3-hUnOzRk", m1613n = {"file", "ssoId", "s3Parameters", "userStatus", "uuid", "$this$uploadToS3_hUnOzRk_u24lambda_u241", "$i$a$-run-S3Uploader$uploadToS3$3"}, m1614nl = {86}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, m1616v = 2)
final class S3Uploader$uploadToS3$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ S3Uploader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    S3Uploader$uploadToS3$1(S3Uploader s3Uploader, Continuation<? super S3Uploader$uploadToS3$1> continuation) {
        super(continuation);
        this.this$0 = s3Uploader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13532uploadToS3hUnOzRk = this.this$0.m13532uploadToS3hUnOzRk(null, null, null, null, null, this);
        return objM13532uploadToS3hUnOzRk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM13532uploadToS3hUnOzRk : Result.m14498boximpl(objM13532uploadToS3hUnOzRk);
    }
}
