package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public enum GestureResult {
    APPLIED(0),
    NOTHING_TO_MOVE(1),
    NO_WORDS_TO_JOIN(2),
    MULTIPLE_MERGE_UNAUTHORIZED(3),
    CANNOT_MOVE_ABOVE_FIRSTLINE(4),
    BOX_ON_RIGTH(5);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static GestureResult swigToEnum(int i) {
        GestureResult[] gestureResultArr = (GestureResult[]) GestureResult.class.getEnumConstants();
        if (i < gestureResultArr.length && i >= 0) {
            GestureResult gestureResult = gestureResultArr[i];
            if (gestureResult.swigValue == i) {
                return gestureResult;
            }
        }
        for (GestureResult gestureResult2 : gestureResultArr) {
            if (gestureResult2.swigValue == i) {
                return gestureResult2;
            }
        }
        throw new IllegalArgumentException("No enum " + GestureResult.class + " with value " + i);
    }

    GestureResult() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    GestureResult(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    GestureResult(GestureResult gestureResult) {
        int i = gestureResult.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
