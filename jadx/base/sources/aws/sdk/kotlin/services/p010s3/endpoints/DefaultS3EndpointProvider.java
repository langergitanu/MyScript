package aws.sdk.kotlin.services.p010s3.endpoints;

import aws.sdk.kotlin.runtime.endpoint.functions.Arn;
import aws.sdk.kotlin.runtime.endpoint.functions.PartitionConfig;
import aws.sdk.kotlin.services.p010s3.endpoints.internal.PartitionsKt;
import aws.sdk.kotlin.services.p010s3.express.S3ExpressDefaultChecksumAlgorithmKt;
import aws.sdk.kotlin.services.p010s3.express.SigV4S3ExpressAuthSchemeKt;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.client.endpoints.EndpointProviderException;
import aws.smithy.kotlin.runtime.client.endpoints.SigningContextKt;
import aws.smithy.kotlin.runtime.client.endpoints.functions.FunctionsKt;
import aws.smithy.kotlin.runtime.client.endpoints.functions.Url;
import aws.smithy.kotlin.runtime.collections.AttributesBuilder;
import aws.smithy.kotlin.runtime.http.auth.SigV4AsymmetricAuthSchemeKt;
import aws.smithy.kotlin.runtime.http.auth.SigV4AuthSchemeKt;
import aws.smithy.kotlin.runtime.net.url.Url;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: DefaultS3EndpointProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/endpoints/DefaultS3EndpointProvider;", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointProvider;", "<init>", "()V", "resolveEndpoint", "Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "params", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters;", "(Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultS3EndpointProvider implements S3EndpointProvider {
    @Override // aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider
    public /* bridge */ /* synthetic */ Object resolveEndpoint(S3EndpointParameters s3EndpointParameters, Continuation continuation) {
        return resolveEndpoint2(s3EndpointParameters, (Continuation<? super Endpoint>) continuation);
    }

    /* JADX INFO: renamed from: resolveEndpoint, reason: avoid collision after fix types in other method */
    public Object resolveEndpoint2(S3EndpointParameters s3EndpointParameters, Continuation<? super Endpoint> continuation) {
        PartitionConfig partitionConfigPartition;
        PartitionConfig partitionConfigPartition2;
        PartitionConfig partitionConfigPartition3;
        PartitionConfig partitionConfigPartition4;
        PartitionConfig partitionConfigPartition5;
        PartitionConfig partitionConfigPartition6;
        PartitionConfig partitionConfigPartition7;
        PartitionConfig partitionConfigPartition8;
        PartitionConfig partitionConfigPartition9;
        String strUriEncode;
        String strUriEncode2;
        boolean z;
        PartitionConfig partitionConfigPartition10;
        PartitionConfig partitionConfigPartition11;
        String strUriEncode3;
        String strUriEncode4;
        String strUriEncode5;
        if (s3EndpointParameters.getRegion() != null) {
            if (Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true))) {
                throw new EndpointProviderException("Accelerate cannot be used with FIPS");
            }
            if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() != null) {
                throw new EndpointProviderException("Cannot set dual-stack in combination with a custom endpoint.");
            }
            if (s3EndpointParameters.getEndpoint() != null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true))) {
                throw new EndpointProviderException("A custom endpoint cannot be combined with FIPS");
            }
            if (s3EndpointParameters.getEndpoint() != null && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true))) {
                throw new EndpointProviderException("A custom endpoint cannot be combined with S3 Accelerate");
            }
            PartitionConfig partitionConfigPartition12 = PartitionsKt.partition(s3EndpointParameters.getRegion());
            if (partitionConfigPartition12 != null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(partitionConfigPartition12.getName(), "aws-cn")) {
                throw new EndpointProviderException("Partition does not support FIPS");
            }
            String strSubstring = FunctionsKt.substring(s3EndpointParameters.getBucket(), 0, 6, true);
            if (strSubstring != null && s3EndpointParameters.getBucket() != null && Intrinsics.areEqual(strSubstring, "--x-s3")) {
                if (Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true))) {
                    throw new EndpointProviderException("S3Express does not support S3 Accelerate.");
                }
                Url url = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                if (url != null && s3EndpointParameters.getEndpoint() != null) {
                    if (s3EndpointParameters.getDisableS3ExpressSessionAuth() != null && Intrinsics.areEqual(s3EndpointParameters.getDisableS3ExpressSessionAuth(), Boxing.boxBoolean(true))) {
                        if (url.isIp() && (strUriEncode5 = FunctionsKt.uriEncode(s3EndpointParameters.getBucket())) != null) {
                            aws.smithy.kotlin.runtime.net.url.Url url2 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url.getScheme() + "://" + url.getAuthority() + JsonPointer.SEPARATOR + strUriEncode5 + url.getPath(), null, 2, null);
                            AttributesBuilder attributesBuilder = new AttributesBuilder();
                            attributesBuilder.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit = Unit.INSTANCE;
                            return new Endpoint(url2, null, attributesBuilder.getAttributes(), 2, null);
                        }
                        if (aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.isVirtualHostableS3Bucket(s3EndpointParameters.getBucket(), false)) {
                            aws.smithy.kotlin.runtime.net.url.Url url3 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url.getScheme() + "://" + s3EndpointParameters.getBucket() + '.' + url.getAuthority() + url.getPath(), null, 2, null);
                            AttributesBuilder attributesBuilder2 = new AttributesBuilder();
                            attributesBuilder2.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder2.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit2 = Unit.INSTANCE;
                            return new Endpoint(url3, null, attributesBuilder2.getAttributes(), 2, null);
                        }
                        throw new EndpointProviderException("S3Express bucket name is not a valid virtual hostable name.");
                    }
                    if (url.isIp() && (strUriEncode4 = FunctionsKt.uriEncode(s3EndpointParameters.getBucket())) != null) {
                        aws.smithy.kotlin.runtime.net.url.Url url4 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url.getScheme() + "://" + url.getAuthority() + JsonPointer.SEPARATOR + strUriEncode4 + url.getPath(), null, 2, null);
                        AttributesBuilder attributesBuilder3 = new AttributesBuilder();
                        attributesBuilder3.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                        attributesBuilder3.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit3 = Unit.INSTANCE;
                        return new Endpoint(url4, null, attributesBuilder3.getAttributes(), 2, null);
                    }
                    if (aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.isVirtualHostableS3Bucket(s3EndpointParameters.getBucket(), false)) {
                        aws.smithy.kotlin.runtime.net.url.Url url5 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url.getScheme() + "://" + s3EndpointParameters.getBucket() + '.' + url.getAuthority() + url.getPath(), null, 2, null);
                        AttributesBuilder attributesBuilder4 = new AttributesBuilder();
                        attributesBuilder4.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                        attributesBuilder4.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit4 = Unit.INSTANCE;
                        return new Endpoint(url5, null, attributesBuilder4.getAttributes(), 2, null);
                    }
                    throw new EndpointProviderException("S3Express bucket name is not a valid virtual hostable name.");
                }
                if (s3EndpointParameters.getUseS3ExpressControlEndpoint() == null || !Intrinsics.areEqual(s3EndpointParameters.getUseS3ExpressControlEndpoint(), Boxing.boxBoolean(true)) || (partitionConfigPartition11 = PartitionsKt.partition(s3EndpointParameters.getRegion())) == null || (strUriEncode3 = FunctionsKt.uriEncode(s3EndpointParameters.getBucket())) == null || s3EndpointParameters.getEndpoint() != null) {
                    z = true;
                } else {
                    z = true;
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                        aws.smithy.kotlin.runtime.net.url.Url url6 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3express-control-fips.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition11.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode3, null, 2, null);
                        AttributesBuilder attributesBuilder5 = new AttributesBuilder();
                        attributesBuilder5.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                        attributesBuilder5.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit5 = Unit.INSTANCE;
                        return new Endpoint(url6, null, attributesBuilder5.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                        aws.smithy.kotlin.runtime.net.url.Url url7 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3express-control-fips." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition11.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode3, null, 2, null);
                        AttributesBuilder attributesBuilder6 = new AttributesBuilder();
                        attributesBuilder6.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                        attributesBuilder6.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit6 = Unit.INSTANCE;
                        return new Endpoint(url7, null, attributesBuilder6.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                        aws.smithy.kotlin.runtime.net.url.Url url8 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3express-control.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition11.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode3, null, 2, null);
                        AttributesBuilder attributesBuilder7 = new AttributesBuilder();
                        attributesBuilder7.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                        attributesBuilder7.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit7 = Unit.INSTANCE;
                        return new Endpoint(url8, null, attributesBuilder7.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                        aws.smithy.kotlin.runtime.net.url.Url url9 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3express-control." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition11.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode3, null, 2, null);
                        AttributesBuilder attributesBuilder8 = new AttributesBuilder();
                        attributesBuilder8.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                        attributesBuilder8.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit8 = Unit.INSTANCE;
                        return new Endpoint(url9, null, attributesBuilder8.getAttributes(), 2, null);
                    }
                }
                if (aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.isVirtualHostableS3Bucket(s3EndpointParameters.getBucket(), false) && (partitionConfigPartition10 = PartitionsKt.partition(s3EndpointParameters.getRegion())) != null) {
                    if (s3EndpointParameters.getDisableS3ExpressSessionAuth() != null && Intrinsics.areEqual(s3EndpointParameters.getDisableS3ExpressSessionAuth(), Boxing.boxBoolean(z))) {
                        boolean z2 = z;
                        String strSubstring2 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 6, 14, z2);
                        String strSubstring3 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 14, 16, z2);
                        if (strSubstring2 != null && strSubstring3 != null && Intrinsics.areEqual(strSubstring3, "--")) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(z2)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(z2))) {
                                aws.smithy.kotlin.runtime.net.url.Url url10 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring2 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder9 = new AttributesBuilder();
                                attributesBuilder9.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder9.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit9 = Unit.INSTANCE;
                                return new Endpoint(url10, null, attributesBuilder9.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url11 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring2 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder10 = new AttributesBuilder();
                                attributesBuilder10.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder10.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit10 = Unit.INSTANCE;
                                return new Endpoint(url11, null, attributesBuilder10.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url12 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring2 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder11 = new AttributesBuilder();
                                attributesBuilder11.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder11.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit11 = Unit.INSTANCE;
                                return new Endpoint(url12, null, attributesBuilder11.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url13 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring2 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder12 = new AttributesBuilder();
                                attributesBuilder12.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder12.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit12 = Unit.INSTANCE;
                                return new Endpoint(url13, null, attributesBuilder12.getAttributes(), 2, null);
                            }
                        }
                        String strSubstring4 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 6, 15, true);
                        String strSubstring5 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 15, 17, true);
                        if (strSubstring4 != null && strSubstring5 != null && Intrinsics.areEqual(strSubstring5, "--")) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url14 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring4 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder13 = new AttributesBuilder();
                                attributesBuilder13.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder13.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit13 = Unit.INSTANCE;
                                return new Endpoint(url14, null, attributesBuilder13.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url15 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring4 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder14 = new AttributesBuilder();
                                attributesBuilder14.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder14.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit14 = Unit.INSTANCE;
                                return new Endpoint(url15, null, attributesBuilder14.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url16 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring4 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder15 = new AttributesBuilder();
                                attributesBuilder15.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder15.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit15 = Unit.INSTANCE;
                                return new Endpoint(url16, null, attributesBuilder15.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url17 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring4 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder16 = new AttributesBuilder();
                                attributesBuilder16.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder16.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit16 = Unit.INSTANCE;
                                return new Endpoint(url17, null, attributesBuilder16.getAttributes(), 2, null);
                            }
                        }
                        String strSubstring6 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 6, 19, true);
                        String strSubstring7 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 19, 21, true);
                        if (strSubstring6 != null && strSubstring7 != null && Intrinsics.areEqual(strSubstring7, "--")) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url18 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring6 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder17 = new AttributesBuilder();
                                attributesBuilder17.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder17.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit17 = Unit.INSTANCE;
                                return new Endpoint(url18, null, attributesBuilder17.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url19 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring6 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder18 = new AttributesBuilder();
                                attributesBuilder18.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder18.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit18 = Unit.INSTANCE;
                                return new Endpoint(url19, null, attributesBuilder18.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url20 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring6 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder19 = new AttributesBuilder();
                                attributesBuilder19.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder19.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit19 = Unit.INSTANCE;
                                return new Endpoint(url20, null, attributesBuilder19.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url21 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring6 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder20 = new AttributesBuilder();
                                attributesBuilder20.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder20.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit20 = Unit.INSTANCE;
                                return new Endpoint(url21, null, attributesBuilder20.getAttributes(), 2, null);
                            }
                        }
                        String strSubstring8 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 6, 20, true);
                        String strSubstring9 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 20, 22, true);
                        if (strSubstring8 != null && strSubstring9 != null && Intrinsics.areEqual(strSubstring9, "--")) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url22 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring8 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder21 = new AttributesBuilder();
                                attributesBuilder21.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder21.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit21 = Unit.INSTANCE;
                                return new Endpoint(url22, null, attributesBuilder21.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url23 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring8 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder22 = new AttributesBuilder();
                                attributesBuilder22.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder22.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit22 = Unit.INSTANCE;
                                return new Endpoint(url23, null, attributesBuilder22.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url24 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring8 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder23 = new AttributesBuilder();
                                attributesBuilder23.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder23.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit23 = Unit.INSTANCE;
                                return new Endpoint(url24, null, attributesBuilder23.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url25 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring8 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder24 = new AttributesBuilder();
                                attributesBuilder24.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder24.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit24 = Unit.INSTANCE;
                                return new Endpoint(url25, null, attributesBuilder24.getAttributes(), 2, null);
                            }
                        }
                        String strSubstring10 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 6, 26, true);
                        String strSubstring11 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 26, 28, true);
                        if (strSubstring10 != null && strSubstring11 != null && Intrinsics.areEqual(strSubstring11, "--")) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url26 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring10 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder25 = new AttributesBuilder();
                                attributesBuilder25.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder25.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit25 = Unit.INSTANCE;
                                return new Endpoint(url26, null, attributesBuilder25.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url27 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring10 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder26 = new AttributesBuilder();
                                attributesBuilder26.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder26.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit26 = Unit.INSTANCE;
                                return new Endpoint(url27, null, attributesBuilder26.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url28 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring10 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder27 = new AttributesBuilder();
                                attributesBuilder27.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder27.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit27 = Unit.INSTANCE;
                                return new Endpoint(url28, null, attributesBuilder27.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url29 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring10 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder28 = new AttributesBuilder();
                                attributesBuilder28.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder28.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit28 = Unit.INSTANCE;
                                return new Endpoint(url29, null, attributesBuilder28.getAttributes(), 2, null);
                            }
                        }
                        throw new EndpointProviderException("Unrecognized S3Express bucket name format.");
                    }
                    String strSubstring12 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 6, 14, true);
                    String strSubstring13 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 14, 16, true);
                    if (strSubstring12 != null && strSubstring13 != null && Intrinsics.areEqual(strSubstring13, "--")) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url30 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring12 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder29 = new AttributesBuilder();
                            attributesBuilder29.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder29.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit29 = Unit.INSTANCE;
                            return new Endpoint(url30, null, attributesBuilder29.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url31 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring12 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder30 = new AttributesBuilder();
                            attributesBuilder30.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder30.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit30 = Unit.INSTANCE;
                            return new Endpoint(url31, null, attributesBuilder30.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url32 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring12 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder31 = new AttributesBuilder();
                            attributesBuilder31.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder31.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit31 = Unit.INSTANCE;
                            return new Endpoint(url32, null, attributesBuilder31.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url33 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring12 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder32 = new AttributesBuilder();
                            attributesBuilder32.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder32.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit32 = Unit.INSTANCE;
                            return new Endpoint(url33, null, attributesBuilder32.getAttributes(), 2, null);
                        }
                    }
                    String strSubstring14 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 6, 15, true);
                    String strSubstring15 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 15, 17, true);
                    if (strSubstring14 != null && strSubstring15 != null && Intrinsics.areEqual(strSubstring15, "--")) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url34 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring14 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder33 = new AttributesBuilder();
                            attributesBuilder33.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder33.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit33 = Unit.INSTANCE;
                            return new Endpoint(url34, null, attributesBuilder33.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url35 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring14 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder34 = new AttributesBuilder();
                            attributesBuilder34.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder34.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit34 = Unit.INSTANCE;
                            return new Endpoint(url35, null, attributesBuilder34.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url36 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring14 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder35 = new AttributesBuilder();
                            attributesBuilder35.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder35.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit35 = Unit.INSTANCE;
                            return new Endpoint(url36, null, attributesBuilder35.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url37 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring14 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder36 = new AttributesBuilder();
                            attributesBuilder36.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder36.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit36 = Unit.INSTANCE;
                            return new Endpoint(url37, null, attributesBuilder36.getAttributes(), 2, null);
                        }
                    }
                    String strSubstring16 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 6, 19, true);
                    String strSubstring17 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 19, 21, true);
                    if (strSubstring16 != null && strSubstring17 != null && Intrinsics.areEqual(strSubstring17, "--")) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url38 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring16 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder37 = new AttributesBuilder();
                            attributesBuilder37.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder37.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit37 = Unit.INSTANCE;
                            return new Endpoint(url38, null, attributesBuilder37.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url39 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring16 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder38 = new AttributesBuilder();
                            attributesBuilder38.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder38.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit38 = Unit.INSTANCE;
                            return new Endpoint(url39, null, attributesBuilder38.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url40 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring16 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder39 = new AttributesBuilder();
                            attributesBuilder39.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder39.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit39 = Unit.INSTANCE;
                            return new Endpoint(url40, null, attributesBuilder39.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url41 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring16 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder40 = new AttributesBuilder();
                            attributesBuilder40.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder40.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit40 = Unit.INSTANCE;
                            return new Endpoint(url41, null, attributesBuilder40.getAttributes(), 2, null);
                        }
                    }
                    String strSubstring18 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 6, 20, true);
                    String strSubstring19 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 20, 22, true);
                    if (strSubstring18 != null && strSubstring19 != null && Intrinsics.areEqual(strSubstring19, "--")) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url42 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring18 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder41 = new AttributesBuilder();
                            attributesBuilder41.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder41.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit41 = Unit.INSTANCE;
                            return new Endpoint(url42, null, attributesBuilder41.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url43 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring18 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder42 = new AttributesBuilder();
                            attributesBuilder42.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder42.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit42 = Unit.INSTANCE;
                            return new Endpoint(url43, null, attributesBuilder42.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url44 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring18 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder43 = new AttributesBuilder();
                            attributesBuilder43.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder43.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit43 = Unit.INSTANCE;
                            return new Endpoint(url44, null, attributesBuilder43.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url45 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring18 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder44 = new AttributesBuilder();
                            attributesBuilder44.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder44.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit44 = Unit.INSTANCE;
                            return new Endpoint(url45, null, attributesBuilder44.getAttributes(), 2, null);
                        }
                    }
                    String strSubstring20 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 6, 26, true);
                    String strSubstring21 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 26, 28, true);
                    if (strSubstring20 != null && strSubstring21 != null && Intrinsics.areEqual(strSubstring21, "--")) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url46 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring20 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder45 = new AttributesBuilder();
                            attributesBuilder45.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder45.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit45 = Unit.INSTANCE;
                            return new Endpoint(url46, null, attributesBuilder45.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url47 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring20 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder46 = new AttributesBuilder();
                            attributesBuilder46.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder46.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit46 = Unit.INSTANCE;
                            return new Endpoint(url47, null, attributesBuilder46.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url48 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring20 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder47 = new AttributesBuilder();
                            attributesBuilder47.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder47.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit47 = Unit.INSTANCE;
                            return new Endpoint(url48, null, attributesBuilder47.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url49 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring20 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition10.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder48 = new AttributesBuilder();
                            attributesBuilder48.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder48.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit48 = Unit.INSTANCE;
                            return new Endpoint(url49, null, attributesBuilder48.getAttributes(), 2, null);
                        }
                    }
                    throw new EndpointProviderException("Unrecognized S3Express bucket name format.");
                }
                throw new EndpointProviderException("S3Express bucket name is not a valid virtual hostable name.");
            }
            String strSubstring22 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 0, 7, true);
            if (strSubstring22 != null && s3EndpointParameters.getBucket() != null && Intrinsics.areEqual(strSubstring22, "--xa-s3")) {
                if (Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true))) {
                    throw new EndpointProviderException("S3Express does not support S3 Accelerate.");
                }
                aws.smithy.kotlin.runtime.client.endpoints.functions.Url url50 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                if (url50 != null && s3EndpointParameters.getEndpoint() != null) {
                    if (s3EndpointParameters.getDisableS3ExpressSessionAuth() != null && Intrinsics.areEqual(s3EndpointParameters.getDisableS3ExpressSessionAuth(), Boxing.boxBoolean(true))) {
                        if (url50.isIp() && (strUriEncode2 = FunctionsKt.uriEncode(s3EndpointParameters.getBucket())) != null) {
                            aws.smithy.kotlin.runtime.net.url.Url url51 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url50.getScheme() + "://" + url50.getAuthority() + JsonPointer.SEPARATOR + strUriEncode2 + url50.getPath(), null, 2, null);
                            AttributesBuilder attributesBuilder49 = new AttributesBuilder();
                            attributesBuilder49.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder49.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit49 = Unit.INSTANCE;
                            return new Endpoint(url51, null, attributesBuilder49.getAttributes(), 2, null);
                        }
                        if (aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.isVirtualHostableS3Bucket(s3EndpointParameters.getBucket(), false)) {
                            aws.smithy.kotlin.runtime.net.url.Url url52 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url50.getScheme() + "://" + s3EndpointParameters.getBucket() + '.' + url50.getAuthority() + url50.getPath(), null, 2, null);
                            AttributesBuilder attributesBuilder50 = new AttributesBuilder();
                            attributesBuilder50.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder50.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit50 = Unit.INSTANCE;
                            return new Endpoint(url52, null, attributesBuilder50.getAttributes(), 2, null);
                        }
                        throw new EndpointProviderException("S3Express bucket name is not a valid virtual hostable name.");
                    }
                    if (url50.isIp() && (strUriEncode = FunctionsKt.uriEncode(s3EndpointParameters.getBucket())) != null) {
                        aws.smithy.kotlin.runtime.net.url.Url url53 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url50.getScheme() + "://" + url50.getAuthority() + JsonPointer.SEPARATOR + strUriEncode + url50.getPath(), null, 2, null);
                        AttributesBuilder attributesBuilder51 = new AttributesBuilder();
                        attributesBuilder51.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                        attributesBuilder51.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit51 = Unit.INSTANCE;
                        return new Endpoint(url53, null, attributesBuilder51.getAttributes(), 2, null);
                    }
                    if (aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.isVirtualHostableS3Bucket(s3EndpointParameters.getBucket(), false)) {
                        aws.smithy.kotlin.runtime.net.url.Url url54 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url50.getScheme() + "://" + s3EndpointParameters.getBucket() + '.' + url50.getAuthority() + url50.getPath(), null, 2, null);
                        AttributesBuilder attributesBuilder52 = new AttributesBuilder();
                        attributesBuilder52.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                        attributesBuilder52.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit52 = Unit.INSTANCE;
                        return new Endpoint(url54, null, attributesBuilder52.getAttributes(), 2, null);
                    }
                    throw new EndpointProviderException("S3Express bucket name is not a valid virtual hostable name.");
                }
                if (aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.isVirtualHostableS3Bucket(s3EndpointParameters.getBucket(), false) && (partitionConfigPartition9 = PartitionsKt.partition(s3EndpointParameters.getRegion())) != null) {
                    if (s3EndpointParameters.getDisableS3ExpressSessionAuth() != null && Intrinsics.areEqual(s3EndpointParameters.getDisableS3ExpressSessionAuth(), Boxing.boxBoolean(true))) {
                        String strSubstring23 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 7, 15, true);
                        String strSubstring24 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 15, 17, true);
                        if (strSubstring23 != null && strSubstring24 != null && Intrinsics.areEqual(strSubstring24, "--")) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url55 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring23 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder53 = new AttributesBuilder();
                                attributesBuilder53.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder53.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit53 = Unit.INSTANCE;
                                return new Endpoint(url55, null, attributesBuilder53.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url56 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring23 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder54 = new AttributesBuilder();
                                attributesBuilder54.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder54.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit54 = Unit.INSTANCE;
                                return new Endpoint(url56, null, attributesBuilder54.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url57 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring23 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder55 = new AttributesBuilder();
                                attributesBuilder55.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder55.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit55 = Unit.INSTANCE;
                                return new Endpoint(url57, null, attributesBuilder55.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url58 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring23 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder56 = new AttributesBuilder();
                                attributesBuilder56.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder56.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit56 = Unit.INSTANCE;
                                return new Endpoint(url58, null, attributesBuilder56.getAttributes(), 2, null);
                            }
                        }
                        String strSubstring25 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 7, 16, true);
                        String strSubstring26 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 16, 18, true);
                        if (strSubstring25 != null && strSubstring26 != null && Intrinsics.areEqual(strSubstring26, "--")) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url59 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring25 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder57 = new AttributesBuilder();
                                attributesBuilder57.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder57.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit57 = Unit.INSTANCE;
                                return new Endpoint(url59, null, attributesBuilder57.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url60 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring25 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder58 = new AttributesBuilder();
                                attributesBuilder58.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder58.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit58 = Unit.INSTANCE;
                                return new Endpoint(url60, null, attributesBuilder58.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url61 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring25 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder59 = new AttributesBuilder();
                                attributesBuilder59.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder59.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit59 = Unit.INSTANCE;
                                return new Endpoint(url61, null, attributesBuilder59.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url62 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring25 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder60 = new AttributesBuilder();
                                attributesBuilder60.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder60.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit60 = Unit.INSTANCE;
                                return new Endpoint(url62, null, attributesBuilder60.getAttributes(), 2, null);
                            }
                        }
                        String strSubstring27 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 7, 20, true);
                        String strSubstring28 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 20, 22, true);
                        if (strSubstring27 != null && strSubstring28 != null && Intrinsics.areEqual(strSubstring28, "--")) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url63 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring27 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder61 = new AttributesBuilder();
                                attributesBuilder61.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder61.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit61 = Unit.INSTANCE;
                                return new Endpoint(url63, null, attributesBuilder61.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url64 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring27 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder62 = new AttributesBuilder();
                                attributesBuilder62.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder62.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit62 = Unit.INSTANCE;
                                return new Endpoint(url64, null, attributesBuilder62.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url65 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring27 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder63 = new AttributesBuilder();
                                attributesBuilder63.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder63.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit63 = Unit.INSTANCE;
                                return new Endpoint(url65, null, attributesBuilder63.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url66 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring27 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder64 = new AttributesBuilder();
                                attributesBuilder64.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder64.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit64 = Unit.INSTANCE;
                                return new Endpoint(url66, null, attributesBuilder64.getAttributes(), 2, null);
                            }
                        }
                        String strSubstring29 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 7, 21, true);
                        String strSubstring30 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 21, 23, true);
                        if (strSubstring29 != null && strSubstring30 != null && Intrinsics.areEqual(strSubstring30, "--")) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url67 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring29 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder65 = new AttributesBuilder();
                                attributesBuilder65.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder65.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit65 = Unit.INSTANCE;
                                return new Endpoint(url67, null, attributesBuilder65.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url68 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring29 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder66 = new AttributesBuilder();
                                attributesBuilder66.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder66.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit66 = Unit.INSTANCE;
                                return new Endpoint(url68, null, attributesBuilder66.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url69 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring29 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder67 = new AttributesBuilder();
                                attributesBuilder67.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder67.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit67 = Unit.INSTANCE;
                                return new Endpoint(url69, null, attributesBuilder67.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url70 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring29 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder68 = new AttributesBuilder();
                                attributesBuilder68.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder68.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit68 = Unit.INSTANCE;
                                return new Endpoint(url70, null, attributesBuilder68.getAttributes(), 2, null);
                            }
                        }
                        String strSubstring31 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 7, 27, true);
                        String strSubstring32 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 27, 29, true);
                        if (strSubstring31 != null && strSubstring32 != null && Intrinsics.areEqual(strSubstring32, "--")) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url71 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring31 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder69 = new AttributesBuilder();
                                attributesBuilder69.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder69.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit69 = Unit.INSTANCE;
                                return new Endpoint(url71, null, attributesBuilder69.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url72 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring31 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder70 = new AttributesBuilder();
                                attributesBuilder70.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder70.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit70 = Unit.INSTANCE;
                                return new Endpoint(url72, null, attributesBuilder70.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                aws.smithy.kotlin.runtime.net.url.Url url73 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring31 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder71 = new AttributesBuilder();
                                attributesBuilder71.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder71.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit71 = Unit.INSTANCE;
                                return new Endpoint(url73, null, attributesBuilder71.getAttributes(), 2, null);
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                aws.smithy.kotlin.runtime.net.url.Url url74 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring31 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder72 = new AttributesBuilder();
                                attributesBuilder72.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                                attributesBuilder72.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit72 = Unit.INSTANCE;
                                return new Endpoint(url74, null, attributesBuilder72.getAttributes(), 2, null);
                            }
                        }
                        throw new EndpointProviderException("Unrecognized S3Express bucket name format.");
                    }
                    String strSubstring33 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 7, 15, true);
                    String strSubstring34 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 15, 17, true);
                    if (strSubstring33 != null && strSubstring34 != null && Intrinsics.areEqual(strSubstring34, "--")) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url75 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring33 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder73 = new AttributesBuilder();
                            attributesBuilder73.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder73.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit73 = Unit.INSTANCE;
                            return new Endpoint(url75, null, attributesBuilder73.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url76 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring33 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder74 = new AttributesBuilder();
                            attributesBuilder74.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder74.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit74 = Unit.INSTANCE;
                            return new Endpoint(url76, null, attributesBuilder74.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url77 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring33 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder75 = new AttributesBuilder();
                            attributesBuilder75.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder75.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit75 = Unit.INSTANCE;
                            return new Endpoint(url77, null, attributesBuilder75.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url78 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring33 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder76 = new AttributesBuilder();
                            attributesBuilder76.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder76.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit76 = Unit.INSTANCE;
                            return new Endpoint(url78, null, attributesBuilder76.getAttributes(), 2, null);
                        }
                    }
                    String strSubstring35 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 7, 16, true);
                    String strSubstring36 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 16, 18, true);
                    if (strSubstring35 != null && strSubstring36 != null && Intrinsics.areEqual(strSubstring36, "--")) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url79 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring35 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder77 = new AttributesBuilder();
                            attributesBuilder77.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder77.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit77 = Unit.INSTANCE;
                            return new Endpoint(url79, null, attributesBuilder77.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url80 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring35 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder78 = new AttributesBuilder();
                            attributesBuilder78.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder78.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit78 = Unit.INSTANCE;
                            return new Endpoint(url80, null, attributesBuilder78.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url81 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring35 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder79 = new AttributesBuilder();
                            attributesBuilder79.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder79.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit79 = Unit.INSTANCE;
                            return new Endpoint(url81, null, attributesBuilder79.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url82 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring35 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder80 = new AttributesBuilder();
                            attributesBuilder80.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder80.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit80 = Unit.INSTANCE;
                            return new Endpoint(url82, null, attributesBuilder80.getAttributes(), 2, null);
                        }
                    }
                    String strSubstring37 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 7, 20, true);
                    String strSubstring38 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 20, 22, true);
                    if (strSubstring37 != null && strSubstring38 != null && Intrinsics.areEqual(strSubstring38, "--")) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url83 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring37 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder81 = new AttributesBuilder();
                            attributesBuilder81.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder81.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit81 = Unit.INSTANCE;
                            return new Endpoint(url83, null, attributesBuilder81.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url84 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring37 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder82 = new AttributesBuilder();
                            attributesBuilder82.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder82.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit82 = Unit.INSTANCE;
                            return new Endpoint(url84, null, attributesBuilder82.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url85 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring37 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder83 = new AttributesBuilder();
                            attributesBuilder83.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder83.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit83 = Unit.INSTANCE;
                            return new Endpoint(url85, null, attributesBuilder83.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url86 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring37 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder84 = new AttributesBuilder();
                            attributesBuilder84.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder84.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit84 = Unit.INSTANCE;
                            return new Endpoint(url86, null, attributesBuilder84.getAttributes(), 2, null);
                        }
                    }
                    String strSubstring39 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 7, 21, true);
                    String strSubstring40 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 21, 23, true);
                    if (strSubstring39 != null && strSubstring40 != null && Intrinsics.areEqual(strSubstring40, "--")) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url87 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring39 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder85 = new AttributesBuilder();
                            attributesBuilder85.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder85.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit85 = Unit.INSTANCE;
                            return new Endpoint(url87, null, attributesBuilder85.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url88 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring39 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder86 = new AttributesBuilder();
                            attributesBuilder86.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder86.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit86 = Unit.INSTANCE;
                            return new Endpoint(url88, null, attributesBuilder86.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url89 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring39 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder87 = new AttributesBuilder();
                            attributesBuilder87.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder87.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit87 = Unit.INSTANCE;
                            return new Endpoint(url89, null, attributesBuilder87.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url90 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring39 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder88 = new AttributesBuilder();
                            attributesBuilder88.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder88.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit88 = Unit.INSTANCE;
                            return new Endpoint(url90, null, attributesBuilder88.getAttributes(), 2, null);
                        }
                    }
                    String strSubstring41 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 7, 27, true);
                    String strSubstring42 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 27, 29, true);
                    if (strSubstring41 != null && strSubstring42 != null && Intrinsics.areEqual(strSubstring42, "--")) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url91 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring41 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder89 = new AttributesBuilder();
                            attributesBuilder89.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder89.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit89 = Unit.INSTANCE;
                            return new Endpoint(url91, null, attributesBuilder89.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url92 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-fips-" + strSubstring41 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder90 = new AttributesBuilder();
                            attributesBuilder90.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder90.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit90 = Unit.INSTANCE;
                            return new Endpoint(url92, null, attributesBuilder90.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url93 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring41 + ".dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder91 = new AttributesBuilder();
                            attributesBuilder91.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder91.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit91 = Unit.INSTANCE;
                            return new Endpoint(url93, null, attributesBuilder91.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url94 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3express-" + strSubstring41 + '.' + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition9.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder92 = new AttributesBuilder();
                            attributesBuilder92.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                            attributesBuilder92.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit92 = Unit.INSTANCE;
                            return new Endpoint(url94, null, attributesBuilder92.getAttributes(), 2, null);
                        }
                    }
                    throw new EndpointProviderException("Unrecognized S3Express bucket name format.");
                }
                throw new EndpointProviderException("S3Express bucket name is not a valid virtual hostable name.");
            }
            if (s3EndpointParameters.getBucket() == null && s3EndpointParameters.getUseS3ExpressControlEndpoint() != null && Intrinsics.areEqual(s3EndpointParameters.getUseS3ExpressControlEndpoint(), Boxing.boxBoolean(true)) && (partitionConfigPartition8 = PartitionsKt.partition(s3EndpointParameters.getRegion())) != null) {
                aws.smithy.kotlin.runtime.client.endpoints.functions.Url url95 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                if (url95 != null && s3EndpointParameters.getEndpoint() != null) {
                    aws.smithy.kotlin.runtime.net.url.Url url96 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url95.getScheme() + "://" + url95.getAuthority() + url95.getPath(), null, 2, null);
                    AttributesBuilder attributesBuilder93 = new AttributesBuilder();
                    attributesBuilder93.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                    attributesBuilder93.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                    Unit unit93 = Unit.INSTANCE;
                    return new Endpoint(url96, null, attributesBuilder93.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                    aws.smithy.kotlin.runtime.net.url.Url url97 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3express-control-fips.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition8.getDnsSuffix(), null, 2, null);
                    AttributesBuilder attributesBuilder94 = new AttributesBuilder();
                    attributesBuilder94.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                    attributesBuilder94.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                    Unit unit94 = Unit.INSTANCE;
                    return new Endpoint(url97, null, attributesBuilder94.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                    aws.smithy.kotlin.runtime.net.url.Url url98 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3express-control-fips." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition8.getDnsSuffix(), null, 2, null);
                    AttributesBuilder attributesBuilder95 = new AttributesBuilder();
                    attributesBuilder95.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                    attributesBuilder95.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                    Unit unit95 = Unit.INSTANCE;
                    return new Endpoint(url98, null, attributesBuilder95.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                    aws.smithy.kotlin.runtime.net.url.Url url99 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3express-control.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition8.getDnsSuffix(), null, 2, null);
                    AttributesBuilder attributesBuilder96 = new AttributesBuilder();
                    attributesBuilder96.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                    attributesBuilder96.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                    Unit unit96 = Unit.INSTANCE;
                    return new Endpoint(url99, null, attributesBuilder96.getAttributes(), 2, null);
                }
                if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                    aws.smithy.kotlin.runtime.net.url.Url url100 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3express-control." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition8.getDnsSuffix(), null, 2, null);
                    AttributesBuilder attributesBuilder97 = new AttributesBuilder();
                    attributesBuilder97.m498to(S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_VALUE);
                    attributesBuilder97.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3express", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                    Unit unit97 = Unit.INSTANCE;
                    return new Endpoint(url100, null, attributesBuilder97.getAttributes(), 2, null);
                }
            }
            String strSubstring43 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 49, 50, true);
            String strSubstring44 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 8, 12, true);
            String strSubstring45 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 0, 7, true);
            String strSubstring46 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 32, 49, true);
            PartitionConfig partitionConfigPartition13 = PartitionsKt.partition(s3EndpointParameters.getRegion());
            if (strSubstring43 != null && strSubstring44 != null && strSubstring45 != null && strSubstring46 != null && partitionConfigPartition13 != null && s3EndpointParameters.getBucket() != null && Intrinsics.areEqual(strSubstring45, "--op-s3")) {
                if (FunctionsKt.isValidHostLabel(strSubstring46, false)) {
                    if (aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.isVirtualHostableS3Bucket(s3EndpointParameters.getBucket(), false)) {
                        if (Intrinsics.areEqual(strSubstring43, "e")) {
                            if (Intrinsics.areEqual(strSubstring44, "beta")) {
                                if (s3EndpointParameters.getEndpoint() == null) {
                                    throw new EndpointProviderException("Expected a endpoint to be specified but no endpoint was found");
                                }
                                aws.smithy.kotlin.runtime.client.endpoints.functions.Url url101 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                                if (url101 != null && s3EndpointParameters.getEndpoint() != null) {
                                    aws.smithy.kotlin.runtime.net.url.Url url102 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".ec2." + url101.getAuthority(), null, 2, null);
                                    AttributesBuilder attributesBuilder98 = new AttributesBuilder();
                                    attributesBuilder98.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf((Object[]) new AuthOption[]{SigV4AsymmetricAuthSchemeKt.sigV4A$default(false, "s3-outposts", CollectionsKt.listOf("*"), Boxing.boxBoolean(true), null, 17, null), SigV4AuthSchemeKt.sigV4$default(false, "s3-outposts", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)}));
                                    Unit unit98 = Unit.INSTANCE;
                                    return new Endpoint(url102, null, attributesBuilder98.getAttributes(), 2, null);
                                }
                            }
                            aws.smithy.kotlin.runtime.net.url.Url url103 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".ec2.s3-outposts." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition13.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder99 = new AttributesBuilder();
                            attributesBuilder99.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf((Object[]) new AuthOption[]{SigV4AsymmetricAuthSchemeKt.sigV4A$default(false, "s3-outposts", CollectionsKt.listOf("*"), Boxing.boxBoolean(true), null, 17, null), SigV4AuthSchemeKt.sigV4$default(false, "s3-outposts", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)}));
                            Unit unit99 = Unit.INSTANCE;
                            return new Endpoint(url103, null, attributesBuilder99.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(strSubstring43, "o")) {
                            if (Intrinsics.areEqual(strSubstring44, "beta")) {
                                if (s3EndpointParameters.getEndpoint() == null) {
                                    throw new EndpointProviderException("Expected a endpoint to be specified but no endpoint was found");
                                }
                                aws.smithy.kotlin.runtime.client.endpoints.functions.Url url104 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                                if (url104 != null && s3EndpointParameters.getEndpoint() != null) {
                                    aws.smithy.kotlin.runtime.net.url.Url url105 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".op-" + strSubstring46 + '.' + url104.getAuthority(), null, 2, null);
                                    AttributesBuilder attributesBuilder100 = new AttributesBuilder();
                                    attributesBuilder100.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf((Object[]) new AuthOption[]{SigV4AsymmetricAuthSchemeKt.sigV4A$default(false, "s3-outposts", CollectionsKt.listOf("*"), Boxing.boxBoolean(true), null, 17, null), SigV4AuthSchemeKt.sigV4$default(false, "s3-outposts", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)}));
                                    Unit unit100 = Unit.INSTANCE;
                                    return new Endpoint(url105, null, attributesBuilder100.getAttributes(), 2, null);
                                }
                            }
                            aws.smithy.kotlin.runtime.net.url.Url url106 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".op-" + strSubstring46 + ".s3-outposts." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition13.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder101 = new AttributesBuilder();
                            attributesBuilder101.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf((Object[]) new AuthOption[]{SigV4AsymmetricAuthSchemeKt.sigV4A$default(false, "s3-outposts", CollectionsKt.listOf("*"), Boxing.boxBoolean(true), null, 17, null), SigV4AuthSchemeKt.sigV4$default(false, "s3-outposts", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)}));
                            Unit unit101 = Unit.INSTANCE;
                            return new Endpoint(url106, null, attributesBuilder101.getAttributes(), 2, null);
                        }
                        throw new EndpointProviderException("Unrecognized hardware type: \"Expected hardware type o or e but got " + strSubstring43 + '\"');
                    }
                    throw new EndpointProviderException("Invalid Outposts Bucket alias - it must be a valid bucket name.");
                }
                throw new EndpointProviderException("Invalid ARN: The outpost Id must only contain a-z, A-Z, 0-9 and `-`.");
            }
            if (s3EndpointParameters.getBucket() != null) {
                if (s3EndpointParameters.getEndpoint() != null && FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint()) == null) {
                    throw new EndpointProviderException("Custom endpoint `" + s3EndpointParameters.getEndpoint() + "` was not a valid URI");
                }
                if (Intrinsics.areEqual(s3EndpointParameters.getForcePathStyle(), Boxing.boxBoolean(false)) && aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.isVirtualHostableS3Bucket(s3EndpointParameters.getBucket(), false) && (partitionConfigPartition7 = PartitionsKt.partition(s3EndpointParameters.getRegion())) != null) {
                    if (FunctionsKt.isValidHostLabel(s3EndpointParameters.getRegion(), false)) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(partitionConfigPartition7.getName(), "aws-cn")) {
                            throw new EndpointProviderException("S3 Accelerate cannot be used in this region");
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url107 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-fips.dualstack.us-east-1." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder102 = new AttributesBuilder();
                            attributesBuilder102.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit102 = Unit.INSTANCE;
                            return new Endpoint(url107, null, attributesBuilder102.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url108 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-fips.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder103 = new AttributesBuilder();
                            attributesBuilder103.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit103 = Unit.INSTANCE;
                            return new Endpoint(url108, null, attributesBuilder103.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url109 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-fips.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder104 = new AttributesBuilder();
                            attributesBuilder104.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit104 = Unit.INSTANCE;
                            return new Endpoint(url109, null, attributesBuilder104.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url110 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-fips.us-east-1." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder105 = new AttributesBuilder();
                            attributesBuilder105.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit105 = Unit.INSTANCE;
                            return new Endpoint(url110, null, attributesBuilder105.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url111 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-fips." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder106 = new AttributesBuilder();
                            attributesBuilder106.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit106 = Unit.INSTANCE;
                            return new Endpoint(url111, null, attributesBuilder106.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url112 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-fips." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder107 = new AttributesBuilder();
                            attributesBuilder107.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit107 = Unit.INSTANCE;
                            return new Endpoint(url112, null, attributesBuilder107.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url113 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-accelerate.dualstack.us-east-1." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder108 = new AttributesBuilder();
                            attributesBuilder108.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit108 = Unit.INSTANCE;
                            return new Endpoint(url113, null, attributesBuilder108.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url114 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-accelerate.dualstack." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder109 = new AttributesBuilder();
                            attributesBuilder109.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit109 = Unit.INSTANCE;
                            return new Endpoint(url114, null, attributesBuilder109.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url115 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-accelerate.dualstack." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder110 = new AttributesBuilder();
                            attributesBuilder110.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit110 = Unit.INSTANCE;
                            return new Endpoint(url115, null, attributesBuilder110.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url116 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3.dualstack.us-east-1." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder111 = new AttributesBuilder();
                            attributesBuilder111.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit111 = Unit.INSTANCE;
                            return new Endpoint(url116, null, attributesBuilder111.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url117 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder112 = new AttributesBuilder();
                            attributesBuilder112.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit112 = Unit.INSTANCE;
                            return new Endpoint(url117, null, attributesBuilder112.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url118 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder113 = new AttributesBuilder();
                            attributesBuilder113.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit113 = Unit.INSTANCE;
                            return new Endpoint(url118, null, attributesBuilder113.getAttributes(), 2, null);
                        }
                        aws.smithy.kotlin.runtime.client.endpoints.functions.Url url119 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                        if (url119 != null && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && url119.isIp() && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url120 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url119.getScheme() + "://" + url119.getAuthority() + url119.getNormalizedPath() + s3EndpointParameters.getBucket(), null, 2, null);
                            AttributesBuilder attributesBuilder114 = new AttributesBuilder();
                            attributesBuilder114.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit114 = Unit.INSTANCE;
                            return new Endpoint(url120, null, attributesBuilder114.getAttributes(), 2, null);
                        }
                        aws.smithy.kotlin.runtime.client.endpoints.functions.Url url121 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                        if (url121 != null && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && !url121.isIp() && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url122 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url121.getScheme() + "://" + s3EndpointParameters.getBucket() + '.' + url121.getAuthority() + url121.getPath(), null, 2, null);
                            AttributesBuilder attributesBuilder115 = new AttributesBuilder();
                            attributesBuilder115.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit115 = Unit.INSTANCE;
                            return new Endpoint(url122, null, attributesBuilder115.getAttributes(), 2, null);
                        }
                        aws.smithy.kotlin.runtime.client.endpoints.functions.Url url123 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                        if (url123 != null && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && url123.isIp() && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getRegion(), "us-east-1")) {
                                aws.smithy.kotlin.runtime.net.url.Url url124 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url123.getScheme() + "://" + url123.getAuthority() + url123.getNormalizedPath() + s3EndpointParameters.getBucket(), null, 2, null);
                                AttributesBuilder attributesBuilder116 = new AttributesBuilder();
                                attributesBuilder116.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit116 = Unit.INSTANCE;
                                return new Endpoint(url124, null, attributesBuilder116.getAttributes(), 2, null);
                            }
                            aws.smithy.kotlin.runtime.net.url.Url url125 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url123.getScheme() + "://" + url123.getAuthority() + url123.getNormalizedPath() + s3EndpointParameters.getBucket(), null, 2, null);
                            AttributesBuilder attributesBuilder117 = new AttributesBuilder();
                            attributesBuilder117.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit117 = Unit.INSTANCE;
                            return new Endpoint(url125, null, attributesBuilder117.getAttributes(), 2, null);
                        }
                        aws.smithy.kotlin.runtime.client.endpoints.functions.Url url126 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                        if (url126 != null && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && !url126.isIp() && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getRegion(), "us-east-1")) {
                                aws.smithy.kotlin.runtime.net.url.Url url127 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url126.getScheme() + "://" + s3EndpointParameters.getBucket() + '.' + url126.getAuthority() + url126.getPath(), null, 2, null);
                                AttributesBuilder attributesBuilder118 = new AttributesBuilder();
                                attributesBuilder118.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit118 = Unit.INSTANCE;
                                return new Endpoint(url127, null, attributesBuilder118.getAttributes(), 2, null);
                            }
                            aws.smithy.kotlin.runtime.net.url.Url url128 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url126.getScheme() + "://" + s3EndpointParameters.getBucket() + '.' + url126.getAuthority() + url126.getPath(), null, 2, null);
                            AttributesBuilder attributesBuilder119 = new AttributesBuilder();
                            attributesBuilder119.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit119 = Unit.INSTANCE;
                            return new Endpoint(url128, null, attributesBuilder119.getAttributes(), 2, null);
                        }
                        aws.smithy.kotlin.runtime.client.endpoints.functions.Url url129 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                        if (url129 != null && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && url129.isIp() && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url130 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url129.getScheme() + "://" + url129.getAuthority() + url129.getNormalizedPath() + s3EndpointParameters.getBucket(), null, 2, null);
                            AttributesBuilder attributesBuilder120 = new AttributesBuilder();
                            attributesBuilder120.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit120 = Unit.INSTANCE;
                            return new Endpoint(url130, null, attributesBuilder120.getAttributes(), 2, null);
                        }
                        aws.smithy.kotlin.runtime.client.endpoints.functions.Url url131 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                        if (url131 != null && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && !url131.isIp() && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url132 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url131.getScheme() + "://" + s3EndpointParameters.getBucket() + '.' + url131.getAuthority() + url131.getPath(), null, 2, null);
                            AttributesBuilder attributesBuilder121 = new AttributesBuilder();
                            attributesBuilder121.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit121 = Unit.INSTANCE;
                            return new Endpoint(url132, null, attributesBuilder121.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url133 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-accelerate." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder122 = new AttributesBuilder();
                            attributesBuilder122.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit122 = Unit.INSTANCE;
                            return new Endpoint(url133, null, attributesBuilder122.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getRegion(), "us-east-1")) {
                                aws.smithy.kotlin.runtime.net.url.Url url134 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-accelerate." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder123 = new AttributesBuilder();
                                attributesBuilder123.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit123 = Unit.INSTANCE;
                                return new Endpoint(url134, null, attributesBuilder123.getAttributes(), 2, null);
                            }
                            aws.smithy.kotlin.runtime.net.url.Url url135 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-accelerate." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder124 = new AttributesBuilder();
                            attributesBuilder124.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit124 = Unit.INSTANCE;
                            return new Endpoint(url135, null, attributesBuilder124.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url136 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3-accelerate." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder125 = new AttributesBuilder();
                            attributesBuilder125.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit125 = Unit.INSTANCE;
                            return new Endpoint(url136, null, attributesBuilder125.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url137 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder126 = new AttributesBuilder();
                            attributesBuilder126.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit126 = Unit.INSTANCE;
                            return new Endpoint(url137, null, attributesBuilder126.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getRegion(), "us-east-1")) {
                                aws.smithy.kotlin.runtime.net.url.Url url138 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3." + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                                AttributesBuilder attributesBuilder127 = new AttributesBuilder();
                                attributesBuilder127.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit127 = Unit.INSTANCE;
                                return new Endpoint(url138, null, attributesBuilder127.getAttributes(), 2, null);
                            }
                            aws.smithy.kotlin.runtime.net.url.Url url139 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder128 = new AttributesBuilder();
                            attributesBuilder128.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit128 = Unit.INSTANCE;
                            return new Endpoint(url139, null, attributesBuilder128.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url140 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + s3EndpointParameters.getBucket() + ".s3." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition7.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder129 = new AttributesBuilder();
                            attributesBuilder129.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit129 = Unit.INSTANCE;
                            return new Endpoint(url140, null, attributesBuilder129.getAttributes(), 2, null);
                        }
                    }
                    throw new EndpointProviderException("Invalid region: region was not a valid DNS name.");
                }
                aws.smithy.kotlin.runtime.client.endpoints.functions.Url url141 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                if (url141 != null && s3EndpointParameters.getEndpoint() != null && Intrinsics.areEqual(url141.getScheme(), "http") && aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.isVirtualHostableS3Bucket(s3EndpointParameters.getBucket(), true) && Intrinsics.areEqual(s3EndpointParameters.getForcePathStyle(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false)) && PartitionsKt.partition(s3EndpointParameters.getRegion()) != null) {
                    if (FunctionsKt.isValidHostLabel(s3EndpointParameters.getRegion(), false)) {
                        aws.smithy.kotlin.runtime.net.url.Url url142 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url141.getScheme() + "://" + s3EndpointParameters.getBucket() + '.' + url141.getAuthority() + url141.getPath(), null, 2, null);
                        AttributesBuilder attributesBuilder130 = new AttributesBuilder();
                        attributesBuilder130.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit130 = Unit.INSTANCE;
                        return new Endpoint(url142, null, attributesBuilder130.getAttributes(), 2, null);
                    }
                    throw new EndpointProviderException("Invalid region: region was not a valid DNS name.");
                }
                Arn arn = aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.parseArn(s3EndpointParameters.getBucket());
                if (arn != null && Intrinsics.areEqual(s3EndpointParameters.getForcePathStyle(), Boxing.boxBoolean(false))) {
                    List<String> resourceId = arn.getResourceId();
                    String str = resourceId != null ? (String) CollectionsKt.getOrNull(resourceId, 0) : null;
                    if (str != null && !Intrinsics.areEqual(str, "")) {
                        if (Intrinsics.areEqual(arn.getService(), "s3-object-lambda")) {
                            if (Intrinsics.areEqual(str, "accesspoint")) {
                                List<String> resourceId2 = arn.getResourceId();
                                String str2 = resourceId2 != null ? (String) CollectionsKt.getOrNull(resourceId2, 1) : null;
                                if (str2 != null && !Intrinsics.areEqual(str2, "")) {
                                    if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                        throw new EndpointProviderException("S3 Object Lambda does not support Dual-stack");
                                    }
                                    if (Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true))) {
                                        throw new EndpointProviderException("S3 Object Lambda does not support S3 Accelerate");
                                    }
                                    if (!Intrinsics.areEqual(arn.getRegion(), "")) {
                                        if (s3EndpointParameters.getDisableAccessPoints() != null && Intrinsics.areEqual(s3EndpointParameters.getDisableAccessPoints(), Boxing.boxBoolean(true))) {
                                            throw new EndpointProviderException("Access points are not supported for this operation");
                                        }
                                        List<String> resourceId3 = arn.getResourceId();
                                        if ((resourceId3 != null ? (String) CollectionsKt.getOrNull(resourceId3, 2) : null) == null) {
                                            if (s3EndpointParameters.getUseArnRegion() != null && Intrinsics.areEqual(s3EndpointParameters.getUseArnRegion(), Boxing.boxBoolean(false)) && !Intrinsics.areEqual(arn.getRegion(), String.valueOf(s3EndpointParameters.getRegion()))) {
                                                throw new EndpointProviderException("Invalid configuration: region from ARN `" + arn.getRegion() + "` does not match client region `" + s3EndpointParameters.getRegion() + "` and UseArnRegion is `false`");
                                            }
                                            PartitionConfig partitionConfigPartition14 = PartitionsKt.partition(arn.getRegion());
                                            if (partitionConfigPartition14 != null && (partitionConfigPartition6 = PartitionsKt.partition(s3EndpointParameters.getRegion())) != null) {
                                                if (Intrinsics.areEqual(partitionConfigPartition14.getName(), partitionConfigPartition6.getName())) {
                                                    if (FunctionsKt.isValidHostLabel(arn.getRegion(), true)) {
                                                        if (Intrinsics.areEqual(arn.getAccountId(), "")) {
                                                            throw new EndpointProviderException("Invalid ARN: Missing account id");
                                                        }
                                                        if (FunctionsKt.isValidHostLabel(arn.getAccountId(), false)) {
                                                            if (FunctionsKt.isValidHostLabel(str2, false)) {
                                                                aws.smithy.kotlin.runtime.client.endpoints.functions.Url url143 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                                                                if (url143 != null && s3EndpointParameters.getEndpoint() != null) {
                                                                    aws.smithy.kotlin.runtime.net.url.Url url144 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url143.getScheme() + "://" + str2 + Soundex.SILENT_MARKER + arn.getAccountId() + '.' + url143.getAuthority() + url143.getPath(), null, 2, null);
                                                                    AttributesBuilder attributesBuilder131 = new AttributesBuilder();
                                                                    attributesBuilder131.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3-object-lambda", String.valueOf(arn.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                                                    Unit unit131 = Unit.INSTANCE;
                                                                    return new Endpoint(url144, null, attributesBuilder131.getAttributes(), 2, null);
                                                                }
                                                                if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true))) {
                                                                    aws.smithy.kotlin.runtime.net.url.Url url145 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + str2 + Soundex.SILENT_MARKER + arn.getAccountId() + ".s3-object-lambda-fips." + arn.getRegion() + '.' + partitionConfigPartition14.getDnsSuffix(), null, 2, null);
                                                                    AttributesBuilder attributesBuilder132 = new AttributesBuilder();
                                                                    attributesBuilder132.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3-object-lambda", String.valueOf(arn.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                                                    Unit unit132 = Unit.INSTANCE;
                                                                    return new Endpoint(url145, null, attributesBuilder132.getAttributes(), 2, null);
                                                                }
                                                                aws.smithy.kotlin.runtime.net.url.Url url146 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + str2 + Soundex.SILENT_MARKER + arn.getAccountId() + ".s3-object-lambda." + arn.getRegion() + '.' + partitionConfigPartition14.getDnsSuffix(), null, 2, null);
                                                                AttributesBuilder attributesBuilder133 = new AttributesBuilder();
                                                                attributesBuilder133.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3-object-lambda", String.valueOf(arn.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                                                Unit unit133 = Unit.INSTANCE;
                                                                return new Endpoint(url146, null, attributesBuilder133.getAttributes(), 2, null);
                                                            }
                                                            throw new EndpointProviderException("Invalid ARN: The access point name may only contain a-z, A-Z, 0-9 and `-`. Found: `" + str2 + '`');
                                                        }
                                                        throw new EndpointProviderException("Invalid ARN: The account id may only contain a-z, A-Z, 0-9 and `-`. Found: `" + arn.getAccountId() + '`');
                                                    }
                                                    throw new EndpointProviderException("Invalid region in ARN: `" + arn.getRegion() + "` (invalid DNS name)");
                                                }
                                                throw new EndpointProviderException("Client was configured for partition `" + partitionConfigPartition6.getName() + "` but ARN (`" + s3EndpointParameters.getBucket() + "`) has `" + partitionConfigPartition14.getName() + '`');
                                            }
                                        }
                                        throw new EndpointProviderException("Invalid ARN: The ARN may only contain a single resource component after `accesspoint`.");
                                    }
                                    throw new EndpointProviderException("Invalid ARN: bucket ARN is missing a region");
                                }
                                throw new EndpointProviderException("Invalid ARN: Expected a resource of the format `accesspoint:<accesspoint name>` but no name was provided");
                            }
                            throw new EndpointProviderException("Invalid ARN: Object Lambda ARNs only support `accesspoint` arn types, but found: `" + str + '`');
                        }
                        if (Intrinsics.areEqual(str, "accesspoint")) {
                            List<String> resourceId4 = arn.getResourceId();
                            String str3 = resourceId4 != null ? (String) CollectionsKt.getOrNull(resourceId4, 1) : null;
                            if (str3 != null && !Intrinsics.areEqual(str3, "")) {
                                if (!Intrinsics.areEqual(arn.getRegion(), "") && Intrinsics.areEqual(str, "accesspoint") && !Intrinsics.areEqual(arn.getRegion(), "")) {
                                    if (s3EndpointParameters.getDisableAccessPoints() != null && Intrinsics.areEqual(s3EndpointParameters.getDisableAccessPoints(), Boxing.boxBoolean(true))) {
                                        throw new EndpointProviderException("Access points are not supported for this operation");
                                    }
                                    List<String> resourceId5 = arn.getResourceId();
                                    if ((resourceId5 != null ? (String) CollectionsKt.getOrNull(resourceId5, 2) : null) == null) {
                                        if (s3EndpointParameters.getUseArnRegion() != null && Intrinsics.areEqual(s3EndpointParameters.getUseArnRegion(), Boxing.boxBoolean(false)) && !Intrinsics.areEqual(arn.getRegion(), String.valueOf(s3EndpointParameters.getRegion()))) {
                                            throw new EndpointProviderException("Invalid configuration: region from ARN `" + arn.getRegion() + "` does not match client region `" + s3EndpointParameters.getRegion() + "` and UseArnRegion is `false`");
                                        }
                                        PartitionConfig partitionConfigPartition15 = PartitionsKt.partition(arn.getRegion());
                                        if (partitionConfigPartition15 != null && (partitionConfigPartition5 = PartitionsKt.partition(s3EndpointParameters.getRegion())) != null) {
                                            if (Intrinsics.areEqual(partitionConfigPartition15.getName(), String.valueOf(partitionConfigPartition5.getName()))) {
                                                if (FunctionsKt.isValidHostLabel(arn.getRegion(), true)) {
                                                    if (Intrinsics.areEqual(arn.getService(), "s3")) {
                                                        if (FunctionsKt.isValidHostLabel(arn.getAccountId(), false)) {
                                                            if (FunctionsKt.isValidHostLabel(str3, false)) {
                                                                if (Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true))) {
                                                                    throw new EndpointProviderException("Access Points do not support S3 Accelerate");
                                                                }
                                                                if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                                                    aws.smithy.kotlin.runtime.net.url.Url url147 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + str3 + Soundex.SILENT_MARKER + arn.getAccountId() + ".s3-accesspoint-fips.dualstack." + arn.getRegion() + '.' + partitionConfigPartition15.getDnsSuffix(), null, 2, null);
                                                                    AttributesBuilder attributesBuilder134 = new AttributesBuilder();
                                                                    attributesBuilder134.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(arn.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                                                    Unit unit134 = Unit.INSTANCE;
                                                                    return new Endpoint(url147, null, attributesBuilder134.getAttributes(), 2, null);
                                                                }
                                                                if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                                                    aws.smithy.kotlin.runtime.net.url.Url url148 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + str3 + Soundex.SILENT_MARKER + arn.getAccountId() + ".s3-accesspoint-fips." + arn.getRegion() + '.' + partitionConfigPartition15.getDnsSuffix(), null, 2, null);
                                                                    AttributesBuilder attributesBuilder135 = new AttributesBuilder();
                                                                    attributesBuilder135.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(arn.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                                                    Unit unit135 = Unit.INSTANCE;
                                                                    return new Endpoint(url148, null, attributesBuilder135.getAttributes(), 2, null);
                                                                }
                                                                if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                                                    aws.smithy.kotlin.runtime.net.url.Url url149 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + str3 + Soundex.SILENT_MARKER + arn.getAccountId() + ".s3-accesspoint.dualstack." + arn.getRegion() + '.' + partitionConfigPartition15.getDnsSuffix(), null, 2, null);
                                                                    AttributesBuilder attributesBuilder136 = new AttributesBuilder();
                                                                    attributesBuilder136.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(arn.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                                                    Unit unit136 = Unit.INSTANCE;
                                                                    return new Endpoint(url149, null, attributesBuilder136.getAttributes(), 2, null);
                                                                }
                                                                aws.smithy.kotlin.runtime.client.endpoints.functions.Url url150 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                                                                if (url150 != null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null) {
                                                                    aws.smithy.kotlin.runtime.net.url.Url url151 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url150.getScheme() + "://" + str3 + Soundex.SILENT_MARKER + arn.getAccountId() + '.' + url150.getAuthority() + url150.getPath(), null, 2, null);
                                                                    AttributesBuilder attributesBuilder137 = new AttributesBuilder();
                                                                    attributesBuilder137.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(arn.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                                                    Unit unit137 = Unit.INSTANCE;
                                                                    return new Endpoint(url151, null, attributesBuilder137.getAttributes(), 2, null);
                                                                }
                                                                if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false))) {
                                                                    aws.smithy.kotlin.runtime.net.url.Url url152 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + str3 + Soundex.SILENT_MARKER + arn.getAccountId() + ".s3-accesspoint." + arn.getRegion() + '.' + partitionConfigPartition15.getDnsSuffix(), null, 2, null);
                                                                    AttributesBuilder attributesBuilder138 = new AttributesBuilder();
                                                                    attributesBuilder138.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(arn.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                                                    Unit unit138 = Unit.INSTANCE;
                                                                    return new Endpoint(url152, null, attributesBuilder138.getAttributes(), 2, null);
                                                                }
                                                            }
                                                            throw new EndpointProviderException("Invalid ARN: The access point name may only contain a-z, A-Z, 0-9 and `-`. Found: `" + str3 + '`');
                                                        }
                                                        throw new EndpointProviderException("Invalid ARN: The account id may only contain a-z, A-Z, 0-9 and `-`. Found: `" + arn.getAccountId() + '`');
                                                    }
                                                    throw new EndpointProviderException("Invalid ARN: The ARN was not for the S3 service, found: " + arn.getService());
                                                }
                                                throw new EndpointProviderException("Invalid region in ARN: `" + arn.getRegion() + "` (invalid DNS name)");
                                            }
                                            throw new EndpointProviderException("Client was configured for partition `" + partitionConfigPartition5.getName() + "` but ARN (`" + s3EndpointParameters.getBucket() + "`) has `" + partitionConfigPartition15.getName() + '`');
                                        }
                                    }
                                    throw new EndpointProviderException("Invalid ARN: The ARN may only contain a single resource component after `accesspoint`.");
                                }
                                if (FunctionsKt.isValidHostLabel(str3, true)) {
                                    if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                        throw new EndpointProviderException("S3 MRAP does not support dual-stack");
                                    }
                                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true))) {
                                        throw new EndpointProviderException("S3 MRAP does not support FIPS");
                                    }
                                    if (Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true))) {
                                        throw new EndpointProviderException("S3 MRAP does not support S3 Accelerate");
                                    }
                                    if (Intrinsics.areEqual(s3EndpointParameters.getDisableMultiRegionAccessPoints(), Boxing.boxBoolean(true))) {
                                        throw new EndpointProviderException("Invalid configuration: Multi-Region Access Point ARNs are disabled.");
                                    }
                                    PartitionConfig partitionConfigPartition16 = PartitionsKt.partition(s3EndpointParameters.getRegion());
                                    if (partitionConfigPartition16 != null) {
                                        if (Intrinsics.areEqual(partitionConfigPartition16.getName(), arn.getPartition())) {
                                            aws.smithy.kotlin.runtime.net.url.Url url153 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + str3 + ".accesspoint.s3-global." + partitionConfigPartition16.getDnsSuffix(), null, 2, null);
                                            AttributesBuilder attributesBuilder139 = new AttributesBuilder();
                                            attributesBuilder139.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AsymmetricAuthSchemeKt.sigV4A$default(false, "s3", CollectionsKt.listOf("*"), Boxing.boxBoolean(true), null, 17, null)));
                                            Unit unit139 = Unit.INSTANCE;
                                            return new Endpoint(url153, null, attributesBuilder139.getAttributes(), 2, null);
                                        }
                                        throw new EndpointProviderException("Client was configured for partition `" + partitionConfigPartition16.getName() + "` but bucket referred to partition `" + arn.getPartition() + '`');
                                    }
                                }
                                throw new EndpointProviderException("Invalid Access Point Name");
                            }
                            throw new EndpointProviderException("Invalid ARN: Expected a resource of the format `accesspoint:<accesspoint name>` but no name was provided");
                        }
                        if (Intrinsics.areEqual(arn.getService(), "s3-outposts")) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                                throw new EndpointProviderException("S3 Outposts does not support Dual-stack");
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true))) {
                                throw new EndpointProviderException("S3 Outposts does not support FIPS");
                            }
                            if (Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true))) {
                                throw new EndpointProviderException("S3 Outposts does not support S3 Accelerate");
                            }
                            List<String> resourceId6 = arn.getResourceId();
                            if ((resourceId6 != null ? (String) CollectionsKt.getOrNull(resourceId6, 4) : null) != null) {
                                throw new EndpointProviderException("Invalid Arn: Outpost Access Point ARN contains sub resources");
                            }
                            List<String> resourceId7 = arn.getResourceId();
                            String str4 = resourceId7 != null ? (String) CollectionsKt.getOrNull(resourceId7, 1) : null;
                            if (str4 != null) {
                                if (FunctionsKt.isValidHostLabel(str4, false)) {
                                    if (s3EndpointParameters.getUseArnRegion() != null && Intrinsics.areEqual(s3EndpointParameters.getUseArnRegion(), Boxing.boxBoolean(false)) && !Intrinsics.areEqual(arn.getRegion(), String.valueOf(s3EndpointParameters.getRegion()))) {
                                        throw new EndpointProviderException("Invalid configuration: region from ARN `" + arn.getRegion() + "` does not match client region `" + s3EndpointParameters.getRegion() + "` and UseArnRegion is `false`");
                                    }
                                    PartitionConfig partitionConfigPartition17 = PartitionsKt.partition(arn.getRegion());
                                    if (partitionConfigPartition17 != null && (partitionConfigPartition4 = PartitionsKt.partition(s3EndpointParameters.getRegion())) != null) {
                                        if (Intrinsics.areEqual(partitionConfigPartition17.getName(), partitionConfigPartition4.getName())) {
                                            if (FunctionsKt.isValidHostLabel(arn.getRegion(), true)) {
                                                if (FunctionsKt.isValidHostLabel(arn.getAccountId(), false)) {
                                                    List<String> resourceId8 = arn.getResourceId();
                                                    String str5 = resourceId8 != null ? (String) CollectionsKt.getOrNull(resourceId8, 2) : null;
                                                    if (str5 != null) {
                                                        List<String> resourceId9 = arn.getResourceId();
                                                        String str6 = resourceId9 != null ? (String) CollectionsKt.getOrNull(resourceId9, 3) : null;
                                                        if (str6 != null) {
                                                            if (Intrinsics.areEqual(str5, "accesspoint")) {
                                                                aws.smithy.kotlin.runtime.client.endpoints.functions.Url url154 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                                                                if (url154 != null && s3EndpointParameters.getEndpoint() != null) {
                                                                    aws.smithy.kotlin.runtime.net.url.Url url155 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + str6 + Soundex.SILENT_MARKER + arn.getAccountId() + '.' + str4 + '.' + url154.getAuthority(), null, 2, null);
                                                                    AttributesBuilder attributesBuilder140 = new AttributesBuilder();
                                                                    attributesBuilder140.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf((Object[]) new AuthOption[]{SigV4AsymmetricAuthSchemeKt.sigV4A$default(false, "s3-outposts", CollectionsKt.listOf("*"), Boxing.boxBoolean(true), null, 17, null), SigV4AuthSchemeKt.sigV4$default(false, "s3-outposts", String.valueOf(arn.getRegion()), Boxing.boxBoolean(true), null, 17, null)}));
                                                                    Unit unit140 = Unit.INSTANCE;
                                                                    return new Endpoint(url155, null, attributesBuilder140.getAttributes(), 2, null);
                                                                }
                                                                aws.smithy.kotlin.runtime.net.url.Url url156 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://" + str6 + Soundex.SILENT_MARKER + arn.getAccountId() + '.' + str4 + ".s3-outposts." + arn.getRegion() + '.' + partitionConfigPartition17.getDnsSuffix(), null, 2, null);
                                                                AttributesBuilder attributesBuilder141 = new AttributesBuilder();
                                                                attributesBuilder141.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf((Object[]) new AuthOption[]{SigV4AsymmetricAuthSchemeKt.sigV4A$default(false, "s3-outposts", CollectionsKt.listOf("*"), Boxing.boxBoolean(true), null, 17, null), SigV4AuthSchemeKt.sigV4$default(false, "s3-outposts", String.valueOf(arn.getRegion()), Boxing.boxBoolean(true), null, 17, null)}));
                                                                Unit unit141 = Unit.INSTANCE;
                                                                return new Endpoint(url156, null, attributesBuilder141.getAttributes(), 2, null);
                                                            }
                                                            throw new EndpointProviderException("Expected an outpost type `accesspoint`, found " + str5);
                                                        }
                                                        throw new EndpointProviderException("Invalid ARN: expected an access point name");
                                                    }
                                                    throw new EndpointProviderException("Invalid ARN: Expected a 4-component resource");
                                                }
                                                throw new EndpointProviderException("Invalid ARN: The account id may only contain a-z, A-Z, 0-9 and `-`. Found: `" + arn.getAccountId() + '`');
                                            }
                                            throw new EndpointProviderException("Invalid region in ARN: `" + arn.getRegion() + "` (invalid DNS name)");
                                        }
                                        throw new EndpointProviderException("Client was configured for partition `" + partitionConfigPartition4.getName() + "` but ARN (`" + s3EndpointParameters.getBucket() + "`) has `" + partitionConfigPartition17.getName() + '`');
                                    }
                                }
                                throw new EndpointProviderException("Invalid ARN: The outpost Id may only contain a-z, A-Z, 0-9 and `-`. Found: `" + str4 + '`');
                            }
                            throw new EndpointProviderException("Invalid ARN: The Outpost Id was not set");
                        }
                        throw new EndpointProviderException("Invalid ARN: Unrecognized format: " + s3EndpointParameters.getBucket() + " (type: " + str + ')');
                    }
                    throw new EndpointProviderException("Invalid ARN: No ARN type specified");
                }
                String strSubstring47 = FunctionsKt.substring(s3EndpointParameters.getBucket(), 0, 4, false);
                if (strSubstring47 != null && Intrinsics.areEqual(strSubstring47, "arn:") && aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.parseArn(s3EndpointParameters.getBucket()) == null) {
                    throw new EndpointProviderException("Invalid ARN: `" + s3EndpointParameters.getBucket() + "` was not a valid ARN");
                }
                if (Intrinsics.areEqual(s3EndpointParameters.getForcePathStyle(), Boxing.boxBoolean(true)) && aws.sdk.kotlin.runtime.endpoint.functions.FunctionsKt.parseArn(s3EndpointParameters.getBucket()) != null) {
                    throw new EndpointProviderException("Path-style addressing cannot be used with ARN buckets");
                }
                String strUriEncode6 = FunctionsKt.uriEncode(s3EndpointParameters.getBucket());
                if (strUriEncode6 != null && (partitionConfigPartition3 = PartitionsKt.partition(s3EndpointParameters.getRegion())) != null) {
                    if (Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(false))) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url157 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips.dualstack.us-east-1." + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder142 = new AttributesBuilder();
                            attributesBuilder142.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit142 = Unit.INSTANCE;
                            return new Endpoint(url157, null, attributesBuilder142.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url158 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder143 = new AttributesBuilder();
                            attributesBuilder143.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit143 = Unit.INSTANCE;
                            return new Endpoint(url158, null, attributesBuilder143.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url159 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder144 = new AttributesBuilder();
                            attributesBuilder144.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit144 = Unit.INSTANCE;
                            return new Endpoint(url159, null, attributesBuilder144.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url160 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips.us-east-1." + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder145 = new AttributesBuilder();
                            attributesBuilder145.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit145 = Unit.INSTANCE;
                            return new Endpoint(url160, null, attributesBuilder145.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url161 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder146 = new AttributesBuilder();
                            attributesBuilder146.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit146 = Unit.INSTANCE;
                            return new Endpoint(url161, null, attributesBuilder146.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url162 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder147 = new AttributesBuilder();
                            attributesBuilder147.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit147 = Unit.INSTANCE;
                            return new Endpoint(url162, null, attributesBuilder147.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url163 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3.dualstack.us-east-1." + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder148 = new AttributesBuilder();
                            attributesBuilder148.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit148 = Unit.INSTANCE;
                            return new Endpoint(url163, null, attributesBuilder148.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            aws.smithy.kotlin.runtime.net.url.Url url164 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder149 = new AttributesBuilder();
                            attributesBuilder149.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit149 = Unit.INSTANCE;
                            return new Endpoint(url164, null, attributesBuilder149.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url165 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder150 = new AttributesBuilder();
                            attributesBuilder150.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit150 = Unit.INSTANCE;
                            return new Endpoint(url165, null, attributesBuilder150.getAttributes(), 2, null);
                        }
                        aws.smithy.kotlin.runtime.client.endpoints.functions.Url url166 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                        if (url166 != null && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url167 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url166.getScheme() + "://" + url166.getAuthority() + url166.getNormalizedPath() + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder151 = new AttributesBuilder();
                            attributesBuilder151.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit151 = Unit.INSTANCE;
                            return new Endpoint(url167, null, attributesBuilder151.getAttributes(), 2, null);
                        }
                        aws.smithy.kotlin.runtime.client.endpoints.functions.Url url168 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                        if (url168 != null && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getRegion(), "us-east-1")) {
                                aws.smithy.kotlin.runtime.net.url.Url url169 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url168.getScheme() + "://" + url168.getAuthority() + url168.getNormalizedPath() + strUriEncode6, null, 2, null);
                                AttributesBuilder attributesBuilder152 = new AttributesBuilder();
                                attributesBuilder152.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit152 = Unit.INSTANCE;
                                return new Endpoint(url169, null, attributesBuilder152.getAttributes(), 2, null);
                            }
                            aws.smithy.kotlin.runtime.net.url.Url url170 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url168.getScheme() + "://" + url168.getAuthority() + url168.getNormalizedPath() + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder153 = new AttributesBuilder();
                            attributesBuilder153.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit153 = Unit.INSTANCE;
                            return new Endpoint(url170, null, attributesBuilder153.getAttributes(), 2, null);
                        }
                        aws.smithy.kotlin.runtime.client.endpoints.functions.Url url171 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                        if (url171 != null && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url172 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url171.getScheme() + "://" + url171.getAuthority() + url171.getNormalizedPath() + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder154 = new AttributesBuilder();
                            attributesBuilder154.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit154 = Unit.INSTANCE;
                            return new Endpoint(url172, null, attributesBuilder154.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                            aws.smithy.kotlin.runtime.net.url.Url url173 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3." + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder155 = new AttributesBuilder();
                            attributesBuilder155.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit155 = Unit.INSTANCE;
                            return new Endpoint(url173, null, attributesBuilder155.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                            if (Intrinsics.areEqual(s3EndpointParameters.getRegion(), "us-east-1")) {
                                aws.smithy.kotlin.runtime.net.url.Url url174 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3." + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                                AttributesBuilder attributesBuilder156 = new AttributesBuilder();
                                attributesBuilder156.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                                Unit unit156 = Unit.INSTANCE;
                                return new Endpoint(url174, null, attributesBuilder156.getAttributes(), 2, null);
                            }
                            aws.smithy.kotlin.runtime.net.url.Url url175 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder157 = new AttributesBuilder();
                            attributesBuilder157.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit157 = Unit.INSTANCE;
                            return new Endpoint(url175, null, attributesBuilder157.getAttributes(), 2, null);
                        }
                        if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                            aws.smithy.kotlin.runtime.net.url.Url url176 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition3.getDnsSuffix() + JsonPointer.SEPARATOR + strUriEncode6, null, 2, null);
                            AttributesBuilder attributesBuilder158 = new AttributesBuilder();
                            attributesBuilder158.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit158 = Unit.INSTANCE;
                            return new Endpoint(url176, null, attributesBuilder158.getAttributes(), 2, null);
                        }
                    }
                    throw new EndpointProviderException("Path-style addressing cannot be used with S3 Accelerate");
                }
            }
            if (s3EndpointParameters.getUseObjectLambdaEndpoint() != null && Intrinsics.areEqual(s3EndpointParameters.getUseObjectLambdaEndpoint(), Boxing.boxBoolean(true)) && (partitionConfigPartition2 = PartitionsKt.partition(s3EndpointParameters.getRegion())) != null) {
                if (FunctionsKt.isValidHostLabel(s3EndpointParameters.getRegion(), true)) {
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true))) {
                        throw new EndpointProviderException("S3 Object Lambda does not support Dual-stack");
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getAccelerate(), Boxing.boxBoolean(true))) {
                        throw new EndpointProviderException("S3 Object Lambda does not support S3 Accelerate");
                    }
                    aws.smithy.kotlin.runtime.client.endpoints.functions.Url url177 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                    if (url177 != null && s3EndpointParameters.getEndpoint() != null) {
                        aws.smithy.kotlin.runtime.net.url.Url url178 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url177.getScheme() + "://" + url177.getAuthority() + url177.getPath(), null, 2, null);
                        AttributesBuilder attributesBuilder159 = new AttributesBuilder();
                        attributesBuilder159.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3-object-lambda", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit159 = Unit.INSTANCE;
                        return new Endpoint(url178, null, attributesBuilder159.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true))) {
                        aws.smithy.kotlin.runtime.net.url.Url url179 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-object-lambda-fips." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition2.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder160 = new AttributesBuilder();
                        attributesBuilder160.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3-object-lambda", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit160 = Unit.INSTANCE;
                        return new Endpoint(url179, null, attributesBuilder160.getAttributes(), 2, null);
                    }
                    aws.smithy.kotlin.runtime.net.url.Url url180 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-object-lambda." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition2.getDnsSuffix(), null, 2, null);
                    AttributesBuilder attributesBuilder161 = new AttributesBuilder();
                    attributesBuilder161.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3-object-lambda", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                    Unit unit161 = Unit.INSTANCE;
                    return new Endpoint(url180, null, attributesBuilder161.getAttributes(), 2, null);
                }
                throw new EndpointProviderException("Invalid region: region was not a valid DNS name.");
            }
            if (s3EndpointParameters.getBucket() == null && (partitionConfigPartition = PartitionsKt.partition(s3EndpointParameters.getRegion())) != null) {
                if (FunctionsKt.isValidHostLabel(s3EndpointParameters.getRegion(), true)) {
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                        aws.smithy.kotlin.runtime.net.url.Url url181 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips.dualstack.us-east-1." + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder162 = new AttributesBuilder();
                        attributesBuilder162.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit162 = Unit.INSTANCE;
                        return new Endpoint(url181, null, attributesBuilder162.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                        aws.smithy.kotlin.runtime.net.url.Url url182 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder163 = new AttributesBuilder();
                        attributesBuilder163.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit163 = Unit.INSTANCE;
                        return new Endpoint(url182, null, attributesBuilder163.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                        aws.smithy.kotlin.runtime.net.url.Url url183 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder164 = new AttributesBuilder();
                        attributesBuilder164.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit164 = Unit.INSTANCE;
                        return new Endpoint(url183, null, attributesBuilder164.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                        aws.smithy.kotlin.runtime.net.url.Url url184 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips.us-east-1." + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder165 = new AttributesBuilder();
                        attributesBuilder165.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit165 = Unit.INSTANCE;
                        return new Endpoint(url184, null, attributesBuilder165.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                        aws.smithy.kotlin.runtime.net.url.Url url185 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder166 = new AttributesBuilder();
                        attributesBuilder166.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit166 = Unit.INSTANCE;
                        return new Endpoint(url185, null, attributesBuilder166.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                        aws.smithy.kotlin.runtime.net.url.Url url186 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3-fips." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder167 = new AttributesBuilder();
                        attributesBuilder167.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit167 = Unit.INSTANCE;
                        return new Endpoint(url186, null, attributesBuilder167.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                        aws.smithy.kotlin.runtime.net.url.Url url187 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3.dualstack.us-east-1." + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder168 = new AttributesBuilder();
                        attributesBuilder168.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit168 = Unit.INSTANCE;
                        return new Endpoint(url187, null, attributesBuilder168.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                        aws.smithy.kotlin.runtime.net.url.Url url188 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder169 = new AttributesBuilder();
                        attributesBuilder169.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit169 = Unit.INSTANCE;
                        return new Endpoint(url188, null, attributesBuilder169.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(true)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                        aws.smithy.kotlin.runtime.net.url.Url url189 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3.dualstack." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder170 = new AttributesBuilder();
                        attributesBuilder170.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit170 = Unit.INSTANCE;
                        return new Endpoint(url189, null, attributesBuilder170.getAttributes(), 2, null);
                    }
                    aws.smithy.kotlin.runtime.client.endpoints.functions.Url url190 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                    if (url190 != null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                        aws.smithy.kotlin.runtime.net.url.Url url191 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url190.getScheme() + "://" + url190.getAuthority() + url190.getPath(), null, 2, null);
                        AttributesBuilder attributesBuilder171 = new AttributesBuilder();
                        attributesBuilder171.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit171 = Unit.INSTANCE;
                        return new Endpoint(url191, null, attributesBuilder171.getAttributes(), 2, null);
                    }
                    aws.smithy.kotlin.runtime.client.endpoints.functions.Url url192 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                    if (url192 != null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getRegion(), "us-east-1")) {
                            aws.smithy.kotlin.runtime.net.url.Url url193 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url192.getScheme() + "://" + url192.getAuthority() + url192.getPath(), null, 2, null);
                            AttributesBuilder attributesBuilder172 = new AttributesBuilder();
                            attributesBuilder172.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit172 = Unit.INSTANCE;
                            return new Endpoint(url193, null, attributesBuilder172.getAttributes(), 2, null);
                        }
                        aws.smithy.kotlin.runtime.net.url.Url url194 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url192.getScheme() + "://" + url192.getAuthority() + url192.getPath(), null, 2, null);
                        AttributesBuilder attributesBuilder173 = new AttributesBuilder();
                        attributesBuilder173.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit173 = Unit.INSTANCE;
                        return new Endpoint(url194, null, attributesBuilder173.getAttributes(), 2, null);
                    }
                    aws.smithy.kotlin.runtime.client.endpoints.functions.Url url195 = FunctionsKt.parseUrl(s3EndpointParameters.getEndpoint());
                    if (url195 != null && Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() != null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                        aws.smithy.kotlin.runtime.net.url.Url url196 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, url195.getScheme() + "://" + url195.getAuthority() + url195.getPath(), null, 2, null);
                        AttributesBuilder attributesBuilder174 = new AttributesBuilder();
                        attributesBuilder174.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit174 = Unit.INSTANCE;
                        return new Endpoint(url196, null, attributesBuilder174.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global")) {
                        aws.smithy.kotlin.runtime.net.url.Url url197 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3." + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder175 = new AttributesBuilder();
                        attributesBuilder175.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", "us-east-1", Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit175 = Unit.INSTANCE;
                        return new Endpoint(url197, null, attributesBuilder175.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(true))) {
                        if (Intrinsics.areEqual(s3EndpointParameters.getRegion(), "us-east-1")) {
                            aws.smithy.kotlin.runtime.net.url.Url url198 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3." + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                            AttributesBuilder attributesBuilder176 = new AttributesBuilder();
                            attributesBuilder176.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                            Unit unit176 = Unit.INSTANCE;
                            return new Endpoint(url198, null, attributesBuilder176.getAttributes(), 2, null);
                        }
                        aws.smithy.kotlin.runtime.net.url.Url url199 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder177 = new AttributesBuilder();
                        attributesBuilder177.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit177 = Unit.INSTANCE;
                        return new Endpoint(url199, null, attributesBuilder177.getAttributes(), 2, null);
                    }
                    if (Intrinsics.areEqual(s3EndpointParameters.getUseFips(), Boxing.boxBoolean(false)) && Intrinsics.areEqual(s3EndpointParameters.getUseDualStack(), Boxing.boxBoolean(false)) && s3EndpointParameters.getEndpoint() == null && !Intrinsics.areEqual(s3EndpointParameters.getRegion(), "aws-global") && Intrinsics.areEqual(s3EndpointParameters.getUseGlobalEndpoint(), Boxing.boxBoolean(false))) {
                        aws.smithy.kotlin.runtime.net.url.Url url200 = Url.Companion.parse$default(aws.smithy.kotlin.runtime.net.url.Url.INSTANCE, "https://s3." + s3EndpointParameters.getRegion() + '.' + partitionConfigPartition.getDnsSuffix(), null, 2, null);
                        AttributesBuilder attributesBuilder178 = new AttributesBuilder();
                        attributesBuilder178.m497to(SigningContextKt.getSigningContextAttributeKey(), CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, "s3", String.valueOf(s3EndpointParameters.getRegion()), Boxing.boxBoolean(true), null, 17, null)));
                        Unit unit178 = Unit.INSTANCE;
                        return new Endpoint(url200, null, attributesBuilder178.getAttributes(), 2, null);
                    }
                }
                throw new EndpointProviderException("Invalid region: region was not a valid DNS name.");
            }
        }
        throw new EndpointProviderException("A region must be set when sending requests to S3.");
    }
}
