package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.config.EnvironmentSetting;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: StsWebIdentityCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a:\u0010\u0002\u001a\u0002H\u0003\"\u0006\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u0010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"PROVIDER_NAME", "", "resolve", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "explicit", "setting", "Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "name", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Ljava/lang/Object;Laws/smithy/kotlin/runtime/config/EnvironmentSetting;Ljava/lang/String;)Ljava/lang/Object;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StsWebIdentityCredentialsProviderKt {
    private static final String PROVIDER_NAME = "WebIdentityToken";

    private static final /* synthetic */ <T> T resolve(PlatformProvider platformProvider, T t, EnvironmentSetting<T> environmentSetting, String str) {
        if (t != null) {
            return t;
        }
        T t2 = (T) EnvironmentSettingKt.resolve(environmentSetting, platformProvider);
        if (t2 != null) {
            return t2;
        }
        throw new ProviderConfigurationException("Required field `" + str + "` could not be automatically inferred for StsWebIdentityCredentialsProvider. Either explicitly pass a value, set the environment variable `" + environmentSetting.getEnvVar() + "`, or set the JVM system property `" + environmentSetting.getSysProp() + '`', null, 2, null);
    }
}
