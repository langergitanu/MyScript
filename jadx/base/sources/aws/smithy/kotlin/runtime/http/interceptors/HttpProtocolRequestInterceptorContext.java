package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterceptorExecutor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u00020\u0017HÖ\u0081\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u00020\u001aHÖ\u0081\u0004¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR\"\u0010\u0005\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010\u000f¨\u0006%"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/HttpProtocolRequestInterceptorContext;", "I", "Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "request", "protocolRequest", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "executionContext", "<init>", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/operation/ExecutionContext;)V", "component1", "()Ljava/lang/Object;", "component2", "()Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "component3", "()Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "copy", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Laws/smithy/kotlin/runtime/http/interceptors/HttpProtocolRequestInterceptorContext;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getRequest", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "getProtocolRequest", "setProtocolRequest", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;)V", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getExecutionContext", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class HttpProtocolRequestInterceptorContext<I> implements ProtocolRequestInterceptorContext<I, HttpRequest> {
    private final ExecutionContext executionContext;
    private HttpRequest protocolRequest;
    private final I request;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpProtocolRequestInterceptorContext copy$default(HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext, Object obj, HttpRequest httpRequest, ExecutionContext executionContext, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = httpProtocolRequestInterceptorContext.request;
        }
        if ((i & 2) != 0) {
            httpRequest = httpProtocolRequestInterceptorContext.protocolRequest;
        }
        if ((i & 4) != 0) {
            executionContext = httpProtocolRequestInterceptorContext.executionContext;
        }
        return httpProtocolRequestInterceptorContext.copy(obj, httpRequest, executionContext);
    }

    public final I component1() {
        return this.request;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HttpRequest getProtocolRequest() {
        return this.protocolRequest;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ExecutionContext getExecutionContext() {
        return this.executionContext;
    }

    public final HttpProtocolRequestInterceptorContext<I> copy(I request, HttpRequest protocolRequest, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(protocolRequest, "protocolRequest");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        return new HttpProtocolRequestInterceptorContext<>(request, protocolRequest, executionContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpProtocolRequestInterceptorContext)) {
            return false;
        }
        HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext = (HttpProtocolRequestInterceptorContext) other;
        return Intrinsics.areEqual(this.request, httpProtocolRequestInterceptorContext.request) && Intrinsics.areEqual(this.protocolRequest, httpProtocolRequestInterceptorContext.protocolRequest) && Intrinsics.areEqual(this.executionContext, httpProtocolRequestInterceptorContext.executionContext);
    }

    public int hashCode() {
        I i = this.request;
        return ((((i == null ? 0 : i.hashCode()) * 31) + this.protocolRequest.hashCode()) * 31) + this.executionContext.hashCode();
    }

    public String toString() {
        return "HttpProtocolRequestInterceptorContext(request=" + this.request + ", protocolRequest=" + this.protocolRequest + ", executionContext=" + this.executionContext + ')';
    }

    public HttpProtocolRequestInterceptorContext(I i, HttpRequest protocolRequest, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(protocolRequest, "protocolRequest");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        this.request = i;
        this.protocolRequest = protocolRequest;
        this.executionContext = executionContext;
    }

    @Override // aws.smithy.kotlin.runtime.client.RequestInterceptorContext
    public I getRequest() {
        return this.request;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext
    public HttpRequest getProtocolRequest() {
        return this.protocolRequest;
    }

    public void setProtocolRequest(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<set-?>");
        this.protocolRequest = httpRequest;
    }

    @Override // aws.smithy.kotlin.runtime.client.RequestInterceptorContext
    public ExecutionContext getExecutionContext() {
        return this.executionContext;
    }
}
