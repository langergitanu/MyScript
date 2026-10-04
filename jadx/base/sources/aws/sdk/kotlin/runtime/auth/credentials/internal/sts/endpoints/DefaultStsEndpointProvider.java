package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.endpoints;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.endpoints.internal.PartitionsKt;
import aws.sdk.kotlin.runtime.endpoint.functions.PartitionConfig;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.client.endpoints.EndpointProviderException;
import aws.smithy.kotlin.runtime.client.endpoints.SigningContextKt;
import aws.smithy.kotlin.runtime.collections.AttributesBuilder;
import aws.smithy.kotlin.runtime.http.auth.SigV4AuthSchemeKt;
import aws.smithy.kotlin.runtime.net.url.Url;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultStsEndpointProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/endpoints/DefaultStsEndpointProvider;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/endpoints/StsEndpointProvider;", "<init>", "()V", "resolveEndpoint", "Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "params", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/endpoints/StsEndpointParameters;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/endpoints/StsEndpointParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultStsEndpointProvider implements StsEndpointProvider {
    @Override // aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider
    public /* bridge */ /* synthetic */ Object resolveEndpoint(StsEndpointParameters stsEndpointParameters, Continuation continuation) {
        return resolveEndpoint2(stsEndpointParameters, (Continuation<? super Endpoint>) continuation);
    }

    /* JADX INFO: renamed from: resolveEndpoint, reason: avoid collision after fix types in other method */
    public Object resolveEndpoint2(StsEndpointParameters stsEndpointParameters, Continuation<? super Endpoint> continuation) {
        PartitionConfig partitionConfigPartition;
        PartitionConfig partitionConfigPartition2 = PartitionsKt.partition(stsEndpointParameters.getRegion());
        if (partitionConfigPartition2 != null && Intrinsics.areEqual(stsEndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true)) && stsEndpointParameters.getEndpoint() == null && stsEndpointParameters.getRegion() != null && Intrinsics.areEqual(stsEndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(stsEndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
            if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "ap-northeast-1")) {
                Url url = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                AttributesBuilder attributesBuilder = new AttributesBuilder();
                attributesBuilder.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                Unit unit = Unit.INSTANCE;
                return new Endpoint(url, null, attributesBuilder.getAttributes(), 2, null);
            }
            if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "ap-south-1")) {
                Url url2 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                AttributesBuilder attributesBuilder2 = new AttributesBuilder();
                attributesBuilder2.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                Unit unit2 = Unit.INSTANCE;
                return new Endpoint(url2, null, attributesBuilder2.getAttributes(), 2, null);
            }
            if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "ap-southeast-1")) {
                Url url3 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                AttributesBuilder attributesBuilder3 = new AttributesBuilder();
                attributesBuilder3.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                Unit unit3 = Unit.INSTANCE;
                return new Endpoint(url3, null, attributesBuilder3.getAttributes(), 2, null);
            }
            if (!Intrinsics.areEqual(stsEndpointParameters.getRegion(), "ap-southeast-2")) {
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "aws-global")) {
                    Url url4 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder4 = new AttributesBuilder();
                    attributesBuilder4.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit4 = Unit.INSTANCE;
                    return new Endpoint(url4, null, attributesBuilder4.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "ca-central-1")) {
                    Url url5 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder5 = new AttributesBuilder();
                    attributesBuilder5.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit5 = Unit.INSTANCE;
                    return new Endpoint(url5, null, attributesBuilder5.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "eu-central-1")) {
                    Url url6 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder6 = new AttributesBuilder();
                    attributesBuilder6.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit6 = Unit.INSTANCE;
                    return new Endpoint(url6, null, attributesBuilder6.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "eu-north-1")) {
                    Url url7 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder7 = new AttributesBuilder();
                    attributesBuilder7.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit7 = Unit.INSTANCE;
                    return new Endpoint(url7, null, attributesBuilder7.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "eu-west-1")) {
                    Url url8 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder8 = new AttributesBuilder();
                    attributesBuilder8.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit8 = Unit.INSTANCE;
                    return new Endpoint(url8, null, attributesBuilder8.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "eu-west-2")) {
                    Url url9 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder9 = new AttributesBuilder();
                    attributesBuilder9.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit9 = Unit.INSTANCE;
                    return new Endpoint(url9, null, attributesBuilder9.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "eu-west-3")) {
                    Url url10 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder10 = new AttributesBuilder();
                    attributesBuilder10.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit10 = Unit.INSTANCE;
                    return new Endpoint(url10, null, attributesBuilder10.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "sa-east-1")) {
                    Url url11 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder11 = new AttributesBuilder();
                    attributesBuilder11.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit11 = Unit.INSTANCE;
                    return new Endpoint(url11, null, attributesBuilder11.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "us-east-1")) {
                    Url url12 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder12 = new AttributesBuilder();
                    attributesBuilder12.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit12 = Unit.INSTANCE;
                    return new Endpoint(url12, null, attributesBuilder12.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "us-east-2")) {
                    Url url13 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder13 = new AttributesBuilder();
                    attributesBuilder13.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit13 = Unit.INSTANCE;
                    return new Endpoint(url13, null, attributesBuilder13.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "us-west-1")) {
                    Url url14 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder14 = new AttributesBuilder();
                    attributesBuilder14.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit14 = Unit.INSTANCE;
                    return new Endpoint(url14, null, attributesBuilder14.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "us-west-2")) {
                    Url url15 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder15 = new AttributesBuilder();
                    attributesBuilder15.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit15 = Unit.INSTANCE;
                    return new Endpoint(url15, null, attributesBuilder15.getAttributes(), 2, null);
                }
                Url url16 = Url.Companion.parse$default(Url.INSTANCE, "https://sts." + stsEndpointParameters.getRegion() + '.' + partitionConfigPartition2.getDnsSuffix(), null, 2, null);
                AttributesBuilder attributesBuilder16 = new AttributesBuilder();
                attributesBuilder16.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", String.valueOf(stsEndpointParameters.getRegion()), Boxing.boxBoolean(false), null, 17, null)));
                Unit unit16 = Unit.INSTANCE;
                return new Endpoint(url16, null, attributesBuilder16.getAttributes(), 2, null);
            }
            Url url17 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
            AttributesBuilder attributesBuilder17 = new AttributesBuilder();
            attributesBuilder17.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
            Unit unit17 = Unit.INSTANCE;
            return new Endpoint(url17, null, attributesBuilder17.getAttributes(), 2, null);
        }
        if (stsEndpointParameters.getEndpoint() != null) {
            if (Intrinsics.areEqual(stsEndpointParameters.getUseFips(), Boxing.boxBoolean(true))) {
                throw new EndpointProviderException("Invalid Configuration: FIPS and custom endpoint are not supported");
            }
            if (Intrinsics.areEqual(stsEndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                throw new EndpointProviderException("Invalid Configuration: Dualstack and custom endpoint are not supported");
            }
            Url url18 = Url.Companion.parse$default(Url.INSTANCE, stsEndpointParameters.getEndpoint(), null, 2, null);
            AttributesBuilder attributesBuilder18 = new AttributesBuilder();
            attributesBuilder18.m497to(BusinessMetricsUtilsKt.getServiceEndpointOverride(), Boxing.boxBoolean(true));
            Unit unit18 = Unit.INSTANCE;
            return new Endpoint(url18, null, attributesBuilder18.getAttributes(), 2, null);
        }
        if (stsEndpointParameters.getRegion() != null && (partitionConfigPartition = PartitionsKt.partition(stsEndpointParameters.getRegion())) != null) {
            if (Intrinsics.areEqual(stsEndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(stsEndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                if (Intrinsics.areEqual(Boxing.boxBoolean(true), partitionConfigPartition.getSupportsFIPS()) && Intrinsics.areEqual(Boxing.boxBoolean(true), partitionConfigPartition.getSupportsDualStack())) {
                    return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://sts-fips." + stsEndpointParameters.getRegion() + '.' + partitionConfigPartition.getDualStackDnsSuffix(), null, 2, null), null, 2, null);
                }
                throw new EndpointProviderException("FIPS and DualStack are enabled, but this partition does not support one or both");
            }
            if (Intrinsics.areEqual(stsEndpointParameters.getUseFips(), Boxing.boxBoolean(true))) {
                if (Intrinsics.areEqual(partitionConfigPartition.getSupportsFIPS(), Boxing.boxBoolean(true))) {
                    if (Intrinsics.areEqual(partitionConfigPartition.getName(), "aws-us-gov")) {
                        return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://sts." + stsEndpointParameters.getRegion() + ".amazonaws.com", null, 2, null), null, 2, null);
                    }
                    return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://sts-fips." + stsEndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null), null, 2, null);
                }
                throw new EndpointProviderException("FIPS is enabled but this partition does not support FIPS");
            }
            if (!Intrinsics.areEqual(stsEndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                if (Intrinsics.areEqual(stsEndpointParameters.getRegion(), "aws-global")) {
                    Url url19 = Url.Companion.parse$default(Url.INSTANCE, "https://sts.amazonaws.com", null, 2, null);
                    AttributesBuilder attributesBuilder19 = new AttributesBuilder();
                    attributesBuilder19.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "sts", "us-east-1", Boxing.boxBoolean(false), null, 17, null)));
                    Unit unit19 = Unit.INSTANCE;
                    return new Endpoint(url19, null, attributesBuilder19.getAttributes(), 2, null);
                }
                return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://sts." + stsEndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null), null, 2, null);
            }
            if (Intrinsics.areEqual(Boxing.boxBoolean(true), partitionConfigPartition.getSupportsDualStack())) {
                return new Endpoint(Url.Companion.parse$default(Url.INSTANCE, "https://sts." + stsEndpointParameters.getRegion() + '.' + partitionConfigPartition.getDualStackDnsSuffix(), null, 2, null), null, 2, null);
            }
            throw new EndpointProviderException("DualStack is enabled but this partition does not support DualStack");
        }
        throw new EndpointProviderException("Invalid Configuration: Missing Region");
    }
}
