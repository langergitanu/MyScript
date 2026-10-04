package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum TrashState {
    NONE(0),
    TRASHED(1),
    RESTORED(2),
    DELETED(3);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static TrashState swigToEnum(int i) {
        TrashState[] trashStateArr = (TrashState[]) TrashState.class.getEnumConstants();
        if (i < trashStateArr.length && i >= 0) {
            TrashState trashState = trashStateArr[i];
            if (trashState.swigValue == i) {
                return trashState;
            }
        }
        for (TrashState trashState2 : trashStateArr) {
            if (trashState2.swigValue == i) {
                return trashState2;
            }
        }
        throw new IllegalArgumentException("No enum " + TrashState.class + " with value " + i);
    }

    TrashState() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    TrashState(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    TrashState(TrashState trashState) {
        int i = trashState.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
