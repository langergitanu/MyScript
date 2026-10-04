package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum KeyboardModifier {
    NONE(0),
    SHIFT(1),
    CONTROL(2),
    ALT(4),
    SYSTEM(8),
    ALL(15);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static KeyboardModifier swigToEnum(int i) {
        KeyboardModifier[] keyboardModifierArr = (KeyboardModifier[]) KeyboardModifier.class.getEnumConstants();
        if (i < keyboardModifierArr.length && i >= 0) {
            KeyboardModifier keyboardModifier = keyboardModifierArr[i];
            if (keyboardModifier.swigValue == i) {
                return keyboardModifier;
            }
        }
        for (KeyboardModifier keyboardModifier2 : keyboardModifierArr) {
            if (keyboardModifier2.swigValue == i) {
                return keyboardModifier2;
            }
        }
        throw new IllegalArgumentException("No enum " + KeyboardModifier.class + " with value " + i);
    }

    KeyboardModifier() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    KeyboardModifier(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    KeyboardModifier(KeyboardModifier keyboardModifier) {
        int i = keyboardModifier.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
