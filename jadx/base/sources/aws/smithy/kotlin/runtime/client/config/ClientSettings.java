package aws.smithy.kotlin.runtime.client.config;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.LogMode;
import aws.smithy.kotlin.runtime.config.EnvironmentSetting;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.net.TlsVersion;
import com.survicate.surveys.TextRecallingManager;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ClientSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\b¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/config/ClientSettings;", "", "<init>", "()V", "MaxAttempts", "Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "", "getMaxAttempts", "()Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "MinTlsVersion", "Laws/smithy/kotlin/runtime/net/TlsVersion;", "getMinTlsVersion", "RetryMode", "Laws/smithy/kotlin/runtime/client/config/RetryMode;", "getRetryMode", "LogMode", "Laws/smithy/kotlin/runtime/client/LogMode;", "getLogMode", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ClientSettings {
    public static final ClientSettings INSTANCE = new ClientSettings();
    private static final EnvironmentSetting<Integer> MaxAttempts = EnvironmentSettingKt.getIntEnvSetting().invoke("sdk.maxAttempts", "SDK_MAX_ATTEMPTS");
    private static final EnvironmentSetting<TlsVersion> MinTlsVersion = new EnvironmentSetting<>(new Function1<String, TlsVersion>() { // from class: aws.smithy.kotlin.runtime.client.config.ClientSettings$special$$inlined$enumEnvSetting$1
        @Override // kotlin.jvm.functions.Function1
        public final TlsVersion invoke(String strValue) {
            TlsVersion tlsVersion;
            Intrinsics.checkNotNullParameter(strValue, "strValue");
            TlsVersion[] tlsVersionArrValues = TlsVersion.values();
            int length = tlsVersionArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    tlsVersion = null;
                    break;
                }
                tlsVersion = tlsVersionArrValues[i];
                if (StringsKt.equals(tlsVersion.name(), strValue, true)) {
                    break;
                }
                i++;
            }
            TlsVersion tlsVersion2 = tlsVersion;
            if (tlsVersion2 != null) {
                return tlsVersion2;
            }
            throw new ClientException("Value " + strValue + " is not supported, should be one of " + ArraysKt.joinToString$default(tlsVersionArrValues, TextRecallingManager.ANSWER_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }, "SDK_MIN_TLS", "sdk.minTls", null, 8, null);
    private static final EnvironmentSetting<RetryMode> RetryMode = new EnvironmentSetting<>(new Function1<String, RetryMode>() { // from class: aws.smithy.kotlin.runtime.client.config.ClientSettings$special$$inlined$enumEnvSetting$2
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
    }, "sdk.retryMode", "SDK_RETRY_MODE", null, 8, null);
    private static final EnvironmentSetting<LogMode> LogMode = new EnvironmentSetting<>(new ClientSettings$LogMode$1(LogMode.INSTANCE), "sdk.logMode", "SDK_LOG_MODE", LogMode.Default.INSTANCE);

    private ClientSettings() {
    }

    public final EnvironmentSetting<Integer> getMaxAttempts() {
        return MaxAttempts;
    }

    public final EnvironmentSetting<TlsVersion> getMinTlsVersion() {
        return MinTlsVersion;
    }

    public final EnvironmentSetting<RetryMode> getRetryMode() {
        return RetryMode;
    }

    public final EnvironmentSetting<LogMode> getLogMode() {
        return LogMode;
    }
}
