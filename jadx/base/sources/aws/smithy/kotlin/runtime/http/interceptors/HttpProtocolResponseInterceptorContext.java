package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterceptorExecutor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B'\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J>\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001c\u001a\u00020\u001bHÖ\u0081\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001f\u001a\u00020\u001eHÖ\u0081\u0004¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0005\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\rR\u001a\u0010\u0006\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010\u000fR\"\u0010\u0007\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010(R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010\u0013¨\u0006+"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/HttpProtocolResponseInterceptorContext;", "I", "Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "request", "protocolRequest", "protocolResponse", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "executionContext", "<init>", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/http/response/HttpResponse;Laws/smithy/kotlin/runtime/operation/ExecutionContext;)V", "component1", "()Ljava/lang/Object;", "component2", "()Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "component3", "()Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "component4", "()Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "copy", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/http/response/HttpResponse;Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Laws/smithy/kotlin/runtime/http/interceptors/HttpProtocolResponseInterceptorContext;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getRequest", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "getProtocolRequest", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "getProtocolResponse", "setProtocolResponse", "(Laws/smithy/kotlin/runtime/http/response/HttpResponse;)V", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getExecutionContext", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class HttpProtocolResponseInterceptorContext<I> implements ProtocolResponseInterceptorContext<I, HttpRequest, HttpResponse> {
    private final ExecutionContext executionContext;
    private final HttpRequest protocolRequest;
    private HttpResponse protocolResponse;
    private final I request;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpProtocolResponseInterceptorContext copy$default(HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext, Object obj, HttpRequest httpRequest, HttpResponse httpResponse, ExecutionContext executionContext, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = httpProtocolResponseInterceptorContext.request;
        }
        if ((i & 2) != 0) {
            httpRequest = httpProtocolResponseInterceptorContext.protocolRequest;
        }
        if ((i & 4) != 0) {
            httpResponse = httpProtocolResponseInterceptorContext.protocolResponse;
        }
        if ((i & 8) != 0) {
            executionContext = httpProtocolResponseInterceptorContext.executionContext;
        }
        return httpProtocolResponseInterceptorContext.copy(obj, httpRequest, httpResponse, executionContext);
    }

    public final I component1() {
        return this.request;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HttpRequest getProtocolRequest() {
        return this.protocolRequest;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HttpResponse getProtocolResponse() {
        return this.protocolResponse;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ExecutionContext getExecutionContext() {
        return this.executionContext;
    }

    public final HttpProtocolResponseInterceptorContext<I> copy(I request, HttpRequest protocolRequest, HttpResponse protocolResponse, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(protocolRequest, "protocolRequest");
        Intrinsics.checkNotNullParameter(protocolResponse, "protocolResponse");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        return new HttpProtocolResponseInterceptorContext<>(request, protocolRequest, protocolResponse, executionContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpProtocolResponseInterceptorContext)) {
            return false;
        }
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext = (HttpProtocolResponseInterceptorContext) other;
        return Intrinsics.areEqual(this.request, httpProtocolResponseInterceptorContext.request) && Intrinsics.areEqual(this.protocolRequest, httpProtocolResponseInterceptorContext.protocolRequest) && Intrinsics.areEqual(this.protocolResponse, httpProtocolResponseInterceptorContext.protocolResponse) && Intrinsics.areEqual(this.executionContext, httpProtocolResponseInterceptorContext.executionContext);
    }

    public int hashCode() {
        I i = this.request;
        return ((((((i == null ? 0 : i.hashCode()) * 31) + this.protocolRequest.hashCode()) * 31) + this.protocolResponse.hashCode()) * 31) + this.executionContext.hashCode();
    }

    public String toString() {
        return "HttpProtocolResponseInterceptorContext(request=" + this.request + ", protocolRequest=" + this.protocolRequest + ", protocolResponse=" + this.protocolResponse + ", executionContext=" + this.executionContext + ')';
    }

    public HttpProtocolResponseInterceptorContext(I i, HttpRequest protocolRequest, HttpResponse protocolResponse, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(protocolRequest, "protocolRequest");
        Intrinsics.checkNotNullParameter(protocolResponse, "protocolResponse");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        this.request = i;
        this.protocolRequest = protocolRequest;
        this.protocolResponse = protocolResponse;
        this.executionContext = executionContext;
    }

    @Override // aws.smithy.kotlin.runtime.client.RequestInterceptorContext
    public I getRequest() {
        return this.request;
    }

    @Override // aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext
    public HttpRequest getProtocolRequest() {
        return this.protocolRequest;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext
    public HttpResponse getProtocolResponse() {
        return this.protocolResponse;
    }

    public void setProtocolResponse(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<set-?>");
        this.protocolResponse = httpResponse;
    }

    @Override // aws.smithy.kotlin.runtime.client.RequestInterceptorContext
    public ExecutionContext getExecutionContext() {
        return this.executionContext;
    }
}
