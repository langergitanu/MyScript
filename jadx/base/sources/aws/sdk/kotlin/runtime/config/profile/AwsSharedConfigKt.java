package aws.sdk.kotlin.runtime.config.profile;

import aws.sdk.kotlin.runtime.ConfigurationException;
import aws.smithy.kotlin.runtime.net.url.Url;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsSharedConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0006"}, m1599d2 = {"resolveEndpointUrl", "Laws/smithy/kotlin/runtime/net/url/Url;", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "serviceKey", "", "resolveServiceEndpointUrl", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsSharedConfigKt {
    public static final Url resolveEndpointUrl(AwsSharedConfig awsSharedConfig, String serviceKey) {
        Intrinsics.checkNotNullParameter(awsSharedConfig, "<this>");
        Intrinsics.checkNotNullParameter(serviceKey, "serviceKey");
        Url urlResolveServiceEndpointUrl = resolveServiceEndpointUrl(awsSharedConfig, serviceKey);
        return urlResolveServiceEndpointUrl == null ? AwsProfileKt.getEndpointUrl(awsSharedConfig.getActiveProfile()) : urlResolveServiceEndpointUrl;
    }

    private static final Url resolveServiceEndpointUrl(AwsSharedConfig awsSharedConfig, String str) {
        String servicesSection = AwsProfileKt.getServicesSection(awsSharedConfig.getActiveProfile());
        if (servicesSection == null) {
            return null;
        }
        ConfigSection configSection = awsSharedConfig.getServices().get(servicesSection);
        if (configSection == null) {
            throw new ConfigurationException("shared config points to nonexistent services section '" + servicesSection + '\'');
        }
        return AwsProfileKt.getUrlOrNull(configSection, str, "endpoint_url");
    }
}
