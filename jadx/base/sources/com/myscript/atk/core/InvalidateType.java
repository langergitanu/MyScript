package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum InvalidateType {
    DOCUMENT(1),
    TEMPORARY(2),
    CAPTURE(4),
    BACKGROUND(8);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static InvalidateType swigToEnum(int i) {
        InvalidateType[] invalidateTypeArr = (InvalidateType[]) InvalidateType.class.getEnumConstants();
        if (i < invalidateTypeArr.length && i >= 0) {
            InvalidateType invalidateType = invalidateTypeArr[i];
            if (invalidateType.swigValue == i) {
                return invalidateType;
            }
        }
        for (InvalidateType invalidateType2 : invalidateTypeArr) {
            if (invalidateType2.swigValue == i) {
                return invalidateType2;
            }
        }
        throw new IllegalArgumentException("No enum " + InvalidateType.class + " with value " + i);
    }

    InvalidateType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    InvalidateType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    InvalidateType(InvalidateType invalidateType) {
        int i = invalidateType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
