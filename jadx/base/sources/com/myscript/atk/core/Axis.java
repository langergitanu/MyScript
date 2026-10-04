package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum Axis {
    X(0),
    Y;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static Axis swigToEnum(int i) {
        Axis[] axisArr = (Axis[]) Axis.class.getEnumConstants();
        if (i < axisArr.length && i >= 0) {
            Axis axis = axisArr[i];
            if (axis.swigValue == i) {
                return axis;
            }
        }
        for (Axis axis2 : axisArr) {
            if (axis2.swigValue == i) {
                return axis2;
            }
        }
        throw new IllegalArgumentException("No enum " + Axis.class + " with value " + i);
    }

    Axis() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    Axis(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    Axis(Axis axis) {
        int i = axis.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
