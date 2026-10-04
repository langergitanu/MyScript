package aws.sdk.kotlin.services.p010s3;

import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: S3Client.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.S3Client$Companion", m1609f = "S3Client.kt", m1610i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, m1611l = {302, 303, 309}, m1612m = "finalizeEnvironmentalConfig", m1613n = {"builder", "sharedConfig", "activeProfile", "builder", "sharedConfig", "activeProfile", "builder", "sharedConfig", "activeProfile"}, m1614nl = {303, 309, 310}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, m1616v = 2)
final class S3Client$Companion$finalizeEnvironmentalConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ S3Client.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    S3Client$Companion$finalizeEnvironmentalConfig$1(S3Client.Companion companion, Continuation<? super S3Client$Companion$finalizeEnvironmentalConfig$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.finalizeEnvironmentalConfig((S3Client.Builder) null, (LazyAsyncValue<AwsSharedConfig>) null, (LazyAsyncValue<ConfigSection>) null, (Continuation<? super Unit>) this);
    }
}
