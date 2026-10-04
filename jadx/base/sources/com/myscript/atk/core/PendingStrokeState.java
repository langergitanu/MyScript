package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum PendingStrokeState {
    ACQUIRING,
    CAPTURED,
    CANCELED,
    DETACHED,
    IN_DOCUMENT;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static PendingStrokeState swigToEnum(int i) {
        PendingStrokeState[] pendingStrokeStateArr = (PendingStrokeState[]) PendingStrokeState.class.getEnumConstants();
        if (i < pendingStrokeStateArr.length && i >= 0) {
            PendingStrokeState pendingStrokeState = pendingStrokeStateArr[i];
            if (pendingStrokeState.swigValue == i) {
                return pendingStrokeState;
            }
        }
        for (PendingStrokeState pendingStrokeState2 : pendingStrokeStateArr) {
            if (pendingStrokeState2.swigValue == i) {
                return pendingStrokeState2;
            }
        }
        throw new IllegalArgumentException("No enum " + PendingStrokeState.class + " with value " + i);
    }

    PendingStrokeState() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    PendingStrokeState(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    PendingStrokeState(PendingStrokeState pendingStrokeState) {
        int i = pendingStrokeState.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
