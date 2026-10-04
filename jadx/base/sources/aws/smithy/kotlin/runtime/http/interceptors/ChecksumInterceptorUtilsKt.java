package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.hashing.HashFunctionKt;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: ChecksumInterceptorUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a+\u0010\u0006\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"&\u0010\u000b\u001a\u0004\u0018\u00010\b*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "checksumAlgorithm", "calculateAwsChunkedStreamingChecksum", "(Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;Laws/smithy/kotlin/runtime/hashing/HashFunction;)Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "", "getDefaultChecksumAlgorithmName", "(Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;)Ljava/lang/String;", "defaultChecksumAlgorithmName", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ChecksumInterceptorUtilsKt {
    public static final HttpRequest calculateAwsChunkedStreamingChecksum(ProtocolRequestInterceptorContext<Object, HttpRequest> context, HashFunction checksumAlgorithm) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(checksumAlgorithm, "checksumAlgorithm");
        HttpRequestBuilder builder = HttpRequestKt.toBuilder(context.getProtocolRequest());
        CompletableDeferred CompletableDeferred = CompletableDeferredKt.CompletableDeferred(JobKt.getJob(context.getExecutionContext().getCoroutineContext()));
        String strResolveChecksumAlgorithmHeaderName = HashFunctionKt.resolveChecksumAlgorithmHeaderName(checksumAlgorithm);
        builder.setBody(HttpBodyKt.toCompletingBody(HttpBodyKt.toHashingBody(builder.getBody(), checksumAlgorithm, builder.getBody().getContentLength()), CompletableDeferred));
        builder.getHeaders().append("x-amz-trailer", strResolveChecksumAlgorithmHeaderName);
        builder.getTrailingHeaders().append(strResolveChecksumAlgorithmHeaderName, CompletableDeferred);
        BusinessMetricsUtilsKt.emitBusinessMetric(context.getExecutionContext(), HashFunctionKt.toBusinessMetric(checksumAlgorithm));
        return builder.build();
    }

    public static final String getDefaultChecksumAlgorithmName(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        Intrinsics.checkNotNullParameter(protocolRequestInterceptorContext, "<this>");
        return (String) protocolRequestInterceptorContext.getExecutionContext().getOrNull(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm());
    }
}
