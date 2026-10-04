package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum SelectionDataType {
    NONE(0),
    CAPTURE,
    CAPTURE_FROM_GESTURE,
    NO_CAPTURE,
    KEYBOARD_WORD,
    KEYBOARD_ACTION,
    CURSOR_INDEX,
    CURSOR_POSITION,
    BOX_ID,
    FULL_CURSOR_INDEX,
    MIMETYPE,
    LASSO,
    HISTORY_POSITION,
    SWIPE,
    SELECTION,
    ADD_SPACE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SelectionDataType swigToEnum(int i) {
        SelectionDataType[] selectionDataTypeArr = (SelectionDataType[]) SelectionDataType.class.getEnumConstants();
        if (i < selectionDataTypeArr.length && i >= 0) {
            SelectionDataType selectionDataType = selectionDataTypeArr[i];
            if (selectionDataType.swigValue == i) {
                return selectionDataType;
            }
        }
        for (SelectionDataType selectionDataType2 : selectionDataTypeArr) {
            if (selectionDataType2.swigValue == i) {
                return selectionDataType2;
            }
        }
        throw new IllegalArgumentException("No enum " + SelectionDataType.class + " with value " + i);
    }

    SelectionDataType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SelectionDataType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SelectionDataType(SelectionDataType selectionDataType) {
        int i = selectionDataType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
