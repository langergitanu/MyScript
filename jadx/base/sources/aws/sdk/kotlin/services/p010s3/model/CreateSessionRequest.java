package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CreateSessionRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u001b\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u001c\u001a\u00020\u001dH\u0096\u0080\u0004J\u0014\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010 \u001a\u00020\u00002\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0\"¢\u0006\u0002\b$H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateSessionRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/CreateSessionRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/CreateSessionRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "sessionMode", "Laws/sdk/kotlin/services/s3/model/SessionMode;", "getSessionMode", "()Laws/sdk/kotlin/services/s3/model/SessionMode;", "ssekmsEncryptionContext", "getSsekmsEncryptionContext", "ssekmsKeyId", "getSsekmsKeyId", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateSessionRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final Boolean bucketKeyEnabled;
    private final ServerSideEncryption serverSideEncryption;
    private final SessionMode sessionMode;
    private final String ssekmsEncryptionContext;
    private final String ssekmsKeyId;

    public /* synthetic */ CreateSessionRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CreateSessionRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.bucketKeyEnabled = builder.getBucketKeyEnabled();
        this.serverSideEncryption = builder.getServerSideEncryption();
        this.sessionMode = builder.getSessionMode();
        this.ssekmsEncryptionContext = builder.getSsekmsEncryptionContext();
        this.ssekmsKeyId = builder.getSsekmsKeyId();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final Boolean getBucketKeyEnabled() {
        return this.bucketKeyEnabled;
    }

    public final ServerSideEncryption getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public final SessionMode getSessionMode() {
        return this.sessionMode;
    }

    public final String getSsekmsEncryptionContext() {
        return this.ssekmsEncryptionContext;
    }

    public final String getSsekmsKeyId() {
        return this.ssekmsKeyId;
    }

    /* JADX INFO: compiled from: CreateSessionRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateSessionRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/CreateSessionRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CreateSessionRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateSessionRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateSessionRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("bucketKeyEnabled=" + this.bucketKeyEnabled + AbstractJsonLexerKt.COMMA);
        sb.append("serverSideEncryption=" + this.serverSideEncryption + AbstractJsonLexerKt.COMMA);
        sb.append("sessionMode=" + this.sessionMode + AbstractJsonLexerKt.COMMA);
        sb.append("ssekmsEncryptionContext=*** Sensitive Data Redacted ***,ssekmsKeyId=*** Sensitive Data Redacted ***)");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.bucketKeyEnabled;
        int iHashCode2 = (iHashCode + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        ServerSideEncryption serverSideEncryption = this.serverSideEncryption;
        int iHashCode3 = (iHashCode2 + (serverSideEncryption != null ? serverSideEncryption.hashCode() : 0)) * 31;
        SessionMode sessionMode = this.sessionMode;
        int iHashCode4 = (iHashCode3 + (sessionMode != null ? sessionMode.hashCode() : 0)) * 31;
        String str2 = this.ssekmsEncryptionContext;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ssekmsKeyId;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CreateSessionRequest createSessionRequest = (CreateSessionRequest) other;
        return Intrinsics.areEqual(this.bucket, createSessionRequest.bucket) && Intrinsics.areEqual(this.bucketKeyEnabled, createSessionRequest.bucketKeyEnabled) && Intrinsics.areEqual(this.serverSideEncryption, createSessionRequest.serverSideEncryption) && Intrinsics.areEqual(this.sessionMode, createSessionRequest.sessionMode) && Intrinsics.areEqual(this.ssekmsEncryptionContext, createSessionRequest.ssekmsEncryptionContext) && Intrinsics.areEqual(this.ssekmsKeyId, createSessionRequest.ssekmsKeyId);
    }

    public static /* synthetic */ CreateSessionRequest copy$default(CreateSessionRequest createSessionRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.CreateSessionRequest.copy.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(createSessionRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final CreateSessionRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CreateSessionRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010&\u001a\u00020\u0005H\u0001J\r\u0010'\u001a\u00020\u0000H\u0000¢\u0006\u0002\b(R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001c\u0010#\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\f¨\u0006)"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateSessionRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/CreateSessionRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateSessionRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "setBucketKeyEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "setServerSideEncryption", "(Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;)V", "sessionMode", "Laws/sdk/kotlin/services/s3/model/SessionMode;", "getSessionMode", "()Laws/sdk/kotlin/services/s3/model/SessionMode;", "setSessionMode", "(Laws/sdk/kotlin/services/s3/model/SessionMode;)V", "ssekmsEncryptionContext", "getSsekmsEncryptionContext", "setSsekmsEncryptionContext", "ssekmsKeyId", "getSsekmsKeyId", "setSsekmsKeyId", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private Boolean bucketKeyEnabled;
        private ServerSideEncryption serverSideEncryption;
        private SessionMode sessionMode;
        private String ssekmsEncryptionContext;
        private String ssekmsKeyId;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final Boolean getBucketKeyEnabled() {
            return this.bucketKeyEnabled;
        }

        public final void setBucketKeyEnabled(Boolean bool) {
            this.bucketKeyEnabled = bool;
        }

        public final ServerSideEncryption getServerSideEncryption() {
            return this.serverSideEncryption;
        }

        public final void setServerSideEncryption(ServerSideEncryption serverSideEncryption) {
            this.serverSideEncryption = serverSideEncryption;
        }

        public final SessionMode getSessionMode() {
            return this.sessionMode;
        }

        public final void setSessionMode(SessionMode sessionMode) {
            this.sessionMode = sessionMode;
        }

        public final String getSsekmsEncryptionContext() {
            return this.ssekmsEncryptionContext;
        }

        public final void setSsekmsEncryptionContext(String str) {
            this.ssekmsEncryptionContext = str;
        }

        public final String getSsekmsKeyId() {
            return this.ssekmsKeyId;
        }

        public final void setSsekmsKeyId(String str) {
            this.ssekmsKeyId = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CreateSessionRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.bucketKeyEnabled = x.getBucketKeyEnabled();
            this.serverSideEncryption = x.getServerSideEncryption();
            this.sessionMode = x.getSessionMode();
            this.ssekmsEncryptionContext = x.getSsekmsEncryptionContext();
            this.ssekmsKeyId = x.getSsekmsKeyId();
        }

        public final CreateSessionRequest build() {
            return new CreateSessionRequest(this, null);
        }
    }
}
