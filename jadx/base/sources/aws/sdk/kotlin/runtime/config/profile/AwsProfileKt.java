package aws.sdk.kotlin.runtime.config.profile;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.ConfigurationException;
import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.auth.credentials.profile.ProfileChainKt;
import aws.sdk.kotlin.runtime.config.endpoints.AccountIdEndpointMode;
import aws.smithy.kotlin.runtime.client.config.RequestHttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.config.ResponseHttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.config.RetryMode;
import aws.smithy.kotlin.runtime.net.url.Url;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.survicate.surveys.TextRecallingManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AwsProfile.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0010\n\u0002\b\u0004\u001a+\u0010\\\u001a\u0004\u0018\u00010'*\u00060\u0001j\u0002`\u00052\u0006\u0010]\u001a\u00020\u00042\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010_\u001a+\u0010`\u001a\u0004\u0018\u00010\u001a*\u00060\u0001j\u0002`\u00052\u0006\u0010]\u001a\u00020\u00042\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010a\u001a+\u0010b\u001a\u0004\u0018\u00010E*\u00060\u0001j\u0002`\u00052\u0006\u0010]\u001a\u00020\u00042\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010c\u001a>\u0010d\u001a\u0004\u0018\u0001He\"\u0010\b\u0000\u0010e\u0018\u0001*\b\u0012\u0004\u0012\u0002He0f*\u00060\u0001j\u0002`\u00052\u0006\u0010]\u001a\u00020\u00042\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0004H\u0087\b¢\u0006\u0002\u0010g\u001a&\u0010h\u001a\u0004\u0018\u00010/*\u00060\u0001j\u0002`\u00052\u0006\u0010]\u001a\u00020\u00042\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u001c\u0010i\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u00042\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0004H\u0002\"$\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"$\u0010\n\u001a\u0004\u0018\u00010\u0004*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\"$\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"$\u0010\u0010\u001a\u0004\u0018\u00010\u0004*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"$\u0010\u0013\u001a\u0004\u0018\u00010\u0004*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\t\"$\u0010\u0016\u001a\u0004\u0018\u00010\u0004*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\t\"$\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\u001d\"$\u0010\u001e\u001a\u0004\u0018\u00010\u0004*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0007\u001a\u0004\b \u0010\t\"$\u0010!\u001a\u0004\u0018\u00010\"*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0007\u001a\u0004\b$\u0010%\"$\u0010&\u001a\u0004\u0018\u00010'*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0007\u001a\u0004\b)\u0010*\"$\u0010+\u001a\u0004\u0018\u00010'*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0007\u001a\u0004\b-\u0010*\"$\u0010.\u001a\u0004\u0018\u00010/*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0007\u001a\u0004\b1\u00102\"$\u00103\u001a\u0004\u0018\u00010'*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0007\u001a\u0004\b5\u0010*\"$\u00106\u001a\u0004\u0018\u00010\u0004*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0007\u001a\u0004\b8\u0010\t\"$\u00109\u001a\u0004\u0018\u00010\u0004*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0007\u001a\u0004\b;\u0010\t\"$\u0010<\u001a\u0004\u0018\u00010=*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0007\u001a\u0004\b?\u0010@\"$\u0010A\u001a\u0004\u0018\u00010'*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0007\u001a\u0004\bC\u0010*\"$\u0010D\u001a\u0004\u0018\u00010E*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0007\u001a\u0004\bG\u0010H\"$\u0010I\u001a\u0004\u0018\u00010\u0004*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010\u0007\u001a\u0004\bK\u0010\t\"$\u0010L\u001a\u0004\u0018\u00010'*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010\u0007\u001a\u0004\bN\u0010*\"$\u0010O\u001a\u0004\u0018\u00010P*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u0010\u0007\u001a\u0004\bR\u0010S\"$\u0010T\u001a\u0004\u0018\u00010U*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\bV\u0010\u0007\u001a\u0004\bW\u0010X\"$\u0010Y\u001a\u0004\u0018\u00010\u0004*\u00060\u0001j\u0002`\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\bZ\u0010\u0007\u001a\u0004\b[\u0010\t*\u0010\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\u0002\b\u0002¨\u0006j"}, m1599d2 = {"AwsProfile", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/InternalSdkApi;", TtmlNode.TAG_REGION, "", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "getRegion$annotations", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;)V", "getRegion", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;)Ljava/lang/String;", "awsAccessKeyId", "getAwsAccessKeyId$annotations", "getAwsAccessKeyId", "awsSecretAccessKey", "getAwsSecretAccessKey$annotations", "getAwsSecretAccessKey", "awsSessionToken", "getAwsSessionToken$annotations", "getAwsSessionToken", "roleArn", "getRoleArn$annotations", "getRoleArn", "sourceProfile", "getSourceProfile$annotations", "getSourceProfile", "maxAttempts", "", "getMaxAttempts$annotations", "getMaxAttempts", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;)Ljava/lang/Integer;", "credentialProcess", "getCredentialProcess$annotations", "getCredentialProcess", "retryMode", "Laws/smithy/kotlin/runtime/client/config/RetryMode;", "getRetryMode$annotations", "getRetryMode", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;)Laws/smithy/kotlin/runtime/client/config/RetryMode;", "useFips", "", "getUseFips$annotations", "getUseFips", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;)Ljava/lang/Boolean;", "useDualStack", "getUseDualStack$annotations", "getUseDualStack", "endpointUrl", "Laws/smithy/kotlin/runtime/net/url/Url;", "getEndpointUrl$annotations", "getEndpointUrl", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;)Laws/smithy/kotlin/runtime/net/url/Url;", "ignoreEndpointUrls", "getIgnoreEndpointUrls$annotations", "getIgnoreEndpointUrls", "servicesSection", "getServicesSection$annotations", "getServicesSection", "sdkUserAgentAppId", "getSdkUserAgentAppId$annotations", "getSdkUserAgentAppId", "accountIdEndpointMode", "Laws/sdk/kotlin/runtime/config/endpoints/AccountIdEndpointMode;", "getAccountIdEndpointMode$annotations", "getAccountIdEndpointMode", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;)Laws/sdk/kotlin/runtime/config/endpoints/AccountIdEndpointMode;", "disableRequestCompression", "getDisableRequestCompression$annotations", "getDisableRequestCompression", "requestMinCompressionSizeBytes", "", "getRequestMinCompressionSizeBytes$annotations", "getRequestMinCompressionSizeBytes", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;)Ljava/lang/Long;", "sigV4aSigningRegionSet", "getSigV4aSigningRegionSet$annotations", "getSigV4aSigningRegionSet", "endpointDiscoveryEnabled", "getEndpointDiscoveryEnabled$annotations", "getEndpointDiscoveryEnabled", "requestChecksumCalculation", "Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "getRequestChecksumCalculation$annotations", "getRequestChecksumCalculation", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;)Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "responseChecksumValidation", "Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "getResponseChecksumValidation$annotations", "getResponseChecksumValidation", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;)Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "authSchemePreference", "getAuthSchemePreference$annotations", "getAuthSchemePreference", "getBooleanOrNull", SubscriberAttributeKt.JSON_NAME_KEY, "subKey", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "getIntOrNull", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "getLongOrNull", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "getEnumOrNull", ExifInterface.GPS_DIRECTION_TRUE, "", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Enum;", "getUrlOrNull", "buildKeyString", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsProfileKt {
    @InternalSdkApi
    public static /* synthetic */ void AwsProfile$annotations() {
    }

    @InternalSdkApi
    public static /* synthetic */ void getAccountIdEndpointMode$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getAuthSchemePreference$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getAwsAccessKeyId$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getAwsSecretAccessKey$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getAwsSessionToken$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getCredentialProcess$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getDisableRequestCompression$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getEndpointDiscoveryEnabled$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getEndpointUrl$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getIgnoreEndpointUrls$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getMaxAttempts$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getRegion$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getRequestChecksumCalculation$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getRequestMinCompressionSizeBytes$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getResponseChecksumValidation$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getRetryMode$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getRoleArn$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getSdkUserAgentAppId$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getServicesSection$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getSigV4aSigningRegionSet$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getSourceProfile$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getUseDualStack$annotations(ConfigSection configSection) {
    }

    @InternalSdkApi
    public static /* synthetic */ void getUseFips$annotations(ConfigSection configSection) {
    }

    public static final String getRegion(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return ConfigSection.getOrNull$default(configSection, TtmlNode.TAG_REGION, null, 2, null);
    }

    public static final String getAwsAccessKeyId(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return ConfigSection.getOrNull$default(configSection, ProfileChainKt.AWS_ACCESS_KEY_ID, null, 2, null);
    }

    public static final String getAwsSecretAccessKey(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return ConfigSection.getOrNull$default(configSection, ProfileChainKt.AWS_SECRET_ACCESS_KEY, null, 2, null);
    }

    public static final String getAwsSessionToken(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return ConfigSection.getOrNull$default(configSection, ProfileChainKt.AWS_SESSION_TOKEN, null, 2, null);
    }

    public static final String getRoleArn(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return ConfigSection.getOrNull$default(configSection, ProfileChainKt.ROLE_ARN, null, 2, null);
    }

    public static final String getSourceProfile(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return ConfigSection.getOrNull$default(configSection, ProfileChainKt.SOURCE_PROFILE, null, 2, null);
    }

    public static final Integer getMaxAttempts(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return getIntOrNull$default(configSection, "max_attempts", null, 2, null);
    }

    public static final String getCredentialProcess(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return ConfigSection.getOrNull$default(configSection, ProfileChainKt.CREDENTIAL_PROCESS, null, 2, null);
    }

    public static final Boolean getUseFips(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return getBooleanOrNull$default(configSection, "use_fips_endpoint", null, 2, null);
    }

    public static final Boolean getUseDualStack(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return getBooleanOrNull$default(configSection, "use_dualstack_endpoint", null, 2, null);
    }

    public static final Url getEndpointUrl(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return getUrlOrNull$default(configSection, "endpoint_url", null, 2, null);
    }

    public static final Boolean getIgnoreEndpointUrls(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return getBooleanOrNull$default(configSection, "ignore_configured_endpoint_urls", null, 2, null);
    }

    public static final String getServicesSection(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return ConfigSection.getOrNull$default(configSection, Literals.SERVICES_KEYWORD, null, 2, null);
    }

    public static final String getSdkUserAgentAppId(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return ConfigSection.getOrNull$default(configSection, "sdk_ua_app_id", null, 2, null);
    }

    public static final Boolean getDisableRequestCompression(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return getBooleanOrNull$default(configSection, "disable_request_compression", null, 2, null);
    }

    public static final Long getRequestMinCompressionSizeBytes(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return getLongOrNull$default(configSection, "request_min_compression_size_bytes", null, 2, null);
    }

    public static final String getSigV4aSigningRegionSet(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return ConfigSection.getOrNull$default(configSection, "sigv4a_signing_region_set", null, 2, null);
    }

    public static final Boolean getEndpointDiscoveryEnabled(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return getBooleanOrNull$default(configSection, "endpoint_discovery_enabled", null, 2, null);
    }

    public static final String getAuthSchemePreference(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        return ConfigSection.getOrNull$default(configSection, "auth_scheme_preference", null, 2, null);
    }

    @InternalSdkApi
    public static final Boolean getBooleanOrNull(ConfigSection configSection, String key, String str) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String orNull = configSection.getOrNull(key, str);
        if (orNull == null) {
            return null;
        }
        String lowerCase = orNull.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Boolean booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(lowerCase);
        if (booleanStrictOrNull == null) {
            throw new ConfigurationException("Failed to parse config property " + buildKeyString(key, str) + " as a boolean");
        }
        return Boolean.valueOf(booleanStrictOrNull.booleanValue());
    }

    public static /* synthetic */ Boolean getBooleanOrNull$default(ConfigSection configSection, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return getBooleanOrNull(configSection, str, str2);
    }

    @InternalSdkApi
    public static final Integer getIntOrNull(ConfigSection configSection, String key, String str) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String orNull = configSection.getOrNull(key, str);
        if (orNull == null) {
            return null;
        }
        Integer intOrNull = StringsKt.toIntOrNull(orNull);
        if (intOrNull == null) {
            throw new ConfigurationException("Failed to parse config property " + buildKeyString(key, str) + " as an integer");
        }
        return Integer.valueOf(intOrNull.intValue());
    }

    public static /* synthetic */ Integer getIntOrNull$default(ConfigSection configSection, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return getIntOrNull(configSection, str, str2);
    }

    @InternalSdkApi
    public static final Long getLongOrNull(ConfigSection configSection, String key, String str) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String orNull = configSection.getOrNull(key, str);
        if (orNull == null) {
            return null;
        }
        Long longOrNull = StringsKt.toLongOrNull(orNull);
        if (longOrNull == null) {
            throw new ConfigurationException("Failed to parse config property " + buildKeyString(key, str) + " as a long");
        }
        return Long.valueOf(longOrNull.longValue());
    }

    public static /* synthetic */ Long getLongOrNull$default(ConfigSection configSection, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return getLongOrNull(configSection, str, str2);
    }

    @InternalSdkApi
    public static final /* synthetic */ <T extends Enum<T>> T getEnumOrNull(ConfigSection configSection, String key, String str) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String orNull = configSection.getOrNull(key, str);
        if (orNull == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        Enum[] enumArr = new Enum[0];
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append(" '");
        sb.append(orNull);
        sb.append("' is not supported, should be one of: ");
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        Intrinsics.needClassReification();
        ArraysKt.joinTo(new Enum[0], sb, (62 & 2) != 0 ? TextRecallingManager.ANSWER_SEPARATOR : null, (62 & 4) != 0 ? "" : null, (62 & 8) != 0 ? "" : null, (62 & 16) != 0 ? -1 : 0, (62 & 32) != 0 ? "..." : null, (62 & 64) != 0 ? null : AwsProfileKt$getEnumOrNull$$inlined$let$lambda$1.INSTANCE);
        throw new ConfigurationException(sb.toString());
    }

    public static /* synthetic */ Enum getEnumOrNull$default(ConfigSection configSection, String key, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String orNull = configSection.getOrNull(key, str);
        if (orNull == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        Enum[] enumArr = new Enum[0];
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append(" '");
        sb.append(orNull);
        sb.append("' is not supported, should be one of: ");
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        Intrinsics.needClassReification();
        ArraysKt.joinTo(new Enum[0], sb, (62 & 2) != 0 ? TextRecallingManager.ANSWER_SEPARATOR : null, (62 & 4) != 0 ? "" : null, (62 & 8) != 0 ? "" : null, (62 & 16) != 0 ? -1 : 0, (62 & 32) != 0 ? "..." : null, (62 & 64) != 0 ? null : AwsProfileKt$getEnumOrNull$$inlined$let$lambda$1.INSTANCE);
        throw new ConfigurationException(sb.toString());
    }

    public static final Url getUrlOrNull(ConfigSection configSection, String key, String str) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String orNull = configSection.getOrNull(key, str);
        if (orNull == null) {
            return null;
        }
        try {
            return Url.Companion.parse$default(Url.INSTANCE, orNull, null, 2, null);
        } catch (Exception e) {
            throw new ConfigurationException("Failed to parse config property " + buildKeyString(key, str) + " as a URL", e);
        }
    }

    public static /* synthetic */ Url getUrlOrNull$default(ConfigSection configSection, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return getUrlOrNull(configSection, str, str2);
    }

    private static final String buildKeyString(String str, String str2) {
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str, str2}), ".", null, null, 0, null, null, 62, null);
    }

    static /* synthetic */ String buildKeyString$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return buildKeyString(str, str2);
    }

    public static final RetryMode getRetryMode(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        Enum r1 = null;
        String orNull = configSection.getOrNull("retry_mode", null);
        if (orNull != null) {
            RetryMode[] retryModeArrValues = RetryMode.values();
            int length = retryModeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                RetryMode retryMode = retryModeArrValues[i];
                if (StringsKt.equals(retryMode.name(), orNull, true)) {
                    r1 = retryMode;
                    break;
                }
                i++;
            }
            r1 = r1;
            if (r1 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("retry_mode '");
                sb.append(orNull);
                sb.append("' is not supported, should be one of: ");
                ArraysKt.joinTo(RetryMode.values(), sb, (62 & 2) != 0 ? TextRecallingManager.ANSWER_SEPARATOR : null, (62 & 4) != 0 ? "" : null, (62 & 8) != 0 ? "" : null, (62 & 16) != 0 ? -1 : 0, (62 & 32) != 0 ? "..." : null, (62 & 64) != 0 ? null : new Function1<RetryMode, CharSequence>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsProfileKt$special$$inlined$getEnumOrNull$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(RetryMode it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String lowerCase = it.name().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        return lowerCase;
                    }
                });
                throw new ConfigurationException(sb.toString());
            }
        }
        return (RetryMode) r1;
    }

    public static final AccountIdEndpointMode getAccountIdEndpointMode(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        Enum r1 = null;
        String orNull = configSection.getOrNull("account_id_endpoint_mode", null);
        if (orNull != null) {
            AccountIdEndpointMode[] accountIdEndpointModeArrValues = AccountIdEndpointMode.values();
            int length = accountIdEndpointModeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AccountIdEndpointMode accountIdEndpointMode = accountIdEndpointModeArrValues[i];
                if (StringsKt.equals(accountIdEndpointMode.name(), orNull, true)) {
                    r1 = accountIdEndpointMode;
                    break;
                }
                i++;
            }
            r1 = r1;
            if (r1 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("account_id_endpoint_mode '");
                sb.append(orNull);
                sb.append("' is not supported, should be one of: ");
                ArraysKt.joinTo(AccountIdEndpointMode.values(), sb, (62 & 2) != 0 ? TextRecallingManager.ANSWER_SEPARATOR : null, (62 & 4) != 0 ? "" : null, (62 & 8) != 0 ? "" : null, (62 & 16) != 0 ? -1 : 0, (62 & 32) != 0 ? "..." : null, (62 & 64) != 0 ? null : new Function1<AccountIdEndpointMode, CharSequence>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsProfileKt$special$$inlined$getEnumOrNull$default$2
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(AccountIdEndpointMode it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String lowerCase = it.name().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        return lowerCase;
                    }
                });
                throw new ConfigurationException(sb.toString());
            }
        }
        return (AccountIdEndpointMode) r1;
    }

    public static final RequestHttpChecksumConfig getRequestChecksumCalculation(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        Enum r1 = null;
        String orNull = configSection.getOrNull("request_checksum_calculation", null);
        if (orNull != null) {
            RequestHttpChecksumConfig[] requestHttpChecksumConfigArrValues = RequestHttpChecksumConfig.values();
            int length = requestHttpChecksumConfigArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                RequestHttpChecksumConfig requestHttpChecksumConfig = requestHttpChecksumConfigArrValues[i];
                if (StringsKt.equals(requestHttpChecksumConfig.name(), orNull, true)) {
                    r1 = requestHttpChecksumConfig;
                    break;
                }
                i++;
            }
            r1 = r1;
            if (r1 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("request_checksum_calculation '");
                sb.append(orNull);
                sb.append("' is not supported, should be one of: ");
                ArraysKt.joinTo(RequestHttpChecksumConfig.values(), sb, (62 & 2) != 0 ? TextRecallingManager.ANSWER_SEPARATOR : null, (62 & 4) != 0 ? "" : null, (62 & 8) != 0 ? "" : null, (62 & 16) != 0 ? -1 : 0, (62 & 32) != 0 ? "..." : null, (62 & 64) != 0 ? null : new Function1<RequestHttpChecksumConfig, CharSequence>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsProfileKt$special$$inlined$getEnumOrNull$default$3
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(RequestHttpChecksumConfig it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String lowerCase = it.name().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        return lowerCase;
                    }
                });
                throw new ConfigurationException(sb.toString());
            }
        }
        return (RequestHttpChecksumConfig) r1;
    }

    public static final ResponseHttpChecksumConfig getResponseChecksumValidation(ConfigSection configSection) {
        Intrinsics.checkNotNullParameter(configSection, "<this>");
        Enum r1 = null;
        String orNull = configSection.getOrNull("response_checksum_validation", null);
        if (orNull != null) {
            ResponseHttpChecksumConfig[] responseHttpChecksumConfigArrValues = ResponseHttpChecksumConfig.values();
            int length = responseHttpChecksumConfigArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                ResponseHttpChecksumConfig responseHttpChecksumConfig = responseHttpChecksumConfigArrValues[i];
                if (StringsKt.equals(responseHttpChecksumConfig.name(), orNull, true)) {
                    r1 = responseHttpChecksumConfig;
                    break;
                }
                i++;
            }
            r1 = r1;
            if (r1 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("response_checksum_validation '");
                sb.append(orNull);
                sb.append("' is not supported, should be one of: ");
                ArraysKt.joinTo(ResponseHttpChecksumConfig.values(), sb, (62 & 2) != 0 ? TextRecallingManager.ANSWER_SEPARATOR : null, (62 & 4) != 0 ? "" : null, (62 & 8) != 0 ? "" : null, (62 & 16) != 0 ? -1 : 0, (62 & 32) != 0 ? "..." : null, (62 & 64) != 0 ? null : new Function1<ResponseHttpChecksumConfig, CharSequence>() { // from class: aws.sdk.kotlin.runtime.config.profile.AwsProfileKt$special$$inlined$getEnumOrNull$default$4
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(ResponseHttpChecksumConfig it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String lowerCase = it.name().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        return lowerCase;
                    }
                });
                throw new ConfigurationException(sb.toString());
            }
        }
        return (ResponseHttpChecksumConfig) r1;
    }
}
