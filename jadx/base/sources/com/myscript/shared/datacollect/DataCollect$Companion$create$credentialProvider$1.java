package com.myscript.shared.datacollect;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: DataCollect.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final class DataCollect$Companion$create$credentialProvider$1 implements IS3CredentialProvider {
    final /* synthetic */ DataCollectApi $api;

    DataCollect$Companion$create$credentialProvider$1(DataCollectApi dataCollectApi) {
        this.$api = dataCollectApi;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.shared.datacollect.IS3CredentialProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getS3UploadParameters(DataCollectPayload dataCollectPayload, Continuation<? super S3UploadParameters> continuation) {
        C6911x2ab286eb c6911x2ab286eb;
        if (continuation instanceof C6911x2ab286eb) {
            c6911x2ab286eb = (C6911x2ab286eb) continuation;
            if ((c6911x2ab286eb.label & Integer.MIN_VALUE) != 0) {
                c6911x2ab286eb.label -= Integer.MIN_VALUE;
            } else {
                c6911x2ab286eb = new C6911x2ab286eb(this, continuation);
            }
        }
        Object s3UploadParameters = c6911x2ab286eb.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c6911x2ab286eb.label;
        if (i == 0) {
            ResultKt.throwOnFailure(s3UploadParameters);
            DataCollectApi dataCollectApi = this.$api;
            c6911x2ab286eb.L$0 = SpillingKt.nullOutSpilledVariable(dataCollectPayload);
            c6911x2ab286eb.label = 1;
            s3UploadParameters = dataCollectApi.getS3UploadParameters(dataCollectPayload, c6911x2ab286eb);
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
