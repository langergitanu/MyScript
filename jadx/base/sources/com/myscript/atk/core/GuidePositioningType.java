package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum GuidePositioningType {
    ABSOLUTE_POSITION(0),
    RELATIVE_TO_TOP(1),
    RELATIVE_TO_BOTTOM(2),
    RELATIVE_TO_LEFT(3),
    RELATIVE_TO_RIGHT(4);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static GuidePositioningType swigToEnum(int i) {
        GuidePositioningType[] guidePositioningTypeArr = (GuidePositioningType[]) GuidePositioningType.class.getEnumConstants();
        if (i < guidePositioningTypeArr.length && i >= 0) {
            GuidePositioningType guidePositioningType = guidePositioningTypeArr[i];
            if (guidePositioningType.swigValue == i) {
                return guidePositioningType;
            }
        }
        for (GuidePositioningType guidePositioningType2 : guidePositioningTypeArr) {
            if (guidePositioningType2.swigValue == i) {
                return guidePositioningType2;
            }
        }
        throw new IllegalArgumentException("No enum " + GuidePositioningType.class + " with value " + i);
    }

    GuidePositioningType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    GuidePositioningType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    GuidePositioningType(GuidePositioningType guidePositioningType) {
        int i = guidePositioningType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
