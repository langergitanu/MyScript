package com.myscript.nebo.migration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LenovoBackupSource.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/migration/BackupStatus;", "", "Idle", "InProgress", "Done", "Failed", "Unavailable", "Unknown", "Lcom/myscript/nebo/migration/BackupStatus$Done;", "Lcom/myscript/nebo/migration/BackupStatus$Failed;", "Lcom/myscript/nebo/migration/BackupStatus$Idle;", "Lcom/myscript/nebo/migration/BackupStatus$InProgress;", "Lcom/myscript/nebo/migration/BackupStatus$Unavailable;", "Lcom/myscript/nebo/migration/BackupStatus$Unknown;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface BackupStatus {

    /* JADX INFO: compiled from: LenovoBackupSource.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/migration/BackupStatus$Idle;", "Lcom/myscript/nebo/migration/BackupStatus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Idle implements BackupStatus {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Idle)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 355956174;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
        }
    }

    /* JADX INFO: compiled from: LenovoBackupSource.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/migration/BackupStatus$InProgress;", "Lcom/myscript/nebo/migration/BackupStatus;", "current", "", "total", "<init>", "(II)V", "getCurrent", "()I", "getTotal", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class InProgress implements BackupStatus {
        public static final int $stable = 0;
        private final int current;
        private final int total;

        public static /* synthetic */ InProgress copy$default(InProgress inProgress, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = inProgress.current;
            }
            if ((i3 & 2) != 0) {
                i2 = inProgress.total;
            }
            return inProgress.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCurrent() {
            return this.current;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        public final InProgress copy(int current, int total) {
            return new InProgress(current, total);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InProgress)) {
                return false;
            }
            InProgress inProgress = (InProgress) other;
            return this.current == inProgress.current && this.total == inProgress.total;
        }

        public int hashCode() {
            return (Integer.hashCode(this.current) * 31) + Integer.hashCode(this.total);
        }

        public String toString() {
            return "InProgress(current=" + this.current + ", total=" + this.total + ")";
        }

        public InProgress(int i, int i2) {
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

    /* JADX INFO: compiled from: LenovoBackupSource.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/migration/BackupStatus$Done;", "Lcom/myscript/nebo/migration/BackupStatus;", "handle", "", "<init>", "(Ljava/lang/String;)V", "getHandle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Done implements BackupStatus {
        public static final int $stable = 0;
        private final String handle;

        public static /* synthetic */ Done copy$default(Done done, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = done.handle;
            }
            return done.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getHandle() {
            return this.handle;
        }

        public final Done copy(String handle) {
            return new Done(handle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Done) && Intrinsics.areEqual(this.handle, ((Done) other).handle);
        }

        public int hashCode() {
            String str = this.handle;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Done(handle=" + this.handle + ")";
        }

        public Done(String str) {
            this.handle = str;
        }

        public final String getHandle() {
            return this.handle;
        }
    }

    /* JADX INFO: compiled from: LenovoBackupSource.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/migration/BackupStatus$Failed;", "Lcom/myscript/nebo/migration/BackupStatus;", "code", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Failed implements BackupStatus {
        public static final int $stable = 0;
        private final String code;
        private final String message;

        public static /* synthetic */ Failed copy$default(Failed failed, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.code;
            }
            if ((i & 2) != 0) {
                str2 = failed.message;
            }
            return failed.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Failed copy(String code, String message) {
            return new Failed(code, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failed)) {
                return false;
            }
            Failed failed = (Failed) other;
            return Intrinsics.areEqual(this.code, failed.code) && Intrinsics.areEqual(this.message, failed.message);
        }

        public int hashCode() {
            String str = this.code;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.message;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Failed(code=" + this.code + ", message=" + this.message + ")";
        }

        public Failed(String str, String str2) {
            this.code = str;
            this.message = str2;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: LenovoBackupSource.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/migration/BackupStatus$Unavailable;", "Lcom/myscript/nebo/migration/BackupStatus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Unavailable implements BackupStatus {
        public static final int $stable = 0;
        public static final Unavailable INSTANCE = new Unavailable();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unavailable)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1086313750;
        }

        public String toString() {
            return "Unavailable";
        }

        private Unavailable() {
        }
    }

    /* JADX INFO: compiled from: LenovoBackupSource.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/migration/BackupStatus$Unknown;", "Lcom/myscript/nebo/migration/BackupStatus;", "rawPhase", "", "<init>", "(Ljava/lang/String;)V", "getRawPhase", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Unknown implements BackupStatus {
        public static final int $stable = 0;
        private final String rawPhase;

        public static /* synthetic */ Unknown copy$default(Unknown unknown, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknown.rawPhase;
            }
            return unknown.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRawPhase() {
            return this.rawPhase;
        }

        public final Unknown copy(String rawPhase) {
            return new Unknown(rawPhase);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unknown) && Intrinsics.areEqual(this.rawPhase, ((Unknown) other).rawPhase);
        }

        public int hashCode() {
            String str = this.rawPhase;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Unknown(rawPhase=" + this.rawPhase + ")";
        }

        public Unknown(String str) {
            this.rawPhase = str;
        }

        public final String getRawPhase() {
            return this.rawPhase;
        }
    }
}
