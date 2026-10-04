package aws.sdk.kotlin.runtime.config.profile;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsSharedConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B9\b\u0000\u0012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00070\u0003j\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR.\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00070\u0003j\u0002`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u000e0\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u00120\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R!\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u00150\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\u0017\u001a\u00060\u0006j\u0002`\u000e8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "", "sections", "", "Laws/sdk/kotlin/runtime/config/profile/ConfigSectionType;", "", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/SectionMap;", "Laws/sdk/kotlin/runtime/config/profile/TypedSectionMap;", FirebaseAnalytics.Param.SOURCE, "Laws/sdk/kotlin/runtime/config/profile/AwsConfigurationSource;", "<init>", "(Ljava/util/Map;Laws/sdk/kotlin/runtime/config/profile/AwsConfigurationSource;)V", "profiles", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "getProfiles", "()Ljava/util/Map;", "ssoSessions", "Laws/sdk/kotlin/runtime/config/profile/SsoSessionConfig;", "getSsoSessions", Literals.SERVICES_KEYWORD, "Laws/sdk/kotlin/runtime/config/profile/ServicesConfig;", "getServices", "activeProfile", "getActiveProfile", "()Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final class AwsSharedConfig {
    private final Map<ConfigSectionType, Map<String, ConfigSection>> sections;
    private final AwsConfigurationSource source;

    /* JADX WARN: Multi-variable type inference failed */
    public AwsSharedConfig(Map<ConfigSectionType, ? extends Map<String, ConfigSection>> sections, AwsConfigurationSource source) {
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(source, "source");
        this.sections = sections;
        this.source = source;
    }

    public final Map<String, ConfigSection> getProfiles() {
        Map<String, ConfigSection> map = this.sections.get(ConfigSectionType.PROFILE);
        return map == null ? MapsKt.emptyMap() : map;
    }

    public final Map<String, ConfigSection> getSsoSessions() {
        Map<String, ConfigSection> map = this.sections.get(ConfigSectionType.SSO_SESSION);
        return map == null ? MapsKt.emptyMap() : map;
    }

    public final Map<String, ConfigSection> getServices() {
        Map<String, ConfigSection> map = this.sections.get(ConfigSectionType.SERVICES);
        return map == null ? MapsKt.emptyMap() : map;
    }

    public final ConfigSection getActiveProfile() {
        ConfigSection configSection = getProfiles().get(this.source.getProfile());
        return configSection == null ? new ConfigSection(this.source.getProfile(), MapsKt.emptyMap(), null, 4, null) : configSection;
    }
}
