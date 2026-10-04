package aws.sdk.kotlin.services.p010s3.express;

import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: DefaultS3ExpressCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.express.DefaultS3ExpressCredentialsProvider", m1609f = "DefaultS3ExpressCredentialsProvider.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1}, m1611l = {106, 97}, m1612m = "createSessionCredentials$s3", m1613n = {SubscriberAttributeKt.JSON_NAME_KEY, "client", "$this$createSession$iv", "$i$f$createSession", SubscriberAttributeKt.JSON_NAME_KEY, "client", "it", "$i$a$-also-DefaultS3ExpressCredentialsProvider$createSessionCredentials$4"}, m1614nl = {PDFACompliance.e_PDFA9_1, 98}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$3", "I$0"}, m1616v = 2)
final class DefaultS3ExpressCredentialsProvider$createSessionCredentials$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultS3ExpressCredentialsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultS3ExpressCredentialsProvider$createSessionCredentials$1(DefaultS3ExpressCredentialsProvider defaultS3ExpressCredentialsProvider, Continuation<? super DefaultS3ExpressCredentialsProvider$createSessionCredentials$1> continuation) {
        super(continuation);
        this.this$0 = defaultS3ExpressCredentialsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createSessionCredentials$s3(null, null, this);
    }
}
