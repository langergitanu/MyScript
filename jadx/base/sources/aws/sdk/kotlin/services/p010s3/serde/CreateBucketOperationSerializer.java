package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.CreateBucketRequest;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.operation.HttpSerializer;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateBucketOperationSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/CreateBucketOperationSerializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$NonStreaming;", "Laws/sdk/kotlin/services/s3/model/CreateBucketRequest;", "<init>", "()V", "serialize", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateBucketOperationSerializer implements HttpSerializer.NonStreaming<CreateBucketRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerializer.NonStreaming
    public HttpRequestBuilder serialize(ExecutionContext context, CreateBucketRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.PUT);
        httpRequestBuilder.getUrl().getPath().setTrailingSlash(true);
        HeadersBuilder headers = httpRequestBuilder.getHeaders();
        if (input.getAcl() != null) {
            headers.append("x-amz-acl", input.getAcl().getValue());
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
        if (input.getGrantWrite() != null) {
            headers.append("x-amz-grant-write", input.getGrantWrite());
        }
        if (input.getGrantWriteAcp() != null) {
            headers.append("x-amz-grant-write-acp", input.getGrantWriteAcp());
        }
        if (input.getObjectLockEnabledForBucket() != null) {
            headers.append("x-amz-bucket-object-lock-enabled", String.valueOf(input.getObjectLockEnabledForBucket().booleanValue()));
        }
        if (input.getObjectOwnership() != null) {
            headers.append("x-amz-object-ownership", input.getObjectOwnership().getValue());
        }
        if (input.getCreateBucketConfiguration() != null) {
            httpRequestBuilder.setBody(HttpBody.INSTANCE.fromBytes(CreateBucketConfigurationPayloadSerializerKt.m478xc8bb6f52(input.getCreateBucketConfiguration())));
        }
        if (!(httpRequestBuilder.getBody() instanceof HttpBody.Empty)) {
            httpRequestBuilder.getHeaders().setMissing("Content-Type", "application/xml");
        }
        return httpRequestBuilder;
    }
}
