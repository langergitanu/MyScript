package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.WriteGetObjectResponseRequest;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.operation.HttpSerializer;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WriteGetObjectResponseOperationSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/WriteGetObjectResponseOperationSerializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$NonStreaming;", "Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest;", "<init>", "()V", "serialize", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class WriteGetObjectResponseOperationSerializer implements HttpSerializer.NonStreaming<WriteGetObjectResponseRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerializer.NonStreaming
    public HttpRequestBuilder serialize(ExecutionContext context, WriteGetObjectResponseRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.POST);
        httpRequestBuilder.getUrl().getPath().setEncoded("/WriteGetObjectResponse");
        HeadersBuilder headers = httpRequestBuilder.getHeaders();
        if (input.getAcceptRanges() != null) {
            headers.append("x-amz-fwd-header-accept-ranges", input.getAcceptRanges());
        }
        if (input.getBucketKeyEnabled() != null) {
            headers.append("x-amz-fwd-header-x-amz-server-side-encryption-bucket-key-enabled", String.valueOf(input.getBucketKeyEnabled().booleanValue()));
        }
        if (input.getCacheControl() != null) {
            headers.append("x-amz-fwd-header-Cache-Control", input.getCacheControl());
        }
        if (input.getChecksumCrc32() != null) {
            headers.append("x-amz-fwd-header-x-amz-checksum-crc32", input.getChecksumCrc32());
        }
        if (input.getChecksumCrc32C() != null) {
            headers.append("x-amz-fwd-header-x-amz-checksum-crc32c", input.getChecksumCrc32C());
        }
        if (input.getChecksumCrc64Nvme() != null) {
            headers.append("x-amz-fwd-header-x-amz-checksum-crc64nvme", input.getChecksumCrc64Nvme());
        }
        if (input.getChecksumSha1() != null) {
            headers.append("x-amz-fwd-header-x-amz-checksum-sha1", input.getChecksumSha1());
        }
        if (input.getChecksumSha256() != null) {
            headers.append("x-amz-fwd-header-x-amz-checksum-sha256", input.getChecksumSha256());
        }
        if (input.getContentDisposition() != null) {
            headers.append("x-amz-fwd-header-Content-Disposition", input.getContentDisposition());
        }
        if (input.getContentEncoding() != null) {
            headers.append("x-amz-fwd-header-Content-Encoding", input.getContentEncoding());
        }
        if (input.getContentLanguage() != null) {
            headers.append("x-amz-fwd-header-Content-Language", input.getContentLanguage());
        }
        if (input.getContentLength() != null) {
            headers.append("Content-Length", String.valueOf(input.getContentLength().longValue()));
        }
        if (input.getContentRange() != null) {
            headers.append("x-amz-fwd-header-Content-Range", input.getContentRange());
        }
        if (input.getContentType() != null) {
            headers.append("x-amz-fwd-header-Content-Type", input.getContentType());
        }
        if (input.getDeleteMarker() != null) {
            headers.append("x-amz-fwd-header-x-amz-delete-marker", String.valueOf(input.getDeleteMarker().booleanValue()));
        }
        if (input.getETag() != null) {
            headers.append("x-amz-fwd-header-ETag", input.getETag());
        }
        if (input.getErrorCode() != null) {
            headers.append("x-amz-fwd-error-code", input.getErrorCode());
        }
        if (input.getErrorMessage() != null) {
            headers.append("x-amz-fwd-error-message", input.getErrorMessage());
        }
        if (input.getExpiration() != null) {
            headers.append("x-amz-fwd-header-x-amz-expiration", input.getExpiration());
        }
        if (input.getExpires() != null) {
            headers.append("x-amz-fwd-header-Expires", input.getExpires().format(TimestampFormat.RFC_5322));
        }
        if (input.getLastModified() != null) {
            headers.append("x-amz-fwd-header-Last-Modified", input.getLastModified().format(TimestampFormat.RFC_5322));
        }
        if (input.getMissingMeta() != null) {
            headers.append("x-amz-fwd-header-x-amz-missing-meta", String.valueOf(input.getMissingMeta().intValue()));
        }
        if (input.getObjectLockLegalHoldStatus() != null) {
            headers.append("x-amz-fwd-header-x-amz-object-lock-legal-hold", input.getObjectLockLegalHoldStatus().getValue());
        }
        if (input.getObjectLockMode() != null) {
            headers.append("x-amz-fwd-header-x-amz-object-lock-mode", input.getObjectLockMode().getValue());
        }
        if (input.getObjectLockRetainUntilDate() != null) {
            headers.append("x-amz-fwd-header-x-amz-object-lock-retain-until-date", input.getObjectLockRetainUntilDate().format(TimestampFormat.ISO_8601));
        }
        if (input.getPartsCount() != null) {
            headers.append("x-amz-fwd-header-x-amz-mp-parts-count", String.valueOf(input.getPartsCount().intValue()));
        }
        if (input.getReplicationStatus() != null) {
            headers.append("x-amz-fwd-header-x-amz-replication-status", input.getReplicationStatus().getValue());
        }
        if (input.getRequestCharged() != null) {
            headers.append("x-amz-fwd-header-x-amz-request-charged", input.getRequestCharged().getValue());
        }
        if (input.getRequestRoute() != null) {
            headers.append("x-amz-request-route", input.getRequestRoute());
        }
        if (input.getRequestToken() != null) {
            headers.append("x-amz-request-token", input.getRequestToken());
        }
        if (input.getRestore() != null) {
            headers.append("x-amz-fwd-header-x-amz-restore", input.getRestore());
        }
        if (input.getSseCustomerAlgorithm() != null) {
            headers.append("x-amz-fwd-header-x-amz-server-side-encryption-customer-algorithm", input.getSseCustomerAlgorithm());
        }
        if (input.getSseCustomerKeyMd5() != null) {
            headers.append("x-amz-fwd-header-x-amz-server-side-encryption-customer-key-MD5", input.getSseCustomerKeyMd5());
        }
        if (input.getSsekmsKeyId() != null) {
            headers.append("x-amz-fwd-header-x-amz-server-side-encryption-aws-kms-key-id", input.getSsekmsKeyId());
        }
        if (input.getServerSideEncryption() != null) {
            headers.append("x-amz-fwd-header-x-amz-server-side-encryption", input.getServerSideEncryption().getValue());
        }
        if (input.getStatusCode() != null) {
            headers.append("x-amz-fwd-status", String.valueOf(input.getStatusCode().intValue()));
        }
        if (input.getStorageClass() != null) {
            headers.append("x-amz-fwd-header-x-amz-storage-class", input.getStorageClass().getValue());
        }
        if (input.getTagCount() != null) {
            headers.append("x-amz-fwd-header-x-amz-tagging-count", String.valueOf(input.getTagCount().intValue()));
        }
        if (input.getVersionId() != null) {
            headers.append("x-amz-fwd-header-x-amz-version-id", input.getVersionId());
        }
        Map<String, String> metadata = input.getMetadata();
        if (metadata != null) {
            for (Map.Entry<String, String> entry : metadata.entrySet()) {
                headers.append("x-amz-meta-" + entry.getKey(), entry.getValue());
            }
        }
        if (input.getBody() != null) {
            httpRequestBuilder.setBody(HttpBodyKt.toHttpBody(input.getBody()));
        }
        if (!(httpRequestBuilder.getBody() instanceof HttpBody.Empty)) {
            httpRequestBuilder.getHeaders().setMissing("Content-Type", "application/octet-stream");
        }
        return httpRequestBuilder;
    }
}
