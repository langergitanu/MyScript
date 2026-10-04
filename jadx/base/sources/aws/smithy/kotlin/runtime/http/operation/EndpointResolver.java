package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: OperationEndpoint.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;", "", "Laws/smithy/kotlin/runtime/http/operation/ResolveEndpointRequest;", "request", "Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "resolve", "(Laws/smithy/kotlin/runtime/http/operation/ResolveEndpointRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface EndpointResolver {
    Object resolve(ResolveEndpointRequest resolveEndpointRequest, Continuation<? super Endpoint> continuation);
}
