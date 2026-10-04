package com.survicate.surveys.core.logging;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogEntry.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003JI\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, m1599d2 = {"Lcom/survicate/surveys/core/logging/LogEntry;", "", FirebaseAnalytics.Param.LEVEL, "Lcom/survicate/surveys/core/logging/SdkLogLevel;", "tag", "", "message", "throwable", "", TtmlNode.TAG_METADATA, "", "<init>", "(Lcom/survicate/surveys/core/logging/SdkLogLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", "getLevel", "()Lcom/survicate/surveys/core/logging/SdkLogLevel;", "getTag", "()Ljava/lang/String;", "getMessage", "getThrowable", "()Ljava/lang/Throwable;", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class LogEntry {
    private final SdkLogLevel level;
    private final String message;
    private final Map<String, String> metadata;
    private final String tag;
    private final Throwable throwable;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LogEntry copy$default(LogEntry logEntry, SdkLogLevel sdkLogLevel, String str, String str2, Throwable th, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkLogLevel = logEntry.level;
        }
        if ((i & 2) != 0) {
            str = logEntry.tag;
        }
        if ((i & 4) != 0) {
            str2 = logEntry.message;
        }
        if ((i & 8) != 0) {
            th = logEntry.throwable;
        }
        if ((i & 16) != 0) {
            map = logEntry.metadata;
        }
        Map map2 = map;
        String str3 = str2;
        return logEntry.copy(sdkLogLevel, str, str3, th, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SdkLogLevel getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final Map<String, String> component5() {
        return this.metadata;
    }

    public final LogEntry copy(SdkLogLevel level, String tag, String message, Throwable throwable, Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new LogEntry(level, tag, message, throwable, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogEntry)) {
            return false;
        }
        LogEntry logEntry = (LogEntry) other;
        return this.level == logEntry.level && Intrinsics.areEqual(this.tag, logEntry.tag) && Intrinsics.areEqual(this.message, logEntry.message) && Intrinsics.areEqual(this.throwable, logEntry.throwable) && Intrinsics.areEqual(this.metadata, logEntry.metadata);
    }

    public int hashCode() {
        int iHashCode = ((((this.level.hashCode() * 31) + this.tag.hashCode()) * 31) + this.message.hashCode()) * 31;
        Throwable th = this.throwable;
        return ((iHashCode + (th == null ? 0 : th.hashCode())) * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "LogEntry(level=" + this.level + ", tag=" + this.tag + ", message=" + this.message + ", throwable=" + this.throwable + ", metadata=" + this.metadata + ')';
    }

    public LogEntry(SdkLogLevel level, String tag, String message, Throwable th, Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.level = level;
        this.tag = tag;
        this.message = message;
        this.throwable = th;
        this.metadata = metadata;
    }

    public final SdkLogLevel getLevel() {
        return this.level;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public /* synthetic */ LogEntry(SdkLogLevel sdkLogLevel, String str, String str2, Throwable th, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sdkLogLevel, str, str2, (i & 8) != 0 ? null : th, (i & 16) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }
}
