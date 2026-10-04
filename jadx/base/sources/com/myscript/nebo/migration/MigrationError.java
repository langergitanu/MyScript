package com.myscript.nebo.migration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MigrationProgress.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/migration/MigrationError;", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "RemoteRepoUnavailable", "RemoteCanceled", "RemoteInsufficientSpace", "RemoteException", "RemoteUnknown", "ProviderUnreachable", "BackupStalled", "BackupUriMissing", "BackupStreamUnavailable", "CopyCanceled", "CopyFailed", "VerifyFailed", "RestoreCanceled", "RestoreInsufficientSpace", "RestoreFailed", "RestoreNoOutcome", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MigrationError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MigrationError[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String code;
    public static final MigrationError RemoteRepoUnavailable = new MigrationError("RemoteRepoUnavailable", 0, "repo_unavailable");
    public static final MigrationError RemoteCanceled = new MigrationError("RemoteCanceled", 1, "canceled");
    public static final MigrationError RemoteInsufficientSpace = new MigrationError("RemoteInsufficientSpace", 2, "insufficient_space");
    public static final MigrationError RemoteException = new MigrationError("RemoteException", 3, "exception");
    public static final MigrationError RemoteUnknown = new MigrationError("RemoteUnknown", 4, "unknown");
    public static final MigrationError ProviderUnreachable = new MigrationError("ProviderUnreachable", 5, "provider_unreachable");
    public static final MigrationError BackupStalled = new MigrationError("BackupStalled", 6, "backup_stalled");
    public static final MigrationError BackupUriMissing = new MigrationError("BackupUriMissing", 7, "backup_uri_missing");
    public static final MigrationError BackupStreamUnavailable = new MigrationError("BackupStreamUnavailable", 8, "backup_stream_unavailable");
    public static final MigrationError CopyCanceled = new MigrationError("CopyCanceled", 9, "copy_canceled");
    public static final MigrationError CopyFailed = new MigrationError("CopyFailed", 10, "copy_failed");
    public static final MigrationError VerifyFailed = new MigrationError("VerifyFailed", 11, "verify_failed");
    public static final MigrationError RestoreCanceled = new MigrationError("RestoreCanceled", 12, "restore_canceled");
    public static final MigrationError RestoreInsufficientSpace = new MigrationError("RestoreInsufficientSpace", 13, "restore_insufficient_space");
    public static final MigrationError RestoreFailed = new MigrationError("RestoreFailed", 14, "restore_failed");
    public static final MigrationError RestoreNoOutcome = new MigrationError("RestoreNoOutcome", 15, "restore_no_outcome");

    private static final /* synthetic */ MigrationError[] $values() {
        return new MigrationError[]{RemoteRepoUnavailable, RemoteCanceled, RemoteInsufficientSpace, RemoteException, RemoteUnknown, ProviderUnreachable, BackupStalled, BackupUriMissing, BackupStreamUnavailable, CopyCanceled, CopyFailed, VerifyFailed, RestoreCanceled, RestoreInsufficientSpace, RestoreFailed, RestoreNoOutcome};
    }

    public static EnumEntries<MigrationError> getEntries() {
        return $ENTRIES;
    }

    public static MigrationError valueOf(String str) {
        return (MigrationError) Enum.valueOf(MigrationError.class, str);
    }

    public static MigrationError[] values() {
        return (MigrationError[]) $VALUES.clone();
    }

    private MigrationError(String str, int i, String str2) {
        this.code = str2;
    }

    public final String getCode() {
        return this.code;
    }

    static {
        MigrationError[] migrationErrorArr$values = $values();
        $VALUES = migrationErrorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(migrationErrorArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: MigrationProgress.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/migration/MigrationError$Companion;", "", "<init>", "()V", "fromRemoteCode", "Lcom/myscript/nebo/migration/MigrationError;", "code", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MigrationError fromRemoteCode(String code) {
            return Intrinsics.areEqual(code, MigrationError.RemoteRepoUnavailable.getCode()) ? MigrationError.RemoteRepoUnavailable : Intrinsics.areEqual(code, MigrationError.RemoteCanceled.getCode()) ? MigrationError.RemoteCanceled : Intrinsics.areEqual(code, MigrationError.RemoteInsufficientSpace.getCode()) ? MigrationError.RemoteInsufficientSpace : Intrinsics.areEqual(code, MigrationError.RemoteException.getCode()) ? MigrationError.RemoteException : MigrationError.RemoteUnknown;
        }
    }
}
