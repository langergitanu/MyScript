package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.client.RequestInterceptorContext;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterceptorExecutor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u00020\u0016HÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00028\u00008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u000b¨\u0006\u001f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/HttpInputInterceptorContext;", "I", "Laws/smithy/kotlin/runtime/client/RequestInterceptorContext;", "request", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "executionContext", "<init>", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/operation/ExecutionContext;)V", "component1", "()Ljava/lang/Object;", "component2", "()Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "copy", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Laws/smithy/kotlin/runtime/http/interceptors/HttpInputInterceptorContext;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getRequest", "setRequest", "(Ljava/lang/Object;)V", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getExecutionContext", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class HttpInputInterceptorContext<I> implements RequestInterceptorContext<I> {
    private final ExecutionContext executionContext;
    private I request;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpInputInterceptorContext copy$default(HttpInputInterceptorContext httpInputInterceptorContext, Object obj, ExecutionContext executionContext, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = httpInputInterceptorContext.request;
        }
        if ((i & 2) != 0) {
            executionContext = httpInputInterceptorContext.executionContext;
        }
        return httpInputInterceptorContext.copy(obj, executionContext);
    }

    public final I component1() {
        return this.request;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ExecutionContext getExecutionContext() {
        return this.executionContext;
    }

    public final HttpInputInterceptorContext<I> copy(I request, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        return new HttpInputInterceptorContext<>(request, executionContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpInputInterceptorContext)) {
            return false;
        }
        HttpInputInterceptorContext httpInputInterceptorContext = (HttpInputInterceptorContext) other;
        return Intrinsics.areEqual(this.request, httpInputInterceptorContext.request) && Intrinsics.areEqual(this.executionContext, httpInputInterceptorContext.executionContext);
    }

    public int hashCode() {
        I i = this.request;
        return ((i == null ? 0 : i.hashCode()) * 31) + this.executionContext.hashCode();
    }

    public String toString() {
        return "HttpInputInterceptorContext(request=" + this.request + ", executionContext=" + this.executionContext + ')';
    }

    public HttpInputInterceptorContext(I i, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        this.request = i;
        this.executionContext = executionContext;
    }

    @Override // aws.smithy.kotlin.runtime.client.RequestInterceptorContext
    public I getRequest() {
        return this.request;
    }

    public void setRequest(I i) {
        this.request = i;
    }

    @Override // aws.smithy.kotlin.runtime.client.RequestInterceptorContext
    public ExecutionContext getExecutionContext() {
        return this.executionContext;
    }
}
