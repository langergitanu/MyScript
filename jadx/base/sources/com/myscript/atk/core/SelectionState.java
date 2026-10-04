package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum SelectionState {
    IDLE(0),
    WRITING,
    LASSOING,
    HOLD_PREVIEW,
    SELECTION,
    SELECTION_DRAG,
    SELECTION_DRAG_HOLD,
    SELECTION_GRAB,
    SELECTION_RESIZE,
    MULTI_SELECTION,
    MULTI_SELECTION_DRAG,
    INLINE_SELECTION,
    INLINE_SELECTION_DRAG,
    INLINE_SELECTION_RESIZE,
    INLINE_SELECTION_BORDER,
    INLINE_SELECTION_PDF,
    INLINE_SELECTION_PDF_RESIZE,
    LASSO_INLINE_SELECTION,
    CURSOR,
    CURSOR_DRAG,
    GO_CURSOR_OR_INLINE_SEL,
    GO_SUB_SEL_OR_CURSOR_OR_INLINE_SEL,
    GO_INLINE_SEL_OR_IDLE,
    GO_SELECTION_OR_IDLE,
    GO_SELECTION_OR_INLINE_SEL,
    SUB_BLOCK_STATE,
    GO_SUB_SEL_OR_IDLE,
    GO_SUB_SEL_OR_SELECTION,
    SECTION_RESIZE,
    SPACE_MANAGEMENT,
    TABLE_SELECTION,
    TABLE_SELECTION_EXTEND;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SelectionState swigToEnum(int i) {
        SelectionState[] selectionStateArr = (SelectionState[]) SelectionState.class.getEnumConstants();
        if (i < selectionStateArr.length && i >= 0) {
            SelectionState selectionState = selectionStateArr[i];
            if (selectionState.swigValue == i) {
                return selectionState;
            }
        }
        for (SelectionState selectionState2 : selectionStateArr) {
            if (selectionState2.swigValue == i) {
                return selectionState2;
            }
        }
        throw new IllegalArgumentException("No enum " + SelectionState.class + " with value " + i);
    }

    SelectionState() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SelectionState(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SelectionState(SelectionState selectionState) {
        int i = selectionState.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
