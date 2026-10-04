package aws.sdk.kotlin.services.p010s3.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.time.Instant;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: CreateMultipartUploadRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 g2\u00020\u0001:\u0002ghB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010]\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010^\u001a\u00020_H\u0096\u0080\u0004J\u0014\u0010`\u001a\u00020\u000f2\b\u0010a\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010b\u001a\u00020\u00002\u0019\b\u0002\u0010c\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020e0d¢\u0006\u0002\bfH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\rR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\rR\u0013\u0010!\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\rR\u0013\u0010#\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\rR\u0013\u0010%\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\rR\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010+\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\rR\u0013\u0010-\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\rR\u0013\u0010/\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\rR\u0013\u00101\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\rR\u0013\u00103\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\rR\u001f\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u000106¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u00109\u001a\u0004\u0018\u00010:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010=\u001a\u0004\u0018\u00010>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010A\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R\u0013\u0010C\u001a\u0004\u0018\u00010D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010G\u001a\u0004\u0018\u00010H¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010K\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\rR\u0013\u0010M\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\rR\u0013\u0010O\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\rR\u0013\u0010Q\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\rR\u0013\u0010S\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\rR\u0013\u0010U\u001a\u0004\u0018\u00010V¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0013\u0010Y\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\rR\u0013\u0010[\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006i"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest$Builder;)V", "acl", "Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", "getAcl", "()Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", "bucket", "", "getBucket", "()Ljava/lang/String;", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "cacheControl", "getCacheControl", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "contentDisposition", "getContentDisposition", "contentEncoding", "getContentEncoding", "contentLanguage", "getContentLanguage", "contentType", "getContentType", "expectedBucketOwner", "getExpectedBucketOwner", ClientCookie.EXPIRES_ATTR, "Laws/smithy/kotlin/runtime/time/Instant;", "getExpires", "()Laws/smithy/kotlin/runtime/time/Instant;", "grantFullControl", "getGrantFullControl", "grantRead", "getGrantRead", "grantReadAcp", "getGrantReadAcp", "grantWriteAcp", "getGrantWriteAcp", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", TtmlNode.TAG_METADATA, "", "getMetadata", "()Ljava/util/Map;", "objectLockLegalHoldStatus", "Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "getObjectLockLegalHoldStatus", "()Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "objectLockMode", "Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "getObjectLockMode", "()Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "objectLockRetainUntilDate", "getObjectLockRetainUntilDate", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "ssekmsEncryptionContext", "getSsekmsEncryptionContext", "ssekmsKeyId", "getSsekmsKeyId", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "tagging", "getTagging", "websiteRedirectLocation", "getWebsiteRedirectLocation", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateMultipartUploadRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ObjectCannedAcl acl;
    private final String bucket;
    private final Boolean bucketKeyEnabled;
    private final String cacheControl;
    private final ChecksumAlgorithm checksumAlgorithm;
    private final ChecksumType checksumType;
    private final String contentDisposition;
    private final String contentEncoding;
    private final String contentLanguage;
    private final String contentType;
    private final String expectedBucketOwner;
    private final Instant expires;
    private final String grantFullControl;
    private final String grantRead;
    private final String grantReadAcp;
    private final String grantWriteAcp;
    private final String key;
    private final Map<String, String> metadata;
    private final ObjectLockLegalHoldStatus objectLockLegalHoldStatus;
    private final ObjectLockMode objectLockMode;
    private final Instant objectLockRetainUntilDate;
    private final RequestPayer requestPayer;
    private final ServerSideEncryption serverSideEncryption;
    private final String sseCustomerAlgorithm;
    private final String sseCustomerKey;
    private final String sseCustomerKeyMd5;
    private final String ssekmsEncryptionContext;
    private final String ssekmsKeyId;
    private final StorageClass storageClass;
    private final String tagging;
    private final String websiteRedirectLocation;

    public /* synthetic */ CreateMultipartUploadRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CreateMultipartUploadRequest(Builder builder) {
        this.acl = builder.getAcl();
        this.bucket = builder.getBucket();
        this.bucketKeyEnabled = builder.getBucketKeyEnabled();
        this.cacheControl = builder.getCacheControl();
        this.checksumAlgorithm = builder.getChecksumAlgorithm();
        this.checksumType = builder.getChecksumType();
        this.contentDisposition = builder.getContentDisposition();
        this.contentEncoding = builder.getContentEncoding();
        this.contentLanguage = builder.getContentLanguage();
        this.contentType = builder.getContentType();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.expires = builder.getExpires();
        this.grantFullControl = builder.getGrantFullControl();
        this.grantRead = builder.getGrantRead();
        this.grantReadAcp = builder.getGrantReadAcp();
        this.grantWriteAcp = builder.getGrantWriteAcp();
        this.key = builder.getKey();
        this.metadata = builder.getMetadata();
        this.objectLockLegalHoldStatus = builder.getObjectLockLegalHoldStatus();
        this.objectLockMode = builder.getObjectLockMode();
        this.objectLockRetainUntilDate = builder.getObjectLockRetainUntilDate();
        this.requestPayer = builder.getRequestPayer();
        this.serverSideEncryption = builder.getServerSideEncryption();
        this.sseCustomerAlgorithm = builder.getSseCustomerAlgorithm();
        this.sseCustomerKey = builder.getSseCustomerKey();
        this.sseCustomerKeyMd5 = builder.getSseCustomerKeyMd5();
        this.ssekmsEncryptionContext = builder.getSsekmsEncryptionContext();
        this.ssekmsKeyId = builder.getSsekmsKeyId();
        this.storageClass = builder.getStorageClass();
        this.tagging = builder.getTagging();
        this.websiteRedirectLocation = builder.getWebsiteRedirectLocation();
    }

    public final ObjectCannedAcl getAcl() {
        return this.acl;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final Boolean getBucketKeyEnabled() {
        return this.bucketKeyEnabled;
    }

    public final String getCacheControl() {
        return this.cacheControl;
    }

    public final ChecksumAlgorithm getChecksumAlgorithm() {
        return this.checksumAlgorithm;
    }

    public final ChecksumType getChecksumType() {
        return this.checksumType;
    }

    public final String getContentDisposition() {
        return this.contentDisposition;
    }

    public final String getContentEncoding() {
        return this.contentEncoding;
    }

    public final String getContentLanguage() {
        return this.contentLanguage;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
    }

    public final Instant getExpires() {
        return this.expires;
    }

    public final String getGrantFullControl() {
        return this.grantFullControl;
    }

    public final String getGrantRead() {
        return this.grantRead;
    }

    public final String getGrantReadAcp() {
        return this.grantReadAcp;
    }

    public final String getGrantWriteAcp() {
        return this.grantWriteAcp;
    }

    public final String getKey() {
        return this.key;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final ObjectLockLegalHoldStatus getObjectLockLegalHoldStatus() {
        return this.objectLockLegalHoldStatus;
    }

    public final ObjectLockMode getObjectLockMode() {
        return this.objectLockMode;
    }

    public final Instant getObjectLockRetainUntilDate() {
        return this.objectLockRetainUntilDate;
    }

    public final RequestPayer getRequestPayer() {
        return this.requestPayer;
    }

    public final ServerSideEncryption getServerSideEncryption() {
        return this.serverSideEncryption;
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

    public final String getSsekmsEncryptionContext() {
        return this.ssekmsEncryptionContext;
    }

    public final String getSsekmsKeyId() {
        return this.ssekmsKeyId;
    }

    public final StorageClass getStorageClass() {
        return this.storageClass;
    }

    public final String getTagging() {
        return this.tagging;
    }

    public final String getWebsiteRedirectLocation() {
        return this.websiteRedirectLocation;
    }

    /* JADX INFO: compiled from: CreateMultipartUploadRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateMultipartUploadRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateMultipartUploadRequest(");
        sb.append("acl=" + this.acl + AbstractJsonLexerKt.COMMA);
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("bucketKeyEnabled=" + this.bucketKeyEnabled + AbstractJsonLexerKt.COMMA);
        sb.append("cacheControl=" + this.cacheControl + AbstractJsonLexerKt.COMMA);
        sb.append("checksumAlgorithm=" + this.checksumAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("checksumType=" + this.checksumType + AbstractJsonLexerKt.COMMA);
        sb.append("contentDisposition=" + this.contentDisposition + AbstractJsonLexerKt.COMMA);
        sb.append("contentEncoding=" + this.contentEncoding + AbstractJsonLexerKt.COMMA);
        sb.append("contentLanguage=" + this.contentLanguage + AbstractJsonLexerKt.COMMA);
        sb.append("contentType=" + this.contentType + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("expires=" + this.expires + AbstractJsonLexerKt.COMMA);
        sb.append("grantFullControl=" + this.grantFullControl + AbstractJsonLexerKt.COMMA);
        sb.append("grantRead=" + this.grantRead + AbstractJsonLexerKt.COMMA);
        sb.append("grantReadAcp=" + this.grantReadAcp + AbstractJsonLexerKt.COMMA);
        sb.append("grantWriteAcp=" + this.grantWriteAcp + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("metadata=" + this.metadata + AbstractJsonLexerKt.COMMA);
        sb.append("objectLockLegalHoldStatus=" + this.objectLockLegalHoldStatus + AbstractJsonLexerKt.COMMA);
        sb.append("objectLockMode=" + this.objectLockMode + AbstractJsonLexerKt.COMMA);
        sb.append("objectLockRetainUntilDate=" + this.objectLockRetainUntilDate + AbstractJsonLexerKt.COMMA);
        sb.append("requestPayer=" + this.requestPayer + AbstractJsonLexerKt.COMMA);
        sb.append("serverSideEncryption=" + this.serverSideEncryption + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerAlgorithm=" + this.sseCustomerAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerKey=*** Sensitive Data Redacted ***,");
        sb.append("sseCustomerKeyMd5=" + this.sseCustomerKeyMd5 + AbstractJsonLexerKt.COMMA);
        sb.append("ssekmsEncryptionContext=*** Sensitive Data Redacted ***,ssekmsKeyId=*** Sensitive Data Redacted ***,");
        sb.append("storageClass=" + this.storageClass + AbstractJsonLexerKt.COMMA);
        sb.append("tagging=" + this.tagging + AbstractJsonLexerKt.COMMA);
        sb.append("websiteRedirectLocation=" + this.websiteRedirectLocation);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        ObjectCannedAcl objectCannedAcl = this.acl;
        int iHashCode = (objectCannedAcl != null ? objectCannedAcl.hashCode() : 0) * 31;
        String str = this.bucket;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Boolean bool = this.bucketKeyEnabled;
        int iHashCode3 = (iHashCode2 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        String str2 = this.cacheControl;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ChecksumAlgorithm checksumAlgorithm = this.checksumAlgorithm;
        int iHashCode5 = (iHashCode4 + (checksumAlgorithm != null ? checksumAlgorithm.hashCode() : 0)) * 31;
        ChecksumType checksumType = this.checksumType;
        int iHashCode6 = (iHashCode5 + (checksumType != null ? checksumType.hashCode() : 0)) * 31;
        String str3 = this.contentDisposition;
        int iHashCode7 = (iHashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.contentEncoding;
        int iHashCode8 = (iHashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.contentLanguage;
        int iHashCode9 = (iHashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.contentType;
        int iHashCode10 = (iHashCode9 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.expectedBucketOwner;
        int iHashCode11 = (iHashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Instant instant = this.expires;
        int iHashCode12 = (iHashCode11 + (instant != null ? instant.hashCode() : 0)) * 31;
        String str8 = this.grantFullControl;
        int iHashCode13 = (iHashCode12 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.grantRead;
        int iHashCode14 = (iHashCode13 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.grantReadAcp;
        int iHashCode15 = (iHashCode14 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.grantWriteAcp;
        int iHashCode16 = (iHashCode15 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.key;
        int iHashCode17 = (iHashCode16 + (str12 != null ? str12.hashCode() : 0)) * 31;
        Map<String, String> map = this.metadata;
        int iHashCode18 = (iHashCode17 + (map != null ? map.hashCode() : 0)) * 31;
        ObjectLockLegalHoldStatus objectLockLegalHoldStatus = this.objectLockLegalHoldStatus;
        int iHashCode19 = (iHashCode18 + (objectLockLegalHoldStatus != null ? objectLockLegalHoldStatus.hashCode() : 0)) * 31;
        ObjectLockMode objectLockMode = this.objectLockMode;
        int iHashCode20 = (iHashCode19 + (objectLockMode != null ? objectLockMode.hashCode() : 0)) * 31;
        Instant instant2 = this.objectLockRetainUntilDate;
        int iHashCode21 = (iHashCode20 + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        RequestPayer requestPayer = this.requestPayer;
        int iHashCode22 = (iHashCode21 + (requestPayer != null ? requestPayer.hashCode() : 0)) * 31;
        ServerSideEncryption serverSideEncryption = this.serverSideEncryption;
        int iHashCode23 = (iHashCode22 + (serverSideEncryption != null ? serverSideEncryption.hashCode() : 0)) * 31;
        String str13 = this.sseCustomerAlgorithm;
        int iHashCode24 = (iHashCode23 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.sseCustomerKey;
        int iHashCode25 = (iHashCode24 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.sseCustomerKeyMd5;
        int iHashCode26 = (iHashCode25 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.ssekmsEncryptionContext;
        int iHashCode27 = (iHashCode26 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.ssekmsKeyId;
        int iHashCode28 = (iHashCode27 + (str17 != null ? str17.hashCode() : 0)) * 31;
        StorageClass storageClass = this.storageClass;
        int iHashCode29 = (iHashCode28 + (storageClass != null ? storageClass.hashCode() : 0)) * 31;
        String str18 = this.tagging;
        int iHashCode30 = (iHashCode29 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.websiteRedirectLocation;
        return iHashCode30 + (str19 != null ? str19.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CreateMultipartUploadRequest createMultipartUploadRequest = (CreateMultipartUploadRequest) other;
        return Intrinsics.areEqual(this.acl, createMultipartUploadRequest.acl) && Intrinsics.areEqual(this.bucket, createMultipartUploadRequest.bucket) && Intrinsics.areEqual(this.bucketKeyEnabled, createMultipartUploadRequest.bucketKeyEnabled) && Intrinsics.areEqual(this.cacheControl, createMultipartUploadRequest.cacheControl) && Intrinsics.areEqual(this.checksumAlgorithm, createMultipartUploadRequest.checksumAlgorithm) && Intrinsics.areEqual(this.checksumType, createMultipartUploadRequest.checksumType) && Intrinsics.areEqual(this.contentDisposition, createMultipartUploadRequest.contentDisposition) && Intrinsics.areEqual(this.contentEncoding, createMultipartUploadRequest.contentEncoding) && Intrinsics.areEqual(this.contentLanguage, createMultipartUploadRequest.contentLanguage) && Intrinsics.areEqual(this.contentType, createMultipartUploadRequest.contentType) && Intrinsics.areEqual(this.expectedBucketOwner, createMultipartUploadRequest.expectedBucketOwner) && Intrinsics.areEqual(this.expires, createMultipartUploadRequest.expires) && Intrinsics.areEqual(this.grantFullControl, createMultipartUploadRequest.grantFullControl) && Intrinsics.areEqual(this.grantRead, createMultipartUploadRequest.grantRead) && Intrinsics.areEqual(this.grantReadAcp, createMultipartUploadRequest.grantReadAcp) && Intrinsics.areEqual(this.grantWriteAcp, createMultipartUploadRequest.grantWriteAcp) && Intrinsics.areEqual(this.key, createMultipartUploadRequest.key) && Intrinsics.areEqual(this.metadata, createMultipartUploadRequest.metadata) && Intrinsics.areEqual(this.objectLockLegalHoldStatus, createMultipartUploadRequest.objectLockLegalHoldStatus) && Intrinsics.areEqual(this.objectLockMode, createMultipartUploadRequest.objectLockMode) && Intrinsics.areEqual(this.objectLockRetainUntilDate, createMultipartUploadRequest.objectLockRetainUntilDate) && Intrinsics.areEqual(this.requestPayer, createMultipartUploadRequest.requestPayer) && Intrinsics.areEqual(this.serverSideEncryption, createMultipartUploadRequest.serverSideEncryption) && Intrinsics.areEqual(this.sseCustomerAlgorithm, createMultipartUploadRequest.sseCustomerAlgorithm) && Intrinsics.areEqual(this.sseCustomerKey, createMultipartUploadRequest.sseCustomerKey) && Intrinsics.areEqual(this.sseCustomerKeyMd5, createMultipartUploadRequest.sseCustomerKeyMd5) && Intrinsics.areEqual(this.ssekmsEncryptionContext, createMultipartUploadRequest.ssekmsEncryptionContext) && Intrinsics.areEqual(this.ssekmsKeyId, createMultipartUploadRequest.ssekmsKeyId) && Intrinsics.areEqual(this.storageClass, createMultipartUploadRequest.storageClass) && Intrinsics.areEqual(this.tagging, createMultipartUploadRequest.tagging) && Intrinsics.areEqual(this.websiteRedirectLocation, createMultipartUploadRequest.websiteRedirectLocation);
    }

    public static /* synthetic */ CreateMultipartUploadRequest copy$default(CreateMultipartUploadRequest createMultipartUploadRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.CreateMultipartUploadRequest.copy.1
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
        Builder builder = new Builder(createMultipartUploadRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final CreateMultipartUploadRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CreateMultipartUploadRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\t\u0010\u0089\u0001\u001a\u00020\u0005H\u0001J\u000f\u0010\u008a\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u008b\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012R\u001c\u0010,\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010\u0012R\u001c\u0010/\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\u001c\u00102\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0010\"\u0004\b4\u0010\u0012R\u001c\u00105\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0010\"\u0004\b7\u0010\u0012R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010\u0012R\u001c\u0010A\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0010\"\u0004\bC\u0010\u0012R\u001c\u0010D\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010\u0012R\u001c\u0010G\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0010\"\u0004\bI\u0010\u0012R\u001c\u0010J\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0010\"\u0004\bL\u0010\u0012R(\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010;\"\u0004\ba\u0010=R\u001c\u0010b\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001c\u0010n\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0010\"\u0004\bp\u0010\u0012R\u001c\u0010q\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0010\"\u0004\bs\u0010\u0012R\u001c\u0010t\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0010\"\u0004\bv\u0010\u0012R\u001c\u0010w\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0010\"\u0004\by\u0010\u0012R\u001c\u0010z\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0010\"\u0004\b|\u0010\u0012R\u001f\u0010}\u001a\u0004\u0018\u00010~X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0010\"\u0005\b\u0085\u0001\u0010\u0012R\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0010\"\u0005\b\u0088\u0001\u0010\u0012¨\u0006\u008c\u0001"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest;)V", "acl", "Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", "getAcl", "()Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", "setAcl", "(Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "setBucketKeyEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "cacheControl", "getCacheControl", "setCacheControl", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "setChecksumAlgorithm", "(Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;)V", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "setChecksumType", "(Laws/sdk/kotlin/services/s3/model/ChecksumType;)V", "contentDisposition", "getContentDisposition", "setContentDisposition", "contentEncoding", "getContentEncoding", "setContentEncoding", "contentLanguage", "getContentLanguage", "setContentLanguage", "contentType", "getContentType", "setContentType", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", ClientCookie.EXPIRES_ATTR, "Laws/smithy/kotlin/runtime/time/Instant;", "getExpires", "()Laws/smithy/kotlin/runtime/time/Instant;", "setExpires", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "grantFullControl", "getGrantFullControl", "setGrantFullControl", "grantRead", "getGrantRead", "setGrantRead", "grantReadAcp", "getGrantReadAcp", "setGrantReadAcp", "grantWriteAcp", "getGrantWriteAcp", "setGrantWriteAcp", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", TtmlNode.TAG_METADATA, "", "getMetadata", "()Ljava/util/Map;", "setMetadata", "(Ljava/util/Map;)V", "objectLockLegalHoldStatus", "Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "getObjectLockLegalHoldStatus", "()Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "setObjectLockLegalHoldStatus", "(Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;)V", "objectLockMode", "Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "getObjectLockMode", "()Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "setObjectLockMode", "(Laws/sdk/kotlin/services/s3/model/ObjectLockMode;)V", "objectLockRetainUntilDate", "getObjectLockRetainUntilDate", "setObjectLockRetainUntilDate", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "setRequestPayer", "(Laws/sdk/kotlin/services/s3/model/RequestPayer;)V", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "setServerSideEncryption", "(Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;)V", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "setSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "setSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "setSseCustomerKeyMd5", "ssekmsEncryptionContext", "getSsekmsEncryptionContext", "setSsekmsEncryptionContext", "ssekmsKeyId", "getSsekmsKeyId", "setSsekmsKeyId", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "setStorageClass", "(Laws/sdk/kotlin/services/s3/model/StorageClass;)V", "tagging", "getTagging", "setTagging", "websiteRedirectLocation", "getWebsiteRedirectLocation", "setWebsiteRedirectLocation", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private ObjectCannedAcl acl;
        private String bucket;
        private Boolean bucketKeyEnabled;
        private String cacheControl;
        private ChecksumAlgorithm checksumAlgorithm;
        private ChecksumType checksumType;
        private String contentDisposition;
        private String contentEncoding;
        private String contentLanguage;
        private String contentType;
        private String expectedBucketOwner;
        private Instant expires;
        private String grantFullControl;
        private String grantRead;
        private String grantReadAcp;
        private String grantWriteAcp;
        private String key;
        private Map<String, String> metadata;
        private ObjectLockLegalHoldStatus objectLockLegalHoldStatus;
        private ObjectLockMode objectLockMode;
        private Instant objectLockRetainUntilDate;
        private RequestPayer requestPayer;
        private ServerSideEncryption serverSideEncryption;
        private String sseCustomerAlgorithm;
        private String sseCustomerKey;
        private String sseCustomerKeyMd5;
        private String ssekmsEncryptionContext;
        private String ssekmsKeyId;
        private StorageClass storageClass;
        private String tagging;
        private String websiteRedirectLocation;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final ObjectCannedAcl getAcl() {
            return this.acl;
        }

        public final void setAcl(ObjectCannedAcl objectCannedAcl) {
            this.acl = objectCannedAcl;
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

        public final String getCacheControl() {
            return this.cacheControl;
        }

        public final void setCacheControl(String str) {
            this.cacheControl = str;
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

        public final String getContentDisposition() {
            return this.contentDisposition;
        }

        public final void setContentDisposition(String str) {
            this.contentDisposition = str;
        }

        public final String getContentEncoding() {
            return this.contentEncoding;
        }

        public final void setContentEncoding(String str) {
            this.contentEncoding = str;
        }

        public final String getContentLanguage() {
            return this.contentLanguage;
        }

        public final void setContentLanguage(String str) {
            this.contentLanguage = str;
        }

        public final String getContentType() {
            return this.contentType;
        }

        public final void setContentType(String str) {
            this.contentType = str;
        }

        public final String getExpectedBucketOwner() {
            return this.expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String str) {
            this.expectedBucketOwner = str;
        }

        public final Instant getExpires() {
            return this.expires;
        }

        public final void setExpires(Instant instant) {
            this.expires = instant;
        }

        public final String getGrantFullControl() {
            return this.grantFullControl;
        }

        public final void setGrantFullControl(String str) {
            this.grantFullControl = str;
        }

        public final String getGrantRead() {
            return this.grantRead;
        }

        public final void setGrantRead(String str) {
            this.grantRead = str;
        }

        public final String getGrantReadAcp() {
            return this.grantReadAcp;
        }

        public final void setGrantReadAcp(String str) {
            this.grantReadAcp = str;
        }

        public final String getGrantWriteAcp() {
            return this.grantWriteAcp;
        }

        public final void setGrantWriteAcp(String str) {
            this.grantWriteAcp = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final Map<String, String> getMetadata() {
            return this.metadata;
        }

        public final void setMetadata(Map<String, String> map) {
            this.metadata = map;
        }

        public final ObjectLockLegalHoldStatus getObjectLockLegalHoldStatus() {
            return this.objectLockLegalHoldStatus;
        }

        public final void setObjectLockLegalHoldStatus(ObjectLockLegalHoldStatus objectLockLegalHoldStatus) {
            this.objectLockLegalHoldStatus = objectLockLegalHoldStatus;
        }

        public final ObjectLockMode getObjectLockMode() {
            return this.objectLockMode;
        }

        public final void setObjectLockMode(ObjectLockMode objectLockMode) {
            this.objectLockMode = objectLockMode;
        }

        public final Instant getObjectLockRetainUntilDate() {
            return this.objectLockRetainUntilDate;
        }

        public final void setObjectLockRetainUntilDate(Instant instant) {
            this.objectLockRetainUntilDate = instant;
        }

        public final RequestPayer getRequestPayer() {
            return this.requestPayer;
        }

        public final void setRequestPayer(RequestPayer requestPayer) {
            this.requestPayer = requestPayer;
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

        public final StorageClass getStorageClass() {
            return this.storageClass;
        }

        public final void setStorageClass(StorageClass storageClass) {
            this.storageClass = storageClass;
        }

        public final String getTagging() {
            return this.tagging;
        }

        public final void setTagging(String str) {
            this.tagging = str;
        }

        public final String getWebsiteRedirectLocation() {
            return this.websiteRedirectLocation;
        }

        public final void setWebsiteRedirectLocation(String str) {
            this.websiteRedirectLocation = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CreateMultipartUploadRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.acl = x.getAcl();
            this.bucket = x.getBucket();
            this.bucketKeyEnabled = x.getBucketKeyEnabled();
            this.cacheControl = x.getCacheControl();
            this.checksumAlgorithm = x.getChecksumAlgorithm();
            this.checksumType = x.getChecksumType();
            this.contentDisposition = x.getContentDisposition();
            this.contentEncoding = x.getContentEncoding();
            this.contentLanguage = x.getContentLanguage();
            this.contentType = x.getContentType();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.expires = x.getExpires();
            this.grantFullControl = x.getGrantFullControl();
            this.grantRead = x.getGrantRead();
            this.grantReadAcp = x.getGrantReadAcp();
            this.grantWriteAcp = x.getGrantWriteAcp();
            this.key = x.getKey();
            this.metadata = x.getMetadata();
            this.objectLockLegalHoldStatus = x.getObjectLockLegalHoldStatus();
            this.objectLockMode = x.getObjectLockMode();
            this.objectLockRetainUntilDate = x.getObjectLockRetainUntilDate();
            this.requestPayer = x.getRequestPayer();
            this.serverSideEncryption = x.getServerSideEncryption();
            this.sseCustomerAlgorithm = x.getSseCustomerAlgorithm();
            this.sseCustomerKey = x.getSseCustomerKey();
            this.sseCustomerKeyMd5 = x.getSseCustomerKeyMd5();
            this.ssekmsEncryptionContext = x.getSsekmsEncryptionContext();
            this.ssekmsKeyId = x.getSsekmsKeyId();
            this.storageClass = x.getStorageClass();
            this.tagging = x.getTagging();
            this.websiteRedirectLocation = x.getWebsiteRedirectLocation();
        }

        public final CreateMultipartUploadRequest build() {
            return new CreateMultipartUploadRequest(this, null);
        }
    }
}
