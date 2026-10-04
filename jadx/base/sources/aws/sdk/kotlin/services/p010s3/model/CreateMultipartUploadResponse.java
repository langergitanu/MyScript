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

/* JADX INFO: compiled from: CreateMultipartUploadResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u00101\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u00102\u001a\u000203H\u0096\u0080\u0004J\u0014\u00104\u001a\u00020\u00112\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u00106\u001a\u00020\u00002\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020908¢\u0006\u0002\b:H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\rR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\rR\u0013\u0010)\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\rR\u0013\u0010+\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\rR\u0013\u0010-\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\rR\u0013\u0010/\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006="}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse$Builder;)V", "abortDate", "Laws/smithy/kotlin/runtime/time/Instant;", "getAbortDate", "()Laws/smithy/kotlin/runtime/time/Instant;", "abortRuleId", "", "getAbortRuleId", "()Ljava/lang/String;", "bucket", "getBucket", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "ssekmsEncryptionContext", "getSsekmsEncryptionContext", "ssekmsKeyId", "getSsekmsKeyId", "uploadId", "getUploadId", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateMultipartUploadResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Instant abortDate;
    private final String abortRuleId;
    private final String bucket;
    private final Boolean bucketKeyEnabled;
    private final ChecksumAlgorithm checksumAlgorithm;
    private final ChecksumType checksumType;
    private final String key;
    private final RequestCharged requestCharged;
    private final ServerSideEncryption serverSideEncryption;
    private final String sseCustomerAlgorithm;
    private final String sseCustomerKeyMd5;
    private final String ssekmsEncryptionContext;
    private final String ssekmsKeyId;
    private final String uploadId;

    public /* synthetic */ CreateMultipartUploadResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CreateMultipartUploadResponse(Builder builder) {
        this.abortDate = builder.getAbortDate();
        this.abortRuleId = builder.getAbortRuleId();
        this.bucket = builder.getBucket();
        this.bucketKeyEnabled = builder.getBucketKeyEnabled();
        this.checksumAlgorithm = builder.getChecksumAlgorithm();
        this.checksumType = builder.getChecksumType();
        this.key = builder.getKey();
        this.requestCharged = builder.getRequestCharged();
        this.serverSideEncryption = builder.getServerSideEncryption();
        this.sseCustomerAlgorithm = builder.getSseCustomerAlgorithm();
        this.sseCustomerKeyMd5 = builder.getSseCustomerKeyMd5();
        this.ssekmsEncryptionContext = builder.getSsekmsEncryptionContext();
        this.ssekmsKeyId = builder.getSsekmsKeyId();
        this.uploadId = builder.getUploadId();
    }

    public final Instant getAbortDate() {
        return this.abortDate;
    }

    public final String getAbortRuleId() {
        return this.abortRuleId;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final Boolean getBucketKeyEnabled() {
        return this.bucketKeyEnabled;
    }

    public final ChecksumAlgorithm getChecksumAlgorithm() {
        return this.checksumAlgorithm;
    }

    public final ChecksumType getChecksumType() {
        return this.checksumType;
    }

    public final String getKey() {
        return this.key;
    }

    public final RequestCharged getRequestCharged() {
        return this.requestCharged;
    }

    public final ServerSideEncryption getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public final String getSseCustomerAlgorithm() {
        return this.sseCustomerAlgorithm;
    }

    public final String getSseCustomerKeyMd5() {
        return this.sseCustomerKeyMd5;
    }

    public final String getSsekmsEncryptionContext() {
        return this.ssekmsEncryptionContext;
    }

    public final String getSsekmsKeyId() {
        return this.ssekmsKeyId;
    }

    public final String getUploadId() {
        return this.uploadId;
    }

    /* JADX INFO: compiled from: CreateMultipartUploadResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateMultipartUploadResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateMultipartUploadResponse(");
        sb.append("abortDate=" + this.abortDate + AbstractJsonLexerKt.COMMA);
        sb.append("abortRuleId=" + this.abortRuleId + AbstractJsonLexerKt.COMMA);
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("bucketKeyEnabled=" + this.bucketKeyEnabled + AbstractJsonLexerKt.COMMA);
        sb.append("checksumAlgorithm=" + this.checksumAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("checksumType=" + this.checksumType + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("requestCharged=" + this.requestCharged + AbstractJsonLexerKt.COMMA);
        sb.append("serverSideEncryption=" + this.serverSideEncryption + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerAlgorithm=" + this.sseCustomerAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerKeyMd5=" + this.sseCustomerKeyMd5 + AbstractJsonLexerKt.COMMA);
        sb.append("ssekmsEncryptionContext=*** Sensitive Data Redacted ***,ssekmsKeyId=*** Sensitive Data Redacted ***,");
        sb.append("uploadId=" + this.uploadId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Instant instant = this.abortDate;
        int iHashCode = (instant != null ? instant.hashCode() : 0) * 31;
        String str = this.abortRuleId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.bucket;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.bucketKeyEnabled;
        int iHashCode4 = (iHashCode3 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        ChecksumAlgorithm checksumAlgorithm = this.checksumAlgorithm;
        int iHashCode5 = (iHashCode4 + (checksumAlgorithm != null ? checksumAlgorithm.hashCode() : 0)) * 31;
        ChecksumType checksumType = this.checksumType;
        int iHashCode6 = (iHashCode5 + (checksumType != null ? checksumType.hashCode() : 0)) * 31;
        String str3 = this.key;
        int iHashCode7 = (iHashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        RequestCharged requestCharged = this.requestCharged;
        int iHashCode8 = (iHashCode7 + (requestCharged != null ? requestCharged.hashCode() : 0)) * 31;
        ServerSideEncryption serverSideEncryption = this.serverSideEncryption;
        int iHashCode9 = (iHashCode8 + (serverSideEncryption != null ? serverSideEncryption.hashCode() : 0)) * 31;
        String str4 = this.sseCustomerAlgorithm;
        int iHashCode10 = (iHashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.sseCustomerKeyMd5;
        int iHashCode11 = (iHashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.ssekmsEncryptionContext;
        int iHashCode12 = (iHashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.ssekmsKeyId;
        int iHashCode13 = (iHashCode12 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.uploadId;
        return iHashCode13 + (str8 != null ? str8.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CreateMultipartUploadResponse createMultipartUploadResponse = (CreateMultipartUploadResponse) other;
        return Intrinsics.areEqual(this.abortDate, createMultipartUploadResponse.abortDate) && Intrinsics.areEqual(this.abortRuleId, createMultipartUploadResponse.abortRuleId) && Intrinsics.areEqual(this.bucket, createMultipartUploadResponse.bucket) && Intrinsics.areEqual(this.bucketKeyEnabled, createMultipartUploadResponse.bucketKeyEnabled) && Intrinsics.areEqual(this.checksumAlgorithm, createMultipartUploadResponse.checksumAlgorithm) && Intrinsics.areEqual(this.checksumType, createMultipartUploadResponse.checksumType) && Intrinsics.areEqual(this.key, createMultipartUploadResponse.key) && Intrinsics.areEqual(this.requestCharged, createMultipartUploadResponse.requestCharged) && Intrinsics.areEqual(this.serverSideEncryption, createMultipartUploadResponse.serverSideEncryption) && Intrinsics.areEqual(this.sseCustomerAlgorithm, createMultipartUploadResponse.sseCustomerAlgorithm) && Intrinsics.areEqual(this.sseCustomerKeyMd5, createMultipartUploadResponse.sseCustomerKeyMd5) && Intrinsics.areEqual(this.ssekmsEncryptionContext, createMultipartUploadResponse.ssekmsEncryptionContext) && Intrinsics.areEqual(this.ssekmsKeyId, createMultipartUploadResponse.ssekmsKeyId) && Intrinsics.areEqual(this.uploadId, createMultipartUploadResponse.uploadId);
    }

    public static /* synthetic */ CreateMultipartUploadResponse copy$default(CreateMultipartUploadResponse createMultipartUploadResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.CreateMultipartUploadResponse.copy.1
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
        Builder builder = new Builder(createMultipartUploadResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final CreateMultipartUploadResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CreateMultipartUploadResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010G\u001a\u00020\u0005H\u0001J\r\u0010H\u001a\u00020\u0000H\u0000¢\u0006\u0002\bIR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0010\"\u0004\b:\u0010\u0012R\u001c\u0010;\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0010\"\u0004\b=\u0010\u0012R\u001c\u0010>\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010\u0012R\u001c\u0010A\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0010\"\u0004\bC\u0010\u0012R\u001c\u0010D\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010\u0012¨\u0006J"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse;", "(Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse;)V", "abortDate", "Laws/smithy/kotlin/runtime/time/Instant;", "getAbortDate", "()Laws/smithy/kotlin/runtime/time/Instant;", "setAbortDate", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "abortRuleId", "", "getAbortRuleId", "()Ljava/lang/String;", "setAbortRuleId", "(Ljava/lang/String;)V", "bucket", "getBucket", "setBucket", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "setBucketKeyEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "setChecksumAlgorithm", "(Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;)V", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "setChecksumType", "(Laws/sdk/kotlin/services/s3/model/ChecksumType;)V", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "setRequestCharged", "(Laws/sdk/kotlin/services/s3/model/RequestCharged;)V", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "setServerSideEncryption", "(Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;)V", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "setSseCustomerAlgorithm", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "setSseCustomerKeyMd5", "ssekmsEncryptionContext", "getSsekmsEncryptionContext", "setSsekmsEncryptionContext", "ssekmsKeyId", "getSsekmsKeyId", "setSsekmsKeyId", "uploadId", "getUploadId", "setUploadId", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Instant abortDate;
        private String abortRuleId;
        private String bucket;
        private Boolean bucketKeyEnabled;
        private ChecksumAlgorithm checksumAlgorithm;
        private ChecksumType checksumType;
        private String key;
        private RequestCharged requestCharged;
        private ServerSideEncryption serverSideEncryption;
        private String sseCustomerAlgorithm;
        private String sseCustomerKeyMd5;
        private String ssekmsEncryptionContext;
        private String ssekmsKeyId;
        private String uploadId;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Instant getAbortDate() {
            return this.abortDate;
        }

        public final void setAbortDate(Instant instant) {
            this.abortDate = instant;
        }

        public final String getAbortRuleId() {
            return this.abortRuleId;
        }

        public final void setAbortRuleId(String str) {
            this.abortRuleId = str;
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

        public final ChecksumAlgorithm getChecksumAlgorithm() {
            return this.checksumAlgorithm;
        }

        public final void setChecksumAlgorithm(ChecksumAlgorithm checksumAlgorithm) {
            this.checksumAlgorithm = checksumAlgorithm;
        }

        public final ChecksumType getChecksumType() {
            return this.checksumType;
        }

        public final void setChecksumType(ChecksumType checksumType) {
            this.checksumType = checksumType;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
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

        public final String getSseCustomerAlgorithm() {
            return this.sseCustomerAlgorithm;
        }

        public final void setSseCustomerAlgorithm(String str) {
            this.sseCustomerAlgorithm = str;
        }

        public final String getSseCustomerKeyMd5() {
            return this.sseCustomerKeyMd5;
        }

        public final void setSseCustomerKeyMd5(String str) {
            this.sseCustomerKeyMd5 = str;
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

        public final String getUploadId() {
            return this.uploadId;
        }

        public final void setUploadId(String str) {
            this.uploadId = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CreateMultipartUploadResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.abortDate = x.getAbortDate();
            this.abortRuleId = x.getAbortRuleId();
            this.bucket = x.getBucket();
            this.bucketKeyEnabled = x.getBucketKeyEnabled();
            this.checksumAlgorithm = x.getChecksumAlgorithm();
            this.checksumType = x.getChecksumType();
            this.key = x.getKey();
            this.requestCharged = x.getRequestCharged();
            this.serverSideEncryption = x.getServerSideEncryption();
            this.sseCustomerAlgorithm = x.getSseCustomerAlgorithm();
            this.sseCustomerKeyMd5 = x.getSseCustomerKeyMd5();
            this.ssekmsEncryptionContext = x.getSsekmsEncryptionContext();
            this.ssekmsKeyId = x.getSsekmsKeyId();
            this.uploadId = x.getUploadId();
        }

        public final CreateMultipartUploadResponse build() {
            return new CreateMultipartUploadResponse(this, null);
        }
    }
}
