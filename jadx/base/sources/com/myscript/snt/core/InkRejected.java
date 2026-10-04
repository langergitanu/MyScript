package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public enum InkRejected {
    NONE(0),
    INK_TOO_SMALL(1),
    INK_TOO_BIG(2),
    INK_ABOVE_FIRST_LINE(4),
    INK_SMALL_TYPESET(8),
    INK_ACTIVE_BLOCK(16),
    INK_MERGE(32),
    INK_TOO_LONG(64),
    INK_SLICE(128),
    INK_BEFORE_FIRST_COLUMN(256),
    INK_OUT_OF_PAGE(512);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static InkRejected swigToEnum(int i) {
        InkRejected[] inkRejectedArr = (InkRejected[]) InkRejected.class.getEnumConstants();
        if (i < inkRejectedArr.length && i >= 0) {
            InkRejected inkRejected = inkRejectedArr[i];
            if (inkRejected.swigValue == i) {
                return inkRejected;
            }
        }
        for (InkRejected inkRejected2 : inkRejectedArr) {
            if (inkRejected2.swigValue == i) {
                return inkRejected2;
            }
        }
        throw new IllegalArgumentException("No enum " + InkRejected.class + " with value " + i);
    }

    InkRejected() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    InkRejected(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    InkRejected(InkRejected inkRejected) {
        int i = inkRejected.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
