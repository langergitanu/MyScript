package com.myscript.nebo.backup;

import com.myscript.snt.core.NotebookKey;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackupRestoreViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState;", "", "<init>", "()V", "Idle", "CopyArchiveProgress", "CopyArchiveDone", "CopyArchiveCanceled", "CopyArchiveError", "RestoreArchiveProgress", "RestoreArchiveDone", "RestoreArchiveCanceled", "RestoreArchiveError", "Lcom/myscript/nebo/backup/RestoreState$CopyArchiveCanceled;", "Lcom/myscript/nebo/backup/RestoreState$CopyArchiveDone;", "Lcom/myscript/nebo/backup/RestoreState$CopyArchiveError;", "Lcom/myscript/nebo/backup/RestoreState$CopyArchiveProgress;", "Lcom/myscript/nebo/backup/RestoreState$Idle;", "Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveCanceled;", "Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveDone;", "Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveError;", "Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveProgress;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class RestoreState {
    public static final int $stable = 0;

    public /* synthetic */ RestoreState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RestoreState() {
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$Idle;", "Lcom/myscript/nebo/backup/RestoreState;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Idle extends RestoreState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$CopyArchiveProgress;", "Lcom/myscript/nebo/backup/RestoreState;", "percent", "", "<init>", "(I)V", "getPercent", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class CopyArchiveProgress extends RestoreState {
        public static final int $stable = 0;
        private final int percent;

        public static /* synthetic */ CopyArchiveProgress copy$default(CopyArchiveProgress copyArchiveProgress, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = copyArchiveProgress.percent;
            }
            return copyArchiveProgress.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPercent() {
            return this.percent;
        }

        public final CopyArchiveProgress copy(int percent) {
            return new CopyArchiveProgress(percent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CopyArchiveProgress) && this.percent == ((CopyArchiveProgress) other).percent;
        }

        public int hashCode() {
            return Integer.hashCode(this.percent);
        }

        public String toString() {
            return "CopyArchiveProgress(percent=" + this.percent + ")";
        }

        public CopyArchiveProgress(int i) {
            super(null);
            this.percent = i;
        }

        public final int getPercent() {
            return this.percent;
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$CopyArchiveDone;", "Lcom/myscript/nebo/backup/RestoreState;", "backupFile", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getBackupFile", "()Ljava/io/File;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class CopyArchiveDone extends RestoreState {
        public static final int $stable = 8;
        private final File backupFile;

        public static /* synthetic */ CopyArchiveDone copy$default(CopyArchiveDone copyArchiveDone, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                file = copyArchiveDone.backupFile;
            }
            return copyArchiveDone.copy(file);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getBackupFile() {
            return this.backupFile;
        }

        public final CopyArchiveDone copy(File backupFile) {
            Intrinsics.checkNotNullParameter(backupFile, "backupFile");
            return new CopyArchiveDone(backupFile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CopyArchiveDone) && Intrinsics.areEqual(this.backupFile, ((CopyArchiveDone) other).backupFile);
        }

        public int hashCode() {
            return this.backupFile.hashCode();
        }

        public String toString() {
            return "CopyArchiveDone(backupFile=" + this.backupFile + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CopyArchiveDone(File backupFile) {
            super(null);
            Intrinsics.checkNotNullParameter(backupFile, "backupFile");
            this.backupFile = backupFile;
        }

        public final File getBackupFile() {
            return this.backupFile;
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$CopyArchiveCanceled;", "Lcom/myscript/nebo/backup/RestoreState;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class CopyArchiveCanceled extends RestoreState {
        public static final int $stable = 0;
        public static final CopyArchiveCanceled INSTANCE = new CopyArchiveCanceled();

        private CopyArchiveCanceled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$CopyArchiveError;", "Lcom/myscript/nebo/backup/RestoreState;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class CopyArchiveError extends RestoreState {
        public static final int $stable = 0;
        public static final CopyArchiveError INSTANCE = new CopyArchiveError();

        private CopyArchiveError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveProgress;", "Lcom/myscript/nebo/backup/RestoreState;", "current", "", "total", "<init>", "(II)V", "getCurrent", "()I", "getTotal", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class RestoreArchiveProgress extends RestoreState {
        public static final int $stable = 0;
        private final int current;
        private final int total;

        public static /* synthetic */ RestoreArchiveProgress copy$default(RestoreArchiveProgress restoreArchiveProgress, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = restoreArchiveProgress.current;
            }
            if ((i3 & 2) != 0) {
                i2 = restoreArchiveProgress.total;
            }
            return restoreArchiveProgress.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCurrent() {
            return this.current;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        public final RestoreArchiveProgress copy(int current, int total) {
            return new RestoreArchiveProgress(current, total);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RestoreArchiveProgress)) {
                return false;
            }
            RestoreArchiveProgress restoreArchiveProgress = (RestoreArchiveProgress) other;
            return this.current == restoreArchiveProgress.current && this.total == restoreArchiveProgress.total;
        }

        public int hashCode() {
            return (Integer.hashCode(this.current) * 31) + Integer.hashCode(this.total);
        }

        public String toString() {
            return "RestoreArchiveProgress(current=" + this.current + ", total=" + this.total + ")";
        }

        public RestoreArchiveProgress(int i, int i2) {
            super(null);
            this.current = i;
            this.total = i2;
        }

        public final int getCurrent() {
            return this.current;
        }

        public final int getTotal() {
            return this.total;
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveDone;", "Lcom/myscript/nebo/backup/RestoreState;", "backupFile", "Ljava/io/File;", "lastOpenedNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "<init>", "(Ljava/io/File;Lcom/myscript/snt/core/NotebookKey;)V", "getBackupFile", "()Ljava/io/File;", "getLastOpenedNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class RestoreArchiveDone extends RestoreState {
        public static final int $stable = 8;
        private final File backupFile;
        private final NotebookKey lastOpenedNotebookKey;

        public static /* synthetic */ RestoreArchiveDone copy$default(RestoreArchiveDone restoreArchiveDone, File file, NotebookKey notebookKey, int i, Object obj) {
            if ((i & 1) != 0) {
                file = restoreArchiveDone.backupFile;
            }
            if ((i & 2) != 0) {
                notebookKey = restoreArchiveDone.lastOpenedNotebookKey;
            }
            return restoreArchiveDone.copy(file, notebookKey);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getBackupFile() {
            return this.backupFile;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final NotebookKey getLastOpenedNotebookKey() {
            return this.lastOpenedNotebookKey;
        }

        public final RestoreArchiveDone copy(File backupFile, NotebookKey lastOpenedNotebookKey) {
            Intrinsics.checkNotNullParameter(backupFile, "backupFile");
            return new RestoreArchiveDone(backupFile, lastOpenedNotebookKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RestoreArchiveDone)) {
                return false;
            }
            RestoreArchiveDone restoreArchiveDone = (RestoreArchiveDone) other;
            return Intrinsics.areEqual(this.backupFile, restoreArchiveDone.backupFile) && Intrinsics.areEqual(this.lastOpenedNotebookKey, restoreArchiveDone.lastOpenedNotebookKey);
        }

        public int hashCode() {
            int iHashCode = this.backupFile.hashCode() * 31;
            NotebookKey notebookKey = this.lastOpenedNotebookKey;
            return iHashCode + (notebookKey == null ? 0 : notebookKey.hashCode());
        }

        public String toString() {
            return "RestoreArchiveDone(backupFile=" + this.backupFile + ", lastOpenedNotebookKey=" + this.lastOpenedNotebookKey + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RestoreArchiveDone(File backupFile, NotebookKey notebookKey) {
            super(null);
            Intrinsics.checkNotNullParameter(backupFile, "backupFile");
            this.backupFile = backupFile;
            this.lastOpenedNotebookKey = notebookKey;
        }

        public final File getBackupFile() {
            return this.backupFile;
        }

        public final NotebookKey getLastOpenedNotebookKey() {
            return this.lastOpenedNotebookKey;
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveCanceled;", "Lcom/myscript/nebo/backup/RestoreState;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class RestoreArchiveCanceled extends RestoreState {
        public static final int $stable = 0;
        public static final RestoreArchiveCanceled INSTANCE = new RestoreArchiveCanceled();

        private RestoreArchiveCanceled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveError;", "Lcom/myscript/nebo/backup/RestoreState;", "<init>", "()V", "NotEnoughSpace", "VerifyError", "UnknownError", "Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveError$NotEnoughSpace;", "Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveError$UnknownError;", "Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveError$VerifyError;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class RestoreArchiveError extends RestoreState {
        public static final int $stable = 0;

        public /* synthetic */ RestoreArchiveError(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
        @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveError$NotEnoughSpace;", "Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveError;", "requiredSize", "", "<init>", "(J)V", "getRequiredSize", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class NotEnoughSpace extends RestoreArchiveError {
            public static final int $stable = 0;
            private final long requiredSize;

            public static /* synthetic */ NotEnoughSpace copy$default(NotEnoughSpace notEnoughSpace, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = notEnoughSpace.requiredSize;
                }
                return notEnoughSpace.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getRequiredSize() {
                return this.requiredSize;
            }

            public final NotEnoughSpace copy(long requiredSize) {
                return new NotEnoughSpace(requiredSize);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NotEnoughSpace) && this.requiredSize == ((NotEnoughSpace) other).requiredSize;
            }

            public int hashCode() {
                return Long.hashCode(this.requiredSize);
            }

            public String toString() {
                return "NotEnoughSpace(requiredSize=" + this.requiredSize + ")";
            }

            public NotEnoughSpace(long j) {
                super(null);
                this.requiredSize = j;
            }

            public final long getRequiredSize() {
                return this.requiredSize;
            }
        }

        private RestoreArchiveError() {
            super(null);
        }

        /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveError$VerifyError;", "Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveError;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class VerifyError extends RestoreArchiveError {
            public static final int $stable = 0;
            public static final VerifyError INSTANCE = new VerifyError();

            private VerifyError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveError$UnknownError;", "Lcom/myscript/nebo/backup/RestoreState$RestoreArchiveError;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class UnknownError extends RestoreArchiveError {
            public static final int $stable = 0;
            public static final UnknownError INSTANCE = new UnknownError();

            private UnknownError() {
                super(null);
            }
        }
    }
}
