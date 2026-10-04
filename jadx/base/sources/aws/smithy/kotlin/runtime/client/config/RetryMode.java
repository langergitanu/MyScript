package aws.smithy.kotlin.runtime.client.config;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: RetryMode.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/config/RetryMode;", "", "<init>", "(Ljava/lang/String;I)V", "LEGACY", "STANDARD", "ADAPTIVE", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RetryMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RetryMode[] $VALUES;
    public static final RetryMode LEGACY = new RetryMode("LEGACY", 0);
    public static final RetryMode STANDARD = new RetryMode("STANDARD", 1);
    public static final RetryMode ADAPTIVE = new RetryMode("ADAPTIVE", 2);

    private static final /* synthetic */ RetryMode[] $values() {
        return new RetryMode[]{LEGACY, STANDARD, ADAPTIVE};
    }

    public static EnumEntries<RetryMode> getEntries() {
        return $ENTRIES;
    }

    public static RetryMode valueOf(String str) {
        return (RetryMode) Enum.valueOf(RetryMode.class, str);
    }

    public static RetryMode[] values() {
        return (RetryMode[]) $VALUES.clone();
    }

    private RetryMode(String str, int i) {
    }

    static {
        RetryMode[] retryModeArr$values = $values();
        $VALUES = retryModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(retryModeArr$values);
    }
}
