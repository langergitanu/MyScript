package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public enum OptionState {
    NotAvailable(0),
    Off(1),
    On(2);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static OptionState swigToEnum(int i) {
        OptionState[] optionStateArr = (OptionState[]) OptionState.class.getEnumConstants();
        if (i < optionStateArr.length && i >= 0) {
            OptionState optionState = optionStateArr[i];
            if (optionState.swigValue == i) {
                return optionState;
            }
        }
        for (OptionState optionState2 : optionStateArr) {
            if (optionState2.swigValue == i) {
                return optionState2;
            }
        }
        throw new IllegalArgumentException("No enum " + OptionState.class + " with value " + i);
    }

    OptionState() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    OptionState(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    OptionState(OptionState optionState) {
        int i = optionState.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
