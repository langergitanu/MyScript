package com.myscript.nebo.editing;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: StylusSwitchBehavior.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/editing/StylusSwitchBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "CURRENT_AND_ERASER", "CURRENT_AND_TOOL", "COLOR_PALETTE", "NONE", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StylusSwitchBehavior {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StylusSwitchBehavior[] $VALUES;
    public static final StylusSwitchBehavior CURRENT_AND_ERASER = new StylusSwitchBehavior("CURRENT_AND_ERASER", 0);
    public static final StylusSwitchBehavior CURRENT_AND_TOOL = new StylusSwitchBehavior("CURRENT_AND_TOOL", 1);
    public static final StylusSwitchBehavior COLOR_PALETTE = new StylusSwitchBehavior("COLOR_PALETTE", 2);
    public static final StylusSwitchBehavior NONE = new StylusSwitchBehavior("NONE", 3);

    private static final /* synthetic */ StylusSwitchBehavior[] $values() {
        return new StylusSwitchBehavior[]{CURRENT_AND_ERASER, CURRENT_AND_TOOL, COLOR_PALETTE, NONE};
    }

    public static EnumEntries<StylusSwitchBehavior> getEntries() {
        return $ENTRIES;
    }

    public static StylusSwitchBehavior valueOf(String str) {
        return (StylusSwitchBehavior) Enum.valueOf(StylusSwitchBehavior.class, str);
    }

    public static StylusSwitchBehavior[] values() {
        return (StylusSwitchBehavior[]) $VALUES.clone();
    }

    private StylusSwitchBehavior(String str, int i) {
    }

    static {
        StylusSwitchBehavior[] stylusSwitchBehaviorArr$values = $values();
        $VALUES = stylusSwitchBehaviorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(stylusSwitchBehaviorArr$values);
    }
}
