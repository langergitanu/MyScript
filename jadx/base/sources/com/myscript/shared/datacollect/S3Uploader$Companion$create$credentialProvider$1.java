package com.myscript.shared.datacollect;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: S3Uploader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final class S3Uploader$Companion$create$credentialProvider$1 implements IS3CredentialProvider {
    final /* synthetic */ DataCollectApi $api;

    S3Uploader$Companion$create$credentialProvider$1(DataCollectApi dataCollectApi) {
        this.$api = dataCollectApi;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.shared.datacollect.IS3CredentialProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getS3UploadParameters(DataCollectPayload dataCollectPayload, Continuation<? super S3UploadParameters> continuation) {
        C6914x33ffa139 c6914x33ffa139;
        if (continuation instanceof C6914x33ffa139) {
            c6914x33ffa139 = (C6914x33ffa139) continuation;
            if ((c6914x33ffa139.label & Integer.MIN_VALUE) != 0) {
                c6914x33ffa139.label -= Integer.MIN_VALUE;
            } else {
                c6914x33ffa139 = new C6914x33ffa139(this, continuation);
            }
        }
        Object s3UploadParameters = c6914x33ffa139.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c6914x33ffa139.label;
        if (i == 0) {
            ResultKt.throwOnFailure(s3UploadParameters);
            DataCollectApi dataCollectApi = this.$api;
            c6914x33ffa139.L$0 = SpillingKt.nullOutSpilledVariable(dataCollectPayload);
            c6914x33ffa139.label = 1;
            s3UploadParameters = dataCollectApi.getS3UploadParameters(dataCollectPayload, c6914x33ffa139);
            if (s3UploadParameters == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(s3UploadParameters);
        }
        return ((NotesCollectResponseModel) s3UploadParameters).getS3UploadParameters();
    }
}
