package aws.sdk.kotlin.services.p010s3.endpoints.internal;

import aws.sdk.kotlin.services.p010s3.endpoints.S3EndpointParameters;
import aws.smithy.kotlin.runtime.http.operation.ResolveEndpointRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EndpointResolverAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class EndpointResolverAdapterKt$opContextBindings$29 extends FunctionReferenceImpl implements Function2<S3EndpointParameters.Builder, ResolveEndpointRequest, Unit> {
    public static final EndpointResolverAdapterKt$opContextBindings$29 INSTANCE = new EndpointResolverAdapterKt$opContextBindings$29();

    EndpointResolverAdapterKt$opContextBindings$29() {
        super(2, EndpointResolverAdapterKt.class, "bindGetBucketAccelerateConfigurationEndpointContext", "bindGetBucketAccelerateConfigurationEndpointContext(Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters$Builder;Laws/smithy/kotlin/runtime/http/operation/ResolveEndpointRequest;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        invoke2(builder, resolveEndpointRequest);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(S3EndpointParameters.Builder p0, ResolveEndpointRequest p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        EndpointResolverAdapterKt.bindGetBucketAccelerateConfigurationEndpointContext(p0, p1);
    }
}
