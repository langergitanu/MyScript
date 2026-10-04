package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum DecorationType {
    TEXT_DECORATION_UNDERLINED(0),
    TEXT_DECORATION_DOUBLE_UNDERLINED(1),
    TEXT_DECORATION_CIRCLED(2),
    TEXT_DECORATION_CIRCLED_BACKGROUND(3),
    TEXT_DECORATION_CIRCLED_OUTLINE(4),
    TEXT_DECORATION_FRAMED(5),
    TEXT_DECORATION_FRAMED_BACKGROUND(6),
    TEXT_DECORATION_FRAMED_OUTLINE(7),
    TEXT_DECORATION_STRIKETHROUGH(8),
    FILL_AREA_DECORATION(9),
    DECORATION_COUNT(10);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static DecorationType swigToEnum(int i) {
        DecorationType[] decorationTypeArr = (DecorationType[]) DecorationType.class.getEnumConstants();
        if (i < decorationTypeArr.length && i >= 0) {
            DecorationType decorationType = decorationTypeArr[i];
            if (decorationType.swigValue == i) {
                return decorationType;
            }
        }
        for (DecorationType decorationType2 : decorationTypeArr) {
            if (decorationType2.swigValue == i) {
                return decorationType2;
            }
        }
        throw new IllegalArgumentException("No enum " + DecorationType.class + " with value " + i);
    }

    DecorationType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    DecorationType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    DecorationType(DecorationType decorationType) {
        int i = decorationType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
