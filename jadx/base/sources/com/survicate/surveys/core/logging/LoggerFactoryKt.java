package com.survicate.surveys.core.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoggerFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m1599d2 = {"createLogger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "sdkVersion", "", "config", "Lcom/survicate/surveys/core/logging/LoggerConfig;", "shared_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LoggerFactoryKt {
    public static final SdkLogger createLogger(String sdkVersion, LoggerConfig config) {
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(config, "config");
        return new SurvicateLogger(new ConsoleLogSink(sdkVersion), config);
    }
}
