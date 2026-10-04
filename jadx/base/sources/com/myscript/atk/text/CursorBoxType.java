package com.myscript.atk.text;

/* JADX INFO: loaded from: classes4.dex */
public enum CursorBoxType {
    TEXT(1),
    SPACE(2),
    OTHER(4);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static CursorBoxType swigToEnum(int i) {
        CursorBoxType[] cursorBoxTypeArr = (CursorBoxType[]) CursorBoxType.class.getEnumConstants();
        if (i < cursorBoxTypeArr.length && i >= 0) {
            CursorBoxType cursorBoxType = cursorBoxTypeArr[i];
            if (cursorBoxType.swigValue == i) {
                return cursorBoxType;
            }
        }
        for (CursorBoxType cursorBoxType2 : cursorBoxTypeArr) {
            if (cursorBoxType2.swigValue == i) {
                return cursorBoxType2;
            }
        }
        throw new IllegalArgumentException("No enum " + CursorBoxType.class + " with value " + i);
    }

    CursorBoxType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    CursorBoxType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    CursorBoxType(CursorBoxType cursorBoxType) {
        int i = cursorBoxType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
