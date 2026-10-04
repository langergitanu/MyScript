package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.ObjectLockRetention;
import aws.smithy.kotlin.runtime.SdkDsl;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PutObjectRetentionRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010#\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010$\u001a\u00020%H\u0096\u0080\u0004J\u0014\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010(\u001a\u00020\u00002\u0019\b\u0002\u0010)\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006/"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "bypassGovernanceRetention", "", "getBypassGovernanceRetention", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "contentMd5", "getContentMd5", "expectedBucketOwner", "getExpectedBucketOwner", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "retention", "Laws/sdk/kotlin/services/s3/model/ObjectLockRetention;", "getRetention", "()Laws/sdk/kotlin/services/s3/model/ObjectLockRetention;", "versionId", "getVersionId", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PutObjectRetentionRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final Boolean bypassGovernanceRetention;
    private final ChecksumAlgorithm checksumAlgorithm;
    private final String contentMd5;
    private final String expectedBucketOwner;
    private final String key;
    private final RequestPayer requestPayer;
    private final ObjectLockRetention retention;
    private final String versionId;

    public /* synthetic */ PutObjectRetentionRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PutObjectRetentionRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.bypassGovernanceRetention = builder.getBypassGovernanceRetention();
        this.checksumAlgorithm = builder.getChecksumAlgorithm();
        this.contentMd5 = builder.getContentMd5();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.key = builder.getKey();
        this.requestPayer = builder.getRequestPayer();
        this.retention = builder.getRetention();
        this.versionId = builder.getVersionId();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final Boolean getBypassGovernanceRetention() {
        return this.bypassGovernanceRetention;
    }

    public final ChecksumAlgorithm getChecksumAlgorithm() {
        return this.checksumAlgorithm;
    }

    public final String getContentMd5() {
        return this.contentMd5;
    }

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
    }

    public final String getKey() {
        return this.key;
    }

    public final RequestPayer getRequestPayer() {
        return this.requestPayer;
    }

    public final ObjectLockRetention getRetention() {
        return this.retention;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    /* JADX INFO: compiled from: PutObjectRetentionRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PutObjectRetentionRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutObjectRetentionRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("bypassGovernanceRetention=" + this.bypassGovernanceRetention + AbstractJsonLexerKt.COMMA);
        sb.append("checksumAlgorithm=" + this.checksumAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("contentMd5=" + this.contentMd5 + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("requestPayer=" + this.requestPayer + AbstractJsonLexerKt.COMMA);
        sb.append("retention=" + this.retention + AbstractJsonLexerKt.COMMA);
        sb.append("versionId=" + this.versionId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.bypassGovernanceRetention;
        int iHashCode2 = (iHashCode + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        ChecksumAlgorithm checksumAlgorithm = this.checksumAlgorithm;
        int iHashCode3 = (iHashCode2 + (checksumAlgorithm != null ? checksumAlgorithm.hashCode() : 0)) * 31;
        String str2 = this.contentMd5;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.expectedBucketOwner;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.key;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        RequestPayer requestPayer = this.requestPayer;
        int iHashCode7 = (iHashCode6 + (requestPayer != null ? requestPayer.hashCode() : 0)) * 31;
        ObjectLockRetention objectLockRetention = this.retention;
        int iHashCode8 = (iHashCode7 + (objectLockRetention != null ? objectLockRetention.hashCode() : 0)) * 31;
        String str5 = this.versionId;
        return iHashCode8 + (str5 != null ? str5.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        PutObjectRetentionRequest putObjectRetentionRequest = (PutObjectRetentionRequest) other;
        return Intrinsics.areEqual(this.bucket, putObjectRetentionRequest.bucket) && Intrinsics.areEqual(this.bypassGovernanceRetention, putObjectRetentionRequest.bypassGovernanceRetention) && Intrinsics.areEqual(this.checksumAlgorithm, putObjectRetentionRequest.checksumAlgorithm) && Intrinsics.areEqual(this.contentMd5, putObjectRetentionRequest.contentMd5) && Intrinsics.areEqual(this.expectedBucketOwner, putObjectRetentionRequest.expectedBucketOwner) && Intrinsics.areEqual(this.key, putObjectRetentionRequest.key) && Intrinsics.areEqual(this.requestPayer, putObjectRetentionRequest.requestPayer) && Intrinsics.areEqual(this.retention, putObjectRetentionRequest.retention) && Intrinsics.areEqual(this.versionId, putObjectRetentionRequest.versionId);
    }

    public static /* synthetic */ PutObjectRetentionRequest copy$default(PutObjectRetentionRequest putObjectRetentionRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.PutObjectRetentionRequest.copy.1
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
        Builder builder = new Builder(putObjectRetentionRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final PutObjectRetentionRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: PutObjectRetentionRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u00102\u001a\u00020\u0005H\u0001J\u001f\u0010)\u001a\u0002032\u0017\u00104\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020305¢\u0006\u0002\b7J\r\u00108\u001a\u00020\u0000H\u0000¢\u0006\u0002\b9R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR\u001c\u0010 \u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\n\"\u0004\b1\u0010\f¨\u0006:"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "bypassGovernanceRetention", "", "getBypassGovernanceRetention", "()Ljava/lang/Boolean;", "setBypassGovernanceRetention", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "setChecksumAlgorithm", "(Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;)V", "contentMd5", "getContentMd5", "setContentMd5", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "setRequestPayer", "(Laws/sdk/kotlin/services/s3/model/RequestPayer;)V", "retention", "Laws/sdk/kotlin/services/s3/model/ObjectLockRetention;", "getRetention", "()Laws/sdk/kotlin/services/s3/model/ObjectLockRetention;", "setRetention", "(Laws/sdk/kotlin/services/s3/model/ObjectLockRetention;)V", "versionId", "getVersionId", "setVersionId", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ObjectLockRetention$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private Boolean bypassGovernanceRetention;
        private ChecksumAlgorithm checksumAlgorithm;
        private String contentMd5;
        private String expectedBucketOwner;
        private String key;
        private RequestPayer requestPayer;
        private ObjectLockRetention retention;
        private String versionId;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final Boolean getBypassGovernanceRetention() {
            return this.bypassGovernanceRetention;
        }

        public final void setBypassGovernanceRetention(Boolean bool) {
            this.bypassGovernanceRetention = bool;
        }

        public final ChecksumAlgorithm getChecksumAlgorithm() {
            return this.checksumAlgorithm;
        }

        public final void setChecksumAlgorithm(ChecksumAlgorithm checksumAlgorithm) {
            this.checksumAlgorithm = checksumAlgorithm;
        }

        public final String getContentMd5() {
            return this.contentMd5;
        }

        public final void setContentMd5(String str) {
            this.contentMd5 = str;
        }

        public final String getExpectedBucketOwner() {
            return this.expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String str) {
            this.expectedBucketOwner = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final RequestPayer getRequestPayer() {
            return this.requestPayer;
        }

        public final void setRequestPayer(RequestPayer requestPayer) {
            this.requestPayer = requestPayer;
        }

        public final ObjectLockRetention getRetention() {
            return this.retention;
        }

        public final void setRetention(ObjectLockRetention objectLockRetention) {
            this.retention = objectLockRetention;
        }

        public final String getVersionId() {
            return this.versionId;
        }

        public final void setVersionId(String str) {
            this.versionId = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(PutObjectRetentionRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.bypassGovernanceRetention = x.getBypassGovernanceRetention();
            this.checksumAlgorithm = x.getChecksumAlgorithm();
            this.contentMd5 = x.getContentMd5();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.key = x.getKey();
            this.requestPayer = x.getRequestPayer();
            this.retention = x.getRetention();
            this.versionId = x.getVersionId();
        }

        public final PutObjectRetentionRequest build() {
            return new PutObjectRetentionRequest(this, null);
        }

        public final void retention(Function1<? super ObjectLockRetention.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.retention = PutObjectRetentionRequestKt.awsSdkKotlinServicesS3ModelObjectLockRetentionDslBuilderRef.invoke(block);
        }
    }
}
