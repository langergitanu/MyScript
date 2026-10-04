package aws.sdk.kotlin.runtime.config.profile;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.config.profile.AwsConfigValue;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConfigSection.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0086\u0002J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÀ\u0003¢\u0006\u0002\b\u0018J\u000e\u0010\u0019\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b\u001aJ3\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "", "name", "", DiagnosticsEntry.PROPERTIES_KEY, "", "Laws/sdk/kotlin/runtime/config/profile/AwsConfigValue;", "sectionType", "Laws/sdk/kotlin/runtime/config/profile/ConfigSectionType;", "<init>", "(Ljava/lang/String;Ljava/util/Map;Laws/sdk/kotlin/runtime/config/profile/ConfigSectionType;)V", "getName", "()Ljava/lang/String;", "getProperties$aws_config", "()Ljava/util/Map;", "getSectionType$aws_config", "()Laws/sdk/kotlin/runtime/config/profile/ConfigSectionType;", "contains", "", SubscriberAttributeKt.JSON_NAME_KEY, "getOrNull", "subKey", "component1", "component2", "component2$aws_config", "component3", "component3$aws_config", "copy", "equals", "other", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final /* data */ class ConfigSection {
    private final String name;
    private final Map<String, AwsConfigValue> properties;
    private final ConfigSectionType sectionType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigSection copy$default(ConfigSection configSection, String str, Map map, ConfigSectionType configSectionType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = configSection.name;
        }
        if ((i & 2) != 0) {
            map = configSection.properties;
        }
        if ((i & 4) != 0) {
            configSectionType = configSection.sectionType;
        }
        return configSection.copy(str, map, configSectionType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Map<String, AwsConfigValue> component2$aws_config() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component3$aws_config, reason: from getter */
    public final ConfigSectionType getSectionType() {
        return this.sectionType;
    }

    public final ConfigSection copy(String name, Map<String, ? extends AwsConfigValue> properties, ConfigSectionType sectionType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(sectionType, "sectionType");
        return new ConfigSection(name, properties, sectionType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigSection)) {
            return false;
        }
        ConfigSection configSection = (ConfigSection) other;
        return Intrinsics.areEqual(this.name, configSection.name) && Intrinsics.areEqual(this.properties, configSection.properties) && this.sectionType == configSection.sectionType;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.properties.hashCode()) * 31) + this.sectionType.hashCode();
    }

    public String toString() {
        return "ConfigSection(name=" + this.name + ", properties=" + this.properties + ", sectionType=" + this.sectionType + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConfigSection(String name, Map<String, ? extends AwsConfigValue> properties, ConfigSectionType sectionType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(sectionType, "sectionType");
        this.name = name;
        this.properties = properties;
        this.sectionType = sectionType;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, AwsConfigValue> getProperties$aws_config() {
        return this.properties;
    }

    public /* synthetic */ ConfigSection(String str, Map map, ConfigSectionType configSectionType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i & 4) != 0 ? ConfigSectionType.PROFILE : configSectionType);
    }

    public final ConfigSectionType getSectionType$aws_config() {
        return this.sectionType;
    }

    public final boolean contains(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.properties.containsKey(key);
    }

    public static /* synthetic */ String getOrNull$default(ConfigSection configSection, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return configSection.getOrNull(str, str2);
    }

    public final String getOrNull(String key, String subKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        AwsConfigValue awsConfigValue = this.properties.get(key);
        if (awsConfigValue == null) {
            return null;
        }
        if (awsConfigValue instanceof AwsConfigValue.String) {
            if (subKey != null) {
                throw new IllegalArgumentException(("property '" + key + "' is a string, but caller specified a sub-key").toString());
            }
            return ((AwsConfigValue.String) awsConfigValue).getValue();
        }
        if (!(awsConfigValue instanceof AwsConfigValue.Map)) {
            throw new NoWhenBranchMatchedException();
        }
        if (subKey == null) {
            throw new IllegalArgumentException(("property '" + key + "' has sub-properties, caller must specify a sub-key").toString());
        }
        return (String) ((AwsConfigValue.Map) awsConfigValue).get((Object) subKey);
    }
}
