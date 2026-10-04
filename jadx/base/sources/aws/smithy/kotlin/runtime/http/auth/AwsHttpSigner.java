package aws.smithy.kotlin.runtime.http.auth;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSignatureType;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSignedBodyHeader;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigner;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAlgorithm;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAttributes;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningConfig;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningResult;
import aws.smithy.kotlin.runtime.auth.awssigning.HashSpecification;
import aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedUtilKt;
import aws.smithy.kotlin.runtime.client.LogMode;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.auth.AwsHttpSigner;
import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.identity.Identity;
import aws.smithy.kotlin.runtime.time.Instant;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: compiled from: AwsHttpSigner.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/AwsHttpSigner;", "Laws/smithy/kotlin/runtime/http/auth/HttpSigner;", "config", "Laws/smithy/kotlin/runtime/http/auth/AwsHttpSigner$Config;", "<init>", "(Laws/smithy/kotlin/runtime/http/auth/AwsHttpSigner$Config;)V", "sign", "", "signingRequest", "Laws/smithy/kotlin/runtime/http/auth/SignHttpRequest;", "(Laws/smithy/kotlin/runtime/http/auth/SignHttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Config", "http-auth-aws"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsHttpSigner implements HttpSigner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Config config;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.auth.AwsHttpSigner$sign$1 */
    /* JADX INFO: compiled from: AwsHttpSigner.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.auth.AwsHttpSigner", m1609f = "AwsHttpSigner.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {185}, m1612m = "sign", m1613n = {"signingRequest", "attributes", "request", TtmlNode.TAG_BODY, "contextHashSpecification", "contextSignedBodyHeader", "contextSigningRegion", "contextSigningRegionSet", "configSigningRegionSet", "contextUseDoubleUriEncode", "contextNormalizeUriPath", "contextSigningServiceName", "contextOmitSessionToken", "signingConfig", "enableAwsChunked"}, m1614nl = {PDFACompliance.e_PDFA1_8_6}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0"}, m1616v = 2)
    static final class C36991 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C36991(Continuation<? super C36991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwsHttpSigner.this.sign(null, this);
        }
    }

    public AwsHttpSigner(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    /* JADX INFO: compiled from: AwsHttpSigner.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/AwsHttpSigner$Companion;", "", "<init>", "()V", "invoke", "Laws/smithy/kotlin/runtime/http/auth/AwsHttpSigner;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/auth/AwsHttpSigner$Config;", "", "Lkotlin/ExtensionFunctionType;", "http-auth-aws"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AwsHttpSigner invoke(Function1<? super Config, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            if (config.getSigner() == null) {
                throw new IllegalArgumentException("A signer must be specified for the middleware".toString());
            }
            return new AwsHttpSigner(config);
        }
    }

    /* JADX INFO: compiled from: AwsHttpSigner.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010'\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R*\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001d07j\u0002`8X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006="}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/AwsHttpSigner$Config;", "", "<init>", "()V", "signer", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "getSigner", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "setSigner", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;)V", NotificationCompat.CATEGORY_SERVICE, "", "getService", "()Ljava/lang/String;", "setService", "(Ljava/lang/String;)V", "signatureType", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignatureType;", "getSignatureType", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignatureType;", "setSignatureType", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignatureType;)V", "algorithm", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;", "getAlgorithm", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;", "setAlgorithm", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;)V", "isUnsignedPayload", "", "()Z", "setUnsignedPayload", "(Z)V", "useDoubleUriEncode", "getUseDoubleUriEncode", "setUseDoubleUriEncode", "normalizeUriPath", "getNormalizeUriPath", "setNormalizeUriPath", "omitSessionToken", "getOmitSessionToken", "setOmitSessionToken", "signedBodyHeader", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignedBodyHeader;", "getSignedBodyHeader", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignedBodyHeader;", "setSignedBodyHeader", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignedBodyHeader;)V", "expiresAfter", "Lkotlin/time/Duration;", "getExpiresAfter-FghU774", "()Lkotlin/time/Duration;", "setExpiresAfter-BwNAW2A", "(Lkotlin/time/Duration;)V", "shouldSignHeader", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/auth/awssigning/ShouldSignHeaderPredicate;", "getShouldSignHeader", "()Lkotlin/jvm/functions/Function1;", "setShouldSignHeader", "(Lkotlin/jvm/functions/Function1;)V", "http-auth-aws"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Config {
        private Duration expiresAfter;
        private boolean isUnsignedPayload;
        private boolean omitSessionToken;
        private String service;
        private AwsSigner signer;
        private AwsSignatureType signatureType = AwsSignatureType.HTTP_REQUEST_VIA_HEADERS;
        private AwsSigningAlgorithm algorithm = AwsSigningAlgorithm.SIGV4;
        private boolean useDoubleUriEncode = true;
        private boolean normalizeUriPath = true;
        private AwsSignedBodyHeader signedBodyHeader = AwsSignedBodyHeader.NONE;
        private Function1<? super String, Boolean> shouldSignHeader = new Function1() { // from class: aws.smithy.kotlin.runtime.http.auth.AwsHttpSigner$Config$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AwsHttpSigner.Config.shouldSignHeader$lambda$0((String) obj));
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean shouldSignHeader$lambda$0(String str) {
            Intrinsics.checkNotNullParameter(str, "<unused var>");
            return true;
        }

        public final AwsSigner getSigner() {
            return this.signer;
        }

        public final void setSigner(AwsSigner awsSigner) {
            this.signer = awsSigner;
        }

        public final String getService() {
            return this.service;
        }

        public final void setService(String str) {
            this.service = str;
        }

        public final AwsSignatureType getSignatureType() {
            return this.signatureType;
        }

        public final void setSignatureType(AwsSignatureType awsSignatureType) {
            Intrinsics.checkNotNullParameter(awsSignatureType, "<set-?>");
            this.signatureType = awsSignatureType;
        }

        public final AwsSigningAlgorithm getAlgorithm() {
            return this.algorithm;
        }

        public final void setAlgorithm(AwsSigningAlgorithm awsSigningAlgorithm) {
            Intrinsics.checkNotNullParameter(awsSigningAlgorithm, "<set-?>");
            this.algorithm = awsSigningAlgorithm;
        }

        /* JADX INFO: renamed from: isUnsignedPayload, reason: from getter */
        public final boolean getIsUnsignedPayload() {
            return this.isUnsignedPayload;
        }

        public final void setUnsignedPayload(boolean z) {
            this.isUnsignedPayload = z;
        }

        public final boolean getUseDoubleUriEncode() {
            return this.useDoubleUriEncode;
        }

        public final void setUseDoubleUriEncode(boolean z) {
            this.useDoubleUriEncode = z;
        }

        public final boolean getNormalizeUriPath() {
            return this.normalizeUriPath;
        }

        public final void setNormalizeUriPath(boolean z) {
            this.normalizeUriPath = z;
        }

        public final boolean getOmitSessionToken() {
            return this.omitSessionToken;
        }

        public final void setOmitSessionToken(boolean z) {
            this.omitSessionToken = z;
        }

        public final AwsSignedBodyHeader getSignedBodyHeader() {
            return this.signedBodyHeader;
        }

        public final void setSignedBodyHeader(AwsSignedBodyHeader awsSignedBodyHeader) {
            Intrinsics.checkNotNullParameter(awsSignedBodyHeader, "<set-?>");
            this.signedBodyHeader = awsSignedBodyHeader;
        }

        /* JADX INFO: renamed from: getExpiresAfter-FghU774, reason: not valid java name and from getter */
        public final Duration getExpiresAfter() {
            return this.expiresAfter;
        }

        /* JADX INFO: renamed from: setExpiresAfter-BwNAW2A, reason: not valid java name */
        public final void m12163setExpiresAfterBwNAW2A(Duration duration) {
            this.expiresAfter = duration;
        }

        public final Function1<String, Boolean> getShouldSignHeader() {
            return this.shouldSignHeader;
        }

        public final void setShouldSignHeader(Function1<? super String, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.shouldSignHeader = function1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v13, types: [aws.smithy.kotlin.runtime.http.DeferredHeaders] */
    @Override // aws.smithy.kotlin.runtime.http.auth.HttpSigner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object sign(SignHttpRequest signHttpRequest, Continuation<? super Unit> continuation) {
        C36991 c36991;
        HttpRequestBuilder httpRequest;
        Object obj;
        String service;
        String strJoinToString$default;
        Set set;
        String str;
        HashSpecification.CalculateFromPayload calculateFromPayload;
        AwsSigningConfig awsSigningConfig;
        Attributes attributes;
        HashSpecification.StreamingAws4HmacSha256Payload streamingAws4HmacSha256Payload;
        Set set2;
        if (continuation instanceof C36991) {
            c36991 = (C36991) continuation;
            if ((c36991.label & Integer.MIN_VALUE) != 0) {
                c36991.label -= Integer.MIN_VALUE;
            } else {
                c36991 = new C36991(continuation);
            }
        }
        Object obj2 = c36991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36991.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            if (!(signHttpRequest.getIdentity() instanceof Credentials)) {
                throw new IllegalArgumentException(("invalid Identity type " + Reflection.getOrCreateKotlinClass(signHttpRequest.getIdentity().getClass()) + "; expected " + Reflection.getOrCreateKotlinClass(Credentials.class)).toString());
            }
            Attributes signingAttributes = signHttpRequest.getSigningAttributes();
            httpRequest = signHttpRequest.getHttpRequest();
            HttpBody body = httpRequest.getBody();
            HashSpecification hashSpecification = (HashSpecification) signingAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getHashSpecification());
            AwsSignedBodyHeader awsSignedBodyHeader = (AwsSignedBodyHeader) signingAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getSignedBodyHeader());
            String str2 = (String) AttributesKt.get(signingAttributes, AwsSigningAttributes.INSTANCE.getSigningRegion());
            Set set3 = (Set) signingAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getSigningRegionSet());
            Set set4 = (Set) signingAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getConfigSigningRegionSet());
            Boolean bool = (Boolean) signingAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getUseDoubleUriEncode());
            Boolean bool2 = (Boolean) signingAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getNormalizeUriPath());
            String str3 = (String) signingAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getSigningService());
            Boolean bool3 = (Boolean) signingAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getOmitSessionToken());
            obj = "Required value was null.";
            Boolean bool4 = (Boolean) signingAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getEnableAwsChunked());
            ?? BooleanValue = bool4 != null ? bool4.booleanValue() : 0;
            AwsSigningConfig.Companion companion = AwsSigningConfig.INSTANCE;
            AwsSigningConfig.Builder builder = new AwsSigningConfig.Builder();
            if (str3 == null) {
                service = this.config.getService();
                if (service == null) {
                    throw new IllegalStateException(obj.toString());
                }
            } else {
                service = str3;
            }
            builder.setService(service);
            Identity identity = signHttpRequest.getIdentity();
            Intrinsics.checkNotNull(identity, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.auth.awscredentials.Credentials");
            builder.setCredentials((Credentials) identity);
            builder.setAlgorithm(this.config.getAlgorithm());
            if (builder.getAlgorithm() != AwsSigningAlgorithm.SIGV4_ASYMMETRIC || (set2 = set4) == null || set2.isEmpty()) {
                strJoinToString$default = (builder.getAlgorithm() != AwsSigningAlgorithm.SIGV4_ASYMMETRIC || (set = set3) == null || set.isEmpty()) ? str2 : CollectionsKt.joinToString$default(set3, ",", null, null, 0, null, null, 62, null);
            } else {
                strJoinToString$default = CollectionsKt.joinToString$default(set4, ",", null, null, 0, null, null, 62, null);
            }
            builder.setRegion(strJoinToString$default);
            Instant instantM12289plusLRDsOJo = (Instant) signingAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getSigningDate());
            if (instantM12289plusLRDsOJo == null) {
                Instant instantNow = Instant.INSTANCE.now();
                Duration duration = (Duration) signingAttributes.getOrNull(HttpOperationContext.INSTANCE.getClockSkew());
                str = str2;
                instantM12289plusLRDsOJo = instantNow.m12289plusLRDsOJo(duration != null ? duration.getRawValue() : Duration.INSTANCE.m15951getZEROUwyO8pc());
            } else {
                str = str2;
            }
            builder.setSigningDate(instantM12289plusLRDsOJo);
            builder.setSignatureType(this.config.getSignatureType());
            builder.setOmitSessionToken(bool3 != null ? bool3.booleanValue() : this.config.getOmitSessionToken());
            builder.setNormalizeUriPath(bool2 != null ? bool2.booleanValue() : this.config.getNormalizeUriPath());
            builder.setUseDoubleUriEncode(bool != null ? bool.booleanValue() : this.config.getUseDoubleUriEncode());
            builder.m12135setExpiresAfterBwNAW2A(this.config.getExpiresAfter());
            builder.setShouldSignHeader(this.config.getShouldSignHeader());
            builder.setSignedBodyHeader(awsSignedBodyHeader == null ? this.config.getSignedBodyHeader() : awsSignedBodyHeader);
            LogMode logMode = (LogMode) signingAttributes.getOrNull(SdkClientOption.INSTANCE.getLogMode());
            builder.setLogRequest(logMode != null && logMode.isEnabled(LogMode.LogRequest.INSTANCE));
            if (hashSpecification != null) {
                calculateFromPayload = hashSpecification;
            } else if (body instanceof HttpBody.Empty) {
                calculateFromPayload = HashSpecification.EmptyBody.INSTANCE;
            } else if (AwsChunkedUtilKt.isEligibleForAwsChunkedStreaming(body) && BooleanValue != 0) {
                if (httpRequest.getHeaders().contains("x-amz-trailer")) {
                    streamingAws4HmacSha256Payload = (HashSpecification.HashLiteral) (this.config.getIsUnsignedPayload() ? HashSpecification.StreamingUnsignedPayloadWithTrailers.INSTANCE : HashSpecification.StreamingAws4HmacSha256PayloadWithTrailers.INSTANCE);
                } else {
                    streamingAws4HmacSha256Payload = HashSpecification.StreamingAws4HmacSha256Payload.INSTANCE;
                }
                calculateFromPayload = streamingAws4HmacSha256Payload;
            } else {
                calculateFromPayload = this.config.getIsUnsignedPayload() ? HashSpecification.UnsignedPayload.INSTANCE : HashSpecification.CalculateFromPayload.INSTANCE;
            }
            builder.setHashSpecification(calculateFromPayload);
            AwsSigningConfig awsSigningConfigBuild = builder.build();
            if (AwsChunkedUtilKt.getUseAwsChunkedEncoding(awsSigningConfigBuild)) {
                AwsChunkedUtilKt.setAwsChunkedHeaders(httpRequest);
            }
            AwsSigner signer = this.config.getSigner();
            if (signer == null) {
                throw new IllegalStateException(obj.toString());
            }
            HttpRequest httpRequestBuild = httpRequest.build();
            c36991.L$0 = SpillingKt.nullOutSpilledVariable(signHttpRequest);
            c36991.L$1 = signingAttributes;
            c36991.L$2 = httpRequest;
            c36991.L$3 = SpillingKt.nullOutSpilledVariable(body);
            c36991.L$4 = SpillingKt.nullOutSpilledVariable(hashSpecification);
            c36991.L$5 = SpillingKt.nullOutSpilledVariable(awsSignedBodyHeader);
            c36991.L$6 = SpillingKt.nullOutSpilledVariable(str);
            c36991.L$7 = SpillingKt.nullOutSpilledVariable(set3);
            c36991.L$8 = SpillingKt.nullOutSpilledVariable(set4);
            c36991.L$9 = SpillingKt.nullOutSpilledVariable(bool);
            c36991.L$10 = SpillingKt.nullOutSpilledVariable(bool2);
            c36991.L$11 = SpillingKt.nullOutSpilledVariable(str3);
            c36991.L$12 = SpillingKt.nullOutSpilledVariable(bool3);
            c36991.L$13 = awsSigningConfigBuild;
            c36991.I$0 = BooleanValue;
            c36991.label = 1;
            Object objSign = signer.sign(httpRequestBuild, awsSigningConfigBuild, c36991);
            if (objSign == coroutine_suspended) {
                return coroutine_suspended;
            }
            awsSigningConfig = awsSigningConfigBuild;
            attributes = signingAttributes;
            obj2 = objSign;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c36991.I$0;
            awsSigningConfig = (AwsSigningConfig) c36991.L$13;
            httpRequest = (HttpRequestBuilder) c36991.L$2;
            attributes = (Attributes) c36991.L$1;
            ResultKt.throwOnFailure(obj2);
            obj = "Required value was null.";
        }
        AwsSigningConfig awsSigningConfig2 = awsSigningConfig;
        HttpRequestBuilder httpRequestBuilder = httpRequest;
        AwsSigningResult awsSigningResult = (AwsSigningResult) obj2;
        HttpRequest httpRequest2 = (HttpRequest) awsSigningResult.getOutput();
        CompletableDeferred completableDeferred = (CompletableDeferred) attributes.getOrNull(AwsSigningAttributes.INSTANCE.getRequestSignature());
        if (completableDeferred != null) {
            Boxing.boxBoolean(completableDeferred.complete(awsSigningResult.getSignature()));
        }
        AwsHttpSignerKt.update(httpRequestBuilder, httpRequest2);
        if (AwsChunkedUtilKt.getUseAwsChunkedEncoding(awsSigningConfig2)) {
            AwsSigner signer2 = this.config.getSigner();
            if (signer2 != null) {
                AwsChunkedUtilKt.setAwsChunkedBody(httpRequestBuilder, signer2, awsSigningConfig2, awsSigningResult.getSignature(), httpRequestBuilder.getTrailingHeaders().build(), c36991.getContext());
            } else {
                throw new IllegalStateException(obj.toString());
            }
        }
        return Unit.INSTANCE;
    }
}
