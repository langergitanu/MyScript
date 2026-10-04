package aws.smithy.kotlin.runtime.time;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TimestampFormat.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/TimestampFormat;", "", "<init>", "(Ljava/lang/String;I)V", "ISO_8601", "ISO_8601_CONDENSED", "ISO_8601_CONDENSED_DATE", "ISO_8601_FULL", "RFC_5322", "EPOCH_SECONDS", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TimestampFormat {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TimestampFormat[] $VALUES;
    public static final TimestampFormat ISO_8601 = new TimestampFormat("ISO_8601", 0);
    public static final TimestampFormat ISO_8601_CONDENSED = new TimestampFormat("ISO_8601_CONDENSED", 1);
    public static final TimestampFormat ISO_8601_CONDENSED_DATE = new TimestampFormat("ISO_8601_CONDENSED_DATE", 2);
    public static final TimestampFormat ISO_8601_FULL = new TimestampFormat("ISO_8601_FULL", 3);
    public static final TimestampFormat RFC_5322 = new TimestampFormat("RFC_5322", 4);
    public static final TimestampFormat EPOCH_SECONDS = new TimestampFormat("EPOCH_SECONDS", 5);

    private static final /* synthetic */ TimestampFormat[] $values() {
        return new TimestampFormat[]{ISO_8601, ISO_8601_CONDENSED, ISO_8601_CONDENSED_DATE, ISO_8601_FULL, RFC_5322, EPOCH_SECONDS};
    }

    public static EnumEntries<TimestampFormat> getEntries() {
        return $ENTRIES;
    }

    public static TimestampFormat valueOf(String str) {
        return (TimestampFormat) Enum.valueOf(TimestampFormat.class, str);
    }

    public static TimestampFormat[] values() {
        return (TimestampFormat[]) $VALUES.clone();
    }

    private TimestampFormat(String str, int i) {
    }

    static {
        TimestampFormat[] timestampFormatArr$values = $values();
        $VALUES = timestampFormatArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(timestampFormatArr$values);
    }
}
