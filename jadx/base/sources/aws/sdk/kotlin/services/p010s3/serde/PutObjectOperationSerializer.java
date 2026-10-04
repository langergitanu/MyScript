package aws.sdk.kotlin.services.p010s3.serde;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import aws.sdk.kotlin.services.p010s3.model.PutObjectRequest;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.operation.HttpSerializer;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import com.google.common.net.HttpHeaders;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PutObjectOperationSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/PutObjectOperationSerializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$NonStreaming;", "Laws/sdk/kotlin/services/s3/model/PutObjectRequest;", "<init>", "()V", "serialize", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PutObjectOperationSerializer implements HttpSerializer.NonStreaming<PutObjectRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerializer.NonStreaming
    public HttpRequestBuilder serialize(ExecutionContext context, final PutObjectRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.PUT);
        Url.Builder url = httpRequestBuilder.getUrl();
        if (input.getKey() == null) {
            throw new IllegalArgumentException("key is bound to the URI and must not be null".toString());
        }
        url.getPath().encodedSegments(new Function1() { // from class: aws.sdk.kotlin.services.s3.serde.PutObjectOperationSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PutObjectOperationSerializer.serialize$lambda$0$1(input, (List) obj);
            }
        });
        url.getParameters().getDecodedParameters().add("x-id", "PutObject");
        HeadersBuilder headers = httpRequestBuilder.getHeaders();
        if (input.getAcl() != null) {
            headers.append("x-amz-acl", input.getAcl().getValue());
        }
        if (input.getBucketKeyEnabled() != null) {
            headers.append("x-amz-server-side-encryption-bucket-key-enabled", String.valueOf(input.getBucketKeyEnabled().booleanValue()));
        }
        if (input.getCacheControl() != null) {
            headers.append("Cache-Control", input.getCacheControl());
        }
        if (input.getChecksumAlgorithm() != null) {
            headers.append("x-amz-sdk-checksum-algorithm", input.getChecksumAlgorithm().getValue());
        }
        if (input.getChecksumCrc32() != null) {
            headers.append("x-amz-checksum-crc32", input.getChecksumCrc32());
        }
        if (input.getChecksumCrc32C() != null) {
            headers.append("x-amz-checksum-crc32c", input.getChecksumCrc32C());
        }
        if (input.getChecksumCrc64Nvme() != null) {
            headers.append("x-amz-checksum-crc64nvme", input.getChecksumCrc64Nvme());
        }
        if (input.getChecksumSha1() != null) {
            headers.append("x-amz-checksum-sha1", input.getChecksumSha1());
        }
        if (input.getChecksumSha256() != null) {
            headers.append("x-amz-checksum-sha256", input.getChecksumSha256());
        }
        if (input.getContentDisposition() != null) {
            headers.append(HttpHeaders.CONTENT_DISPOSITION, input.getContentDisposition());
        }
        if (input.getContentEncoding() != null) {
            headers.append("Content-Encoding", input.getContentEncoding());
        }
        if (input.getContentLanguage() != null) {
            headers.append("Content-Language", input.getContentLanguage());
        }
        if (input.getContentLength() != null) {
            headers.append("Content-Length", String.valueOf(input.getContentLength().longValue()));
        }
        if (input.getContentMd5() != null) {
            headers.append("Content-MD5", input.getContentMd5());
        }
        if (input.getContentType() != null) {
            headers.append("Content-Type", input.getContentType());
        }
        if (input.getExpectedBucketOwner() != null) {
            headers.append("x-amz-expected-bucket-owner", input.getExpectedBucketOwner());
        }
        if (input.getExpires() != null) {
            headers.append("Expires", input.getExpires().format(TimestampFormat.RFC_5322));
        }
        if (input.getGrantFullControl() != null) {
            headers.append("x-amz-grant-full-control", input.getGrantFullControl());
        }
        if (input.getGrantRead() != null) {
            headers.append("x-amz-grant-read", input.getGrantRead());
        }
        if (input.getGrantReadAcp() != null) {
            headers.append("x-amz-grant-read-acp", input.getGrantReadAcp());
        }
        if (input.getGrantWriteAcp() != null) {
            headers.append("x-amz-grant-write-acp", input.getGrantWriteAcp());
        }
        if (input.getIfMatch() != null) {
            headers.append("If-Match", input.getIfMatch());
        }
        if (input.getIfNoneMatch() != null) {
            headers.append("If-None-Match", input.getIfNoneMatch());
        }
        if (input.getObjectLockLegalHoldStatus() != null) {
            headers.append("x-amz-object-lock-legal-hold", input.getObjectLockLegalHoldStatus().getValue());
        }
        if (input.getObjectLockMode() != null) {
            headers.append("x-amz-object-lock-mode", input.getObjectLockMode().getValue());
        }
        if (input.getObjectLockRetainUntilDate() != null) {
            headers.append("x-amz-object-lock-retain-until-date", input.getObjectLockRetainUntilDate().format(TimestampFormat.ISO_8601));
        }
        if (input.getRequestPayer() != null) {
            headers.append("x-amz-request-payer", input.getRequestPayer().getValue());
        }
        if (input.getSseCustomerAlgorithm() != null) {
            headers.append("x-amz-server-side-encryption-customer-algorithm", input.getSseCustomerAlgorithm());
        }
        if (input.getSseCustomerKey() != null) {
            headers.append("x-amz-server-side-encryption-customer-key", input.getSseCustomerKey());
        }
        if (input.getSseCustomerKeyMd5() != null) {
            headers.append("x-amz-server-side-encryption-customer-key-MD5", input.getSseCustomerKeyMd5());
        }
        if (input.getSsekmsEncryptionContext() != null) {
            headers.append("x-amz-server-side-encryption-context", input.getSsekmsEncryptionContext());
        }
        if (input.getSsekmsKeyId() != null) {
            headers.append("x-amz-server-side-encryption-aws-kms-key-id", input.getSsekmsKeyId());
        }
        if (input.getServerSideEncryption() != null) {
            headers.append("x-amz-server-side-encryption", input.getServerSideEncryption().getValue());
        }
        if (input.getStorageClass() != null) {
            headers.append("x-amz-storage-class", input.getStorageClass().getValue());
        }
        if (input.getTagging() != null) {
            headers.append("x-amz-tagging", input.getTagging());
        }
        if (input.getWebsiteRedirectLocation() != null) {
            headers.append("x-amz-website-redirect-location", input.getWebsiteRedirectLocation());
        }
        if (input.getWriteOffsetBytes() != null) {
            headers.append("x-amz-write-offset-bytes", String.valueOf(input.getWriteOffsetBytes().longValue()));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serialize$lambda$0$1(PutObjectRequest putObjectRequest, List encodedSegments) {
        Intrinsics.checkNotNullParameter(encodedSegments, "$this$encodedSegments");
        List list = encodedSegments;
        Iterator it = StringsKt.split$default((CharSequence) putObjectRequest.getKey(), new String[]{DomExceptionUtils.SEPARATOR}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            list.add(PercentEncoding.INSTANCE.getSmithyLabel().encode((String) it.next()));
        }
        return Unit.INSTANCE;
    }
}
