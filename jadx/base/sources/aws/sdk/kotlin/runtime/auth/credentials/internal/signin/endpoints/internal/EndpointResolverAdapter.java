package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.endpoints.internal;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.SigninClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.endpoints.SigninEndpointParameters;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.endpoints.SigninEndpointProvider;
import aws.sdk.kotlin.runtime.client.AwsClientOption;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAttributes;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.businessmetrics.SmithyBusinessMetric;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.operation.EndpointResolver;
import aws.smithy.kotlin.runtime.http.operation.ResolveEndpointRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EndpointResolverAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/endpoints/internal/EndpointResolverAdapter;", "Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;", "config", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config;)V", "resolve", "Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "request", "Laws/smithy/kotlin/runtime/http/operation/ResolveEndpointRequest;", "(Laws/smithy/kotlin/runtime/http/operation/ResolveEndpointRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EndpointResolverAdapter implements EndpointResolver {
    private final SigninClient.Config config;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.internal.signin.endpoints.internal.EndpointResolverAdapter$resolve$1 */
    /* JADX INFO: compiled from: EndpointResolverAdapter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.internal.signin.endpoints.internal.EndpointResolverAdapter", m1609f = "EndpointResolverAdapter.kt", m1610i = {0, 0}, m1611l = {26}, m1612m = "resolve", m1613n = {"request", "params"}, m1614nl = {28}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C30351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30351(Continuation<? super C30351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EndpointResolverAdapter.this.resolve(null, this);
        }
    }

    public EndpointResolverAdapter(SigninClient.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.http.operation.EndpointResolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(ResolveEndpointRequest resolveEndpointRequest, Continuation<? super Endpoint> continuation) {
        C30351 c30351;
        if (continuation instanceof C30351) {
            c30351 = (C30351) continuation;
            if ((c30351.label & Integer.MIN_VALUE) != 0) {
                c30351.label -= Integer.MIN_VALUE;
            } else {
                c30351 = new C30351(continuation);
            }
        }
        Object objResolveEndpoint = c30351.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30351.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolveEndpoint);
            SigninEndpointParameters signinEndpointParametersResolveEndpointParams = EndpointResolverAdapterKt.resolveEndpointParams(this.config, resolveEndpointRequest);
            SigninEndpointProvider endpointProvider = this.config.getEndpointProvider();
            c30351.L$0 = resolveEndpointRequest;
            c30351.L$1 = SpillingKt.nullOutSpilledVariable(signinEndpointParametersResolveEndpointParams);
            c30351.label = 1;
            objResolveEndpoint = endpointProvider.resolveEndpoint(signinEndpointParametersResolveEndpointParams, c30351);
            if (objResolveEndpoint == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            resolveEndpointRequest = (ResolveEndpointRequest) c30351.L$0;
            ResultKt.throwOnFailure(objResolveEndpoint);
        }
        Endpoint endpoint = (Endpoint) objResolveEndpoint;
        if (endpoint.getAttributes().contains(BusinessMetricsUtilsKt.getServiceEndpointOverride())) {
            BusinessMetricsUtilsKt.emitBusinessMetric(resolveEndpointRequest.getContext(), (BusinessMetric) SmithyBusinessMetric.SERVICE_ENDPOINT_OVERRIDE);
        }
        if (endpoint.getAttributes().contains(BusinessMetricsUtilsKt.getAccountIdBasedEndpointAccountId())) {
            BusinessMetricsUtilsKt.emitBusinessMetric(resolveEndpointRequest.getContext(), (BusinessMetric) SmithyBusinessMetric.ACCOUNT_ID_BASED_ENDPOINT);
        }
        if (endpoint.getAttributes().contains(AwsSigningAttributes.INSTANCE.getSigningService()) && Intrinsics.areEqual(AttributesKt.get(endpoint.getAttributes(), AwsSigningAttributes.INSTANCE.getSigningService()), "s3express")) {
            BusinessMetricsUtilsKt.emitBusinessMetric(resolveEndpointRequest.getContext(), (BusinessMetric) AwsBusinessMetric.S3_EXPRESS_BUCKET);
        }
        if (resolveEndpointRequest.getIdentity().getAttributes().contains(AwsClientOption.INSTANCE.getAccountId())) {
            BusinessMetricsUtilsKt.emitBusinessMetric(resolveEndpointRequest.getContext(), (BusinessMetric) SmithyBusinessMetric.RESOLVED_ACCOUNT_ID);
        }
        return endpoint;
    }
}
