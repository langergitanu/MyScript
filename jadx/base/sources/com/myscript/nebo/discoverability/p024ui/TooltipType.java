package com.myscript.nebo.discoverability.p024ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TooltipUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/TooltipType;", "", "<init>", "(Ljava/lang/String;I)V", "Small", "Large", "Modal", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TooltipType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TooltipType[] $VALUES;
    public static final TooltipType Small = new TooltipType("Small", 0);
    public static final TooltipType Large = new TooltipType("Large", 1);
    public static final TooltipType Modal = new TooltipType("Modal", 2);

    private static final /* synthetic */ TooltipType[] $values() {
        return new TooltipType[]{Small, Large, Modal};
    }

    public static EnumEntries<TooltipType> getEntries() {
        return $ENTRIES;
    }

    public static TooltipType valueOf(String str) {
        return (TooltipType) Enum.valueOf(TooltipType.class, str);
    }

    public static TooltipType[] values() {
        return (TooltipType[]) $VALUES.clone();
    }

    private TooltipType(String str, int i) {
    }

    static {
        TooltipType[] tooltipTypeArr$values = $values();
        $VALUES = tooltipTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(tooltipTypeArr$values);
    }
}
