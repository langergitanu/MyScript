package com.myscript.nebo.backup;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: BackupRunnable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupTaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "BackupTaskIdle", "BackupTaskBusy", "BackupTaskFinished", "BackupTaskCanceled", "BackupTaskError", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BackupTaskStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BackupTaskStatus[] $VALUES;
    public static final BackupTaskStatus BackupTaskIdle = new BackupTaskStatus("BackupTaskIdle", 0);
    public static final BackupTaskStatus BackupTaskBusy = new BackupTaskStatus("BackupTaskBusy", 1);
    public static final BackupTaskStatus BackupTaskFinished = new BackupTaskStatus("BackupTaskFinished", 2);
    public static final BackupTaskStatus BackupTaskCanceled = new BackupTaskStatus("BackupTaskCanceled", 3);
    public static final BackupTaskStatus BackupTaskError = new BackupTaskStatus("BackupTaskError", 4);

    private static final /* synthetic */ BackupTaskStatus[] $values() {
        return new BackupTaskStatus[]{BackupTaskIdle, BackupTaskBusy, BackupTaskFinished, BackupTaskCanceled, BackupTaskError};
    }

    public static EnumEntries<BackupTaskStatus> getEntries() {
        return $ENTRIES;
    }

    public static BackupTaskStatus valueOf(String str) {
        return (BackupTaskStatus) Enum.valueOf(BackupTaskStatus.class, str);
    }

    public static BackupTaskStatus[] values() {
        return (BackupTaskStatus[]) $VALUES.clone();
    }

    private BackupTaskStatus(String str, int i) {
    }

    static {
        BackupTaskStatus[] backupTaskStatusArr$values = $values();
        $VALUES = backupTaskStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(backupTaskStatusArr$values);
    }
}
