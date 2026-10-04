package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.p011io.middleware.Phase;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import aws.smithy.kotlin.runtime.retries.policy.StandardRetryPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkOperationExecution.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R)\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR-\u0010\u000e\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\r\u0012\u0004\u0012\u00028\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR-\u0010\u0010\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\r\u0012\u0004\u0012\u00028\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR-\u0010\u0013\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\r\u0012\u0004\u0012\u00020\u00120\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/SdkOperationExecution;", "Request", "Response", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/io/middleware/Phase;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "initialize", "Laws/smithy/kotlin/runtime/io/middleware/Phase;", "getInitialize", "()Laws/smithy/kotlin/runtime/io/middleware/Phase;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "mutate", "getMutate", "onEachAttempt", "getOnEachAttempt", "Laws/smithy/kotlin/runtime/http/HttpCall;", "receive", "getReceive", "Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;", "auth", "Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;", "getAuth", "()Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;", "setAuth", "(Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;)V", "Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;", "endpointResolver", "Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;", "getEndpointResolver", "()Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;", "setEndpointResolver", "(Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;)V", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "retryStrategy", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "getRetryStrategy", "()Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "setRetryStrategy", "(Laws/smithy/kotlin/runtime/retries/RetryStrategy;)V", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "retryPolicy", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "getRetryPolicy", "()Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "setRetryPolicy", "(Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;)V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkOperationExecution<Request, Response> {
    private EndpointResolver endpointResolver;
    private final Phase<OperationRequest<Request>, Response> initialize = new Phase<>();
    private final Phase<OperationRequest<HttpRequestBuilder>, Response> mutate = new Phase<>();
    private final Phase<OperationRequest<HttpRequestBuilder>, Response> onEachAttempt = new Phase<>();
    private final Phase<OperationRequest<HttpRequestBuilder>, HttpCall> receive = new Phase<>();
    private OperationAuthConfig auth = OperationAuthConfig.INSTANCE.getAnonymous();
    private RetryStrategy retryStrategy = new StandardRetryStrategy(null, 1, 0 == true ? 1 : 0);
    private RetryPolicy<? super Response> retryPolicy = StandardRetryPolicy.INSTANCE.getDefault();

    public final Phase<OperationRequest<Request>, Response> getInitialize() {
        return this.initialize;
    }

    public final Phase<OperationRequest<HttpRequestBuilder>, Response> getMutate() {
        return this.mutate;
    }

    public final Phase<OperationRequest<HttpRequestBuilder>, Response> getOnEachAttempt() {
        return this.onEachAttempt;
    }

    public final Phase<OperationRequest<HttpRequestBuilder>, HttpCall> getReceive() {
        return this.receive;
    }

    public final OperationAuthConfig getAuth() {
        return this.auth;
    }

    public final void setAuth(OperationAuthConfig operationAuthConfig) {
        Intrinsics.checkNotNullParameter(operationAuthConfig, "<set-?>");
        this.auth = operationAuthConfig;
    }

    public final EndpointResolver getEndpointResolver() {
        return this.endpointResolver;
    }

    public final void setEndpointResolver(EndpointResolver endpointResolver) {
        this.endpointResolver = endpointResolver;
    }

    public final RetryStrategy getRetryStrategy() {
        return this.retryStrategy;
    }

    public final void setRetryStrategy(RetryStrategy retryStrategy) {
        Intrinsics.checkNotNullParameter(retryStrategy, "<set-?>");
        this.retryStrategy = retryStrategy;
    }

    public final RetryPolicy<Response> getRetryPolicy() {
        return this.retryPolicy;
    }

    public final void setRetryPolicy(RetryPolicy<? super Response> retryPolicy) {
        Intrinsics.checkNotNullParameter(retryPolicy, "<set-?>");
        this.retryPolicy = retryPolicy;
    }
}
