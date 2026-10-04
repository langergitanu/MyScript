package com.myscript.shared.datacollect;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: com.myscript.shared.datacollect.DataCollect$Companion$create$credentialProvider$1$getS3UploadParameters$1 */
/* JADX INFO: compiled from: DataCollect.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.shared.datacollect.DataCollect$Companion$create$credentialProvider$1", m1609f = "DataCollect.kt", m1610i = {0}, m1611l = {64}, m1612m = "getS3UploadParameters", m1613n = {"payload"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
final class C6911x2ab286eb extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataCollect$Companion$create$credentialProvider$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6911x2ab286eb(DataCollect$Companion$create$credentialProvider$1 dataCollect$Companion$create$credentialProvider$1, Continuation<? super C6911x2ab286eb> continuation) {
        super(continuation);
        this.this$0 = dataCollect$Companion$create$credentialProvider$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getS3UploadParameters(null, this);
    }
}
