package com.myscript.shared.datacollect;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IS3CredentialProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/shared/datacollect/IS3CredentialProvider;", "", "getS3UploadParameters", "Lcom/myscript/shared/datacollect/S3UploadParameters;", "payload", "Lcom/myscript/shared/datacollect/DataCollectPayload;", "(Lcom/myscript/shared/datacollect/DataCollectPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IS3CredentialProvider {
    Object getS3UploadParameters(DataCollectPayload dataCollectPayload, Continuation<? super S3UploadParameters> continuation);
}
