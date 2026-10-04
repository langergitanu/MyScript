package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum SyncState {
    FAILED(-1),
    UP_TO_DATE(0),
    CONFLICT(1),
    NEED_DOWNLOAD(2),
    NEED_UPLOAD(3),
    NEED_MERGE(4),
    TO_DELETE_LOCALLY(5),
    TO_DELETE_REMOTELY(6);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SyncState swigToEnum(int i) {
        SyncState[] syncStateArr = (SyncState[]) SyncState.class.getEnumConstants();
        if (i < syncStateArr.length && i >= 0) {
            SyncState syncState = syncStateArr[i];
            if (syncState.swigValue == i) {
                return syncState;
            }
        }
        for (SyncState syncState2 : syncStateArr) {
            if (syncState2.swigValue == i) {
                return syncState2;
            }
        }
        throw new IllegalArgumentException("No enum " + SyncState.class + " with value " + i);
    }

    SyncState() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SyncState(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SyncState(SyncState syncState) {
        int i = syncState.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
