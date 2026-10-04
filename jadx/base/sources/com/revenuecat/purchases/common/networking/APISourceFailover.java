package com.revenuecat.purchases.common.networking;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceHandle;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceProvider;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: APISourceFailover.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J \u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/APISourceFailover;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "sourceProvider", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceProvider;", "healthChecker", "Lcom/revenuecat/purchases/common/networking/SourceHealthChecker;", "connectivityChecker", "Lcom/revenuecat/purchases/common/networking/DeviceConnectivityChecker;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceProvider;Lcom/revenuecat/purchases/common/networking/SourceHealthChecker;Lcom/revenuecat/purchases/common/networking/DeviceConnectivityChecker;)V", "currentResolvedSource", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$ResolvedSource;", "currentSource", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "baseURL", "Ljava/net/URL;", "isFallbackAttempt", "", "onRequestFailure", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision;", FirebaseAnalytics.Param.SOURCE, "connectionException", "Ljava/io/IOException;", "FailureDecision", "ResolvedSource", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class APISourceFailover {
    private final AppConfig appConfig;
    private final DeviceConnectivityChecker connectivityChecker;
    private final SourceHealthChecker healthChecker;
    private final RemoteConfigSourceProvider sourceProvider;

    public APISourceFailover(AppConfig appConfig, RemoteConfigSourceProvider sourceProvider, SourceHealthChecker healthChecker, DeviceConnectivityChecker connectivityChecker) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(sourceProvider, "sourceProvider");
        Intrinsics.checkNotNullParameter(healthChecker, "healthChecker");
        Intrinsics.checkNotNullParameter(connectivityChecker, "connectivityChecker");
        this.appConfig = appConfig;
        this.sourceProvider = sourceProvider;
        this.healthChecker = healthChecker;
        this.connectivityChecker = connectivityChecker;
    }

    /* JADX INFO: compiled from: APISourceFailover.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/APISourceFailover$ResolvedSource;", "", "handle", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle;", ImagesContract.URL, "Ljava/net/URL;", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle;Ljava/net/URL;)V", "getHandle", "()Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceHandle;", "getUrl", "()Ljava/net/URL;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class ResolvedSource {
        private final RemoteConfigSourceHandle handle;
        private final URL url;

        public static /* synthetic */ ResolvedSource copy$default(ResolvedSource resolvedSource, RemoteConfigSourceHandle remoteConfigSourceHandle, URL url, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteConfigSourceHandle = resolvedSource.handle;
            }
            if ((i & 2) != 0) {
                url = resolvedSource.url;
            }
            return resolvedSource.copy(remoteConfigSourceHandle, url);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RemoteConfigSourceHandle getHandle() {
            return this.handle;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final URL getUrl() {
            return this.url;
        }

        public final ResolvedSource copy(RemoteConfigSourceHandle handle, URL url) {
            Intrinsics.checkNotNullParameter(handle, "handle");
            Intrinsics.checkNotNullParameter(url, "url");
            return new ResolvedSource(handle, url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResolvedSource)) {
                return false;
            }
            ResolvedSource resolvedSource = (ResolvedSource) other;
            return Intrinsics.areEqual(this.handle, resolvedSource.handle) && Intrinsics.areEqual(this.url, resolvedSource.url);
        }

        public int hashCode() {
            return (this.handle.hashCode() * 31) + this.url.hashCode();
        }

        public String toString() {
            return "ResolvedSource(handle=" + this.handle + ", url=" + this.url + ')';
        }

        public ResolvedSource(RemoteConfigSourceHandle handle, URL url) {
            Intrinsics.checkNotNullParameter(handle, "handle");
            Intrinsics.checkNotNullParameter(url, "url");
            this.handle = handle;
            this.url = url;
        }

        public final RemoteConfigSourceHandle getHandle() {
            return this.handle;
        }

        public final URL getUrl() {
            return this.url;
        }
    }

    /* JADX INFO: compiled from: APISourceFailover.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision;", "", "DeviceOffline", "RetryNextSource", "SourceHealthy", "SourcesExhausted", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision$DeviceOffline;", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision$RetryNextSource;", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision$SourceHealthy;", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision$SourcesExhausted;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public interface FailureDecision {

        /* JADX INFO: compiled from: APISourceFailover.kt */
        @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision$RetryNextSource;", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision;", "next", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$ResolvedSource;", "(Lcom/revenuecat/purchases/common/networking/APISourceFailover$ResolvedSource;)V", "getNext", "()Lcom/revenuecat/purchases/common/networking/APISourceFailover$ResolvedSource;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class RetryNextSource implements FailureDecision {
            private final ResolvedSource next;

            public static /* synthetic */ RetryNextSource copy$default(RetryNextSource retryNextSource, ResolvedSource resolvedSource, int i, Object obj) {
                if ((i & 1) != 0) {
                    resolvedSource = retryNextSource.next;
                }
                return retryNextSource.copy(resolvedSource);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ResolvedSource getNext() {
                return this.next;
            }

            public final RetryNextSource copy(ResolvedSource next) {
                Intrinsics.checkNotNullParameter(next, "next");
                return new RetryNextSource(next);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RetryNextSource) && Intrinsics.areEqual(this.next, ((RetryNextSource) other).next);
            }

            public int hashCode() {
                return this.next.hashCode();
            }

            public String toString() {
                return "RetryNextSource(next=" + this.next + ')';
            }

            public RetryNextSource(ResolvedSource next) {
                Intrinsics.checkNotNullParameter(next, "next");
                this.next = next;
            }

            public final ResolvedSource getNext() {
                return this.next;
            }
        }

        /* JADX INFO: compiled from: APISourceFailover.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision$SourceHealthy;", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class SourceHealthy implements FailureDecision {
            public static final SourceHealthy INSTANCE = new SourceHealthy();

            private SourceHealthy() {
            }
        }

        /* JADX INFO: compiled from: APISourceFailover.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision$SourcesExhausted;", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class SourcesExhausted implements FailureDecision {
            public static final SourcesExhausted INSTANCE = new SourcesExhausted();

            private SourcesExhausted() {
            }
        }

        /* JADX INFO: compiled from: APISourceFailover.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision$DeviceOffline;", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$FailureDecision;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class DeviceOffline implements FailureDecision {
            public static final DeviceOffline INSTANCE = new DeviceOffline();

            private DeviceOffline() {
            }
        }
    }

    public final ResolvedSource currentSource(Endpoint endpoint, URL baseURL, boolean isFallbackAttempt) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(baseURL, "baseURL");
        if (this.appConfig.getUsesRemoteConfigAPISources() && !isFallbackAttempt && endpoint.getUsesAPISources() && Intrinsics.areEqual(baseURL.toString(), AppConfig.baseUrlString)) {
            return currentResolvedSource();
        }
        return null;
    }

    public final FailureDecision onRequestFailure(final ResolvedSource source, IOException connectionException) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(source, "source");
        if (connectionException == null || !this.connectivityChecker.isDeviceOffline()) {
            if (!this.healthChecker.isHealthy(source.getHandle().getUrl())) {
                this.sourceProvider.reportUnhealthy(source.getHandle());
                ResolvedSource resolvedSourceCurrentResolvedSource = currentResolvedSource();
                return resolvedSourceCurrentResolvedSource != null ? new FailureDecision.RetryNextSource(resolvedSourceCurrentResolvedSource) : FailureDecision.SourcesExhausted.INSTANCE;
            }
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.networking.APISourceFailover$onRequestFailure$$inlined$log$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + TokenParser.f2383SP + ("API source " + source.getHandle().getUrl() + " is healthy despite the request failing; not failing over.");
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler2.mo1541d("[Purchases] - " + logLevel.name(), function0.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler3.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler4.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler5.mo1541d("[Purchases] - " + logLevel4.name(), function0.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler6.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler7.mo1541d("[Purchases] - " + logLevel6.name(), function0.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler8.mo1541d("[Purchases] - " + logLevel7.name(), function0.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler9.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler10.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler11.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
            }
            return FailureDecision.SourceHealthy.INSTANCE;
        }
        final LogIntent logIntent2 = LogIntent.DEBUG;
        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.common.networking.APISourceFailover$onRequestFailure$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + TokenParser.f2383SP + ("Device appears to be offline; not failing over from " + source.getHandle().getUrl() + '.');
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
            case 1:
                LogLevel logLevel11 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                    str = "[Purchases] - " + logLevel11.name();
                    strInvoke = function02.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 3:
                LogLevel logLevel12 = LogLevel.WARN;
                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                    currentLogHandler12.mo1545w("[Purchases] - " + logLevel12.name(), function02.invoke());
                }
                break;
            case 4:
                LogLevel logLevel13 = LogLevel.INFO;
                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                    currentLogHandler13.mo1543i("[Purchases] - " + logLevel13.name(), function02.invoke());
                }
                break;
            case 5:
                LogLevel logLevel14 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                    str = "[Purchases] - " + logLevel14.name();
                    strInvoke = function02.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 7:
                LogLevel logLevel15 = LogLevel.INFO;
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    currentLogHandler14.mo1543i("[Purchases] - " + logLevel15.name(), function02.invoke());
                }
                break;
            case 8:
                LogLevel logLevel16 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                    str = "[Purchases] - " + logLevel16.name();
                    strInvoke = function02.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel17 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                    str = "[Purchases] - " + logLevel17.name();
                    strInvoke = function02.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel18 = LogLevel.WARN;
                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                    currentLogHandler15.mo1545w("[Purchases] - " + logLevel18.name(), function02.invoke());
                }
                break;
            case 11:
                LogLevel logLevel19 = LogLevel.WARN;
                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                    currentLogHandler16.mo1545w("[Purchases] - " + logLevel19.name(), function02.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 13:
                LogLevel logLevel20 = LogLevel.WARN;
                LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                    currentLogHandler17.mo1545w("[Purchases] - " + logLevel20.name(), function02.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
        }
        return FailureDecision.DeviceOffline.INSTANCE;
    }

    private final ResolvedSource currentResolvedSource() {
        while (true) {
            RemoteConfigSourceHandle remoteConfigSourceHandleCurrentAPISource = this.sourceProvider.currentAPISource();
            if (remoteConfigSourceHandleCurrentAPISource == null) {
                return null;
            }
            try {
                return new ResolvedSource(remoteConfigSourceHandleCurrentAPISource, new URL(remoteConfigSourceHandleCurrentAPISource.getUrl()));
            } catch (MalformedURLException e) {
                LogLevel logLevel = LogLevel.WARN;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Skipping API source with malformed url " + remoteConfigSourceHandleCurrentAPISource.getUrl() + ": " + e);
                }
                this.sourceProvider.reportUnhealthy(remoteConfigSourceHandleCurrentAPISource);
            }
        }
    }
}
