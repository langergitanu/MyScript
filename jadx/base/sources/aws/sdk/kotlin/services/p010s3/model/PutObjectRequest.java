package aws.sdk.kotlin.services.p010s3.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.content.ByteStream;
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

/* JADX INFO: compiled from: PutObjectRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ~2\u00020\u0001:\u0002~\u007fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010t\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010u\u001a\u00020vH\u0096\u0080\u0004J\u0014\u0010w\u001a\u00020\u00132\b\u0010x\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010y\u001a\u00020\u00002\u0019\b\u0002\u0010z\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020|0{¢\u0006\u0002\b}H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R\u0013\u0010!\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011R\u0013\u0010#\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011R\u0013\u0010%\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0011R\u0013\u0010'\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0011R\u0013\u0010)\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0011R\u0013\u0010+\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0011R\u0015\u0010-\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0013\u00102\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0011R\u0013\u00104\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0011R\u0013\u00106\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0011R\u0013\u00108\u001a\u0004\u0018\u000109¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010<\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0011R\u0013\u0010>\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0011R\u0013\u0010@\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0011R\u0013\u0010B\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0011R\u0013\u0010D\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0011R\u0013\u0010F\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0011R\u0013\u0010H\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0011R\u001f\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010K¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010N\u001a\u0004\u0018\u00010O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010R\u001a\u0004\u0018\u00010S¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010V\u001a\u0004\u0018\u000109¢\u0006\b\n\u0000\u001a\u0004\bW\u0010;R\u0013\u0010X\u001a\u0004\u0018\u00010Y¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0013\u0010\\\u001a\u0004\u0018\u00010]¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0013\u0010`\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0011R\u0013\u0010b\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0011R\u0013\u0010d\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0011R\u0013\u0010f\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0011R\u0013\u0010h\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0011R\u0013\u0010j\u001a\u0004\u0018\u00010k¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0013\u0010n\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0011R\u0013\u0010p\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0011R\u0015\u0010r\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00101\u001a\u0004\bs\u00100\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0080\u0001"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutObjectRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/PutObjectRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/PutObjectRequest$Builder;)V", "acl", "Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", "getAcl", "()Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/content/ByteStream;", "getBody", "()Laws/smithy/kotlin/runtime/content/ByteStream;", "bucket", "", "getBucket", "()Ljava/lang/String;", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "cacheControl", "getCacheControl", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "checksumCrc32", "getChecksumCrc32", "checksumCrc32C", "getChecksumCrc32C", "checksumCrc64Nvme", "getChecksumCrc64Nvme", "checksumSha1", "getChecksumSha1", "checksumSha256", "getChecksumSha256", "contentDisposition", "getContentDisposition", "contentEncoding", "getContentEncoding", "contentLanguage", "getContentLanguage", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "contentMd5", "getContentMd5", "contentType", "getContentType", "expectedBucketOwner", "getExpectedBucketOwner", ClientCookie.EXPIRES_ATTR, "Laws/smithy/kotlin/runtime/time/Instant;", "getExpires", "()Laws/smithy/kotlin/runtime/time/Instant;", "grantFullControl", "getGrantFullControl", "grantRead", "getGrantRead", "grantReadAcp", "getGrantReadAcp", "grantWriteAcp", "getGrantWriteAcp", "ifMatch", "getIfMatch", "ifNoneMatch", "getIfNoneMatch", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", TtmlNode.TAG_METADATA, "", "getMetadata", "()Ljava/util/Map;", "objectLockLegalHoldStatus", "Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "getObjectLockLegalHoldStatus", "()Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "objectLockMode", "Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "getObjectLockMode", "()Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "objectLockRetainUntilDate", "getObjectLockRetainUntilDate", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "ssekmsEncryptionContext", "getSsekmsEncryptionContext", "ssekmsKeyId", "getSsekmsKeyId", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "tagging", "getTagging", "websiteRedirectLocation", "getWebsiteRedirectLocation", "writeOffsetBytes", "getWriteOffsetBytes", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PutObjectRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ObjectCannedAcl acl;
    private final ByteStream body;
    private final String bucket;
    private final Boolean bucketKeyEnabled;
    private final String cacheControl;
    private final ChecksumAlgorithm checksumAlgorithm;
    private final String checksumCrc32;
    private final String checksumCrc32C;
    private final String checksumCrc64Nvme;
    private final String checksumSha1;
    private final String checksumSha256;
    private final String contentDisposition;
    private final String contentEncoding;
    private final String contentLanguage;
    private final Long contentLength;
    private final String contentMd5;
    private final String contentType;
    private final String expectedBucketOwner;
    private final Instant expires;
    private final String grantFullControl;
    private final String grantRead;
    private final String grantReadAcp;
    private final String grantWriteAcp;
    private final String ifMatch;
    private final String ifNoneMatch;
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
    private final Long writeOffsetBytes;

    public /* synthetic */ PutObjectRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PutObjectRequest(Builder builder) {
        this.acl = builder.getAcl();
        this.body = builder.getBody();
        this.bucket = builder.getBucket();
        this.bucketKeyEnabled = builder.getBucketKeyEnabled();
        this.cacheControl = builder.getCacheControl();
        this.checksumAlgorithm = builder.getChecksumAlgorithm();
        this.checksumCrc32 = builder.getChecksumCrc32();
        this.checksumCrc32C = builder.getChecksumCrc32C();
        this.checksumCrc64Nvme = builder.getChecksumCrc64Nvme();
        this.checksumSha1 = builder.getChecksumSha1();
        this.checksumSha256 = builder.getChecksumSha256();
        this.contentDisposition = builder.getContentDisposition();
        this.contentEncoding = builder.getContentEncoding();
        this.contentLanguage = builder.getContentLanguage();
        this.contentLength = builder.getContentLength();
        this.contentMd5 = builder.getContentMd5();
        this.contentType = builder.getContentType();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.expires = builder.getExpires();
        this.grantFullControl = builder.getGrantFullControl();
        this.grantRead = builder.getGrantRead();
        this.grantReadAcp = builder.getGrantReadAcp();
        this.grantWriteAcp = builder.getGrantWriteAcp();
        this.ifMatch = builder.getIfMatch();
        this.ifNoneMatch = builder.getIfNoneMatch();
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
        this.writeOffsetBytes = builder.getWriteOffsetBytes();
    }

    public final ObjectCannedAcl getAcl() {
        return this.acl;
    }

    public final ByteStream getBody() {
        return this.body;
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

    public final String getContentDisposition() {
        return this.contentDisposition;
    }

    public final String getContentEncoding() {
        return this.contentEncoding;
    }

    public final String getContentLanguage() {
        return this.contentLanguage;
    }

    public final Long getContentLength() {
        return this.contentLength;
    }

    public final String getContentMd5() {
        return this.contentMd5;
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

    public final String getIfMatch() {
        return this.ifMatch;
    }

    public final String getIfNoneMatch() {
        return this.ifNoneMatch;
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

    public final Long getWriteOffsetBytes() {
        return this.writeOffsetBytes;
    }

    /* JADX INFO: compiled from: PutObjectRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutObjectRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/PutObjectRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/PutObjectRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PutObjectRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutObjectRequest(");
        sb.append("acl=" + this.acl + AbstractJsonLexerKt.COMMA);
        sb.append("body=" + this.body + AbstractJsonLexerKt.COMMA);
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("bucketKeyEnabled=" + this.bucketKeyEnabled + AbstractJsonLexerKt.COMMA);
        sb.append("cacheControl=" + this.cacheControl + AbstractJsonLexerKt.COMMA);
        sb.append("checksumAlgorithm=" + this.checksumAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc32=" + this.checksumCrc32 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc32C=" + this.checksumCrc32C + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc64Nvme=" + this.checksumCrc64Nvme + AbstractJsonLexerKt.COMMA);
        sb.append("checksumSha1=" + this.checksumSha1 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumSha256=" + this.checksumSha256 + AbstractJsonLexerKt.COMMA);
        sb.append("contentDisposition=" + this.contentDisposition + AbstractJsonLexerKt.COMMA);
        sb.append("contentEncoding=" + this.contentEncoding + AbstractJsonLexerKt.COMMA);
        sb.append("contentLanguage=" + this.contentLanguage + AbstractJsonLexerKt.COMMA);
        sb.append("contentLength=" + this.contentLength + AbstractJsonLexerKt.COMMA);
        sb.append("contentMd5=" + this.contentMd5 + AbstractJsonLexerKt.COMMA);
        sb.append("contentType=" + this.contentType + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("expires=" + this.expires + AbstractJsonLexerKt.COMMA);
        sb.append("grantFullControl=" + this.grantFullControl + AbstractJsonLexerKt.COMMA);
        sb.append("grantRead=" + this.grantRead + AbstractJsonLexerKt.COMMA);
        sb.append("grantReadAcp=" + this.grantReadAcp + AbstractJsonLexerKt.COMMA);
        sb.append("grantWriteAcp=" + this.grantWriteAcp + AbstractJsonLexerKt.COMMA);
        sb.append("ifMatch=" + this.ifMatch + AbstractJsonLexerKt.COMMA);
        sb.append("ifNoneMatch=" + this.ifNoneMatch + AbstractJsonLexerKt.COMMA);
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
        sb.append("websiteRedirectLocation=" + this.websiteRedirectLocation + AbstractJsonLexerKt.COMMA);
        sb.append("writeOffsetBytes=" + this.writeOffsetBytes);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        ObjectCannedAcl objectCannedAcl = this.acl;
        int iHashCode = (objectCannedAcl != null ? objectCannedAcl.hashCode() : 0) * 31;
        ByteStream byteStream = this.body;
        int iHashCode2 = (iHashCode + (byteStream != null ? byteStream.hashCode() : 0)) * 31;
        String str = this.bucket;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Boolean bool = this.bucketKeyEnabled;
        int iHashCode4 = (iHashCode3 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        String str2 = this.cacheControl;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ChecksumAlgorithm checksumAlgorithm = this.checksumAlgorithm;
        int iHashCode6 = (iHashCode5 + (checksumAlgorithm != null ? checksumAlgorithm.hashCode() : 0)) * 31;
        String str3 = this.checksumCrc32;
        int iHashCode7 = (iHashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.checksumCrc32C;
        int iHashCode8 = (iHashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.checksumCrc64Nvme;
        int iHashCode9 = (iHashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.checksumSha1;
        int iHashCode10 = (iHashCode9 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.checksumSha256;
        int iHashCode11 = (iHashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.contentDisposition;
        int iHashCode12 = (iHashCode11 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.contentEncoding;
        int iHashCode13 = (iHashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.contentLanguage;
        int iHashCode14 = (iHashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
        Long l = this.contentLength;
        int iHashCode15 = (iHashCode14 + (l != null ? Long.hashCode(l.longValue()) : 0)) * 31;
        String str11 = this.contentMd5;
        int iHashCode16 = (iHashCode15 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.contentType;
        int iHashCode17 = (iHashCode16 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.expectedBucketOwner;
        int iHashCode18 = (iHashCode17 + (str13 != null ? str13.hashCode() : 0)) * 31;
        Instant instant = this.expires;
        int iHashCode19 = (iHashCode18 + (instant != null ? instant.hashCode() : 0)) * 31;
        String str14 = this.grantFullControl;
        int iHashCode20 = (iHashCode19 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.grantRead;
        int iHashCode21 = (iHashCode20 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.grantReadAcp;
        int iHashCode22 = (iHashCode21 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.grantWriteAcp;
        int iHashCode23 = (iHashCode22 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.ifMatch;
        int iHashCode24 = (iHashCode23 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.ifNoneMatch;
        int iHashCode25 = (iHashCode24 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.key;
        int iHashCode26 = (iHashCode25 + (str20 != null ? str20.hashCode() : 0)) * 31;
        Map<String, String> map = this.metadata;
        int iHashCode27 = (iHashCode26 + (map != null ? map.hashCode() : 0)) * 31;
        ObjectLockLegalHoldStatus objectLockLegalHoldStatus = this.objectLockLegalHoldStatus;
        int iHashCode28 = (iHashCode27 + (objectLockLegalHoldStatus != null ? objectLockLegalHoldStatus.hashCode() : 0)) * 31;
        ObjectLockMode objectLockMode = this.objectLockMode;
        int iHashCode29 = (iHashCode28 + (objectLockMode != null ? objectLockMode.hashCode() : 0)) * 31;
        Instant instant2 = this.objectLockRetainUntilDate;
        int iHashCode30 = (iHashCode29 + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        RequestPayer requestPayer = this.requestPayer;
        int iHashCode31 = (iHashCode30 + (requestPayer != null ? requestPayer.hashCode() : 0)) * 31;
        ServerSideEncryption serverSideEncryption = this.serverSideEncryption;
        int iHashCode32 = (iHashCode31 + (serverSideEncryption != null ? serverSideEncryption.hashCode() : 0)) * 31;
        String str21 = this.sseCustomerAlgorithm;
        int iHashCode33 = (iHashCode32 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.sseCustomerKey;
        int iHashCode34 = (iHashCode33 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.sseCustomerKeyMd5;
        int iHashCode35 = (iHashCode34 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.ssekmsEncryptionContext;
        int iHashCode36 = (iHashCode35 + (str24 != null ? str24.hashCode() : 0)) * 31;
        String str25 = this.ssekmsKeyId;
        int iHashCode37 = (iHashCode36 + (str25 != null ? str25.hashCode() : 0)) * 31;
        StorageClass storageClass = this.storageClass;
        int iHashCode38 = (iHashCode37 + (storageClass != null ? storageClass.hashCode() : 0)) * 31;
        String str26 = this.tagging;
        int iHashCode39 = (iHashCode38 + (str26 != null ? str26.hashCode() : 0)) * 31;
        String str27 = this.websiteRedirectLocation;
        int iHashCode40 = (iHashCode39 + (str27 != null ? str27.hashCode() : 0)) * 31;
        Long l2 = this.writeOffsetBytes;
        return iHashCode40 + (l2 != null ? Long.hashCode(l2.longValue()) : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        PutObjectRequest putObjectRequest = (PutObjectRequest) other;
        return Intrinsics.areEqual(this.acl, putObjectRequest.acl) && Intrinsics.areEqual(this.body, putObjectRequest.body) && Intrinsics.areEqual(this.bucket, putObjectRequest.bucket) && Intrinsics.areEqual(this.bucketKeyEnabled, putObjectRequest.bucketKeyEnabled) && Intrinsics.areEqual(this.cacheControl, putObjectRequest.cacheControl) && Intrinsics.areEqual(this.checksumAlgorithm, putObjectRequest.checksumAlgorithm) && Intrinsics.areEqual(this.checksumCrc32, putObjectRequest.checksumCrc32) && Intrinsics.areEqual(this.checksumCrc32C, putObjectRequest.checksumCrc32C) && Intrinsics.areEqual(this.checksumCrc64Nvme, putObjectRequest.checksumCrc64Nvme) && Intrinsics.areEqual(this.checksumSha1, putObjectRequest.checksumSha1) && Intrinsics.areEqual(this.checksumSha256, putObjectRequest.checksumSha256) && Intrinsics.areEqual(this.contentDisposition, putObjectRequest.contentDisposition) && Intrinsics.areEqual(this.contentEncoding, putObjectRequest.contentEncoding) && Intrinsics.areEqual(this.contentLanguage, putObjectRequest.contentLanguage) && Intrinsics.areEqual(this.contentLength, putObjectRequest.contentLength) && Intrinsics.areEqual(this.contentMd5, putObjectRequest.contentMd5) && Intrinsics.areEqual(this.contentType, putObjectRequest.contentType) && Intrinsics.areEqual(this.expectedBucketOwner, putObjectRequest.expectedBucketOwner) && Intrinsics.areEqual(this.expires, putObjectRequest.expires) && Intrinsics.areEqual(this.grantFullControl, putObjectRequest.grantFullControl) && Intrinsics.areEqual(this.grantRead, putObjectRequest.grantRead) && Intrinsics.areEqual(this.grantReadAcp, putObjectRequest.grantReadAcp) && Intrinsics.areEqual(this.grantWriteAcp, putObjectRequest.grantWriteAcp) && Intrinsics.areEqual(this.ifMatch, putObjectRequest.ifMatch) && Intrinsics.areEqual(this.ifNoneMatch, putObjectRequest.ifNoneMatch) && Intrinsics.areEqual(this.key, putObjectRequest.key) && Intrinsics.areEqual(this.metadata, putObjectRequest.metadata) && Intrinsics.areEqual(this.objectLockLegalHoldStatus, putObjectRequest.objectLockLegalHoldStatus) && Intrinsics.areEqual(this.objectLockMode, putObjectRequest.objectLockMode) && Intrinsics.areEqual(this.objectLockRetainUntilDate, putObjectRequest.objectLockRetainUntilDate) && Intrinsics.areEqual(this.requestPayer, putObjectRequest.requestPayer) && Intrinsics.areEqual(this.serverSideEncryption, putObjectRequest.serverSideEncryption) && Intrinsics.areEqual(this.sseCustomerAlgorithm, putObjectRequest.sseCustomerAlgorithm) && Intrinsics.areEqual(this.sseCustomerKey, putObjectRequest.sseCustomerKey) && Intrinsics.areEqual(this.sseCustomerKeyMd5, putObjectRequest.sseCustomerKeyMd5) && Intrinsics.areEqual(this.ssekmsEncryptionContext, putObjectRequest.ssekmsEncryptionContext) && Intrinsics.areEqual(this.ssekmsKeyId, putObjectRequest.ssekmsKeyId) && Intrinsics.areEqual(this.storageClass, putObjectRequest.storageClass) && Intrinsics.areEqual(this.tagging, putObjectRequest.tagging) && Intrinsics.areEqual(this.websiteRedirectLocation, putObjectRequest.websiteRedirectLocation) && Intrinsics.areEqual(this.writeOffsetBytes, putObjectRequest.writeOffsetBytes);
    }

    public static /* synthetic */ PutObjectRequest copy$default(PutObjectRequest putObjectRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.PutObjectRequest.copy.1
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
        Builder builder = new Builder(putObjectRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final PutObjectRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: PutObjectRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\t\u0010«\u0001\u001a\u00020\u0005H\u0001J\u000f\u0010¬\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u00ad\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R\u001c\u0010,\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001c\u0010/\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u001c\u00102\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001c\u00105\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R\u001c\u00108\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R\u001c\u0010;\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018R\u001c\u0010>\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0016\"\u0004\b@\u0010\u0018R\u001e\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010H\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0016\"\u0004\bJ\u0010\u0018R\u001c\u0010K\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0016\"\u0004\bM\u0010\u0018R\u001c\u0010N\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0016\"\u0004\bP\u0010\u0018R\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0016\"\u0004\bY\u0010\u0018R\u001c\u0010Z\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0016\"\u0004\b\\\u0010\u0018R\u001c\u0010]\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0016\"\u0004\b_\u0010\u0018R\u001c\u0010`\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0016\"\u0004\bb\u0010\u0018R\u001c\u0010c\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0016\"\u0004\be\u0010\u0018R\u001c\u0010f\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0016\"\u0004\bh\u0010\u0018R\u001c\u0010i\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0016\"\u0004\bk\u0010\u0018R(\u0010l\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010mX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001c\u0010r\u001a\u0004\u0018\u00010sX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001c\u0010x\u001a\u0004\u0018\u00010yX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001d\u0010~\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010T\"\u0005\b\u0080\u0001\u0010VR\"\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\"\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u0016\"\u0005\b\u008f\u0001\u0010\u0018R\u001f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u0016\"\u0005\b\u0092\u0001\u0010\u0018R\u001f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0016\"\u0005\b\u0095\u0001\u0010\u0018R\u001f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0016\"\u0005\b\u0098\u0001\u0010\u0018R\u001f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010\u0016\"\u0005\b\u009b\u0001\u0010\u0018R\"\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R\u001f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010\u0016\"\u0005\b¤\u0001\u0010\u0018R\u001f\u0010¥\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010\u0016\"\u0005\b§\u0001\u0010\u0018R!\u0010¨\u0001\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b©\u0001\u0010D\"\u0005\bª\u0001\u0010F¨\u0006®\u0001"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutObjectRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/PutObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectRequest;)V", "acl", "Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", "getAcl", "()Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", "setAcl", "(Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;)V", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/content/ByteStream;", "getBody", "()Laws/smithy/kotlin/runtime/content/ByteStream;", "setBody", "(Laws/smithy/kotlin/runtime/content/ByteStream;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "setBucketKeyEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "cacheControl", "getCacheControl", "setCacheControl", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "setChecksumAlgorithm", "(Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;)V", "checksumCrc32", "getChecksumCrc32", "setChecksumCrc32", "checksumCrc32C", "getChecksumCrc32C", "setChecksumCrc32C", "checksumCrc64Nvme", "getChecksumCrc64Nvme", "setChecksumCrc64Nvme", "checksumSha1", "getChecksumSha1", "setChecksumSha1", "checksumSha256", "getChecksumSha256", "setChecksumSha256", "contentDisposition", "getContentDisposition", "setContentDisposition", "contentEncoding", "getContentEncoding", "setContentEncoding", "contentLanguage", "getContentLanguage", "setContentLanguage", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "setContentLength", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "contentMd5", "getContentMd5", "setContentMd5", "contentType", "getContentType", "setContentType", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", ClientCookie.EXPIRES_ATTR, "Laws/smithy/kotlin/runtime/time/Instant;", "getExpires", "()Laws/smithy/kotlin/runtime/time/Instant;", "setExpires", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "grantFullControl", "getGrantFullControl", "setGrantFullControl", "grantRead", "getGrantRead", "setGrantRead", "grantReadAcp", "getGrantReadAcp", "setGrantReadAcp", "grantWriteAcp", "getGrantWriteAcp", "setGrantWriteAcp", "ifMatch", "getIfMatch", "setIfMatch", "ifNoneMatch", "getIfNoneMatch", "setIfNoneMatch", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", TtmlNode.TAG_METADATA, "", "getMetadata", "()Ljava/util/Map;", "setMetadata", "(Ljava/util/Map;)V", "objectLockLegalHoldStatus", "Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "getObjectLockLegalHoldStatus", "()Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "setObjectLockLegalHoldStatus", "(Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;)V", "objectLockMode", "Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "getObjectLockMode", "()Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "setObjectLockMode", "(Laws/sdk/kotlin/services/s3/model/ObjectLockMode;)V", "objectLockRetainUntilDate", "getObjectLockRetainUntilDate", "setObjectLockRetainUntilDate", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "setRequestPayer", "(Laws/sdk/kotlin/services/s3/model/RequestPayer;)V", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "setServerSideEncryption", "(Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;)V", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "setSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "setSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "setSseCustomerKeyMd5", "ssekmsEncryptionContext", "getSsekmsEncryptionContext", "setSsekmsEncryptionContext", "ssekmsKeyId", "getSsekmsKeyId", "setSsekmsKeyId", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "setStorageClass", "(Laws/sdk/kotlin/services/s3/model/StorageClass;)V", "tagging", "getTagging", "setTagging", "websiteRedirectLocation", "getWebsiteRedirectLocation", "setWebsiteRedirectLocation", "writeOffsetBytes", "getWriteOffsetBytes", "setWriteOffsetBytes", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private ObjectCannedAcl acl;
        private ByteStream body;
        private String bucket;
        private Boolean bucketKeyEnabled;
        private String cacheControl;
        private ChecksumAlgorithm checksumAlgorithm;
        private String checksumCrc32;
        private String checksumCrc32C;
        private String checksumCrc64Nvme;
        private String checksumSha1;
        private String checksumSha256;
        private String contentDisposition;
        private String contentEncoding;
        private String contentLanguage;
        private Long contentLength;
        private String contentMd5;
        private String contentType;
        private String expectedBucketOwner;
        private Instant expires;
        private String grantFullControl;
        private String grantRead;
        private String grantReadAcp;
        private String grantWriteAcp;
        private String ifMatch;
        private String ifNoneMatch;
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
        private Long writeOffsetBytes;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final ObjectCannedAcl getAcl() {
            return this.acl;
        }

        public final void setAcl(ObjectCannedAcl objectCannedAcl) {
            this.acl = objectCannedAcl;
        }

        public final ByteStream getBody() {
            return this.body;
        }

        public final void setBody(ByteStream byteStream) {
            this.body = byteStream;
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

        public final Long getContentLength() {
            return this.contentLength;
        }

        public final void setContentLength(Long l) {
            this.contentLength = l;
        }

        public final String getContentMd5() {
            return this.contentMd5;
        }

        public final void setContentMd5(String str) {
            this.contentMd5 = str;
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

        public final Long getWriteOffsetBytes() {
            return this.writeOffsetBytes;
        }

        public final void setWriteOffsetBytes(Long l) {
            this.writeOffsetBytes = l;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(PutObjectRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.acl = x.getAcl();
            this.body = x.getBody();
            this.bucket = x.getBucket();
            this.bucketKeyEnabled = x.getBucketKeyEnabled();
            this.cacheControl = x.getCacheControl();
            this.checksumAlgorithm = x.getChecksumAlgorithm();
            this.checksumCrc32 = x.getChecksumCrc32();
            this.checksumCrc32C = x.getChecksumCrc32C();
            this.checksumCrc64Nvme = x.getChecksumCrc64Nvme();
            this.checksumSha1 = x.getChecksumSha1();
            this.checksumSha256 = x.getChecksumSha256();
            this.contentDisposition = x.getContentDisposition();
            this.contentEncoding = x.getContentEncoding();
            this.contentLanguage = x.getContentLanguage();
            this.contentLength = x.getContentLength();
            this.contentMd5 = x.getContentMd5();
            this.contentType = x.getContentType();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.expires = x.getExpires();
            this.grantFullControl = x.getGrantFullControl();
            this.grantRead = x.getGrantRead();
            this.grantReadAcp = x.getGrantReadAcp();
            this.grantWriteAcp = x.getGrantWriteAcp();
            this.ifMatch = x.getIfMatch();
            this.ifNoneMatch = x.getIfNoneMatch();
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
            this.writeOffsetBytes = x.getWriteOffsetBytes();
        }

        public final PutObjectRequest build() {
            return new PutObjectRequest(this, null);
        }
    }
}
