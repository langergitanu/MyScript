package com.survicate.surveys.core.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsoleLogSink.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/core/logging/ConsoleLogSink;", "Lcom/survicate/surveys/core/logging/LogSink;", "sdkVersion", "", "<init>", "(Ljava/lang/String;)V", "write", "", "entry", "Lcom/survicate/surveys/core/logging/LogEntry;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ConsoleLogSink implements LogSink {
    private final String sdkVersion;

    public ConsoleLogSink(String sdkVersion) {
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        this.sdkVersion = sdkVersion;
    }

    @Override // com.survicate.surveys.core.logging.LogSink
    public void write(LogEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        PlatformLogKt.platformLog(entry, this.sdkVersion);
    }
}
