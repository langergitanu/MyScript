package com.revenuecat.purchases.common.localrules;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.rules.RulesEngineLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RulesEngineLoggerBridge.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesEngineLoggerBridge;", "Lcom/revenuecat/purchases/rules/RulesEngineLogger;", "()V", "LOG_PREFIX", "", "log", "", "message", "warn", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RulesEngineLoggerBridge implements RulesEngineLogger {
    public static final RulesEngineLoggerBridge INSTANCE = new RulesEngineLoggerBridge();
    private static final String LOG_PREFIX = "Rules engine: ";

    private RulesEngineLoggerBridge() {
    }

    @Override // com.revenuecat.purchases.rules.RulesEngineLogger
    public void warn(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), LOG_PREFIX + message);
        }
    }

    @Override // com.revenuecat.purchases.rules.RulesEngineLogger
    public void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), LOG_PREFIX + message);
        }
    }
}
