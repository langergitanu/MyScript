package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum PointerInfoFlag {
    IS_INTERMEDIATE(1),
    IS_GHOST(2),
    GESTURE_ON_HOLD_SHAPE(4),
    GESTURE_ON_HOLD_MERGE_TEXT(8),
    GESTURE_LONG_PRESS_CANCELED(16),
    EVENT_EDGE_SCROLLING_ENABLE(32),
    EVENT_EDGE_SCROLLING_DISABLE(64);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static PointerInfoFlag swigToEnum(int i) {
        PointerInfoFlag[] pointerInfoFlagArr = (PointerInfoFlag[]) PointerInfoFlag.class.getEnumConstants();
        if (i < pointerInfoFlagArr.length && i >= 0) {
            PointerInfoFlag pointerInfoFlag = pointerInfoFlagArr[i];
            if (pointerInfoFlag.swigValue == i) {
                return pointerInfoFlag;
            }
        }
        for (PointerInfoFlag pointerInfoFlag2 : pointerInfoFlagArr) {
            if (pointerInfoFlag2.swigValue == i) {
                return pointerInfoFlag2;
            }
        }
        throw new IllegalArgumentException("No enum " + PointerInfoFlag.class + " with value " + i);
    }

    PointerInfoFlag() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    PointerInfoFlag(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    PointerInfoFlag(PointerInfoFlag pointerInfoFlag) {
        int i = pointerInfoFlag.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
