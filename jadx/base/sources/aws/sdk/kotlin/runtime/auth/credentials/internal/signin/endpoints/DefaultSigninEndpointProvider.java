package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.endpoints;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.endpoints.internal.PartitionsKt;
import aws.sdk.kotlin.runtime.endpoint.functions.PartitionConfig;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.client.endpoints.EndpointProviderException;
import aws.smithy.kotlin.runtime.collections.AttributesBuilder;
import aws.smithy.kotlin.runtime.net.url.Url;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultSigninEndpointProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/endpoints/DefaultSigninEndpointProvider;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/endpoints/SigninEndpointProvider;", "<init>", "()V", "resolveEndpoint", "Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "params", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/endpoints/SigninEndpointParameters;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/endpoints/SigninEndpointParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultSigninEndpointProvider implements SigninEndpointProvider {
    @Override // aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider
    public /* bridge */ /* synthetic */ Object resolveEndpoint(SigninEndpointParameters signinEndpointParameters, Continuation continuation) {
        return resolveEndpoint2(signinEndpointParameters, (Continuation<? super Endpoint>) continuation);
    }

    /* JADX INFO: renamed from: resolveEndpoint, reason: avoid collision after fix types in other method */
    public Object resolveEndpoint2(SigninEndpointParameters signinEndpointParameters, Continuation<? super Endpoint> continuation) {
        PartitionConfig partitionConfigPartition;
        if (signinEndpointParameters.getEndpoint() != null) {
            if (Intrinsics.areEqual(signinEndpointParameters.getUseFips(), Boxing.boxBoolean(true))) {
                throw new EndpointProviderException("Invalid Configuration: FIPS and custom endpoint are not supported");
            }
            if (Intrinsics.areEqual(signinEndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                throw new EndpointProviderException("Invalid Configuration: Dualstack and custom endpoint are not supported");
            }
            Url url = Url.Companion.parse$default(Url.INSTANCE, signinEndpointParameters.getEndpoint(), null, 2, null);
            AttributesBuilder attributesBuilder = new AttributesBuilder();
            attributesBuilder.m497to(BusinessMetricsUtilsKt.getServiceEndpointOverride(), Boxing.boxBoolean(true));
            Unit unit = Unit.INSTANCE;
            return new Endpoint(url, null, attributesBuilder.getAttributes(), 2, null);
        }
        if (signinEndpointParameters.getRegion() != null && (partitionConfigPartition = PartitionsKt.partition(signinEndpointParameters.getRegion())) != null) {
            if (Intrinsics.areEqual(partitionConfigPartition.getName(), "aws") && Intrinsics.areEqual(signinEndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(signinEndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://" + signinEndpointParameters.getRegion() + ".signin.aws.amazon.com", null, 2, null), null, 2, null);
            }
            if (Intrinsics.areEqual(partitionConfigPartition.getName(), "aws-cn") && Intrinsics.areEqual(signinEndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(signinEndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://" + signinEndpointParameters.getRegion() + ".signin.amazonaws.cn", null, 2, null), null, 2, null);
            }
            if (Intrinsics.areEqual(partitionConfigPartition.getName(), "aws-us-gov") && Intrinsics.areEqual(signinEndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(signinEndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://" + signinEndpointParameters.getRegion() + ".signin.amazonaws-us-gov.com", null, 2, null), null, 2, null);
            }
            if (Intrinsics.areEqual(signinEndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(signinEndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                if (Intrinsics.areEqual(Boxing.boxBoolean(true), partitionConfigPartition.getSupportsFIPS()) && Intrinsics.areEqual(Boxing.boxBoolean(true), partitionConfigPartition.getSupportsDualStack())) {
                    return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://signin-fips." + signinEndpointParameters.getRegion() + '.' + partitionConfigPartition.getDualStackDnsSuffix(), null, 2, null), null, 2, null);
                }
                throw new EndpointProviderException("FIPS and DualStack are enabled, but this partition does not support one or both");
            }
            if (Intrinsics.areEqual(signinEndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(signinEndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                if (Intrinsics.areEqual(partitionConfigPartition.getSupportsFIPS(), Boxing.boxBoolean(true))) {
                    return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://signin-fips." + signinEndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null), null, 2, null);
                }
                throw new EndpointProviderException("FIPS is enabled but this partition does not support FIPS");
            }
            if (Intrinsics.areEqual(signinEndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(signinEndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                if (Intrinsics.areEqual(Boxing.boxBoolean(true), partitionConfigPartition.getSupportsDualStack())) {
                    return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://signin." + signinEndpointParameters.getRegion() + '.' + partitionConfigPartition.getDualStackDnsSuffix(), null, 2, null), null, 2, null);
                }
                throw new EndpointProviderException("DualStack is enabled but this partition does not support DualStack");
            }
            return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://signin." + signinEndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null), null, 2, null);
        }
        throw new EndpointProviderException("Invalid Configuration: Missing Region");
    }
}
