package aws.sdk.kotlin.runtime.config;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.smithy.kotlin.runtime.config.EnvironmentSetting;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsSdkSetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, m1599d2 = {"resolveEndpointUrl", "Laws/smithy/kotlin/runtime/net/url/Url;", "Laws/sdk/kotlin/runtime/config/AwsSdkSetting;", "provider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "sysPropSuffix", "", "envSuffix", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsSdkSettingKt {
    @InternalSdkApi
    public static final Url resolveEndpointUrl(AwsSdkSetting awsSdkSetting, PlatformProvider provider, String sysPropSuffix, String envSuffix) {
        Intrinsics.checkNotNullParameter(awsSdkSetting, "<this>");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(sysPropSuffix, "sysPropSuffix");
        Intrinsics.checkNotNullParameter(envSuffix, "envSuffix");
        PlatformProvider platformProvider = provider;
        Url url = (Url) EnvironmentSettingKt.resolve(EnvironmentSettingKt.withCaseInsensitiveSuffixes((EnvironmentSetting) EnvironmentSetting.INSTANCE.invoke(new AwsSdkSettingKt$resolveEndpointUrl$serviceSetting$1(Url.INSTANCE)).invoke("aws.endpointUrl", "AWS_ENDPOINT_URL_"), sysPropSuffix, envSuffix), platformProvider);
        return url == null ? (Url) EnvironmentSettingKt.resolve(awsSdkSetting.getAwsEndpointUrl(), platformProvider) : url;
    }
}
