package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum ButtonTypeSet {
    NONE(0),
    PRIMARY(1),
    SECONDARY(2),
    TERTIARY(4),
    ALL(7);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ButtonTypeSet swigToEnum(int i) {
        ButtonTypeSet[] buttonTypeSetArr = (ButtonTypeSet[]) ButtonTypeSet.class.getEnumConstants();
        if (i < buttonTypeSetArr.length && i >= 0) {
            ButtonTypeSet buttonTypeSet = buttonTypeSetArr[i];
            if (buttonTypeSet.swigValue == i) {
                return buttonTypeSet;
            }
        }
        for (ButtonTypeSet buttonTypeSet2 : buttonTypeSetArr) {
            if (buttonTypeSet2.swigValue == i) {
                return buttonTypeSet2;
            }
        }
        throw new IllegalArgumentException("No enum " + ButtonTypeSet.class + " with value " + i);
    }

    ButtonTypeSet() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    ButtonTypeSet(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    ButtonTypeSet(ButtonTypeSet buttonTypeSet) {
        int i = buttonTypeSet.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
