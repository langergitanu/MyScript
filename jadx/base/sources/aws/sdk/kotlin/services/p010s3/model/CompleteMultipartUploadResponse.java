package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CompleteMultipartUploadResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u00101\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u00102\u001a\u000203H\u0096\u0080\u0004J\u0014\u00104\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u00106\u001a\u00020\u00002\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020908¢\u0006\u0002\b:H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\tR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\tR\u0013\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\tR\u0013\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\tR\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\tR\u0013\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006="}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "checksumCrc32", "getChecksumCrc32", "checksumCrc32C", "getChecksumCrc32C", "checksumCrc64Nvme", "getChecksumCrc64Nvme", "checksumSha1", "getChecksumSha1", "checksumSha256", "getChecksumSha256", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "eTag", "getETag", "expiration", "getExpiration", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", FirebaseAnalytics.Param.LOCATION, "getLocation", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "ssekmsKeyId", "getSsekmsKeyId", "versionId", "getVersionId", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CompleteMultipartUploadResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final Boolean bucketKeyEnabled;
    private final String checksumCrc32;
    private final String checksumCrc32C;
    private final String checksumCrc64Nvme;
    private final String checksumSha1;
    private final String checksumSha256;
    private final ChecksumType checksumType;
    private final String eTag;
    private final String expiration;
    private final String key;
    private final String location;
    private final RequestCharged requestCharged;
    private final ServerSideEncryption serverSideEncryption;
    private final String ssekmsKeyId;
    private final String versionId;

    public /* synthetic */ CompleteMultipartUploadResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CompleteMultipartUploadResponse(Builder builder) {
        this.bucket = builder.getBucket();
        this.bucketKeyEnabled = builder.getBucketKeyEnabled();
        this.checksumCrc32 = builder.getChecksumCrc32();
        this.checksumCrc32C = builder.getChecksumCrc32C();
        this.checksumCrc64Nvme = builder.getChecksumCrc64Nvme();
        this.checksumSha1 = builder.getChecksumSha1();
        this.checksumSha256 = builder.getChecksumSha256();
        this.checksumType = builder.getChecksumType();
        this.eTag = builder.getETag();
        this.expiration = builder.getExpiration();
        this.key = builder.getKey();
        this.location = builder.getLocation();
        this.requestCharged = builder.getRequestCharged();
        this.serverSideEncryption = builder.getServerSideEncryption();
        this.ssekmsKeyId = builder.getSsekmsKeyId();
        this.versionId = builder.getVersionId();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final Boolean getBucketKeyEnabled() {
        return this.bucketKeyEnabled;
    }

    public final String getChecksumCrc32() {
        return this.checksumCrc32;
    }

    public final String getChecksumCrc32C() {
        return this.checksumCrc32C;
    }

    public final String getChecksumCrc64Nvme() {
        return this.checksumCrc64Nvme;
    }

    public final String getChecksumSha1() {
        return this.checksumSha1;
    }

    public final String getChecksumSha256() {
        return this.checksumSha256;
    }

    public final ChecksumType getChecksumType() {
        return this.checksumType;
    }

    public final String getETag() {
        return this.eTag;
    }

    public final String getExpiration() {
        return this.expiration;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLocation() {
        return this.location;
    }

    public final RequestCharged getRequestCharged() {
        return this.requestCharged;
    }

    public final ServerSideEncryption getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public final String getSsekmsKeyId() {
        return this.ssekmsKeyId;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    /* JADX INFO: compiled from: CompleteMultipartUploadResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CompleteMultipartUploadResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CompleteMultipartUploadResponse(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("bucketKeyEnabled=" + this.bucketKeyEnabled + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc32=" + this.checksumCrc32 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc32C=" + this.checksumCrc32C + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc64Nvme=" + this.checksumCrc64Nvme + AbstractJsonLexerKt.COMMA);
        sb.append("checksumSha1=" + this.checksumSha1 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumSha256=" + this.checksumSha256 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumType=" + this.checksumType + AbstractJsonLexerKt.COMMA);
        sb.append("eTag=" + this.eTag + AbstractJsonLexerKt.COMMA);
        sb.append("expiration=" + this.expiration + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("location=" + this.location + AbstractJsonLexerKt.COMMA);
        sb.append("requestCharged=" + this.requestCharged + AbstractJsonLexerKt.COMMA);
        sb.append("serverSideEncryption=" + this.serverSideEncryption + AbstractJsonLexerKt.COMMA);
        sb.append("ssekmsKeyId=*** Sensitive Data Redacted ***,");
        sb.append("versionId=" + this.versionId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.bucketKeyEnabled;
        int iHashCode2 = (iHashCode + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        String str2 = this.checksumCrc32;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.checksumCrc32C;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.checksumCrc64Nvme;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.checksumSha1;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.checksumSha256;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ChecksumType checksumType = this.checksumType;
        int iHashCode8 = (iHashCode7 + (checksumType != null ? checksumType.hashCode() : 0)) * 31;
        String str7 = this.eTag;
        int iHashCode9 = (iHashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.expiration;
        int iHashCode10 = (iHashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.key;
        int iHashCode11 = (iHashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.location;
        int iHashCode12 = (iHashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        RequestCharged requestCharged = this.requestCharged;
        int iHashCode13 = (iHashCode12 + (requestCharged != null ? requestCharged.hashCode() : 0)) * 31;
        ServerSideEncryption serverSideEncryption = this.serverSideEncryption;
        int iHashCode14 = (iHashCode13 + (serverSideEncryption != null ? serverSideEncryption.hashCode() : 0)) * 31;
        String str11 = this.ssekmsKeyId;
        int iHashCode15 = (iHashCode14 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.versionId;
        return iHashCode15 + (str12 != null ? str12.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CompleteMultipartUploadResponse completeMultipartUploadResponse = (CompleteMultipartUploadResponse) other;
        return Intrinsics.areEqual(this.bucket, completeMultipartUploadResponse.bucket) && Intrinsics.areEqual(this.bucketKeyEnabled, completeMultipartUploadResponse.bucketKeyEnabled) && Intrinsics.areEqual(this.checksumCrc32, completeMultipartUploadResponse.checksumCrc32) && Intrinsics.areEqual(this.checksumCrc32C, completeMultipartUploadResponse.checksumCrc32C) && Intrinsics.areEqual(this.checksumCrc64Nvme, completeMultipartUploadResponse.checksumCrc64Nvme) && Intrinsics.areEqual(this.checksumSha1, completeMultipartUploadResponse.checksumSha1) && Intrinsics.areEqual(this.checksumSha256, completeMultipartUploadResponse.checksumSha256) && Intrinsics.areEqual(this.checksumType, completeMultipartUploadResponse.checksumType) && Intrinsics.areEqual(this.eTag, completeMultipartUploadResponse.eTag) && Intrinsics.areEqual(this.expiration, completeMultipartUploadResponse.expiration) && Intrinsics.areEqual(this.key, completeMultipartUploadResponse.key) && Intrinsics.areEqual(this.location, completeMultipartUploadResponse.location) && Intrinsics.areEqual(this.requestCharged, completeMultipartUploadResponse.requestCharged) && Intrinsics.areEqual(this.serverSideEncryption, completeMultipartUploadResponse.serverSideEncryption) && Intrinsics.areEqual(this.ssekmsKeyId, completeMultipartUploadResponse.ssekmsKeyId) && Intrinsics.areEqual(this.versionId, completeMultipartUploadResponse.versionId);
    }

    public static /* synthetic */ CompleteMultipartUploadResponse copy$default(CompleteMultipartUploadResponse completeMultipartUploadResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.CompleteMultipartUploadResponse.copy.1
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
        Builder builder = new Builder(completeMultipartUploadResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final CompleteMultipartUploadResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CompleteMultipartUploadResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010G\u001a\u00020\u0005H\u0001J\r\u0010H\u001a\u00020\u0000H\u0000¢\u0006\u0002\bIR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR\u001c\u0010 \u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010\fR\u001c\u0010,\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\fR\u001c\u0010/\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\n\"\u0004\b1\u0010\fR\u001c\u00102\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\n\"\u0004\b4\u0010\fR\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\n\"\u0004\bC\u0010\fR\u001c\u0010D\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\n\"\u0004\bF\u0010\f¨\u0006J"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse;", "(Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "setBucketKeyEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "checksumCrc32", "getChecksumCrc32", "setChecksumCrc32", "checksumCrc32C", "getChecksumCrc32C", "setChecksumCrc32C", "checksumCrc64Nvme", "getChecksumCrc64Nvme", "setChecksumCrc64Nvme", "checksumSha1", "getChecksumSha1", "setChecksumSha1", "checksumSha256", "getChecksumSha256", "setChecksumSha256", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "setChecksumType", "(Laws/sdk/kotlin/services/s3/model/ChecksumType;)V", "eTag", "getETag", "setETag", "expiration", "getExpiration", "setExpiration", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", FirebaseAnalytics.Param.LOCATION, "getLocation", "setLocation", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "setRequestCharged", "(Laws/sdk/kotlin/services/s3/model/RequestCharged;)V", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "setServerSideEncryption", "(Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;)V", "ssekmsKeyId", "getSsekmsKeyId", "setSsekmsKeyId", "versionId", "getVersionId", "setVersionId", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private Boolean bucketKeyEnabled;
        private String checksumCrc32;
        private String checksumCrc32C;
        private String checksumCrc64Nvme;
        private String checksumSha1;
        private String checksumSha256;
        private ChecksumType checksumType;
        private String eTag;
        private String expiration;
        private String key;
        private String location;
        private RequestCharged requestCharged;
        private ServerSideEncryption serverSideEncryption;
        private String ssekmsKeyId;
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

        public final Boolean getBucketKeyEnabled() {
            return this.bucketKeyEnabled;
        }

        public final void setBucketKeyEnabled(Boolean bool) {
            this.bucketKeyEnabled = bool;
        }

        public final String getChecksumCrc32() {
            return this.checksumCrc32;
        }

        public final void setChecksumCrc32(String str) {
            this.checksumCrc32 = str;
        }

        public final String getChecksumCrc32C() {
            return this.checksumCrc32C;
        }

        public final void setChecksumCrc32C(String str) {
            this.checksumCrc32C = str;
        }

        public final String getChecksumCrc64Nvme() {
            return this.checksumCrc64Nvme;
        }

        public final void setChecksumCrc64Nvme(String str) {
            this.checksumCrc64Nvme = str;
        }

        public final String getChecksumSha1() {
            return this.checksumSha1;
        }

        public final void setChecksumSha1(String str) {
            this.checksumSha1 = str;
        }

        public final String getChecksumSha256() {
            return this.checksumSha256;
        }

        public final void setChecksumSha256(String str) {
            this.checksumSha256 = str;
        }

        public final ChecksumType getChecksumType() {
            return this.checksumType;
        }

        public final void setChecksumType(ChecksumType checksumType) {
            this.checksumType = checksumType;
        }

        public final String getETag() {
            return this.eTag;
        }

        public final void setETag(String str) {
            this.eTag = str;
        }

        public final String getExpiration() {
            return this.expiration;
        }

        public final void setExpiration(String str) {
            this.expiration = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final String getLocation() {
            return this.location;
        }

        public final void setLocation(String str) {
            this.location = str;
        }

        public final RequestCharged getRequestCharged() {
            return this.requestCharged;
        }

        public final void setRequestCharged(RequestCharged requestCharged) {
            this.requestCharged = requestCharged;
        }

        public final ServerSideEncryption getServerSideEncryption() {
            return this.serverSideEncryption;
        }

        public final void setServerSideEncryption(ServerSideEncryption serverSideEncryption) {
            this.serverSideEncryption = serverSideEncryption;
        }

        public final String getSsekmsKeyId() {
            return this.ssekmsKeyId;
        }

        public final void setSsekmsKeyId(String str) {
            this.ssekmsKeyId = str;
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
        public Builder(CompleteMultipartUploadResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.bucketKeyEnabled = x.getBucketKeyEnabled();
            this.checksumCrc32 = x.getChecksumCrc32();
            this.checksumCrc32C = x.getChecksumCrc32C();
            this.checksumCrc64Nvme = x.getChecksumCrc64Nvme();
            this.checksumSha1 = x.getChecksumSha1();
            this.checksumSha256 = x.getChecksumSha256();
            this.checksumType = x.getChecksumType();
            this.eTag = x.getETag();
            this.expiration = x.getExpiration();
            this.key = x.getKey();
            this.location = x.getLocation();
            this.requestCharged = x.getRequestCharged();
            this.serverSideEncryption = x.getServerSideEncryption();
            this.ssekmsKeyId = x.getSsekmsKeyId();
            this.versionId = x.getVersionId();
        }

        public final CompleteMultipartUploadResponse build() {
            return new CompleteMultipartUploadResponse(this, null);
        }
    }
}
