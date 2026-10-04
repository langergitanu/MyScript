package com.survicate.surveys.helpers;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.core.logging.SdkLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurvicateLogger.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J#\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J-\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000fH\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J#\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/helpers/SurvicateLogger;", "Lcom/survicate/surveys/core/logging/SdkLogger;", "logger", "<init>", "(Lcom/survicate/surveys/core/logging/SdkLogger;)V", "debug", "", "tag", "", "message", "error", "throwable", "", "info", TtmlNode.TAG_METADATA, "", "warn", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateLogger implements SdkLogger {
    private final /* synthetic */ SdkLogger $$delegate_0;

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void debug(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        this.$$delegate_0.debug(tag, message);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void error(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        this.$$delegate_0.error(tag, message);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void error(String tag, String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        this.$$delegate_0.error(tag, message, throwable);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void info(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        this.$$delegate_0.info(tag, message);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void info(String tag, String message, Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.$$delegate_0.info(tag, message, metadata);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void warn(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        this.$$delegate_0.warn(tag, message);
    }

    @Override // com.survicate.surveys.core.logging.SdkLogger
    public void warn(String tag, String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        this.$$delegate_0.warn(tag, message, throwable);
    }

    public SurvicateLogger(SdkLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.$$delegate_0 = logger;
    }
}
