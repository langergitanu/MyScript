package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum PointerType {
    UNDEFINED(0),
    MOUSE,
    PEN,
    TOUCH,
    DOUBLE_TOUCH;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static PointerType swigToEnum(int i) {
        PointerType[] pointerTypeArr = (PointerType[]) PointerType.class.getEnumConstants();
        if (i < pointerTypeArr.length && i >= 0) {
            PointerType pointerType = pointerTypeArr[i];
            if (pointerType.swigValue == i) {
                return pointerType;
            }
        }
        for (PointerType pointerType2 : pointerTypeArr) {
            if (pointerType2.swigValue == i) {
                return pointerType2;
            }
        }
        throw new IllegalArgumentException("No enum " + PointerType.class + " with value " + i);
    }

    PointerType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    PointerType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    PointerType(PointerType pointerType) {
        int i = pointerType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
