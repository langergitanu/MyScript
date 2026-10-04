package aws.smithy.kotlin.runtime.telemetry.trace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SpanKind.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/trace/SpanKind;", "", "<init>", "(Ljava/lang/String;I)V", "INTERNAL", "CLIENT", "SERVER", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SpanKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SpanKind[] $VALUES;
    public static final SpanKind INTERNAL = new SpanKind("INTERNAL", 0);
    public static final SpanKind CLIENT = new SpanKind("CLIENT", 1);
    public static final SpanKind SERVER = new SpanKind("SERVER", 2);

    private static final /* synthetic */ SpanKind[] $values() {
        return new SpanKind[]{INTERNAL, CLIENT, SERVER};
    }

    public static EnumEntries<SpanKind> getEntries() {
        return $ENTRIES;
    }

    public static SpanKind valueOf(String str) {
        return (SpanKind) Enum.valueOf(SpanKind.class, str);
    }

    public static SpanKind[] values() {
        return (SpanKind[]) $VALUES.clone();
    }

    private SpanKind(String str, int i) {
    }

    static {
        SpanKind[] spanKindArr$values = $values();
        $VALUES = spanKindArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(spanKindArr$values);
    }
}
