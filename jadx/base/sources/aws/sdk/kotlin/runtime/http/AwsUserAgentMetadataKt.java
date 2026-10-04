package aws.sdk.kotlin.runtime.http;

import aws.sdk.kotlin.runtime.http.operation.CustomUserAgentMetadata;
import aws.smithy.kotlin.runtime.util.OperatingSystem;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.fasterxml.jackson.core.JsonPointer;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: AwsUserAgentMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\n\u001a$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\u0012H\u0002\u001a(\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\f\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u001c\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u001a\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m1599d2 = {AwsUserAgentMetadataKt.AWS_EXECUTION_ENV, "", "AWS_APP_ID_ENV", "USER_AGENT_SPEC_VERSION", "BUSINESS_METRICS_MAX_LENGTH", "", "AWS_APP_ID_PROP", "FRAMEWORK_METADATA_ENV", "FRAMEWORK_METADATA_PROP", "loadAwsUserAgentMetadataFromEnvironment", "Laws/sdk/kotlin/runtime/http/AwsUserAgentMetadata;", DeviceDimensionProvider.KEY_PLATFORM, "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "apiMeta", "Laws/sdk/kotlin/runtime/http/ApiMetadata;", "appIdValue", "detectExecEnv", "Laws/sdk/kotlin/runtime/http/ExecutionEnvMetadata;", "Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;", "VALID_TCHAR_NO_HASH", "", "", "VALID_TCHAR", "uaPair", "category", SubscriberAttributeKt.JSON_NAME_KEY, "value", "encodeUaName", "encodeUaValue", "encodeUaString", "charSet", "aws-http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsUserAgentMetadataKt {
    public static final String AWS_APP_ID_ENV = "AWS_SDK_UA_APP_ID";
    public static final String AWS_APP_ID_PROP = "aws.userAgentAppId";
    public static final String AWS_EXECUTION_ENV = "AWS_EXECUTION_ENV";
    public static final int BUSINESS_METRICS_MAX_LENGTH = 1024;
    public static final String FRAMEWORK_METADATA_ENV = "AWS_FRAMEWORK_METADATA";
    public static final String FRAMEWORK_METADATA_PROP = "aws.frameworkMetadata";
    private static final String USER_AGENT_SPEC_VERSION = "2.1";
    private static final Set<Character> VALID_TCHAR;
    private static final Set<Character> VALID_TCHAR_NO_HASH;

    public static /* synthetic */ AwsUserAgentMetadata loadAwsUserAgentMetadataFromEnvironment$default(PlatformProvider platformProvider, ApiMetadata apiMetadata, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return loadAwsUserAgentMetadataFromEnvironment(platformProvider, apiMetadata, str);
    }

    public static final AwsUserAgentMetadata loadAwsUserAgentMetadataFromEnvironment(PlatformProvider platform, ApiMetadata apiMeta, String str) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(apiMeta, "apiMeta");
        SdkMetadata sdkMetadata = new SdkMetadata("kotlin", apiMeta.getVersion());
        OperatingSystem operatingSystemOsInfo = platform.osInfo();
        OsMetadata osMetadata = new OsMetadata(operatingSystemOsInfo.getFamily(), operatingSystemOsInfo.getVersion());
        LanguageMetadata languageMetadataPlatformLanguageMetadata = AwsUserAgentMetadataJvmKt.platformLanguageMetadata();
        if (str == null && (str = platform.getProperty(AWS_APP_ID_PROP)) == null) {
            str = platform.getenv(AWS_APP_ID_ENV);
        }
        PlatformProvider platformProvider = platform;
        return new AwsUserAgentMetadata(sdkMetadata, apiMeta, osMetadata, languageMetadataPlatformLanguageMetadata, detectExecEnv(platformProvider), FrameworkMetadata.INSTANCE.fromEnvironment$aws_http(platformProvider), str, CustomUserAgentMetadata.INSTANCE.fromEnvironment$aws_http(platformProvider));
    }

    private static final ExecutionEnvMetadata detectExecEnv(PlatformEnvironProvider platformEnvironProvider) {
        String str = platformEnvironProvider.getenv(AWS_EXECUTION_ENV);
        if (str != null) {
            return new ExecutionEnvMetadata(str);
        }
        return null;
    }

    static {
        Set<Character> of = SetsKt.setOf((Object[]) new Character[]{'!', Character.valueOf(Typography.dollar), '%', Character.valueOf(Typography.amp), '\'', '*', '+', Character.valueOf(Soundex.SILENT_MARKER), '.', '^', '_', '`', '|', '~'});
        VALID_TCHAR_NO_HASH = of;
        VALID_TCHAR = SetsKt.plus(of, '#');
    }

    public static /* synthetic */ String uaPair$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return uaPair(str, str2, str3);
    }

    public static final String uaPair(String category, String str, String str2) {
        Intrinsics.checkNotNullParameter(category, "category");
        if (str == null && str2 == null) {
            return encodeUaName(category);
        }
        if (str2 == null) {
            StringBuilder sbAppend = new StringBuilder().append(encodeUaName(category)).append(JsonPointer.SEPARATOR);
            Intrinsics.checkNotNull(str);
            return sbAppend.append(encodeUaName(str)).toString();
        }
        if (str == null) {
            return encodeUaName(category) + JsonPointer.SEPARATOR + encodeUaValue(str2);
        }
        return encodeUaName(category) + JsonPointer.SEPARATOR + encodeUaName(str) + '#' + encodeUaValue(str2);
    }

    private static final String encodeUaName(String str) {
        return encodeUaString(str, VALID_TCHAR_NO_HASH);
    }

    private static final String encodeUaValue(String str) {
        return encodeUaString(str, VALID_TCHAR);
    }

    private static final String encodeUaString(String str, Set<Character> set) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ' ') {
                sb.append("_");
            } else if (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || (('0' <= cCharAt && cCharAt < ':') || set.contains(Character.valueOf(cCharAt))))) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }
}
