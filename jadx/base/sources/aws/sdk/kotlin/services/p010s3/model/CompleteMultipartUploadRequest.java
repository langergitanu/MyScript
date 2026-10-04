package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.CompletedMultipartUpload;
import aws.smithy.kotlin.runtime.SdkDsl;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CompleteMultipartUploadRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 @2\u00020\u0001:\u0002@AB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u00105\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u00106\u001a\u000207H\u0096\u0080\u0004J\u0014\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010;\u001a\u00020\u00002\u0019\b\u0002\u0010<\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020>0=¢\u0006\u0002\b?H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\tR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\tR\u0013\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\tR\u0013\u00101\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\tR\u0013\u00103\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006B"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "checksumCrc32", "getChecksumCrc32", "checksumCrc32C", "getChecksumCrc32C", "checksumCrc64Nvme", "getChecksumCrc64Nvme", "checksumSha1", "getChecksumSha1", "checksumSha256", "getChecksumSha256", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "expectedBucketOwner", "getExpectedBucketOwner", "ifMatch", "getIfMatch", "ifNoneMatch", "getIfNoneMatch", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "mpuObjectSize", "", "getMpuObjectSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "multipartUpload", "Laws/sdk/kotlin/services/s3/model/CompletedMultipartUpload;", "getMultipartUpload", "()Laws/sdk/kotlin/services/s3/model/CompletedMultipartUpload;", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "uploadId", "getUploadId", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CompleteMultipartUploadRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final String checksumCrc32;
    private final String checksumCrc32C;
    private final String checksumCrc64Nvme;
    private final String checksumSha1;
    private final String checksumSha256;
    private final ChecksumType checksumType;
    private final String expectedBucketOwner;
    private final String ifMatch;
    private final String ifNoneMatch;
    private final String key;
    private final Long mpuObjectSize;
    private final CompletedMultipartUpload multipartUpload;
    private final RequestPayer requestPayer;
    private final String sseCustomerAlgorithm;
    private final String sseCustomerKey;
    private final String sseCustomerKeyMd5;
    private final String uploadId;

    public /* synthetic */ CompleteMultipartUploadRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CompleteMultipartUploadRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.checksumCrc32 = builder.getChecksumCrc32();
        this.checksumCrc32C = builder.getChecksumCrc32C();
        this.checksumCrc64Nvme = builder.getChecksumCrc64Nvme();
        this.checksumSha1 = builder.getChecksumSha1();
        this.checksumSha256 = builder.getChecksumSha256();
        this.checksumType = builder.getChecksumType();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.ifMatch = builder.getIfMatch();
        this.ifNoneMatch = builder.getIfNoneMatch();
        this.key = builder.getKey();
        this.mpuObjectSize = builder.getMpuObjectSize();
        this.multipartUpload = builder.getMultipartUpload();
        this.requestPayer = builder.getRequestPayer();
        this.sseCustomerAlgorithm = builder.getSseCustomerAlgorithm();
        this.sseCustomerKey = builder.getSseCustomerKey();
        this.sseCustomerKeyMd5 = builder.getSseCustomerKeyMd5();
        this.uploadId = builder.getUploadId();
    }

    public final String getBucket() {
        return this.bucket;
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

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
    }

    public final String getIfMatch() {
        return this.ifMatch;
    }

    public final String getIfNoneMatch() {
        return this.ifNoneMatch;
    }

    public final String getKey() {
        return this.key;
    }

    public final Long getMpuObjectSize() {
        return this.mpuObjectSize;
    }

    public final CompletedMultipartUpload getMultipartUpload() {
        return this.multipartUpload;
    }

    public final RequestPayer getRequestPayer() {
        return this.requestPayer;
    }

    public final String getSseCustomerAlgorithm() {
        return this.sseCustomerAlgorithm;
    }

    public final String getSseCustomerKey() {
        return this.sseCustomerKey;
    }

    public final String getSseCustomerKeyMd5() {
        return this.sseCustomerKeyMd5;
    }

    public final String getUploadId() {
        return this.uploadId;
    }

    /* JADX INFO: compiled from: CompleteMultipartUploadRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CompleteMultipartUploadRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CompleteMultipartUploadRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc32=" + this.checksumCrc32 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc32C=" + this.checksumCrc32C + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc64Nvme=" + this.checksumCrc64Nvme + AbstractJsonLexerKt.COMMA);
        sb.append("checksumSha1=" + this.checksumSha1 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumSha256=" + this.checksumSha256 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumType=" + this.checksumType + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("ifMatch=" + this.ifMatch + AbstractJsonLexerKt.COMMA);
        sb.append("ifNoneMatch=" + this.ifNoneMatch + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("mpuObjectSize=" + this.mpuObjectSize + AbstractJsonLexerKt.COMMA);
        sb.append("multipartUpload=" + this.multipartUpload + AbstractJsonLexerKt.COMMA);
        sb.append("requestPayer=" + this.requestPayer + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerAlgorithm=" + this.sseCustomerAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerKey=*** Sensitive Data Redacted ***,");
        sb.append("sseCustomerKeyMd5=" + this.sseCustomerKeyMd5 + AbstractJsonLexerKt.COMMA);
        sb.append("uploadId=" + this.uploadId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.checksumCrc32;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.checksumCrc32C;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.checksumCrc64Nvme;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.checksumSha1;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.checksumSha256;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ChecksumType checksumType = this.checksumType;
        int iHashCode7 = (iHashCode6 + (checksumType != null ? checksumType.hashCode() : 0)) * 31;
        String str7 = this.expectedBucketOwner;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.ifMatch;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.ifNoneMatch;
        int iHashCode10 = (iHashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.key;
        int iHashCode11 = (iHashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        Long l = this.mpuObjectSize;
        int iHashCode12 = (iHashCode11 + (l != null ? Long.hashCode(l.longValue()) : 0)) * 31;
        CompletedMultipartUpload completedMultipartUpload = this.multipartUpload;
        int iHashCode13 = (iHashCode12 + (completedMultipartUpload != null ? completedMultipartUpload.hashCode() : 0)) * 31;
        RequestPayer requestPayer = this.requestPayer;
        int iHashCode14 = (iHashCode13 + (requestPayer != null ? requestPayer.hashCode() : 0)) * 31;
        String str11 = this.sseCustomerAlgorithm;
        int iHashCode15 = (iHashCode14 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.sseCustomerKey;
        int iHashCode16 = (iHashCode15 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.sseCustomerKeyMd5;
        int iHashCode17 = (iHashCode16 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.uploadId;
        return iHashCode17 + (str14 != null ? str14.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CompleteMultipartUploadRequest completeMultipartUploadRequest = (CompleteMultipartUploadRequest) other;
        return Intrinsics.areEqual(this.bucket, completeMultipartUploadRequest.bucket) && Intrinsics.areEqual(this.checksumCrc32, completeMultipartUploadRequest.checksumCrc32) && Intrinsics.areEqual(this.checksumCrc32C, completeMultipartUploadRequest.checksumCrc32C) && Intrinsics.areEqual(this.checksumCrc64Nvme, completeMultipartUploadRequest.checksumCrc64Nvme) && Intrinsics.areEqual(this.checksumSha1, completeMultipartUploadRequest.checksumSha1) && Intrinsics.areEqual(this.checksumSha256, completeMultipartUploadRequest.checksumSha256) && Intrinsics.areEqual(this.checksumType, completeMultipartUploadRequest.checksumType) && Intrinsics.areEqual(this.expectedBucketOwner, completeMultipartUploadRequest.expectedBucketOwner) && Intrinsics.areEqual(this.ifMatch, completeMultipartUploadRequest.ifMatch) && Intrinsics.areEqual(this.ifNoneMatch, completeMultipartUploadRequest.ifNoneMatch) && Intrinsics.areEqual(this.key, completeMultipartUploadRequest.key) && Intrinsics.areEqual(this.mpuObjectSize, completeMultipartUploadRequest.mpuObjectSize) && Intrinsics.areEqual(this.multipartUpload, completeMultipartUploadRequest.multipartUpload) && Intrinsics.areEqual(this.requestPayer, completeMultipartUploadRequest.requestPayer) && Intrinsics.areEqual(this.sseCustomerAlgorithm, completeMultipartUploadRequest.sseCustomerAlgorithm) && Intrinsics.areEqual(this.sseCustomerKey, completeMultipartUploadRequest.sseCustomerKey) && Intrinsics.areEqual(this.sseCustomerKeyMd5, completeMultipartUploadRequest.sseCustomerKeyMd5) && Intrinsics.areEqual(this.uploadId, completeMultipartUploadRequest.uploadId);
    }

    public static /* synthetic */ CompleteMultipartUploadRequest copy$default(CompleteMultipartUploadRequest completeMultipartUploadRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.CompleteMultipartUploadRequest.copy.1
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
        Builder builder = new Builder(completeMultipartUploadRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final CompleteMultipartUploadRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CompleteMultipartUploadRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010M\u001a\u00020\u0005H\u0001J\u001f\u00105\u001a\u00020N2\u0017\u0010O\u001a\u0013\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020N0P¢\u0006\u0002\bRJ\r\u0010S\u001a\u00020\u0000H\u0000¢\u0006\u0002\bTR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001c\u0010%\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001c\u0010(\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR\u001c\u0010+\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR\u001e\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\n\"\u0004\bC\u0010\fR\u001c\u0010D\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\n\"\u0004\bF\u0010\fR\u001c\u0010G\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\n\"\u0004\bI\u0010\fR\u001c\u0010J\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\n\"\u0004\bL\u0010\f¨\u0006U"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest;", "(Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "checksumCrc32", "getChecksumCrc32", "setChecksumCrc32", "checksumCrc32C", "getChecksumCrc32C", "setChecksumCrc32C", "checksumCrc64Nvme", "getChecksumCrc64Nvme", "setChecksumCrc64Nvme", "checksumSha1", "getChecksumSha1", "setChecksumSha1", "checksumSha256", "getChecksumSha256", "setChecksumSha256", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "setChecksumType", "(Laws/sdk/kotlin/services/s3/model/ChecksumType;)V", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "ifMatch", "getIfMatch", "setIfMatch", "ifNoneMatch", "getIfNoneMatch", "setIfNoneMatch", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", "mpuObjectSize", "", "getMpuObjectSize", "()Ljava/lang/Long;", "setMpuObjectSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "multipartUpload", "Laws/sdk/kotlin/services/s3/model/CompletedMultipartUpload;", "getMultipartUpload", "()Laws/sdk/kotlin/services/s3/model/CompletedMultipartUpload;", "setMultipartUpload", "(Laws/sdk/kotlin/services/s3/model/CompletedMultipartUpload;)V", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "setRequestPayer", "(Laws/sdk/kotlin/services/s3/model/RequestPayer;)V", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "setSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "setSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "setSseCustomerKeyMd5", "uploadId", "getUploadId", "setUploadId", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CompletedMultipartUpload$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private String checksumCrc32;
        private String checksumCrc32C;
        private String checksumCrc64Nvme;
        private String checksumSha1;
        private String checksumSha256;
        private ChecksumType checksumType;
        private String expectedBucketOwner;
        private String ifMatch;
        private String ifNoneMatch;
        private String key;
        private Long mpuObjectSize;
        private CompletedMultipartUpload multipartUpload;
        private RequestPayer requestPayer;
        private String sseCustomerAlgorithm;
        private String sseCustomerKey;
        private String sseCustomerKeyMd5;
        private String uploadId;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
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

        public final String getIfNoneMatch() {
            return this.ifNoneMatch;
        }

        public final void setIfNoneMatch(String str) {
            this.ifNoneMatch = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final Long getMpuObjectSize() {
            return this.mpuObjectSize;
        }

        public final void setMpuObjectSize(Long l) {
            this.mpuObjectSize = l;
        }

        public final CompletedMultipartUpload getMultipartUpload() {
            return this.multipartUpload;
        }

        public final void setMultipartUpload(CompletedMultipartUpload completedMultipartUpload) {
            this.multipartUpload = completedMultipartUpload;
        }

        public final RequestPayer getRequestPayer() {
            return this.requestPayer;
        }

        public final void setRequestPayer(RequestPayer requestPayer) {
            this.requestPayer = requestPayer;
        }

        public final String getSseCustomerAlgorithm() {
            return this.sseCustomerAlgorithm;
        }

        public final void setSseCustomerAlgorithm(String str) {
            this.sseCustomerAlgorithm = str;
        }

        public final String getSseCustomerKey() {
            return this.sseCustomerKey;
        }

        public final void setSseCustomerKey(String str) {
            this.sseCustomerKey = str;
        }

        public final String getSseCustomerKeyMd5() {
            return this.sseCustomerKeyMd5;
        }

        public final void setSseCustomerKeyMd5(String str) {
            this.sseCustomerKeyMd5 = str;
        }

        public final String getUploadId() {
            return this.uploadId;
        }

        public final void setUploadId(String str) {
            this.uploadId = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CompleteMultipartUploadRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.checksumCrc32 = x.getChecksumCrc32();
            this.checksumCrc32C = x.getChecksumCrc32C();
            this.checksumCrc64Nvme = x.getChecksumCrc64Nvme();
            this.checksumSha1 = x.getChecksumSha1();
            this.checksumSha256 = x.getChecksumSha256();
            this.checksumType = x.getChecksumType();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.ifMatch = x.getIfMatch();
            this.ifNoneMatch = x.getIfNoneMatch();
            this.key = x.getKey();
            this.mpuObjectSize = x.getMpuObjectSize();
            this.multipartUpload = x.getMultipartUpload();
            this.requestPayer = x.getRequestPayer();
            this.sseCustomerAlgorithm = x.getSseCustomerAlgorithm();
            this.sseCustomerKey = x.getSseCustomerKey();
            this.sseCustomerKeyMd5 = x.getSseCustomerKeyMd5();
            this.uploadId = x.getUploadId();
        }

        public final CompleteMultipartUploadRequest build() {
            return new CompleteMultipartUploadRequest(this, null);
        }

        public final void multipartUpload(Function1<? super CompletedMultipartUpload.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.multipartUpload = CompleteMultipartUploadRequestKt.awsSdkKotlinServicesS3ModelCompletedMultipartUploadDslBuilderRef.invoke(block);
        }
    }
}
