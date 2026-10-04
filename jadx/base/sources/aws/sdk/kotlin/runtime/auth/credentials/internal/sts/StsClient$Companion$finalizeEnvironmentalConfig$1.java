package aws.sdk.kotlin.runtime.auth.credentials.internal.sts;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClient;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: StsClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClient$Companion", m1609f = "StsClient.kt", m1610i = {0, 0, 0, 1, 1, 1}, m1611l = {84, 85}, m1612m = "finalizeEnvironmentalConfig", m1613n = {"builder", "sharedConfig", "activeProfile", "builder", "sharedConfig", "activeProfile"}, m1614nl = {85, PDFACompliance.e_PDFA9_1}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, m1616v = 2)
final class StsClient$Companion$finalizeEnvironmentalConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StsClient.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StsClient$Companion$finalizeEnvironmentalConfig$1(StsClient.Companion companion, Continuation<? super StsClient$Companion$finalizeEnvironmentalConfig$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.finalizeEnvironmentalConfig((StsClient.Builder) null, (LazyAsyncValue<AwsSharedConfig>) null, (LazyAsyncValue<ConfigSection>) null, (Continuation<? super Unit>) this);
    }
}
