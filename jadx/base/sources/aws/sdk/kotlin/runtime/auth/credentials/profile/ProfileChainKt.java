package aws.sdk.kotlin.runtime.auth.credentials.profile;

import aws.sdk.kotlin.runtime.auth.credentials.ProviderConfigurationException;
import aws.sdk.kotlin.runtime.auth.credentials.internal.CredentialsExtKt;
import aws.sdk.kotlin.runtime.auth.credentials.profile.LeafProvider;
import aws.sdk.kotlin.runtime.auth.credentials.profile.LeafProviderResult;
import aws.sdk.kotlin.runtime.auth.credentials.profile.NextProfile;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfileChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0082\b\u001a\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00060\u0001j\u0002`\u0002H\u0002\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0002\u001a\u001d\u0010\u001e\u001a\u00020\u001d*\u0004\u0018\u00010\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007H\u0082\b\u001a!\u0010 \u001a\u0004\u0018\u00010\u001d*\u0004\u0018\u00010\u001d2\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0007H\u0082\b\u001a\u0012\u0010!\u001a\u0004\u0018\u00010\u001d*\u00060\u0001j\u0002`\u0002H\u0002\u001a\u0012\u0010\"\u001a\u0004\u0018\u00010\u001d*\u00060\u0001j\u0002`\u0002H\u0002\u001a\u001a\u0010#\u001a\u0004\u0018\u00010\u001d*\u00060\u0001j\u0002`\u00022\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0012\u0010&\u001a\u0004\u0018\u00010\u001d*\u00060\u0001j\u0002`\u0002H\u0002\u001a\u0010\u0010'\u001a\u00020\u001d*\u00060\u0001j\u0002`\u0002H\u0002\u001a\u0010\u0010(\u001a\u00020\u001d*\u00060\u0001j\u0002`\u0002H\u0002\u001a\u0012\u0010)\u001a\u0004\u0018\u00010\u001c*\u00060\u0001j\u0002`\u0002H\u0002\u001a\u0010\u0010*\u001a\u00020+*\u00060\u0001j\u0002`\u0002H\u0002\u001a\u0018\u0010,\u001a\u00020\u001c*\u00060\u0001j\u0002`\u00022\u0006\u0010$\u001a\u00020%H\u0002\"\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006-"}, m1599d2 = {"getOrThrow", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "", "", "name", "lazyMessage", "Lkotlin/Function0;", "ROLE_ARN", "EXTERNAL_ID", "ROLE_SESSION_NAME", "CREDENTIAL_SOURCE", "SOURCE_PROFILE", "WEB_IDENTITY_TOKEN_FILE", "AWS_ACCESS_KEY_ID", "AWS_SECRET_ACCESS_KEY", "AWS_SESSION_TOKEN", "AWS_ACCOUNT_ID", "SSO_START_URL", "SSO_REGION", "SSO_ACCOUNT_ID", "SSO_ROLE_NAME", "SSO_SESSION", "LOGIN_SESSION", "CREDENTIAL_PROCESS", "roleArnOrNull", "Laws/sdk/kotlin/runtime/auth/credentials/profile/RoleArn;", "unwrap", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProviderResult;", "unwrapOrElse", "fn", "orElse", "webIdentityTokenCreds", "legacySsoCreds", "ssoSessionCreds", "config", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "loginSessionCreds", "processCreds", "staticCreds", "staticCredsOrNull", "chainProvider", "Laws/sdk/kotlin/runtime/auth/credentials/profile/NextProfile;", "leafProvider", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ProfileChainKt {
    public static final String AWS_ACCESS_KEY_ID = "aws_access_key_id";
    public static final String AWS_ACCOUNT_ID = "aws_account_id";
    public static final String AWS_SECRET_ACCESS_KEY = "aws_secret_access_key";
    public static final String AWS_SESSION_TOKEN = "aws_session_token";
    public static final String CREDENTIAL_PROCESS = "credential_process";
    public static final String CREDENTIAL_SOURCE = "credential_source";
    public static final String EXTERNAL_ID = "external_id";
    public static final String LOGIN_SESSION = "login_session";
    public static final String ROLE_ARN = "role_arn";
    public static final String ROLE_SESSION_NAME = "role_session_name";
    public static final String SOURCE_PROFILE = "source_profile";
    public static final String SSO_ACCOUNT_ID = "sso_account_id";
    public static final String SSO_REGION = "sso_region";
    public static final String SSO_ROLE_NAME = "sso_role_name";
    public static final String SSO_SESSION = "sso_session";
    public static final String SSO_START_URL = "sso_start_url";
    public static final String WEB_IDENTITY_TOKEN_FILE = "web_identity_token_file";

    private static final ConfigSection getOrThrow(Map<String, ConfigSection> map, String str, Function0<String> function0) {
        ConfigSection configSection = map.get(str);
        if (configSection != null) {
            return configSection;
        }
        throw new ProviderConfigurationException(function0.invoke(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoleArn roleArnOrNull(ConfigSection configSection) {
        String orNull$default;
        RoleArnSource roleArnSource;
        if ((!configSection.contains(CREDENTIAL_SOURCE) && !configSection.contains(SOURCE_PROFILE) && configSection.contains(WEB_IDENTITY_TOKEN_FILE)) || (orNull$default = ConfigSection.getOrNull$default(configSection, ROLE_ARN, null, 2, null)) == null) {
            return null;
        }
        if (!configSection.contains(SOURCE_PROFILE) || configSection.contains(CREDENTIAL_SOURCE)) {
            roleArnSource = (!configSection.contains(CREDENTIAL_SOURCE) || configSection.contains(SOURCE_PROFILE)) ? null : RoleArnSource.CREDENTIALS_SOURCE;
        } else {
            roleArnSource = RoleArnSource.SOURCE_PROFILE;
        }
        return new RoleArn(orNull$default, roleArnSource, ConfigSection.getOrNull$default(configSection, ROLE_SESSION_NAME, null, 2, null), ConfigSection.getOrNull$default(configSection, EXTERNAL_ID, null, 2, null));
    }

    private static final LeafProvider unwrap(LeafProviderResult leafProviderResult) {
        if (leafProviderResult instanceof LeafProviderResult.C3090Ok) {
            return ((LeafProviderResult.C3090Ok) leafProviderResult).getProvider();
        }
        if (leafProviderResult instanceof LeafProviderResult.Err) {
            throw new ProviderConfigurationException(((LeafProviderResult.Err) leafProviderResult).getErrorMessage(), null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final LeafProviderResult unwrapOrElse(LeafProviderResult leafProviderResult, Function0<? extends LeafProviderResult> function0) {
        return leafProviderResult == null ? function0.invoke() : leafProviderResult;
    }

    private static final LeafProviderResult orElse(LeafProviderResult leafProviderResult, Function0<? extends LeafProviderResult> function0) {
        return leafProviderResult == null ? function0.invoke() : leafProviderResult;
    }

    private static final LeafProviderResult webIdentityTokenCreds(ConfigSection configSection) {
        String orNull$default = ConfigSection.getOrNull$default(configSection, ROLE_ARN, null, 2, null);
        String orNull$default2 = ConfigSection.getOrNull$default(configSection, WEB_IDENTITY_TOKEN_FILE, null, 2, null);
        String orNull$default3 = ConfigSection.getOrNull$default(configSection, ROLE_SESSION_NAME, null, 2, null);
        if (orNull$default2 == null) {
            return null;
        }
        if (orNull$default == null) {
            return new LeafProviderResult.Err("profile (" + configSection.getName() + ") missing `role_arn`");
        }
        return new LeafProviderResult.C3090Ok(new LeafProvider.WebIdentityTokenRole(orNull$default, orNull$default2, orNull$default3));
    }

    private static final LeafProviderResult legacySsoCreds(ConfigSection configSection) {
        if (!configSection.contains(SSO_ACCOUNT_ID) && !configSection.contains(SSO_ROLE_NAME)) {
            return null;
        }
        String orNull$default = ConfigSection.getOrNull$default(configSection, SSO_START_URL, null, 2, null);
        if (orNull$default == null) {
            return new LeafProviderResult.Err("profile (" + configSection.getName() + ") missing `sso_start_url`");
        }
        String orNull$default2 = ConfigSection.getOrNull$default(configSection, SSO_REGION, null, 2, null);
        if (orNull$default2 == null) {
            return new LeafProviderResult.Err("profile (" + configSection.getName() + ") missing `sso_region`");
        }
        String orNull$default3 = ConfigSection.getOrNull$default(configSection, SSO_ACCOUNT_ID, null, 2, null);
        if (orNull$default3 == null) {
            return new LeafProviderResult.Err("profile (" + configSection.getName() + ") missing `sso_account_id`");
        }
        String orNull$default4 = ConfigSection.getOrNull$default(configSection, SSO_ROLE_NAME, null, 2, null);
        return orNull$default4 == null ? new LeafProviderResult.Err("profile (" + configSection.getName() + ") missing `sso_role_name`") : new LeafProviderResult.C3090Ok(new LeafProvider.LegacySso(orNull$default, orNull$default2, orNull$default3, orNull$default4));
    }

    private static final LeafProviderResult ssoSessionCreds(ConfigSection configSection, AwsSharedConfig awsSharedConfig) {
        String orNull$default = ConfigSection.getOrNull$default(configSection, SSO_SESSION, null, 2, null);
        if (orNull$default == null) {
            return null;
        }
        ConfigSection configSection2 = awsSharedConfig.getSsoSessions().get(orNull$default);
        if (configSection2 == null) {
            return new LeafProviderResult.Err("profile (" + configSection.getName() + ") references non-existing sso_session = `" + orNull$default + '`');
        }
        String orNull$default2 = ConfigSection.getOrNull$default(configSection2, SSO_START_URL, null, 2, null);
        if (orNull$default2 == null) {
            return new LeafProviderResult.Err("sso-session (" + orNull$default + ") missing `sso_start_url`");
        }
        String orNull$default3 = ConfigSection.getOrNull$default(configSection2, SSO_REGION, null, 2, null);
        if (orNull$default3 == null) {
            return new LeafProviderResult.Err("sso-session (" + orNull$default + ") missing `sso_region`");
        }
        String orNull$default4 = ConfigSection.getOrNull$default(configSection, SSO_ACCOUNT_ID, null, 2, null);
        if (orNull$default4 == null) {
            return new LeafProviderResult.Err("profile (" + configSection.getName() + ") missing `sso_account_id`");
        }
        String orNull$default5 = ConfigSection.getOrNull$default(configSection, SSO_ROLE_NAME, null, 2, null);
        if (orNull$default5 == null) {
            return new LeafProviderResult.Err("profile (" + configSection.getName() + ") missing `sso_role_name`");
        }
        String orNull$default6 = ConfigSection.getOrNull$default(configSection2, SSO_REGION, null, 2, null);
        String orNull$default7 = ConfigSection.getOrNull$default(configSection, SSO_REGION, null, 2, null);
        if (orNull$default6 != null && orNull$default7 != null && !Intrinsics.areEqual(orNull$default6, orNull$default7)) {
            return new LeafProviderResult.Err("sso-session (" + orNull$default + ") sso_region = `" + orNull$default6 + "` does not match profile (" + configSection.getName() + ") sso_region = `" + orNull$default7 + '`');
        }
        String orNull$default8 = ConfigSection.getOrNull$default(configSection2, SSO_START_URL, null, 2, null);
        String orNull$default9 = ConfigSection.getOrNull$default(configSection, SSO_START_URL, null, 2, null);
        if (orNull$default8 != null && orNull$default9 != null && !Intrinsics.areEqual(orNull$default8, orNull$default9)) {
            return new LeafProviderResult.Err("sso-session (" + orNull$default + ") sso_start_url = `" + orNull$default8 + "` does not match profile (" + configSection.getName() + ") sso_start_url = `" + orNull$default9 + '`');
        }
        return new LeafProviderResult.C3090Ok(new LeafProvider.SsoSession(orNull$default, orNull$default2, orNull$default3, orNull$default4, orNull$default5));
    }

    private static final LeafProviderResult loginSessionCreds(ConfigSection configSection) {
        String orNull$default = ConfigSection.getOrNull$default(configSection, LOGIN_SESSION, null, 2, null);
        if (orNull$default == null) {
            return null;
        }
        return new LeafProviderResult.C3090Ok(new LeafProvider.LoginSession(orNull$default));
    }

    private static final LeafProviderResult processCreds(ConfigSection configSection) {
        if (!configSection.contains(CREDENTIAL_PROCESS)) {
            return new LeafProviderResult.Err("profile (" + configSection.getName() + ") did not contain credential information");
        }
        String orNull$default = ConfigSection.getOrNull$default(configSection, CREDENTIAL_PROCESS, null, 2, null);
        return orNull$default == null ? new LeafProviderResult.Err("profile (" + configSection.getName() + ") missing `credential_process`") : new LeafProviderResult.C3090Ok(new LeafProvider.Process(orNull$default));
    }

    private static final LeafProviderResult staticCreds(ConfigSection configSection) {
        String orNull$default = ConfigSection.getOrNull$default(configSection, AWS_ACCESS_KEY_ID, null, 2, null);
        String orNull$default2 = ConfigSection.getOrNull$default(configSection, AWS_SECRET_ACCESS_KEY, null, 2, null);
        String orNull$default3 = ConfigSection.getOrNull$default(configSection, AWS_ACCOUNT_ID, null, 2, null);
        if (orNull$default == null && orNull$default2 == null) {
            return new LeafProviderResult.Err("profile (" + configSection.getName() + ") missing `aws_access_key_id` & `aws_secret_access_key`");
        }
        if (orNull$default == null) {
            return new LeafProviderResult.Err("profile (" + configSection.getName() + ") missing `aws_access_key_id`");
        }
        if (orNull$default2 == null) {
            return new LeafProviderResult.Err("profile (" + configSection.getName() + ") missing `aws_secret_access_key`");
        }
        return new LeafProviderResult.C3090Ok(new LeafProvider.AccessKey(CredentialsExtKt.credentials$default(orNull$default, orNull$default2, ConfigSection.getOrNull$default(configSection, AWS_SESSION_TOKEN, null, 2, null), null, null, orNull$default3, 24, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LeafProvider staticCredsOrNull(ConfigSection configSection) {
        LeafProviderResult leafProviderResultStaticCreds = staticCreds(configSection);
        if (leafProviderResultStaticCreds instanceof LeafProviderResult.C3090Ok) {
            return ((LeafProviderResult.C3090Ok) leafProviderResultStaticCreds).getProvider();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NextProfile chainProvider(ConfigSection configSection) {
        String orNull$default = ConfigSection.getOrNull$default(configSection, SOURCE_PROFILE, null, 2, null);
        String orNull$default2 = ConfigSection.getOrNull$default(configSection, CREDENTIAL_SOURCE, null, 2, null);
        if (orNull$default != null && orNull$default2 != null) {
            throw new ProviderConfigurationException("profile (" + configSection.getName() + ") contained both `source_profile` and `credential_source`. Only one or the other can be defined.", null, 2, null);
        }
        if (orNull$default == null && orNull$default2 == null) {
            throw new ProviderConfigurationException("profile (" + configSection.getName() + ") must contain `source_profile` or `credential_source` but neither were defined", null, 2, null);
        }
        if (orNull$default != null && orNull$default2 == null) {
            if (Intrinsics.areEqual(orNull$default, configSection.getName())) {
                return NextProfile.SelfReference.INSTANCE;
            }
            return new NextProfile.Named(orNull$default);
        }
        return NextProfile.SelfReference.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LeafProvider leafProvider(ConfigSection configSection, AwsSharedConfig awsSharedConfig) {
        String orNull$default = ConfigSection.getOrNull$default(configSection, CREDENTIAL_SOURCE, null, 2, null);
        if (orNull$default != null) {
            return new LeafProvider.NamedSource(orNull$default);
        }
        LeafProviderResult leafProviderResultWebIdentityTokenCreds = webIdentityTokenCreds(configSection);
        if (leafProviderResultWebIdentityTokenCreds == null) {
            leafProviderResultWebIdentityTokenCreds = ssoSessionCreds(configSection, awsSharedConfig);
        }
        if (leafProviderResultWebIdentityTokenCreds == null) {
            leafProviderResultWebIdentityTokenCreds = legacySsoCreds(configSection);
        }
        if (leafProviderResultWebIdentityTokenCreds == null) {
            leafProviderResultWebIdentityTokenCreds = loginSessionCreds(configSection);
        }
        if (leafProviderResultWebIdentityTokenCreds == null) {
            leafProviderResultWebIdentityTokenCreds = processCreds(configSection);
        }
        return unwrap(leafProviderResultWebIdentityTokenCreds);
    }
}
