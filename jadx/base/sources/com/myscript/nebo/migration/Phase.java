package com.myscript.nebo.migration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MigrationProgress.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/migration/Phase;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "CreatingBackup", "CopyingBackup", "Restoring", "Done", "Error", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Phase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Phase[] $VALUES;
    public static final Phase Idle = new Phase("Idle", 0);
    public static final Phase CreatingBackup = new Phase("CreatingBackup", 1);
    public static final Phase CopyingBackup = new Phase("CopyingBackup", 2);
    public static final Phase Restoring = new Phase("Restoring", 3);
    public static final Phase Done = new Phase("Done", 4);
    public static final Phase Error = new Phase("Error", 5);

    private static final /* synthetic */ Phase[] $values() {
        return new Phase[]{Idle, CreatingBackup, CopyingBackup, Restoring, Done, Error};
    }

    public static EnumEntries<Phase> getEntries() {
        return $ENTRIES;
    }

    public static Phase valueOf(String str) {
        return (Phase) Enum.valueOf(Phase.class, str);
    }

    public static Phase[] values() {
        return (Phase[]) $VALUES.clone();
    }

    static {
        Phase[] phaseArr$values = $values();
        $VALUES = phaseArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(phaseArr$values);
    }

    private Phase(String str, int i) {
    }
}
