package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum SelectionEvent {
    NONE(0),
    DOWN,
    MOVE,
    UP,
    ABORT,
    TAP,
    DOUBLE_TAP,
    LONGPRESS,
    HOLD,
    SWIPE,
    KEYBOARD_WORD,
    KEYBOARD_ACTION,
    KEYBOARD_CURSOR,
    DRAG_BEGIN,
    DRAG_MOVE,
    DRAG_END,
    DRAG_ABORT,
    SELECT,
    LASSO_DOWN,
    LASSO_MOVE,
    LASSO_UP,
    DELETE_EVENT,
    COPY,
    GO_TO,
    REMOVE,
    HAS_FOCUS,
    ADD_SPACE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SelectionEvent swigToEnum(int i) {
        SelectionEvent[] selectionEventArr = (SelectionEvent[]) SelectionEvent.class.getEnumConstants();
        if (i < selectionEventArr.length && i >= 0) {
            SelectionEvent selectionEvent = selectionEventArr[i];
            if (selectionEvent.swigValue == i) {
                return selectionEvent;
            }
        }
        for (SelectionEvent selectionEvent2 : selectionEventArr) {
            if (selectionEvent2.swigValue == i) {
                return selectionEvent2;
            }
        }
        throw new IllegalArgumentException("No enum " + SelectionEvent.class + " with value " + i);
    }

    SelectionEvent() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SelectionEvent(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SelectionEvent(SelectionEvent selectionEvent) {
        int i = selectionEvent.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
