package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: ImdsEndpointProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class ImdsEndpointProvider$resolvedEndpoint$1 extends FunctionReferenceImpl implements Function1<Continuation<? super Endpoint>, Object>, SuspendFunction {
    ImdsEndpointProvider$resolvedEndpoint$1(Object obj) {
        super(1, obj, ImdsEndpointProvider.class, "doResolveEndpoint", "doResolveEndpoint(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Endpoint> continuation) {
        return ((ImdsEndpointProvider) this.receiver).doResolveEndpoint(continuation);
    }
}
