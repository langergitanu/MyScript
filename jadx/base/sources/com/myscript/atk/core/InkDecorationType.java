package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum InkDecorationType {
    NONE(0),
    ARROW_HEAD(1);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static InkDecorationType swigToEnum(int i) {
        InkDecorationType[] inkDecorationTypeArr = (InkDecorationType[]) InkDecorationType.class.getEnumConstants();
        if (i < inkDecorationTypeArr.length && i >= 0) {
            InkDecorationType inkDecorationType = inkDecorationTypeArr[i];
            if (inkDecorationType.swigValue == i) {
                return inkDecorationType;
            }
        }
        for (InkDecorationType inkDecorationType2 : inkDecorationTypeArr) {
            if (inkDecorationType2.swigValue == i) {
                return inkDecorationType2;
            }
        }
        throw new IllegalArgumentException("No enum " + InkDecorationType.class + " with value " + i);
    }

    InkDecorationType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    InkDecorationType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    InkDecorationType(InkDecorationType inkDecorationType) {
        int i = inkDecorationType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
