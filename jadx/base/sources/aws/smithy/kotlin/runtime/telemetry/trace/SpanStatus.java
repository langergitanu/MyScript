package aws.smithy.kotlin.runtime.telemetry.trace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SpanStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/SpanStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UNSET", "OK", "ERROR", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SpanStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SpanStatus[] $VALUES;
    public static final SpanStatus UNSET = new SpanStatus("UNSET", 0);

    /* JADX INFO: renamed from: OK */
    public static final SpanStatus f529OK = new SpanStatus("OK", 1);
    public static final SpanStatus ERROR = new SpanStatus("ERROR", 2);

    private static final /* synthetic */ SpanStatus[] $values() {
        return new SpanStatus[]{UNSET, f529OK, ERROR};
    }

    public static EnumEntries<SpanStatus> getEntries() {
        return $ENTRIES;
    }

    public static SpanStatus valueOf(String str) {
        return (SpanStatus) Enum.valueOf(SpanStatus.class, str);
    }

    public static SpanStatus[] values() {
        return (SpanStatus[]) $VALUES.clone();
    }

    private SpanStatus(String str, int i) {
    }

    static {
        SpanStatus[] spanStatusArr$values = $values();
        $VALUES = spanStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(spanStatusArr$values);
    }
}
