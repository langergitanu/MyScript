package aws.sdk.kotlin.services.p010s3.express;

import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAttributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.http.auth.HttpSigner;
import aws.smithy.kotlin.runtime.http.auth.SignHttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.identity.Identity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3ExpressHttpSigner.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/express/S3ExpressHttpSigner;", "Laws/smithy/kotlin/runtime/http/auth/HttpSigner;", "httpSigner", "<init>", "(Laws/smithy/kotlin/runtime/http/auth/HttpSigner;)V", "sign", "", "signingRequest", "Laws/smithy/kotlin/runtime/http/auth/SignHttpRequest;", "(Laws/smithy/kotlin/runtime/http/auth/SignHttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3ExpressHttpSigner implements HttpSigner {
    private final HttpSigner httpSigner;

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.express.S3ExpressHttpSigner$sign$1 */
    /* JADX INFO: compiled from: S3ExpressHttpSigner.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.express.S3ExpressHttpSigner", m1609f = "S3ExpressHttpSigner.kt", m1610i = {0, 0, 0}, m1611l = {41}, m1612m = "sign", m1613n = {"signingRequest", "sessionToken", "mutAttrs"}, m1614nl = {44}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C31421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C31421(Continuation<? super C31421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return S3ExpressHttpSigner.this.sign(null, this);
        }
    }

    public S3ExpressHttpSigner(HttpSigner httpSigner) {
        Intrinsics.checkNotNullParameter(httpSigner, "httpSigner");
        this.httpSigner = httpSigner;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.http.auth.HttpSigner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object sign(SignHttpRequest signHttpRequest, Continuation<? super Unit> continuation) {
        C31421 c31421;
        String sessionToken;
        SignHttpRequest signHttpRequest2;
        if (continuation instanceof C31421) {
            c31421 = (C31421) continuation;
            if ((c31421.label & Integer.MIN_VALUE) != 0) {
                c31421.label -= Integer.MIN_VALUE;
            } else {
                c31421 = new C31421(continuation);
            }
        }
        Object obj = c31421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31421.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Identity identity = signHttpRequest.getIdentity();
            Credentials credentials = identity instanceof Credentials ? (Credentials) identity : null;
            if (credentials == null || (sessionToken = credentials.getSessionToken()) == null) {
                throw new IllegalStateException("No session token found on identity, required for S3 Express".toString());
            }
            HttpRequestBuilderKt.header(signHttpRequest.getHttpRequest(), S3ExpressHttpSignerKt.S3_EXPRESS_SESSION_TOKEN_HEADER, sessionToken);
            MutableAttributes mutableAttributes = AttributesKt.toMutableAttributes(signHttpRequest.getSigningAttributes());
            mutableAttributes.set(AwsSigningAttributes.INSTANCE.getOmitSessionToken(), Boxing.boxBoolean(true));
            HttpSigner httpSigner = this.httpSigner;
            SignHttpRequest signHttpRequestCopy$default = SignHttpRequest.copy$default(signHttpRequest, null, null, mutableAttributes, 3, null);
            c31421.L$0 = signHttpRequest;
            c31421.L$1 = SpillingKt.nullOutSpilledVariable(sessionToken);
            c31421.L$2 = SpillingKt.nullOutSpilledVariable(mutableAttributes);
            c31421.label = 1;
            if (httpSigner.sign(signHttpRequestCopy$default, c31421) == coroutine_suspended) {
                return coroutine_suspended;
            }
            signHttpRequest2 = signHttpRequest;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            signHttpRequest2 = (SignHttpRequest) c31421.L$0;
            ResultKt.throwOnFailure(obj);
        }
        signHttpRequest2.getHttpRequest().getHeaders().remove("X-Amz-Security-Token");
        return Unit.INSTANCE;
    }
}
