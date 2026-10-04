package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.client.ResponseInterceptorContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterceptorExecutor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003B7\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018JV\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0083\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u00020 HÖ\u0081\u0004¢\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001a\u00020#HÖ\u0081\u0004¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0006\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010\u0010R(\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010&\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010*R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b,\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010-\u001a\u0004\b.\u0010\u0016R\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b0\u0010\u0018¨\u00061"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/HttpAttemptInterceptorContext;", "I", "O", "Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "request", "Lkotlin/Result;", "response", "protocolRequest", "protocolResponse", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "executionContext", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/http/response/HttpResponse;Laws/smithy/kotlin/runtime/operation/ExecutionContext;)V", "component1", "()Ljava/lang/Object;", "component2-d1pmJ48", "component2", "component3", "()Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "component4", "()Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "component5", "()Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/http/response/HttpResponse;Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Laws/smithy/kotlin/runtime/http/interceptors/HttpAttemptInterceptorContext;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getRequest", "getResponse-d1pmJ48", "setResponse", "(Ljava/lang/Object;)V", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "getProtocolRequest", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "getProtocolResponse", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getExecutionContext", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class HttpAttemptInterceptorContext<I, O> implements ResponseInterceptorContext<I, O, HttpRequest, HttpResponse> {
    private final ExecutionContext executionContext;
    private final HttpRequest protocolRequest;
    private final HttpResponse protocolResponse;
    private final I request;
    private Object response;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpAttemptInterceptorContext copy$default(HttpAttemptInterceptorContext httpAttemptInterceptorContext, Object obj, Result result, HttpRequest httpRequest, HttpResponse httpResponse, ExecutionContext executionContext, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = httpAttemptInterceptorContext.request;
        }
        if ((i & 2) != 0) {
            result = Result.m14498boximpl(httpAttemptInterceptorContext.response);
        }
        if ((i & 4) != 0) {
            httpRequest = httpAttemptInterceptorContext.protocolRequest;
        }
        if ((i & 8) != 0) {
            httpResponse = httpAttemptInterceptorContext.protocolResponse;
        }
        if ((i & 16) != 0) {
            executionContext = httpAttemptInterceptorContext.executionContext;
        }
        return httpAttemptInterceptorContext.copy(obj, result.getValue(), httpRequest, httpResponse, executionContext);
    }

    public final I component1() {
        return this.request;
    }

    /* JADX INFO: renamed from: component2-d1pmJ48, reason: not valid java name and from getter */
    public final Object getResponse() {
        return this.response;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HttpRequest getProtocolRequest() {
        return this.protocolRequest;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final HttpResponse getProtocolResponse() {
        return this.protocolResponse;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ExecutionContext getExecutionContext() {
        return this.executionContext;
    }

    public final HttpAttemptInterceptorContext<I, O> copy(I request, Object response, HttpRequest protocolRequest, HttpResponse protocolResponse, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(protocolRequest, "protocolRequest");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        return new HttpAttemptInterceptorContext<>(request, response, protocolRequest, protocolResponse, executionContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpAttemptInterceptorContext)) {
            return false;
        }
        HttpAttemptInterceptorContext httpAttemptInterceptorContext = (HttpAttemptInterceptorContext) other;
        return Intrinsics.areEqual(this.request, httpAttemptInterceptorContext.request) && Result.m14501equalsimpl0(this.response, httpAttemptInterceptorContext.response) && Intrinsics.areEqual(this.protocolRequest, httpAttemptInterceptorContext.protocolRequest) && Intrinsics.areEqual(this.protocolResponse, httpAttemptInterceptorContext.protocolResponse) && Intrinsics.areEqual(this.executionContext, httpAttemptInterceptorContext.executionContext);
    }

    public int hashCode() {
        I i = this.request;
        int iHashCode = (((((i == null ? 0 : i.hashCode()) * 31) + Result.m14504hashCodeimpl(this.response)) * 31) + this.protocolRequest.hashCode()) * 31;
        HttpResponse httpResponse = this.protocolResponse;
        return ((iHashCode + (httpResponse != null ? httpResponse.hashCode() : 0)) * 31) + this.executionContext.hashCode();
    }

    public String toString() {
        return "HttpAttemptInterceptorContext(request=" + this.request + ", response=" + ((Object) Result.m14507toStringimpl(this.response)) + ", protocolRequest=" + this.protocolRequest + ", protocolResponse=" + this.protocolResponse + ", executionContext=" + this.executionContext + ')';
    }

    public HttpAttemptInterceptorContext(I i, Object obj, HttpRequest protocolRequest, HttpResponse httpResponse, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(protocolRequest, "protocolRequest");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        this.request = i;
        this.response = obj;
        this.protocolRequest = protocolRequest;
        this.protocolResponse = httpResponse;
        this.executionContext = executionContext;
    }

    @Override // aws.smithy.kotlin.runtime.client.RequestInterceptorContext
    public I getRequest() {
        return this.request;
    }

    @Override // aws.smithy.kotlin.runtime.client.ResponseInterceptorContext
    /* JADX INFO: renamed from: getResponse-d1pmJ48 */
    public Object mo12149getResponsed1pmJ48() {
        return this.response;
    }

    public void setResponse(Object obj) {
        this.response = obj;
    }

    @Override // aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext
    public HttpRequest getProtocolRequest() {
        return this.protocolRequest;
    }

    @Override // aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext
    public HttpResponse getProtocolResponse() {
        return this.protocolResponse;
    }

    @Override // aws.smithy.kotlin.runtime.client.RequestInterceptorContext
    public ExecutionContext getExecutionContext() {
        return this.executionContext;
    }
}
