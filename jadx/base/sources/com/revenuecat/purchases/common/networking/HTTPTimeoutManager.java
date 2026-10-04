package com.revenuecat.purchases.common.networking;

import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HTTPTimeoutManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/DateProvider;)V", "lastTimeoutByHost", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getTimeoutForRequest", DiagnosticsTracker.HOST_KEY, "isFallback", "", "fallbackAvailable", "isProxied", "reTieredTimeoutsEnabled", "hasRecentTimeout", "recordRequestResult", "", "result", "Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager$RequestResult;", "Companion", "RequestResult", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class HTTPTimeoutManager {
    public static final long DEFAULT_TIMEOUT_MS = 30000;
    public static final long FALLBACK_HOST_TIMEOUT_MS = 30000;
    public static final long MAIN_SOURCE_NO_FALLBACK_REDUCED_TIMEOUT_MS = 5000;
    public static final long MAIN_SOURCE_NO_FALLBACK_TIMEOUT_MS = 15000;
    public static final long REDUCED_TIMEOUT_MS = 2000;
    public static final long SUPPORTED_FALLBACK_TIMEOUT_MS = 5000;
    public static final long TEST_DIVIDER = 10;
    public static final long TIMEOUT_RESET_INTERVAL_MS = 600000;
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final ConcurrentHashMap<String, Long> lastTimeoutByHost;

    /* JADX INFO: compiled from: HTTPTimeoutManager.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager$RequestResult;", "", "(Ljava/lang/String;I)V", "SUCCESS_ON_MAIN_BACKEND", "MAIN_SOURCE_TIMED_OUT", "OTHER_RESULT", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public enum RequestResult {
        SUCCESS_ON_MAIN_BACKEND,
        MAIN_SOURCE_TIMED_OUT,
        OTHER_RESULT
    }

    /* JADX INFO: compiled from: HTTPTimeoutManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestResult.values().length];
            try {
                iArr[RequestResult.SUCCESS_ON_MAIN_BACKEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RequestResult.MAIN_SOURCE_TIMED_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RequestResult.OTHER_RESULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HTTPTimeoutManager(AppConfig appConfig, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.appConfig = appConfig;
        this.dateProvider = dateProvider;
        this.lastTimeoutByHost = new ConcurrentHashMap<>();
    }

    public /* synthetic */ HTTPTimeoutManager(AppConfig appConfig, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appConfig, (i & 2) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long getTimeoutForRequest(String host, boolean isFallback, boolean fallbackAvailable, boolean isProxied, boolean reTieredTimeoutsEnabled) {
        long j = 30000;
        if (!isFallback && !isProxied) {
            boolean zHasRecentTimeout = host != null ? hasRecentTimeout(host) : false;
            if (fallbackAvailable && zHasRecentTimeout) {
                j = 2000;
            } else if (!fallbackAvailable) {
                if (reTieredTimeoutsEnabled) {
                    j = zHasRecentTimeout ? 5000L : 15000L;
                }
            }
        }
        return this.appConfig.getRunningTests() ? j / 10 : j;
    }

    public final void recordRequestResult(String host, RequestResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (host == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[result.ordinal()];
        if (i == 1) {
            this.lastTimeoutByHost.remove(host);
        } else {
            if (i != 2) {
                return;
            }
            this.lastTimeoutByHost.put(host, Long.valueOf(this.dateProvider.getNow().getTime()));
        }
    }

    private final boolean hasRecentTimeout(String host) {
        Long l = this.lastTimeoutByHost.get(host);
        if (l == null) {
            return false;
        }
        long jLongValue = l.longValue();
        boolean z = this.dateProvider.getNow().getTime() - jLongValue >= 600000;
        if (z) {
            this.lastTimeoutByHost.remove(host, Long.valueOf(jLongValue));
        }
        return !z;
    }
}
