package aws.sdk.kotlin.runtime.config.profile;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsConfigLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/AwsConfigurationSource;", "", "profile", "", "configPath", "credentialsPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProfile", "()Ljava/lang/String;", "getConfigPath", "getCredentialsPath", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final /* data */ class AwsConfigurationSource {
    private final String configPath;
    private final String credentialsPath;
    private final String profile;

    public static /* synthetic */ AwsConfigurationSource copy$default(AwsConfigurationSource awsConfigurationSource, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = awsConfigurationSource.profile;
        }
        if ((i & 2) != 0) {
            str2 = awsConfigurationSource.configPath;
        }
        if ((i & 4) != 0) {
            str3 = awsConfigurationSource.credentialsPath;
        }
        return awsConfigurationSource.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProfile() {
        return this.profile;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getConfigPath() {
        return this.configPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCredentialsPath() {
        return this.credentialsPath;
    }

    public final AwsConfigurationSource copy(String profile, String configPath, String credentialsPath) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(configPath, "configPath");
        Intrinsics.checkNotNullParameter(credentialsPath, "credentialsPath");
        return new AwsConfigurationSource(profile, configPath, credentialsPath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AwsConfigurationSource)) {
            return false;
        }
        AwsConfigurationSource awsConfigurationSource = (AwsConfigurationSource) other;
        return Intrinsics.areEqual(this.profile, awsConfigurationSource.profile) && Intrinsics.areEqual(this.configPath, awsConfigurationSource.configPath) && Intrinsics.areEqual(this.credentialsPath, awsConfigurationSource.credentialsPath);
    }

    public int hashCode() {
        return (((this.profile.hashCode() * 31) + this.configPath.hashCode()) * 31) + this.credentialsPath.hashCode();
    }

    public String toString() {
        return "AwsConfigurationSource(profile=" + this.profile + ", configPath=" + this.configPath + ", credentialsPath=" + this.credentialsPath + ')';
    }

    public AwsConfigurationSource(String profile, String configPath, String credentialsPath) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(configPath, "configPath");
        Intrinsics.checkNotNullParameter(credentialsPath, "credentialsPath");
        this.profile = profile;
        this.configPath = configPath;
        this.credentialsPath = credentialsPath;
    }

    public final String getConfigPath() {
        return this.configPath;
    }

    public final String getCredentialsPath() {
        return this.credentialsPath;
    }

    public final String getProfile() {
        return this.profile;
    }
}
