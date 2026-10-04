package aws.sdk.kotlin.services.p010s3.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.content.ByteStream;
import aws.smithy.kotlin.runtime.time.Instant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: WriteGetObjectResponseRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ~2\u00020\u0001:\u0002~\u007fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010u\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010v\u001a\u00020CH\u0096\u0080\u0004J\u0014\u0010w\u001a\u00020\u000f2\b\u0010x\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010y\u001a\u00020\u00002\u0019\b\u0002\u0010z\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020|0{¢\u0006\u0002\b}H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\tR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\tR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\tR\u0013\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\tR\u0013\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\tR\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0013\u0010*\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\tR\u0013\u0010,\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\tR\u0015\u0010.\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b/\u0010\u0011R\u0013\u00100\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\tR\u0013\u00102\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\tR\u0013\u00104\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\tR\u0013\u00106\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\tR\u0013\u00108\u001a\u0004\u0018\u000109¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010<\u001a\u0004\u0018\u000109¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R\u001f\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0015\u0010B\u001a\u0004\u0018\u00010C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bD\u0010ER\u0013\u0010G\u001a\u0004\u0018\u00010H¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010K\u001a\u0004\u0018\u00010L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010O\u001a\u0004\u0018\u000109¢\u0006\b\n\u0000\u001a\u0004\bP\u0010;R\u0015\u0010Q\u001a\u0004\u0018\u00010C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bR\u0010ER\u0013\u0010S\u001a\u0004\u0018\u00010T¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010W\u001a\u0004\u0018\u00010X¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0013\u0010[\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\tR\u0013\u0010]\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\tR\u0013\u0010_\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\tR\u0013\u0010a\u001a\u0004\u0018\u00010b¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0013\u0010e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\tR\u0013\u0010g\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bh\u0010\tR\u0013\u0010i\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\tR\u0015\u0010k\u001a\u0004\u0018\u00010C¢\u0006\n\n\u0002\u0010F\u001a\u0004\bl\u0010ER\u0013\u0010m\u001a\u0004\u0018\u00010n¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0015\u0010q\u001a\u0004\u0018\u00010C¢\u0006\n\n\u0002\u0010F\u001a\u0004\br\u0010ER\u0013\u0010s\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bt\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0080\u0001"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest$Builder;)V", "acceptRanges", "", "getAcceptRanges", "()Ljava/lang/String;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/content/ByteStream;", "getBody", "()Laws/smithy/kotlin/runtime/content/ByteStream;", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "cacheControl", "getCacheControl", "checksumCrc32", "getChecksumCrc32", "checksumCrc32C", "getChecksumCrc32C", "checksumCrc64Nvme", "getChecksumCrc64Nvme", "checksumSha1", "getChecksumSha1", "checksumSha256", "getChecksumSha256", "contentDisposition", "getContentDisposition", "contentEncoding", "getContentEncoding", "contentLanguage", "getContentLanguage", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "contentRange", "getContentRange", "contentType", "getContentType", "deleteMarker", "getDeleteMarker", "eTag", "getETag", "errorCode", "getErrorCode", "errorMessage", "getErrorMessage", "expiration", "getExpiration", ClientCookie.EXPIRES_ATTR, "Laws/smithy/kotlin/runtime/time/Instant;", "getExpires", "()Laws/smithy/kotlin/runtime/time/Instant;", "lastModified", "getLastModified", TtmlNode.TAG_METADATA, "", "getMetadata", "()Ljava/util/Map;", "missingMeta", "", "getMissingMeta", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "objectLockLegalHoldStatus", "Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "getObjectLockLegalHoldStatus", "()Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "objectLockMode", "Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "getObjectLockMode", "()Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "objectLockRetainUntilDate", "getObjectLockRetainUntilDate", "partsCount", "getPartsCount", "replicationStatus", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "getReplicationStatus", "()Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "requestRoute", "getRequestRoute", "requestToken", "getRequestToken", "restore", "getRestore", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "ssekmsKeyId", "getSsekmsKeyId", "statusCode", "getStatusCode", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "tagCount", "getTagCount", "versionId", "getVersionId", "toString", "hashCode", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class WriteGetObjectResponseRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String acceptRanges;
    private final ByteStream body;
    private final Boolean bucketKeyEnabled;
    private final String cacheControl;
    private final String checksumCrc32;
    private final String checksumCrc32C;
    private final String checksumCrc64Nvme;
    private final String checksumSha1;
    private final String checksumSha256;
    private final String contentDisposition;
    private final String contentEncoding;
    private final String contentLanguage;
    private final Long contentLength;
    private final String contentRange;
    private final String contentType;
    private final Boolean deleteMarker;
    private final String eTag;
    private final String errorCode;
    private final String errorMessage;
    private final String expiration;
    private final Instant expires;
    private final Instant lastModified;
    private final Map<String, String> metadata;
    private final Integer missingMeta;
    private final ObjectLockLegalHoldStatus objectLockLegalHoldStatus;
    private final ObjectLockMode objectLockMode;
    private final Instant objectLockRetainUntilDate;
    private final Integer partsCount;
    private final ReplicationStatus replicationStatus;
    private final RequestCharged requestCharged;
    private final String requestRoute;
    private final String requestToken;
    private final String restore;
    private final ServerSideEncryption serverSideEncryption;
    private final String sseCustomerAlgorithm;
    private final String sseCustomerKeyMd5;
    private final String ssekmsKeyId;
    private final Integer statusCode;
    private final StorageClass storageClass;
    private final Integer tagCount;
    private final String versionId;

    public /* synthetic */ WriteGetObjectResponseRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private WriteGetObjectResponseRequest(Builder builder) {
        this.acceptRanges = builder.getAcceptRanges();
        this.body = builder.getBody();
        this.bucketKeyEnabled = builder.getBucketKeyEnabled();
        this.cacheControl = builder.getCacheControl();
        this.checksumCrc32 = builder.getChecksumCrc32();
        this.checksumCrc32C = builder.getChecksumCrc32C();
        this.checksumCrc64Nvme = builder.getChecksumCrc64Nvme();
        this.checksumSha1 = builder.getChecksumSha1();
        this.checksumSha256 = builder.getChecksumSha256();
        this.contentDisposition = builder.getContentDisposition();
        this.contentEncoding = builder.getContentEncoding();
        this.contentLanguage = builder.getContentLanguage();
        this.contentLength = builder.getContentLength();
        this.contentRange = builder.getContentRange();
        this.contentType = builder.getContentType();
        this.deleteMarker = builder.getDeleteMarker();
        this.eTag = builder.getETag();
        this.errorCode = builder.getErrorCode();
        this.errorMessage = builder.getErrorMessage();
        this.expiration = builder.getExpiration();
        this.expires = builder.getExpires();
        this.lastModified = builder.getLastModified();
        this.metadata = builder.getMetadata();
        this.missingMeta = builder.getMissingMeta();
        this.objectLockLegalHoldStatus = builder.getObjectLockLegalHoldStatus();
        this.objectLockMode = builder.getObjectLockMode();
        this.objectLockRetainUntilDate = builder.getObjectLockRetainUntilDate();
        this.partsCount = builder.getPartsCount();
        this.replicationStatus = builder.getReplicationStatus();
        this.requestCharged = builder.getRequestCharged();
        this.requestRoute = builder.getRequestRoute();
        this.requestToken = builder.getRequestToken();
        this.restore = builder.getRestore();
        this.serverSideEncryption = builder.getServerSideEncryption();
        this.sseCustomerAlgorithm = builder.getSseCustomerAlgorithm();
        this.sseCustomerKeyMd5 = builder.getSseCustomerKeyMd5();
        this.ssekmsKeyId = builder.getSsekmsKeyId();
        this.statusCode = builder.getStatusCode();
        this.storageClass = builder.getStorageClass();
        this.tagCount = builder.getTagCount();
        this.versionId = builder.getVersionId();
    }

    public final String getAcceptRanges() {
        return this.acceptRanges;
    }

    public final ByteStream getBody() {
        return this.body;
    }

    public final Boolean getBucketKeyEnabled() {
        return this.bucketKeyEnabled;
    }

    public final String getCacheControl() {
        return this.cacheControl;
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

    public final String getContentRange() {
        return this.contentRange;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final Boolean getDeleteMarker() {
        return this.deleteMarker;
    }

    public final String getETag() {
        return this.eTag;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getExpiration() {
        return this.expiration;
    }

    public final Instant getExpires() {
        return this.expires;
    }

    public final Instant getLastModified() {
        return this.lastModified;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final Integer getMissingMeta() {
        return this.missingMeta;
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

    public final Integer getPartsCount() {
        return this.partsCount;
    }

    public final ReplicationStatus getReplicationStatus() {
        return this.replicationStatus;
    }

    public final RequestCharged getRequestCharged() {
        return this.requestCharged;
    }

    public final String getRequestRoute() {
        return this.requestRoute;
    }

    public final String getRequestToken() {
        return this.requestToken;
    }

    public final String getRestore() {
        return this.restore;
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

    public final String getSsekmsKeyId() {
        return this.ssekmsKeyId;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final StorageClass getStorageClass() {
        return this.storageClass;
    }

    public final Integer getTagCount() {
        return this.tagCount;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    /* JADX INFO: compiled from: WriteGetObjectResponseRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WriteGetObjectResponseRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WriteGetObjectResponseRequest(");
        sb.append("acceptRanges=" + this.acceptRanges + AbstractJsonLexerKt.COMMA);
        sb.append("body=" + this.body + AbstractJsonLexerKt.COMMA);
        sb.append("bucketKeyEnabled=" + this.bucketKeyEnabled + AbstractJsonLexerKt.COMMA);
        sb.append("cacheControl=" + this.cacheControl + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc32=" + this.checksumCrc32 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc32C=" + this.checksumCrc32C + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc64Nvme=" + this.checksumCrc64Nvme + AbstractJsonLexerKt.COMMA);
        sb.append("checksumSha1=" + this.checksumSha1 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumSha256=" + this.checksumSha256 + AbstractJsonLexerKt.COMMA);
        sb.append("contentDisposition=" + this.contentDisposition + AbstractJsonLexerKt.COMMA);
        sb.append("contentEncoding=" + this.contentEncoding + AbstractJsonLexerKt.COMMA);
        sb.append("contentLanguage=" + this.contentLanguage + AbstractJsonLexerKt.COMMA);
        sb.append("contentLength=" + this.contentLength + AbstractJsonLexerKt.COMMA);
        sb.append("contentRange=" + this.contentRange + AbstractJsonLexerKt.COMMA);
        sb.append("contentType=" + this.contentType + AbstractJsonLexerKt.COMMA);
        sb.append("deleteMarker=" + this.deleteMarker + AbstractJsonLexerKt.COMMA);
        sb.append("eTag=" + this.eTag + AbstractJsonLexerKt.COMMA);
        sb.append("errorCode=" + this.errorCode + AbstractJsonLexerKt.COMMA);
        sb.append("errorMessage=" + this.errorMessage + AbstractJsonLexerKt.COMMA);
        sb.append("expiration=" + this.expiration + AbstractJsonLexerKt.COMMA);
        sb.append("expires=" + this.expires + AbstractJsonLexerKt.COMMA);
        sb.append("lastModified=" + this.lastModified + AbstractJsonLexerKt.COMMA);
        sb.append("metadata=" + this.metadata + AbstractJsonLexerKt.COMMA);
        sb.append("missingMeta=" + this.missingMeta + AbstractJsonLexerKt.COMMA);
        sb.append("objectLockLegalHoldStatus=" + this.objectLockLegalHoldStatus + AbstractJsonLexerKt.COMMA);
        sb.append("objectLockMode=" + this.objectLockMode + AbstractJsonLexerKt.COMMA);
        sb.append("objectLockRetainUntilDate=" + this.objectLockRetainUntilDate + AbstractJsonLexerKt.COMMA);
        sb.append("partsCount=" + this.partsCount + AbstractJsonLexerKt.COMMA);
        sb.append("replicationStatus=" + this.replicationStatus + AbstractJsonLexerKt.COMMA);
        sb.append("requestCharged=" + this.requestCharged + AbstractJsonLexerKt.COMMA);
        sb.append("requestRoute=" + this.requestRoute + AbstractJsonLexerKt.COMMA);
        sb.append("requestToken=" + this.requestToken + AbstractJsonLexerKt.COMMA);
        sb.append("restore=" + this.restore + AbstractJsonLexerKt.COMMA);
        sb.append("serverSideEncryption=" + this.serverSideEncryption + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerAlgorithm=" + this.sseCustomerAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerKeyMd5=" + this.sseCustomerKeyMd5 + AbstractJsonLexerKt.COMMA);
        sb.append("ssekmsKeyId=*** Sensitive Data Redacted ***,");
        sb.append("statusCode=" + this.statusCode + AbstractJsonLexerKt.COMMA);
        sb.append("storageClass=" + this.storageClass + AbstractJsonLexerKt.COMMA);
        sb.append("tagCount=" + this.tagCount + AbstractJsonLexerKt.COMMA);
        sb.append("versionId=" + this.versionId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.acceptRanges;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ByteStream byteStream = this.body;
        int iHashCode2 = (iHashCode + (byteStream != null ? byteStream.hashCode() : 0)) * 31;
        Boolean bool = this.bucketKeyEnabled;
        int iHashCode3 = (iHashCode2 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        String str2 = this.cacheControl;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.checksumCrc32;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.checksumCrc32C;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.checksumCrc64Nvme;
        int iHashCode7 = (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.checksumSha1;
        int iHashCode8 = (iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.checksumSha256;
        int iHashCode9 = (iHashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.contentDisposition;
        int iHashCode10 = (iHashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.contentEncoding;
        int iHashCode11 = (iHashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.contentLanguage;
        int iHashCode12 = (iHashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        Long l = this.contentLength;
        int iHashCode13 = (iHashCode12 + (l != null ? Long.hashCode(l.longValue()) : 0)) * 31;
        String str11 = this.contentRange;
        int iHashCode14 = (iHashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.contentType;
        int iHashCode15 = (iHashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
        Boolean bool2 = this.deleteMarker;
        int iHashCode16 = (iHashCode15 + (bool2 != null ? Boolean.hashCode(bool2.booleanValue()) : 0)) * 31;
        String str13 = this.eTag;
        int iHashCode17 = (iHashCode16 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.errorCode;
        int iHashCode18 = (iHashCode17 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.errorMessage;
        int iHashCode19 = (iHashCode18 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.expiration;
        int iHashCode20 = (iHashCode19 + (str16 != null ? str16.hashCode() : 0)) * 31;
        Instant instant = this.expires;
        int iHashCode21 = (iHashCode20 + (instant != null ? instant.hashCode() : 0)) * 31;
        Instant instant2 = this.lastModified;
        int iHashCode22 = (iHashCode21 + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        Map<String, String> map = this.metadata;
        int iHashCode23 = (iHashCode22 + (map != null ? map.hashCode() : 0)) * 31;
        Integer num = this.missingMeta;
        int iIntValue = (iHashCode23 + (num != null ? num.intValue() : 0)) * 31;
        ObjectLockLegalHoldStatus objectLockLegalHoldStatus = this.objectLockLegalHoldStatus;
        int iHashCode24 = (iIntValue + (objectLockLegalHoldStatus != null ? objectLockLegalHoldStatus.hashCode() : 0)) * 31;
        ObjectLockMode objectLockMode = this.objectLockMode;
        int iHashCode25 = (iHashCode24 + (objectLockMode != null ? objectLockMode.hashCode() : 0)) * 31;
        Instant instant3 = this.objectLockRetainUntilDate;
        int iHashCode26 = (iHashCode25 + (instant3 != null ? instant3.hashCode() : 0)) * 31;
        Integer num2 = this.partsCount;
        int iIntValue2 = (iHashCode26 + (num2 != null ? num2.intValue() : 0)) * 31;
        ReplicationStatus replicationStatus = this.replicationStatus;
        int iHashCode27 = (iIntValue2 + (replicationStatus != null ? replicationStatus.hashCode() : 0)) * 31;
        RequestCharged requestCharged = this.requestCharged;
        int iHashCode28 = (iHashCode27 + (requestCharged != null ? requestCharged.hashCode() : 0)) * 31;
        String str17 = this.requestRoute;
        int iHashCode29 = (iHashCode28 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.requestToken;
        int iHashCode30 = (iHashCode29 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.restore;
        int iHashCode31 = (iHashCode30 + (str19 != null ? str19.hashCode() : 0)) * 31;
        ServerSideEncryption serverSideEncryption = this.serverSideEncryption;
        int iHashCode32 = (iHashCode31 + (serverSideEncryption != null ? serverSideEncryption.hashCode() : 0)) * 31;
        String str20 = this.sseCustomerAlgorithm;
        int iHashCode33 = (iHashCode32 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.sseCustomerKeyMd5;
        int iHashCode34 = (iHashCode33 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.ssekmsKeyId;
        int iHashCode35 = (iHashCode34 + (str22 != null ? str22.hashCode() : 0)) * 31;
        Integer num3 = this.statusCode;
        int iIntValue3 = (iHashCode35 + (num3 != null ? num3.intValue() : 0)) * 31;
        StorageClass storageClass = this.storageClass;
        int iHashCode36 = (iIntValue3 + (storageClass != null ? storageClass.hashCode() : 0)) * 31;
        Integer num4 = this.tagCount;
        int iIntValue4 = (iHashCode36 + (num4 != null ? num4.intValue() : 0)) * 31;
        String str23 = this.versionId;
        return iIntValue4 + (str23 != null ? str23.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        WriteGetObjectResponseRequest writeGetObjectResponseRequest = (WriteGetObjectResponseRequest) other;
        return Intrinsics.areEqual(this.acceptRanges, writeGetObjectResponseRequest.acceptRanges) && Intrinsics.areEqual(this.body, writeGetObjectResponseRequest.body) && Intrinsics.areEqual(this.bucketKeyEnabled, writeGetObjectResponseRequest.bucketKeyEnabled) && Intrinsics.areEqual(this.cacheControl, writeGetObjectResponseRequest.cacheControl) && Intrinsics.areEqual(this.checksumCrc32, writeGetObjectResponseRequest.checksumCrc32) && Intrinsics.areEqual(this.checksumCrc32C, writeGetObjectResponseRequest.checksumCrc32C) && Intrinsics.areEqual(this.checksumCrc64Nvme, writeGetObjectResponseRequest.checksumCrc64Nvme) && Intrinsics.areEqual(this.checksumSha1, writeGetObjectResponseRequest.checksumSha1) && Intrinsics.areEqual(this.checksumSha256, writeGetObjectResponseRequest.checksumSha256) && Intrinsics.areEqual(this.contentDisposition, writeGetObjectResponseRequest.contentDisposition) && Intrinsics.areEqual(this.contentEncoding, writeGetObjectResponseRequest.contentEncoding) && Intrinsics.areEqual(this.contentLanguage, writeGetObjectResponseRequest.contentLanguage) && Intrinsics.areEqual(this.contentLength, writeGetObjectResponseRequest.contentLength) && Intrinsics.areEqual(this.contentRange, writeGetObjectResponseRequest.contentRange) && Intrinsics.areEqual(this.contentType, writeGetObjectResponseRequest.contentType) && Intrinsics.areEqual(this.deleteMarker, writeGetObjectResponseRequest.deleteMarker) && Intrinsics.areEqual(this.eTag, writeGetObjectResponseRequest.eTag) && Intrinsics.areEqual(this.errorCode, writeGetObjectResponseRequest.errorCode) && Intrinsics.areEqual(this.errorMessage, writeGetObjectResponseRequest.errorMessage) && Intrinsics.areEqual(this.expiration, writeGetObjectResponseRequest.expiration) && Intrinsics.areEqual(this.expires, writeGetObjectResponseRequest.expires) && Intrinsics.areEqual(this.lastModified, writeGetObjectResponseRequest.lastModified) && Intrinsics.areEqual(this.metadata, writeGetObjectResponseRequest.metadata) && Intrinsics.areEqual(this.missingMeta, writeGetObjectResponseRequest.missingMeta) && Intrinsics.areEqual(this.objectLockLegalHoldStatus, writeGetObjectResponseRequest.objectLockLegalHoldStatus) && Intrinsics.areEqual(this.objectLockMode, writeGetObjectResponseRequest.objectLockMode) && Intrinsics.areEqual(this.objectLockRetainUntilDate, writeGetObjectResponseRequest.objectLockRetainUntilDate) && Intrinsics.areEqual(this.partsCount, writeGetObjectResponseRequest.partsCount) && Intrinsics.areEqual(this.replicationStatus, writeGetObjectResponseRequest.replicationStatus) && Intrinsics.areEqual(this.requestCharged, writeGetObjectResponseRequest.requestCharged) && Intrinsics.areEqual(this.requestRoute, writeGetObjectResponseRequest.requestRoute) && Intrinsics.areEqual(this.requestToken, writeGetObjectResponseRequest.requestToken) && Intrinsics.areEqual(this.restore, writeGetObjectResponseRequest.restore) && Intrinsics.areEqual(this.serverSideEncryption, writeGetObjectResponseRequest.serverSideEncryption) && Intrinsics.areEqual(this.sseCustomerAlgorithm, writeGetObjectResponseRequest.sseCustomerAlgorithm) && Intrinsics.areEqual(this.sseCustomerKeyMd5, writeGetObjectResponseRequest.sseCustomerKeyMd5) && Intrinsics.areEqual(this.ssekmsKeyId, writeGetObjectResponseRequest.ssekmsKeyId) && Intrinsics.areEqual(this.statusCode, writeGetObjectResponseRequest.statusCode) && Intrinsics.areEqual(this.storageClass, writeGetObjectResponseRequest.storageClass) && Intrinsics.areEqual(this.tagCount, writeGetObjectResponseRequest.tagCount) && Intrinsics.areEqual(this.versionId, writeGetObjectResponseRequest.versionId);
    }

    public static /* synthetic */ WriteGetObjectResponseRequest copy$default(WriteGetObjectResponseRequest writeGetObjectResponseRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.WriteGetObjectResponseRequest.copy.1
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
        Builder builder = new Builder(writeGetObjectResponseRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final WriteGetObjectResponseRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: WriteGetObjectResponseRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\t\u0010¬\u0001\u001a\u00020\u0005H\u0001J\u000f\u0010\u00ad\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b®\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR\u001c\u0010 \u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001c\u0010#\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\fR\u001c\u0010&\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\n\"\u0004\b(\u0010\fR\u001c\u0010)\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010\fR\u001c\u0010,\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\fR\u001c\u0010/\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\n\"\u0004\b1\u0010\fR\u001c\u00102\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\n\"\u0004\b4\u0010\fR\u001e\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010<\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\n\"\u0004\b>\u0010\fR\u001c\u0010?\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\n\"\u0004\bA\u0010\fR\u001e\u0010B\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\bC\u0010\u0016\"\u0004\bD\u0010\u0018R\u001c\u0010E\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\n\"\u0004\bG\u0010\fR\u001c\u0010H\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\n\"\u0004\bJ\u0010\fR\u001c\u0010K\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\n\"\u0004\bM\u0010\fR\u001c\u0010N\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\n\"\u0004\bP\u0010\fR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010T\"\u0004\bY\u0010VR(\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010[X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001e\u0010`\u001a\u0004\u0018\u00010aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010f\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001c\u0010g\u001a\u0004\u0018\u00010hX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001c\u0010m\u001a\u0004\u0018\u00010nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001c\u0010s\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010T\"\u0004\bu\u0010VR\u001e\u0010v\u001a\u0004\u0018\u00010aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010f\u001a\u0004\bw\u0010c\"\u0004\bx\u0010eR\u001c\u0010y\u001a\u0004\u0018\u00010zX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R!\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\n\"\u0005\b\u0087\u0001\u0010\fR\u001f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010\n\"\u0005\b\u008a\u0001\u0010\fR\u001f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\n\"\u0005\b\u008d\u0001\u0010\fR\"\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\n\"\u0005\b\u0096\u0001\u0010\fR\u001f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\n\"\u0005\b\u0099\u0001\u0010\fR\u001f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010\n\"\u0005\b\u009c\u0001\u0010\fR!\u0010\u009d\u0001\u001a\u0004\u0018\u00010aX\u0086\u000e¢\u0006\u0012\n\u0002\u0010f\u001a\u0005\b\u009e\u0001\u0010c\"\u0005\b\u009f\u0001\u0010eR\"\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R!\u0010¦\u0001\u001a\u0004\u0018\u00010aX\u0086\u000e¢\u0006\u0012\n\u0002\u0010f\u001a\u0005\b§\u0001\u0010c\"\u0005\b¨\u0001\u0010eR\u001f\u0010©\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010\n\"\u0005\b«\u0001\u0010\f¨\u0006¯\u0001"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest;", "(Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest;)V", "acceptRanges", "", "getAcceptRanges", "()Ljava/lang/String;", "setAcceptRanges", "(Ljava/lang/String;)V", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/content/ByteStream;", "getBody", "()Laws/smithy/kotlin/runtime/content/ByteStream;", "setBody", "(Laws/smithy/kotlin/runtime/content/ByteStream;)V", "bucketKeyEnabled", "", "getBucketKeyEnabled", "()Ljava/lang/Boolean;", "setBucketKeyEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "cacheControl", "getCacheControl", "setCacheControl", "checksumCrc32", "getChecksumCrc32", "setChecksumCrc32", "checksumCrc32C", "getChecksumCrc32C", "setChecksumCrc32C", "checksumCrc64Nvme", "getChecksumCrc64Nvme", "setChecksumCrc64Nvme", "checksumSha1", "getChecksumSha1", "setChecksumSha1", "checksumSha256", "getChecksumSha256", "setChecksumSha256", "contentDisposition", "getContentDisposition", "setContentDisposition", "contentEncoding", "getContentEncoding", "setContentEncoding", "contentLanguage", "getContentLanguage", "setContentLanguage", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "setContentLength", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "contentRange", "getContentRange", "setContentRange", "contentType", "getContentType", "setContentType", "deleteMarker", "getDeleteMarker", "setDeleteMarker", "eTag", "getETag", "setETag", "errorCode", "getErrorCode", "setErrorCode", "errorMessage", "getErrorMessage", "setErrorMessage", "expiration", "getExpiration", "setExpiration", ClientCookie.EXPIRES_ATTR, "Laws/smithy/kotlin/runtime/time/Instant;", "getExpires", "()Laws/smithy/kotlin/runtime/time/Instant;", "setExpires", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "lastModified", "getLastModified", "setLastModified", TtmlNode.TAG_METADATA, "", "getMetadata", "()Ljava/util/Map;", "setMetadata", "(Ljava/util/Map;)V", "missingMeta", "", "getMissingMeta", "()Ljava/lang/Integer;", "setMissingMeta", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "objectLockLegalHoldStatus", "Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "getObjectLockLegalHoldStatus", "()Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;", "setObjectLockLegalHoldStatus", "(Laws/sdk/kotlin/services/s3/model/ObjectLockLegalHoldStatus;)V", "objectLockMode", "Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "getObjectLockMode", "()Laws/sdk/kotlin/services/s3/model/ObjectLockMode;", "setObjectLockMode", "(Laws/sdk/kotlin/services/s3/model/ObjectLockMode;)V", "objectLockRetainUntilDate", "getObjectLockRetainUntilDate", "setObjectLockRetainUntilDate", "partsCount", "getPartsCount", "setPartsCount", "replicationStatus", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "getReplicationStatus", "()Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "setReplicationStatus", "(Laws/sdk/kotlin/services/s3/model/ReplicationStatus;)V", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "setRequestCharged", "(Laws/sdk/kotlin/services/s3/model/RequestCharged;)V", "requestRoute", "getRequestRoute", "setRequestRoute", "requestToken", "getRequestToken", "setRequestToken", "restore", "getRestore", "setRestore", "serverSideEncryption", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getServerSideEncryption", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "setServerSideEncryption", "(Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;)V", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "setSseCustomerAlgorithm", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "setSseCustomerKeyMd5", "ssekmsKeyId", "getSsekmsKeyId", "setSsekmsKeyId", "statusCode", "getStatusCode", "setStatusCode", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "setStorageClass", "(Laws/sdk/kotlin/services/s3/model/StorageClass;)V", "tagCount", "getTagCount", "setTagCount", "versionId", "getVersionId", "setVersionId", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String acceptRanges;
        private ByteStream body;
        private Boolean bucketKeyEnabled;
        private String cacheControl;
        private String checksumCrc32;
        private String checksumCrc32C;
        private String checksumCrc64Nvme;
        private String checksumSha1;
        private String checksumSha256;
        private String contentDisposition;
        private String contentEncoding;
        private String contentLanguage;
        private Long contentLength;
        private String contentRange;
        private String contentType;
        private Boolean deleteMarker;
        private String eTag;
        private String errorCode;
        private String errorMessage;
        private String expiration;
        private Instant expires;
        private Instant lastModified;
        private Map<String, String> metadata;
        private Integer missingMeta;
        private ObjectLockLegalHoldStatus objectLockLegalHoldStatus;
        private ObjectLockMode objectLockMode;
        private Instant objectLockRetainUntilDate;
        private Integer partsCount;
        private ReplicationStatus replicationStatus;
        private RequestCharged requestCharged;
        private String requestRoute;
        private String requestToken;
        private String restore;
        private ServerSideEncryption serverSideEncryption;
        private String sseCustomerAlgorithm;
        private String sseCustomerKeyMd5;
        private String ssekmsKeyId;
        private Integer statusCode;
        private StorageClass storageClass;
        private Integer tagCount;
        private String versionId;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getAcceptRanges() {
            return this.acceptRanges;
        }

        public final void setAcceptRanges(String str) {
            this.acceptRanges = str;
        }

        public final ByteStream getBody() {
            return this.body;
        }

        public final void setBody(ByteStream byteStream) {
            this.body = byteStream;
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

        public final String getContentRange() {
            return this.contentRange;
        }

        public final void setContentRange(String str) {
            this.contentRange = str;
        }

        public final String getContentType() {
            return this.contentType;
        }

        public final void setContentType(String str) {
            this.contentType = str;
        }

        public final Boolean getDeleteMarker() {
            return this.deleteMarker;
        }

        public final void setDeleteMarker(Boolean bool) {
            this.deleteMarker = bool;
        }

        public final String getETag() {
            return this.eTag;
        }

        public final void setETag(String str) {
            this.eTag = str;
        }

        public final String getErrorCode() {
            return this.errorCode;
        }

        public final void setErrorCode(String str) {
            this.errorCode = str;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final void setErrorMessage(String str) {
            this.errorMessage = str;
        }

        public final String getExpiration() {
            return this.expiration;
        }

        public final void setExpiration(String str) {
            this.expiration = str;
        }

        public final Instant getExpires() {
            return this.expires;
        }

        public final void setExpires(Instant instant) {
            this.expires = instant;
        }

        public final Instant getLastModified() {
            return this.lastModified;
        }

        public final void setLastModified(Instant instant) {
            this.lastModified = instant;
        }

        public final Map<String, String> getMetadata() {
            return this.metadata;
        }

        public final void setMetadata(Map<String, String> map) {
            this.metadata = map;
        }

        public final Integer getMissingMeta() {
            return this.missingMeta;
        }

        public final void setMissingMeta(Integer num) {
            this.missingMeta = num;
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

        public final Integer getPartsCount() {
            return this.partsCount;
        }

        public final void setPartsCount(Integer num) {
            this.partsCount = num;
        }

        public final ReplicationStatus getReplicationStatus() {
            return this.replicationStatus;
        }

        public final void setReplicationStatus(ReplicationStatus replicationStatus) {
            this.replicationStatus = replicationStatus;
        }

        public final RequestCharged getRequestCharged() {
            return this.requestCharged;
        }

        public final void setRequestCharged(RequestCharged requestCharged) {
            this.requestCharged = requestCharged;
        }

        public final String getRequestRoute() {
            return this.requestRoute;
        }

        public final void setRequestRoute(String str) {
            this.requestRoute = str;
        }

        public final String getRequestToken() {
            return this.requestToken;
        }

        public final void setRequestToken(String str) {
            this.requestToken = str;
        }

        public final String getRestore() {
            return this.restore;
        }

        public final void setRestore(String str) {
            this.restore = str;
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

        public final String getSsekmsKeyId() {
            return this.ssekmsKeyId;
        }

        public final void setSsekmsKeyId(String str) {
            this.ssekmsKeyId = str;
        }

        public final Integer getStatusCode() {
            return this.statusCode;
        }

        public final void setStatusCode(Integer num) {
            this.statusCode = num;
        }

        public final StorageClass getStorageClass() {
            return this.storageClass;
        }

        public final void setStorageClass(StorageClass storageClass) {
            this.storageClass = storageClass;
        }

        public final Integer getTagCount() {
            return this.tagCount;
        }

        public final void setTagCount(Integer num) {
            this.tagCount = num;
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
        public Builder(WriteGetObjectResponseRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.acceptRanges = x.getAcceptRanges();
            this.body = x.getBody();
            this.bucketKeyEnabled = x.getBucketKeyEnabled();
            this.cacheControl = x.getCacheControl();
            this.checksumCrc32 = x.getChecksumCrc32();
            this.checksumCrc32C = x.getChecksumCrc32C();
            this.checksumCrc64Nvme = x.getChecksumCrc64Nvme();
            this.checksumSha1 = x.getChecksumSha1();
            this.checksumSha256 = x.getChecksumSha256();
            this.contentDisposition = x.getContentDisposition();
            this.contentEncoding = x.getContentEncoding();
            this.contentLanguage = x.getContentLanguage();
            this.contentLength = x.getContentLength();
            this.contentRange = x.getContentRange();
            this.contentType = x.getContentType();
            this.deleteMarker = x.getDeleteMarker();
            this.eTag = x.getETag();
            this.errorCode = x.getErrorCode();
            this.errorMessage = x.getErrorMessage();
            this.expiration = x.getExpiration();
            this.expires = x.getExpires();
            this.lastModified = x.getLastModified();
            this.metadata = x.getMetadata();
            this.missingMeta = x.getMissingMeta();
            this.objectLockLegalHoldStatus = x.getObjectLockLegalHoldStatus();
            this.objectLockMode = x.getObjectLockMode();
            this.objectLockRetainUntilDate = x.getObjectLockRetainUntilDate();
            this.partsCount = x.getPartsCount();
            this.replicationStatus = x.getReplicationStatus();
            this.requestCharged = x.getRequestCharged();
            this.requestRoute = x.getRequestRoute();
            this.requestToken = x.getRequestToken();
            this.restore = x.getRestore();
            this.serverSideEncryption = x.getServerSideEncryption();
            this.sseCustomerAlgorithm = x.getSseCustomerAlgorithm();
            this.sseCustomerKeyMd5 = x.getSseCustomerKeyMd5();
            this.ssekmsKeyId = x.getSsekmsKeyId();
            this.statusCode = x.getStatusCode();
            this.storageClass = x.getStorageClass();
            this.tagCount = x.getTagCount();
            this.versionId = x.getVersionId();
        }

        public final WriteGetObjectResponseRequest build() {
            return new WriteGetObjectResponseRequest(this, null);
        }
    }
}
