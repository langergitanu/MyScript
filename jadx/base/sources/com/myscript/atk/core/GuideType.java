package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum GuideType {
    HORIZONTAL_LINE_SET(0),
    VERTICAL_LINE_SET(1);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static GuideType swigToEnum(int i) {
        GuideType[] guideTypeArr = (GuideType[]) GuideType.class.getEnumConstants();
        if (i < guideTypeArr.length && i >= 0) {
            GuideType guideType = guideTypeArr[i];
            if (guideType.swigValue == i) {
                return guideType;
            }
        }
        for (GuideType guideType2 : guideTypeArr) {
            if (guideType2.swigValue == i) {
                return guideType2;
            }
        }
        throw new IllegalArgumentException("No enum " + GuideType.class + " with value " + i);
    }

    GuideType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    GuideType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    GuideType(GuideType guideType) {
        int i = guideType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
