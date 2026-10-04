package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum KeyboardAction {
    BACKSPACE(0),
    BACKSPACE_WORD,
    ENTER,
    ESCAPE,
    DEL,
    UP,
    DOWN,
    LEFT,
    RIGHT,
    HOME,
    END,
    BOLD,
    UNDERLINE,
    DOUBLE_UNDERLINE,
    STRIKE_THROUGH,
    CLOSE,
    UNSET_CURSOR,
    SELECT_WORD_AT_CURSOR,
    START_DICTATION_SESSION,
    END_DICTATION_SESSION,
    START_COMPOSITION_SESSION,
    END_COMPOSITION_SESSION,
    TABULATION,
    HIGHLIGHT;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static KeyboardAction swigToEnum(int i) {
        KeyboardAction[] keyboardActionArr = (KeyboardAction[]) KeyboardAction.class.getEnumConstants();
        if (i < keyboardActionArr.length && i >= 0) {
            KeyboardAction keyboardAction = keyboardActionArr[i];
            if (keyboardAction.swigValue == i) {
                return keyboardAction;
            }
        }
        for (KeyboardAction keyboardAction2 : keyboardActionArr) {
            if (keyboardAction2.swigValue == i) {
                return keyboardAction2;
            }
        }
        throw new IllegalArgumentException("No enum " + KeyboardAction.class + " with value " + i);
    }

    KeyboardAction() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    KeyboardAction(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    KeyboardAction(KeyboardAction keyboardAction) {
        int i = keyboardAction.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
