package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public enum ModificationState {
    Thumbnail(0),
    Sync,
    Any,
    All;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ModificationState swigToEnum(int i) {
        ModificationState[] modificationStateArr = (ModificationState[]) ModificationState.class.getEnumConstants();
        if (i < modificationStateArr.length && i >= 0) {
            ModificationState modificationState = modificationStateArr[i];
            if (modificationState.swigValue == i) {
                return modificationState;
            }
        }
        for (ModificationState modificationState2 : modificationStateArr) {
            if (modificationState2.swigValue == i) {
                return modificationState2;
            }
        }
        throw new IllegalArgumentException("No enum " + ModificationState.class + " with value " + i);
    }

    ModificationState() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    ModificationState(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    ModificationState(ModificationState modificationState) {
        int i = modificationState.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
