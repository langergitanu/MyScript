package aws.smithy.kotlin.runtime.retries.policy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: RetryErrorType.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "ServerSide", "ClientSide", "Throttling", "Transient", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RetryErrorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RetryErrorType[] $VALUES;
    public static final RetryErrorType ServerSide = new RetryErrorType("ServerSide", 0);
    public static final RetryErrorType ClientSide = new RetryErrorType("ClientSide", 1);
    public static final RetryErrorType Throttling = new RetryErrorType("Throttling", 2);
    public static final RetryErrorType Transient = new RetryErrorType("Transient", 3);

    private static final /* synthetic */ RetryErrorType[] $values() {
        return new RetryErrorType[]{ServerSide, ClientSide, Throttling, Transient};
    }

    public static EnumEntries<RetryErrorType> getEntries() {
        return $ENTRIES;
    }

    public static RetryErrorType valueOf(String str) {
        return (RetryErrorType) Enum.valueOf(RetryErrorType.class, str);
    }

    public static RetryErrorType[] values() {
        return (RetryErrorType[]) $VALUES.clone();
    }

    private RetryErrorType(String str, int i) {
    }

    static {
        RetryErrorType[] retryErrorTypeArr$values = $values();
        $VALUES = retryErrorTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(retryErrorTypeArr$values);
    }
}
