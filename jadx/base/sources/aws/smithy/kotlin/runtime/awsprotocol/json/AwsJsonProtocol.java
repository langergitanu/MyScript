package aws.smithy.kotlin.runtime.awsprotocol.json;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.operation.ModifyRequestMiddleware;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AwsJsonProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\n2\u0010\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\nH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/json/AwsJsonProtocol;", "Laws/smithy/kotlin/runtime/http/operation/ModifyRequestMiddleware;", "serviceShapeName", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "modifyRequest", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "req", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-json-protocols"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsJsonProtocol implements ModifyRequestMiddleware {
    private final String serviceShapeName;
    private final String version;

    public AwsJsonProtocol(String serviceShapeName, String version) {
        Intrinsics.checkNotNullParameter(serviceShapeName, "serviceShapeName");
        Intrinsics.checkNotNullParameter(version, "version");
        this.serviceShapeName = serviceShapeName;
        this.version = version;
    }

    @Override // aws.smithy.kotlin.runtime.http.operation.ModifyRequestMiddleware
    @InternalApi
    public /* bridge */ void install(SdkHttpOperation<?, ?> sdkHttpOperation) {
        super.install(sdkHttpOperation);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.middleware.ModifyRequest
    public Object modifyRequest(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super OperationRequest<HttpRequestBuilder>> continuation) {
        operationRequest.getSubject().getHeaders().append("X-Amz-Target", this.serviceShapeName + '.' + ((String) AttributesKt.get(operationRequest.getContext(), SdkClientOption.INSTANCE.getOperationName())));
        operationRequest.getSubject().getHeaders().setMissing("Content-Type", "application/x-amz-json-" + this.version);
        if (operationRequest.getSubject().getBody() instanceof HttpBody.Empty) {
            operationRequest.getSubject().setBody(HttpBody.INSTANCE.fromBytes(StringsKt.encodeToByteArray("{}")));
        }
        return operationRequest;
    }
}
