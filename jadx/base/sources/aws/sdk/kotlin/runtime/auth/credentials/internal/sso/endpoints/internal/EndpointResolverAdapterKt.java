package aws.sdk.kotlin.runtime.auth.credentials.internal.sso.endpoints.internal;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.SsoClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.endpoints.SsoEndpointParameters;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.operation.ResolveEndpointRequest;
import aws.smithy.kotlin.runtime.net.url.Url;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EndpointResolverAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\t*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\"0\u0010\n\u001a$\u0012\u0004\u0012\u00020\f\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000*0\b\u0002\u0010\u0006\"\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u00072\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007¨\u0006\u000f"}, m1599d2 = {"resolveEndpointParams", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/endpoints/SsoEndpointParameters;", "config", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/SsoClient$Config;", "request", "Laws/smithy/kotlin/runtime/http/operation/ResolveEndpointRequest;", "BindOperationContextParamsFn", "Lkotlin/Function2;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/endpoints/SsoEndpointParameters$Builder;", "", "opContextBindings", "", "", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/endpoints/internal/BindOperationContextParamsFn;", "bindAwsBuiltins", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EndpointResolverAdapterKt {
    private static final Map<String, Function2<SsoEndpointParameters.Builder, ResolveEndpointRequest, Unit>> opContextBindings = MapsKt.emptyMap();

    public static final SsoEndpointParameters resolveEndpointParams(SsoClient.Config config, ResolveEndpointRequest request) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(request, "request");
        SsoEndpointParameters.Companion companion = SsoEndpointParameters.INSTANCE;
        SsoEndpointParameters.Builder builder = new SsoEndpointParameters.Builder();
        builder.setRegion(config.getRegion());
        bindAwsBuiltins(builder, config, request);
        Url endpointUrl = config.getEndpointUrl();
        builder.setEndpoint(endpointUrl != null ? endpointUrl.getEncoded() : null);
        Function2<SsoEndpointParameters.Builder, ResolveEndpointRequest, Unit> function2 = opContextBindings.get((String) AttributesKt.get(request.getContext(), SdkClientOption.INSTANCE.getOperationName()));
        if (function2 != null) {
            function2.invoke(builder, request);
        }
        return builder.build();
    }

    private static final void bindAwsBuiltins(SsoEndpointParameters.Builder builder, SsoClient.Config config, ResolveEndpointRequest resolveEndpointRequest) {
        builder.setUseDualStack(Boolean.valueOf(config.getUseDualStack()));
        builder.setUseFips(Boolean.valueOf(config.getUseFips()));
    }
}
