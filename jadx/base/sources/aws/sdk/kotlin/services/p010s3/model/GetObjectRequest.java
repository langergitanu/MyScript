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

/* JADX INFO: compiled from: GetObjectRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 E2\u00020\u0001:\u0002EFB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010;\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010<\u001a\u00020\u001dH\u0096\u0080\u0004J\u0014\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010@\u001a\u00020\u00002\u0019\b\u0002\u0010A\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020C0B¢\u0006\u0002\bDH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\tR\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\tR\u0013\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR\u0013\u0010+\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\tR\u0013\u0010-\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\tR\u0013\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\tR\u0013\u00101\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0015R\u0013\u00103\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\tR\u0013\u00105\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\tR\u0013\u00107\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\tR\u0013\u00109\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006G"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetObjectRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/GetObjectRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/GetObjectRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "checksumMode", "Laws/sdk/kotlin/services/s3/model/ChecksumMode;", "getChecksumMode", "()Laws/sdk/kotlin/services/s3/model/ChecksumMode;", "expectedBucketOwner", "getExpectedBucketOwner", "ifMatch", "getIfMatch", "ifModifiedSince", "Laws/smithy/kotlin/runtime/time/Instant;", "getIfModifiedSince", "()Laws/smithy/kotlin/runtime/time/Instant;", "ifNoneMatch", "getIfNoneMatch", "ifUnmodifiedSince", "getIfUnmodifiedSince", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "partNumber", "", "getPartNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "range", "getRange", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "responseCacheControl", "getResponseCacheControl", "responseContentDisposition", "getResponseContentDisposition", "responseContentEncoding", "getResponseContentEncoding", "responseContentLanguage", "getResponseContentLanguage", "responseContentType", "getResponseContentType", "responseExpires", "getResponseExpires", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "versionId", "getVersionId", "toString", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetObjectRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final ChecksumMode checksumMode;
    private final String expectedBucketOwner;
    private final String ifMatch;
    private final Instant ifModifiedSince;
    private final String ifNoneMatch;
    private final Instant ifUnmodifiedSince;
    private final String key;
    private final Integer partNumber;
    private final String range;
    private final RequestPayer requestPayer;
    private final String responseCacheControl;
    private final String responseContentDisposition;
    private final String responseContentEncoding;
    private final String responseContentLanguage;
    private final String responseContentType;
    private final Instant responseExpires;
    private final String sseCustomerAlgorithm;
    private final String sseCustomerKey;
    private final String sseCustomerKeyMd5;
    private final String versionId;

    public /* synthetic */ GetObjectRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private GetObjectRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.checksumMode = builder.getChecksumMode();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.ifMatch = builder.getIfMatch();
        this.ifModifiedSince = builder.getIfModifiedSince();
        this.ifNoneMatch = builder.getIfNoneMatch();
        this.ifUnmodifiedSince = builder.getIfUnmodifiedSince();
        this.key = builder.getKey();
        this.partNumber = builder.getPartNumber();
        this.range = builder.getRange();
        this.requestPayer = builder.getRequestPayer();
        this.responseCacheControl = builder.getResponseCacheControl();
        this.responseContentDisposition = builder.getResponseContentDisposition();
        this.responseContentEncoding = builder.getResponseContentEncoding();
        this.responseContentLanguage = builder.getResponseContentLanguage();
        this.responseContentType = builder.getResponseContentType();
        this.responseExpires = builder.getResponseExpires();
        this.sseCustomerAlgorithm = builder.getSseCustomerAlgorithm();
        this.sseCustomerKey = builder.getSseCustomerKey();
        this.sseCustomerKeyMd5 = builder.getSseCustomerKeyMd5();
        this.versionId = builder.getVersionId();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final ChecksumMode getChecksumMode() {
        return this.checksumMode;
    }

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
    }

    public final String getIfMatch() {
        return this.ifMatch;
    }

    public final Instant getIfModifiedSince() {
        return this.ifModifiedSince;
    }

    public final String getIfNoneMatch() {
        return this.ifNoneMatch;
    }

    public final Instant getIfUnmodifiedSince() {
        return this.ifUnmodifiedSince;
    }

    public final String getKey() {
        return this.key;
    }

    public final Integer getPartNumber() {
        return this.partNumber;
    }

    public final String getRange() {
        return this.range;
    }

    public final RequestPayer getRequestPayer() {
        return this.requestPayer;
    }

    public final String getResponseCacheControl() {
        return this.responseCacheControl;
    }

    public final String getResponseContentDisposition() {
        return this.responseContentDisposition;
    }

    public final String getResponseContentEncoding() {
        return this.responseContentEncoding;
    }

    public final String getResponseContentLanguage() {
        return this.responseContentLanguage;
    }

    public final String getResponseContentType() {
        return this.responseContentType;
    }

    public final Instant getResponseExpires() {
        return this.responseExpires;
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

    public final String getVersionId() {
        return this.versionId;
    }

    /* JADX INFO: compiled from: GetObjectRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetObjectRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/GetObjectRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/GetObjectRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GetObjectRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetObjectRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("checksumMode=" + this.checksumMode + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("ifMatch=" + this.ifMatch + AbstractJsonLexerKt.COMMA);
        sb.append("ifModifiedSince=" + this.ifModifiedSince + AbstractJsonLexerKt.COMMA);
        sb.append("ifNoneMatch=" + this.ifNoneMatch + AbstractJsonLexerKt.COMMA);
        sb.append("ifUnmodifiedSince=" + this.ifUnmodifiedSince + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("partNumber=" + this.partNumber + AbstractJsonLexerKt.COMMA);
        sb.append("range=" + this.range + AbstractJsonLexerKt.COMMA);
        sb.append("requestPayer=" + this.requestPayer + AbstractJsonLexerKt.COMMA);
        sb.append("responseCacheControl=" + this.responseCacheControl + AbstractJsonLexerKt.COMMA);
        sb.append("responseContentDisposition=" + this.responseContentDisposition + AbstractJsonLexerKt.COMMA);
        sb.append("responseContentEncoding=" + this.responseContentEncoding + AbstractJsonLexerKt.COMMA);
        sb.append("responseContentLanguage=" + this.responseContentLanguage + AbstractJsonLexerKt.COMMA);
        sb.append("responseContentType=" + this.responseContentType + AbstractJsonLexerKt.COMMA);
        sb.append("responseExpires=" + this.responseExpires + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerAlgorithm=" + this.sseCustomerAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerKey=*** Sensitive Data Redacted ***,");
        sb.append("sseCustomerKeyMd5=" + this.sseCustomerKeyMd5 + AbstractJsonLexerKt.COMMA);
        sb.append("versionId=" + this.versionId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ChecksumMode checksumMode = this.checksumMode;
        int iHashCode2 = (iHashCode + (checksumMode != null ? checksumMode.hashCode() : 0)) * 31;
        String str2 = this.expectedBucketOwner;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ifMatch;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Instant instant = this.ifModifiedSince;
        int iHashCode5 = (iHashCode4 + (instant != null ? instant.hashCode() : 0)) * 31;
        String str4 = this.ifNoneMatch;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Instant instant2 = this.ifUnmodifiedSince;
        int iHashCode7 = (iHashCode6 + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        String str5 = this.key;
        int iHashCode8 = (iHashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num = this.partNumber;
        int iIntValue = (iHashCode8 + (num != null ? num.intValue() : 0)) * 31;
        String str6 = this.range;
        int iHashCode9 = (iIntValue + (str6 != null ? str6.hashCode() : 0)) * 31;
        RequestPayer requestPayer = this.requestPayer;
        int iHashCode10 = (iHashCode9 + (requestPayer != null ? requestPayer.hashCode() : 0)) * 31;
        String str7 = this.responseCacheControl;
        int iHashCode11 = (iHashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.responseContentDisposition;
        int iHashCode12 = (iHashCode11 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.responseContentEncoding;
        int iHashCode13 = (iHashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.responseContentLanguage;
        int iHashCode14 = (iHashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.responseContentType;
        int iHashCode15 = (iHashCode14 + (str11 != null ? str11.hashCode() : 0)) * 31;
        Instant instant3 = this.responseExpires;
        int iHashCode16 = (iHashCode15 + (instant3 != null ? instant3.hashCode() : 0)) * 31;
        String str12 = this.sseCustomerAlgorithm;
        int iHashCode17 = (iHashCode16 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.sseCustomerKey;
        int iHashCode18 = (iHashCode17 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.sseCustomerKeyMd5;
        int iHashCode19 = (iHashCode18 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.versionId;
        return iHashCode19 + (str15 != null ? str15.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        GetObjectRequest getObjectRequest = (GetObjectRequest) other;
        return Intrinsics.areEqual(this.bucket, getObjectRequest.bucket) && Intrinsics.areEqual(this.checksumMode, getObjectRequest.checksumMode) && Intrinsics.areEqual(this.expectedBucketOwner, getObjectRequest.expectedBucketOwner) && Intrinsics.areEqual(this.ifMatch, getObjectRequest.ifMatch) && Intrinsics.areEqual(this.ifModifiedSince, getObjectRequest.ifModifiedSince) && Intrinsics.areEqual(this.ifNoneMatch, getObjectRequest.ifNoneMatch) && Intrinsics.areEqual(this.ifUnmodifiedSince, getObjectRequest.ifUnmodifiedSince) && Intrinsics.areEqual(this.key, getObjectRequest.key) && Intrinsics.areEqual(this.partNumber, getObjectRequest.partNumber) && Intrinsics.areEqual(this.range, getObjectRequest.range) && Intrinsics.areEqual(this.requestPayer, getObjectRequest.requestPayer) && Intrinsics.areEqual(this.responseCacheControl, getObjectRequest.responseCacheControl) && Intrinsics.areEqual(this.responseContentDisposition, getObjectRequest.responseContentDisposition) && Intrinsics.areEqual(this.responseContentEncoding, getObjectRequest.responseContentEncoding) && Intrinsics.areEqual(this.responseContentLanguage, getObjectRequest.responseContentLanguage) && Intrinsics.areEqual(this.responseContentType, getObjectRequest.responseContentType) && Intrinsics.areEqual(this.responseExpires, getObjectRequest.responseExpires) && Intrinsics.areEqual(this.sseCustomerAlgorithm, getObjectRequest.sseCustomerAlgorithm) && Intrinsics.areEqual(this.sseCustomerKey, getObjectRequest.sseCustomerKey) && Intrinsics.areEqual(this.sseCustomerKeyMd5, getObjectRequest.sseCustomerKeyMd5) && Intrinsics.areEqual(this.versionId, getObjectRequest.versionId);
    }

    public static /* synthetic */ GetObjectRequest copy$default(GetObjectRequest getObjectRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.GetObjectRequest.copy.1
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
        Builder builder = new Builder(getObjectRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final GetObjectRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: GetObjectRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010V\u001a\u00020\u0005H\u0001J\r\u0010W\u001a\u00020\u0000H\u0000¢\u0006\u0002\bXR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001c\u0010%\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001e\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010/\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\n\"\u0004\b1\u0010\fR\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\n\"\u0004\b:\u0010\fR\u001c\u0010;\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\n\"\u0004\b=\u0010\fR\u001c\u0010>\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\n\"\u0004\b@\u0010\fR\u001c\u0010A\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\n\"\u0004\bC\u0010\fR\u001c\u0010D\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\n\"\u0004\bF\u0010\fR\u001c\u0010G\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001c\"\u0004\bI\u0010\u001eR\u001c\u0010J\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\n\"\u0004\bL\u0010\fR\u001c\u0010M\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\n\"\u0004\bO\u0010\fR\u001c\u0010P\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\n\"\u0004\bR\u0010\fR\u001c\u0010S\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\n\"\u0004\bU\u0010\f¨\u0006Y"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetObjectRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/GetObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "checksumMode", "Laws/sdk/kotlin/services/s3/model/ChecksumMode;", "getChecksumMode", "()Laws/sdk/kotlin/services/s3/model/ChecksumMode;", "setChecksumMode", "(Laws/sdk/kotlin/services/s3/model/ChecksumMode;)V", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "ifMatch", "getIfMatch", "setIfMatch", "ifModifiedSince", "Laws/smithy/kotlin/runtime/time/Instant;", "getIfModifiedSince", "()Laws/smithy/kotlin/runtime/time/Instant;", "setIfModifiedSince", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "ifNoneMatch", "getIfNoneMatch", "setIfNoneMatch", "ifUnmodifiedSince", "getIfUnmodifiedSince", "setIfUnmodifiedSince", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", "partNumber", "", "getPartNumber", "()Ljava/lang/Integer;", "setPartNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "range", "getRange", "setRange", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "setRequestPayer", "(Laws/sdk/kotlin/services/s3/model/RequestPayer;)V", "responseCacheControl", "getResponseCacheControl", "setResponseCacheControl", "responseContentDisposition", "getResponseContentDisposition", "setResponseContentDisposition", "responseContentEncoding", "getResponseContentEncoding", "setResponseContentEncoding", "responseContentLanguage", "getResponseContentLanguage", "setResponseContentLanguage", "responseContentType", "getResponseContentType", "setResponseContentType", "responseExpires", "getResponseExpires", "setResponseExpires", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "setSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "setSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "setSseCustomerKeyMd5", "versionId", "getVersionId", "setVersionId", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private ChecksumMode checksumMode;
        private String expectedBucketOwner;
        private String ifMatch;
        private Instant ifModifiedSince;
        private String ifNoneMatch;
        private Instant ifUnmodifiedSince;
        private String key;
        private Integer partNumber;
        private String range;
        private RequestPayer requestPayer;
        private String responseCacheControl;
        private String responseContentDisposition;
        private String responseContentEncoding;
        private String responseContentLanguage;
        private String responseContentType;
        private Instant responseExpires;
        private String sseCustomerAlgorithm;
        private String sseCustomerKey;
        private String sseCustomerKeyMd5;
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

        public final ChecksumMode getChecksumMode() {
            return this.checksumMode;
        }

        public final void setChecksumMode(ChecksumMode checksumMode) {
            this.checksumMode = checksumMode;
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

        public final Instant getIfModifiedSince() {
            return this.ifModifiedSince;
        }

        public final void setIfModifiedSince(Instant instant) {
            this.ifModifiedSince = instant;
        }

        public final String getIfNoneMatch() {
            return this.ifNoneMatch;
        }

        public final void setIfNoneMatch(String str) {
            this.ifNoneMatch = str;
        }

        public final Instant getIfUnmodifiedSince() {
            return this.ifUnmodifiedSince;
        }

        public final void setIfUnmodifiedSince(Instant instant) {
            this.ifUnmodifiedSince = instant;
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

        public final String getRange() {
            return this.range;
        }

        public final void setRange(String str) {
            this.range = str;
        }

        public final RequestPayer getRequestPayer() {
            return this.requestPayer;
        }

        public final void setRequestPayer(RequestPayer requestPayer) {
            this.requestPayer = requestPayer;
        }

        public final String getResponseCacheControl() {
            return this.responseCacheControl;
        }

        public final void setResponseCacheControl(String str) {
            this.responseCacheControl = str;
        }

        public final String getResponseContentDisposition() {
            return this.responseContentDisposition;
        }

        public final void setResponseContentDisposition(String str) {
            this.responseContentDisposition = str;
        }

        public final String getResponseContentEncoding() {
            return this.responseContentEncoding;
        }

        public final void setResponseContentEncoding(String str) {
            this.responseContentEncoding = str;
        }

        public final String getResponseContentLanguage() {
            return this.responseContentLanguage;
        }

        public final void setResponseContentLanguage(String str) {
            this.responseContentLanguage = str;
        }

        public final String getResponseContentType() {
            return this.responseContentType;
        }

        public final void setResponseContentType(String str) {
            this.responseContentType = str;
        }

        public final Instant getResponseExpires() {
            return this.responseExpires;
        }

        public final void setResponseExpires(Instant instant) {
            this.responseExpires = instant;
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

        public final String getVersionId() {
            return this.versionId;
        }

        public final void setVersionId(String str) {
            this.versionId = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(GetObjectRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.checksumMode = x.getChecksumMode();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.ifMatch = x.getIfMatch();
            this.ifModifiedSince = x.getIfModifiedSince();
            this.ifNoneMatch = x.getIfNoneMatch();
            this.ifUnmodifiedSince = x.getIfUnmodifiedSince();
            this.key = x.getKey();
            this.partNumber = x.getPartNumber();
            this.range = x.getRange();
            this.requestPayer = x.getRequestPayer();
            this.responseCacheControl = x.getResponseCacheControl();
            this.responseContentDisposition = x.getResponseContentDisposition();
            this.responseContentEncoding = x.getResponseContentEncoding();
            this.responseContentLanguage = x.getResponseContentLanguage();
            this.responseContentType = x.getResponseContentType();
            this.responseExpires = x.getResponseExpires();
            this.sseCustomerAlgorithm = x.getSseCustomerAlgorithm();
            this.sseCustomerKey = x.getSseCustomerKey();
            this.sseCustomerKeyMd5 = x.getSseCustomerKeyMd5();
            this.versionId = x.getVersionId();
        }

        public final GetObjectRequest build() {
            return new GetObjectRequest(this, null);
        }
    }
}
