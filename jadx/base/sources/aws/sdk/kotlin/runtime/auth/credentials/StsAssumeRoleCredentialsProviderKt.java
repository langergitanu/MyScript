package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.InstantKt;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StsAssumeRoleCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"GLOBAL_STS_PARTITION_ENDPOINT", "", "PROVIDER_NAME", "defaultSessionName", "platformEnvironProvider", "Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StsAssumeRoleCredentialsProviderKt {
    private static final String GLOBAL_STS_PARTITION_ENDPOINT = "aws-global";
    private static final String PROVIDER_NAME = "AssumeRoleProvider";

    public static final String defaultSessionName(PlatformEnvironProvider platformEnvironProvider) {
        Intrinsics.checkNotNullParameter(platformEnvironProvider, "platformEnvironProvider");
        String str = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsRoleSessionName(), platformEnvironProvider);
        return str == null ? "aws-sdk-kotlin-" + InstantKt.getEpochMilliseconds(Instant.INSTANCE.now()) : str;
    }

    public static /* synthetic */ String defaultSessionName$default(PlatformEnvironProvider platformEnvironProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            platformEnvironProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return defaultSessionName(platformEnvironProvider);
    }
}
