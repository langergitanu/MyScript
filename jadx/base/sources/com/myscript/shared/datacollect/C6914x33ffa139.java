package com.myscript.shared.datacollect;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: com.myscript.shared.datacollect.S3Uploader$Companion$create$credentialProvider$1$getS3UploadParameters$1 */
/* JADX INFO: compiled from: S3Uploader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.shared.datacollect.S3Uploader$Companion$create$credentialProvider$1", m1609f = "S3Uploader.kt", m1610i = {0}, m1611l = {115}, m1612m = "getS3UploadParameters", m1613n = {"payload"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
final class C6914x33ffa139 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ S3Uploader$Companion$create$credentialProvider$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6914x33ffa139(S3Uploader$Companion$create$credentialProvider$1 s3Uploader$Companion$create$credentialProvider$1, Continuation<? super C6914x33ffa139> continuation) {
        super(continuation);
        this.this$0 = s3Uploader$Companion$create$credentialProvider$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getS3UploadParameters(null, this);
    }
}
