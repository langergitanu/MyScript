package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum DMSSyncState {
    NONE,
    UP_TO_DATE,
    NEED_SYNC,
    SYNCING,
    SYNC_FAILED,
    REFRESHING,
    REFRESH_FAILED,
    OUTDATED,
    CLOUD_DISABLED;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static DMSSyncState swigToEnum(int i) {
        DMSSyncState[] dMSSyncStateArr = (DMSSyncState[]) DMSSyncState.class.getEnumConstants();
        if (i < dMSSyncStateArr.length && i >= 0) {
            DMSSyncState dMSSyncState = dMSSyncStateArr[i];
            if (dMSSyncState.swigValue == i) {
                return dMSSyncState;
            }
        }
        for (DMSSyncState dMSSyncState2 : dMSSyncStateArr) {
            if (dMSSyncState2.swigValue == i) {
                return dMSSyncState2;
            }
        }
        throw new IllegalArgumentException("No enum " + DMSSyncState.class + " with value " + i);
    }

    DMSSyncState() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    DMSSyncState(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    DMSSyncState(DMSSyncState dMSSyncState) {
        int i = dMSSyncState.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
