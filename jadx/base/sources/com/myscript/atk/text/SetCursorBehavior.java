package com.myscript.atk.text;

/* JADX INFO: loaded from: classes4.dex */
public enum SetCursorBehavior {
    AT_TAP_LOCATION(0),
    AT_WORD_BOUNDARY;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SetCursorBehavior swigToEnum(int i) {
        SetCursorBehavior[] setCursorBehaviorArr = (SetCursorBehavior[]) SetCursorBehavior.class.getEnumConstants();
        if (i < setCursorBehaviorArr.length && i >= 0) {
            SetCursorBehavior setCursorBehavior = setCursorBehaviorArr[i];
            if (setCursorBehavior.swigValue == i) {
                return setCursorBehavior;
            }
        }
        for (SetCursorBehavior setCursorBehavior2 : setCursorBehaviorArr) {
            if (setCursorBehavior2.swigValue == i) {
                return setCursorBehavior2;
            }
        }
        throw new IllegalArgumentException("No enum " + SetCursorBehavior.class + " with value " + i);
    }

    SetCursorBehavior() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SetCursorBehavior(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SetCursorBehavior(SetCursorBehavior setCursorBehavior) {
        int i = setCursorBehavior.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
