package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum ButtonType {
    UNDEFINED(0),
    PRIMARY(1),
    SECONDARY(2),
    TERTIARY(3);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ButtonType swigToEnum(int i) {
        ButtonType[] buttonTypeArr = (ButtonType[]) ButtonType.class.getEnumConstants();
        if (i < buttonTypeArr.length && i >= 0) {
            ButtonType buttonType = buttonTypeArr[i];
            if (buttonType.swigValue == i) {
                return buttonType;
            }
        }
        for (ButtonType buttonType2 : buttonTypeArr) {
            if (buttonType2.swigValue == i) {
                return buttonType2;
            }
        }
        throw new IllegalArgumentException("No enum " + ButtonType.class + " with value " + i);
    }

    ButtonType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    ButtonType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    ButtonType(ButtonType buttonType) {
        int i = buttonType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
