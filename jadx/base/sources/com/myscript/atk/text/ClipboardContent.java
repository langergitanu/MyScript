package com.myscript.atk.text;

/* JADX INFO: loaded from: classes4.dex */
public enum ClipboardContent {
    EMPTY(0),
    TEXT(1),
    SHAPE(2),
    IMAGES(4),
    MATH(8);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ClipboardContent swigToEnum(int i) {
        ClipboardContent[] clipboardContentArr = (ClipboardContent[]) ClipboardContent.class.getEnumConstants();
        if (i < clipboardContentArr.length && i >= 0) {
            ClipboardContent clipboardContent = clipboardContentArr[i];
            if (clipboardContent.swigValue == i) {
                return clipboardContent;
            }
        }
        for (ClipboardContent clipboardContent2 : clipboardContentArr) {
            if (clipboardContent2.swigValue == i) {
                return clipboardContent2;
            }
        }
        throw new IllegalArgumentException("No enum " + ClipboardContent.class + " with value " + i);
    }

    ClipboardContent() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    ClipboardContent(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    ClipboardContent(ClipboardContent clipboardContent) {
        int i = clipboardContent.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
