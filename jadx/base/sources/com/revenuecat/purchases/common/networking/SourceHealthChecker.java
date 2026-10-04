package com.revenuecat.purchases.common.networking;

import com.fasterxml.jackson.core.JsonPointer;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.utils.DefaultUrlConnectionFactory;
import com.revenuecat.purchases.utils.UrlConnection;
import com.revenuecat.purchases.utils.UrlConnectionFactory;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SourceHealthChecker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0003\u0017\u0018\u0019B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\tJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/SourceHealthChecker;", "", "urlConnectionFactory", "Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Lcom/revenuecat/purchases/utils/UrlConnectionFactory;Lcom/revenuecat/purchases/common/DateProvider;)V", "cachedResults", "", "", "Lcom/revenuecat/purchases/common/networking/SourceHealthChecker$CachedResult;", "lock", "pendingChecks", "Lcom/revenuecat/purchases/common/networking/SourceHealthChecker$PendingCheck;", "healthUrl", "sourceBaseUrl", "isHealthy", "", "performCheck", "performOwnedCheck", "check", "validCachedResult", "(Ljava/lang/String;)Ljava/lang/Boolean;", "CachedResult", "Companion", "PendingCheck", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class SourceHealthChecker {
    private static final Companion Companion = new Companion(null);
    private static final IntRange HEALTHY_RESPONSE_CODES = new IntRange(200, AIContainerViewModel.SUMMARIZE_MIN_LIMIT);

    @Deprecated
    public static final int HEALTH_CHECK_TIMEOUT_MS = 5000;

    @Deprecated
    public static final String HEALTH_PATH = "v1/health/connectivity";

    @Deprecated
    public static final long RESULT_VALIDITY_MS = 10000;
    private final Map<String, CachedResult> cachedResults;
    private final DateProvider dateProvider;
    private final Object lock;
    private final Map<String, PendingCheck> pendingChecks;
    private final UrlConnectionFactory urlConnectionFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public SourceHealthChecker() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public SourceHealthChecker(UrlConnectionFactory urlConnectionFactory, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(urlConnectionFactory, "urlConnectionFactory");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.urlConnectionFactory = urlConnectionFactory;
        this.dateProvider = dateProvider;
        this.lock = new Object();
        this.pendingChecks = new LinkedHashMap();
        this.cachedResults = new LinkedHashMap();
    }

    public /* synthetic */ SourceHealthChecker(DefaultUrlConnectionFactory defaultUrlConnectionFactory, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultUrlConnectionFactory() : defaultUrlConnectionFactory, (i & 2) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    /* JADX INFO: compiled from: SourceHealthChecker.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/SourceHealthChecker$PendingCheck;", "", "()V", "isHealthy", "", "()Z", "setHealthy", "(Z)V", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class PendingCheck {
        private volatile boolean isHealthy;
        private final CountDownLatch latch = new CountDownLatch(1);

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        /* JADX INFO: renamed from: isHealthy, reason: from getter */
        public final boolean getIsHealthy() {
            return this.isHealthy;
        }

        public final void setHealthy(boolean z) {
            this.isHealthy = z;
        }
    }

    /* JADX INFO: compiled from: SourceHealthChecker.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/SourceHealthChecker$CachedResult;", "", "timestampMs", "", "isHealthy", "", "(JZ)V", "()Z", "getTimestampMs", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final /* data */ class CachedResult {
        private final boolean isHealthy;
        private final long timestampMs;

        public static /* synthetic */ CachedResult copy$default(CachedResult cachedResult, long j, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = cachedResult.timestampMs;
            }
            if ((i & 2) != 0) {
                z = cachedResult.isHealthy;
            }
            return cachedResult.copy(j, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestampMs() {
            return this.timestampMs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsHealthy() {
            return this.isHealthy;
        }

        public final CachedResult copy(long timestampMs, boolean isHealthy) {
            return new CachedResult(timestampMs, isHealthy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CachedResult)) {
                return false;
            }
            CachedResult cachedResult = (CachedResult) other;
            return this.timestampMs == cachedResult.timestampMs && this.isHealthy == cachedResult.isHealthy;
        }

        public int hashCode() {
            return (Long.hashCode(this.timestampMs) * 31) + Boolean.hashCode(this.isHealthy);
        }

        public String toString() {
            return "CachedResult(timestampMs=" + this.timestampMs + ", isHealthy=" + this.isHealthy + ')';
        }

        public CachedResult(long j, boolean z) {
            this.timestampMs = j;
            this.isHealthy = z;
        }

        public final long getTimestampMs() {
            return this.timestampMs;
        }

        public final boolean isHealthy() {
            return this.isHealthy;
        }
    }

    public final boolean isHealthy(String sourceBaseUrl) throws InterruptedException {
        boolean z;
        Intrinsics.checkNotNullParameter(sourceBaseUrl, "sourceBaseUrl");
        String strHealthUrl = healthUrl(sourceBaseUrl);
        synchronized (this.lock) {
            Boolean boolValidCachedResult = validCachedResult(strHealthUrl);
            if (boolValidCachedResult != null) {
                return boolValidCachedResult.booleanValue();
            }
            Map<String, PendingCheck> map = this.pendingChecks;
            PendingCheck pendingCheck = map.get(strHealthUrl);
            if (pendingCheck == null) {
                pendingCheck = new PendingCheck();
                map.put(strHealthUrl, pendingCheck);
                z = true;
            } else {
                z = false;
            }
            PendingCheck pendingCheck2 = pendingCheck;
            if (z) {
                return performOwnedCheck(strHealthUrl, pendingCheck2);
            }
            pendingCheck2.getLatch().await();
            return pendingCheck2.getIsHealthy();
        }
    }

    private final boolean performOwnedCheck(String healthUrl, PendingCheck check) {
        try {
            check.setHealthy(performCheck(healthUrl));
            synchronized (this.lock) {
                this.cachedResults.put(healthUrl, new CachedResult(this.dateProvider.getNow().getTime(), check.getIsHealthy()));
                this.pendingChecks.remove(healthUrl);
                Unit unit = Unit.INSTANCE;
            }
            check.getLatch().countDown();
            return check.getIsHealthy();
        } catch (Throwable th) {
            synchronized (this.lock) {
                this.cachedResults.put(healthUrl, new CachedResult(this.dateProvider.getNow().getTime(), check.getIsHealthy()));
                this.pendingChecks.remove(healthUrl);
                Unit unit2 = Unit.INSTANCE;
                check.getLatch().countDown();
                throw th;
            }
        }
    }

    private final Boolean validCachedResult(String healthUrl) {
        CachedResult cachedResult = this.cachedResults.get(healthUrl);
        if (cachedResult != null) {
            Boolean boolValueOf = Boolean.valueOf(cachedResult.isHealthy());
            boolValueOf.booleanValue();
            if (this.dateProvider.getNow().getTime() - cachedResult.getTimestampMs() < 10000) {
                return boolValueOf;
            }
        }
        return null;
    }

    private final boolean performCheck(String healthUrl) {
        String str;
        UrlConnection urlConnectionCreateConnection$default = null;
        try {
            try {
                str = healthUrl;
            } finally {
            }
        } catch (IOException e) {
            e = e;
            str = healthUrl;
        }
        try {
            urlConnectionCreateConnection$default = UrlConnectionFactory.createConnection$default(this.urlConnectionFactory, str, 5000, 5000, null, 8, null);
            int responseCode = urlConnectionCreateConnection$default.getResponseCode();
            IntRange intRange = HEALTHY_RESPONSE_CODES;
            boolean z = responseCode <= intRange.getLast() && intRange.getFirst() <= responseCode;
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Health check for " + str + " returned " + responseCode + " (healthy=" + z + ')');
            }
            if (urlConnectionCreateConnection$default != null) {
                urlConnectionCreateConnection$default.disconnect();
            }
            return z;
        } catch (IOException e2) {
            e = e2;
            IOException iOException = e;
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.mo1544v("[Purchases] - " + logLevel2.name(), "Health check for " + str + " failed to connect: " + iOException);
            }
            if (urlConnectionCreateConnection$default != null) {
                urlConnectionCreateConnection$default.disconnect();
            }
            return false;
        }
    }

    private final String healthUrl(String sourceBaseUrl) {
        return StringsKt.trimEnd(sourceBaseUrl, JsonPointer.SEPARATOR) + "/v1/health/connectivity";
    }

    /* JADX INFO: compiled from: SourceHealthChecker.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/SourceHealthChecker$Companion;", "", "()V", "HEALTHY_RESPONSE_CODES", "Lkotlin/ranges/IntRange;", "getHEALTHY_RESPONSE_CODES", "()Lkotlin/ranges/IntRange;", "HEALTH_CHECK_TIMEOUT_MS", "", "HEALTH_PATH", "", "RESULT_VALIDITY_MS", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IntRange getHEALTHY_RESPONSE_CODES() {
            return SourceHealthChecker.HEALTHY_RESPONSE_CODES;
        }
    }
}
