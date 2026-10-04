package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public enum CompactMode {
    AUTO(0),
    FORCED(1),
    DISABLED(2);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static CompactMode swigToEnum(int i) {
        CompactMode[] compactModeArr = (CompactMode[]) CompactMode.class.getEnumConstants();
        if (i < compactModeArr.length && i >= 0) {
            CompactMode compactMode = compactModeArr[i];
            if (compactMode.swigValue == i) {
                return compactMode;
            }
        }
        for (CompactMode compactMode2 : compactModeArr) {
            if (compactMode2.swigValue == i) {
                return compactMode2;
            }
        }
        throw new IllegalArgumentException("No enum " + CompactMode.class + " with value " + i);
    }

    CompactMode() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    CompactMode(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    CompactMode(CompactMode compactMode) {
        int i = compactMode.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
