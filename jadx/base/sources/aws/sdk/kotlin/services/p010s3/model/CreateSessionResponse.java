package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.SessionCredentials;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CreateSessionResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0019\u001a\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u001a\u001a\u00020\u001bH\u0096\u0080\u0004J\u0014\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001e\u001a\u00020\u00002\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateSessionResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/CreateSessionResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/CreateSessionResponse$Builder;)V", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "credentials", "Laws/sdk/kotlin/services/s3/model/SessionCredentials;", "getCredentials", "()Laws/sdk/kotlin/services/s3/model/SessionCredentials;", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "ssekmsEncryptionContext", "", "getSsekmsEncryptionContext", "()Ljava/lang/String;", "ssekmsKeyId", "getSsekmsKeyId", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateSessionResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean bucketKeyEnabled;
    private final SessionCredentials credentials;
    private final ServerSideEncryption serverSideEncryption;
    private final String ssekmsEncryptionContext;
    private final String ssekmsKeyId;

    public /* synthetic */ CreateSessionResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CreateSessionResponse(Builder builder) {
        this.bucketKeyEnabled = builder.getBucketKeyEnabled();
        this.credentials = builder.getCredentials();
        this.serverSideEncryption = builder.getServerSideEncryption();
        this.ssekmsEncryptionContext = builder.getSsekmsEncryptionContext();
        this.ssekmsKeyId = builder.getSsekmsKeyId();
    }

    public final Boolean getBucketKeyEnabled() {
        return this.bucketKeyEnabled;
    }

    public final SessionCredentials getCredentials() {
        return this.credentials;
    }

    public final ServerSideEncryption getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public final String getSsekmsEncryptionContext() {
        return this.ssekmsEncryptionContext;
    }

    public final String getSsekmsKeyId() {
        return this.ssekmsKeyId;
    }

    /* JADX INFO: compiled from: CreateSessionResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateSessionResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/CreateSessionResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CreateSessionResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateSessionResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateSessionResponse(");
        sb.append("bucketKeyEnabled=" + this.bucketKeyEnabled + AbstractJsonLexerKt.COMMA);
        sb.append("credentials=" + this.credentials + AbstractJsonLexerKt.COMMA);
        sb.append("serverSideEncryption=" + this.serverSideEncryption + AbstractJsonLexerKt.COMMA);
        sb.append("ssekmsEncryptionContext=*** Sensitive Data Redacted ***,ssekmsKeyId=*** Sensitive Data Redacted ***)");
        return sb.toString();
    }

    public int hashCode() {
        Boolean bool = this.bucketKeyEnabled;
        int iHashCode = (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0) * 31;
        SessionCredentials sessionCredentials = this.credentials;
        int iHashCode2 = (iHashCode + (sessionCredentials != null ? sessionCredentials.hashCode() : 0)) * 31;
        ServerSideEncryption serverSideEncryption = this.serverSideEncryption;
        int iHashCode3 = (iHashCode2 + (serverSideEncryption != null ? serverSideEncryption.hashCode() : 0)) * 31;
        String str = this.ssekmsEncryptionContext;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.ssekmsKeyId;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CreateSessionResponse createSessionResponse = (CreateSessionResponse) other;
        return Intrinsics.areEqual(this.bucketKeyEnabled, createSessionResponse.bucketKeyEnabled) && Intrinsics.areEqual(this.credentials, createSessionResponse.credentials) && Intrinsics.areEqual(this.serverSideEncryption, createSessionResponse.serverSideEncryption) && Intrinsics.areEqual(this.ssekmsEncryptionContext, createSessionResponse.ssekmsEncryptionContext) && Intrinsics.areEqual(this.ssekmsKeyId, createSessionResponse.ssekmsKeyId);
    }

    public static /* synthetic */ CreateSessionResponse copy$default(CreateSessionResponse createSessionResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.CreateSessionResponse.copy.1
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
        Builder builder = new Builder(createSessionResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final CreateSessionResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CreateSessionResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010#\u001a\u00020\u0005H\u0001J\u001f\u0010\u000e\u001a\u00020$2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020$0&¢\u0006\u0002\b(J\r\u0010)\u001a\u00020\u0000H\u0000¢\u0006\u0002\b*R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006+"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateSessionResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/CreateSessionResponse;", "(Laws/sdk/kotlin/services/s3/model/CreateSessionResponse;)V", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "setBucketKeyEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "credentials", "Laws/sdk/kotlin/services/s3/model/SessionCredentials;", "getCredentials", "()Laws/sdk/kotlin/services/s3/model/SessionCredentials;", "setCredentials", "(Laws/sdk/kotlin/services/s3/model/SessionCredentials;)V", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "setServerSideEncryption", "(Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;)V", "ssekmsEncryptionContext", "", "getSsekmsEncryptionContext", "()Ljava/lang/String;", "setSsekmsEncryptionContext", "(Ljava/lang/String;)V", "ssekmsKeyId", "getSsekmsKeyId", "setSsekmsKeyId", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/SessionCredentials$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Boolean bucketKeyEnabled;
        private SessionCredentials credentials;
        private ServerSideEncryption serverSideEncryption;
        private String ssekmsEncryptionContext;
        private String ssekmsKeyId;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Boolean getBucketKeyEnabled() {
            return this.bucketKeyEnabled;
        }

        public final void setBucketKeyEnabled(Boolean bool) {
            this.bucketKeyEnabled = bool;
        }

        public final SessionCredentials getCredentials() {
            return this.credentials;
        }

        public final void setCredentials(SessionCredentials sessionCredentials) {
            this.credentials = sessionCredentials;
        }

        public final ServerSideEncryption getServerSideEncryption() {
            return this.serverSideEncryption;
        }

        public final void setServerSideEncryption(ServerSideEncryption serverSideEncryption) {
            this.serverSideEncryption = serverSideEncryption;
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
        public Builder(CreateSessionResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucketKeyEnabled = x.getBucketKeyEnabled();
            this.credentials = x.getCredentials();
            this.serverSideEncryption = x.getServerSideEncryption();
            this.ssekmsEncryptionContext = x.getSsekmsEncryptionContext();
            this.ssekmsKeyId = x.getSsekmsKeyId();
        }

        public final CreateSessionResponse build() {
            return new CreateSessionResponse(this, null);
        }

        public final void credentials(Function1<? super SessionCredentials.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.credentials = CreateSessionResponseKt.awsSdkKotlinServicesS3ModelSessionCredentialsDslBuilderRef.invoke(block);
        }
    }
}
