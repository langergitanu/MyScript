package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import kotlin.Metadata;

/* JADX INFO: compiled from: EnvironmentCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"PROVIDER_NAME", "", "ACCESS_KEY_ID", "SECRET_ACCESS_KEY", "SESSION_TOKEN", "ACCOUNT_ID", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EnvironmentCredentialsProviderKt {
    private static final String PROVIDER_NAME = "Environment";
    private static final String ACCESS_KEY_ID = AwsSdkSetting.INSTANCE.getAwsAccessKeyId().getEnvVar();
    private static final String SECRET_ACCESS_KEY = AwsSdkSetting.INSTANCE.getAwsSecretAccessKey().getEnvVar();
    private static final String SESSION_TOKEN = AwsSdkSetting.INSTANCE.getAwsSessionToken().getEnvVar();
    private static final String ACCOUNT_ID = AwsSdkSetting.INSTANCE.getAwsAccountId().getEnvVar();
}
