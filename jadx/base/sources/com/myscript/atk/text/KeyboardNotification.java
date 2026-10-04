package com.myscript.atk.text;

/* JADX INFO: loaded from: classes4.dex */
public enum KeyboardNotification {
    NONE(0),
    TEXT(1),
    RANGE(2),
    POSITION(4),
    VISIBILITY(8),
    ALL(15);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static KeyboardNotification swigToEnum(int i) {
        KeyboardNotification[] keyboardNotificationArr = (KeyboardNotification[]) KeyboardNotification.class.getEnumConstants();
        if (i < keyboardNotificationArr.length && i >= 0) {
            KeyboardNotification keyboardNotification = keyboardNotificationArr[i];
            if (keyboardNotification.swigValue == i) {
                return keyboardNotification;
            }
        }
        for (KeyboardNotification keyboardNotification2 : keyboardNotificationArr) {
            if (keyboardNotification2.swigValue == i) {
                return keyboardNotification2;
            }
        }
        throw new IllegalArgumentException("No enum " + KeyboardNotification.class + " with value " + i);
    }

    KeyboardNotification() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    KeyboardNotification(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    KeyboardNotification(KeyboardNotification keyboardNotification) {
        int i = keyboardNotification.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
