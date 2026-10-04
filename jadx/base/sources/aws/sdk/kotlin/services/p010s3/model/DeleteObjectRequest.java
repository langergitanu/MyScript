package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.time.Instant;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: DeleteObjectRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 02\u00020\u0001:\u000201B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010&\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010'\u001a\u00020(H\u0096\u0080\u0004J\u0014\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010+\u001a\u00020\u00002\u0019\b\u0002\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020.0-¢\u0006\u0002\b/H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\tR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00062"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "bypassGovernanceRetention", "", "getBypassGovernanceRetention", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "expectedBucketOwner", "getExpectedBucketOwner", "ifMatch", "getIfMatch", "ifMatchLastModifiedTime", "Laws/smithy/kotlin/runtime/time/Instant;", "getIfMatchLastModifiedTime", "()Laws/smithy/kotlin/runtime/time/Instant;", "ifMatchSize", "", "getIfMatchSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "mfa", "getMfa", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "versionId", "getVersionId", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DeleteObjectRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final Boolean bypassGovernanceRetention;
    private final String expectedBucketOwner;
    private final String ifMatch;
    private final Instant ifMatchLastModifiedTime;
    private final Long ifMatchSize;
    private final String key;
    private final String mfa;
    private final RequestPayer requestPayer;
    private final String versionId;

    public /* synthetic */ DeleteObjectRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private DeleteObjectRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.bypassGovernanceRetention = builder.getBypassGovernanceRetention();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.ifMatch = builder.getIfMatch();
        this.ifMatchLastModifiedTime = builder.getIfMatchLastModifiedTime();
        this.ifMatchSize = builder.getIfMatchSize();
        this.key = builder.getKey();
        this.mfa = builder.getMfa();
        this.requestPayer = builder.getRequestPayer();
        this.versionId = builder.getVersionId();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final Boolean getBypassGovernanceRetention() {
        return this.bypassGovernanceRetention;
    }

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
    }

    public final String getIfMatch() {
        return this.ifMatch;
    }

    public final Instant getIfMatchLastModifiedTime() {
        return this.ifMatchLastModifiedTime;
    }

    public final Long getIfMatchSize() {
        return this.ifMatchSize;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMfa() {
        return this.mfa;
    }

    public final RequestPayer getRequestPayer() {
        return this.requestPayer;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    /* JADX INFO: compiled from: DeleteObjectRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeleteObjectRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteObjectRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("bypassGovernanceRetention=" + this.bypassGovernanceRetention + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("ifMatch=" + this.ifMatch + AbstractJsonLexerKt.COMMA);
        sb.append("ifMatchLastModifiedTime=" + this.ifMatchLastModifiedTime + AbstractJsonLexerKt.COMMA);
        sb.append("ifMatchSize=" + this.ifMatchSize + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("mfa=" + this.mfa + AbstractJsonLexerKt.COMMA);
        sb.append("requestPayer=" + this.requestPayer + AbstractJsonLexerKt.COMMA);
        sb.append("versionId=" + this.versionId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.bypassGovernanceRetention;
        int iHashCode2 = (iHashCode + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        String str2 = this.expectedBucketOwner;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ifMatch;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Instant instant = this.ifMatchLastModifiedTime;
        int iHashCode5 = (iHashCode4 + (instant != null ? instant.hashCode() : 0)) * 31;
        Long l = this.ifMatchSize;
        int iHashCode6 = (iHashCode5 + (l != null ? Long.hashCode(l.longValue()) : 0)) * 31;
        String str4 = this.key;
        int iHashCode7 = (iHashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mfa;
        int iHashCode8 = (iHashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        RequestPayer requestPayer = this.requestPayer;
        int iHashCode9 = (iHashCode8 + (requestPayer != null ? requestPayer.hashCode() : 0)) * 31;
        String str6 = this.versionId;
        return iHashCode9 + (str6 != null ? str6.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DeleteObjectRequest deleteObjectRequest = (DeleteObjectRequest) other;
        return Intrinsics.areEqual(this.bucket, deleteObjectRequest.bucket) && Intrinsics.areEqual(this.bypassGovernanceRetention, deleteObjectRequest.bypassGovernanceRetention) && Intrinsics.areEqual(this.expectedBucketOwner, deleteObjectRequest.expectedBucketOwner) && Intrinsics.areEqual(this.ifMatch, deleteObjectRequest.ifMatch) && Intrinsics.areEqual(this.ifMatchLastModifiedTime, deleteObjectRequest.ifMatchLastModifiedTime) && Intrinsics.areEqual(this.ifMatchSize, deleteObjectRequest.ifMatchSize) && Intrinsics.areEqual(this.key, deleteObjectRequest.key) && Intrinsics.areEqual(this.mfa, deleteObjectRequest.mfa) && Intrinsics.areEqual(this.requestPayer, deleteObjectRequest.requestPayer) && Intrinsics.areEqual(this.versionId, deleteObjectRequest.versionId);
    }

    public static /* synthetic */ DeleteObjectRequest copy$default(DeleteObjectRequest deleteObjectRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.DeleteObjectRequest.copy.1
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
        Builder builder = new Builder(deleteObjectRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final DeleteObjectRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: DeleteObjectRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u00106\u001a\u00020\u0005H\u0001J\r\u00107\u001a\u00020\u0000H\u0000¢\u0006\u0002\b8R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010'\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\n\"\u0004\b)\u0010\fR\u001c\u0010*\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\n\"\u0004\b,\u0010\fR\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\n\"\u0004\b5\u0010\f¨\u00069"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "bypassGovernanceRetention", "", "getBypassGovernanceRetention", "()Ljava/lang/Boolean;", "setBypassGovernanceRetention", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "ifMatch", "getIfMatch", "setIfMatch", "ifMatchLastModifiedTime", "Laws/smithy/kotlin/runtime/time/Instant;", "getIfMatchLastModifiedTime", "()Laws/smithy/kotlin/runtime/time/Instant;", "setIfMatchLastModifiedTime", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "ifMatchSize", "", "getIfMatchSize", "()Ljava/lang/Long;", "setIfMatchSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", "mfa", "getMfa", "setMfa", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "setRequestPayer", "(Laws/sdk/kotlin/services/s3/model/RequestPayer;)V", "versionId", "getVersionId", "setVersionId", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private Boolean bypassGovernanceRetention;
        private String expectedBucketOwner;
        private String ifMatch;
        private Instant ifMatchLastModifiedTime;
        private Long ifMatchSize;
        private String key;
        private String mfa;
        private RequestPayer requestPayer;
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

        public final String getExpectedBucketOwner() {
            return this.expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String str) {
            this.expectedBucketOwner = str;
        }

        public final String getIfMatch() {
            return this.ifMatch;
        }

        public final void setIfMatch(String str) {
            this.ifMatch = str;
        }

        public final Instant getIfMatchLastModifiedTime() {
            return this.ifMatchLastModifiedTime;
        }

        public final void setIfMatchLastModifiedTime(Instant instant) {
            this.ifMatchLastModifiedTime = instant;
        }

        public final Long getIfMatchSize() {
            return this.ifMatchSize;
        }

        public final void setIfMatchSize(Long l) {
            this.ifMatchSize = l;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final String getMfa() {
            return this.mfa;
        }

        public final void setMfa(String str) {
            this.mfa = str;
        }

        public final RequestPayer getRequestPayer() {
            return this.requestPayer;
        }

        public final void setRequestPayer(RequestPayer requestPayer) {
            this.requestPayer = requestPayer;
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
        public Builder(DeleteObjectRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.bypassGovernanceRetention = x.getBypassGovernanceRetention();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.ifMatch = x.getIfMatch();
            this.ifMatchLastModifiedTime = x.getIfMatchLastModifiedTime();
            this.ifMatchSize = x.getIfMatchSize();
            this.key = x.getKey();
            this.mfa = x.getMfa();
            this.requestPayer = x.getRequestPayer();
            this.versionId = x.getVersionId();
        }

        public final DeleteObjectRequest build() {
            return new DeleteObjectRequest(this, null);
        }
    }
}
