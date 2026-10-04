package aws.sdk.kotlin.runtime.config;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.config.endpoints.AccountIdEndpointMode;
import aws.sdk.kotlin.runtime.http.AwsUserAgentMetadataKt;
import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.client.config.RequestHttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.config.ResponseHttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.config.RetryMode;
import aws.smithy.kotlin.runtime.config.EnvironmentSetting;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.config.MultipleKeyEnvironmentSetting;
import aws.smithy.kotlin.runtime.net.url.Url;
import com.survicate.surveys.TextRecallingManager;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AwsSdkSetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\bR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\bR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\bR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\bR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\bR\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\bR\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\bR\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\bR\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\bR\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\bR\u0017\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\bR\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\bR\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\bR\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\bR\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\bR\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\bR\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\bR\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u0005¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\bR\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0014R\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0005¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\bR\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u0005¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\bR\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u0005¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\bR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\b¨\u0006U"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/AwsSdkSetting;", "", "<init>", "()V", "AwsAccessKeyId", "Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "", "getAwsAccessKeyId", "()Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "AwsSecretAccessKey", "getAwsSecretAccessKey", "AwsSessionToken", "getAwsSessionToken", "AwsRegion", "getAwsRegion", "AwsAccountId", "getAwsAccountId", "AwsAppId", "Laws/smithy/kotlin/runtime/config/MultipleKeyEnvironmentSetting;", "getAwsAppId", "()Laws/smithy/kotlin/runtime/config/MultipleKeyEnvironmentSetting;", "AwsConfigFile", "getAwsConfigFile", "AwsSharedCredentialsFile", "getAwsSharedCredentialsFile", "AwsExecutionEnv", "getAwsExecutionEnv", "AwsProfile", "getAwsProfile", "AwsEc2MetadataDisabled", "", "getAwsEc2MetadataDisabled", "AwsEc2MetadataServiceEndpoint", "getAwsEc2MetadataServiceEndpoint", "AwsEc2MetadataServiceEndpointMode", "getAwsEc2MetadataServiceEndpointMode", "AwsRoleArn", "getAwsRoleArn", "AwsRoleSessionName", "getAwsRoleSessionName", "AwsWebIdentityTokenFile", "getAwsWebIdentityTokenFile", "AwsContainerCredentialsRelativeUri", "getAwsContainerCredentialsRelativeUri", "AwsContainerCredentialsFullUri", "getAwsContainerCredentialsFullUri", "AwsContainerAuthorizationToken", "getAwsContainerAuthorizationToken", "AwsContainerAuthorizationTokenFile", "getAwsContainerAuthorizationTokenFile", "AwsMaxAttempts", "", "getAwsMaxAttempts", "AwsRetryMode", "Laws/smithy/kotlin/runtime/client/config/RetryMode;", "getAwsRetryMode", "AwsUseFipsEndpoint", "getAwsUseFipsEndpoint", "AwsUseDualStackEndpoint", "getAwsUseDualStackEndpoint", "AwsEndpointUrl", "Laws/smithy/kotlin/runtime/net/url/Url;", "getAwsEndpointUrl", "AwsIgnoreEndpointUrls", "getAwsIgnoreEndpointUrls", "AwsAccountIdEndpointMode", "Laws/sdk/kotlin/runtime/config/endpoints/AccountIdEndpointMode;", "getAwsAccountIdEndpointMode", "AwsDisableRequestCompression", "getAwsDisableRequestCompression", "AwsRequestMinCompressionSizeBytes", "", "getAwsRequestMinCompressionSizeBytes", "AwsSigV4aSigningRegionSet", "getAwsSigV4aSigningRegionSet", "AwsEndpointDiscoveryEnabled", "getAwsEndpointDiscoveryEnabled", "AwsRequestChecksumCalculation", "Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "getAwsRequestChecksumCalculation", "AwsResponseChecksumValidation", "Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "getAwsResponseChecksumValidation", "AwsAuthSchemePreference", "getAwsAuthSchemePreference", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final class AwsSdkSetting {
    public static final AwsSdkSetting INSTANCE = new AwsSdkSetting();
    private static final EnvironmentSetting<String> AwsAccessKeyId = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.accessKeyId", "AWS_ACCESS_KEY_ID");
    private static final EnvironmentSetting<String> AwsSecretAccessKey = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.secretAccessKey", "AWS_SECRET_ACCESS_KEY");
    private static final EnvironmentSetting<String> AwsSessionToken = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.sessionToken", "AWS_SESSION_TOKEN");
    private static final EnvironmentSetting<String> AwsRegion = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.region", "AWS_REGION");
    private static final EnvironmentSetting<String> AwsAccountId = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.accountId", "AWS_ACCOUNT_ID");
    private static final MultipleKeyEnvironmentSetting<String> AwsAppId = EnvironmentSettingKt.withAdditionalKeys$default(EnvironmentSettingKt.getStrEnvSetting().invoke(AwsUserAgentMetadataKt.AWS_APP_ID_PROP, AwsUserAgentMetadataKt.AWS_APP_ID_ENV), CollectionsKt.listOf("sdk.ua.appId"), null, 2, null);
    private static final EnvironmentSetting<String> AwsConfigFile = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.configFile", "AWS_CONFIG_FILE");
    private static final EnvironmentSetting<String> AwsSharedCredentialsFile = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.sharedCredentialsFile", "AWS_SHARED_CREDENTIALS_FILE");
    private static final EnvironmentSetting<String> AwsExecutionEnv = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.executionEnvironment", AwsUserAgentMetadataKt.AWS_EXECUTION_ENV);
    private static final EnvironmentSetting<String> AwsProfile = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.profile", "AWS_PROFILE").orElse("default");
    private static final EnvironmentSetting<Boolean> AwsEc2MetadataDisabled = EnvironmentSettingKt.getBoolEnvSetting().invoke("aws.disableEc2Metadata", "AWS_EC2_METADATA_DISABLED").orElse(false);
    private static final EnvironmentSetting<String> AwsEc2MetadataServiceEndpoint = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.ec2MetadataServiceEndpoint", "AWS_EC2_METADATA_SERVICE_ENDPOINT");
    private static final EnvironmentSetting<String> AwsEc2MetadataServiceEndpointMode = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.ec2MetadataServiceEndpointMode", "AWS_EC2_METADATA_SERVICE_ENDPOINT_MODE");
    private static final EnvironmentSetting<String> AwsRoleArn = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.roleArn", "AWS_ROLE_ARN");
    private static final EnvironmentSetting<String> AwsRoleSessionName = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.roleSessionName", "AWS_ROLE_SESSION_NAME");
    private static final EnvironmentSetting<String> AwsWebIdentityTokenFile = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.webIdentityTokenFile", "AWS_WEB_IDENTITY_TOKEN_FILE");
    private static final EnvironmentSetting<String> AwsContainerCredentialsRelativeUri = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.containerCredentialsPath", "AWS_CONTAINER_CREDENTIALS_RELATIVE_URI");
    private static final EnvironmentSetting<String> AwsContainerCredentialsFullUri = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.containerCredentialsFullUri", "AWS_CONTAINER_CREDENTIALS_FULL_URI");
    private static final EnvironmentSetting<String> AwsContainerAuthorizationToken = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.containerAuthorizationToken", "AWS_CONTAINER_AUTHORIZATION_TOKEN");
    private static final EnvironmentSetting<String> AwsContainerAuthorizationTokenFile = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.containerAuthorizationTokenFile", "AWS_CONTAINER_AUTHORIZATION_TOKEN_FILE");
    private static final EnvironmentSetting<Integer> AwsMaxAttempts = EnvironmentSettingKt.getIntEnvSetting().invoke("aws.maxAttempts", "AWS_MAX_ATTEMPTS");
    private static final EnvironmentSetting<RetryMode> AwsRetryMode = new EnvironmentSetting<>(new Function1<String, RetryMode>() { // from class: aws.sdk.kotlin.runtime.config.AwsSdkSetting$special$$inlined$enumEnvSetting$1
        @Override // kotlin.jvm.functions.Function1
        public final RetryMode invoke(String strValue) {
            RetryMode retryMode;
            Intrinsics.checkNotNullParameter(strValue, "strValue");
            RetryMode[] retryModeArrValues = RetryMode.values();
            int length = retryModeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    retryMode = null;
                    break;
                }
                retryMode = retryModeArrValues[i];
                if (StringsKt.equals(retryMode.name(), strValue, true)) {
                    break;
                }
                i++;
            }
            RetryMode retryMode2 = retryMode;
            if (retryMode2 != null) {
                return retryMode2;
            }
            throw new ClientException("Value " + strValue + " is not supported, should be one of " + ArraysKt.joinToString$default(retryModeArrValues, TextRecallingManager.ANSWER_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }, "aws.retryMode", "AWS_RETRY_MODE", null, 8, null);
    private static final EnvironmentSetting<Boolean> AwsUseFipsEndpoint = EnvironmentSettingKt.getBoolEnvSetting().invoke("aws.useFipsEndpoint", "AWS_USE_FIPS_ENDPOINT");
    private static final EnvironmentSetting<Boolean> AwsUseDualStackEndpoint = EnvironmentSettingKt.getBoolEnvSetting().invoke("aws.useDualstackEndpoint", "AWS_USE_DUALSTACK_ENDPOINT");
    private static final EnvironmentSetting<Url> AwsEndpointUrl = (EnvironmentSetting) EnvironmentSetting.INSTANCE.invoke(new AwsSdkSetting$AwsEndpointUrl$1(Url.INSTANCE)).invoke("aws.endpointUrl", "AWS_ENDPOINT_URL");
    private static final EnvironmentSetting<Boolean> AwsIgnoreEndpointUrls = EnvironmentSettingKt.getBoolEnvSetting().invoke("aws.ignoreConfiguredEndpointUrls", "AWS_IGNORE_CONFIGURED_ENDPOINT_URLS");
    private static final EnvironmentSetting<AccountIdEndpointMode> AwsAccountIdEndpointMode = new EnvironmentSetting<>(new Function1<String, AccountIdEndpointMode>() { // from class: aws.sdk.kotlin.runtime.config.AwsSdkSetting$special$$inlined$enumEnvSetting$2
        @Override // kotlin.jvm.functions.Function1
        public final AccountIdEndpointMode invoke(String strValue) {
            AccountIdEndpointMode accountIdEndpointMode;
            Intrinsics.checkNotNullParameter(strValue, "strValue");
            AccountIdEndpointMode[] accountIdEndpointModeArrValues = AccountIdEndpointMode.values();
            int length = accountIdEndpointModeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    accountIdEndpointMode = null;
                    break;
                }
                accountIdEndpointMode = accountIdEndpointModeArrValues[i];
                if (StringsKt.equals(accountIdEndpointMode.name(), strValue, true)) {
                    break;
                }
                i++;
            }
            AccountIdEndpointMode accountIdEndpointMode2 = accountIdEndpointMode;
            if (accountIdEndpointMode2 != null) {
                return accountIdEndpointMode2;
            }
            throw new ClientException("Value " + strValue + " is not supported, should be one of " + ArraysKt.joinToString$default(accountIdEndpointModeArrValues, TextRecallingManager.ANSWER_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }, "aws.accountIdEndpointMode", "AWS_ACCOUNT_ID_ENDPOINT_MODE", null, 8, null);
    private static final EnvironmentSetting<Boolean> AwsDisableRequestCompression = EnvironmentSettingKt.getBoolEnvSetting().invoke("aws.disableRequestCompression", "AWS_DISABLE_REQUEST_COMPRESSION");
    private static final EnvironmentSetting<Long> AwsRequestMinCompressionSizeBytes = EnvironmentSettingKt.getLongEnvSetting().invoke("aws.requestMinCompressionSizeBytes", "AWS_REQUEST_MIN_COMPRESSION_SIZE_BYTES");
    private static final MultipleKeyEnvironmentSetting<String> AwsSigV4aSigningRegionSet = EnvironmentSettingKt.withAdditionalKeys$default(EnvironmentSettingKt.getStrEnvSetting().invoke("aws.sigV4aSigningRegionSet", "AWS_SIGV4A_SIGNING_REGION_SET"), CollectionsKt.listOf("aws.sigv4a.signing.region.set"), null, 2, null);
    private static final EnvironmentSetting<Boolean> AwsEndpointDiscoveryEnabled = EnvironmentSettingKt.getBoolEnvSetting().invoke("aws.endpointDiscoveryEnabled", "AWS_ENABLE_ENDPOINT_DISCOVERY");
    private static final EnvironmentSetting<RequestHttpChecksumConfig> AwsRequestChecksumCalculation = new EnvironmentSetting<>(new Function1<String, RequestHttpChecksumConfig>() { // from class: aws.sdk.kotlin.runtime.config.AwsSdkSetting$special$$inlined$enumEnvSetting$3
        @Override // kotlin.jvm.functions.Function1
        public final RequestHttpChecksumConfig invoke(String strValue) {
            RequestHttpChecksumConfig requestHttpChecksumConfig;
            Intrinsics.checkNotNullParameter(strValue, "strValue");
            RequestHttpChecksumConfig[] requestHttpChecksumConfigArrValues = RequestHttpChecksumConfig.values();
            int length = requestHttpChecksumConfigArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    requestHttpChecksumConfig = null;
                    break;
                }
                requestHttpChecksumConfig = requestHttpChecksumConfigArrValues[i];
                if (StringsKt.equals(requestHttpChecksumConfig.name(), strValue, true)) {
                    break;
                }
                i++;
            }
            RequestHttpChecksumConfig requestHttpChecksumConfig2 = requestHttpChecksumConfig;
            if (requestHttpChecksumConfig2 != null) {
                return requestHttpChecksumConfig2;
            }
            throw new ClientException("Value " + strValue + " is not supported, should be one of " + ArraysKt.joinToString$default(requestHttpChecksumConfigArrValues, TextRecallingManager.ANSWER_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }, "aws.requestChecksumCalculation", "AWS_REQUEST_CHECKSUM_CALCULATION", null, 8, null);
    private static final EnvironmentSetting<ResponseHttpChecksumConfig> AwsResponseChecksumValidation = new EnvironmentSetting<>(new Function1<String, ResponseHttpChecksumConfig>() { // from class: aws.sdk.kotlin.runtime.config.AwsSdkSetting$special$$inlined$enumEnvSetting$4
        @Override // kotlin.jvm.functions.Function1
        public final ResponseHttpChecksumConfig invoke(String strValue) {
            ResponseHttpChecksumConfig responseHttpChecksumConfig;
            Intrinsics.checkNotNullParameter(strValue, "strValue");
            ResponseHttpChecksumConfig[] responseHttpChecksumConfigArrValues = ResponseHttpChecksumConfig.values();
            int length = responseHttpChecksumConfigArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    responseHttpChecksumConfig = null;
                    break;
                }
                responseHttpChecksumConfig = responseHttpChecksumConfigArrValues[i];
                if (StringsKt.equals(responseHttpChecksumConfig.name(), strValue, true)) {
                    break;
                }
                i++;
            }
            ResponseHttpChecksumConfig responseHttpChecksumConfig2 = responseHttpChecksumConfig;
            if (responseHttpChecksumConfig2 != null) {
                return responseHttpChecksumConfig2;
            }
            throw new ClientException("Value " + strValue + " is not supported, should be one of " + ArraysKt.joinToString$default(responseHttpChecksumConfigArrValues, TextRecallingManager.ANSWER_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }, "aws.responseChecksumValidation", "AWS_RESPONSE_CHECKSUM_VALIDATION", null, 8, null);
    private static final EnvironmentSetting<String> AwsAuthSchemePreference = EnvironmentSettingKt.getStrEnvSetting().invoke("aws.authSchemePreference", "AWS_AUTH_SCHEME_PREFERENCE");

    private AwsSdkSetting() {
    }

    public final EnvironmentSetting<String> getAwsAccessKeyId() {
        return AwsAccessKeyId;
    }

    public final EnvironmentSetting<String> getAwsSecretAccessKey() {
        return AwsSecretAccessKey;
    }

    public final EnvironmentSetting<String> getAwsSessionToken() {
        return AwsSessionToken;
    }

    public final EnvironmentSetting<String> getAwsRegion() {
        return AwsRegion;
    }

    public final EnvironmentSetting<String> getAwsAccountId() {
        return AwsAccountId;
    }

    public final MultipleKeyEnvironmentSetting<String> getAwsAppId() {
        return AwsAppId;
    }

    public final EnvironmentSetting<String> getAwsConfigFile() {
        return AwsConfigFile;
    }

    public final EnvironmentSetting<String> getAwsSharedCredentialsFile() {
        return AwsSharedCredentialsFile;
    }

    public final EnvironmentSetting<String> getAwsExecutionEnv() {
        return AwsExecutionEnv;
    }

    public final EnvironmentSetting<String> getAwsProfile() {
        return AwsProfile;
    }

    public final EnvironmentSetting<Boolean> getAwsEc2MetadataDisabled() {
        return AwsEc2MetadataDisabled;
    }

    public final EnvironmentSetting<String> getAwsEc2MetadataServiceEndpoint() {
        return AwsEc2MetadataServiceEndpoint;
    }

    public final EnvironmentSetting<String> getAwsEc2MetadataServiceEndpointMode() {
        return AwsEc2MetadataServiceEndpointMode;
    }

    public final EnvironmentSetting<String> getAwsRoleArn() {
        return AwsRoleArn;
    }

    public final EnvironmentSetting<String> getAwsRoleSessionName() {
        return AwsRoleSessionName;
    }

    public final EnvironmentSetting<String> getAwsWebIdentityTokenFile() {
        return AwsWebIdentityTokenFile;
    }

    public final EnvironmentSetting<String> getAwsContainerCredentialsRelativeUri() {
        return AwsContainerCredentialsRelativeUri;
    }

    public final EnvironmentSetting<String> getAwsContainerCredentialsFullUri() {
        return AwsContainerCredentialsFullUri;
    }

    public final EnvironmentSetting<String> getAwsContainerAuthorizationToken() {
        return AwsContainerAuthorizationToken;
    }

    public final EnvironmentSetting<String> getAwsContainerAuthorizationTokenFile() {
        return AwsContainerAuthorizationTokenFile;
    }

    public final EnvironmentSetting<Integer> getAwsMaxAttempts() {
        return AwsMaxAttempts;
    }

    public final EnvironmentSetting<RetryMode> getAwsRetryMode() {
        return AwsRetryMode;
    }

    public final EnvironmentSetting<Boolean> getAwsUseFipsEndpoint() {
        return AwsUseFipsEndpoint;
    }

    public final EnvironmentSetting<Boolean> getAwsUseDualStackEndpoint() {
        return AwsUseDualStackEndpoint;
    }

    public final EnvironmentSetting<Url> getAwsEndpointUrl() {
        return AwsEndpointUrl;
    }

    public final EnvironmentSetting<Boolean> getAwsIgnoreEndpointUrls() {
        return AwsIgnoreEndpointUrls;
    }

    public final EnvironmentSetting<AccountIdEndpointMode> getAwsAccountIdEndpointMode() {
        return AwsAccountIdEndpointMode;
    }

    public final EnvironmentSetting<Boolean> getAwsDisableRequestCompression() {
        return AwsDisableRequestCompression;
    }

    public final EnvironmentSetting<Long> getAwsRequestMinCompressionSizeBytes() {
        return AwsRequestMinCompressionSizeBytes;
    }

    public final MultipleKeyEnvironmentSetting<String> getAwsSigV4aSigningRegionSet() {
        return AwsSigV4aSigningRegionSet;
    }

    public final EnvironmentSetting<Boolean> getAwsEndpointDiscoveryEnabled() {
        return AwsEndpointDiscoveryEnabled;
    }

    public final EnvironmentSetting<RequestHttpChecksumConfig> getAwsRequestChecksumCalculation() {
        return AwsRequestChecksumCalculation;
    }

    public final EnvironmentSetting<ResponseHttpChecksumConfig> getAwsResponseChecksumValidation() {
        return AwsResponseChecksumValidation;
    }

    public final EnvironmentSetting<String> getAwsAuthSchemePreference() {
        return AwsAuthSchemePreference;
    }
}
