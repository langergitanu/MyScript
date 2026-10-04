package com.myscript.nebo.backup;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackupRestoreViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupState;", "", "<init>", "()V", "Idle", "Progress", "Done", "Canceled", "BackupError", "Lcom/myscript/nebo/backup/BackupState$BackupError;", "Lcom/myscript/nebo/backup/BackupState$Canceled;", "Lcom/myscript/nebo/backup/BackupState$Done;", "Lcom/myscript/nebo/backup/BackupState$Idle;", "Lcom/myscript/nebo/backup/BackupState$Progress;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class BackupState {
    public static final int $stable = 0;

    public /* synthetic */ BackupState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupState$Idle;", "Lcom/myscript/nebo/backup/BackupState;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Idle extends BackupState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    private BackupState() {
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupState$Progress;", "Lcom/myscript/nebo/backup/BackupState;", "current", "", "total", "<init>", "(II)V", "getCurrent", "()I", "getTotal", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Progress extends BackupState {
        public static final int $stable = 0;
        private final int current;
        private final int total;

        public static /* synthetic */ Progress copy$default(Progress progress, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = progress.current;
            }
            if ((i3 & 2) != 0) {
                i2 = progress.total;
            }
            return progress.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCurrent() {
            return this.current;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        public final Progress copy(int current, int total) {
            return new Progress(current, total);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Progress)) {
                return false;
            }
            Progress progress = (Progress) other;
            return this.current == progress.current && this.total == progress.total;
        }

        public int hashCode() {
            return (Integer.hashCode(this.current) * 31) + Integer.hashCode(this.total);
        }

        public String toString() {
            return "Progress(current=" + this.current + ", total=" + this.total + ")";
        }

        public Progress(int i, int i2) {
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
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupState$Done;", "Lcom/myscript/nebo/backup/BackupState;", "backupFile", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getBackupFile", "()Ljava/io/File;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Done extends BackupState {
        public static final int $stable = 8;
        private final File backupFile;

        public static /* synthetic */ Done copy$default(Done done, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                file = done.backupFile;
            }
            return done.copy(file);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getBackupFile() {
            return this.backupFile;
        }

        public final Done copy(File backupFile) {
            Intrinsics.checkNotNullParameter(backupFile, "backupFile");
            return new Done(backupFile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Done) && Intrinsics.areEqual(this.backupFile, ((Done) other).backupFile);
        }

        public int hashCode() {
            return this.backupFile.hashCode();
        }

        public String toString() {
            return "Done(backupFile=" + this.backupFile + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Done(File backupFile) {
            super(null);
            Intrinsics.checkNotNullParameter(backupFile, "backupFile");
            this.backupFile = backupFile;
        }

        public final File getBackupFile() {
            return this.backupFile;
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupState$Canceled;", "Lcom/myscript/nebo/backup/BackupState;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Canceled extends BackupState {
        public static final int $stable = 0;
        public static final Canceled INSTANCE = new Canceled();

        private Canceled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupState$BackupError;", "Lcom/myscript/nebo/backup/BackupState;", "<init>", "()V", "NotEnoughSpace", "UnknownError", "Lcom/myscript/nebo/backup/BackupState$BackupError$NotEnoughSpace;", "Lcom/myscript/nebo/backup/BackupState$BackupError$UnknownError;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class BackupError extends BackupState {
        public static final int $stable = 0;

        public /* synthetic */ BackupError(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
        @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupState$BackupError$NotEnoughSpace;", "Lcom/myscript/nebo/backup/BackupState$BackupError;", "requiredSize", "", "<init>", "(J)V", "getRequiredSize", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class NotEnoughSpace extends BackupError {
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

        private BackupError() {
            super(null);
        }

        /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupState$BackupError$UnknownError;", "Lcom/myscript/nebo/backup/BackupState$BackupError;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class UnknownError extends BackupError {
            public static final int $stable = 0;
            public static final UnknownError INSTANCE = new UnknownError();

            private UnknownError() {
                super(null);
            }
        }
    }
}
