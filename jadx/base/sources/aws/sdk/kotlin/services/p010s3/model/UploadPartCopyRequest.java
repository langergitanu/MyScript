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

/* JADX INFO: compiled from: UploadPartCopyRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u00105\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u00106\u001a\u00020%H\u0096\u0080\u0004J\u0014\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010:\u001a\u00020\u00002\u0019\b\u0002\u0010;\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020=0<¢\u0006\u0002\b>H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\tR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u0013\u0010 \u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\tR\u0015\u0010$\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\tR\u0013\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\tR\u0013\u00101\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\tR\u0013\u00103\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006A"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "copySource", "getCopySource", "copySourceIfMatch", "getCopySourceIfMatch", "copySourceIfModifiedSince", "Laws/smithy/kotlin/runtime/time/Instant;", "getCopySourceIfModifiedSince", "()Laws/smithy/kotlin/runtime/time/Instant;", "copySourceIfNoneMatch", "getCopySourceIfNoneMatch", "copySourceIfUnmodifiedSince", "getCopySourceIfUnmodifiedSince", "copySourceRange", "getCopySourceRange", "copySourceSseCustomerAlgorithm", "getCopySourceSseCustomerAlgorithm", "copySourceSseCustomerKey", "getCopySourceSseCustomerKey", "copySourceSseCustomerKeyMd5", "getCopySourceSseCustomerKeyMd5", "expectedBucketOwner", "getExpectedBucketOwner", "expectedSourceBucketOwner", "getExpectedSourceBucketOwner", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "partNumber", "", "getPartNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "uploadId", "getUploadId", "toString", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UploadPartCopyRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final String copySource;
    private final String copySourceIfMatch;
    private final Instant copySourceIfModifiedSince;
    private final String copySourceIfNoneMatch;
    private final Instant copySourceIfUnmodifiedSince;
    private final String copySourceRange;
    private final String copySourceSseCustomerAlgorithm;
    private final String copySourceSseCustomerKey;
    private final String copySourceSseCustomerKeyMd5;
    private final String expectedBucketOwner;
    private final String expectedSourceBucketOwner;
    private final String key;
    private final Integer partNumber;
    private final RequestPayer requestPayer;
    private final String sseCustomerAlgorithm;
    private final String sseCustomerKey;
    private final String sseCustomerKeyMd5;
    private final String uploadId;

    public /* synthetic */ UploadPartCopyRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private UploadPartCopyRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.copySource = builder.getCopySource();
        this.copySourceIfMatch = builder.getCopySourceIfMatch();
        this.copySourceIfModifiedSince = builder.getCopySourceIfModifiedSince();
        this.copySourceIfNoneMatch = builder.getCopySourceIfNoneMatch();
        this.copySourceIfUnmodifiedSince = builder.getCopySourceIfUnmodifiedSince();
        this.copySourceRange = builder.getCopySourceRange();
        this.copySourceSseCustomerAlgorithm = builder.getCopySourceSseCustomerAlgorithm();
        this.copySourceSseCustomerKey = builder.getCopySourceSseCustomerKey();
        this.copySourceSseCustomerKeyMd5 = builder.getCopySourceSseCustomerKeyMd5();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.expectedSourceBucketOwner = builder.getExpectedSourceBucketOwner();
        this.key = builder.getKey();
        this.partNumber = builder.getPartNumber();
        this.requestPayer = builder.getRequestPayer();
        this.sseCustomerAlgorithm = builder.getSseCustomerAlgorithm();
        this.sseCustomerKey = builder.getSseCustomerKey();
        this.sseCustomerKeyMd5 = builder.getSseCustomerKeyMd5();
        this.uploadId = builder.getUploadId();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getCopySource() {
        return this.copySource;
    }

    public final String getCopySourceIfMatch() {
        return this.copySourceIfMatch;
    }

    public final Instant getCopySourceIfModifiedSince() {
        return this.copySourceIfModifiedSince;
    }

    public final String getCopySourceIfNoneMatch() {
        return this.copySourceIfNoneMatch;
    }

    public final Instant getCopySourceIfUnmodifiedSince() {
        return this.copySourceIfUnmodifiedSince;
    }

    public final String getCopySourceRange() {
        return this.copySourceRange;
    }

    public final String getCopySourceSseCustomerAlgorithm() {
        return this.copySourceSseCustomerAlgorithm;
    }

    public final String getCopySourceSseCustomerKey() {
        return this.copySourceSseCustomerKey;
    }

    public final String getCopySourceSseCustomerKeyMd5() {
        return this.copySourceSseCustomerKeyMd5;
    }

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
    }

    public final String getExpectedSourceBucketOwner() {
        return this.expectedSourceBucketOwner;
    }

    public final String getKey() {
        return this.key;
    }

    public final Integer getPartNumber() {
        return this.partNumber;
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

    /* JADX INFO: compiled from: UploadPartCopyRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UploadPartCopyRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadPartCopyRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("copySource=" + this.copySource + AbstractJsonLexerKt.COMMA);
        sb.append("copySourceIfMatch=" + this.copySourceIfMatch + AbstractJsonLexerKt.COMMA);
        sb.append("copySourceIfModifiedSince=" + this.copySourceIfModifiedSince + AbstractJsonLexerKt.COMMA);
        sb.append("copySourceIfNoneMatch=" + this.copySourceIfNoneMatch + AbstractJsonLexerKt.COMMA);
        sb.append("copySourceIfUnmodifiedSince=" + this.copySourceIfUnmodifiedSince + AbstractJsonLexerKt.COMMA);
        sb.append("copySourceRange=" + this.copySourceRange + AbstractJsonLexerKt.COMMA);
        sb.append("copySourceSseCustomerAlgorithm=" + this.copySourceSseCustomerAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("copySourceSseCustomerKey=*** Sensitive Data Redacted ***,");
        sb.append("copySourceSseCustomerKeyMd5=" + this.copySourceSseCustomerKeyMd5 + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("expectedSourceBucketOwner=" + this.expectedSourceBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("partNumber=" + this.partNumber + AbstractJsonLexerKt.COMMA);
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
        String str2 = this.copySource;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.copySourceIfMatch;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Instant instant = this.copySourceIfModifiedSince;
        int iHashCode4 = (iHashCode3 + (instant != null ? instant.hashCode() : 0)) * 31;
        String str4 = this.copySourceIfNoneMatch;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Instant instant2 = this.copySourceIfUnmodifiedSince;
        int iHashCode6 = (iHashCode5 + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        String str5 = this.copySourceRange;
        int iHashCode7 = (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.copySourceSseCustomerAlgorithm;
        int iHashCode8 = (iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.copySourceSseCustomerKey;
        int iHashCode9 = (iHashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.copySourceSseCustomerKeyMd5;
        int iHashCode10 = (iHashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.expectedBucketOwner;
        int iHashCode11 = (iHashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.expectedSourceBucketOwner;
        int iHashCode12 = (iHashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.key;
        int iHashCode13 = (iHashCode12 + (str11 != null ? str11.hashCode() : 0)) * 31;
        Integer num = this.partNumber;
        int iIntValue = (iHashCode13 + (num != null ? num.intValue() : 0)) * 31;
        RequestPayer requestPayer = this.requestPayer;
        int iHashCode14 = (iIntValue + (requestPayer != null ? requestPayer.hashCode() : 0)) * 31;
        String str12 = this.sseCustomerAlgorithm;
        int iHashCode15 = (iHashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.sseCustomerKey;
        int iHashCode16 = (iHashCode15 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.sseCustomerKeyMd5;
        int iHashCode17 = (iHashCode16 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.uploadId;
        return iHashCode17 + (str15 != null ? str15.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        UploadPartCopyRequest uploadPartCopyRequest = (UploadPartCopyRequest) other;
        return Intrinsics.areEqual(this.bucket, uploadPartCopyRequest.bucket) && Intrinsics.areEqual(this.copySource, uploadPartCopyRequest.copySource) && Intrinsics.areEqual(this.copySourceIfMatch, uploadPartCopyRequest.copySourceIfMatch) && Intrinsics.areEqual(this.copySourceIfModifiedSince, uploadPartCopyRequest.copySourceIfModifiedSince) && Intrinsics.areEqual(this.copySourceIfNoneMatch, uploadPartCopyRequest.copySourceIfNoneMatch) && Intrinsics.areEqual(this.copySourceIfUnmodifiedSince, uploadPartCopyRequest.copySourceIfUnmodifiedSince) && Intrinsics.areEqual(this.copySourceRange, uploadPartCopyRequest.copySourceRange) && Intrinsics.areEqual(this.copySourceSseCustomerAlgorithm, uploadPartCopyRequest.copySourceSseCustomerAlgorithm) && Intrinsics.areEqual(this.copySourceSseCustomerKey, uploadPartCopyRequest.copySourceSseCustomerKey) && Intrinsics.areEqual(this.copySourceSseCustomerKeyMd5, uploadPartCopyRequest.copySourceSseCustomerKeyMd5) && Intrinsics.areEqual(this.expectedBucketOwner, uploadPartCopyRequest.expectedBucketOwner) && Intrinsics.areEqual(this.expectedSourceBucketOwner, uploadPartCopyRequest.expectedSourceBucketOwner) && Intrinsics.areEqual(this.key, uploadPartCopyRequest.key) && Intrinsics.areEqual(this.partNumber, uploadPartCopyRequest.partNumber) && Intrinsics.areEqual(this.requestPayer, uploadPartCopyRequest.requestPayer) && Intrinsics.areEqual(this.sseCustomerAlgorithm, uploadPartCopyRequest.sseCustomerAlgorithm) && Intrinsics.areEqual(this.sseCustomerKey, uploadPartCopyRequest.sseCustomerKey) && Intrinsics.areEqual(this.sseCustomerKeyMd5, uploadPartCopyRequest.sseCustomerKeyMd5) && Intrinsics.areEqual(this.uploadId, uploadPartCopyRequest.uploadId);
    }

    public static /* synthetic */ UploadPartCopyRequest copy$default(UploadPartCopyRequest uploadPartCopyRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.UploadPartCopyRequest.copy.1
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
        Builder builder = new Builder(uploadPartCopyRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final UploadPartCopyRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: UploadPartCopyRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010M\u001a\u00020\u0005H\u0001J\r\u0010N\u001a\u00020\u0000H\u0000¢\u0006\u0002\bOR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001c\u0010\"\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001c\u0010%\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001c\u0010(\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR\u001c\u0010+\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR\u001c\u0010.\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\fR\u001c\u00101\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\n\"\u0004\b3\u0010\fR\u001e\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\n\"\u0004\bC\u0010\fR\u001c\u0010D\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\n\"\u0004\bF\u0010\fR\u001c\u0010G\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\n\"\u0004\bI\u0010\fR\u001c\u0010J\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\n\"\u0004\bL\u0010\f¨\u0006P"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest;", "(Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "copySource", "getCopySource", "setCopySource", "copySourceIfMatch", "getCopySourceIfMatch", "setCopySourceIfMatch", "copySourceIfModifiedSince", "Laws/smithy/kotlin/runtime/time/Instant;", "getCopySourceIfModifiedSince", "()Laws/smithy/kotlin/runtime/time/Instant;", "setCopySourceIfModifiedSince", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "copySourceIfNoneMatch", "getCopySourceIfNoneMatch", "setCopySourceIfNoneMatch", "copySourceIfUnmodifiedSince", "getCopySourceIfUnmodifiedSince", "setCopySourceIfUnmodifiedSince", "copySourceRange", "getCopySourceRange", "setCopySourceRange", "copySourceSseCustomerAlgorithm", "getCopySourceSseCustomerAlgorithm", "setCopySourceSseCustomerAlgorithm", "copySourceSseCustomerKey", "getCopySourceSseCustomerKey", "setCopySourceSseCustomerKey", "copySourceSseCustomerKeyMd5", "getCopySourceSseCustomerKeyMd5", "setCopySourceSseCustomerKeyMd5", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "expectedSourceBucketOwner", "getExpectedSourceBucketOwner", "setExpectedSourceBucketOwner", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", "partNumber", "", "getPartNumber", "()Ljava/lang/Integer;", "setPartNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "setRequestPayer", "(Laws/sdk/kotlin/services/s3/model/RequestPayer;)V", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "setSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "setSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "setSseCustomerKeyMd5", "uploadId", "getUploadId", "setUploadId", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private String copySource;
        private String copySourceIfMatch;
        private Instant copySourceIfModifiedSince;
        private String copySourceIfNoneMatch;
        private Instant copySourceIfUnmodifiedSince;
        private String copySourceRange;
        private String copySourceSseCustomerAlgorithm;
        private String copySourceSseCustomerKey;
        private String copySourceSseCustomerKeyMd5;
        private String expectedBucketOwner;
        private String expectedSourceBucketOwner;
        private String key;
        private Integer partNumber;
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

        public final String getCopySource() {
            return this.copySource;
        }

        public final void setCopySource(String str) {
            this.copySource = str;
        }

        public final String getCopySourceIfMatch() {
            return this.copySourceIfMatch;
        }

        public final void setCopySourceIfMatch(String str) {
            this.copySourceIfMatch = str;
        }

        public final Instant getCopySourceIfModifiedSince() {
            return this.copySourceIfModifiedSince;
        }

        public final void setCopySourceIfModifiedSince(Instant instant) {
            this.copySourceIfModifiedSince = instant;
        }

        public final String getCopySourceIfNoneMatch() {
            return this.copySourceIfNoneMatch;
        }

        public final void setCopySourceIfNoneMatch(String str) {
            this.copySourceIfNoneMatch = str;
        }

        public final Instant getCopySourceIfUnmodifiedSince() {
            return this.copySourceIfUnmodifiedSince;
        }

        public final void setCopySourceIfUnmodifiedSince(Instant instant) {
            this.copySourceIfUnmodifiedSince = instant;
        }

        public final String getCopySourceRange() {
            return this.copySourceRange;
        }

        public final void setCopySourceRange(String str) {
            this.copySourceRange = str;
        }

        public final String getCopySourceSseCustomerAlgorithm() {
            return this.copySourceSseCustomerAlgorithm;
        }

        public final void setCopySourceSseCustomerAlgorithm(String str) {
            this.copySourceSseCustomerAlgorithm = str;
        }

        public final String getCopySourceSseCustomerKey() {
            return this.copySourceSseCustomerKey;
        }

        public final void setCopySourceSseCustomerKey(String str) {
            this.copySourceSseCustomerKey = str;
        }

        public final String getCopySourceSseCustomerKeyMd5() {
            return this.copySourceSseCustomerKeyMd5;
        }

        public final void setCopySourceSseCustomerKeyMd5(String str) {
            this.copySourceSseCustomerKeyMd5 = str;
        }

        public final String getExpectedBucketOwner() {
            return this.expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String str) {
            this.expectedBucketOwner = str;
        }

        public final String getExpectedSourceBucketOwner() {
            return this.expectedSourceBucketOwner;
        }

        public final void setExpectedSourceBucketOwner(String str) {
            this.expectedSourceBucketOwner = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final Integer getPartNumber() {
            return this.partNumber;
        }

        public final void setPartNumber(Integer num) {
            this.partNumber = num;
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
        public Builder(UploadPartCopyRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.copySource = x.getCopySource();
            this.copySourceIfMatch = x.getCopySourceIfMatch();
            this.copySourceIfModifiedSince = x.getCopySourceIfModifiedSince();
            this.copySourceIfNoneMatch = x.getCopySourceIfNoneMatch();
            this.copySourceIfUnmodifiedSince = x.getCopySourceIfUnmodifiedSince();
            this.copySourceRange = x.getCopySourceRange();
            this.copySourceSseCustomerAlgorithm = x.getCopySourceSseCustomerAlgorithm();
            this.copySourceSseCustomerKey = x.getCopySourceSseCustomerKey();
            this.copySourceSseCustomerKeyMd5 = x.getCopySourceSseCustomerKeyMd5();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.expectedSourceBucketOwner = x.getExpectedSourceBucketOwner();
            this.key = x.getKey();
            this.partNumber = x.getPartNumber();
            this.requestPayer = x.getRequestPayer();
            this.sseCustomerAlgorithm = x.getSseCustomerAlgorithm();
            this.sseCustomerKey = x.getSseCustomerKey();
            this.sseCustomerKeyMd5 = x.getSseCustomerKeyMd5();
            this.uploadId = x.getUploadId();
        }

        public final UploadPartCopyRequest build() {
            return new UploadPartCopyRequest(this, null);
        }
    }
}
