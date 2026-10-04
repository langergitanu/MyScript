package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum SyncProgress {
    NONE,
    SYNC_QUEUED,
    SYNCING;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SyncProgress swigToEnum(int i) {
        SyncProgress[] syncProgressArr = (SyncProgress[]) SyncProgress.class.getEnumConstants();
        if (i < syncProgressArr.length && i >= 0) {
            SyncProgress syncProgress = syncProgressArr[i];
            if (syncProgress.swigValue == i) {
                return syncProgress;
            }
        }
        for (SyncProgress syncProgress2 : syncProgressArr) {
            if (syncProgress2.swigValue == i) {
                return syncProgress2;
            }
        }
        throw new IllegalArgumentException("No enum " + SyncProgress.class + " with value " + i);
    }

    SyncProgress() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SyncProgress(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SyncProgress(SyncProgress syncProgress) {
        int i = syncProgress.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
