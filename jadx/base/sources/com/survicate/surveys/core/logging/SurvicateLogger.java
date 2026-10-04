package com.survicate.surveys.core.logging;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.survicate.surveys.core.logging.SdkLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurvicateLogger.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J,\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016J\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016JB\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m1599d2 = {"Lcom/survicate/surveys/core/logging/SurvicateLogger;", "Lcom/survicate/surveys/core/logging/SdkLogger;", "sink", "Lcom/survicate/surveys/core/logging/LogSink;", "config", "Lcom/survicate/surveys/core/logging/LoggerConfig;", "<init>", "(Lcom/survicate/surveys/core/logging/LogSink;Lcom/survicate/surveys/core/logging/LoggerConfig;)V", "debug", "", "tag", "", "message", "info", TtmlNode.TAG_METADATA, "", "warn", "throwable", "", "error", "write", FirebaseAnalytics.Param.LEVEL, "Lcom/survicate/surveys/core/logging/SdkLogLevel;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateLogger implements SdkLogger {
    private final LoggerConfig config;
    private final LogSink sink;

    public SurvicateLogger(LogSink sink, LoggerConfig config) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(config, "config");
        this.sink = sink;
        this.config = config;
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void error(String str, String str2) {
        SdkLogger.DefaultImpls.error(this, str, str2);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void info(String str, String str2) {
        SdkLogger.DefaultImpls.info(this, str, str2);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void warn(String str, String str2) {
        SdkLogger.DefaultImpls.warn(this, str, str2);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void debug(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        write$default(this, SdkLogLevel.DEBUG, tag, message, null, null, 24, null);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void info(String tag, String message, Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        write$default(this, SdkLogLevel.INFO, tag, message, null, metadata, 8, null);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void warn(String tag, String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        write$default(this, SdkLogLevel.WARN, tag, message, throwable, null, 16, null);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void error(String tag, String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        write$default(this, SdkLogLevel.ERROR, tag, message, throwable, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void write$default(SurvicateLogger survicateLogger, SdkLogLevel sdkLogLevel, String str, String str2, Throwable th, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            th = null;
        }
        Throwable th2 = th;
        if ((i & 16) != 0) {
            map = MapsKt.emptyMap();
        }
        survicateLogger.write(sdkLogLevel, str, str2, th2, map);
    }

    private final void write(SdkLogLevel level, String tag, String message, Throwable throwable, Map<String, String> metadata) {
        if (this.config.getEnabled()) {
            this.sink.write(new LogEntry(level, tag, message, throwable, metadata));
        }
    }
}
