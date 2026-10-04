package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public enum LineBreakType {
    NONE(0),
    IMPLICIT,
    EXPLICIT;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static LineBreakType swigToEnum(int i) {
        LineBreakType[] lineBreakTypeArr = (LineBreakType[]) LineBreakType.class.getEnumConstants();
        if (i < lineBreakTypeArr.length && i >= 0) {
            LineBreakType lineBreakType = lineBreakTypeArr[i];
            if (lineBreakType.swigValue == i) {
                return lineBreakType;
            }
        }
        for (LineBreakType lineBreakType2 : lineBreakTypeArr) {
            if (lineBreakType2.swigValue == i) {
                return lineBreakType2;
            }
        }
        throw new IllegalArgumentException("No enum " + LineBreakType.class + " with value " + i);
    }

    LineBreakType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    LineBreakType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    LineBreakType(LineBreakType lineBreakType) {
        int i = lineBreakType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
