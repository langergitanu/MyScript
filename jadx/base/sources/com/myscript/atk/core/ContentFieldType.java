package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum ContentFieldType {
    TEXT(0),
    SHAPE(1),
    MATH(2),
    ANALYZER(3),
    MUSIC(4),
    DRAWING(5);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static ContentFieldType swigToEnum(int i) {
        ContentFieldType[] contentFieldTypeArr = (ContentFieldType[]) ContentFieldType.class.getEnumConstants();
        if (i < contentFieldTypeArr.length && i >= 0) {
            ContentFieldType contentFieldType = contentFieldTypeArr[i];
            if (contentFieldType.swigValue == i) {
                return contentFieldType;
            }
        }
        for (ContentFieldType contentFieldType2 : contentFieldTypeArr) {
            if (contentFieldType2.swigValue == i) {
                return contentFieldType2;
            }
        }
        throw new IllegalArgumentException("No enum " + ContentFieldType.class + " with value " + i);
    }

    ContentFieldType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    ContentFieldType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    ContentFieldType(ContentFieldType contentFieldType) {
        int i = contentFieldType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
