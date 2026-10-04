package com.myscript.nebo.discoverability.p024ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TooltipUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/TooltipPosition;", "", "<init>", "(Ljava/lang/String;I)V", "Top", "Bottom", "Left", "Right", "Auto", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TooltipPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TooltipPosition[] $VALUES;
    public static final TooltipPosition Top = new TooltipPosition("Top", 0);
    public static final TooltipPosition Bottom = new TooltipPosition("Bottom", 1);
    public static final TooltipPosition Left = new TooltipPosition("Left", 2);
    public static final TooltipPosition Right = new TooltipPosition("Right", 3);
    public static final TooltipPosition Auto = new TooltipPosition("Auto", 4);

    private static final /* synthetic */ TooltipPosition[] $values() {
        return new TooltipPosition[]{Top, Bottom, Left, Right, Auto};
    }

    public static EnumEntries<TooltipPosition> getEntries() {
        return $ENTRIES;
    }

    public static TooltipPosition valueOf(String str) {
        return (TooltipPosition) Enum.valueOf(TooltipPosition.class, str);
    }

    public static TooltipPosition[] values() {
        return (TooltipPosition[]) $VALUES.clone();
    }

    private TooltipPosition(String str, int i) {
    }

    static {
        TooltipPosition[] tooltipPositionArr$values = $values();
        $VALUES = tooltipPositionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(tooltipPositionArr$values);
    }
}
