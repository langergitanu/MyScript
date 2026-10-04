package aws.sdk.kotlin.runtime.http.middleware;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.http.AwsUserAgentMetadata;
import aws.sdk.kotlin.runtime.http.operation.CustomUserAgentMetadata;
import aws.smithy.kotlin.runtime.http.operation.ModifyRequestMiddleware;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.p011io.middleware.Phase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserAgent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tH\u0016J*\u0010\n\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r2\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rH\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/middleware/UserAgent;", "Laws/smithy/kotlin/runtime/http/operation/ModifyRequestMiddleware;", "staticMetadata", "Laws/sdk/kotlin/runtime/http/AwsUserAgentMetadata;", "<init>", "(Laws/sdk/kotlin/runtime/http/AwsUserAgentMetadata;)V", "install", "", "op", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "modifyRequest", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "req", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final class UserAgent implements ModifyRequestMiddleware {
    private final AwsUserAgentMetadata staticMetadata;

    public UserAgent(AwsUserAgentMetadata staticMetadata) {
        Intrinsics.checkNotNullParameter(staticMetadata, "staticMetadata");
        this.staticMetadata = staticMetadata;
    }

    @Override // aws.smithy.kotlin.runtime.http.operation.ModifyRequestMiddleware
    public void install(SdkHttpOperation<?, ?> op) {
        Intrinsics.checkNotNullParameter(op, "op");
        op.getExecution().getMutate().register(this, Phase.Order.After);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.middleware.ModifyRequest
    public Object modifyRequest(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super OperationRequest<HttpRequestBuilder>> continuation) {
        AwsUserAgentMetadata awsUserAgentMetadataCopy$default;
        CustomUserAgentMetadata customUserAgentMetadata = (CustomUserAgentMetadata) operationRequest.getContext().getOrNull(CustomUserAgentMetadata.INSTANCE.getContextKey());
        if (customUserAgentMetadata == null) {
            awsUserAgentMetadataCopy$default = this.staticMetadata;
        } else if (this.staticMetadata.getCustomMetadata() == null) {
            awsUserAgentMetadataCopy$default = AwsUserAgentMetadata.copy$default(this.staticMetadata, null, null, null, null, null, null, null, customUserAgentMetadata, 127, null);
        } else {
            AwsUserAgentMetadata awsUserAgentMetadata = this.staticMetadata;
            awsUserAgentMetadataCopy$default = AwsUserAgentMetadata.copy$default(awsUserAgentMetadata, null, null, null, null, null, null, null, awsUserAgentMetadata.getCustomMetadata().plus(customUserAgentMetadata), 127, null);
        }
        operationRequest.getSubject().getHeaders().set("User-Agent", awsUserAgentMetadataCopy$default.getXAmzUserAgent());
        operationRequest.getSubject().getHeaders().set(UserAgentKt.X_AMZ_USER_AGENT, awsUserAgentMetadataCopy$default.getUserAgent());
        return operationRequest;
    }
}
