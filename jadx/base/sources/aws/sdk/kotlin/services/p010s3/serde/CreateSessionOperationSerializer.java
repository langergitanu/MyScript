package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.CreateSessionRequest;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.operation.HttpSerializer;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateSessionOperationSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/CreateSessionOperationSerializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$NonStreaming;", "Laws/sdk/kotlin/services/s3/model/CreateSessionRequest;", "<init>", "()V", "serialize", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateSessionOperationSerializer implements HttpSerializer.NonStreaming<CreateSessionRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerializer.NonStreaming
    public HttpRequestBuilder serialize(ExecutionContext context, CreateSessionRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.GET);
        Url.Builder url = httpRequestBuilder.getUrl();
        url.getPath().setTrailingSlash(true);
        url.getParameters().getDecodedParameters().add("session", "");
        HeadersBuilder headers = httpRequestBuilder.getHeaders();
        if (input.getBucketKeyEnabled() != null) {
            headers.append("x-amz-server-side-encryption-bucket-key-enabled", String.valueOf(input.getBucketKeyEnabled().booleanValue()));
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
        if (input.getSessionMode() != null) {
            headers.append("x-amz-create-session-mode", input.getSessionMode().getValue());
        }
        return httpRequestBuilder;
    }
}
