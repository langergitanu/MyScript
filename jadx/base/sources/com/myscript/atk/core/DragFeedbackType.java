package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum DragFeedbackType {
    NONE,
    FULL_SIZE,
    INSERT,
    SWAP;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static DragFeedbackType swigToEnum(int i) {
        DragFeedbackType[] dragFeedbackTypeArr = (DragFeedbackType[]) DragFeedbackType.class.getEnumConstants();
        if (i < dragFeedbackTypeArr.length && i >= 0) {
            DragFeedbackType dragFeedbackType = dragFeedbackTypeArr[i];
            if (dragFeedbackType.swigValue == i) {
                return dragFeedbackType;
            }
        }
        for (DragFeedbackType dragFeedbackType2 : dragFeedbackTypeArr) {
            if (dragFeedbackType2.swigValue == i) {
                return dragFeedbackType2;
            }
        }
        throw new IllegalArgumentException("No enum " + DragFeedbackType.class + " with value " + i);
    }

    DragFeedbackType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    DragFeedbackType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    DragFeedbackType(DragFeedbackType dragFeedbackType) {
        int i = dragFeedbackType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
