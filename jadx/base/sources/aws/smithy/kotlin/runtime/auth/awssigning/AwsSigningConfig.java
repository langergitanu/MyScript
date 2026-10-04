package aws.smithy.kotlin.runtime.auth.awssigning;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningConfig;
import aws.smithy.kotlin.runtime.auth.awssigning.HashSpecification;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: compiled from: AwsSigningConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u000289B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u00107\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011j\u0002`\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010#\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u00101\u001a\u0004\u0018\u000102¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u0010 ¨\u0006:"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "", "builder", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig$Builder;", "<init>", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig$Builder;)V", TtmlNode.TAG_REGION, "", "getRegion", "()Ljava/lang/String;", NotificationCompat.CATEGORY_SERVICE, "getService", "signingDate", "Laws/smithy/kotlin/runtime/time/Instant;", "getSigningDate", "()Laws/smithy/kotlin/runtime/time/Instant;", "shouldSignHeader", "Lkotlin/Function1;", "", "Laws/smithy/kotlin/runtime/auth/awssigning/ShouldSignHeaderPredicate;", "getShouldSignHeader", "()Lkotlin/jvm/functions/Function1;", "algorithm", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;", "getAlgorithm", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;", "signatureType", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignatureType;", "getSignatureType", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignatureType;", "useDoubleUriEncode", "getUseDoubleUriEncode", "()Z", "normalizeUriPath", "getNormalizeUriPath", "omitSessionToken", "getOmitSessionToken", "hashSpecification", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification;", "getHashSpecification", "()Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification;", "signedBodyHeader", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignedBodyHeader;", "getSignedBodyHeader", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignedBodyHeader;", "credentials", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "getCredentials", "()Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "expiresAfter", "Lkotlin/time/Duration;", "getExpiresAfter-FghU774", "()Lkotlin/time/Duration;", "logRequest", "getLogRequest", "toBuilder", "Companion", "Builder", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsSigningConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AwsSigningAlgorithm algorithm;
    private final Credentials credentials;
    private final Duration expiresAfter;
    private final HashSpecification hashSpecification;
    private final boolean logRequest;
    private final boolean normalizeUriPath;
    private final boolean omitSessionToken;
    private final String region;
    private final String service;
    private final Function1<String, Boolean> shouldSignHeader;
    private final AwsSignatureType signatureType;
    private final AwsSignedBodyHeader signedBodyHeader;
    private final Instant signingDate;
    private final boolean useDoubleUriEncode;

    /* JADX INFO: compiled from: AwsSigningConfig.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig$Companion;", "", "<init>", "()V", "invoke", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AwsSigningConfig invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public AwsSigningConfig(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        String region = builder.getRegion();
        if (region == null) {
            throw new IllegalArgumentException("Signing config must specify a region".toString());
        }
        this.region = region;
        String service = builder.getService();
        if (service == null) {
            throw new IllegalArgumentException("Signing config must specify a service".toString());
        }
        this.service = service;
        Instant signingDate = builder.getSigningDate();
        this.signingDate = signingDate == null ? Instant.INSTANCE.now() : signingDate;
        this.shouldSignHeader = builder.getShouldSignHeader();
        this.algorithm = builder.getAlgorithm();
        this.signatureType = builder.getSignatureType();
        this.useDoubleUriEncode = builder.getUseDoubleUriEncode();
        this.normalizeUriPath = builder.getNormalizeUriPath();
        this.omitSessionToken = builder.getOmitSessionToken();
        HashSpecification.CalculateFromPayload hashSpecification = builder.getHashSpecification();
        this.hashSpecification = hashSpecification == null ? HashSpecification.CalculateFromPayload.INSTANCE : hashSpecification;
        this.signedBodyHeader = builder.getSignedBodyHeader();
        Credentials credentials = builder.getCredentials();
        if (credentials == null) {
            throw new IllegalArgumentException("Signing config must specify credentials".toString());
        }
        this.credentials = credentials;
        this.expiresAfter = builder.getExpiresAfter();
        this.logRequest = builder.getLogRequest();
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getService() {
        return this.service;
    }

    public final Instant getSigningDate() {
        return this.signingDate;
    }

    public final Function1<String, Boolean> getShouldSignHeader() {
        return this.shouldSignHeader;
    }

    public final AwsSigningAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    public final AwsSignatureType getSignatureType() {
        return this.signatureType;
    }

    public final boolean getUseDoubleUriEncode() {
        return this.useDoubleUriEncode;
    }

    public final boolean getNormalizeUriPath() {
        return this.normalizeUriPath;
    }

    public final boolean getOmitSessionToken() {
        return this.omitSessionToken;
    }

    public final HashSpecification getHashSpecification() {
        return this.hashSpecification;
    }

    public final AwsSignedBodyHeader getSignedBodyHeader() {
        return this.signedBodyHeader;
    }

    public final Credentials getCredentials() {
        return this.credentials;
    }

    /* JADX INFO: renamed from: getExpiresAfter-FghU774, reason: not valid java name and from getter */
    public final Duration getExpiresAfter() {
        return this.expiresAfter;
    }

    public final boolean getLogRequest() {
        return this.logRequest;
    }

    public final Builder toBuilder() {
        Builder builder = new Builder();
        builder.setRegion(this.region);
        builder.setService(this.service);
        builder.setSigningDate(this.signingDate);
        builder.setShouldSignHeader(this.shouldSignHeader);
        builder.setAlgorithm(this.algorithm);
        builder.setSignatureType(this.signatureType);
        builder.setUseDoubleUriEncode(this.useDoubleUriEncode);
        builder.setNormalizeUriPath(this.normalizeUriPath);
        builder.setOmitSessionToken(this.omitSessionToken);
        builder.setHashSpecification(this.hashSpecification);
        builder.setSignedBodyHeader(this.signedBodyHeader);
        builder.setCredentials(this.credentials);
        builder.m12135setExpiresAfterBwNAW2A(this.expiresAfter);
        builder.setLogRequest(this.logRequest);
        return builder;
    }

    /* JADX INFO: compiled from: AwsSigningConfig.kt */
    @Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010M\u001a\u00020NR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014j\u0002`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001a\u0010/\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010)\"\u0004\bL\u0010+¨\u0006O"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig$Builder;", "", "<init>", "()V", TtmlNode.TAG_REGION, "", "getRegion", "()Ljava/lang/String;", "setRegion", "(Ljava/lang/String;)V", NotificationCompat.CATEGORY_SERVICE, "getService", "setService", "signingDate", "Laws/smithy/kotlin/runtime/time/Instant;", "getSigningDate", "()Laws/smithy/kotlin/runtime/time/Instant;", "setSigningDate", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "shouldSignHeader", "Lkotlin/Function1;", "", "Laws/smithy/kotlin/runtime/auth/awssigning/ShouldSignHeaderPredicate;", "getShouldSignHeader", "()Lkotlin/jvm/functions/Function1;", "setShouldSignHeader", "(Lkotlin/jvm/functions/Function1;)V", "algorithm", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;", "getAlgorithm", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;", "setAlgorithm", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;)V", "signatureType", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignatureType;", "getSignatureType", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignatureType;", "setSignatureType", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignatureType;)V", "useDoubleUriEncode", "getUseDoubleUriEncode", "()Z", "setUseDoubleUriEncode", "(Z)V", "normalizeUriPath", "getNormalizeUriPath", "setNormalizeUriPath", "omitSessionToken", "getOmitSessionToken", "setOmitSessionToken", "hashSpecification", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification;", "getHashSpecification", "()Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification;", "setHashSpecification", "(Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification;)V", "signedBodyHeader", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignedBodyHeader;", "getSignedBodyHeader", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignedBodyHeader;", "setSignedBodyHeader", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSignedBodyHeader;)V", "credentials", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "getCredentials", "()Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "setCredentials", "(Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;)V", "expiresAfter", "Lkotlin/time/Duration;", "getExpiresAfter-FghU774", "()Lkotlin/time/Duration;", "setExpiresAfter-BwNAW2A", "(Lkotlin/time/Duration;)V", "logRequest", "getLogRequest", "setLogRequest", "build", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Credentials credentials;
        private Duration expiresAfter;
        private HashSpecification hashSpecification;
        private boolean logRequest;
        private boolean omitSessionToken;
        private String region;
        private String service;
        private Instant signingDate;
        private Function1<? super String, Boolean> shouldSignHeader = new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningConfig$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AwsSigningConfig.Builder.shouldSignHeader$lambda$0((String) obj));
            }
        };
        private AwsSigningAlgorithm algorithm = AwsSigningAlgorithm.SIGV4;
        private AwsSignatureType signatureType = AwsSignatureType.HTTP_REQUEST_VIA_HEADERS;
        private boolean useDoubleUriEncode = true;
        private boolean normalizeUriPath = true;
        private AwsSignedBodyHeader signedBodyHeader = AwsSignedBodyHeader.NONE;

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean shouldSignHeader$lambda$0(String str) {
            Intrinsics.checkNotNullParameter(str, "<unused var>");
            return true;
        }

        public final String getRegion() {
            return this.region;
        }

        public final void setRegion(String str) {
            this.region = str;
        }

        public final String getService() {
            return this.service;
        }

        public final void setService(String str) {
            this.service = str;
        }

        public final Instant getSigningDate() {
            return this.signingDate;
        }

        public final void setSigningDate(Instant instant) {
            this.signingDate = instant;
        }

        public final Function1<String, Boolean> getShouldSignHeader() {
            return this.shouldSignHeader;
        }

        public final void setShouldSignHeader(Function1<? super String, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.shouldSignHeader = function1;
        }

        public final AwsSigningAlgorithm getAlgorithm() {
            return this.algorithm;
        }

        public final void setAlgorithm(AwsSigningAlgorithm awsSigningAlgorithm) {
            Intrinsics.checkNotNullParameter(awsSigningAlgorithm, "<set-?>");
            this.algorithm = awsSigningAlgorithm;
        }

        public final AwsSignatureType getSignatureType() {
            return this.signatureType;
        }

        public final void setSignatureType(AwsSignatureType awsSignatureType) {
            Intrinsics.checkNotNullParameter(awsSignatureType, "<set-?>");
            this.signatureType = awsSignatureType;
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

        public final HashSpecification getHashSpecification() {
            return this.hashSpecification;
        }

        public final void setHashSpecification(HashSpecification hashSpecification) {
            this.hashSpecification = hashSpecification;
        }

        public final AwsSignedBodyHeader getSignedBodyHeader() {
            return this.signedBodyHeader;
        }

        public final void setSignedBodyHeader(AwsSignedBodyHeader awsSignedBodyHeader) {
            Intrinsics.checkNotNullParameter(awsSignedBodyHeader, "<set-?>");
            this.signedBodyHeader = awsSignedBodyHeader;
        }

        public final Credentials getCredentials() {
            return this.credentials;
        }

        public final void setCredentials(Credentials credentials) {
            this.credentials = credentials;
        }

        /* JADX INFO: renamed from: getExpiresAfter-FghU774, reason: not valid java name and from getter */
        public final Duration getExpiresAfter() {
            return this.expiresAfter;
        }

        /* JADX INFO: renamed from: setExpiresAfter-BwNAW2A, reason: not valid java name */
        public final void m12135setExpiresAfterBwNAW2A(Duration duration) {
            this.expiresAfter = duration;
        }

        public final boolean getLogRequest() {
            return this.logRequest;
        }

        public final void setLogRequest(boolean z) {
            this.logRequest = z;
        }

        public final AwsSigningConfig build() {
            return new AwsSigningConfig(this);
        }
    }
}
