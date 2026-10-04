package aws.smithy.kotlin.runtime.telemetry.logging;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LogLevel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/LogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "Error", "Warning", "Info", "Debug", "Trace", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LogLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LogLevel[] $VALUES;
    public static final LogLevel Error = new LogLevel("Error", 0);
    public static final LogLevel Warning = new LogLevel("Warning", 1);
    public static final LogLevel Info = new LogLevel("Info", 2);
    public static final LogLevel Debug = new LogLevel("Debug", 3);
    public static final LogLevel Trace = new LogLevel("Trace", 4);

    private static final /* synthetic */ LogLevel[] $values() {
        return new LogLevel[]{Error, Warning, Info, Debug, Trace};
    }

    public static EnumEntries<LogLevel> getEntries() {
        return $ENTRIES;
    }

    public static LogLevel valueOf(String str) {
        return (LogLevel) Enum.valueOf(LogLevel.class, str);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) $VALUES.clone();
    }

    private LogLevel(String str, int i) {
    }

    static {
        LogLevel[] logLevelArr$values = $values();
        $VALUES = logLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(logLevelArr$values);
    }
}
