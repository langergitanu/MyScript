package com.myscript.nebo.migration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MigrationProgress.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/migration/MigrationState;", "", "<init>", "(Ljava/lang/String;I)V", "NotStarted", "Pending", "Completed", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MigrationState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MigrationState[] $VALUES;
    public static final MigrationState NotStarted = new MigrationState("NotStarted", 0);
    public static final MigrationState Pending = new MigrationState("Pending", 1);
    public static final MigrationState Completed = new MigrationState("Completed", 2);

    private static final /* synthetic */ MigrationState[] $values() {
        return new MigrationState[]{NotStarted, Pending, Completed};
    }

    public static EnumEntries<MigrationState> getEntries() {
        return $ENTRIES;
    }

    public static MigrationState valueOf(String str) {
        return (MigrationState) Enum.valueOf(MigrationState.class, str);
    }

    public static MigrationState[] values() {
        return (MigrationState[]) $VALUES.clone();
    }

    static {
        MigrationState[] migrationStateArr$values = $values();
        $VALUES = migrationStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(migrationStateArr$values);
    }

    private MigrationState(String str, int i) {
    }
}
