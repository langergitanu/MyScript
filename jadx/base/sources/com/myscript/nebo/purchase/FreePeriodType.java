package com.myscript.nebo.purchase;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SubscriptionRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/purchase/FreePeriodType;", "", "<init>", "(Ljava/lang/String;I)V", "Trial", "OEMOffer", "None", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FreePeriodType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FreePeriodType[] $VALUES;
    public static final FreePeriodType Trial = new FreePeriodType("Trial", 0);
    public static final FreePeriodType OEMOffer = new FreePeriodType("OEMOffer", 1);
    public static final FreePeriodType None = new FreePeriodType("None", 2);

    private static final /* synthetic */ FreePeriodType[] $values() {
        return new FreePeriodType[]{Trial, OEMOffer, None};
    }

    public static EnumEntries<FreePeriodType> getEntries() {
        return $ENTRIES;
    }

    public static FreePeriodType valueOf(String str) {
        return (FreePeriodType) Enum.valueOf(FreePeriodType.class, str);
    }

    public static FreePeriodType[] values() {
        return (FreePeriodType[]) $VALUES.clone();
    }

    private FreePeriodType(String str, int i) {
    }

    static {
        FreePeriodType[] freePeriodTypeArr$values = $values();
        $VALUES = freePeriodTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(freePeriodTypeArr$values);
    }
}
