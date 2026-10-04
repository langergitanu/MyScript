package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public enum PositionToOtherBoxes {
    ISOLATED,
    OVER_BOX,
    CLOSE_TO_BOX,
    CLOSE_TO_BOXES,
    VERTICALLY_BETWEEN_BOXES,
    HORIZONTALLY_BETWEEN_BOXES,
    VERTICALLY_AND_HORIZONTALLY_BETWEEN_BOXES;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static PositionToOtherBoxes swigToEnum(int i) {
        PositionToOtherBoxes[] positionToOtherBoxesArr = (PositionToOtherBoxes[]) PositionToOtherBoxes.class.getEnumConstants();
        if (i < positionToOtherBoxesArr.length && i >= 0) {
            PositionToOtherBoxes positionToOtherBoxes = positionToOtherBoxesArr[i];
            if (positionToOtherBoxes.swigValue == i) {
                return positionToOtherBoxes;
            }
        }
        for (PositionToOtherBoxes positionToOtherBoxes2 : positionToOtherBoxesArr) {
            if (positionToOtherBoxes2.swigValue == i) {
                return positionToOtherBoxes2;
            }
        }
        throw new IllegalArgumentException("No enum " + PositionToOtherBoxes.class + " with value " + i);
    }

    PositionToOtherBoxes() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    PositionToOtherBoxes(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    PositionToOtherBoxes(PositionToOtherBoxes positionToOtherBoxes) {
        int i = positionToOtherBoxes.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
