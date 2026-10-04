package com.survicate.surveys.core.targeting;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TargetingMode.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/TargetingMode;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL", "HYBRID", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TargetingMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TargetingMode[] $VALUES;
    public static final TargetingMode LOCAL = new TargetingMode("LOCAL", 0);
    public static final TargetingMode HYBRID = new TargetingMode("HYBRID", 1);

    private static final /* synthetic */ TargetingMode[] $values() {
        return new TargetingMode[]{LOCAL, HYBRID};
    }

    public static EnumEntries<TargetingMode> getEntries() {
        return $ENTRIES;
    }

    private TargetingMode(String str, int i) {
    }

    static {
        TargetingMode[] targetingModeArr$values = $values();
        $VALUES = targetingModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(targetingModeArr$values);
    }

    public static TargetingMode valueOf(String str) {
        return (TargetingMode) Enum.valueOf(TargetingMode.class, str);
    }

    public static TargetingMode[] values() {
        return (TargetingMode[]) $VALUES.clone();
    }
}
