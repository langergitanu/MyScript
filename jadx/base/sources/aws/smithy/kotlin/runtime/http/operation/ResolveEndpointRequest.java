package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.identity.Identity;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: OperationEndpoint.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u00020\u0016HÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u00020\u0019HÖ\u0081\u0004¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\u000f¨\u0006\""}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/ResolveEndpointRequest;", "", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "httpRequest", "Laws/smithy/kotlin/runtime/identity/Identity;", HTTP.IDENTITY_CODING, "<init>", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/identity/Identity;)V", "component1", "()Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "component2", "()Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "component3", "()Laws/smithy/kotlin/runtime/identity/Identity;", "copy", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/identity/Identity;)Laws/smithy/kotlin/runtime/http/operation/ResolveEndpointRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getContext", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "getHttpRequest", "Laws/smithy/kotlin/runtime/identity/Identity;", "getIdentity", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ResolveEndpointRequest {
    private final ExecutionContext context;
    private final HttpRequest httpRequest;
    private final Identity identity;

    public static /* synthetic */ ResolveEndpointRequest copy$default(ResolveEndpointRequest resolveEndpointRequest, ExecutionContext executionContext, HttpRequest httpRequest, Identity identity, int i, Object obj) {
        if ((i & 1) != 0) {
            executionContext = resolveEndpointRequest.context;
        }
        if ((i & 2) != 0) {
            httpRequest = resolveEndpointRequest.httpRequest;
        }
        if ((i & 4) != 0) {
            identity = resolveEndpointRequest.identity;
        }
        return resolveEndpointRequest.copy(executionContext, httpRequest, identity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ExecutionContext getContext() {
        return this.context;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HttpRequest getHttpRequest() {
        return this.httpRequest;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Identity getIdentity() {
        return this.identity;
    }

    public final ResolveEndpointRequest copy(ExecutionContext context, HttpRequest httpRequest, Identity identity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
        Intrinsics.checkNotNullParameter(identity, "identity");
        return new ResolveEndpointRequest(context, httpRequest, identity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResolveEndpointRequest)) {
            return false;
        }
        ResolveEndpointRequest resolveEndpointRequest = (ResolveEndpointRequest) other;
        return Intrinsics.areEqual(this.context, resolveEndpointRequest.context) && Intrinsics.areEqual(this.httpRequest, resolveEndpointRequest.httpRequest) && Intrinsics.areEqual(this.identity, resolveEndpointRequest.identity);
    }

    public int hashCode() {
        return (((this.context.hashCode() * 31) + this.httpRequest.hashCode()) * 31) + this.identity.hashCode();
    }

    public String toString() {
        return "ResolveEndpointRequest(context=" + this.context + ", httpRequest=" + this.httpRequest + ", identity=" + this.identity + ')';
    }

    public ResolveEndpointRequest(ExecutionContext context, HttpRequest httpRequest, Identity identity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
        Intrinsics.checkNotNullParameter(identity, "identity");
        this.context = context;
        this.httpRequest = httpRequest;
        this.identity = identity;
    }

    public final ExecutionContext getContext() {
        return this.context;
    }

    public final HttpRequest getHttpRequest() {
        return this.httpRequest;
    }

    public final Identity getIdentity() {
        return this.identity;
    }
}
