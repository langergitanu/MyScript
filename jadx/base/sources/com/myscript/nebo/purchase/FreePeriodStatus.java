package com.myscript.nebo.purchase;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SubscriptionRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/purchase/FreePeriodStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Unknown", "Active", "Expired", "NotStarted", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FreePeriodStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FreePeriodStatus[] $VALUES;
    public static final FreePeriodStatus Unknown = new FreePeriodStatus("Unknown", 0);
    public static final FreePeriodStatus Active = new FreePeriodStatus("Active", 1);
    public static final FreePeriodStatus Expired = new FreePeriodStatus("Expired", 2);
    public static final FreePeriodStatus NotStarted = new FreePeriodStatus("NotStarted", 3);

    private static final /* synthetic */ FreePeriodStatus[] $values() {
        return new FreePeriodStatus[]{Unknown, Active, Expired, NotStarted};
    }

    public static EnumEntries<FreePeriodStatus> getEntries() {
        return $ENTRIES;
    }

    public static FreePeriodStatus valueOf(String str) {
        return (FreePeriodStatus) Enum.valueOf(FreePeriodStatus.class, str);
    }

    public static FreePeriodStatus[] values() {
        return (FreePeriodStatus[]) $VALUES.clone();
    }

    private FreePeriodStatus(String str, int i) {
    }

    static {
        FreePeriodStatus[] freePeriodStatusArr$values = $values();
        $VALUES = freePeriodStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(freePeriodStatusArr$values);
    }
}
