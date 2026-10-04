package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.collections.ValuesMap;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.net.url.UrlPath;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.text.encoding.Encodable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OperationEndpoint.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "req", "Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "endpoint", "", "setResolvedEndpoint", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;)V", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "ctx", "(Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;)V", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OperationEndpointKt {
    @InternalApi
    public static final void setResolvedEndpoint(OperationRequest<HttpRequestBuilder> req, Endpoint endpoint) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        setResolvedEndpoint(req.getSubject(), req.getContext(), endpoint);
    }

    @InternalApi
    public static final void setResolvedEndpoint(HttpRequestBuilder req, ExecutionContext ctx, Endpoint endpoint) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        String str = (String) ctx.getOrNull(HttpOperationContext.INSTANCE.getHostPrefix());
        if (str == null) {
            str = "";
        }
        String str2 = str + endpoint.getUri().getHost();
        Url.Builder url = req.getUrl();
        url.setScheme(endpoint.getUri().getScheme());
        url.getUserInfo().copyFrom(endpoint.getUri().getUserInfo());
        url.setHost(Host.INSTANCE.parse(str2));
        url.setPort(Integer.valueOf(endpoint.getUri().getPort()));
        UrlPath.Builder path = url.getPath();
        path.setTrailingSlash(path.getTrailingSlash() || (path.getSegments().isEmpty() && endpoint.getUri().getPath().getTrailingSlash()));
        path.getSegments().addAll(0, endpoint.getUri().getPath().getSegments());
        url.getParameters().addAll(endpoint.getUri().getParameters());
        Encodable fragment = endpoint.getUri().getFragment();
        url.setEncodedFragment(fragment != null ? fragment.getEncoded() : null);
        req.getHeaders().set("Host", req.getUrl().getHostAndPort());
        ValuesMap<String> headers = endpoint.getHeaders();
        if (headers != null) {
            req.getHeaders().appendAll(headers);
        }
    }
}
