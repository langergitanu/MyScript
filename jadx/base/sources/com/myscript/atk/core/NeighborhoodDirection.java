package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum NeighborhoodDirection {
    UNDEFINED(0),
    HORIZONTAL,
    VERTICAL,
    ALL;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static NeighborhoodDirection swigToEnum(int i) {
        NeighborhoodDirection[] neighborhoodDirectionArr = (NeighborhoodDirection[]) NeighborhoodDirection.class.getEnumConstants();
        if (i < neighborhoodDirectionArr.length && i >= 0) {
            NeighborhoodDirection neighborhoodDirection = neighborhoodDirectionArr[i];
            if (neighborhoodDirection.swigValue == i) {
                return neighborhoodDirection;
            }
        }
        for (NeighborhoodDirection neighborhoodDirection2 : neighborhoodDirectionArr) {
            if (neighborhoodDirection2.swigValue == i) {
                return neighborhoodDirection2;
            }
        }
        throw new IllegalArgumentException("No enum " + NeighborhoodDirection.class + " with value " + i);
    }

    NeighborhoodDirection() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    NeighborhoodDirection(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    NeighborhoodDirection(NeighborhoodDirection neighborhoodDirection) {
        int i = neighborhoodDirection.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
