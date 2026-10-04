package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum TextStructureOperation {
    INDENT(0),
    TEXTIFY,
    TEXTIFY_FULL,
    LISTIFY,
    LISTIFY_FULL;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static TextStructureOperation swigToEnum(int i) {
        TextStructureOperation[] textStructureOperationArr = (TextStructureOperation[]) TextStructureOperation.class.getEnumConstants();
        if (i < textStructureOperationArr.length && i >= 0) {
            TextStructureOperation textStructureOperation = textStructureOperationArr[i];
            if (textStructureOperation.swigValue == i) {
                return textStructureOperation;
            }
        }
        for (TextStructureOperation textStructureOperation2 : textStructureOperationArr) {
            if (textStructureOperation2.swigValue == i) {
                return textStructureOperation2;
            }
        }
        throw new IllegalArgumentException("No enum " + TextStructureOperation.class + " with value " + i);
    }

    TextStructureOperation() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    TextStructureOperation(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    TextStructureOperation(TextStructureOperation textStructureOperation) {
        int i = textStructureOperation.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
